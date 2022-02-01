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
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
  extends j
{
  public NoteEditorVoiceBaseView JKM;
  private l JKN;
  public LinearLayout qOU;
  public LinearLayout qOV;
  public ImageView qOX;
  private TextView qOY;
  private TextView qOZ;
  private final MMHandler qPb;
  
  public c(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30851);
    this.qPb = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(30850);
        if (c.a(c.this).qPO)
        {
          c.b(c.this).removeMessages(4096);
          AppMethodBeat.o(30850);
          return;
        }
        paramAnonymousMessage = " " + com.tencent.mm.bl.a.J(MMApplicationContext.getContext(), c.a(c.this).qPQ).toString();
        c.c(c.this).setText(paramAnonymousMessage);
        sendEmptyMessageDelayed(4096, 500L);
        AppMethodBeat.o(30850);
      }
    };
    this.qOU = ((LinearLayout)paramView.findViewById(2131305532));
    this.qOV = ((LinearLayout)paramView.findViewById(2131305506));
    this.qOX = ((ImageView)paramView.findViewById(2131305533));
    this.qOY = ((TextView)paramView.findViewById(2131305535));
    this.qOZ = ((TextView)paramView.findViewById(2131305536));
    this.JKM = ((NoteEditorVoiceBaseView)paramView.findViewById(2131305511));
    com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.gkl().a(this.JKM);
    this.kmg.setVisibility(0);
    this.qOU.setVisibility(8);
    this.qOV.setVisibility(0);
    this.dKU.setVisibility(8);
    this.qOs.setVisibility(8);
    this.kmg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30849);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteChatVoiceItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((c.a(c.this) != null) && (c.a(c.this).qPX.booleanValue())) {
          c.a(c.this).qPY = Boolean.TRUE;
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
    this.JKN = ((l)paramc);
    Object localObject1;
    Object localObject2;
    if (this.JKN.qPO)
    {
      this.qOV.setVisibility(0);
      this.qOU.setVisibility(8);
      this.kmg.setPadding(0, 0, 0, 0);
      if (paramc.qPH)
      {
        this.JKM.setBackgroundResource(2131235744);
        localObject1 = this.JKM;
        localObject2 = this.JKN.dUs;
        int i = this.JKN.dLt;
        String str = this.JKN.qPR;
        ((NoteEditorVoiceBaseView)localObject1).path = Util.nullAs((String)localObject2, "");
        ((NoteEditorVoiceBaseView)localObject1).dLt = i;
        ((NoteEditorVoiceBaseView)localObject1).setText(str);
      }
    }
    for (;;)
    {
      super.a(paramc, paramInt1, paramInt2);
      AppMethodBeat.o(30852);
      return;
      this.JKM.setBackgroundResource(2131235743);
      break;
      this.kmg.setPadding(26, 7, 0, 7);
      this.qOV.setVisibility(8);
      this.qOU.setVisibility(0);
      localObject1 = this.qOX;
      if (((ImageView)localObject1).getAnimation() != null) {
        ((ImageView)localObject1).startAnimation(((ImageView)localObject1).getAnimation());
      }
      for (;;)
      {
        if (!this.JKN.qPX.booleanValue()) {
          break label341;
        }
        this.qPb.sendEmptyMessage(4096);
        this.qOY.setText(2131759365);
        localObject1 = " " + com.tencent.mm.bl.a.J(MMApplicationContext.getContext(), this.JKN.qPQ).toString();
        this.qOZ.setText((CharSequence)localObject1);
        break;
        localObject2 = new AlphaAnimation(1.0F, 0.0F);
        ((Animation)localObject2).setDuration(500L);
        ((Animation)localObject2).setInterpolator(new LinearInterpolator());
        ((Animation)localObject2).setRepeatCount(-1);
        ((Animation)localObject2).setRepeatMode(2);
        ((ImageView)localObject1).startAnimation((Animation)localObject2);
      }
      label341:
      this.qOY.setText(2131759364);
      localObject1 = " " + com.tencent.mm.bl.a.J(MMApplicationContext.getContext(), (int)com.tencent.mm.bl.a.AO(this.JKN.dLu)).toString();
      this.qOZ.setText((CharSequence)localObject1);
    }
  }
  
  public final int cCY()
  {
    return 20;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.c
 * JD-Core Version:    0.7.0.1
 */