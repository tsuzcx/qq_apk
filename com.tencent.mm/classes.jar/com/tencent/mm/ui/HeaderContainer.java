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
  private i IXt;
  private ac IXu;
  private Rect mVW;
  
  public HeaderContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33167);
    this.mVW = new Rect();
    init(paramContext);
    AppMethodBeat.o(33167);
  }
  
  public HeaderContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33168);
    this.mVW = new Rect();
    init(paramContext);
    AppMethodBeat.o(33168);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(33171);
    this.IXu = new ac(paramContext);
    this.IXu.setHeaderContainer(this);
    this.IXu.setId(2131302489);
    paramContext = new FrameLayout.LayoutParams(-1, -2);
    addView(this.IXu, paramContext);
    AppMethodBeat.o(33171);
  }
  
  public Rect getBackUpFooterRect()
  {
    return this.mVW;
  }
  
  public ac getHeaderView()
  {
    return this.IXu;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33170);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(33170);
  }
  
  public void setAnimController(i parami)
  {
    AppMethodBeat.i(33169);
    this.IXt = parami;
    if ((this.IXu != null) && (this.IXt != null)) {
      this.IXt.a(this.IXu);
    }
    AppMethodBeat.o(33169);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.HeaderContainer
 * JD-Core Version:    0.7.0.1
 */