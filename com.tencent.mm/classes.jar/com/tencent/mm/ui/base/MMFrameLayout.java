package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMFrameLayout
  extends FrameLayout
{
  private boolean FXa = false;
  
  public MMFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141956);
    int j = getChildCount();
    int i = 0;
    while ((!this.FXa) && (i < j))
    {
      View localView = getChildAt(i);
      if (localView != null)
      {
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.gravity == -1)
        {
          localLayoutParams.gravity = 51;
          localView.setLayoutParams(localLayoutParams);
        }
      }
      i += 1;
    }
    this.FXa = true;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(141956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFrameLayout
 * JD-Core Version:    0.7.0.1
 */