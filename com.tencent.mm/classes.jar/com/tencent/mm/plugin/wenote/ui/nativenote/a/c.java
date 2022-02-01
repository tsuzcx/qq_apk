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
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;

public final class c
  extends j
{
  public NoteEditorVoiceBaseView EUT;
  private l EUU;
  public LinearLayout pzD;
  public LinearLayout pzE;
  public ImageView pzG;
  private TextView pzH;
  private TextView pzI;
  private final aq pzK;
  
  public c(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30851);
    this.pzK = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(30850);
        if (c.a(c.this).pAx)
        {
          c.b(c.this).removeMessages(4096);
          AppMethodBeat.o(30850);
          return;
        }
        paramAnonymousMessage = " " + com.tencent.mm.bl.a.G(ak.getContext(), c.a(c.this).pAz).toString();
        c.c(c.this).setText(paramAnonymousMessage);
        sendEmptyMessageDelayed(4096, 500L);
        AppMethodBeat.o(30850);
      }
    };
    this.pzD = ((LinearLayout)paramView.findViewById(2131302945));
    this.pzE = ((LinearLayout)paramView.findViewById(2131302919));
    this.pzG = ((ImageView)paramView.findViewById(2131302946));
    this.pzH = ((TextView)paramView.findViewById(2131302948));
    this.pzI = ((TextView)paramView.findViewById(2131302949));
    this.EUT = ((NoteEditorVoiceBaseView)paramView.findViewById(2131302924));
    com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.fbf().a(this.EUT);
    this.jnX.setVisibility(0);
    this.pzD.setVisibility(8);
    this.pzE.setVisibility(0);
    this.dtJ.setVisibility(8);
    this.pzb.setVisibility(8);
    this.jnX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30849);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteChatVoiceItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((c.a(c.this) != null) && (c.a(c.this).pAG.booleanValue())) {
          c.a(c.this).pAH = Boolean.TRUE;
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
    this.EUU = ((l)paramc);
    Object localObject1;
    Object localObject2;
    if (this.EUU.pAx)
    {
      this.pzE.setVisibility(0);
      this.pzD.setVisibility(8);
      this.jnX.setPadding(0, 0, 0, 0);
      if (paramc.pAq)
      {
        this.EUT.setBackgroundResource(2131234765);
        localObject1 = this.EUT;
        localObject2 = this.EUU.dCC;
        int i = this.EUU.dui;
        String str = this.EUU.pAA;
        ((NoteEditorVoiceBaseView)localObject1).path = bu.bI((String)localObject2, "");
        ((NoteEditorVoiceBaseView)localObject1).dui = i;
        ((NoteEditorVoiceBaseView)localObject1).setText(str);
      }
    }
    for (;;)
    {
      super.a(paramc, paramInt1, paramInt2);
      AppMethodBeat.o(30852);
      return;
      this.EUT.setBackgroundResource(2131234764);
      break;
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
          break label341;
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
      label341:
      this.pzH.setText(2131759038);
      localObject1 = " " + com.tencent.mm.bl.a.G(ak.getContext(), (int)com.tencent.mm.bl.a.sI(this.EUU.duj)).toString();
      this.pzI.setText((CharSequence)localObject1);
    }
  }
  
  public final int cfi()
  {
    return 20;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.c
 * JD-Core Version:    0.7.0.1
 */