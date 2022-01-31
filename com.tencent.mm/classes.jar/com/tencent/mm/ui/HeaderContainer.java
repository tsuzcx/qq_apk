package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class HeaderContainer
  extends FrameLayout
{
  private Rect jdr;
  private z yXA;
  private i yXz;
  
  public HeaderContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(29334);
    this.jdr = new Rect();
    init(paramContext);
    AppMethodBeat.o(29334);
  }
  
  public HeaderContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29335);
    this.jdr = new Rect();
    init(paramContext);
    AppMethodBeat.o(29335);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(29338);
    this.yXA = new z(paramContext);
    this.yXA.setHeaderContainer(this);
    this.yXA.setId(2131820647);
    paramContext = new FrameLayout.LayoutParams(-1, -2);
    addView(this.yXA, paramContext);
    AppMethodBeat.o(29338);
  }
  
  public Rect getBackUpFooterRect()
  {
    return this.jdr;
  }
  
  public z getHeaderView()
  {
    return this.yXA;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(29337);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(29337);
  }
  
  public void setAnimController(i parami)
  {
    AppMethodBeat.i(29336);
    this.yXz = parami;
    if ((this.yXA != null) && (this.yXz != null)) {
      this.yXz.a(this.yXA);
    }
    AppMethodBeat.o(29336);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.HeaderContainer
 * JD-Core Version:    0.7.0.1
 */