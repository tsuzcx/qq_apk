package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.u;
import com.tencent.mm.aj.v;
import com.tencent.mm.ay.q;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bs;
import com.tencent.mm.plugin.brandservice.a.f;
import com.tencent.mm.pluginsdk.model.w;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.pluginsdk.ui.applet.n;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.an;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.s;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class an$j
  extends c
{
  private static int HyD;
  private static int Xij;
  private static int Xik;
  private static int sAs;
  private static int sAt = 0;
  private static int sAu;
  private static int sAv = 0;
  private static int sAx;
  private com.tencent.mm.ui.chatting.e.a WBq;
  private boolean Xil = false;
  private int Xim = 0;
  private long sHA = 0L;
  private boolean sHB = false;
  
  static
  {
    sAu = 0;
  }
  
  private static void Y(View paramView, int paramInt)
  {
    AppMethodBeat.i(277161);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(277161);
  }
  
  private static void Z(View paramView, int paramInt)
  {
    AppMethodBeat.i(37156);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.rightMargin = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(37156);
  }
  
  private static String a(ca paramca, Context paramContext, int paramInt)
  {
    AppMethodBeat.i(37167);
    if (paramContext == null)
    {
      Log.w("MicroMsg.ChattingItemBizFrom", "getReaderAppMsgContent: context is null");
      AppMethodBeat.o(37167);
      return null;
    }
    if (paramca == null)
    {
      Log.w("MicroMsg.ChattingItemBizFrom", "getReaderAppMsgContent: msg is null");
      AppMethodBeat.o(37167);
      return null;
    }
    paramca = com.tencent.mm.aj.m.a(paramContext, paramInt, paramca.field_content, paramca.field_talker, paramca.field_msgId);
    AppMethodBeat.o(37167);
    return paramca;
  }
  
  private static void a(View paramView, an.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(37159);
    if (paramBoolean)
    {
      if (paramb.sEi == null) {
        paramb.dS(paramView);
      }
      if (paramb.sEi != null)
      {
        paramb.sEi.setVisibility(0);
        AppMethodBeat.o(37159);
      }
    }
    else if (paramb.sEi != null)
    {
      paramb.sEi.setVisibility(8);
    }
    AppMethodBeat.o(37159);
  }
  
  private void a(ImageView paramImageView, ca paramca, int paramInt)
  {
    AppMethodBeat.i(37158);
    e.g localg = new e.g();
    localg.msgId = paramca.field_msgId;
    localg.XeO = paramInt;
    localg.xml = paramca.field_content;
    paramImageView.setTag(localg);
    paramImageView.setOnClickListener(((com.tencent.mm.ui.chatting.d.b.k)this.WBq.bC(com.tencent.mm.ui.chatting.d.b.k.class)).hNP());
    AppMethodBeat.o(37158);
  }
  
  private void a(v paramv, View paramView)
  {
    AppMethodBeat.i(37168);
    s.a(paramv, paramView, this.WBq.getTalkerUserName());
    AppMethodBeat.o(37168);
  }
  
  private void a(v paramv, View paramView, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(37169);
    if (((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).Gv(paramv.type)) {
      paramView.setOnClickListener(new an.j.2(this, paramLong1, paramLong2, paramInt));
    }
    AppMethodBeat.o(37169);
  }
  
  private void a(v paramv, ca paramca, int paramInt, u paramu, View paramView)
  {
    AppMethodBeat.i(37153);
    String str = ((d)this.WBq.bC(d.class)).bzf(paramv.url);
    if (!TextUtils.isEmpty(str))
    {
      Log.d("MicroMsg.ChattingItemBizFrom", "productId:%s", new Object[] { str });
      paramu = new by(paramca, false, paramInt, paramv.url, false, this.WBq.hOp(), paramu.fUd, paramu.fUe, paramv.title, str, null, false, false);
      paramView.setOnClickListener(i(this.WBq));
    }
    for (;;)
    {
      paramu.PVT = paramca.field_msgSvrId;
      paramu.PVU = 0;
      paramu.XmP = paramv.type;
      paramView.setTag(paramu);
      if (com.tencent.mm.aj.m.OS(paramv.lpP)) {
        a(paramv, paramView);
      }
      a(paramv, paramView, paramca.field_msgId, paramca.field_msgSvrId, 0);
      paramView.setOnLongClickListener(c(this.WBq));
      paramView.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)this.WBq.bC(com.tencent.mm.ui.chatting.d.b.k.class)).hNO());
      AppMethodBeat.o(37153);
      return;
      paramu = new by(paramca, false, paramInt, paramv.url, false, this.WBq.hOp(), paramu.fUd, paramu.fUe, paramv.title);
      a(paramu, paramv, paramca);
      paramView.setOnClickListener(h(this.WBq));
    }
  }
  
  private static void a(an.c paramc, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    AppMethodBeat.i(37160);
    boolean bool1;
    if (paramInt1 == 5)
    {
      bool1 = true;
      a(paramc.sHk, paramc.XhZ, bool1);
      if (!bool1) {
        break label232;
      }
    }
    label46:
    label75:
    label209:
    label215:
    label227:
    label232:
    for (int i = 1;; i = 0)
    {
      if (paramInt1 == 8)
      {
        bool1 = true;
        a(paramc.sHk, paramc.Xia, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 7) {
          break label203;
        }
        bool1 = true;
        a(paramc.sHk, paramc.Xib, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 6) {
          break label209;
        }
        bool1 = true;
        label104:
        a(paramc.sHk, paramc.Xic, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 10) {
          break label215;
        }
        bool1 = true;
        a(paramc.sHk, paramc.Xid, bool1);
        if (!bool1) {
          break label227;
        }
      }
      for (paramInt1 = 1;; paramInt1 = i)
      {
        LinearLayout localLinearLayout = paramc.sHk;
        paramc = paramc.XhY;
        if ((paramInt1 == 0) && (paramInt2 > 0)) {}
        for (bool1 = bool2;; bool1 = false)
        {
          a(localLinearLayout, paramc, bool1);
          AppMethodBeat.o(37160);
          return;
          bool1 = false;
          break;
          bool1 = false;
          break label46;
          bool1 = false;
          break label75;
          bool1 = false;
          break label104;
          bool1 = false;
          break label133;
        }
      }
    }
  }
  
  private void a(an.c paramc, final an.a parama, v paramv, ca paramca, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(37157);
    if (parama.sGT != null) {
      parama.sGT.setVisibility(8);
    }
    if (paramv.type == 5)
    {
      parama.sGV.setVisibility(0);
      parama.sGV.setImageResource(R.g.dmx);
      parama.sGV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(169877);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          parama.sEi.performClick();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(169877);
        }
      });
      paramInt = com.tencent.mm.ci.a.fromDPToPix(this.WBq.WQv.getContext(), 26);
      if (paramv.type != 7) {
        break label489;
      }
      paramInt = com.tencent.mm.ci.a.fromDPToPix(this.WBq.WQv.getContext(), 32);
    }
    for (;;)
    {
      aT(parama.sGV, paramInt);
      AppMethodBeat.o(37157);
      return;
      if (paramv.type == 6)
      {
        parama.sGV.setVisibility(0);
        if (paramBoolean) {
          if ((paramca.field_msgId + "_" + paramInt + "_msg").equals(paramc.playingMsgId)) {
            parama.sGV.setImageResource(R.g.chatting_item_biz_music_pause_selector);
          }
        }
        for (;;)
        {
          a(parama.sGV, paramca, paramInt);
          break;
          parama.sGV.setImageResource(R.g.chatting_item_biz_music_play_selector);
          continue;
          if ((paramca.field_msgId + "_" + paramInt + "_msg").equals(paramc.playingMsgId)) {
            parama.sGV.setImageResource(R.k.chatting_item_biz_music_pause_loading_icon);
          } else {
            parama.sGV.setImageResource(R.k.chatting_item_biz_music_play_loading_icon);
          }
        }
      }
      if (paramv.type == 7)
      {
        parama.sGV.setVisibility(8);
        if (parama.sGT != null) {
          parama.sGT.setVisibility(0);
        }
        Drawable localDrawable = parama.sGU.getDrawable();
        if (((localDrawable instanceof AnimationDrawable)) && (((AnimationDrawable)localDrawable).isRunning())) {
          ((AnimationDrawable)localDrawable).stop();
        }
        if ((paramca.field_msgId + "_" + paramInt + "_msg").equals(paramc.playingMsgId))
        {
          parama.sGU.setImageResource(R.g.dmz);
          if ((parama.sGU.getDrawable() instanceof AnimationDrawable)) {
            ((AnimationDrawable)parama.sGU.getDrawable()).start();
          }
        }
        for (;;)
        {
          a(parama.sGU, paramca, paramInt);
          break;
          parama.sGU.setImageResource(R.g.dmy);
        }
      }
      parama.sGV.setVisibility(8);
      break;
      label489:
      if (paramv.type == 5) {
        paramInt = com.tencent.mm.ci.a.fromDPToPix(this.WBq.WQv.getContext(), 24);
      }
    }
  }
  
  private void a(by paramby, v paramv, ca paramca)
  {
    AppMethodBeat.i(37162);
    Bundle localBundle = new Bundle();
    int i;
    switch (ac.aN(a(this.WBq, paramca), this.WBq.getTalkerUserName()))
    {
    case 3: 
    case 4: 
    case 5: 
    default: 
      i = 0;
    }
    for (;;)
    {
      localBundle.putString("share_report_pre_msg_url", paramv.url);
      localBundle.putString("share_report_pre_msg_title", paramv.title);
      localBundle.putString("share_report_pre_msg_desc", paramv.lpM);
      localBundle.putString("share_report_pre_msg_icon_url", com.tencent.mm.aj.m.a(paramv));
      localBundle.putString("share_report_pre_msg_appid", "");
      localBundle.putInt("share_report_from_scene", i);
      if (i == 5) {
        localBundle.putString("share_report_biz_username", this.WBq.getTalkerUserName());
      }
      paramby.XmN = localBundle;
      AppMethodBeat.o(37162);
      return;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 5;
    }
  }
  
  private static void a(String paramString, ImageView paramImageView, int paramInt1, int paramInt2, m.a parama)
  {
    AppMethodBeat.i(37163);
    paramString = com.tencent.mm.api.b.M(paramString, 3);
    com.tencent.mm.ay.a.a locala = q.bml();
    com.tencent.mm.ay.a.a.c.a locala1 = new com.tencent.mm.ay.a.a.c.a();
    locala1.lRS = R.e.chatting_item_biz_default_bg;
    locala1.lRD = true;
    locala1 = locala1.dO(paramInt1, paramInt2);
    locala1.lRs = new n(2);
    locala1.lSb = new com.tencent.mm.pluginsdk.ui.applet.e(2);
    locala1.fullPath = w.bpO(paramString);
    locala.a(paramString, paramImageView, locala1.bmL(), null, new com.tencent.mm.pluginsdk.ui.applet.m(2, 0, 0, null, parama));
    AppMethodBeat.o(37163);
  }
  
  private void a(String paramString, ImageView paramImageView, boolean paramBoolean, int paramInt, m.a parama)
  {
    AppMethodBeat.i(37164);
    paramString = com.tencent.mm.api.b.M(paramString, 3);
    int i;
    boolean bool;
    label28:
    int j;
    label37:
    float f1;
    if (paramBoolean)
    {
      i = R.g.dml;
      if (!paramBoolean) {
        break label248;
      }
      bool = false;
      if (!paramBoolean) {
        break label254;
      }
      j = R.g.dmo;
      f1 = this.WBq.WQv.getContext().getResources().getDimensionPixelSize(R.f.chatting_item_corners_size);
      if (!((com.tencent.mm.ui.chatting.d.b.k)this.WBq.bC(com.tencent.mm.ui.chatting.d.b.k.class)).hNH()) {
        break label262;
      }
    }
    label262:
    for (int k = 72;; k = 32)
    {
      Object localObject = com.tencent.mm.plugin.bizui.a.a.shG;
      int m = com.tencent.mm.plugin.bizui.a.a.eO(paramImageView.getContext());
      float f2 = com.tencent.mm.ci.a.getDensity(paramImageView.getContext());
      k = m - (int)(k * f2);
      localObject = q.bml();
      com.tencent.mm.ay.a.a.c.a locala = new com.tencent.mm.ay.a.a.c.a();
      locala.lRS = j;
      locala.lRD = true;
      locala.lRU = String.valueOf(i);
      locala = locala.dO(k, paramInt);
      locala.lRs = new n(2);
      locala.lSb = new com.tencent.mm.pluginsdk.ui.applet.e(2);
      locala.fullPath = w.bpO(paramString);
      ((com.tencent.mm.ay.a.a)localObject).a(paramString, paramImageView, locala.bmL(), null, new com.tencent.mm.pluginsdk.ui.applet.m(2, k, paramInt, true, bool, f1, parama));
      AppMethodBeat.o(37164);
      return;
      i = R.g.dmk;
      break;
      label248:
      bool = true;
      break label28;
      label254:
      j = R.g.dmn;
      break label37;
    }
  }
  
  private static void aT(View paramView, int paramInt)
  {
    AppMethodBeat.i(37155);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.width = paramInt;
    localLayoutParams.height = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(37155);
  }
  
  private static void c(v paramv)
  {
    if (paramv.type == 6) {
      paramv.type = 7;
    }
  }
  
  private void e(com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(37165);
    if (this.sHB)
    {
      if (!this.sHB)
      {
        Log.w("MicroMsg.ChattingItemBizFrom", "transmitAppBrandMsg not AppBrandMsg!");
        AppMethodBeat.o(37165);
        return;
      }
      s.a(this.Xim, parama.WQv.getContext(), paramca.field_content, paramca.field_talker, paramca.field_msgId, paramca.field_msgSvrId);
      AppMethodBeat.o(37165);
      return;
    }
    String str = a(paramca, parama.WQv.getContext(), this.Xim);
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(37165);
      return;
    }
    Intent localIntent = new Intent(parama.WQv.getContext(), MsgRetransmitUI.class);
    localIntent.putExtra("Retr_Msg_content", str);
    localIntent.putExtra("Retr_Msg_Type", 2);
    localIntent.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.Xim);
    localIntent.putExtra("Retr_Msg_Id", paramca.field_msgId);
    localIntent.putExtra("Retr_MsgFromScene", 1);
    str = paramca.field_talker;
    Object localObject = ad.Rp(paramca.field_msgSvrId);
    localIntent.putExtra("reportSessionId", (String)localObject);
    localObject = ad.beh().I((String)localObject, true);
    ((ad.b)localObject).k("prePublishId", "msg_" + paramca.field_msgSvrId);
    ((ad.b)localObject).k("preUsername", str);
    ((ad.b)localObject).k("preChatName", str);
    ((ad.b)localObject).k("preMsgIndex", Integer.valueOf(this.Xim));
    ((ad.b)localObject).k("sendAppMsgScene", Integer.valueOf(1));
    paramca = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(parama, paramca.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom", "doRestransmit", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramca.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom", "doRestransmit", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(37165);
  }
  
  private static void lk(Context paramContext)
  {
    AppMethodBeat.i(37151);
    int i;
    int j;
    if (sAv == 0)
    {
      sAv = paramContext.getResources().getDimensionPixelSize(R.f.SmallPadding);
      sAu = paramContext.getResources().getDimensionPixelSize(R.f.MiddlePadding);
      sAt = paramContext.getResources().getDimensionPixelSize(R.f.LargePadding);
      sAs = paramContext.getResources().getDimensionPixelSize(R.f.chatting_item_biz_sub_item_pic_size);
      sAx = paramContext.getResources().getDimensionPixelSize(R.f.chatting_item_biz_line_big_padding);
      com.tencent.mm.plugin.bizui.a.a locala = com.tencent.mm.plugin.bizui.a.a.shG;
      i = com.tencent.mm.plugin.bizui.a.a.eO(paramContext);
      j = com.tencent.mm.ci.a.ks(paramContext);
      if (i >= j) {
        break label145;
      }
    }
    for (;;)
    {
      i -= (int)(com.tencent.mm.ci.a.getDensity(paramContext) * 32.0F);
      HyD = (int)(i / 2.35D);
      Xij = (int)(i / 1.777778F);
      Xik = (int)(i / 1.777778F);
      AppMethodBeat.o(37151);
      return;
      label145:
      i = j;
    }
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37150);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new aq(paramLayoutInflater, R.i.ecy);
      paramView = new an.c();
      paramView.timeTV = ((TextView)((View)localObject).findViewById(R.h.dzs));
      paramView.historyMsgTip = ((View)localObject).findViewById(R.h.dxM);
      paramView.sHk = ((LinearLayout)((View)localObject).findViewById(R.h.dxf));
      paramView.checkBox = ((CheckBox)((View)localObject).findViewById(R.h.dwZ));
      paramView.maskView = ((View)localObject).findViewById(R.h.dyD);
      paramView.Xdu = ((TextView)((View)localObject).findViewById(R.h.dwm));
      ((View)localObject).setTag(paramView);
    }
    lk(paramLayoutInflater.getContext());
    AppMethodBeat.o(37150);
    return localObject;
  }
  
  public final void a(final c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, final ca paramca, final String paramString)
  {
    AppMethodBeat.i(37152);
    this.WBq = parama1;
    lk(parama1.WQv.getContext());
    final an.c localc = (an.c)parama;
    parama = localc.sHn.iterator();
    if (parama.hasNext())
    {
      paramString = (an.a)parama.next();
      if (localc.sHn.indexOf(paramString) != localc.sHn.size() - 1) {
        com.tencent.mm.ui.chatting.aq.aM(paramString.sEi, 1);
      }
      for (;;)
      {
        localc.sHk.removeView(paramString.sEi);
        break;
        com.tencent.mm.ui.chatting.aq.aM(paramString.sEi, 2);
      }
    }
    localc.sHn.clear();
    u localu = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class)).b(paramca.field_msgId, paramca.field_content);
    parama = localu.ilh;
    if ((parama == null) || (parama.length() == 0)) {
      localc.Xdu.setVisibility(8);
    }
    LinkedList localLinkedList;
    final int j;
    for (;;)
    {
      localLinkedList = localu.lpz;
      j = localLinkedList.size();
      if (j != 0) {
        break;
      }
      localc.sHk.setVisibility(8);
      a(localc, -1, 0);
      AppMethodBeat.o(37152);
      return;
      localc.Xdu.setVisibility(0);
      b(parama1, localc.Xdu, by.bzO(parama));
    }
    localc.sHk.setVisibility(0);
    a(localc, ((v)localLinkedList.get(0)).type, j);
    Object localObject1 = parama1.WQv.getActivityLayoutInflater();
    final int i = localc.sHn.size() + 2;
    while (i < j)
    {
      paramString = com.tencent.mm.ui.chatting.aq.avs(1);
      parama = paramString;
      if (paramString == null) {
        parama = ((LayoutInflater)localObject1).inflate(R.i.ecz, null);
      }
      localc.io(parama);
      i += 1;
    }
    if (j > 1)
    {
      paramString = com.tencent.mm.ui.chatting.aq.avs(2);
      parama = paramString;
      if (paramString == null) {
        parama = ((LayoutInflater)localObject1).inflate(R.i.ecA, null);
      }
      localc.io(parama);
    }
    for (this.Xil = true;; this.Xil = false)
    {
      i = 0;
      while (i < localc.sHn.size())
      {
        ((an.a)localc.sHn.get(i)).sEi.setVisibility(8);
        i += 1;
      }
    }
    paramString = (v)localLinkedList.get(0);
    c(paramString);
    label571:
    final boolean bool;
    label641:
    label704:
    label760:
    label763:
    Object localObject2;
    int k;
    label873:
    label884:
    Object localObject3;
    if (paramString.type == 5)
    {
      parama = com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.sKW;
      com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.G(paramString.url, 5, "");
      Y(localc.XhZ.sDp, Xij);
      Y(localc.XhZ.sDf, Xij);
      if (Util.isNullOrNil(paramString.title))
      {
        localc.XhZ.sDe.setVisibility(8);
        if (j != 1) {
          break label1523;
        }
        localc.XhZ.sDf.setBackgroundResource(R.g.dng);
        parama = com.tencent.mm.aj.m.uD(paramString.lpO);
        if (TextUtils.isEmpty(parama)) {
          break label1540;
        }
        localc.XhZ.timeTv.setVisibility(0);
        localc.XhZ.timeTv.setText(parama);
        localc.XhZ.timeTv.setTextColor(this.WBq.WQv.getContext().getResources().getColor(R.e.light_grey_text_color));
        a(paramString, paramca, paramInt, localu, localc.XhZ.sEi);
        localc.XhZ.sCT.setVisibility(8);
        parama = paramString.lpK;
        localObject1 = localc.XhZ.sCR;
        paramca.getType();
        if (j <= 1) {
          break label1556;
        }
        bool = true;
        a(parama, (ImageView)localObject1, bool, Xij, new m.a()
        {
          public final void onFinish()
          {
            AppMethodBeat.i(37143);
            localc.XhZ.sCT.setVisibility(0);
            localc.XhZ.sDe.setTextColor(an.j.a(an.j.this).WQv.getContext().getResources().getColor(R.e.white_text_color));
            localc.XhZ.timeTv.setTextColor(an.j.a(an.j.this).WQv.getContext().getResources().getColor(R.e.white_text_color));
            ImageView localImageView = localc.XhZ.sCT;
            if (j > 1) {}
            for (int i = R.g.dmA;; i = R.g.dmB)
            {
              localImageView.setBackgroundResource(i);
              AppMethodBeat.o(37143);
              return;
            }
          }
          
          public final void onStart() {}
        });
        if (com.tencent.mm.ci.a.ez(this.WBq.WQv.getContext()) <= 1.125F) {
          break label1562;
        }
        localc.XhZ.sDe.setMaxLines(1);
        i = 1;
        if (i >= j) {
          break label4526;
        }
        localObject1 = (v)localLinkedList.get(i);
        c((v)localObject1);
        localObject2 = (an.a)localc.sHn.get(i - 1);
        k = paramString.type;
        if ((i != 1) || ((k != 5) && (k != 8) && (k != 0))) {
          break label3846;
        }
        if ((k != 0) || (!Util.isNullOrNil(((v)localLinkedList.get(0)).lpK))) {
          break label3833;
        }
        ((an.a)localObject2).mrE.setVisibility(0);
        Z(((an.a)localObject2).mrE, sAt);
        if (i != 1) {
          break label4013;
        }
        if (i != j - 1) {
          break label3994;
        }
        ((an.a)localObject2).vpA.setPadding(0, sAt, 0, sAt);
        label915:
        a(localc, (an.a)localObject2, (v)localObject1, paramca, i, false);
        ((an.a)localObject2).sDe.setTextColor(parama1.WQv.getMMResources().getColor(R.e.normal_text_color));
        if (!Util.isNullOrNil(((v)localObject1).title)) {
          break label4102;
        }
        localObject3 = com.tencent.mm.plugin.brandservice.b.b.svR;
        k = ((v)localObject1).type;
        parama = this.WBq.WQv.getContext();
        switch (k)
        {
        case 6: 
        default: 
          parama = parama.getResources().getString(R.l.euv);
          label1027:
          ((com.tencent.mm.plugin.brandservice.b.b)localObject3).a(parama, ((an.a)localObject2).sDe, (v)localObject1, 3);
          label1041:
          if ((((v)localObject1).lpN == 0) || (((v)localObject1).lpN == 1))
          {
            ((an.a)localObject2).sGS.setVisibility(0);
            ((an.a)localObject2).sDe.setTextColor(parama1.WQv.getContext().getResources().getColor(R.e.FG_0));
            if (((v)localObject1).type == 7)
            {
              ((an.a)localObject2).sCR.setVisibility(8);
              label1111:
              if ((Util.isNullOrNil(((v)localObject1).lpM)) || (((v)localObject1).type != 3)) {
                break label4417;
              }
              ((an.a)localObject2).sGR.setText(((v)localObject1).lpM);
              ((an.a)localObject2).sGR.setVisibility(0);
              ((an.a)localObject2).sEi.setVisibility(0);
              parama = ((d)parama1.bC(d.class)).bzf(((v)localObject1).url);
              if (TextUtils.isEmpty(parama)) {
                break label4430;
              }
              Log.d("MicroMsg.ChattingItemBizFrom", "productId:%s", new Object[] { parama });
              parama = new by(paramca, false, paramInt, ((v)localObject1).url, this.Xil, parama1.hOp(), localu.fUd, localu.fUe, ((v)localObject1).title, parama, null, false, true);
              ((an.a)localObject2).sEi.setOnClickListener(i(parama1));
              label1261:
              parama.PVT = paramca.field_msgSvrId;
              parama.PVU = i;
              parama.XmP = ((v)localObject1).type;
              ((an.a)localObject2).sEi.setTag(parama);
              if (com.tencent.mm.aj.m.OS(((v)localObject1).lpP)) {
                a((v)localObject1, ((an.a)localObject2).sEi);
              }
              a((v)localObject1, ((an.a)localObject2).sEi, paramca.field_msgId, paramca.field_msgSvrId, i);
              ((an.a)localObject2).sEi.setOnLongClickListener(c(parama1));
              ((an.a)localObject2).sEi.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bC(com.tencent.mm.ui.chatting.d.b.k.class)).hNO());
              if (((v)localObject1).type != 8) {
                break label4503;
              }
              ((an.a)localObject2).sHS.setImageResource(R.k.biz_time_line_pic_icon);
              ((an.a)localObject2).sHS.setVisibility(0);
              if (((v)localObject1).lqa <= 1) {
                break label4490;
              }
              ((an.a)localObject2).XhX.setVisibility(0);
              ((an.a)localObject2).XhX.setText(String.valueOf(((v)localObject1).lqa));
            }
          }
          label1153:
          break;
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label763;
      localc.XhZ.sDe.aL(paramString.title);
      localc.XhZ.sDe.getPaint().setFakeBoldText(true);
      localc.XhZ.sDe.setVisibility(0);
      localc.XhZ.sDe.setTextColor(this.WBq.WQv.getContext().getResources().getColor(R.e.light_grey_text_color));
      break;
      label1523:
      localc.XhZ.sDf.setBackgroundResource(R.g.dnh);
      break label571;
      label1540:
      localc.XhZ.timeTv.setVisibility(8);
      break label641;
      label1556:
      bool = false;
      break label704;
      label1562:
      localc.XhZ.sDe.setMaxLines(2);
      break label760;
      if (paramString.type == 8)
      {
        Y(localc.Xia.sDp, Xik);
        Y(localc.Xia.sDf, Xik);
        if ((j > 1) || (!Util.isNullOrNil(paramString.lpM)))
        {
          bool = true;
          label1635:
          if (bool) {
            break label1840;
          }
          localc.Xia.sDf.setBackgroundResource(R.g.dng);
          label1654:
          if (paramString.lqa <= 1) {
            break label1857;
          }
          localc.Xia.XhX.setVisibility(0);
          localc.Xia.XhX.setText(String.valueOf(paramString.lqa));
          label1694:
          if ((Util.isNullOrNil(paramString.lpM)) || (j != 1)) {
            break label1873;
          }
          localc.Xia.Xif.setVisibility(0);
          localc.Xia.Xie.aL(paramString.lpM);
          localc.Xia.Xif.setBackgroundResource(R.g.dmm);
        }
        for (;;)
        {
          localc.Xia.sCT.setVisibility(8);
          parama = paramString.lpK;
          localObject1 = localc.Xia.sCR;
          paramca.getType();
          a(parama, (ImageView)localObject1, bool, Xik, new m.a()
          {
            public final void onFinish()
            {
              AppMethodBeat.i(37145);
              localc.Xia.sCT.setVisibility(0);
              localc.Xia.bwJ.setImageResource(R.k.biz_time_line_pic_icon);
              ImageView localImageView = localc.Xia.sCT;
              if (bool) {}
              for (int i = R.g.dmA;; i = R.g.dmB)
              {
                localImageView.setBackgroundResource(i);
                AppMethodBeat.o(37145);
                return;
              }
            }
            
            public final void onStart() {}
          });
          a(paramString, paramca, paramInt, localu, localc.Xia.sEi);
          break;
          bool = false;
          break label1635;
          label1840:
          localc.Xia.sDf.setBackgroundResource(R.g.dnh);
          break label1654;
          label1857:
          localc.Xia.XhX.setVisibility(8);
          break label1694;
          label1873:
          localc.Xia.Xif.setVisibility(8);
        }
      }
      if (paramString.type == 7)
      {
        if (Util.isNullOrNil(paramString.title))
        {
          localc.Xib.jMg.setVisibility(8);
          label1923:
          if (j <= 1) {
            break label2170;
          }
          localc.Xib.sEi.setBackgroundResource(R.g.chatting_item_multi_top);
          label1943:
          parama = com.tencent.mm.aj.m.uD(paramString.lpO);
          if (TextUtils.isEmpty(parama)) {
            break label2187;
          }
          localc.Xib.sGk.setVisibility(0);
          localc.Xib.sGk.setText(parama);
          label1983:
          parama = localc.Xib.sGV.getDrawable();
          if (((parama instanceof AnimationDrawable)) && (((AnimationDrawable)parama).isRunning())) {
            ((AnimationDrawable)parama).stop();
          }
          if (!(paramca.field_msgId + "_0_msg").equals(localc.playingMsgId)) {
            break label2202;
          }
          localc.Xib.sGV.setImageResource(R.g.dmz);
          if ((localc.Xib.sGV.getDrawable() instanceof AnimationDrawable)) {
            ((AnimationDrawable)localc.Xib.sGV.getDrawable()).start();
          }
        }
        for (;;)
        {
          a(localc.Xib.sGV, paramca, 0);
          a(paramString, paramca, paramInt, localu, localc.Xib.sEi);
          break;
          localc.Xib.jMg.setVisibility(0);
          localc.Xib.jMg.setText(paramString.title);
          break label1923;
          label2170:
          localc.Xib.sEi.setBackgroundResource(R.g.white_corner_bg_selector);
          break label1943;
          label2187:
          localc.Xib.sGk.setVisibility(4);
          break label1983;
          label2202:
          localc.Xib.sGV.setImageResource(R.g.dmy);
        }
      }
      if (paramString.type == 6)
      {
        localObject1 = (v)localLinkedList.get(0);
        if (Util.isNullOrNil(((v)localObject1).title))
        {
          localc.Xic.jMg.setVisibility(8);
          label2266:
          if (j <= 1) {
            break label2538;
          }
          localc.Xic.sEi.setBackgroundResource(R.g.chatting_item_multi_top);
          label2286:
          if (TextUtils.isEmpty(((v)localObject1).lpY)) {
            break label2555;
          }
          localc.Xic.sHM.setVisibility(0);
          localc.Xic.sHM.setText(((v)localObject1).lpY);
          label2325:
          if (((v)localObject1).lpZ != 2) {
            break label2571;
          }
          localc.Xic.sHN.setImageResource(R.k.chatting_item_biz_kugou_music_watermark);
          label2348:
          a(localc.Xic.sGV, paramca, 0);
          a((v)localObject1, paramca, paramInt, localu, localc.Xic.sEi);
          if (!(paramca.field_msgId + "_0_msg").equals(localc.playingMsgId)) {
            break label2588;
          }
          localc.Xic.sGV.setImageResource(R.k.chatting_item_biz_music_pause_loading_icon);
        }
        for (;;)
        {
          localc.Xic.sCT.setVisibility(8);
          parama = new WeakReference(localc);
          localObject1 = ((v)localObject1).lpK;
          localObject2 = localc.Xic.sCR;
          paramca.getType();
          i = sAs;
          a((String)localObject1, (ImageView)localObject2, i, i, new m.a()
          {
            public final void onFinish()
            {
              AppMethodBeat.i(37144);
              an.c localc = (an.c)parama.get();
              if (localc == null)
              {
                AppMethodBeat.o(37144);
                return;
              }
              localc.Xic.sCT.setVisibility(0);
              if ((paramca.field_msgId + "_0_msg").equals(localc.playingMsgId))
              {
                localc.Xic.sGV.setImageResource(R.g.chatting_item_biz_music_pause_selector);
                AppMethodBeat.o(37144);
                return;
              }
              localc.Xic.sGV.setImageResource(R.g.chatting_item_biz_music_play_selector);
              AppMethodBeat.o(37144);
            }
            
            public final void onStart() {}
          });
          break;
          localc.Xic.jMg.setVisibility(0);
          localc.Xic.jMg.setText(((v)localObject1).title);
          break label2266;
          label2538:
          localc.Xic.sEi.setBackgroundResource(R.g.white_corner_bg_selector);
          break label2286;
          label2555:
          localc.Xic.sHM.setVisibility(8);
          break label2325;
          label2571:
          localc.Xic.sHN.setImageResource(R.k.chatting_item_biz_qq_music_watermark);
          break label2348;
          label2588:
          localc.Xic.sGV.setImageResource(R.k.chatting_item_biz_music_play_loading_icon);
        }
      }
      if (paramString.type == 10)
      {
        if (Util.isNullOrNil(paramString.title))
        {
          localc.Xid.sDe.setVisibility(8);
          if (j <= 1) {
            break label3114;
          }
          localc.Xid.sEi.setBackgroundResource(R.g.chatting_item_multi_top);
        }
        for (;;)
        {
          a(paramString, paramca, paramInt, localu, localc.Xid.sEi);
          break;
          localc.Xid.sDe.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.h(localc.Xid.sDe, new com.tencent.mm.pluginsdk.ui.span.o(this.WBq.WQv.getContext())));
          localc.Xid.sDe.setVisibility(0);
          localc.Xid.sDe.aL(l.k(this.WBq.WQv.getContext(), paramString.title, (int)localc.Xid.sDe.getTextSize()));
          parama = com.tencent.mm.plugin.bizui.a.a.shG;
          i = com.tencent.mm.plugin.bizui.a.a.eO(this.WBq.WQv.getContext());
          k = (int)(com.tencent.mm.ci.a.getDensity(this.WBq.WQv.getContext()) * 80.0F);
          parama = localc.Xid.sDe.nH(i - k, 2147483647);
          if (parama != null) {}
          for (i = parama.ikp();; i = 0)
          {
            parama = (LinearLayout.LayoutParams)localc.Xid.sDe.getLayoutParams();
            localObject1 = (LinearLayout.LayoutParams)localc.Xid.Xii.getLayoutParams();
            if (i > 3) {
              break label2950;
            }
            localc.Xid.Xih.setVisibility(8);
            ((LinearLayout.LayoutParams)localObject1).gravity = 16;
            localc.Xid.Xii.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            parama.topMargin = 0;
            parama.gravity = 17;
            localc.Xid.sDe.setLayoutParams(parama);
            break;
          }
          label2950:
          if (paramString.lqd == 1)
          {
            i = 1;
            label2962:
            localc.Xid.Xih.setVisibility(0);
            ((LinearLayout.LayoutParams)localObject1).gravity = 48;
            localc.Xid.Xii.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            parama.topMargin = com.tencent.mm.ci.a.fromDPToPix(this.WBq.WQv.getContext(), 38);
            parama.gravity = 8388627;
            if (i == 0) {
              break label3085;
            }
            localc.Xid.sDe.setMaxLines(2147483647);
            localc.Xid.Xih.setText(R.l.esP);
          }
          for (;;)
          {
            localc.Xid.Xih.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(37146);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bn(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                if (paramString.lqd == 1)
                {
                  localc.Xid.sDe.setMaxLines(3);
                  localc.Xid.Xih.setText(R.l.esQ);
                }
                for (paramString.lqd = 0;; paramString.lqd = 1)
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(37146);
                  return;
                  localc.Xid.sDe.setMaxLines(2147483647);
                  localc.Xid.Xih.setText(R.l.esP);
                }
              }
            });
            break;
            i = 0;
            break label2962;
            label3085:
            localc.Xid.sDe.setMaxLines(3);
            localc.Xid.Xih.setText(R.l.esQ);
          }
          label3114:
          localc.Xid.sEi.setBackgroundResource(R.g.white_corner_bg_selector);
        }
      }
      parama = localc.XhY.sDe;
      if (j > 1)
      {
        i = 8;
        label3150:
        parama.setVisibility(i);
        parama = localc.XhY.Xig;
        if ((j <= 1) && (!Util.isNullOrNil(paramString.lpM))) {
          break label3550;
        }
        i = 8;
        label3186:
        parama.setVisibility(i);
        parama = localc.XhY.HyN;
        if (j <= 1) {
          break label3556;
        }
      }
      label3550:
      label3556:
      for (i = 0;; i = 8)
      {
        parama.setVisibility(i);
        localc.XhY.HyO.setVisibility(8);
        if (j != 1) {
          break label3563;
        }
        localc.XhY.sDf.setBackgroundResource(R.g.dng);
        localc.XhY.neN.setVisibility(0);
        Y(localc.XhY.sDp, HyD);
        Y(localc.XhY.sDf, HyD);
        if (Util.isNullOrNil(paramString.lpK)) {
          break label3675;
        }
        localc.XhY.sDp.setVisibility(0);
        parama = paramString.lpK;
        localObject1 = localc.XhY.sCR;
        paramca.getType();
        a(parama, (ImageView)localObject1, true, HyD, new m.a()
        {
          public final void onFinish()
          {
            AppMethodBeat.i(37142);
            if (j > 1)
            {
              localc.XhY.HyN.setTextColor(an.j.a(an.j.this).WQv.getContext().getResources().getColor(R.e.white_text_color));
              localc.XhY.HyN.setBackgroundResource(R.g.biz_msg_cover_gradient_mask);
            }
            localc.XhY.HyO.setVisibility(0);
            AppMethodBeat.o(37142);
          }
          
          public final void onStart() {}
        });
        localc.XhY.neN.setBackgroundResource(R.g.chatting_item_multbg_bottom_normal);
        parama = localc.XhY.neN;
        i = sAt;
        k = sAu;
        int m = sAt;
        parama.setPadding(i, k, m, m);
        localc.XhY.sDf.setVisibility(0);
        localc.XhY.Xig.setMaxLines(30);
        localc.XhY.Xig.setText(paramString.lpM);
        com.tencent.mm.plugin.brandservice.b.b.svR.a(paramString.title, localc.XhY.sDe, paramString, 2);
        com.tencent.mm.plugin.brandservice.b.b.svR.a(paramString.title, localc.XhY.HyN, paramString, 21);
        if ((paramString.lpN != 0) && (paramString.lpN != 1)) {
          localc.XhY.HyN.setVisibility(4);
        }
        a(paramString, paramca, paramInt, localu, localc.XhY.sEi);
        break;
        i = 0;
        break label3150;
        i = 0;
        break label3186;
      }
      label3563:
      parama = localc.XhY.neN;
      if (Util.isNullOrNil(paramString.lpK)) {}
      for (i = 0;; i = 8)
      {
        parama.setVisibility(i);
        localc.XhY.sDf.setBackgroundResource(R.g.dnh);
        localc.XhY.HyN.setTextColor(this.WBq.WQv.getContext().getResources().getColor(R.e.light_grey_text_color));
        localc.XhY.HyN.setBackgroundResource(R.g.mm_trans);
        localc.XhY.HyN.getPaint().setFakeBoldText(true);
        break;
      }
      label3675:
      localc.XhY.Xig.setMaxLines(100);
      localc.XhY.sDp.setVisibility(8);
      localc.XhY.sDe.setVisibility(0);
      parama = localc.XhY.Xig;
      if (Util.isNullOrNil(paramString.lpM))
      {
        i = 8;
        label3737:
        parama.setVisibility(i);
        if (j != 1) {
          break label3816;
        }
        localc.XhY.neN.setBackgroundResource(R.g.white_corner_bg_selector);
      }
      for (;;)
      {
        parama = localc.XhY.neN;
        i = sAt;
        k = sAt;
        parama.setPadding(i, i, k, k);
        localc.XhY.sDf.setVisibility(8);
        break;
        i = 0;
        break label3737;
        label3816:
        localc.XhY.neN.setBackgroundResource(R.g.chatting_item_multi_top);
      }
      label3833:
      ((an.a)localObject2).mrE.setVisibility(8);
      break label884;
      label3846:
      ((an.a)localObject2).mrE.setVisibility(0);
      if (i <= 1) {
        break label873;
      }
      parama = (v)localLinkedList.get(i - 1);
      localObject3 = (v)localLinkedList.get(i);
      if (((parama.type != 7) && (parama.type != 5) && (parama.type != 6) && (Util.isNullOrNil(parama.lpK))) || ((((v)localObject3).type != 7) && (((v)localObject3).type != 5) && (((v)localObject3).type != 6) && (Util.isNullOrNil(((v)localObject3).lpK))))
      {
        Z(((an.a)localObject2).mrE, sAt);
        break label884;
      }
      Z(((an.a)localObject2).mrE, sAx);
      break label884;
      label3994:
      ((an.a)localObject2).vpA.setPadding(0, sAt, 0, sAv);
      break label915;
      label4013:
      if (i == j - 1)
      {
        ((an.a)localObject2).vpA.setPadding(0, sAv, 0, sAt);
        break label915;
      }
      ((an.a)localObject2).vpA.setPadding(0, sAv, 0, sAv);
      break label915;
      parama = parama.getResources().getString(R.l.euD);
      break label1027;
      parama = parama.getResources().getString(R.l.euE);
      break label1027;
      parama = parama.getResources().getString(R.l.euw);
      break label1027;
      label4102:
      com.tencent.mm.plugin.brandservice.b.b.svR.a(((v)localObject1).title, ((an.a)localObject2).sDe, (v)localObject1, 3);
      break label1041;
      Object localObject4;
      Object localObject5;
      if (!Util.isNullOrNil(((v)localObject1).lpK))
      {
        ((an.a)localObject2).sCR.setVisibility(0);
        localObject3 = new WeakReference(localc);
        localObject4 = new WeakReference(localObject2);
        if (Util.isNullOrNil(((v)localObject1).lqb)) {}
        for (parama = ((v)localObject1).lpK;; parama = ((v)localObject1).lqb)
        {
          localObject5 = ((an.a)localObject2).sCR;
          paramca.getType();
          k = sAs;
          a(parama, (ImageView)localObject5, k, k, new m.a()
          {
            public final void onFinish()
            {
              AppMethodBeat.i(37141);
              if ((this.Xin.get() != null) && (this.Xio.get() != null)) {
                an.j.a(an.j.this, (an.c)this.Xin.get(), (an.a)this.Xio.get(), this.sHy, paramca, i);
              }
              AppMethodBeat.o(37141);
            }
            
            public final void onStart() {}
          });
          break;
        }
      }
      if ((((v)localObject1).type == 5) || (((v)localObject1).type == 6))
      {
        ((an.a)localObject2).sCR.setVisibility(0);
        parama = R.g.chatting_item_biz_play_icon_bg;
        localObject3 = ((an.a)localObject2).sCR;
        k = sAs;
        localObject4 = q.bml();
        localObject5 = new com.tencent.mm.ay.a.a.c.a();
        ((com.tencent.mm.ay.a.a.c.a)localObject5).lRB = true;
        ((com.tencent.mm.ay.a.a.c.a)localObject5).lRP = R.e.chatting_item_biz_default_bg;
        localObject5 = ((com.tencent.mm.ay.a.a.c.a)localObject5).dO(k, k);
        ((com.tencent.mm.ay.a.a.c.a)localObject5).lRG = 4;
        ((com.tencent.mm.ay.a.a)localObject4).a(parama, (ImageView)localObject3, ((com.tencent.mm.ay.a.a.c.a)localObject5).bmL(), null, new com.tencent.mm.pluginsdk.ui.applet.m());
        break label1111;
      }
      ((an.a)localObject2).sGS.setVisibility(8);
      break label1111;
      ((an.a)localObject2).sGS.setVisibility(8);
      ((an.a)localObject2).sDe.setTextColor(parama1.WQv.getContext().getResources().getColor(R.e.FG_2));
      break label1111;
      label4417:
      ((an.a)localObject2).sGR.setVisibility(8);
      break label1153;
      label4430:
      parama = new by(paramca, false, paramInt, ((v)localObject1).url, this.Xil, parama1.hOp(), localu.fUd, localu.fUe);
      a(parama, (v)localObject1, paramca);
      ((an.a)localObject2).sEi.setOnClickListener(h(parama1));
      break label1261;
      label4490:
      ((an.a)localObject2).XhX.setVisibility(8);
      continue;
      label4503:
      ((an.a)localObject2).sHS.setVisibility(8);
      ((an.a)localObject2).XhX.setVisibility(8);
    }
    label4526:
    if (((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).Gw(2))
    {
      paramInt = 0;
      while (paramInt < localLinkedList.size())
      {
        parama = (v)localLinkedList.get(paramInt);
        if (!TextUtils.isEmpty(parama.url))
        {
          ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).a(parama.url, parama.type, 0, new Object[0]);
          if ((parama.lls == 1) && (((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).cyB())) {
            ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).cY(parama.url, parama.type);
          }
          ((f)com.tencent.mm.kernel.h.ae(f.class)).a(parama.url, 0, null, parama.title, parama.lpM, null, 2);
        }
        paramInt += 1;
      }
    }
    AppMethodBeat.o(37152);
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(37166);
    this.sHA = Util.nowSecond();
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(37166);
      return false;
      paramMenuItem = bs.T(paramca);
      if (Util.isNullOrNil(paramMenuItem))
      {
        e(parama, paramca);
      }
      else
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
        com.tencent.mm.ui.base.h.a(parama.WQv.getContext(), R.l.eRO, R.l.eRP, R.l.app_view_detail, R.l.ewL, true, new an.j.9(this, paramMenuItem, parama), new an.j.10(this, parama, paramca, paramMenuItem));
        continue;
        paramMenuItem = a(paramca, parama.WQv.getContext(), 0);
        if (!Util.isNullOrNil(paramMenuItem))
        {
          an.c(paramca, paramMenuItem, parama.WQv.getContext());
          continue;
          s.a(this.sHA, this.Xim, parama.WQv.getContext(), parama.WQv, null, paramca);
          continue;
          paramMenuItem = new Intent();
          paramMenuItem.putExtra("Chat_Msg_Id", paramca.field_msgId);
          com.tencent.mm.by.c.b(parama.WQv.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
        }
      }
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(277163);
    Object localObject = (by)paramView.getTag();
    if (localObject == null)
    {
      AppMethodBeat.o(277163);
      return false;
    }
    this.Xim = ((by)localObject).PVU;
    int i = ((by)localObject).position;
    localObject = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class)).b(paramca.field_msgId, paramca.field_content);
    if (localObject == null)
    {
      Log.w("MicroMsg.ChattingItemBizFrom", "onCreateContextMenu reader is null");
      AppMethodBeat.o(277163);
      return false;
    }
    this.sHB = false;
    if ((this.Xim >= 0) && (this.Xim < ((u)localObject).lpz.size()) && (com.tencent.mm.aj.m.OS(((v)((u)localObject).lpz.get(this.Xim)).lpP))) {
      this.sHB = true;
    }
    if ((!this.WBq.hRj()) && (!com.tencent.mm.ui.chatting.k.bK(paramca))) {
      paramo.a(i, 111, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
    }
    if ((com.tencent.mm.by.c.blP("favorite")) && (!this.sHB)) {
      paramo.a(i, 126, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
    }
    if ((BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())) {
      paramo.a(i, 144, paramView.getContext().getString(R.l.menu_show_app_msg_content), R.k.fix_tools_entry);
    }
    paramo.a(i, 100, this.WBq.WQv.getMMResources().getString(R.l.evO), R.k.icons_filled_delete);
    AppMethodBeat.o(277163);
    return true;
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return paramInt == 285212721;
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean hTD()
  {
    return false;
  }
  
  protected final boolean hTE()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.an.j
 * JD-Core Version:    0.7.0.1
 */