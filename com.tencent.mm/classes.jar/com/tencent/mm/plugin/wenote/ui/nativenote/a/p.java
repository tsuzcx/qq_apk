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
import com.tencent.mm.al.h;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteVoiceView;
import com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteVoiceView.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;

public final class p
  extends j
{
  public NoteVoiceView ECT;
  private l ECy;
  private LinearLayout jld;
  public LinearLayout psX;
  public LinearLayout psY;
  public ImageView pta;
  private TextView ptb;
  private TextView ptc;
  private final ap pte;
  
  public p(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30887);
    this.pte = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(30886);
        if (p.a(p.this).ptT)
        {
          p.b(p.this).removeMessages(4096);
          AppMethodBeat.o(30886);
          return;
        }
        paramAnonymousMessage = " " + com.tencent.mm.bm.a.G(aj.getContext(), p.a(p.this).ptV).toString();
        p.c(p.this).setText(paramAnonymousMessage);
        sendEmptyMessageDelayed(4096, 500L);
        AppMethodBeat.o(30886);
      }
    };
    this.jld = ((LinearLayout)paramView.findViewById(2131302943));
    this.psX = ((LinearLayout)paramView.findViewById(2131302945));
    this.psY = ((LinearLayout)paramView.findViewById(2131302944));
    this.pta = ((ImageView)paramView.findViewById(2131302946));
    this.ptb = ((TextView)paramView.findViewById(2131302948));
    this.ptc = ((TextView)paramView.findViewById(2131302949));
    this.ECT = ((NoteVoiceView)paramView.findViewById(2131302925));
    this.ECT.setVoiceHelper(com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.eXt());
    this.jld.setVisibility(0);
    this.psX.setVisibility(8);
    this.psY.setVisibility(0);
    this.dsD.setVisibility(8);
    this.psv.setVisibility(8);
    this.jld.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30885);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteVoiceItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if ((p.a(p.this) != null) && (p.a(p.this).puc.booleanValue())) {
          p.a(p.this).pud = Boolean.TRUE;
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteVoiceItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30885);
      }
    });
    AppMethodBeat.o(30887);
  }
  
  public final void a(c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30888);
    this.ECy = ((l)paramc);
    if (this.ECy.ptT)
    {
      this.jld.setBackgroundResource(0);
      this.psY.setVisibility(0);
      this.psX.setVisibility(8);
      this.jld.setPadding(0, 0, 0, 0);
      if (!paramc.ptM) {
        break label591;
      }
    }
    label306:
    label319:
    label591:
    for (int i = 1;; i = 0)
    {
      Object localObject1 = this.ECT;
      Object localObject2 = this.ECy.dBx;
      int j = this.ECy.dtc;
      int k = this.ECy.dtd;
      ((NoteVoiceView)localObject1).path = bt.bI((String)localObject2, "");
      ((NoteVoiceView)localObject1).dtc = j;
      ((NoteVoiceView)localObject1).duration = k;
      if (i != 0)
      {
        ((NoteVoiceView)localObject1).gZU.setVisibility(0);
        if (!((NoteVoiceView)localObject1).path.equals(((NoteVoiceView)localObject1).ECY.path)) {
          break label319;
        }
        if (!((NoteVoiceView)localObject1).ECY.cfC()) {
          break label229;
        }
        ad.i("MicroMsg.NoteVoiceView", "updateInfo .isPlay()");
        localObject2 = ((NoteVoiceView)localObject1).ECZ;
        ((NoteVoiceView)localObject1).ECY.PF();
        ((NoteVoiceView.a)localObject2).ko(true);
      }
      for (;;)
      {
        super.a(paramc, paramInt1, paramInt2);
        AppMethodBeat.o(30888);
        return;
        ((NoteVoiceView)localObject1).gZU.setVisibility(8);
        break;
        label229:
        localObject2 = ((NoteVoiceView)localObject1).ECY;
        if (((com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a)localObject2).pyq == null) {
          ad.w("MicroMsg.RecordVoiceHelper", "check is pause, but player is null");
        }
        for (boolean bool = false;; bool = ((com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a)localObject2).pyq.OI())
        {
          if (!bool) {
            break label306;
          }
          ad.i("MicroMsg.NoteVoiceView", "updateInfo .isPause()");
          localObject2 = ((NoteVoiceView)localObject1).ECZ;
          ((NoteVoiceView)localObject1).ECY.PF();
          ((NoteVoiceView.a)localObject2).ko(false);
          break;
        }
        ((NoteVoiceView)localObject1).ECZ.BH(k);
        continue;
        ((NoteVoiceView)localObject1).ECZ.BH(k);
        continue;
        this.jld.setBackgroundResource(2131234781);
        this.jld.setPadding(26, 7, 0, 7);
        this.psY.setVisibility(8);
        this.psX.setVisibility(0);
        localObject1 = this.pta;
        if (((ImageView)localObject1).getAnimation() != null) {
          ((ImageView)localObject1).startAnimation(((ImageView)localObject1).getAnimation());
        }
        for (;;)
        {
          if (!this.ECy.puc.booleanValue()) {
            break label529;
          }
          this.pte.sendEmptyMessage(4096);
          this.ptb.setText(2131759039);
          localObject1 = " " + com.tencent.mm.bm.a.G(aj.getContext(), this.ECy.ptV).toString();
          this.ptc.setText((CharSequence)localObject1);
          break;
          localObject2 = new AlphaAnimation(1.0F, 0.0F);
          ((Animation)localObject2).setDuration(500L);
          ((Animation)localObject2).setInterpolator(new LinearInterpolator());
          ((Animation)localObject2).setRepeatCount(-1);
          ((Animation)localObject2).setRepeatMode(2);
          ((ImageView)localObject1).startAnimation((Animation)localObject2);
        }
        this.ptb.setText(2131759038);
        localObject1 = " " + com.tencent.mm.bm.a.G(aj.getContext(), (int)com.tencent.mm.bm.a.sv(this.ECy.dtd)).toString();
        this.ptc.setText((CharSequence)localObject1);
      }
    }
  }
  
  public final int cdT()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.p
 * JD-Core Version:    0.7.0.1
 */