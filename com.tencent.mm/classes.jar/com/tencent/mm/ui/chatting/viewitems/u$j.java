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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.l;
import com.tencent.mm.at.o;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.e.a;
import com.tencent.mm.pluginsdk.ui.applet.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.al;
import com.tencent.mm.ui.chatting.an;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.r;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class u$j
  extends c
{
  private static int jVA;
  private static int jVv;
  private static int jVw = 0;
  private static int jVx;
  private static int jVy = 0;
  private static int pUm;
  private long jYq = 0L;
  private boolean jYr = false;
  private boolean zUP = false;
  private int zUQ = 0;
  private com.tencent.mm.ui.chatting.d.a zzP;
  
  static
  {
    jVx = 0;
  }
  
  private static void P(View paramView, int paramInt)
  {
    AppMethodBeat.i(33091);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.width = paramInt;
    localLayoutParams.height = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(33091);
  }
  
  private static void R(View paramView, int paramInt)
  {
    AppMethodBeat.i(33092);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.rightMargin = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(33092);
  }
  
  private static String a(bi parambi, Context paramContext, int paramInt)
  {
    AppMethodBeat.i(33102);
    if (paramContext == null)
    {
      ab.w("MicroMsg.ChattingItemBizFrom", "getReaderAppMsgContent: context is null");
      AppMethodBeat.o(33102);
      return null;
    }
    if (parambi == null)
    {
      ab.w("MicroMsg.ChattingItemBizFrom", "getReaderAppMsgContent: msg is null");
      AppMethodBeat.o(33102);
      return null;
    }
    parambi = l.a(paramContext, paramInt, parambi.field_content, parambi.field_talker, parambi.field_msgId);
    AppMethodBeat.o(33102);
    return parambi;
  }
  
  private static void a(View paramView, u.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(33095);
    if (paramBoolean)
    {
      if (paramb.jXr == null) {
        paramb.fj(paramView);
      }
      if (paramb.jXr != null)
      {
        paramb.jXr.setVisibility(0);
        AppMethodBeat.o(33095);
      }
    }
    else if (paramb.jXr != null)
    {
      paramb.jXr.setVisibility(8);
    }
    AppMethodBeat.o(33095);
  }
  
  private void a(ImageView paramImageView, bi parambi, int paramInt)
  {
    AppMethodBeat.i(33094);
    d.f localf = new d.f();
    localf.cpO = parambi.field_msgId;
    localf.zTf = paramInt;
    localf.cBW = parambi.field_content;
    paramImageView.setTag(localf);
    paramImageView.setOnClickListener(((h)this.zzP.ay(h.class)).dHj());
    AppMethodBeat.o(33094);
  }
  
  private void a(com.tencent.mm.af.q paramq, View paramView)
  {
    AppMethodBeat.i(33103);
    r.a(paramq, paramView, this.zzP.getTalkerUserName());
    AppMethodBeat.o(33103);
  }
  
  private void a(com.tencent.mm.af.q paramq, View paramView, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(33104);
    if (((b)g.E(b.class)).rT(paramq.type)) {
      paramView.setOnClickListener(new u.j.7(this, paramInt, paramLong1, paramLong2));
    }
    AppMethodBeat.o(33104);
  }
  
  private void a(com.tencent.mm.af.q paramq, bi parambi, int paramInt, com.tencent.mm.af.p paramp, View paramView)
  {
    AppMethodBeat.i(33089);
    String str = ((com.tencent.mm.ui.chatting.c.b.d)this.zzP.ay(com.tencent.mm.ui.chatting.c.b.d.class)).atR(paramq.url);
    if (!TextUtils.isEmpty(str))
    {
      ab.d("MicroMsg.ChattingItemBizFrom", "productId:%s", new Object[] { str });
      paramp = new az(parambi, false, paramInt, paramq.url, false, this.zzP.dHF(), paramp.cGN, paramp.cGO, paramq.title, str, null, false, false);
      paramView.setOnClickListener(i(this.zzP));
    }
    for (;;)
    {
      paramp.uWZ = parambi.field_msgSvrId;
      paramp.uXa = 0;
      paramp.zYN = paramq.type;
      paramView.setTag(paramp);
      if (l.na(paramq.fjO)) {
        a(paramq, paramView);
      }
      a(paramq, paramView, parambi.field_msgId, parambi.field_msgSvrId, 0);
      paramView.setOnLongClickListener(c(this.zzP));
      paramView.setOnTouchListener(((h)this.zzP.ay(h.class)).dHi());
      AppMethodBeat.o(33089);
      return;
      paramp = new az(parambi, false, paramInt, paramq.url, false, this.zzP.dHF(), paramp.cGN, paramp.cGO, paramq.title);
      a(paramp, paramq, parambi);
      paramView.setOnClickListener(h(this.zzP));
    }
  }
  
  private void a(az paramaz, com.tencent.mm.af.q paramq, bi parambi)
  {
    AppMethodBeat.i(33098);
    Bundle localBundle = new Bundle();
    int i;
    switch (u.ah(b(this.zzP, parambi), this.zzP.getTalkerUserName()))
    {
    case 3: 
    case 4: 
    case 5: 
    default: 
      i = 0;
    }
    for (;;)
    {
      localBundle.putString("share_report_pre_msg_url", paramq.url);
      localBundle.putString("share_report_pre_msg_title", paramq.title);
      localBundle.putString("share_report_pre_msg_desc", paramq.fjL);
      localBundle.putString("share_report_pre_msg_icon_url", l.a(paramq));
      localBundle.putString("share_report_pre_msg_appid", "");
      localBundle.putInt("share_report_from_scene", i);
      if (i == 5) {
        localBundle.putString("share_report_biz_username", this.zzP.getTalkerUserName());
      }
      paramaz.zYL = localBundle;
      AppMethodBeat.o(33098);
      return;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 5;
    }
  }
  
  private static void a(u.c paramc, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    AppMethodBeat.i(33096);
    boolean bool1;
    if (paramInt1 == 5)
    {
      bool1 = true;
      a(paramc.jYa, paramc.zUJ, bool1);
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
        a(paramc.jYa, paramc.zUK, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 7) {
          break label203;
        }
        bool1 = true;
        a(paramc.jYa, paramc.zUL, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 6) {
          break label209;
        }
        bool1 = true;
        label104:
        a(paramc.jYa, paramc.zUM, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 10) {
          break label215;
        }
        bool1 = true;
        a(paramc.jYa, paramc.zUN, bool1);
        if (!bool1) {
          break label227;
        }
      }
      for (paramInt1 = 1;; paramInt1 = i)
      {
        LinearLayout localLinearLayout = paramc.jYa;
        paramc = paramc.zUI;
        if ((paramInt1 == 0) && (paramInt2 > 0)) {}
        for (bool1 = bool2;; bool1 = false)
        {
          a(localLinearLayout, paramc, bool1);
          AppMethodBeat.o(33096);
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
  
  private void a(u.c paramc, u.a parama, com.tencent.mm.af.q paramq, bi parambi, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(33093);
    if (paramq.type == 5)
    {
      parama.jXy.setVisibility(0);
      parama.jXy.setImageResource(2130837973);
      parama.jXy.setOnClickListener(new u.j.6(this, parama));
    }
    for (;;)
    {
      paramInt = com.tencent.mm.cb.a.fromDPToPix(this.zzP.zJz.getContext(), 26);
      if (paramq.type == 7) {
        paramInt = com.tencent.mm.cb.a.fromDPToPix(this.zzP.zJz.getContext(), 32);
      }
      P(parama.jXy, paramInt);
      AppMethodBeat.o(33093);
      return;
      if (paramq.type == 6)
      {
        parama.jXy.setVisibility(0);
        if (paramBoolean) {
          if ((parambi.field_msgId + "_" + paramInt).equals(paramc.zRD)) {
            parama.jXy.setImageResource(2130838314);
          }
        }
        for (;;)
        {
          a(parama.jXy, parambi, paramInt);
          break;
          parama.jXy.setImageResource(2130838315);
          continue;
          if ((parambi.field_msgId + "_" + paramInt).equals(paramc.zRD)) {
            parama.jXy.setImageResource(2131231112);
          } else {
            parama.jXy.setImageResource(2131231115);
          }
        }
      }
      if (paramq.type == 7)
      {
        parama.jXy.setVisibility(0);
        Drawable localDrawable = parama.jXy.getDrawable();
        if (((localDrawable instanceof AnimationDrawable)) && (((AnimationDrawable)localDrawable).isRunning())) {
          ((AnimationDrawable)localDrawable).stop();
        }
        if ((parambi.field_msgId + "_" + paramInt).equals(paramc.zRD))
        {
          parama.jXy.setImageResource(2130837975);
          if ((parama.jXy.getDrawable() instanceof AnimationDrawable)) {
            ((AnimationDrawable)parama.jXy.getDrawable()).start();
          }
        }
        for (;;)
        {
          a(parama.jXy, parambi, paramInt);
          break;
          parama.jXy.setImageResource(2130837974);
        }
      }
      parama.jXy.setVisibility(8);
    }
  }
  
  private static void a(String paramString, ImageView paramImageView, int paramInt1, int paramInt2, e.a parama)
  {
    AppMethodBeat.i(153949);
    paramString = com.tencent.mm.at.q.ts(paramString);
    com.tencent.mm.at.a.a locala = o.ahG();
    com.tencent.mm.at.a.a.c.a locala1 = new com.tencent.mm.at.a.a.c.a();
    locala1.eOa = 2131689878;
    locala1.eNM = true;
    locala1 = locala1.cx(paramInt1, paramInt2);
    locala1.fHk = new f();
    locala1.eNO = com.tencent.mm.pluginsdk.model.p.aln(paramString);
    locala.a(paramString, paramImageView, locala1.ahY(), null, new e(0, 0, null, parama));
    AppMethodBeat.o(153949);
  }
  
  private void a(String paramString, ImageView paramImageView, boolean paramBoolean, int paramInt, e.a parama)
  {
    AppMethodBeat.i(153950);
    paramString = com.tencent.mm.at.q.ts(paramString);
    int i;
    boolean bool;
    label27:
    int j;
    label36:
    float f1;
    if (paramBoolean)
    {
      i = 2130837914;
      if (!paramBoolean) {
        break label227;
      }
      bool = false;
      if (!paramBoolean) {
        break label233;
      }
      j = 2130837920;
      f1 = this.zzP.zJz.getContext().getResources().getDimensionPixelSize(2131428218);
      if (!((h)this.zzP.ay(h.class)).isInEditMode()) {
        break label241;
      }
    }
    label227:
    label233:
    label241:
    for (int k = 72;; k = 32)
    {
      int m = com.tencent.mm.cb.a.gw(paramImageView.getContext());
      float f2 = com.tencent.mm.cb.a.getDensity(paramImageView.getContext());
      k = m - (int)(k * f2);
      com.tencent.mm.at.a.a locala = o.ahG();
      com.tencent.mm.at.a.a.c.a locala1 = new com.tencent.mm.at.a.a.c.a();
      locala1.eOa = j;
      locala1.eNM = true;
      locala1.eOc = String.valueOf(i);
      locala1 = locala1.cx(k, paramInt);
      locala1.fHk = new f();
      locala1.eNO = com.tencent.mm.pluginsdk.model.p.aln(paramString);
      locala.a(paramString, paramImageView, locala1.ahY(), null, new e(k, paramInt, true, bool, f1, parama));
      AppMethodBeat.o(153950);
      return;
      i = 2130837911;
      break;
      bool = true;
      break label27;
      j = 2130837918;
      break label36;
    }
  }
  
  private static void c(com.tencent.mm.af.q paramq)
  {
    if (paramq.type == 6) {
      paramq.type = 7;
    }
  }
  
  private static void dd(View paramView)
  {
    AppMethodBeat.i(33090);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = pUm;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(33090);
  }
  
  private static void ip(Context paramContext)
  {
    AppMethodBeat.i(33087);
    int i;
    int j;
    if (jVy == 0)
    {
      jVy = paramContext.getResources().getDimensionPixelSize(2131427854);
      jVx = paramContext.getResources().getDimensionPixelSize(2131427792);
      jVw = paramContext.getResources().getDimensionPixelSize(2131427772);
      jVv = paramContext.getResources().getDimensionPixelSize(2131428215);
      jVA = paramContext.getResources().getDimensionPixelSize(2131428213);
      i = com.tencent.mm.cb.a.gw(paramContext);
      j = com.tencent.mm.cb.a.gx(paramContext);
      if (i >= j) {
        break label119;
      }
    }
    for (;;)
    {
      pUm = (int)((i - (int)(com.tencent.mm.cb.a.getDensity(paramContext) * 32.0F)) / 2.35D);
      AppMethodBeat.o(33087);
      return;
      label119:
      i = j;
    }
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(33086);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969050);
      paramView = new u.c();
      paramView.ekh = ((TextView)((View)localObject).findViewById(2131820587));
      paramView.zRB = ((View)localObject).findViewById(2131820582);
      paramView.jYa = ((LinearLayout)((View)localObject).findViewById(2131822517));
      paramView.mCC = ((CheckBox)((View)localObject).findViewById(2131820579));
      paramView.jbK = ((View)localObject).findViewById(2131820586);
      paramView.zRY = ((TextView)((View)localObject).findViewById(2131822518));
      ((View)localObject).setTag(paramView);
    }
    ip(paramLayoutInflater.getContext());
    AppMethodBeat.o(33086);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, final bi parambi, String paramString)
  {
    AppMethodBeat.i(33088);
    this.zzP = parama1;
    ip(parama1.zJz.getContext());
    final u.c localc = (u.c)parama;
    parama = localc.jYd.iterator();
    if (parama.hasNext())
    {
      paramString = (u.a)parama.next();
      if (localc.jYd.indexOf(paramString) != localc.jYd.size() - 1) {
        an.an(paramString.jXr, 1);
      }
      for (;;)
      {
        localc.jYa.removeView(paramString.jXr);
        break;
        an.an(paramString.jXr, 2);
      }
    }
    localc.jYd.clear();
    com.tencent.mm.af.p localp = ((com.tencent.mm.plugin.biz.a.a)g.E(com.tencent.mm.plugin.biz.a.a.class)).b(parambi.field_msgId, parambi.field_content);
    parama = localp.dGR;
    if ((parama == null) || (parama.length() == 0)) {
      localc.zRY.setVisibility(8);
    }
    LinkedList localLinkedList;
    int j;
    for (;;)
    {
      localLinkedList = localp.fjy;
      j = localLinkedList.size();
      if (j != 0) {
        break;
      }
      localc.jYa.setVisibility(8);
      a(localc, -1, 0);
      AppMethodBeat.o(33088);
      return;
      localc.zRY.setVisibility(0);
      b(parama1, localc.zRY, az.auv(parama));
    }
    localc.jYa.setVisibility(0);
    a(localc, ((com.tencent.mm.af.q)localLinkedList.get(0)).type, j);
    Object localObject1 = parama1.zJz.getActivityLayoutInflater();
    final int i = localc.jYd.size() + 2;
    while (i < j)
    {
      paramString = an.Py(1);
      parama = paramString;
      if (paramString == null) {
        parama = ((LayoutInflater)localObject1).inflate(2130969051, null);
      }
      localc.fk(parama);
      i += 1;
    }
    if (j > 1)
    {
      paramString = an.Py(2);
      parama = paramString;
      if (paramString == null) {
        parama = ((LayoutInflater)localObject1).inflate(2130969052, null);
      }
      localc.fk(parama);
    }
    for (this.zUP = true;; this.zUP = false)
    {
      i = 0;
      while (i < localc.jYd.size())
      {
        ((u.a)localc.jYd.get(i)).jXr.setVisibility(8);
        i += 1;
      }
    }
    paramString = (com.tencent.mm.af.q)localLinkedList.get(0);
    c(paramString);
    label563:
    label633:
    boolean bool;
    label690:
    label744:
    label747:
    final u.a locala;
    int k;
    label857:
    label868:
    Object localObject2;
    if (paramString.type == 5)
    {
      dd(localc.zUJ.jYA);
      dd(localc.zUJ.jXH);
      if (ah.isNullOrNil(paramString.title))
      {
        localc.zUJ.jXI.setVisibility(8);
        if (j != 1) {
          break label1448;
        }
        localc.zUJ.jXG.setBackgroundResource(2130838003);
        localc.zUJ.jXH.setBackgroundResource(2130838352);
        parama = l.kq(paramString.fjN);
        if (TextUtils.isEmpty(parama)) {
          break label1479;
        }
        localc.zUJ.timeTv.setVisibility(0);
        localc.zUJ.timeTv.setText(parama);
        localc.zUJ.timeTv.setTextColor(this.zzP.zJz.getContext().getResources().getColor(2131690208));
        a(paramString, parambi, paramInt, localp, localc.zUJ.jXr);
        localc.zUJ.jXG.setVisibility(8);
        parama = paramString.fjJ;
        localObject1 = localc.zUJ.jXx;
        if (j <= 1) {
          break label1495;
        }
        bool = true;
        a(parama, (ImageView)localObject1, bool, pUm, new u.j.3(this, localc));
        if (com.tencent.mm.cb.a.dr(this.zzP.zJz.getContext()) <= 1.125F) {
          break label1501;
        }
        localc.zUJ.jXI.setMaxLines(1);
        i = 1;
        if (i >= j) {
          break label3951;
        }
        localObject1 = (com.tencent.mm.af.q)localLinkedList.get(i);
        c((com.tencent.mm.af.q)localObject1);
        locala = (u.a)localc.jYd.get(i - 1);
        k = paramString.type;
        if ((i != 1) || ((k != 5) && (k != 8) && (k != 0))) {
          break label3397;
        }
        if ((k != 0) || (!ah.isNullOrNil(((com.tencent.mm.af.q)localLinkedList.get(0)).fjJ))) {
          break label3384;
        }
        locala.jXs.setVisibility(0);
        R(locala.jXs, jVw);
        if (i != 1) {
          break label3564;
        }
        if (i != j - 1) {
          break label3545;
        }
        locala.jXt.setPadding(0, jVw, 0, jVw);
        label899:
        a(localc, locala, (com.tencent.mm.af.q)localObject1, parambi, i, false);
        locala.gui.setText(((com.tencent.mm.af.q)localObject1).title);
        locala.gui.setTextColor(parama1.zJz.getMMResources().getColor(2131689763));
        if (ah.isNullOrNil(((com.tencent.mm.af.q)localObject1).title))
        {
          localObject2 = locala.gui;
          k = ((com.tencent.mm.af.q)localObject1).type;
          parama = this.zzP.zJz.getContext();
        }
        switch (k)
        {
        case 6: 
        default: 
          parama = parama.getResources().getString(2131298147);
          label1027:
          ((TextView)localObject2).setText(parama);
          if ((((com.tencent.mm.af.q)localObject1).fjM == 0) || (((com.tencent.mm.af.q)localObject1).fjM == 1))
          {
            locala.jXw.setVisibility(0);
            locala.gui.setTextColor(parama1.zJz.getMMResources().getColor(2131689763));
            if (((com.tencent.mm.af.q)localObject1).type == 7)
            {
              locala.jXx.setVisibility(8);
              label1100:
              if ((ah.isNullOrNil(((com.tencent.mm.af.q)localObject1).fjL)) || (((com.tencent.mm.af.q)localObject1).type != 3)) {
                break label3878;
              }
              locala.jXv.setText(((com.tencent.mm.af.q)localObject1).fjL);
              locala.jXv.setVisibility(0);
              label1142:
              locala.jXr.setVisibility(0);
              parama = ((com.tencent.mm.ui.chatting.c.b.d)parama1.ay(com.tencent.mm.ui.chatting.c.b.d.class)).atR(((com.tencent.mm.af.q)localObject1).url);
              if (TextUtils.isEmpty(parama)) {
                break label3891;
              }
              ab.d("MicroMsg.ChattingItemBizFrom", "productId:%s", new Object[] { parama });
              parama = new az(parambi, false, paramInt, ((com.tencent.mm.af.q)localObject1).url, this.zUP, parama1.dHF(), localp.cGN, localp.cGO, ((com.tencent.mm.af.q)localObject1).title, parama, null, false, true);
              locala.jXr.setOnClickListener(i(parama1));
            }
          }
          break;
        }
      }
    }
    for (;;)
    {
      parama.uWZ = parambi.field_msgSvrId;
      parama.uXa = i;
      parama.zYN = ((com.tencent.mm.af.q)localObject1).type;
      locala.jXr.setTag(parama);
      if (l.na(((com.tencent.mm.af.q)localObject1).fjO)) {
        a((com.tencent.mm.af.q)localObject1, locala.jXr);
      }
      a((com.tencent.mm.af.q)localObject1, locala.jXr, parambi.field_msgId, parambi.field_msgSvrId, i);
      locala.jXr.setOnLongClickListener(c(parama1));
      locala.jXr.setOnTouchListener(((h)parama1.ay(h.class)).dHi());
      i += 1;
      break label747;
      localc.zUJ.jXI.af(paramString.title);
      localc.zUJ.jXI.getPaint().setFakeBoldText(true);
      localc.zUJ.jXI.setVisibility(0);
      localc.zUJ.jXI.setTextColor(this.zzP.zJz.getContext().getResources().getColor(2131690208));
      break;
      label1448:
      localc.zUJ.jXG.setBackgroundResource(2130837921);
      localc.zUJ.jXH.setBackgroundResource(2130838354);
      break label563;
      label1479:
      localc.zUJ.timeTv.setVisibility(8);
      break label633;
      label1495:
      bool = false;
      break label690;
      label1501:
      localc.zUJ.jXI.setMaxLines(2);
      break label744;
      if (paramString.type == 8)
      {
        dd(localc.zUK.jYA);
        dd(localc.zUK.jXH);
        if (j == 1)
        {
          localc.zUK.jXG.setBackgroundResource(2130837978);
          localc.zUK.jXH.setBackgroundResource(2130838352);
          localc.zUK.pUt.setBackgroundResource(2130837913);
          label1596:
          localc.zUK.jXG.setVisibility(8);
          localc.zUK.pUt.setVisibility(8);
          localc.zUK.iTH.setImageResource(2131230993);
          parama = paramString.fjJ;
          localObject1 = localc.zUK.jXx;
          if (j <= 1) {
            break label1750;
          }
        }
        label1750:
        for (bool = true;; bool = false)
        {
          a(parama, (ImageView)localObject1, bool, pUm, new u.j.5(this, localc));
          a(paramString, parambi, paramInt, localp, localc.zUK.jXr);
          break;
          localc.zUK.jXG.setBackgroundResource(2130837922);
          localc.zUK.jXH.setBackgroundResource(2130838354);
          localc.zUK.pUt.setBackgroundResource(2130837979);
          break label1596;
        }
      }
      if (paramString.type == 7)
      {
        if (ah.isNullOrNil(paramString.title))
        {
          localc.zUL.gui.setVisibility(8);
          label1790:
          if (j <= 1) {
            break label2037;
          }
          localc.zUL.jXr.setBackgroundResource(2130838336);
          label1810:
          parama = l.kq(paramString.fjN);
          if (TextUtils.isEmpty(parama)) {
            break label2054;
          }
          localc.zUL.nxi.setVisibility(0);
          localc.zUL.nxi.setText(parama);
          label1850:
          parama = localc.zUL.jXy.getDrawable();
          if (((parama instanceof AnimationDrawable)) && (((AnimationDrawable)parama).isRunning())) {
            ((AnimationDrawable)parama).stop();
          }
          if (!(parambi.field_msgId + "_0").equals(localc.zRD)) {
            break label2069;
          }
          localc.zUL.jXy.setImageResource(2130837975);
          if ((localc.zUL.jXy.getDrawable() instanceof AnimationDrawable)) {
            ((AnimationDrawable)localc.zUL.jXy.getDrawable()).start();
          }
        }
        for (;;)
        {
          a(localc.zUL.jXy, parambi, 0);
          a(paramString, parambi, paramInt, localp, localc.zUL.jXr);
          break;
          localc.zUL.gui.setVisibility(0);
          localc.zUL.gui.setText(paramString.title);
          break label1790;
          label2037:
          localc.zUL.jXr.setBackgroundResource(2130838337);
          break label1810;
          label2054:
          localc.zUL.nxi.setVisibility(4);
          break label1850;
          label2069:
          localc.zUL.jXy.setImageResource(2130837974);
        }
      }
      if (paramString.type == 6)
      {
        parama = (com.tencent.mm.af.q)localLinkedList.get(0);
        if (ah.isNullOrNil(parama.title))
        {
          localc.zUM.gui.setVisibility(8);
          label2131:
          if (j <= 1) {
            break label2380;
          }
          localc.zUM.jXr.setBackgroundResource(2130838336);
          label2151:
          if (TextUtils.isEmpty(parama.fjX)) {
            break label2397;
          }
          localc.zUM.jYx.setVisibility(0);
          localc.zUM.jYx.setText(parama.fjX);
          label2188:
          if (parama.fjY != 2) {
            break label2413;
          }
          localc.zUM.jYy.setImageResource(2131231109);
          label2210:
          a(localc.zUM.jXy, parambi, 0);
          a(parama, parambi, paramInt, localp, localc.zUM.jXr);
          if (!(parambi.field_msgId + "_0").equals(localc.zRD)) {
            break label2430;
          }
          localc.zUM.jXy.setImageResource(2131231112);
        }
        for (;;)
        {
          localc.zUM.jXG.setVisibility(8);
          parama = parama.fjJ;
          localObject1 = localc.zUM.jXx;
          i = jVv;
          a(parama, (ImageView)localObject1, i, i, new u.j.4(this, localc, parambi));
          break;
          localc.zUM.gui.setVisibility(0);
          localc.zUM.gui.setText(parama.title);
          break label2131;
          label2380:
          localc.zUM.jXr.setBackgroundResource(2130838337);
          break label2151;
          label2397:
          localc.zUM.jYx.setVisibility(8);
          break label2188;
          label2413:
          localc.zUM.jYy.setImageResource(2131231118);
          break label2210;
          label2430:
          localc.zUM.jXy.setImageResource(2131231115);
        }
      }
      if (paramString.type == 10)
      {
        if (ah.isNullOrNil(paramString.title))
        {
          localc.zUN.jXI.setVisibility(8);
          if (j <= 1) {
            break label2710;
          }
          localc.zUN.jXr.setBackgroundResource(2130838336);
          localc.zUN.zUO.setVisibility(8);
        }
        for (;;)
        {
          a(paramString, parambi, paramInt, localp, localc.zUN.jXr);
          break;
          localc.zUN.jXI.setVisibility(0);
          localc.zUN.jXI.af(com.tencent.mm.pluginsdk.ui.d.j.a(this.zzP.zJz.getContext(), paramString.title, (int)localc.zUN.jXI.getTextSize()));
          i = com.tencent.mm.cb.a.gw(this.zzP.zJz.getContext());
          k = (int)(com.tencent.mm.cb.a.getDensity(this.zzP.zJz.getContext()) * 80.0F);
          parama = localc.zUN.jXI.Sa(i - k);
          if (parama != null)
          {
            i = parama.dTo();
            label2653:
            parama = (LinearLayout.LayoutParams)localc.zUN.jXI.getLayoutParams();
            if (i != 1) {
              break label2701;
            }
          }
          label2701:
          for (parama.gravity = 17;; parama.gravity = 19)
          {
            localc.zUN.jXI.setLayoutParams(parama);
            break;
            i = 0;
            break label2653;
          }
          label2710:
          localc.zUN.jXr.setBackgroundResource(2130838337);
          localc.zUN.zUO.setVisibility(0);
        }
      }
      parama = localc.zUI.gui;
      if (j > 1)
      {
        i = 8;
        label2758:
        parama.setVisibility(i);
        parama = localc.zUI.pUE;
        if ((j <= 1) && (!ah.isNullOrNil(paramString.fjL))) {
          break label3114;
        }
        i = 8;
        label2794:
        parama.setVisibility(i);
        parama = localc.zUI.pUs;
        if (j <= 1) {
          break label3120;
        }
      }
      label3114:
      label3120:
      for (i = 0;; i = 8)
      {
        parama.setVisibility(i);
        localc.zUI.pUt.setVisibility(8);
        if (j != 1) {
          break label3127;
        }
        localc.zUI.jXH.setBackgroundResource(2130838352);
        localc.zUI.gEY.setVisibility(0);
        dd(localc.zUI.jYA);
        dd(localc.zUI.jXH);
        if (ah.isNullOrNil(paramString.fjJ)) {
          break label3239;
        }
        localc.zUI.jYA.setVisibility(0);
        a(paramString.fjJ, localc.zUI.jXx, true, pUm, new u.j.2(this, j, localc));
        localc.zUI.gEY.setBackgroundResource(2130838328);
        parama = localc.zUI.gEY;
        i = jVw;
        k = jVx;
        int m = jVw;
        parama.setPadding(i, k, m, m);
        localc.zUI.jXH.setVisibility(0);
        localc.zUI.pUE.setText(paramString.fjL);
        localc.zUI.gui.setText(paramString.title);
        localc.zUI.pUs.af(paramString.title);
        if ((paramString.fjM != 0) && (paramString.fjM != 1)) {
          localc.zUI.pUs.setVisibility(4);
        }
        a(paramString, parambi, paramInt, localp, localc.zUI.jXr);
        break;
        i = 0;
        break label2758;
        i = 0;
        break label2794;
      }
      label3127:
      parama = localc.zUI.gEY;
      if (ah.isNullOrNil(paramString.fjJ)) {}
      for (i = 0;; i = 8)
      {
        parama.setVisibility(i);
        localc.zUI.jXH.setBackgroundResource(2130838354);
        localc.zUI.pUs.setTextColor(this.zzP.zJz.getContext().getResources().getColor(2131690208));
        localc.zUI.pUs.setBackgroundResource(2130839676);
        localc.zUI.pUs.getPaint().setFakeBoldText(true);
        break;
      }
      label3239:
      localc.zUI.jYA.setVisibility(8);
      localc.zUI.gui.setVisibility(0);
      parama = localc.zUI.pUE;
      if (ah.isNullOrNil(paramString.fjL))
      {
        i = 8;
        label3288:
        parama.setVisibility(i);
        if (j != 1) {
          break label3367;
        }
        localc.zUI.gEY.setBackgroundResource(2130838337);
      }
      for (;;)
      {
        parama = localc.zUI.gEY;
        i = jVw;
        k = jVw;
        parama.setPadding(i, i, k, k);
        localc.zUI.jXH.setVisibility(8);
        break;
        i = 0;
        break label3288;
        label3367:
        localc.zUI.gEY.setBackgroundResource(2130838336);
      }
      label3384:
      locala.jXs.setVisibility(8);
      break label868;
      label3397:
      locala.jXs.setVisibility(0);
      if (i <= 1) {
        break label857;
      }
      parama = (com.tencent.mm.af.q)localLinkedList.get(i - 1);
      localObject2 = (com.tencent.mm.af.q)localLinkedList.get(i);
      if (((parama.type != 7) && (parama.type != 5) && (parama.type != 6) && (ah.isNullOrNil(parama.fjJ))) || ((((com.tencent.mm.af.q)localObject2).type != 7) && (((com.tencent.mm.af.q)localObject2).type != 5) && (((com.tencent.mm.af.q)localObject2).type != 6) && (ah.isNullOrNil(((com.tencent.mm.af.q)localObject2).fjJ))))
      {
        R(locala.jXs, jVw);
        break label868;
      }
      R(locala.jXs, jVA);
      break label868;
      label3545:
      locala.jXt.setPadding(0, jVw, 0, jVy);
      break label899;
      label3564:
      if (i == j - 1)
      {
        locala.jXt.setPadding(0, jVy, 0, jVw);
        break label899;
      }
      locala.jXt.setPadding(0, jVy, 0, jVy);
      break label899;
      parama = parama.getResources().getString(2131298155);
      break label1027;
      parama = parama.getResources().getString(2131298156);
      break label1027;
      parama = parama.getResources().getString(2131298148);
      break label1027;
      if (!ah.isNullOrNil(((com.tencent.mm.af.q)localObject1).fjJ))
      {
        locala.jXx.setVisibility(0);
        parama = l.a((com.tencent.mm.af.q)localObject1);
        localObject2 = locala.jXx;
        k = jVv;
        a(parama, (ImageView)localObject2, k, k, new e.a()
        {
          public final void onFinish()
          {
            AppMethodBeat.i(33079);
            u.j.a(u.j.this, localc, locala, this.jYo, parambi, i);
            AppMethodBeat.o(33079);
          }
          
          public final void onStart() {}
        });
        break label1100;
      }
      if ((((com.tencent.mm.af.q)localObject1).type == 5) || (((com.tencent.mm.af.q)localObject1).type == 6))
      {
        locala.jXx.setVisibility(0);
        parama = locala.jXx;
        k = jVv;
        localObject2 = o.ahG();
        com.tencent.mm.at.a.a.c.a locala1 = new com.tencent.mm.at.a.a.c.a();
        locala1.eNK = true;
        locala1.eNY = 2131689878;
        locala1 = locala1.cx(k, k);
        locala1.fHt = 4;
        ((com.tencent.mm.at.a.a)localObject2).a("2130841217", parama, locala1.ahY(), null, new e());
        break label1100;
      }
      locala.jXw.setVisibility(8);
      break label1100;
      locala.jXw.setVisibility(8);
      locala.gui.setTextColor(parama1.zJz.getMMResources().getColor(2131690168));
      break label1100;
      label3878:
      locala.jXv.setVisibility(8);
      break label1142;
      label3891:
      parama = new az(parambi, false, paramInt, ((com.tencent.mm.af.q)localObject1).url, this.zUP, parama1.dHF(), localp.cGN, localp.cGO);
      a(parama, (com.tencent.mm.af.q)localObject1, parambi);
      locala.jXr.setOnClickListener(h(parama1));
    }
    label3951:
    if (((b)g.E(b.class)).rU(2))
    {
      paramInt = 0;
      while (paramInt < localLinkedList.size())
      {
        parama = (com.tencent.mm.af.q)localLinkedList.get(paramInt);
        if (!TextUtils.isEmpty(parama.url)) {
          ((b)g.E(b.class)).a(parama.url, parama.type, 0, new Object[0]);
        }
        paramInt += 1;
      }
    }
    AppMethodBeat.o(33088);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(33097);
    Object localObject = (az)paramView.getTag();
    if (localObject == null)
    {
      AppMethodBeat.o(33097);
      return false;
    }
    this.zUQ = ((az)localObject).uXa;
    int i = ((az)localObject).position;
    localObject = ((com.tencent.mm.plugin.biz.a.a)g.E(com.tencent.mm.plugin.biz.a.a.class)).b(parambi.field_msgId, parambi.field_content);
    if (localObject == null)
    {
      ab.w("MicroMsg.ChattingItemBizFrom", "onCreateContextMenu reader is null");
      AppMethodBeat.o(33097);
      return false;
    }
    this.jYr = false;
    if ((this.zUQ >= 0) && (this.zUQ < ((com.tencent.mm.af.p)localObject).fjy.size()) && (l.na(((com.tencent.mm.af.q)((com.tencent.mm.af.p)localObject).fjy.get(this.zUQ)).fjO))) {
      this.jYr = true;
    }
    if ((!this.zzP.dJH()) && (!com.tencent.mm.ui.chatting.j.aF(parambi))) {
      paramContextMenu.add(i, 111, 0, paramView.getContext().getString(2131302650));
    }
    if ((com.tencent.mm.bq.d.ahR("favorite")) && (!this.jYr)) {
      paramContextMenu.add(i, 126, 0, paramView.getContext().getString(2131302102));
    }
    AppMethodBeat.o(33097);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(33101);
    this.jYq = ah.aox();
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(33101);
      return false;
      if (this.jYr)
      {
        if (!this.jYr) {
          ab.w("MicroMsg.ChattingItemBizFrom", "transmitAppBrandMsg not AppBrandMsg!");
        }
        for (;;)
        {
          AppMethodBeat.o(33101);
          return false;
          r.a(this.zUQ, parama.zJz.getContext(), parambi.field_content, parambi.field_talker, parambi.field_msgId, parambi.field_msgSvrId);
        }
      }
      String str = a(parambi, parama.zJz.getContext(), this.zUQ);
      if (!ah.isNullOrNil(str))
      {
        paramMenuItem = new Intent(parama.zJz.getContext(), MsgRetransmitUI.class);
        paramMenuItem.putExtra("Retr_Msg_content", str);
        paramMenuItem.putExtra("Retr_Msg_Type", 2);
        paramMenuItem.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.zUQ);
        paramMenuItem.putExtra("Retr_Msg_Id", parambi.field_msgId);
        paramMenuItem.putExtra("Retr_MsgFromScene", 1);
        str = parambi.field_talker;
        Object localObject = v.oQ(parambi.field_msgSvrId);
        paramMenuItem.putExtra("reportSessionId", (String)localObject);
        localObject = v.aae().z((String)localObject, true);
        ((v.b)localObject).i("prePublishId", "msg_" + parambi.field_msgSvrId);
        ((v.b)localObject).i("preUsername", str);
        ((v.b)localObject).i("preChatName", str);
        ((v.b)localObject).i("preMsgIndex", Integer.valueOf(this.zUQ));
        ((v.b)localObject).i("sendAppMsgScene", Integer.valueOf(1));
        parama.startActivity(paramMenuItem);
        continue;
        paramMenuItem = a(parambi, parama.zJz.getContext(), 0);
        if (!ah.isNullOrNil(paramMenuItem))
        {
          al.c(parambi, paramMenuItem, parama.zJz.getContext());
          continue;
          r.a(this.jYq, this.zUQ, parama.zJz.getContext(), parama.zJz, null, parambi);
        }
      }
    }
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return paramInt == 285212721;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    return false;
  }
  
  protected final boolean dLo()
  {
    return false;
  }
  
  public final boolean dLp()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.j
 * JD-Core Version:    0.7.0.1
 */