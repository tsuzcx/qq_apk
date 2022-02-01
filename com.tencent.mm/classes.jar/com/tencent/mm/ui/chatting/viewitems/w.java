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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.av.i;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.ef.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.vfs.s;

public final class w
{
  static final class a
    extends c.a
  {
    protected TextView PHZ;
    protected TextView PKR;
    protected ImageView PKS;
    protected View thM;
    protected TextView tln;
    protected ImageView xdY;
    protected ImageView xnz;
    
    public final a gT(View paramView)
    {
      AppMethodBeat.i(36965);
      super.create(paramView);
      this.xdY = ((ImageView)paramView.findViewById(2131298388));
      this.tln = ((TextView)paramView.findViewById(2131298385));
      this.PKR = ((TextView)paramView.findViewById(2131298377));
      this.thM = paramView.findViewById(2131298378);
      this.PHZ = ((TextView)paramView.findViewById(2131298364));
      this.userTV = ((TextView)paramView.findViewById(2131298566));
      this.PKS = ((ImageView)paramView.findViewById(2131298380));
      this.checkBox = ((CheckBox)paramView.findViewById(2131298410));
      this.maskView = paramView.findViewById(2131298508);
      this.xnz = ((ImageView)paramView.findViewById(2131298419));
      AppMethodBeat.o(36965);
      return this;
    }
  }
  
