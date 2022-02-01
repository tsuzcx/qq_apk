package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
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
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.ay.i;
import com.tencent.mm.f.a.em;
import com.tencent.mm.f.a.em.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bs;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.vfs.u;

public final class z
{
  static final class a
    extends c.a
  {
    protected ImageView BPW;
    protected ImageView BZR;
    protected TextView Xdu;
    protected TextView XgL;
    protected ImageView XgM;
    protected View wOd;
    protected TextView wRL;
    
    public final a jdMethod_if(View paramView)
    {
      AppMethodBeat.i(36965);
      super.create(paramView);
      this.BPW = ((ImageView)paramView.findViewById(R.h.dwL));
      this.wRL = ((TextView)paramView.findViewById(R.h.dwI));
      this.XgL = ((TextView)paramView.findViewById(R.h.dwA));
      this.wOd = paramView.findViewById(R.h.dwB);
      this.Xdu = ((TextView)paramView.findViewById(R.h.dwm));
      this.userTV = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
      this.XgM = ((ImageView)paramView.findViewById(R.h.dwD));
      this.checkBox = ((CheckBox)paramView.findViewById(R.h.dwZ));
      this.maskView = paramView.findViewById(R.h.dyD);
      this.BZR = ((ImageView)paramView.findViewById(R.h.dxg));
      AppMethodBeat.o(36965);
      return this;
    }
  }
  
