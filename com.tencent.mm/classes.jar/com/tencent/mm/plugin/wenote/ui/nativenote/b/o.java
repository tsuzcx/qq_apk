package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.h;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteVoiceView;
import com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteVoiceView.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class o
  extends i
{
  private LinearLayout fmL;
  private final ah rGl = new o.2(this);
  public LinearLayout rMI;
  public LinearLayout rMJ;
  public ImageView rML;
  private TextView rMM;
  private TextView rMN;
  private l rMO;
  public NoteVoiceView rND;
  
  public o(View paramView, k paramk)
  {
    super(paramView, paramk);
    this.fmL = ((LinearLayout)paramView.findViewById(R.h.note_voice_ll));
    this.rMI = ((LinearLayout)paramView.findViewById(R.h.note_voice_record_ll));
    this.rMJ = ((LinearLayout)paramView.findViewById(R.h.note_voice_play_ll));
    this.rML = ((ImageView)paramView.findViewById(R.h.note_voice_record_red_point));
    this.rMM = ((TextView)paramView.findViewById(R.h.note_voice_recording_tips));
    this.rMN = ((TextView)paramView.findViewById(R.h.note_voice_recording_tips_time));
    this.rND = ((NoteVoiceView)paramView.findViewById(R.h.note_editor_voice_player));
    this.rND.setVoiceHelper(com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.cjx());
    this.fmL.setVisibility(0);
    this.rMI.setVisibility(8);
    this.rMJ.setVisibility(0);
    this.bNu.setVisibility(8);
    this.rNa.setVisibility(8);
    this.fmL.setOnClickListener(new o.1(this));
  }
  
  public final void a(c paramc, int paramInt1, int paramInt2)
  {
    this.rMO = ((l)paramc);
    if (this.rMO.rGJ)
    {
      this.fmL.setBackgroundResource(0);
      this.rMJ.setVisibility(0);
      this.rMI.setVisibility(8);
      this.fmL.setPadding(0, 0, 0, 0);
      if (!paramc.rGu) {
        break label583;
      }
    }
    label294:
    label307:
    label583:
    for (int i = 1;; i = 0)
    {
      Object localObject1 = this.rND;
      Object localObject2 = this.rMO.bTY;
      int j = this.rMO.bNM;
      int k = this.rMO.bNN;
      ((NoteVoiceView)localObject1).path = bk.aM((String)localObject2, "");
      ((NoteVoiceView)localObject1).bNM = j;
      ((NoteVoiceView)localObject1).duration = k;
      if (i != 0)
      {
        ((NoteVoiceView)localObject1).hoY.setVisibility(0);
        if (!((NoteVoiceView)localObject1).path.equals(((NoteVoiceView)localObject1).rNJ.path)) {
          break label307;
        }
        if (!((NoteVoiceView)localObject1).rNJ.aQk()) {
          break label217;
        }
        y.i("MicroMsg.NoteVoiceView", "updateInfo .isPlay()");
        localObject2 = ((NoteVoiceView)localObject1).rNK;
        ((NoteVoiceView)localObject1).rNJ.ue();
        ((NoteVoiceView.a)localObject2).lK(true);
      }
      for (;;)
      {
        super.a(paramc, paramInt1, paramInt2);
        return;
        ((NoteVoiceView)localObject1).hoY.setVisibility(8);
        break;
        label217:
        localObject2 = ((NoteVoiceView)localObject1).rNJ;
        if (((com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a)localObject2).jZC == null) {
          y.w("MicroMsg.RecordVoiceHelper", "check is pause, but player is null");
        }
        for (boolean bool = false;; bool = ((com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a)localObject2).jZC.uf())
        {
          if (!bool) {
            break label294;
          }
          y.i("MicroMsg.NoteVoiceView", "updateInfo .isPause()");
          localObject2 = ((NoteVoiceView)localObject1).rNK;
          ((NoteVoiceView)localObject1).rNJ.ue();
          ((NoteVoiceView.a)localObject2).lK(false);
          break;
        }
        ((NoteVoiceView)localObject1).rNK.Du(k);
        continue;
        ((NoteVoiceView)localObject1).rNK.Du(k);
        continue;
        this.fmL.setBackgroundResource(R.g.wenote_voice_basecard_bg);
        this.fmL.setPadding(26, 7, 0, 7);
        this.rMJ.setVisibility(8);
        this.rMI.setVisibility(0);
        localObject1 = this.rML;
        if (((ImageView)localObject1).getAnimation() != null) {
          ((ImageView)localObject1).startAnimation(((ImageView)localObject1).getAnimation());
        }
        for (;;)
        {
          if (!this.rMO.rGB.booleanValue()) {
            break label520;
          }
          this.rGl.sendEmptyMessage(4096);
          this.rMM.setText(R.l.favorite_wenote_voice_recording);
          localObject1 = " " + com.tencent.mm.bj.a.x(ae.getContext(), this.rMO.rGW).toString();
          this.rMN.setText((CharSequence)localObject1);
          break;
          localObject2 = new AlphaAnimation(1.0F, 0.0F);
          ((Animation)localObject2).setDuration(500L);
          ((Animation)localObject2).setInterpolator(new LinearInterpolator());
          ((Animation)localObject2).setRepeatCount(-1);
          ((Animation)localObject2).setRepeatMode(2);
          ((ImageView)localObject1).startAnimation((Animation)localObject2);
        }
        this.rMM.setText(R.l.favorite_wenote_voice_downloading);
        localObject1 = " " + com.tencent.mm.bj.a.x(ae.getContext(), (int)com.tencent.mm.bj.a.ck(this.rMO.bNN)).toString();
        this.rMN.setText((CharSequence)localObject1);
      }
    }
  }
  
  public final int cjv()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b.o
 * JD-Core Version:    0.7.0.1
 */