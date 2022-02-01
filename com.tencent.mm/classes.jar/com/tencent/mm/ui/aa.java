package com.tencent.mm.ui;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.b.b;
import com.tencent.mm.ui.b.b.a;

public class aa
  extends y
  implements b.a
{
  public MMFragment adFi = null;
  public b adFj;
  private ActionBar mActionBar;
  
  protected final String Dy()
  {
    AppMethodBeat.i(141373);
    String str = this.adFi.getClass().getName();
    AppMethodBeat.o(141373);
    return str;
  }
  
  protected final void dealContentView(View paramView)
  {
    AppMethodBeat.i(141368);
    if (this.adFi != null) {
      this.adFi.dealContentView(paramView);
    }
    AppMethodBeat.o(141368);
  }
  
  public final boolean e(Menu paramMenu)
  {
    AppMethodBeat.i(141376);
    if (this.adFi != null) {
      this.adFi.onPrepareOptionsMenu(paramMenu);
    }
    AppMethodBeat.o(141376);
    return true;
  }
  
  public final boolean f(Menu paramMenu)
  {
    AppMethodBeat.i(141377);
    this.adFi.onCreateOptionsMenu(paramMenu, this.adFj.getMenuInflater());
    AppMethodBeat.o(141377);
    return true;
  }
  
  protected final boolean fromFullScreenActivity()
  {
    return false;
  }
  
  protected final int getCustomBounceId()
  {
    AppMethodBeat.i(249695);
    if (this.adFi != null)
    {
      int i = this.adFi.getCustomBounceId();
      AppMethodBeat.o(249695);
      return i;
    }
    AppMethodBeat.o(249695);
    return -1;
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  protected final String getIdentString()
  {
    AppMethodBeat.i(141369);
    if (this.adFi != null)
    {
      String str = this.adFi.getIdentityString();
      AppMethodBeat.o(141369);
      return str;
    }
    AppMethodBeat.o(141369);
    return null;
  }
  
  protected final int getLayoutId()
  {
    AppMethodBeat.i(141367);
    if (this.adFi != null)
    {
      int i = this.adFi.getLayoutId();
      AppMethodBeat.o(141367);
      return i;
    }
    AppMethodBeat.o(141367);
    return -1;
  }
  
  protected final View getLayoutView()
  {
    AppMethodBeat.i(141370);
    if (this.adFi != null)
    {
      View localView = this.adFi.getLayoutView();
      AppMethodBeat.o(141370);
      return localView;
    }
    AppMethodBeat.o(141370);
    return null;
  }
  
  public final ActionBar getSupportActionBar()
  {
    AppMethodBeat.i(249701);
    if (this.mActionBar == null) {
      this.mActionBar = this.adFj.jlx();
    }
    ActionBar localActionBar = this.mActionBar;
    AppMethodBeat.o(249701);
    return localActionBar;
  }
  
  public final boolean i(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(249720);
    boolean bool = super.onOptionsItemSelected(paramMenuItem);
    AppMethodBeat.o(249720);
    return bool;
  }
  
  public final boolean interceptSupportInvalidateOptionsMenu()
  {
    return true;
  }
  
  public final boolean jjN()
  {
    return true;
  }
  
  protected final void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(141372);
    if (this.adFi != null) {
      this.adFi.onCreateBeforeSetContentView();
    }
    AppMethodBeat.o(141372);
  }
  
  public final void onKeyboardStateChanged()
  {
    AppMethodBeat.i(141371);
    if (this.adFi != null) {
      this.adFi.onKeyboardStateChanged();
    }
    AppMethodBeat.o(141371);
  }
  
  public final void supportInvalidateOptionsMenu()
  {
    AppMethodBeat.i(141375);
    this.adFj.supportInvalidateOptionsMenu();
    AppMethodBeat.o(141375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.aa
 * JD-Core Version:    0.7.0.1
 */