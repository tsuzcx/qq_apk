package com.tencent.mm.ui.chatting;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ak.t;
import com.tencent.mm.al.ag;
import com.tencent.mm.av.i;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.a;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.transmit.MsgRetransmitUI.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class an
{
  public static void a(ca paramca, final Context paramContext, final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(34909);
    if (paramContext == null)
    {
      Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: context is null");
      AppMethodBeat.o(34909);
      return;
    }
    if (paramca == null)
    {
      Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: msg is null");
      AppMethodBeat.o(34909);
      return;
    }
    bg.aVF();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.u.kf(paramContext);
      Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: sd card is not available");
      AppMethodBeat.o(34909);
      return;
    }
    a(jm(ag.bah().sN(4)), paramContext, new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        paramAnonymousInt = 1;
        AppMethodBeat.i(34900);
        Object localObject1 = paramAnonymousMenuItem.getTitle();
        if (this.iBF.field_msgId > 0L) {}
        for (paramAnonymousMenuItem = com.tencent.mm.av.q.bcR().H(this.iBF.field_talker, this.iBF.field_msgId);; paramAnonymousMenuItem = null)
        {
          if (((paramAnonymousMenuItem == null) || (paramAnonymousMenuItem.localId <= 0L)) && (this.iBF.field_msgSvrId > 0L)) {
            paramAnonymousMenuItem = com.tencent.mm.av.q.bcR().G(this.iBF.field_talker, this.iBF.field_msgSvrId);
          }
          for (;;)
          {
            if (paramAnonymousMenuItem == null)
            {
              Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: try get imgInfo fail");
              AppMethodBeat.o(34900);
              return;
            }
            if ((paramAnonymousMenuItem.offset >= paramAnonymousMenuItem.iKP) && (paramAnonymousMenuItem.iKP != 0))
            {
              if (this.iBF.field_isSend == 1) {
                if (paramAnonymousMenuItem.bcv()) {
                  paramAnonymousInt = 1;
                }
              }
              for (;;)
              {
                localObject2 = z.aTY();
                paramAnonymousMenuItem = com.tencent.mm.av.q.bcR().o(com.tencent.mm.av.h.c(paramAnonymousMenuItem), "", "");
                if (!Util.isNullOrNil(paramAnonymousMenuItem))
                {
                  Log.i("MicroMsg.LongClickBrandServiceHelper", "connector click[img]: to[%s] fileName[%s]", new Object[] { localObject1, paramAnonymousMenuItem });
                  o.e locale = o.a(o.d.jdL).tc(4);
                  locale.dRL = ((String)localObject2);
                  locale.toUser = ((String)localObject1);
                  locale.iZt = paramAnonymousMenuItem;
                  locale.iXp = paramAnonymousInt;
                  locale.jdS = null;
                  locale.dQd = 0;
                  locale.iXy = "";
                  locale.thumbPath = "";
                  locale.jdV = true;
                  locale.jdU = 2131231628;
                  locale.jdR = 11;
                  locale.bdQ().execute();
                  cf.aWl().f(cf.iFI, null);
                }
                com.tencent.mm.plugin.report.service.h.CyF.a(10424, new Object[] { Integer.valueOf(3), Integer.valueOf(4), localObject1 });
                com.tencent.mm.ui.base.h.cD(paramContext, paramContext.getString(2131755971));
                AppMethodBeat.o(34900);
                return;
                paramAnonymousInt = 0;
                continue;
                if (!paramAnonymousMenuItem.bcv()) {
                  paramAnonymousInt = 0;
                } else if (!com.tencent.mm.vfs.s.YS(com.tencent.mm.av.h.a(paramAnonymousMenuItem).iXm)) {
                  paramAnonymousInt = 0;
                } else {
                  paramAnonymousInt = 1;
                }
              }
            }
            Log.i("MicroMsg.LongClickBrandServiceHelper", "[ImageGalleryUI] enter");
            paramAnonymousMenuItem = new Intent(paramContext, ImageGalleryUI.class);
            paramAnonymousMenuItem.putExtra("img_gallery_msg_id", this.iBF.field_msgId);
            paramAnonymousMenuItem.putExtra("img_gallery_msg_svr_id", this.iBF.field_msgSvrId);
            paramAnonymousMenuItem.putExtra("img_gallery_talker", this.iBF.field_talker);
            paramAnonymousMenuItem.putExtra("img_gallery_chatroom_name", this.iBF.field_talker);
            paramAnonymousMenuItem.putExtra("img_gallery_is_restransmit_after_download", true);
            paramAnonymousMenuItem.putExtra("img_gallery_directly_send_name", (String)localObject1);
            paramAnonymousMenuItem.putExtra("start_chatting_ui", false);
            localObject1 = this.iBF.field_talker;
            Object localObject2 = new Bundle();
            if (paramBoolean) {
              paramAnonymousInt = 2;
            }
            for (;;)
            {
              ((Bundle)localObject2).putInt("stat_scene", paramAnonymousInt);
              ((Bundle)localObject2).putString("stat_msg_id", "msg_" + Long.toString(this.iBF.field_msgSvrId));
              ((Bundle)localObject2).putString("stat_chat_talker_username", (String)localObject1);
              ((Bundle)localObject2).putString("stat_send_msg_user", paramString);
              paramAnonymousMenuItem.putExtra("_stat_obj", (Bundle)localObject2);
              localObject1 = paramContext;
              paramAnonymousMenuItem = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousMenuItem);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramAnonymousMenuItem.axQ(), "com/tencent/mm/ui/chatting/SendToBrandServiceHelper$3", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Context)localObject1).startActivity((Intent)paramAnonymousMenuItem.pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/SendToBrandServiceHelper$3", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(34900);
              return;
              if (ab.IT((String)localObject1)) {
                paramAnonymousInt = 7;
              }
            }
          }
        }
      }
    });
    AppMethodBeat.o(34909);
  }
  
  public static void a(ca paramca, String paramString, Context paramContext)
  {
    AppMethodBeat.i(34914);
    a(paramca, paramString, paramContext, 512);
    AppMethodBeat.o(34914);
  }
  
  private static void a(ca paramca, final String paramString, final Context paramContext, final int paramInt)
  {
    AppMethodBeat.i(34917);
    if (paramContext == null)
    {
      Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptMusicConnector: context is null");
      AppMethodBeat.o(34917);
      return;
    }
    if (paramca == null)
    {
      Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptMusicConnector: msg is null");
      AppMethodBeat.o(34917);
      return;
    }
    List localList = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      a(localList, paramContext, new o.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(34905);
          String str2 = paramAnonymousMenuItem.getTitle();
          Object localObject2 = this.iBF;
          k.b localb = k.b.HD(Util.processXml(paramString));
          if (localb == null)
          {
            Log.w("MicroMsg.LongClickBrandServiceHelper", "send: parse app msg content return null");
            switch (paramInt)
            {
            }
          }
          for (;;)
          {
            for (;;)
            {
              com.tencent.mm.ui.base.h.cD(paramContext, paramContext.getString(2131755971));
              AppMethodBeat.o(34905);
              return;
              paramAnonymousMenuItem = null;
              Object localObject1 = paramAnonymousMenuItem;
              if (((eo)localObject2).field_imgPath != null)
              {
                localObject1 = paramAnonymousMenuItem;
                if (!((eo)localObject2).field_imgPath.equals("")) {
                  localObject1 = com.tencent.mm.av.q.bcR().R(((eo)localObject2).field_imgPath, true);
                }
              }
              try
              {
                localObject1 = com.tencent.mm.vfs.s.aW((String)localObject1, 0, -1);
                localObject2 = new com.tencent.mm.pluginsdk.model.app.c();
                paramAnonymousMenuItem = (MenuItem)localObject2;
                if (!Util.isNullOrNil(localb.dCK))
                {
                  long l = Util.getLong(localb.dCK, -1L);
                  if (l == -1L) {
                    break label415;
                  }
                  ao.cgO().get(l, (IAutoDBItem)localObject2);
                  paramAnonymousMenuItem = (MenuItem)localObject2;
                  if (((com.tencent.mm.pluginsdk.model.app.c)localObject2).systemRowid != l)
                  {
                    localObject2 = ao.cgO().bdx(localb.dCK);
                    if (localObject2 != null)
                    {
                      paramAnonymousMenuItem = (MenuItem)localObject2;
                      if (((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_mediaSvrId.equals(localb.dCK)) {}
                    }
                    else
                    {
                      paramAnonymousMenuItem = null;
                    }
                  }
                }
                String str1 = "";
                localObject2 = str1;
                if (paramAnonymousMenuItem != null)
                {
                  localObject2 = str1;
                  if (paramAnonymousMenuItem.field_fileFullPath != null)
                  {
                    localObject2 = str1;
                    if (!paramAnonymousMenuItem.field_fileFullPath.equals(""))
                    {
                      bg.aVF();
                      localObject2 = m.aB(com.tencent.mm.model.c.aTg(), localb.title, localb.iwJ);
                      com.tencent.mm.vfs.s.nw(paramAnonymousMenuItem.field_fileFullPath, (String)localObject2);
                    }
                  }
                }
                paramAnonymousMenuItem = k.b.a(localb);
                paramAnonymousMenuItem.iwL = 3;
                m.a(paramAnonymousMenuItem, localb.appId, localb.appName, str2, (String)localObject2, (byte[])localObject1, null);
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  Log.e("MicroMsg.LongClickBrandServiceHelper", "send appmsg to %s, error:%s", new Object[] { str2, localException.getLocalizedMessage() });
                  MenuItem localMenuItem = paramAnonymousMenuItem;
                  continue;
                  label415:
                  localObject2 = ao.cgO().bdx(localb.dCK);
                  if (localObject2 != null)
                  {
                    paramAnonymousMenuItem = (MenuItem)localObject2;
                    if (((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_mediaSvrId.equals(localb.dCK)) {}
                  }
                  else
                  {
                    paramAnonymousMenuItem = null;
                  }
                }
              }
            }
            com.tencent.mm.plugin.report.service.h.CyF.a(10424, new Object[] { Integer.valueOf(49), Integer.valueOf(256), str2 });
            continue;
            com.tencent.mm.plugin.report.service.h.CyF.a(10424, new Object[] { Integer.valueOf(49), Integer.valueOf(128), str2 });
            continue;
            com.tencent.mm.plugin.report.service.h.CyF.a(10424, new Object[] { Integer.valueOf(49), Integer.valueOf(512), str2 });
          }
        }
      });
      AppMethodBeat.o(34917);
      return;
      localList = jm(com.tencent.mm.al.g.aZO());
      continue;
      localList = jm(com.tencent.mm.al.g.aZM());
      continue;
      localList = jm(com.tencent.mm.al.g.aZQ());
    }
  }
  
  private static void a(List<String> paramList, Context paramContext, o.g paramg)
  {
    AppMethodBeat.i(34919);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      Log.w("MicroMsg.LongClickBrandServiceHelper", "tryShowConnectorDialog: careList is null or empty");
      AppMethodBeat.o(34919);
      return;
    }
    l locall = new l(paramContext);
    locall.HMa = new an.11();
    locall.HMb = new an.2(paramContext);
    locall.HLX = new an.3(paramList);
    locall.HLY = paramg;
    locall.gXI();
    AppMethodBeat.o(34919);
  }
  
  public static void b(ca paramca, final Context paramContext)
  {
    AppMethodBeat.i(34908);
    if (paramContext == null)
    {
      Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: context is null");
      AppMethodBeat.o(34908);
      return;
    }
    if (paramca == null)
    {
      Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: msg is null");
      AppMethodBeat.o(34908);
      return;
    }
    bg.aVF();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.u.kf(paramContext);
      Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: sd card not available");
      AppMethodBeat.o(34908);
      return;
    }
    a(jm(ag.bah().sN(2)), paramContext, new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(34899);
        paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
        if (Util.isNullOrNil(this.iBF.field_imgPath))
        {
          Log.e("MicroMsg.LongClickBrandServiceHelper", "Transfer fileName erro: fileName null");
          AppMethodBeat.o(34899);
          return;
        }
        Object localObject = com.tencent.mm.modelvoice.s.Ro(this.iBF.field_imgPath);
        String str = this.iBF.field_imgPath;
        if (localObject == null) {}
        for (paramAnonymousInt = 0;; paramAnonymousInt = ((r)localObject).jvt)
        {
          localObject = com.tencent.mm.modelvoice.s.n(paramAnonymousMenuItem, str, paramAnonymousInt);
          Log.i("MicroMsg.LongClickBrandServiceHelper", "connector click[voice]: to[%s] filePath[%s]", new Object[] { paramAnonymousMenuItem, localObject });
          localObject = new com.tencent.mm.modelvoice.f((String)localObject, 1);
          bg.azz().a((com.tencent.mm.ak.q)localObject, 0);
          com.tencent.mm.plugin.report.service.h.CyF.a(10424, new Object[] { Integer.valueOf(34), Integer.valueOf(2), paramAnonymousMenuItem });
          com.tencent.mm.ui.base.h.cD(paramContext, paramContext.getString(2131755971));
          AppMethodBeat.o(34899);
          return;
        }
      }
    });
    AppMethodBeat.o(34908);
  }
  
  public static void b(ca paramca, String paramString, Context paramContext)
  {
    AppMethodBeat.i(34915);
    a(paramca, paramString, paramContext, 256);
    AppMethodBeat.o(34915);
  }
  
  public static void c(ca paramca, final Context paramContext)
  {
    AppMethodBeat.i(34910);
    if (paramContext == null)
    {
      Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: context is null");
      AppMethodBeat.o(34910);
      return;
    }
    if (paramca == null)
    {
      Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: msg is null");
      AppMethodBeat.o(34910);
      return;
    }
    bg.aVF();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.u.kf(paramContext);
      Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: sd card is not available");
      AppMethodBeat.o(34910);
      return;
    }
    a(jm(ag.bah().sN(8)), paramContext, new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(34901);
        paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
        com.tencent.mm.modelvideo.s locals = com.tencent.mm.modelvideo.u.QN(this.iBF.field_imgPath);
        Log.i("MicroMsg.LongClickBrandServiceHelper", "connector click[video]: to[%s] imgPath[%s]", new Object[] { paramAnonymousMenuItem, this.iBF.field_imgPath });
        final MsgRetransmitUI.a locala = new MsgRetransmitUI.a();
        Object localObject = paramContext;
        paramContext.getResources().getString(2131755998);
        localObject = com.tencent.mm.ui.base.h.a((Context)localObject, paramContext.getResources().getString(2131755978), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            locala.QyQ = true;
          }
        });
        locala.context = paramContext;
        locala.fileName = this.iBF.field_imgPath;
        locala.tipDialog = ((Dialog)localObject);
        locala.userName = paramAnonymousMenuItem;
        locala.Qyk = locals.jsr;
        locala.iFw = locals.iFw;
        locala.execute(new Object[0]);
        cf.aWl().f(cf.iFJ, null);
        com.tencent.mm.ui.base.h.cD(paramContext, paramContext.getString(2131755971));
        AppMethodBeat.o(34901);
      }
    });
    AppMethodBeat.o(34910);
  }
  
  public static void c(ca paramca, String paramString, Context paramContext)
  {
    AppMethodBeat.i(34916);
    a(paramca, paramString, paramContext, 128);
    AppMethodBeat.o(34916);
  }
  
  public static void d(ca paramca, final Context paramContext)
  {
    AppMethodBeat.i(34913);
    if (paramContext == null)
    {
      Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: context is null");
      AppMethodBeat.o(34913);
      return;
    }
    if (paramca == null)
    {
      Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: msg is null");
      AppMethodBeat.o(34913);
      return;
    }
    bg.aVF();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.u.kf(paramContext);
      Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: sd card is not available");
      AppMethodBeat.o(34913);
      return;
    }
    a(jm(ag.bah().sN(64)), paramContext, new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(34904);
        String str = paramAnonymousMenuItem.getTitle();
        paramAnonymousMenuItem = be.bkr(this.iBF.field_content).md5;
        if ((paramAnonymousMenuItem == null) || (paramAnonymousMenuItem.endsWith("-1"))) {
          paramAnonymousMenuItem = this.iBF.field_imgPath;
        }
        for (;;)
        {
          if (paramAnonymousMenuItem == null)
          {
            Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: filePath is null");
            AppMethodBeat.o(34904);
            return;
          }
          Log.i("MicroMsg.LongClickBrandServiceHelper", "connector click[emoji]: to[%s] filePath[%s]", new Object[] { str, paramAnonymousMenuItem });
          if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().u(paramContext, str, paramAnonymousMenuItem))
          {
            com.tencent.mm.plugin.report.service.h.CyF.a(10424, new Object[] { Integer.valueOf(47), Integer.valueOf(64), str });
            com.tencent.mm.ui.base.h.cD(paramContext, "");
          }
          com.tencent.mm.plugin.report.service.h.CyF.a(10424, new Object[] { Integer.valueOf(47), Integer.valueOf(64), str });
          com.tencent.mm.ui.base.h.cD(paramContext, paramContext.getString(2131755971));
          AppMethodBeat.o(34904);
          return;
        }
      }
    });
    AppMethodBeat.o(34913);
  }
  
  private static List<String> jm(List<String> paramList)
  {
    AppMethodBeat.i(34918);
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (!com.tencent.mm.al.g.Ne(str)) {
        localLinkedList.add(str);
      }
    }
    Log.d("MicroMsg.LongClickBrandServiceHelper", "get selected accept list, size %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    AppMethodBeat.o(34918);
    return localLinkedList;
  }
  
  public static void m(String paramString, final Context paramContext)
  {
    AppMethodBeat.i(34907);
    if (paramContext == null)
    {
      Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptTextConnector: context is null");
      AppMethodBeat.o(34907);
      return;
    }
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptTextConnector: content is null");
      AppMethodBeat.o(34907);
      return;
    }
    a(jm(ag.bah().sN(1)), paramContext, new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(34896);
        paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
        Log.i("MicroMsg.LongClickBrandServiceHelper", "connector click[text]: to[%s] text[%s]", new Object[] { paramAnonymousMenuItem, this.val$content });
        o.e locale = o.Pl(paramAnonymousMenuItem);
        locale.toUser = paramAnonymousMenuItem;
        locale.content = this.val$content;
        locale = locale.tD(ab.JG(paramAnonymousMenuItem));
        locale.cSx = 0;
        locale.jdR = 4;
        locale.bdQ().execute();
        com.tencent.mm.plugin.report.service.h.CyF.a(10424, new Object[] { Integer.valueOf(1), Integer.valueOf(1), paramAnonymousMenuItem });
        com.tencent.mm.ui.base.h.cD(paramContext, paramContext.getString(2131755971));
        AppMethodBeat.o(34896);
      }
    });
    AppMethodBeat.o(34907);
  }
  
  public static void n(String paramString, final Context paramContext)
  {
    AppMethodBeat.i(34911);
    if (paramContext == null)
    {
      Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptLocationConnector: context is null");
      AppMethodBeat.o(34911);
      return;
    }
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptLocationConnector: locationXML is null");
      AppMethodBeat.o(34911);
      return;
    }
    a(jm(ag.bah().sN(16)), paramContext, new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(34902);
        paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
        Log.i("MicroMsg.LongClickBrandServiceHelper", "connector click[location]: to[%s] content[%s]", new Object[] { paramAnonymousMenuItem, this.PkB });
        o.e locale = o.Pl(paramAnonymousMenuItem);
        locale.toUser = paramAnonymousMenuItem;
        locale.content = this.PkB;
        locale = locale.tD(48);
        locale.cSx = 0;
        locale.jdR = 4;
        locale.bdQ().execute();
        com.tencent.mm.plugin.report.service.h.CyF.a(10424, new Object[] { Integer.valueOf(48), Integer.valueOf(16), paramAnonymousMenuItem });
        com.tencent.mm.ui.base.h.cD(paramContext, paramContext.getString(2131755971));
        AppMethodBeat.o(34902);
      }
    });
    AppMethodBeat.o(34911);
  }
  
  public static void o(String paramString, final Context paramContext)
  {
    AppMethodBeat.i(34912);
    if (paramContext == null)
    {
      Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptPersonalCardConnector: context is null");
      AppMethodBeat.o(34912);
      return;
    }
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptPersonalCardConnector: locationXML is null");
      AppMethodBeat.o(34912);
      return;
    }
    a(jm(ag.bah().sN(32)), paramContext, new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        int i = 66;
        AppMethodBeat.i(34903);
        paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
        Log.i("MicroMsg.LongClickBrandServiceHelper", "connector click[location]: to[%s] content[%s]", new Object[] { paramAnonymousMenuItem, this.PkC });
        ca.a locala = ca.a.bkA(this.PkC);
        Object localObject = o.Pl(paramAnonymousMenuItem);
        ((o.e)localObject).toUser = paramAnonymousMenuItem;
        ((o.e)localObject).content = this.PkC;
        if (as.bjp(locala.dkU))
        {
          paramAnonymousInt = 66;
          localObject = ((o.e)localObject).tD(paramAnonymousInt);
          ((o.e)localObject).cSx = 0;
          ((o.e)localObject).jdR = 4;
          ((o.e)localObject).bdQ().execute();
          localObject = com.tencent.mm.plugin.report.service.h.CyF;
          if (!as.bjp(locala.dkU)) {
            break label201;
          }
        }
        label201:
        for (paramAnonymousInt = i;; paramAnonymousInt = 42)
        {
          ((com.tencent.mm.plugin.report.service.h)localObject).a(10424, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(32), paramAnonymousMenuItem });
          com.tencent.mm.ui.base.h.cD(paramContext, paramContext.getString(2131755971));
          AppMethodBeat.o(34903);
          return;
          paramAnonymousInt = 42;
          break;
        }
      }
    });
    AppMethodBeat.o(34912);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.an
 * JD-Core Version:    0.7.0.1
 */