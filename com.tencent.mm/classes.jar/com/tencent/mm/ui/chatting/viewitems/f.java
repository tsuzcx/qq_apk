package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.za;
import com.tencent.mm.g.a.za.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.protocal.protobuf.bom;
import com.tencent.mm.protocal.protobuf.bon;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import java.util.UUID;

public final class f
{
  static final class a
    extends c.a
  {
    public boolean DRM;
    public int KwJ = 0;
    public ImageView Kxg;
    public TextView Kxh;
    public TextView Kxi;
    public TextView Kxj;
    public TextView Kxk;
    public TextView Kxl;
    public ImageView Kxm;
    public ImageView Kxn;
    public int Kxo = 0;
    public int Kxp;
    public long Kxq;
    public View iYM;
    public int maxSize = 0;
    public View oPx;
    public ImageView vLX;
    
    public final a gw(View paramView)
    {
      AppMethodBeat.i(36847);
      super.gs(paramView);
      this.fVV = ((TextView)this.uan.findViewById(2131298178));
      this.iFD = ((CheckBox)this.uan.findViewById(2131298068));
      this.hcH = this.uan.findViewById(2131298147);
      this.yUp = ((TextView)this.uan.findViewById(2131298185));
      this.oPx = this.uan.findViewById(2131300196);
      this.iYM = ((ImageView)this.uan.findViewById(2131299154));
      this.Kxg = ((ImageView)this.uan.findViewById(2131296913));
      this.Kxh = ((TextView)this.uan.findViewById(2131296919));
      this.Kxi = ((TextView)this.uan.findViewById(2131296911));
      this.Kxj = ((TextView)this.uan.findViewById(2131296922));
      this.olI = this.uan.findViewById(2131298069);
      this.vLX = ((ImageView)this.uan.findViewById(2131298120));
      this.Kxl = ((TextView)this.uan.findViewById(2131296921));
      this.Kxk = ((TextView)this.uan.findViewById(2131307149));
      this.Kxm = ((ImageView)this.uan.findViewById(2131298121));
      this.Kxn = ((ImageView)this.uan.findViewById(2131296920));
      this.iYM = this.uan.findViewById(2131296912);
      this.KwJ = c.ku(ak.getContext());
      this.Kxo = com.tencent.mm.cb.a.ax(ak.getContext(), 2131165217);
      this.maxSize = ((int)(com.tencent.mm.cb.a.ay(ak.getContext(), 2131165217) * 1.45F));
      this.Kxp = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 20);
      AppMethodBeat.o(36847);
      return this;
    }
  }
  
  public static final class b
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a JWz;
    
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
        localObject = new ah(paramLayoutInflater, 2131493432);
        ((View)localObject).setTag(new f.a().gw((View)localObject));
      }
      AppMethodBeat.o(36848);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, com.tencent.mm.storage.bv parambv, String paramString)
    {
      AppMethodBeat.i(36849);
      this.JWz = parama1;
      f.a locala = (f.a)parama;
      if (locala.Kxq == parambv.field_msgId)
      {
        locala.DRM = true;
        locala.Kxq = parambv.field_msgId;
        paramString = parambv.field_content;
        if (paramString == null) {
          break label1500;
        }
      }
      label191:
      label461:
      label1109:
      label1494:
      label1500:
      for (k.b localb = k.b.aB(paramString, parambv.field_reserved);; localb = null)
      {
        com.tencent.mm.ah.c localc;
        za localza;
        label350:
        Object localObject;
        int i;
        int j;
        if (localb != null)
        {
          localc = (com.tencent.mm.ah.c)localb.ao(com.tencent.mm.ah.c.class);
          boolean bool2 = "1001".equals(localb.hEk);
          localza = new za();
          if ((!bu.isNullOrNil(localb.hEl)) && (!bool2))
          {
            localza.dOZ.dPb = localb.hEl;
            com.tencent.mm.sdk.b.a.IvT.l(localza);
          }
          f.a.aI(locala.olI, locala.KwJ);
          if (!"1001".equals(localb.hEk)) {
            break label956;
          }
          paramString = locala.olI;
          if (parambv.field_isSend != 1) {
            break label950;
          }
          bool1 = true;
          paramString.setBackgroundResource(com.tencent.mm.ui.chatting.f.c(localb, bool1));
          locala.Kxh.setTypeface(Typeface.defaultFromStyle(1));
          locala.iYM.setVisibility(0);
          locala.Kxj.setTextColor(parama1.Kkd.getContext().getResources().getColor(2131099828));
          locala.Kxj.setAlpha(0.7F);
          parama1.Kkd.getContext().getResources().getDimensionPixelSize(2131165568);
          parama1.Kkd.getContext().getResources().getDimensionPixelSize(2131166006);
          locala.olI.setPadding(0, 0, 0, 0);
          if (parambv.field_isSend != 1) {
            break label1109;
          }
          paramString = localb.hEf;
          if (!bu.isNullOrNil(paramString)) {
            break label1119;
          }
          paramString = localb.description;
          locala.Kxh.setSingleLine(false);
          locala.Kxh.setMaxLines(3);
          locala.Kxh.setText(com.tencent.mm.pluginsdk.ui.span.k.b(parama1.Kkd.getContext(), paramString, locala.Kxo));
          locala.Kxh.setTextSize(0, locala.Kxo);
          if (!bool2) {
            break label1137;
          }
          localObject = locala.Kxi;
          paramString = parama1.Kkd.getContext();
          if (parambv.field_isSend != 1) {
            break label1131;
          }
          bool1 = true;
          paramString = com.tencent.mm.pluginsdk.ui.span.k.b(paramString, com.tencent.mm.ui.chatting.f.b(localb, bool1), locala.Kxi.getTextSize());
          ((TextView)localObject).setText(paramString);
          locala.Kxi.setVisibility(0);
          localObject = localb.hEi;
          paramString = (String)localObject;
          if (bu.isNullOrNil((String)localObject)) {
            paramString = localb.title;
          }
          locala.Kxj.setText(paramString);
          i = 0;
          if (!bu.isNullOrNil(localc.hBI))
          {
            q.aJb().loadImage("", locala.Kxg);
            j = parama1.Kkd.getMMResources().getIdentifier(localc.hBI, "drawable", ak.getPackageName());
            i = j;
            if (j <= 0) {
              i = parama1.Kkd.getMMResources().getIdentifier(localc.hBI, "raw", ak.getPackageName());
            }
          }
          ae.i("MicroMsg.ChattingItemAppMsgC2CFrom", "c2c loaclResId: %s", new Object[] { Integer.valueOf(i) });
          if (i > 0)
          {
            ae.i("MicroMsg.ChattingItemAppMsgC2CFrom", "set c2cIcon from localRes");
            locala.Kxg.setImageResource(i);
          }
          if (!"1001".equals(localb.hEk)) {
            break label1286;
          }
          if (parambv.field_isSend != 1) {
            break label1280;
          }
          bool1 = true;
          j = com.tencent.mm.ui.chatting.f.a(localb, bool1);
          if (j <= 0) {
            break label1338;
          }
          ae.i("MicroMsg.ChattingItemAppMsgC2CFrom", "set c2cIcon from iconRes");
          locala.Kxg.setImageResource(j);
          i = -1;
          if (!bu.isNullOrNil(localc.hBJ)) {
            i = parama1.Kkd.getMMResources().getIdentifier(localc.hBJ, "drawable", ak.getPackageName());
          }
          ae.i("MicroMsg.ChattingItemAppMsgC2CFrom", "backgroundResId: %s", new Object[] { Integer.valueOf(i) });
          if (i > 0) {
            locala.olI.setBackgroundResource(i);
          }
          i = localza.dPa.dPd;
          j = localza.dPa.dPe;
          if (parambv.field_isSend != 1) {
            break label1453;
          }
        }
        for (boolean bool1 = true;; bool1 = false)
        {
          f.a(locala, localc, true, com.tencent.mm.ui.chatting.f.G(i, j, bool1), parama1.getTalkerUserName(), parambv);
          parama.olI.setOnClickListener(d(parama1));
          if (!x.Ai(parama1.getTalkerUserName())) {
            parama.olI.setOnLongClickListener(c(parama1));
          }
          parama.olI.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGw());
          parambv = new bk(parambv, this.JWz.fJC(), paramInt, null, '\000');
          parama.olI.setTag(parambv);
          if (((f.a)parama).oPx == null) {
            break label1494;
          }
          if (!al.isDarkMode()) {
            break label1459;
          }
          ((f.a)parama).oPx.setBackground(null);
          ((f.a)parama).iYM.setVisibility(0);
          AppMethodBeat.o(36849);
          return;
          locala.DRM = false;
          break;
          bool1 = false;
          break label191;
          paramString = locala.olI;
          i = localza.dPa.dPd;
          j = localza.dPa.dPe;
          if (parambv.field_isSend == 1)
          {
            bool1 = true;
            label995:
            paramString.setBackgroundResource(com.tencent.mm.ui.chatting.f.E(i, j, bool1));
            locala.Kxh.setTypeface(Typeface.defaultFromStyle(1));
            if (locala.Kxo <= locala.maxSize) {
              break label1099;
            }
          }
          for (i = locala.maxSize;; i = locala.Kxo)
          {
            locala.Kxo = i;
            locala.iYM.setVisibility(0);
            locala.Kxj.setTextColor(parama1.Kkd.getContext().getResources().getColor(2131099828));
            locala.Kxj.setAlpha(0.7F);
            break;
            bool1 = false;
            break label995;
          }
          paramString = localb.hEe;
          break label317;
          label1119:
          locala.Kxh.setSingleLine(true);
          break label350;
          label1131:
          bool1 = false;
          break label423;
          label1137:
          if (!bu.isNullOrNil(localb.hEl))
          {
            i = localza.dPa.dPc;
            j = localza.dPa.dPd;
            k = localza.dPa.dPe;
            if (parambv.field_isSend == 1) {}
            for (bool1 = true;; bool1 = false)
            {
              paramString = com.tencent.mm.ui.chatting.f.b(i, j, k, bool1, parama1.fJC());
              if (bu.isNullOrNil(paramString)) {
                break label1231;
              }
              localObject = locala.Kxi;
              break;
            }
            locala.Kxi.setVisibility(8);
            break label461;
          }
          localObject = locala.Kxi;
          if (parambv.field_isSend == 1)
          {
            paramString = localb.hEg;
            break label445;
          }
          paramString = localb.hEh;
          break label445;
          bool1 = false;
          break label650;
          j = localza.dPa.dPd;
          int k = localza.dPa.dPe;
          if (parambv.field_isSend == 1) {}
          for (bool1 = true;; bool1 = false)
          {
            j = com.tencent.mm.ui.chatting.f.F(j, k, bool1);
            break;
          }
          if (i > 0) {
            break label683;
          }
          ae.i("MicroMsg.ChattingItemAppMsgC2CFrom", "set c2cIcon from c2cIconUrl");
          localObject = localb.hEd;
          paramString = (String)localObject;
          if (bu.isNullOrNil((String)localObject)) {
            paramString = localb.thumburl;
          }
          locala.Kxg.setImageBitmap(null);
          if (bu.isNullOrNil(paramString)) {
            break label683;
          }
          localObject = new com.tencent.mm.av.a.a.c.a();
          bc.aCg();
          ((com.tencent.mm.av.a.a.c.a)localObject).prefixPath = com.tencent.mm.model.c.azR();
          ((com.tencent.mm.av.a.a.c.a)localObject).igk = true;
          ((com.tencent.mm.av.a.a.c.a)localObject).hgL = true;
          localObject = ((com.tencent.mm.av.a.a.c.a)localObject).aJu();
          q.aJb().a(paramString, locala.Kxg, (com.tencent.mm.av.a.a.c)localObject);
          break label683;
        }
        ((f.a)parama).oPx.setBackground(parama1.Kkd.getMMResources().getDrawable(2131231681));
        ((f.a)parama).iYM.setVisibility(8);
        AppMethodBeat.o(36849);
        return;
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, com.tencent.mm.storage.bv parambv)
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
      paramMenuItem.putExtra("Chat_Msg_Id", parambv.field_msgId);
      com.tencent.mm.br.d.b(parama.Kkd.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
      AppMethodBeat.o(36851);
      return true;
    }
    
    public final boolean a(l paraml, View paramView, com.tencent.mm.storage.bv parambv)
    {
      AppMethodBeat.i(187726);
      int i = ((bk)paramView.getTag()).position;
      paraml.a(i, 100, this.JWz.Kkd.getMMResources().getString(2131757221), 2131690384);
      if ((j.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.bv.fpT())) {
        paraml.a(i, 144, paramView.getContext().getString(2131761225), 2131690202);
      }
      AppMethodBeat.o(187726);
      return false;
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, com.tencent.mm.storage.bv parambv)
    {
      int j = 2;
      AppMethodBeat.i(36852);
      ((b)com.tencent.mm.kernel.g.ab(b.class)).aaK(parambv.field_talker);
      paramView = parambv.field_content;
      if (paramView != null) {}
      for (paramView = k.b.aB(paramView, parambv.field_reserved);; paramView = null)
      {
        Object localObject1;
        if (paramView != null)
        {
          if (!bu.isNullOrNil(paramView.hEc)) {
            break label202;
          }
          localObject1 = paramView.url;
          ae.i("MicroMsg.ChattingItemAppMsgC2CFrom", "url==null: %s, billNo==null: %s", new Object[] { Boolean.valueOf(bu.isNullOrNil((String)localObject1)), Boolean.valueOf(bu.isNullOrNil(paramView.hEt)) });
          if (bu.isNullOrNil(paramView.hEl)) {
            break label696;
          }
          if (!paramView.hEl.startsWith("weixin://openNativeUrl/weixinHB/startreceivebizhbrequest")) {
            break label211;
          }
          parambv = new Intent();
          parambv.putExtra("key_way", 1);
          parambv.putExtra("key_native_url", paramView.hEl);
          parambv.putExtra("key_username", parama.getTalkerUserName());
          parambv.putExtra("key_static_from_scene", 100002);
          com.tencent.mm.br.d.b(parama.Kkd.getContext(), "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", parambv);
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
          localObject1 = paramView.hEc;
          break;
          if (!paramView.hEl.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao")) {
            break label613;
          }
          localObject2 = new Intent();
          if (!parama.fJC()) {
            break label601;
          }
          i = 0;
          ((Intent)localObject2).putExtra("key_way", i);
          ((Intent)localObject2).putExtra("key_native_url", paramView.hEl);
          ((Intent)localObject2).putExtra("key_username", parama.getTalkerUserName());
          localObject1 = (com.tencent.mm.ah.c)paramView.ao(com.tencent.mm.ah.c.class);
          localObject3 = (com.tencent.mm.ah.g)paramView.ao(com.tencent.mm.ah.g.class);
          ((Intent)localObject2).putExtra("key_cropname", ((com.tencent.mm.ah.c)localObject1).hBL);
          ((Intent)localObject2).putExtra("key_receive_envelope_url", ((com.tencent.mm.ah.c)localObject1).hBQ);
          ((Intent)localObject2).putExtra("key_receive_envelope_md5", ((com.tencent.mm.ah.c)localObject1).hBR);
          ((Intent)localObject2).putExtra("key_detail_envelope_url", ((com.tencent.mm.ah.c)localObject1).hBS);
          ((Intent)localObject2).putExtra("key_detail_envelope_md5", ((com.tencent.mm.ah.c)localObject1).hBT);
          ((Intent)localObject2).putExtra("key_about_url", ((com.tencent.mm.ah.g)localObject3).hCn);
          ((Intent)localObject2).putExtra("key_packet_id", ((com.tencent.mm.ah.g)localObject3).hCo);
          ((Intent)localObject2).putExtra("key_has_story", ((com.tencent.mm.ah.g)localObject3).hCr);
          ((Intent)localObject2).putExtra("key_material_flag", ((com.tencent.mm.ah.g)localObject3).hCs);
          ((Intent)localObject2).putExtra("key_msgid", parambv.field_msgId);
          ((Intent)localObject2).putExtra("key_emoji_md5", ((com.tencent.mm.ah.d)paramView.ao(com.tencent.mm.ah.d.class)).glt.field_md5);
          com.tencent.mm.br.d.b(parama.Kkd.getContext(), "luckymoney", ".ui.LuckyMoneyNotHookReceiveUI", (Intent)localObject2);
          if (x.Ai(parama.getTalkerUserName())) {
            com.tencent.mm.plugin.luckymoney.a.d.tW(1);
          }
        } while (!((com.tencent.mm.ah.c)localObject1).hBU.hCr);
        if (!bu.isNullOrNil(((com.tencent.mm.ah.c)localObject1).hBU.hCp)) {}
        for (int i = 2;; i = 1)
        {
          paramView = parambv.sessionId;
          localObject2 = ((com.tencent.mm.ah.c)localObject1).hBL;
          parama = parama.getTalkerUserName();
          localObject3 = ((com.tencent.mm.ah.c)localObject1).hBU.hCo;
          if (((com.tencent.mm.ah.c)localObject1).hBU.hCr) {}
          for (;;)
          {
            com.tencent.mm.plugin.luckymoney.a.c.a(paramView, (String)localObject2, parama, (String)localObject3, j, i);
            com.tencent.mm.plugin.luckymoney.a.c.bq(10, ((com.tencent.mm.ah.c)localObject1).hBM);
            parambv.sessionId = UUID.randomUUID().toString();
            break;
            label601:
            i = 1;
            break label243;
            j = 1;
          }
          label613:
          ae.i("MicroMsg.ChattingItemAppMsgC2CFrom", "native url not match:" + paramView.hEl + ", go webview:" + (String)localObject1);
          if (bu.isNullOrNil((String)localObject1)) {
            break;
          }
          paramView = new Intent();
          paramView.putExtra("rawUrl", (String)localObject1);
          com.tencent.mm.br.d.b(parama.Kkd.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
          break;
          label696:
          if (!bu.isNullOrNil(paramView.hEt))
          {
            ae.i("MicroMsg.ChattingItemAppMsgC2CFrom", "tofuliu billNo: %s, c2cNewAAType: %s, fromUser: %s", new Object[] { paramView.hEt, Integer.valueOf(paramView.hEu), paramView.dzZ });
            if ((paramView.hEu == 2) || (paramView.hEu == 3) || (paramView.hEu == 1))
            {
              parambv = new Intent();
              parambv.putExtra("bill_no", paramView.hEt);
              parambv.putExtra("launcher_user_name", paramView.dzZ);
              parambv.putExtra("enter_scene", 1);
              parambv.putExtra("chatroom", parama.getTalkerUserName());
              com.tencent.mm.br.d.b(parama.Kkd.getContext(), "aa", ".ui.PaylistAAUI", parambv);
            }
            for (;;)
            {
              if (com.tencent.mm.ui.chatting.f.h(paramView).role != 2) {
                break label924;
              }
              com.tencent.mm.plugin.report.service.g.yxI.f(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(2) });
              break;
              if (!bu.isNullOrNil((String)localObject1))
              {
                parambv = new Intent();
                parambv.putExtra("rawUrl", (String)localObject1);
                com.tencent.mm.br.d.b(parama.Kkd.getContext(), "webview", ".ui.tools.WebViewUI", parambv);
              }
            }
            com.tencent.mm.plugin.report.service.g.yxI.f(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(3) });
            break;
          }
          label924:
          if (bu.isNullOrNil((String)localObject1)) {
            break;
          }
          paramView = new Intent();
          paramView.putExtra("rawUrl", (String)localObject1);
          com.tencent.mm.br.d.b(parama.Kkd.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
          break;
        }
      }
    }
    
    public final boolean br(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 436207665);
    }
    
    final boolean fLA()
    {
      return false;
    }
    
    public final boolean fLz()
    {
      return false;
    }
  }
  
  public static final class c
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a JWz;
    
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
        localObject = new ah(paramLayoutInflater, 2131493477);
        ((View)localObject).setTag(new f.a().gw((View)localObject));
      }
      AppMethodBeat.o(36854);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, com.tencent.mm.storage.bv parambv, String paramString)
    {
      AppMethodBeat.i(36855);
      this.JWz = parama1;
      f.a locala = (f.a)parama;
      if (locala.Kxq == parambv.field_msgId)
      {
        locala.DRM = true;
        locala.Kxq = parambv.field_msgId;
        paramString = parambv.field_content;
        if (paramString == null) {
          break label1497;
        }
      }
      label191:
      label458:
      label1106:
      label1491:
      label1497:
      for (k.b localb = k.b.aB(paramString, parambv.field_reserved);; localb = null)
      {
        com.tencent.mm.ah.c localc;
        za localza;
        label347:
        Object localObject;
        int i;
        int j;
        if (localb != null)
        {
          localc = (com.tencent.mm.ah.c)localb.ao(com.tencent.mm.ah.c.class);
          boolean bool2 = "1001".equals(localb.hEk);
          localza = new za();
          if ((!bu.isNullOrNil(localb.hEl)) && (!bool2))
          {
            localza.dOZ.dPb = localb.hEl;
            com.tencent.mm.sdk.b.a.IvT.l(localza);
          }
          f.a.aI(locala.olI, locala.KwJ);
          if (!"1001".equals(localb.hEk)) {
            break label953;
          }
          paramString = locala.olI;
          if (parambv.field_isSend != 1) {
            break label947;
          }
          bool1 = true;
          paramString.setBackgroundResource(com.tencent.mm.ui.chatting.f.c(localb, bool1));
          locala.Kxh.setTypeface(Typeface.defaultFromStyle(1));
          locala.iYM.setVisibility(0);
          locala.Kxj.setTextColor(parama1.Kkd.getContext().getResources().getColor(2131099828));
          locala.Kxj.setAlpha(0.7F);
          com.tencent.mm.cb.a.fromDPToPix(parama1.Kkd.getContext(), 13);
          parama1.Kkd.getContext().getResources().getDimensionPixelSize(2131165500);
          locala.olI.setPadding(0, 0, 0, 0);
          if (parambv.field_isSend != 1) {
            break label1106;
          }
          paramString = localb.hEf;
          if (!bu.isNullOrNil(paramString)) {
            break label1116;
          }
          paramString = localb.description;
          locala.Kxh.setSingleLine(false);
          locala.Kxh.setMaxLines(3);
          locala.Kxh.setText(com.tencent.mm.pluginsdk.ui.span.k.b(parama1.Kkd.getContext(), paramString, locala.Kxo));
          locala.Kxh.setTextSize(0, locala.Kxo);
          if (!bool2) {
            break label1134;
          }
          localObject = locala.Kxi;
          paramString = parama1.Kkd.getContext();
          if (parambv.field_isSend != 1) {
            break label1128;
          }
          bool1 = true;
          paramString = com.tencent.mm.pluginsdk.ui.span.k.b(paramString, com.tencent.mm.ui.chatting.f.b(localb, bool1), locala.Kxi.getTextSize());
          ((TextView)localObject).setText(paramString);
          locala.Kxi.setVisibility(0);
          localObject = localb.hEi;
          paramString = (String)localObject;
          if (bu.isNullOrNil((String)localObject)) {
            paramString = localb.title;
          }
          locala.Kxj.setText(paramString);
          i = 0;
          if (!bu.isNullOrNil(localc.hBI))
          {
            q.aJb().loadImage("", locala.Kxg);
            j = parama1.Kkd.getMMResources().getIdentifier(localc.hBI, "drawable", ak.getPackageName());
            i = j;
            if (j <= 0) {
              i = parama1.Kkd.getMMResources().getIdentifier(localc.hBI, "raw", ak.getPackageName());
            }
          }
          ae.v("MicroMsg.ChattingItemAppMsgC2CTo", "c2c localResId: %s", new Object[] { Integer.valueOf(i) });
          if (i > 0)
          {
            ae.v("MicroMsg.ChattingItemAppMsgC2CTo", "set c2cIcon from localRes");
            locala.Kxg.setImageResource(i);
          }
          if (!"1001".equals(localb.hEk)) {
            break label1283;
          }
          if (parambv.field_isSend != 1) {
            break label1277;
          }
          bool1 = true;
          j = com.tencent.mm.ui.chatting.f.a(localb, bool1);
          if (j <= 0) {
            break label1335;
          }
          ae.i("MicroMsg.ChattingItemAppMsgC2CTo", "set c2cIcon from iconRes");
          locala.Kxg.setImageResource(j);
          i = -1;
          if (!bu.isNullOrNil(localc.hBJ)) {
            i = parama1.Kkd.getMMResources().getIdentifier(localc.hBJ, "drawable", ak.getPackageName());
          }
          ae.i("MicroMsg.ChattingItemAppMsgC2CTo", "backgroundResId: %s", new Object[] { Integer.valueOf(i) });
          if (i > 0) {
            locala.olI.setBackgroundResource(i);
          }
          i = localza.dPa.dPd;
          j = localza.dPa.dPe;
          if (parambv.field_isSend != 1) {
            break label1450;
          }
        }
        for (boolean bool1 = true;; bool1 = false)
        {
          f.a(locala, localc, false, com.tencent.mm.ui.chatting.f.G(i, j, bool1), parama1.getTalkerUserName(), parambv);
          parama.olI.setOnClickListener(d(parama1));
          if (!x.Ai(parama1.getTalkerUserName())) {
            parama.olI.setOnLongClickListener(c(parama1));
          }
          parama.olI.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGw());
          parambv = new bk(parambv, this.JWz.fJC(), paramInt, null, '\000');
          parama.olI.setTag(parambv);
          if (((f.a)parama).oPx == null) {
            break label1491;
          }
          if (!al.isDarkMode()) {
            break label1456;
          }
          ((f.a)parama).oPx.setBackground(null);
          ((f.a)parama).iYM.setVisibility(0);
          AppMethodBeat.o(36855);
          return;
          locala.DRM = false;
          break;
          bool1 = false;
          break label191;
          paramString = locala.olI;
          i = localza.dPa.dPd;
          j = localza.dPa.dPe;
          if (parambv.field_isSend == 1)
          {
            bool1 = true;
            label992:
            paramString.setBackgroundResource(com.tencent.mm.ui.chatting.f.E(i, j, bool1));
            locala.Kxh.setTypeface(Typeface.defaultFromStyle(1));
            if (locala.Kxo <= locala.maxSize) {
              break label1096;
            }
          }
          for (i = locala.maxSize;; i = locala.Kxo)
          {
            locala.Kxo = i;
            locala.iYM.setVisibility(0);
            locala.Kxj.setTextColor(parama1.Kkd.getContext().getResources().getColor(2131099828));
            locala.Kxj.setAlpha(0.7F);
            break;
            bool1 = false;
            break label992;
          }
          paramString = localb.hEe;
          break label314;
          label1116:
          locala.Kxh.setSingleLine(true);
          break label347;
          label1128:
          bool1 = false;
          break label420;
          label1134:
          if (!bu.isNullOrNil(localb.hEl))
          {
            i = localza.dPa.dPc;
            j = localza.dPa.dPd;
            k = localza.dPa.dPe;
            if (parambv.field_isSend == 1) {}
            for (bool1 = true;; bool1 = false)
            {
              paramString = com.tencent.mm.ui.chatting.f.b(i, j, k, bool1, parama1.fJC());
              if (bu.isNullOrNil(paramString)) {
                break label1228;
              }
              localObject = locala.Kxi;
              break;
            }
            locala.Kxi.setVisibility(8);
            break label458;
          }
          localObject = locala.Kxi;
          if (parambv.field_isSend == 1)
          {
            paramString = localb.hEg;
            break label442;
          }
          paramString = localb.hEh;
          break label442;
          label1277:
          bool1 = false;
          break label647;
          j = localza.dPa.dPd;
          int k = localza.dPa.dPe;
          if (parambv.field_isSend == 1) {}
          for (bool1 = true;; bool1 = false)
          {
            j = com.tencent.mm.ui.chatting.f.F(j, k, bool1);
            break;
          }
          if (i > 0) {
            break label680;
          }
          ae.i("MicroMsg.ChattingItemAppMsgC2CTo", "set c2cIcon from iconUrl");
          localObject = localb.hEd;
          paramString = (String)localObject;
          if (bu.isNullOrNil((String)localObject)) {
            paramString = localb.thumburl;
          }
          locala.Kxg.setImageBitmap(null);
          if (bu.isNullOrNil(paramString)) {
            break label680;
          }
          localObject = new com.tencent.mm.av.a.a.c.a();
          bc.aCg();
          ((com.tencent.mm.av.a.a.c.a)localObject).prefixPath = com.tencent.mm.model.c.azR();
          ((com.tencent.mm.av.a.a.c.a)localObject).igk = true;
          ((com.tencent.mm.av.a.a.c.a)localObject).hgL = true;
          localObject = ((com.tencent.mm.av.a.a.c.a)localObject).aJu();
          q.aJb().a(paramString, locala.Kxg, (com.tencent.mm.av.a.a.c)localObject);
          break label680;
        }
        ((f.a)parama).oPx.setBackground(parama1.Kkd.getMMResources().getDrawable(2131231681));
        ((f.a)parama).iYM.setVisibility(8);
        AppMethodBeat.o(36855);
        return;
      }
    }
    
    public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.e.a parama, final com.tencent.mm.storage.bv parambv)
    {
      AppMethodBeat.i(36857);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(36857);
        return false;
      case 103: 
        final String str1 = parambv.field_content;
        paramMenuItem = null;
        if (str1 != null) {
          paramMenuItem = k.b.aB(str1, parambv.field_reserved);
        }
        if (paramMenuItem != null)
        {
          parambv = parambv.field_talker;
          str1 = paramMenuItem.hEe;
          final String str2 = paramMenuItem.hEf;
          final String str3 = paramMenuItem.hEg;
          final String str4 = paramMenuItem.hEh;
          final String str5 = paramMenuItem.hEc;
          final String str6 = paramMenuItem.hEj;
          paramMenuItem = paramMenuItem.hEk;
          h.e(parama.Kkd.getContext(), parama.Kkd.getMMResources().getString(2131757285), parama.Kkd.getMMResources().getString(2131755873), parama.Kkd.getMMResources().getString(2131757286), parama.Kkd.getMMResources().getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(36853);
              paramAnonymousDialogInterface = new Intent();
              paramAnonymousDialogInterface.putExtra("key_scene", 1);
              paramAnonymousDialogInterface.putExtra("key_receiver", parambv);
              paramAnonymousDialogInterface.putExtra("key_receivertitle", str1);
              paramAnonymousDialogInterface.putExtra("key_sendertitle", str2);
              paramAnonymousDialogInterface.putExtra("key_sender_des", str3);
              paramAnonymousDialogInterface.putExtra("key_receiver_des", str4);
              paramAnonymousDialogInterface.putExtra("key_url", str5);
              paramAnonymousDialogInterface.putExtra("key_templateid", str6);
              paramAnonymousDialogInterface.putExtra("key_sceneid", paramMenuItem);
              com.tencent.mm.br.d.b(parama.Kkd.getContext(), "wallet_index", ".ui.WalletSendC2CMsgUI", paramAnonymousDialogInterface);
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
      paramMenuItem.putExtra("Chat_Msg_Id", parambv.field_msgId);
      com.tencent.mm.br.d.b(parama.Kkd.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
      AppMethodBeat.o(36857);
      return true;
    }
    
    public final boolean a(l paraml, View paramView, com.tencent.mm.storage.bv parambv)
    {
      AppMethodBeat.i(187727);
      int i = ((bk)paramView.getTag()).position;
      paraml.a(i, 100, this.JWz.Kkd.getMMResources().getString(2131757221), 2131690384);
      if ((j.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.bv.fpT())) {
        paraml.a(i, 144, paramView.getContext().getString(2131761225), 2131690202);
      }
      AppMethodBeat.o(187727);
      return false;
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, com.tencent.mm.storage.bv parambv)
    {
      int j = 2;
      AppMethodBeat.i(36858);
      ((b)com.tencent.mm.kernel.g.ab(b.class)).aaK(parambv.field_talker);
      paramView = parambv.field_content;
      if (paramView != null) {}
      for (paramView = k.b.aB(paramView, parambv.field_reserved);; paramView = null)
      {
        Object localObject1;
        if (paramView != null)
        {
          if (!bu.isNullOrNil(paramView.hEc)) {
            break label202;
          }
          localObject1 = paramView.url;
          ae.i("MicroMsg.ChattingItemAppMsgC2CTo", "url==null: %s, billNo==null: %s", new Object[] { Boolean.valueOf(bu.isNullOrNil((String)localObject1)), Boolean.valueOf(bu.isNullOrNil(paramView.hEt)) });
          if (bu.isNullOrNil(paramView.hEl)) {
            break label652;
          }
          if (!paramView.hEl.startsWith("weixin://openNativeUrl/weixinHB/startreceivebizhbrequest")) {
            break label211;
          }
          parambv = new Intent();
          parambv.putExtra("key_way", 1);
          parambv.putExtra("key_native_url", paramView.hEl);
          parambv.putExtra("key_username", parama.getTalkerUserName());
          parambv.putExtra("key_static_from_scene", 100002);
          com.tencent.mm.br.d.b(parama.Kkd.getContext(), "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", parambv);
        }
        label202:
        label211:
        Object localObject2;
        label243:
        do
        {
          AppMethodBeat.o(36858);
          return true;
          localObject1 = paramView.hEc;
          break;
          if (!paramView.hEl.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao")) {
            break label569;
          }
          localObject2 = new Intent();
          if (!parama.fJC()) {
            break label557;
          }
          i = 0;
          ((Intent)localObject2).putExtra("key_way", i);
          ((Intent)localObject2).putExtra("key_native_url", paramView.hEl);
          ((Intent)localObject2).putExtra("key_username", parama.getTalkerUserName());
          localObject1 = (com.tencent.mm.ah.c)paramView.ao(com.tencent.mm.ah.c.class);
          paramView = (com.tencent.mm.ah.g)paramView.ao(com.tencent.mm.ah.g.class);
          ((Intent)localObject2).putExtra("key_cropname", ((com.tencent.mm.ah.c)localObject1).hBL);
          ((Intent)localObject2).putExtra("key_receive_envelope_url", ((com.tencent.mm.ah.c)localObject1).hBQ);
          ((Intent)localObject2).putExtra("key_receive_envelope_md5", ((com.tencent.mm.ah.c)localObject1).hBR);
          ((Intent)localObject2).putExtra("key_detail_envelope_url", ((com.tencent.mm.ah.c)localObject1).hBS);
          ((Intent)localObject2).putExtra("key_detail_envelope_md5", ((com.tencent.mm.ah.c)localObject1).hBT);
          ((Intent)localObject2).putExtra("key_about_url", paramView.hCn);
          ((Intent)localObject2).putExtra("key_packet_id", paramView.hCo);
          ((Intent)localObject2).putExtra("key_has_story", paramView.hCr);
          ((Intent)localObject2).putExtra("key_material_flag", paramView.hCs);
          ((Intent)localObject2).putExtra("key_msgid", parambv.field_msgId);
          com.tencent.mm.br.d.b(parama.Kkd.getContext(), "luckymoney", ".ui.LuckyMoneyNotHookReceiveUI", (Intent)localObject2);
        } while (!((com.tencent.mm.ah.c)localObject1).hBU.hCr);
        if (!bu.isNullOrNil(((com.tencent.mm.ah.c)localObject1).hBU.hCp)) {}
        for (int i = 2;; i = 1)
        {
          paramView = parambv.sessionId;
          localObject2 = ((com.tencent.mm.ah.c)localObject1).hBL;
          parama = parama.getTalkerUserName();
          String str = ((com.tencent.mm.ah.c)localObject1).hBU.hCo;
          if (((com.tencent.mm.ah.c)localObject1).hBU.hCr) {}
          for (;;)
          {
            com.tencent.mm.plugin.luckymoney.a.c.a(paramView, (String)localObject2, parama, str, j, i);
            com.tencent.mm.plugin.luckymoney.a.c.bq(10, ((com.tencent.mm.ah.c)localObject1).hBM);
            parambv.sessionId = UUID.randomUUID().toString();
            break;
            label557:
            i = 1;
            break label243;
            j = 1;
          }
          label569:
          ae.i("MicroMsg.ChattingItemAppMsgC2CTo", "native url not match:" + paramView.hEl + ", go webview:" + (String)localObject1);
          if (bu.isNullOrNil((String)localObject1)) {
            break;
          }
          paramView = new Intent();
          paramView.putExtra("rawUrl", (String)localObject1);
          com.tencent.mm.br.d.b(parama.Kkd.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
          break;
          label652:
          if (!bu.isNullOrNil(paramView.hEt))
          {
            ae.i("MicroMsg.ChattingItemAppMsgC2CTo", "tofuliu billNo: %s, c2cNewAAType: %s, fromUser: %s", new Object[] { paramView.hEt, Integer.valueOf(paramView.hEu), paramView.dzZ });
            if ((paramView.hEu == 2) || (paramView.hEu == 3) || (paramView.hEu == 1))
            {
              parambv = new Intent();
              parambv.putExtra("bill_no", paramView.hEt);
              parambv.putExtra("launcher_user_name", paramView.dzZ);
              parambv.putExtra("enter_scene", 1);
              parambv.putExtra("chatroom", parama.getTalkerUserName());
              com.tencent.mm.br.d.b(parama.Kkd.getContext(), "aa", ".ui.PaylistAAUI", parambv);
              com.tencent.mm.plugin.report.service.g.yxI.f(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
              break;
            }
            if (bu.isNullOrNil((String)localObject1)) {
              break;
            }
            paramView = new Intent();
            paramView.putExtra("rawUrl", (String)localObject1);
            com.tencent.mm.br.d.b(parama.Kkd.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
            break;
          }
          if ((bu.isNullOrNil((String)localObject1)) || (bu.isNullOrNil((String)localObject1))) {
            break;
          }
          paramView = new Intent();
          paramView.putExtra("rawUrl", (String)localObject1);
          com.tencent.mm.br.d.b(parama.Kkd.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
          break;
        }
      }
    }
    
    public final boolean br(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 436207665);
    }
    
    final boolean fLA()
    {
      return false;
    }
    
    public final boolean fLz()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.f
 * JD-Core Version:    0.7.0.1
 */