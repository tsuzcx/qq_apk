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
import com.tencent.mm.sdk.platformtools.ae;

public class MMDotView
  extends LinearLayout
{
  private int JEY;
  private int JEZ;
  private int maxCount;
  
  public MMDotView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141880);
    this.maxCount = 9;
    this.JEY = 2131233546;
    this.JEZ = 2131233541;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(141880);
  }
  
  @TargetApi(11)
  public MMDotView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(141879);
    this.maxCount = 9;
    this.JEY = 2131233546;
    this.JEZ = 2131233541;
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
      this.JEY = 2131233547;
      this.JEZ = 2131233542;
      return;
    }
    this.JEY = 2131233546;
    this.JEZ = 2131233541;
  }
  
  public void setDotCount(int paramInt)
  {
    AppMethodBeat.i(141883);
    ae.v("MicroMsg.MMDotView", "setDotCount:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt < 0)
    {
      AppMethodBeat.o(141883);
      return;
    }
    int i = paramInt;
    if (paramInt > this.maxCount)
    {
      ae.i("MicroMsg.MMDotView", "large than max count");
      i = this.maxCount;
    }
    removeAllViews();
    while (i != 0)
    {
      localImageView = (ImageView)View.inflate(getContext(), 2131494916, null);
      localImageView.setImageResource(this.JEY);
      addView(localImageView);
      i -= 1;
    }
    ImageView localImageView = (ImageView)getChildAt(0);
    if (localImageView != null) {
      localImageView.setImageResource(this.JEZ);
    }
    AppMethodBeat.o(141883);
  }
  
  public void setInvertedStyle(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.JEY = 2131233541;
      this.JEZ = 2131233546;
      return;
    }
    this.JEY = 2131233546;
    this.JEZ = 2131233541;
  }
  
  public void setMaxCount(int paramInt)
  {
    AppMethodBeat.i(141882);
    ae.d("MicroMsg.MMDotView", "setMaxCount:%d", new Object[] { Integer.valueOf(paramInt) });
    this.maxCount = paramInt;
    AppMethodBeat.o(141882);
  }
  
  public void setSelectedDot(int paramInt)
  {
    AppMethodBeat.i(141884);
    ae.v("MicroMsg.MMDotView", "setSelectedDot:target index is %d", new Object[] { Integer.valueOf(paramInt) });
    int i;
    if (paramInt >= getChildCount()) {
      i = getChildCount() - 1;
    }
    for (;;)
    {
      ae.v("MicroMsg.MMDotView", "setSelectedDot:after adjust index is %d", new Object[] { Integer.valueOf(i) });
      paramInt = 0;
      while (paramInt < getChildCount())
      {
        ((ImageView)getChildAt(paramInt)).setImageResource(this.JEY);
        paramInt += 1;
      }
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
    }
    ImageView localImageView = (ImageView)getChildAt(i);
    if (localImageView != null) {
      localImageView.setImageResource(this.JEZ);
    }
    AppMethodBeat.o(141884);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMDotView
 * JD-Core Version:    0.7.0.1
 */