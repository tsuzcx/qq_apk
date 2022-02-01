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
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteVoiceView;
import com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteVoiceView.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class p
  extends j
{
  public NoteVoiceView QKC;
  private l QKg;
  private LinearLayout ndX;
  public LinearLayout uqY;
  public LinearLayout uqZ;
  public ImageView urb;
  private TextView urc;
  private TextView urd;
  private final MMHandler urf;
  
  public p(View paramView, com.tencent.mm.plugin.wenote.model.nativenote.manager.k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30887);
    this.urf = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(30886);
        if (p.a(p.this).urU)
        {
          p.b(p.this).removeMessages(4096);
          AppMethodBeat.o(30886);
          return;
        }
        paramAnonymousMessage = " " + com.tencent.mm.bn.a.N(MMApplicationContext.getContext(), p.a(p.this).urW).toString();
        p.c(p.this).setText(paramAnonymousMessage);
        sendEmptyMessageDelayed(4096, 500L);
        AppMethodBeat.o(30886);
      }
    };
    this.ndX = ((LinearLayout)paramView.findViewById(R.h.dQh));
    this.uqY = ((LinearLayout)paramView.findViewById(R.h.dQj));
    this.uqZ = ((LinearLayout)paramView.findViewById(R.h.dQi));
    this.urb = ((ImageView)paramView.findViewById(R.h.dQk));
    this.urc = ((TextView)paramView.findViewById(R.h.dQl));
    this.urd = ((TextView)paramView.findViewById(R.h.dQm));
    this.QKC = ((NoteVoiceView)paramView.findViewById(R.h.dPT));
    this.QKC.setVoiceHelper(com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.hec());
    this.ndX.setVisibility(0);
    this.uqY.setVisibility(8);
    this.uqZ.setVisibility(0);
    this.fDJ.setVisibility(8);
    this.uqw.setVisibility(8);
    this.ndX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30885);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteVoiceItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if ((p.a(p.this) != null) && (p.a(p.this).usd.booleanValue())) {
          p.a(p.this).use = Boolean.TRUE;
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
    this.QKg = ((l)paramc);
    if (this.QKg.urU)
    {
      this.ndX.setBackgroundResource(0);
      this.uqZ.setVisibility(0);
      this.uqY.setVisibility(8);
      this.ndX.setPadding(0, 0, 0, 0);
      if (!paramc.urN) {
        break label595;
      }
    }
    label306:
    label319:
    label595:
    for (int i = 1;; i = 0)
    {
      Object localObject1 = this.QKC;
      Object localObject2 = this.QKg.fNU;
      int j = this.QKg.fEi;
      int k = this.QKg.fEj;
      ((NoteVoiceView)localObject1).path = Util.nullAs((String)localObject2, "");
      ((NoteVoiceView)localObject1).fEi = j;
      ((NoteVoiceView)localObject1).duration = k;
      if (i != 0)
      {
        ((NoteVoiceView)localObject1).maskView.setVisibility(0);
        if (!((NoteVoiceView)localObject1).path.equals(((NoteVoiceView)localObject1).QKH.path)) {
          break label319;
        }
        if (!((NoteVoiceView)localObject1).QKH.cTl()) {
          break label229;
        }
        Log.i("MicroMsg.NoteVoiceView", "updateInfo .isPlay()");
        localObject2 = ((NoteVoiceView)localObject1).QKI;
        ((NoteVoiceView)localObject1).QKH.aeI();
        ((NoteVoiceView.a)localObject2).mB(true);
      }
      for (;;)
      {
        super.a(paramc, paramInt1, paramInt2);
        AppMethodBeat.o(30888);
        return;
        ((NoteVoiceView)localObject1).maskView.setVisibility(8);
        break;
        label229:
        localObject2 = ((NoteVoiceView)localObject1).QKH;
        if (((com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a)localObject2).uwr == null) {
          Log.w("MicroMsg.RecordVoiceHelper", "check is pause, but player is null");
        }
        for (boolean bool = false;; bool = ((com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a)localObject2).uwr.adH())
        {
          if (!bool) {
            break label306;
          }
          Log.i("MicroMsg.NoteVoiceView", "updateInfo .isPause()");
          localObject2 = ((NoteVoiceView)localObject1).QKI;
          ((NoteVoiceView)localObject1).QKH.aeI();
          ((NoteVoiceView.a)localObject2).mB(false);
          break;
        }
        ((NoteVoiceView)localObject1).QKI.Jl(k);
        continue;
        ((NoteVoiceView)localObject1).QKI.Jl(k);
        continue;
        this.ndX.setBackgroundResource(R.g.dpA);
        this.ndX.setPadding(26, 7, 0, 7);
        this.uqZ.setVisibility(8);
        this.uqY.setVisibility(0);
        localObject1 = this.urb;
        if (((ImageView)localObject1).getAnimation() != null) {
          ((ImageView)localObject1).startAnimation(((ImageView)localObject1).getAnimation());
        }
        for (;;)
        {
          if (!this.QKg.usd.booleanValue()) {
            break label532;
          }
          this.urf.sendEmptyMessage(4096);
          this.urc.setText(R.l.favorite_wenote_voice_recording);
          localObject1 = " " + com.tencent.mm.bn.a.N(MMApplicationContext.getContext(), this.QKg.urW).toString();
          this.urd.setText((CharSequence)localObject1);
          break;
          localObject2 = new AlphaAnimation(1.0F, 0.0F);
          ((Animation)localObject2).setDuration(500L);
          ((Animation)localObject2).setInterpolator(new LinearInterpolator());
          ((Animation)localObject2).setRepeatCount(-1);
          ((Animation)localObject2).setRepeatMode(2);
          ((ImageView)localObject1).startAnimation((Animation)localObject2);
        }
        this.urc.setText(R.l.favorite_wenote_voice_downloading);
        localObject1 = " " + com.tencent.mm.bn.a.N(MMApplicationContext.getContext(), (int)com.tencent.mm.bn.a.GW(this.QKg.fEj)).toString();
        this.urd.setText((CharSequence)localObject1);
      }
    }
  }
  
  public final int cRD()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.p
 * JD-Core Version:    0.7.0.1
 */