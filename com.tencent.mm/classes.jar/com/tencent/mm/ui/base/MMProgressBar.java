package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.am;

public class MMProgressBar
  extends LinearLayout
{
  private am mKp = new am(new MMProgressBar.1(this), false);
  private int max = 100;
  private TextView ofU;
  private int uWL = 0;
  private int uWM = 0;
  private TextView uWN;
  private MMProgressBar.a uWO;
  
  public MMProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    inflate(getContext(), a.h.mm_progress_bar, this);
    this.uWN = ((TextView)findViewById(a.g.mm_progress_bar_progress));
    this.ofU = ((TextView)findViewById(a.g.mm_progress_bar_tips));
  }
  
  private int getProgressLength()
  {
    int j = getWidth() * this.uWL / this.max;
    int i = j;
    if (j < BackwardSupportUtil.b.b(getContext(), 20.0F)) {
      i = BackwardSupportUtil.b.b(getContext(), 20.0F);
    }
    return i;
  }
  
  public int getMax()
  {
    return this.max;
  }
  
  public int getProgress()
  {
    return this.uWM;
  }
  
  public void setAutoProgress(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mKp.S(40L, 40L);
      return;
    }
    this.mKp.stopTimer();
  }
  
  public void setMax(int paramInt)
  {
    this.max = paramInt;
  }
  
  public void setOnProgressChangedListener(MMProgressBar.a parama)
  {
    this.uWO = parama;
  }
  
  public void setProgress(int paramInt)
  {
    int i = paramInt;
    if (paramInt > this.max) {
      i = this.max;
    }
    this.uWM = i;
    if (this.mKp.crl()) {
      setAutoProgress(true);
    }
  }
  
  public void setTips(CharSequence paramCharSequence)
  {
    this.ofU.setText(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMProgressBar
 * JD-Core Version:    0.7.0.1
 */