package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.i;
import com.tencent.mm.ae.l;
import com.tencent.mm.ae.m;
import com.tencent.mm.as.o;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.applet.e.a;
import com.tencent.mm.pluginsdk.ui.applet.f;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.ao;
import com.tencent.mm.ui.chatting.aq;
import com.tencent.mm.ui.chatting.k;
import com.tencent.mm.ui.chatting.s;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeatTextView;
import com.tencent.mm.ui.x;
import com.tencent.neattextview.textview.layout.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class r$j
  extends c
{
  private static int ieH;
  private static int ieI = 0;
  private static int ieJ;
  private static int ieK = 0;
  private static int ieL;
  private static int noY;
  private boolean ieS = false;
  private long ieT = 0L;
  private boolean vDE = false;
  private int vDF = 0;
  private com.tencent.mm.ui.chatting.c.a vko;
  
  static
  {
    ieJ = 0;
  }
  
  private static void E(View paramView, int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.rightMargin = paramInt;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private static String a(bi parambi, Context paramContext, int paramInt)
  {
    if (paramContext == null)
    {
      y.w("MicroMsg.ChattingItemBizFrom", "getReaderAppMsgContent: context is null");
      return null;
    }
    if (parambi == null)
    {
      y.w("MicroMsg.ChattingItemBizFrom", "getReaderAppMsgContent: msg is null");
      return null;
    }
    return i.a(paramContext, paramInt, parambi.field_content, parambi.field_talker, parambi.field_msgId);
  }
  
  private static void a(View paramView, r.b paramb, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramb.ifA == null) {
        paramb.cC(paramView);
      }
      if (paramb.ifA != null) {
        paramb.ifA.setVisibility(0);
      }
    }
    while (paramb.ifA == null) {
      return;
    }
    paramb.ifA.setVisibility(8);
  }
  
  private void a(ImageView paramImageView, bi parambi, int paramInt)
  {
    d.f localf = new d.f();
    localf.bIt = parambi.field_msgId;
    localf.vCm = paramInt;
    localf.bUr = parambi.field_content;
    paramImageView.setTag(localf);
    paramImageView.setOnClickListener(((com.tencent.mm.ui.chatting.b.b.g)this.vko.ac(com.tencent.mm.ui.chatting.b.b.g.class)).cDv());
  }
  
  private void a(m paramm, View paramView)
  {
    s.a(paramm, paramView, this.vko.getTalkerUserName());
  }
  
  private void a(m paramm, bi parambi, int paramInt, l paraml, View paramView)
  {
    String str = ((com.tencent.mm.ui.chatting.b.b.c)this.vko.ac(com.tencent.mm.ui.chatting.b.b.c.class)).adq(paramm.url);
    if (!TextUtils.isEmpty(str))
    {
      y.d("MicroMsg.ChattingItemBizFrom", "productId:%s", new Object[] { str });
      paraml = new aw(parambi, false, paramInt, paramm.url, false, this.vko.cDP(), paraml.bYG, paraml.bYH, paramm.title, str, null, false, false);
      paramView.setOnClickListener(h(this.vko));
    }
    for (;;)
    {
      paraml.rgL = parambi.field_msgSvrId;
      paraml.rgM = 0;
      paramView.setTag(paraml);
      if (i.gr(paramm.dTI)) {
        a(paramm, paramView);
      }
      paramView.setOnLongClickListener(c(this.vko));
      paramView.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g)this.vko.ac(com.tencent.mm.ui.chatting.b.b.g.class)).cDu());
      return;
      paraml = new aw(parambi, false, paramInt, paramm.url, false, this.vko.cDP(), paraml.bYG, paraml.bYH, paramm.title);
      a(paraml, paramm, parambi);
      paramView.setOnClickListener(g(this.vko));
    }
  }
  
  private void a(aw paramaw, m paramm, bi parambi)
  {
    Bundle localBundle = new Bundle();
    int i;
    switch (com.tencent.mm.model.t.R(b(this.vko, parambi), this.vko.getTalkerUserName()))
    {
    case 3: 
    case 4: 
    case 5: 
    default: 
      i = 0;
    }
    for (;;)
    {
      localBundle.putString("share_report_pre_msg_url", paramm.url);
      localBundle.putString("share_report_pre_msg_title", paramm.title);
      localBundle.putString("share_report_pre_msg_desc", paramm.dTF);
      localBundle.putString("share_report_pre_msg_icon_url", paramm.dTD);
      localBundle.putString("share_report_pre_msg_appid", "");
      localBundle.putInt("share_report_from_scene", i);
      if (i == 5) {
        localBundle.putString("share_report_biz_username", this.vko.getTalkerUserName());
      }
      paramaw.vHq = localBundle;
      return;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 5;
    }
  }
  
  private static void a(r.c paramc, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramInt1 == 5)
    {
      bool1 = true;
      a(paramc.ifV, paramc.vDz, bool1);
      if (!bool1) {
        break label220;
      }
    }
    label40:
    label69:
    label203:
    label215:
    label220:
    for (int i = 1;; i = 0)
    {
      if (paramInt1 == 8)
      {
        bool1 = true;
        a(paramc.ifV, paramc.vDA, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 7) {
          break label191;
        }
        bool1 = true;
        a(paramc.ifV, paramc.vDB, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 6) {
          break label197;
        }
        bool1 = true;
        label98:
        a(paramc.ifV, paramc.vDC, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 10) {
          break label203;
        }
        bool1 = true;
        label127:
        a(paramc.ifV, paramc.vDD, bool1);
        if (!bool1) {
          break label215;
        }
      }
      for (paramInt1 = 1;; paramInt1 = i)
      {
        LinearLayout localLinearLayout = paramc.ifV;
        paramc = paramc.vDy;
        if ((paramInt1 == 0) && (paramInt2 > 0)) {}
        for (bool1 = bool2;; bool1 = false)
        {
          a(localLinearLayout, paramc, bool1);
          return;
          bool1 = false;
          break;
          bool1 = false;
          break label40;
          bool1 = false;
          break label69;
          bool1 = false;
          break label98;
          bool1 = false;
          break label127;
        }
      }
    }
  }
  
  private void a(r.c paramc, r.a parama, m paramm, bi parambi, int paramInt, boolean paramBoolean)
  {
    if (paramm.type == 5)
    {
      parama.ifH.setVisibility(0);
      parama.ifH.setImageResource(R.g.biz_msg_video_play_icon);
      parama.ifH.setOnClickListener(new r.j.6(this, parama));
    }
    for (;;)
    {
      paramInt = com.tencent.mm.cb.a.fromDPToPix(this.vko.vtz.getContext(), 26);
      if (paramm.type == 7) {
        paramInt = com.tencent.mm.cb.a.fromDPToPix(this.vko.vtz.getContext(), 32);
      }
      paramc = parama.ifH;
      parama = paramc.getLayoutParams();
      parama.width = paramInt;
      parama.height = paramInt;
      paramc.setLayoutParams(parama);
      return;
      Object localObject;
      if (paramm.type == 6)
      {
        parama.ifH.setVisibility(0);
        if (paramBoolean) {
          if ((parambi.field_msgId + "_" + paramInt).equals(paramc.vBb)) {
            parama.ifH.setImageResource(R.g.chatting_item_biz_music_pause_selector);
          }
        }
        for (;;)
        {
          paramc = parama.ifH;
          localObject = paramm.dTD;
          a(paramc, parambi, paramInt);
          break;
          parama.ifH.setImageResource(R.g.chatting_item_biz_music_play_selector);
          continue;
          if ((parambi.field_msgId + "_" + paramInt).equals(paramc.vBb)) {
            parama.ifH.setImageResource(R.k.chatting_item_biz_music_pause_loading_icon);
          } else {
            parama.ifH.setImageResource(R.k.chatting_item_biz_music_play_loading_icon);
          }
        }
      }
      if (paramm.type == 7)
      {
        parama.ifH.setVisibility(0);
        localObject = parama.ifH.getDrawable();
        if (((localObject instanceof AnimationDrawable)) && (((AnimationDrawable)localObject).isRunning())) {
          ((AnimationDrawable)localObject).stop();
        }
        if ((parambi.field_msgId + "_" + paramInt).equals(paramc.vBb))
        {
          parama.ifH.setImageResource(R.g.chatting_item_biz_voice_playing_selector);
          if ((parama.ifH.getDrawable() instanceof AnimationDrawable)) {
            ((AnimationDrawable)parama.ifH.getDrawable()).start();
          }
        }
        for (;;)
        {
          paramc = parama.ifH;
          localObject = paramm.dTD;
          a(paramc, parambi, paramInt);
          break;
          parama.ifH.setImageResource(R.g.chatting_item_biz_voice_play_selector);
        }
      }
      parama.ifH.setVisibility(8);
    }
  }
  
  private static void a(String paramString1, ImageView paramImageView, int paramInt1, int paramInt2, int paramInt3, String paramString2, e.a parama)
  {
    if (com.tencent.mm.as.q.OQ()) {
      paramString1 = com.tencent.mm.as.q.mo(paramString1);
    }
    for (;;)
    {
      com.tencent.mm.as.a.a locala = o.ON();
      com.tencent.mm.as.a.a.c.a locala1 = new com.tencent.mm.as.a.a.c.a();
      locala1.ery = R.e.chatting_item_biz_default_bg;
      locala1.erf = true;
      locala1 = locala1.bn(paramInt2, paramInt3);
      locala1.eqU = new f();
      locala1.erh = com.tencent.mm.pluginsdk.model.q.y(paramString1, paramInt1, paramString2);
      locala.a(paramString1, paramImageView, locala1.OV(), null, new com.tencent.mm.pluginsdk.ui.applet.e(0, 0, 0, parama));
      return;
    }
  }
  
  private void a(String paramString, ImageView paramImageView, int paramInt1, boolean paramBoolean, int paramInt2, e.a parama)
  {
    if (com.tencent.mm.as.q.OQ()) {
      paramString = com.tencent.mm.as.q.mo(paramString);
    }
    for (;;)
    {
      int i;
      int j;
      if (paramBoolean)
      {
        i = R.g.biz_bg_top_rounded_mask;
        if (!paramBoolean) {
          break label195;
        }
        j = R.g.biz_item_cover_top_round_bg;
        label31:
        if (!((com.tencent.mm.ui.chatting.b.b.g)this.vko.ac(com.tencent.mm.ui.chatting.b.b.g.class)).isInEditMode()) {
          break label203;
        }
      }
      label195:
      label203:
      for (int k = 72;; k = 32)
      {
        int m = com.tencent.mm.cb.a.fj(paramImageView.getContext());
        float f = com.tencent.mm.cb.a.getDensity(paramImageView.getContext());
        k = m - (int)(k * f);
        com.tencent.mm.as.a.a locala = o.ON();
        com.tencent.mm.as.a.a.c.a locala1 = new com.tencent.mm.as.a.a.c.a();
        locala1.ery = j;
        locala1.erf = true;
        locala1.erA = String.valueOf(i);
        locala1 = locala1.bn(k, paramInt2);
        locala1.eqU = new f();
        locala1.erh = com.tencent.mm.pluginsdk.model.q.y(paramString, paramInt1, "@T");
        locala.a(paramString, paramImageView, locala1.OV(), null, new com.tencent.mm.pluginsdk.ui.applet.e(i, k, paramInt2, parama));
        return;
        i = R.g.biz_bg_rounded_mask;
        break;
        j = R.g.biz_item_cover_round_bg;
        break label31;
      }
    }
  }
  
  private static void cB(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = noY;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private static void gU(Context paramContext)
  {
    int i;
    int j;
    if (ieK == 0)
    {
      ieK = paramContext.getResources().getDimensionPixelSize(R.f.SmallPadding);
      ieJ = paramContext.getResources().getDimensionPixelSize(R.f.MiddlePadding);
      ieI = paramContext.getResources().getDimensionPixelSize(R.f.LargePadding);
      ieH = paramContext.getResources().getDimensionPixelSize(R.f.chatting_item_biz_sub_item_pic_size);
      ieL = paramContext.getResources().getDimensionPixelSize(R.f.chatting_item_biz_line_big_padding);
      i = com.tencent.mm.cb.a.fj(paramContext);
      j = com.tencent.mm.cb.a.fk(paramContext);
      if (i >= j) {
        break label107;
      }
    }
    for (;;)
    {
      noY = (int)((i - (int)(com.tencent.mm.cb.a.getDensity(paramContext) * 32.0F)) / 2.35D);
      return;
      label107:
      i = j;
    }
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new t(paramLayoutInflater, R.i.chatting_item_biz);
      paramView = new r.c();
      paramView.dsz = ((TextView)((View)localObject).findViewById(R.h.chatting_time_tv));
      paramView.vAZ = ((View)localObject).findViewById(R.h.chatting_histroy_msg_tip);
      paramView.ifV = ((LinearLayout)((View)localObject).findViewById(R.h.chatting_content_ll));
      paramView.khV = ((CheckBox)((View)localObject).findViewById(R.h.chatting_checkbox));
      paramView.hoY = ((View)localObject).findViewById(R.h.chatting_maskview);
      paramView.vBz = ((TextView)((View)localObject).findViewById(R.h.chatting_appmsg_comment_tv));
      ((View)localObject).setTag(paramView);
    }
    gU(paramLayoutInflater.getContext());
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.c.a parama1, bi parambi, String paramString)
  {
    this.vko = parama1;
    gU(parama1.vtz.getContext());
    r.c localc = (r.c)parama;
    parama = localc.ifY.iterator();
    if (parama.hasNext())
    {
      paramString = (r.a)parama.next();
      if (localc.ifY.indexOf(paramString) != localc.ifY.size() - 1) {
        aq.U(paramString.ifA, 1);
      }
      for (;;)
      {
        localc.ifV.removeView(paramString.ifA);
        break;
        aq.U(paramString.ifA, 2);
      }
    }
    localc.ifY.clear();
    l locall = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.biz.a.a.class)).d(parambi.field_msgId, parambi.field_content);
    parama = locall.cQF;
    if ((parama == null) || (parama.length() == 0)) {
      localc.vBz.setVisibility(8);
    }
    LinkedList localLinkedList;
    int j;
    for (;;)
    {
      localLinkedList = locall.dTx;
      j = localLinkedList.size();
      if (j != 0) {
        break;
      }
      localc.ifV.setVisibility(8);
      a(localc, -1, 0);
      return;
      localc.vBz.setVisibility(0);
      b(parama1, localc.vBz, aw.adO(parama));
    }
    localc.ifV.setVisibility(0);
    a(localc, ((m)localLinkedList.get(0)).type, j);
    Object localObject1 = parama1.vtz.getActivityLayoutInflater();
    int i = localc.ifY.size() + 2;
    while (i < j)
    {
      paramString = aq.GV(1);
      parama = paramString;
      if (paramString == null) {
        parama = ((LayoutInflater)localObject1).inflate(R.i.chatting_item_biz_slot, null);
      }
      localc.dW(parama);
      i += 1;
    }
    if (j > 1)
    {
      paramString = aq.GV(2);
      parama = paramString;
      if (paramString == null) {
        parama = ((LayoutInflater)localObject1).inflate(R.i.chatting_item_biz_slot_bottom, null);
      }
      localc.dW(parama);
    }
    for (this.vDE = true;; this.vDE = false)
    {
      i = 0;
      while (i < localc.ifY.size())
      {
        ((r.a)localc.ifY.get(i)).ifA.setVisibility(8);
        i += 1;
      }
    }
    paramString = (m)localLinkedList.get(0);
    label512:
    label546:
    boolean bool;
    label610:
    label637:
    Object localObject2;
    int k;
    if (paramString.type == 5)
    {
      cB(localc.vDz.igj);
      cB(localc.vDz.ifM);
      if (ah.bl(paramString.title))
      {
        localc.vDz.ifS.setVisibility(8);
        if (j != 1) {
          break label1216;
        }
        localc.vDz.ifL.setBackgroundResource(R.g.biz_video_msg_cover_round_mask);
        localc.vDz.ifM.setBackgroundResource(R.g.chatting_share_reader_mask);
        a(paramString, parambi, paramInt, locall, localc.vDz.ifA);
        localc.vDz.ifL.setVisibility(8);
        parama = paramString.dTD;
        localObject1 = localc.vDz.ifG;
        i = parambi.getType();
        if (j <= 1) {
          break label1247;
        }
        bool = true;
        a(parama, (ImageView)localObject1, i, bool, noY, new r.j.3(this, localc));
        i = 1;
        if (i < j)
        {
          localObject1 = (m)localLinkedList.get(i);
          localObject2 = (r.a)localc.ifY.get(i - 1);
          k = paramString.type;
          if ((i != 1) || ((k != 5) && (k != 8) && (k != 0))) {
            break label3143;
          }
          if ((k != 0) || (!ah.bl(((m)localLinkedList.get(0)).dTD))) {
            break label3130;
          }
          ((r.a)localObject2).ifB.setVisibility(0);
          label742:
          E(((r.a)localObject2).ifB, ieI);
          label753:
          if (i != 1) {
            break label3310;
          }
          if (i != j - 1) {
            break label3291;
          }
          ((r.a)localObject2).ifC.setPadding(0, ieI, 0, ieI);
          label784:
          a(localc, (r.a)localObject2, (m)localObject1, parambi, i, false);
          ((r.a)localObject2).fcy.setText(((m)localObject1).title);
          ((r.a)localObject2).fcy.setTextColor(parama1.vtz.getMMResources().getColor(R.e.black));
          if ((((m)localObject1).dTG != 0) && (((m)localObject1).dTG != 1)) {
            break label3569;
          }
          ((r.a)localObject2).ifF.setVisibility(0);
          ((r.a)localObject2).fcy.setTextColor(parama1.vtz.getMMResources().getColor(R.e.black));
          if (((m)localObject1).type != 7) {
            break label3357;
          }
          ((r.a)localObject2).ifG.setVisibility(8);
          label900:
          if ((ah.bl(((m)localObject1).dTF)) || (((m)localObject1).type != 3)) {
            break label3603;
          }
          ((r.a)localObject2).ifE.setText(((m)localObject1).dTF);
          ((r.a)localObject2).ifE.setVisibility(0);
          label942:
          ((r.a)localObject2).ifA.setVisibility(0);
          parama = ((com.tencent.mm.ui.chatting.b.b.c)parama1.ac(com.tencent.mm.ui.chatting.b.b.c.class)).adq(((m)localObject1).url);
          if (TextUtils.isEmpty(parama)) {
            break label3616;
          }
          y.d("MicroMsg.ChattingItemBizFrom", "productId:%s", new Object[] { parama });
          parama = new aw(parambi, false, paramInt, ((m)localObject1).url, this.vDE, parama1.cDP(), locall.bYG, locall.bYH, ((m)localObject1).title, parama, null, false, true);
          ((r.a)localObject2).ifA.setOnClickListener(h(parama1));
        }
      }
    }
    for (;;)
    {
      parama.rgL = parambi.field_msgSvrId;
      parama.rgM = i;
      ((r.a)localObject2).ifA.setTag(parama);
      if (i.gr(((m)localObject1).dTI)) {
        a((m)localObject1, ((r.a)localObject2).ifA);
      }
      ((r.a)localObject2).ifA.setOnLongClickListener(c(parama1));
      ((r.a)localObject2).ifA.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class)).cDu());
      i += 1;
      break label637;
      break;
      localc.vDz.ifS.R(paramString.title);
      localc.vDz.ifS.getPaint().setFakeBoldText(true);
      localc.vDz.ifS.setVisibility(0);
      localc.vDz.ifS.setTextColor(this.vko.vtz.getContext().getResources().getColor(R.e.light_grey_text_color));
      break label512;
      label1216:
      localc.vDz.ifL.setBackgroundResource(R.g.biz_item_cover_top_round_mask);
      localc.vDz.ifM.setBackgroundResource(R.g.chatting_share_reader_mask_top_round);
      break label546;
      label1247:
      bool = false;
      break label610;
      if (paramString.type == 8)
      {
        cB(localc.vDA.igj);
        cB(localc.vDA.ifM);
        if (j == 1)
        {
          localc.vDA.ifL.setBackgroundResource(R.g.biz_time_line_pic_cover_bottom_round_gradient_mask);
          localc.vDA.ifM.setBackgroundResource(R.g.chatting_share_reader_mask);
          localc.vDA.npf.setBackgroundResource(R.g.biz_bg_rounded_shadow_mask);
          label1333:
          localc.vDA.ifL.setVisibility(8);
          localc.vDA.npf.setVisibility(8);
          localc.vDA.hic.setBackgroundResource(R.k.chatting_item_biz_pic_loading_icon);
          parama = paramString.dTD;
          localObject1 = localc.vDA.ifG;
          i = parambi.getType();
          if (j <= 1) {
            break label1496;
          }
        }
        label1496:
        for (bool = true;; bool = false)
        {
          a(parama, (ImageView)localObject1, i, bool, noY, new r.j.5(this, localc));
          a(paramString, parambi, paramInt, locall, localc.vDA.ifA);
          break;
          localc.vDA.ifL.setBackgroundResource(R.g.biz_item_cover_top_round_pic_mask);
          localc.vDA.ifM.setBackgroundResource(R.g.chatting_share_reader_mask_top_round);
          localc.vDA.npf.setBackgroundResource(R.g.biz_time_line_pic_cover_gradient_mask);
          break label1333;
        }
      }
      if (paramString.type == 7)
      {
        if (ah.bl(paramString.title))
        {
          localc.vDB.fcy.setVisibility(8);
          label1536:
          if (j <= 1) {
            break label1792;
          }
          localc.vDB.ifA.setBackgroundResource(R.g.chatting_item_multi_top);
          label1556:
          parama = i.hF(paramString.dTH);
          if (TextUtils.isEmpty(parama)) {
            break label1809;
          }
          localc.vDB.kZl.setVisibility(0);
          localc.vDB.kZl.setText(parama);
          label1596:
          parama = localc.vDB.ifH.getDrawable();
          if (((parama instanceof AnimationDrawable)) && (((AnimationDrawable)parama).isRunning())) {
            ((AnimationDrawable)parama).stop();
          }
          if (!(parambi.field_msgId + "_0").equals(localc.vBb)) {
            break label1824;
          }
          localc.vDB.ifH.setImageResource(R.g.chatting_item_biz_voice_playing_selector);
          if ((localc.vDB.ifH.getDrawable() instanceof AnimationDrawable)) {
            ((AnimationDrawable)localc.vDB.ifH.getDrawable()).start();
          }
        }
        for (;;)
        {
          parama = localc.vDB.ifH;
          localObject1 = paramString.dTD;
          a(parama, parambi, 0);
          a(paramString, parambi, paramInt, locall, localc.vDB.ifA);
          break;
          localc.vDB.fcy.setVisibility(0);
          localc.vDB.fcy.setText(paramString.title);
          break label1536;
          label1792:
          localc.vDB.ifA.setBackgroundResource(R.g.chatting_item_one_item);
          break label1556;
          label1809:
          localc.vDB.kZl.setVisibility(4);
          break label1596;
          label1824:
          localc.vDB.ifH.setImageResource(R.g.chatting_item_biz_voice_play_selector);
        }
      }
      if (paramString.type == 6)
      {
        parama = (m)localLinkedList.get(0);
        if (ah.bl(parama.title))
        {
          localc.vDC.fcy.setVisibility(8);
          label1886:
          if (j <= 1) {
            break label2144;
          }
          localc.vDC.ifA.setBackgroundResource(R.g.chatting_item_multi_top);
          label1906:
          if (TextUtils.isEmpty(parama.dTR)) {
            break label2161;
          }
          localc.vDC.igh.setVisibility(0);
          localc.vDC.igh.setText(parama.dTR);
          label1943:
          if (parama.dTS != 2) {
            break label2177;
          }
          localc.vDC.igi.setImageResource(R.k.chatting_item_biz_kugou_music_watermark);
          label1965:
          localObject1 = localc.vDC.ifH;
          localObject2 = parama.dTD;
          a((ImageView)localObject1, parambi, 0);
          a(parama, parambi, paramInt, locall, localc.vDC.ifA);
          if (!(parambi.field_msgId + "_0").equals(localc.vBb)) {
            break label2194;
          }
          localc.vDC.ifH.setImageResource(R.k.chatting_item_biz_music_pause_loading_icon);
        }
        for (;;)
        {
          localc.vDC.ifL.setVisibility(8);
          a(parama.dTD, localc.vDC.ifG, parambi.getType(), ieH, ieH, "@S", new r.j.4(this, localc, parambi));
          break;
          localc.vDC.fcy.setVisibility(0);
          localc.vDC.fcy.setText(parama.title);
          break label1886;
          label2144:
          localc.vDC.ifA.setBackgroundResource(R.g.chatting_item_one_item);
          break label1906;
          label2161:
          localc.vDC.igh.setVisibility(8);
          break label1943;
          label2177:
          localc.vDC.igi.setImageResource(R.k.chatting_item_biz_qq_music_watermark);
          break label1965;
          label2194:
          localc.vDC.ifH.setImageResource(R.k.chatting_item_biz_music_play_loading_icon);
        }
      }
      if (paramString.type == 10)
      {
        if (ah.bl(paramString.title))
        {
          localc.vDD.ifS.setVisibility(8);
          if (j <= 1) {
            break label2472;
          }
          localc.vDD.ifA.setBackgroundResource(R.g.chatting_item_multi_top);
          localc.vDD.igl.setVisibility(8);
        }
        for (;;)
        {
          a(paramString, parambi, paramInt, locall, localc.vDD.ifA);
          break;
          localc.vDD.ifS.setVisibility(0);
          localc.vDD.ifS.R(j.a(this.vko.vtz.getContext(), paramString.title, (int)localc.vDD.ifS.getTextSize()));
          i = com.tencent.mm.cb.a.fj(this.vko.vtz.getContext());
          k = (int)(com.tencent.mm.cb.a.getDensity(this.vko.vtz.getContext()) * 80.0F);
          parama = localc.vDD.ifS.Je(i - k);
          if (parama != null)
          {
            i = parama.cNL();
            label2415:
            parama = (LinearLayout.LayoutParams)localc.vDD.ifS.getLayoutParams();
            if (i != 1) {
              break label2463;
            }
          }
          label2463:
          for (parama.gravity = 17;; parama.gravity = 19)
          {
            localc.vDD.ifS.setLayoutParams(parama);
            break;
            i = 0;
            break label2415;
          }
          label2472:
          localc.vDD.ifA.setBackgroundResource(R.g.chatting_item_one_item);
          localc.vDD.igl.setVisibility(0);
        }
      }
      parama = localc.vDy.fcy;
      if (j > 1)
      {
        i = 8;
        label2520:
        parama.setVisibility(i);
        parama = localc.vDy.npq;
        if ((j <= 1) && (!ah.bl(paramString.dTF))) {
          break label2868;
        }
        i = 8;
        label2556:
        parama.setVisibility(i);
        parama = localc.vDy.npe;
        if (j <= 1) {
          break label2874;
        }
      }
      label2868:
      label2874:
      for (i = 0;; i = 8)
      {
        parama.setVisibility(i);
        localc.vDy.npf.setVisibility(8);
        if (j != 1) {
          break label2881;
        }
        localc.vDy.ifM.setBackgroundResource(R.g.chatting_share_reader_mask);
        localc.vDy.fnF.setVisibility(0);
        cB(localc.vDy.igj);
        cB(localc.vDy.ifM);
        if (ah.bl(paramString.dTD)) {
          break label2993;
        }
        localc.vDy.igj.setVisibility(0);
        a(paramString.dTD, localc.vDy.ifG, parambi.getType(), true, noY, new r.j.2(this, j, localc));
        localc.vDy.fnF.setBackgroundResource(R.g.chatting_item_multbg_bottom_normal);
        localc.vDy.fnF.setPadding(ieI, ieJ, ieI, ieI);
        localc.vDy.ifM.setVisibility(0);
        localc.vDy.npq.setText(paramString.dTF);
        localc.vDy.fcy.setText(paramString.title);
        localc.vDy.npe.R(paramString.title);
        if ((paramString.dTG != 0) && (paramString.dTG != 1)) {
          localc.vDy.npe.setVisibility(4);
        }
        a(paramString, parambi, paramInt, locall, localc.vDy.ifA);
        break;
        i = 0;
        break label2520;
        i = 0;
        break label2556;
      }
      label2881:
      parama = localc.vDy.fnF;
      if (ah.bl(paramString.dTD)) {}
      for (i = 0;; i = 8)
      {
        parama.setVisibility(i);
        localc.vDy.ifM.setBackgroundResource(R.g.chatting_share_reader_mask_top_round);
        localc.vDy.npe.setTextColor(this.vko.vtz.getContext().getResources().getColor(R.e.light_grey_text_color));
        localc.vDy.npe.setBackgroundResource(R.g.mm_trans);
        localc.vDy.npe.getPaint().setFakeBoldText(true);
        break;
      }
      label2993:
      localc.vDy.igj.setVisibility(8);
      localc.vDy.fcy.setVisibility(0);
      parama = localc.vDy.npq;
      if (ah.bl(paramString.dTF))
      {
        i = 8;
        label3042:
        parama.setVisibility(i);
        if (j != 1) {
          break label3113;
        }
        localc.vDy.fnF.setBackgroundResource(R.g.chatting_item_one_item);
      }
      for (;;)
      {
        localc.vDy.fnF.setPadding(ieI, ieI, ieI, ieI);
        localc.vDy.ifM.setVisibility(8);
        break;
        i = 0;
        break label3042;
        label3113:
        localc.vDy.fnF.setBackgroundResource(R.g.chatting_item_multi_top);
      }
      label3130:
      ((r.a)localObject2).ifB.setVisibility(8);
      break label753;
      label3143:
      ((r.a)localObject2).ifB.setVisibility(0);
      if (i <= 1) {
        break label742;
      }
      parama = (m)localLinkedList.get(i - 1);
      Object localObject3 = (m)localLinkedList.get(i);
      if (((parama.type != 7) && (parama.type != 5) && (parama.type != 6) && (ah.bl(parama.dTD))) || ((((m)localObject3).type != 7) && (((m)localObject3).type != 5) && (((m)localObject3).type != 6) && (ah.bl(((m)localObject3).dTD))))
      {
        E(((r.a)localObject2).ifB, ieI);
        break label753;
      }
      E(((r.a)localObject2).ifB, ieL);
      break label753;
      label3291:
      ((r.a)localObject2).ifC.setPadding(0, ieI, 0, ieK);
      break label784;
      label3310:
      if (i == j - 1)
      {
        ((r.a)localObject2).ifC.setPadding(0, ieK, 0, ieI);
        break label784;
      }
      ((r.a)localObject2).ifC.setPadding(0, ieK, 0, ieK);
      break label784;
      label3357:
      if (!ah.bl(((m)localObject1).dTD))
      {
        ((r.a)localObject2).ifG.setVisibility(0);
        a(((m)localObject1).dTD, ((r.a)localObject2).ifG, parambi.getType(), ieH, ieH, "@S", new r.j.1(this, localc, (r.a)localObject2, (m)localObject1, parambi, i));
        break label900;
      }
      if ((((m)localObject1).type == 5) || (((m)localObject1).type == 6))
      {
        ((r.a)localObject2).ifG.setVisibility(0);
        parama = R.g.chatting_item_biz_play_icon_bg;
        localObject3 = ((r.a)localObject2).ifG;
        k = ieH;
        int m = ieH;
        com.tencent.mm.as.a.a locala = o.ON();
        com.tencent.mm.as.a.a.c.a locala1 = new com.tencent.mm.as.a.a.c.a();
        locala1.erd = true;
        locala1.eru = R.e.chatting_item_biz_default_bg;
        locala1 = locala1.bn(k, m);
        locala1.erk = 4;
        locala.a(parama, (ImageView)localObject3, locala1.OV(), null, new com.tencent.mm.pluginsdk.ui.applet.e());
        break label900;
      }
      ((r.a)localObject2).ifF.setVisibility(8);
      break label900;
      label3569:
      ((r.a)localObject2).ifF.setVisibility(8);
      ((r.a)localObject2).fcy.setTextColor(parama1.vtz.getMMResources().getColor(R.e.hint_text_color));
      break label900;
      label3603:
      ((r.a)localObject2).ifE.setVisibility(8);
      break label942;
      label3616:
      parama = new aw(parambi, false, paramInt, ((m)localObject1).url, this.vDE, parama1.cDP(), locall.bYG, locall.bYH);
      a(parama, (m)localObject1, parambi);
      ((r.a)localObject2).ifA.setOnClickListener(g(parama1));
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    Object localObject = (aw)paramView.getTag();
    if (localObject == null) {
      return false;
    }
    this.vDF = ((aw)localObject).rgM;
    int i = ((aw)localObject).position;
    localObject = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.biz.a.a.class)).d(parambi.field_msgId, parambi.field_content);
    if (localObject == null)
    {
      y.w("MicroMsg.ChattingItemBizFrom", "onCreateContextMenu reader is null");
      return false;
    }
    this.ieS = false;
    if ((this.vDF >= 0) && (this.vDF < ((l)localObject).dTx.size()) && (i.gr(((m)((l)localObject).dTx.get(this.vDF)).dTI))) {
      this.ieS = true;
    }
    if ((!this.vko.cFF()) && (!k.ax(parambi))) {
      paramContextMenu.add(i, 111, 0, paramView.getContext().getString(R.l.retransmit));
    }
    if ((d.SP("favorite")) && (!this.ieS)) {
      paramContextMenu.add(i, 126, 0, paramView.getContext().getString(R.l.plugin_favorite_opt));
    }
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    this.ieT = ah.UX();
    switch (paramMenuItem.getItemId())
    {
    default: 
    case 111: 
    case 114: 
      do
      {
        do
        {
          return false;
          if (this.ieS)
          {
            if (!this.ieS)
            {
              y.w("MicroMsg.ChattingItemBizFrom", "transmitAppBrandMsg not AppBrandMsg!");
              return false;
            }
            s.a(this.vDF, parama.vtz.getContext(), parambi.field_content, parambi.field_talker, parambi.field_msgId, parambi.field_msgSvrId);
            return false;
          }
          str = a(parambi, parama.vtz.getContext(), this.vDF);
        } while (ah.bl(str));
        paramMenuItem = new Intent(parama.vtz.getContext(), MsgRetransmitUI.class);
        paramMenuItem.putExtra("Retr_Msg_content", str);
        paramMenuItem.putExtra("Retr_Msg_Type", 2);
        paramMenuItem.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.vDF);
        paramMenuItem.putExtra("Retr_Msg_Id", parambi.field_msgId);
        paramMenuItem.putExtra("Retr_MsgFromScene", 1);
        String str = parambi.field_talker;
        Object localObject = u.ij(parambi.field_msgSvrId);
        paramMenuItem.putExtra("reportSessionId", (String)localObject);
        localObject = u.Hc().v((String)localObject, true);
        ((u.b)localObject).h("prePublishId", "msg_" + parambi.field_msgSvrId);
        ((u.b)localObject).h("preUsername", str);
        ((u.b)localObject).h("preChatName", str);
        ((u.b)localObject).h("preMsgIndex", Integer.valueOf(this.vDF));
        ((u.b)localObject).h("sendAppMsgScene", Integer.valueOf(1));
        parama.startActivity(paramMenuItem);
        return false;
        paramMenuItem = a(parambi, parama.vtz.getContext(), 0);
      } while (ah.bl(paramMenuItem));
      ao.c(parambi, paramMenuItem, parama.vtz.getContext());
      return false;
    }
    s.a(this.ieT, this.vDF, parama.vtz.getContext(), parama.vtz, null, parambi);
    return false;
  }
  
  public final boolean au(int paramInt, boolean paramBoolean)
  {
    return paramInt == 285212721;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    return false;
  }
  
  public final boolean bfO()
  {
    return false;
  }
  
  protected final boolean cHb()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.r.j
 * JD-Core Version:    0.7.0.1
 */