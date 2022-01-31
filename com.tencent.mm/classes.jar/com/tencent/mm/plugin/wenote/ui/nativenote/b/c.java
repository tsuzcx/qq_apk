package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteEditorVoiceBaseView;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

public final class c
  extends i
{
  public LinearLayout vDm;
  public LinearLayout vDn;
  public NoteEditorVoiceBaseView vDo;
  public ImageView vDp;
  private TextView vDq;
  private TextView vDr;
  private l vDs;
  private final ak vwU;
  
  public c(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(27153);
    this.vwU = new c.2(this);
    this.vDm = ((LinearLayout)paramView.findViewById(2131826585));
    this.vDn = ((LinearLayout)paramView.findViewById(2131826591));
    this.vDp = ((ImageView)paramView.findViewById(2131826586));
    this.vDq = ((TextView)paramView.findViewById(2131826587));
    this.vDr = ((TextView)paramView.findViewById(2131826588));
    this.vDo = ((NoteEditorVoiceBaseView)paramView.findViewById(2131826592));
    com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.djZ().a(this.vDo);
    this.gEf.setVisibility(0);
    this.vDm.setVisibility(8);
    this.vDn.setVisibility(0);
    this.cuM.setVisibility(8);
    this.vDE.setVisibility(8);
    this.gEf.setOnClickListener(new c.1(this));
    AppMethodBeat.o(27153);
  }
  
  public final void a(com.tencent.mm.plugin.wenote.model.a.c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(27154);
    this.vDs = ((l)paramc);
    Object localObject1;
    Object localObject2;
    if (this.vDs.vxs)
    {
      this.vDn.setVisibility(0);
      this.vDm.setVisibility(8);
      this.gEf.setPadding(0, 0, 0, 0);
      if (paramc.vxd)
      {
        this.vDo.setBackgroundResource(2130840937);
        localObject1 = this.vDo;
        localObject2 = this.vDs.cBD;
        int i = this.vDs.cve;
        String str = this.vDs.vxF;
        ((NoteEditorVoiceBaseView)localObject1).path = bo.bf((String)localObject2, "");
        ((NoteEditorVoiceBaseView)localObject1).cve = i;
        ((NoteEditorVoiceBaseView)localObject1).setText(str);
      }
    }
    for (;;)
    {
      super.a(paramc, paramInt1, paramInt2);
      AppMethodBeat.o(27154);
      return;
      this.vDo.setBackgroundResource(2130840936);
      break;
      this.gEf.setPadding(26, 7, 0, 7);
      this.vDn.setVisibility(8);
      this.vDm.setVisibility(0);
      localObject1 = this.vDp;
      if (((ImageView)localObject1).getAnimation() != null) {
        ((ImageView)localObject1).startAnimation(((ImageView)localObject1).getAnimation());
      }
      for (;;)
      {
        if (!this.vDs.vxk.booleanValue()) {
          break label341;
        }
        this.vwU.sendEmptyMessage(4096);
        this.vDq.setText(2131299862);
        localObject1 = " " + com.tencent.mm.bk.a.C(ah.getContext(), this.vDs.vxE).toString();
        this.vDr.setText((CharSequence)localObject1);
        break;
        localObject2 = new AlphaAnimation(1.0F, 0.0F);
        ((Animation)localObject2).setDuration(500L);
        ((Animation)localObject2).setInterpolator(new LinearInterpolator());
        ((Animation)localObject2).setRepeatCount(-1);
        ((Animation)localObject2).setRepeatMode(2);
        ((ImageView)localObject1).startAnimation((Animation)localObject2);
      }
      label341:
      this.vDq.setText(2131299861);
      localObject1 = " " + com.tencent.mm.bk.a.C(ah.getContext(), (int)com.tencent.mm.bk.a.hi(this.vDs.cvf)).toString();
      this.vDr.setText((CharSequence)localObject1);
    }
  }
  
  public final int djX()
  {
    return 20;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b.c
 * JD-Core Version:    0.7.0.1
 */