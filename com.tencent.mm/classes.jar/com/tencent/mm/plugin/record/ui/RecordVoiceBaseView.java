package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.record.b.u;
import com.tencent.mm.plugin.record.b.u.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.t;
import java.util.Iterator;
import java.util.List;

public class RecordVoiceBaseView
  extends TextView
  implements u.a
{
  private Context context;
  public int dtc;
  public int duration;
  private boolean isRunning;
  public String path;
  private AlphaAnimation pym;
  private AnimationDrawable pyn;
  private u xsB;
  
  public RecordVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27982);
    this.isRunning = false;
    this.duration = -1;
    this.path = "";
    this.context = paramContext;
    aPY();
    AppMethodBeat.o(27982);
  }
  
  public RecordVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27983);
    this.isRunning = false;
    this.duration = -1;
    this.path = "";
    this.context = paramContext;
    aPY();
    AppMethodBeat.o(27983);
  }
  
  private void aPY()
  {
    AppMethodBeat.i(27984);
    this.pym = new AlphaAnimation(0.1F, 1.0F);
    this.pym.setDuration(1000L);
    this.pym.setRepeatCount(-1);
    this.pym.setRepeatMode(2);
    this.pyn = new com.tencent.mm.ui.e.a();
    Drawable localDrawable = getResources().getDrawable(2131689892);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.pyn.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689893);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.pyn.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689894);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.pyn.addFrame(localDrawable, 300);
    this.pyn.setOneShot(false);
    this.pyn.setVisible(true, true);
    AppMethodBeat.o(27984);
  }
  
  private void cfx()
  {
    AppMethodBeat.i(27985);
    if ((this.pym != null) && (this.pym.isInitialized())) {
      setAnimation(null);
    }
    this.isRunning = false;
    setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2131689891), null, null, null);
    this.pyn.stop();
    AppMethodBeat.o(27985);
  }
  
  public final void avs(String paramString)
  {
    AppMethodBeat.i(27989);
    ad.d("MicroMsg.RecordVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[] { this.path, Integer.valueOf(this.duration), paramString });
    if (!bt.bI(paramString, "").equals(this.path)) {
      cfx();
    }
    AppMethodBeat.o(27989);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(27990);
    stopPlay();
    AppMethodBeat.o(27990);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(27986);
    super.onFinishInflate();
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(27981);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/record/ui/RecordVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.d("MicroMsg.RecordVoiceBaseView", "clicked path %s, isPlay %s", new Object[] { RecordVoiceBaseView.a(RecordVoiceBaseView.this), Boolean.valueOf(RecordVoiceBaseView.b(RecordVoiceBaseView.this).cfC()) });
        if ((com.tencent.mm.s.a.cf(RecordVoiceBaseView.c(RecordVoiceBaseView.this))) || (com.tencent.mm.s.a.cd(RecordVoiceBaseView.c(RecordVoiceBaseView.this))) || (com.tencent.mm.s.a.ch(RecordVoiceBaseView.c(RecordVoiceBaseView.this))))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/RecordVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27981);
          return;
        }
        if ((!e.abf()) && (!bt.isNullOrNil(RecordVoiceBaseView.a(RecordVoiceBaseView.this))))
        {
          t.g(paramAnonymousView.getContext(), null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/RecordVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27981);
          return;
        }
        if (!bt.bI(RecordVoiceBaseView.a(RecordVoiceBaseView.this), "").equals(RecordVoiceBaseView.b(RecordVoiceBaseView.this).path)) {
          RecordVoiceBaseView.d(RecordVoiceBaseView.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/RecordVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27981);
          return;
          if (RecordVoiceBaseView.b(RecordVoiceBaseView.this).cfC()) {
            RecordVoiceBaseView.this.stopPlay();
          } else if (!RecordVoiceBaseView.e(RecordVoiceBaseView.this)) {
            RecordVoiceBaseView.d(RecordVoiceBaseView.this);
          }
        }
      }
    });
    AppMethodBeat.o(27986);
  }
  
  public void setVoiceHelper(u paramu)
  {
    AppMethodBeat.i(27987);
    this.xsB = paramu;
    paramu = this.xsB;
    Iterator localIterator = paramu.callbacks.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (this != (u.a)localIterator.next());
    for (;;)
    {
      AppMethodBeat.o(27987);
      return;
      paramu.callbacks.add(this);
    }
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(27988);
    ad.d("MicroMsg.RecordVoiceBaseView", "stop play");
    cfx();
    this.xsB.stopPlay();
    AppMethodBeat.o(27988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordVoiceBaseView
 * JD-Core Version:    0.7.0.1
 */