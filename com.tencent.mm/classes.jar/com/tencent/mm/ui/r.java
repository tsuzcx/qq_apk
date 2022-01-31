package com.tencent.mm.ui;

import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.b.b;
import com.tencent.mm.ui.b.b.a;

public final class r
  extends q
  implements b.a
{
  private ActionBar mActionBar;
  public MMFragment zbQ = null;
  public b zbR;
  
  public final boolean c(Menu paramMenu)
  {
    AppMethodBeat.i(142742);
    if (this.zbQ != null) {
      this.zbQ.onPrepareOptionsMenu(paramMenu);
    }
    AppMethodBeat.o(142742);
    return true;
  }
  
  public final boolean d(Menu paramMenu)
  {
    AppMethodBeat.i(142743);
    this.zbQ.onCreateOptionsMenu(paramMenu, this.zbR.getMenuInflater());
    AppMethodBeat.o(142743);
    return true;
  }
  
  protected final void dealContentView(View paramView)
  {
    AppMethodBeat.i(142734);
    if (this.zbQ != null) {
      this.zbQ.dealContentView(paramView);
    }
    AppMethodBeat.o(142734);
  }
  
  public final boolean e(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(142744);
    boolean bool = super.onOptionsItemSelected(paramMenuItem);
    AppMethodBeat.o(142744);
    return bool;
  }
  
  protected final boolean fromFullScreenActivity()
  {
    return false;
  }
  
  protected final String getClassName()
  {
    AppMethodBeat.i(142739);
    String str = this.zbQ.getClass().getName();
    AppMethodBeat.o(142739);
    return str;
  }
  
  protected final String getIdentString()
  {
    AppMethodBeat.i(142735);
    if (this.zbQ != null)
    {
      String str = this.zbQ.getIdentityString();
      AppMethodBeat.o(142735);
      return str;
    }
    AppMethodBeat.o(142735);
    return null;
  }
  
  protected final int getLayoutId()
  {
    AppMethodBeat.i(142733);
    if (this.zbQ != null)
    {
      int i = this.zbQ.getLayoutId();
      AppMethodBeat.o(142733);
      return i;
    }
    AppMethodBeat.o(142733);
    return -1;
  }
  
  protected final View getLayoutView()
  {
    AppMethodBeat.i(142736);
    if (this.zbQ != null)
    {
      View localView = this.zbQ.getLayoutView();
      AppMethodBeat.o(142736);
      return localView;
    }
    AppMethodBeat.o(142736);
    return null;
  }
  
  public final ActionBar getSupportActionBar()
  {
    AppMethodBeat.i(142740);
    if (this.mActionBar == null) {
      this.mActionBar = this.zbR.dDu();
    }
    ActionBar localActionBar = this.mActionBar;
    AppMethodBeat.o(142740);
    return localActionBar;
  }
  
  public final boolean interceptSupportInvalidateOptionsMenu()
  {
    return true;
  }
  
  protected final void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(142738);
    if (this.zbQ != null) {
      this.zbQ.onCreateBeforeSetContentView();
    }
    AppMethodBeat.o(142738);
  }
  
  public final void onKeyboardStateChanged()
  {
    AppMethodBeat.i(142737);
    if (this.zbQ != null) {
      this.zbQ.onKeyboardStateChanged();
    }
    AppMethodBeat.o(142737);
  }
  
  public final void supportInvalidateOptionsMenu()
  {
    AppMethodBeat.i(142741);
    this.zbR.supportInvalidateOptionsMenu();
    AppMethodBeat.o(142741);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.r
 * JD-Core Version:    0.7.0.1
 */