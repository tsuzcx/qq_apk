package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

public class MMProgressBar
  extends LinearLayout
{
  private MTimerHandler GBW;
  private TextView Jto;
  private int Wlc;
  private int Wld;
  private TextView Wle;
  private a Wlf;
  private int max;
  
  public MMProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142059);
    this.max = 100;
    this.Wlc = 0;
    this.Wld = 0;
    this.GBW = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(142058);
        int j = MMProgressBar.a(MMProgressBar.this) - MMProgressBar.b(MMProgressBar.this);
        int i;
        MMProgressBar localMMProgressBar;
        int k;
        if (j > 0)
        {
          i = (int)(j * 0.6D);
          localMMProgressBar = MMProgressBar.this;
          k = MMProgressBar.b(MMProgressBar.this);
          if (i <= 0) {
            break label112;
          }
        }
        for (;;)
        {
          MMProgressBar.a(localMMProgressBar, i + k);
          MMProgressBar.b(MMProgressBar.this, MMProgressBar.b(MMProgressBar.this));
          MMProgressBar.d(MMProgressBar.this).startTimer((MMProgressBar.c(MMProgressBar.this) - j) * 40 / MMProgressBar.c(MMProgressBar.this));
          AppMethodBeat.o(142058);
          return false;
          label112:
          i = 1;
        }
      }
    }, false);
    inflate(getContext(), a.h.mm_progress_bar, this);
    this.Wle = ((TextView)findViewById(a.g.mm_progress_bar_progress));
    this.Jto = ((TextView)findViewById(a.g.mm_progress_bar_tips));
    AppMethodBeat.o(142059);
  }
  
  private int getProgressLength()
  {
    AppMethodBeat.i(142063);
    int j = getWidth() * this.Wlc / this.max;
    int i = j;
    if (j < BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 20.0F)) {
      i = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 20.0F);
    }
    AppMethodBeat.o(142063);
    return i;
  }
  
  public int getMax()
  {
    return this.max;
  }
  
  public int getProgress()
  {
    return this.Wld;
  }
  
  public void setAutoProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(142061);
    if (paramBoolean)
    {
      this.GBW.startTimer(40L);
      AppMethodBeat.o(142061);
      return;
    }
    this.GBW.stopTimer();
    AppMethodBeat.o(142061);
  }
  
  public void setMax(int paramInt)
  {
    this.max = paramInt;
  }
  
  public void setOnProgressChangedListener(a parama)
  {
    this.Wlf = parama;
  }
  
  public void setProgress(int paramInt)
  {
    AppMethodBeat.i(142060);
    int i = paramInt;
    if (paramInt > this.max) {
      i = this.max;
    }
    this.Wld = i;
    if (this.GBW.stopped()) {
      setAutoProgress(true);
    }
    AppMethodBeat.o(142060);
  }
  
  public void setTips(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142062);
    this.Jto.setText(paramCharSequence);
    AppMethodBeat.o(142062);
  }
  
  public static abstract interface a
  {
    public abstract void ajM(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMProgressBar
 * JD-Core Version:    0.7.0.1
 */