  public static final class b
    extends c
  {
    private final long PKT = 259200000L;
    private com.tencent.mm.ui.chatting.e.a PhN;
    
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
        localObject = new an(paramLayoutInflater, 2131493541);
        ((View)localObject).setTag(new w.a().gT((View)localObject));
      }
      AppMethodBeat.o(36970);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(36971);
      final w.a locala = (w.a)parama;
      this.PhN = parama1;
      ((com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class)).bZ(paramca);
      parama = null;
      String str = paramca.field_content;
      paramString = str;
      if (parama1.gRM())
      {
        int i = paramca.field_content.indexOf(':');
        paramString = str;
        if (i != -1) {
          paramString = paramca.field_content.substring(i + 1);
        }
      }
      if (paramString != null) {
        parama = k.b.aD(paramString, paramca.field_reserved);
      }
      com.tencent.mm.pluginsdk.model.app.g localg;
      if (parama != null)
      {
        localg = com.tencent.mm.pluginsdk.model.app.h.gE(parama.appId, parama.appVersion);
        if (localg != null) {
          b(parama1, parama, paramca);
        }
        if ((localg != null) && (localg.field_appName != null) && (localg.field_appName.trim().length() > 0)) {
          break label454;
        }
        paramString = parama.appName;
        if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.h.gp(paramString))) {
          break label480;
        }
        locala.tln.setText(com.tencent.mm.pluginsdk.model.app.h.a(parama1.Pwc.getContext(), localg, paramString));
        locala.tln.setVisibility(0);
        if ((localg == null) || (!localg.NA())) {
          break label464;
        }
        a(parama1, locala.tln, paramca, parama, localg.field_packageName, paramca.field_msgSvrId);
        label257:
        a(parama1, locala.tln, parama.appId);
        label270:
        if ((parama.fQR != null) && (parama.fQR.length() != 0)) {
          break label493;
        }
        locala.PHZ.setVisibility(8);
        label297:
        switch (parama.type)
        {
        default: 
          label320:
          if (!parama1.gRM()) {
            if (com.tencent.mm.pluginsdk.model.app.h.k(localg))
            {
              locala.PKS.setVisibility(0);
              locala.PHZ.setVisibility(8);
              c(parama1, locala.PKS, bq.a(parama, paramca));
            }
          }
          break;
        }
      }
      for (;;)
      {
        locala.clickArea.setTag(new bq(paramca, parama1.gRM(), paramInt, null, '\000'));
        locala.clickArea.setOnClickListener(d(parama1));
        if (this.qoo)
        {
          locala.clickArea.setOnLongClickListener(c(parama1));
          locala.clickArea.setOnTouchListener(((k)parama1.bh(k.class)).gOC());
        }
        AppMethodBeat.o(36971);
        return;
        label454:
        paramString = localg.field_appName;
        break;
        label464:
        a(parama1, locala.tln, parama.appId);
        break label257;
        label480:
        locala.tln.setVisibility(8);
        break label270;
        label493:
        locala.PHZ.setVisibility(0);
        b(parama1, locala.PHZ, bq.bnn(parama.fQR));
        break label297;
        locala.xdY.setVisibility(0);
        com.tencent.mm.pluginsdk.model.app.c localc = ao.cgO().bdx(parama.dCK);
        str = paramca.field_imgPath;
        paramString = Boolean.FALSE;
        if (localc != null)
        {
          str = localc.field_fileFullPath;
          paramString = Boolean.TRUE;
        }
        if (com.tencent.mm.av.q.bcR().a(locala.xdY, str, paramString.booleanValue(), com.tencent.mm.cb.a.getDensity(parama1.Pwc.getContext()), parama.ixa, parama.iwZ, locala.xnz, 2131231623, 1, null)) {
          break label320;
        }
        if (this.qoo) {
          locala.xdY.setImageResource(2131689898);
        }
        for (;;)
        {
          locala.xdY.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36966);
              locala.xdY.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
              FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(locala.xdY.getWidth(), locala.xdY.getHeight());
              locala.xnz.setLayoutParams(localLayoutParams);
              AppMethodBeat.o(36966);
            }
          });
          break;
          locala.xdY.setImageBitmap(BitmapFactory.decodeResource(parama1.Pwc.getMMResources(), 2131231623));
        }
        locala.PKS.setVisibility(8);
        continue;
        locala.PKS.setVisibility(8);
      }
    }
    
    public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.e.a parama, final ca paramca)
    {
      AppMethodBeat.i(36973);
      String str = paramca.field_content;
      Object localObject = null;
      if (str != null) {
        localObject = k.b.HD(str);
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
          if (((k.b)localObject).dCK != null)
          {
            paramMenuItem = str;
            if (((k.b)localObject).dCK.length() > 0)
            {
              localObject = ao.cgO().bdx(((k.b)localObject).dCK);
              paramMenuItem = str;
              if (localObject != null) {
                paramMenuItem = ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath;
              }
            }
          }
        }
        if (!paramca.gDB()) {
          if ((System.currentTimeMillis() - paramca.field_createTime <= 259200000L) || ((!Util.isNullOrNil(paramMenuItem)) && (s.YS(paramMenuItem)))) {
            break label237;
          }
        }
        label237:
        for (int i = 1; i != 0; i = 0)
        {
          Log.i("MicroMsg.ChattingItemAppMsgFromImg", "img is expired or clean!!!");
          com.tencent.mm.ui.base.h.d(parama.Pwc.getContext(), parama.Pwc.getContext().getString(2131761768), parama.Pwc.getContext().getString(2131755998), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(36973);
          return false;
        }
        new MMHandler().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36967);
            com.tencent.mm.pluginsdk.model.app.m.a(paramca, null);
            AppMethodBeat.o(36967);
          }
        });
        localObject = br.N(paramca);
        if (Util.isNullOrNil((String)localObject))
        {
          localObject = new Intent(parama.Pwc.getContext(), MsgRetransmitUI.class);
          ((Intent)localObject).putExtra("Retr_File_Name", paramMenuItem);
          ((Intent)localObject).putExtra("Retr_Msg_content", bp.b(parama.gRM(), paramca.field_content, paramca.field_isSend));
          ((Intent)localObject).putExtra("Retr_Msg_Type", 16);
          ((Intent)localObject).putExtra("Retr_Msg_Id", paramca.field_msgId);
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        for (;;)
        {
          AppMethodBeat.o(36973);
          return false;
          com.tencent.mm.plugin.report.service.h.CyF.a(17509, new Object[] { Integer.valueOf(3), localObject });
          com.tencent.mm.ui.base.h.a(parama.Pwc.getContext(), 2131765108, 2131765109, 2131756020, 2131757502, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(36968);
              paramAnonymousDialogInterface = new Intent();
              paramAnonymousDialogInterface.putExtra("rawUrl", this.PtI);
              paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
              paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
              com.tencent.mm.br.c.b(parama.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
              com.tencent.mm.plugin.report.service.h.CyF.a(17509, new Object[] { Integer.valueOf(1), this.PtI });
              AppMethodBeat.o(36968);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(36969);
              Object localObject = new Intent(parama.Pwc.getContext(), MsgRetransmitUI.class);
              ((Intent)localObject).putExtra("Retr_File_Name", paramMenuItem);
              ((Intent)localObject).putExtra("Retr_Msg_content", bp.b(parama.gRM(), paramca.field_content, paramca.field_isSend));
              ((Intent)localObject).putExtra("Retr_Msg_Type", 16);
              ((Intent)localObject).putExtra("Retr_Msg_Id", paramca.field_msgId);
              paramAnonymousDialogInterface = parama;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.plugin.report.service.h.CyF.a(17509, new Object[] { Integer.valueOf(2), this.PtI });
              AppMethodBeat.o(36969);
            }
          });
        }
      }
      w.a(parama, paramMenuItem, paramca);
      AppMethodBeat.o(36973);
      return false;
    }
    
    public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
    {
      AppMethodBeat.i(233727);
      if ((paramView == null) || (paramca == null))
      {
        AppMethodBeat.o(233727);
        return true;
      }
      int k = ((bq)paramView.getTag()).position;
      com.tencent.mm.pluginsdk.model.app.m.bdI(bp.b(this.PhN.gRM(), paramca.field_content, paramca.field_isSend));
      if (com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.o(k.b.HD(bp.b(this.PhN.gRM(), paramca.field_content, paramca.field_isSend)).appId, false, false))) {
        paramm.a(k, 111, this.PhN.Pwc.getMMResources().getString(2131764628), 2131690674);
      }
      if (com.tencent.mm.br.c.aZU("favorite")) {
        paramm.a(k, 116, this.PhN.Pwc.getMMResources().getString(2131763947), 2131690551);
      }
      Object localObject;
      int[] arrayOfInt;
      int j;
      int i;
      if (paramca.field_status != 5)
      {
        localObject = paramm.a(k, 131, paramView.getContext().getString(2131757388), 2131690644);
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
        localObject = new ef();
        ((ef)localObject).dHy.msgId = paramca.field_msgId;
        EventCenter.instance.publish((IEvent)localObject);
        boolean bool = com.tencent.mm.pluginsdk.model.app.h.s(this.PhN.Pwc.getContext(), 2L);
        if ((((ef)localObject).dHz.dGX) || (bool)) {
          paramm.a(k, 129, paramView.getContext().getString(2131757440), 2131690628);
        }
        if (br.B(paramca)) {
          paramm.clear();
        }
        if (!this.PhN.gRN()) {
          paramm.a(k, 100, this.PhN.Pwc.getMMResources().getString(2131757433), 2131690529);
        }
        AppMethodBeat.o(233727);
        return true;
        label417:
        i = 0;
        j = 0;
      }
    }
    
    public final boolean bM(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 268435505);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(36974);
      bg.aVF();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        u.g(parama.Pwc.getContext(), parama.Pwc.getContentView());
        AppMethodBeat.o(36974);
        return true;
      }
      ((b)com.tencent.mm.kernel.g.af(b.class)).akR(paramca.field_talker);
      Object localObject1 = null;
      Object localObject2 = bp.b(parama.gRM(), paramca.field_content, paramca.field_isSend);
      if (localObject2 != null) {
        localObject1 = k.b.HD((String)localObject2);
      }
      if (localObject1 == null)
      {
        Log.e("MicroMsg.ChattingItemAppMsgFromImg", "content is null");
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
        paramView = com.tencent.mm.pluginsdk.model.app.h.o(((k.b)localObject1).appId, true, false);
        if ((paramView != null) && (paramView.NA())) {
          a(parama, (k.b)localObject1, d(parama, paramca), paramView, paramca.field_msgSvrId, parama.getTalkerUserName());
        }
        if ((((k.b)localObject1).dCK != null) && (((k.b)localObject1).dCK.length() > 0))
        {
          paramView = ao.cgO().bdx(((k.b)localObject1).dCK);
          if ((paramView == null) || (!paramView.deQ())) {
            if (paramca.field_isSend == 0)
            {
              l1 = paramca.field_msgId;
              parama = new Intent();
              parama.setClassName(this.PhN.Pwc.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
              parama.putExtra("app_msg_id", l1);
              paramView = this.PhN;
              parama = new com.tencent.mm.hellhoundlib.b.a().bl(parama);
              com.tencent.mm.hellhoundlib.a.a.a(paramView, parama.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "doGetMsgImg", "(J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramView.startActivity((Intent)parama.pG(0));
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
            if (!s.YS(paramView))
            {
              Log.i("MicroMsg.ChattingItemAppMsgFromImg", "Img not exist, bigImgPath: %s, msgId: %d, msgSvrId: %d", new Object[] { paramView, Long.valueOf(paramca.field_msgId), Long.valueOf(paramca.field_msgSvrId) });
              paramView = new Intent();
              paramView.setClassName(parama.Pwc.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
              paramView.putExtra("clean_view_type", 1);
              paramView = new com.tencent.mm.hellhoundlib.b.a().bl(paramView);
              com.tencent.mm.hellhoundlib.a.a.a(parama, paramView.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              parama.startActivity((Intent)paramView.pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(36974);
              return true;
            }
            if ((paramView != null) && (!paramView.equals("")) && (s.YS(paramView))) {
              break;
            }
            Log.d("MicroMsg.ChattingItemAppMsgFromImg", "showImg : imgPath is null");
          }
          long l1 = paramca.field_msgId;
          long l2 = paramca.field_msgSvrId;
          parama = paramca.field_talker;
          Log.i("MicroMsg.ChattingItemAppMsgFromImg", "[ImageGalleryUI] enter");
          paramView = new Intent(this.PhN.Pwc.getContext(), ImageGalleryUI.class);
          paramView.putExtra("img_gallery_msg_id", l1);
          paramView.putExtra("img_gallery_talker", parama);
          paramView.putExtra("img_gallery_left", localObject2[0]);
          paramView.putExtra("img_gallery_top", localObject2[1]);
          paramView.putExtra("img_gallery_width", j);
          paramView.putExtra("img_gallery_height", i);
          parama = this.PhN.getTalkerUserName();
          paramca = a(this.PhN, paramca);
          localObject1 = new Bundle();
          if (this.PhN.gRM()) {
            i = 2;
          }
          for (;;)
          {
            ((Bundle)localObject1).putInt("stat_scene", i);
            ((Bundle)localObject1).putString("stat_msg_id", "msg_" + Long.toString(l2));
            ((Bundle)localObject1).putString("stat_chat_talker_username", parama);
            ((Bundle)localObject1).putString("stat_send_msg_user", paramca);
            paramView.putExtra("_stat_obj", (Bundle)localObject1);
            parama = this.PhN;
            paramView = new com.tencent.mm.hellhoundlib.b.a().bl(paramView);
            com.tencent.mm.hellhoundlib.a.a.a(parama, paramView.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "showImg", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            parama.startActivity((Intent)paramView.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "showImg", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            break;
            if (ab.IT(parama)) {
              i = 7;
            } else {
              i = 1;
            }
          }
        }
        localObject2 = com.tencent.mm.pluginsdk.model.app.q.R(((k.b)localObject1).url, "message");
        PackageInfo localPackageInfo = getPackageInfo(parama.Pwc.getContext(), ((k.b)localObject1).appId);
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
          a(parama, (String)localObject2, (String)localObject2, paramView, i, ((k.b)localObject1).appId, false, paramca.field_msgId, paramca.field_msgSvrId, paramca);
          break;
          paramView = localPackageInfo.versionName;
          break label925;
        }
        i = 0;
        j = 0;
      }
    }
    
    public final boolean gTT()
    {
      return false;
    }
  }
  
  public static final class c
    extends c
    implements t.n
  {
    private com.tencent.mm.ui.chatting.e.a PhN;
    
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
        localObject = new an(paramLayoutInflater, 2131493592);
        ((View)localObject).setTag(new w.a().gT((View)localObject));
      }
      AppMethodBeat.o(36976);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(36977);
      final w.a locala = (w.a)parama;
      this.PhN = parama1;
      ((com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class)).bZ(paramca);
      parama = null;
      String str = paramca.field_content;
      if (str != null) {
        parama = k.b.aD(str, paramca.field_reserved);
      }
      Object localObject;
      label198:
      label211:
      label232:
      int i;
      if (parama != null)
      {
        localObject = com.tencent.mm.pluginsdk.model.app.h.gE(parama.appId, parama.appVersion);
        if ((localObject == null) || (((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName == null) || (((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName.trim().length() <= 0))
        {
          paramString = parama.appName;
          if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.h.gp(paramString))) {
            break label428;
          }
          locala.tln.setText(com.tencent.mm.pluginsdk.model.app.h.a(parama1.Pwc.getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject, paramString));
          locala.tln.setVisibility(0);
          if ((localObject == null) || (!((com.tencent.mm.pluginsdk.model.app.g)localObject).NA())) {
            break label412;
          }
          a(parama1, locala.tln, paramca, parama, ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_packageName, paramca.field_msgSvrId);
          a(parama1, locala.tln, parama.appId);
        }
      }
      else
      {
        switch (parama.type)
        {
        default: 
          locala.clickArea.setTag(new bq(paramca, parama1.gRM(), paramInt, null, '\000'));
          locala.clickArea.setOnClickListener(d(parama1));
          if (this.qoo)
          {
            locala.clickArea.setOnLongClickListener(c(parama1));
            locala.clickArea.setOnTouchListener(((k)parama1.bh(k.class)).gOC());
          }
          i = com.tencent.mm.pluginsdk.model.app.m.bdI(str);
          if ((i == -1) || (i >= 100) || (parama.iwI <= 0) || (paramca.field_status == 5))
          {
            locala.thM.setVisibility(8);
            locala.xdY.setAlpha(255);
            locala.xdY.setBackgroundDrawable(null);
          }
          break;
        }
      }
      for (;;)
      {
        a(paramInt, locala, paramca, parama1.gRI(), parama1.gRM(), parama1, this);
        AppMethodBeat.o(36977);
        return;
        paramString = ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName;
        break;
        label412:
        a(parama1, locala.tln, parama.appId);
        break label198;
        label428:
        locala.tln.setVisibility(8);
        break label211;
        locala.xdY.setVisibility(0);
        com.tencent.mm.pluginsdk.model.app.c localc = ao.cgO().bdx(parama.dCK);
        localObject = paramca.field_imgPath;
        paramString = Boolean.FALSE;
        if (localc != null)
        {
          localObject = localc.field_fileFullPath;
          paramString = Boolean.TRUE;
        }
        if (com.tencent.mm.av.q.bcR().a(locala.xdY, (String)localObject, paramString.booleanValue(), com.tencent.mm.cb.a.getDensity(parama1.Pwc.getContext()), parama.thumbWidth, parama.thumbHeight, locala.xnz, 2131231623, 0, null)) {
          break label232;
        }
        if (this.qoo) {
          locala.xdY.setImageResource(2131689898);
        }
        for (;;)
        {
          locala.xdY.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36975);
              locala.xdY.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
              FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(locala.xdY.getWidth(), locala.xdY.getHeight());
              locala.xnz.setLayoutParams(localLayoutParams);
              AppMethodBeat.o(36975);
            }
          });
          break;
          locala.xdY.setImageBitmap(BitmapFactory.decodeResource(parama1.Pwc.getMMResources(), 2131231623));
        }
        locala.thM.setVisibility(0);
        locala.PKR.setText(i + "%");
        locala.xdY.setAlpha(64);
        locala.xdY.setBackgroundResource(2131234784);
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      Object localObject2 = null;
      AppMethodBeat.i(36979);
      Object localObject1 = paramca.field_content;
      if (localObject1 != null) {}
      for (localObject1 = k.b.HD((String)localObject1);; localObject1 = null)
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
            if (((k.b)localObject1).dCK != null)
            {
              paramMenuItem = localObject2;
              if (((k.b)localObject1).dCK.length() > 0)
              {
                localObject1 = ao.cgO().bdx(((k.b)localObject1).dCK);
                paramMenuItem = localObject2;
                if (localObject1 != null) {
                  paramMenuItem = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath;
                }
              }
            }
          }
          localObject1 = new Intent(parama.Pwc.getContext(), MsgRetransmitUI.class);
          ((Intent)localObject1).putExtra("Retr_Msg_content", paramca.field_content);
          ((Intent)localObject1).putExtra("Retr_File_Name", paramMenuItem);
          ((Intent)localObject1).putExtra("Retr_Msg_Type", 16);
          ((Intent)localObject1).putExtra("Retr_Msg_Id", paramca.field_msgId);
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(36979);
          return false;
        }
        w.a(parama, paramMenuItem, paramca);
        AppMethodBeat.o(36979);
        return false;
      }
    }
    
    public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
    {
      AppMethodBeat.i(233728);
      if (paramView == null)
      {
        Log.e("MicroMsg.ChattingItemAppMsgToImg", "[onCreateContextMenu] v is null");
        AppMethodBeat.o(233728);
        return false;
      }
      Object localObject = (bq)paramView.getTag();
      if (localObject == null)
      {
        Log.e("MicroMsg.ChattingItemAppMsgToImg", "[onCreateContextMenu] tag is null");
        AppMethodBeat.o(233728);
        return false;
      }
      int k = ((bq)localObject).position;
      localObject = k.b.HD(bp.b(this.PhN.gRM(), paramca.field_content, paramca.field_isSend));
      if ((localObject != null) && (com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.o(((k.b)localObject).appId, false, false)))) {
        paramm.a(k, 111, this.PhN.Pwc.getMMResources().getString(2131764628), 2131690674);
      }
      if (com.tencent.mm.br.c.aZU("favorite")) {
        paramm.a(k, 116, this.PhN.Pwc.getMMResources().getString(2131763947), 2131690551);
      }
      int[] arrayOfInt;
      int j;
      int i;
      if (paramca.field_status != 5)
      {
        localObject = paramm.a(k, 131, paramView.getContext().getString(2131757388), 2131690644);
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
        localObject = new ef();
        ((ef)localObject).dHy.msgId = paramca.field_msgId;
        EventCenter.instance.publish((IEvent)localObject);
        boolean bool = com.tencent.mm.pluginsdk.model.app.h.s(this.PhN.Pwc.getContext(), 2L);
        if ((((ef)localObject).dHz.dGX) || (bool)) {
          paramm.a(k, 129, paramView.getContext().getString(2131757440), 2131690628);
        }
        if ((!paramca.gAt()) && (paramca.gDr()) && ((paramca.field_status == 2) || (paramca.fQV == 1)) && (b(paramca, this.PhN)) && (bnf(paramca.field_talker))) {
          paramm.a(k, 123, paramView.getContext().getString(2131757446), 2131690650);
        }
        if (!this.PhN.gRN()) {
          paramm.a(k, 100, this.PhN.Pwc.getMMResources().getString(2131757433), 2131690529);
        }
        AppMethodBeat.o(233728);
        return true;
        label497:
        i = 0;
        j = 0;
      }
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(233729);
      if (paramca.dOQ())
      {
        com.tencent.mm.pluginsdk.model.app.m.aS(paramca);
        bp.Ad(paramca.field_msgId);
        parama.BN(true);
        AppMethodBeat.o(233729);
        return;
      }
      AppMethodBeat.o(233729);
    }
    
    public final boolean bM(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 268435505);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(36980);
      bg.aVF();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        u.g(parama.Pwc.getContext(), parama.Pwc.getContentView());
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
      Object localObject2 = paramca.field_content;
      if (localObject2 != null) {
        localObject1 = k.b.HD((String)localObject2);
      }
      if (localObject1 == null)
      {
        Log.e("MicroMsg.ChattingItemAppMsgToImg", "content is null");
        AppMethodBeat.o(36980);
        return true;
      }
      localObject2 = new int[2];
      paramView.getLocationInWindow((int[])localObject2);
      int i = paramView.getWidth();
      int j = paramView.getHeight();
      paramView = com.tencent.mm.pluginsdk.model.app.h.o(((k.b)localObject1).appId, false, false);
      if (paramView != null) {
        a(parama, (k.b)localObject1, z.aTY(), paramView, paramca.field_msgSvrId, parama.getTalkerUserName());
      }
      label597:
      PackageInfo localPackageInfo;
      if ((((k.b)localObject1).dCK != null) && (((k.b)localObject1).dCK.length() > 0))
      {
        paramView = ao.cgO().bdx(((k.b)localObject1).dCK);
        if (paramView != null)
        {
          bg.aVF();
          if (!com.tencent.mm.model.c.isSDCardAvailable()) {
            u.g(parama.Pwc.getContext(), parama.Pwc.getContentView());
          }
          for (;;)
          {
            AppMethodBeat.o(36980);
            return true;
            if (paramca.field_isSend == 1)
            {
              paramView = paramView.field_fileFullPath;
              if (!s.YS(paramView)) {
                break label597;
              }
              if ((paramView != null) && (!paramView.equals("")) && (s.YS(paramView))) {
                break;
              }
              Log.d("MicroMsg.ChattingItemAppMsgToImg", "showImg : imgPath is null");
            }
          }
          long l1 = paramca.field_msgId;
          long l2 = paramca.field_msgSvrId;
          parama = paramca.field_talker;
          Log.i("MicroMsg.ChattingItemAppMsgToImg", "[ImageGalleryUI] enter");
          paramView = new Intent(this.PhN.Pwc.getContext(), ImageGalleryUI.class);
          paramView.putExtra("img_gallery_msg_id", l1);
          paramView.putExtra("img_gallery_talker", parama);
          paramView.putExtra("img_gallery_left", localObject2[0]);
          paramView.putExtra("img_gallery_top", localObject2[1]);
          paramView.putExtra("img_gallery_width", i);
          paramView.putExtra("img_gallery_height", j);
          parama = this.PhN.getTalkerUserName();
          paramca = a(this.PhN, paramca);
          localObject1 = new Bundle();
          if (this.PhN.gRM()) {
            i = 2;
          }
          for (;;)
          {
            ((Bundle)localObject1).putInt("stat_scene", i);
            ((Bundle)localObject1).putString("stat_msg_id", "msg_" + Long.toString(l2));
            ((Bundle)localObject1).putString("stat_chat_talker_username", parama);
            ((Bundle)localObject1).putString("stat_send_msg_user", paramca);
            paramView.putExtra("_stat_obj", (Bundle)localObject1);
            parama = this.PhN;
            paramView = new com.tencent.mm.hellhoundlib.b.a().bl(paramView);
            com.tencent.mm.hellhoundlib.a.a.a(parama, paramView.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "showImg", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            parama.startActivity((Intent)paramView.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "showImg", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            break;
            if (ab.IT(parama)) {
              i = 7;
            } else {
              i = 1;
            }
          }
          Log.i("MicroMsg.ChattingItemAppMsgToImg", "onItemClick::bigImgPath: %s, msgId: %d, msgSvrId: %d", new Object[] { paramView, Long.valueOf(paramca.field_msgId), Long.valueOf(paramca.field_msgSvrId) });
          paramView = new Intent();
          paramView.setClassName(parama.Pwc.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
          paramView.putExtra("clean_view_type", 1);
          paramView = new com.tencent.mm.hellhoundlib.b.a().bl(paramView);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramView.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramView.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(36980);
          return true;
        }
      }
      else if ((((k.b)localObject1).url != null) && (((k.b)localObject1).url.length() > 0))
      {
        localObject2 = com.tencent.mm.pluginsdk.model.app.q.R(((k.b)localObject1).url, "message");
        localPackageInfo = getPackageInfo(parama.Pwc.getContext(), ((k.b)localObject1).appId);
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
        a(parama, (String)localObject2, (String)localObject2, paramView, i, ((k.b)localObject1).appId, false, paramca.field_msgId, paramca.field_msgSvrId, paramca);
        AppMethodBeat.o(36980);
        return false;
        paramView = localPackageInfo.versionName;
        break;
      }
    }
    
    public final boolean gTT()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.w
 * JD-Core Version:    0.7.0.1
 */