package com.tencent.mm.ui;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.b.b;
import com.tencent.mm.ui.b.b.a;

public class y
  extends w
  implements b.a
{
  public MMFragment WaN = null;
  public b WaO;
  private ActionBar mActionBar;
  
  protected final String bpE()
  {
    AppMethodBeat.i(141373);
    String str = this.WaN.getClass().getName();
    AppMethodBeat.o(141373);
    return str;
  }
  
  protected final void dealContentView(View paramView)
  {
    AppMethodBeat.i(141368);
    if (this.WaN != null) {
      this.WaN.dealContentView(paramView);
    }
    AppMethodBeat.o(141368);
  }
  
  public final boolean e(Menu paramMenu)
  {
    AppMethodBeat.i(141376);
    if (this.WaN != null) {
      this.WaN.onPrepareOptionsMenu(paramMenu);
    }
    AppMethodBeat.o(141376);
    return true;
  }
  
  public final boolean f(Menu paramMenu)
  {
    AppMethodBeat.i(141377);
    this.WaN.onCreateOptionsMenu(paramMenu, this.WaO.getMenuInflater());
    AppMethodBeat.o(141377);
    return true;
  }
  
  protected final boolean fromFullScreenActivity()
  {
    return false;
  }
  
  public final boolean g(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(194070);
    boolean bool = super.onOptionsItemSelected(paramMenuItem);
    AppMethodBeat.o(194070);
    return bool;
  }
  
  protected final int getCustomBounceId()
  {
    AppMethodBeat.i(293127);
    if (this.WaN != null)
    {
      int i = this.WaN.getCustomBounceId();
      AppMethodBeat.o(293127);
      return i;
    }
    AppMethodBeat.o(293127);
    return -1;
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  protected final String getIdentString()
  {
    AppMethodBeat.i(141369);
    if (this.WaN != null)
    {
      String str = this.WaN.getIdentityString();
      AppMethodBeat.o(141369);
      return str;
    }
    AppMethodBeat.o(141369);
    return null;
  }
  
  protected final int getLayoutId()
  {
    AppMethodBeat.i(141367);
    if (this.WaN != null)
    {
      int i = this.WaN.getLayoutId();
      AppMethodBeat.o(141367);
      return i;
    }
    AppMethodBeat.o(141367);
    return -1;
  }
  
  protected final View getLayoutView()
  {
    AppMethodBeat.i(141370);
    if (this.WaN != null)
    {
      View localView = this.WaN.getLayoutView();
      AppMethodBeat.o(141370);
      return localView;
    }
    AppMethodBeat.o(141370);
    return null;
  }
  
  public final ActionBar getSupportActionBar()
  {
    AppMethodBeat.i(194061);
    if (this.mActionBar == null) {
      this.mActionBar = this.WaO.hJi();
    }
    ActionBar localActionBar = this.mActionBar;
    AppMethodBeat.o(194061);
    return localActionBar;
  }
  
  public final boolean hHD()
  {
    return true;
  }
  
  public final boolean interceptSupportInvalidateOptionsMenu()
  {
    return true;
  }
  
  protected final void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(141372);
    if (this.WaN != null) {
      this.WaN.onCreateBeforeSetContentView();
    }
    AppMethodBeat.o(141372);
  }
  
  public final void onKeyboardStateChanged()
  {
    AppMethodBeat.i(141371);
    if (this.WaN != null) {
      this.WaN.onKeyboardStateChanged();
    }
    AppMethodBeat.o(141371);
  }
  
  public final void supportInvalidateOptionsMenu()
  {
    AppMethodBeat.i(141375);
    this.WaO.supportInvalidateOptionsMenu();
    AppMethodBeat.o(141375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.y
 * JD-Core Version:    0.7.0.1
 */