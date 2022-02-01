package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.adj;
import com.tencent.mm.autogen.a.adj.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.m;
import java.util.UUID;

public final class f$c
  extends c
{
  private com.tencent.mm.ui.chatting.d.a aeiK;
  
  public static boolean g(com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    int j = 0;
    int i = 2;
    AppMethodBeat.i(255735);
    if (!WeChatBrands.Business.Entries.SessionLuckyMoney.checkAvailable(parama.aezO.getContext()))
    {
      AppMethodBeat.o(255735);
      return true;
    }
    ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).amp(paramcc.field_talker);
    Object localObject1 = paramcc.field_content;
    if (localObject1 != null) {}
    for (localObject1 = k.b.aP((String)localObject1, paramcc.field_reserved);; localObject1 = null)
    {
      Object localObject2;
      Object localObject3;
      if (localObject1 != null)
      {
        if (!Util.isNullOrNil(((k.b)localObject1).nSC)) {
          break label581;
        }
        localObject2 = ((k.b)localObject1).url;
        Log.i("MicroMsg.ChattingItemAppMsgC2CTo", "url==null: %s, billNo==null: %s", new Object[] { Boolean.valueOf(Util.isNullOrNil((String)localObject2)), Boolean.valueOf(Util.isNullOrNil(((k.b)localObject1).nST)) });
        if (Util.isNullOrNil(((k.b)localObject1).nSL)) {
          break label1280;
        }
        if (!((k.b)localObject1).nSL.startsWith("weixin://openNativeUrl/weixinHB/startreceivebizhbrequest")) {
          break label596;
        }
        localObject3 = new Intent();
        ((Intent)localObject3).putExtra("key_way", 1);
        ((Intent)localObject3).putExtra("key_native_url", ((k.b)localObject1).nSL);
        ((Intent)localObject3).putExtra("key_username", parama.getTalkerUserName());
        ((Intent)localObject3).putExtra("key_static_from_scene", 100002);
        ((Intent)localObject3).putExtra("key_msgid", paramcc.field_msgId);
        localObject2 = (com.tencent.mm.message.c)((k.b)localObject1).aK(com.tencent.mm.message.c.class);
        ((Intent)localObject3).putExtra("key_exclusive_username", ((com.tencent.mm.message.c)localObject2).nQc);
        ((Intent)localObject3).putExtra("key_cropname", ((com.tencent.mm.message.c)localObject2).nPT);
        ((Intent)localObject3).putExtra("key_receive_envelope_url", ((com.tencent.mm.message.c)localObject2).nPY);
        ((Intent)localObject3).putExtra("key_receive_envelope_md5", ((com.tencent.mm.message.c)localObject2).nPZ);
        ((Intent)localObject3).putExtra("key_detail_envelope_url", ((com.tencent.mm.message.c)localObject2).nQa);
        ((Intent)localObject3).putExtra("key_detail_envelope_md5", ((com.tencent.mm.message.c)localObject2).nQb);
        localObject1 = (com.tencent.mm.message.g)((k.b)localObject1).aK(com.tencent.mm.message.g.class);
        ((Intent)localObject3).putExtra("key_packet_create_time", (int)paramcc.getCreateTime());
        ((Intent)localObject3).putExtra("key_packet_source", ((com.tencent.mm.message.g)localObject1).nQF);
        ((Intent)localObject3).putExtra("key_about_url", ((com.tencent.mm.message.g)localObject1).nQD);
        ((Intent)localObject3).putExtra("key_packet_id", ((com.tencent.mm.message.g)localObject1).nQE);
        ((Intent)localObject3).putExtra("key_has_story", ((com.tencent.mm.message.g)localObject1).nQI);
        ((Intent)localObject3).putExtra("key_material_flag", ((com.tencent.mm.message.g)localObject1).nQJ);
        ((Intent)localObject3).putExtra("key_receive_envelope_widget_url", ((com.tencent.mm.message.c)localObject2).nQd);
        ((Intent)localObject3).putExtra("key_receive_envelope_widget_md5", ((com.tencent.mm.message.c)localObject2).nQe);
        ((Intent)localObject3).putExtra("key_receive_envelope_widget_status_flag", ((com.tencent.mm.message.c)localObject2).nQj);
        ((Intent)localObject3).putExtra("key_receive_envelope_fission_info", ((com.tencent.mm.message.c)localObject2).nQk);
        com.tencent.mm.br.c.b(parama.aezO.getContext(), "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", (Intent)localObject3);
        if ((((com.tencent.mm.message.c)localObject2).nQl != null) && (((com.tencent.mm.message.c)localObject2).nQl.nQI)) {
          if (Util.isNullOrNil(((com.tencent.mm.message.c)localObject2).nQl.nQG)) {
            break label1681;
          }
        }
      }
      label1280:
      label1681:
      for (j = 2;; j = 1)
      {
        localObject1 = paramcc.sessionId;
        localObject3 = ((com.tencent.mm.message.c)localObject2).nPT;
        parama = parama.getTalkerUserName();
        String str = ((com.tencent.mm.message.c)localObject2).nQl.nQE;
        if (((com.tencent.mm.message.c)localObject2).nQl.nQI)
        {
          label542:
          com.tencent.mm.plugin.luckymoney.a.c.a((String)localObject1, (String)localObject3, parama, str, i, j);
          com.tencent.mm.plugin.luckymoney.a.c.cg(10, ((com.tencent.mm.message.c)localObject2).nPU);
          paramcc.sessionId = UUID.randomUUID().toString();
        }
        label581:
        label596:
        label628:
        do
        {
          AppMethodBeat.o(255735);
          return true;
          localObject2 = ((k.b)localObject1).nSC;
          break;
          i = 1;
          break label542;
          if (!((k.b)localObject1).nSL.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao")) {
            break label1073;
          }
          localObject3 = new Intent();
          if (!parama.juG()) {
            break label1063;
          }
          j = 0;
          ((Intent)localObject3).putExtra("key_way", j);
          ((Intent)localObject3).putExtra("key_native_url", ((k.b)localObject1).nSL);
          ((Intent)localObject3).putExtra("key_username", parama.getTalkerUserName());
          ((Intent)localObject3).putExtra("scene_id", Integer.parseInt(((k.b)localObject1).nSK));
          ((Intent)localObject3).putExtra("key_invalidtime", ((k.b)localObject1).nSl);
          localObject2 = (com.tencent.mm.message.c)((k.b)localObject1).aK(com.tencent.mm.message.c.class);
          localObject1 = (com.tencent.mm.message.g)((k.b)localObject1).aK(com.tencent.mm.message.g.class);
          ((Intent)localObject3).putExtra("key_exclusive_username", ((com.tencent.mm.message.c)localObject2).nQc);
          ((Intent)localObject3).putExtra("key_cropname", ((com.tencent.mm.message.c)localObject2).nPT);
          ((Intent)localObject3).putExtra("key_receive_envelope_url", ((com.tencent.mm.message.c)localObject2).nPY);
          ((Intent)localObject3).putExtra("key_receive_envelope_md5", ((com.tencent.mm.message.c)localObject2).nPZ);
          ((Intent)localObject3).putExtra("key_receive_envelope_widget_url", ((com.tencent.mm.message.c)localObject2).nQd);
          ((Intent)localObject3).putExtra("key_receive_envelope_widget_md5", ((com.tencent.mm.message.c)localObject2).nQe);
          ((Intent)localObject3).putExtra("key_receive_envelope_widget_status_flag", ((com.tencent.mm.message.c)localObject2).nQj);
          ((Intent)localObject3).putExtra("key_receive_envelope_fission_info", ((com.tencent.mm.message.c)localObject2).nQk);
          ((Intent)localObject3).putExtra("key_packet_create_time", (int)paramcc.getCreateTime());
          ((Intent)localObject3).putExtra("key_packet_source", ((com.tencent.mm.message.g)localObject1).nQF);
          ((Intent)localObject3).putExtra("key_detail_envelope_url", ((com.tencent.mm.message.c)localObject2).nQa);
          ((Intent)localObject3).putExtra("key_detail_envelope_md5", ((com.tencent.mm.message.c)localObject2).nQb);
          ((Intent)localObject3).putExtra("key_about_url", ((com.tencent.mm.message.g)localObject1).nQD);
          ((Intent)localObject3).putExtra("key_packet_id", ((com.tencent.mm.message.g)localObject1).nQE);
          ((Intent)localObject3).putExtra("key_has_story", ((com.tencent.mm.message.g)localObject1).nQI);
          ((Intent)localObject3).putExtra("key_material_flag", ((com.tencent.mm.message.g)localObject1).nQJ);
          ((Intent)localObject3).putExtra("key_msgid", paramcc.field_msgId);
          com.tencent.mm.br.c.b(parama.aezO.getContext(), "luckymoney", ".ui.LuckyMoneyNotHookReceiveUI", (Intent)localObject3);
        } while ((((com.tencent.mm.message.c)localObject2).nQl == null) || (!((com.tencent.mm.message.c)localObject2).nQl.nQI));
        if (!Util.isNullOrNil(((com.tencent.mm.message.c)localObject2).nQl.nQG)) {}
        for (j = 2;; j = 1)
        {
          localObject1 = paramcc.sessionId;
          localObject3 = ((com.tencent.mm.message.c)localObject2).nPT;
          parama = parama.getTalkerUserName();
          str = ((com.tencent.mm.message.c)localObject2).nQl.nQE;
          if (((com.tencent.mm.message.c)localObject2).nQl.nQI) {}
          for (;;)
          {
            com.tencent.mm.plugin.luckymoney.a.c.a((String)localObject1, (String)localObject3, parama, str, i, j);
            com.tencent.mm.plugin.luckymoney.a.c.cg(10, ((com.tencent.mm.message.c)localObject2).nPU);
            paramcc.sessionId = UUID.randomUUID().toString();
            break;
            label1063:
            j = 1;
            break label628;
            i = 1;
          }
          label1073:
          if (((k.b)localObject1).nSL.startsWith("frhb://c2cbizmessagehandler/hongbao/receivehongbao"))
          {
            localObject3 = new Intent();
            if (parama.juG()) {}
            for (i = j;; i = 1)
            {
              ((Intent)localObject3).putExtra("key_way", i);
              ((Intent)localObject3).putExtra("key_native_url", ((k.b)localObject1).nSL);
              ((Intent)localObject3).putExtra("key_hk_url", (String)localObject2);
              ((Intent)localObject3).putExtra("key_username", parama.getTalkerUserName());
              ((Intent)localObject3).putExtra("key_msgid", paramcc.field_msgId);
              ((Intent)localObject3).putExtra("key_hk_scene", 1);
              com.tencent.mm.br.c.b(parama.aezO.getContext(), "luckymoney", ".hk.ui.LuckyMoneyHKReceiveUI", (Intent)localObject3);
              break;
            }
          }
          Log.i("MicroMsg.ChattingItemAppMsgC2CTo", "native url not match:" + ((k.b)localObject1).nSL + ", go webview:" + (String)localObject2);
          if (Util.isNullOrNil((String)localObject2)) {
            break;
          }
          paramcc = new Intent();
          paramcc.putExtra("rawUrl", (String)localObject2);
          com.tencent.mm.br.c.b(parama.aezO.getContext(), "webview", ".ui.tools.WebViewUI", paramcc);
          break;
          if (!Util.isNullOrNil(((k.b)localObject1).nST))
          {
            Log.i("MicroMsg.ChattingItemAppMsgC2CTo", "tofuliu billNo: %s, c2cNewAAType: %s, fromUser: %s", new Object[] { ((k.b)localObject1).nST, Integer.valueOf(((k.b)localObject1).nSU), ((k.b)localObject1).hQQ });
            if ((((k.b)localObject1).nSU == 2) || (((k.b)localObject1).nSU == 3) || (((k.b)localObject1).nSU == 1) || (((k.b)localObject1).nSU == 5))
            {
              paramcc = new Intent();
              paramcc.putExtra("bill_no", ((k.b)localObject1).nST);
              paramcc.putExtra("launcher_user_name", ((k.b)localObject1).hQQ);
              paramcc.putExtra("enter_scene", 1);
              paramcc.putExtra("chatroom", parama.getTalkerUserName());
              com.tencent.mm.br.c.b(parama.aezO.getContext(), "aa", ".ui.PaylistAAUI", paramcc);
              if (((k.b)localObject1).nSU == 2)
              {
                com.tencent.mm.plugin.report.service.h.OAn.b(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(2) });
                break;
              }
              if (((k.b)localObject1).nSU == 3)
              {
                com.tencent.mm.plugin.report.service.h.OAn.b(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(3) });
                break;
              }
              if (((k.b)localObject1).nSU != 5) {
                break;
              }
              com.tencent.mm.plugin.report.service.h.OAn.b(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(4) });
              break;
            }
            if (Util.isNullOrNil((String)localObject2)) {
              break;
            }
            paramcc = new Intent();
            paramcc.putExtra("rawUrl", (String)localObject2);
            com.tencent.mm.br.c.b(parama.aezO.getContext(), "webview", ".ui.tools.WebViewUI", paramcc);
            break;
          }
          if ((Util.isNullOrNil((String)localObject2)) || (Util.isNullOrNil((String)localObject2))) {
            break;
          }
          paramcc = new Intent();
          paramcc.putExtra("rawUrl", (String)localObject2);
          com.tencent.mm.br.c.b(parama.aezO.getContext(), "webview", ".ui.tools.WebViewUI", paramcc);
          break;
        }
      }
    }
  }
  
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
      localObject = new ap(paramLayoutInflater, R.i.ggy);
      ((View)localObject).setTag(new f.a().lt((View)localObject));
    }
    AppMethodBeat.o(36854);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
  {
    AppMethodBeat.i(36855);
    this.aeiK = parama1;
    f.a locala = (f.a)parama;
    k.b localb;
    com.tencent.mm.message.c localc;
    adj localadj;
    label196:
    Object localObject;
    label403:
    label436:
    label509:
    int i;
    label531:
    label547:
    int j;
    if (locala.aePd == paramcc.field_msgId)
    {
      locala.Wmn = true;
      locala.aePd = paramcc.field_msgId;
      paramString = paramcc.field_content;
      localb = null;
      if (paramString != null) {
        localb = k.b.aP(paramString, paramcc.field_reserved);
      }
      if (localb != null)
      {
        localc = (com.tencent.mm.message.c)localb.aK(com.tencent.mm.message.c.class);
        boolean bool2 = "1001".equals(localb.nSK);
        localadj = new adj();
        if ((!Util.isNullOrNil(localb.nSL)) && (!bool2))
        {
          localadj.ihv.ihx = localb.nSL;
          localadj.publish();
        }
        locala.resetChatBubbleWidth(locala.clickArea, locala.aeOt);
        if (!"1001".equals(localb.nSK)) {
          break label1279;
        }
        paramString = locala.clickArea;
        if (paramcc.field_isSend != 1) {
          break label1046;
        }
        bool1 = true;
        paramString.setBackgroundResource(com.tencent.mm.ui.chatting.g.c(localb, bool1));
        locala.aeOT.setTypeface(Typeface.defaultFromStyle(1));
        locala.pKl.setVisibility(0);
        if (aw.isDarkMode()) {
          break label1052;
        }
        locala.aeOT.setTextColor(parama1.aezO.getContext().getResources().getColor(R.e.White));
        locala.aeOT.setAlpha(1.0F);
        locala.aeOU.setTextColor(parama1.aezO.getContext().getResources().getColor(R.e.White));
        locala.aeOU.setAlpha(1.0F);
        locala.aeOV.setTextColor(parama1.aezO.getContext().getResources().getColor(R.e.White));
        locala.aeOV.setAlpha(0.8F);
        locala.aeOS.setAlpha(1.0F);
        com.tencent.mm.cd.a.fromDPToPix(parama1.aezO.getContext(), 13);
        parama1.aezO.getContext().getResources().getDimensionPixelSize(R.f.MiddlePadding);
        locala.clickArea.setPadding(0, 0, 0, 0);
        if (paramcc.field_isSend != 1) {
          break label1434;
        }
        paramString = localb.nSF;
        if (!Util.isNullOrNil(paramString)) {
          break label1444;
        }
        paramString = localb.description;
        locala.aeOT.setSingleLine(false);
        locala.aeOT.setMaxLines(3);
        locala.aeOT.setText(p.d(parama1.aezO.getContext(), paramString, locala.aePb));
        locala.aeOT.setTextSize(0, locala.aePb);
        if (!bool2) {
          break label1462;
        }
        localObject = locala.aeOU;
        paramString = parama1.aezO.getContext();
        if (paramcc.field_isSend != 1) {
          break label1456;
        }
        bool1 = true;
        paramString = p.b(paramString, com.tencent.mm.ui.chatting.g.a(localb, bool1), locala.aeOU.getTextSize());
        ((TextView)localObject).setText(paramString);
        locala.aeOU.setVisibility(0);
        localObject = localb.nSI;
        paramString = (String)localObject;
        if (Util.isNullOrNil((String)localObject)) {
          paramString = localb.title;
        }
        locala.aeOV.setText(paramString);
        i = 0;
        if (!Util.isNullOrNil(localc.nPQ))
        {
          r.bKe().loadImage("", locala.aeOS);
          j = parama1.aezO.getMMResources().getIdentifier(localc.nPQ, "drawable", MMApplicationContext.getPackageName());
          i = j;
          if (j <= 0) {
            i = parama1.aezO.getMMResources().getIdentifier(localc.nPQ, "raw", MMApplicationContext.getPackageName());
          }
        }
        Log.v("MicroMsg.ChattingItemAppMsgC2CTo", "c2c localResId: %s", new Object[] { Integer.valueOf(i) });
        if (i > 0)
        {
          Log.v("MicroMsg.ChattingItemAppMsgC2CTo", "set c2cIcon from localRes");
          locala.aeOS.setImageResource(i);
        }
        if (!"1001".equals(localb.nSK)) {
          break label1660;
        }
        if (paramcc.field_isSend != 1) {
          break label1654;
        }
        bool1 = true;
        label735:
        j = com.tencent.mm.ui.chatting.g.b(localb, bool1);
        if (j <= 0) {
          break label1712;
        }
        Log.i("MicroMsg.ChattingItemAppMsgC2CTo", "set c2cIcon from iconRes");
        locala.aeOS.setImageResource(j);
        label767:
        i = -1;
        if (!Util.isNullOrNil(localc.nPR)) {
          i = parama1.aezO.getMMResources().getIdentifier(localc.nPR, "drawable", MMApplicationContext.getPackageName());
        }
        Log.i("MicroMsg.ChattingItemAppMsgC2CTo", "backgroundResId: %s", new Object[] { Integer.valueOf(i) });
        if (i > 0)
        {
          locala.clickArea.setBackgroundResource(i);
          locala.clickArea.setPadding(0, 0, 0, 0);
        }
        i = localadj.ihw.ihz;
        j = localadj.ihw.ihA;
        if (paramcc.field_isSend != 1) {
          break label1826;
        }
      }
    }
    label1046:
    label1052:
    label1826:
    for (boolean bool1 = true;; bool1 = false)
    {
      f.a(locala, localc, false, com.tencent.mm.ui.chatting.g.V(i, j, bool1), parama1.getTalkerUserName(), paramcc);
      parama.clickArea.setOnClickListener(d(parama1));
      if (!ab.IN(parama1.getTalkerUserName())) {
        parama.clickArea.setOnLongClickListener(c(parama1));
      }
      parama.clickArea.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
      paramcc = new bz(paramcc, this.aeiK.juG(), paramInt, null, '\000');
      parama.clickArea.setTag(paramcc);
      if (((f.a)parama).uiF == null) {
        break label1867;
      }
      if (!aw.isDarkMode()) {
        break label1832;
      }
      ((f.a)parama).uiF.setBackground(null);
      ((f.a)parama).pKl.setVisibility(0);
      AppMethodBeat.o(36855);
      return;
      locala.Wmn = false;
      break;
      bool1 = false;
      break label196;
      locala.aeOT.setTextColor(parama1.aezO.getContext().getResources().getColor(R.e.White));
      locala.aeOU.setTextColor(parama1.aezO.getContext().getResources().getColor(R.e.White));
      locala.aeOV.setTextColor(parama1.aezO.getContext().getResources().getColor(R.e.White));
      paramString = locala.aeOT;
      if (paramcc.field_isSend == 1)
      {
        bool1 = true;
        label1143:
        paramString.setAlpha(com.tencent.mm.ui.chatting.g.a(localb, bool1, false));
        paramString = locala.aeOU;
        if (paramcc.field_isSend != 1) {
          break label1261;
        }
        bool1 = true;
        paramString.setAlpha(com.tencent.mm.ui.chatting.g.a(localb, bool1, false));
        paramString = locala.aeOV;
        if (paramcc.field_isSend != 1) {
          break label1267;
        }
        bool1 = true;
        label1207:
        paramString.setAlpha(com.tencent.mm.ui.chatting.g.a(localb, bool1, true));
        paramString = locala.aeOS;
        if (paramcc.field_isSend != 1) {
          break label1273;
        }
      }
      label1261:
      label1267:
      label1273:
      for (bool1 = true;; bool1 = false)
      {
        paramString.setAlpha(com.tencent.mm.ui.chatting.g.a(localb, bool1, false));
        break;
        bool1 = false;
        break label1143;
        bool1 = false;
        break label1175;
        bool1 = false;
        break label1207;
      }
      label1279:
      paramString = locala.clickArea;
      i = localadj.ihw.ihz;
      j = localadj.ihw.ihA;
      if (paramcc.field_isSend == 1)
      {
        bool1 = true;
        label1318:
        paramString.setBackgroundResource(com.tencent.mm.ui.chatting.g.T(i, j, bool1));
        locala.aeOT.setTypeface(Typeface.defaultFromStyle(1));
        if (locala.aePb <= locala.maxSize) {
          break label1424;
        }
      }
      for (i = locala.maxSize;; i = locala.aePb)
      {
        locala.aePb = i;
        locala.pKl.setVisibility(0);
        locala.aeOV.setTextColor(parama1.aezO.getContext().getResources().getColor(R.e.White));
        locala.aeOV.setAlpha(0.7F);
        break;
        bool1 = false;
        break label1318;
      }
      paramString = localb.nSE;
      break label403;
      label1444:
      locala.aeOT.setSingleLine(true);
      break label436;
      label1456:
      bool1 = false;
      break label509;
      label1462:
      if (!Util.isNullOrNil(localb.nSL))
      {
        locala.aeOU.setTextSize(1, 12.0F);
        i = localadj.ihw.ihy;
        j = localadj.ihw.ihz;
        k = localadj.ihw.ihA;
        if (paramcc.field_isSend == 1) {}
        for (bool1 = true;; bool1 = false)
        {
          paramString = com.tencent.mm.ui.chatting.g.a(i, j, k, bool1, parama1.juG(), parama1.getTalkerUserName(), localb, locala.aeOU);
          if (Util.isNullOrNil(paramString)) {
            break label1605;
          }
          localObject = locala.aeOU;
          paramString = p.b(locala.aeOU.getContext(), Util.nullAsNil(paramString), locala.aeOU.getTextSize());
          break;
        }
        label1605:
        locala.aeOU.setVisibility(8);
        break label547;
      }
      localObject = locala.aeOU;
      if (paramcc.field_isSend == 1)
      {
        paramString = localb.nSG;
        break label531;
      }
      paramString = localb.nSH;
      break label531;
      label1654:
      bool1 = false;
      break label735;
      label1660:
      j = localadj.ihw.ihz;
      int k = localadj.ihw.ihA;
      if (paramcc.field_isSend == 1) {}
      for (bool1 = true;; bool1 = false)
      {
        j = com.tencent.mm.ui.chatting.g.U(j, k, bool1);
        break;
      }
      label1712:
      if (i > 0) {
        break label767;
      }
      Log.i("MicroMsg.ChattingItemAppMsgC2CTo", "set c2cIcon from iconUrl");
      localObject = localb.nSD;
      paramString = (String)localObject;
      if (Util.isNullOrNil((String)localObject)) {
        paramString = localb.thumburl;
      }
      locala.aeOS.setImageBitmap(null);
      if (Util.isNullOrNil(paramString)) {
        break label767;
      }
      localObject = new com.tencent.mm.modelimage.loader.a.c.a();
      bh.bCz();
      ((com.tencent.mm.modelimage.loader.a.c.a)localObject).prefixPath = com.tencent.mm.model.c.bzM();
      ((com.tencent.mm.modelimage.loader.a.c.a)localObject).oKp = true;
      ((com.tencent.mm.modelimage.loader.a.c.a)localObject).nqa = true;
      localObject = ((com.tencent.mm.modelimage.loader.a.c.a)localObject).bKx();
      r.bKe().a(paramString, locala.aeOS, (com.tencent.mm.modelimage.loader.a.c)localObject);
      break label767;
    }
    label1175:
    label1434:
    label1832:
    ((f.a)parama).uiF.setBackground(parama1.aezO.getMMResources().getDrawable(R.g.fnk));
    label1424:
    ((f.a)parama).pKl.setVisibility(8);
    label1867:
    AppMethodBeat.o(36855);
  }
  
  public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.d.a parama, final cc paramcc)
  {
    AppMethodBeat.i(36857);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(36857);
      return false;
    }
    final String str1 = paramcc.field_content;
    paramMenuItem = null;
    if (str1 != null) {
      paramMenuItem = k.b.aP(str1, paramcc.field_reserved);
    }
    if (paramMenuItem != null)
    {
      paramcc = paramcc.field_talker;
      str1 = paramMenuItem.nSE;
      final String str2 = paramMenuItem.nSF;
      final String str3 = paramMenuItem.nSG;
      final String str4 = paramMenuItem.nSH;
      final String str5 = paramMenuItem.nSC;
      final String str6 = paramMenuItem.nSJ;
      paramMenuItem = paramMenuItem.nSK;
      k.b(parama.aezO.getContext(), parama.aezO.getMMResources().getString(R.l.gzl), parama.aezO.getMMResources().getString(R.l.app_remind), parama.aezO.getMMResources().getString(R.l.gzm), parama.aezO.getMMResources().getString(R.l.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(36853);
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("key_scene", 1);
          paramAnonymousDialogInterface.putExtra("key_receiver", paramcc);
          paramAnonymousDialogInterface.putExtra("key_receivertitle", str1);
          paramAnonymousDialogInterface.putExtra("key_sendertitle", str2);
          paramAnonymousDialogInterface.putExtra("key_sender_des", str3);
          paramAnonymousDialogInterface.putExtra("key_receiver_des", str4);
          paramAnonymousDialogInterface.putExtra("key_url", str5);
          paramAnonymousDialogInterface.putExtra("key_templateid", str6);
          paramAnonymousDialogInterface.putExtra("key_sceneid", paramMenuItem);
          com.tencent.mm.br.c.b(parama.aezO.getContext(), "wallet_index", ".ui.WalletSendC2CMsgUI", paramAnonymousDialogInterface);
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
  
  public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(255756);
    params.a(((bz)paramView.getTag()).position, 100, this.aeiK.aezO.getMMResources().getString(R.l.gyo), R.k.icons_filled_delete);
    AppMethodBeat.o(255756);
    return false;
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(36858);
    boolean bool = g(parama, paramcc);
    AppMethodBeat.o(36858);
    return bool;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 436207665);
  }
  
  public final boolean fXn()
  {
    return true;
  }
  
  public final boolean jxg()
  {
    return true;
  }
  
  final boolean jxi()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.f.c
 * JD-Core Version:    0.7.0.1
 */