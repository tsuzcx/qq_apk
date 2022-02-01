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

public final class z
  extends w
  implements b.a
{
  public MMFragment WaN = null;
  public b WaO;
  private ActionBar mActionBar;
  
  public final ActionMode b(ActionMode.Callback paramCallback)
  {
    AppMethodBeat.i(141379);
    paramCallback = this.WaO.b(paramCallback);
    AppMethodBeat.o(141379);
    return paramCallback;
  }
  
  protected final String bpE()
  {
    AppMethodBeat.i(141386);
    String str = this.WaN.getClass().getName();
    AppMethodBeat.o(141386);
    return str;
  }
  
  protected final void dealContentView(View paramView)
  {
    AppMethodBeat.i(141381);
    if (this.WaN != null) {
      this.WaN.dealContentView(paramView);
    }
    AppMethodBeat.o(141381);
  }
  
  public final boolean e(Menu paramMenu)
  {
    AppMethodBeat.i(141389);
    if (this.WaN != null) {
      this.WaN.onPrepareOptionsMenu(paramMenu);
    }
    AppMethodBeat.o(141389);
    return true;
  }
  
  public final boolean f(Menu paramMenu)
  {
    AppMethodBeat.i(141390);
    this.WaN.onCreateOptionsMenu(paramMenu, this.WaO.getMenuInflater());
    AppMethodBeat.o(141390);
    return true;
  }
  
  protected final boolean fromFullScreenActivity()
  {
    return false;
  }
  
  public final boolean g(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(205443);
    boolean bool = super.onOptionsItemSelected(paramMenuItem);
    AppMethodBeat.o(205443);
    return bool;
  }
  
  protected final int getCustomBounceId()
  {
    AppMethodBeat.i(205439);
    if (this.WaN != null)
    {
      int i = this.WaN.getCustomBounceId();
      AppMethodBeat.o(205439);
      return i;
    }
    AppMethodBeat.o(205439);
    return -1;
  }
  
  protected final String getIdentString()
  {
    AppMethodBeat.i(141382);
    if (this.WaN != null)
    {
      String str = this.WaN.getIdentityString();
      AppMethodBeat.o(141382);
      return str;
    }
    AppMethodBeat.o(141382);
    return null;
  }
  
  protected final int getLayoutId()
  {
    AppMethodBeat.i(141380);
    if (this.WaN != null)
    {
      int i = this.WaN.getLayoutId();
      AppMethodBeat.o(141380);
      return i;
    }
    AppMethodBeat.o(141380);
    return -1;
  }
  
  protected final View getLayoutView()
  {
    AppMethodBeat.i(141383);
    if (this.WaN != null)
    {
      View localView = this.WaN.getLayoutView();
      AppMethodBeat.o(141383);
      return localView;
    }
    AppMethodBeat.o(141383);
    return null;
  }
  
  public final ActionBar getSupportActionBar()
  {
    AppMethodBeat.i(205441);
    if (this.mActionBar == null) {
      this.mActionBar = d.c(this.WaO.hJi());
    }
    ActionBar localActionBar = this.mActionBar;
    AppMethodBeat.o(205441);
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
  
  protected final boolean isActionbarMenuUseOriginalSys()
  {
    AppMethodBeat.i(205440);
    if (this.WaN != null)
    {
      bool = this.WaN.isActionbarMenuUseOriginalSys();
      AppMethodBeat.o(205440);
      return bool;
    }
    boolean bool = super.isActionbarMenuUseOriginalSys();
    AppMethodBeat.o(205440);
    return bool;
  }
  
  protected final void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(141385);
    if (this.WaN != null) {
      this.WaN.onCreateBeforeSetContentView();
    }
    AppMethodBeat.o(141385);
  }
  
  public final void onKeyboardStateChanged()
  {
    AppMethodBeat.i(141384);
    if (this.WaN != null) {
      this.WaN.onKeyboardStateChanged();
    }
    AppMethodBeat.o(141384);
  }
  
  public final void supportInvalidateOptionsMenu()
  {
    AppMethodBeat.i(141388);
    this.WaO.supportInvalidateOptionsMenu();
    AppMethodBeat.o(141388);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.z
 * JD-Core Version:    0.7.0.1
 */