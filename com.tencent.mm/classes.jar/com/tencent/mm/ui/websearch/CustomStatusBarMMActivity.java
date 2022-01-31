package com.tencent.mm.ui.websearch;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.statusbar.a;
import com.tencent.mm.ui.statusbar.b;
import com.tencent.mm.ui.widget.SwipeBackLayout;

public abstract class CustomStatusBarMMActivity
  extends MMActivity
{
  private b iLE = null;
  
  protected int getStatusBarColor()
  {
    return getResources().getColor(2131690521);
  }
  
  public boolean initNavigationSwipeBack()
  {
    boolean bool = super.initNavigationSwipeBack();
    if (!isSupportNavigationSwipeBack()) {
      a.d(getContentView(), getStatusBarColor(), true);
    }
    return bool;
  }
  
  public void initSwipeBack()
  {
    super.initSwipeBack();
    if ((getSwipeBackLayout() != null) && (getSwipeBackLayout().getChildCount() > 0))
    {
      View localView = getSwipeBackLayout().getChildAt(0);
      getSwipeBackLayout().removeView(localView);
      this.iLE = new b(this);
      this.iLE.addView(localView, new FrameLayout.LayoutParams(-1, -1));
      getSwipeBackLayout().addView(this.iLE);
      getSwipeBackLayout().setContentView(this.iLE);
    }
    a.d(getContentView(), getStatusBarColor(), true);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.websearch.CustomStatusBarMMActivity
 * JD-Core Version:    0.7.0.1
 */