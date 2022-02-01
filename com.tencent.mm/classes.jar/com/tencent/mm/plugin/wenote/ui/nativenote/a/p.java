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
import com.tencent.mm.al.i;
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
  public NoteVoiceView BGQ;
  private l BGv;
  private LinearLayout irQ;
  public LinearLayout olP;
  public LinearLayout olQ;
  public ImageView olS;
  private TextView olT;
  private TextView olU;
  private final ap olW;
  
  public p(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30887);
    this.olW = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(30886);
        if (p.a(p.this).omJ)
        {
          p.b(p.this).removeMessages(4096);
          AppMethodBeat.o(30886);
          return;
        }
        paramAnonymousMessage = " " + com.tencent.mm.bm.a.C(aj.getContext(), p.a(p.this).omL).toString();
        p.c(p.this).setText(paramAnonymousMessage);
        sendEmptyMessageDelayed(4096, 500L);
        AppMethodBeat.o(30886);
      }
    };
    this.irQ = ((LinearLayout)paramView.findViewById(2131302943));
    this.olP = ((LinearLayout)paramView.findViewById(2131302945));
    this.olQ = ((LinearLayout)paramView.findViewById(2131302944));
    this.olS = ((ImageView)paramView.findViewById(2131302946));
    this.olT = ((TextView)paramView.findViewById(2131302948));
    this.olU = ((TextView)paramView.findViewById(2131302949));
    this.BGQ = ((NoteVoiceView)paramView.findViewById(2131302925));
    this.BGQ.setVoiceHelper(com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.eth());
    this.irQ.setVisibility(0);
    this.olP.setVisibility(8);
    this.olQ.setVisibility(0);
    this.djK.setVisibility(8);
    this.oln.setVisibility(8);
    this.irQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30885);
        if ((p.a(p.this) != null) && (p.a(p.this).omS.booleanValue())) {
          p.a(p.this).omT = Boolean.TRUE;
        }
        AppMethodBeat.o(30885);
      }
    });
    AppMethodBeat.o(30887);
  }
  
  public final void a(c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30888);
    this.BGv = ((l)paramc);
    if (this.BGv.omJ)
    {
      this.irQ.setBackgroundResource(0);
      this.olQ.setVisibility(0);
      this.olP.setVisibility(8);
      this.irQ.setPadding(0, 0, 0, 0);
      if (!paramc.omC) {
        break label591;
      }
    }
    label306:
    label319:
    label591:
    for (int i = 1;; i = 0)
    {
      Object localObject1 = this.BGQ;
      Object localObject2 = this.BGv.drZ;
      int j = this.BGv.dkj;
      int k = this.BGv.dkk;
      ((NoteVoiceView)localObject1).path = bt.by((String)localObject2, "");
      ((NoteVoiceView)localObject1).dkj = j;
      ((NoteVoiceView)localObject1).duration = k;
      if (i != 0)
      {
        ((NoteVoiceView)localObject1).lRB.setVisibility(0);
        if (!((NoteVoiceView)localObject1).path.equals(((NoteVoiceView)localObject1).BGV.path)) {
          break label319;
        }
        if (!((NoteVoiceView)localObject1).BGV.bTK()) {
          break label229;
        }
        ad.i("MicroMsg.NoteVoiceView", "updateInfo .isPlay()");
        localObject2 = ((NoteVoiceView)localObject1).BGW;
        ((NoteVoiceView)localObject1).BGV.Oa();
        ((NoteVoiceView.a)localObject2).jA(true);
      }
      for (;;)
      {
        super.a(paramc, paramInt1, paramInt2);
        AppMethodBeat.o(30888);
        return;
        ((NoteVoiceView)localObject1).lRB.setVisibility(8);
        break;
        label229:
        localObject2 = ((NoteVoiceView)localObject1).BGV;
        if (((com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a)localObject2).org == null) {
          ad.w("MicroMsg.RecordVoiceHelper", "check is pause, but player is null");
        }
        for (boolean bool = false;; bool = ((com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a)localObject2).org.Nb())
        {
          if (!bool) {
            break label306;
          }
          ad.i("MicroMsg.NoteVoiceView", "updateInfo .isPause()");
          localObject2 = ((NoteVoiceView)localObject1).BGW;
          ((NoteVoiceView)localObject1).BGV.Oa();
          ((NoteVoiceView.a)localObject2).jA(false);
          break;
        }
        ((NoteVoiceView)localObject1).BGW.Ah(k);
        continue;
        ((NoteVoiceView)localObject1).BGW.Ah(k);
        continue;
        this.irQ.setBackgroundResource(2131234781);
        this.irQ.setPadding(26, 7, 0, 7);
        this.olQ.setVisibility(8);
        this.olP.setVisibility(0);
        localObject1 = this.olS;
        if (((ImageView)localObject1).getAnimation() != null) {
          ((ImageView)localObject1).startAnimation(((ImageView)localObject1).getAnimation());
        }
        for (;;)
        {
          if (!this.BGv.omS.booleanValue()) {
            break label529;
          }
          this.olW.sendEmptyMessage(4096);
          this.olT.setText(2131759039);
          localObject1 = " " + com.tencent.mm.bm.a.C(aj.getContext(), this.BGv.omL).toString();
          this.olU.setText((CharSequence)localObject1);
          break;
          localObject2 = new AlphaAnimation(1.0F, 0.0F);
          ((Animation)localObject2).setDuration(500L);
          ((Animation)localObject2).setInterpolator(new LinearInterpolator());
          ((Animation)localObject2).setRepeatCount(-1);
          ((Animation)localObject2).setRepeatMode(2);
          ((ImageView)localObject1).startAnimation((Animation)localObject2);
        }
        this.olT.setText(2131759038);
        localObject1 = " " + com.tencent.mm.bm.a.C(aj.getContext(), (int)com.tencent.mm.bm.a.mI(this.BGv.dkk)).toString();
        this.olU.setText((CharSequence)localObject1);
      }
    }
  }
  
  public final int bSa()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.p
 * JD-Core Version:    0.7.0.1
 */