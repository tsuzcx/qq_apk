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
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteEditorVoiceBaseView;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
  extends j
{
  public NoteEditorVoiceBaseView QKf;
  private l QKg;
  public LinearLayout uqY;
  public LinearLayout uqZ;
  public ImageView urb;
  private TextView urc;
  private TextView urd;
  private final MMHandler urf;
  
  public c(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30851);
    this.urf = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(30850);
        if (c.a(c.this).urU)
        {
          c.b(c.this).removeMessages(4096);
          AppMethodBeat.o(30850);
          return;
        }
        paramAnonymousMessage = " " + com.tencent.mm.bn.a.N(MMApplicationContext.getContext(), c.a(c.this).urW).toString();
        c.c(c.this).setText(paramAnonymousMessage);
        sendEmptyMessageDelayed(4096, 500L);
        AppMethodBeat.o(30850);
      }
    };
    this.uqY = ((LinearLayout)paramView.findViewById(R.h.dQj));
    this.uqZ = ((LinearLayout)paramView.findViewById(R.h.dPN));
    this.urb = ((ImageView)paramView.findViewById(R.h.dQk));
    this.urc = ((TextView)paramView.findViewById(R.h.dQl));
    this.urd = ((TextView)paramView.findViewById(R.h.dQm));
    this.QKf = ((NoteEditorVoiceBaseView)paramView.findViewById(R.h.dPS));
    com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.hec().a(this.QKf);
    this.ndX.setVisibility(0);
    this.uqY.setVisibility(8);
    this.uqZ.setVisibility(0);
    this.fDJ.setVisibility(8);
    this.uqw.setVisibility(8);
    this.ndX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30849);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteChatVoiceItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if ((c.a(c.this) != null) && (c.a(c.this).usd.booleanValue())) {
          c.a(c.this).use = Boolean.TRUE;
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
    this.QKg = ((l)paramc);
    Object localObject1;
    Object localObject2;
    if (this.QKg.urU)
    {
      this.uqZ.setVisibility(0);
      this.uqY.setVisibility(8);
      this.ndX.setPadding(0, 0, 0, 0);
      if (paramc.urN)
      {
        this.QKf.setBackgroundResource(R.g.dpz);
        localObject1 = this.QKf;
        localObject2 = this.QKg.fNU;
        int i = this.QKg.fEi;
        String str = this.QKg.urX;
        ((NoteEditorVoiceBaseView)localObject1).path = Util.nullAs((String)localObject2, "");
        ((NoteEditorVoiceBaseView)localObject1).fEi = i;
        ((NoteEditorVoiceBaseView)localObject1).setText(str);
      }
    }
    for (;;)
    {
      super.a(paramc, paramInt1, paramInt2);
      AppMethodBeat.o(30852);
      return;
      this.QKf.setBackgroundResource(R.g.dpy);
      break;
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
          break label344;
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
      label344:
      this.urc.setText(R.l.favorite_wenote_voice_downloading);
      localObject1 = " " + com.tencent.mm.bn.a.N(MMApplicationContext.getContext(), (int)com.tencent.mm.bn.a.GW(this.QKg.fEj)).toString();
      this.urd.setText((CharSequence)localObject1);
    }
  }
  
  public final int cRD()
  {
    return 20;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.c
 * JD-Core Version:    0.7.0.1
 */