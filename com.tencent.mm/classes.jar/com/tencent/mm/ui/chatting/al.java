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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.n;
import com.tencent.mm.am.ag;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.w;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bu.a;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.transmit.MsgRetransmitUI.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class al
{
  public static void a(bu parambu, final Context paramContext, final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(34909);
    if (paramContext == null)
    {
      ad.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: context is null");
      AppMethodBeat.o(34909);
      return;
    }
    if (parambu == null)
    {
      ad.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: msg is null");
      AppMethodBeat.o(34909);
      return;
    }
    ba.aBQ();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      t.kg(paramContext);
      ad.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: sd card is not available");
      AppMethodBeat.o(34909);
      return;
    }
    a(ia(ag.aFZ().oW(4)), paramContext, new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        paramAnonymousInt = 1;
        AppMethodBeat.i(34900);
        Object localObject1 = paramAnonymousMenuItem.getTitle();
        if (this.hED.field_msgId > 0L) {}
        for (paramAnonymousMenuItem = com.tencent.mm.aw.q.aIF().G(this.hED.field_talker, this.hED.field_msgId);; paramAnonymousMenuItem = null)
        {
          if (((paramAnonymousMenuItem == null) || (paramAnonymousMenuItem.dnz <= 0L)) && (this.hED.field_msgSvrId > 0L)) {
            paramAnonymousMenuItem = com.tencent.mm.aw.q.aIF().F(this.hED.field_talker, this.hED.field_msgSvrId);
          }
          for (;;)
          {
            if (paramAnonymousMenuItem == null)
            {
              ad.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: try get imgInfo fail");
              AppMethodBeat.o(34900);
              return;
            }
            if ((paramAnonymousMenuItem.offset >= paramAnonymousMenuItem.hMP) && (paramAnonymousMenuItem.hMP != 0))
            {
              if (this.hED.field_isSend == 1) {
                if (paramAnonymousMenuItem.aIj()) {
                  paramAnonymousInt = 1;
                }
              }
              for (;;)
              {
                localObject2 = com.tencent.mm.model.u.aAm();
                paramAnonymousMenuItem = com.tencent.mm.aw.q.aIF().o(com.tencent.mm.aw.h.c(paramAnonymousMenuItem), "", "");
                if (!bt.isNullOrNil(paramAnonymousMenuItem))
                {
                  ad.i("MicroMsg.LongClickBrandServiceHelper", "connector click[img]: to[%s] fileName[%s]", new Object[] { localObject1, paramAnonymousMenuItem });
                  o.e locale = o.a(o.d.ifX).pk(4);
                  locale.dyU = ((String)localObject2);
                  locale.toUser = ((String)localObject1);
                  locale.ibF = paramAnonymousMenuItem;
                  locale.hZz = paramAnonymousInt;
                  locale.igd = null;
                  locale.dxr = 0;
                  locale.hZI = "";
                  locale.thumbPath = "";
                  locale.igg = true;
                  locale.igf = 2131231564;
                  locale.igc = 11;
                  locale.aJv().execute();
                  bz.aCx().d(bz.hIc, null);
                }
                com.tencent.mm.plugin.report.service.g.yhR.f(10424, new Object[] { Integer.valueOf(3), Integer.valueOf(4), localObject1 });
                com.tencent.mm.ui.base.h.cl(paramContext, paramContext.getString(2131755881));
                AppMethodBeat.o(34900);
                return;
                paramAnonymousInt = 0;
                continue;
                if (!paramAnonymousMenuItem.aIj()) {
                  paramAnonymousInt = 0;
                } else if (!com.tencent.mm.vfs.i.fv(com.tencent.mm.aw.h.a(paramAnonymousMenuItem).hZw)) {
                  paramAnonymousInt = 0;
                } else {
                  paramAnonymousInt = 1;
                }
              }
            }
            ad.i("MicroMsg.LongClickBrandServiceHelper", "[ImageGalleryUI] enter");
            paramAnonymousMenuItem = new Intent(paramContext, ImageGalleryUI.class);
            paramAnonymousMenuItem.putExtra("img_gallery_msg_id", this.hED.field_msgId);
            paramAnonymousMenuItem.putExtra("img_gallery_msg_svr_id", this.hED.field_msgSvrId);
            paramAnonymousMenuItem.putExtra("img_gallery_talker", this.hED.field_talker);
            paramAnonymousMenuItem.putExtra("img_gallery_chatroom_name", this.hED.field_talker);
            paramAnonymousMenuItem.putExtra("img_gallery_is_restransmit_after_download", true);
            paramAnonymousMenuItem.putExtra("img_gallery_directly_send_name", (String)localObject1);
            paramAnonymousMenuItem.putExtra("start_chatting_ui", false);
            localObject1 = this.hED.field_talker;
            Object localObject2 = new Bundle();
            if (paramBoolean) {
              paramAnonymousInt = 2;
            }
            for (;;)
            {
              ((Bundle)localObject2).putInt("stat_scene", paramAnonymousInt);
              ((Bundle)localObject2).putString("stat_msg_id", "msg_" + Long.toString(this.hED.field_msgSvrId));
              ((Bundle)localObject2).putString("stat_chat_talker_username", (String)localObject1);
              ((Bundle)localObject2).putString("stat_send_msg_user", paramString);
              paramAnonymousMenuItem.putExtra("_stat_obj", (Bundle)localObject2);
              localObject1 = paramContext;
              paramAnonymousMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousMenuItem);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramAnonymousMenuItem.ahp(), "com/tencent/mm/ui/chatting/SendToBrandServiceHelper$3", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Context)localObject1).startActivity((Intent)paramAnonymousMenuItem.mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/SendToBrandServiceHelper$3", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(34900);
              return;
              if (w.zE((String)localObject1)) {
                paramAnonymousInt = 7;
              }
            }
          }
        }
      }
    });
    AppMethodBeat.o(34909);
  }
  
  public static void a(bu parambu, String paramString, Context paramContext)
  {
    AppMethodBeat.i(34914);
    a(parambu, paramString, paramContext, 512);
    AppMethodBeat.o(34914);
  }
  
  private static void a(bu parambu, final String paramString, final Context paramContext, final int paramInt)
  {
    AppMethodBeat.i(34917);
    if (paramContext == null)
    {
      ad.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptMusicConnector: context is null");
      AppMethodBeat.o(34917);
      return;
    }
    if (parambu == null)
    {
      ad.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptMusicConnector: msg is null");
      AppMethodBeat.o(34917);
      return;
    }
    List localList = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      a(localList, paramContext, new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(34905);
          String str2 = paramAnonymousMenuItem.getTitle();
          Object localObject2 = this.hED;
          k.b localb = k.b.yr(bt.aRd(paramString));
          if (localb == null)
          {
            ad.w("MicroMsg.LongClickBrandServiceHelper", "send: parse app msg content return null");
            switch (paramInt)
            {
            }
          }
          for (;;)
          {
            for (;;)
            {
              com.tencent.mm.ui.base.h.cl(paramContext, paramContext.getString(2131755881));
              AppMethodBeat.o(34905);
              return;
              paramAnonymousMenuItem = null;
              Object localObject1 = paramAnonymousMenuItem;
              if (((ei)localObject2).field_imgPath != null)
              {
                localObject1 = paramAnonymousMenuItem;
                if (!((ei)localObject2).field_imgPath.equals("")) {
                  localObject1 = com.tencent.mm.aw.q.aIF().R(((ei)localObject2).field_imgPath, true);
                }
              }
              try
              {
                localObject1 = com.tencent.mm.vfs.i.aY((String)localObject1, 0, -1);
                localObject2 = new com.tencent.mm.pluginsdk.model.app.c();
                paramAnonymousMenuItem = (MenuItem)localObject2;
                if (!bt.isNullOrNil(localb.dks))
                {
                  long l = bt.getLong(localb.dks, -1L);
                  if (l == -1L) {
                    break label415;
                  }
                  ao.bIX().get(l, (com.tencent.mm.sdk.e.c)localObject2);
                  paramAnonymousMenuItem = (MenuItem)localObject2;
                  if (((com.tencent.mm.pluginsdk.model.app.c)localObject2).systemRowid != l)
                  {
                    localObject2 = ao.bIX().aLD(localb.dks);
                    if (localObject2 != null)
                    {
                      paramAnonymousMenuItem = (MenuItem)localObject2;
                      if (((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_mediaSvrId.equals(localb.dks)) {}
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
                      ba.aBQ();
                      localObject2 = m.aq(com.tencent.mm.model.c.azI(), localb.title, localb.hzP);
                      com.tencent.mm.vfs.i.mz(paramAnonymousMenuItem.field_fileFullPath, (String)localObject2);
                    }
                  }
                }
                paramAnonymousMenuItem = k.b.a(localb);
                paramAnonymousMenuItem.hzR = 3;
                m.a(paramAnonymousMenuItem, localb.appId, localb.appName, str2, (String)localObject2, (byte[])localObject1, null);
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  ad.e("MicroMsg.LongClickBrandServiceHelper", "send appmsg to %s, error:%s", new Object[] { str2, localException.getLocalizedMessage() });
                  MenuItem localMenuItem = paramAnonymousMenuItem;
                  continue;
                  label415:
                  localObject2 = ao.bIX().aLD(localb.dks);
                  if (localObject2 != null)
                  {
                    paramAnonymousMenuItem = (MenuItem)localObject2;
                    if (((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_mediaSvrId.equals(localb.dks)) {}
                  }
                  else
                  {
                    paramAnonymousMenuItem = null;
                  }
                }
              }
            }
            com.tencent.mm.plugin.report.service.g.yhR.f(10424, new Object[] { Integer.valueOf(49), Integer.valueOf(256), str2 });
            continue;
            com.tencent.mm.plugin.report.service.g.yhR.f(10424, new Object[] { Integer.valueOf(49), Integer.valueOf(128), str2 });
            continue;
            com.tencent.mm.plugin.report.service.g.yhR.f(10424, new Object[] { Integer.valueOf(49), Integer.valueOf(512), str2 });
          }
        }
      });
      AppMethodBeat.o(34917);
      return;
      localList = ia(com.tencent.mm.am.g.aFG());
      continue;
      localList = ia(com.tencent.mm.am.g.aFE());
      continue;
      localList = ia(com.tencent.mm.am.g.aFI());
    }
  }
  
  private static void a(List<String> paramList, Context paramContext, n.e parame)
  {
    AppMethodBeat.i(34919);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ad.w("MicroMsg.LongClickBrandServiceHelper", "tryShowConnectorDialog: careList is null or empty");
      AppMethodBeat.o(34919);
      return;
    }
    l locall = new l(paramContext);
    locall.KJC = new al.11();
    locall.KJD = new al.2(paramContext);
    locall.KJy = new al.3(paramList);
    locall.KJz = parame;
    locall.fKy();
    AppMethodBeat.o(34919);
  }
  
  public static void b(bu parambu, final Context paramContext)
  {
    AppMethodBeat.i(34908);
    if (paramContext == null)
    {
      ad.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: context is null");
      AppMethodBeat.o(34908);
      return;
    }
    if (parambu == null)
    {
      ad.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: msg is null");
      AppMethodBeat.o(34908);
      return;
    }
    ba.aBQ();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      t.kg(paramContext);
      ad.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: sd card not available");
      AppMethodBeat.o(34908);
      return;
    }
    a(ia(ag.aFZ().oW(2)), paramContext, new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(34899);
        paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
        if (bt.isNullOrNil(this.hED.field_imgPath))
        {
          ad.e("MicroMsg.LongClickBrandServiceHelper", "Transfer fileName erro: fileName null");
          AppMethodBeat.o(34899);
          return;
        }
        Object localObject = com.tencent.mm.modelvoice.s.Ia(this.hED.field_imgPath);
        String str = this.hED.field_imgPath;
        if (localObject == null) {}
        for (paramAnonymousInt = 0;; paramAnonymousInt = ((r)localObject).ixm)
        {
          localObject = com.tencent.mm.modelvoice.s.o(paramAnonymousMenuItem, str, paramAnonymousInt);
          ad.i("MicroMsg.LongClickBrandServiceHelper", "connector click[voice]: to[%s] filePath[%s]", new Object[] { paramAnonymousMenuItem, localObject });
          localObject = new com.tencent.mm.modelvoice.f((String)localObject, 1);
          ba.aiU().a((n)localObject, 0);
          com.tencent.mm.plugin.report.service.g.yhR.f(10424, new Object[] { Integer.valueOf(34), Integer.valueOf(2), paramAnonymousMenuItem });
          com.tencent.mm.ui.base.h.cl(paramContext, paramContext.getString(2131755881));
          AppMethodBeat.o(34899);
          return;
        }
      }
    });
    AppMethodBeat.o(34908);
  }
  
  public static void b(bu parambu, String paramString, Context paramContext)
  {
    AppMethodBeat.i(34915);
    a(parambu, paramString, paramContext, 256);
    AppMethodBeat.o(34915);
  }
  
  public static void c(bu parambu, final Context paramContext)
  {
    AppMethodBeat.i(34910);
    if (paramContext == null)
    {
      ad.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: context is null");
      AppMethodBeat.o(34910);
      return;
    }
    if (parambu == null)
    {
      ad.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: msg is null");
      AppMethodBeat.o(34910);
      return;
    }
    ba.aBQ();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      t.kg(paramContext);
      ad.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: sd card is not available");
      AppMethodBeat.o(34910);
      return;
    }
    a(ia(ag.aFZ().oW(8)), paramContext, new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(34901);
        paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
        com.tencent.mm.modelvideo.s locals = com.tencent.mm.modelvideo.u.Hy(this.hED.field_imgPath);
        ad.i("MicroMsg.LongClickBrandServiceHelper", "connector click[video]: to[%s] imgPath[%s]", new Object[] { paramAnonymousMenuItem, this.hED.field_imgPath });
        final MsgRetransmitUI.a locala = new MsgRetransmitUI.a();
        Object localObject = paramContext;
        paramContext.getResources().getString(2131755906);
        localObject = com.tencent.mm.ui.base.h.b((Context)localObject, paramContext.getResources().getString(2131755886), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            locala.KNs = true;
          }
        });
        locala.context = paramContext;
        locala.fileName = this.hED.field_imgPath;
        locala.tipDialog = ((Dialog)localObject);
        locala.userName = paramAnonymousMenuItem;
        locala.KMM = locals.iui;
        locala.hHQ = locals.hHQ;
        locala.execute(new Object[0]);
        bz.aCx().d(bz.hId, null);
        com.tencent.mm.ui.base.h.cl(paramContext, paramContext.getString(2131755881));
        AppMethodBeat.o(34901);
      }
    });
    AppMethodBeat.o(34910);
  }
  
  public static void c(bu parambu, String paramString, Context paramContext)
  {
    AppMethodBeat.i(34916);
    a(parambu, paramString, paramContext, 128);
    AppMethodBeat.o(34916);
  }
  
  public static void d(bu parambu, final Context paramContext)
  {
    AppMethodBeat.i(34913);
    if (paramContext == null)
    {
      ad.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: context is null");
      AppMethodBeat.o(34913);
      return;
    }
    if (parambu == null)
    {
      ad.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: msg is null");
      AppMethodBeat.o(34913);
      return;
    }
    ba.aBQ();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      t.kg(paramContext);
      ad.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: sd card is not available");
      AppMethodBeat.o(34913);
      return;
    }
    a(ia(ag.aFZ().oW(64)), paramContext, new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(34904);
        String str = paramAnonymousMenuItem.getTitle();
        paramAnonymousMenuItem = ay.aTS(this.hED.field_content).md5;
        if ((paramAnonymousMenuItem == null) || (paramAnonymousMenuItem.endsWith("-1"))) {
          paramAnonymousMenuItem = this.hED.field_imgPath;
        }
        for (;;)
        {
          if (paramAnonymousMenuItem == null)
          {
            ad.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: filePath is null");
            AppMethodBeat.o(34904);
            return;
          }
          ad.i("MicroMsg.LongClickBrandServiceHelper", "connector click[emoji]: to[%s] filePath[%s]", new Object[] { str, paramAnonymousMenuItem });
          if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().v(paramContext, str, paramAnonymousMenuItem))
          {
            com.tencent.mm.plugin.report.service.g.yhR.f(10424, new Object[] { Integer.valueOf(47), Integer.valueOf(64), str });
            com.tencent.mm.ui.base.h.cl(paramContext, "");
          }
          com.tencent.mm.plugin.report.service.g.yhR.f(10424, new Object[] { Integer.valueOf(47), Integer.valueOf(64), str });
          com.tencent.mm.ui.base.h.cl(paramContext, paramContext.getString(2131755881));
          AppMethodBeat.o(34904);
          return;
        }
      }
    });
    AppMethodBeat.o(34913);
  }
  
  private static List<String> ia(List<String> paramList)
  {
    AppMethodBeat.i(34918);
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (!com.tencent.mm.am.g.DO(str)) {
        localLinkedList.add(str);
      }
    }
    ad.d("MicroMsg.LongClickBrandServiceHelper", "get selected accept list, size %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    AppMethodBeat.o(34918);
    return localLinkedList;
  }
  
  public static void p(String paramString, final Context paramContext)
  {
    AppMethodBeat.i(34907);
    if (paramContext == null)
    {
      ad.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptTextConnector: context is null");
      AppMethodBeat.o(34907);
      return;
    }
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptTextConnector: content is null");
      AppMethodBeat.o(34907);
      return;
    }
    a(ia(ag.aFZ().oW(1)), paramContext, new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(34896);
        paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
        ad.i("MicroMsg.LongClickBrandServiceHelper", "connector click[text]: to[%s] text[%s]", new Object[] { paramAnonymousMenuItem, this.ilu });
        o.e locale = o.FX(paramAnonymousMenuItem);
        locale.toUser = paramAnonymousMenuItem;
        locale.content = this.ilu;
        locale.type = w.Ar(paramAnonymousMenuItem);
        locale.dDp = 0;
        locale.igc = 4;
        locale.aJv().execute();
        com.tencent.mm.plugin.report.service.g.yhR.f(10424, new Object[] { Integer.valueOf(1), Integer.valueOf(1), paramAnonymousMenuItem });
        com.tencent.mm.ui.base.h.cl(paramContext, paramContext.getString(2131755881));
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
      ad.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptLocationConnector: context is null");
      AppMethodBeat.o(34911);
      return;
    }
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptLocationConnector: locationXML is null");
      AppMethodBeat.o(34911);
      return;
    }
    a(ia(ag.aFZ().oW(16)), paramContext, new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(34902);
        paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
        ad.i("MicroMsg.LongClickBrandServiceHelper", "connector click[location]: to[%s] content[%s]", new Object[] { paramAnonymousMenuItem, this.JEr });
        o.e locale = o.FX(paramAnonymousMenuItem);
        locale.toUser = paramAnonymousMenuItem;
        locale.content = this.JEr;
        locale.type = 48;
        locale.dDp = 0;
        locale.igc = 4;
        locale.aJv().execute();
        com.tencent.mm.plugin.report.service.g.yhR.f(10424, new Object[] { Integer.valueOf(48), Integer.valueOf(16), paramAnonymousMenuItem });
        com.tencent.mm.ui.base.h.cl(paramContext, paramContext.getString(2131755881));
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
      ad.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptPersonalCardConnector: context is null");
      AppMethodBeat.o(34912);
      return;
    }
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptPersonalCardConnector: locationXML is null");
      AppMethodBeat.o(34912);
      return;
    }
    a(ia(ag.aFZ().oW(32)), paramContext, new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        int i = 66;
        AppMethodBeat.i(34903);
        paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
        ad.i("MicroMsg.LongClickBrandServiceHelper", "connector click[location]: to[%s] content[%s]", new Object[] { paramAnonymousMenuItem, this.JEs });
        bu.a locala = bu.a.aUb(this.JEs);
        Object localObject = o.FX(paramAnonymousMenuItem);
        ((o.e)localObject).toUser = paramAnonymousMenuItem;
        ((o.e)localObject).content = this.JEs;
        if (am.aSQ(locala.dHm))
        {
          paramAnonymousInt = 66;
          ((o.e)localObject).type = paramAnonymousInt;
          ((o.e)localObject).dDp = 0;
          ((o.e)localObject).igc = 4;
          ((o.e)localObject).aJv().execute();
          localObject = com.tencent.mm.plugin.report.service.g.yhR;
          if (!am.aSQ(locala.dHm)) {
            break label199;
          }
        }
        label199:
        for (paramAnonymousInt = i;; paramAnonymousInt = 42)
        {
          ((com.tencent.mm.plugin.report.service.g)localObject).f(10424, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(32), paramAnonymousMenuItem });
          com.tencent.mm.ui.base.h.cl(paramContext, paramContext.getString(2131755881));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.al
 * JD-Core Version:    0.7.0.1
 */