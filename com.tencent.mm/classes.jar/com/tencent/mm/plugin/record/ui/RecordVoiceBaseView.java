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
import com.tencent.mm.R.k;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.record.b.u;
import com.tencent.mm.plugin.record.b.u.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.w;
import java.util.Iterator;
import java.util.List;

public class RecordVoiceBaseView
  extends TextView
  implements u.a
{
  private u HEH;
  private Context context;
  public int duration;
  public int fEi;
  private boolean isRunning;
  public String path;
  private AlphaAnimation uwn;
  private AnimationDrawable uwo;
  
  public RecordVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27982);
    this.isRunning = false;
    this.duration = -1;
    this.path = "";
    this.context = paramContext;
    buR();
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
    buR();
    AppMethodBeat.o(27983);
  }
  
  private void buR()
  {
    AppMethodBeat.i(27984);
    this.uwn = new AlphaAnimation(0.1F, 1.0F);
    this.uwn.setDuration(1000L);
    this.uwn.setRepeatCount(-1);
    this.uwn.setRepeatMode(2);
    this.uwo = new com.tencent.mm.ui.g.a();
    Drawable localDrawable = getResources().getDrawable(R.k.chatfrom_voice_playing_new_f1);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.uwo.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(R.k.chatfrom_voice_playing_new_f2);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.uwo.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(R.k.chatfrom_voice_playing_new_f3);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.uwo.addFrame(localDrawable, 300);
    this.uwo.setOneShot(false);
    this.uwo.setVisible(true, true);
    AppMethodBeat.o(27984);
  }
  
  private void cTg()
  {
    AppMethodBeat.i(27985);
    if ((this.uwn != null) && (this.uwn.isInitialized())) {
      setAnimation(null);
    }
    this.isRunning = false;
    setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.k.chatfrom_voice_playing_new), null, null, null);
    this.uwo.stop();
    AppMethodBeat.o(27985);
  }
  
  public final void aVA(String paramString)
  {
    AppMethodBeat.i(27989);
    Log.d("MicroMsg.RecordVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[] { this.path, Integer.valueOf(this.duration), paramString });
    if (!Util.nullAs(paramString, "").equals(this.path)) {
      cTg();
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
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/record/ui/RecordVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.d("MicroMsg.RecordVoiceBaseView", "clicked path %s, isPlay %s", new Object[] { RecordVoiceBaseView.a(RecordVoiceBaseView.this), Boolean.valueOf(RecordVoiceBaseView.b(RecordVoiceBaseView.this).cTl()) });
        if ((com.tencent.mm.q.a.cy(RecordVoiceBaseView.c(RecordVoiceBaseView.this))) || (com.tencent.mm.q.a.cw(RecordVoiceBaseView.c(RecordVoiceBaseView.this))) || (com.tencent.mm.q.a.cB(RecordVoiceBaseView.c(RecordVoiceBaseView.this))))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/RecordVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27981);
          return;
        }
        if ((!e.avA()) && (!Util.isNullOrNil(RecordVoiceBaseView.a(RecordVoiceBaseView.this))))
        {
          w.g(paramAnonymousView.getContext(), null);
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
          if (RecordVoiceBaseView.b(RecordVoiceBaseView.this).cTl()) {
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
    this.HEH = paramu;
    paramu = this.HEH;
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
    cTg();
    this.HEH.stopPlay();
    AppMethodBeat.o(27988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordVoiceBaseView
 * JD-Core Version:    0.7.0.1
 */