package com.tencent.mm.ui.statusbar;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.SwipeBackLayout;

public class DrawStatusBarPreference
  extends MMPreference
{
  private b Hlm = null;
  
  public int getResourceId()
  {
    return 0;
  }
  
  public void initSwipeBack()
  {
    AppMethodBeat.i(142985);
    super.initSwipeBack();
    if ((getSwipeBackLayout() != null) && (getSwipeBackLayout().getChildCount() > 0))
    {
      View localView = getSwipeBackLayout().getChildAt(0);
      getSwipeBackLayout().removeView(localView);
      this.Hlm = new b(this);
      this.Hlm.addView(localView, new FrameLayout.LayoutParams(-1, -1));
      getSwipeBackLayout().addView(this.Hlm);
      getSwipeBackLayout().setContentView(this.Hlm);
    }
    AppMethodBeat.o(142985);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.statusbar.DrawStatusBarPreference
 * JD-Core Version:    0.7.0.1
 */