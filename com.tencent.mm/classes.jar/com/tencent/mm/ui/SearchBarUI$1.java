package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

final class SearchBarUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SearchBarUI$1(SearchBarUI paramSearchBarUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(112457);
    Object localObject = this.zeM;
    if (!((BaseActivity)localObject).yUg.isEmpty())
    {
      ((BaseActivity)localObject).yUg.clear();
      ((BaseActivity)localObject).supportInvalidateOptionsMenu();
    }
    ((SearchBarUI)localObject).zeL = new ac((Context)localObject);
    ((SearchBarUI)localObject).zeL.setSearchViewListener((ac.a)localObject);
    ((SearchBarUI)localObject).zeL.setHint(((SearchBarUI)localObject).getResources().getString(2131304401));
    ((SearchBarUI)localObject).getSupportActionBar().setCustomView(((SearchBarUI)localObject).zeL);
    paramMenuItem = (InputMethodManager)((Activity)localObject).getSystemService("input_method");
    if (paramMenuItem != null)
    {
      localObject = ((Activity)localObject).getCurrentFocus();
      if ((localObject != null) && (((View)localObject).getWindowToken() != null)) {
        paramMenuItem.toggleSoftInput(0, 2);
      }
    }
    AppMethodBeat.o(112457);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.SearchBarUI.1
 * JD-Core Version:    0.7.0.1
 */