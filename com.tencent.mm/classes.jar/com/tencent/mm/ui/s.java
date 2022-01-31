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

public final class s
  extends q
  implements b.a
{
  private ActionBar mActionBar;
  public MMFragment zbQ = null;
  public b zbR;
  
  public final boolean c(Menu paramMenu)
  {
    AppMethodBeat.i(106037);
    if (this.zbQ != null) {
      this.zbQ.onPrepareOptionsMenu(paramMenu);
    }
    AppMethodBeat.o(106037);
    return true;
  }
  
  public final boolean d(Menu paramMenu)
  {
    AppMethodBeat.i(106038);
    this.zbQ.onCreateOptionsMenu(paramMenu, this.zbR.getMenuInflater());
    AppMethodBeat.o(106038);
    return true;
  }
  
  protected final void dealContentView(View paramView)
  {
    AppMethodBeat.i(106029);
    if (this.zbQ != null) {
      this.zbQ.dealContentView(paramView);
    }
    AppMethodBeat.o(106029);
  }
  
  public final boolean e(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(106039);
    boolean bool = super.onOptionsItemSelected(paramMenuItem);
    AppMethodBeat.o(106039);
    return bool;
  }
  
  protected final boolean fromFullScreenActivity()
  {
    return false;
  }
  
  protected final String getClassName()
  {
    AppMethodBeat.i(106034);
    String str = this.zbQ.getClass().getName();
    AppMethodBeat.o(106034);
    return str;
  }
  
  protected final String getIdentString()
  {
    AppMethodBeat.i(106030);
    if (this.zbQ != null)
    {
      String str = this.zbQ.getIdentityString();
      AppMethodBeat.o(106030);
      return str;
    }
    AppMethodBeat.o(106030);
    return null;
  }
  
  protected final int getLayoutId()
  {
    AppMethodBeat.i(106028);
    if (this.zbQ != null)
    {
      int i = this.zbQ.getLayoutId();
      AppMethodBeat.o(106028);
      return i;
    }
    AppMethodBeat.o(106028);
    return -1;
  }
  
  protected final View getLayoutView()
  {
    AppMethodBeat.i(106031);
    if (this.zbQ != null)
    {
      View localView = this.zbQ.getLayoutView();
      AppMethodBeat.o(106031);
      return localView;
    }
    AppMethodBeat.o(106031);
    return null;
  }
  
  public final ActionBar getSupportActionBar()
  {
    AppMethodBeat.i(106035);
    if (this.mActionBar == null) {
      this.mActionBar = this.zbR.dDu();
    }
    ActionBar localActionBar = this.mActionBar;
    AppMethodBeat.o(106035);
    return localActionBar;
  }
  
  public final boolean interceptSupportInvalidateOptionsMenu()
  {
    return true;
  }
  
  protected final void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(106033);
    if (this.zbQ != null) {
      this.zbQ.onCreateBeforeSetContentView();
    }
    AppMethodBeat.o(106033);
  }
  
  public final void onKeyboardStateChanged()
  {
    AppMethodBeat.i(106032);
    if (this.zbQ != null) {
      this.zbQ.onKeyboardStateChanged();
    }
    AppMethodBeat.o(106032);
  }
  
  public final ActionMode startActionMode(ActionMode.Callback paramCallback)
  {
    AppMethodBeat.i(106027);
    paramCallback = this.zbR.startActionMode(paramCallback);
    AppMethodBeat.o(106027);
    return paramCallback;
  }
  
  public final void supportInvalidateOptionsMenu()
  {
    AppMethodBeat.i(106036);
    this.zbR.supportInvalidateOptionsMenu();
    AppMethodBeat.o(106036);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.s
 * JD-Core Version:    0.7.0.1
 */