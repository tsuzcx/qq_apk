package com.tencent.mm.ui;

import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.b.b;
import com.tencent.mm.ui.b.b.a;

public final class u
  extends s
  implements b.a
{
  public MMFragment Jco = null;
  public b Jcp;
  private ActionBar mActionBar;
  
  public final boolean d(Menu paramMenu)
  {
    AppMethodBeat.i(141376);
    if (this.Jco != null) {
      this.Jco.onPrepareOptionsMenu(paramMenu);
    }
    AppMethodBeat.o(141376);
    return true;
  }
  
  protected final void dealContentView(View paramView)
  {
    AppMethodBeat.i(141368);
    if (this.Jco != null) {
      this.Jco.dealContentView(paramView);
    }
    AppMethodBeat.o(141368);
  }
  
  public final boolean e(Menu paramMenu)
  {
    AppMethodBeat.i(141377);
    this.Jco.onCreateOptionsMenu(paramMenu, this.Jcp.getMenuInflater());
    AppMethodBeat.o(141377);
    return true;
  }
  
  public final boolean f(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(141378);
    boolean bool = super.onOptionsItemSelected(paramMenuItem);
    AppMethodBeat.o(141378);
    return bool;
  }
  
  protected final boolean fromFullScreenActivity()
  {
    return false;
  }
  
  protected final String getClassName()
  {
    AppMethodBeat.i(141373);
    String str = this.Jco.getClass().getName();
    AppMethodBeat.o(141373);
    return str;
  }
  
  protected final String getIdentString()
  {
    AppMethodBeat.i(141369);
    if (this.Jco != null)
    {
      String str = this.Jco.getIdentityString();
      AppMethodBeat.o(141369);
      return str;
    }
    AppMethodBeat.o(141369);
    return null;
  }
  
  protected final int getLayoutId()
  {
    AppMethodBeat.i(141367);
    if (this.Jco != null)
    {
      int i = this.Jco.getLayoutId();
      AppMethodBeat.o(141367);
      return i;
    }
    AppMethodBeat.o(141367);
    return -1;
  }
  
  protected final View getLayoutView()
  {
    AppMethodBeat.i(141370);
    if (this.Jco != null)
    {
      View localView = this.Jco.getLayoutView();
      AppMethodBeat.o(141370);
      return localView;
    }
    AppMethodBeat.o(141370);
    return null;
  }
  
  public final ActionBar getSupportActionBar()
  {
    AppMethodBeat.i(141374);
    if (this.mActionBar == null) {
      this.mActionBar = this.Jcp.fyg();
    }
    ActionBar localActionBar = this.mActionBar;
    AppMethodBeat.o(141374);
    return localActionBar;
  }
  
  public final boolean interceptSupportInvalidateOptionsMenu()
  {
    return true;
  }
  
  protected final void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(141372);
    if (this.Jco != null) {
      this.Jco.onCreateBeforeSetContentView();
    }
    AppMethodBeat.o(141372);
  }
  
  public final void onKeyboardStateChanged()
  {
    AppMethodBeat.i(141371);
    if (this.Jco != null) {
      this.Jco.onKeyboardStateChanged();
    }
    AppMethodBeat.o(141371);
  }
  
  public final void supportInvalidateOptionsMenu()
  {
    AppMethodBeat.i(141375);
    this.Jcp.supportInvalidateOptionsMenu();
    AppMethodBeat.o(141375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.u
 * JD-Core Version:    0.7.0.1
 */