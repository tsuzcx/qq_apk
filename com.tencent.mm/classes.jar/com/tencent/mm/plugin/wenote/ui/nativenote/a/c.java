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
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteEditorVoiceBaseView;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;

public final class c
  extends j
{
  public NoteEditorVoiceBaseView BGu;
  private l BGv;
  public LinearLayout olP;
  public LinearLayout olQ;
  public ImageView olS;
  private TextView olT;
  private TextView olU;
  private final ap olW;
  
  public c(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30851);
    this.olW = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(30850);
        if (c.a(c.this).omJ)
        {
          c.b(c.this).removeMessages(4096);
          AppMethodBeat.o(30850);
          return;
        }
        paramAnonymousMessage = " " + com.tencent.mm.bm.a.C(aj.getContext(), c.a(c.this).omL).toString();
        c.c(c.this).setText(paramAnonymousMessage);
        sendEmptyMessageDelayed(4096, 500L);
        AppMethodBeat.o(30850);
      }
    };
    this.olP = ((LinearLayout)paramView.findViewById(2131302945));
    this.olQ = ((LinearLayout)paramView.findViewById(2131302919));
    this.olS = ((ImageView)paramView.findViewById(2131302946));
    this.olT = ((TextView)paramView.findViewById(2131302948));
    this.olU = ((TextView)paramView.findViewById(2131302949));
    this.BGu = ((NoteEditorVoiceBaseView)paramView.findViewById(2131302924));
    com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.eth().a(this.BGu);
    this.irQ.setVisibility(0);
    this.olP.setVisibility(8);
    this.olQ.setVisibility(0);
    this.djK.setVisibility(8);
    this.oln.setVisibility(8);
    this.irQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30849);
        if ((c.a(c.this) != null) && (c.a(c.this).omS.booleanValue())) {
          c.a(c.this).omT = Boolean.TRUE;
        }
        AppMethodBeat.o(30849);
      }
    });
    AppMethodBeat.o(30851);
  }
  
  public final void a(com.tencent.mm.plugin.wenote.model.a.c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30852);
    this.BGv = ((l)paramc);
    Object localObject1;
    Object localObject2;
    if (this.BGv.omJ)
    {
      this.olQ.setVisibility(0);
      this.olP.setVisibility(8);
      this.irQ.setPadding(0, 0, 0, 0);
      if (paramc.omC)
      {
        this.BGu.setBackgroundResource(2131234765);
        localObject1 = this.BGu;
        localObject2 = this.BGv.drZ;
        int i = this.BGv.dkj;
        String str = this.BGv.omM;
        ((NoteEditorVoiceBaseView)localObject1).path = bt.by((String)localObject2, "");
        ((NoteEditorVoiceBaseView)localObject1).dkj = i;
        ((NoteEditorVoiceBaseView)localObject1).setText(str);
      }
    }
    for (;;)
    {
      super.a(paramc, paramInt1, paramInt2);
      AppMethodBeat.o(30852);
      return;
      this.BGu.setBackgroundResource(2131234764);
      break;
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
          break label341;
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
      label341:
      this.olT.setText(2131759038);
      localObject1 = " " + com.tencent.mm.bm.a.C(aj.getContext(), (int)com.tencent.mm.bm.a.mI(this.BGv.dkk)).toString();
      this.olU.setText((CharSequence)localObject1);
    }
  }
  
  public final int bSa()
  {
    return 20;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.c
 * JD-Core Version:    0.7.0.1
 */