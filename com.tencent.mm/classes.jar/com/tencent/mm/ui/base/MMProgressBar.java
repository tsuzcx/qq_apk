package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;

public class MMProgressBar
  extends LinearLayout
{
  private int Jmj;
  private int Jmk;
  private TextView Jml;
  private a Jmm;
  private int max;
  private av wxw;
  private TextView ySI;
  
  public MMProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142059);
    this.max = 100;
    this.Jmj = 0;
    this.Jmk = 0;
    this.wxw = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(142058);
        int j = MMProgressBar.a(MMProgressBar.this) - MMProgressBar.b(MMProgressBar.this);
        int i;
        Object localObject;
        int k;
        if (j > 0)
        {
          i = (int)(j * 0.6D);
          localObject = MMProgressBar.this;
          k = MMProgressBar.b(MMProgressBar.this);
          if (i <= 0) {
            break label122;
          }
        }
        for (;;)
        {
          MMProgressBar.a((MMProgressBar)localObject, i + k);
          MMProgressBar.b(MMProgressBar.this, MMProgressBar.b(MMProgressBar.this));
          localObject = MMProgressBar.d(MMProgressBar.this);
          long l = (MMProgressBar.c(MMProgressBar.this) - j) * 40 / MMProgressBar.c(MMProgressBar.this);
          ((av)localObject).az(l, l);
          AppMethodBeat.o(142058);
          return false;
          label122:
          i = 1;
        }
      }
    }, false);
    inflate(getContext(), 2131494895, this);
    this.Jml = ((TextView)findViewById(2131302336));
    this.ySI = ((TextView)findViewById(2131302337));
    AppMethodBeat.o(142059);
  }
  
  private int getProgressLength()
  {
    AppMethodBeat.i(142063);
    int j = getWidth() * this.Jmj / this.max;
    int i = j;
    if (j < BackwardSupportUtil.b.g(getContext(), 20.0F)) {
      i = BackwardSupportUtil.b.g(getContext(), 20.0F);
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
    return this.Jmk;
  }
  
  public void setAutoProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(142061);
    if (paramBoolean)
    {
      this.wxw.az(40L, 40L);
      AppMethodBeat.o(142061);
      return;
    }
    this.wxw.stopTimer();
    AppMethodBeat.o(142061);
  }
  
  public void setMax(int paramInt)
  {
    this.max = paramInt;
  }
  
  public void setOnProgressChangedListener(a parama)
  {
    this.Jmm = parama;
  }
  
  public void setProgress(int paramInt)
  {
    AppMethodBeat.i(142060);
    int i = paramInt;
    if (paramInt > this.max) {
      i = this.max;
    }
    this.Jmk = i;
    if (this.wxw.fkZ()) {
      setAutoProgress(true);
    }
    AppMethodBeat.o(142060);
  }
  
  public void setTips(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142062);
    this.ySI.setText(paramCharSequence);
    AppMethodBeat.o(142062);
  }
  
  public static abstract interface a
  {
    public abstract void Tj(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMProgressBar
 * JD-Core Version:    0.7.0.1
 */