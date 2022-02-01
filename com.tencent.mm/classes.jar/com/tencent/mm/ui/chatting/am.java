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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.al.ag;
import com.tencent.mm.av.i;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bv.a;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.transmit.MsgRetransmitUI.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class am
{
  public static void a(bv parambv, final Context paramContext, final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(34909);
    if (paramContext == null)
    {
      ae.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: context is null");
      AppMethodBeat.o(34909);
      return;
    }
    if (parambv == null)
    {
      ae.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: msg is null");
      AppMethodBeat.o(34909);
      return;
    }
    bc.aCg();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      t.kn(paramContext);
      ae.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: sd card is not available");
      AppMethodBeat.o(34909);
      return;
    }
    a(ik(ag.aGp().oZ(4)), paramContext, new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        paramAnonymousInt = 1;
        AppMethodBeat.i(34900);
        Object localObject1 = paramAnonymousMenuItem.getTitle();
        if (this.hHv.field_msgId > 0L) {}
        for (paramAnonymousMenuItem = com.tencent.mm.av.q.aIX().G(this.hHv.field_talker, this.hHv.field_msgId);; paramAnonymousMenuItem = null)
        {
          if (((paramAnonymousMenuItem == null) || (paramAnonymousMenuItem.doE <= 0L)) && (this.hHv.field_msgSvrId > 0L)) {
            paramAnonymousMenuItem = com.tencent.mm.av.q.aIX().F(this.hHv.field_talker, this.hHv.field_msgSvrId);
          }
          for (;;)
          {
            if (paramAnonymousMenuItem == null)
            {
              ae.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: try get imgInfo fail");
              AppMethodBeat.o(34900);
              return;
            }
            if ((paramAnonymousMenuItem.offset >= paramAnonymousMenuItem.hPI) && (paramAnonymousMenuItem.hPI != 0))
            {
              if (this.hHv.field_isSend == 1) {
                if (paramAnonymousMenuItem.aIB()) {
                  paramAnonymousInt = 1;
                }
              }
              for (;;)
              {
                localObject2 = v.aAC();
                paramAnonymousMenuItem = com.tencent.mm.av.q.aIX().o(com.tencent.mm.av.h.c(paramAnonymousMenuItem), "", "");
                if (!bu.isNullOrNil(paramAnonymousMenuItem))
                {
                  ae.i("MicroMsg.LongClickBrandServiceHelper", "connector click[img]: to[%s] fileName[%s]", new Object[] { localObject1, paramAnonymousMenuItem });
                  o.e locale = com.tencent.mm.modelmulti.o.a(o.d.iiQ).pn(4);
                  locale.dzZ = ((String)localObject2);
                  locale.toUser = ((String)localObject1);
                  locale.iey = paramAnonymousMenuItem;
                  locale.icr = paramAnonymousInt;
                  locale.iiW = null;
                  locale.dyw = 0;
                  locale.icA = "";
                  locale.thumbPath = "";
                  locale.iiZ = true;
                  locale.iiY = 2131231564;
                  locale.iiV = 11;
                  locale.aJO().execute();
                  cb.aCN().d(cb.hKU, null);
                }
                com.tencent.mm.plugin.report.service.g.yxI.f(10424, new Object[] { Integer.valueOf(3), Integer.valueOf(4), localObject1 });
                com.tencent.mm.ui.base.h.cm(paramContext, paramContext.getString(2131755881));
                AppMethodBeat.o(34900);
                return;
                paramAnonymousInt = 0;
                continue;
                if (!paramAnonymousMenuItem.aIB()) {
                  paramAnonymousInt = 0;
                } else if (!com.tencent.mm.vfs.o.fB(com.tencent.mm.av.h.a(paramAnonymousMenuItem).ico)) {
                  paramAnonymousInt = 0;
                } else {
                  paramAnonymousInt = 1;
                }
              }
            }
            ae.i("MicroMsg.LongClickBrandServiceHelper", "[ImageGalleryUI] enter");
            paramAnonymousMenuItem = new Intent(paramContext, ImageGalleryUI.class);
            paramAnonymousMenuItem.putExtra("img_gallery_msg_id", this.hHv.field_msgId);
            paramAnonymousMenuItem.putExtra("img_gallery_msg_svr_id", this.hHv.field_msgSvrId);
            paramAnonymousMenuItem.putExtra("img_gallery_talker", this.hHv.field_talker);
            paramAnonymousMenuItem.putExtra("img_gallery_chatroom_name", this.hHv.field_talker);
            paramAnonymousMenuItem.putExtra("img_gallery_is_restransmit_after_download", true);
            paramAnonymousMenuItem.putExtra("img_gallery_directly_send_name", (String)localObject1);
            paramAnonymousMenuItem.putExtra("start_chatting_ui", false);
            localObject1 = this.hHv.field_talker;
            Object localObject2 = new Bundle();
            if (paramBoolean) {
              paramAnonymousInt = 2;
            }
            for (;;)
            {
              ((Bundle)localObject2).putInt("stat_scene", paramAnonymousInt);
              ((Bundle)localObject2).putString("stat_msg_id", "msg_" + Long.toString(this.hHv.field_msgSvrId));
              ((Bundle)localObject2).putString("stat_chat_talker_username", (String)localObject1);
              ((Bundle)localObject2).putString("stat_send_msg_user", paramString);
              paramAnonymousMenuItem.putExtra("_stat_obj", (Bundle)localObject2);
              localObject1 = paramContext;
              paramAnonymousMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousMenuItem);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramAnonymousMenuItem.ahE(), "com/tencent/mm/ui/chatting/SendToBrandServiceHelper$3", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Context)localObject1).startActivity((Intent)paramAnonymousMenuItem.mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/SendToBrandServiceHelper$3", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(34900);
              return;
              if (x.Ao((String)localObject1)) {
                paramAnonymousInt = 7;
              }
            }
          }
        }
      }
    });
    AppMethodBeat.o(34909);
  }
  
  public static void a(bv parambv, String paramString, Context paramContext)
  {
    AppMethodBeat.i(34914);
    a(parambv, paramString, paramContext, 512);
    AppMethodBeat.o(34914);
  }
  
  private static void a(bv parambv, final String paramString, final Context paramContext, final int paramInt)
  {
    AppMethodBeat.i(34917);
    if (paramContext == null)
    {
      ae.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptMusicConnector: context is null");
      AppMethodBeat.o(34917);
      return;
    }
    if (parambv == null)
    {
      ae.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptMusicConnector: msg is null");
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
          Object localObject2 = this.hHv;
          k.b localb = k.b.zb(bu.aSA(paramString));
          if (localb == null)
          {
            ae.w("MicroMsg.LongClickBrandServiceHelper", "send: parse app msg content return null");
            switch (paramInt)
            {
            }
          }
          for (;;)
          {
            for (;;)
            {
              com.tencent.mm.ui.base.h.cm(paramContext, paramContext.getString(2131755881));
              AppMethodBeat.o(34905);
              return;
              paramAnonymousMenuItem = null;
              Object localObject1 = paramAnonymousMenuItem;
              if (((ei)localObject2).field_imgPath != null)
              {
                localObject1 = paramAnonymousMenuItem;
                if (!((ei)localObject2).field_imgPath.equals("")) {
                  localObject1 = com.tencent.mm.av.q.aIX().R(((ei)localObject2).field_imgPath, true);
                }
              }
              try
              {
                localObject1 = com.tencent.mm.vfs.o.bb((String)localObject1, 0, -1);
                localObject2 = new com.tencent.mm.pluginsdk.model.app.c();
                paramAnonymousMenuItem = (MenuItem)localObject2;
                if (!bu.isNullOrNil(localb.dlu))
                {
                  long l = bu.getLong(localb.dlu, -1L);
                  if (l == -1L) {
                    break label415;
                  }
                  ao.bJV().get(l, (com.tencent.mm.sdk.e.c)localObject2);
                  paramAnonymousMenuItem = (MenuItem)localObject2;
                  if (((com.tencent.mm.pluginsdk.model.app.c)localObject2).systemRowid != l)
                  {
                    localObject2 = ao.bJV().aMZ(localb.dlu);
                    if (localObject2 != null)
                    {
                      paramAnonymousMenuItem = (MenuItem)localObject2;
                      if (((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_mediaSvrId.equals(localb.dlu)) {}
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
                      bc.aCg();
                      localObject2 = m.aq(com.tencent.mm.model.c.azY(), localb.title, localb.hCD);
                      com.tencent.mm.vfs.o.mF(paramAnonymousMenuItem.field_fileFullPath, (String)localObject2);
                    }
                  }
                }
                paramAnonymousMenuItem = k.b.a(localb);
                paramAnonymousMenuItem.hCF = 3;
                m.a(paramAnonymousMenuItem, localb.appId, localb.appName, str2, (String)localObject2, (byte[])localObject1, null);
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  ae.e("MicroMsg.LongClickBrandServiceHelper", "send appmsg to %s, error:%s", new Object[] { str2, localException.getLocalizedMessage() });
                  MenuItem localMenuItem = paramAnonymousMenuItem;
                  continue;
                  label415:
                  localObject2 = ao.bJV().aMZ(localb.dlu);
                  if (localObject2 != null)
                  {
                    paramAnonymousMenuItem = (MenuItem)localObject2;
                    if (((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_mediaSvrId.equals(localb.dlu)) {}
                  }
                  else
                  {
                    paramAnonymousMenuItem = null;
                  }
                }
              }
            }
            com.tencent.mm.plugin.report.service.g.yxI.f(10424, new Object[] { Integer.valueOf(49), Integer.valueOf(256), str2 });
            continue;
            com.tencent.mm.plugin.report.service.g.yxI.f(10424, new Object[] { Integer.valueOf(49), Integer.valueOf(128), str2 });
            continue;
            com.tencent.mm.plugin.report.service.g.yxI.f(10424, new Object[] { Integer.valueOf(49), Integer.valueOf(512), str2 });
          }
        }
      });
      AppMethodBeat.o(34917);
      return;
      localList = ik(com.tencent.mm.al.g.aFW());
      continue;
      localList = ik(com.tencent.mm.al.g.aFU());
      continue;
      localList = ik(com.tencent.mm.al.g.aFY());
    }
  }
  
  private static void a(List<String> paramList, Context paramContext, n.e parame)
  {
    AppMethodBeat.i(34919);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ae.w("MicroMsg.LongClickBrandServiceHelper", "tryShowConnectorDialog: careList is null or empty");
      AppMethodBeat.o(34919);
      return;
    }
    l locall = new l(paramContext);
    locall.LfW = new am.11();
    locall.LfX = new am.2(paramContext);
    locall.LfS = new am.3(paramList);
    locall.LfT = parame;
    locall.fOP();
    AppMethodBeat.o(34919);
  }
  
  public static void b(bv parambv, final Context paramContext)
  {
    AppMethodBeat.i(34908);
    if (paramContext == null)
    {
      ae.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: context is null");
      AppMethodBeat.o(34908);
      return;
    }
    if (parambv == null)
    {
      ae.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: msg is null");
      AppMethodBeat.o(34908);
      return;
    }
    bc.aCg();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      t.kn(paramContext);
      ae.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: sd card not available");
      AppMethodBeat.o(34908);
      return;
    }
    a(ik(ag.aGp().oZ(2)), paramContext, new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(34899);
        paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
        if (bu.isNullOrNil(this.hHv.field_imgPath))
        {
          ae.e("MicroMsg.LongClickBrandServiceHelper", "Transfer fileName erro: fileName null");
          AppMethodBeat.o(34899);
          return;
        }
        Object localObject = com.tencent.mm.modelvoice.s.IC(this.hHv.field_imgPath);
        String str = this.hHv.field_imgPath;
        if (localObject == null) {}
        for (paramAnonymousInt = 0;; paramAnonymousInt = ((r)localObject).iAf)
        {
          localObject = com.tencent.mm.modelvoice.s.o(paramAnonymousMenuItem, str, paramAnonymousInt);
          ae.i("MicroMsg.LongClickBrandServiceHelper", "connector click[voice]: to[%s] filePath[%s]", new Object[] { paramAnonymousMenuItem, localObject });
          localObject = new com.tencent.mm.modelvoice.f((String)localObject, 1);
          bc.ajj().a((n)localObject, 0);
          com.tencent.mm.plugin.report.service.g.yxI.f(10424, new Object[] { Integer.valueOf(34), Integer.valueOf(2), paramAnonymousMenuItem });
          com.tencent.mm.ui.base.h.cm(paramContext, paramContext.getString(2131755881));
          AppMethodBeat.o(34899);
          return;
        }
      }
    });
    AppMethodBeat.o(34908);
  }
  
  public static void b(bv parambv, String paramString, Context paramContext)
  {
    AppMethodBeat.i(34915);
    a(parambv, paramString, paramContext, 256);
    AppMethodBeat.o(34915);
  }
  
  public static void c(bv parambv, final Context paramContext)
  {
    AppMethodBeat.i(34910);
    if (paramContext == null)
    {
      ae.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: context is null");
      AppMethodBeat.o(34910);
      return;
    }
    if (parambv == null)
    {
      ae.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: msg is null");
      AppMethodBeat.o(34910);
      return;
    }
    bc.aCg();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      t.kn(paramContext);
      ae.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: sd card is not available");
      AppMethodBeat.o(34910);
      return;
    }
    a(ik(ag.aGp().oZ(8)), paramContext, new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(34901);
        paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
        com.tencent.mm.modelvideo.s locals = u.Ia(this.hHv.field_imgPath);
        ae.i("MicroMsg.LongClickBrandServiceHelper", "connector click[video]: to[%s] imgPath[%s]", new Object[] { paramAnonymousMenuItem, this.hHv.field_imgPath });
        final MsgRetransmitUI.a locala = new MsgRetransmitUI.a();
        Object localObject = paramContext;
        paramContext.getResources().getString(2131755906);
        localObject = com.tencent.mm.ui.base.h.b((Context)localObject, paramContext.getResources().getString(2131755886), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            locala.LjQ = true;
          }
        });
        locala.context = paramContext;
        locala.fileName = this.hHv.field_imgPath;
        locala.tipDialog = ((Dialog)localObject);
        locala.userName = paramAnonymousMenuItem;
        locala.Ljk = locals.ixc;
        locala.hKI = locals.hKI;
        locala.execute(new Object[0]);
        cb.aCN().d(cb.hKV, null);
        com.tencent.mm.ui.base.h.cm(paramContext, paramContext.getString(2131755881));
        AppMethodBeat.o(34901);
      }
    });
    AppMethodBeat.o(34910);
  }
  
  public static void c(bv parambv, String paramString, Context paramContext)
  {
    AppMethodBeat.i(34916);
    a(parambv, paramString, paramContext, 128);
    AppMethodBeat.o(34916);
  }
  
  public static void d(bv parambv, final Context paramContext)
  {
    AppMethodBeat.i(34913);
    if (paramContext == null)
    {
      ae.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: context is null");
      AppMethodBeat.o(34913);
      return;
    }
    if (parambv == null)
    {
      ae.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: msg is null");
      AppMethodBeat.o(34913);
      return;
    }
    bc.aCg();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      t.kn(paramContext);
      ae.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: sd card is not available");
      AppMethodBeat.o(34913);
      return;
    }
    a(ik(ag.aGp().oZ(64)), paramContext, new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(34904);
        String str = paramAnonymousMenuItem.getTitle();
        paramAnonymousMenuItem = az.aVt(this.hHv.field_content).md5;
        if ((paramAnonymousMenuItem == null) || (paramAnonymousMenuItem.endsWith("-1"))) {
          paramAnonymousMenuItem = this.hHv.field_imgPath;
        }
        for (;;)
        {
          if (paramAnonymousMenuItem == null)
          {
            ae.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: filePath is null");
            AppMethodBeat.o(34904);
            return;
          }
          ae.i("MicroMsg.LongClickBrandServiceHelper", "connector click[emoji]: to[%s] filePath[%s]", new Object[] { str, paramAnonymousMenuItem });
          if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().v(paramContext, str, paramAnonymousMenuItem))
          {
            com.tencent.mm.plugin.report.service.g.yxI.f(10424, new Object[] { Integer.valueOf(47), Integer.valueOf(64), str });
            com.tencent.mm.ui.base.h.cm(paramContext, "");
          }
          com.tencent.mm.plugin.report.service.g.yxI.f(10424, new Object[] { Integer.valueOf(47), Integer.valueOf(64), str });
          com.tencent.mm.ui.base.h.cm(paramContext, paramContext.getString(2131755881));
          AppMethodBeat.o(34904);
          return;
        }
      }
    });
    AppMethodBeat.o(34913);
  }
  
  private static List<String> ik(List<String> paramList)
  {
    AppMethodBeat.i(34918);
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (!com.tencent.mm.al.g.Eq(str)) {
        localLinkedList.add(str);
      }
    }
    ae.d("MicroMsg.LongClickBrandServiceHelper", "get selected accept list, size %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    AppMethodBeat.o(34918);
    return localLinkedList;
  }
  
  public static void o(String paramString, final Context paramContext)
  {
    AppMethodBeat.i(34907);
    if (paramContext == null)
    {
      ae.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptTextConnector: context is null");
      AppMethodBeat.o(34907);
      return;
    }
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptTextConnector: content is null");
      AppMethodBeat.o(34907);
      return;
    }
    a(ik(ag.aGp().oZ(1)), paramContext, new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(34896);
        paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
        ae.i("MicroMsg.LongClickBrandServiceHelper", "connector click[text]: to[%s] text[%s]", new Object[] { paramAnonymousMenuItem, this.ion });
        o.e locale = com.tencent.mm.modelmulti.o.Gz(paramAnonymousMenuItem);
        locale.toUser = paramAnonymousMenuItem;
        locale.content = this.ion;
        locale.type = x.Bb(paramAnonymousMenuItem);
        locale.dEu = 0;
        locale.iiV = 4;
        locale.aJO().execute();
        com.tencent.mm.plugin.report.service.g.yxI.f(10424, new Object[] { Integer.valueOf(1), Integer.valueOf(1), paramAnonymousMenuItem });
        com.tencent.mm.ui.base.h.cm(paramContext, paramContext.getString(2131755881));
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
      ae.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptLocationConnector: context is null");
      AppMethodBeat.o(34911);
      return;
    }
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptLocationConnector: locationXML is null");
      AppMethodBeat.o(34911);
      return;
    }
    a(ik(ag.aGp().oZ(16)), paramContext, new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(34902);
        paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
        ae.i("MicroMsg.LongClickBrandServiceHelper", "connector click[location]: to[%s] content[%s]", new Object[] { paramAnonymousMenuItem, this.JZi });
        o.e locale = com.tencent.mm.modelmulti.o.Gz(paramAnonymousMenuItem);
        locale.toUser = paramAnonymousMenuItem;
        locale.content = this.JZi;
        locale.type = 48;
        locale.dEu = 0;
        locale.iiV = 4;
        locale.aJO().execute();
        com.tencent.mm.plugin.report.service.g.yxI.f(10424, new Object[] { Integer.valueOf(48), Integer.valueOf(16), paramAnonymousMenuItem });
        com.tencent.mm.ui.base.h.cm(paramContext, paramContext.getString(2131755881));
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
      ae.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptPersonalCardConnector: context is null");
      AppMethodBeat.o(34912);
      return;
    }
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptPersonalCardConnector: locationXML is null");
      AppMethodBeat.o(34912);
      return;
    }
    a(ik(ag.aGp().oZ(32)), paramContext, new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        int i = 66;
        AppMethodBeat.i(34903);
        paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
        ae.i("MicroMsg.LongClickBrandServiceHelper", "connector click[location]: to[%s] content[%s]", new Object[] { paramAnonymousMenuItem, this.JZj });
        bv.a locala = bv.a.aVC(this.JZj);
        Object localObject = com.tencent.mm.modelmulti.o.Gz(paramAnonymousMenuItem);
        ((o.e)localObject).toUser = paramAnonymousMenuItem;
        ((o.e)localObject).content = this.JZj;
        if (an.aUq(locala.cUA))
        {
          paramAnonymousInt = 66;
          ((o.e)localObject).type = paramAnonymousInt;
          ((o.e)localObject).dEu = 0;
          ((o.e)localObject).iiV = 4;
          ((o.e)localObject).aJO().execute();
          localObject = com.tencent.mm.plugin.report.service.g.yxI;
          if (!an.aUq(locala.cUA)) {
            break label199;
          }
        }
        label199:
        for (paramAnonymousInt = i;; paramAnonymousInt = 42)
        {
          ((com.tencent.mm.plugin.report.service.g)localObject).f(10424, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(32), paramAnonymousMenuItem });
          com.tencent.mm.ui.base.h.cm(paramContext, paramContext.getString(2131755881));
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
 * Qualified Name:     com.tencent.mm.ui.chatting.am
 * JD-Core Version:    0.7.0.1
 */