package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.base.AnimImageView;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.c.b.aj;
import com.tencent.mm.ui.chatting.c.b.f;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.d;

public final class ao$c
  extends c.a
{
  TextView zRY;
  ImageView zSm;
  TextView zVQ;
  int zXN;
  TextView zXO;
  TextView zXP;
  AnimImageView zXQ;
  FrameLayout zXR;
  FrameLayout zXS;
  ImageView zXT;
  AnimImageView zXU;
  ProgressBar zXV;
  TextView zXW;
  Animation zXX;
  ViewStub zXh;
  ChattingItemTranslate zXi;
  
  private static void a(c paramc, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(33377);
    paramc.zRC.setVisibility(paramInt2);
    paramc.zVQ.setVisibility(paramInt2);
    paramc.zXR.setVisibility(paramInt2);
    if (paramBoolean)
    {
      paramc.zXU.setVisibility(paramInt1);
      paramc.zRY.setVisibility(paramInt2);
      AppMethodBeat.o(33377);
      return;
    }
    paramc.zXW.setVisibility(paramInt1);
    AppMethodBeat.o(33377);
  }
  
  public static void a(c paramc, bi parambi, int paramInt, com.tencent.mm.ui.chatting.d.a parama, boolean paramBoolean, View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(33374);
    if (paramc == null)
    {
      AppMethodBeat.o(33374);
      return;
    }
    Object localObject = new p(parambi.field_content);
    float f1 = s.hi(((p)localObject).time);
    d locald = ((aj)parama.ay(aj.class)).dJv();
    label220:
    float f2;
    if ((locald != null) && (parambi.field_msgId == locald.zwt))
    {
      paramc.zXQ.setVisibility(0);
      paramc.zXQ.dDA();
      if (parambi.field_isSend != 0) {
        break label729;
      }
      if (((p)localObject).time != 0L) {
        break label525;
      }
      a(paramc, 8, 0, true);
      paramc.zXU.cgf();
      paramc.zXU.setVisibility(8);
      paramc.zRC.setVisibility(8);
      f1 = 0.0F;
      paramc.zXN = com.tencent.mm.cb.a.fromDPToPix(parama.zJz.getContext(), yP(0));
      paramc.zXP.setWidth(paramc.zXN);
      paramc.zVQ.setText(parama.zJz.getMMResources().getString(2131300103, new Object[] { Integer.valueOf(0) }));
      paramc.zXQ.setWidth(com.tencent.mm.cb.a.fromDPToPix(parama.zJz.getContext(), yP(0)));
      f2 = f1;
      if (1 != parambi.field_isSend) {
        break label1024;
      }
      if (parambi.field_status != 1) {
        break label732;
      }
      a(paramc, 0, 8, false);
      paramc.zXS.setVisibility(8);
      paramc.dLx();
      label261:
      localObject = ((com.tencent.mm.ui.chatting.c.b.c)parama.ay(com.tencent.mm.ui.chatting.c.b.c.class)).dHS();
      if (localObject != null)
      {
        if (!((e)localObject).vQg) {
          break label1031;
        }
        paramc.zVQ.setShadowLayer(2.0F, 1.2F, 1.2F, ((e)localObject).vQh);
        label307:
        if (!((e)localObject).vQi) {
          break label1045;
        }
        paramc.zVQ.setBackgroundResource(2130838366);
      }
      label324:
      localObject = new ChattingItemTranslate.a(parambi, parama.dJG(), paramInt);
      paramc.zXP.setTag(localObject);
      paramc.zXP.setOnClickListener(paramc.zRE.d(parama));
      paramc.zXP.setOnLongClickListener(paramOnLongClickListener);
      paramc.zXP.setOnTouchListener(((h)parama.ay(h.class)).dHi());
      if ((parambi.dnr & 0x1) != 1) {
        break label1079;
      }
      paramc.zXO.setVisibility(0);
      if (parambi.field_isSend != 0) {
        break label1056;
      }
      paramc.zXQ.setBackgroundResource(2130838280);
      label428:
      if (!paramBoolean) {
        break label1131;
      }
      parama.getTalkerUserName();
    }
    for (;;)
    {
      parambi = ((f)parama.ay(f.class)).atS(parama.getTalkerUserName());
      parama = a.a.dDt();
      paramOnLongClickListener = paramc.zXP;
      paramInt = (int)f1;
      if (parambi != null) {
        parambi.toString();
      }
      parama.al(paramOnLongClickListener, paramInt);
      paramc.zVQ.setContentDescription(" ");
      AppMethodBeat.o(33374);
      return;
      paramc.zXQ.setVisibility(8);
      paramc.zXQ.cgf();
      break;
      label525:
      if (((p)localObject).time == -1L)
      {
        a(paramc, 8, 0, true);
        paramc.zXU.cgf();
        paramc.zXU.setVisibility(8);
        paramc.zXN = 80;
        paramc.zXP.setWidth(80);
        paramc.zVQ.setVisibility(8);
        paramc.zXQ.setWidth(com.tencent.mm.cb.a.fromDPToPix(parama.zJz.getContext(), yP((int)f1)));
        break label220;
      }
      a(paramc, 8, 0, true);
      paramc.zXU.cgf();
      paramc.zXU.setVisibility(8);
      paramc.zVQ.setVisibility(0);
      paramc.zXN = com.tencent.mm.cb.a.fromDPToPix(parama.zJz.getContext(), yP((int)f1));
      paramc.zXP.setWidth(paramc.zXN);
      paramc.zVQ.setText(parama.zJz.getMMResources().getString(2131300103, new Object[] { Integer.valueOf((int)f1) }));
      paramc.zXQ.setWidth(com.tencent.mm.cb.a.fromDPToPix(parama.zJz.getContext(), yP((int)f1)));
      label729:
      break label220;
      label732:
      if (((p)localObject).time == -1L)
      {
        a(paramc, 8, 0, false);
        paramc.zXP.setWidth(80);
        paramc.zXN = 80;
        paramc.zVQ.setVisibility(8);
        paramc.zXS.setVisibility(8);
        paramc.zXQ.setWidth(com.tencent.mm.cb.a.fromDPToPix(parama.zJz.getContext(), yP((int)f1)));
        paramc.dLx();
        break label261;
      }
      if (parambi.field_status == 7)
      {
        a(paramc, 8, 8, false);
        paramc.zVQ.setVisibility(8);
        paramc.zXS.setVisibility(0);
        paramc.dLx();
        if (paramc.zXT != null)
        {
          paramc.zXX = AnimationUtils.loadAnimation(paramc.ngZ.getContext(), 2131034289);
          paramc.zXT.startAnimation(paramc.zXX);
        }
        break label261;
      }
      a(paramc, 8, 0, false);
      paramc.zXS.setVisibility(8);
      paramc.zVQ.setVisibility(0);
      paramc.dLx();
      if (((p)localObject).time == 0L) {
        f1 = 0.0F;
      }
      paramc.zXN = com.tencent.mm.cb.a.fromDPToPix(parama.zJz.getContext(), yP((int)f1));
      paramc.zXP.setWidth(paramc.zXN);
      paramc.zVQ.setText(parama.zJz.getMMResources().getString(2131300103, new Object[] { Integer.valueOf((int)f1) }));
      paramc.zXQ.setWidth(com.tencent.mm.cb.a.fromDPToPix(parama.zJz.getContext(), yP((int)f1)));
      f2 = f1;
      label1024:
      f1 = f2;
      break label261;
      label1031:
      paramc.zVQ.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      break label307;
      label1045:
      paramc.zVQ.setBackgroundColor(0);
      break label324;
      label1056:
      paramc.zXW.setBackgroundResource(2130838372);
      paramc.zXQ.setBackgroundResource(2130838372);
      break label428;
      label1079:
      paramc.zXO.setVisibility(8);
      if (parambi.field_isSend == 0)
      {
        paramc.zXQ.setBackgroundResource(2130838263);
        break label428;
      }
      paramc.zXW.setBackgroundResource(2130838367);
      paramc.zXQ.setBackgroundResource(2130838367);
      break label428;
      label1131:
      parama.dJD();
    }
  }
  
  private void dLx()
  {
    AppMethodBeat.i(33376);
    if (this.zXX != null)
    {
      this.zXX.cancel();
      this.zXX = null;
    }
    AppMethodBeat.o(33376);
  }
  
  static void f(Context paramContext, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(33375);
    Intent localIntent = new Intent(paramContext, TextPreviewUI.class);
    localIntent.putExtra("key_chat_text", paramCharSequence);
    paramContext.startActivity(localIntent);
    b.jdMethod_if(paramContext);
    AppMethodBeat.o(33375);
  }
  
  private static int yP(int paramInt)
  {
    if (paramInt <= 2) {
      return 80;
    }
    if (paramInt < 10) {
      return (paramInt - 2) * 9 + 80;
    }
    if (paramInt < 60) {
      return (paramInt / 10 + 7) * 9 + 80;
    }
    return 204;
  }
  
  public final c.a c(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(33373);
    super.eV(paramView);
    this.ekh = ((TextView)paramView.findViewById(2131820587));
    this.qFY = ((TextView)paramView.findViewById(2131821122));
    this.zXP = ((TextView)paramView.findViewById(2131822693));
    this.mCC = ((CheckBox)paramView.findViewById(2131820579));
    this.jbK = paramView.findViewById(2131820586);
    this.zRC = ((ImageView)paramView.findViewById(2131822695));
    this.zVQ = ((TextView)paramView.findViewById(2131821123));
    this.zXR = ((FrameLayout)paramView.findViewById(2131822692));
    this.zXh = ((ViewStub)paramView.findViewById(2131822575));
    this.zXO = ((TextView)paramView.findViewById(2131822689));
    this.zXQ = ((AnimImageView)paramView.findViewById(2131822694));
    this.zXQ.setType(1);
    if (paramBoolean1)
    {
      this.zXQ.setFromVoice(true);
      this.zXQ.setFromGroup(paramBoolean2);
      this.zRY = ((TextView)paramView.findViewById(2131822518));
      this.zXU = ((AnimImageView)paramView.findViewById(2131822690));
      this.zXU.setFromVoice(true);
      this.zXU.setFromGroup(paramBoolean2);
      this.zXU.setType(0);
    }
    for (;;)
    {
      AppMethodBeat.o(33373);
      return this;
      this.zXS = ((FrameLayout)paramView.findViewById(2131822740));
      this.zXT = ((ImageView)paramView.findViewById(2131822741));
      this.zXV = ((ProgressBar)paramView.findViewById(2131822739));
      this.pNd = ((ProgressBar)paramView.findViewById(2131822728));
      this.zXW = ((TextView)paramView.findViewById(2131822738));
      this.zXQ.setFromVoice(false);
      this.zXQ.setFromGroup(paramBoolean2);
      this.zSm = ((ImageView)paramView.findViewById(2131822729));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ao.c
 * JD-Core Version:    0.7.0.1
 */