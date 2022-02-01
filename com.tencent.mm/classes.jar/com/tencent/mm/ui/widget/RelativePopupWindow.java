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
  private FrameLayout GKQ;
  private boolean Ydq;
  
  public RelativePopupWindow(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public RelativePopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(196578);
    this.Ydq = false;
    this.GKQ = new FrameLayout(paramContext);
    super.setContentView(this.GKQ);
    AppMethodBeat.o(196578);
  }
  
  public View getContentView()
  {
    AppMethodBeat.i(196581);
    View localView = this.GKQ.getChildAt(0);
    AppMethodBeat.o(196581);
    return localView;
  }
  
  public void setContentView(View paramView)
  {
    AppMethodBeat.i(196580);
    this.GKQ.removeAllViews();
    this.GKQ.addView(paramView);
    AppMethodBeat.o(196580);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.RelativePopupWindow
 * JD-Core Version:    0.7.0.1
 */