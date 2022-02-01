package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.av.o;
import com.tencent.mm.g.a.ya;
import com.tencent.mm.g.a.ya.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.bjm;
import com.tencent.mm.protocal.protobuf.bjn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import java.util.UUID;

public final class f
{
  static final class a
    extends c.a
  {
    public int IjS = 0;
    public boolean IkA;
    public ImageView Ikp;
    public TextView Ikq;
    public TextView Ikr;
    public TextView Iks;
    public TextView Ikt;
    public TextView Iku;
    public ImageView Ikv;
    public ImageView Ikw;
    public int Ikx = 0;
    public int Iky;
    public long Ikz;
    public View iCJ;
    public int maxSize = 0;
    public View ofC;
    public ImageView uxq;
    
    public final a ga(View paramView)
    {
      AppMethodBeat.i(36847);
      super.fX(paramView);
      this.fAz = ((TextView)this.sSS.findViewById(2131298178));
      this.ijt = ((CheckBox)this.sSS.findViewById(2131298068));
      this.gGk = this.sSS.findViewById(2131298147);
      this.xpH = ((TextView)this.sSS.findViewById(2131298185));
      this.ofC = this.sSS.findViewById(2131300196);
      this.iCJ = ((ImageView)this.sSS.findViewById(2131299154));
      this.Ikp = ((ImageView)this.sSS.findViewById(2131296913));
      this.Ikq = ((TextView)this.sSS.findViewById(2131296919));
      this.Ikr = ((TextView)this.sSS.findViewById(2131296911));
      this.Iks = ((TextView)this.sSS.findViewById(2131296922));
      this.nDl = this.sSS.findViewById(2131298069);
      this.uxq = ((ImageView)this.sSS.findViewById(2131298120));
      this.Iku = ((TextView)this.sSS.findViewById(2131296921));
      this.Ikt = ((TextView)this.sSS.findViewById(2131307149));
      this.Ikv = ((ImageView)this.sSS.findViewById(2131298121));
      this.Ikw = ((ImageView)this.sSS.findViewById(2131296920));
      this.iCJ = this.sSS.findViewById(2131296912);
      this.IjS = c.kb(ai.getContext());
      this.Ikx = com.tencent.mm.cc.a.au(ai.getContext(), 2131165217);
      this.maxSize = ((int)(com.tencent.mm.cc.a.av(ai.getContext(), 2131165217) * 1.45F));
      this.Iky = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 20);
      AppMethodBeat.o(36847);
      return this;
    }
  }
  
  public static final class b
    extends c
  {
    private com.tencent.mm.ui.chatting.d.a HNS;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(36848);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new ag(paramLayoutInflater, 2131493432);
        ((View)localObject).setTag(new f.a().ga((View)localObject));
      }
      AppMethodBeat.o(36848);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
    {
      AppMethodBeat.i(36849);
      this.HNS = parama1;
      f.a locala = (f.a)parama;
      if (locala.Ikz == parambo.field_msgId)
      {
        locala.IkA = true;
        locala.Ikz = parambo.field_msgId;
        paramString = parambo.field_content;
        if (paramString == null) {
          break label1500;
        }
      }
      label191:
      label461:
      label1109:
      label1494:
      label1500:
      for (k.b localb = k.b.az(paramString, parambo.field_reserved);; localb = null)
      {
        com.tencent.mm.ah.c localc;
        ya localya;
        label350:
        Object localObject;
        int i;
        int j;
        if (localb != null)
        {
          localc = (com.tencent.mm.ah.c)localb.ao(com.tencent.mm.ah.c.class);
          boolean bool2 = "1001".equals(localb.hjn);
          localya = new ya();
          if ((!bs.isNullOrNil(localb.hjo)) && (!bool2))
          {
            localya.dBw.dBy = localb.hjo;
            com.tencent.mm.sdk.b.a.GpY.l(localya);
          }
          f.a.aG(locala.nDl, locala.IjS);
          if (!"1001".equals(localb.hjn)) {
            break label956;
          }
          paramString = locala.nDl;
          if (parambo.field_isSend != 1) {
            break label950;
          }
          bool1 = true;
          paramString.setBackgroundResource(com.tencent.mm.ui.chatting.f.c(localb, bool1));
          locala.Ikq.setTypeface(Typeface.defaultFromStyle(1));
          locala.iCJ.setVisibility(0);
          locala.Iks.setTextColor(parama1.HZF.getContext().getResources().getColor(2131099828));
          locala.Iks.setAlpha(0.7F);
          parama1.HZF.getContext().getResources().getDimensionPixelSize(2131165568);
          parama1.HZF.getContext().getResources().getDimensionPixelSize(2131166006);
          locala.nDl.setPadding(0, 0, 0, 0);
          if (parambo.field_isSend != 1) {
            break label1109;
          }
          paramString = localb.hji;
          if (!bs.isNullOrNil(paramString)) {
            break label1119;
          }
          paramString = localb.description;
          locala.Ikq.setSingleLine(false);
          locala.Ikq.setMaxLines(3);
          locala.Ikq.setText(k.b(parama1.HZF.getContext(), paramString, locala.Ikx));
          locala.Ikq.setTextSize(0, locala.Ikx);
          if (!bool2) {
            break label1137;
          }
          localObject = locala.Ikr;
          paramString = parama1.HZF.getContext();
          if (parambo.field_isSend != 1) {
            break label1131;
          }
          bool1 = true;
          paramString = k.b(paramString, com.tencent.mm.ui.chatting.f.b(localb, bool1), locala.Ikr.getTextSize());
          ((TextView)localObject).setText(paramString);
          locala.Ikr.setVisibility(0);
          localObject = localb.hjl;
          paramString = (String)localObject;
          if (bs.isNullOrNil((String)localObject)) {
            paramString = localb.title;
          }
          locala.Iks.setText(paramString);
          i = 0;
          if (!bs.isNullOrNil(localc.hgL))
          {
            o.aFB().loadImage("", locala.Ikp);
            j = parama1.HZF.getMMResources().getIdentifier(localc.hgL, "drawable", ai.getPackageName());
            i = j;
            if (j <= 0) {
              i = parama1.HZF.getMMResources().getIdentifier(localc.hgL, "raw", ai.getPackageName());
            }
          }
          ac.i("MicroMsg.ChattingItemAppMsgC2CFrom", "c2c loaclResId: %s", new Object[] { Integer.valueOf(i) });
          if (i > 0)
          {
            ac.i("MicroMsg.ChattingItemAppMsgC2CFrom", "set c2cIcon from localRes");
            locala.Ikp.setImageResource(i);
          }
          if (!"1001".equals(localb.hjn)) {
            break label1286;
          }
          if (parambo.field_isSend != 1) {
            break label1280;
          }
          bool1 = true;
          j = com.tencent.mm.ui.chatting.f.a(localb, bool1);
          if (j <= 0) {
            break label1338;
          }
          ac.i("MicroMsg.ChattingItemAppMsgC2CFrom", "set c2cIcon from iconRes");
          locala.Ikp.setImageResource(j);
          i = -1;
          if (!bs.isNullOrNil(localc.hgM)) {
            i = parama1.HZF.getMMResources().getIdentifier(localc.hgM, "drawable", ai.getPackageName());
          }
          ac.i("MicroMsg.ChattingItemAppMsgC2CFrom", "backgroundResId: %s", new Object[] { Integer.valueOf(i) });
          if (i > 0) {
            locala.nDl.setBackgroundResource(i);
          }
          i = localya.dBx.dBA;
          j = localya.dBx.dBB;
          if (parambo.field_isSend != 1) {
            break label1453;
          }
        }
        for (boolean bool1 = true;; bool1 = false)
        {
          f.a(locala, localc, true, com.tencent.mm.ui.chatting.f.F(i, j, bool1), parama1.getTalkerUserName(), parambo);
          parama.nDl.setOnClickListener(d(parama1));
          if (!w.wC(parama1.getTalkerUserName())) {
            parama.nDl.setOnLongClickListener(c(parama1));
          }
          parama.nDl.setOnTouchListener(((i)parama1.bf(i.class)).fmb());
          parambo = new bj(parambo, this.HNS.foQ(), paramInt, null, '\000');
          parama.nDl.setTag(parambo);
          if (((f.a)parama).ofC == null) {
            break label1494;
          }
          if (!aj.DT()) {
            break label1459;
          }
          ((f.a)parama).ofC.setBackground(null);
          ((f.a)parama).iCJ.setVisibility(0);
          AppMethodBeat.o(36849);
          return;
          locala.IkA = false;
          break;
          bool1 = false;
          break label191;
          paramString = locala.nDl;
          i = localya.dBx.dBA;
          j = localya.dBx.dBB;
          if (parambo.field_isSend == 1)
          {
            bool1 = true;
            label995:
            paramString.setBackgroundResource(com.tencent.mm.ui.chatting.f.D(i, j, bool1));
            locala.Ikq.setTypeface(Typeface.defaultFromStyle(1));
            if (locala.Ikx <= locala.maxSize) {
              break label1099;
            }
          }
          for (i = locala.maxSize;; i = locala.Ikx)
          {
            locala.Ikx = i;
            locala.iCJ.setVisibility(0);
            locala.Iks.setTextColor(parama1.HZF.getContext().getResources().getColor(2131099828));
            locala.Iks.setAlpha(0.7F);
            break;
            bool1 = false;
            break label995;
          }
          paramString = localb.hjh;
          break label317;
          label1119:
          locala.Ikq.setSingleLine(true);
          break label350;
          label1131:
          bool1 = false;
          break label423;
          label1137:
          if (!bs.isNullOrNil(localb.hjo))
          {
            i = localya.dBx.dBz;
            j = localya.dBx.dBA;
            k = localya.dBx.dBB;
            if (parambo.field_isSend == 1) {}
            for (bool1 = true;; bool1 = false)
            {
              paramString = com.tencent.mm.ui.chatting.f.b(i, j, k, bool1, parama1.foQ());
              if (bs.isNullOrNil(paramString)) {
                break label1231;
              }
              localObject = locala.Ikr;
              break;
            }
            locala.Ikr.setVisibility(8);
            break label461;
          }
          localObject = locala.Ikr;
          if (parambo.field_isSend == 1)
          {
            paramString = localb.hjj;
            break label445;
          }
          paramString = localb.hjk;
          break label445;
          bool1 = false;
          break label650;
          j = localya.dBx.dBA;
          int k = localya.dBx.dBB;
          if (parambo.field_isSend == 1) {}
          for (bool1 = true;; bool1 = false)
          {
            j = com.tencent.mm.ui.chatting.f.E(j, k, bool1);
            break;
          }
          if (i > 0) {
            break label683;
          }
          ac.i("MicroMsg.ChattingItemAppMsgC2CFrom", "set c2cIcon from c2cIconUrl");
          localObject = localb.hjg;
          paramString = (String)localObject;
          if (bs.isNullOrNil((String)localObject)) {
            paramString = localb.thumburl;
          }
          locala.Ikp.setImageBitmap(null);
          if (bs.isNullOrNil(paramString)) {
            break label683;
          }
          localObject = new com.tencent.mm.av.a.a.c.a();
          az.ayM();
          ((com.tencent.mm.av.a.a.c.a)localObject).prefixPath = com.tencent.mm.model.c.awM();
          ((com.tencent.mm.av.a.a.c.a)localObject).hKx = true;
          ((com.tencent.mm.av.a.a.c.a)localObject).gKm = true;
          localObject = ((com.tencent.mm.av.a.a.c.a)localObject).aFT();
          o.aFB().a(paramString, locala.Ikp, (com.tencent.mm.av.a.a.c)localObject);
          break label683;
        }
        ((f.a)parama).ofC.setBackground(parama1.HZF.getMMResources().getDrawable(2131231681));
        ((f.a)parama).iCJ.setVisibility(8);
        AppMethodBeat.o(36849);
        return;
      }
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
    {
      AppMethodBeat.i(36850);
      int i = ((bj)paramView.getTag()).position;
      paramContextMenu.add(i, 100, 0, this.HNS.HZF.getMMResources().getString(2131757221));
      if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (bt.eWo())) {
        paramContextMenu.add(i, 144, 0, paramView.getContext().getString(2131761225));
      }
      AppMethodBeat.o(36850);
      return false;
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
    {
      AppMethodBeat.i(36851);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(36851);
        return false;
      case 100: 
        AppMethodBeat.o(36851);
        return true;
      }
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Chat_Msg_Id", parambo.field_msgId);
      com.tencent.mm.br.d.b(parama.HZF.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
      AppMethodBeat.o(36851);
      return true;
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
    {
      int j = 2;
      AppMethodBeat.i(36852);
      ((b)com.tencent.mm.kernel.g.ab(b.class)).Wm(parambo.field_talker);
      paramView = parambo.field_content;
      if (paramView != null) {}
      for (paramView = k.b.az(paramView, parambo.field_reserved);; paramView = null)
      {
        Object localObject1;
        if (paramView != null)
        {
          if (!bs.isNullOrNil(paramView.hjf)) {
            break label202;
          }
          localObject1 = paramView.url;
          ac.i("MicroMsg.ChattingItemAppMsgC2CFrom", "url==null: %s, billNo==null: %s", new Object[] { Boolean.valueOf(bs.isNullOrNil((String)localObject1)), Boolean.valueOf(bs.isNullOrNil(paramView.hjw)) });
          if (bs.isNullOrNil(paramView.hjo)) {
            break label696;
          }
          if (!paramView.hjo.startsWith("weixin://openNativeUrl/weixinHB/startreceivebizhbrequest")) {
            break label211;
          }
          parambo = new Intent();
          parambo.putExtra("key_way", 1);
          parambo.putExtra("key_native_url", paramView.hjo);
          parambo.putExtra("key_username", parama.getTalkerUserName());
          parambo.putExtra("key_static_from_scene", 100002);
          com.tencent.mm.br.d.b(parama.HZF.getContext(), "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", parambo);
        }
        label202:
        label211:
        Object localObject2;
        label243:
        Object localObject3;
        do
        {
          AppMethodBeat.o(36852);
          return true;
          localObject1 = paramView.hjf;
          break;
          if (!paramView.hjo.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao")) {
            break label613;
          }
          localObject2 = new Intent();
          if (!parama.foQ()) {
            break label601;
          }
          i = 0;
          ((Intent)localObject2).putExtra("key_way", i);
          ((Intent)localObject2).putExtra("key_native_url", paramView.hjo);
          ((Intent)localObject2).putExtra("key_username", parama.getTalkerUserName());
          localObject1 = (com.tencent.mm.ah.c)paramView.ao(com.tencent.mm.ah.c.class);
          localObject3 = (com.tencent.mm.ah.g)paramView.ao(com.tencent.mm.ah.g.class);
          ((Intent)localObject2).putExtra("key_cropname", ((com.tencent.mm.ah.c)localObject1).hgO);
          ((Intent)localObject2).putExtra("key_receive_envelope_url", ((com.tencent.mm.ah.c)localObject1).hgT);
          ((Intent)localObject2).putExtra("key_receive_envelope_md5", ((com.tencent.mm.ah.c)localObject1).hgU);
          ((Intent)localObject2).putExtra("key_detail_envelope_url", ((com.tencent.mm.ah.c)localObject1).hgV);
          ((Intent)localObject2).putExtra("key_detail_envelope_md5", ((com.tencent.mm.ah.c)localObject1).hgW);
          ((Intent)localObject2).putExtra("key_about_url", ((com.tencent.mm.ah.g)localObject3).hhq);
          ((Intent)localObject2).putExtra("key_packet_id", ((com.tencent.mm.ah.g)localObject3).hhr);
          ((Intent)localObject2).putExtra("key_has_story", ((com.tencent.mm.ah.g)localObject3).hhu);
          ((Intent)localObject2).putExtra("key_material_flag", ((com.tencent.mm.ah.g)localObject3).hhv);
          ((Intent)localObject2).putExtra("key_msgid", parambo.field_msgId);
          ((Intent)localObject2).putExtra("key_emoji_md5", ((com.tencent.mm.ah.d)paramView.ao(com.tencent.mm.ah.d.class)).fPB.field_md5);
          com.tencent.mm.br.d.b(parama.HZF.getContext(), "luckymoney", ".ui.LuckyMoneyNotHookReceiveUI", (Intent)localObject2);
          if (w.wC(parama.getTalkerUserName())) {
            com.tencent.mm.plugin.luckymoney.a.d.tn(1);
          }
        } while (!((com.tencent.mm.ah.c)localObject1).hgX.hhu);
        if (!bs.isNullOrNil(((com.tencent.mm.ah.c)localObject1).hgX.hhs)) {}
        for (int i = 2;; i = 1)
        {
          paramView = parambo.sessionId;
          localObject2 = ((com.tencent.mm.ah.c)localObject1).hgO;
          parama = parama.getTalkerUserName();
          localObject3 = ((com.tencent.mm.ah.c)localObject1).hgX.hhr;
          if (((com.tencent.mm.ah.c)localObject1).hgX.hhu) {}
          for (;;)
          {
            com.tencent.mm.plugin.luckymoney.a.c.a(paramView, (String)localObject2, parama, (String)localObject3, j, i);
            com.tencent.mm.plugin.luckymoney.a.c.bn(10, ((com.tencent.mm.ah.c)localObject1).hgP);
            parambo.sessionId = UUID.randomUUID().toString();
            break;
            label601:
            i = 1;
            break label243;
            j = 1;
          }
          label613:
          ac.i("MicroMsg.ChattingItemAppMsgC2CFrom", "native url not match:" + paramView.hjo + ", go webview:" + (String)localObject1);
          if (bs.isNullOrNil((String)localObject1)) {
            break;
          }
          paramView = new Intent();
          paramView.putExtra("rawUrl", (String)localObject1);
          com.tencent.mm.br.d.b(parama.HZF.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
          break;
          label696:
          if (!bs.isNullOrNil(paramView.hjw))
          {
            ac.i("MicroMsg.ChattingItemAppMsgC2CFrom", "tofuliu billNo: %s, c2cNewAAType: %s, fromUser: %s", new Object[] { paramView.hjw, Integer.valueOf(paramView.hjx), paramView.dng });
            parambo = new Intent();
            parambo.putExtra("bill_no", paramView.hjw);
            parambo.putExtra("launcher_user_name", paramView.dng);
            parambo.putExtra("enter_scene", 1);
            parambo.putExtra("chatroom", parama.getTalkerUserName());
            com.tencent.mm.br.d.b(parama.HZF.getContext(), "aa", ".ui.PaylistAAUI", parambo);
            if (com.tencent.mm.ui.chatting.f.g(paramView).role == 2)
            {
              com.tencent.mm.plugin.report.service.h.wUl.f(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(2) });
              break;
            }
            com.tencent.mm.plugin.report.service.h.wUl.f(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(3) });
            break;
          }
          if (bs.isNullOrNil((String)localObject1)) {
            break;
          }
          paramView = new Intent();
          paramView.putExtra("rawUrl", (String)localObject1);
          com.tencent.mm.br.d.b(parama.HZF.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
          break;
        }
      }
    }
    
    public final boolean bb(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 436207665);
    }
    
    public final boolean fqu()
    {
      return false;
    }
    
    final boolean fqv()
    {
      return false;
    }
  }
  
  public static final class c
    extends c
  {
    private com.tencent.mm.ui.chatting.d.a HNS;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(36854);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new ag(paramLayoutInflater, 2131493477);
        ((View)localObject).setTag(new f.a().ga((View)localObject));
      }
      AppMethodBeat.o(36854);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
    {
      AppMethodBeat.i(36855);
      this.HNS = parama1;
      f.a locala = (f.a)parama;
      if (locala.Ikz == parambo.field_msgId)
      {
        locala.IkA = true;
        locala.Ikz = parambo.field_msgId;
        paramString = parambo.field_content;
        if (paramString == null) {
          break label1497;
        }
      }
      label191:
      label458:
      label1106:
      label1491:
      label1497:
      for (k.b localb = k.b.az(paramString, parambo.field_reserved);; localb = null)
      {
        com.tencent.mm.ah.c localc;
        ya localya;
        label347:
        Object localObject;
        int i;
        int j;
        if (localb != null)
        {
          localc = (com.tencent.mm.ah.c)localb.ao(com.tencent.mm.ah.c.class);
          boolean bool2 = "1001".equals(localb.hjn);
          localya = new ya();
          if ((!bs.isNullOrNil(localb.hjo)) && (!bool2))
          {
            localya.dBw.dBy = localb.hjo;
            com.tencent.mm.sdk.b.a.GpY.l(localya);
          }
          f.a.aG(locala.nDl, locala.IjS);
          if (!"1001".equals(localb.hjn)) {
            break label953;
          }
          paramString = locala.nDl;
          if (parambo.field_isSend != 1) {
            break label947;
          }
          bool1 = true;
          paramString.setBackgroundResource(com.tencent.mm.ui.chatting.f.c(localb, bool1));
          locala.Ikq.setTypeface(Typeface.defaultFromStyle(1));
          locala.iCJ.setVisibility(0);
          locala.Iks.setTextColor(parama1.HZF.getContext().getResources().getColor(2131099828));
          locala.Iks.setAlpha(0.7F);
          com.tencent.mm.cc.a.fromDPToPix(parama1.HZF.getContext(), 13);
          parama1.HZF.getContext().getResources().getDimensionPixelSize(2131165500);
          locala.nDl.setPadding(0, 0, 0, 0);
          if (parambo.field_isSend != 1) {
            break label1106;
          }
          paramString = localb.hji;
          if (!bs.isNullOrNil(paramString)) {
            break label1116;
          }
          paramString = localb.description;
          locala.Ikq.setSingleLine(false);
          locala.Ikq.setMaxLines(3);
          locala.Ikq.setText(k.b(parama1.HZF.getContext(), paramString, locala.Ikx));
          locala.Ikq.setTextSize(0, locala.Ikx);
          if (!bool2) {
            break label1134;
          }
          localObject = locala.Ikr;
          paramString = parama1.HZF.getContext();
          if (parambo.field_isSend != 1) {
            break label1128;
          }
          bool1 = true;
          paramString = k.b(paramString, com.tencent.mm.ui.chatting.f.b(localb, bool1), locala.Ikr.getTextSize());
          ((TextView)localObject).setText(paramString);
          locala.Ikr.setVisibility(0);
          localObject = localb.hjl;
          paramString = (String)localObject;
          if (bs.isNullOrNil((String)localObject)) {
            paramString = localb.title;
          }
          locala.Iks.setText(paramString);
          i = 0;
          if (!bs.isNullOrNil(localc.hgL))
          {
            o.aFB().loadImage("", locala.Ikp);
            j = parama1.HZF.getMMResources().getIdentifier(localc.hgL, "drawable", ai.getPackageName());
            i = j;
            if (j <= 0) {
              i = parama1.HZF.getMMResources().getIdentifier(localc.hgL, "raw", ai.getPackageName());
            }
          }
          ac.v("MicroMsg.ChattingItemAppMsgC2CTo", "c2c localResId: %s", new Object[] { Integer.valueOf(i) });
          if (i > 0)
          {
            ac.v("MicroMsg.ChattingItemAppMsgC2CTo", "set c2cIcon from localRes");
            locala.Ikp.setImageResource(i);
          }
          if (!"1001".equals(localb.hjn)) {
            break label1283;
          }
          if (parambo.field_isSend != 1) {
            break label1277;
          }
          bool1 = true;
          j = com.tencent.mm.ui.chatting.f.a(localb, bool1);
          if (j <= 0) {
            break label1335;
          }
          ac.i("MicroMsg.ChattingItemAppMsgC2CTo", "set c2cIcon from iconRes");
          locala.Ikp.setImageResource(j);
          i = -1;
          if (!bs.isNullOrNil(localc.hgM)) {
            i = parama1.HZF.getMMResources().getIdentifier(localc.hgM, "drawable", ai.getPackageName());
          }
          ac.i("MicroMsg.ChattingItemAppMsgC2CTo", "backgroundResId: %s", new Object[] { Integer.valueOf(i) });
          if (i > 0) {
            locala.nDl.setBackgroundResource(i);
          }
          i = localya.dBx.dBA;
          j = localya.dBx.dBB;
          if (parambo.field_isSend != 1) {
            break label1450;
          }
        }
        for (boolean bool1 = true;; bool1 = false)
        {
          f.a(locala, localc, false, com.tencent.mm.ui.chatting.f.F(i, j, bool1), parama1.getTalkerUserName(), parambo);
          parama.nDl.setOnClickListener(d(parama1));
          if (!w.wC(parama1.getTalkerUserName())) {
            parama.nDl.setOnLongClickListener(c(parama1));
          }
          parama.nDl.setOnTouchListener(((i)parama1.bf(i.class)).fmb());
          parambo = new bj(parambo, this.HNS.foQ(), paramInt, null, '\000');
          parama.nDl.setTag(parambo);
          if (((f.a)parama).ofC == null) {
            break label1491;
          }
          if (!aj.DT()) {
            break label1456;
          }
          ((f.a)parama).ofC.setBackground(null);
          ((f.a)parama).iCJ.setVisibility(0);
          AppMethodBeat.o(36855);
          return;
          locala.IkA = false;
          break;
          bool1 = false;
          break label191;
          paramString = locala.nDl;
          i = localya.dBx.dBA;
          j = localya.dBx.dBB;
          if (parambo.field_isSend == 1)
          {
            bool1 = true;
            label992:
            paramString.setBackgroundResource(com.tencent.mm.ui.chatting.f.D(i, j, bool1));
            locala.Ikq.setTypeface(Typeface.defaultFromStyle(1));
            if (locala.Ikx <= locala.maxSize) {
              break label1096;
            }
          }
          for (i = locala.maxSize;; i = locala.Ikx)
          {
            locala.Ikx = i;
            locala.iCJ.setVisibility(0);
            locala.Iks.setTextColor(parama1.HZF.getContext().getResources().getColor(2131099828));
            locala.Iks.setAlpha(0.7F);
            break;
            bool1 = false;
            break label992;
          }
          paramString = localb.hjh;
          break label314;
          label1116:
          locala.Ikq.setSingleLine(true);
          break label347;
          label1128:
          bool1 = false;
          break label420;
          label1134:
          if (!bs.isNullOrNil(localb.hjo))
          {
            i = localya.dBx.dBz;
            j = localya.dBx.dBA;
            k = localya.dBx.dBB;
            if (parambo.field_isSend == 1) {}
            for (bool1 = true;; bool1 = false)
            {
              paramString = com.tencent.mm.ui.chatting.f.b(i, j, k, bool1, parama1.foQ());
              if (bs.isNullOrNil(paramString)) {
                break label1228;
              }
              localObject = locala.Ikr;
              break;
            }
            locala.Ikr.setVisibility(8);
            break label458;
          }
          localObject = locala.Ikr;
          if (parambo.field_isSend == 1)
          {
            paramString = localb.hjj;
            break label442;
          }
          paramString = localb.hjk;
          break label442;
          label1277:
          bool1 = false;
          break label647;
          j = localya.dBx.dBA;
          int k = localya.dBx.dBB;
          if (parambo.field_isSend == 1) {}
          for (bool1 = true;; bool1 = false)
          {
            j = com.tencent.mm.ui.chatting.f.E(j, k, bool1);
            break;
          }
          if (i > 0) {
            break label680;
          }
          ac.i("MicroMsg.ChattingItemAppMsgC2CTo", "set c2cIcon from iconUrl");
          localObject = localb.hjg;
          paramString = (String)localObject;
          if (bs.isNullOrNil((String)localObject)) {
            paramString = localb.thumburl;
          }
          locala.Ikp.setImageBitmap(null);
          if (bs.isNullOrNil(paramString)) {
            break label680;
          }
          localObject = new com.tencent.mm.av.a.a.c.a();
          az.ayM();
          ((com.tencent.mm.av.a.a.c.a)localObject).prefixPath = com.tencent.mm.model.c.awM();
          ((com.tencent.mm.av.a.a.c.a)localObject).hKx = true;
          ((com.tencent.mm.av.a.a.c.a)localObject).gKm = true;
          localObject = ((com.tencent.mm.av.a.a.c.a)localObject).aFT();
          o.aFB().a(paramString, locala.Ikp, (com.tencent.mm.av.a.a.c)localObject);
          break label680;
        }
        ((f.a)parama).ofC.setBackground(parama1.HZF.getMMResources().getDrawable(2131231681));
        ((f.a)parama).iCJ.setVisibility(8);
        AppMethodBeat.o(36855);
        return;
      }
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
    {
      AppMethodBeat.i(36856);
      int i = ((bj)paramView.getTag()).position;
      paramContextMenu.add(i, 100, 0, this.HNS.HZF.getMMResources().getString(2131757221));
      if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (bt.eWo())) {
        paramContextMenu.add(i, 144, 0, paramView.getContext().getString(2131761225));
      }
      AppMethodBeat.o(36856);
      return false;
    }
    
    public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.d.a parama, final bo parambo)
    {
      AppMethodBeat.i(36857);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(36857);
        return false;
      case 103: 
        final String str1 = parambo.field_content;
        paramMenuItem = null;
        if (str1 != null) {
          paramMenuItem = k.b.az(str1, parambo.field_reserved);
        }
        if (paramMenuItem != null)
        {
          parambo = parambo.field_talker;
          str1 = paramMenuItem.hjh;
          final String str2 = paramMenuItem.hji;
          final String str3 = paramMenuItem.hjj;
          final String str4 = paramMenuItem.hjk;
          final String str5 = paramMenuItem.hjf;
          final String str6 = paramMenuItem.hjm;
          paramMenuItem = paramMenuItem.hjn;
          com.tencent.mm.ui.base.h.d(parama.HZF.getContext(), parama.HZF.getMMResources().getString(2131757285), parama.HZF.getMMResources().getString(2131755873), parama.HZF.getMMResources().getString(2131757286), parama.HZF.getMMResources().getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(36853);
              paramAnonymousDialogInterface = new Intent();
              paramAnonymousDialogInterface.putExtra("key_scene", 1);
              paramAnonymousDialogInterface.putExtra("key_receiver", parambo);
              paramAnonymousDialogInterface.putExtra("key_receivertitle", str1);
              paramAnonymousDialogInterface.putExtra("key_sendertitle", str2);
              paramAnonymousDialogInterface.putExtra("key_sender_des", str3);
              paramAnonymousDialogInterface.putExtra("key_receiver_des", str4);
              paramAnonymousDialogInterface.putExtra("key_url", str5);
              paramAnonymousDialogInterface.putExtra("key_templateid", str6);
              paramAnonymousDialogInterface.putExtra("key_sceneid", paramMenuItem);
              com.tencent.mm.br.d.b(parama.HZF.getContext(), "wallet_index", ".ui.WalletSendC2CMsgUI", paramAnonymousDialogInterface);
              AppMethodBeat.o(36853);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
        }
        AppMethodBeat.o(36857);
        return true;
      }
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Chat_Msg_Id", parambo.field_msgId);
      com.tencent.mm.br.d.b(parama.HZF.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
      AppMethodBeat.o(36857);
      return true;
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
    {
      int j = 2;
      AppMethodBeat.i(36858);
      ((b)com.tencent.mm.kernel.g.ab(b.class)).Wm(parambo.field_talker);
      paramView = parambo.field_content;
      if (paramView != null) {}
      for (paramView = k.b.az(paramView, parambo.field_reserved);; paramView = null)
      {
        Object localObject1;
        if (paramView != null)
        {
          if (!bs.isNullOrNil(paramView.hjf)) {
            break label202;
          }
          localObject1 = paramView.url;
          ac.i("MicroMsg.ChattingItemAppMsgC2CTo", "url==null: %s, billNo==null: %s", new Object[] { Boolean.valueOf(bs.isNullOrNil((String)localObject1)), Boolean.valueOf(bs.isNullOrNil(paramView.hjw)) });
          if (bs.isNullOrNil(paramView.hjo)) {
            break label652;
          }
          if (!paramView.hjo.startsWith("weixin://openNativeUrl/weixinHB/startreceivebizhbrequest")) {
            break label211;
          }
          parambo = new Intent();
          parambo.putExtra("key_way", 1);
          parambo.putExtra("key_native_url", paramView.hjo);
          parambo.putExtra("key_username", parama.getTalkerUserName());
          parambo.putExtra("key_static_from_scene", 100002);
          com.tencent.mm.br.d.b(parama.HZF.getContext(), "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", parambo);
        }
        label202:
        label211:
        Object localObject2;
        label243:
        do
        {
          AppMethodBeat.o(36858);
          return true;
          localObject1 = paramView.hjf;
          break;
          if (!paramView.hjo.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao")) {
            break label569;
          }
          localObject2 = new Intent();
          if (!parama.foQ()) {
            break label557;
          }
          i = 0;
          ((Intent)localObject2).putExtra("key_way", i);
          ((Intent)localObject2).putExtra("key_native_url", paramView.hjo);
          ((Intent)localObject2).putExtra("key_username", parama.getTalkerUserName());
          localObject1 = (com.tencent.mm.ah.c)paramView.ao(com.tencent.mm.ah.c.class);
          paramView = (com.tencent.mm.ah.g)paramView.ao(com.tencent.mm.ah.g.class);
          ((Intent)localObject2).putExtra("key_cropname", ((com.tencent.mm.ah.c)localObject1).hgO);
          ((Intent)localObject2).putExtra("key_receive_envelope_url", ((com.tencent.mm.ah.c)localObject1).hgT);
          ((Intent)localObject2).putExtra("key_receive_envelope_md5", ((com.tencent.mm.ah.c)localObject1).hgU);
          ((Intent)localObject2).putExtra("key_detail_envelope_url", ((com.tencent.mm.ah.c)localObject1).hgV);
          ((Intent)localObject2).putExtra("key_detail_envelope_md5", ((com.tencent.mm.ah.c)localObject1).hgW);
          ((Intent)localObject2).putExtra("key_about_url", paramView.hhq);
          ((Intent)localObject2).putExtra("key_packet_id", paramView.hhr);
          ((Intent)localObject2).putExtra("key_has_story", paramView.hhu);
          ((Intent)localObject2).putExtra("key_material_flag", paramView.hhv);
          ((Intent)localObject2).putExtra("key_msgid", parambo.field_msgId);
          com.tencent.mm.br.d.b(parama.HZF.getContext(), "luckymoney", ".ui.LuckyMoneyNotHookReceiveUI", (Intent)localObject2);
        } while (!((com.tencent.mm.ah.c)localObject1).hgX.hhu);
        if (!bs.isNullOrNil(((com.tencent.mm.ah.c)localObject1).hgX.hhs)) {}
        for (int i = 2;; i = 1)
        {
          paramView = parambo.sessionId;
          localObject2 = ((com.tencent.mm.ah.c)localObject1).hgO;
          parama = parama.getTalkerUserName();
          String str = ((com.tencent.mm.ah.c)localObject1).hgX.hhr;
          if (((com.tencent.mm.ah.c)localObject1).hgX.hhu) {}
          for (;;)
          {
            com.tencent.mm.plugin.luckymoney.a.c.a(paramView, (String)localObject2, parama, str, j, i);
            com.tencent.mm.plugin.luckymoney.a.c.bn(10, ((com.tencent.mm.ah.c)localObject1).hgP);
            parambo.sessionId = UUID.randomUUID().toString();
            break;
            label557:
            i = 1;
            break label243;
            j = 1;
          }
          label569:
          ac.i("MicroMsg.ChattingItemAppMsgC2CTo", "native url not match:" + paramView.hjo + ", go webview:" + (String)localObject1);
          if (bs.isNullOrNil((String)localObject1)) {
            break;
          }
          paramView = new Intent();
          paramView.putExtra("rawUrl", (String)localObject1);
          com.tencent.mm.br.d.b(parama.HZF.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
          break;
          label652:
          if (!bs.isNullOrNil(paramView.hjw))
          {
            ac.i("MicroMsg.ChattingItemAppMsgC2CTo", "tofuliu billNo: %s, c2cNewAAType: %s, fromUser: %s", new Object[] { paramView.hjw, Integer.valueOf(paramView.hjx), paramView.dng });
            parambo = new Intent();
            parambo.putExtra("bill_no", paramView.hjw);
            parambo.putExtra("launcher_user_name", paramView.dng);
            parambo.putExtra("enter_scene", 1);
            parambo.putExtra("chatroom", parama.getTalkerUserName());
            com.tencent.mm.br.d.b(parama.HZF.getContext(), "aa", ".ui.PaylistAAUI", parambo);
            com.tencent.mm.plugin.report.service.h.wUl.f(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
            break;
          }
          if ((bs.isNullOrNil((String)localObject1)) || (bs.isNullOrNil((String)localObject1))) {
            break;
          }
          paramView = new Intent();
          paramView.putExtra("rawUrl", (String)localObject1);
          com.tencent.mm.br.d.b(parama.HZF.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
          break;
        }
      }
    }
    
    public final boolean bb(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 436207665);
    }
    
    public final boolean fqu()
    {
      return true;
    }
    
    final boolean fqv()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.f
 * JD-Core Version:    0.7.0.1
 */