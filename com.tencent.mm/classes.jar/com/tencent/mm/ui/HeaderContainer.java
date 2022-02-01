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
  private Rect FTJ;
  private j OCr;
  private ad OCs;
  
  public HeaderContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33167);
    this.FTJ = new Rect();
    init(paramContext);
    AppMethodBeat.o(33167);
  }
  
  public HeaderContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33168);
    this.FTJ = new Rect();
    init(paramContext);
    AppMethodBeat.o(33168);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(33171);
    this.OCs = new ad(paramContext);
    this.OCs.setHeaderContainer(this);
    this.OCs.setId(2131304915);
    paramContext = new FrameLayout.LayoutParams(-1, -2);
    addView(this.OCs, paramContext);
    AppMethodBeat.o(33171);
  }
  
  public Rect getBackUpFooterRect()
  {
    return this.FTJ;
  }
  
  public ad getHeaderView()
  {
    return this.OCs;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33170);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(33170);
  }
  
  public void setAnimController(j paramj)
  {
    AppMethodBeat.i(33169);
    this.OCr = paramj;
    if ((this.OCs != null) && (this.OCr != null)) {
      this.OCr.a(this.OCs);
    }
    AppMethodBeat.o(33169);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.HeaderContainer
 * JD-Core Version:    0.7.0.1
 */