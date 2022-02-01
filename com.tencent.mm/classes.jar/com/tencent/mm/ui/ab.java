package com.tencent.mm.ui;

import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.b.b;
import com.tencent.mm.ui.b.b.a;
import com.tencent.mm.ui.widget.d;

public final class ab
  extends y
  implements b.a
{
  public MMFragment adFi = null;
  public b adFj;
  private ActionBar mActionBar;
  
  protected final String Dy()
  {
    AppMethodBeat.i(141386);
    String str = this.adFi.getClass().getName();
    AppMethodBeat.o(141386);
    return str;
  }
  
  public final ActionMode b(ActionMode.Callback paramCallback)
  {
    AppMethodBeat.i(141379);
    paramCallback = this.adFj.b(paramCallback);
    AppMethodBeat.o(141379);
    return paramCallback;
  }
  
  protected final void dealContentView(View paramView)
  {
    AppMethodBeat.i(141381);
    if (this.adFi != null) {
      this.adFi.dealContentView(paramView);
    }
    AppMethodBeat.o(141381);
  }
  
  public final boolean e(Menu paramMenu)
  {
    AppMethodBeat.i(141389);
    if (this.adFi != null) {
      this.adFi.onPrepareOptionsMenu(paramMenu);
    }
    AppMethodBeat.o(141389);
    return true;
  }
  
  public final boolean f(Menu paramMenu)
  {
    AppMethodBeat.i(141390);
    this.adFi.onCreateOptionsMenu(paramMenu, this.adFj.getMenuInflater());
    AppMethodBeat.o(141390);
    return true;
  }
  
  protected final boolean fromFullScreenActivity()
  {
    return false;
  }
  
  protected final int getCustomBounceId()
  {
    AppMethodBeat.i(249697);
    if (this.adFi != null)
    {
      int i = this.adFi.getCustomBounceId();
      AppMethodBeat.o(249697);
      return i;
    }
    AppMethodBeat.o(249697);
    return -1;
  }
  
  protected final String getIdentString()
  {
    AppMethodBeat.i(141382);
    if (this.adFi != null)
    {
      String str = this.adFi.getIdentityString();
      AppMethodBeat.o(141382);
      return str;
    }
    AppMethodBeat.o(141382);
    return null;
  }
  
  protected final int getLayoutId()
  {
    AppMethodBeat.i(141380);
    if (this.adFi != null)
    {
      int i = this.adFi.getLayoutId();
      AppMethodBeat.o(141380);
      return i;
    }
    AppMethodBeat.o(141380);
    return -1;
  }
  
  protected final View getLayoutView()
  {
    AppMethodBeat.i(141383);
    if (this.adFi != null)
    {
      View localView = this.adFi.getLayoutView();
      AppMethodBeat.o(141383);
      return localView;
    }
    AppMethodBeat.o(141383);
    return null;
  }
  
  public final ActionBar getSupportActionBar()
  {
    AppMethodBeat.i(249711);
    if (this.mActionBar == null) {
      this.mActionBar = d.c(this.adFj.jlx());
    }
    ActionBar localActionBar = this.mActionBar;
    AppMethodBeat.o(249711);
    return localActionBar;
  }
  
  public final boolean i(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(249728);
    boolean bool = super.onOptionsItemSelected(paramMenuItem);
    AppMethodBeat.o(249728);
    return bool;
  }
  
  public final boolean interceptSupportInvalidateOptionsMenu()
  {
    return true;
  }
  
  protected final boolean isActionbarMenuUseOriginalSys()
  {
    AppMethodBeat.i(249706);
    if (this.adFi != null)
    {
      bool = this.adFi.isActionbarMenuUseOriginalSys();
      AppMethodBeat.o(249706);
      return bool;
    }
    boolean bool = super.isActionbarMenuUseOriginalSys();
    AppMethodBeat.o(249706);
    return bool;
  }
  
  public final boolean jjN()
  {
    return true;
  }
  
  protected final void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(141385);
    if (this.adFi != null) {
      this.adFi.onCreateBeforeSetContentView();
    }
    AppMethodBeat.o(141385);
  }
  
  public final void onKeyboardStateChanged()
  {
    AppMethodBeat.i(141384);
    if (this.adFi != null) {
      this.adFi.onKeyboardStateChanged();
    }
    AppMethodBeat.o(141384);
  }
  
  public final void supportInvalidateOptionsMenu()
  {
    AppMethodBeat.i(141388);
    this.adFj.supportInvalidateOptionsMenu();
    AppMethodBeat.o(141388);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.ab
 * JD-Core Version:    0.7.0.1
 */