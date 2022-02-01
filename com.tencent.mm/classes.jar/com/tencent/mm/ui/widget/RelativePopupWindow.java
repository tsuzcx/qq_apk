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
  private FrameLayout ARF;
  private boolean QEP;
  
  public RelativePopupWindow(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public RelativePopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(205439);
    this.QEP = false;
    this.ARF = new FrameLayout(paramContext);
    super.setContentView(this.ARF);
    AppMethodBeat.o(205439);
  }
  
  public View getContentView()
  {
    AppMethodBeat.i(205441);
    View localView = this.ARF.getChildAt(0);
    AppMethodBeat.o(205441);
    return localView;
  }
  
  public void setContentView(View paramView)
  {
    AppMethodBeat.i(205440);
    this.ARF.removeAllViews();
    this.ARF.addView(paramView);
    AppMethodBeat.o(205440);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.RelativePopupWindow
 * JD-Core Version:    0.7.0.1
 */