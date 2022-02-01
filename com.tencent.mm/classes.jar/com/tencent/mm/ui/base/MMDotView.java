package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.a.a;
import com.tencent.mm.sdk.platformtools.ad;

public class MMDotView
  extends LinearLayout
{
  private int FWG;
  private int FWH;
  private int maxCount;
  
  public MMDotView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141880);
    this.maxCount = 9;
    this.FWG = 2131233546;
    this.FWH = 2131233541;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(141880);
  }
  
  @TargetApi(11)
  public MMDotView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(141879);
    this.maxCount = 9;
    this.FWG = 2131233546;
    this.FWH = 2131233541;
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
      this.FWG = 2131233547;
      this.FWH = 2131233542;
      return;
    }
    this.FWG = 2131233546;
    this.FWH = 2131233541;
  }
  
  public void setDotCount(int paramInt)
  {
    AppMethodBeat.i(141883);
    ad.v("MicroMsg.MMDotView", "setDotCount:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt < 0)
    {
      AppMethodBeat.o(141883);
      return;
    }
    int i = paramInt;
    if (paramInt > this.maxCount)
    {
      ad.i("MicroMsg.MMDotView", "large than max count");
      i = this.maxCount;
    }
    removeAllViews();
    while (i != 0)
    {
      localImageView = (ImageView)View.inflate(getContext(), 2131494916, null);
      localImageView.setImageResource(this.FWG);
      addView(localImageView);
      i -= 1;
    }
    ImageView localImageView = (ImageView)getChildAt(0);
    if (localImageView != null) {
      localImageView.setImageResource(this.FWH);
    }
    AppMethodBeat.o(141883);
  }
  
  public void setInvertedStyle(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.FWG = 2131233541;
      this.FWH = 2131233546;
      return;
    }
    this.FWG = 2131233546;
    this.FWH = 2131233541;
  }
  
  public void setMaxCount(int paramInt)
  {
    AppMethodBeat.i(141882);
    ad.d("MicroMsg.MMDotView", "setMaxCount:%d", new Object[] { Integer.valueOf(paramInt) });
    this.maxCount = paramInt;
    AppMethodBeat.o(141882);
  }
  
  public void setSelectedDot(int paramInt)
  {
    AppMethodBeat.i(141884);
    ad.v("MicroMsg.MMDotView", "setSelectedDot:target index is %d", new Object[] { Integer.valueOf(paramInt) });
    int i;
    if (paramInt >= getChildCount()) {
      i = getChildCount() - 1;
    }
    for (;;)
    {
      ad.v("MicroMsg.MMDotView", "setSelectedDot:after adjust index is %d", new Object[] { Integer.valueOf(i) });
      paramInt = 0;
      while (paramInt < getChildCount())
      {
        ((ImageView)getChildAt(paramInt)).setImageResource(this.FWG);
        paramInt += 1;
      }
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
    }
    ImageView localImageView = (ImageView)getChildAt(i);
    if (localImageView != null) {
      localImageView.setImageResource(this.FWH);
    }
    AppMethodBeat.o(141884);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMDotView
 * JD-Core Version:    0.7.0.1
 */