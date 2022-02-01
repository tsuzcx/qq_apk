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
  private boolean KTf;
  private FrameLayout wGa;
  
  public RelativePopupWindow(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public RelativePopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(186539);
    this.KTf = false;
    this.wGa = new FrameLayout(paramContext);
    super.setContentView(this.wGa);
    AppMethodBeat.o(186539);
  }
  
  public View getContentView()
  {
    AppMethodBeat.i(186541);
    View localView = this.wGa.getChildAt(0);
    AppMethodBeat.o(186541);
    return localView;
  }
  
  public void setContentView(View paramView)
  {
    AppMethodBeat.i(186540);
    this.wGa.removeAllViews();
    this.wGa.addView(paramView);
    AppMethodBeat.o(186540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.RelativePopupWindow
 * JD-Core Version:    0.7.0.1
 */