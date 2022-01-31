package com.tencent.mm.ui.statusbar;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.SwipeBackLayout;

public class DrawStatusBarPreference
  extends MMPreference
{
  private b hct = null;
  
  public boolean a(f paramf, Preference paramPreference)
  {
    return false;
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
  
  public int xj()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.statusbar.DrawStatusBarPreference
 * JD-Core Version:    0.7.0.1
 */