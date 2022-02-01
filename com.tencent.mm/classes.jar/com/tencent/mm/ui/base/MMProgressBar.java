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
  private int FYD;
  private int FYE;
  private TextView FYF;
  private a FYG;
  private int max;
  private av uji;
  private TextView wsI;
  
  public MMProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142059);
    this.max = 100;
    this.FYD = 0;
    this.FYE = 0;
    this.uji = new av(new av.a()
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
          ((av)localObject).av(l, l);
          AppMethodBeat.o(142058);
          return false;
          label122:
          i = 1;
        }
      }
    }, false);
    inflate(getContext(), 2131494895, this);
    this.FYF = ((TextView)findViewById(2131302336));
    this.wsI = ((TextView)findViewById(2131302337));
    AppMethodBeat.o(142059);
  }
  
  private int getProgressLength()
  {
    AppMethodBeat.i(142063);
    int j = getWidth() * this.FYD / this.max;
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
    return this.FYE;
  }
  
  public void setAutoProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(142061);
    if (paramBoolean)
    {
      this.uji.av(40L, 40L);
      AppMethodBeat.o(142061);
      return;
    }
    this.uji.stopTimer();
    AppMethodBeat.o(142061);
  }
  
  public void setMax(int paramInt)
  {
    this.max = paramInt;
  }
  
  public void setOnProgressChangedListener(a parama)
  {
    this.FYG = parama;
  }
  
  public void setProgress(int paramInt)
  {
    AppMethodBeat.i(142060);
    int i = paramInt;
    if (paramInt > this.max) {
      i = this.max;
    }
    this.FYE = i;
    if (this.uji.eFX()) {
      setAutoProgress(true);
    }
    AppMethodBeat.o(142060);
  }
  
  public void setTips(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142062);
    this.wsI.setText(paramCharSequence);
    AppMethodBeat.o(142062);
  }
  
  public static abstract interface a
  {
    public abstract void Pt(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMProgressBar
 * JD-Core Version:    0.7.0.1
 */