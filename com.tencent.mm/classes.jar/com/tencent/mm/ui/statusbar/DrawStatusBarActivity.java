package com.tencent.mm.ui.statusbar;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.SwipeBackLayout;

public abstract class DrawStatusBarActivity
  extends MMActivity
{
  private b KZi = null;
  
  public void initSwipeBack()
  {
    super.initSwipeBack();
    if ((getSwipeBackLayout() != null) && (getSwipeBackLayout().getChildCount() > 0))
    {
      View localView = getSwipeBackLayout().getChildAt(0);
      getSwipeBackLayout().removeView(localView);
      this.KZi = new b(this);
      this.KZi.addView(localView, new FrameLayout.LayoutParams(-1, -1));
      getSwipeBackLayout().addView(this.KZi);
      getSwipeBackLayout().setContentView(this.KZi);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.statusbar.DrawStatusBarActivity
 * JD-Core Version:    0.7.0.1
 */