package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class RelativePopupWindow
  extends PopupWindow
{
  private boolean LpD;
  private FrameLayout wVM;
  
  public RelativePopupWindow(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public RelativePopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(193797);
    this.LpD = false;
    this.wVM = new FrameLayout(paramContext);
    super.setContentView(this.wVM);
    AppMethodBeat.o(193797);
  }
  
  public View getContentView()
  {
    AppMethodBeat.i(193799);
    View localView = this.wVM.getChildAt(0);
    AppMethodBeat.o(193799);
    return localView;
  }
  
  public void setContentView(View paramView)
  {
    AppMethodBeat.i(193798);
    this.wVM.removeAllViews();
    this.wVM.addView(paramView);
    AppMethodBeat.o(193798);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.RelativePopupWindow
 * JD-Core Version:    0.7.0.1
 */