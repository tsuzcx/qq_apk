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
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.an.t;
import com.tencent.mm.ao.af;
import com.tencent.mm.ay.i;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cg;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.a;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI.a;
import com.tencent.mm.vfs.u;
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
    bh.beI();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.w.ld(paramContext);
      Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: sd card is not available");
      AppMethodBeat.o(34909);
      return;
    }
    a(ke(af.bjv().vK(4)), paramContext, new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        paramAnonymousInt = 1;
        AppMethodBeat.i(34900);
        Object localObject1 = paramAnonymousMenuItem.getTitle();
        if (this.lrk.field_msgId > 0L) {}
        for (paramAnonymousMenuItem = com.tencent.mm.ay.q.bmh().D(this.lrk.field_talker, this.lrk.field_msgId);; paramAnonymousMenuItem = null)
        {
          if (((paramAnonymousMenuItem == null) || (paramAnonymousMenuItem.localId <= 0L)) && (this.lrk.field_msgSvrId > 0L)) {
            paramAnonymousMenuItem = com.tencent.mm.ay.q.bmh().C(this.lrk.field_talker, this.lrk.field_msgSvrId);
          }
          for (;;)
          {
            if (paramAnonymousMenuItem == null)
            {
              Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: try get imgInfo fail");
              AppMethodBeat.o(34900);
              return;
            }
            if ((paramAnonymousMenuItem.offset >= paramAnonymousMenuItem.lAW) && (paramAnonymousMenuItem.lAW != 0))
            {
              if (this.lrk.field_isSend == 1) {
                if (paramAnonymousMenuItem.blK()) {
                  paramAnonymousInt = 1;
                }
              }
              for (;;)
              {
                localObject2 = z.bcZ();
                paramAnonymousMenuItem = com.tencent.mm.ay.q.bmh().r(com.tencent.mm.ay.h.c(paramAnonymousMenuItem), "", "");
                if (!Util.isNullOrNil(paramAnonymousMenuItem))
                {
                  Log.i("MicroMsg.LongClickBrandServiceHelper", "connector click[img]: to[%s] fileName[%s]", new Object[] { localObject1, paramAnonymousMenuItem });
                  o.e locale = o.a(o.d.lUk).wb(4);
                  locale.fLi = ((String)localObject2);
                  locale.toUser = ((String)localObject1);
                  locale.lPO = paramAnonymousMenuItem;
                  locale.lNK = paramAnonymousInt;
                  locale.lUr = null;
                  locale.fJu = 0;
                  locale.lNS = "";
                  locale.thumbPath = "";
                  locale.lUu = true;
                  locale.lUt = R.g.chat_img_template;
                  locale.lUq = 11;
                  locale.bnl().aEv();
                  cg.bfp().e(cg.lvK, null);
                }
                com.tencent.mm.plugin.report.service.h.IzE.a(10424, new Object[] { Integer.valueOf(3), Integer.valueOf(4), localObject1 });
                com.tencent.mm.ui.base.h.cO(paramContext, paramContext.getString(R.l.app_saved));
                AppMethodBeat.o(34900);
                return;
                paramAnonymousInt = 0;
                continue;
                if (!paramAnonymousMenuItem.blK()) {
                  paramAnonymousInt = 0;
                } else if (!u.agG(com.tencent.mm.ay.h.a(paramAnonymousMenuItem).lNH)) {
                  paramAnonymousInt = 0;
                } else {
                  paramAnonymousInt = 1;
                }
              }
            }
            Log.i("MicroMsg.LongClickBrandServiceHelper", "[ImageGalleryUI] enter");
            paramAnonymousMenuItem = new Intent(paramContext, ImageGalleryUI.class);
            paramAnonymousMenuItem.putExtra("img_gallery_msg_id", this.lrk.field_msgId);
            paramAnonymousMenuItem.putExtra("img_gallery_msg_svr_id", this.lrk.field_msgSvrId);
            paramAnonymousMenuItem.putExtra("img_gallery_talker", this.lrk.field_talker);
            paramAnonymousMenuItem.putExtra("img_gallery_chatroom_name", this.lrk.field_talker);
            paramAnonymousMenuItem.putExtra("img_gallery_is_restransmit_after_download", true);
            paramAnonymousMenuItem.putExtra("img_gallery_directly_send_name", (String)localObject1);
            paramAnonymousMenuItem.putExtra("start_chatting_ui", false);
            localObject1 = this.lrk.field_talker;
            Object localObject2 = new Bundle();
            if (paramBoolean) {
              paramAnonymousInt = 2;
            }
            for (;;)
            {
              ((Bundle)localObject2).putInt("stat_scene", paramAnonymousInt);
              ((Bundle)localObject2).putString("stat_msg_id", "msg_" + Long.toString(this.lrk.field_msgSvrId));
              ((Bundle)localObject2).putString("stat_chat_talker_username", (String)localObject1);
              ((Bundle)localObject2).putString("stat_send_msg_user", paramString);
              paramAnonymousMenuItem.putExtra("_stat_obj", (Bundle)localObject2);
              localObject1 = paramContext;
              paramAnonymousMenuItem = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousMenuItem);
              com.tencent.mm.hellhoundlib.a.a.b(localObject1, paramAnonymousMenuItem.aFh(), "com/tencent/mm/ui/chatting/SendToBrandServiceHelper$3", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Context)localObject1).startActivity((Intent)paramAnonymousMenuItem.sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/ui/chatting/SendToBrandServiceHelper$3", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(34900);
              return;
              if (ab.Qm((String)localObject1)) {
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
      a(localList, paramContext, new q.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(34905);
          String str2 = paramAnonymousMenuItem.getTitle();
          Object localObject2 = this.lrk;
          k.b localb = k.b.OQ(Util.processXml(paramString));
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
              com.tencent.mm.ui.base.h.cO(paramContext, paramContext.getString(R.l.app_saved));
              AppMethodBeat.o(34905);
              return;
              paramAnonymousMenuItem = null;
              Object localObject1 = paramAnonymousMenuItem;
              if (((et)localObject2).field_imgPath != null)
              {
                localObject1 = paramAnonymousMenuItem;
                if (!((et)localObject2).field_imgPath.equals("")) {
                  localObject1 = com.tencent.mm.ay.q.bmh().T(((et)localObject2).field_imgPath, true);
                }
              }
              try
              {
                localObject1 = u.aY((String)localObject1, 0, -1);
                localObject2 = new com.tencent.mm.pluginsdk.model.app.c();
                paramAnonymousMenuItem = (MenuItem)localObject2;
                if (!Util.isNullOrNil(localb.fvr))
                {
                  long l = Util.getLong(localb.fvr, -1L);
                  if (l == -1L) {
                    break label416;
                  }
                  ao.ctZ().get(l, (IAutoDBItem)localObject2);
                  paramAnonymousMenuItem = (MenuItem)localObject2;
                  if (((com.tencent.mm.pluginsdk.model.app.c)localObject2).systemRowid != l)
                  {
                    localObject2 = ao.ctZ().bpR(localb.fvr);
                    if (localObject2 != null)
                    {
                      paramAnonymousMenuItem = (MenuItem)localObject2;
                      if (((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_mediaSvrId.equals(localb.fvr)) {}
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
                      bh.beI();
                      localObject2 = com.tencent.mm.pluginsdk.model.app.m.aw(com.tencent.mm.model.c.bce(), localb.title, localb.llY);
                      u.on(paramAnonymousMenuItem.field_fileFullPath, (String)localObject2);
                    }
                  }
                }
                paramAnonymousMenuItem = k.b.a(localb);
                paramAnonymousMenuItem.lma = 3;
                com.tencent.mm.pluginsdk.model.app.m.a(paramAnonymousMenuItem, localb.appId, localb.appName, str2, (String)localObject2, (byte[])localObject1, null);
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  Log.e("MicroMsg.LongClickBrandServiceHelper", "send appmsg to %s, error:%s", new Object[] { str2, localException.getLocalizedMessage() });
                  MenuItem localMenuItem = paramAnonymousMenuItem;
                  continue;
                  label416:
                  localObject2 = ao.ctZ().bpR(localb.fvr);
                  if (localObject2 != null)
                  {
                    paramAnonymousMenuItem = (MenuItem)localObject2;
                    if (((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_mediaSvrId.equals(localb.fvr)) {}
                  }
                  else
                  {
                    paramAnonymousMenuItem = null;
                  }
                }
              }
            }
            com.tencent.mm.plugin.report.service.h.IzE.a(10424, new Object[] { Integer.valueOf(49), Integer.valueOf(256), str2 });
            continue;
            com.tencent.mm.plugin.report.service.h.IzE.a(10424, new Object[] { Integer.valueOf(49), Integer.valueOf(128), str2 });
            continue;
            com.tencent.mm.plugin.report.service.h.IzE.a(10424, new Object[] { Integer.valueOf(49), Integer.valueOf(512), str2 });
          }
        }
      });
      AppMethodBeat.o(34917);
      return;
      localList = ke(com.tencent.mm.ao.g.bje());
      continue;
      localList = ke(com.tencent.mm.ao.g.bjc());
      continue;
      localList = ke(com.tencent.mm.ao.g.bjg());
    }
  }
  
  private static void a(List<String> paramList, Context paramContext, q.g paramg)
  {
    AppMethodBeat.i(34919);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      Log.w("MicroMsg.LongClickBrandServiceHelper", "tryShowConnectorDialog: careList is null or empty");
      AppMethodBeat.o(34919);
      return;
    }
    com.tencent.mm.ui.tools.m localm = new com.tencent.mm.ui.tools.m(paramContext);
    localm.ODW = new an.11();
    localm.ODX = new an.2(paramContext);
    localm.ODT = new an.3(paramList);
    localm.ODU = paramg;
    localm.hYu();
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
    bh.beI();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.w.ld(paramContext);
      Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: sd card not available");
      AppMethodBeat.o(34908);
      return;
    }
    a(ke(af.bjv().vK(2)), paramContext, new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(34899);
        paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
        if (Util.isNullOrNil(this.lrk.field_imgPath))
        {
          Log.e("MicroMsg.LongClickBrandServiceHelper", "Transfer fileName erro: fileName null");
          AppMethodBeat.o(34899);
          return;
        }
        Object localObject = s.YL(this.lrk.field_imgPath);
        String str = this.lrk.field_imgPath;
        if (localObject == null) {}
        for (paramAnonymousInt = 0;; paramAnonymousInt = ((r)localObject).mkW)
        {
          localObject = s.p(paramAnonymousMenuItem, str, paramAnonymousInt);
          Log.i("MicroMsg.LongClickBrandServiceHelper", "connector click[voice]: to[%s] filePath[%s]", new Object[] { paramAnonymousMenuItem, localObject });
          localObject = new com.tencent.mm.modelvoice.f((String)localObject, 1);
          bh.aGY().a((com.tencent.mm.an.q)localObject, 0);
          com.tencent.mm.plugin.report.service.h.IzE.a(10424, new Object[] { Integer.valueOf(34), Integer.valueOf(2), paramAnonymousMenuItem });
          com.tencent.mm.ui.base.h.cO(paramContext, paramContext.getString(R.l.app_saved));
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
    bh.beI();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.w.ld(paramContext);
      Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: sd card is not available");
      AppMethodBeat.o(34910);
      return;
    }
    a(ke(af.bjv().vK(8)), paramContext, new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(34901);
        paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
        com.tencent.mm.modelvideo.w localw = y.Yk(this.lrk.field_imgPath);
        Log.i("MicroMsg.LongClickBrandServiceHelper", "connector click[video]: to[%s] imgPath[%s]", new Object[] { paramAnonymousMenuItem, this.lrk.field_imgPath });
        final MsgRetransmitUI.a locala = new MsgRetransmitUI.a();
        Object localObject = paramContext;
        paramContext.getResources().getString(R.l.app_tip);
        localObject = com.tencent.mm.ui.base.h.a((Context)localObject, paramContext.getResources().getString(R.l.app_sending), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            locala.XWZ = true;
          }
        });
        locala.context = paramContext;
        locala.fileName = this.lrk.field_imgPath;
        locala.tipDialog = ((Dialog)localObject);
        locala.userName = paramAnonymousMenuItem;
        locala.XWq = localw.mhU;
        locala.lvw = localw.lvw;
        locala.execute(new Object[0]);
        cg.bfp().e(cg.lvL, null);
        com.tencent.mm.ui.base.h.cO(paramContext, paramContext.getString(R.l.app_saved));
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
    bh.beI();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.w.ld(paramContext);
      Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: sd card is not available");
      AppMethodBeat.o(34913);
      return;
    }
    a(ke(af.bjv().vK(64)), paramContext, new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(34904);
        String str = paramAnonymousMenuItem.getTitle();
        paramAnonymousMenuItem = be.bwQ(this.lrk.field_content).md5;
        if ((paramAnonymousMenuItem == null) || (paramAnonymousMenuItem.endsWith("-1"))) {
          paramAnonymousMenuItem = this.lrk.field_imgPath;
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
          if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().x(paramContext, str, paramAnonymousMenuItem))
          {
            com.tencent.mm.plugin.report.service.h.IzE.a(10424, new Object[] { Integer.valueOf(47), Integer.valueOf(64), str });
            com.tencent.mm.ui.base.h.cO(paramContext, "");
          }
          com.tencent.mm.plugin.report.service.h.IzE.a(10424, new Object[] { Integer.valueOf(47), Integer.valueOf(64), str });
          com.tencent.mm.ui.base.h.cO(paramContext, paramContext.getString(R.l.app_saved));
          AppMethodBeat.o(34904);
          return;
        }
      }
    });
    AppMethodBeat.o(34913);
  }
  
  private static List<String> ke(List<String> paramList)
  {
    AppMethodBeat.i(34918);
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (!com.tencent.mm.ao.g.UA(str)) {
        localLinkedList.add(str);
      }
    }
    Log.d("MicroMsg.LongClickBrandServiceHelper", "get selected accept list, size %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    AppMethodBeat.o(34918);
    return localLinkedList;
  }
  
  public static void o(String paramString, final Context paramContext)
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
    a(ke(af.bjv().vK(1)), paramContext, new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(34896);
        paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
        Log.i("MicroMsg.LongClickBrandServiceHelper", "connector click[text]: to[%s] text[%s]", new Object[] { paramAnonymousMenuItem, this.val$content });
        o.e locale = o.WI(paramAnonymousMenuItem);
        locale.toUser = paramAnonymousMenuItem;
        locale.content = this.val$content;
        locale = locale.wD(ab.QZ(paramAnonymousMenuItem));
        locale.cUP = 0;
        locale.lUq = 4;
        locale.bnl().aEv();
        com.tencent.mm.plugin.report.service.h.IzE.a(10424, new Object[] { Integer.valueOf(1), Integer.valueOf(1), paramAnonymousMenuItem });
        com.tencent.mm.ui.base.h.cO(paramContext, paramContext.getString(R.l.app_saved));
        AppMethodBeat.o(34896);
      }
    });
    AppMethodBeat.o(34907);
  }
  
  public static void p(String paramString, final Context paramContext)
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
    a(ke(af.bjv().vK(16)), paramContext, new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(34902);
        paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
        Log.i("MicroMsg.LongClickBrandServiceHelper", "connector click[location]: to[%s] content[%s]", new Object[] { paramAnonymousMenuItem, this.WEk });
        o.e locale = o.WI(paramAnonymousMenuItem);
        locale.toUser = paramAnonymousMenuItem;
        locale.content = this.WEk;
        locale = locale.wD(48);
        locale.cUP = 0;
        locale.lUq = 4;
        locale.bnl().aEv();
        com.tencent.mm.plugin.report.service.h.IzE.a(10424, new Object[] { Integer.valueOf(48), Integer.valueOf(16), paramAnonymousMenuItem });
        com.tencent.mm.ui.base.h.cO(paramContext, paramContext.getString(R.l.app_saved));
        AppMethodBeat.o(34902);
      }
    });
    AppMethodBeat.o(34911);
  }
  
  public static void q(String paramString, final Context paramContext)
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
    a(ke(af.bjv().vK(32)), paramContext, new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        int i = 66;
        AppMethodBeat.i(34903);
        paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
        Log.i("MicroMsg.LongClickBrandServiceHelper", "connector click[location]: to[%s] content[%s]", new Object[] { paramAnonymousMenuItem, this.WEl });
        ca.a locala = ca.a.bwZ(this.WEl);
        Object localObject = o.WI(paramAnonymousMenuItem);
        ((o.e)localObject).toUser = paramAnonymousMenuItem;
        ((o.e)localObject).content = this.WEl;
        if (as.bvK(locala.fcC))
        {
          paramAnonymousInt = 66;
          localObject = ((o.e)localObject).wD(paramAnonymousInt);
          ((o.e)localObject).cUP = 0;
          ((o.e)localObject).lUq = 4;
          ((o.e)localObject).bnl().aEv();
          localObject = com.tencent.mm.plugin.report.service.h.IzE;
          if (!as.bvK(locala.fcC)) {
            break label202;
          }
        }
        label202:
        for (paramAnonymousInt = i;; paramAnonymousInt = 42)
        {
          ((com.tencent.mm.plugin.report.service.h)localObject).a(10424, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(32), paramAnonymousMenuItem });
          com.tencent.mm.ui.base.h.cO(paramContext, paramContext.getString(R.l.app_saved));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.an
 * JD-Core Version:    0.7.0.1
 */