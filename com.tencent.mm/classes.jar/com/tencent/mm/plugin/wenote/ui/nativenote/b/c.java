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
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteEditorVoiceBaseView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;

public final class c
  extends i
{
  private final ah rGl = new c.2(this);
  public LinearLayout rMI;
  public LinearLayout rMJ;
  public NoteEditorVoiceBaseView rMK;
  public ImageView rML;
  private TextView rMM;
  private TextView rMN;
  private l rMO;
  
  public c(View paramView, k paramk)
  {
    super(paramView, paramk);
    this.rMI = ((LinearLayout)paramView.findViewById(R.h.note_voice_record_ll));
    this.rMJ = ((LinearLayout)paramView.findViewById(R.h.note_chatvoice_play_ll));
    this.rML = ((ImageView)paramView.findViewById(R.h.note_voice_record_red_point));
    this.rMM = ((TextView)paramView.findViewById(R.h.note_voice_recording_tips));
    this.rMN = ((TextView)paramView.findViewById(R.h.note_voice_recording_tips_time));
    this.rMK = ((NoteEditorVoiceBaseView)paramView.findViewById(R.h.note_editor_chatvoice_player));
    com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.cjx().a(this.rMK);
    this.fmL.setVisibility(0);
    this.rMI.setVisibility(8);
    this.rMJ.setVisibility(0);
    this.bNu.setVisibility(8);
    this.rNa.setVisibility(8);
    this.fmL.setOnClickListener(new c.1(this));
  }
  
  public final void a(com.tencent.mm.plugin.wenote.model.a.c paramc, int paramInt1, int paramInt2)
  {
    this.rMO = ((l)paramc);
    Object localObject1;
    Object localObject2;
    if (this.rMO.rGJ)
    {
      this.rMJ.setVisibility(0);
      this.rMI.setVisibility(8);
      this.fmL.setPadding(0, 0, 0, 0);
      if (paramc.rGu)
      {
        this.rMK.setBackgroundResource(R.g.wenote_basecard_pressed_bg);
        localObject1 = this.rMK;
        localObject2 = this.rMO.bTY;
        int i = this.rMO.bNM;
        String str = this.rMO.rGX;
        ((NoteEditorVoiceBaseView)localObject1).path = bk.aM((String)localObject2, "");
        ((NoteEditorVoiceBaseView)localObject1).bNM = i;
        ((NoteEditorVoiceBaseView)localObject1).setText(str);
      }
    }
    for (;;)
    {
      super.a(paramc, paramInt1, paramInt2);
      return;
      this.rMK.setBackgroundResource(R.g.wenote_basecard_bg);
      break;
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
          break label332;
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
      label332:
      this.rMM.setText(R.l.favorite_wenote_voice_downloading);
      localObject1 = " " + com.tencent.mm.bj.a.x(ae.getContext(), (int)com.tencent.mm.bj.a.ck(this.rMO.bNN)).toString();
      this.rMN.setText((CharSequence)localObject1);
    }
  }
  
  public final int cjv()
  {
    return 20;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b.c
 * JD-Core Version:    0.7.0.1
 */