package com.tencent.mm.ui.chatting.viewitems;

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
import com.tencent.mm.R.a;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.base.AnimImageView;
import com.tencent.mm.ui.chatting.b.b.ai;
import com.tencent.mm.ui.chatting.b.b.b;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.d;

public final class al$c
  extends c.a
{
  ImageView vBN;
  TextView vBz;
  TextView vEC;
  ViewStub vFQ;
  ChattingItemTranslate vFR;
  TextView vGA;
  Animation vGB;
  int vGr;
  TextView vGs;
  TextView vGt;
  AnimImageView vGu;
  FrameLayout vGv;
  FrameLayout vGw;
  ImageView vGx;
  AnimImageView vGy;
  ProgressBar vGz;
  
  private static void a(c paramc, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramc.vBa.setVisibility(paramInt2);
    paramc.vEC.setVisibility(paramInt2);
    paramc.vGv.setVisibility(paramInt2);
    if (paramBoolean)
    {
      paramc.vGy.setVisibility(paramInt1);
      paramc.vBz.setVisibility(paramInt2);
      return;
    }
    paramc.vGA.setVisibility(paramInt1);
  }
  
  public static void a(c paramc, bi parambi, int paramInt, com.tencent.mm.ui.chatting.c.a parama, boolean paramBoolean, View.OnLongClickListener paramOnLongClickListener)
  {
    if (paramc == null) {
      return;
    }
    Object localObject = new n(parambi.field_content);
    float f1 = q.ck(((n)localObject).time);
    d locald = ((ai)parama.ac(ai.class)).cFx();
    label216:
    float f2;
    if ((locald != null) && (parambi.field_msgId == locald.vhz))
    {
      paramc.vGu.setVisibility(0);
      paramc.vGu.cAq();
      if (parambi.field_isSend != 0) {
        break label750;
      }
      if (((n)localObject).time != 0L) {
        break label535;
      }
      parambi.cvI();
      a(paramc, 8, 0, true);
      paramc.vGy.bvP();
      paramc.vGy.setVisibility(8);
      paramc.vBa.setVisibility(8);
      f1 = 0.0F;
      paramc.vGr = com.tencent.mm.cb.a.fromDPToPix(parama.vtz.getContext(), oq(0));
      paramc.vGt.setWidth(paramc.vGr);
      paramc.vEC.setText(parama.vtz.getMMResources().getString(R.l.fmt_time_length, new Object[] { Integer.valueOf(0) }));
      paramc.vGu.setWidth(com.tencent.mm.cb.a.fromDPToPix(parama.vtz.getContext(), oq(0)));
      f2 = f1;
      if (1 != parambi.field_isSend) {
        break label1061;
      }
      if (parambi.field_status != 1) {
        break label753;
      }
      parambi.cvI();
      a(paramc, 0, 8, false);
      paramc.vGw.setVisibility(8);
      paramc.cHh();
      label262:
      localObject = ((b)parama.ac(b.class)).cEc();
      if (localObject != null)
      {
        paramc.vEC.setTextColor(((com.tencent.mm.pluginsdk.ui.e)localObject).rZo);
        if (!((com.tencent.mm.pluginsdk.ui.e)localObject).rZp) {
          break label1068;
        }
        paramc.vEC.setShadowLayer(2.0F, 1.2F, 1.2F, ((com.tencent.mm.pluginsdk.ui.e)localObject).rZq);
        label320:
        if (!((com.tencent.mm.pluginsdk.ui.e)localObject).rZr) {
          break label1082;
        }
        paramc.vEC.setBackgroundResource(R.g.chatting_voice_second_bg);
      }
      label338:
      localObject = new ChattingItemTranslate.a(parambi, parama.cFE(), paramInt);
      paramc.vGt.setTag(localObject);
      paramc.vGt.setOnClickListener(paramc.vBc.d(parama));
      paramc.vGt.setOnLongClickListener(paramOnLongClickListener);
      paramc.vGt.setOnTouchListener(((g)parama.ac(g.class)).cDu());
      if ((parambi.czq & 0x1) != 1) {
        break label1116;
      }
      paramc.vGs.setVisibility(0);
      if (parambi.field_isSend != 0) {
        break label1093;
      }
      paramc.vGu.setBackgroundResource(R.g.chatfrom_bg_voice_forward);
      label443:
      if (!paramBoolean) {
        break label1168;
      }
      parama.getTalkerUserName();
    }
    for (;;)
    {
      parambi = ((com.tencent.mm.ui.chatting.b.b.e)parama.ac(com.tencent.mm.ui.chatting.b.b.e.class)).adr(parama.getTalkerUserName());
      parama = a.a.cAj();
      paramOnLongClickListener = paramc.vGt;
      paramInt = (int)f1;
      if (parambi != null) {
        parambi.toString();
      }
      parama.S(paramOnLongClickListener, paramInt);
      paramc.vEC.setContentDescription(" ");
      return;
      paramc.vGu.setVisibility(8);
      paramc.vGu.bvP();
      break;
      label535:
      if (((n)localObject).time == -1L)
      {
        parambi.cvI();
        a(paramc, 8, 0, true);
        paramc.vGy.bvP();
        paramc.vGy.setVisibility(8);
        paramc.vGr = 80;
        paramc.vGt.setWidth(80);
        paramc.vEC.setVisibility(8);
        paramc.vGu.setWidth(com.tencent.mm.cb.a.fromDPToPix(parama.vtz.getContext(), oq((int)f1)));
        break label216;
      }
      parambi.cvI();
      a(paramc, 8, 0, true);
      paramc.vGy.bvP();
      paramc.vGy.setVisibility(8);
      paramc.vEC.setVisibility(0);
      paramc.vGr = com.tencent.mm.cb.a.fromDPToPix(parama.vtz.getContext(), oq((int)f1));
      paramc.vGt.setWidth(paramc.vGr);
      paramc.vEC.setText(parama.vtz.getMMResources().getString(R.l.fmt_time_length, new Object[] { Integer.valueOf((int)f1) }));
      paramc.vGu.setWidth(com.tencent.mm.cb.a.fromDPToPix(parama.vtz.getContext(), oq((int)f1)));
      label750:
      break label216;
      label753:
      if (((n)localObject).time == -1L)
      {
        parambi.cvI();
        a(paramc, 8, 0, false);
        paramc.vGt.setWidth(80);
        paramc.vGr = 80;
        paramc.vEC.setVisibility(8);
        paramc.vGw.setVisibility(8);
        paramc.vGu.setWidth(com.tencent.mm.cb.a.fromDPToPix(parama.vtz.getContext(), oq((int)f1)));
        paramc.cHh();
        break label262;
      }
      if (parambi.field_status == 7)
      {
        parambi.cvI();
        a(paramc, 8, 8, false);
        paramc.vEC.setVisibility(8);
        paramc.vGw.setVisibility(0);
        paramc.cHh();
        if (paramc.vGx != null)
        {
          paramc.vGB = AnimationUtils.loadAnimation(paramc.kKz.getContext(), R.a.voice_recording_animation);
          paramc.vGx.startAnimation(paramc.vGB);
        }
        break label262;
      }
      parambi.cvI();
      a(paramc, 8, 0, false);
      paramc.vGw.setVisibility(8);
      paramc.vEC.setVisibility(0);
      paramc.cHh();
      if (((n)localObject).time == 0L) {
        f1 = 0.0F;
      }
      paramc.vGr = com.tencent.mm.cb.a.fromDPToPix(parama.vtz.getContext(), oq((int)f1));
      paramc.vGt.setWidth(paramc.vGr);
      paramc.vEC.setText(parama.vtz.getMMResources().getString(R.l.fmt_time_length, new Object[] { Integer.valueOf((int)f1) }));
      paramc.vGu.setWidth(com.tencent.mm.cb.a.fromDPToPix(parama.vtz.getContext(), oq((int)f1)));
      f2 = f1;
      label1061:
      f1 = f2;
      break label262;
      label1068:
      paramc.vEC.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      break label320;
      label1082:
      paramc.vEC.setBackgroundColor(0);
      break label338;
      label1093:
      paramc.vGA.setBackgroundResource(R.g.chatto_bg_voice_forward);
      paramc.vGu.setBackgroundResource(R.g.chatto_bg_voice_forward);
      break label443;
      label1116:
      paramc.vGs.setVisibility(8);
      if (parambi.field_isSend == 0)
      {
        paramc.vGu.setBackgroundResource(R.g.chatfrom_bg);
        break label443;
      }
      paramc.vGA.setBackgroundResource(R.g.chatto_bg);
      paramc.vGu.setBackgroundResource(R.g.chatto_bg);
      break label443;
      label1168:
      parama.cFB();
    }
  }
  
  private void cHh()
  {
    if (this.vGB != null)
    {
      this.vGB.cancel();
      this.vGB = null;
    }
  }
  
  private static int oq(int paramInt)
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
  
  public final c.a b(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.dN(paramView);
    this.dsz = ((TextView)paramView.findViewById(R.h.chatting_time_tv));
    this.nSa = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
    this.vGt = ((TextView)paramView.findViewById(R.h.chatting_voice_play_anim_tv));
    this.khV = ((CheckBox)paramView.findViewById(R.h.chatting_checkbox));
    this.hoY = paramView.findViewById(R.h.chatting_maskview);
    this.vBa = ((ImageView)paramView.findViewById(R.h.chatting_state_iv));
    this.vEC = ((TextView)paramView.findViewById(R.h.chatting_content_itv));
    this.vGv = ((FrameLayout)paramView.findViewById(R.h.chatting_voice_play_content));
    this.vFQ = ((ViewStub)paramView.findViewById(R.h.translate_item_vs));
    this.vGs = ((TextView)paramView.findViewById(R.h.chatting_voice_forwardflag));
    this.vGu = ((AnimImageView)paramView.findViewById(R.h.chatting_voice_anim));
    this.vGu.setType(1);
    if (paramBoolean1)
    {
      this.vGu.setFromVoice(true);
      this.vGu.setFromGroup(paramBoolean2);
      this.vBz = ((TextView)paramView.findViewById(R.h.chatting_appmsg_comment_tv));
      this.vGy = ((AnimImageView)paramView.findViewById(R.h.chatting_voice_loading));
      this.vGy.setFromVoice(true);
      this.vGy.setFromGroup(paramBoolean2);
      this.vGy.setType(0);
      return this;
    }
    this.vGw = ((FrameLayout)paramView.findViewById(R.h.chatting_voice_recording));
    this.vGx = ((ImageView)paramView.findViewById(R.h.chatting_voice_recording_hl));
    this.vGz = ((ProgressBar)paramView.findViewById(R.h.chatting_voice_sending));
    this.nhQ = ((ProgressBar)paramView.findViewById(R.h.uploading_pb));
    this.vGA = ((TextView)paramView.findViewById(R.h.chatting_voice_sending_bg));
    this.vGu.setFromVoice(false);
    this.vGu.setFromGroup(paramBoolean2);
    this.vBN = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.al.c
 * JD-Core Version:    0.7.0.1
 */