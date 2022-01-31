package com.tencent.xweb.extension.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class VideoDotPercentIndicator
  extends LinearLayout
{
  private int ibJ;
  private LayoutInflater mInflater;
  
  public VideoDotPercentIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(84559);
    init(paramContext);
    AppMethodBeat.o(84559);
  }
  
  public VideoDotPercentIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(84560);
    init(paramContext);
    AppMethodBeat.o(84560);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(84561);
    this.mInflater = LayoutInflater.from(paramContext);
    setDotsNum(0);
    AppMethodBeat.o(84561);
  }
  
  public void setDotsNum(int paramInt)
  {
    AppMethodBeat.i(84562);
    if (paramInt > 1) {}
    for (;;)
    {
      this.ibJ = paramInt;
      removeAllViews();
      paramInt = 0;
      while (paramInt < this.ibJ)
      {
        addView((ImageView)this.mInflater.inflate(2130971343, this, false));
        paramInt += 1;
      }
      paramInt = 8;
    }
    AppMethodBeat.o(84562);
  }
  
  public void setProgress(float paramFloat)
  {
    float f1 = 1.0F;
    float f2 = 0.0F;
    AppMethodBeat.i(84563);
    paramFloat /= 100.0F;
    if (paramFloat < 0.0F)
    {
      paramFloat = f2;
      if (paramFloat <= 1.0F) {
        break label123;
      }
      paramFloat = f1;
    }
    int j;
    label123:
    for (;;)
    {
      int k = (int)Math.rint(this.ibJ * paramFloat);
      ab.v("MicroMsg.AppBrandDotPercentIndicator", "setPercent percent:%s dotsOnNum:%d", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(k) });
      int i = 0;
      for (;;)
      {
        j = i;
        if (i >= k) {
          break;
        }
        j = i;
        if (i >= getChildCount()) {
          break;
        }
        ((ImageView)getChildAt(i)).setImageResource(2130840984);
        i += 1;
      }
      break;
    }
    while (j < getChildCount())
    {
      ((ImageView)getChildAt(j)).setImageResource(2130840983);
      j += 1;
    }
    AppMethodBeat.o(84563);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.extension.video.VideoDotPercentIndicator
 * JD-Core Version:    0.7.0.1
 */