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
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.av.i;
import com.tencent.mm.g.a.ec;
import com.tencent.mm.g.a.ec.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.vfs.o;

public final class s
{
  static final class a
    extends c.a
  {
    protected TextView KvI;
    protected TextView KyE;
    protected ImageView KyF;
    protected View rIf;
    protected TextView rLB;
    protected ImageView tMY;
    protected ImageView tWp;
    
    public final a gD(View paramView)
    {
      AppMethodBeat.i(36965);
      super.gs(paramView);
      this.tMY = ((ImageView)paramView.findViewById(2131298047));
      this.rLB = ((TextView)paramView.findViewById(2131298044));
      this.KyE = ((TextView)paramView.findViewById(2131298036));
      this.rIf = paramView.findViewById(2131298037);
      this.KvI = ((TextView)paramView.findViewById(2131298023));
      this.yUp = ((TextView)paramView.findViewById(2131298185));
      this.KyF = ((ImageView)paramView.findViewById(2131298039));
      this.iFD = ((CheckBox)paramView.findViewById(2131298068));
      this.hcH = paramView.findViewById(2131298147);
      this.tWp = ((ImageView)paramView.findViewById(2131298076));
      AppMethodBeat.o(36965);
      return this;
    }
  }
  
  public static final class b
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a JWz;
    private final long KyG = 259200000L;
    
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
        localObject = new ah(paramLayoutInflater, 2131493441);
        ((View)localObject).setTag(new s.a().gD((View)localObject));
      }
      AppMethodBeat.o(36970);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
    {
      AppMethodBeat.i(36971);
      final s.a locala = (s.a)parama;
      this.JWz = parama1;
      ((com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class)).bJ(parambv);
      parama = null;
      String str = parambv.field_content;
      paramString = str;
      if (parama1.fJC())
      {
        int i = parambv.field_content.indexOf(':');
        paramString = str;
        if (i != -1) {
          paramString = parambv.field_content.substring(i + 1);
        }
      }
      if (paramString != null) {
        parama = k.b.aB(paramString, parambv.field_reserved);
      }
      com.tencent.mm.pluginsdk.model.app.g localg;
      if (parama != null)
      {
        localg = com.tencent.mm.pluginsdk.model.app.h.gg(parama.appId, parama.aDD);
        if (localg != null) {
          b(parama1, parama, parambv);
        }
        if ((localg != null) && (localg.field_appName != null) && (localg.field_appName.trim().length() > 0)) {
          break label454;
        }
        paramString = parama.appName;
        if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.h.fD(paramString))) {
          break label480;
        }
        locala.rLB.setText(com.tencent.mm.pluginsdk.model.app.h.a(parama1.Kkd.getContext(), localg, paramString));
        locala.rLB.setVisibility(0);
        if ((localg == null) || (!localg.Ee())) {
          break label464;
        }
        a(parama1, locala.rLB, parambv, parama, localg.field_packageName, parambv.field_msgSvrId);
        label257:
        a(parama1, locala.rLB, parama.appId);
        label270:
        if ((parama.fmn != null) && (parama.fmn.length() != 0)) {
          break label493;
        }
        locala.KvI.setVisibility(8);
        label297:
        switch (parama.type)
        {
        default: 
          label320:
          if (!parama1.fJC()) {
            if (com.tencent.mm.pluginsdk.model.app.h.k(localg))
            {
              locala.KyF.setVisibility(0);
              locala.KvI.setVisibility(8);
              c(parama1, locala.KyF, bk.a(parama, parambv));
            }
          }
          break;
        }
      }
      for (;;)
      {
        locala.olI.setTag(new bk(parambv, parama1.fJC(), paramInt, null, '\000'));
        locala.olI.setOnClickListener(d(parama1));
        if (this.oZq)
        {
          locala.olI.setOnLongClickListener(c(parama1));
          locala.olI.setOnTouchListener(((k)parama1.bh(k.class)).fGw());
        }
        AppMethodBeat.o(36971);
        return;
        label454:
        paramString = localg.field_appName;
        break;
        label464:
        a(parama1, locala.rLB, parama.appId);
        break label257;
        label480:
        locala.rLB.setVisibility(8);
        break label270;
        label493:
        locala.KvI.setVisibility(0);
        b(parama1, locala.KvI, bk.aYj(parama.fmn));
        break label297;
        locala.tMY.setVisibility(0);
        com.tencent.mm.pluginsdk.model.app.c localc = ao.bJV().aMZ(parama.dlu);
        str = parambv.field_imgPath;
        paramString = Boolean.FALSE;
        if (localc != null)
        {
          str = localc.field_fileFullPath;
          paramString = Boolean.TRUE;
        }
        if (com.tencent.mm.av.q.aIX().a(locala.tMY, str, paramString.booleanValue(), com.tencent.mm.cb.a.getDensity(parama1.Kkd.getContext()), parama.hCV, parama.hCU, locala.tWp, 2131231559, 1, null)) {
          break label320;
        }
        if (this.oZq) {
          locala.tMY.setImageResource(2131689883);
        }
        for (;;)
        {
          locala.tMY.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36966);
              locala.tMY.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
              FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(locala.tMY.getWidth(), locala.tMY.getHeight());
              locala.tWp.setLayoutParams(localLayoutParams);
              AppMethodBeat.o(36966);
            }
          });
          break;
          locala.tMY.setImageBitmap(BitmapFactory.decodeResource(parama1.Kkd.getMMResources(), 2131231559));
        }
        locala.KyF.setVisibility(8);
        continue;
        locala.KyF.setVisibility(8);
      }
    }
    
    public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.e.a parama, final bv parambv)
    {
      AppMethodBeat.i(36973);
      String str = parambv.field_content;
      Object localObject = null;
      if (str != null) {
        localObject = k.b.zb(str);
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
          if (((k.b)localObject).dlu != null)
          {
            paramMenuItem = str;
            if (((k.b)localObject).dlu.length() > 0)
            {
              localObject = ao.bJV().aMZ(((k.b)localObject).dlu);
              paramMenuItem = str;
              if (localObject != null) {
                paramMenuItem = ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath;
              }
            }
          }
        }
        if (!parambv.fvU()) {
          if ((System.currentTimeMillis() - parambv.field_createTime <= 259200000L) || ((!bu.isNullOrNil(paramMenuItem)) && (o.fB(paramMenuItem)))) {
            break label237;
          }
        }
        label237:
        for (int i = 1; i != 0; i = 0)
        {
          ae.i("MicroMsg.ChattingItemAppMsgFromImg", "img is expired or clean!!!");
          com.tencent.mm.ui.base.h.d(parama.Kkd.getContext(), parama.Kkd.getContext().getString(2131760324), parama.Kkd.getContext().getString(2131755906), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(36973);
          return false;
        }
        new aq().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36967);
            com.tencent.mm.pluginsdk.model.app.m.a(parambv, null);
            AppMethodBeat.o(36967);
          }
        });
        localObject = bn.E(parambv);
        if (bu.isNullOrNil((String)localObject))
        {
          localObject = new Intent(parama.Kkd.getContext(), MsgRetransmitUI.class);
          ((Intent)localObject).putExtra("Retr_File_Name", paramMenuItem);
          ((Intent)localObject).putExtra("Retr_Msg_content", bl.b(parama.fJC(), parambv.field_content, parambv.field_isSend));
          ((Intent)localObject).putExtra("Retr_Msg_Type", 16);
          ((Intent)localObject).putExtra("Retr_Msg_Id", parambv.field_msgId);
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        for (;;)
        {
          AppMethodBeat.o(36973);
          return false;
          com.tencent.mm.plugin.report.service.g.yxI.f(17509, new Object[] { Integer.valueOf(3), localObject });
          com.tencent.mm.ui.base.h.a(parama.Kkd.getContext(), 2131762971, 2131762972, 2131755928, 2131757288, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(36968);
              paramAnonymousDialogInterface = new Intent();
              paramAnonymousDialogInterface.putExtra("rawUrl", this.KhN);
              paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FGb);
              paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.FFX);
              com.tencent.mm.br.d.b(parama.Kkd.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
              com.tencent.mm.plugin.report.service.g.yxI.f(17509, new Object[] { Integer.valueOf(1), this.KhN });
              AppMethodBeat.o(36968);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(36969);
              Object localObject = new Intent(parama.Kkd.getContext(), MsgRetransmitUI.class);
              ((Intent)localObject).putExtra("Retr_File_Name", paramMenuItem);
              ((Intent)localObject).putExtra("Retr_Msg_content", bl.b(parama.fJC(), parambv.field_content, parambv.field_isSend));
              ((Intent)localObject).putExtra("Retr_Msg_Type", 16);
              ((Intent)localObject).putExtra("Retr_Msg_Id", parambv.field_msgId);
              paramAnonymousDialogInterface = parama;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.plugin.report.service.g.yxI.f(17509, new Object[] { Integer.valueOf(2), this.KhN });
              AppMethodBeat.o(36969);
            }
          });
        }
      }
      s.a(parama, paramMenuItem, parambv);
      AppMethodBeat.o(36973);
      return false;
    }
    
    public final boolean a(l paraml, View paramView, bv parambv)
    {
      AppMethodBeat.i(187770);
      if ((paramView == null) || (parambv == null))
      {
        AppMethodBeat.o(187770);
        return true;
      }
      int k = ((bk)paramView.getTag()).position;
      com.tencent.mm.pluginsdk.model.app.m.aNi(bl.b(this.JWz.fJC(), parambv.field_content, parambv.field_isSend));
      if (com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.m(k.b.zb(bl.b(this.JWz.fJC(), parambv.field_content, parambv.field_isSend)).appId, false, false))) {
        paraml.a(k, 111, this.JWz.Kkd.getMMResources().getString(2131762559), 2131690478);
      }
      if (com.tencent.mm.br.d.aJN("favorite")) {
        paraml.a(k, 116, this.JWz.Kkd.getMMResources().getString(2131761941), 2131690400);
      }
      Object localObject;
      int[] arrayOfInt;
      int j;
      int i;
      if (parambv.field_status != 5)
      {
        localObject = paraml.a(k, 131, paramView.getContext().getString(2131757183), 2131690457);
        arrayOfInt = new int[2];
        if (paramView == null) {
          break label417;
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
        localObject = new ec();
        ((ec)localObject).dql.msgId = parambv.field_msgId;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
        boolean bool = com.tencent.mm.pluginsdk.model.app.h.s(this.JWz.Kkd.getContext(), 2L);
        if ((((ec)localObject).dqm.dpK) || (bool)) {
          paraml.a(k, 129, paramView.getContext().getString(2131757228), 2131691577);
        }
        if (bn.z(parambv)) {
          paraml.clear();
        }
        if (!this.JWz.fJD()) {
          paraml.a(k, 100, this.JWz.Kkd.getMMResources().getString(2131757221), 2131690384);
        }
        AppMethodBeat.o(187770);
        return true;
        label417:
        i = 0;
        j = 0;
      }
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      AppMethodBeat.i(36974);
      bc.aCg();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        t.g(parama.Kkd.getContext(), parama.Kkd.getContentView());
        AppMethodBeat.o(36974);
        return true;
      }
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).aaK(parambv.field_talker);
      Object localObject1 = null;
      Object localObject2 = bl.b(parama.fJC(), parambv.field_content, parambv.field_isSend);
      if (localObject2 != null) {
        localObject1 = k.b.zb((String)localObject2);
      }
      if (localObject1 == null)
      {
        ae.e("MicroMsg.ChattingItemAppMsgFromImg", "content is null");
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
        paramView = com.tencent.mm.pluginsdk.model.app.h.m(((k.b)localObject1).appId, true, false);
        if ((paramView != null) && (paramView.Ee())) {
          a(parama, (k.b)localObject1, d(parama, parambv), paramView, parambv.field_msgSvrId, parama.getTalkerUserName());
        }
        if ((((k.b)localObject1).dlu != null) && (((k.b)localObject1).dlu.length() > 0))
        {
          paramView = ao.bJV().aMZ(((k.b)localObject1).dlu);
          if ((paramView == null) || (!paramView.cZe())) {
            if (parambv.field_isSend == 0)
            {
              l1 = parambv.field_msgId;
              parama = new Intent();
              parama.setClassName(this.JWz.Kkd.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
              parama.putExtra("app_msg_id", l1);
              paramView = this.JWz;
              parama = new com.tencent.mm.hellhoundlib.b.a().bc(parama);
              com.tencent.mm.hellhoundlib.a.a.a(paramView, parama.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "doGetMsgImg", "(J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramView.startActivity((Intent)parama.mt(0));
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
            if (!o.fB(paramView))
            {
              ae.i("MicroMsg.ChattingItemAppMsgFromImg", "Img not exist, bigImgPath: %s, msgId: %d, msgSvrId: %d", new Object[] { paramView, Long.valueOf(parambv.field_msgId), Long.valueOf(parambv.field_msgSvrId) });
              paramView = new Intent();
              paramView.setClassName(parama.Kkd.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
              paramView.putExtra("clean_view_type", 1);
              paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
              com.tencent.mm.hellhoundlib.a.a.a(parama, paramView.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              parama.startActivity((Intent)paramView.mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(36974);
              return true;
            }
            if ((paramView != null) && (!paramView.equals("")) && (o.fB(paramView))) {
              break;
            }
            ae.d("MicroMsg.ChattingItemAppMsgFromImg", "showImg : imgPath is null");
          }
          long l1 = parambv.field_msgId;
          long l2 = parambv.field_msgSvrId;
          parama = parambv.field_talker;
          ae.i("MicroMsg.ChattingItemAppMsgFromImg", "[ImageGalleryUI] enter");
          paramView = new Intent(this.JWz.Kkd.getContext(), ImageGalleryUI.class);
          paramView.putExtra("img_gallery_msg_id", l1);
          paramView.putExtra("img_gallery_talker", parama);
          paramView.putExtra("img_gallery_left", localObject2[0]);
          paramView.putExtra("img_gallery_top", localObject2[1]);
          paramView.putExtra("img_gallery_width", j);
          paramView.putExtra("img_gallery_height", i);
          parama = this.JWz.getTalkerUserName();
          parambv = b(this.JWz, parambv);
          localObject1 = new Bundle();
          if (this.JWz.fJC()) {
            i = 2;
          }
          for (;;)
          {
            ((Bundle)localObject1).putInt("stat_scene", i);
            ((Bundle)localObject1).putString("stat_msg_id", "msg_" + Long.toString(l2));
            ((Bundle)localObject1).putString("stat_chat_talker_username", parama);
            ((Bundle)localObject1).putString("stat_send_msg_user", parambv);
            paramView.putExtra("_stat_obj", (Bundle)localObject1);
            parama = this.JWz;
            paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
            com.tencent.mm.hellhoundlib.a.a.a(parama, paramView.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "showImg", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            parama.startActivity((Intent)paramView.mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "showImg", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            break;
            if (x.Ao(parama)) {
              i = 7;
            } else {
              i = 1;
            }
          }
        }
        localObject2 = com.tencent.mm.pluginsdk.model.app.q.Q(((k.b)localObject1).url, "message");
        PackageInfo localPackageInfo = getPackageInfo(parama.Kkd.getContext(), ((k.b)localObject1).appId);
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
          a(parama, (String)localObject2, (String)localObject2, paramView, i, ((k.b)localObject1).appId, false, parambv.field_msgId, parambv.field_msgSvrId, parambv);
          break;
          paramView = localPackageInfo.versionName;
          break label925;
        }
        i = 0;
        j = 0;
      }
    }
    
    public final boolean br(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 268435505);
    }
    
    public final boolean fLz()
    {
      return false;
    }
  }
  
  public static final class c
    extends c
    implements t.n
  {
    private com.tencent.mm.ui.chatting.e.a JWz;
    
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
        localObject = new ah(paramLayoutInflater, 2131493485);
        ((View)localObject).setTag(new s.a().gD((View)localObject));
      }
      AppMethodBeat.o(36976);
      return localObject;
    }
    
    public final void a(com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      AppMethodBeat.i(36981);
      if (parambv.cVH())
      {
        com.tencent.mm.pluginsdk.model.app.m.aF(parambv);
        bl.rW(parambv.field_msgId);
        parama.xY(true);
        AppMethodBeat.o(36981);
        return;
      }
      AppMethodBeat.o(36981);
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
    {
      AppMethodBeat.i(36977);
      final s.a locala = (s.a)parama;
      this.JWz = parama1;
      ((com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class)).bJ(parambv);
      parama = null;
      String str = parambv.field_content;
      if (str != null) {
        parama = k.b.aB(str, parambv.field_reserved);
      }
      Object localObject;
      label198:
      label211:
      label232:
      int i;
      if (parama != null)
      {
        localObject = com.tencent.mm.pluginsdk.model.app.h.gg(parama.appId, parama.aDD);
        if ((localObject == null) || (((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName == null) || (((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName.trim().length() <= 0))
        {
          paramString = parama.appName;
          if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.h.fD(paramString))) {
            break label428;
          }
          locala.rLB.setText(com.tencent.mm.pluginsdk.model.app.h.a(parama1.Kkd.getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject, paramString));
          locala.rLB.setVisibility(0);
          if ((localObject == null) || (!((com.tencent.mm.pluginsdk.model.app.g)localObject).Ee())) {
            break label412;
          }
          a(parama1, locala.rLB, parambv, parama, ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_packageName, parambv.field_msgSvrId);
          a(parama1, locala.rLB, parama.appId);
        }
      }
      else
      {
        switch (parama.type)
        {
        default: 
          locala.olI.setTag(new bk(parambv, parama1.fJC(), paramInt, null, '\000'));
          locala.olI.setOnClickListener(d(parama1));
          if (this.oZq)
          {
            locala.olI.setOnLongClickListener(c(parama1));
            locala.olI.setOnTouchListener(((k)parama1.bh(k.class)).fGw());
          }
          i = com.tencent.mm.pluginsdk.model.app.m.aNi(str);
          if ((i == -1) || (i >= 100) || (parama.hCC <= 0) || (parambv.field_status == 5))
          {
            locala.rIf.setVisibility(8);
            locala.tMY.setAlpha(255);
            locala.tMY.setBackgroundDrawable(null);
          }
          break;
        }
      }
      for (;;)
      {
        a(paramInt, locala, parambv, parama1.fJy(), parama1.fJC(), parama1, this);
        AppMethodBeat.o(36977);
        return;
        paramString = ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName;
        break;
        label412:
        a(parama1, locala.rLB, parama.appId);
        break label198;
        label428:
        locala.rLB.setVisibility(8);
        break label211;
        locala.tMY.setVisibility(0);
        com.tencent.mm.pluginsdk.model.app.c localc = ao.bJV().aMZ(parama.dlu);
        localObject = parambv.field_imgPath;
        paramString = Boolean.FALSE;
        if (localc != null)
        {
          localObject = localc.field_fileFullPath;
          paramString = Boolean.TRUE;
        }
        if (com.tencent.mm.av.q.aIX().a(locala.tMY, (String)localObject, paramString.booleanValue(), com.tencent.mm.cb.a.getDensity(parama1.Kkd.getContext()), parama.thumbWidth, parama.thumbHeight, locala.tWp, 2131231559, 0, null)) {
          break label232;
        }
        if (this.oZq) {
          locala.tMY.setImageResource(2131689883);
        }
        for (;;)
        {
          locala.tMY.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36975);
              locala.tMY.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
              FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(locala.tMY.getWidth(), locala.tMY.getHeight());
              locala.tWp.setLayoutParams(localLayoutParams);
              AppMethodBeat.o(36975);
            }
          });
          break;
          locala.tMY.setImageBitmap(BitmapFactory.decodeResource(parama1.Kkd.getMMResources(), 2131231559));
        }
        locala.rIf.setVisibility(0);
        locala.KyE.setText(i + "%");
        locala.tMY.setAlpha(64);
        locala.tMY.setBackgroundResource(2131233948);
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      Object localObject2 = null;
      AppMethodBeat.i(36979);
      Object localObject1 = parambv.field_content;
      if (localObject1 != null) {}
      for (localObject1 = k.b.zb((String)localObject1);; localObject1 = null)
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
            if (((k.b)localObject1).dlu != null)
            {
              paramMenuItem = localObject2;
              if (((k.b)localObject1).dlu.length() > 0)
              {
                localObject1 = ao.bJV().aMZ(((k.b)localObject1).dlu);
                paramMenuItem = localObject2;
                if (localObject1 != null) {
                  paramMenuItem = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath;
                }
              }
            }
          }
          localObject1 = new Intent(parama.Kkd.getContext(), MsgRetransmitUI.class);
          ((Intent)localObject1).putExtra("Retr_Msg_content", parambv.field_content);
          ((Intent)localObject1).putExtra("Retr_File_Name", paramMenuItem);
          ((Intent)localObject1).putExtra("Retr_Msg_Type", 16);
          ((Intent)localObject1).putExtra("Retr_Msg_Id", parambv.field_msgId);
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(36979);
          return false;
        }
        s.a(parama, paramMenuItem, parambv);
        AppMethodBeat.o(36979);
        return false;
      }
    }
    
    public final boolean a(l paraml, View paramView, bv parambv)
    {
      AppMethodBeat.i(187771);
      if (paramView == null)
      {
        ae.e("MicroMsg.ChattingItemAppMsgToImg", "[onCreateContextMenu] v is null");
        AppMethodBeat.o(187771);
        return false;
      }
      Object localObject = (bk)paramView.getTag();
      if (localObject == null)
      {
        ae.e("MicroMsg.ChattingItemAppMsgToImg", "[onCreateContextMenu] tag is null");
        AppMethodBeat.o(187771);
        return false;
      }
      int k = ((bk)localObject).position;
      localObject = k.b.zb(bl.b(this.JWz.fJC(), parambv.field_content, parambv.field_isSend));
      if ((localObject != null) && (com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.m(((k.b)localObject).appId, false, false)))) {
        paraml.a(k, 111, this.JWz.Kkd.getMMResources().getString(2131762559), 2131690478);
      }
      if (com.tencent.mm.br.d.aJN("favorite")) {
        paraml.a(k, 116, this.JWz.Kkd.getMMResources().getString(2131761941), 2131690400);
      }
      int[] arrayOfInt;
      int j;
      int i;
      if (parambv.field_status != 5)
      {
        localObject = paraml.a(k, 131, paramView.getContext().getString(2131757183), 2131690457);
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
        localObject = new ec();
        ((ec)localObject).dql.msgId = parambv.field_msgId;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
        boolean bool = com.tencent.mm.pluginsdk.model.app.h.s(this.JWz.Kkd.getContext(), 2L);
        if ((((ec)localObject).dqm.dpK) || (bool)) {
          paraml.a(k, 129, paramView.getContext().getString(2131757228), 2131691577);
        }
        if ((!parambv.fta()) && (parambv.fvK()) && ((parambv.field_status == 2) || (parambv.fmr == 1)) && (b(parambv, this.JWz)) && (aYa(parambv.field_talker))) {
          paraml.a(k, 123, paramView.getContext().getString(2131757234), 2131690462);
        }
        if (!this.JWz.fJD()) {
          paraml.a(k, 100, this.JWz.Kkd.getMMResources().getString(2131757221), 2131690384);
        }
        AppMethodBeat.o(187771);
        return true;
        label497:
        i = 0;
        j = 0;
      }
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      AppMethodBeat.i(36980);
      bc.aCg();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        t.g(parama.Kkd.getContext(), parama.Kkd.getContentView());
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
      Object localObject2 = parambv.field_content;
      if (localObject2 != null) {
        localObject1 = k.b.zb((String)localObject2);
      }
      if (localObject1 == null)
      {
        ae.e("MicroMsg.ChattingItemAppMsgToImg", "content is null");
        AppMethodBeat.o(36980);
        return true;
      }
      localObject2 = new int[2];
      paramView.getLocationInWindow((int[])localObject2);
      int i = paramView.getWidth();
      int j = paramView.getHeight();
      paramView = com.tencent.mm.pluginsdk.model.app.h.m(((k.b)localObject1).appId, false, false);
      if (paramView != null) {
        a(parama, (k.b)localObject1, v.aAC(), paramView, parambv.field_msgSvrId, parama.getTalkerUserName());
      }
      label597:
      PackageInfo localPackageInfo;
      if ((((k.b)localObject1).dlu != null) && (((k.b)localObject1).dlu.length() > 0))
      {
        paramView = ao.bJV().aMZ(((k.b)localObject1).dlu);
        if (paramView != null)
        {
          bc.aCg();
          if (!com.tencent.mm.model.c.isSDCardAvailable()) {
            t.g(parama.Kkd.getContext(), parama.Kkd.getContentView());
          }
          for (;;)
          {
            AppMethodBeat.o(36980);
            return true;
            if (parambv.field_isSend == 1)
            {
              paramView = paramView.field_fileFullPath;
              if (!o.fB(paramView)) {
                break label597;
              }
              if ((paramView != null) && (!paramView.equals("")) && (o.fB(paramView))) {
                break;
              }
              ae.d("MicroMsg.ChattingItemAppMsgToImg", "showImg : imgPath is null");
            }
          }
          long l1 = parambv.field_msgId;
          long l2 = parambv.field_msgSvrId;
          parama = parambv.field_talker;
          ae.i("MicroMsg.ChattingItemAppMsgToImg", "[ImageGalleryUI] enter");
          paramView = new Intent(this.JWz.Kkd.getContext(), ImageGalleryUI.class);
          paramView.putExtra("img_gallery_msg_id", l1);
          paramView.putExtra("img_gallery_talker", parama);
          paramView.putExtra("img_gallery_left", localObject2[0]);
          paramView.putExtra("img_gallery_top", localObject2[1]);
          paramView.putExtra("img_gallery_width", i);
          paramView.putExtra("img_gallery_height", j);
          parama = this.JWz.getTalkerUserName();
          parambv = b(this.JWz, parambv);
          localObject1 = new Bundle();
          if (this.JWz.fJC()) {
            i = 2;
          }
          for (;;)
          {
            ((Bundle)localObject1).putInt("stat_scene", i);
            ((Bundle)localObject1).putString("stat_msg_id", "msg_" + Long.toString(l2));
            ((Bundle)localObject1).putString("stat_chat_talker_username", parama);
            ((Bundle)localObject1).putString("stat_send_msg_user", parambv);
            paramView.putExtra("_stat_obj", (Bundle)localObject1);
            parama = this.JWz;
            paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
            com.tencent.mm.hellhoundlib.a.a.a(parama, paramView.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "showImg", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            parama.startActivity((Intent)paramView.mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "showImg", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            break;
            if (x.Ao(parama)) {
              i = 7;
            } else {
              i = 1;
            }
          }
          ae.i("MicroMsg.ChattingItemAppMsgToImg", "onItemClick::bigImgPath: %s, msgId: %d, msgSvrId: %d", new Object[] { paramView, Long.valueOf(parambv.field_msgId), Long.valueOf(parambv.field_msgSvrId) });
          paramView = new Intent();
          paramView.setClassName(parama.Kkd.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
          paramView.putExtra("clean_view_type", 1);
          paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramView.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramView.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(36980);
          return true;
        }
      }
      else if ((((k.b)localObject1).url != null) && (((k.b)localObject1).url.length() > 0))
      {
        localObject2 = com.tencent.mm.pluginsdk.model.app.q.Q(((k.b)localObject1).url, "message");
        localPackageInfo = getPackageInfo(parama.Kkd.getContext(), ((k.b)localObject1).appId);
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
        a(parama, (String)localObject2, (String)localObject2, paramView, i, ((k.b)localObject1).appId, false, parambv.field_msgId, parambv.field_msgSvrId, parambv);
        AppMethodBeat.o(36980);
        return false;
        paramView = localPackageInfo.versionName;
        break;
      }
    }
    
    public final boolean br(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 268435505);
    }
    
    public final boolean fLz()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.s
 * JD-Core Version:    0.7.0.1
 */