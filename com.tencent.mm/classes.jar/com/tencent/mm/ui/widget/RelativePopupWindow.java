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
  private FrameLayout MHK;
  private boolean afVg;
  
  public RelativePopupWindow(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public RelativePopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(251723);
    this.afVg = false;
    this.MHK = new FrameLayout(paramContext);
    super.setContentView(this.MHK);
    AppMethodBeat.o(251723);
  }
  
  public View getContentView()
  {
    AppMethodBeat.i(251727);
    View localView = this.MHK.getChildAt(0);
    AppMethodBeat.o(251727);
    return localView;
  }
  
  public void setContentView(View paramView)
  {
    AppMethodBeat.i(251725);
    this.MHK.removeAllViews();
    this.MHK.addView(paramView);
    AppMethodBeat.o(251725);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.RelativePopupWindow
 * JD-Core Version:    0.7.0.1
 */