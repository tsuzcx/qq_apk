package com.tencent.mm.ui.contact.address;

import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.ax;

public abstract class BaseAddressUIFragment
  extends AbstractTabChildActivity.AbStractTabFragment
{
  private int getTopHeight()
  {
    int j = ax.ew(getContext());
    int i = ax.F(getContext(), -1);
    View localView = getView().getRootView().findViewById(R.h.action_bar_container);
    if ((Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null)) {}
    for (boolean bool1 = LauncherUI.getInstance().isInMultiWindowMode();; bool1 = false)
    {
      SharedPreferences localSharedPreferences;
      if (!bool1)
      {
        localSharedPreferences = MMApplicationContext.getDefaultPreference();
        if (localSharedPreferences == null) {
          break label158;
        }
      }
      label153:
      label158:
      for (boolean bool2 = localSharedPreferences.getBoolean("Main_need_read_top_margin", false);; bool2 = false)
      {
        if (bool2)
        {
          int k = localSharedPreferences.getInt("Main_top_marign", -1);
          if (k >= 0) {
            return j + k;
          }
        }
        if (bool1) {
          if (localView == null) {
            break label153;
          }
        }
        for (i = localView.getTop();; i = 0)
        {
          Log.i(getLogTag(), "getTopHeight statusHeight:%s, isInMultiWindowMode:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1) });
          return i + j;
        }
      }
    }
  }
  
  public abstract void GH(boolean paramBoolean);
  
  public abstract String getLogTag();
  
  public void gkE() {}
  
  public void gkF() {}
  
  public void hFb() {}
  
  public void hFc() {}
  
  public void hFd() {}
  
  public void hFe() {}
  
  public void hFf() {}
  
  public void hFg() {}
  
  public void hFh() {}
  
  public void hFi() {}
  
  public void hFj() {}
  
  protected final void hGa()
  {
    final View localView = getView().getRootView().findViewById(R.h.dKR);
    int i = ax.ew(getContext());
    int j = ax.F(getContext(), -1);
    Runnable local1 = new Runnable()
    {
      int kQn = 0;
      
      public final void run()
      {
        AppMethodBeat.i(276153);
        if (BaseAddressUIFragment.this.getView() == null)
        {
          AppMethodBeat.o(276153);
          return;
        }
        int i = ax.ew(BaseAddressUIFragment.this.getContext());
        int j = ax.F(BaseAddressUIFragment.this.getContext(), -1);
        if (j <= 0) {
          if (this.kQn < 2)
          {
            Log.i(BaseAddressUIFragment.this.getLogTag(), "[trySetParentViewPadding] try getStatusHeight again!");
            BaseAddressUIFragment.this.getView().post(this);
            this.kQn += 1;
          }
        }
        for (;;)
        {
          Log.i(BaseAddressUIFragment.this.getLogTag(), "[trySetParentViewPadding] tryCount:%s actionBarHeight:%s actionBarHeight:%s", new Object[] { Integer.valueOf(this.kQn), Integer.valueOf(j), Integer.valueOf(i) });
          AppMethodBeat.o(276153);
          return;
          Log.e(BaseAddressUIFragment.this.getLogTag(), "[trySetParentViewPadding] try getStatusHeight finally!");
          break;
          int k = BaseAddressUIFragment.a(BaseAddressUIFragment.this);
          if (k != BaseAddressUIFragment.this.getView().getPaddingTop())
          {
            Log.i(BaseAddressUIFragment.this.getLogTag(), "[trySetParentViewPadding] now:%s old:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(BaseAddressUIFragment.this.getView().getPaddingTop()) });
            BaseAddressUIFragment.this.getView().setPadding(0, k, 0, localView.getHeight());
          }
          else
          {
            Log.i(BaseAddressUIFragment.this.getLogTag(), "[trySetParentViewPadding] has try more once! it's right! actionBarHeight:%s actionBarHeight:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          }
        }
      }
    };
    if (j <= 0)
    {
      getView().post(local1);
      return;
    }
    int k = getTopHeight();
    getView().setPadding(0, k, 0, localView.getHeight());
    Log.i(getLogTag(), "[trySetParentViewPadding] actionBarHeight:%s actionBarHeight:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
    getView().postDelayed(local1, 100L);
  }
  
  public abstract void hUl();
  
  public boolean noActionBar()
  {
    return true;
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.address.BaseAddressUIFragment
 * JD-Core Version:    0.7.0.1
 */