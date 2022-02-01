package com.tencent.mm.ui.contact.address;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bf;

public abstract class BaseAddressUIFragment
  extends AbstractTabChildActivity.AbStractTabFragment
{
  private int getTopHeight()
  {
    int j = bf.fs(getContext());
    int i = bf.I(getContext(), -1);
    View localView = getView().getRootView().findViewById(R.h.action_bar_container);
    if (aw.jkY())
    {
      if (localView != null) {
        return localView.getTop() + j;
      }
      return i + j;
    }
    if ((Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null)) {}
    for (boolean bool1 = LauncherUI.getInstance().isInMultiWindowMode();; bool1 = false)
    {
      SharedPreferences localSharedPreferences;
      if (!bool1)
      {
        localSharedPreferences = MMApplicationContext.getDefaultPreference();
        if (localSharedPreferences == null) {
          break label181;
        }
      }
      label176:
      label181:
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
            break label176;
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
  
  public abstract void Mw(boolean paramBoolean);
  
  public abstract String getLogTag();
  
  public void hFp() {}
  
  public void hFq() {}
  
  public void jhn() {}
  
  public void jho() {}
  
  public void jhp() {}
  
  public void jhq() {}
  
  public void jhr() {}
  
  public void jhs() {}
  
  public void jht() {}
  
  public void jhu() {}
  
  public void jhv() {}
  
  protected final void jil()
  {
    final View localView = getView().getRootView().findViewById(R.h.fMt);
    int i = bf.fs(getContext());
    int j = bf.I(getContext(), -1);
    Runnable local1 = new Runnable()
    {
      int nrQ = 0;
      
      public final void run()
      {
        AppMethodBeat.i(253254);
        if (BaseAddressUIFragment.this.getView() == null)
        {
          AppMethodBeat.o(253254);
          return;
        }
        int i = bf.fs(BaseAddressUIFragment.this.getContext());
        int j = bf.I(BaseAddressUIFragment.this.getContext(), -1);
        if (j <= 0) {
          if (this.nrQ < 2)
          {
            Log.i(BaseAddressUIFragment.this.getLogTag(), "[trySetParentViewPadding] try getStatusHeight again!");
            BaseAddressUIFragment.this.getView().post(this);
            this.nrQ += 1;
          }
        }
        for (;;)
        {
          Log.i(BaseAddressUIFragment.this.getLogTag(), "[trySetParentViewPadding] tryCount:%s actionBarHeight:%s actionBarHeight:%s", new Object[] { Integer.valueOf(this.nrQ), Integer.valueOf(j), Integer.valueOf(i) });
          AppMethodBeat.o(253254);
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
  
  public abstract void jyb();
  
  public boolean noActionBar()
  {
    return true;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    jil();
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