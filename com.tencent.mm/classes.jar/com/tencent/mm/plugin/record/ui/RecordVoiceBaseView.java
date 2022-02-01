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
import com.tencent.mm.plugin.record.b.s;
import com.tencent.mm.plugin.record.b.s.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.t;
import java.util.Iterator;
import java.util.List;

public class RecordVoiceBaseView
  extends TextView
  implements s.a
{
  private Context context;
  public int dhE;
  public int duration;
  private boolean isRunning;
  private AlphaAnimation oUC;
  private AnimationDrawable oUD;
  public String path;
  private s wkH;
  
  public RecordVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27982);
    this.isRunning = false;
    this.duration = -1;
    this.path = "";
    this.context = paramContext;
    aMN();
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
    aMN();
    AppMethodBeat.o(27983);
  }
  
  private void aMN()
  {
    AppMethodBeat.i(27984);
    this.oUC = new AlphaAnimation(0.1F, 1.0F);
    this.oUC.setDuration(1000L);
    this.oUC.setRepeatCount(-1);
    this.oUC.setRepeatMode(2);
    this.oUD = new com.tencent.mm.ui.e.a();
    Drawable localDrawable = getResources().getDrawable(2131689892);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.oUD.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689893);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.oUD.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689894);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.oUD.addFrame(localDrawable, 300);
    this.oUD.setOneShot(false);
    this.oUD.setVisible(true, true);
    AppMethodBeat.o(27984);
  }
  
  private void caT()
  {
    AppMethodBeat.i(27985);
    if ((this.oUC != null) && (this.oUC.isInitialized())) {
      setAnimation(null);
    }
    this.isRunning = false;
    setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2131689891), null, null, null);
    this.oUD.stop();
    AppMethodBeat.o(27985);
  }
  
  public final void aqt(String paramString)
  {
    AppMethodBeat.i(27989);
    ac.d("MicroMsg.RecordVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[] { this.path, Integer.valueOf(this.duration), paramString });
    if (!bs.bG(paramString, "").equals(this.path)) {
      caT();
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
        ac.d("MicroMsg.RecordVoiceBaseView", "clicked path %s, isPlay %s", new Object[] { RecordVoiceBaseView.a(RecordVoiceBaseView.this), Boolean.valueOf(RecordVoiceBaseView.b(RecordVoiceBaseView.this).caY()) });
        if ((com.tencent.mm.r.a.ci(RecordVoiceBaseView.c(RecordVoiceBaseView.this))) || (com.tencent.mm.r.a.cf(RecordVoiceBaseView.c(RecordVoiceBaseView.this))) || (com.tencent.mm.r.a.ck(RecordVoiceBaseView.c(RecordVoiceBaseView.this))))
        {
          AppMethodBeat.o(27981);
          return;
        }
        if ((!e.YD()) && (!bs.isNullOrNil(RecordVoiceBaseView.a(RecordVoiceBaseView.this))))
        {
          t.g(paramAnonymousView.getContext(), null);
          AppMethodBeat.o(27981);
          return;
        }
        if (!bs.bG(RecordVoiceBaseView.a(RecordVoiceBaseView.this), "").equals(RecordVoiceBaseView.b(RecordVoiceBaseView.this).path))
        {
          RecordVoiceBaseView.d(RecordVoiceBaseView.this);
          AppMethodBeat.o(27981);
          return;
        }
        if (RecordVoiceBaseView.b(RecordVoiceBaseView.this).caY())
        {
          RecordVoiceBaseView.this.stopPlay();
          AppMethodBeat.o(27981);
          return;
        }
        if (!RecordVoiceBaseView.e(RecordVoiceBaseView.this)) {
          RecordVoiceBaseView.d(RecordVoiceBaseView.this);
        }
        AppMethodBeat.o(27981);
      }
    });
    AppMethodBeat.o(27986);
  }
  
  public void setVoiceHelper(s params)
  {
    AppMethodBeat.i(27987);
    this.wkH = params;
    params = this.wkH;
    Iterator localIterator = params.callbacks.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (this != (s.a)localIterator.next());
    for (;;)
    {
      AppMethodBeat.o(27987);
      return;
      params.callbacks.add(this);
    }
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(27988);
    ac.d("MicroMsg.RecordVoiceBaseView", "stop play");
    caT();
    this.wkH.stopPlay();
    AppMethodBeat.o(27988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordVoiceBaseView
 * JD-Core Version:    0.7.0.1
 */