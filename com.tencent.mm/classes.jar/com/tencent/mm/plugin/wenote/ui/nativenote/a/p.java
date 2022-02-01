package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteVoiceView;
import com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteVoiceView.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;

public final class p
  extends j
{
  private l CYC;
  public NoteVoiceView CYX;
  private LinearLayout iRV;
  public LinearLayout oPp;
  public LinearLayout oPq;
  public ImageView oPs;
  private TextView oPt;
  private TextView oPu;
  private final ao oPw;
  
  public p(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30887);
    this.oPw = new ao()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(30886);
        if (p.a(p.this).oQj)
        {
          p.b(p.this).removeMessages(4096);
          AppMethodBeat.o(30886);
          return;
        }
        paramAnonymousMessage = " " + com.tencent.mm.bl.a.F(ai.getContext(), p.a(p.this).oQl).toString();
        p.c(p.this).setText(paramAnonymousMessage);
        sendEmptyMessageDelayed(4096, 500L);
        AppMethodBeat.o(30886);
      }
    };
    this.iRV = ((LinearLayout)paramView.findViewById(2131302943));
    this.oPp = ((LinearLayout)paramView.findViewById(2131302945));
    this.oPq = ((LinearLayout)paramView.findViewById(2131302944));
    this.oPs = ((ImageView)paramView.findViewById(2131302946));
    this.oPt = ((TextView)paramView.findViewById(2131302948));
    this.oPu = ((TextView)paramView.findViewById(2131302949));
    this.CYX = ((NoteVoiceView)paramView.findViewById(2131302925));
    this.CYX.setVoiceHelper(com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.eIA());
    this.iRV.setVisibility(0);
    this.oPp.setVisibility(8);
    this.oPq.setVisibility(0);
    this.dhf.setVisibility(8);
    this.oON.setVisibility(8);
    this.iRV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30885);
        if ((p.a(p.this) != null) && (p.a(p.this).oQs.booleanValue())) {
          p.a(p.this).oQt = Boolean.TRUE;
        }
        AppMethodBeat.o(30885);
      }
    });
    AppMethodBeat.o(30887);
  }
  
  public final void a(c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30888);
    this.CYC = ((l)paramc);
    if (this.CYC.oQj)
    {
      this.iRV.setBackgroundResource(0);
      this.oPq.setVisibility(0);
      this.oPp.setVisibility(8);
      this.iRV.setPadding(0, 0, 0, 0);
      if (!paramc.oQc) {
        break label591;
      }
    }
    label306:
    label319:
    label591:
    for (int i = 1;; i = 0)
    {
      Object localObject1 = this.CYX;
      Object localObject2 = this.CYC.dpK;
      int j = this.CYC.dhE;
      int k = this.CYC.dhF;
      ((NoteVoiceView)localObject1).path = bs.bG((String)localObject2, "");
      ((NoteVoiceView)localObject1).dhE = j;
      ((NoteVoiceView)localObject1).duration = k;
      if (i != 0)
      {
        ((NoteVoiceView)localObject1).gGk.setVisibility(0);
        if (!((NoteVoiceView)localObject1).path.equals(((NoteVoiceView)localObject1).CZc.path)) {
          break label319;
        }
        if (!((NoteVoiceView)localObject1).CZc.caY()) {
          break label229;
        }
        ac.i("MicroMsg.NoteVoiceView", "updateInfo .isPlay()");
        localObject2 = ((NoteVoiceView)localObject1).CZd;
        ((NoteVoiceView)localObject1).CZc.NW();
        ((NoteVoiceView.a)localObject2).kd(true);
      }
      for (;;)
      {
        super.a(paramc, paramInt1, paramInt2);
        AppMethodBeat.o(30888);
        return;
        ((NoteVoiceView)localObject1).gGk.setVisibility(8);
        break;
        label229:
        localObject2 = ((NoteVoiceView)localObject1).CZc;
        if (((com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a)localObject2).oUG == null) {
          ac.w("MicroMsg.RecordVoiceHelper", "check is pause, but player is null");
        }
        for (boolean bool = false;; bool = ((com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a)localObject2).oUG.MZ())
        {
          if (!bool) {
            break label306;
          }
          ac.i("MicroMsg.NoteVoiceView", "updateInfo .isPause()");
          localObject2 = ((NoteVoiceView)localObject1).CZd;
          ((NoteVoiceView)localObject1).CZc.NW();
          ((NoteVoiceView.a)localObject2).kd(false);
          break;
        }
        ((NoteVoiceView)localObject1).CZd.AZ(k);
        continue;
        ((NoteVoiceView)localObject1).CZd.AZ(k);
        continue;
        this.iRV.setBackgroundResource(2131234781);
        this.iRV.setPadding(26, 7, 0, 7);
        this.oPq.setVisibility(8);
        this.oPp.setVisibility(0);
        localObject1 = this.oPs;
        if (((ImageView)localObject1).getAnimation() != null) {
          ((ImageView)localObject1).startAnimation(((ImageView)localObject1).getAnimation());
        }
        for (;;)
        {
          if (!this.CYC.oQs.booleanValue()) {
            break label529;
          }
          this.oPw.sendEmptyMessage(4096);
          this.oPt.setText(2131759039);
          localObject1 = " " + com.tencent.mm.bl.a.F(ai.getContext(), this.CYC.oQl).toString();
          this.oPu.setText((CharSequence)localObject1);
          break;
          localObject2 = new AlphaAnimation(1.0F, 0.0F);
          ((Animation)localObject2).setDuration(500L);
          ((Animation)localObject2).setInterpolator(new LinearInterpolator());
          ((Animation)localObject2).setRepeatCount(-1);
          ((Animation)localObject2).setRepeatMode(2);
          ((ImageView)localObject1).startAnimation((Animation)localObject2);
        }
        this.oPt.setText(2131759038);
        localObject1 = " " + com.tencent.mm.bl.a.F(ai.getContext(), (int)com.tencent.mm.bl.a.qw(this.CYC.dhF)).toString();
        this.oPu.setText((CharSequence)localObject1);
      }
    }
  }
  
  public final int bZp()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.p
 * JD-Core Version:    0.7.0.1
 */