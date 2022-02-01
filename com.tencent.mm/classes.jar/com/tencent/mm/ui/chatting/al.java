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
import com.tencent.mm.al.q;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.by;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bl.a;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class al
{
  public static void a(bl parambl, final Context paramContext, final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(34909);
    if (paramContext == null)
    {
      ad.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: context is null");
      AppMethodBeat.o(34909);
      return;
    }
    if (parambl == null)
    {
      ad.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: msg is null");
      AppMethodBeat.o(34909);
      return;
    }
    az.arV();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      t.jK(paramContext);
      ad.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: sd card is not available");
      AppMethodBeat.o(34909);
      return;
    }
    a(hB(com.tencent.mm.am.af.awe().nH(4)), paramContext, new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(34900);
        Object localObject1 = paramAnonymousMenuItem.getTitle();
        paramAnonymousMenuItem = null;
        if (this.gLQ.field_msgId > 0L) {
          paramAnonymousMenuItem = o.ayF().ms(this.gLQ.field_msgId);
        }
        if (((paramAnonymousMenuItem == null) || (paramAnonymousMenuItem.deI <= 0L)) && (this.gLQ.field_msgSvrId > 0L)) {
          paramAnonymousMenuItem = o.ayF().mr(this.gLQ.field_msgSvrId);
        }
        for (;;)
        {
          if (paramAnonymousMenuItem == null)
          {
            ad.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: try get imgInfo fail");
            AppMethodBeat.o(34900);
            return;
          }
          if ((paramAnonymousMenuItem.offset >= paramAnonymousMenuItem.gTY) && (paramAnonymousMenuItem.gTY != 0))
          {
            if (this.gLQ.field_isSend == 1) {
              if (paramAnonymousMenuItem.ayi()) {
                paramAnonymousInt = 1;
              }
            }
            for (;;)
            {
              localObject2 = com.tencent.mm.model.u.aqG();
              paramAnonymousMenuItem = o.ayF().p(com.tencent.mm.aw.f.c(paramAnonymousMenuItem), "", "");
              if (!bt.isNullOrNil(paramAnonymousMenuItem))
              {
                ad.i("MicroMsg.LongClickBrandServiceHelper", "connector click[img]: to[%s] fileName[%s]", new Object[] { localObject1, paramAnonymousMenuItem });
                paramAnonymousMenuItem = new com.tencent.mm.aw.l(4, (String)localObject2, (String)localObject1, paramAnonymousMenuItem, paramAnonymousInt, null, 0, "", "", true, 2131231564);
                az.aeS().a(paramAnonymousMenuItem, 0);
                by.asD().d(by.gPk, null);
              }
              com.tencent.mm.plugin.report.service.h.vKh.f(10424, new Object[] { Integer.valueOf(3), Integer.valueOf(4), localObject1 });
              com.tencent.mm.ui.base.h.cf(paramContext, paramContext.getString(2131755881));
              AppMethodBeat.o(34900);
              return;
              paramAnonymousInt = 0;
              continue;
              if (!paramAnonymousMenuItem.ayi()) {
                paramAnonymousInt = 0;
              } else if (!com.tencent.mm.vfs.i.eK(com.tencent.mm.aw.f.a(paramAnonymousMenuItem).hgj)) {
                paramAnonymousInt = 0;
              } else {
                paramAnonymousInt = 1;
              }
            }
          }
          ad.i("MicroMsg.LongClickBrandServiceHelper", "[ImageGalleryUI] enter");
          paramAnonymousMenuItem = new Intent(paramContext, ImageGalleryUI.class);
          paramAnonymousMenuItem.putExtra("img_gallery_msg_id", this.gLQ.field_msgId);
          paramAnonymousMenuItem.putExtra("img_gallery_msg_svr_id", this.gLQ.field_msgSvrId);
          paramAnonymousMenuItem.putExtra("img_gallery_talker", this.gLQ.field_talker);
          paramAnonymousMenuItem.putExtra("img_gallery_chatroom_name", this.gLQ.field_talker);
          paramAnonymousMenuItem.putExtra("img_gallery_is_restransmit_after_download", true);
          paramAnonymousMenuItem.putExtra("img_gallery_directly_send_name", (String)localObject1);
          paramAnonymousMenuItem.putExtra("start_chatting_ui", false);
          localObject1 = this.gLQ.field_talker;
          Object localObject2 = new Bundle();
          if (paramBoolean) {
            paramAnonymousInt = 2;
          }
          for (;;)
          {
            ((Bundle)localObject2).putInt("stat_scene", paramAnonymousInt);
            ((Bundle)localObject2).putString("stat_msg_id", "msg_" + Long.toString(this.gLQ.field_msgSvrId));
            ((Bundle)localObject2).putString("stat_chat_talker_username", (String)localObject1);
            ((Bundle)localObject2).putString("stat_send_msg_user", paramString);
            paramAnonymousMenuItem.putExtra("_stat_obj", (Bundle)localObject2);
            localObject1 = paramContext;
            paramAnonymousMenuItem = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousMenuItem);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramAnonymousMenuItem.adn(), "com/tencent/mm/ui/chatting/SendToBrandServiceHelper$3", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Context)localObject1).startActivity((Intent)paramAnonymousMenuItem.lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/SendToBrandServiceHelper$3", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(34900);
            return;
            if (w.sE((String)localObject1)) {
              paramAnonymousInt = 7;
            } else {
              paramAnonymousInt = 1;
            }
          }
        }
      }
    });
    AppMethodBeat.o(34909);
  }
  
  public static void a(bl parambl, String paramString, Context paramContext)
  {
    AppMethodBeat.i(34914);
    a(parambl, paramString, paramContext, 512);
    AppMethodBeat.o(34914);
  }
  
  private static void a(bl parambl, final String paramString, final Context paramContext, final int paramInt)
  {
    AppMethodBeat.i(34917);
    if (paramContext == null)
    {
      ad.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptMusicConnector: context is null");
      AppMethodBeat.o(34917);
      return;
    }
    if (parambl == null)
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
      a(localList, paramContext, new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(34905);
          String str2 = paramAnonymousMenuItem.getTitle();
          Object localObject2 = this.gLQ;
          k.b localb = k.b.rx(bt.aGg(paramString));
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
              com.tencent.mm.ui.base.h.cf(paramContext, paramContext.getString(2131755881));
              AppMethodBeat.o(34905);
              return;
              paramAnonymousMenuItem = null;
              Object localObject1 = paramAnonymousMenuItem;
              if (((du)localObject2).field_imgPath != null)
              {
                localObject1 = paramAnonymousMenuItem;
                if (!((du)localObject2).field_imgPath.equals("")) {
                  localObject1 = o.ayF().Q(((du)localObject2).field_imgPath, true);
                }
              }
              try
              {
                localObject1 = com.tencent.mm.vfs.i.aR((String)localObject1, 0, -1);
                localObject2 = new com.tencent.mm.pluginsdk.model.app.c();
                paramAnonymousMenuItem = (MenuItem)localObject2;
                if (!bt.isNullOrNil(localb.dbA))
                {
                  long l = bt.getLong(localb.dbA, -1L);
                  if (l == -1L) {
                    break label415;
                  }
                  ap.bxS().get(l, (com.tencent.mm.sdk.e.c)localObject2);
                  paramAnonymousMenuItem = (MenuItem)localObject2;
                  if (((com.tencent.mm.pluginsdk.model.app.c)localObject2).systemRowid != l)
                  {
                    localObject2 = ap.bxS().aAL(localb.dbA);
                    if (localObject2 != null)
                    {
                      paramAnonymousMenuItem = (MenuItem)localObject2;
                      if (((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_mediaSvrId.equals(localb.dbA)) {}
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
                      az.arV();
                      localObject2 = m.ai(com.tencent.mm.model.c.aqe(), localb.title, localb.gHf);
                      com.tencent.mm.vfs.i.lC(paramAnonymousMenuItem.field_fileFullPath, (String)localObject2);
                    }
                  }
                }
                paramAnonymousMenuItem = k.b.a(localb);
                paramAnonymousMenuItem.gHh = 3;
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
                  localObject2 = ap.bxS().aAL(localb.dbA);
                  if (localObject2 != null)
                  {
                    paramAnonymousMenuItem = (MenuItem)localObject2;
                    if (((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_mediaSvrId.equals(localb.dbA)) {}
                  }
                  else
                  {
                    paramAnonymousMenuItem = null;
                  }
                }
              }
            }
            com.tencent.mm.plugin.report.service.h.vKh.f(10424, new Object[] { Integer.valueOf(49), Integer.valueOf(256), str2 });
            continue;
            com.tencent.mm.plugin.report.service.h.vKh.f(10424, new Object[] { Integer.valueOf(49), Integer.valueOf(128), str2 });
            continue;
            com.tencent.mm.plugin.report.service.h.vKh.f(10424, new Object[] { Integer.valueOf(49), Integer.valueOf(512), str2 });
          }
        }
      });
      AppMethodBeat.o(34917);
      return;
      localList = hB(com.tencent.mm.am.f.avL());
      continue;
      localList = hB(com.tencent.mm.am.f.avJ());
      continue;
      localList = hB(com.tencent.mm.am.f.avN());
    }
  }
  
  private static void a(List<String> paramList, Context paramContext, n.d paramd)
  {
    AppMethodBeat.i(34919);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ad.w("MicroMsg.LongClickBrandServiceHelper", "tryShowConnectorDialog: careList is null or empty");
      AppMethodBeat.o(34919);
      return;
    }
    com.tencent.mm.ui.tools.l locall = new com.tencent.mm.ui.tools.l(paramContext);
    locall.Hsb = new al.11();
    locall.Hsc = new al.2(paramContext);
    locall.HrX = new al.3(paramList);
    locall.HrY = paramd;
    locall.fdQ();
    AppMethodBeat.o(34919);
  }
  
  public static void b(bl parambl, final Context paramContext)
  {
    AppMethodBeat.i(34908);
    if (paramContext == null)
    {
      ad.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: context is null");
      AppMethodBeat.o(34908);
      return;
    }
    if (parambl == null)
    {
      ad.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: msg is null");
      AppMethodBeat.o(34908);
      return;
    }
    az.arV();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      t.jK(paramContext);
      ad.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: sd card not available");
      AppMethodBeat.o(34908);
      return;
    }
    a(hB(com.tencent.mm.am.af.awe().nH(2)), paramContext, new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(34899);
        paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
        if (bt.isNullOrNil(this.gLQ.field_imgPath))
        {
          ad.e("MicroMsg.LongClickBrandServiceHelper", "Transfer fileName erro: fileName null");
          AppMethodBeat.o(34899);
          return;
        }
        Object localObject = com.tencent.mm.modelvoice.s.AG(this.gLQ.field_imgPath);
        String str = this.gLQ.field_imgPath;
        if (localObject == null) {}
        for (paramAnonymousInt = 0;; paramAnonymousInt = ((r)localObject).hDp)
        {
          localObject = com.tencent.mm.modelvoice.s.m(paramAnonymousMenuItem, str, paramAnonymousInt);
          ad.i("MicroMsg.LongClickBrandServiceHelper", "connector click[voice]: to[%s] filePath[%s]", new Object[] { paramAnonymousMenuItem, localObject });
          localObject = new com.tencent.mm.modelvoice.f((String)localObject, 1);
          az.aeS().a((n)localObject, 0);
          com.tencent.mm.plugin.report.service.h.vKh.f(10424, new Object[] { Integer.valueOf(34), Integer.valueOf(2), paramAnonymousMenuItem });
          com.tencent.mm.ui.base.h.cf(paramContext, paramContext.getString(2131755881));
          AppMethodBeat.o(34899);
          return;
        }
      }
    });
    AppMethodBeat.o(34908);
  }
  
  public static void b(bl parambl, String paramString, Context paramContext)
  {
    AppMethodBeat.i(34915);
    a(parambl, paramString, paramContext, 256);
    AppMethodBeat.o(34915);
  }
  
  public static void c(bl parambl, final Context paramContext)
  {
    AppMethodBeat.i(34910);
    if (paramContext == null)
    {
      ad.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: context is null");
      AppMethodBeat.o(34910);
      return;
    }
    if (parambl == null)
    {
      ad.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: msg is null");
      AppMethodBeat.o(34910);
      return;
    }
    az.arV();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      t.jK(paramContext);
      ad.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: sd card is not available");
      AppMethodBeat.o(34910);
      return;
    }
    a(hB(com.tencent.mm.am.af.awe().nH(8)), paramContext, new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(34901);
        paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
        com.tencent.mm.modelvideo.s locals = com.tencent.mm.modelvideo.u.Ae(this.gLQ.field_imgPath);
        ad.i("MicroMsg.LongClickBrandServiceHelper", "connector click[video]: to[%s] imgPath[%s]", new Object[] { paramAnonymousMenuItem, this.gLQ.field_imgPath });
        final MsgRetransmitUI.a locala = new MsgRetransmitUI.a();
        Object localObject = paramContext;
        paramContext.getResources().getString(2131755906);
        localObject = com.tencent.mm.ui.base.h.b((Context)localObject, paramContext.getResources().getString(2131755886), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            locala.HvR = true;
          }
        });
        locala.context = paramContext;
        locala.fileName = this.gLQ.field_imgPath;
        locala.tipDialog = ((Dialog)localObject);
        locala.userName = paramAnonymousMenuItem;
        locala.Hvl = locals.hAl;
        locala.gOY = locals.gOY;
        locala.execute(new Object[0]);
        by.asD().d(by.gPl, null);
        com.tencent.mm.ui.base.h.cf(paramContext, paramContext.getString(2131755881));
        AppMethodBeat.o(34901);
      }
    });
    AppMethodBeat.o(34910);
  }
  
  public static void c(bl parambl, String paramString, Context paramContext)
  {
    AppMethodBeat.i(34916);
    a(parambl, paramString, paramContext, 128);
    AppMethodBeat.o(34916);
  }
  
  public static void d(bl parambl, final Context paramContext)
  {
    AppMethodBeat.i(34913);
    if (paramContext == null)
    {
      ad.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: context is null");
      AppMethodBeat.o(34913);
      return;
    }
    if (parambl == null)
    {
      ad.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: msg is null");
      AppMethodBeat.o(34913);
      return;
    }
    az.arV();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      t.jK(paramContext);
      ad.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: sd card is not available");
      AppMethodBeat.o(34913);
      return;
    }
    a(hB(com.tencent.mm.am.af.awe().nH(64)), paramContext, new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(34904);
        String str = paramAnonymousMenuItem.getTitle();
        paramAnonymousMenuItem = ar.aIF(this.gLQ.field_content).md5;
        if ((paramAnonymousMenuItem == null) || (paramAnonymousMenuItem.endsWith("-1"))) {
          paramAnonymousMenuItem = this.gLQ.field_imgPath;
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
            com.tencent.mm.plugin.report.service.h.vKh.f(10424, new Object[] { Integer.valueOf(47), Integer.valueOf(64), str });
            com.tencent.mm.ui.base.h.cf(paramContext, "");
          }
          com.tencent.mm.plugin.report.service.h.vKh.f(10424, new Object[] { Integer.valueOf(47), Integer.valueOf(64), str });
          com.tencent.mm.ui.base.h.cf(paramContext, paramContext.getString(2131755881));
          AppMethodBeat.o(34904);
          return;
        }
      }
    });
    AppMethodBeat.o(34913);
  }
  
  private static List<String> hB(List<String> paramList)
  {
    AppMethodBeat.i(34918);
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (!com.tencent.mm.am.f.wJ(str)) {
        localLinkedList.add(str);
      }
    }
    ad.d("MicroMsg.LongClickBrandServiceHelper", "get selected accept list, size %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    AppMethodBeat.o(34918);
    return localLinkedList;
  }
  
  public static void p(String paramString, Context paramContext)
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
    a(hB(com.tencent.mm.am.af.awe().nH(1)), paramContext, new al.1(paramString, paramContext));
    AppMethodBeat.o(34907);
  }
  
  public static void q(String paramString, Context paramContext)
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
    a(hB(com.tencent.mm.am.af.awe().nH(16)), paramContext, new al.7(paramString, paramContext));
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
    a(hB(com.tencent.mm.am.af.awe().nH(32)), paramContext, new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        int i = 66;
        AppMethodBeat.i(34903);
        paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
        ad.i("MicroMsg.LongClickBrandServiceHelper", "connector click[location]: to[%s] content[%s]", new Object[] { paramAnonymousMenuItem, this.GqL });
        bl.a locala = bl.a.aIO(this.GqL);
        Object localObject = this.GqL;
        if (com.tencent.mm.storage.af.aHH(locala.yGA))
        {
          paramAnonymousInt = 66;
          localObject = new com.tencent.mm.modelmulti.i(paramAnonymousMenuItem, (String)localObject, paramAnonymousInt, 0);
          az.aeS().a((n)localObject, 0);
          localObject = com.tencent.mm.plugin.report.service.h.vKh;
          if (!com.tencent.mm.storage.af.aHH(locala.yGA)) {
            break label181;
          }
        }
        label181:
        for (paramAnonymousInt = i;; paramAnonymousInt = 42)
        {
          ((com.tencent.mm.plugin.report.service.h)localObject).f(10424, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(32), paramAnonymousMenuItem });
          com.tencent.mm.ui.base.h.cf(paramContext, paramContext.getString(2131755881));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.al
 * JD-Core Version:    0.7.0.1
 */