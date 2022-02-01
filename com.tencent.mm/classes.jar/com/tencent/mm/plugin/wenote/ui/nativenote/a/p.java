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
import com.tencent.mm.ak.h;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteVoiceView;
import com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteVoiceView.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;

public final class p
  extends j
{
  private l EUU;
  public NoteVoiceView EVp;
  private LinearLayout jnX;
  public LinearLayout pzD;
  public LinearLayout pzE;
  public ImageView pzG;
  private TextView pzH;
  private TextView pzI;
  private final aq pzK;
  
  public p(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30887);
    this.pzK = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(30886);
        if (p.a(p.this).pAx)
        {
          p.b(p.this).removeMessages(4096);
          AppMethodBeat.o(30886);
          return;
        }
        paramAnonymousMessage = " " + com.tencent.mm.bl.a.G(ak.getContext(), p.a(p.this).pAz).toString();
        p.c(p.this).setText(paramAnonymousMessage);
        sendEmptyMessageDelayed(4096, 500L);
        AppMethodBeat.o(30886);
      }
    };
    this.jnX = ((LinearLayout)paramView.findViewById(2131302943));
    this.pzD = ((LinearLayout)paramView.findViewById(2131302945));
    this.pzE = ((LinearLayout)paramView.findViewById(2131302944));
    this.pzG = ((ImageView)paramView.findViewById(2131302946));
    this.pzH = ((TextView)paramView.findViewById(2131302948));
    this.pzI = ((TextView)paramView.findViewById(2131302949));
    this.EVp = ((NoteVoiceView)paramView.findViewById(2131302925));
    this.EVp.setVoiceHelper(com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.fbf());
    this.jnX.setVisibility(0);
    this.pzD.setVisibility(8);
    this.pzE.setVisibility(0);
    this.dtJ.setVisibility(8);
    this.pzb.setVisibility(8);
    this.jnX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30885);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteVoiceItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((p.a(p.this) != null) && (p.a(p.this).pAG.booleanValue())) {
          p.a(p.this).pAH = Boolean.TRUE;
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
    this.EUU = ((l)paramc);
    if (this.EUU.pAx)
    {
      this.jnX.setBackgroundResource(0);
      this.pzE.setVisibility(0);
      this.pzD.setVisibility(8);
      this.jnX.setPadding(0, 0, 0, 0);
      if (!paramc.pAq) {
        break label591;
      }
    }
    label306:
    label319:
    label591:
    for (int i = 1;; i = 0)
    {
      Object localObject1 = this.EVp;
      Object localObject2 = this.EUU.dCC;
      int j = this.EUU.dui;
      int k = this.EUU.duj;
      ((NoteVoiceView)localObject1).path = bu.bI((String)localObject2, "");
      ((NoteVoiceView)localObject1).dui = j;
      ((NoteVoiceView)localObject1).duration = k;
      if (i != 0)
      {
        ((NoteVoiceView)localObject1).hcH.setVisibility(0);
        if (!((NoteVoiceView)localObject1).path.equals(((NoteVoiceView)localObject1).EVu.path)) {
          break label319;
        }
        if (!((NoteVoiceView)localObject1).EVu.cgS()) {
          break label229;
        }
        ae.i("MicroMsg.NoteVoiceView", "updateInfo .isPlay()");
        localObject2 = ((NoteVoiceView)localObject1).EVv;
        ((NoteVoiceView)localObject1).EVu.PE();
        ((NoteVoiceView.a)localObject2).kn(true);
      }
      for (;;)
      {
        super.a(paramc, paramInt1, paramInt2);
        AppMethodBeat.o(30888);
        return;
        ((NoteVoiceView)localObject1).hcH.setVisibility(8);
        break;
        label229:
        localObject2 = ((NoteVoiceView)localObject1).EVu;
        if (((com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a)localObject2).pEU == null) {
          ae.w("MicroMsg.RecordVoiceHelper", "check is pause, but player is null");
        }
        for (boolean bool = false;; bool = ((com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a)localObject2).pEU.OG())
        {
          if (!bool) {
            break label306;
          }
          ae.i("MicroMsg.NoteVoiceView", "updateInfo .isPause()");
          localObject2 = ((NoteVoiceView)localObject1).EVv;
          ((NoteVoiceView)localObject1).EVu.PE();
          ((NoteVoiceView.a)localObject2).kn(false);
          break;
        }
        ((NoteVoiceView)localObject1).EVv.BT(k);
        continue;
        ((NoteVoiceView)localObject1).EVv.BT(k);
        continue;
        this.jnX.setBackgroundResource(2131234781);
        this.jnX.setPadding(26, 7, 0, 7);
        this.pzE.setVisibility(8);
        this.pzD.setVisibility(0);
        localObject1 = this.pzG;
        if (((ImageView)localObject1).getAnimation() != null) {
          ((ImageView)localObject1).startAnimation(((ImageView)localObject1).getAnimation());
        }
        for (;;)
        {
          if (!this.EUU.pAG.booleanValue()) {
            break label529;
          }
          this.pzK.sendEmptyMessage(4096);
          this.pzH.setText(2131759039);
          localObject1 = " " + com.tencent.mm.bl.a.G(ak.getContext(), this.EUU.pAz).toString();
          this.pzI.setText((CharSequence)localObject1);
          break;
          localObject2 = new AlphaAnimation(1.0F, 0.0F);
          ((Animation)localObject2).setDuration(500L);
          ((Animation)localObject2).setInterpolator(new LinearInterpolator());
          ((Animation)localObject2).setRepeatCount(-1);
          ((Animation)localObject2).setRepeatMode(2);
          ((ImageView)localObject1).startAnimation((Animation)localObject2);
        }
        this.pzH.setText(2131759038);
        localObject1 = " " + com.tencent.mm.bl.a.G(ak.getContext(), (int)com.tencent.mm.bl.a.sI(this.EUU.duj)).toString();
        this.pzI.setText((CharSequence)localObject1);
      }
    }
  }
  
  public final int cfi()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.p
 * JD-Core Version:    0.7.0.1
 */