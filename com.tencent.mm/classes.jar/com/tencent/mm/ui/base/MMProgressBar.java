package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

public class MMProgressBar
  extends LinearLayout
{
  private MTimerHandler AIN;
  private TextView DnJ;
  private int ORP;
  private int ORQ;
  private TextView ORR;
  private a ORS;
  private int max;
  
  public MMProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142059);
    this.max = 100;
    this.ORP = 0;
    this.ORQ = 0;
    this.AIN = new MTimerHandler(new MTimerHandler.CallBack()
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
    inflate(getContext(), 2131495633, this);
    this.ORR = ((TextView)findViewById(2131304731));
    this.DnJ = ((TextView)findViewById(2131304732));
    AppMethodBeat.o(142059);
  }
  
  private int getProgressLength()
  {
    AppMethodBeat.i(142063);
    int j = getWidth() * this.ORP / this.max;
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
    return this.ORQ;
  }
  
  public void setAutoProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(142061);
    if (paramBoolean)
    {
      this.AIN.startTimer(40L);
      AppMethodBeat.o(142061);
      return;
    }
    this.AIN.stopTimer();
    AppMethodBeat.o(142061);
  }
  
  public void setMax(int paramInt)
  {
    this.max = paramInt;
  }
  
  public void setOnProgressChangedListener(a parama)
  {
    this.ORS = parama;
  }
  
  public void setProgress(int paramInt)
  {
    AppMethodBeat.i(142060);
    int i = paramInt;
    if (paramInt > this.max) {
      i = this.max;
    }
    this.ORQ = i;
    if (this.AIN.stopped()) {
      setAutoProgress(true);
    }
    AppMethodBeat.o(142060);
  }
  
  public void setTips(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142062);
    this.DnJ.setText(paramCharSequence);
    AppMethodBeat.o(142062);
  }
  
  public static abstract interface a
  {
    public abstract void acg(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMProgressBar
 * JD-Core Version:    0.7.0.1
 */