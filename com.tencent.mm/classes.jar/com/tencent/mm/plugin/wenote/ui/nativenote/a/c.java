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
  public NoteEditorVoiceBaseView XDE;
  private l XDF;
  private TextView xxA;
  private final MMHandler xxC;
  public LinearLayout xxv;
  public LinearLayout xxw;
  public ImageView xxy;
  private TextView xxz;
  
  public c(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30851);
    this.xxC = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(30850);
        if (c.a(c.this).xyp)
        {
          c.b(c.this).removeMessages(4096);
          AppMethodBeat.o(30850);
          return;
        }
        paramAnonymousMessage = " " + com.tencent.mm.bf.a.Q(MMApplicationContext.getContext(), c.a(c.this).xyr).toString();
        c.c(c.this).setText(paramAnonymousMessage);
        sendEmptyMessageDelayed(4096, 500L);
        AppMethodBeat.o(30850);
      }
    };
    this.xxv = ((LinearLayout)paramView.findViewById(R.h.fSo));
    this.xxw = ((LinearLayout)paramView.findViewById(R.h.fRS));
    this.xxy = ((ImageView)paramView.findViewById(R.h.fSp));
    this.xxz = ((TextView)paramView.findViewById(R.h.fSq));
    this.xxA = ((TextView)paramView.findViewById(R.h.fSr));
    this.XDE = ((NoteEditorVoiceBaseView)paramView.findViewById(R.h.fRX));
    com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.iEK().a(this.XDE);
    this.pZr.setVisibility(0);
    this.xxv.setVisibility(8);
    this.xxw.setVisibility(0);
    this.hIz.setVisibility(8);
    this.xwT.setVisibility(8);
    this.pZr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30849);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteChatVoiceItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((c.a(c.this) != null) && (c.a(c.this).xyz.booleanValue())) {
          c.a(c.this).xyA = Boolean.TRUE;
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
    this.XDF = ((l)paramc);
    Object localObject1;
    Object localObject2;
    if (this.XDF.xyp)
    {
      this.xxw.setVisibility(0);
      this.xxv.setVisibility(8);
      this.pZr.setPadding(0, 0, 0, 0);
      if (paramc.xyi)
      {
        this.XDE.setBackgroundResource(R.g.fpO);
        localObject1 = this.XDE;
        localObject2 = this.XDF.hTM;
        int i = this.XDF.hIY;
        String str = this.XDF.xyt;
        ((NoteEditorVoiceBaseView)localObject1).path = Util.nullAs((String)localObject2, "");
        ((NoteEditorVoiceBaseView)localObject1).hIY = i;
        ((NoteEditorVoiceBaseView)localObject1).setText(str);
      }
    }
    for (;;)
    {
      super.a(paramc, paramInt1, paramInt2);
      AppMethodBeat.o(30852);
      return;
      this.XDE.setBackgroundResource(R.g.fpN);
      break;
      this.pZr.setPadding(26, 7, 0, 7);
      this.xxw.setVisibility(8);
      this.xxv.setVisibility(0);
      localObject1 = this.xxy;
      if (((ImageView)localObject1).getAnimation() != null) {
        ((ImageView)localObject1).startAnimation(((ImageView)localObject1).getAnimation());
      }
      for (;;)
      {
        if (!this.XDF.xyz.booleanValue()) {
          break label344;
        }
        this.xxC.sendEmptyMessage(4096);
        this.xxz.setText(R.l.favorite_wenote_voice_recording);
        localObject1 = " " + com.tencent.mm.bf.a.Q(MMApplicationContext.getContext(), this.XDF.xyr).toString();
        this.xxA.setText((CharSequence)localObject1);
        break;
        localObject2 = new AlphaAnimation(1.0F, 0.0F);
        ((Animation)localObject2).setDuration(500L);
        ((Animation)localObject2).setInterpolator(new LinearInterpolator());
        ((Animation)localObject2).setRepeatCount(-1);
        ((Animation)localObject2).setRepeatMode(2);
        ((ImageView)localObject1).startAnimation((Animation)localObject2);
      }
      label344:
      this.xxz.setText(R.l.favorite_wenote_voice_downloading);
      localObject1 = " " + com.tencent.mm.bf.a.Q(MMApplicationContext.getContext(), (int)com.tencent.mm.bf.a.jh(this.XDF.hIZ)).toString();
      this.xxA.setText((CharSequence)localObject1);
    }
  }
  
  public final int dvW()
  {
    return 20;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.c
 * JD-Core Version:    0.7.0.1
 */