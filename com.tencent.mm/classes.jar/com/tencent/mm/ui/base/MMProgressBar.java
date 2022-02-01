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
  private MTimerHandler Mye;
  private TextView PtY;
  private int adSw;
  private int adSx;
  private TextView adSy;
  private MMProgressBar.a adSz;
  private int max;
  
  public MMProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142059);
    this.max = 100;
    this.adSw = 0;
    this.adSx = 0;
    this.Mye = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(142058);
        int j = MMProgressBar.a(MMProgressBar.this) - MMProgressBar.b(MMProgressBar.this);
        int i;
        MMProgressBar localMMProgressBar;
        if (j > 0)
        {
          i = (int)(j * 0.6D);
          localMMProgressBar = MMProgressBar.this;
          if (i <= 0) {
            break label100;
          }
        }
        for (;;)
        {
          MMProgressBar.a(localMMProgressBar, i);
          MMProgressBar.b(MMProgressBar.this, MMProgressBar.b(MMProgressBar.this));
          MMProgressBar.d(MMProgressBar.this).startTimer((MMProgressBar.c(MMProgressBar.this) - j) * 40 / MMProgressBar.c(MMProgressBar.this));
          AppMethodBeat.o(142058);
          return false;
          label100:
          i = 1;
        }
      }
    }, false);
    inflate(getContext(), a.h.mm_progress_bar, this);
    this.adSy = ((TextView)findViewById(a.g.mm_progress_bar_progress));
    this.PtY = ((TextView)findViewById(a.g.mm_progress_bar_tips));
    AppMethodBeat.o(142059);
  }
  
  private int getProgressLength()
  {
    AppMethodBeat.i(142063);
    int j = getWidth() * this.adSw / this.max;
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
    return this.adSx;
  }
  
  public void setAutoProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(142061);
    if (paramBoolean)
    {
      this.Mye.startTimer(40L);
      AppMethodBeat.o(142061);
      return;
    }
    this.Mye.stopTimer();
    AppMethodBeat.o(142061);
  }
  
  public void setMax(int paramInt)
  {
    this.max = paramInt;
  }
  
  public void setOnProgressChangedListener(MMProgressBar.a parama)
  {
    this.adSz = parama;
  }
  
  public void setProgress(int paramInt)
  {
    AppMethodBeat.i(142060);
    int i = paramInt;
    if (paramInt > this.max) {
      i = this.max;
    }
    this.adSx = i;
    if (this.Mye.stopped()) {
      setAutoProgress(true);
    }
    AppMethodBeat.o(142060);
  }
  
  public void setTips(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142062);
    this.PtY.setText(paramCharSequence);
    AppMethodBeat.o(142062);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMProgressBar
 * JD-Core Version:    0.7.0.1
 */