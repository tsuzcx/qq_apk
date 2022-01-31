package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.R.e;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.statusbar.a;
import com.tencent.mm.ui.statusbar.b;
import com.tencent.mm.ui.widget.SwipeBackLayout;

public abstract class CustomStatusBarMMActivity
  extends MMActivity
{
  private b hct = null;
  
  protected int getStatusBarColor()
  {
    return getResources().getColor(R.e.status_bar_color);
  }
  
  public boolean initNavigationSwipeBack()
  {
    boolean bool = super.initNavigationSwipeBack();
    if (!isSupportNavigationSwipeBack()) {
      a.d(this.mController.contentView, getStatusBarColor(), true);
    }
    return bool;
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
    a.d(this.mController.contentView, getStatusBarColor(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.CustomStatusBarMMActivity
 * JD-Core Version:    0.7.0.1
 */