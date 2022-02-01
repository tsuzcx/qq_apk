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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.av.o;
import com.tencent.mm.g.a.dy.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
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
    protected TextView IiR;
    protected TextView IlM;
    protected ImageView IlN;
    protected View qPU;
    protected TextView qTn;
    protected ImageView sFo;
    protected ImageView sOU;
    
    public final a gh(View paramView)
    {
      AppMethodBeat.i(36965);
      super.fX(paramView);
      this.sFo = ((ImageView)paramView.findViewById(2131298047));
      this.qTn = ((TextView)paramView.findViewById(2131298044));
      this.IlM = ((TextView)paramView.findViewById(2131298036));
      this.qPU = paramView.findViewById(2131298037);
      this.IiR = ((TextView)paramView.findViewById(2131298023));
      this.xpH = ((TextView)paramView.findViewById(2131298185));
      this.IlN = ((ImageView)paramView.findViewById(2131298039));
      this.ijt = ((CheckBox)paramView.findViewById(2131298068));
      this.gGk = paramView.findViewById(2131298147);
      this.sOU = ((ImageView)paramView.findViewById(2131298076));
      AppMethodBeat.o(36965);
      return this;
    }
  }
  
  public static final class b
    extends c
  {
    private com.tencent.mm.ui.chatting.d.a HNS;
    private final long IlO = 259200000L;
    
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
        localObject = new ag(paramLayoutInflater, 2131493441);
        ((View)localObject).setTag(new r.a().gh((View)localObject));
      }
      AppMethodBeat.o(36970);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
    {
      AppMethodBeat.i(36971);
      final r.a locala = (r.a)parama;
      this.HNS = parama1;
      ((k)parama1.bf(k.class)).bE(parambo);
      parama = null;
      String str = parambo.field_content;
      paramString = str;
      if (parama1.foQ())
      {
        int i = parambo.field_content.indexOf(':');
        paramString = str;
        if (i != -1) {
          paramString = parambo.field_content.substring(i + 1);
        }
      }
      if (paramString != null) {
        parama = k.b.az(paramString, parambo.field_reserved);
      }
      com.tencent.mm.pluginsdk.model.app.g localg;
      if (parama != null)
      {
        localg = com.tencent.mm.pluginsdk.model.app.h.fA(parama.appId, parama.aBM);
        if (localg != null) {
          b(parama1, parama, parambo);
        }
        if ((localg != null) && (localg.field_appName != null) && (localg.field_appName.trim().length() > 0)) {
          break label454;
        }
        paramString = parama.appName;
        if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.h.eC(paramString))) {
          break label480;
        }
        locala.qTn.setText(com.tencent.mm.pluginsdk.model.app.h.a(parama1.HZF.getContext(), localg, paramString));
        locala.qTn.setVisibility(0);
        if ((localg == null) || (!localg.CC())) {
          break label464;
        }
        a(parama1, locala.qTn, parambo, parama, localg.field_packageName, parambo.field_msgSvrId);
        label257:
        a(parama1, locala.qTn, parama.appId);
        label270:
        if ((parama.eSb != null) && (parama.eSb.length() != 0)) {
          break label493;
        }
        locala.IiR.setVisibility(8);
        label297:
        switch (parama.type)
        {
        default: 
          label320:
          if (!parama1.foQ()) {
            if (com.tencent.mm.pluginsdk.model.app.h.k(localg))
            {
              locala.IlN.setVisibility(0);
              locala.IiR.setVisibility(8);
              c(parama1, locala.IlN, bj.a(parama, parambo));
            }
          }
          break;
        }
      }
      for (;;)
      {
        locala.nDl.setTag(new bj(parambo, parama1.foQ(), paramInt, null, '\000'));
        locala.nDl.setOnClickListener(d(parama1));
        if (this.opt)
        {
          locala.nDl.setOnLongClickListener(c(parama1));
          locala.nDl.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.i)parama1.bf(com.tencent.mm.ui.chatting.c.b.i.class)).fmb());
        }
        AppMethodBeat.o(36971);
        return;
        label454:
        paramString = localg.field_appName;
        break;
        label464:
        a(parama1, locala.qTn, parama.appId);
        break label257;
        label480:
        locala.qTn.setVisibility(8);
        break label270;
        label493:
        locala.IiR.setVisibility(0);
        b(parama1, locala.IiR, bj.aQO(parama.eSb));
        break label297;
        locala.sFo.setVisibility(0);
        com.tencent.mm.pluginsdk.model.app.c localc = ap.bEO().aGd(parama.cZa);
        str = parambo.field_imgPath;
        paramString = Boolean.FALSE;
        if (localc != null)
        {
          str = localc.field_fileFullPath;
          paramString = Boolean.TRUE;
        }
        if (o.aFx().a(locala.sFo, str, paramString.booleanValue(), com.tencent.mm.cc.a.getDensity(parama1.HZF.getContext()), parama.hhY, parama.hhX, locala.sOU, 2131231559, 1, null)) {
          break label320;
        }
        if (this.opt) {
          locala.sFo.setImageResource(2131689883);
        }
        for (;;)
        {
          locala.sFo.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36966);
              locala.sFo.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
              FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(locala.sFo.getWidth(), locala.sFo.getHeight());
              locala.sOU.setLayoutParams(localLayoutParams);
              AppMethodBeat.o(36966);
            }
          });
          break;
          locala.sFo.setImageBitmap(BitmapFactory.decodeResource(parama1.HZF.getMMResources(), 2131231559));
        }
        locala.IlN.setVisibility(8);
        continue;
        locala.IlN.setVisibility(8);
      }
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
    {
      AppMethodBeat.i(36972);
      if ((paramView == null) || (parambo == null))
      {
        AppMethodBeat.o(36972);
        return true;
      }
      int k = ((bj)paramView.getTag()).position;
      m.aGm(bi.b(this.HNS.foQ(), parambo.field_content, parambo.field_isSend));
      if (com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.k(k.b.vA(bi.b(this.HNS.foQ(), parambo.field_content, parambo.field_isSend)).appId, false, false))) {
        paramContextMenu.add(k, 111, 0, this.HNS.HZF.getMMResources().getString(2131762559));
      }
      if (com.tencent.mm.br.d.aCT("favorite")) {
        paramContextMenu.add(k, 116, 0, this.HNS.HZF.getMMResources().getString(2131761941));
      }
      Object localObject = new com.tencent.mm.g.a.dy();
      ((com.tencent.mm.g.a.dy)localObject).ddK.msgId = parambo.field_msgId;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      boolean bool = com.tencent.mm.pluginsdk.model.app.h.r(this.HNS.HZF.getContext(), 2L);
      if ((((com.tencent.mm.g.a.dy)localObject).ddL.ddj) || (bool)) {
        paramContextMenu.add(k, 129, 0, paramView.getContext().getString(2131757228));
      }
      int[] arrayOfInt;
      int j;
      int i;
      if (parambo.field_status != 5)
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
        if (bk.x(parambo)) {
          paramContextMenu.clear();
        }
        if (!this.HNS.foR()) {
          paramContextMenu.add(k, 100, 0, this.HNS.HZF.getMMResources().getString(2131757221));
        }
        AppMethodBeat.o(36972);
        return true;
        label416:
        i = 0;
        j = 0;
      }
    }
    
    public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.d.a parama, final bo parambo)
    {
      AppMethodBeat.i(36973);
      String str = parambo.field_content;
      Object localObject = null;
      if (str != null) {
        localObject = k.b.vA(str);
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
          if (((k.b)localObject).cZa != null)
          {
            paramMenuItem = str;
            if (((k.b)localObject).cZa.length() > 0)
            {
              localObject = ap.bEO().aGd(((k.b)localObject).cZa);
              paramMenuItem = str;
              if (localObject != null) {
                paramMenuItem = ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath;
              }
            }
          }
        }
        if (!parambo.fbQ()) {
          if ((System.currentTimeMillis() - parambo.field_createTime <= 259200000L) || ((!bs.isNullOrNil(paramMenuItem)) && (com.tencent.mm.vfs.i.eA(paramMenuItem)))) {
            break label237;
          }
        }
        label237:
        for (int i = 1; i != 0; i = 0)
        {
          ac.i("MicroMsg.ChattingItemAppMsgFromImg", "img is expired or clean!!!");
          com.tencent.mm.ui.base.h.d(parama.HZF.getContext(), parama.HZF.getContext().getString(2131760324), parama.HZF.getContext().getString(2131755906), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(36973);
          return false;
        }
        new ao().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36967);
            m.a(parambo, null);
            AppMethodBeat.o(36967);
          }
        });
        localObject = bk.C(parambo);
        if (bs.isNullOrNil((String)localObject))
        {
          localObject = new Intent(parama.HZF.getContext(), MsgRetransmitUI.class);
          ((Intent)localObject).putExtra("Retr_File_Name", paramMenuItem);
          ((Intent)localObject).putExtra("Retr_Msg_content", bi.b(parama.foQ(), parambo.field_content, parambo.field_isSend));
          ((Intent)localObject).putExtra("Retr_Msg_Type", 16);
          ((Intent)localObject).putExtra("Retr_Msg_Id", parambo.field_msgId);
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        for (;;)
        {
          AppMethodBeat.o(36973);
          return false;
          com.tencent.mm.plugin.report.service.h.wUl.f(17509, new Object[] { Integer.valueOf(3), localObject });
          com.tencent.mm.ui.base.h.a(parama.HZF.getContext(), 2131762971, 2131762972, 2131755928, 2131757288, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(36968);
              paramAnonymousDialogInterface = new Intent();
              paramAnonymousDialogInterface.putExtra("rawUrl", this.HXK);
              paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.DIw);
              paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.DIs);
              com.tencent.mm.br.d.b(parama.HZF.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
              com.tencent.mm.plugin.report.service.h.wUl.f(17509, new Object[] { Integer.valueOf(1), this.HXK });
              AppMethodBeat.o(36968);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(36969);
              Object localObject = new Intent(parama.HZF.getContext(), MsgRetransmitUI.class);
              ((Intent)localObject).putExtra("Retr_File_Name", paramMenuItem);
              ((Intent)localObject).putExtra("Retr_Msg_content", bi.b(parama.foQ(), parambo.field_content, parambo.field_isSend));
              ((Intent)localObject).putExtra("Retr_Msg_Type", 16);
              ((Intent)localObject).putExtra("Retr_Msg_Id", parambo.field_msgId);
              paramAnonymousDialogInterface = parama;
              localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.plugin.report.service.h.wUl.f(17509, new Object[] { Integer.valueOf(2), this.HXK });
              AppMethodBeat.o(36969);
            }
          });
        }
      }
      r.a(parama, paramMenuItem, parambo);
      AppMethodBeat.o(36973);
      return false;
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
    {
      AppMethodBeat.i(36974);
      az.ayM();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        t.g(parama.HZF.getContext(), parama.HZF.getContentView());
        AppMethodBeat.o(36974);
        return true;
      }
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).Wm(parambo.field_talker);
      Object localObject1 = null;
      Object localObject2 = bi.b(parama.foQ(), parambo.field_content, parambo.field_isSend);
      if (localObject2 != null) {
        localObject1 = k.b.vA((String)localObject2);
      }
      if (localObject1 == null)
      {
        ac.e("MicroMsg.ChattingItemAppMsgFromImg", "content is null");
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
        paramView = com.tencent.mm.pluginsdk.model.app.h.k(((k.b)localObject1).appId, true, false);
        if ((paramView != null) && (paramView.CC())) {
          a(parama, (k.b)localObject1, d(parama, parambo), paramView, parambo.field_msgSvrId, parama.getTalkerUserName());
        }
        if ((((k.b)localObject1).cZa != null) && (((k.b)localObject1).cZa.length() > 0))
        {
          paramView = ap.bEO().aGd(((k.b)localObject1).cZa);
          if ((paramView == null) || (!paramView.cOg())) {
            if (parambo.field_isSend == 0)
            {
              l1 = parambo.field_msgId;
              parama = new Intent();
              parama.setClassName(this.HNS.HZF.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
              parama.putExtra("app_msg_id", l1);
              paramView = this.HNS;
              parama = new com.tencent.mm.hellhoundlib.b.a().ba(parama);
              com.tencent.mm.hellhoundlib.a.a.a(paramView, parama.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "doGetMsgImg", "(J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramView.startActivity((Intent)parama.lR(0));
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
            if (!com.tencent.mm.vfs.i.eA(paramView))
            {
              ac.i("MicroMsg.ChattingItemAppMsgFromImg", "Img not exist, bigImgPath: %s, msgId: %d, msgSvrId: %d", new Object[] { paramView, Long.valueOf(parambo.field_msgId), Long.valueOf(parambo.field_msgSvrId) });
              paramView = new Intent();
              paramView.setClassName(parama.HZF.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
              paramView.putExtra("clean_view_type", 1);
              paramView = new com.tencent.mm.hellhoundlib.b.a().ba(paramView);
              com.tencent.mm.hellhoundlib.a.a.a(parama, paramView.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              parama.startActivity((Intent)paramView.lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(36974);
              return true;
            }
            if ((paramView != null) && (!paramView.equals("")) && (com.tencent.mm.vfs.i.eA(paramView))) {
              break;
            }
            ac.d("MicroMsg.ChattingItemAppMsgFromImg", "showImg : imgPath is null");
          }
          long l1 = parambo.field_msgId;
          long l2 = parambo.field_msgSvrId;
          parama = parambo.field_talker;
          ac.i("MicroMsg.ChattingItemAppMsgFromImg", "[ImageGalleryUI] enter");
          paramView = new Intent(this.HNS.HZF.getContext(), ImageGalleryUI.class);
          paramView.putExtra("img_gallery_msg_id", l1);
          paramView.putExtra("img_gallery_talker", parama);
          paramView.putExtra("img_gallery_left", localObject2[0]);
          paramView.putExtra("img_gallery_top", localObject2[1]);
          paramView.putExtra("img_gallery_width", j);
          paramView.putExtra("img_gallery_height", i);
          parama = this.HNS.getTalkerUserName();
          parambo = b(this.HNS, parambo);
          localObject1 = new Bundle();
          if (this.HNS.foQ()) {
            i = 2;
          }
          for (;;)
          {
            ((Bundle)localObject1).putInt("stat_scene", i);
            ((Bundle)localObject1).putString("stat_msg_id", "msg_" + Long.toString(l2));
            ((Bundle)localObject1).putString("stat_chat_talker_username", parama);
            ((Bundle)localObject1).putString("stat_send_msg_user", parambo);
            paramView.putExtra("_stat_obj", (Bundle)localObject1);
            parama = this.HNS;
            paramView = new com.tencent.mm.hellhoundlib.b.a().ba(paramView);
            com.tencent.mm.hellhoundlib.a.a.a(parama, paramView.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "showImg", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            parama.startActivity((Intent)paramView.lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "showImg", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            break;
            if (w.wH(parama)) {
              i = 7;
            } else {
              i = 1;
            }
          }
        }
        localObject2 = q.P(((k.b)localObject1).url, "message");
        PackageInfo localPackageInfo = getPackageInfo(parama.HZF.getContext(), ((k.b)localObject1).appId);
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
          a(parama, (String)localObject2, (String)localObject2, paramView, i, ((k.b)localObject1).appId, false, parambo.field_msgId, parambo.field_msgSvrId, parambo);
          break;
          paramView = localPackageInfo.versionName;
          break label925;
        }
        i = 0;
        j = 0;
      }
    }
    
    public final boolean bb(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 268435505);
    }
    
    public final boolean fqu()
    {
      return false;
    }
  }
  
  public static final class c
    extends c
    implements s.n
  {
    private com.tencent.mm.ui.chatting.d.a HNS;
    
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
        localObject = new ag(paramLayoutInflater, 2131493485);
        ((View)localObject).setTag(new r.a().gh((View)localObject));
      }
      AppMethodBeat.o(36976);
      return localObject;
    }
    
    public final void a(com.tencent.mm.ui.chatting.d.a parama, bo parambo)
    {
      AppMethodBeat.i(36981);
      if (parambo.cKN())
      {
        m.aD(parambo);
        bi.pK(parambo.field_msgId);
        parama.xg(true);
        AppMethodBeat.o(36981);
        return;
      }
      AppMethodBeat.o(36981);
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
    {
      AppMethodBeat.i(36977);
      final r.a locala = (r.a)parama;
      this.HNS = parama1;
      ((k)parama1.bf(k.class)).bE(parambo);
      parama = null;
      String str = parambo.field_content;
      if (str != null) {
        parama = k.b.az(str, parambo.field_reserved);
      }
      Object localObject;
      label198:
      label211:
      label232:
      int i;
      if (parama != null)
      {
        localObject = com.tencent.mm.pluginsdk.model.app.h.fA(parama.appId, parama.aBM);
        if ((localObject == null) || (((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName == null) || (((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName.trim().length() <= 0))
        {
          paramString = parama.appName;
          if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.h.eC(paramString))) {
            break label428;
          }
          locala.qTn.setText(com.tencent.mm.pluginsdk.model.app.h.a(parama1.HZF.getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject, paramString));
          locala.qTn.setVisibility(0);
          if ((localObject == null) || (!((com.tencent.mm.pluginsdk.model.app.g)localObject).CC())) {
            break label412;
          }
          a(parama1, locala.qTn, parambo, parama, ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_packageName, parambo.field_msgSvrId);
          a(parama1, locala.qTn, parama.appId);
        }
      }
      else
      {
        switch (parama.type)
        {
        default: 
          locala.nDl.setTag(new bj(parambo, parama1.foQ(), paramInt, null, '\000'));
          locala.nDl.setOnClickListener(d(parama1));
          if (this.opt)
          {
            locala.nDl.setOnLongClickListener(c(parama1));
            locala.nDl.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.i)parama1.bf(com.tencent.mm.ui.chatting.c.b.i.class)).fmb());
          }
          i = m.aGm(str);
          if ((i == -1) || (i >= 100) || (parama.hhF <= 0) || (parambo.field_status == 5))
          {
            locala.qPU.setVisibility(8);
            locala.sFo.setAlpha(255);
            locala.sFo.setBackgroundDrawable(null);
          }
          break;
        }
      }
      for (;;)
      {
        a(paramInt, locala, parambo, parama1.foM(), parama1.foQ(), parama1, this);
        AppMethodBeat.o(36977);
        return;
        paramString = ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName;
        break;
        label412:
        a(parama1, locala.qTn, parama.appId);
        break label198;
        label428:
        locala.qTn.setVisibility(8);
        break label211;
        locala.sFo.setVisibility(0);
        com.tencent.mm.pluginsdk.model.app.c localc = ap.bEO().aGd(parama.cZa);
        localObject = parambo.field_imgPath;
        paramString = Boolean.FALSE;
        if (localc != null)
        {
          localObject = localc.field_fileFullPath;
          paramString = Boolean.TRUE;
        }
        if (o.aFx().a(locala.sFo, (String)localObject, paramString.booleanValue(), com.tencent.mm.cc.a.getDensity(parama1.HZF.getContext()), parama.thumbWidth, parama.thumbHeight, locala.sOU, 2131231559, 0, null)) {
          break label232;
        }
        if (this.opt) {
          locala.sFo.setImageResource(2131689883);
        }
        for (;;)
        {
          locala.sFo.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36975);
              locala.sFo.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
              FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(locala.sFo.getWidth(), locala.sFo.getHeight());
              locala.sOU.setLayoutParams(localLayoutParams);
              AppMethodBeat.o(36975);
            }
          });
          break;
          locala.sFo.setImageBitmap(BitmapFactory.decodeResource(parama1.HZF.getMMResources(), 2131231559));
        }
        locala.qPU.setVisibility(0);
        locala.IlM.setText(i + "%");
        locala.sFo.setAlpha(64);
        locala.sFo.setBackgroundResource(2131233948);
      }
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
    {
      AppMethodBeat.i(36978);
      if (paramView == null)
      {
        ac.e("MicroMsg.ChattingItemAppMsgToImg", "[onCreateContextMenu] v is null");
        AppMethodBeat.o(36978);
        return false;
      }
      Object localObject = (bj)paramView.getTag();
      if (localObject == null)
      {
        ac.e("MicroMsg.ChattingItemAppMsgToImg", "[onCreateContextMenu] tag is null");
        AppMethodBeat.o(36978);
        return false;
      }
      int k = ((bj)localObject).position;
      localObject = k.b.vA(bi.b(this.HNS.foQ(), parambo.field_content, parambo.field_isSend));
      if ((localObject != null) && (com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.k(((k.b)localObject).appId, false, false)))) {
        paramContextMenu.add(k, 111, 0, this.HNS.HZF.getMMResources().getString(2131762559));
      }
      if (com.tencent.mm.br.d.aCT("favorite")) {
        paramContextMenu.add(k, 116, 0, this.HNS.HZF.getMMResources().getString(2131761941));
      }
      localObject = new com.tencent.mm.g.a.dy();
      ((com.tencent.mm.g.a.dy)localObject).ddK.msgId = parambo.field_msgId;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      boolean bool = com.tencent.mm.pluginsdk.model.app.h.r(this.HNS.HZF.getContext(), 2L);
      if ((((com.tencent.mm.g.a.dy)localObject).ddL.ddj) || (bool)) {
        paramContextMenu.add(k, 129, 0, paramView.getContext().getString(2131757228));
      }
      int[] arrayOfInt;
      int j;
      int i;
      if (parambo.field_status != 5)
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
        if ((!parambo.eZj()) && (parambo.fbG()) && ((parambo.field_status == 2) || (parambo.eSf == 1)) && (b(parambo, this.HNS)) && (aQE(parambo.field_talker))) {
          paramContextMenu.add(k, 123, 0, paramView.getContext().getString(2131757234));
        }
        if (!this.HNS.foR()) {
          paramContextMenu.add(k, 100, 0, this.HNS.HZF.getMMResources().getString(2131757221));
        }
        AppMethodBeat.o(36978);
        return true;
        label497:
        i = 0;
        j = 0;
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
    {
      Object localObject2 = null;
      AppMethodBeat.i(36979);
      Object localObject1 = parambo.field_content;
      if (localObject1 != null) {}
      for (localObject1 = k.b.vA((String)localObject1);; localObject1 = null)
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
            if (((k.b)localObject1).cZa != null)
            {
              paramMenuItem = localObject2;
              if (((k.b)localObject1).cZa.length() > 0)
              {
                localObject1 = ap.bEO().aGd(((k.b)localObject1).cZa);
                paramMenuItem = localObject2;
                if (localObject1 != null) {
                  paramMenuItem = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath;
                }
              }
            }
          }
          localObject1 = new Intent(parama.HZF.getContext(), MsgRetransmitUI.class);
          ((Intent)localObject1).putExtra("Retr_Msg_content", parambo.field_content);
          ((Intent)localObject1).putExtra("Retr_File_Name", paramMenuItem);
          ((Intent)localObject1).putExtra("Retr_Msg_Type", 16);
          ((Intent)localObject1).putExtra("Retr_Msg_Id", parambo.field_msgId);
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(36979);
          return false;
        }
        r.a(parama, paramMenuItem, parambo);
        AppMethodBeat.o(36979);
        return false;
      }
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
    {
      AppMethodBeat.i(36980);
      az.ayM();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        t.g(parama.HZF.getContext(), parama.HZF.getContentView());
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
      Object localObject2 = parambo.field_content;
      if (localObject2 != null) {
        localObject1 = k.b.vA((String)localObject2);
      }
      if (localObject1 == null)
      {
        ac.e("MicroMsg.ChattingItemAppMsgToImg", "content is null");
        AppMethodBeat.o(36980);
        return true;
      }
      localObject2 = new int[2];
      paramView.getLocationInWindow((int[])localObject2);
      int i = paramView.getWidth();
      int j = paramView.getHeight();
      paramView = com.tencent.mm.pluginsdk.model.app.h.k(((k.b)localObject1).appId, false, false);
      if (paramView != null) {
        a(parama, (k.b)localObject1, u.axw(), paramView, parambo.field_msgSvrId, parama.getTalkerUserName());
      }
      label597:
      PackageInfo localPackageInfo;
      if ((((k.b)localObject1).cZa != null) && (((k.b)localObject1).cZa.length() > 0))
      {
        paramView = ap.bEO().aGd(((k.b)localObject1).cZa);
        if (paramView != null)
        {
          az.ayM();
          if (!com.tencent.mm.model.c.isSDCardAvailable()) {
            t.g(parama.HZF.getContext(), parama.HZF.getContentView());
          }
          for (;;)
          {
            AppMethodBeat.o(36980);
            return true;
            if (parambo.field_isSend == 1)
            {
              paramView = paramView.field_fileFullPath;
              if (!com.tencent.mm.vfs.i.eA(paramView)) {
                break label597;
              }
              if ((paramView != null) && (!paramView.equals("")) && (com.tencent.mm.vfs.i.eA(paramView))) {
                break;
              }
              ac.d("MicroMsg.ChattingItemAppMsgToImg", "showImg : imgPath is null");
            }
          }
          long l1 = parambo.field_msgId;
          long l2 = parambo.field_msgSvrId;
          parama = parambo.field_talker;
          ac.i("MicroMsg.ChattingItemAppMsgToImg", "[ImageGalleryUI] enter");
          paramView = new Intent(this.HNS.HZF.getContext(), ImageGalleryUI.class);
          paramView.putExtra("img_gallery_msg_id", l1);
          paramView.putExtra("img_gallery_talker", parama);
          paramView.putExtra("img_gallery_left", localObject2[0]);
          paramView.putExtra("img_gallery_top", localObject2[1]);
          paramView.putExtra("img_gallery_width", i);
          paramView.putExtra("img_gallery_height", j);
          parama = this.HNS.getTalkerUserName();
          parambo = b(this.HNS, parambo);
          localObject1 = new Bundle();
          if (this.HNS.foQ()) {
            i = 2;
          }
          for (;;)
          {
            ((Bundle)localObject1).putInt("stat_scene", i);
            ((Bundle)localObject1).putString("stat_msg_id", "msg_" + Long.toString(l2));
            ((Bundle)localObject1).putString("stat_chat_talker_username", parama);
            ((Bundle)localObject1).putString("stat_send_msg_user", parambo);
            paramView.putExtra("_stat_obj", (Bundle)localObject1);
            parama = this.HNS;
            paramView = new com.tencent.mm.hellhoundlib.b.a().ba(paramView);
            com.tencent.mm.hellhoundlib.a.a.a(parama, paramView.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "showImg", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            parama.startActivity((Intent)paramView.lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "showImg", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            break;
            if (w.wH(parama)) {
              i = 7;
            } else {
              i = 1;
            }
          }
          ac.i("MicroMsg.ChattingItemAppMsgToImg", "onItemClick::bigImgPath: %s, msgId: %d, msgSvrId: %d", new Object[] { paramView, Long.valueOf(parambo.field_msgId), Long.valueOf(parambo.field_msgSvrId) });
          paramView = new Intent();
          paramView.setClassName(parama.HZF.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
          paramView.putExtra("clean_view_type", 1);
          paramView = new com.tencent.mm.hellhoundlib.b.a().ba(paramView);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramView.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramView.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(36980);
          return true;
        }
      }
      else if ((((k.b)localObject1).url != null) && (((k.b)localObject1).url.length() > 0))
      {
        localObject2 = q.P(((k.b)localObject1).url, "message");
        localPackageInfo = getPackageInfo(parama.HZF.getContext(), ((k.b)localObject1).appId);
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
        a(parama, (String)localObject2, (String)localObject2, paramView, i, ((k.b)localObject1).appId, false, parambo.field_msgId, parambo.field_msgSvrId, parambo);
        AppMethodBeat.o(36980);
        return false;
        paramView = localPackageInfo.versionName;
        break;
      }
    }
    
    public final boolean bb(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 268435505);
    }
    
    public final boolean fqu()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.r
 * JD-Core Version:    0.7.0.1
 */