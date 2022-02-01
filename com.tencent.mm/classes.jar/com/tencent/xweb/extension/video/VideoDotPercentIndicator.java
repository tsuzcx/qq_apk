package com.tencent.xweb.extension.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;
import org.xwalk.core.R.drawable;
import org.xwalk.core.R.layout;

public class VideoDotPercentIndicator
  extends LinearLayout
{
  private LayoutInflater mInflater;
  private int pCR;
  
  public VideoDotPercentIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(153554);
    init(paramContext);
    AppMethodBeat.o(153554);
  }
  
  public VideoDotPercentIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(153555);
    init(paramContext);
    AppMethodBeat.o(153555);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(153556);
    this.mInflater = LayoutInflater.from(paramContext);
    setDotsNum(0);
    AppMethodBeat.o(153556);
  }
  
  public void setDotsNum(int paramInt)
  {
    AppMethodBeat.i(153557);
    if (paramInt > 1) {}
    for (;;)
    {
      this.pCR = paramInt;
      removeAllViews();
      paramInt = 0;
      while (paramInt < this.pCR)
      {
        addView((ImageView)this.mInflater.inflate(R.layout.xweb_dot_percent_indicator_dot, this, false));
        paramInt += 1;
      }
      paramInt = 8;
    }
    AppMethodBeat.o(153557);
  }
  
  public void setProgress(float paramFloat)
  {
    float f1 = 1.0F;
    float f2 = 0.0F;
    AppMethodBeat.i(153558);
    paramFloat /= 100.0F;
    if (paramFloat < 0.0F)
    {
      paramFloat = f2;
      if (paramFloat <= 1.0F) {
        break label129;
      }
      paramFloat = f1;
    }
    int j;
    label129:
    for (;;)
    {
      int k = (int)Math.rint(this.pCR * paramFloat);
      Log.v("MicroMsg.AppBrandDotPercentIndicator", "setPercent percent:" + paramFloat + " dotsOnNum:" + k);
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
        ((ImageView)getChildAt(i)).setImageResource(R.drawable.xweb_video_percent_indicator_dot_on_shape);
        i += 1;
      }
      break;
    }
    while (j < getChildCount())
    {
      ((ImageView)getChildAt(j)).setImageResource(R.drawable.xweb_video_percent_indicator_dot_off_shape);
      j += 1;
    }
    AppMethodBeat.o(153558);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.extension.video.VideoDotPercentIndicator
 * JD-Core Version:    0.7.0.1
 */