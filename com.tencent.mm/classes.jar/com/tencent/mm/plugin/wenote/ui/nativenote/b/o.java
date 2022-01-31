package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.h;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteVoiceView;
import com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteVoiceView.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

public final class o
  extends i
{
  private LinearLayout gEf;
  public LinearLayout vDm;
  public LinearLayout vDn;
  public ImageView vDp;
  private TextView vDq;
  private TextView vDr;
  private l vDs;
  public NoteVoiceView vEh;
  private final ak vwU;
  
  public o(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(27186);
    this.vwU = new o.2(this);
    this.gEf = ((LinearLayout)paramView.findViewById(2131826584));
    this.vDm = ((LinearLayout)paramView.findViewById(2131826585));
    this.vDn = ((LinearLayout)paramView.findViewById(2131826589));
    this.vDp = ((ImageView)paramView.findViewById(2131826586));
    this.vDq = ((TextView)paramView.findViewById(2131826587));
    this.vDr = ((TextView)paramView.findViewById(2131826588));
    this.vEh = ((NoteVoiceView)paramView.findViewById(2131826590));
    this.vEh.setVoiceHelper(com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.djZ());
    this.gEf.setVisibility(0);
    this.vDm.setVisibility(8);
    this.vDn.setVisibility(0);
    this.cuM.setVisibility(8);
    this.vDE.setVisibility(8);
    this.gEf.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(27184);
        if ((o.a(o.this) != null) && (o.a(o.this).vxk.booleanValue())) {
          o.a(o.this).vxl = Boolean.TRUE;
        }
        AppMethodBeat.o(27184);
      }
    });
    AppMethodBeat.o(27186);
  }
  
  public final void a(c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(27187);
    this.vDs = ((l)paramc);
    if (this.vDs.vxs)
    {
      this.gEf.setBackgroundResource(0);
      this.vDn.setVisibility(0);
      this.vDm.setVisibility(8);
      this.gEf.setPadding(0, 0, 0, 0);
      if (!paramc.vxd) {
        break label591;
      }
    }
    label306:
    label319:
    label591:
    for (int i = 1;; i = 0)
    {
      Object localObject1 = this.vEh;
      Object localObject2 = this.vDs.cBD;
      int j = this.vDs.cve;
      int k = this.vDs.cvf;
      ((NoteVoiceView)localObject1).path = bo.bf((String)localObject2, "");
      ((NoteVoiceView)localObject1).cve = j;
      ((NoteVoiceView)localObject1).duration = k;
      if (i != 0)
      {
        ((NoteVoiceView)localObject1).jbK.setVisibility(0);
        if (!((NoteVoiceView)localObject1).path.equals(((NoteVoiceView)localObject1).vEn.path)) {
          break label319;
        }
        if (!((NoteVoiceView)localObject1).vEn.bwz()) {
          break label229;
        }
        ab.i("MicroMsg.NoteVoiceView", "updateInfo .isPlay()");
        localObject2 = ((NoteVoiceView)localObject1).vEo;
        ((NoteVoiceView)localObject1).vEn.Er();
        ((NoteVoiceView.a)localObject2).oV(true);
      }
      for (;;)
      {
        super.a(paramc, paramInt1, paramInt2);
        AppMethodBeat.o(27187);
        return;
        ((NoteVoiceView)localObject1).jbK.setVisibility(8);
        break;
        label229:
        localObject2 = ((NoteVoiceView)localObject1).vEn;
        if (((com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a)localObject2).mtU == null) {
          ab.w("MicroMsg.RecordVoiceHelper", "check is pause, but player is null");
        }
        for (boolean bool = false;; bool = ((com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a)localObject2).mtU.Ds())
        {
          if (!bool) {
            break label306;
          }
          ab.i("MicroMsg.NoteVoiceView", "updateInfo .isPause()");
          localObject2 = ((NoteVoiceView)localObject1).vEo;
          ((NoteVoiceView)localObject1).vEn.Er();
          ((NoteVoiceView.a)localObject2).oV(false);
          break;
        }
        ((NoteVoiceView)localObject1).vEo.vY(k);
        continue;
        ((NoteVoiceView)localObject1).vEo.vY(k);
        continue;
        this.gEf.setBackgroundResource(2130840953);
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
            break label529;
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
        this.vDq.setText(2131299861);
        localObject1 = " " + com.tencent.mm.bk.a.C(ah.getContext(), (int)com.tencent.mm.bk.a.hi(this.vDs.cvf)).toString();
        this.vDr.setText((CharSequence)localObject1);
      }
    }
  }
  
  public final int djX()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b.o
 * JD-Core Version:    0.7.0.1
 */