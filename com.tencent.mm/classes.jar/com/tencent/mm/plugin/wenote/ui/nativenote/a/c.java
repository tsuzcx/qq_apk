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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteEditorVoiceBaseView;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;

public final class c
  extends j
{
  public NoteEditorVoiceBaseView ECx;
  private l ECy;
  public LinearLayout psX;
  public LinearLayout psY;
  public ImageView pta;
  private TextView ptb;
  private TextView ptc;
  private final ap pte;
  
  public c(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30851);
    this.pte = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(30850);
        if (c.a(c.this).ptT)
        {
          c.b(c.this).removeMessages(4096);
          AppMethodBeat.o(30850);
          return;
        }
        paramAnonymousMessage = " " + com.tencent.mm.bm.a.G(aj.getContext(), c.a(c.this).ptV).toString();
        c.c(c.this).setText(paramAnonymousMessage);
        sendEmptyMessageDelayed(4096, 500L);
        AppMethodBeat.o(30850);
      }
    };
    this.psX = ((LinearLayout)paramView.findViewById(2131302945));
    this.psY = ((LinearLayout)paramView.findViewById(2131302919));
    this.pta = ((ImageView)paramView.findViewById(2131302946));
    this.ptb = ((TextView)paramView.findViewById(2131302948));
    this.ptc = ((TextView)paramView.findViewById(2131302949));
    this.ECx = ((NoteEditorVoiceBaseView)paramView.findViewById(2131302924));
    com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.eXt().a(this.ECx);
    this.jld.setVisibility(0);
    this.psX.setVisibility(8);
    this.psY.setVisibility(0);
    this.dsD.setVisibility(8);
    this.psv.setVisibility(8);
    this.jld.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30849);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteChatVoiceItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if ((c.a(c.this) != null) && (c.a(c.this).puc.booleanValue())) {
          c.a(c.this).pud = Boolean.TRUE;
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteChatVoiceItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30849);
      }
    });
    AppMethodBeat.o(30851);
  }
  
  public final void a(com.tencent.mm.plugin.wenote.model.a.c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30852);
    this.ECy = ((l)paramc);
    Object localObject1;
    Object localObject2;
    if (this.ECy.ptT)
    {
      this.psY.setVisibility(0);
      this.psX.setVisibility(8);
      this.jld.setPadding(0, 0, 0, 0);
      if (paramc.ptM)
      {
        this.ECx.setBackgroundResource(2131234765);
        localObject1 = this.ECx;
        localObject2 = this.ECy.dBx;
        int i = this.ECy.dtc;
        String str = this.ECy.ptW;
        ((NoteEditorVoiceBaseView)localObject1).path = bt.bI((String)localObject2, "");
        ((NoteEditorVoiceBaseView)localObject1).dtc = i;
        ((NoteEditorVoiceBaseView)localObject1).setText(str);
      }
    }
    for (;;)
    {
      super.a(paramc, paramInt1, paramInt2);
      AppMethodBeat.o(30852);
      return;
      this.ECx.setBackgroundResource(2131234764);
      break;
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
          break label341;
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
      label341:
      this.ptb.setText(2131759038);
      localObject1 = " " + com.tencent.mm.bm.a.G(aj.getContext(), (int)com.tencent.mm.bm.a.sv(this.ECy.dtd)).toString();
      this.ptc.setText((CharSequence)localObject1);
    }
  }
  
  public final int cdT()
  {
    return 20;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.c
 * JD-Core Version:    0.7.0.1
 */