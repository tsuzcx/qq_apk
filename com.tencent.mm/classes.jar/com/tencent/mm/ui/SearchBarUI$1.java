package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mm.ci.a.i;
import java.util.LinkedList;

final class SearchBarUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SearchBarUI$1(SearchBarUI paramSearchBarUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    Object localObject = this.uQA;
    if (!((BaseActivity)localObject).uGV.isEmpty())
    {
      ((BaseActivity)localObject).uGV.clear();
      ((BaseActivity)localObject).supportInvalidateOptionsMenu();
    }
    ((SearchBarUI)localObject).uQz = new ah((Context)localObject);
    ((SearchBarUI)localObject).uQz.setSearchViewListener((ah.a)localObject);
    ((SearchBarUI)localObject).uQz.setHint(((SearchBarUI)localObject).getResources().getString(a.i.ui_search));
    ((SearchBarUI)localObject).getSupportActionBar().setCustomView(((SearchBarUI)localObject).uQz);
    if (localObject != null)
    {
      paramMenuItem = (InputMethodManager)((Activity)localObject).getSystemService("input_method");
      if (paramMenuItem != null)
      {
        localObject = ((Activity)localObject).getCurrentFocus();
        if ((localObject != null) && (((View)localObject).getWindowToken() != null)) {
          paramMenuItem.toggleSoftInput(0, 2);
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.SearchBarUI.1
 * JD-Core Version:    0.7.0.1
 */