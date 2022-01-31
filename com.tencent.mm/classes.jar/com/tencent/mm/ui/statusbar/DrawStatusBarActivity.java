package com.tencent.mm.ui.statusbar;

import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.SwipeBackLayout;

public abstract class DrawStatusBarActivity
  extends MMActivity
{
  private b hct = null;
  
  public int getStatusBarColor()
  {
    return this.mController.czv();
  }
  
  protected void initSwipeBack()
  {
    super.initSwipeBack();
    if ((getSwipeBackLayout() != null) && (getSwipeBackLayout().getChildCount() > 0))
    {
      View localView = getSwipeBackLayout().getChildAt(0);
      getSwipeBackLayout().removeView(localView);
      this.hct = new b(this);
      this.hct.addView(localView, new FrameLayout.LayoutParams(-1, -1));
      getSwipeBackLayout().addView(this.hct);
      getSwipeBackLayout().setContentView(this.hct);
    }
  }
  
  public final void ta(int paramInt)
  {
    super.ta(paramInt);
    if ((Build.VERSION.SDK_INT >= 21) && (getWindow() != null)) {
      a.d(this.mController.contentView, getWindow().getStatusBarColor(), d.c(getWindow()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.statusbar.DrawStatusBarActivity
 * JD-Core Version:    0.7.0.1
 */