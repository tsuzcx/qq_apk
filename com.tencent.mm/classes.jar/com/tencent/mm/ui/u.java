package com.tencent.mm.ui;

import android.support.v7.app.ActionBar;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.b.b;
import com.tencent.mm.ui.b.b.a;

public final class u
  extends r
  implements b.a
{
  public MMFragment FOX = null;
  public b FOY;
  private ActionBar mActionBar;
  
  public final boolean d(Menu paramMenu)
  {
    AppMethodBeat.i(141389);
    if (this.FOX != null) {
      this.FOX.onPrepareOptionsMenu(paramMenu);
    }
    AppMethodBeat.o(141389);
    return true;
  }
  
  protected final void dealContentView(View paramView)
  {
    AppMethodBeat.i(141381);
    if (this.FOX != null) {
      this.FOX.dealContentView(paramView);
    }
    AppMethodBeat.o(141381);
  }
  
  public final boolean e(Menu paramMenu)
  {
    AppMethodBeat.i(141390);
    this.FOX.onCreateOptionsMenu(paramMenu, this.FOY.getMenuInflater());
    AppMethodBeat.o(141390);
    return true;
  }
  
  public final boolean f(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(141391);
    boolean bool = super.onOptionsItemSelected(paramMenuItem);
    AppMethodBeat.o(141391);
    return bool;
  }
  
  protected final boolean fromFullScreenActivity()
  {
    return false;
  }
  
  protected final String getClassName()
  {
    AppMethodBeat.i(141386);
    String str = this.FOX.getClass().getName();
    AppMethodBeat.o(141386);
    return str;
  }
  
  protected final String getIdentString()
  {
    AppMethodBeat.i(141382);
    if (this.FOX != null)
    {
      String str = this.FOX.getIdentityString();
      AppMethodBeat.o(141382);
      return str;
    }
    AppMethodBeat.o(141382);
    return null;
  }
  
  protected final int getLayoutId()
  {
    AppMethodBeat.i(141380);
    if (this.FOX != null)
    {
      int i = this.FOX.getLayoutId();
      AppMethodBeat.o(141380);
      return i;
    }
    AppMethodBeat.o(141380);
    return -1;
  }
  
  protected final View getLayoutView()
  {
    AppMethodBeat.i(141383);
    if (this.FOX != null)
    {
      View localView = this.FOX.getLayoutView();
      AppMethodBeat.o(141383);
      return localView;
    }
    AppMethodBeat.o(141383);
    return null;
  }
  
  public final ActionBar getSupportActionBar()
  {
    AppMethodBeat.i(141387);
    if (this.mActionBar == null) {
      this.mActionBar = this.FOY.eSg();
    }
    ActionBar localActionBar = this.mActionBar;
    AppMethodBeat.o(141387);
    return localActionBar;
  }
  
  public final boolean interceptSupportInvalidateOptionsMenu()
  {
    return true;
  }
  
  protected final void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(141385);
    if (this.FOX != null) {
      this.FOX.onCreateBeforeSetContentView();
    }
    AppMethodBeat.o(141385);
  }
  
  public final void onKeyboardStateChanged()
  {
    AppMethodBeat.i(141384);
    if (this.FOX != null) {
      this.FOX.onKeyboardStateChanged();
    }
    AppMethodBeat.o(141384);
  }
  
  public final ActionMode startActionMode(ActionMode.Callback paramCallback)
  {
    AppMethodBeat.i(141379);
    paramCallback = this.FOY.startActionMode(paramCallback);
    AppMethodBeat.o(141379);
    return paramCallback;
  }
  
  public final void supportInvalidateOptionsMenu()
  {
    AppMethodBeat.i(141388);
    this.FOY.supportInvalidateOptionsMenu();
    AppMethodBeat.o(141388);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.u
 * JD-Core Version:    0.7.0.1
 */