package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.f;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ah.a.m;
import com.tencent.mm.sdk.platformtools.Log;

public class MMDotView
  extends LinearLayout
{
  private int adPZ;
  private int adQa;
  private int lyL;
  
  public MMDotView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141880);
    this.lyL = 9;
    this.adPZ = a.f.page_normal;
    this.adQa = a.f.page_active;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(141880);
  }
  
  public MMDotView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(141879);
    this.lyL = 9;
    this.adPZ = a.f.page_normal;
    this.adQa = a.f.page_active;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(141879);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(141881);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.MMDotView);
    int i = paramContext.getResourceId(a.m.MMDotView_dot_count, 0);
    paramContext.recycle();
    setDotCount(i);
    AppMethodBeat.o(141881);
  }
  
  public void setDarkStyle(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.adPZ = a.f.page_normal_dark;
      this.adQa = a.f.page_active_dark;
      return;
    }
    this.adPZ = a.f.page_normal;
    this.adQa = a.f.page_active;
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
    if (paramInt > this.lyL)
    {
      Log.i("MicroMsg.MMDotView", "large than max count");
      i = this.lyL;
    }
    removeAllViews();
    while (i != 0)
    {
      localImageView = (ImageView)View.inflate(getContext(), a.h.mmpage_control_image, null);
      localImageView.setImageResource(this.adPZ);
      addView(localImageView);
      i -= 1;
    }
    ImageView localImageView = (ImageView)getChildAt(0);
    if (localImageView != null) {
      localImageView.setImageResource(this.adQa);
    }
    AppMethodBeat.o(141883);
  }
  
  public void setInvertedStyle(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.adPZ = a.f.page_active;
      this.adQa = a.f.page_normal;
      return;
    }
    this.adPZ = a.f.page_normal;
    this.adQa = a.f.page_active;
  }
  
  public void setMaxCount(int paramInt)
  {
    AppMethodBeat.i(141882);
    Log.d("MicroMsg.MMDotView", "setMaxCount:%d", new Object[] { Integer.valueOf(paramInt) });
    this.lyL = paramInt;
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
        ((ImageView)getChildAt(paramInt)).setImageResource(this.adPZ);
        paramInt += 1;
      }
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
    }
    ImageView localImageView = (ImageView)getChildAt(i);
    if (localImageView != null) {
      localImageView.setImageResource(this.adQa);
    }
    AppMethodBeat.o(141884);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMDotView
 * JD-Core Version:    0.7.0.1
 */