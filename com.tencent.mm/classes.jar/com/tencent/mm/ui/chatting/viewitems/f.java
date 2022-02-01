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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.aaf;
import com.tencent.mm.g.a.aaf.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.cbe;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import java.util.UUID;

public final class f
{
  static final class a
    extends c.a
  {
    public boolean IBL;
    public TextView PJA;
    public TextView PJB;
    public ImageView PJC;
    public ImageView PJD;
    public int PJE = 0;
    public int PJF;
    public long PJG;
    public int PJa = 0;
    public ImageView PJw;
    public TextView PJx;
    public TextView PJy;
    public TextView PJz;
    public View jWr;
    public int maxSize = 0;
    public View qdl;
    public ImageView zhf;
    
    public final a gM(View paramView)
    {
      AppMethodBeat.i(36847);
      super.create(paramView);
      this.timeTV = ((TextView)this.convertView.findViewById(2131298558));
      this.checkBox = ((CheckBox)this.convertView.findViewById(2131298410));
      this.maskView = this.convertView.findViewById(2131298508);
      this.userTV = ((TextView)this.convertView.findViewById(2131298566));
      this.qdl = this.convertView.findViewById(2131301661);
      this.jWr = ((ImageView)this.convertView.findViewById(2131299682));
      this.PJw = ((ImageView)this.convertView.findViewById(2131297017));
      this.PJx = ((TextView)this.convertView.findViewById(2131297023));
      this.PJy = ((TextView)this.convertView.findViewById(2131297015));
      this.PJz = ((TextView)this.convertView.findViewById(2131297027));
      this.clickArea = this.convertView.findViewById(2131298411);
      this.zhf = ((ImageView)this.convertView.findViewById(2131298470));
      this.PJB = ((TextView)this.convertView.findViewById(2131297026));
      this.PJA = ((TextView)this.convertView.findViewById(2131297024));
      this.PJC = ((ImageView)this.convertView.findViewById(2131298471));
      this.PJD = ((ImageView)this.convertView.findViewById(2131297025));
      this.jWr = this.convertView.findViewById(2131297016);
      this.PJa = c.kl(MMApplicationContext.getContext());
      this.PJE = com.tencent.mm.cb.a.aG(MMApplicationContext.getContext(), 2131165220);
      this.maxSize = ((int)(com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131165220) * 1.45F));
      this.PJF = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 20);
      AppMethodBeat.o(36847);
      return this;
    }
  }
  
  public static final class b
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a PhN;
    
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
        localObject = new an(paramLayoutInflater, 2131493527);
        ((View)localObject).setTag(new f.a().gM((View)localObject));
      }
      AppMethodBeat.o(36848);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(36849);
      this.PhN = parama1;
      f.a locala = (f.a)parama;
      k.b localb;
      com.tencent.mm.ag.c localc;
      aaf localaaf;
      label196:
      Object localObject;
      label401:
      label434:
      label507:
      int i;
      label529:
      label545:
      int j;
      if (locala.PJG == paramca.field_msgId)
      {
        locala.IBL = true;
        locala.PJG = paramca.field_msgId;
        paramString = paramca.field_content;
        localb = null;
        if (paramString != null) {
          localb = k.b.aD(paramString, paramca.field_reserved);
        }
        if (localb != null)
        {
          localc = (com.tencent.mm.ag.c)localb.as(com.tencent.mm.ag.c.class);
          boolean bool2 = "1001".equals(localb.iyq);
          localaaf = new aaf();
          if ((!Util.isNullOrNil(localb.iyr)) && (!bool2))
          {
            localaaf.egV.egX = localb.iyr;
            EventCenter.instance.publish(localaaf);
          }
          locala.resetChatBubbleWidth(locala.clickArea, locala.PJa);
          if (!"1001".equals(localb.iyq)) {
            break label1276;
          }
          paramString = locala.clickArea;
          if (paramca.field_isSend != 1) {
            break label1046;
          }
          bool1 = true;
          paramString.setBackgroundResource(com.tencent.mm.ui.chatting.f.c(localb, bool1));
          locala.PJx.setTypeface(Typeface.defaultFromStyle(1));
          locala.jWr.setVisibility(0);
          if (ao.isDarkMode()) {
            break label1052;
          }
          locala.PJx.setTextColor(parama1.Pwc.getContext().getResources().getColor(2131099844));
          locala.PJx.setAlpha(1.0F);
          locala.PJy.setTextColor(parama1.Pwc.getContext().getResources().getColor(2131099844));
          locala.PJy.setAlpha(1.0F);
          locala.PJz.setTextColor(parama1.Pwc.getContext().getResources().getColor(2131099844));
          locala.PJz.setAlpha(0.8F);
          locala.PJw.setAlpha(1.0F);
          parama1.Pwc.getContext().getResources().getDimensionPixelSize(2131165586);
          parama1.Pwc.getContext().getResources().getDimensionPixelSize(2131166038);
          locala.clickArea.setPadding(0, 0, 0, 0);
          if (paramca.field_isSend != 1) {
            break label1430;
          }
          paramString = localb.iyl;
          if (!Util.isNullOrNil(paramString)) {
            break label1440;
          }
          paramString = localb.description;
          locala.PJx.setSingleLine(false);
          locala.PJx.setMaxLines(3);
          locala.PJx.setText(l.e(parama1.Pwc.getContext(), paramString, locala.PJE));
          locala.PJx.setTextSize(0, locala.PJE);
          if (!bool2) {
            break label1458;
          }
          localObject = locala.PJy;
          paramString = parama1.Pwc.getContext();
          if (paramca.field_isSend != 1) {
            break label1452;
          }
          bool1 = true;
          paramString = l.b(paramString, com.tencent.mm.ui.chatting.f.a(localb, bool1), locala.PJy.getTextSize());
          ((TextView)localObject).setText(paramString);
          locala.PJy.setVisibility(0);
          localObject = localb.iyo;
          paramString = (String)localObject;
          if (Util.isNullOrNil((String)localObject)) {
            paramString = localb.title;
          }
          locala.PJz.setText(paramString);
          i = 0;
          if (!Util.isNullOrNil(localc.ivO))
          {
            q.bcV().loadImage("", locala.PJw);
            j = parama1.Pwc.getMMResources().getIdentifier(localc.ivO, "drawable", MMApplicationContext.getPackageName());
            i = j;
            if (j <= 0) {
              i = parama1.Pwc.getMMResources().getIdentifier(localc.ivO, "raw", MMApplicationContext.getPackageName());
            }
          }
          Log.i("MicroMsg.ChattingItemAppMsgC2CFrom", "c2c loaclResId: %s", new Object[] { Integer.valueOf(i) });
          if (i > 0)
          {
            Log.i("MicroMsg.ChattingItemAppMsgC2CFrom", "set c2cIcon from localRes");
            locala.PJw.setImageResource(i);
          }
          if (!"1001".equals(localb.iyq)) {
            break label1656;
          }
          if (paramca.field_isSend != 1) {
            break label1650;
          }
          bool1 = true;
          label734:
          j = com.tencent.mm.ui.chatting.f.b(localb, bool1);
          if (j <= 0) {
            break label1708;
          }
          Log.i("MicroMsg.ChattingItemAppMsgC2CFrom", "set c2cIcon from iconRes");
          locala.PJw.setImageResource(j);
          label767:
          i = -1;
          if (!Util.isNullOrNil(localc.ivP)) {
            i = parama1.Pwc.getMMResources().getIdentifier(localc.ivP, "drawable", MMApplicationContext.getPackageName());
          }
          Log.i("MicroMsg.ChattingItemAppMsgC2CFrom", "backgroundResId: %s", new Object[] { Integer.valueOf(i) });
          if (i > 0)
          {
            locala.clickArea.setBackgroundResource(i);
            locala.clickArea.setPadding(0, 0, 0, 0);
          }
          i = localaaf.egW.egZ;
          j = localaaf.egW.eha;
          if (paramca.field_isSend != 1) {
            break label1823;
          }
        }
      }
      label1046:
      label1052:
      label1823:
      for (boolean bool1 = true;; bool1 = false)
      {
        f.a(locala, localc, true, com.tencent.mm.ui.chatting.f.K(i, j, bool1), parama1.getTalkerUserName(), paramca);
        parama.clickArea.setOnClickListener(d(parama1));
        if (!ab.IN(parama1.getTalkerUserName())) {
          parama.clickArea.setOnLongClickListener(c(parama1));
        }
        parama.clickArea.setOnTouchListener(((k)parama1.bh(k.class)).gOC());
        paramca = new bq(paramca, this.PhN.gRM(), paramInt, null, '\000');
        parama.clickArea.setTag(paramca);
        if (((f.a)parama).qdl == null) {
          break label1864;
        }
        if (!ao.isDarkMode()) {
          break label1829;
        }
        ((f.a)parama).qdl.setBackground(null);
        ((f.a)parama).jWr.setVisibility(0);
        AppMethodBeat.o(36849);
        return;
        locala.IBL = false;
        break;
        bool1 = false;
        break label196;
        locala.PJx.setTextColor(parama1.Pwc.getContext().getResources().getColor(2131099844));
        locala.PJy.setTextColor(parama1.Pwc.getContext().getResources().getColor(2131099844));
        locala.PJz.setTextColor(parama1.Pwc.getContext().getResources().getColor(2131099844));
        paramString = locala.PJx;
        if (paramca.field_isSend == 1)
        {
          bool1 = true;
          label1140:
          paramString.setAlpha(com.tencent.mm.ui.chatting.f.a(localb, bool1, false));
          paramString = locala.PJy;
          if (paramca.field_isSend != 1) {
            break label1258;
          }
          bool1 = true;
          paramString.setAlpha(com.tencent.mm.ui.chatting.f.a(localb, bool1, false));
          paramString = locala.PJz;
          if (paramca.field_isSend != 1) {
            break label1264;
          }
          bool1 = true;
          label1204:
          paramString.setAlpha(com.tencent.mm.ui.chatting.f.a(localb, bool1, true));
          paramString = locala.PJw;
          if (paramca.field_isSend != 1) {
            break label1270;
          }
        }
        label1258:
        label1264:
        label1270:
        for (bool1 = true;; bool1 = false)
        {
          paramString.setAlpha(com.tencent.mm.ui.chatting.f.a(localb, bool1, false));
          break;
          bool1 = false;
          break label1140;
          bool1 = false;
          break label1172;
          bool1 = false;
          break label1204;
        }
        label1276:
        paramString = locala.clickArea;
        i = localaaf.egW.egZ;
        j = localaaf.egW.eha;
        if (paramca.field_isSend == 1)
        {
          bool1 = true;
          label1315:
          paramString.setBackgroundResource(com.tencent.mm.ui.chatting.f.I(i, j, bool1));
          locala.PJx.setTypeface(Typeface.defaultFromStyle(1));
          if (locala.PJE <= locala.maxSize) {
            break label1420;
          }
        }
        for (i = locala.maxSize;; i = locala.PJE)
        {
          locala.PJE = i;
          locala.jWr.setVisibility(0);
          locala.PJz.setTextColor(parama1.Pwc.getContext().getResources().getColor(2131099844));
          locala.PJz.setAlpha(0.7F);
          break;
          bool1 = false;
          break label1315;
        }
        paramString = localb.iyk;
        break label401;
        label1440:
        locala.PJx.setSingleLine(true);
        break label434;
        label1452:
        bool1 = false;
        break label507;
        label1458:
        if (!Util.isNullOrNil(localb.iyr))
        {
          locala.PJy.setTextSize(1, 12.0F);
          i = localaaf.egW.egY;
          j = localaaf.egW.egZ;
          k = localaaf.egW.eha;
          if (paramca.field_isSend == 1) {}
          for (bool1 = true;; bool1 = false)
          {
            paramString = com.tencent.mm.ui.chatting.f.a(i, j, k, bool1, parama1.gRM(), parama1.getTalkerUserName(), localb, locala.PJy);
            if (Util.isNullOrNil(paramString)) {
              break label1601;
            }
            localObject = locala.PJy;
            paramString = l.b(locala.PJy.getContext(), Util.nullAsNil(paramString), locala.PJy.getTextSize());
            break;
          }
          label1601:
          locala.PJy.setVisibility(8);
          break label545;
        }
        localObject = locala.PJy;
        if (paramca.field_isSend == 1)
        {
          paramString = localb.iym;
          break label529;
        }
        paramString = localb.iyn;
        break label529;
        label1650:
        bool1 = false;
        break label734;
        label1656:
        j = localaaf.egW.egZ;
        int k = localaaf.egW.eha;
        if (paramca.field_isSend == 1) {}
        for (bool1 = true;; bool1 = false)
        {
          j = com.tencent.mm.ui.chatting.f.J(j, k, bool1);
          break;
        }
        label1708:
        if (i > 0) {
          break label767;
        }
        Log.i("MicroMsg.ChattingItemAppMsgC2CFrom", "set c2cIcon from c2cIconUrl");
        localObject = localb.iyj;
        paramString = (String)localObject;
        if (Util.isNullOrNil((String)localObject)) {
          paramString = localb.thumburl;
        }
        locala.PJw.setImageBitmap(null);
        if (Util.isNullOrNil(paramString)) {
          break label767;
        }
        localObject = new com.tencent.mm.av.a.a.c.a();
        bg.aVF();
        ((com.tencent.mm.av.a.a.c.a)localObject).prefixPath = com.tencent.mm.model.c.aSZ();
        ((com.tencent.mm.av.a.a.c.a)localObject).jbf = true;
        ((com.tencent.mm.av.a.a.c.a)localObject).hZF = true;
        localObject = ((com.tencent.mm.av.a.a.c.a)localObject).bdv();
        q.bcV().a(paramString, locala.PJw, (com.tencent.mm.av.a.a.c)localObject);
        break label767;
      }
      label1172:
      label1430:
      label1829:
      ((f.a)parama).qdl.setBackground(parama1.Pwc.getMMResources().getDrawable(2131231748));
      label1420:
      ((f.a)parama).jWr.setVisibility(8);
      label1864:
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
      com.tencent.mm.br.c.b(parama.Pwc.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
      AppMethodBeat.o(36851);
      return true;
    }
    
    public final boolean a(m paramm, View paramView, ca paramca)
    {
      AppMethodBeat.i(233616);
      int i = ((bq)paramView.getTag()).position;
      paramm.a(i, 100, this.PhN.Pwc.getMMResources().getString(2131757433), 2131690529);
      if ((BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())) {
        paramm.a(i, 144, paramView.getContext().getString(2131763040), 2131690297);
      }
      AppMethodBeat.o(233616);
      return false;
    }
    
    public final boolean bM(int paramInt, boolean paramBoolean)
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
      ((b)com.tencent.mm.kernel.g.af(b.class)).akR(paramca.field_talker);
      paramView = paramca.field_content;
      if (paramView != null) {}
      for (paramView = k.b.aD(paramView, paramca.field_reserved);; paramView = null)
      {
        Object localObject1;
        if (paramView != null)
        {
          if (!Util.isNullOrNil(paramView.iyi)) {
            break label226;
          }
          localObject1 = paramView.url;
          Log.i("MicroMsg.ChattingItemAppMsgC2CFrom", "url==null: %s, billNo==null: %s", new Object[] { Boolean.valueOf(Util.isNullOrNil((String)localObject1)), Boolean.valueOf(Util.isNullOrNil(paramView.iyz)) });
          if (Util.isNullOrNil(paramView.iyr)) {
            break label890;
          }
          if (!paramView.iyr.startsWith("weixin://openNativeUrl/weixinHB/startreceivebizhbrequest")) {
            break label235;
          }
          paramca = new Intent();
          paramca.putExtra("key_way", 1);
          paramca.putExtra("key_native_url", paramView.iyr);
          paramca.putExtra("key_username", parama.getTalkerUserName());
          paramca.putExtra("key_static_from_scene", 100002);
          com.tencent.mm.br.c.b(parama.Pwc.getContext(), "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", paramca);
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
          localObject1 = paramView.iyi;
          break;
          if (!paramView.iyr.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao")) {
            break label680;
          }
          localObject2 = new Intent();
          if (!parama.gRM()) {
            break label668;
          }
          i = 0;
          ((Intent)localObject2).putExtra("key_way", i);
          ((Intent)localObject2).putExtra("key_native_url", paramView.iyr);
          ((Intent)localObject2).putExtra("key_username", parama.getTalkerUserName());
          ((Intent)localObject2).putExtra("scene_id", Integer.parseInt(paramView.iyq));
          ((Intent)localObject2).putExtra("key_invalidtime", paramView.ixR);
          localObject1 = (com.tencent.mm.ag.c)paramView.as(com.tencent.mm.ag.c.class);
          localObject3 = (com.tencent.mm.ag.g)paramView.as(com.tencent.mm.ag.g.class);
          ((Intent)localObject2).putExtra("key_exclusive_username", ((com.tencent.mm.ag.c)localObject1).iwa);
          ((Intent)localObject2).putExtra("key_cropname", ((com.tencent.mm.ag.c)localObject1).ivR);
          ((Intent)localObject2).putExtra("key_receive_envelope_url", ((com.tencent.mm.ag.c)localObject1).ivW);
          ((Intent)localObject2).putExtra("key_receive_envelope_md5", ((com.tencent.mm.ag.c)localObject1).ivX);
          ((Intent)localObject2).putExtra("key_detail_envelope_url", ((com.tencent.mm.ag.c)localObject1).ivY);
          ((Intent)localObject2).putExtra("key_detail_envelope_md5", ((com.tencent.mm.ag.c)localObject1).ivZ);
          ((Intent)localObject2).putExtra("key_about_url", ((com.tencent.mm.ag.g)localObject3).iwt);
          ((Intent)localObject2).putExtra("key_packet_id", ((com.tencent.mm.ag.g)localObject3).iwu);
          ((Intent)localObject2).putExtra("key_has_story", ((com.tencent.mm.ag.g)localObject3).iwx);
          ((Intent)localObject2).putExtra("key_material_flag", ((com.tencent.mm.ag.g)localObject3).iwy);
          ((Intent)localObject2).putExtra("key_msgid", paramca.field_msgId);
          ((Intent)localObject2).putExtra("key_emoji_md5", ((com.tencent.mm.ag.d)paramView.as(com.tencent.mm.ag.d.class)).gWm.field_md5);
          com.tencent.mm.br.c.b(parama.Pwc.getContext(), "luckymoney", ".ui.LuckyMoneyNotHookReceiveUI", (Intent)localObject2);
          if (ab.IN(parama.getTalkerUserName())) {
            com.tencent.mm.plugin.luckymoney.a.d.xV(1);
          }
        } while (!((com.tencent.mm.ag.c)localObject1).iwb.iwx);
        if (!Util.isNullOrNil(((com.tencent.mm.ag.c)localObject1).iwb.iwv)) {}
        for (i = 2;; i = 1)
        {
          paramView = paramca.sessionId;
          localObject2 = ((com.tencent.mm.ag.c)localObject1).ivR;
          parama = parama.getTalkerUserName();
          localObject3 = ((com.tencent.mm.ag.c)localObject1).iwb.iwu;
          if (((com.tencent.mm.ag.c)localObject1).iwb.iwx) {}
          for (;;)
          {
            com.tencent.mm.plugin.luckymoney.a.c.a(paramView, (String)localObject2, parama, (String)localObject3, j, i);
            com.tencent.mm.plugin.luckymoney.a.c.bC(10, ((com.tencent.mm.ag.c)localObject1).ivS);
            paramca.sessionId = UUID.randomUUID().toString();
            break;
            label668:
            i = 1;
            break label267;
            j = 1;
          }
          label680:
          if (paramView.iyr.startsWith("frhb://c2cbizmessagehandler/hongbao/receivehongbao"))
          {
            localObject2 = new Intent();
            if (parama.gRM()) {}
            for (;;)
            {
              ((Intent)localObject2).putExtra("key_way", i);
              ((Intent)localObject2).putExtra("key_native_url", paramView.iyr);
              ((Intent)localObject2).putExtra("key_hk_url", (String)localObject1);
              ((Intent)localObject2).putExtra("key_username", parama.getTalkerUserName());
              ((Intent)localObject2).putExtra("key_msgid", paramca.field_msgId);
              ((Intent)localObject2).putExtra("key_hk_scene", 1);
              com.tencent.mm.br.c.b(parama.Pwc.getContext(), "luckymoney", ".hk.ui.LuckyMoneyHKReceiveUI", (Intent)localObject2);
              break;
              i = 1;
            }
          }
          Log.i("MicroMsg.ChattingItemAppMsgC2CFrom", "native url not match:" + paramView.iyr + ", go webview:" + (String)localObject1);
          if (Util.isNullOrNil((String)localObject1)) {
            break;
          }
          paramView = new Intent();
          paramView.putExtra("rawUrl", (String)localObject1);
          com.tencent.mm.br.c.b(parama.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
          break;
          label890:
          if (!Util.isNullOrNil(paramView.iyz))
          {
            Log.i("MicroMsg.ChattingItemAppMsgC2CFrom", "tofuliu billNo: %s, c2cNewAAType: %s, fromUser: %s", new Object[] { paramView.iyz, Integer.valueOf(paramView.iyA), paramView.dRL });
            if ((paramView.iyA == 2) || (paramView.iyA == 3) || (paramView.iyA == 1) || (paramView.iyA == 5))
            {
              paramca = new Intent();
              paramca.putExtra("bill_no", paramView.iyz);
              paramca.putExtra("launcher_user_name", paramView.dRL);
              paramca.putExtra("enter_scene", 1);
              paramca.putExtra("chatroom", parama.getTalkerUserName());
              com.tencent.mm.br.c.b(parama.Pwc.getContext(), "aa", ".ui.PaylistAAUI", paramca);
            }
            for (;;)
            {
              if (com.tencent.mm.ui.chatting.f.h(paramView).role == 2)
              {
                if (paramView.iyA == 2)
                {
                  com.tencent.mm.plugin.report.service.h.CyF.a(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(2), Integer.valueOf(2) });
                  break;
                  if (Util.isNullOrNil((String)localObject1)) {
                    continue;
                  }
                  paramca = new Intent();
                  paramca.putExtra("rawUrl", (String)localObject1);
                  com.tencent.mm.br.c.b(parama.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", paramca);
                  continue;
                }
                if (paramView.iyA == 3)
                {
                  com.tencent.mm.plugin.report.service.h.CyF.a(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(2), Integer.valueOf(3) });
                  break;
                }
                if (paramView.iyA != 5) {
                  break;
                }
                com.tencent.mm.plugin.report.service.h.CyF.a(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(2), Integer.valueOf(4) });
                break;
              }
            }
            if (paramView.iyA == 2)
            {
              com.tencent.mm.plugin.report.service.h.CyF.a(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(2) });
              break;
            }
            if (paramView.iyA == 3)
            {
              com.tencent.mm.plugin.report.service.h.CyF.a(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(3) });
              break;
            }
            if (paramView.iyA != 5) {
              break;
            }
            com.tencent.mm.plugin.report.service.h.CyF.a(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(4) });
            break;
          }
          if (Util.isNullOrNil((String)localObject1)) {
            break;
          }
          paramView = new Intent();
          paramView.putExtra("rawUrl", (String)localObject1);
          com.tencent.mm.br.c.b(parama.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
          break;
        }
      }
    }
    
    public final boolean gTT()
    {
      return false;
    }
    
    final boolean gTV()
    {
      return false;
    }
  }
  
  public static final class c
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a PhN;
    
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
        localObject = new an(paramLayoutInflater, 2131493579);
        ((View)localObject).setTag(new f.a().gM((View)localObject));
      }
      AppMethodBeat.o(36854);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(36855);
      this.PhN = parama1;
      f.a locala = (f.a)parama;
      k.b localb;
      com.tencent.mm.ag.c localc;
      aaf localaaf;
      label196:
      Object localObject;
      label398:
      label431:
      label504:
      int i;
      label526:
      label542:
      int j;
      if (locala.PJG == paramca.field_msgId)
      {
        locala.IBL = true;
        locala.PJG = paramca.field_msgId;
        paramString = paramca.field_content;
        localb = null;
        if (paramString != null) {
          localb = k.b.aD(paramString, paramca.field_reserved);
        }
        if (localb != null)
        {
          localc = (com.tencent.mm.ag.c)localb.as(com.tencent.mm.ag.c.class);
          boolean bool2 = "1001".equals(localb.iyq);
          localaaf = new aaf();
          if ((!Util.isNullOrNil(localb.iyr)) && (!bool2))
          {
            localaaf.egV.egX = localb.iyr;
            EventCenter.instance.publish(localaaf);
          }
          locala.resetChatBubbleWidth(locala.clickArea, locala.PJa);
          if (!"1001".equals(localb.iyq)) {
            break label1273;
          }
          paramString = locala.clickArea;
          if (paramca.field_isSend != 1) {
            break label1043;
          }
          bool1 = true;
          paramString.setBackgroundResource(com.tencent.mm.ui.chatting.f.c(localb, bool1));
          locala.PJx.setTypeface(Typeface.defaultFromStyle(1));
          locala.jWr.setVisibility(0);
          if (ao.isDarkMode()) {
            break label1049;
          }
          locala.PJx.setTextColor(parama1.Pwc.getContext().getResources().getColor(2131099844));
          locala.PJx.setAlpha(1.0F);
          locala.PJy.setTextColor(parama1.Pwc.getContext().getResources().getColor(2131099844));
          locala.PJy.setAlpha(1.0F);
          locala.PJz.setTextColor(parama1.Pwc.getContext().getResources().getColor(2131099844));
          locala.PJz.setAlpha(0.8F);
          locala.PJw.setAlpha(1.0F);
          com.tencent.mm.cb.a.fromDPToPix(parama1.Pwc.getContext(), 13);
          parama1.Pwc.getContext().getResources().getDimensionPixelSize(2131165518);
          locala.clickArea.setPadding(0, 0, 0, 0);
          if (paramca.field_isSend != 1) {
            break label1427;
          }
          paramString = localb.iyl;
          if (!Util.isNullOrNil(paramString)) {
            break label1437;
          }
          paramString = localb.description;
          locala.PJx.setSingleLine(false);
          locala.PJx.setMaxLines(3);
          locala.PJx.setText(l.e(parama1.Pwc.getContext(), paramString, locala.PJE));
          locala.PJx.setTextSize(0, locala.PJE);
          if (!bool2) {
            break label1455;
          }
          localObject = locala.PJy;
          paramString = parama1.Pwc.getContext();
          if (paramca.field_isSend != 1) {
            break label1449;
          }
          bool1 = true;
          paramString = l.b(paramString, com.tencent.mm.ui.chatting.f.a(localb, bool1), locala.PJy.getTextSize());
          ((TextView)localObject).setText(paramString);
          locala.PJy.setVisibility(0);
          localObject = localb.iyo;
          paramString = (String)localObject;
          if (Util.isNullOrNil((String)localObject)) {
            paramString = localb.title;
          }
          locala.PJz.setText(paramString);
          i = 0;
          if (!Util.isNullOrNil(localc.ivO))
          {
            q.bcV().loadImage("", locala.PJw);
            j = parama1.Pwc.getMMResources().getIdentifier(localc.ivO, "drawable", MMApplicationContext.getPackageName());
            i = j;
            if (j <= 0) {
              i = parama1.Pwc.getMMResources().getIdentifier(localc.ivO, "raw", MMApplicationContext.getPackageName());
            }
          }
          Log.v("MicroMsg.ChattingItemAppMsgC2CTo", "c2c localResId: %s", new Object[] { Integer.valueOf(i) });
          if (i > 0)
          {
            Log.v("MicroMsg.ChattingItemAppMsgC2CTo", "set c2cIcon from localRes");
            locala.PJw.setImageResource(i);
          }
          if (!"1001".equals(localb.iyq)) {
            break label1653;
          }
          if (paramca.field_isSend != 1) {
            break label1647;
          }
          bool1 = true;
          label731:
          j = com.tencent.mm.ui.chatting.f.b(localb, bool1);
          if (j <= 0) {
            break label1705;
          }
          Log.i("MicroMsg.ChattingItemAppMsgC2CTo", "set c2cIcon from iconRes");
          locala.PJw.setImageResource(j);
          label764:
          i = -1;
          if (!Util.isNullOrNil(localc.ivP)) {
            i = parama1.Pwc.getMMResources().getIdentifier(localc.ivP, "drawable", MMApplicationContext.getPackageName());
          }
          Log.i("MicroMsg.ChattingItemAppMsgC2CTo", "backgroundResId: %s", new Object[] { Integer.valueOf(i) });
          if (i > 0)
          {
            locala.clickArea.setBackgroundResource(i);
            locala.clickArea.setPadding(0, 0, 0, 0);
          }
          i = localaaf.egW.egZ;
          j = localaaf.egW.eha;
          if (paramca.field_isSend != 1) {
            break label1820;
          }
        }
      }
      label1043:
      label1049:
      label1820:
      for (boolean bool1 = true;; bool1 = false)
      {
        f.a(locala, localc, false, com.tencent.mm.ui.chatting.f.K(i, j, bool1), parama1.getTalkerUserName(), paramca);
        parama.clickArea.setOnClickListener(d(parama1));
        if (!ab.IN(parama1.getTalkerUserName())) {
          parama.clickArea.setOnLongClickListener(c(parama1));
        }
        parama.clickArea.setOnTouchListener(((k)parama1.bh(k.class)).gOC());
        paramca = new bq(paramca, this.PhN.gRM(), paramInt, null, '\000');
        parama.clickArea.setTag(paramca);
        if (((f.a)parama).qdl == null) {
          break label1861;
        }
        if (!ao.isDarkMode()) {
          break label1826;
        }
        ((f.a)parama).qdl.setBackground(null);
        ((f.a)parama).jWr.setVisibility(0);
        AppMethodBeat.o(36855);
        return;
        locala.IBL = false;
        break;
        bool1 = false;
        break label196;
        locala.PJx.setTextColor(parama1.Pwc.getContext().getResources().getColor(2131099844));
        locala.PJy.setTextColor(parama1.Pwc.getContext().getResources().getColor(2131099844));
        locala.PJz.setTextColor(parama1.Pwc.getContext().getResources().getColor(2131099844));
        paramString = locala.PJx;
        if (paramca.field_isSend == 1)
        {
          bool1 = true;
          label1137:
          paramString.setAlpha(com.tencent.mm.ui.chatting.f.a(localb, bool1, false));
          paramString = locala.PJy;
          if (paramca.field_isSend != 1) {
            break label1255;
          }
          bool1 = true;
          paramString.setAlpha(com.tencent.mm.ui.chatting.f.a(localb, bool1, false));
          paramString = locala.PJz;
          if (paramca.field_isSend != 1) {
            break label1261;
          }
          bool1 = true;
          label1201:
          paramString.setAlpha(com.tencent.mm.ui.chatting.f.a(localb, bool1, true));
          paramString = locala.PJw;
          if (paramca.field_isSend != 1) {
            break label1267;
          }
        }
        label1255:
        label1261:
        label1267:
        for (bool1 = true;; bool1 = false)
        {
          paramString.setAlpha(com.tencent.mm.ui.chatting.f.a(localb, bool1, false));
          break;
          bool1 = false;
          break label1137;
          bool1 = false;
          break label1169;
          bool1 = false;
          break label1201;
        }
        label1273:
        paramString = locala.clickArea;
        i = localaaf.egW.egZ;
        j = localaaf.egW.eha;
        if (paramca.field_isSend == 1)
        {
          bool1 = true;
          label1312:
          paramString.setBackgroundResource(com.tencent.mm.ui.chatting.f.I(i, j, bool1));
          locala.PJx.setTypeface(Typeface.defaultFromStyle(1));
          if (locala.PJE <= locala.maxSize) {
            break label1417;
          }
        }
        for (i = locala.maxSize;; i = locala.PJE)
        {
          locala.PJE = i;
          locala.jWr.setVisibility(0);
          locala.PJz.setTextColor(parama1.Pwc.getContext().getResources().getColor(2131099844));
          locala.PJz.setAlpha(0.7F);
          break;
          bool1 = false;
          break label1312;
        }
        paramString = localb.iyk;
        break label398;
        label1437:
        locala.PJx.setSingleLine(true);
        break label431;
        label1449:
        bool1 = false;
        break label504;
        label1455:
        if (!Util.isNullOrNil(localb.iyr))
        {
          locala.PJy.setTextSize(1, 12.0F);
          i = localaaf.egW.egY;
          j = localaaf.egW.egZ;
          k = localaaf.egW.eha;
          if (paramca.field_isSend == 1) {}
          for (bool1 = true;; bool1 = false)
          {
            paramString = com.tencent.mm.ui.chatting.f.a(i, j, k, bool1, parama1.gRM(), parama1.getTalkerUserName(), localb, locala.PJy);
            if (Util.isNullOrNil(paramString)) {
              break label1598;
            }
            localObject = locala.PJy;
            paramString = l.b(locala.PJy.getContext(), Util.nullAsNil(paramString), locala.PJy.getTextSize());
            break;
          }
          label1598:
          locala.PJy.setVisibility(8);
          break label542;
        }
        localObject = locala.PJy;
        if (paramca.field_isSend == 1)
        {
          paramString = localb.iym;
          break label526;
        }
        paramString = localb.iyn;
        break label526;
        label1647:
        bool1 = false;
        break label731;
        label1653:
        j = localaaf.egW.egZ;
        int k = localaaf.egW.eha;
        if (paramca.field_isSend == 1) {}
        for (bool1 = true;; bool1 = false)
        {
          j = com.tencent.mm.ui.chatting.f.J(j, k, bool1);
          break;
        }
        label1705:
        if (i > 0) {
          break label764;
        }
        Log.i("MicroMsg.ChattingItemAppMsgC2CTo", "set c2cIcon from iconUrl");
        localObject = localb.iyj;
        paramString = (String)localObject;
        if (Util.isNullOrNil((String)localObject)) {
          paramString = localb.thumburl;
        }
        locala.PJw.setImageBitmap(null);
        if (Util.isNullOrNil(paramString)) {
          break label764;
        }
        localObject = new com.tencent.mm.av.a.a.c.a();
        bg.aVF();
        ((com.tencent.mm.av.a.a.c.a)localObject).prefixPath = com.tencent.mm.model.c.aSZ();
        ((com.tencent.mm.av.a.a.c.a)localObject).jbf = true;
        ((com.tencent.mm.av.a.a.c.a)localObject).hZF = true;
        localObject = ((com.tencent.mm.av.a.a.c.a)localObject).bdv();
        q.bcV().a(paramString, locala.PJw, (com.tencent.mm.av.a.a.c)localObject);
        break label764;
      }
      label1169:
      label1427:
      label1826:
      ((f.a)parama).qdl.setBackground(parama1.Pwc.getMMResources().getDrawable(2131231748));
      label1417:
      ((f.a)parama).jWr.setVisibility(8);
      label1861:
      AppMethodBeat.o(36855);
    }
    
    public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.e.a parama, final ca paramca)
    {
      AppMethodBeat.i(36857);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(36857);
        return false;
      case 103: 
        final String str1 = paramca.field_content;
        paramMenuItem = null;
        if (str1 != null) {
          paramMenuItem = k.b.aD(str1, paramca.field_reserved);
        }
        if (paramMenuItem != null)
        {
          paramca = paramca.field_talker;
          str1 = paramMenuItem.iyk;
          final String str2 = paramMenuItem.iyl;
          final String str3 = paramMenuItem.iym;
          final String str4 = paramMenuItem.iyn;
          final String str5 = paramMenuItem.iyi;
          final String str6 = paramMenuItem.iyp;
          paramMenuItem = paramMenuItem.iyq;
          com.tencent.mm.ui.base.h.c(parama.Pwc.getContext(), parama.Pwc.getMMResources().getString(2131757499), parama.Pwc.getMMResources().getString(2131755962), parama.Pwc.getMMResources().getString(2131757500), parama.Pwc.getMMResources().getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(36853);
              paramAnonymousDialogInterface = new Intent();
              paramAnonymousDialogInterface.putExtra("key_scene", 1);
              paramAnonymousDialogInterface.putExtra("key_receiver", paramca);
              paramAnonymousDialogInterface.putExtra("key_receivertitle", str1);
              paramAnonymousDialogInterface.putExtra("key_sendertitle", str2);
              paramAnonymousDialogInterface.putExtra("key_sender_des", str3);
              paramAnonymousDialogInterface.putExtra("key_receiver_des", str4);
              paramAnonymousDialogInterface.putExtra("key_url", str5);
              paramAnonymousDialogInterface.putExtra("key_templateid", str6);
              paramAnonymousDialogInterface.putExtra("key_sceneid", paramMenuItem);
              com.tencent.mm.br.c.b(parama.Pwc.getContext(), "wallet_index", ".ui.WalletSendC2CMsgUI", paramAnonymousDialogInterface);
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
      paramMenuItem.putExtra("Chat_Msg_Id", paramca.field_msgId);
      com.tencent.mm.br.c.b(parama.Pwc.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
      AppMethodBeat.o(36857);
      return true;
    }
    
    public final boolean a(m paramm, View paramView, ca paramca)
    {
      AppMethodBeat.i(233617);
      int i = ((bq)paramView.getTag()).position;
      paramm.a(i, 100, this.PhN.Pwc.getMMResources().getString(2131757433), 2131690529);
      if ((BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())) {
        paramm.a(i, 144, paramView.getContext().getString(2131763040), 2131690297);
      }
      AppMethodBeat.o(233617);
      return false;
    }
    
    public final boolean bM(int paramInt, boolean paramBoolean)
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
      ((b)com.tencent.mm.kernel.g.af(b.class)).akR(paramca.field_talker);
      paramView = paramca.field_content;
      if (paramView != null) {}
      for (paramView = k.b.aD(paramView, paramca.field_reserved);; paramView = null)
      {
        Object localObject1;
        if (paramView != null)
        {
          if (!Util.isNullOrNil(paramView.iyi)) {
            break label226;
          }
          localObject1 = paramView.url;
          Log.i("MicroMsg.ChattingItemAppMsgC2CTo", "url==null: %s, billNo==null: %s", new Object[] { Boolean.valueOf(Util.isNullOrNil((String)localObject1)), Boolean.valueOf(Util.isNullOrNil(paramView.iyz)) });
          if (Util.isNullOrNil(paramView.iyr)) {
            break label846;
          }
          if (!paramView.iyr.startsWith("weixin://openNativeUrl/weixinHB/startreceivebizhbrequest")) {
            break label235;
          }
          paramca = new Intent();
          paramca.putExtra("key_way", 1);
          paramca.putExtra("key_native_url", paramView.iyr);
          paramca.putExtra("key_username", parama.getTalkerUserName());
          paramca.putExtra("key_static_from_scene", 100002);
          com.tencent.mm.br.c.b(parama.Pwc.getContext(), "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", paramca);
        }
        label226:
        label235:
        Object localObject2;
        label267:
        do
        {
          AppMethodBeat.o(36858);
          return true;
          localObject1 = paramView.iyi;
          break;
          if (!paramView.iyr.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao")) {
            break label636;
          }
          localObject2 = new Intent();
          if (!parama.gRM()) {
            break label624;
          }
          i = 0;
          ((Intent)localObject2).putExtra("key_way", i);
          ((Intent)localObject2).putExtra("key_native_url", paramView.iyr);
          ((Intent)localObject2).putExtra("key_username", parama.getTalkerUserName());
          ((Intent)localObject2).putExtra("scene_id", Integer.parseInt(paramView.iyq));
          ((Intent)localObject2).putExtra("key_invalidtime", paramView.ixR);
          localObject1 = (com.tencent.mm.ag.c)paramView.as(com.tencent.mm.ag.c.class);
          paramView = (com.tencent.mm.ag.g)paramView.as(com.tencent.mm.ag.g.class);
          ((Intent)localObject2).putExtra("key_exclusive_username", ((com.tencent.mm.ag.c)localObject1).iwa);
          ((Intent)localObject2).putExtra("key_cropname", ((com.tencent.mm.ag.c)localObject1).ivR);
          ((Intent)localObject2).putExtra("key_receive_envelope_url", ((com.tencent.mm.ag.c)localObject1).ivW);
          ((Intent)localObject2).putExtra("key_receive_envelope_md5", ((com.tencent.mm.ag.c)localObject1).ivX);
          ((Intent)localObject2).putExtra("key_detail_envelope_url", ((com.tencent.mm.ag.c)localObject1).ivY);
          ((Intent)localObject2).putExtra("key_detail_envelope_md5", ((com.tencent.mm.ag.c)localObject1).ivZ);
          ((Intent)localObject2).putExtra("key_about_url", paramView.iwt);
          ((Intent)localObject2).putExtra("key_packet_id", paramView.iwu);
          ((Intent)localObject2).putExtra("key_has_story", paramView.iwx);
          ((Intent)localObject2).putExtra("key_material_flag", paramView.iwy);
          ((Intent)localObject2).putExtra("key_msgid", paramca.field_msgId);
          com.tencent.mm.br.c.b(parama.Pwc.getContext(), "luckymoney", ".ui.LuckyMoneyNotHookReceiveUI", (Intent)localObject2);
        } while (!((com.tencent.mm.ag.c)localObject1).iwb.iwx);
        if (!Util.isNullOrNil(((com.tencent.mm.ag.c)localObject1).iwb.iwv)) {}
        for (i = 2;; i = 1)
        {
          paramView = paramca.sessionId;
          localObject2 = ((com.tencent.mm.ag.c)localObject1).ivR;
          parama = parama.getTalkerUserName();
          String str = ((com.tencent.mm.ag.c)localObject1).iwb.iwu;
          if (((com.tencent.mm.ag.c)localObject1).iwb.iwx) {}
          for (;;)
          {
            com.tencent.mm.plugin.luckymoney.a.c.a(paramView, (String)localObject2, parama, str, j, i);
            com.tencent.mm.plugin.luckymoney.a.c.bC(10, ((com.tencent.mm.ag.c)localObject1).ivS);
            paramca.sessionId = UUID.randomUUID().toString();
            break;
            label624:
            i = 1;
            break label267;
            j = 1;
          }
          label636:
          if (paramView.iyr.startsWith("frhb://c2cbizmessagehandler/hongbao/receivehongbao"))
          {
            localObject2 = new Intent();
            if (parama.gRM()) {}
            for (;;)
            {
              ((Intent)localObject2).putExtra("key_way", i);
              ((Intent)localObject2).putExtra("key_native_url", paramView.iyr);
              ((Intent)localObject2).putExtra("key_hk_url", (String)localObject1);
              ((Intent)localObject2).putExtra("key_username", parama.getTalkerUserName());
              ((Intent)localObject2).putExtra("key_msgid", paramca.field_msgId);
              ((Intent)localObject2).putExtra("key_hk_scene", 1);
              com.tencent.mm.br.c.b(parama.Pwc.getContext(), "luckymoney", ".hk.ui.LuckyMoneyHKReceiveUI", (Intent)localObject2);
              break;
              i = 1;
            }
          }
          Log.i("MicroMsg.ChattingItemAppMsgC2CTo", "native url not match:" + paramView.iyr + ", go webview:" + (String)localObject1);
          if (Util.isNullOrNil((String)localObject1)) {
            break;
          }
          paramView = new Intent();
          paramView.putExtra("rawUrl", (String)localObject1);
          com.tencent.mm.br.c.b(parama.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
          break;
          label846:
          if (!Util.isNullOrNil(paramView.iyz))
          {
            Log.i("MicroMsg.ChattingItemAppMsgC2CTo", "tofuliu billNo: %s, c2cNewAAType: %s, fromUser: %s", new Object[] { paramView.iyz, Integer.valueOf(paramView.iyA), paramView.dRL });
            if ((paramView.iyA == 2) || (paramView.iyA == 3) || (paramView.iyA == 1) || (paramView.iyA == 5))
            {
              paramca = new Intent();
              paramca.putExtra("bill_no", paramView.iyz);
              paramca.putExtra("launcher_user_name", paramView.dRL);
              paramca.putExtra("enter_scene", 1);
              paramca.putExtra("chatroom", parama.getTalkerUserName());
              com.tencent.mm.br.c.b(parama.Pwc.getContext(), "aa", ".ui.PaylistAAUI", paramca);
              if (paramView.iyA == 2)
              {
                com.tencent.mm.plugin.report.service.h.CyF.a(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(2) });
                break;
              }
              if (paramView.iyA == 3)
              {
                com.tencent.mm.plugin.report.service.h.CyF.a(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(3) });
                break;
              }
              if (paramView.iyA != 5) {
                break;
              }
              com.tencent.mm.plugin.report.service.h.CyF.a(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(4) });
              break;
            }
            if (Util.isNullOrNil((String)localObject1)) {
              break;
            }
            paramView = new Intent();
            paramView.putExtra("rawUrl", (String)localObject1);
            com.tencent.mm.br.c.b(parama.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
            break;
          }
          if ((Util.isNullOrNil((String)localObject1)) || (Util.isNullOrNil((String)localObject1))) {
            break;
          }
          paramView = new Intent();
          paramView.putExtra("rawUrl", (String)localObject1);
          com.tencent.mm.br.c.b(parama.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
          break;
        }
      }
    }
    
    public final boolean gTT()
    {
      return true;
    }
    
    final boolean gTV()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.f
 * JD-Core Version:    0.7.0.1
 */