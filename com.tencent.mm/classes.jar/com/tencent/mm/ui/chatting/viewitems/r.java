package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.a.dx;
import com.tencent.mm.g.a.dx.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.k;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class r
{
  static final class a
    extends c.a
  {
    protected TextView GIU;
    protected TextView GLP;
    protected ImageView GLQ;
    protected View qhs;
    protected TextView qkL;
    protected ImageView rHf;
    protected ImageView rww;
    
    public final a fU(View paramView)
    {
      AppMethodBeat.i(36965);
      super.fK(paramView);
      this.rww = ((ImageView)paramView.findViewById(2131298047));
      this.qkL = ((TextView)paramView.findViewById(2131298044));
      this.GLP = ((TextView)paramView.findViewById(2131298036));
      this.qhs = paramView.findViewById(2131298037);
      this.GIU = ((TextView)paramView.findViewById(2131298023));
      this.wet = ((TextView)paramView.findViewById(2131298185));
      this.GLQ = ((ImageView)paramView.findViewById(2131298039));
      this.hIS = ((CheckBox)paramView.findViewById(2131298068));
      this.lRB = paramView.findViewById(2131298147);
      this.rHf = ((ImageView)paramView.findViewById(2131298076));
      AppMethodBeat.o(36965);
      return this;
    }
  }
  
  public static final class b
    extends c
  {
    private final long GLR = 259200000L;
    private com.tencent.mm.ui.chatting.d.a Gob;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(36970);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new af(paramLayoutInflater, 2131493441);
        ((View)localObject).setTag(new r.a().fU((View)localObject));
      }
      AppMethodBeat.o(36970);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
    {
      AppMethodBeat.i(36971);
      final r.a locala = (r.a)parama;
      this.Gob = parama1;
      ((k)parama1.be(k.class)).bC(parambl);
      parama = null;
      String str = parambl.field_content;
      paramString = str;
      if (parama1.eZb())
      {
        int i = parambl.field_content.indexOf(':');
        paramString = str;
        if (i != -1) {
          paramString = parambl.field_content.substring(i + 1);
        }
      }
      if (paramString != null) {
        parama = k.b.ar(paramString, parambl.field_reserved);
      }
      com.tencent.mm.pluginsdk.model.app.g localg;
      if (parama != null)
      {
        localg = com.tencent.mm.pluginsdk.model.app.h.fv(parama.appId, parama.aAS);
        if (localg != null) {
          b(parama1, parama, parambl);
        }
        if ((localg != null) && (localg.field_appName != null) && (localg.field_appName.trim().length() > 0)) {
          break label454;
        }
        paramString = parama.appName;
        if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.h.eM(paramString))) {
          break label480;
        }
        locala.qkL.setText(com.tencent.mm.pluginsdk.model.app.h.a(parama1.GzJ.getContext(), localg, paramString));
        locala.qkL.setVisibility(0);
        if ((localg == null) || (!localg.CZ())) {
          break label464;
        }
        a(parama1, locala.qkL, parambl, parama, localg.field_packageName, parambl.field_msgSvrId);
        label257:
        a(parama1, locala.qkL, parama.appId);
        label270:
        if ((parama.eOT != null) && (parama.eOT.length() != 0)) {
          break label493;
        }
        locala.GIU.setVisibility(8);
        label297:
        switch (parama.type)
        {
        default: 
          label320:
          if (!parama1.eZb()) {
            if (com.tencent.mm.pluginsdk.model.app.h.k(localg))
            {
              locala.GLQ.setVisibility(0);
              locala.GIU.setVisibility(8);
              c(parama1, locala.GLQ, bi.a(parama, parambl));
            }
          }
          break;
        }
      }
      for (;;)
      {
        locala.naN.setTag(new bi(parambl, parama1.eZb(), paramInt, null, '\000'));
        locala.naN.setOnClickListener(d(parama1));
        if (this.nMt)
        {
          locala.naN.setOnLongClickListener(c(parama1));
          locala.naN.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.i)parama1.be(com.tencent.mm.ui.chatting.c.b.i.class)).eWp());
        }
        AppMethodBeat.o(36971);
        return;
        label454:
        paramString = localg.field_appName;
        break;
        label464:
        a(parama1, locala.qkL, parama.appId);
        break label257;
        label480:
        locala.qkL.setVisibility(8);
        break label270;
        label493:
        locala.GIU.setVisibility(0);
        b(parama1, locala.GIU, bi.aLk(parama.eOT));
        break label297;
        locala.rww.setVisibility(0);
        com.tencent.mm.pluginsdk.model.app.c localc = com.tencent.mm.pluginsdk.model.app.ap.bxS().aAL(parama.dbA);
        str = parambl.field_imgPath;
        paramString = Boolean.FALSE;
        if (localc != null)
        {
          str = localc.field_fileFullPath;
          paramString = Boolean.TRUE;
        }
        if (o.ayF().a(locala.rww, str, paramString.booleanValue(), com.tencent.mm.cd.a.getDensity(parama1.GzJ.getContext()), parama.gHx, parama.gHw, locala.rHf, 2131231559, 1, null)) {
          break label320;
        }
        if (this.nMt) {
          locala.rww.setImageResource(2131689883);
        }
        for (;;)
        {
          locala.rww.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36966);
              locala.rww.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
              FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(locala.rww.getWidth(), locala.rww.getHeight());
              locala.rHf.setLayoutParams(localLayoutParams);
              AppMethodBeat.o(36966);
            }
          });
          break;
          locala.rww.setImageBitmap(BitmapFactory.decodeResource(parama1.GzJ.getMMResources(), 2131231559));
        }
        locala.GLQ.setVisibility(8);
        continue;
        locala.GLQ.setVisibility(8);
      }
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
    {
      AppMethodBeat.i(36972);
      if ((paramView == null) || (parambl == null))
      {
        AppMethodBeat.o(36972);
        return true;
      }
      int k = ((bi)paramView.getTag()).position;
      m.aAU(com.tencent.mm.model.bi.b(this.Gob.eZb(), parambl.field_content, parambl.field_isSend));
      if (com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.j(k.b.rx(com.tencent.mm.model.bi.b(this.Gob.eZb(), parambl.field_content, parambl.field_isSend)).appId, false, false))) {
        paramContextMenu.add(k, 111, 0, this.Gob.GzJ.getMMResources().getString(2131762559));
      }
      if (com.tencent.mm.bs.d.axB("favorite")) {
        paramContextMenu.add(k, 116, 0, this.Gob.GzJ.getMMResources().getString(2131761941));
      }
      Object localObject = new dx();
      ((dx)localObject).dgp.msgId = parambl.field_msgId;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      boolean bool = com.tencent.mm.pluginsdk.model.app.h.q(this.Gob.GzJ.getContext(), 2L);
      if ((((dx)localObject).dgq.dfO) || (bool)) {
        paramContextMenu.add(k, 129, 0, paramView.getContext().getString(2131757228));
      }
      int[] arrayOfInt;
      int j;
      int i;
      if (parambl.field_status != 5)
      {
        localObject = paramContextMenu.add(k, 131, 0, paramView.getContext().getString(2131757183));
        arrayOfInt = new int[2];
        if (paramView == null) {
          break label416;
        }
        j = paramView.getWidth();
        i = paramView.getHeight();
        paramView.getLocationInWindow(arrayOfInt);
      }
      for (;;)
      {
        paramView = new Intent();
        paramView.putExtra("img_gallery_width", j).putExtra("img_gallery_height", i).putExtra("img_gallery_left", arrayOfInt[0]).putExtra("img_gallery_top", arrayOfInt[1]);
        ((MenuItem)localObject).setIntent(paramView);
        if (bk.x(parambl)) {
          paramContextMenu.clear();
        }
        if (!this.Gob.eZc()) {
          paramContextMenu.add(k, 100, 0, this.Gob.GzJ.getMMResources().getString(2131757221));
        }
        AppMethodBeat.o(36972);
        return true;
        label416:
        i = 0;
        j = 0;
      }
    }
    
    public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.d.a parama, final bl parambl)
    {
      AppMethodBeat.i(36973);
      String str = parambl.field_content;
      Object localObject = null;
      if (str != null) {
        localObject = k.b.rx(str);
      }
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(36973);
        return false;
      case 111: 
        str = null;
        paramMenuItem = str;
        if (localObject != null)
        {
          paramMenuItem = str;
          if (((k.b)localObject).dbA != null)
          {
            paramMenuItem = str;
            if (((k.b)localObject).dbA.length() > 0)
            {
              localObject = com.tencent.mm.pluginsdk.model.app.ap.bxS().aAL(((k.b)localObject).dbA);
              paramMenuItem = str;
              if (localObject != null) {
                paramMenuItem = ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath;
              }
            }
          }
        }
        if (!parambl.eMl()) {
          if ((System.currentTimeMillis() - parambl.field_createTime <= 259200000L) || ((!bt.isNullOrNil(paramMenuItem)) && (com.tencent.mm.vfs.i.eK(paramMenuItem)))) {
            break label237;
          }
        }
        label237:
        for (int i = 1; i != 0; i = 0)
        {
          ad.i("MicroMsg.ChattingItemAppMsgFromImg", "img is expired or clean!!!");
          com.tencent.mm.ui.base.h.d(parama.GzJ.getContext(), parama.GzJ.getContext().getString(2131760324), parama.GzJ.getContext().getString(2131755906), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(36973);
          return false;
        }
        new com.tencent.mm.sdk.platformtools.ap().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36967);
            m.a(parambl, null);
            AppMethodBeat.o(36967);
          }
        });
        localObject = bk.C(parambl);
        if (bt.isNullOrNil((String)localObject))
        {
          localObject = new Intent(parama.GzJ.getContext(), MsgRetransmitUI.class);
          ((Intent)localObject).putExtra("Retr_File_Name", paramMenuItem);
          ((Intent)localObject).putExtra("Retr_Msg_content", com.tencent.mm.model.bi.b(parama.eZb(), parambl.field_content, parambl.field_isSend));
          ((Intent)localObject).putExtra("Retr_Msg_Type", 16);
          ((Intent)localObject).putExtra("Retr_Msg_Id", parambl.field_msgId);
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        for (;;)
        {
          AppMethodBeat.o(36973);
          return false;
          com.tencent.mm.plugin.report.service.h.vKh.f(17509, new Object[] { Integer.valueOf(3), localObject });
          com.tencent.mm.ui.base.h.a(parama.GzJ.getContext(), 2131762971, 2131762972, 2131755928, 2131757288, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(36968);
              paramAnonymousDialogInterface = new Intent();
              paramAnonymousDialogInterface.putExtra("rawUrl", this.GxT);
              paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Cqe);
              paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Cqa);
              com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
              com.tencent.mm.plugin.report.service.h.vKh.f(17509, new Object[] { Integer.valueOf(1), this.GxT });
              AppMethodBeat.o(36968);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(36969);
              Object localObject = new Intent(parama.GzJ.getContext(), MsgRetransmitUI.class);
              ((Intent)localObject).putExtra("Retr_File_Name", paramMenuItem);
              ((Intent)localObject).putExtra("Retr_Msg_content", com.tencent.mm.model.bi.b(parama.eZb(), parambl.field_content, parambl.field_isSend));
              ((Intent)localObject).putExtra("Retr_Msg_Type", 16);
              ((Intent)localObject).putExtra("Retr_Msg_Id", parambl.field_msgId);
              paramAnonymousDialogInterface = parama;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.plugin.report.service.h.vKh.f(17509, new Object[] { Integer.valueOf(2), this.GxT });
              AppMethodBeat.o(36969);
            }
          });
        }
      }
      r.a(parama, paramMenuItem, parambl);
      AppMethodBeat.o(36973);
      return false;
    }
    
    public final boolean aX(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 268435505);
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
    {
      AppMethodBeat.i(36974);
      az.arV();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        t.g(parama.GzJ.getContext(), parama.GzJ.getContentView());
        AppMethodBeat.o(36974);
        return true;
      }
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).Sa(parambl.field_talker);
      Object localObject1 = null;
      Object localObject2 = com.tencent.mm.model.bi.b(parama.eZb(), parambl.field_content, parambl.field_isSend);
      if (localObject2 != null) {
        localObject1 = k.b.rx((String)localObject2);
      }
      if (localObject1 == null)
      {
        ad.e("MicroMsg.ChattingItemAppMsgFromImg", "content is null");
        AppMethodBeat.o(36974);
        return true;
      }
      localObject2 = new int[2];
      int j;
      int i;
      if (paramView != null)
      {
        paramView.getLocationInWindow((int[])localObject2);
        j = paramView.getWidth();
        i = paramView.getHeight();
      }
      for (;;)
      {
        paramView = com.tencent.mm.pluginsdk.model.app.h.j(((k.b)localObject1).appId, true, false);
        if ((paramView != null) && (paramView.CZ())) {
          a(parama, (k.b)localObject1, d(parama, parambl), paramView, parambl.field_msgSvrId, parama.getTalkerUserName());
        }
        if ((((k.b)localObject1).dbA != null) && (((k.b)localObject1).dbA.length() > 0))
        {
          paramView = com.tencent.mm.pluginsdk.model.app.ap.bxS().aAL(((k.b)localObject1).dbA);
          if ((paramView == null) || (!paramView.cAX())) {
            if (parambl.field_isSend == 0)
            {
              l1 = parambl.field_msgId;
              parama = new Intent();
              parama.setClassName(this.Gob.GzJ.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
              parama.putExtra("app_msg_id", l1);
              paramView = this.Gob;
              parama = new com.tencent.mm.hellhoundlib.b.a().bd(parama);
              com.tencent.mm.hellhoundlib.a.a.a(paramView, parama.adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "doGetMsgImg", "(J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramView.startActivity((Intent)parama.lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "doGetMsgImg", "(J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
          }
        }
        while ((((k.b)localObject1).url == null) || (((k.b)localObject1).url.length() <= 0))
        {
          for (;;)
          {
            AppMethodBeat.o(36974);
            return true;
            paramView = paramView.field_fileFullPath;
            if (!com.tencent.mm.vfs.i.eK(paramView))
            {
              ad.i("MicroMsg.ChattingItemAppMsgFromImg", "Img not exist, bigImgPath: %s, msgId: %d, msgSvrId: %d", new Object[] { paramView, Long.valueOf(parambl.field_msgId), Long.valueOf(parambl.field_msgSvrId) });
              paramView = new Intent();
              paramView.setClassName(parama.GzJ.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
              paramView.putExtra("clean_view_type", 1);
              paramView = new com.tencent.mm.hellhoundlib.b.a().bd(paramView);
              com.tencent.mm.hellhoundlib.a.a.a(parama, paramView.adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              parama.startActivity((Intent)paramView.lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(36974);
              return true;
            }
            if ((paramView != null) && (!paramView.equals("")) && (com.tencent.mm.vfs.i.eK(paramView))) {
              break;
            }
            ad.d("MicroMsg.ChattingItemAppMsgFromImg", "showImg : imgPath is null");
          }
          long l1 = parambl.field_msgId;
          long l2 = parambl.field_msgSvrId;
          parama = parambl.field_talker;
          ad.i("MicroMsg.ChattingItemAppMsgFromImg", "[ImageGalleryUI] enter");
          paramView = new Intent(this.Gob.GzJ.getContext(), ImageGalleryUI.class);
          paramView.putExtra("img_gallery_msg_id", l1);
          paramView.putExtra("img_gallery_talker", parama);
          paramView.putExtra("img_gallery_left", localObject2[0]);
          paramView.putExtra("img_gallery_top", localObject2[1]);
          paramView.putExtra("img_gallery_width", j);
          paramView.putExtra("img_gallery_height", i);
          parama = this.Gob.getTalkerUserName();
          parambl = b(this.Gob, parambl);
          localObject1 = new Bundle();
          if (this.Gob.eZb()) {
            i = 2;
          }
          for (;;)
          {
            ((Bundle)localObject1).putInt("stat_scene", i);
            ((Bundle)localObject1).putString("stat_msg_id", "msg_" + Long.toString(l2));
            ((Bundle)localObject1).putString("stat_chat_talker_username", parama);
            ((Bundle)localObject1).putString("stat_send_msg_user", parambl);
            paramView.putExtra("_stat_obj", (Bundle)localObject1);
            parama = this.Gob;
            paramView = new com.tencent.mm.hellhoundlib.b.a().bd(paramView);
            com.tencent.mm.hellhoundlib.a.a.a(parama, paramView.adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "showImg", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            parama.startActivity((Intent)paramView.lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "showImg", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            break;
            if (w.sE(parama)) {
              i = 7;
            } else {
              i = 1;
            }
          }
        }
        localObject2 = q.O(((k.b)localObject1).url, "message");
        PackageInfo localPackageInfo = getPackageInfo(parama.GzJ.getContext(), ((k.b)localObject1).appId);
        if (localPackageInfo == null)
        {
          paramView = null;
          label925:
          if (localPackageInfo != null) {
            break label972;
          }
        }
        label972:
        for (i = 0;; i = localPackageInfo.versionCode)
        {
          a(parama, (String)localObject2, (String)localObject2, paramView, i, ((k.b)localObject1).appId, false, parambl.field_msgId, parambl.field_msgSvrId, parambl);
          break;
          paramView = localPackageInfo.versionName;
          break label925;
        }
        i = 0;
        j = 0;
      }
    }
    
    public final boolean faE()
    {
      return false;
    }
  }
  
  public static final class c
    extends c
    implements s.n
  {
    private com.tencent.mm.ui.chatting.d.a Gob;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(36976);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new af(paramLayoutInflater, 2131493485);
        ((View)localObject).setTag(new r.a().fU((View)localObject));
      }
      AppMethodBeat.o(36976);
      return localObject;
    }
    
    public final void a(com.tencent.mm.ui.chatting.d.a parama, bl parambl)
    {
      AppMethodBeat.i(36981);
      if (parambl.cxB())
      {
        m.aB(parambl);
        com.tencent.mm.model.bi.lW(parambl.field_msgId);
        parama.wc(true);
        AppMethodBeat.o(36981);
        return;
      }
      AppMethodBeat.o(36981);
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
    {
      AppMethodBeat.i(36977);
      final r.a locala = (r.a)parama;
      this.Gob = parama1;
      ((k)parama1.be(k.class)).bC(parambl);
      parama = null;
      String str = parambl.field_content;
      if (str != null) {
        parama = k.b.ar(str, parambl.field_reserved);
      }
      Object localObject;
      label198:
      label211:
      label232:
      int i;
      if (parama != null)
      {
        localObject = com.tencent.mm.pluginsdk.model.app.h.fv(parama.appId, parama.aAS);
        if ((localObject == null) || (((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName == null) || (((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName.trim().length() <= 0))
        {
          paramString = parama.appName;
          if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.h.eM(paramString))) {
            break label428;
          }
          locala.qkL.setText(com.tencent.mm.pluginsdk.model.app.h.a(parama1.GzJ.getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject, paramString));
          locala.qkL.setVisibility(0);
          if ((localObject == null) || (!((com.tencent.mm.pluginsdk.model.app.g)localObject).CZ())) {
            break label412;
          }
          a(parama1, locala.qkL, parambl, parama, ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_packageName, parambl.field_msgSvrId);
          a(parama1, locala.qkL, parama.appId);
        }
      }
      else
      {
        switch (parama.type)
        {
        default: 
          locala.naN.setTag(new bi(parambl, parama1.eZb(), paramInt, null, '\000'));
          locala.naN.setOnClickListener(d(parama1));
          if (this.nMt)
          {
            locala.naN.setOnLongClickListener(c(parama1));
            locala.naN.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.i)parama1.be(com.tencent.mm.ui.chatting.c.b.i.class)).eWp());
          }
          i = m.aAU(str);
          if ((i == -1) || (i >= 100) || (parama.gHe <= 0) || (parambl.field_status == 5))
          {
            locala.qhs.setVisibility(8);
            locala.rww.setAlpha(255);
            locala.rww.setBackgroundDrawable(null);
          }
          break;
        }
      }
      for (;;)
      {
        a(paramInt, locala, parambl, parama1.eYX(), parama1.eZb(), parama1, this);
        AppMethodBeat.o(36977);
        return;
        paramString = ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName;
        break;
        label412:
        a(parama1, locala.qkL, parama.appId);
        break label198;
        label428:
        locala.qkL.setVisibility(8);
        break label211;
        locala.rww.setVisibility(0);
        com.tencent.mm.pluginsdk.model.app.c localc = com.tencent.mm.pluginsdk.model.app.ap.bxS().aAL(parama.dbA);
        localObject = parambl.field_imgPath;
        paramString = Boolean.FALSE;
        if (localc != null)
        {
          localObject = localc.field_fileFullPath;
          paramString = Boolean.TRUE;
        }
        if (o.ayF().a(locala.rww, (String)localObject, paramString.booleanValue(), com.tencent.mm.cd.a.getDensity(parama1.GzJ.getContext()), parama.thumbWidth, parama.thumbHeight, locala.rHf, 2131231559, 0, null)) {
          break label232;
        }
        if (this.nMt) {
          locala.rww.setImageResource(2131689883);
        }
        for (;;)
        {
          locala.rww.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36975);
              locala.rww.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
              FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(locala.rww.getWidth(), locala.rww.getHeight());
              locala.rHf.setLayoutParams(localLayoutParams);
              AppMethodBeat.o(36975);
            }
          });
          break;
          locala.rww.setImageBitmap(BitmapFactory.decodeResource(parama1.GzJ.getMMResources(), 2131231559));
        }
        locala.qhs.setVisibility(0);
        locala.GLP.setText(i + "%");
        locala.rww.setAlpha(64);
        locala.rww.setBackgroundResource(2131233948);
      }
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
    {
      AppMethodBeat.i(36978);
      if (paramView == null)
      {
        ad.e("MicroMsg.ChattingItemAppMsgToImg", "[onCreateContextMenu] v is null");
        AppMethodBeat.o(36978);
        return false;
      }
      Object localObject = (bi)paramView.getTag();
      if (localObject == null)
      {
        ad.e("MicroMsg.ChattingItemAppMsgToImg", "[onCreateContextMenu] tag is null");
        AppMethodBeat.o(36978);
        return false;
      }
      int k = ((bi)localObject).position;
      localObject = k.b.rx(com.tencent.mm.model.bi.b(this.Gob.eZb(), parambl.field_content, parambl.field_isSend));
      if ((localObject != null) && (com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.j(((k.b)localObject).appId, false, false)))) {
        paramContextMenu.add(k, 111, 0, this.Gob.GzJ.getMMResources().getString(2131762559));
      }
      if (com.tencent.mm.bs.d.axB("favorite")) {
        paramContextMenu.add(k, 116, 0, this.Gob.GzJ.getMMResources().getString(2131761941));
      }
      localObject = new dx();
      ((dx)localObject).dgp.msgId = parambl.field_msgId;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      boolean bool = com.tencent.mm.pluginsdk.model.app.h.q(this.Gob.GzJ.getContext(), 2L);
      if ((((dx)localObject).dgq.dfO) || (bool)) {
        paramContextMenu.add(k, 129, 0, paramView.getContext().getString(2131757228));
      }
      int[] arrayOfInt;
      int j;
      int i;
      if (parambl.field_status != 5)
      {
        localObject = paramContextMenu.add(k, 131, 0, paramView.getContext().getString(2131757183));
        arrayOfInt = new int[2];
        if (paramView == null) {
          break label497;
        }
        j = paramView.getWidth();
        i = paramView.getHeight();
        paramView.getLocationInWindow(arrayOfInt);
      }
      for (;;)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("img_gallery_width", j).putExtra("img_gallery_height", i).putExtra("img_gallery_left", arrayOfInt[0]).putExtra("img_gallery_top", arrayOfInt[1]);
        ((MenuItem)localObject).setIntent(localIntent);
        if ((!parambl.eJL()) && (parambl.eMb()) && ((parambl.field_status == 2) || (parambl.eOX == 1)) && (b(parambl, this.Gob)) && (aKZ(parambl.field_talker))) {
          paramContextMenu.add(k, 123, 0, paramView.getContext().getString(2131757234));
        }
        if (!this.Gob.eZc()) {
          paramContextMenu.add(k, 100, 0, this.Gob.GzJ.getMMResources().getString(2131757221));
        }
        AppMethodBeat.o(36978);
        return true;
        label497:
        i = 0;
        j = 0;
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
    {
      Object localObject2 = null;
      AppMethodBeat.i(36979);
      Object localObject1 = parambl.field_content;
      if (localObject1 != null) {}
      for (localObject1 = k.b.rx((String)localObject1);; localObject1 = null)
      {
        switch (paramMenuItem.getItemId())
        {
        default: 
          AppMethodBeat.o(36979);
          return false;
        case 111: 
          paramMenuItem = localObject2;
          if (localObject1 != null)
          {
            paramMenuItem = localObject2;
            if (((k.b)localObject1).dbA != null)
            {
              paramMenuItem = localObject2;
              if (((k.b)localObject1).dbA.length() > 0)
              {
                localObject1 = com.tencent.mm.pluginsdk.model.app.ap.bxS().aAL(((k.b)localObject1).dbA);
                paramMenuItem = localObject2;
                if (localObject1 != null) {
                  paramMenuItem = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath;
                }
              }
            }
          }
          localObject1 = new Intent(parama.GzJ.getContext(), MsgRetransmitUI.class);
          ((Intent)localObject1).putExtra("Retr_Msg_content", parambl.field_content);
          ((Intent)localObject1).putExtra("Retr_File_Name", paramMenuItem);
          ((Intent)localObject1).putExtra("Retr_Msg_Type", 16);
          ((Intent)localObject1).putExtra("Retr_Msg_Id", parambl.field_msgId);
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(36979);
          return false;
        }
        r.a(parama, paramMenuItem, parambl);
        AppMethodBeat.o(36979);
        return false;
      }
    }
    
    public final boolean aX(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 268435505);
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
    {
      AppMethodBeat.i(36980);
      az.arV();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        t.g(parama.GzJ.getContext(), parama.GzJ.getContentView());
        AppMethodBeat.o(36980);
        return true;
      }
      if (paramView == null)
      {
        AppMethodBeat.o(36980);
        return true;
      }
      paramView.getTag();
      Object localObject1 = null;
      Object localObject2 = parambl.field_content;
      if (localObject2 != null) {
        localObject1 = k.b.rx((String)localObject2);
      }
      if (localObject1 == null)
      {
        ad.e("MicroMsg.ChattingItemAppMsgToImg", "content is null");
        AppMethodBeat.o(36980);
        return true;
      }
      localObject2 = new int[2];
      paramView.getLocationInWindow((int[])localObject2);
      int i = paramView.getWidth();
      int j = paramView.getHeight();
      paramView = com.tencent.mm.pluginsdk.model.app.h.j(((k.b)localObject1).appId, false, false);
      if (paramView != null) {
        a(parama, (k.b)localObject1, u.aqG(), paramView, parambl.field_msgSvrId, parama.getTalkerUserName());
      }
      label597:
      PackageInfo localPackageInfo;
      if ((((k.b)localObject1).dbA != null) && (((k.b)localObject1).dbA.length() > 0))
      {
        paramView = com.tencent.mm.pluginsdk.model.app.ap.bxS().aAL(((k.b)localObject1).dbA);
        if (paramView != null)
        {
          az.arV();
          if (!com.tencent.mm.model.c.isSDCardAvailable()) {
            t.g(parama.GzJ.getContext(), parama.GzJ.getContentView());
          }
          for (;;)
          {
            AppMethodBeat.o(36980);
            return true;
            if (parambl.field_isSend == 1)
            {
              paramView = paramView.field_fileFullPath;
              if (!com.tencent.mm.vfs.i.eK(paramView)) {
                break label597;
              }
              if ((paramView != null) && (!paramView.equals("")) && (com.tencent.mm.vfs.i.eK(paramView))) {
                break;
              }
              ad.d("MicroMsg.ChattingItemAppMsgToImg", "showImg : imgPath is null");
            }
          }
          long l1 = parambl.field_msgId;
          long l2 = parambl.field_msgSvrId;
          parama = parambl.field_talker;
          ad.i("MicroMsg.ChattingItemAppMsgToImg", "[ImageGalleryUI] enter");
          paramView = new Intent(this.Gob.GzJ.getContext(), ImageGalleryUI.class);
          paramView.putExtra("img_gallery_msg_id", l1);
          paramView.putExtra("img_gallery_talker", parama);
          paramView.putExtra("img_gallery_left", localObject2[0]);
          paramView.putExtra("img_gallery_top", localObject2[1]);
          paramView.putExtra("img_gallery_width", i);
          paramView.putExtra("img_gallery_height", j);
          parama = this.Gob.getTalkerUserName();
          parambl = b(this.Gob, parambl);
          localObject1 = new Bundle();
          if (this.Gob.eZb()) {
            i = 2;
          }
          for (;;)
          {
            ((Bundle)localObject1).putInt("stat_scene", i);
            ((Bundle)localObject1).putString("stat_msg_id", "msg_" + Long.toString(l2));
            ((Bundle)localObject1).putString("stat_chat_talker_username", parama);
            ((Bundle)localObject1).putString("stat_send_msg_user", parambl);
            paramView.putExtra("_stat_obj", (Bundle)localObject1);
            parama = this.Gob;
            paramView = new com.tencent.mm.hellhoundlib.b.a().bd(paramView);
            com.tencent.mm.hellhoundlib.a.a.a(parama, paramView.adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "showImg", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            parama.startActivity((Intent)paramView.lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "showImg", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            break;
            if (w.sE(parama)) {
              i = 7;
            } else {
              i = 1;
            }
          }
          ad.i("MicroMsg.ChattingItemAppMsgToImg", "onItemClick::bigImgPath: %s, msgId: %d, msgSvrId: %d", new Object[] { paramView, Long.valueOf(parambl.field_msgId), Long.valueOf(parambl.field_msgSvrId) });
          paramView = new Intent();
          paramView.setClassName(parama.GzJ.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
          paramView.putExtra("clean_view_type", 1);
          paramView = new com.tencent.mm.hellhoundlib.b.a().bd(paramView);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramView.adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramView.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(36980);
          return true;
        }
      }
      else if ((((k.b)localObject1).url != null) && (((k.b)localObject1).url.length() > 0))
      {
        localObject2 = q.O(((k.b)localObject1).url, "message");
        localPackageInfo = getPackageInfo(parama.GzJ.getContext(), ((k.b)localObject1).appId);
        if (localPackageInfo != null) {
          break label845;
        }
        paramView = null;
        if (localPackageInfo != null) {
          break label854;
        }
      }
      label845:
      label854:
      for (i = 0;; i = localPackageInfo.versionCode)
      {
        a(parama, (String)localObject2, (String)localObject2, paramView, i, ((k.b)localObject1).appId, false, parambl.field_msgId, parambl.field_msgSvrId, parambl);
        AppMethodBeat.o(36980);
        return false;
        paramView = localPackageInfo.versionName;
        break;
      }
    }
    
    public final boolean faE()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.r
 * JD-Core Version:    0.7.0.1
 */