package com.tencent.mm.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class SearchBarUI
  extends BaseActivity
  implements ag.a
{
  ag JAd;
  
  public void onClickBackBtn(View paramView)
  {
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = BaseActivity.c.Jov;
    a("", new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(159098);
        paramAnonymousMenuItem = SearchBarUI.this;
        paramAnonymousMenuItem.removeAllOptionMenu();
        paramAnonymousMenuItem.JAd = new ag(paramAnonymousMenuItem);
        paramAnonymousMenuItem.JAd.setSearchViewListener(paramAnonymousMenuItem);
        paramAnonymousMenuItem.JAd.setHint(paramAnonymousMenuItem.getResources().getString(2131764545));
        paramAnonymousMenuItem.getSupportActionBar().setCustomView(paramAnonymousMenuItem.JAd);
        SearchBarUI.showVKB(paramAnonymousMenuItem);
        AppMethodBeat.o(159098);
        return false;
      }
    }, paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(159099);
        SearchBarUI.this.finish();
        AppMethodBeat.o(159099);
        return true;
      }
    });
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.SearchBarUI
 * JD-Core Version:    0.7.0.1
 */