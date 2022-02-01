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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.aw.q;
import com.tencent.mm.g.a.yu;
import com.tencent.mm.g.a.yu.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.protocal.protobuf.bnu;
import com.tencent.mm.protocal.protobuf.bnv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
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
    public ImageView KaN;
    public TextView KaO;
    public TextView KaP;
    public TextView KaQ;
    public TextView KaR;
    public TextView KaS;
    public ImageView KaT;
    public ImageView KaU;
    public int KaV = 0;
    public int KaW;
    public long KaX;
    public boolean KaY;
    public int Kaq = 0;
    public View iVT;
    public int maxSize = 0;
    public View oIV;
    public ImageView vzT;
    
    public final a gr(View paramView)
    {
      AppMethodBeat.i(36847);
      super.gn(paramView);
      this.fTP = ((TextView)this.tPw.findViewById(2131298178));
      this.iCK = ((CheckBox)this.tPw.findViewById(2131298068));
      this.gZU = this.tPw.findViewById(2131298147);
      this.yEk = ((TextView)this.tPw.findViewById(2131298185));
      this.oIV = this.tPw.findViewById(2131300196);
      this.iVT = ((ImageView)this.tPw.findViewById(2131299154));
      this.KaN = ((ImageView)this.tPw.findViewById(2131296913));
      this.KaO = ((TextView)this.tPw.findViewById(2131296919));
      this.KaP = ((TextView)this.tPw.findViewById(2131296911));
      this.KaQ = ((TextView)this.tPw.findViewById(2131296922));
      this.ofK = this.tPw.findViewById(2131298069);
      this.vzT = ((ImageView)this.tPw.findViewById(2131298120));
      this.KaS = ((TextView)this.tPw.findViewById(2131296921));
      this.KaR = ((TextView)this.tPw.findViewById(2131307149));
      this.KaT = ((ImageView)this.tPw.findViewById(2131298121));
      this.KaU = ((ImageView)this.tPw.findViewById(2131296920));
      this.iVT = this.tPw.findViewById(2131296912);
      this.Kaq = c.kn(aj.getContext());
      this.KaV = com.tencent.mm.cc.a.ax(aj.getContext(), 2131165217);
      this.maxSize = ((int)(com.tencent.mm.cc.a.ay(aj.getContext(), 2131165217) * 1.45F));
      this.KaW = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 20);
      AppMethodBeat.o(36847);
      return this;
    }
  }
  
  public static final class b
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a JBI;
    
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
        ((View)localObject).setTag(new f.a().gr((View)localObject));
      }
      AppMethodBeat.o(36848);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, com.tencent.mm.storage.bu parambu, String paramString)
    {
      AppMethodBeat.i(36849);
      this.JBI = parama1;
      f.a locala = (f.a)parama;
      if (locala.KaX == parambu.field_msgId)
      {
        locala.KaY = true;
        locala.KaX = parambu.field_msgId;
        paramString = parambu.field_content;
        if (paramString == null) {
          break label1500;
        }
      }
      label191:
      label461:
      label1109:
      label1494:
      label1500:
      for (k.b localb = k.b.aA(paramString, parambu.field_reserved);; localb = null)
      {
        com.tencent.mm.ai.c localc;
        yu localyu;
        label350:
        Object localObject;
        int i;
        int j;
        if (localb != null)
        {
          localc = (com.tencent.mm.ai.c)localb.ao(com.tencent.mm.ai.c.class);
          boolean bool2 = "1001".equals(localb.hBw);
          localyu = new yu();
          if ((!bt.isNullOrNil(localb.hBx)) && (!bool2))
          {
            localyu.dNJ.dNL = localb.hBx;
            com.tencent.mm.sdk.b.a.IbL.l(localyu);
          }
          f.a.aI(locala.ofK, locala.Kaq);
          if (!"1001".equals(localb.hBw)) {
            break label956;
          }
          paramString = locala.ofK;
          if (parambu.field_isSend != 1) {
            break label950;
          }
          bool1 = true;
          paramString.setBackgroundResource(com.tencent.mm.ui.chatting.f.c(localb, bool1));
          locala.KaO.setTypeface(Typeface.defaultFromStyle(1));
          locala.iVT.setVisibility(0);
          locala.KaQ.setTextColor(parama1.JOR.getContext().getResources().getColor(2131099828));
          locala.KaQ.setAlpha(0.7F);
          parama1.JOR.getContext().getResources().getDimensionPixelSize(2131165568);
          parama1.JOR.getContext().getResources().getDimensionPixelSize(2131166006);
          locala.ofK.setPadding(0, 0, 0, 0);
          if (parambu.field_isSend != 1) {
            break label1109;
          }
          paramString = localb.hBr;
          if (!bt.isNullOrNil(paramString)) {
            break label1119;
          }
          paramString = localb.description;
          locala.KaO.setSingleLine(false);
          locala.KaO.setMaxLines(3);
          locala.KaO.setText(com.tencent.mm.pluginsdk.ui.span.k.b(parama1.JOR.getContext(), paramString, locala.KaV));
          locala.KaO.setTextSize(0, locala.KaV);
          if (!bool2) {
            break label1137;
          }
          localObject = locala.KaP;
          paramString = parama1.JOR.getContext();
          if (parambu.field_isSend != 1) {
            break label1131;
          }
          bool1 = true;
          paramString = com.tencent.mm.pluginsdk.ui.span.k.b(paramString, com.tencent.mm.ui.chatting.f.b(localb, bool1), locala.KaP.getTextSize());
          ((TextView)localObject).setText(paramString);
          locala.KaP.setVisibility(0);
          localObject = localb.hBu;
          paramString = (String)localObject;
          if (bt.isNullOrNil((String)localObject)) {
            paramString = localb.title;
          }
          locala.KaQ.setText(paramString);
          i = 0;
          if (!bt.isNullOrNil(localc.hyU))
          {
            q.aIJ().loadImage("", locala.KaN);
            j = parama1.JOR.getMMResources().getIdentifier(localc.hyU, "drawable", aj.getPackageName());
            i = j;
            if (j <= 0) {
              i = parama1.JOR.getMMResources().getIdentifier(localc.hyU, "raw", aj.getPackageName());
            }
          }
          ad.i("MicroMsg.ChattingItemAppMsgC2CFrom", "c2c loaclResId: %s", new Object[] { Integer.valueOf(i) });
          if (i > 0)
          {
            ad.i("MicroMsg.ChattingItemAppMsgC2CFrom", "set c2cIcon from localRes");
            locala.KaN.setImageResource(i);
          }
          if (!"1001".equals(localb.hBw)) {
            break label1286;
          }
          if (parambu.field_isSend != 1) {
            break label1280;
          }
          bool1 = true;
          j = com.tencent.mm.ui.chatting.f.a(localb, bool1);
          if (j <= 0) {
            break label1338;
          }
          ad.i("MicroMsg.ChattingItemAppMsgC2CFrom", "set c2cIcon from iconRes");
          locala.KaN.setImageResource(j);
          i = -1;
          if (!bt.isNullOrNil(localc.hyV)) {
            i = parama1.JOR.getMMResources().getIdentifier(localc.hyV, "drawable", aj.getPackageName());
          }
          ad.i("MicroMsg.ChattingItemAppMsgC2CFrom", "backgroundResId: %s", new Object[] { Integer.valueOf(i) });
          if (i > 0) {
            locala.ofK.setBackgroundResource(i);
          }
          i = localyu.dNK.dNN;
          j = localyu.dNK.dNO;
          if (parambu.field_isSend != 1) {
            break label1453;
          }
        }
        for (boolean bool1 = true;; bool1 = false)
        {
          f.a(locala, localc, true, com.tencent.mm.ui.chatting.f.G(i, j, bool1), parama1.getTalkerUserName(), parambu);
          parama.ofK.setOnClickListener(d(parama1));
          if (!w.zy(parama1.getTalkerUserName())) {
            parama.ofK.setOnLongClickListener(c(parama1));
          }
          parama.ofK.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCu());
          parambu = new bk(parambu, this.JBI.fFv(), paramInt, null, '\000');
          parama.ofK.setTag(parambu);
          if (((f.a)parama).oIV == null) {
            break label1494;
          }
          if (!al.isDarkMode()) {
            break label1459;
          }
          ((f.a)parama).oIV.setBackground(null);
          ((f.a)parama).iVT.setVisibility(0);
          AppMethodBeat.o(36849);
          return;
          locala.KaY = false;
          break;
          bool1 = false;
          break label191;
          paramString = locala.ofK;
          i = localyu.dNK.dNN;
          j = localyu.dNK.dNO;
          if (parambu.field_isSend == 1)
          {
            bool1 = true;
            label995:
            paramString.setBackgroundResource(com.tencent.mm.ui.chatting.f.E(i, j, bool1));
            locala.KaO.setTypeface(Typeface.defaultFromStyle(1));
            if (locala.KaV <= locala.maxSize) {
              break label1099;
            }
          }
          for (i = locala.maxSize;; i = locala.KaV)
          {
            locala.KaV = i;
            locala.iVT.setVisibility(0);
            locala.KaQ.setTextColor(parama1.JOR.getContext().getResources().getColor(2131099828));
            locala.KaQ.setAlpha(0.7F);
            break;
            bool1 = false;
            break label995;
          }
          paramString = localb.hBq;
          break label317;
          label1119:
          locala.KaO.setSingleLine(true);
          break label350;
          label1131:
          bool1 = false;
          break label423;
          label1137:
          if (!bt.isNullOrNil(localb.hBx))
          {
            i = localyu.dNK.dNM;
            j = localyu.dNK.dNN;
            k = localyu.dNK.dNO;
            if (parambu.field_isSend == 1) {}
            for (bool1 = true;; bool1 = false)
            {
              paramString = com.tencent.mm.ui.chatting.f.b(i, j, k, bool1, parama1.fFv());
              if (bt.isNullOrNil(paramString)) {
                break label1231;
              }
              localObject = locala.KaP;
              break;
            }
            locala.KaP.setVisibility(8);
            break label461;
          }
          localObject = locala.KaP;
          if (parambu.field_isSend == 1)
          {
            paramString = localb.hBs;
            break label445;
          }
          paramString = localb.hBt;
          break label445;
          bool1 = false;
          break label650;
          j = localyu.dNK.dNN;
          int k = localyu.dNK.dNO;
          if (parambu.field_isSend == 1) {}
          for (bool1 = true;; bool1 = false)
          {
            j = com.tencent.mm.ui.chatting.f.F(j, k, bool1);
            break;
          }
          if (i > 0) {
            break label683;
          }
          ad.i("MicroMsg.ChattingItemAppMsgC2CFrom", "set c2cIcon from c2cIconUrl");
          localObject = localb.hBp;
          paramString = (String)localObject;
          if (bt.isNullOrNil((String)localObject)) {
            paramString = localb.thumburl;
          }
          locala.KaN.setImageBitmap(null);
          if (bt.isNullOrNil(paramString)) {
            break label683;
          }
          localObject = new com.tencent.mm.aw.a.a.c.a();
          ba.aBQ();
          ((com.tencent.mm.aw.a.a.c.a)localObject).prefixPath = com.tencent.mm.model.c.azB();
          ((com.tencent.mm.aw.a.a.c.a)localObject).idr = true;
          ((com.tencent.mm.aw.a.a.c.a)localObject).hdX = true;
          localObject = ((com.tencent.mm.aw.a.a.c.a)localObject).aJc();
          q.aIJ().a(paramString, locala.KaN, (com.tencent.mm.aw.a.a.c)localObject);
          break label683;
        }
        ((f.a)parama).oIV.setBackground(parama1.JOR.getMMResources().getDrawable(2131231681));
        ((f.a)parama).iVT.setVisibility(8);
        AppMethodBeat.o(36849);
        return;
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, com.tencent.mm.storage.bu parambu)
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
      paramMenuItem.putExtra("Chat_Msg_Id", parambu.field_msgId);
      com.tencent.mm.bs.d.b(parama.JOR.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
      AppMethodBeat.o(36851);
      return true;
    }
    
    public final boolean a(l paraml, View paramView, com.tencent.mm.storage.bu parambu)
    {
      AppMethodBeat.i(194331);
      int i = ((bk)paramView.getTag()).position;
      paraml.a(i, 100, this.JBI.JOR.getMMResources().getString(2131757221), 2131690384);
      if ((i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.bu.flY())) {
        paraml.a(i, 144, paramView.getContext().getString(2131761225), 2131690202);
      }
      AppMethodBeat.o(194331);
      return false;
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, com.tencent.mm.storage.bu parambu)
    {
      int j = 2;
      AppMethodBeat.i(36852);
      ((b)com.tencent.mm.kernel.g.ab(b.class)).ZT(parambu.field_talker);
      paramView = parambu.field_content;
      if (paramView != null) {}
      for (paramView = k.b.aA(paramView, parambu.field_reserved);; paramView = null)
      {
        Object localObject1;
        if (paramView != null)
        {
          if (!bt.isNullOrNil(paramView.hBo)) {
            break label202;
          }
          localObject1 = paramView.url;
          ad.i("MicroMsg.ChattingItemAppMsgC2CFrom", "url==null: %s, billNo==null: %s", new Object[] { Boolean.valueOf(bt.isNullOrNil((String)localObject1)), Boolean.valueOf(bt.isNullOrNil(paramView.hBF)) });
          if (bt.isNullOrNil(paramView.hBx)) {
            break label696;
          }
          if (!paramView.hBx.startsWith("weixin://openNativeUrl/weixinHB/startreceivebizhbrequest")) {
            break label211;
          }
          parambu = new Intent();
          parambu.putExtra("key_way", 1);
          parambu.putExtra("key_native_url", paramView.hBx);
          parambu.putExtra("key_username", parama.getTalkerUserName());
          parambu.putExtra("key_static_from_scene", 100002);
          com.tencent.mm.bs.d.b(parama.JOR.getContext(), "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", parambu);
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
          localObject1 = paramView.hBo;
          break;
          if (!paramView.hBx.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao")) {
            break label613;
          }
          localObject2 = new Intent();
          if (!parama.fFv()) {
            break label601;
          }
          i = 0;
          ((Intent)localObject2).putExtra("key_way", i);
          ((Intent)localObject2).putExtra("key_native_url", paramView.hBx);
          ((Intent)localObject2).putExtra("key_username", parama.getTalkerUserName());
          localObject1 = (com.tencent.mm.ai.c)paramView.ao(com.tencent.mm.ai.c.class);
          localObject3 = (com.tencent.mm.ai.g)paramView.ao(com.tencent.mm.ai.g.class);
          ((Intent)localObject2).putExtra("key_cropname", ((com.tencent.mm.ai.c)localObject1).hyX);
          ((Intent)localObject2).putExtra("key_receive_envelope_url", ((com.tencent.mm.ai.c)localObject1).hzc);
          ((Intent)localObject2).putExtra("key_receive_envelope_md5", ((com.tencent.mm.ai.c)localObject1).hzd);
          ((Intent)localObject2).putExtra("key_detail_envelope_url", ((com.tencent.mm.ai.c)localObject1).hze);
          ((Intent)localObject2).putExtra("key_detail_envelope_md5", ((com.tencent.mm.ai.c)localObject1).hzf);
          ((Intent)localObject2).putExtra("key_about_url", ((com.tencent.mm.ai.g)localObject3).hzz);
          ((Intent)localObject2).putExtra("key_packet_id", ((com.tencent.mm.ai.g)localObject3).hzA);
          ((Intent)localObject2).putExtra("key_has_story", ((com.tencent.mm.ai.g)localObject3).hzD);
          ((Intent)localObject2).putExtra("key_material_flag", ((com.tencent.mm.ai.g)localObject3).hzE);
          ((Intent)localObject2).putExtra("key_msgid", parambu.field_msgId);
          ((Intent)localObject2).putExtra("key_emoji_md5", ((com.tencent.mm.ai.d)paramView.ao(com.tencent.mm.ai.d.class)).gjb.field_md5);
          com.tencent.mm.bs.d.b(parama.JOR.getContext(), "luckymoney", ".ui.LuckyMoneyNotHookReceiveUI", (Intent)localObject2);
          if (w.zy(parama.getTalkerUserName())) {
            com.tencent.mm.plugin.luckymoney.a.d.tQ(1);
          }
        } while (!((com.tencent.mm.ai.c)localObject1).hzg.hzD);
        if (!bt.isNullOrNil(((com.tencent.mm.ai.c)localObject1).hzg.hzB)) {}
        for (int i = 2;; i = 1)
        {
          paramView = parambu.sessionId;
          localObject2 = ((com.tencent.mm.ai.c)localObject1).hyX;
          parama = parama.getTalkerUserName();
          localObject3 = ((com.tencent.mm.ai.c)localObject1).hzg.hzA;
          if (((com.tencent.mm.ai.c)localObject1).hzg.hzD) {}
          for (;;)
          {
            com.tencent.mm.plugin.luckymoney.a.c.a(paramView, (String)localObject2, parama, (String)localObject3, j, i);
            com.tencent.mm.plugin.luckymoney.a.c.br(10, ((com.tencent.mm.ai.c)localObject1).hyY);
            parambu.sessionId = UUID.randomUUID().toString();
            break;
            label601:
            i = 1;
            break label243;
            j = 1;
          }
          label613:
          ad.i("MicroMsg.ChattingItemAppMsgC2CFrom", "native url not match:" + paramView.hBx + ", go webview:" + (String)localObject1);
          if (bt.isNullOrNil((String)localObject1)) {
            break;
          }
          paramView = new Intent();
          paramView.putExtra("rawUrl", (String)localObject1);
          com.tencent.mm.bs.d.b(parama.JOR.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
          break;
          label696:
          if (!bt.isNullOrNil(paramView.hBF))
          {
            ad.i("MicroMsg.ChattingItemAppMsgC2CFrom", "tofuliu billNo: %s, c2cNewAAType: %s, fromUser: %s", new Object[] { paramView.hBF, Integer.valueOf(paramView.hBG), paramView.dyU });
            if ((paramView.hBG == 2) || (paramView.hBG == 3) || (paramView.hBG == 1))
            {
              parambu = new Intent();
              parambu.putExtra("bill_no", paramView.hBF);
              parambu.putExtra("launcher_user_name", paramView.dyU);
              parambu.putExtra("enter_scene", 1);
              parambu.putExtra("chatroom", parama.getTalkerUserName());
              com.tencent.mm.bs.d.b(parama.JOR.getContext(), "aa", ".ui.PaylistAAUI", parambu);
            }
            for (;;)
            {
              if (com.tencent.mm.ui.chatting.f.h(paramView).role != 2) {
                break label924;
              }
              com.tencent.mm.plugin.report.service.g.yhR.f(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(2) });
              break;
              if (!bt.isNullOrNil((String)localObject1))
              {
                parambu = new Intent();
                parambu.putExtra("rawUrl", (String)localObject1);
                com.tencent.mm.bs.d.b(parama.JOR.getContext(), "webview", ".ui.tools.WebViewUI", parambu);
              }
            }
            com.tencent.mm.plugin.report.service.g.yhR.f(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(3) });
            break;
          }
          label924:
          if (bt.isNullOrNil((String)localObject1)) {
            break;
          }
          paramView = new Intent();
          paramView.putExtra("rawUrl", (String)localObject1);
          com.tencent.mm.bs.d.b(parama.JOR.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
          break;
        }
      }
    }
    
    public final boolean bi(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 436207665);
    }
    
    public final boolean fHh()
    {
      return false;
    }
    
    final boolean fHi()
    {
      return false;
    }
  }
  
  public static final class c
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a JBI;
    
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
        ((View)localObject).setTag(new f.a().gr((View)localObject));
      }
      AppMethodBeat.o(36854);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, com.tencent.mm.storage.bu parambu, String paramString)
    {
      AppMethodBeat.i(36855);
      this.JBI = parama1;
      f.a locala = (f.a)parama;
      if (locala.KaX == parambu.field_msgId)
      {
        locala.KaY = true;
        locala.KaX = parambu.field_msgId;
        paramString = parambu.field_content;
        if (paramString == null) {
          break label1497;
        }
      }
      label191:
      label458:
      label1106:
      label1491:
      label1497:
      for (k.b localb = k.b.aA(paramString, parambu.field_reserved);; localb = null)
      {
        com.tencent.mm.ai.c localc;
        yu localyu;
        label347:
        Object localObject;
        int i;
        int j;
        if (localb != null)
        {
          localc = (com.tencent.mm.ai.c)localb.ao(com.tencent.mm.ai.c.class);
          boolean bool2 = "1001".equals(localb.hBw);
          localyu = new yu();
          if ((!bt.isNullOrNil(localb.hBx)) && (!bool2))
          {
            localyu.dNJ.dNL = localb.hBx;
            com.tencent.mm.sdk.b.a.IbL.l(localyu);
          }
          f.a.aI(locala.ofK, locala.Kaq);
          if (!"1001".equals(localb.hBw)) {
            break label953;
          }
          paramString = locala.ofK;
          if (parambu.field_isSend != 1) {
            break label947;
          }
          bool1 = true;
          paramString.setBackgroundResource(com.tencent.mm.ui.chatting.f.c(localb, bool1));
          locala.KaO.setTypeface(Typeface.defaultFromStyle(1));
          locala.iVT.setVisibility(0);
          locala.KaQ.setTextColor(parama1.JOR.getContext().getResources().getColor(2131099828));
          locala.KaQ.setAlpha(0.7F);
          com.tencent.mm.cc.a.fromDPToPix(parama1.JOR.getContext(), 13);
          parama1.JOR.getContext().getResources().getDimensionPixelSize(2131165500);
          locala.ofK.setPadding(0, 0, 0, 0);
          if (parambu.field_isSend != 1) {
            break label1106;
          }
          paramString = localb.hBr;
          if (!bt.isNullOrNil(paramString)) {
            break label1116;
          }
          paramString = localb.description;
          locala.KaO.setSingleLine(false);
          locala.KaO.setMaxLines(3);
          locala.KaO.setText(com.tencent.mm.pluginsdk.ui.span.k.b(parama1.JOR.getContext(), paramString, locala.KaV));
          locala.KaO.setTextSize(0, locala.KaV);
          if (!bool2) {
            break label1134;
          }
          localObject = locala.KaP;
          paramString = parama1.JOR.getContext();
          if (parambu.field_isSend != 1) {
            break label1128;
          }
          bool1 = true;
          paramString = com.tencent.mm.pluginsdk.ui.span.k.b(paramString, com.tencent.mm.ui.chatting.f.b(localb, bool1), locala.KaP.getTextSize());
          ((TextView)localObject).setText(paramString);
          locala.KaP.setVisibility(0);
          localObject = localb.hBu;
          paramString = (String)localObject;
          if (bt.isNullOrNil((String)localObject)) {
            paramString = localb.title;
          }
          locala.KaQ.setText(paramString);
          i = 0;
          if (!bt.isNullOrNil(localc.hyU))
          {
            q.aIJ().loadImage("", locala.KaN);
            j = parama1.JOR.getMMResources().getIdentifier(localc.hyU, "drawable", aj.getPackageName());
            i = j;
            if (j <= 0) {
              i = parama1.JOR.getMMResources().getIdentifier(localc.hyU, "raw", aj.getPackageName());
            }
          }
          ad.v("MicroMsg.ChattingItemAppMsgC2CTo", "c2c localResId: %s", new Object[] { Integer.valueOf(i) });
          if (i > 0)
          {
            ad.v("MicroMsg.ChattingItemAppMsgC2CTo", "set c2cIcon from localRes");
            locala.KaN.setImageResource(i);
          }
          if (!"1001".equals(localb.hBw)) {
            break label1283;
          }
          if (parambu.field_isSend != 1) {
            break label1277;
          }
          bool1 = true;
          j = com.tencent.mm.ui.chatting.f.a(localb, bool1);
          if (j <= 0) {
            break label1335;
          }
          ad.i("MicroMsg.ChattingItemAppMsgC2CTo", "set c2cIcon from iconRes");
          locala.KaN.setImageResource(j);
          i = -1;
          if (!bt.isNullOrNil(localc.hyV)) {
            i = parama1.JOR.getMMResources().getIdentifier(localc.hyV, "drawable", aj.getPackageName());
          }
          ad.i("MicroMsg.ChattingItemAppMsgC2CTo", "backgroundResId: %s", new Object[] { Integer.valueOf(i) });
          if (i > 0) {
            locala.ofK.setBackgroundResource(i);
          }
          i = localyu.dNK.dNN;
          j = localyu.dNK.dNO;
          if (parambu.field_isSend != 1) {
            break label1450;
          }
        }
        for (boolean bool1 = true;; bool1 = false)
        {
          f.a(locala, localc, false, com.tencent.mm.ui.chatting.f.G(i, j, bool1), parama1.getTalkerUserName(), parambu);
          parama.ofK.setOnClickListener(d(parama1));
          if (!w.zy(parama1.getTalkerUserName())) {
            parama.ofK.setOnLongClickListener(c(parama1));
          }
          parama.ofK.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCu());
          parambu = new bk(parambu, this.JBI.fFv(), paramInt, null, '\000');
          parama.ofK.setTag(parambu);
          if (((f.a)parama).oIV == null) {
            break label1491;
          }
          if (!al.isDarkMode()) {
            break label1456;
          }
          ((f.a)parama).oIV.setBackground(null);
          ((f.a)parama).iVT.setVisibility(0);
          AppMethodBeat.o(36855);
          return;
          locala.KaY = false;
          break;
          bool1 = false;
          break label191;
          paramString = locala.ofK;
          i = localyu.dNK.dNN;
          j = localyu.dNK.dNO;
          if (parambu.field_isSend == 1)
          {
            bool1 = true;
            label992:
            paramString.setBackgroundResource(com.tencent.mm.ui.chatting.f.E(i, j, bool1));
            locala.KaO.setTypeface(Typeface.defaultFromStyle(1));
            if (locala.KaV <= locala.maxSize) {
              break label1096;
            }
          }
          for (i = locala.maxSize;; i = locala.KaV)
          {
            locala.KaV = i;
            locala.iVT.setVisibility(0);
            locala.KaQ.setTextColor(parama1.JOR.getContext().getResources().getColor(2131099828));
            locala.KaQ.setAlpha(0.7F);
            break;
            bool1 = false;
            break label992;
          }
          paramString = localb.hBq;
          break label314;
          label1116:
          locala.KaO.setSingleLine(true);
          break label347;
          label1128:
          bool1 = false;
          break label420;
          label1134:
          if (!bt.isNullOrNil(localb.hBx))
          {
            i = localyu.dNK.dNM;
            j = localyu.dNK.dNN;
            k = localyu.dNK.dNO;
            if (parambu.field_isSend == 1) {}
            for (bool1 = true;; bool1 = false)
            {
              paramString = com.tencent.mm.ui.chatting.f.b(i, j, k, bool1, parama1.fFv());
              if (bt.isNullOrNil(paramString)) {
                break label1228;
              }
              localObject = locala.KaP;
              break;
            }
            locala.KaP.setVisibility(8);
            break label458;
          }
          localObject = locala.KaP;
          if (parambu.field_isSend == 1)
          {
            paramString = localb.hBs;
            break label442;
          }
          paramString = localb.hBt;
          break label442;
          label1277:
          bool1 = false;
          break label647;
          j = localyu.dNK.dNN;
          int k = localyu.dNK.dNO;
          if (parambu.field_isSend == 1) {}
          for (bool1 = true;; bool1 = false)
          {
            j = com.tencent.mm.ui.chatting.f.F(j, k, bool1);
            break;
          }
          if (i > 0) {
            break label680;
          }
          ad.i("MicroMsg.ChattingItemAppMsgC2CTo", "set c2cIcon from iconUrl");
          localObject = localb.hBp;
          paramString = (String)localObject;
          if (bt.isNullOrNil((String)localObject)) {
            paramString = localb.thumburl;
          }
          locala.KaN.setImageBitmap(null);
          if (bt.isNullOrNil(paramString)) {
            break label680;
          }
          localObject = new com.tencent.mm.aw.a.a.c.a();
          ba.aBQ();
          ((com.tencent.mm.aw.a.a.c.a)localObject).prefixPath = com.tencent.mm.model.c.azB();
          ((com.tencent.mm.aw.a.a.c.a)localObject).idr = true;
          ((com.tencent.mm.aw.a.a.c.a)localObject).hdX = true;
          localObject = ((com.tencent.mm.aw.a.a.c.a)localObject).aJc();
          q.aIJ().a(paramString, locala.KaN, (com.tencent.mm.aw.a.a.c)localObject);
          break label680;
        }
        ((f.a)parama).oIV.setBackground(parama1.JOR.getMMResources().getDrawable(2131231681));
        ((f.a)parama).iVT.setVisibility(8);
        AppMethodBeat.o(36855);
        return;
      }
    }
    
    public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.e.a parama, final com.tencent.mm.storage.bu parambu)
    {
      AppMethodBeat.i(36857);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(36857);
        return false;
      case 103: 
        final String str1 = parambu.field_content;
        paramMenuItem = null;
        if (str1 != null) {
          paramMenuItem = k.b.aA(str1, parambu.field_reserved);
        }
        if (paramMenuItem != null)
        {
          parambu = parambu.field_talker;
          str1 = paramMenuItem.hBq;
          final String str2 = paramMenuItem.hBr;
          final String str3 = paramMenuItem.hBs;
          final String str4 = paramMenuItem.hBt;
          final String str5 = paramMenuItem.hBo;
          final String str6 = paramMenuItem.hBv;
          paramMenuItem = paramMenuItem.hBw;
          h.e(parama.JOR.getContext(), parama.JOR.getMMResources().getString(2131757285), parama.JOR.getMMResources().getString(2131755873), parama.JOR.getMMResources().getString(2131757286), parama.JOR.getMMResources().getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(36853);
              paramAnonymousDialogInterface = new Intent();
              paramAnonymousDialogInterface.putExtra("key_scene", 1);
              paramAnonymousDialogInterface.putExtra("key_receiver", parambu);
              paramAnonymousDialogInterface.putExtra("key_receivertitle", str1);
              paramAnonymousDialogInterface.putExtra("key_sendertitle", str2);
              paramAnonymousDialogInterface.putExtra("key_sender_des", str3);
              paramAnonymousDialogInterface.putExtra("key_receiver_des", str4);
              paramAnonymousDialogInterface.putExtra("key_url", str5);
              paramAnonymousDialogInterface.putExtra("key_templateid", str6);
              paramAnonymousDialogInterface.putExtra("key_sceneid", paramMenuItem);
              com.tencent.mm.bs.d.b(parama.JOR.getContext(), "wallet_index", ".ui.WalletSendC2CMsgUI", paramAnonymousDialogInterface);
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
      paramMenuItem.putExtra("Chat_Msg_Id", parambu.field_msgId);
      com.tencent.mm.bs.d.b(parama.JOR.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
      AppMethodBeat.o(36857);
      return true;
    }
    
    public final boolean a(l paraml, View paramView, com.tencent.mm.storage.bu parambu)
    {
      AppMethodBeat.i(194332);
      int i = ((bk)paramView.getTag()).position;
      paraml.a(i, 100, this.JBI.JOR.getMMResources().getString(2131757221), 2131690384);
      if ((i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.bu.flY())) {
        paraml.a(i, 144, paramView.getContext().getString(2131761225), 2131690202);
      }
      AppMethodBeat.o(194332);
      return false;
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, com.tencent.mm.storage.bu parambu)
    {
      int j = 2;
      AppMethodBeat.i(36858);
      ((b)com.tencent.mm.kernel.g.ab(b.class)).ZT(parambu.field_talker);
      paramView = parambu.field_content;
      if (paramView != null) {}
      for (paramView = k.b.aA(paramView, parambu.field_reserved);; paramView = null)
      {
        Object localObject1;
        if (paramView != null)
        {
          if (!bt.isNullOrNil(paramView.hBo)) {
            break label202;
          }
          localObject1 = paramView.url;
          ad.i("MicroMsg.ChattingItemAppMsgC2CTo", "url==null: %s, billNo==null: %s", new Object[] { Boolean.valueOf(bt.isNullOrNil((String)localObject1)), Boolean.valueOf(bt.isNullOrNil(paramView.hBF)) });
          if (bt.isNullOrNil(paramView.hBx)) {
            break label652;
          }
          if (!paramView.hBx.startsWith("weixin://openNativeUrl/weixinHB/startreceivebizhbrequest")) {
            break label211;
          }
          parambu = new Intent();
          parambu.putExtra("key_way", 1);
          parambu.putExtra("key_native_url", paramView.hBx);
          parambu.putExtra("key_username", parama.getTalkerUserName());
          parambu.putExtra("key_static_from_scene", 100002);
          com.tencent.mm.bs.d.b(parama.JOR.getContext(), "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", parambu);
        }
        label202:
        label211:
        Object localObject2;
        label243:
        do
        {
          AppMethodBeat.o(36858);
          return true;
          localObject1 = paramView.hBo;
          break;
          if (!paramView.hBx.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao")) {
            break label569;
          }
          localObject2 = new Intent();
          if (!parama.fFv()) {
            break label557;
          }
          i = 0;
          ((Intent)localObject2).putExtra("key_way", i);
          ((Intent)localObject2).putExtra("key_native_url", paramView.hBx);
          ((Intent)localObject2).putExtra("key_username", parama.getTalkerUserName());
          localObject1 = (com.tencent.mm.ai.c)paramView.ao(com.tencent.mm.ai.c.class);
          paramView = (com.tencent.mm.ai.g)paramView.ao(com.tencent.mm.ai.g.class);
          ((Intent)localObject2).putExtra("key_cropname", ((com.tencent.mm.ai.c)localObject1).hyX);
          ((Intent)localObject2).putExtra("key_receive_envelope_url", ((com.tencent.mm.ai.c)localObject1).hzc);
          ((Intent)localObject2).putExtra("key_receive_envelope_md5", ((com.tencent.mm.ai.c)localObject1).hzd);
          ((Intent)localObject2).putExtra("key_detail_envelope_url", ((com.tencent.mm.ai.c)localObject1).hze);
          ((Intent)localObject2).putExtra("key_detail_envelope_md5", ((com.tencent.mm.ai.c)localObject1).hzf);
          ((Intent)localObject2).putExtra("key_about_url", paramView.hzz);
          ((Intent)localObject2).putExtra("key_packet_id", paramView.hzA);
          ((Intent)localObject2).putExtra("key_has_story", paramView.hzD);
          ((Intent)localObject2).putExtra("key_material_flag", paramView.hzE);
          ((Intent)localObject2).putExtra("key_msgid", parambu.field_msgId);
          com.tencent.mm.bs.d.b(parama.JOR.getContext(), "luckymoney", ".ui.LuckyMoneyNotHookReceiveUI", (Intent)localObject2);
        } while (!((com.tencent.mm.ai.c)localObject1).hzg.hzD);
        if (!bt.isNullOrNil(((com.tencent.mm.ai.c)localObject1).hzg.hzB)) {}
        for (int i = 2;; i = 1)
        {
          paramView = parambu.sessionId;
          localObject2 = ((com.tencent.mm.ai.c)localObject1).hyX;
          parama = parama.getTalkerUserName();
          String str = ((com.tencent.mm.ai.c)localObject1).hzg.hzA;
          if (((com.tencent.mm.ai.c)localObject1).hzg.hzD) {}
          for (;;)
          {
            com.tencent.mm.plugin.luckymoney.a.c.a(paramView, (String)localObject2, parama, str, j, i);
            com.tencent.mm.plugin.luckymoney.a.c.br(10, ((com.tencent.mm.ai.c)localObject1).hyY);
            parambu.sessionId = UUID.randomUUID().toString();
            break;
            label557:
            i = 1;
            break label243;
            j = 1;
          }
          label569:
          ad.i("MicroMsg.ChattingItemAppMsgC2CTo", "native url not match:" + paramView.hBx + ", go webview:" + (String)localObject1);
          if (bt.isNullOrNil((String)localObject1)) {
            break;
          }
          paramView = new Intent();
          paramView.putExtra("rawUrl", (String)localObject1);
          com.tencent.mm.bs.d.b(parama.JOR.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
          break;
          label652:
          if (!bt.isNullOrNil(paramView.hBF))
          {
            ad.i("MicroMsg.ChattingItemAppMsgC2CTo", "tofuliu billNo: %s, c2cNewAAType: %s, fromUser: %s", new Object[] { paramView.hBF, Integer.valueOf(paramView.hBG), paramView.dyU });
            if ((paramView.hBG == 2) || (paramView.hBG == 3) || (paramView.hBG == 1))
            {
              parambu = new Intent();
              parambu.putExtra("bill_no", paramView.hBF);
              parambu.putExtra("launcher_user_name", paramView.dyU);
              parambu.putExtra("enter_scene", 1);
              parambu.putExtra("chatroom", parama.getTalkerUserName());
              com.tencent.mm.bs.d.b(parama.JOR.getContext(), "aa", ".ui.PaylistAAUI", parambu);
              com.tencent.mm.plugin.report.service.g.yhR.f(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
              break;
            }
            if (bt.isNullOrNil((String)localObject1)) {
              break;
            }
            paramView = new Intent();
            paramView.putExtra("rawUrl", (String)localObject1);
            com.tencent.mm.bs.d.b(parama.JOR.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
            break;
          }
          if ((bt.isNullOrNil((String)localObject1)) || (bt.isNullOrNil((String)localObject1))) {
            break;
          }
          paramView = new Intent();
          paramView.putExtra("rawUrl", (String)localObject1);
          com.tencent.mm.bs.d.b(parama.JOR.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
          break;
        }
      }
    }
    
    public final boolean bi(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 436207665);
    }
    
    public final boolean fHh()
    {
      return true;
    }
    
    final boolean fHi()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.f
 * JD-Core Version:    0.7.0.1
 */