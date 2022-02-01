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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.a.eb;
import com.tencent.mm.g.a.eb.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class s
{
  static final class a
    extends c.a
  {
    protected TextView JZp;
    protected TextView Kcm;
    protected ImageView Kcn;
    protected TextView rDq;
    protected View rzU;
    protected ImageView tCh;
    protected ImageView tLy;
    
    public final a gy(View paramView)
    {
      AppMethodBeat.i(36965);
      super.gn(paramView);
      this.tCh = ((ImageView)paramView.findViewById(2131298047));
      this.rDq = ((TextView)paramView.findViewById(2131298044));
      this.Kcm = ((TextView)paramView.findViewById(2131298036));
      this.rzU = paramView.findViewById(2131298037);
      this.JZp = ((TextView)paramView.findViewById(2131298023));
      this.yEk = ((TextView)paramView.findViewById(2131298185));
      this.Kcn = ((ImageView)paramView.findViewById(2131298039));
      this.iCK = ((CheckBox)paramView.findViewById(2131298068));
      this.gZU = paramView.findViewById(2131298147);
      this.tLy = ((ImageView)paramView.findViewById(2131298076));
      AppMethodBeat.o(36965);
      return this;
    }
  }
  
  public static final class b
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a JBI;
    private final long Kco = 259200000L;
    
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
        ((View)localObject).setTag(new s.a().gy((View)localObject));
      }
      AppMethodBeat.o(36970);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
    {
      AppMethodBeat.i(36971);
      final s.a locala = (s.a)parama;
      this.JBI = parama1;
      ((com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class)).bK(parambu);
      parama = null;
      String str = parambu.field_content;
      paramString = str;
      if (parama1.fFv())
      {
        int i = parambu.field_content.indexOf(':');
        paramString = str;
        if (i != -1) {
          paramString = parambu.field_content.substring(i + 1);
        }
      }
      if (paramString != null) {
        parama = k.b.aA(paramString, parambu.field_reserved);
      }
      com.tencent.mm.pluginsdk.model.app.g localg;
      if (parama != null)
      {
        localg = com.tencent.mm.pluginsdk.model.app.h.fX(parama.appId, parama.aDD);
        if (localg != null) {
          b(parama1, parama, parambu);
        }
        if ((localg != null) && (localg.field_appName != null) && (localg.field_appName.trim().length() > 0)) {
          break label454;
        }
        paramString = parama.appName;
        if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.h.fx(paramString))) {
          break label480;
        }
        locala.rDq.setText(com.tencent.mm.pluginsdk.model.app.h.a(parama1.JOR.getContext(), localg, paramString));
        locala.rDq.setVisibility(0);
        if ((localg == null) || (!localg.Eb())) {
          break label464;
        }
        a(parama1, locala.rDq, parambu, parama, localg.field_packageName, parambu.field_msgSvrId);
        label257:
        a(parama1, locala.rDq, parama.appId);
        label270:
        if ((parama.fkq != null) && (parama.fkq.length() != 0)) {
          break label493;
        }
        locala.JZp.setVisibility(8);
        label297:
        switch (parama.type)
        {
        default: 
          label320:
          if (!parama1.fFv()) {
            if (com.tencent.mm.pluginsdk.model.app.h.k(localg))
            {
              locala.Kcn.setVisibility(0);
              locala.JZp.setVisibility(8);
              c(parama1, locala.Kcn, bk.a(parama, parambu));
            }
          }
          break;
        }
      }
      for (;;)
      {
        locala.ofK.setTag(new bk(parambu, parama1.fFv(), paramInt, null, '\000'));
        locala.ofK.setOnClickListener(d(parama1));
        if (this.oSO)
        {
          locala.ofK.setOnLongClickListener(c(parama1));
          locala.ofK.setOnTouchListener(((k)parama1.bh(k.class)).fCu());
        }
        AppMethodBeat.o(36971);
        return;
        label454:
        paramString = localg.field_appName;
        break;
        label464:
        a(parama1, locala.rDq, parama.appId);
        break label257;
        label480:
        locala.rDq.setVisibility(8);
        break label270;
        label493:
        locala.JZp.setVisibility(0);
        b(parama1, locala.JZp, bk.aWI(parama.fkq));
        break label297;
        locala.tCh.setVisibility(0);
        com.tencent.mm.pluginsdk.model.app.c localc = ao.bIX().aLD(parama.dks);
        str = parambu.field_imgPath;
        paramString = Boolean.FALSE;
        if (localc != null)
        {
          str = localc.field_fileFullPath;
          paramString = Boolean.TRUE;
        }
        if (com.tencent.mm.aw.q.aIF().a(locala.tCh, str, paramString.booleanValue(), com.tencent.mm.cc.a.getDensity(parama1.JOR.getContext()), parama.hAh, parama.hAg, locala.tLy, 2131231559, 1, null)) {
          break label320;
        }
        if (this.oSO) {
          locala.tCh.setImageResource(2131689883);
        }
        for (;;)
        {
          locala.tCh.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36966);
              locala.tCh.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
              FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(locala.tCh.getWidth(), locala.tCh.getHeight());
              locala.tLy.setLayoutParams(localLayoutParams);
              AppMethodBeat.o(36966);
            }
          });
          break;
          locala.tCh.setImageBitmap(BitmapFactory.decodeResource(parama1.JOR.getMMResources(), 2131231559));
        }
        locala.Kcn.setVisibility(8);
        continue;
        locala.Kcn.setVisibility(8);
      }
    }
    
    public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.e.a parama, final bu parambu)
    {
      AppMethodBeat.i(36973);
      String str = parambu.field_content;
      Object localObject = null;
      if (str != null) {
        localObject = k.b.yr(str);
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
          if (((k.b)localObject).dks != null)
          {
            paramMenuItem = str;
            if (((k.b)localObject).dks.length() > 0)
            {
              localObject = ao.bIX().aLD(((k.b)localObject).dks);
              paramMenuItem = str;
              if (localObject != null) {
                paramMenuItem = ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath;
              }
            }
          }
        }
        if (!parambu.frT()) {
          if ((System.currentTimeMillis() - parambu.field_createTime <= 259200000L) || ((!bt.isNullOrNil(paramMenuItem)) && (com.tencent.mm.vfs.i.fv(paramMenuItem)))) {
            break label237;
          }
        }
        label237:
        for (int i = 1; i != 0; i = 0)
        {
          ad.i("MicroMsg.ChattingItemAppMsgFromImg", "img is expired or clean!!!");
          com.tencent.mm.ui.base.h.d(parama.JOR.getContext(), parama.JOR.getContext().getString(2131760324), parama.JOR.getContext().getString(2131755906), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(36973);
          return false;
        }
        new ap().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36967);
            com.tencent.mm.pluginsdk.model.app.m.a(parambu, null);
            AppMethodBeat.o(36967);
          }
        });
        localObject = bl.E(parambu);
        if (bt.isNullOrNil((String)localObject))
        {
          localObject = new Intent(parama.JOR.getContext(), MsgRetransmitUI.class);
          ((Intent)localObject).putExtra("Retr_File_Name", paramMenuItem);
          ((Intent)localObject).putExtra("Retr_Msg_content", bj.b(parama.fFv(), parambu.field_content, parambu.field_isSend));
          ((Intent)localObject).putExtra("Retr_Msg_Type", 16);
          ((Intent)localObject).putExtra("Retr_Msg_Id", parambu.field_msgId);
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        for (;;)
        {
          AppMethodBeat.o(36973);
          return false;
          com.tencent.mm.plugin.report.service.g.yhR.f(17509, new Object[] { Integer.valueOf(3), localObject });
          com.tencent.mm.ui.base.h.a(parama.JOR.getContext(), 2131762971, 2131762972, 2131755928, 2131757288, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(36968);
              paramAnonymousDialogInterface = new Intent();
              paramAnonymousDialogInterface.putExtra("rawUrl", this.JMQ);
              paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FnD);
              paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Fnz);
              com.tencent.mm.bs.d.b(parama.JOR.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
              com.tencent.mm.plugin.report.service.g.yhR.f(17509, new Object[] { Integer.valueOf(1), this.JMQ });
              AppMethodBeat.o(36968);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(36969);
              Object localObject = new Intent(parama.JOR.getContext(), MsgRetransmitUI.class);
              ((Intent)localObject).putExtra("Retr_File_Name", paramMenuItem);
              ((Intent)localObject).putExtra("Retr_Msg_content", bj.b(parama.fFv(), parambu.field_content, parambu.field_isSend));
              ((Intent)localObject).putExtra("Retr_Msg_Type", 16);
              ((Intent)localObject).putExtra("Retr_Msg_Id", parambu.field_msgId);
              paramAnonymousDialogInterface = parama;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.plugin.report.service.g.yhR.f(17509, new Object[] { Integer.valueOf(2), this.JMQ });
              AppMethodBeat.o(36969);
            }
          });
        }
      }
      s.a(parama, paramMenuItem, parambu);
      AppMethodBeat.o(36973);
      return false;
    }
    
    public final boolean a(l paraml, View paramView, bu parambu)
    {
      AppMethodBeat.i(194375);
      if ((paramView == null) || (parambu == null))
      {
        AppMethodBeat.o(194375);
        return true;
      }
      int k = ((bk)paramView.getTag()).position;
      com.tencent.mm.pluginsdk.model.app.m.aLM(bj.b(this.JBI.fFv(), parambu.field_content, parambu.field_isSend));
      if (com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.m(k.b.yr(bj.b(this.JBI.fFv(), parambu.field_content, parambu.field_isSend)).appId, false, false))) {
        paraml.a(k, 111, this.JBI.JOR.getMMResources().getString(2131762559), 2131690478);
      }
      if (com.tencent.mm.bs.d.aIu("favorite")) {
        paraml.a(k, 116, this.JBI.JOR.getMMResources().getString(2131761941), 2131690400);
      }
      Object localObject;
      int[] arrayOfInt;
      int j;
      int i;
      if (parambu.field_status != 5)
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
        localObject = new eb();
        ((eb)localObject).dpg.msgId = parambu.field_msgId;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
        boolean bool = com.tencent.mm.pluginsdk.model.app.h.r(this.JBI.JOR.getContext(), 2L);
        if ((((eb)localObject).dph.doF) || (bool)) {
          paraml.a(k, 129, paramView.getContext().getString(2131757228), 2131691577);
        }
        if (bl.z(parambu)) {
          paraml.clear();
        }
        if (!this.JBI.fFw()) {
          paraml.a(k, 100, this.JBI.JOR.getMMResources().getString(2131757221), 2131690384);
        }
        AppMethodBeat.o(194375);
        return true;
        label417:
        i = 0;
        j = 0;
      }
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      AppMethodBeat.i(36974);
      ba.aBQ();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        t.g(parama.JOR.getContext(), parama.JOR.getContentView());
        AppMethodBeat.o(36974);
        return true;
      }
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).ZT(parambu.field_talker);
      Object localObject1 = null;
      Object localObject2 = bj.b(parama.fFv(), parambu.field_content, parambu.field_isSend);
      if (localObject2 != null) {
        localObject1 = k.b.yr((String)localObject2);
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
        paramView = com.tencent.mm.pluginsdk.model.app.h.m(((k.b)localObject1).appId, true, false);
        if ((paramView != null) && (paramView.Eb())) {
          a(parama, (k.b)localObject1, d(parama, parambu), paramView, parambu.field_msgSvrId, parama.getTalkerUserName());
        }
        if ((((k.b)localObject1).dks != null) && (((k.b)localObject1).dks.length() > 0))
        {
          paramView = ao.bIX().aLD(((k.b)localObject1).dks);
          if ((paramView == null) || (!paramView.cWz())) {
            if (parambu.field_isSend == 0)
            {
              l1 = parambu.field_msgId;
              parama = new Intent();
              parama.setClassName(this.JBI.JOR.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
              parama.putExtra("app_msg_id", l1);
              paramView = this.JBI;
              parama = new com.tencent.mm.hellhoundlib.b.a().bc(parama);
              com.tencent.mm.hellhoundlib.a.a.a(paramView, parama.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "doGetMsgImg", "(J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramView.startActivity((Intent)parama.mq(0));
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
            if (!com.tencent.mm.vfs.i.fv(paramView))
            {
              ad.i("MicroMsg.ChattingItemAppMsgFromImg", "Img not exist, bigImgPath: %s, msgId: %d, msgSvrId: %d", new Object[] { paramView, Long.valueOf(parambu.field_msgId), Long.valueOf(parambu.field_msgSvrId) });
              paramView = new Intent();
              paramView.setClassName(parama.JOR.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
              paramView.putExtra("clean_view_type", 1);
              paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
              com.tencent.mm.hellhoundlib.a.a.a(parama, paramView.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              parama.startActivity((Intent)paramView.mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(36974);
              return true;
            }
            if ((paramView != null) && (!paramView.equals("")) && (com.tencent.mm.vfs.i.fv(paramView))) {
              break;
            }
            ad.d("MicroMsg.ChattingItemAppMsgFromImg", "showImg : imgPath is null");
          }
          long l1 = parambu.field_msgId;
          long l2 = parambu.field_msgSvrId;
          parama = parambu.field_talker;
          ad.i("MicroMsg.ChattingItemAppMsgFromImg", "[ImageGalleryUI] enter");
          paramView = new Intent(this.JBI.JOR.getContext(), ImageGalleryUI.class);
          paramView.putExtra("img_gallery_msg_id", l1);
          paramView.putExtra("img_gallery_talker", parama);
          paramView.putExtra("img_gallery_left", localObject2[0]);
          paramView.putExtra("img_gallery_top", localObject2[1]);
          paramView.putExtra("img_gallery_width", j);
          paramView.putExtra("img_gallery_height", i);
          parama = this.JBI.getTalkerUserName();
          parambu = b(this.JBI, parambu);
          localObject1 = new Bundle();
          if (this.JBI.fFv()) {
            i = 2;
          }
          for (;;)
          {
            ((Bundle)localObject1).putInt("stat_scene", i);
            ((Bundle)localObject1).putString("stat_msg_id", "msg_" + Long.toString(l2));
            ((Bundle)localObject1).putString("stat_chat_talker_username", parama);
            ((Bundle)localObject1).putString("stat_send_msg_user", parambu);
            paramView.putExtra("_stat_obj", (Bundle)localObject1);
            parama = this.JBI;
            paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
            com.tencent.mm.hellhoundlib.a.a.a(parama, paramView.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "showImg", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            parama.startActivity((Intent)paramView.mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "showImg", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            break;
            if (w.zE(parama)) {
              i = 7;
            } else {
              i = 1;
            }
          }
        }
        localObject2 = com.tencent.mm.pluginsdk.model.app.q.Q(((k.b)localObject1).url, "message");
        PackageInfo localPackageInfo = getPackageInfo(parama.JOR.getContext(), ((k.b)localObject1).appId);
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
          a(parama, (String)localObject2, (String)localObject2, paramView, i, ((k.b)localObject1).appId, false, parambu.field_msgId, parambu.field_msgSvrId, parambu);
          break;
          paramView = localPackageInfo.versionName;
          break label925;
        }
        i = 0;
        j = 0;
      }
    }
    
    public final boolean bi(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 268435505);
    }
    
    public final boolean fHh()
    {
      return false;
    }
  }
  
  public static final class c
    extends c
    implements s.n
  {
    private com.tencent.mm.ui.chatting.e.a JBI;
    
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
        ((View)localObject).setTag(new s.a().gy((View)localObject));
      }
      AppMethodBeat.o(36976);
      return localObject;
    }
    
    public final void a(com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      AppMethodBeat.i(36981);
      if (parambu.cTc())
      {
        com.tencent.mm.pluginsdk.model.app.m.aG(parambu);
        bj.rJ(parambu.field_msgId);
        parama.xR(true);
        AppMethodBeat.o(36981);
        return;
      }
      AppMethodBeat.o(36981);
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
    {
      AppMethodBeat.i(36977);
      final s.a locala = (s.a)parama;
      this.JBI = parama1;
      ((com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class)).bK(parambu);
      parama = null;
      String str = parambu.field_content;
      if (str != null) {
        parama = k.b.aA(str, parambu.field_reserved);
      }
      Object localObject;
      label198:
      label211:
      label232:
      int i;
      if (parama != null)
      {
        localObject = com.tencent.mm.pluginsdk.model.app.h.fX(parama.appId, parama.aDD);
        if ((localObject == null) || (((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName == null) || (((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName.trim().length() <= 0))
        {
          paramString = parama.appName;
          if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.h.fx(paramString))) {
            break label428;
          }
          locala.rDq.setText(com.tencent.mm.pluginsdk.model.app.h.a(parama1.JOR.getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject, paramString));
          locala.rDq.setVisibility(0);
          if ((localObject == null) || (!((com.tencent.mm.pluginsdk.model.app.g)localObject).Eb())) {
            break label412;
          }
          a(parama1, locala.rDq, parambu, parama, ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_packageName, parambu.field_msgSvrId);
          a(parama1, locala.rDq, parama.appId);
        }
      }
      else
      {
        switch (parama.type)
        {
        default: 
          locala.ofK.setTag(new bk(parambu, parama1.fFv(), paramInt, null, '\000'));
          locala.ofK.setOnClickListener(d(parama1));
          if (this.oSO)
          {
            locala.ofK.setOnLongClickListener(c(parama1));
            locala.ofK.setOnTouchListener(((k)parama1.bh(k.class)).fCu());
          }
          i = com.tencent.mm.pluginsdk.model.app.m.aLM(str);
          if ((i == -1) || (i >= 100) || (parama.hzO <= 0) || (parambu.field_status == 5))
          {
            locala.rzU.setVisibility(8);
            locala.tCh.setAlpha(255);
            locala.tCh.setBackgroundDrawable(null);
          }
          break;
        }
      }
      for (;;)
      {
        a(paramInt, locala, parambu, parama1.fFr(), parama1.fFv(), parama1, this);
        AppMethodBeat.o(36977);
        return;
        paramString = ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName;
        break;
        label412:
        a(parama1, locala.rDq, parama.appId);
        break label198;
        label428:
        locala.rDq.setVisibility(8);
        break label211;
        locala.tCh.setVisibility(0);
        com.tencent.mm.pluginsdk.model.app.c localc = ao.bIX().aLD(parama.dks);
        localObject = parambu.field_imgPath;
        paramString = Boolean.FALSE;
        if (localc != null)
        {
          localObject = localc.field_fileFullPath;
          paramString = Boolean.TRUE;
        }
        if (com.tencent.mm.aw.q.aIF().a(locala.tCh, (String)localObject, paramString.booleanValue(), com.tencent.mm.cc.a.getDensity(parama1.JOR.getContext()), parama.thumbWidth, parama.thumbHeight, locala.tLy, 2131231559, 0, null)) {
          break label232;
        }
        if (this.oSO) {
          locala.tCh.setImageResource(2131689883);
        }
        for (;;)
        {
          locala.tCh.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36975);
              locala.tCh.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
              FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(locala.tCh.getWidth(), locala.tCh.getHeight());
              locala.tLy.setLayoutParams(localLayoutParams);
              AppMethodBeat.o(36975);
            }
          });
          break;
          locala.tCh.setImageBitmap(BitmapFactory.decodeResource(parama1.JOR.getMMResources(), 2131231559));
        }
        locala.rzU.setVisibility(0);
        locala.Kcm.setText(i + "%");
        locala.tCh.setAlpha(64);
        locala.tCh.setBackgroundResource(2131233948);
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      Object localObject2 = null;
      AppMethodBeat.i(36979);
      Object localObject1 = parambu.field_content;
      if (localObject1 != null) {}
      for (localObject1 = k.b.yr((String)localObject1);; localObject1 = null)
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
            if (((k.b)localObject1).dks != null)
            {
              paramMenuItem = localObject2;
              if (((k.b)localObject1).dks.length() > 0)
              {
                localObject1 = ao.bIX().aLD(((k.b)localObject1).dks);
                paramMenuItem = localObject2;
                if (localObject1 != null) {
                  paramMenuItem = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath;
                }
              }
            }
          }
          localObject1 = new Intent(parama.JOR.getContext(), MsgRetransmitUI.class);
          ((Intent)localObject1).putExtra("Retr_Msg_content", parambu.field_content);
          ((Intent)localObject1).putExtra("Retr_File_Name", paramMenuItem);
          ((Intent)localObject1).putExtra("Retr_Msg_Type", 16);
          ((Intent)localObject1).putExtra("Retr_Msg_Id", parambu.field_msgId);
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(36979);
          return false;
        }
        s.a(parama, paramMenuItem, parambu);
        AppMethodBeat.o(36979);
        return false;
      }
    }
    
    public final boolean a(l paraml, View paramView, bu parambu)
    {
      AppMethodBeat.i(194376);
      if (paramView == null)
      {
        ad.e("MicroMsg.ChattingItemAppMsgToImg", "[onCreateContextMenu] v is null");
        AppMethodBeat.o(194376);
        return false;
      }
      Object localObject = (bk)paramView.getTag();
      if (localObject == null)
      {
        ad.e("MicroMsg.ChattingItemAppMsgToImg", "[onCreateContextMenu] tag is null");
        AppMethodBeat.o(194376);
        return false;
      }
      int k = ((bk)localObject).position;
      localObject = k.b.yr(bj.b(this.JBI.fFv(), parambu.field_content, parambu.field_isSend));
      if ((localObject != null) && (com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.m(((k.b)localObject).appId, false, false)))) {
        paraml.a(k, 111, this.JBI.JOR.getMMResources().getString(2131762559), 2131690478);
      }
      if (com.tencent.mm.bs.d.aIu("favorite")) {
        paraml.a(k, 116, this.JBI.JOR.getMMResources().getString(2131761941), 2131690400);
      }
      int[] arrayOfInt;
      int j;
      int i;
      if (parambu.field_status != 5)
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
        localObject = new eb();
        ((eb)localObject).dpg.msgId = parambu.field_msgId;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
        boolean bool = com.tencent.mm.pluginsdk.model.app.h.r(this.JBI.JOR.getContext(), 2L);
        if ((((eb)localObject).dph.doF) || (bool)) {
          paraml.a(k, 129, paramView.getContext().getString(2131757228), 2131691577);
        }
        if ((!parambu.fpd()) && (parambu.frK()) && ((parambu.field_status == 2) || (parambu.fku == 1)) && (b(parambu, this.JBI)) && (aWy(parambu.field_talker))) {
          paraml.a(k, 123, paramView.getContext().getString(2131757234), 2131690462);
        }
        if (!this.JBI.fFw()) {
          paraml.a(k, 100, this.JBI.JOR.getMMResources().getString(2131757221), 2131690384);
        }
        AppMethodBeat.o(194376);
        return true;
        label497:
        i = 0;
        j = 0;
      }
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      AppMethodBeat.i(36980);
      ba.aBQ();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        t.g(parama.JOR.getContext(), parama.JOR.getContentView());
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
      Object localObject2 = parambu.field_content;
      if (localObject2 != null) {
        localObject1 = k.b.yr((String)localObject2);
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
      paramView = com.tencent.mm.pluginsdk.model.app.h.m(((k.b)localObject1).appId, false, false);
      if (paramView != null) {
        a(parama, (k.b)localObject1, u.aAm(), paramView, parambu.field_msgSvrId, parama.getTalkerUserName());
      }
      label597:
      PackageInfo localPackageInfo;
      if ((((k.b)localObject1).dks != null) && (((k.b)localObject1).dks.length() > 0))
      {
        paramView = ao.bIX().aLD(((k.b)localObject1).dks);
        if (paramView != null)
        {
          ba.aBQ();
          if (!com.tencent.mm.model.c.isSDCardAvailable()) {
            t.g(parama.JOR.getContext(), parama.JOR.getContentView());
          }
          for (;;)
          {
            AppMethodBeat.o(36980);
            return true;
            if (parambu.field_isSend == 1)
            {
              paramView = paramView.field_fileFullPath;
              if (!com.tencent.mm.vfs.i.fv(paramView)) {
                break label597;
              }
              if ((paramView != null) && (!paramView.equals("")) && (com.tencent.mm.vfs.i.fv(paramView))) {
                break;
              }
              ad.d("MicroMsg.ChattingItemAppMsgToImg", "showImg : imgPath is null");
            }
          }
          long l1 = parambu.field_msgId;
          long l2 = parambu.field_msgSvrId;
          parama = parambu.field_talker;
          ad.i("MicroMsg.ChattingItemAppMsgToImg", "[ImageGalleryUI] enter");
          paramView = new Intent(this.JBI.JOR.getContext(), ImageGalleryUI.class);
          paramView.putExtra("img_gallery_msg_id", l1);
          paramView.putExtra("img_gallery_talker", parama);
          paramView.putExtra("img_gallery_left", localObject2[0]);
          paramView.putExtra("img_gallery_top", localObject2[1]);
          paramView.putExtra("img_gallery_width", i);
          paramView.putExtra("img_gallery_height", j);
          parama = this.JBI.getTalkerUserName();
          parambu = b(this.JBI, parambu);
          localObject1 = new Bundle();
          if (this.JBI.fFv()) {
            i = 2;
          }
          for (;;)
          {
            ((Bundle)localObject1).putInt("stat_scene", i);
            ((Bundle)localObject1).putString("stat_msg_id", "msg_" + Long.toString(l2));
            ((Bundle)localObject1).putString("stat_chat_talker_username", parama);
            ((Bundle)localObject1).putString("stat_send_msg_user", parambu);
            paramView.putExtra("_stat_obj", (Bundle)localObject1);
            parama = this.JBI;
            paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
            com.tencent.mm.hellhoundlib.a.a.a(parama, paramView.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "showImg", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            parama.startActivity((Intent)paramView.mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "showImg", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            break;
            if (w.zE(parama)) {
              i = 7;
            } else {
              i = 1;
            }
          }
          ad.i("MicroMsg.ChattingItemAppMsgToImg", "onItemClick::bigImgPath: %s, msgId: %d, msgSvrId: %d", new Object[] { paramView, Long.valueOf(parambu.field_msgId), Long.valueOf(parambu.field_msgSvrId) });
          paramView = new Intent();
          paramView.setClassName(parama.JOR.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
          paramView.putExtra("clean_view_type", 1);
          paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramView.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramView.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(36980);
          return true;
        }
      }
      else if ((((k.b)localObject1).url != null) && (((k.b)localObject1).url.length() > 0))
      {
        localObject2 = com.tencent.mm.pluginsdk.model.app.q.Q(((k.b)localObject1).url, "message");
        localPackageInfo = getPackageInfo(parama.JOR.getContext(), ((k.b)localObject1).appId);
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
        a(parama, (String)localObject2, (String)localObject2, paramView, i, ((k.b)localObject1).appId, false, parambu.field_msgId, parambu.field_msgSvrId, parambu);
        AppMethodBeat.o(36980);
        return false;
        paramView = localPackageInfo.versionName;
        break;
      }
    }
    
    public final boolean bi(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 268435505);
    }
    
    public final boolean fHh()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.s
 * JD-Core Version:    0.7.0.1
 */