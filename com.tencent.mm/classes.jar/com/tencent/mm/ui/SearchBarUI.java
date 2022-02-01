package com.tencent.mm.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.i;

public abstract class SearchBarUI
  extends BaseActivity
  implements ap.a
{
  ap adJF;
  
  public void onClickBackBtn(View paramView)
  {
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a(BaseActivity.c.advA, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(159098);
        paramAnonymousMenuItem = SearchBarUI.this;
        paramAnonymousMenuItem.removeAllOptionMenu();
        paramAnonymousMenuItem.adJF = new ap(paramAnonymousMenuItem);
        paramAnonymousMenuItem.adJF.setSearchViewListener(paramAnonymousMenuItem);
        paramAnonymousMenuItem.adJF.setHint(paramAnonymousMenuItem.getResources().getString(a.i.ui_search));
        paramAnonymousMenuItem.getSupportActionBar().setCustomView(paramAnonymousMenuItem.adJF);
        SearchBarUI.showVKB(paramAnonymousMenuItem);
        AppMethodBeat.o(159098);
        return false;
      }
    });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.SearchBarUI
 * JD-Core Version:    0.7.0.1
 */