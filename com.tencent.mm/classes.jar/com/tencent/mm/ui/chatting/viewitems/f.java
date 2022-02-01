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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.a.xp;
import com.tencent.mm.g.a.xp.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.bfu;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import java.util.UUID;

public final class f
{
  static final class a
    extends c.a
  {
    public int GJV = 0;
    public int GKA = 0;
    public int GKB;
    public long GKC;
    public boolean GKD;
    public ImageView GKs;
    public TextView GKt;
    public TextView GKu;
    public TextView GKv;
    public TextView GKw;
    public TextView GKx;
    public ImageView GKy;
    public ImageView GKz;
    public View icB;
    public int maxSize = 0;
    public View nCB;
    public ImageView toY;
    
    public final a fN(View paramView)
    {
      AppMethodBeat.i(36847);
      super.fK(paramView);
      this.fwS = ((TextView)this.rLd.findViewById(2131298178));
      this.hIS = ((CheckBox)this.rLd.findViewById(2131298068));
      this.lRB = this.rLd.findViewById(2131298147);
      this.wet = ((TextView)this.rLd.findViewById(2131298185));
      this.nCB = this.rLd.findViewById(2131300196);
      this.icB = ((ImageView)this.rLd.findViewById(2131299154));
      this.GKs = ((ImageView)this.rLd.findViewById(2131296913));
      this.GKt = ((TextView)this.rLd.findViewById(2131296919));
      this.GKu = ((TextView)this.rLd.findViewById(2131296911));
      this.GKv = ((TextView)this.rLd.findViewById(2131296922));
      this.naN = this.rLd.findViewById(2131298069);
      this.toY = ((ImageView)this.rLd.findViewById(2131298120));
      this.GKx = ((TextView)this.rLd.findViewById(2131296921));
      this.GKw = ((TextView)this.rLd.findViewById(2131307149));
      this.GKy = ((ImageView)this.rLd.findViewById(2131298121));
      this.GKz = ((ImageView)this.rLd.findViewById(2131296920));
      this.icB = this.rLd.findViewById(2131296912);
      this.GJV = c.jQ(aj.getContext());
      this.GKA = com.tencent.mm.cd.a.ao(aj.getContext(), 2131165217);
      this.maxSize = ((int)(com.tencent.mm.cd.a.ap(aj.getContext(), 2131165217) * 1.45F));
      this.GKB = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 20);
      AppMethodBeat.o(36847);
      return this;
    }
  }
  
  public static final class b
    extends c
  {
    private com.tencent.mm.ui.chatting.d.a Gob;
    
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
        localObject = new af(paramLayoutInflater, 2131493432);
        ((View)localObject).setTag(new f.a().fN((View)localObject));
      }
      AppMethodBeat.o(36848);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
    {
      AppMethodBeat.i(36849);
      this.Gob = parama1;
      f.a locala = (f.a)parama;
      if (locala.GKC == parambl.field_msgId)
      {
        locala.GKD = true;
        locala.GKC = parambl.field_msgId;
        paramString = parambl.field_content;
        if (paramString == null) {
          break label1500;
        }
      }
      label191:
      label461:
      label1109:
      label1494:
      label1500:
      for (k.b localb = k.b.ar(paramString, parambl.field_reserved);; localb = null)
      {
        com.tencent.mm.ai.c localc;
        xp localxp;
        label350:
        Object localObject;
        int i;
        int j;
        if (localb != null)
        {
          localc = (com.tencent.mm.ai.c)localb.ao(com.tencent.mm.ai.c.class);
          boolean bool2 = "1001".equals(localb.gIN);
          localxp = new xp();
          if ((!bt.isNullOrNil(localb.gIO)) && (!bool2))
          {
            localxp.dDK.dDM = localb.gIO;
            com.tencent.mm.sdk.b.a.ESL.l(localxp);
          }
          f.a.aE(locala.naN, locala.GJV);
          if (!"1001".equals(localb.gIN)) {
            break label956;
          }
          paramString = locala.naN;
          if (parambl.field_isSend != 1) {
            break label950;
          }
          bool1 = true;
          paramString.setBackgroundResource(com.tencent.mm.ui.chatting.f.c(localb, bool1));
          locala.GKt.setTypeface(Typeface.defaultFromStyle(1));
          locala.icB.setVisibility(0);
          locala.GKv.setTextColor(parama1.GzJ.getContext().getResources().getColor(2131099828));
          locala.GKv.setAlpha(0.7F);
          parama1.GzJ.getContext().getResources().getDimensionPixelSize(2131165568);
          parama1.GzJ.getContext().getResources().getDimensionPixelSize(2131166006);
          locala.naN.setPadding(0, 0, 0, 0);
          if (parambl.field_isSend != 1) {
            break label1109;
          }
          paramString = localb.gII;
          if (!bt.isNullOrNil(paramString)) {
            break label1119;
          }
          paramString = localb.description;
          locala.GKt.setSingleLine(false);
          locala.GKt.setMaxLines(3);
          locala.GKt.setText(k.b(parama1.GzJ.getContext(), paramString, locala.GKA));
          locala.GKt.setTextSize(0, locala.GKA);
          if (!bool2) {
            break label1137;
          }
          localObject = locala.GKu;
          paramString = parama1.GzJ.getContext();
          if (parambl.field_isSend != 1) {
            break label1131;
          }
          bool1 = true;
          paramString = k.b(paramString, com.tencent.mm.ui.chatting.f.b(localb, bool1), locala.GKu.getTextSize());
          ((TextView)localObject).setText(paramString);
          locala.GKu.setVisibility(0);
          localObject = localb.gIL;
          paramString = (String)localObject;
          if (bt.isNullOrNil((String)localObject)) {
            paramString = localb.title;
          }
          locala.GKv.setText(paramString);
          i = 0;
          if (!bt.isNullOrNil(localc.gGk))
          {
            o.ayJ().loadImage("", locala.GKs);
            j = parama1.GzJ.getMMResources().getIdentifier(localc.gGk, "drawable", aj.getPackageName());
            i = j;
            if (j <= 0) {
              i = parama1.GzJ.getMMResources().getIdentifier(localc.gGk, "raw", aj.getPackageName());
            }
          }
          ad.i("MicroMsg.ChattingItemAppMsgC2CFrom", "c2c loaclResId: %s", new Object[] { Integer.valueOf(i) });
          if (i > 0)
          {
            ad.i("MicroMsg.ChattingItemAppMsgC2CFrom", "set c2cIcon from localRes");
            locala.GKs.setImageResource(i);
          }
          if (!"1001".equals(localb.gIN)) {
            break label1286;
          }
          if (parambl.field_isSend != 1) {
            break label1280;
          }
          bool1 = true;
          j = com.tencent.mm.ui.chatting.f.a(localb, bool1);
          if (j <= 0) {
            break label1338;
          }
          ad.i("MicroMsg.ChattingItemAppMsgC2CFrom", "set c2cIcon from iconRes");
          locala.GKs.setImageResource(j);
          i = -1;
          if (!bt.isNullOrNil(localc.gGl)) {
            i = parama1.GzJ.getMMResources().getIdentifier(localc.gGl, "drawable", aj.getPackageName());
          }
          ad.i("MicroMsg.ChattingItemAppMsgC2CFrom", "backgroundResId: %s", new Object[] { Integer.valueOf(i) });
          if (i > 0) {
            locala.naN.setBackgroundResource(i);
          }
          i = localxp.dDL.dDO;
          j = localxp.dDL.dDP;
          if (parambl.field_isSend != 1) {
            break label1453;
          }
        }
        for (boolean bool1 = true;; bool1 = false)
        {
          f.a(locala, localc, true, com.tencent.mm.ui.chatting.f.G(i, j, bool1), parama1.getTalkerUserName(), parambl);
          parama.naN.setOnClickListener(d(parama1));
          if (!w.sz(parama1.getTalkerUserName())) {
            parama.naN.setOnLongClickListener(c(parama1));
          }
          parama.naN.setOnTouchListener(((i)parama1.be(i.class)).eWp());
          parambl = new bi(parambl, this.Gob.eZb(), paramInt, null, '\000');
          parama.naN.setTag(parambl);
          if (((f.a)parama).nCB == null) {
            break label1494;
          }
          if (!ai.Eq()) {
            break label1459;
          }
          ((f.a)parama).nCB.setBackground(null);
          ((f.a)parama).icB.setVisibility(0);
          AppMethodBeat.o(36849);
          return;
          locala.GKD = false;
          break;
          bool1 = false;
          break label191;
          paramString = locala.naN;
          i = localxp.dDL.dDO;
          j = localxp.dDL.dDP;
          if (parambl.field_isSend == 1)
          {
            bool1 = true;
            label995:
            paramString.setBackgroundResource(com.tencent.mm.ui.chatting.f.E(i, j, bool1));
            locala.GKt.setTypeface(Typeface.defaultFromStyle(1));
            if (locala.GKA <= locala.maxSize) {
              break label1099;
            }
          }
          for (i = locala.maxSize;; i = locala.GKA)
          {
            locala.GKA = i;
            locala.icB.setVisibility(0);
            locala.GKv.setTextColor(parama1.GzJ.getContext().getResources().getColor(2131099828));
            locala.GKv.setAlpha(0.7F);
            break;
            bool1 = false;
            break label995;
          }
          paramString = localb.gIH;
          break label317;
          label1119:
          locala.GKt.setSingleLine(true);
          break label350;
          label1131:
          bool1 = false;
          break label423;
          label1137:
          if (!bt.isNullOrNil(localb.gIO))
          {
            i = localxp.dDL.dDN;
            j = localxp.dDL.dDO;
            k = localxp.dDL.dDP;
            if (parambl.field_isSend == 1) {}
            for (bool1 = true;; bool1 = false)
            {
              paramString = com.tencent.mm.ui.chatting.f.b(i, j, k, bool1, parama1.eZb());
              if (bt.isNullOrNil(paramString)) {
                break label1231;
              }
              localObject = locala.GKu;
              break;
            }
            locala.GKu.setVisibility(8);
            break label461;
          }
          localObject = locala.GKu;
          if (parambl.field_isSend == 1)
          {
            paramString = localb.gIJ;
            break label445;
          }
          paramString = localb.gIK;
          break label445;
          bool1 = false;
          break label650;
          j = localxp.dDL.dDO;
          int k = localxp.dDL.dDP;
          if (parambl.field_isSend == 1) {}
          for (bool1 = true;; bool1 = false)
          {
            j = com.tencent.mm.ui.chatting.f.F(j, k, bool1);
            break;
          }
          if (i > 0) {
            break label683;
          }
          ad.i("MicroMsg.ChattingItemAppMsgC2CFrom", "set c2cIcon from c2cIconUrl");
          localObject = localb.gIG;
          paramString = (String)localObject;
          if (bt.isNullOrNil((String)localObject)) {
            paramString = localb.thumburl;
          }
          locala.GKs.setImageBitmap(null);
          if (bt.isNullOrNil(paramString)) {
            break label683;
          }
          localObject = new com.tencent.mm.aw.a.a.c.a();
          az.arV();
          ((com.tencent.mm.aw.a.a.c.a)localObject).prefixPath = com.tencent.mm.model.c.apX();
          ((com.tencent.mm.aw.a.a.c.a)localObject).hjU = true;
          ((com.tencent.mm.aw.a.a.c.a)localObject).gjA = true;
          localObject = ((com.tencent.mm.aw.a.a.c.a)localObject).azc();
          o.ayJ().a(paramString, locala.GKs, (com.tencent.mm.aw.a.a.c)localObject);
          break label683;
        }
        ((f.a)parama).nCB.setBackground(parama1.GzJ.getMMResources().getDrawable(2131231681));
        ((f.a)parama).icB.setVisibility(8);
        AppMethodBeat.o(36849);
        return;
      }
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
    {
      AppMethodBeat.i(36850);
      int i = ((bi)paramView.getTag()).position;
      paramContextMenu.add(i, 100, 0, this.Gob.GzJ.getMMResources().getString(2131757221));
      if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (bu.eGT())) {
        paramContextMenu.add(i, 144, 0, paramView.getContext().getString(2131761225));
      }
      AppMethodBeat.o(36850);
      return false;
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
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
      paramMenuItem.putExtra("Chat_Msg_Id", parambl.field_msgId);
      com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
      AppMethodBeat.o(36851);
      return true;
    }
    
    public final boolean aX(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 436207665);
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
    {
      int j = 2;
      AppMethodBeat.i(36852);
      ((b)com.tencent.mm.kernel.g.ab(b.class)).Sa(parambl.field_talker);
      paramView = parambl.field_content;
      if (paramView != null) {}
      for (paramView = k.b.ar(paramView, parambl.field_reserved);; paramView = null)
      {
        Object localObject1;
        if (paramView != null)
        {
          if (!bt.isNullOrNil(paramView.gIF)) {
            break label202;
          }
          localObject1 = paramView.url;
          ad.i("MicroMsg.ChattingItemAppMsgC2CFrom", "url==null: %s, billNo==null: %s", new Object[] { Boolean.valueOf(bt.isNullOrNil((String)localObject1)), Boolean.valueOf(bt.isNullOrNil(paramView.gIW)) });
          if (bt.isNullOrNil(paramView.gIO)) {
            break label696;
          }
          if (!paramView.gIO.startsWith("weixin://openNativeUrl/weixinHB/startreceivebizhbrequest")) {
            break label211;
          }
          parambl = new Intent();
          parambl.putExtra("key_way", 1);
          parambl.putExtra("key_native_url", paramView.gIO);
          parambl.putExtra("key_username", parama.getTalkerUserName());
          parambl.putExtra("key_static_from_scene", 100002);
          com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", parambl);
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
          localObject1 = paramView.gIF;
          break;
          if (!paramView.gIO.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao")) {
            break label613;
          }
          localObject2 = new Intent();
          if (!parama.eZb()) {
            break label601;
          }
          i = 0;
          ((Intent)localObject2).putExtra("key_way", i);
          ((Intent)localObject2).putExtra("key_native_url", paramView.gIO);
          ((Intent)localObject2).putExtra("key_username", parama.getTalkerUserName());
          localObject1 = (com.tencent.mm.ai.c)paramView.ao(com.tencent.mm.ai.c.class);
          localObject3 = (com.tencent.mm.ai.g)paramView.ao(com.tencent.mm.ai.g.class);
          ((Intent)localObject2).putExtra("key_cropname", ((com.tencent.mm.ai.c)localObject1).gGn);
          ((Intent)localObject2).putExtra("key_receive_envelope_url", ((com.tencent.mm.ai.c)localObject1).gGs);
          ((Intent)localObject2).putExtra("key_receive_envelope_md5", ((com.tencent.mm.ai.c)localObject1).gGt);
          ((Intent)localObject2).putExtra("key_detail_envelope_url", ((com.tencent.mm.ai.c)localObject1).gGu);
          ((Intent)localObject2).putExtra("key_detail_envelope_md5", ((com.tencent.mm.ai.c)localObject1).gGv);
          ((Intent)localObject2).putExtra("key_about_url", ((com.tencent.mm.ai.g)localObject3).gGP);
          ((Intent)localObject2).putExtra("key_packet_id", ((com.tencent.mm.ai.g)localObject3).gGQ);
          ((Intent)localObject2).putExtra("key_has_story", ((com.tencent.mm.ai.g)localObject3).gGT);
          ((Intent)localObject2).putExtra("key_material_flag", ((com.tencent.mm.ai.g)localObject3).gGU);
          ((Intent)localObject2).putExtra("key_msgid", parambl.field_msgId);
          ((Intent)localObject2).putExtra("key_emoji_md5", ((com.tencent.mm.ai.d)paramView.ao(com.tencent.mm.ai.d.class)).fLP.field_md5);
          com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "luckymoney", ".ui.LuckyMoneyNotHookReceiveUI", (Intent)localObject2);
          if (w.sz(parama.getTalkerUserName())) {
            com.tencent.mm.plugin.luckymoney.a.d.sw(1);
          }
        } while (!((com.tencent.mm.ai.c)localObject1).gGw.gGT);
        if (!bt.isNullOrNil(((com.tencent.mm.ai.c)localObject1).gGw.gGR)) {}
        for (int i = 2;; i = 1)
        {
          paramView = parambl.sessionId;
          localObject2 = ((com.tencent.mm.ai.c)localObject1).gGn;
          parama = parama.getTalkerUserName();
          localObject3 = ((com.tencent.mm.ai.c)localObject1).gGw.gGQ;
          if (((com.tencent.mm.ai.c)localObject1).gGw.gGT) {}
          for (;;)
          {
            com.tencent.mm.plugin.luckymoney.a.c.a(paramView, (String)localObject2, parama, (String)localObject3, j, i);
            com.tencent.mm.plugin.luckymoney.a.c.bi(10, ((com.tencent.mm.ai.c)localObject1).gGo);
            parambl.sessionId = UUID.randomUUID().toString();
            break;
            label601:
            i = 1;
            break label243;
            j = 1;
          }
          label613:
          ad.i("MicroMsg.ChattingItemAppMsgC2CFrom", "native url not match:" + paramView.gIO + ", go webview:" + (String)localObject1);
          if (bt.isNullOrNil((String)localObject1)) {
            break;
          }
          paramView = new Intent();
          paramView.putExtra("rawUrl", (String)localObject1);
          com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
          break;
          label696:
          if (!bt.isNullOrNil(paramView.gIW))
          {
            ad.i("MicroMsg.ChattingItemAppMsgC2CFrom", "tofuliu billNo: %s, c2cNewAAType: %s, fromUser: %s", new Object[] { paramView.gIW, Integer.valueOf(paramView.gIX), paramView.dpv });
            parambl = new Intent();
            parambl.putExtra("bill_no", paramView.gIW);
            parambl.putExtra("launcher_user_name", paramView.dpv);
            parambl.putExtra("enter_scene", 1);
            parambl.putExtra("chatroom", parama.getTalkerUserName());
            com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "aa", ".ui.PaylistAAUI", parambl);
            if (com.tencent.mm.ui.chatting.f.g(paramView).role == 2)
            {
              com.tencent.mm.plugin.report.service.h.vKh.f(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(2) });
              break;
            }
            com.tencent.mm.plugin.report.service.h.vKh.f(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(3) });
            break;
          }
          if (bt.isNullOrNil((String)localObject1)) {
            break;
          }
          paramView = new Intent();
          paramView.putExtra("rawUrl", (String)localObject1);
          com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
          break;
        }
      }
    }
    
    public final boolean faE()
    {
      return false;
    }
    
    final boolean faF()
    {
      return false;
    }
  }
  
  public static final class c
    extends c
  {
    private com.tencent.mm.ui.chatting.d.a Gob;
    
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
        localObject = new af(paramLayoutInflater, 2131493477);
        ((View)localObject).setTag(new f.a().fN((View)localObject));
      }
      AppMethodBeat.o(36854);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
    {
      AppMethodBeat.i(36855);
      this.Gob = parama1;
      f.a locala = (f.a)parama;
      if (locala.GKC == parambl.field_msgId)
      {
        locala.GKD = true;
        locala.GKC = parambl.field_msgId;
        paramString = parambl.field_content;
        if (paramString == null) {
          break label1497;
        }
      }
      label191:
      label458:
      label1106:
      label1491:
      label1497:
      for (k.b localb = k.b.ar(paramString, parambl.field_reserved);; localb = null)
      {
        com.tencent.mm.ai.c localc;
        xp localxp;
        label347:
        Object localObject;
        int i;
        int j;
        if (localb != null)
        {
          localc = (com.tencent.mm.ai.c)localb.ao(com.tencent.mm.ai.c.class);
          boolean bool2 = "1001".equals(localb.gIN);
          localxp = new xp();
          if ((!bt.isNullOrNil(localb.gIO)) && (!bool2))
          {
            localxp.dDK.dDM = localb.gIO;
            com.tencent.mm.sdk.b.a.ESL.l(localxp);
          }
          f.a.aE(locala.naN, locala.GJV);
          if (!"1001".equals(localb.gIN)) {
            break label953;
          }
          paramString = locala.naN;
          if (parambl.field_isSend != 1) {
            break label947;
          }
          bool1 = true;
          paramString.setBackgroundResource(com.tencent.mm.ui.chatting.f.c(localb, bool1));
          locala.GKt.setTypeface(Typeface.defaultFromStyle(1));
          locala.icB.setVisibility(0);
          locala.GKv.setTextColor(parama1.GzJ.getContext().getResources().getColor(2131099828));
          locala.GKv.setAlpha(0.7F);
          com.tencent.mm.cd.a.fromDPToPix(parama1.GzJ.getContext(), 13);
          parama1.GzJ.getContext().getResources().getDimensionPixelSize(2131165500);
          locala.naN.setPadding(0, 0, 0, 0);
          if (parambl.field_isSend != 1) {
            break label1106;
          }
          paramString = localb.gII;
          if (!bt.isNullOrNil(paramString)) {
            break label1116;
          }
          paramString = localb.description;
          locala.GKt.setSingleLine(false);
          locala.GKt.setMaxLines(3);
          locala.GKt.setText(k.b(parama1.GzJ.getContext(), paramString, locala.GKA));
          locala.GKt.setTextSize(0, locala.GKA);
          if (!bool2) {
            break label1134;
          }
          localObject = locala.GKu;
          paramString = parama1.GzJ.getContext();
          if (parambl.field_isSend != 1) {
            break label1128;
          }
          bool1 = true;
          paramString = k.b(paramString, com.tencent.mm.ui.chatting.f.b(localb, bool1), locala.GKu.getTextSize());
          ((TextView)localObject).setText(paramString);
          locala.GKu.setVisibility(0);
          localObject = localb.gIL;
          paramString = (String)localObject;
          if (bt.isNullOrNil((String)localObject)) {
            paramString = localb.title;
          }
          locala.GKv.setText(paramString);
          i = 0;
          if (!bt.isNullOrNil(localc.gGk))
          {
            o.ayJ().loadImage("", locala.GKs);
            j = parama1.GzJ.getMMResources().getIdentifier(localc.gGk, "drawable", aj.getPackageName());
            i = j;
            if (j <= 0) {
              i = parama1.GzJ.getMMResources().getIdentifier(localc.gGk, "raw", aj.getPackageName());
            }
          }
          ad.v("MicroMsg.ChattingItemAppMsgC2CTo", "c2c localResId: %s", new Object[] { Integer.valueOf(i) });
          if (i > 0)
          {
            ad.v("MicroMsg.ChattingItemAppMsgC2CTo", "set c2cIcon from localRes");
            locala.GKs.setImageResource(i);
          }
          if (!"1001".equals(localb.gIN)) {
            break label1283;
          }
          if (parambl.field_isSend != 1) {
            break label1277;
          }
          bool1 = true;
          j = com.tencent.mm.ui.chatting.f.a(localb, bool1);
          if (j <= 0) {
            break label1335;
          }
          ad.i("MicroMsg.ChattingItemAppMsgC2CTo", "set c2cIcon from iconRes");
          locala.GKs.setImageResource(j);
          i = -1;
          if (!bt.isNullOrNil(localc.gGl)) {
            i = parama1.GzJ.getMMResources().getIdentifier(localc.gGl, "drawable", aj.getPackageName());
          }
          ad.i("MicroMsg.ChattingItemAppMsgC2CTo", "backgroundResId: %s", new Object[] { Integer.valueOf(i) });
          if (i > 0) {
            locala.naN.setBackgroundResource(i);
          }
          i = localxp.dDL.dDO;
          j = localxp.dDL.dDP;
          if (parambl.field_isSend != 1) {
            break label1450;
          }
        }
        for (boolean bool1 = true;; bool1 = false)
        {
          f.a(locala, localc, false, com.tencent.mm.ui.chatting.f.G(i, j, bool1), parama1.getTalkerUserName(), parambl);
          parama.naN.setOnClickListener(d(parama1));
          if (!w.sz(parama1.getTalkerUserName())) {
            parama.naN.setOnLongClickListener(c(parama1));
          }
          parama.naN.setOnTouchListener(((i)parama1.be(i.class)).eWp());
          parambl = new bi(parambl, this.Gob.eZb(), paramInt, null, '\000');
          parama.naN.setTag(parambl);
          if (((f.a)parama).nCB == null) {
            break label1491;
          }
          if (!ai.Eq()) {
            break label1456;
          }
          ((f.a)parama).nCB.setBackground(null);
          ((f.a)parama).icB.setVisibility(0);
          AppMethodBeat.o(36855);
          return;
          locala.GKD = false;
          break;
          bool1 = false;
          break label191;
          paramString = locala.naN;
          i = localxp.dDL.dDO;
          j = localxp.dDL.dDP;
          if (parambl.field_isSend == 1)
          {
            bool1 = true;
            label992:
            paramString.setBackgroundResource(com.tencent.mm.ui.chatting.f.E(i, j, bool1));
            locala.GKt.setTypeface(Typeface.defaultFromStyle(1));
            if (locala.GKA <= locala.maxSize) {
              break label1096;
            }
          }
          for (i = locala.maxSize;; i = locala.GKA)
          {
            locala.GKA = i;
            locala.icB.setVisibility(0);
            locala.GKv.setTextColor(parama1.GzJ.getContext().getResources().getColor(2131099828));
            locala.GKv.setAlpha(0.7F);
            break;
            bool1 = false;
            break label992;
          }
          paramString = localb.gIH;
          break label314;
          label1116:
          locala.GKt.setSingleLine(true);
          break label347;
          label1128:
          bool1 = false;
          break label420;
          label1134:
          if (!bt.isNullOrNil(localb.gIO))
          {
            i = localxp.dDL.dDN;
            j = localxp.dDL.dDO;
            k = localxp.dDL.dDP;
            if (parambl.field_isSend == 1) {}
            for (bool1 = true;; bool1 = false)
            {
              paramString = com.tencent.mm.ui.chatting.f.b(i, j, k, bool1, parama1.eZb());
              if (bt.isNullOrNil(paramString)) {
                break label1228;
              }
              localObject = locala.GKu;
              break;
            }
            locala.GKu.setVisibility(8);
            break label458;
          }
          localObject = locala.GKu;
          if (parambl.field_isSend == 1)
          {
            paramString = localb.gIJ;
            break label442;
          }
          paramString = localb.gIK;
          break label442;
          label1277:
          bool1 = false;
          break label647;
          j = localxp.dDL.dDO;
          int k = localxp.dDL.dDP;
          if (parambl.field_isSend == 1) {}
          for (bool1 = true;; bool1 = false)
          {
            j = com.tencent.mm.ui.chatting.f.F(j, k, bool1);
            break;
          }
          if (i > 0) {
            break label680;
          }
          ad.i("MicroMsg.ChattingItemAppMsgC2CTo", "set c2cIcon from iconUrl");
          localObject = localb.gIG;
          paramString = (String)localObject;
          if (bt.isNullOrNil((String)localObject)) {
            paramString = localb.thumburl;
          }
          locala.GKs.setImageBitmap(null);
          if (bt.isNullOrNil(paramString)) {
            break label680;
          }
          localObject = new com.tencent.mm.aw.a.a.c.a();
          az.arV();
          ((com.tencent.mm.aw.a.a.c.a)localObject).prefixPath = com.tencent.mm.model.c.apX();
          ((com.tencent.mm.aw.a.a.c.a)localObject).hjU = true;
          ((com.tencent.mm.aw.a.a.c.a)localObject).gjA = true;
          localObject = ((com.tencent.mm.aw.a.a.c.a)localObject).azc();
          o.ayJ().a(paramString, locala.GKs, (com.tencent.mm.aw.a.a.c)localObject);
          break label680;
        }
        ((f.a)parama).nCB.setBackground(parama1.GzJ.getMMResources().getDrawable(2131231681));
        ((f.a)parama).icB.setVisibility(8);
        AppMethodBeat.o(36855);
        return;
      }
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
    {
      AppMethodBeat.i(36856);
      int i = ((bi)paramView.getTag()).position;
      paramContextMenu.add(i, 100, 0, this.Gob.GzJ.getMMResources().getString(2131757221));
      if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (bu.eGT())) {
        paramContextMenu.add(i, 144, 0, paramView.getContext().getString(2131761225));
      }
      AppMethodBeat.o(36856);
      return false;
    }
    
    public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.d.a parama, final bl parambl)
    {
      AppMethodBeat.i(36857);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(36857);
        return false;
      case 103: 
        final String str1 = parambl.field_content;
        paramMenuItem = null;
        if (str1 != null) {
          paramMenuItem = k.b.ar(str1, parambl.field_reserved);
        }
        if (paramMenuItem != null)
        {
          parambl = parambl.field_talker;
          str1 = paramMenuItem.gIH;
          final String str2 = paramMenuItem.gII;
          final String str3 = paramMenuItem.gIJ;
          final String str4 = paramMenuItem.gIK;
          final String str5 = paramMenuItem.gIF;
          final String str6 = paramMenuItem.gIM;
          paramMenuItem = paramMenuItem.gIN;
          com.tencent.mm.ui.base.h.d(parama.GzJ.getContext(), parama.GzJ.getMMResources().getString(2131757285), parama.GzJ.getMMResources().getString(2131755873), parama.GzJ.getMMResources().getString(2131757286), parama.GzJ.getMMResources().getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(36853);
              paramAnonymousDialogInterface = new Intent();
              paramAnonymousDialogInterface.putExtra("key_scene", 1);
              paramAnonymousDialogInterface.putExtra("key_receiver", parambl);
              paramAnonymousDialogInterface.putExtra("key_receivertitle", str1);
              paramAnonymousDialogInterface.putExtra("key_sendertitle", str2);
              paramAnonymousDialogInterface.putExtra("key_sender_des", str3);
              paramAnonymousDialogInterface.putExtra("key_receiver_des", str4);
              paramAnonymousDialogInterface.putExtra("key_url", str5);
              paramAnonymousDialogInterface.putExtra("key_templateid", str6);
              paramAnonymousDialogInterface.putExtra("key_sceneid", paramMenuItem);
              com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "wallet_index", ".ui.WalletSendC2CMsgUI", paramAnonymousDialogInterface);
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
      paramMenuItem.putExtra("Chat_Msg_Id", parambl.field_msgId);
      com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
      AppMethodBeat.o(36857);
      return true;
    }
    
    public final boolean aX(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 436207665);
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
    {
      int j = 2;
      AppMethodBeat.i(36858);
      ((b)com.tencent.mm.kernel.g.ab(b.class)).Sa(parambl.field_talker);
      paramView = parambl.field_content;
      if (paramView != null) {}
      for (paramView = k.b.ar(paramView, parambl.field_reserved);; paramView = null)
      {
        Object localObject1;
        if (paramView != null)
        {
          if (!bt.isNullOrNil(paramView.gIF)) {
            break label202;
          }
          localObject1 = paramView.url;
          ad.i("MicroMsg.ChattingItemAppMsgC2CTo", "url==null: %s, billNo==null: %s", new Object[] { Boolean.valueOf(bt.isNullOrNil((String)localObject1)), Boolean.valueOf(bt.isNullOrNil(paramView.gIW)) });
          if (bt.isNullOrNil(paramView.gIO)) {
            break label652;
          }
          if (!paramView.gIO.startsWith("weixin://openNativeUrl/weixinHB/startreceivebizhbrequest")) {
            break label211;
          }
          parambl = new Intent();
          parambl.putExtra("key_way", 1);
          parambl.putExtra("key_native_url", paramView.gIO);
          parambl.putExtra("key_username", parama.getTalkerUserName());
          parambl.putExtra("key_static_from_scene", 100002);
          com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", parambl);
        }
        label202:
        label211:
        Object localObject2;
        label243:
        do
        {
          AppMethodBeat.o(36858);
          return true;
          localObject1 = paramView.gIF;
          break;
          if (!paramView.gIO.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao")) {
            break label569;
          }
          localObject2 = new Intent();
          if (!parama.eZb()) {
            break label557;
          }
          i = 0;
          ((Intent)localObject2).putExtra("key_way", i);
          ((Intent)localObject2).putExtra("key_native_url", paramView.gIO);
          ((Intent)localObject2).putExtra("key_username", parama.getTalkerUserName());
          localObject1 = (com.tencent.mm.ai.c)paramView.ao(com.tencent.mm.ai.c.class);
          paramView = (com.tencent.mm.ai.g)paramView.ao(com.tencent.mm.ai.g.class);
          ((Intent)localObject2).putExtra("key_cropname", ((com.tencent.mm.ai.c)localObject1).gGn);
          ((Intent)localObject2).putExtra("key_receive_envelope_url", ((com.tencent.mm.ai.c)localObject1).gGs);
          ((Intent)localObject2).putExtra("key_receive_envelope_md5", ((com.tencent.mm.ai.c)localObject1).gGt);
          ((Intent)localObject2).putExtra("key_detail_envelope_url", ((com.tencent.mm.ai.c)localObject1).gGu);
          ((Intent)localObject2).putExtra("key_detail_envelope_md5", ((com.tencent.mm.ai.c)localObject1).gGv);
          ((Intent)localObject2).putExtra("key_about_url", paramView.gGP);
          ((Intent)localObject2).putExtra("key_packet_id", paramView.gGQ);
          ((Intent)localObject2).putExtra("key_has_story", paramView.gGT);
          ((Intent)localObject2).putExtra("key_material_flag", paramView.gGU);
          ((Intent)localObject2).putExtra("key_msgid", parambl.field_msgId);
          com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "luckymoney", ".ui.LuckyMoneyNotHookReceiveUI", (Intent)localObject2);
        } while (!((com.tencent.mm.ai.c)localObject1).gGw.gGT);
        if (!bt.isNullOrNil(((com.tencent.mm.ai.c)localObject1).gGw.gGR)) {}
        for (int i = 2;; i = 1)
        {
          paramView = parambl.sessionId;
          localObject2 = ((com.tencent.mm.ai.c)localObject1).gGn;
          parama = parama.getTalkerUserName();
          String str = ((com.tencent.mm.ai.c)localObject1).gGw.gGQ;
          if (((com.tencent.mm.ai.c)localObject1).gGw.gGT) {}
          for (;;)
          {
            com.tencent.mm.plugin.luckymoney.a.c.a(paramView, (String)localObject2, parama, str, j, i);
            com.tencent.mm.plugin.luckymoney.a.c.bi(10, ((com.tencent.mm.ai.c)localObject1).gGo);
            parambl.sessionId = UUID.randomUUID().toString();
            break;
            label557:
            i = 1;
            break label243;
            j = 1;
          }
          label569:
          ad.i("MicroMsg.ChattingItemAppMsgC2CTo", "native url not match:" + paramView.gIO + ", go webview:" + (String)localObject1);
          if (bt.isNullOrNil((String)localObject1)) {
            break;
          }
          paramView = new Intent();
          paramView.putExtra("rawUrl", (String)localObject1);
          com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
          break;
          label652:
          if (!bt.isNullOrNil(paramView.gIW))
          {
            ad.i("MicroMsg.ChattingItemAppMsgC2CTo", "tofuliu billNo: %s, c2cNewAAType: %s, fromUser: %s", new Object[] { paramView.gIW, Integer.valueOf(paramView.gIX), paramView.dpv });
            parambl = new Intent();
            parambl.putExtra("bill_no", paramView.gIW);
            parambl.putExtra("launcher_user_name", paramView.dpv);
            parambl.putExtra("enter_scene", 1);
            parambl.putExtra("chatroom", parama.getTalkerUserName());
            com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "aa", ".ui.PaylistAAUI", parambl);
            com.tencent.mm.plugin.report.service.h.vKh.f(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
            break;
          }
          if ((bt.isNullOrNil((String)localObject1)) || (bt.isNullOrNil((String)localObject1))) {
            break;
          }
          paramView = new Intent();
          paramView.putExtra("rawUrl", (String)localObject1);
          com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
          break;
        }
      }
    }
    
    public final boolean faE()
    {
      return true;
    }
    
    final boolean faF()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.f
 * JD-Core Version:    0.7.0.1
 */