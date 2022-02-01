package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.a.a;
import com.tencent.mm.sdk.platformtools.Log;

public class MMDotView
  extends LinearLayout
{
  private int OPQ;
  private int OPR;
  private int maxCount;
  
  public MMDotView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141880);
    this.maxCount = 9;
    this.OPQ = 2131234350;
    this.OPR = 2131234345;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(141880);
  }
  
  @TargetApi(11)
  public MMDotView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(141879);
    this.maxCount = 9;
    this.OPQ = 2131234350;
    this.OPR = 2131234345;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(141879);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(141881);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MMDotView);
    int i = paramContext.getResourceId(0, 0);
    paramContext.recycle();
    setDotCount(i);
    AppMethodBeat.o(141881);
  }
  
  public void setDarkStyle(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.OPQ = 2131234351;
      this.OPR = 2131234346;
      return;
    }
    this.OPQ = 2131234350;
    this.OPR = 2131234345;
  }
  
  public void setDotCount(int paramInt)
  {
    AppMethodBeat.i(141883);
    Log.v("MicroMsg.MMDotView", "setDotCount:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt < 0)
    {
      AppMethodBeat.o(141883);
      return;
    }
    int i = paramInt;
    if (paramInt > this.maxCount)
    {
      Log.i("MicroMsg.MMDotView", "large than max count");
      i = this.maxCount;
    }
    removeAllViews();
    while (i != 0)
    {
      localImageView = (ImageView)View.inflate(getContext(), 2131495656, null);
      localImageView.setImageResource(this.OPQ);
      addView(localImageView);
      i -= 1;
    }
    ImageView localImageView = (ImageView)getChildAt(0);
    if (localImageView != null) {
      localImageView.setImageResource(this.OPR);
    }
    AppMethodBeat.o(141883);
  }
  
  public void setInvertedStyle(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.OPQ = 2131234345;
      this.OPR = 2131234350;
      return;
    }
    this.OPQ = 2131234350;
    this.OPR = 2131234345;
  }
  
  public void setMaxCount(int paramInt)
  {
    AppMethodBeat.i(141882);
    Log.d("MicroMsg.MMDotView", "setMaxCount:%d", new Object[] { Integer.valueOf(paramInt) });
    this.maxCount = paramInt;
    AppMethodBeat.o(141882);
  }
  
  public void setSelectedDot(int paramInt)
  {
    AppMethodBeat.i(141884);
    Log.v("MicroMsg.MMDotView", "setSelectedDot:target index is %d", new Object[] { Integer.valueOf(paramInt) });
    int i;
    if (paramInt >= getChildCount()) {
      i = getChildCount() - 1;
    }
    for (;;)
    {
      Log.v("MicroMsg.MMDotView", "setSelectedDot:after adjust index is %d", new Object[] { Integer.valueOf(i) });
      paramInt = 0;
      while (paramInt < getChildCount())
      {
        ((ImageView)getChildAt(paramInt)).setImageResource(this.OPQ);
        paramInt += 1;
      }
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
    }
    ImageView localImageView = (ImageView)getChildAt(i);
    if (localImageView != null) {
      localImageView.setImageResource(this.OPR);
    }
    AppMethodBeat.o(141884);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMDotView
 * JD-Core Version:    0.7.0.1
 */