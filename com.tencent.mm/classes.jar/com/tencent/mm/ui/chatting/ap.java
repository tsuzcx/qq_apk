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
import com.tencent.mm.am.p;
import com.tencent.mm.an.af;
import com.tencent.mm.an.g;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.ch;
import com.tencent.mm.modelimage.i;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelmulti.t;
import com.tencent.mm.modelmulti.t.b;
import com.tencent.mm.modelmulti.t.d;
import com.tencent.mm.modelmulti.t.e;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cc.a;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.transmit.MsgRetransmitUI.a;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ap
{
  public static void a(cc paramcc, final Context paramContext, final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(34909);
    if (paramContext == null)
    {
      Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: context is null");
      AppMethodBeat.o(34909);
      return;
    }
    if (paramcc == null)
    {
      Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: msg is null");
      AppMethodBeat.o(34909);
      return;
    }
    bh.bCz();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      aa.nh(paramContext);
      Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: sd card is not available");
      AppMethodBeat.o(34909);
      return;
    }
    a(nu(af.bHf().vP(4)), paramContext, new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        paramAnonymousInt = 1;
        AppMethodBeat.i(34900);
        Object localObject1 = paramAnonymousMenuItem.getTitle();
        if (ap.this.field_msgId > 0L) {}
        for (paramAnonymousMenuItem = com.tencent.mm.modelimage.r.bKa().H(ap.this.field_talker, ap.this.field_msgId);; paramAnonymousMenuItem = null)
        {
          if (((paramAnonymousMenuItem == null) || (paramAnonymousMenuItem.localId <= 0L)) && (ap.this.field_msgSvrId > 0L)) {
            paramAnonymousMenuItem = com.tencent.mm.modelimage.r.bKa().G(ap.this.field_talker, ap.this.field_msgSvrId);
          }
          for (;;)
          {
            if (paramAnonymousMenuItem == null)
            {
              Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: try get imgInfo fail");
              AppMethodBeat.o(34900);
              return;
            }
            if ((paramAnonymousMenuItem.offset >= paramAnonymousMenuItem.osy) && (paramAnonymousMenuItem.osy != 0))
            {
              if (ap.this.field_isSend == 1) {
                if (paramAnonymousMenuItem.bJE()) {
                  paramAnonymousInt = 1;
                }
              }
              for (;;)
              {
                localObject2 = com.tencent.mm.model.z.bAM();
                paramAnonymousMenuItem = com.tencent.mm.modelimage.r.bKa().v(i.c(paramAnonymousMenuItem), "", "");
                if (!Util.isNullOrNil(paramAnonymousMenuItem))
                {
                  Log.i("MicroMsg.LongClickBrandServiceHelper", "connector click[img]: to[%s] fileName[%s]", new Object[] { localObject1, paramAnonymousMenuItem });
                  t.e locale = t.a(t.d.oNd).wg(4);
                  locale.hQQ = ((String)localObject2);
                  locale.toUser = ((String)localObject1);
                  locale.oIx = paramAnonymousMenuItem;
                  locale.oGu = paramAnonymousInt;
                  locale.oNk = null;
                  locale.hOX = 0;
                  locale.oGC = "";
                  locale.thumbPath = "";
                  locale.oNn = true;
                  locale.oNm = R.g.chat_img_template;
                  locale.oNj = 11;
                  locale.bKW().aXz();
                  ch.bDg().f(ch.oni, null);
                }
                com.tencent.mm.plugin.report.service.h.OAn.b(10424, new Object[] { Integer.valueOf(3), Integer.valueOf(4), localObject1 });
                k.cZ(paramContext, paramContext.getString(R.l.app_saved));
                AppMethodBeat.o(34900);
                return;
                paramAnonymousInt = 0;
                continue;
                if (!paramAnonymousMenuItem.bJE()) {
                  paramAnonymousInt = 0;
                } else if (!y.ZC(i.a(paramAnonymousMenuItem).oGr)) {
                  paramAnonymousInt = 0;
                } else {
                  paramAnonymousInt = 1;
                }
              }
            }
            Log.i("MicroMsg.LongClickBrandServiceHelper", "[ImageGalleryUI] enter");
            paramAnonymousMenuItem = new Intent(paramContext, ImageGalleryUI.class);
            paramAnonymousMenuItem.putExtra("img_gallery_msg_id", ap.this.field_msgId);
            paramAnonymousMenuItem.putExtra("img_gallery_msg_svr_id", ap.this.field_msgSvrId);
            paramAnonymousMenuItem.putExtra("img_gallery_talker", ap.this.field_talker);
            paramAnonymousMenuItem.putExtra("img_gallery_chatroom_name", ap.this.field_talker);
            paramAnonymousMenuItem.putExtra("img_gallery_is_restransmit_after_download", true);
            paramAnonymousMenuItem.putExtra("img_gallery_directly_send_name", (String)localObject1);
            paramAnonymousMenuItem.putExtra("start_chatting_ui", false);
            localObject1 = ap.this.field_talker;
            Object localObject2 = new Bundle();
            if (paramBoolean) {
              paramAnonymousInt = 2;
            }
            for (;;)
            {
              ((Bundle)localObject2).putInt("stat_scene", paramAnonymousInt);
              ((Bundle)localObject2).putString("stat_msg_id", "msg_" + Long.toString(ap.this.field_msgSvrId));
              ((Bundle)localObject2).putString("stat_chat_talker_username", (String)localObject1);
              ((Bundle)localObject2).putString("stat_send_msg_user", paramString);
              paramAnonymousMenuItem.putExtra("_stat_obj", (Bundle)localObject2);
              localObject1 = paramContext;
              paramAnonymousMenuItem = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousMenuItem);
              com.tencent.mm.hellhoundlib.a.a.b(localObject1, paramAnonymousMenuItem.aYi(), "com/tencent/mm/ui/chatting/SendToBrandServiceHelper$3", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Context)localObject1).startActivity((Intent)paramAnonymousMenuItem.sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/ui/chatting/SendToBrandServiceHelper$3", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(34900);
              return;
              if (com.tencent.mm.model.ab.IS((String)localObject1)) {
                paramAnonymousInt = 7;
              }
            }
          }
        }
      }
    });
    AppMethodBeat.o(34909);
  }
  
  public static void a(cc paramcc, String paramString, Context paramContext)
  {
    AppMethodBeat.i(34914);
    a(paramcc, paramString, paramContext, 512);
    AppMethodBeat.o(34914);
  }
  
  private static void a(cc paramcc, final String paramString, final Context paramContext, final int paramInt)
  {
    AppMethodBeat.i(34917);
    if (paramContext == null)
    {
      Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptMusicConnector: context is null");
      AppMethodBeat.o(34917);
      return;
    }
    if (paramcc == null)
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
      a(localList, paramContext, new u.i()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(34905);
          String str2 = paramAnonymousMenuItem.getTitle();
          Object localObject2 = ap.this;
          k.b localb = k.b.Hf(Util.processXml(paramString));
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
              k.cZ(paramContext, paramContext.getString(R.l.app_saved));
              AppMethodBeat.o(34905);
              return;
              paramAnonymousMenuItem = null;
              Object localObject1 = paramAnonymousMenuItem;
              if (((fi)localObject2).field_imgPath != null)
              {
                localObject1 = paramAnonymousMenuItem;
                if (!((fi)localObject2).field_imgPath.equals("")) {
                  localObject1 = com.tencent.mm.modelimage.r.bKa().X(((fi)localObject2).field_imgPath, true);
                }
              }
              try
              {
                localObject1 = y.bi((String)localObject1, 0, -1);
                localObject2 = new com.tencent.mm.pluginsdk.model.app.c();
                paramAnonymousMenuItem = (MenuItem)localObject2;
                if (!Util.isNullOrNil(localb.hzM))
                {
                  long l = Util.getLong(localb.hzM, -1L);
                  if (l == -1L) {
                    break label417;
                  }
                  as.cWJ().get(l, (IAutoDBItem)localObject2);
                  paramAnonymousMenuItem = (MenuItem)localObject2;
                  if (((com.tencent.mm.pluginsdk.model.app.c)localObject2).systemRowid != l)
                  {
                    localObject2 = as.cWJ().bpI(localb.hzM);
                    if (localObject2 != null)
                    {
                      paramAnonymousMenuItem = (MenuItem)localObject2;
                      if (((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_mediaSvrId.equals(localb.hzM)) {}
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
                      bh.bCz();
                      localObject2 = n.aK(com.tencent.mm.model.c.bzT(), localb.title, localb.nRe);
                      y.O(paramAnonymousMenuItem.field_fileFullPath, (String)localObject2, false);
                    }
                  }
                }
                paramAnonymousMenuItem = k.b.a(localb);
                paramAnonymousMenuItem.nRg = 3;
                n.a(paramAnonymousMenuItem, localb.appId, localb.appName, str2, (String)localObject2, (byte[])localObject1, null);
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  Log.e("MicroMsg.LongClickBrandServiceHelper", "send appmsg to %s, error:%s", new Object[] { str2, localException.getLocalizedMessage() });
                  MenuItem localMenuItem = paramAnonymousMenuItem;
                  continue;
                  label417:
                  localObject2 = as.cWJ().bpI(localb.hzM);
                  if (localObject2 != null)
                  {
                    paramAnonymousMenuItem = (MenuItem)localObject2;
                    if (((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_mediaSvrId.equals(localb.hzM)) {}
                  }
                  else
                  {
                    paramAnonymousMenuItem = null;
                  }
                }
              }
            }
            com.tencent.mm.plugin.report.service.h.OAn.b(10424, new Object[] { Integer.valueOf(49), Integer.valueOf(256), str2 });
            continue;
            com.tencent.mm.plugin.report.service.h.OAn.b(10424, new Object[] { Integer.valueOf(49), Integer.valueOf(128), str2 });
            continue;
            com.tencent.mm.plugin.report.service.h.OAn.b(10424, new Object[] { Integer.valueOf(49), Integer.valueOf(512), str2 });
          }
        }
      });
      AppMethodBeat.o(34917);
      return;
      localList = nu(g.bGO());
      continue;
      localList = nu(g.bGM());
      continue;
      localList = nu(g.bGQ());
    }
  }
  
  private static void a(List<String> paramList, Context paramContext, u.i parami)
  {
    AppMethodBeat.i(34919);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      Log.w("MicroMsg.LongClickBrandServiceHelper", "tryShowConnectorDialog: careList is null or empty");
      AppMethodBeat.o(34919);
      return;
    }
    l locall = new l(paramContext);
    locall.Vti = new ap.11();
    locall.Vtj = new ap.2(paramContext);
    locall.Vtg = new ap.3(paramList);
    locall.GAC = parami;
    locall.jDd();
    AppMethodBeat.o(34919);
  }
  
  public static void b(cc paramcc, final Context paramContext)
  {
    AppMethodBeat.i(34908);
    if (paramContext == null)
    {
      Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: context is null");
      AppMethodBeat.o(34908);
      return;
    }
    if (paramcc == null)
    {
      Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: msg is null");
      AppMethodBeat.o(34908);
      return;
    }
    bh.bCz();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      aa.nh(paramContext);
      Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: sd card not available");
      AppMethodBeat.o(34908);
      return;
    }
    a(nu(af.bHf().vP(2)), paramContext, new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(34899);
        paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
        if (Util.isNullOrNil(ap.this.field_imgPath))
        {
          Log.e("MicroMsg.LongClickBrandServiceHelper", "Transfer fileName erro: fileName null");
          AppMethodBeat.o(34899);
          return;
        }
        Object localObject = com.tencent.mm.modelvoice.s.QQ(ap.this.field_imgPath);
        String str = ap.this.field_imgPath;
        if (localObject == null) {}
        for (paramAnonymousInt = 0;; paramAnonymousInt = ((com.tencent.mm.modelvoice.r)localObject).peH)
        {
          localObject = com.tencent.mm.modelvoice.s.s(paramAnonymousMenuItem, str, paramAnonymousInt);
          Log.i("MicroMsg.LongClickBrandServiceHelper", "connector click[voice]: to[%s] filePath[%s]", new Object[] { paramAnonymousMenuItem, localObject });
          localObject = new com.tencent.mm.modelvoice.f((String)localObject, 1);
          bh.aZW().a((p)localObject, 0);
          com.tencent.mm.plugin.report.service.h.OAn.b(10424, new Object[] { Integer.valueOf(34), Integer.valueOf(2), paramAnonymousMenuItem });
          k.cZ(paramContext, paramContext.getString(R.l.app_saved));
          AppMethodBeat.o(34899);
          return;
        }
      }
    });
    AppMethodBeat.o(34908);
  }
  
  public static void b(cc paramcc, String paramString, Context paramContext)
  {
    AppMethodBeat.i(34915);
    a(paramcc, paramString, paramContext, 256);
    AppMethodBeat.o(34915);
  }
  
  public static void c(cc paramcc, final Context paramContext)
  {
    AppMethodBeat.i(34910);
    if (paramContext == null)
    {
      Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: context is null");
      AppMethodBeat.o(34910);
      return;
    }
    if (paramcc == null)
    {
      Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: msg is null");
      AppMethodBeat.o(34910);
      return;
    }
    bh.bCz();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      aa.nh(paramContext);
      Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: sd card is not available");
      AppMethodBeat.o(34910);
      return;
    }
    a(nu(af.bHf().vP(8)), paramContext, new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(34901);
        paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
        com.tencent.mm.modelvideo.z localz = com.tencent.mm.modelvideo.ab.Qo(ap.this.field_imgPath);
        Log.i("MicroMsg.LongClickBrandServiceHelper", "connector click[video]: to[%s] imgPath[%s]", new Object[] { paramAnonymousMenuItem, ap.this.field_imgPath });
        final MsgRetransmitUI.a locala = new MsgRetransmitUI.a();
        Object localObject = paramContext;
        paramContext.getResources().getString(R.l.app_tip);
        localObject = k.a((Context)localObject, paramContext.getResources().getString(R.l.app_sending), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            locala.afNt = true;
          }
        });
        locala.context = paramContext;
        locala.fileName = ap.this.field_imgPath;
        locala.tipDialog = ((Dialog)localObject);
        locala.userName = paramAnonymousMenuItem;
        locala.afMH = localz.pbf;
        locala.omT = localz.omT;
        locala.execute(new Object[0]);
        ch.bDg().f(ch.onj, null);
        k.cZ(paramContext, paramContext.getString(R.l.app_saved));
        AppMethodBeat.o(34901);
      }
    });
    AppMethodBeat.o(34910);
  }
  
  public static void c(cc paramcc, String paramString, Context paramContext)
  {
    AppMethodBeat.i(34916);
    a(paramcc, paramString, paramContext, 128);
    AppMethodBeat.o(34916);
  }
  
  public static void d(cc paramcc, final Context paramContext)
  {
    AppMethodBeat.i(34913);
    if (paramContext == null)
    {
      Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: context is null");
      AppMethodBeat.o(34913);
      return;
    }
    if (paramcc == null)
    {
      Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: msg is null");
      AppMethodBeat.o(34913);
      return;
    }
    bh.bCz();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      aa.nh(paramContext);
      Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: sd card is not available");
      AppMethodBeat.o(34913);
      return;
    }
    a(nu(af.bHf().vP(64)), paramContext, new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(34904);
        String str = paramAnonymousMenuItem.getTitle();
        paramAnonymousMenuItem = bg.byj(ap.this.field_content).md5;
        if ((paramAnonymousMenuItem == null) || (paramAnonymousMenuItem.endsWith("-1"))) {
          paramAnonymousMenuItem = ap.this.field_imgPath;
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
          if (((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().y(paramContext, str, paramAnonymousMenuItem))
          {
            com.tencent.mm.plugin.report.service.h.OAn.b(10424, new Object[] { Integer.valueOf(47), Integer.valueOf(64), str });
            k.cZ(paramContext, "");
          }
          com.tencent.mm.plugin.report.service.h.OAn.b(10424, new Object[] { Integer.valueOf(47), Integer.valueOf(64), str });
          k.cZ(paramContext, paramContext.getString(R.l.app_saved));
          AppMethodBeat.o(34904);
          return;
        }
      }
    });
    AppMethodBeat.o(34913);
  }
  
  private static List<String> nu(List<String> paramList)
  {
    AppMethodBeat.i(34918);
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (!g.Mz(str)) {
        localLinkedList.add(str);
      }
    }
    Log.d("MicroMsg.LongClickBrandServiceHelper", "get selected accept list, size %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    AppMethodBeat.o(34918);
    return localLinkedList;
  }
  
  public static void p(String paramString, final Context paramContext)
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
    a(nu(af.bHf().vP(1)), paramContext, new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(34896);
        paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
        Log.i("MicroMsg.LongClickBrandServiceHelper", "connector click[text]: to[%s] text[%s]", new Object[] { paramAnonymousMenuItem, ap.this });
        t.e locale = t.OH(paramAnonymousMenuItem);
        locale.toUser = paramAnonymousMenuItem;
        locale.content = ap.this;
        locale = locale.wF(com.tencent.mm.model.ab.IX(paramAnonymousMenuItem));
        locale.eQp = 0;
        locale.oNj = 4;
        locale.bKW().aXz();
        com.tencent.mm.plugin.report.service.h.OAn.b(10424, new Object[] { Integer.valueOf(1), Integer.valueOf(1), paramAnonymousMenuItem });
        k.cZ(paramContext, paramContext.getString(R.l.app_saved));
        AppMethodBeat.o(34896);
      }
    });
    AppMethodBeat.o(34907);
  }
  
  public static void q(String paramString, final Context paramContext)
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
    a(nu(af.bHf().vP(16)), paramContext, new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(34902);
        paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
        Log.i("MicroMsg.LongClickBrandServiceHelper", "connector click[location]: to[%s] content[%s]", new Object[] { paramAnonymousMenuItem, ap.this });
        t.e locale = t.OH(paramAnonymousMenuItem);
        locale.toUser = paramAnonymousMenuItem;
        locale.content = ap.this;
        locale = locale.wF(48);
        locale.eQp = 0;
        locale.oNj = 4;
        locale.bKW().aXz();
        com.tencent.mm.plugin.report.service.h.OAn.b(10424, new Object[] { Integer.valueOf(48), Integer.valueOf(16), paramAnonymousMenuItem });
        k.cZ(paramContext, paramContext.getString(R.l.app_saved));
        AppMethodBeat.o(34902);
      }
    });
    AppMethodBeat.o(34911);
  }
  
  public static void r(String paramString, final Context paramContext)
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
    a(nu(af.bHf().vP(32)), paramContext, new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        int i = 66;
        AppMethodBeat.i(34903);
        paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
        Log.i("MicroMsg.LongClickBrandServiceHelper", "connector click[location]: to[%s] content[%s]", new Object[] { paramAnonymousMenuItem, ap.this });
        cc.a locala = cc.a.bys(ap.this);
        Object localObject = t.OH(paramAnonymousMenuItem);
        ((t.e)localObject).toUser = paramAnonymousMenuItem;
        ((t.e)localObject).content = ap.this;
        if (au.bwO(locala.hgk))
        {
          paramAnonymousInt = 66;
          localObject = ((t.e)localObject).wF(paramAnonymousInt);
          ((t.e)localObject).eQp = 0;
          ((t.e)localObject).oNj = 4;
          ((t.e)localObject).bKW().aXz();
          localObject = com.tencent.mm.plugin.report.service.h.OAn;
          if (!au.bwO(locala.hgk)) {
            break label202;
          }
        }
        label202:
        for (paramAnonymousInt = i;; paramAnonymousInt = 42)
        {
          ((com.tencent.mm.plugin.report.service.h)localObject).b(10424, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(32), paramAnonymousMenuItem });
          k.cZ(paramContext, paramContext.getString(R.l.app_saved));
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
 * Qualified Name:     com.tencent.mm.ui.chatting.ap
 * JD-Core Version:    0.7.0.1
 */