  public static final class b
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a WBq;
    private final long XgN = 259200000L;
    
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
        localObject = new aq(paramLayoutInflater, R.i.ecZ);
        ((View)localObject).setTag(new z.a().jdMethod_if((View)localObject));
      }
      AppMethodBeat.o(36970);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(36971);
      final z.a locala = (z.a)parama;
      this.WBq = parama1;
      ((com.tencent.mm.ui.chatting.d.b.m)parama1.bC(com.tencent.mm.ui.chatting.d.b.m.class)).ct(paramca);
      parama = null;
      String str = paramca.field_content;
      paramString = str;
      if (parama1.hRi())
      {
        int i = paramca.field_content.indexOf(':');
        paramString = str;
        if (i != -1) {
          paramString = paramca.field_content.substring(i + 1);
        }
      }
      if (paramString != null) {
        parama = k.b.aG(paramString, paramca.field_reserved);
      }
      g localg;
      if (parama != null)
      {
        localg = com.tencent.mm.pluginsdk.model.app.h.hn(parama.appId, parama.appVersion);
        if (localg != null) {
          b(parama1, parama, paramca);
        }
        if ((localg != null) && (localg.field_appName != null) && (localg.field_appName.trim().length() > 0)) {
          break label454;
        }
        paramString = parama.appName;
        if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.h.gZ(paramString))) {
          break label480;
        }
        locala.wRL.setText(com.tencent.mm.pluginsdk.model.app.h.a(parama1.WQv.getContext(), localg, paramString));
        locala.wRL.setVisibility(0);
        if ((localg == null) || (!localg.Qv())) {
          break label464;
        }
        a(parama1, locala.wRL, paramca, parama, localg.field_packageName, paramca.field_msgSvrId);
        label257:
        a(parama1, locala.wRL, parama.appId);
        label270:
        if ((parama.ilh != null) && (parama.ilh.length() != 0)) {
          break label493;
        }
        locala.Xdu.setVisibility(8);
        label297:
        switch (parama.type)
        {
        default: 
          label320:
          if (!parama1.hRi()) {
            if (com.tencent.mm.pluginsdk.model.app.h.k(localg))
            {
              locala.XgM.setVisibility(0);
              locala.Xdu.setVisibility(8);
              c(parama1, locala.XgM, by.a(parama, paramca));
            }
          }
          break;
        }
      }
      for (;;)
      {
        locala.clickArea.setTag(new by(paramca, parama1.hRi(), paramInt, null, '\000'));
        locala.clickArea.setOnClickListener(d(parama1));
        if (this.tMW)
        {
          locala.clickArea.setOnLongClickListener(c(parama1));
          locala.clickArea.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
        }
        AppMethodBeat.o(36971);
        return;
        label454:
        paramString = localg.field_appName;
        break;
        label464:
        a(parama1, locala.wRL, parama.appId);
        break label257;
        label480:
        locala.wRL.setVisibility(8);
        break label270;
        label493:
        locala.Xdu.setVisibility(0);
        b(parama1, locala.Xdu, by.bzO(parama.ilh));
        break label297;
        locala.BPW.setVisibility(0);
        com.tencent.mm.pluginsdk.model.app.c localc = ao.ctZ().bpR(parama.fvr);
        str = paramca.field_imgPath;
        paramString = Boolean.FALSE;
        if (localc != null)
        {
          str = localc.field_fileFullPath;
          paramString = Boolean.TRUE;
        }
        if (com.tencent.mm.ay.q.bmh().a(locala.BPW, str, paramString.booleanValue(), com.tencent.mm.ci.a.getDensity(parama1.WQv.getContext()), parama.lmp, parama.lmo, R.g.chat_img_template, locala.BZR, R.g.chat_img_default_bg, 1, null)) {
          break label320;
        }
        if (this.tMW) {
          locala.BPW.setImageResource(R.k.chatfrom_bg_pic);
        }
        for (;;)
        {
          locala.BPW.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36966);
              locala.BPW.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
              FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(locala.BPW.getWidth(), locala.BPW.getHeight());
              locala.BZR.setLayoutParams(localLayoutParams);
              AppMethodBeat.o(36966);
            }
          });
          break;
          locala.BPW.setImageBitmap(BitmapFactory.decodeResource(parama1.WQv.getMMResources(), R.g.chat_img_default_bg));
        }
        locala.XgM.setVisibility(8);
        continue;
        locala.XgM.setVisibility(8);
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, final ca paramca)
    {
      AppMethodBeat.i(36973);
      String str = paramca.field_content;
      Object localObject = null;
      if (str != null) {
        localObject = k.b.OQ(str);
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
          if (((k.b)localObject).fvr != null)
          {
            paramMenuItem = str;
            if (((k.b)localObject).fvr.length() > 0)
            {
              localObject = ao.ctZ().bpR(((k.b)localObject).fvr);
              paramMenuItem = str;
              if (localObject != null) {
                paramMenuItem = ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath;
              }
            }
          }
        }
        if (!paramca.Ic()) {
          if ((System.currentTimeMillis() - paramca.field_createTime <= 259200000L) || ((!Util.isNullOrNil(paramMenuItem)) && (u.agG(paramMenuItem)))) {
            break label237;
          }
        }
        label237:
        for (int i = 1; i != 0; i = 0)
        {
          Log.i("MicroMsg.ChattingItemAppMsgFromImg", "img is expired or clean!!!");
          com.tencent.mm.ui.base.h.d(parama.WQv.getContext(), parama.WQv.getContext().getString(R.l.eHX), parama.WQv.getContext().getString(R.l.app_tip), new z.b.2(this));
          AppMethodBeat.o(36973);
          return false;
        }
        new MMHandler().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36967);
            com.tencent.mm.pluginsdk.model.app.m.aW(paramca);
            AppMethodBeat.o(36967);
          }
        });
        localObject = bs.T(paramca);
        if (Util.isNullOrNil((String)localObject))
        {
          localObject = new Intent(parama.WQv.getContext(), MsgRetransmitUI.class);
          ((Intent)localObject).putExtra("Retr_File_Name", paramMenuItem);
          ((Intent)localObject).putExtra("Retr_Msg_content", bq.b(parama.hRi(), paramca.field_content, paramca.field_isSend));
          ((Intent)localObject).putExtra("Retr_Msg_Type", 16);
          ((Intent)localObject).putExtra("Retr_Msg_Id", paramca.field_msgId);
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        for (;;)
        {
          AppMethodBeat.o(36973);
          return false;
          com.tencent.mm.plugin.report.service.h.IzE.a(17509, new Object[] { Integer.valueOf(3), localObject });
          com.tencent.mm.ui.base.h.a(parama.WQv.getContext(), R.l.eRO, R.l.eRP, R.l.app_view_detail, R.l.ewL, true, new z.b.4(this, (String)localObject, parama), new z.b.5(this, parama, paramMenuItem, paramca, (String)localObject));
        }
      }
      z.a(parama, paramMenuItem, paramca);
      AppMethodBeat.o(36973);
      return false;
    }
    
    public final boolean a(o paramo, View paramView, ca paramca)
    {
      AppMethodBeat.i(280091);
      if ((paramView == null) || (paramca == null))
      {
        AppMethodBeat.o(280091);
        return true;
      }
      int k = ((by)paramView.getTag()).position;
      com.tencent.mm.pluginsdk.model.app.m.bqe(bq.b(this.WBq.hRi(), paramca.field_content, paramca.field_isSend));
      if ((com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.o(k.b.OQ(bq.b(this.WBq.hRi(), paramca.field_content, paramca.field_isSend)).appId, false, false))) && (!bs.O(paramca))) {
        paramo.a(k, 111, this.WBq.WQv.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
      }
      if (com.tencent.mm.by.c.blP("favorite")) {
        paramo.a(k, 116, this.WBq.WQv.getMMResources().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
      }
      Object localObject;
      int[] arrayOfInt;
      int j;
      int i;
      if (paramca.field_status != 5)
      {
        localObject = paramo.a(k, 131, paramView.getContext().getString(R.l.chatting_image_long_click_photo_edit), R.k.icons_filled_pencil);
        arrayOfInt = new int[2];
        if (paramView == null) {
          break label424;
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
        localObject = new em();
        ((em)localObject).fAp.msgId = paramca.field_msgId;
        EventCenter.instance.publish((IEvent)localObject);
        boolean bool = com.tencent.mm.pluginsdk.model.app.h.u(this.WBq.WQv.getContext(), 2L);
        if ((((em)localObject).fAq.fzO) || (bool)) {
          paramo.a(k, 129, paramView.getContext().getString(R.l.evU), R.k.icons_filled_open);
        }
        if (bs.D(paramca)) {
          paramo.clear();
        }
        if (!this.WBq.hRj()) {
          paramo.a(k, 100, this.WBq.WQv.getMMResources().getString(R.l.evO), R.k.icons_filled_delete);
        }
        AppMethodBeat.o(280091);
        return true;
        label424:
        i = 0;
        j = 0;
      }
    }
    
    public final boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 268435505);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(36974);
      bh.beI();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        w.g(parama.WQv.getContext(), parama.WQv.getContentView());
        AppMethodBeat.o(36974);
        return true;
      }
      ((b)com.tencent.mm.kernel.h.ae(b.class)).asK(paramca.field_talker);
      Object localObject1 = null;
      Object localObject2 = bq.b(parama.hRi(), paramca.field_content, paramca.field_isSend);
      if (localObject2 != null) {
        localObject1 = k.b.OQ((String)localObject2);
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
        if ((paramView != null) && (paramView.Qv())) {
          a(parama, (k.b)localObject1, d(parama, paramca), paramView, paramca.field_msgSvrId, parama.getTalkerUserName());
        }
        if ((((k.b)localObject1).fvr != null) && (((k.b)localObject1).fvr.length() > 0))
        {
          paramView = ao.ctZ().bpR(((k.b)localObject1).fvr);
          if ((paramView == null) || (!paramView.evg())) {
            if (paramca.field_isSend == 0)
            {
              l1 = paramca.field_msgId;
              parama = new Intent();
              parama.setClassName(this.WBq.WQv.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
              parama.putExtra("app_msg_id", l1);
              paramView = this.WBq;
              parama = new com.tencent.mm.hellhoundlib.b.a().bm(parama);
              com.tencent.mm.hellhoundlib.a.a.b(paramView, parama.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "doGetMsgImg", "(J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramView.startActivity((Intent)parama.sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "doGetMsgImg", "(J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
            if (!u.agG(paramView))
            {
              Log.i("MicroMsg.ChattingItemAppMsgFromImg", "Img not exist, bigImgPath: %s, msgId: %d, msgSvrId: %d", new Object[] { paramView, Long.valueOf(paramca.field_msgId), Long.valueOf(paramca.field_msgSvrId) });
              paramView = new Intent();
              paramView.setClassName(parama.WQv.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
              paramView.putExtra("clean_view_type", 1);
              paramView = new com.tencent.mm.hellhoundlib.b.a().bm(paramView);
              com.tencent.mm.hellhoundlib.a.a.b(parama, paramView.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              parama.startActivity((Intent)paramView.sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(36974);
              return true;
            }
            if ((paramView != null) && (!paramView.equals("")) && (u.agG(paramView))) {
              break;
            }
            Log.d("MicroMsg.ChattingItemAppMsgFromImg", "showImg : imgPath is null");
          }
          long l1 = paramca.field_msgId;
          long l2 = paramca.field_msgSvrId;
          parama = paramca.field_talker;
          Log.i("MicroMsg.ChattingItemAppMsgFromImg", "[ImageGalleryUI] enter");
          paramView = new Intent(this.WBq.WQv.getContext(), ImageGalleryUI.class);
          paramView.putExtra("img_gallery_msg_id", l1);
          paramView.putExtra("img_gallery_talker", parama);
          paramView.putExtra("img_gallery_left", localObject2[0]);
          paramView.putExtra("img_gallery_top", localObject2[1]);
          paramView.putExtra("img_gallery_width", j);
          paramView.putExtra("img_gallery_height", i);
          parama = this.WBq.getTalkerUserName();
          paramca = a(this.WBq, paramca);
          localObject1 = new Bundle();
          if (this.WBq.hRi()) {
            i = 2;
          }
          for (;;)
          {
            ((Bundle)localObject1).putInt("stat_scene", i);
            ((Bundle)localObject1).putString("stat_msg_id", "msg_" + Long.toString(l2));
            ((Bundle)localObject1).putString("stat_chat_talker_username", parama);
            ((Bundle)localObject1).putString("stat_send_msg_user", paramca);
            paramView.putExtra("_stat_obj", (Bundle)localObject1);
            parama = this.WBq;
            paramView = new com.tencent.mm.hellhoundlib.b.a().bm(paramView);
            com.tencent.mm.hellhoundlib.a.a.b(parama, paramView.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "showImg", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            parama.startActivity((Intent)paramView.sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "showImg", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            break;
            if (ab.Qm(parama)) {
              i = 7;
            } else {
              i = 1;
            }
          }
        }
        localObject2 = com.tencent.mm.pluginsdk.model.app.q.V(((k.b)localObject1).url, "message");
        PackageInfo localPackageInfo = getPackageInfo(parama.WQv.getContext(), ((k.b)localObject1).appId);
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
    
    public final boolean hTD()
    {
      return false;
    }
  }
  
  public static final class c
    extends c
    implements t.n
  {
    private com.tencent.mm.ui.chatting.e.a WBq;
    
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
        localObject = new aq(paramLayoutInflater, R.i.edZ);
        ((View)localObject).setTag(new z.a().jdMethod_if((View)localObject));
      }
      AppMethodBeat.o(36976);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(36977);
      final z.a locala = (z.a)parama;
      this.WBq = parama1;
      ((com.tencent.mm.ui.chatting.d.b.m)parama1.bC(com.tencent.mm.ui.chatting.d.b.m.class)).ct(paramca);
      parama = null;
      String str = paramca.field_content;
      if (str != null) {
        parama = k.b.aG(str, paramca.field_reserved);
      }
      Object localObject;
      label198:
      label211:
      label232:
      int i;
      if (parama != null)
      {
        localObject = com.tencent.mm.pluginsdk.model.app.h.hn(parama.appId, parama.appVersion);
        if ((localObject == null) || (((g)localObject).field_appName == null) || (((g)localObject).field_appName.trim().length() <= 0))
        {
          paramString = parama.appName;
          if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.h.gZ(paramString))) {
            break label428;
          }
          locala.wRL.setText(com.tencent.mm.pluginsdk.model.app.h.a(parama1.WQv.getContext(), (g)localObject, paramString));
          locala.wRL.setVisibility(0);
          if ((localObject == null) || (!((g)localObject).Qv())) {
            break label412;
          }
          a(parama1, locala.wRL, paramca, parama, ((g)localObject).field_packageName, paramca.field_msgSvrId);
          a(parama1, locala.wRL, parama.appId);
        }
      }
      else
      {
        switch (parama.type)
        {
        default: 
          locala.clickArea.setTag(new by(paramca, parama1.hRi(), paramInt, null, '\000'));
          locala.clickArea.setOnClickListener(d(parama1));
          if (this.tMW)
          {
            locala.clickArea.setOnLongClickListener(c(parama1));
            locala.clickArea.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
          }
          i = com.tencent.mm.pluginsdk.model.app.m.bqe(str);
          if ((i == -1) || (i >= 100) || (parama.llX <= 0) || (paramca.field_status == 5))
          {
            locala.wOd.setVisibility(8);
            locala.BPW.setAlpha(255);
            locala.BPW.setBackgroundDrawable(null);
          }
          break;
        }
      }
      for (;;)
      {
        a(paramInt, locala, paramca, parama1.getSelfUserName(), parama1.hRi(), parama1, this);
        AppMethodBeat.o(36977);
        return;
        paramString = ((g)localObject).field_appName;
        break;
        label412:
        a(parama1, locala.wRL, parama.appId);
        break label198;
        label428:
        locala.wRL.setVisibility(8);
        break label211;
        locala.BPW.setVisibility(0);
        com.tencent.mm.pluginsdk.model.app.c localc = ao.ctZ().bpR(parama.fvr);
        localObject = paramca.field_imgPath;
        paramString = Boolean.FALSE;
        if (localc != null)
        {
          localObject = localc.field_fileFullPath;
          paramString = Boolean.TRUE;
        }
        if (com.tencent.mm.ay.q.bmh().a(locala.BPW, (String)localObject, paramString.booleanValue(), com.tencent.mm.ci.a.getDensity(parama1.WQv.getContext()), parama.thumbWidth, parama.thumbHeight, R.g.chat_img_template, locala.BZR, R.g.chat_img_default_bg, 0, null)) {
          break label232;
        }
        if (this.tMW) {
          locala.BPW.setImageResource(R.k.chatfrom_bg_pic);
        }
        for (;;)
        {
          locala.BPW.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36975);
              locala.BPW.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
              FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(locala.BPW.getWidth(), locala.BPW.getHeight());
              locala.BZR.setLayoutParams(localLayoutParams);
              AppMethodBeat.o(36975);
            }
          });
          break;
          locala.BPW.setImageBitmap(BitmapFactory.decodeResource(parama1.WQv.getMMResources(), R.g.chat_img_default_bg));
        }
        locala.wOd.setVisibility(0);
        locala.XgL.setText(i + "%");
        locala.BPW.setAlpha(64);
        locala.BPW.setBackgroundResource(R.g.doD);
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      Object localObject2 = null;
      AppMethodBeat.i(36979);
      Object localObject1 = paramca.field_content;
      if (localObject1 != null) {}
      for (localObject1 = k.b.OQ((String)localObject1);; localObject1 = null)
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
            if (((k.b)localObject1).fvr != null)
            {
              paramMenuItem = localObject2;
              if (((k.b)localObject1).fvr.length() > 0)
              {
                localObject1 = ao.ctZ().bpR(((k.b)localObject1).fvr);
                paramMenuItem = localObject2;
                if (localObject1 != null) {
                  paramMenuItem = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath;
                }
              }
            }
          }
          localObject1 = new Intent(parama.WQv.getContext(), MsgRetransmitUI.class);
          ((Intent)localObject1).putExtra("Retr_Msg_content", paramca.field_content);
          ((Intent)localObject1).putExtra("Retr_File_Name", paramMenuItem);
          ((Intent)localObject1).putExtra("Retr_Msg_Type", 16);
          ((Intent)localObject1).putExtra("Retr_Msg_Id", paramca.field_msgId);
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
          com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(36979);
          return false;
        }
        z.a(parama, paramMenuItem, paramca);
        AppMethodBeat.o(36979);
        return false;
      }
    }
    
    public final boolean a(o paramo, View paramView, ca paramca)
    {
      AppMethodBeat.i(290482);
      if (paramView == null)
      {
        Log.e("MicroMsg.ChattingItemAppMsgToImg", "[onCreateContextMenu] v is null");
        AppMethodBeat.o(290482);
        return false;
      }
      Object localObject = (by)paramView.getTag();
      if (localObject == null)
      {
        Log.e("MicroMsg.ChattingItemAppMsgToImg", "[onCreateContextMenu] tag is null");
        AppMethodBeat.o(290482);
        return false;
      }
      int k = ((by)localObject).position;
      localObject = k.b.OQ(bq.b(this.WBq.hRi(), paramca.field_content, paramca.field_isSend));
      if ((localObject != null) && (com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.o(((k.b)localObject).appId, false, false))) && (!bs.O(paramca))) {
        paramo.a(k, 111, this.WBq.WQv.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
      }
      if (com.tencent.mm.by.c.blP("favorite")) {
        paramo.a(k, 116, this.WBq.WQv.getMMResources().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
      }
      int[] arrayOfInt;
      int j;
      int i;
      if (paramca.field_status != 5)
      {
        localObject = paramo.a(k, 131, paramView.getContext().getString(R.l.chatting_image_long_click_photo_edit), R.k.icons_filled_pencil);
        arrayOfInt = new int[2];
        if (paramView == null) {
          break label504;
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
        localObject = new em();
        ((em)localObject).fAp.msgId = paramca.field_msgId;
        EventCenter.instance.publish((IEvent)localObject);
        boolean bool = com.tencent.mm.pluginsdk.model.app.h.u(this.WBq.WQv.getContext(), 2L);
        if ((((em)localObject).fAq.fzO) || (bool)) {
          paramo.a(k, 129, paramView.getContext().getString(R.l.evU), R.k.icons_filled_open);
        }
        if ((!paramca.hwA()) && (paramca.hzF()) && ((paramca.field_status == 2) || (paramca.ill == 1)) && (b(paramca, this.WBq)) && (bzE(paramca.field_talker))) {
          paramo.a(k, 123, paramView.getContext().getString(R.l.ewa), R.k.icons_filled_previous);
        }
        if (!this.WBq.hRj()) {
          paramo.a(k, 100, this.WBq.WQv.getMMResources().getString(R.l.evO), R.k.icons_filled_delete);
        }
        AppMethodBeat.o(290482);
        return true;
        label504:
        i = 0;
        j = 0;
      }
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(290484);
      if (paramca.erk())
      {
        com.tencent.mm.pluginsdk.model.app.m.bh(paramca);
        bq.Gk(paramca.field_msgId);
        parama.Gi(true);
        AppMethodBeat.o(290484);
        return;
      }
      AppMethodBeat.o(290484);
    }
    
    public final boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 268435505);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(36980);
      bh.beI();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        w.g(parama.WQv.getContext(), parama.WQv.getContentView());
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
        localObject1 = k.b.OQ((String)localObject2);
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
        a(parama, (k.b)localObject1, com.tencent.mm.model.z.bcZ(), paramView, paramca.field_msgSvrId, parama.getTalkerUserName());
      }
      label597:
      PackageInfo localPackageInfo;
      if ((((k.b)localObject1).fvr != null) && (((k.b)localObject1).fvr.length() > 0))
      {
        paramView = ao.ctZ().bpR(((k.b)localObject1).fvr);
        if (paramView != null)
        {
          bh.beI();
          if (!com.tencent.mm.model.c.isSDCardAvailable()) {
            w.g(parama.WQv.getContext(), parama.WQv.getContentView());
          }
          for (;;)
          {
            AppMethodBeat.o(36980);
            return true;
            if (paramca.field_isSend == 1)
            {
              paramView = paramView.field_fileFullPath;
              if (!u.agG(paramView)) {
                break label597;
              }
              if ((paramView != null) && (!paramView.equals("")) && (u.agG(paramView))) {
                break;
              }
              Log.d("MicroMsg.ChattingItemAppMsgToImg", "showImg : imgPath is null");
            }
          }
          long l1 = paramca.field_msgId;
          long l2 = paramca.field_msgSvrId;
          parama = paramca.field_talker;
          Log.i("MicroMsg.ChattingItemAppMsgToImg", "[ImageGalleryUI] enter");
          paramView = new Intent(this.WBq.WQv.getContext(), ImageGalleryUI.class);
          paramView.putExtra("img_gallery_msg_id", l1);
          paramView.putExtra("img_gallery_talker", parama);
          paramView.putExtra("img_gallery_left", localObject2[0]);
          paramView.putExtra("img_gallery_top", localObject2[1]);
          paramView.putExtra("img_gallery_width", i);
          paramView.putExtra("img_gallery_height", j);
          parama = this.WBq.getTalkerUserName();
          paramca = a(this.WBq, paramca);
          localObject1 = new Bundle();
          if (this.WBq.hRi()) {
            i = 2;
          }
          for (;;)
          {
            ((Bundle)localObject1).putInt("stat_scene", i);
            ((Bundle)localObject1).putString("stat_msg_id", "msg_" + Long.toString(l2));
            ((Bundle)localObject1).putString("stat_chat_talker_username", parama);
            ((Bundle)localObject1).putString("stat_send_msg_user", paramca);
            paramView.putExtra("_stat_obj", (Bundle)localObject1);
            parama = this.WBq;
            paramView = new com.tencent.mm.hellhoundlib.b.a().bm(paramView);
            com.tencent.mm.hellhoundlib.a.a.b(parama, paramView.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "showImg", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            parama.startActivity((Intent)paramView.sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "showImg", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            break;
            if (ab.Qm(parama)) {
              i = 7;
            } else {
              i = 1;
            }
          }
          Log.i("MicroMsg.ChattingItemAppMsgToImg", "onItemClick::bigImgPath: %s, msgId: %d, msgSvrId: %d", new Object[] { paramView, Long.valueOf(paramca.field_msgId), Long.valueOf(paramca.field_msgSvrId) });
          paramView = new Intent();
          paramView.setClassName(parama.WQv.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
          paramView.putExtra("clean_view_type", 1);
          paramView = new com.tencent.mm.hellhoundlib.b.a().bm(paramView);
          com.tencent.mm.hellhoundlib.a.a.b(parama, paramView.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramView.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(36980);
          return true;
        }
      }
      else if ((((k.b)localObject1).url != null) && (((k.b)localObject1).url.length() > 0))
      {
        localObject2 = com.tencent.mm.pluginsdk.model.app.q.V(((k.b)localObject1).url, "message");
        localPackageInfo = getPackageInfo(parama.WQv.getContext(), ((k.b)localObject1).appId);
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
    
    public final boolean hTD()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.z
 * JD-Core Version:    0.7.0.1
 */