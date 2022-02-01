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
import com.tencent.mm.plugin.record.b.u.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;

public class RecordVoiceBaseView
  extends TextView
  implements u.a
{
  private com.tencent.mm.plugin.record.b.u BIz;
  private Context context;
  public int dLt;
  public int duration;
  private boolean isRunning;
  public String path;
  private AlphaAnimation qUh;
  private AnimationDrawable qUi;
  
  public RecordVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27982);
    this.isRunning = false;
    this.duration = -1;
    this.path = "";
    this.context = paramContext;
    blc();
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
    blc();
    AppMethodBeat.o(27983);
  }
  
  private void blc()
  {
    AppMethodBeat.i(27984);
    this.qUh = new AlphaAnimation(0.1F, 1.0F);
    this.qUh.setDuration(1000L);
    this.qUh.setRepeatCount(-1);
    this.qUh.setRepeatMode(2);
    this.qUi = new com.tencent.mm.ui.f.a();
    Drawable localDrawable = getResources().getDrawable(2131689907);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.qUi.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689908);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.qUi.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689909);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.qUi.addFrame(localDrawable, 300);
    this.qUi.setOneShot(false);
    this.qUi.setVisible(true, true);
    AppMethodBeat.o(27984);
  }
  
  private void cEA()
  {
    AppMethodBeat.i(27985);
    if ((this.qUh != null) && (this.qUh.isInitialized())) {
      setAnimation(null);
    }
    this.isRunning = false;
    setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2131689906), null, null, null);
    this.qUi.stop();
    AppMethodBeat.o(27985);
  }
  
  public final void aKZ(String paramString)
  {
    AppMethodBeat.i(27989);
    Log.d("MicroMsg.RecordVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[] { this.path, Integer.valueOf(this.duration), paramString });
    if (!Util.nullAs(paramString, "").equals(this.path)) {
      cEA();
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
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/record/ui/RecordVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.d("MicroMsg.RecordVoiceBaseView", "clicked path %s, isPlay %s", new Object[] { RecordVoiceBaseView.a(RecordVoiceBaseView.this), Boolean.valueOf(RecordVoiceBaseView.b(RecordVoiceBaseView.this).cEF()) });
        if ((com.tencent.mm.q.a.cC(RecordVoiceBaseView.c(RecordVoiceBaseView.this))) || (com.tencent.mm.q.a.cA(RecordVoiceBaseView.c(RecordVoiceBaseView.this))) || (com.tencent.mm.q.a.cE(RecordVoiceBaseView.c(RecordVoiceBaseView.this))))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/RecordVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27981);
          return;
        }
        if ((!e.apn()) && (!Util.isNullOrNil(RecordVoiceBaseView.a(RecordVoiceBaseView.this))))
        {
          com.tencent.mm.ui.base.u.g(paramAnonymousView.getContext(), null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/RecordVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27981);
          return;
        }
        if (!Util.nullAs(RecordVoiceBaseView.a(RecordVoiceBaseView.this), "").equals(RecordVoiceBaseView.b(RecordVoiceBaseView.this).path)) {
          RecordVoiceBaseView.d(RecordVoiceBaseView.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/RecordVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27981);
          return;
          if (RecordVoiceBaseView.b(RecordVoiceBaseView.this).cEF()) {
            RecordVoiceBaseView.this.stopPlay();
          } else if (!RecordVoiceBaseView.e(RecordVoiceBaseView.this)) {
            RecordVoiceBaseView.d(RecordVoiceBaseView.this);
          }
        }
      }
    });
    AppMethodBeat.o(27986);
  }
  
  public void setVoiceHelper(com.tencent.mm.plugin.record.b.u paramu)
  {
    AppMethodBeat.i(27987);
    this.BIz = paramu;
    paramu = this.BIz;
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
    Log.d("MicroMsg.RecordVoiceBaseView", "stop play");
    cEA();
    this.BIz.stopPlay();
    AppMethodBeat.o(27988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordVoiceBaseView
 * JD-Core Version:    0.7.0.1
 */