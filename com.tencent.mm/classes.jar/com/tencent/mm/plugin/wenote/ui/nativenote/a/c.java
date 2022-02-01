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
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;

public final class c
  extends j
{
  public NoteEditorVoiceBaseView CYB;
  private l CYC;
  public LinearLayout oPp;
  public LinearLayout oPq;
  public ImageView oPs;
  private TextView oPt;
  private TextView oPu;
  private final ao oPw;
  
  public c(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30851);
    this.oPw = new ao()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(30850);
        if (c.a(c.this).oQj)
        {
          c.b(c.this).removeMessages(4096);
          AppMethodBeat.o(30850);
          return;
        }
        paramAnonymousMessage = " " + com.tencent.mm.bl.a.F(ai.getContext(), c.a(c.this).oQl).toString();
        c.c(c.this).setText(paramAnonymousMessage);
        sendEmptyMessageDelayed(4096, 500L);
        AppMethodBeat.o(30850);
      }
    };
    this.oPp = ((LinearLayout)paramView.findViewById(2131302945));
    this.oPq = ((LinearLayout)paramView.findViewById(2131302919));
    this.oPs = ((ImageView)paramView.findViewById(2131302946));
    this.oPt = ((TextView)paramView.findViewById(2131302948));
    this.oPu = ((TextView)paramView.findViewById(2131302949));
    this.CYB = ((NoteEditorVoiceBaseView)paramView.findViewById(2131302924));
    com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.eIA().a(this.CYB);
    this.iRV.setVisibility(0);
    this.oPp.setVisibility(8);
    this.oPq.setVisibility(0);
    this.dhf.setVisibility(8);
    this.oON.setVisibility(8);
    this.iRV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30849);
        if ((c.a(c.this) != null) && (c.a(c.this).oQs.booleanValue())) {
          c.a(c.this).oQt = Boolean.TRUE;
        }
        AppMethodBeat.o(30849);
      }
    });
    AppMethodBeat.o(30851);
  }
  
  public final void a(com.tencent.mm.plugin.wenote.model.a.c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30852);
    this.CYC = ((l)paramc);
    Object localObject1;
    Object localObject2;
    if (this.CYC.oQj)
    {
      this.oPq.setVisibility(0);
      this.oPp.setVisibility(8);
      this.iRV.setPadding(0, 0, 0, 0);
      if (paramc.oQc)
      {
        this.CYB.setBackgroundResource(2131234765);
        localObject1 = this.CYB;
        localObject2 = this.CYC.dpK;
        int i = this.CYC.dhE;
        String str = this.CYC.oQm;
        ((NoteEditorVoiceBaseView)localObject1).path = bs.bG((String)localObject2, "");
        ((NoteEditorVoiceBaseView)localObject1).dhE = i;
        ((NoteEditorVoiceBaseView)localObject1).setText(str);
      }
    }
    for (;;)
    {
      super.a(paramc, paramInt1, paramInt2);
      AppMethodBeat.o(30852);
      return;
      this.CYB.setBackgroundResource(2131234764);
      break;
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
          break label341;
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
      label341:
      this.oPt.setText(2131759038);
      localObject1 = " " + com.tencent.mm.bl.a.F(ai.getContext(), (int)com.tencent.mm.bl.a.qw(this.CYC.dhF)).toString();
      this.oPu.setText((CharSequence)localObject1);
    }
  }
  
  public final int bZp()
  {
    return 20;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.c
 * JD-Core Version:    0.7.0.1
 */