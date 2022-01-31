package com.tencent.mm.ui.mogic;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WxViewPager$LayoutParams
  extends ViewGroup.LayoutParams
{
  public boolean Hb;
  boolean Hc;
  int Hd;
  public int gravity;
  int position;
  float widthFactor;
  
  public WxViewPager$LayoutParams()
  {
    super(-1, -1);
    this.widthFactor = 0.0F;
  }
  
  public WxViewPager$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(107454);
    this.widthFactor = 0.0F;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, WxViewPager.access$400());
    this.gravity = paramContext.getInteger(0, 48);
    paramContext.recycle();
    AppMethodBeat.o(107454);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.mogic.WxViewPager.LayoutParams
 * JD-Core Version:    0.7.0.1
 */