package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.g;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.ay.q;
import com.tencent.mm.f.a.abm;
import com.tencent.mm.f.a.abm.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.cjf;
import com.tencent.mm.protocal.protobuf.cjg;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import java.util.UUID;

public final class f
{
  static final class a
    extends c.a
  {
    public ImageView EMl;
    public boolean PvY;
    public ImageView XeS;
    public TextView XeT;
    public TextView XeU;
    public TextView XeV;
    public TextView XeW;
    public TextView XeX;
    public ImageView XeY;
    public ImageView XeZ;
    public int Xev = 0;
    public int Xfa = 0;
    public int Xfb;
    public long Xfc;
    public View mND;
    public int maxSize = 0;
    public View tzi;
    
    public final a hX(View paramView)
    {
      AppMethodBeat.i(36847);
      super.create(paramView);
      this.timeTV = ((TextView)this.convertView.findViewById(R.h.dzs));
      this.checkBox = ((CheckBox)this.convertView.findViewById(R.h.dwZ));
      this.maskView = this.convertView.findViewById(R.h.dyD);
      this.userTV = ((TextView)this.convertView.findViewById(R.h.chatting_user_tv));
      this.tzi = this.convertView.findViewById(R.h.footer);
      this.mND = ((ImageView)this.convertView.findViewById(R.h.divider));
      this.XeS = ((ImageView)this.convertView.findViewById(R.h.drA));
      this.XeT = ((TextView)this.convertView.findViewById(R.h.drG));
      this.XeU = ((TextView)this.convertView.findViewById(R.h.dry));
      this.XeV = ((TextView)this.convertView.findViewById(R.h.drK));
      this.clickArea = this.convertView.findViewById(R.h.chatting_click_area);
      this.EMl = ((ImageView)this.convertView.findViewById(R.h.dxW));
      this.XeX = ((TextView)this.convertView.findViewById(R.h.drJ));
      this.XeW = ((TextView)this.convertView.findViewById(R.h.drH));
      this.XeY = ((ImageView)this.convertView.findViewById(R.h.dxX));
      this.XeZ = ((ImageView)this.convertView.findViewById(R.h.drI));
      this.mND = this.convertView.findViewById(R.h.drz);
      this.Xev = c.lj(MMApplicationContext.getContext());
      this.Xfa = com.tencent.mm.ci.a.aY(MMApplicationContext.getContext(), R.f.ChatLucyTitleTextSize);
      this.maxSize = ((int)(com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), R.f.ChatLucyTitleTextSize) * 1.45F));
      this.Xfb = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 20);
      AppMethodBeat.o(36847);
      return this;
    }
  }
  
  public static final class b
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a WBq;
    
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
        localObject = new aq(paramLayoutInflater, R.i.ecH);
        ((View)localObject).setTag(new f.a().hX((View)localObject));
      }
      AppMethodBeat.o(36848);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(36849);
      this.WBq = parama1;
      f.a locala = (f.a)parama;
      k.b localb;
      com.tencent.mm.aj.c localc;
      abm localabm;
      label196:
      Object localObject;
      label406:
      label439:
      int i;
      label512:
      label534:
      label550:
      int j;
      if (locala.Xfc == paramca.field_msgId)
      {
        locala.PvY = true;
        locala.Xfc = paramca.field_msgId;
        paramString = paramca.field_content;
        localb = null;
        if (paramString != null) {
          localb = k.b.aG(paramString, paramca.field_reserved);
        }
        if (localb != null)
        {
          localc = (com.tencent.mm.aj.c)localb.ar(com.tencent.mm.aj.c.class);
          boolean bool2 = "1001".equals(localb.lnG);
          localabm = new abm();
          if ((!Util.isNullOrNil(localb.lnH)) && (!bool2))
          {
            localabm.gbl.gbn = localb.lnH;
            EventCenter.instance.publish(localabm);
          }
          locala.resetChatBubbleWidth(locala.clickArea, locala.Xev);
          if (!"1001".equals(localb.lnG)) {
            break label1284;
          }
          paramString = locala.clickArea;
          if (paramca.field_isSend != 1) {
            break label1051;
          }
          bool1 = true;
          paramString.setBackgroundResource(com.tencent.mm.ui.chatting.f.c(localb, bool1));
          locala.XeT.setTypeface(Typeface.defaultFromStyle(1));
          locala.mND.setVisibility(0);
          if (ar.isDarkMode()) {
            break label1057;
          }
          locala.XeT.setTextColor(parama1.WQv.getContext().getResources().getColor(R.e.White));
          locala.XeT.setAlpha(1.0F);
          locala.XeU.setTextColor(parama1.WQv.getContext().getResources().getColor(R.e.White));
          locala.XeU.setAlpha(1.0F);
          locala.XeV.setTextColor(parama1.WQv.getContext().getResources().getColor(R.e.White));
          locala.XeV.setAlpha(0.8F);
          locala.XeS.setAlpha(1.0F);
          parama1.WQv.getContext().getResources().getDimensionPixelSize(R.f.SmallPadding);
          parama1.WQv.getContext().getResources().getDimensionPixelSize(R.f.chattingBubblepadding);
          locala.clickArea.setPadding(0, 0, 0, 0);
          if (paramca.field_isSend != 1) {
            break label1439;
          }
          paramString = localb.lnB;
          if (!Util.isNullOrNil(paramString)) {
            break label1449;
          }
          paramString = localb.description;
          locala.XeT.setSingleLine(false);
          locala.XeT.setMaxLines(3);
          locala.XeT.setText(l.d(parama1.WQv.getContext(), paramString, locala.Xfa));
          locala.XeT.setTextSize(0, locala.Xfa);
          if (!bool2) {
            break label1467;
          }
          localObject = locala.XeU;
          paramString = parama1.WQv.getContext();
          if (paramca.field_isSend != 1) {
            break label1461;
          }
          bool1 = true;
          paramString = l.b(paramString, com.tencent.mm.ui.chatting.f.a(localb, bool1), locala.XeU.getTextSize());
          ((TextView)localObject).setText(paramString);
          locala.XeU.setVisibility(0);
          localObject = localb.lnE;
          paramString = (String)localObject;
          if (Util.isNullOrNil((String)localObject)) {
            paramString = localb.title;
          }
          locala.XeV.setText(paramString);
          i = 0;
          if (!Util.isNullOrNil(localc.llb))
          {
            q.bml().loadImage("", locala.XeS);
            j = parama1.WQv.getMMResources().getIdentifier(localc.llb, "drawable", MMApplicationContext.getPackageName());
            i = j;
            if (j <= 0) {
              i = parama1.WQv.getMMResources().getIdentifier(localc.llb, "raw", MMApplicationContext.getPackageName());
            }
          }
          Log.i("MicroMsg.ChattingItemAppMsgC2CFrom", "c2c loaclResId: %s", new Object[] { Integer.valueOf(i) });
          if (i > 0)
          {
            Log.i("MicroMsg.ChattingItemAppMsgC2CFrom", "set c2cIcon from localRes");
            locala.XeS.setImageResource(i);
          }
          if (!"1001".equals(localb.lnG)) {
            break label1665;
          }
          if (paramca.field_isSend != 1) {
            break label1659;
          }
          bool1 = true;
          label739:
          j = com.tencent.mm.ui.chatting.f.b(localb, bool1);
          if (j <= 0) {
            break label1717;
          }
          Log.i("MicroMsg.ChattingItemAppMsgC2CFrom", "set c2cIcon from iconRes");
          locala.XeS.setImageResource(j);
          label772:
          i = -1;
          if (!Util.isNullOrNil(localc.llc)) {
            i = parama1.WQv.getMMResources().getIdentifier(localc.llc, "drawable", MMApplicationContext.getPackageName());
          }
          Log.i("MicroMsg.ChattingItemAppMsgC2CFrom", "backgroundResId: %s", new Object[] { Integer.valueOf(i) });
          if (i > 0)
          {
            locala.clickArea.setBackgroundResource(i);
            locala.clickArea.setPadding(0, 0, 0, 0);
          }
          i = localabm.gbm.gbp;
          j = localabm.gbm.gbq;
          if (paramca.field_isSend != 1) {
            break label1832;
          }
        }
      }
      label1051:
      label1057:
      label1832:
      for (boolean bool1 = true;; bool1 = false)
      {
        f.a(locala, localc, true, com.tencent.mm.ui.chatting.f.R(i, j, bool1), parama1.getTalkerUserName(), paramca);
        parama.clickArea.setOnClickListener(d(parama1));
        if (!ab.Qg(parama1.getTalkerUserName())) {
          parama.clickArea.setOnLongClickListener(c(parama1));
        }
        parama.clickArea.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
        paramca = new by(paramca, this.WBq.hRi(), paramInt, null, '\000');
        parama.clickArea.setTag(paramca);
        if (((f.a)parama).tzi == null) {
          break label1873;
        }
        if (!ar.isDarkMode()) {
          break label1838;
        }
        ((f.a)parama).tzi.setBackground(null);
        ((f.a)parama).mND.setVisibility(0);
        AppMethodBeat.o(36849);
        return;
        locala.PvY = false;
        break;
        bool1 = false;
        break label196;
        locala.XeT.setTextColor(parama1.WQv.getContext().getResources().getColor(R.e.White));
        locala.XeU.setTextColor(parama1.WQv.getContext().getResources().getColor(R.e.White));
        locala.XeV.setTextColor(parama1.WQv.getContext().getResources().getColor(R.e.White));
        paramString = locala.XeT;
        if (paramca.field_isSend == 1)
        {
          bool1 = true;
          label1148:
          paramString.setAlpha(com.tencent.mm.ui.chatting.f.a(localb, bool1, false));
          paramString = locala.XeU;
          if (paramca.field_isSend != 1) {
            break label1266;
          }
          bool1 = true;
          paramString.setAlpha(com.tencent.mm.ui.chatting.f.a(localb, bool1, false));
          paramString = locala.XeV;
          if (paramca.field_isSend != 1) {
            break label1272;
          }
          bool1 = true;
          label1212:
          paramString.setAlpha(com.tencent.mm.ui.chatting.f.a(localb, bool1, true));
          paramString = locala.XeS;
          if (paramca.field_isSend != 1) {
            break label1278;
          }
        }
        label1266:
        label1272:
        label1278:
        for (bool1 = true;; bool1 = false)
        {
          paramString.setAlpha(com.tencent.mm.ui.chatting.f.a(localb, bool1, false));
          break;
          bool1 = false;
          break label1148;
          bool1 = false;
          break label1180;
          bool1 = false;
          break label1212;
        }
        paramString = locala.clickArea;
        i = localabm.gbm.gbp;
        j = localabm.gbm.gbq;
        if (paramca.field_isSend == 1)
        {
          bool1 = true;
          label1323:
          paramString.setBackgroundResource(com.tencent.mm.ui.chatting.f.P(i, j, bool1));
          locala.XeT.setTypeface(Typeface.defaultFromStyle(1));
          if (locala.Xfa <= locala.maxSize) {
            break label1429;
          }
        }
        for (i = locala.maxSize;; i = locala.Xfa)
        {
          locala.Xfa = i;
          locala.mND.setVisibility(0);
          locala.XeV.setTextColor(parama1.WQv.getContext().getResources().getColor(R.e.White));
          locala.XeV.setAlpha(0.7F);
          break;
          bool1 = false;
          break label1323;
        }
        paramString = localb.lnA;
        break label406;
        label1449:
        locala.XeT.setSingleLine(true);
        break label439;
        label1461:
        bool1 = false;
        break label512;
        label1467:
        if (!Util.isNullOrNil(localb.lnH))
        {
          locala.XeU.setTextSize(1, 12.0F);
          i = localabm.gbm.gbo;
          j = localabm.gbm.gbp;
          k = localabm.gbm.gbq;
          if (paramca.field_isSend == 1) {}
          for (bool1 = true;; bool1 = false)
          {
            paramString = com.tencent.mm.ui.chatting.f.a(i, j, k, bool1, parama1.hRi(), parama1.getTalkerUserName(), localb, locala.XeU);
            if (Util.isNullOrNil(paramString)) {
              break label1610;
            }
            localObject = locala.XeU;
            paramString = l.b(locala.XeU.getContext(), Util.nullAsNil(paramString), locala.XeU.getTextSize());
            break;
          }
          label1610:
          locala.XeU.setVisibility(8);
          break label550;
        }
        localObject = locala.XeU;
        if (paramca.field_isSend == 1)
        {
          paramString = localb.lnC;
          break label534;
        }
        paramString = localb.lnD;
        break label534;
        label1659:
        bool1 = false;
        break label739;
        j = localabm.gbm.gbp;
        int k = localabm.gbm.gbq;
        if (paramca.field_isSend == 1) {}
        for (bool1 = true;; bool1 = false)
        {
          j = com.tencent.mm.ui.chatting.f.Q(j, k, bool1);
          break;
        }
        label1717:
        if (i > 0) {
          break label772;
        }
        Log.i("MicroMsg.ChattingItemAppMsgC2CFrom", "set c2cIcon from c2cIconUrl");
        localObject = localb.lnz;
        paramString = (String)localObject;
        if (Util.isNullOrNil((String)localObject)) {
          paramString = localb.thumburl;
        }
        locala.XeS.setImageBitmap(null);
        if (Util.isNullOrNil(paramString)) {
          break label772;
        }
        localObject = new com.tencent.mm.ay.a.a.c.a();
        bh.beI();
        ((com.tencent.mm.ay.a.a.c.a)localObject).prefixPath = com.tencent.mm.model.c.bbX();
        ((com.tencent.mm.ay.a.a.c.a)localObject).lRD = true;
        ((com.tencent.mm.ay.a.a.c.a)localObject).kOl = true;
        localObject = ((com.tencent.mm.ay.a.a.c.a)localObject).bmL();
        q.bml().a(paramString, locala.XeS, (com.tencent.mm.ay.a.a.c)localObject);
        break label772;
      }
      label1180:
      label1439:
      label1838:
      ((f.a)parama).tzi.setBackground(parama1.WQv.getMMResources().getDrawable(R.g.dmY));
      label1284:
      label1429:
      ((f.a)parama).mND.setVisibility(8);
      label1665:
      label1873:
      AppMethodBeat.o(36849);
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
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
      paramMenuItem.putExtra("Chat_Msg_Id", paramca.field_msgId);
      com.tencent.mm.by.c.b(parama.WQv.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
      AppMethodBeat.o(36851);
      return true;
    }
    
    public final boolean a(o paramo, View paramView, ca paramca)
    {
      AppMethodBeat.i(287857);
      int i = ((by)paramView.getTag()).position;
      paramo.a(i, 100, this.WBq.WQv.getMMResources().getString(R.l.evO), R.k.icons_filled_delete);
      if ((BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())) {
        paramo.a(i, 144, paramView.getContext().getString(R.l.menu_show_app_msg_content), R.k.fix_tools_entry);
      }
      AppMethodBeat.o(287857);
      return false;
    }
    
    public final boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 436207665);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      int i = 0;
      int j = 2;
      AppMethodBeat.i(36852);
      if (!WeChatBrands.Business.Entries.SessionLuckyMoney.checkAvailable(paramView.getContext()))
      {
        AppMethodBeat.o(36852);
        return true;
      }
      ((b)com.tencent.mm.kernel.h.ae(b.class)).asK(paramca.field_talker);
      paramView = paramca.field_content;
      if (paramView != null) {}
      for (paramView = k.b.aG(paramView, paramca.field_reserved);; paramView = null)
      {
        Object localObject1;
        if (paramView != null)
        {
          if (!Util.isNullOrNil(paramView.lny)) {
            break label226;
          }
          localObject1 = paramView.url;
          Log.i("MicroMsg.ChattingItemAppMsgC2CFrom", "url==null: %s, billNo==null: %s", new Object[] { Boolean.valueOf(Util.isNullOrNil((String)localObject1)), Boolean.valueOf(Util.isNullOrNil(paramView.lnP)) });
          if (Util.isNullOrNil(paramView.lnH)) {
            break label898;
          }
          if (!paramView.lnH.startsWith("weixin://openNativeUrl/weixinHB/startreceivebizhbrequest")) {
            break label235;
          }
          paramca = new Intent();
          paramca.putExtra("key_way", 1);
          paramca.putExtra("key_native_url", paramView.lnH);
          paramca.putExtra("key_username", parama.getTalkerUserName());
          paramca.putExtra("key_static_from_scene", 100002);
          com.tencent.mm.by.c.b(parama.WQv.getContext(), "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", paramca);
        }
        label226:
        label235:
        Object localObject2;
        label267:
        Object localObject3;
        do
        {
          AppMethodBeat.o(36852);
          return true;
          localObject1 = paramView.lny;
          break;
          if (!paramView.lnH.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao")) {
            break label688;
          }
          localObject2 = new Intent();
          if (!parama.hRi()) {
            break label676;
          }
          i = 0;
          ((Intent)localObject2).putExtra("key_way", i);
          ((Intent)localObject2).putExtra("key_native_url", paramView.lnH);
          ((Intent)localObject2).putExtra("key_username", parama.getTalkerUserName());
          ((Intent)localObject2).putExtra("scene_id", Integer.parseInt(paramView.lnG));
          ((Intent)localObject2).putExtra("key_invalidtime", paramView.lnh);
          localObject1 = (com.tencent.mm.aj.c)paramView.ar(com.tencent.mm.aj.c.class);
          localObject3 = (g)paramView.ar(g.class);
          ((Intent)localObject2).putExtra("key_exclusive_username", ((com.tencent.mm.aj.c)localObject1).lln);
          ((Intent)localObject2).putExtra("key_cropname", ((com.tencent.mm.aj.c)localObject1).lle);
          ((Intent)localObject2).putExtra("key_receive_envelope_url", ((com.tencent.mm.aj.c)localObject1).llj);
          ((Intent)localObject2).putExtra("key_receive_envelope_md5", ((com.tencent.mm.aj.c)localObject1).llk);
          ((Intent)localObject2).putExtra("key_detail_envelope_url", ((com.tencent.mm.aj.c)localObject1).lll);
          ((Intent)localObject2).putExtra("key_detail_envelope_md5", ((com.tencent.mm.aj.c)localObject1).llm);
          ((Intent)localObject2).putExtra("key_about_url", ((g)localObject3).llG);
          ((Intent)localObject2).putExtra("key_packet_id", ((g)localObject3).llH);
          ((Intent)localObject2).putExtra("key_has_story", ((g)localObject3).llK);
          ((Intent)localObject2).putExtra("key_material_flag", ((g)localObject3).llL);
          ((Intent)localObject2).putExtra("key_msgid", paramca.field_msgId);
          ((Intent)localObject2).putExtra("key_emoji_md5", ((com.tencent.mm.aj.d)paramView.ar(com.tencent.mm.aj.d.class)).jHh.field_md5);
          com.tencent.mm.by.c.b(parama.WQv.getContext(), "luckymoney", ".ui.LuckyMoneyNotHookReceiveUI", (Intent)localObject2);
          if (ab.Qg(parama.getTalkerUserName())) {
            com.tencent.mm.plugin.luckymoney.a.d.Bv(1);
          }
        } while ((((com.tencent.mm.aj.c)localObject1).llo == null) || (!((com.tencent.mm.aj.c)localObject1).llo.llK));
        if (!Util.isNullOrNil(((com.tencent.mm.aj.c)localObject1).llo.llI)) {}
        for (i = 2;; i = 1)
        {
          paramView = paramca.sessionId;
          localObject2 = ((com.tencent.mm.aj.c)localObject1).lle;
          parama = parama.getTalkerUserName();
          localObject3 = ((com.tencent.mm.aj.c)localObject1).llo.llH;
          if (((com.tencent.mm.aj.c)localObject1).llo.llK) {}
          for (;;)
          {
            com.tencent.mm.plugin.luckymoney.a.c.a(paramView, (String)localObject2, parama, (String)localObject3, j, i);
            com.tencent.mm.plugin.luckymoney.a.c.bz(10, ((com.tencent.mm.aj.c)localObject1).llf);
            paramca.sessionId = UUID.randomUUID().toString();
            break;
            label676:
            i = 1;
            break label267;
            j = 1;
          }
          label688:
          if (paramView.lnH.startsWith("frhb://c2cbizmessagehandler/hongbao/receivehongbao"))
          {
            localObject2 = new Intent();
            if (parama.hRi()) {}
            for (;;)
            {
              ((Intent)localObject2).putExtra("key_way", i);
              ((Intent)localObject2).putExtra("key_native_url", paramView.lnH);
              ((Intent)localObject2).putExtra("key_hk_url", (String)localObject1);
              ((Intent)localObject2).putExtra("key_username", parama.getTalkerUserName());
              ((Intent)localObject2).putExtra("key_msgid", paramca.field_msgId);
              ((Intent)localObject2).putExtra("key_hk_scene", 1);
              com.tencent.mm.by.c.b(parama.WQv.getContext(), "luckymoney", ".hk.ui.LuckyMoneyHKReceiveUI", (Intent)localObject2);
              break;
              i = 1;
            }
          }
          Log.i("MicroMsg.ChattingItemAppMsgC2CFrom", "native url not match:" + paramView.lnH + ", go webview:" + (String)localObject1);
          if (Util.isNullOrNil((String)localObject1)) {
            break;
          }
          paramView = new Intent();
          paramView.putExtra("rawUrl", (String)localObject1);
          com.tencent.mm.by.c.b(parama.WQv.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
          break;
          label898:
          if (!Util.isNullOrNil(paramView.lnP))
          {
            Log.i("MicroMsg.ChattingItemAppMsgC2CFrom", "tofuliu billNo: %s, c2cNewAAType: %s, fromUser: %s", new Object[] { paramView.lnP, Integer.valueOf(paramView.lnQ), paramView.fLi });
            if ((paramView.lnQ == 2) || (paramView.lnQ == 3) || (paramView.lnQ == 1) || (paramView.lnQ == 5))
            {
              paramca = new Intent();
              paramca.putExtra("bill_no", paramView.lnP);
              paramca.putExtra("launcher_user_name", paramView.fLi);
              paramca.putExtra("enter_scene", 1);
              paramca.putExtra("chatroom", parama.getTalkerUserName());
              com.tencent.mm.by.c.b(parama.WQv.getContext(), "aa", ".ui.PaylistAAUI", paramca);
            }
            for (;;)
            {
              if (com.tencent.mm.ui.chatting.f.h(paramView).role == 2)
              {
                if (paramView.lnQ == 2)
                {
                  com.tencent.mm.plugin.report.service.h.IzE.a(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(2), Integer.valueOf(2) });
                  break;
                  if (Util.isNullOrNil((String)localObject1)) {
                    continue;
                  }
                  paramca = new Intent();
                  paramca.putExtra("rawUrl", (String)localObject1);
                  com.tencent.mm.by.c.b(parama.WQv.getContext(), "webview", ".ui.tools.WebViewUI", paramca);
                  continue;
                }
                if (paramView.lnQ == 3)
                {
                  com.tencent.mm.plugin.report.service.h.IzE.a(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(2), Integer.valueOf(3) });
                  break;
                }
                if (paramView.lnQ != 5) {
                  break;
                }
                com.tencent.mm.plugin.report.service.h.IzE.a(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(2), Integer.valueOf(4) });
                break;
              }
            }
            if (paramView.lnQ == 2)
            {
              com.tencent.mm.plugin.report.service.h.IzE.a(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(2) });
              break;
            }
            if (paramView.lnQ == 3)
            {
              com.tencent.mm.plugin.report.service.h.IzE.a(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(3) });
              break;
            }
            if (paramView.lnQ != 5) {
              break;
            }
            com.tencent.mm.plugin.report.service.h.IzE.a(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(4) });
            break;
          }
          if (Util.isNullOrNil((String)localObject1)) {
            break;
          }
          paramView = new Intent();
          paramView.putExtra("rawUrl", (String)localObject1);
          com.tencent.mm.by.c.b(parama.WQv.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
          break;
        }
      }
    }
    
    public final boolean hTD()
    {
      return false;
    }
    
    final boolean hTF()
    {
      return false;
    }
  }
  
  public static final class c
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a WBq;
    
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
        localObject = new aq(paramLayoutInflater, R.i.edI);
        ((View)localObject).setTag(new f.a().hX((View)localObject));
      }
      AppMethodBeat.o(36854);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(36855);
      this.WBq = parama1;
      f.a locala = (f.a)parama;
      k.b localb;
      com.tencent.mm.aj.c localc;
      abm localabm;
      label196:
      Object localObject;
      label402:
      label435:
      label508:
      int i;
      label530:
      label546:
      int j;
      if (locala.Xfc == paramca.field_msgId)
      {
        locala.PvY = true;
        locala.Xfc = paramca.field_msgId;
        paramString = paramca.field_content;
        localb = null;
        if (paramString != null) {
          localb = k.b.aG(paramString, paramca.field_reserved);
        }
        if (localb != null)
        {
          localc = (com.tencent.mm.aj.c)localb.ar(com.tencent.mm.aj.c.class);
          boolean bool2 = "1001".equals(localb.lnG);
          localabm = new abm();
          if ((!Util.isNullOrNil(localb.lnH)) && (!bool2))
          {
            localabm.gbl.gbn = localb.lnH;
            EventCenter.instance.publish(localabm);
          }
          locala.resetChatBubbleWidth(locala.clickArea, locala.Xev);
          if (!"1001".equals(localb.lnG)) {
            break label1280;
          }
          paramString = locala.clickArea;
          if (paramca.field_isSend != 1) {
            break label1047;
          }
          bool1 = true;
          paramString.setBackgroundResource(com.tencent.mm.ui.chatting.f.c(localb, bool1));
          locala.XeT.setTypeface(Typeface.defaultFromStyle(1));
          locala.mND.setVisibility(0);
          if (ar.isDarkMode()) {
            break label1053;
          }
          locala.XeT.setTextColor(parama1.WQv.getContext().getResources().getColor(R.e.White));
          locala.XeT.setAlpha(1.0F);
          locala.XeU.setTextColor(parama1.WQv.getContext().getResources().getColor(R.e.White));
          locala.XeU.setAlpha(1.0F);
          locala.XeV.setTextColor(parama1.WQv.getContext().getResources().getColor(R.e.White));
          locala.XeV.setAlpha(0.8F);
          locala.XeS.setAlpha(1.0F);
          com.tencent.mm.ci.a.fromDPToPix(parama1.WQv.getContext(), 13);
          parama1.WQv.getContext().getResources().getDimensionPixelSize(R.f.MiddlePadding);
          locala.clickArea.setPadding(0, 0, 0, 0);
          if (paramca.field_isSend != 1) {
            break label1435;
          }
          paramString = localb.lnB;
          if (!Util.isNullOrNil(paramString)) {
            break label1445;
          }
          paramString = localb.description;
          locala.XeT.setSingleLine(false);
          locala.XeT.setMaxLines(3);
          locala.XeT.setText(l.d(parama1.WQv.getContext(), paramString, locala.Xfa));
          locala.XeT.setTextSize(0, locala.Xfa);
          if (!bool2) {
            break label1463;
          }
          localObject = locala.XeU;
          paramString = parama1.WQv.getContext();
          if (paramca.field_isSend != 1) {
            break label1457;
          }
          bool1 = true;
          paramString = l.b(paramString, com.tencent.mm.ui.chatting.f.a(localb, bool1), locala.XeU.getTextSize());
          ((TextView)localObject).setText(paramString);
          locala.XeU.setVisibility(0);
          localObject = localb.lnE;
          paramString = (String)localObject;
          if (Util.isNullOrNil((String)localObject)) {
            paramString = localb.title;
          }
          locala.XeV.setText(paramString);
          i = 0;
          if (!Util.isNullOrNil(localc.llb))
          {
            q.bml().loadImage("", locala.XeS);
            j = parama1.WQv.getMMResources().getIdentifier(localc.llb, "drawable", MMApplicationContext.getPackageName());
            i = j;
            if (j <= 0) {
              i = parama1.WQv.getMMResources().getIdentifier(localc.llb, "raw", MMApplicationContext.getPackageName());
            }
          }
          Log.v("MicroMsg.ChattingItemAppMsgC2CTo", "c2c localResId: %s", new Object[] { Integer.valueOf(i) });
          if (i > 0)
          {
            Log.v("MicroMsg.ChattingItemAppMsgC2CTo", "set c2cIcon from localRes");
            locala.XeS.setImageResource(i);
          }
          if (!"1001".equals(localb.lnG)) {
            break label1661;
          }
          if (paramca.field_isSend != 1) {
            break label1655;
          }
          bool1 = true;
          label735:
          j = com.tencent.mm.ui.chatting.f.b(localb, bool1);
          if (j <= 0) {
            break label1713;
          }
          Log.i("MicroMsg.ChattingItemAppMsgC2CTo", "set c2cIcon from iconRes");
          locala.XeS.setImageResource(j);
          label768:
          i = -1;
          if (!Util.isNullOrNil(localc.llc)) {
            i = parama1.WQv.getMMResources().getIdentifier(localc.llc, "drawable", MMApplicationContext.getPackageName());
          }
          Log.i("MicroMsg.ChattingItemAppMsgC2CTo", "backgroundResId: %s", new Object[] { Integer.valueOf(i) });
          if (i > 0)
          {
            locala.clickArea.setBackgroundResource(i);
            locala.clickArea.setPadding(0, 0, 0, 0);
          }
          i = localabm.gbm.gbp;
          j = localabm.gbm.gbq;
          if (paramca.field_isSend != 1) {
            break label1828;
          }
        }
      }
      label1047:
      label1053:
      label1828:
      for (boolean bool1 = true;; bool1 = false)
      {
        f.a(locala, localc, false, com.tencent.mm.ui.chatting.f.R(i, j, bool1), parama1.getTalkerUserName(), paramca);
        parama.clickArea.setOnClickListener(d(parama1));
        if (!ab.Qg(parama1.getTalkerUserName())) {
          parama.clickArea.setOnLongClickListener(c(parama1));
        }
        parama.clickArea.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
        paramca = new by(paramca, this.WBq.hRi(), paramInt, null, '\000');
        parama.clickArea.setTag(paramca);
        if (((f.a)parama).tzi == null) {
          break label1869;
        }
        if (!ar.isDarkMode()) {
          break label1834;
        }
        ((f.a)parama).tzi.setBackground(null);
        ((f.a)parama).mND.setVisibility(0);
        AppMethodBeat.o(36855);
        return;
        locala.PvY = false;
        break;
        bool1 = false;
        break label196;
        locala.XeT.setTextColor(parama1.WQv.getContext().getResources().getColor(R.e.White));
        locala.XeU.setTextColor(parama1.WQv.getContext().getResources().getColor(R.e.White));
        locala.XeV.setTextColor(parama1.WQv.getContext().getResources().getColor(R.e.White));
        paramString = locala.XeT;
        if (paramca.field_isSend == 1)
        {
          bool1 = true;
          label1144:
          paramString.setAlpha(com.tencent.mm.ui.chatting.f.a(localb, bool1, false));
          paramString = locala.XeU;
          if (paramca.field_isSend != 1) {
            break label1262;
          }
          bool1 = true;
          paramString.setAlpha(com.tencent.mm.ui.chatting.f.a(localb, bool1, false));
          paramString = locala.XeV;
          if (paramca.field_isSend != 1) {
            break label1268;
          }
          bool1 = true;
          label1208:
          paramString.setAlpha(com.tencent.mm.ui.chatting.f.a(localb, bool1, true));
          paramString = locala.XeS;
          if (paramca.field_isSend != 1) {
            break label1274;
          }
        }
        label1262:
        label1268:
        label1274:
        for (bool1 = true;; bool1 = false)
        {
          paramString.setAlpha(com.tencent.mm.ui.chatting.f.a(localb, bool1, false));
          break;
          bool1 = false;
          break label1144;
          bool1 = false;
          break label1176;
          bool1 = false;
          break label1208;
        }
        paramString = locala.clickArea;
        i = localabm.gbm.gbp;
        j = localabm.gbm.gbq;
        if (paramca.field_isSend == 1)
        {
          bool1 = true;
          label1319:
          paramString.setBackgroundResource(com.tencent.mm.ui.chatting.f.P(i, j, bool1));
          locala.XeT.setTypeface(Typeface.defaultFromStyle(1));
          if (locala.Xfa <= locala.maxSize) {
            break label1425;
          }
        }
        for (i = locala.maxSize;; i = locala.Xfa)
        {
          locala.Xfa = i;
          locala.mND.setVisibility(0);
          locala.XeV.setTextColor(parama1.WQv.getContext().getResources().getColor(R.e.White));
          locala.XeV.setAlpha(0.7F);
          break;
          bool1 = false;
          break label1319;
        }
        paramString = localb.lnA;
        break label402;
        label1445:
        locala.XeT.setSingleLine(true);
        break label435;
        label1457:
        bool1 = false;
        break label508;
        label1463:
        if (!Util.isNullOrNil(localb.lnH))
        {
          locala.XeU.setTextSize(1, 12.0F);
          i = localabm.gbm.gbo;
          j = localabm.gbm.gbp;
          k = localabm.gbm.gbq;
          if (paramca.field_isSend == 1) {}
          for (bool1 = true;; bool1 = false)
          {
            paramString = com.tencent.mm.ui.chatting.f.a(i, j, k, bool1, parama1.hRi(), parama1.getTalkerUserName(), localb, locala.XeU);
            if (Util.isNullOrNil(paramString)) {
              break label1606;
            }
            localObject = locala.XeU;
            paramString = l.b(locala.XeU.getContext(), Util.nullAsNil(paramString), locala.XeU.getTextSize());
            break;
          }
          label1606:
          locala.XeU.setVisibility(8);
          break label546;
        }
        localObject = locala.XeU;
        if (paramca.field_isSend == 1)
        {
          paramString = localb.lnC;
          break label530;
        }
        paramString = localb.lnD;
        break label530;
        label1655:
        bool1 = false;
        break label735;
        label1661:
        j = localabm.gbm.gbp;
        int k = localabm.gbm.gbq;
        if (paramca.field_isSend == 1) {}
        for (bool1 = true;; bool1 = false)
        {
          j = com.tencent.mm.ui.chatting.f.Q(j, k, bool1);
          break;
        }
        label1713:
        if (i > 0) {
          break label768;
        }
        Log.i("MicroMsg.ChattingItemAppMsgC2CTo", "set c2cIcon from iconUrl");
        localObject = localb.lnz;
        paramString = (String)localObject;
        if (Util.isNullOrNil((String)localObject)) {
          paramString = localb.thumburl;
        }
        locala.XeS.setImageBitmap(null);
        if (Util.isNullOrNil(paramString)) {
          break label768;
        }
        localObject = new com.tencent.mm.ay.a.a.c.a();
        bh.beI();
        ((com.tencent.mm.ay.a.a.c.a)localObject).prefixPath = com.tencent.mm.model.c.bbX();
        ((com.tencent.mm.ay.a.a.c.a)localObject).lRD = true;
        ((com.tencent.mm.ay.a.a.c.a)localObject).kOl = true;
        localObject = ((com.tencent.mm.ay.a.a.c.a)localObject).bmL();
        q.bml().a(paramString, locala.XeS, (com.tencent.mm.ay.a.a.c)localObject);
        break label768;
      }
      label1176:
      label1435:
      label1834:
      ((f.a)parama).tzi.setBackground(parama1.WQv.getMMResources().getDrawable(R.g.dmY));
      label1280:
      label1425:
      ((f.a)parama).mND.setVisibility(8);
      label1869:
      AppMethodBeat.o(36855);
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(36857);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(36857);
        return false;
      case 103: 
        String str1 = paramca.field_content;
        paramMenuItem = null;
        if (str1 != null) {
          paramMenuItem = k.b.aG(str1, paramca.field_reserved);
        }
        if (paramMenuItem != null)
        {
          paramca = paramca.field_talker;
          str1 = paramMenuItem.lnA;
          String str2 = paramMenuItem.lnB;
          String str3 = paramMenuItem.lnC;
          String str4 = paramMenuItem.lnD;
          String str5 = paramMenuItem.lny;
          String str6 = paramMenuItem.lnF;
          paramMenuItem = paramMenuItem.lnG;
          com.tencent.mm.ui.base.h.c(parama.WQv.getContext(), parama.WQv.getMMResources().getString(R.l.ewI), parama.WQv.getMMResources().getString(R.l.app_remind), parama.WQv.getMMResources().getString(R.l.ewJ), parama.WQv.getMMResources().getString(R.l.app_cancel), new f.c.1(this, paramca, str1, str2, str3, str4, str5, str6, paramMenuItem, parama), new f.c.2(this));
        }
        AppMethodBeat.o(36857);
        return true;
      }
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Chat_Msg_Id", paramca.field_msgId);
      com.tencent.mm.by.c.b(parama.WQv.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
      AppMethodBeat.o(36857);
      return true;
    }
    
    public final boolean a(o paramo, View paramView, ca paramca)
    {
      AppMethodBeat.i(196134);
      int i = ((by)paramView.getTag()).position;
      paramo.a(i, 100, this.WBq.WQv.getMMResources().getString(R.l.evO), R.k.icons_filled_delete);
      if ((BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())) {
        paramo.a(i, 144, paramView.getContext().getString(R.l.menu_show_app_msg_content), R.k.fix_tools_entry);
      }
      AppMethodBeat.o(196134);
      return false;
    }
    
    public final boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 436207665);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      int i = 0;
      int j = 2;
      AppMethodBeat.i(36858);
      if (!WeChatBrands.Business.Entries.SessionLuckyMoney.checkAvailable(paramView.getContext()))
      {
        AppMethodBeat.o(36858);
        return true;
      }
      ((b)com.tencent.mm.kernel.h.ae(b.class)).asK(paramca.field_talker);
      paramView = paramca.field_content;
      if (paramView != null) {}
      for (paramView = k.b.aG(paramView, paramca.field_reserved);; paramView = null)
      {
        Object localObject1;
        if (paramView != null)
        {
          if (!Util.isNullOrNil(paramView.lny)) {
            break label226;
          }
          localObject1 = paramView.url;
          Log.i("MicroMsg.ChattingItemAppMsgC2CTo", "url==null: %s, billNo==null: %s", new Object[] { Boolean.valueOf(Util.isNullOrNil((String)localObject1)), Boolean.valueOf(Util.isNullOrNil(paramView.lnP)) });
          if (Util.isNullOrNil(paramView.lnH)) {
            break label854;
          }
          if (!paramView.lnH.startsWith("weixin://openNativeUrl/weixinHB/startreceivebizhbrequest")) {
            break label235;
          }
          paramca = new Intent();
          paramca.putExtra("key_way", 1);
          paramca.putExtra("key_native_url", paramView.lnH);
          paramca.putExtra("key_username", parama.getTalkerUserName());
          paramca.putExtra("key_static_from_scene", 100002);
          com.tencent.mm.by.c.b(parama.WQv.getContext(), "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", paramca);
        }
        label226:
        label235:
        Object localObject2;
        label267:
        do
        {
          AppMethodBeat.o(36858);
          return true;
          localObject1 = paramView.lny;
          break;
          if (!paramView.lnH.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao")) {
            break label644;
          }
          localObject2 = new Intent();
          if (!parama.hRi()) {
            break label632;
          }
          i = 0;
          ((Intent)localObject2).putExtra("key_way", i);
          ((Intent)localObject2).putExtra("key_native_url", paramView.lnH);
          ((Intent)localObject2).putExtra("key_username", parama.getTalkerUserName());
          ((Intent)localObject2).putExtra("scene_id", Integer.parseInt(paramView.lnG));
          ((Intent)localObject2).putExtra("key_invalidtime", paramView.lnh);
          localObject1 = (com.tencent.mm.aj.c)paramView.ar(com.tencent.mm.aj.c.class);
          paramView = (g)paramView.ar(g.class);
          ((Intent)localObject2).putExtra("key_exclusive_username", ((com.tencent.mm.aj.c)localObject1).lln);
          ((Intent)localObject2).putExtra("key_cropname", ((com.tencent.mm.aj.c)localObject1).lle);
          ((Intent)localObject2).putExtra("key_receive_envelope_url", ((com.tencent.mm.aj.c)localObject1).llj);
          ((Intent)localObject2).putExtra("key_receive_envelope_md5", ((com.tencent.mm.aj.c)localObject1).llk);
          ((Intent)localObject2).putExtra("key_detail_envelope_url", ((com.tencent.mm.aj.c)localObject1).lll);
          ((Intent)localObject2).putExtra("key_detail_envelope_md5", ((com.tencent.mm.aj.c)localObject1).llm);
          ((Intent)localObject2).putExtra("key_about_url", paramView.llG);
          ((Intent)localObject2).putExtra("key_packet_id", paramView.llH);
          ((Intent)localObject2).putExtra("key_has_story", paramView.llK);
          ((Intent)localObject2).putExtra("key_material_flag", paramView.llL);
          ((Intent)localObject2).putExtra("key_msgid", paramca.field_msgId);
          com.tencent.mm.by.c.b(parama.WQv.getContext(), "luckymoney", ".ui.LuckyMoneyNotHookReceiveUI", (Intent)localObject2);
        } while ((((com.tencent.mm.aj.c)localObject1).llo == null) || (!((com.tencent.mm.aj.c)localObject1).llo.llK));
        if (!Util.isNullOrNil(((com.tencent.mm.aj.c)localObject1).llo.llI)) {}
        for (i = 2;; i = 1)
        {
          paramView = paramca.sessionId;
          localObject2 = ((com.tencent.mm.aj.c)localObject1).lle;
          parama = parama.getTalkerUserName();
          String str = ((com.tencent.mm.aj.c)localObject1).llo.llH;
          if (((com.tencent.mm.aj.c)localObject1).llo.llK) {}
          for (;;)
          {
            com.tencent.mm.plugin.luckymoney.a.c.a(paramView, (String)localObject2, parama, str, j, i);
            com.tencent.mm.plugin.luckymoney.a.c.bz(10, ((com.tencent.mm.aj.c)localObject1).llf);
            paramca.sessionId = UUID.randomUUID().toString();
            break;
            label632:
            i = 1;
            break label267;
            j = 1;
          }
          label644:
          if (paramView.lnH.startsWith("frhb://c2cbizmessagehandler/hongbao/receivehongbao"))
          {
            localObject2 = new Intent();
            if (parama.hRi()) {}
            for (;;)
            {
              ((Intent)localObject2).putExtra("key_way", i);
              ((Intent)localObject2).putExtra("key_native_url", paramView.lnH);
              ((Intent)localObject2).putExtra("key_hk_url", (String)localObject1);
              ((Intent)localObject2).putExtra("key_username", parama.getTalkerUserName());
              ((Intent)localObject2).putExtra("key_msgid", paramca.field_msgId);
              ((Intent)localObject2).putExtra("key_hk_scene", 1);
              com.tencent.mm.by.c.b(parama.WQv.getContext(), "luckymoney", ".hk.ui.LuckyMoneyHKReceiveUI", (Intent)localObject2);
              break;
              i = 1;
            }
          }
          Log.i("MicroMsg.ChattingItemAppMsgC2CTo", "native url not match:" + paramView.lnH + ", go webview:" + (String)localObject1);
          if (Util.isNullOrNil((String)localObject1)) {
            break;
          }
          paramView = new Intent();
          paramView.putExtra("rawUrl", (String)localObject1);
          com.tencent.mm.by.c.b(parama.WQv.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
          break;
          label854:
          if (!Util.isNullOrNil(paramView.lnP))
          {
            Log.i("MicroMsg.ChattingItemAppMsgC2CTo", "tofuliu billNo: %s, c2cNewAAType: %s, fromUser: %s", new Object[] { paramView.lnP, Integer.valueOf(paramView.lnQ), paramView.fLi });
            if ((paramView.lnQ == 2) || (paramView.lnQ == 3) || (paramView.lnQ == 1) || (paramView.lnQ == 5))
            {
              paramca = new Intent();
              paramca.putExtra("bill_no", paramView.lnP);
              paramca.putExtra("launcher_user_name", paramView.fLi);
              paramca.putExtra("enter_scene", 1);
              paramca.putExtra("chatroom", parama.getTalkerUserName());
              com.tencent.mm.by.c.b(parama.WQv.getContext(), "aa", ".ui.PaylistAAUI", paramca);
              if (paramView.lnQ == 2)
              {
                com.tencent.mm.plugin.report.service.h.IzE.a(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(2) });
                break;
              }
              if (paramView.lnQ == 3)
              {
                com.tencent.mm.plugin.report.service.h.IzE.a(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(3) });
                break;
              }
              if (paramView.lnQ != 5) {
                break;
              }
              com.tencent.mm.plugin.report.service.h.IzE.a(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(4) });
              break;
            }
            if (Util.isNullOrNil((String)localObject1)) {
              break;
            }
            paramView = new Intent();
            paramView.putExtra("rawUrl", (String)localObject1);
            com.tencent.mm.by.c.b(parama.WQv.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
            break;
          }
          if ((Util.isNullOrNil((String)localObject1)) || (Util.isNullOrNil((String)localObject1))) {
            break;
          }
          paramView = new Intent();
          paramView.putExtra("rawUrl", (String)localObject1);
          com.tencent.mm.by.c.b(parama.WQv.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
          break;
        }
      }
    }
    
    public final boolean hTD()
    {
      return true;
    }
    
    final boolean hTF()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.f
 * JD-Core Version:    0.7.0.1
 */