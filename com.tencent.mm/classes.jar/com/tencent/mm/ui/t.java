package com.tencent.mm.ui;

import android.support.v7.app.ActionBar;
import android.support.v7.view.f.a;
import android.support.v7.view.g;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.ui.b.a;
import com.tencent.mm.ui.b.a.a;
import com.tencent.mm.ui.b.b.a;

public final class t
  extends s
  implements b.a
{
  private ActionBar mActionBar;
  public x uNW = null;
  public com.tencent.mm.ui.b.b uNX;
  
  protected final String bdI()
  {
    if (this.uNW != null) {
      return this.uNW.getIdentityString();
    }
    return null;
  }
  
  public final boolean c(Menu paramMenu)
  {
    if (this.uNW != null) {
      this.uNW.onPrepareOptionsMenu(paramMenu);
    }
    return true;
  }
  
  protected final boolean czg()
  {
    return false;
  }
  
  public final boolean d(Menu paramMenu)
  {
    x localx = this.uNW;
    com.tencent.mm.ui.b.b localb = this.uNX;
    ActionBar localActionBar;
    if (localb.fe == null)
    {
      localActionBar = localb.getSupportActionBar();
      if (localActionBar == null) {
        break label55;
      }
    }
    label55:
    for (localb.fe = new g(localActionBar.getThemedContext());; localb.fe = new g(localb.mActivity))
    {
      localx.onCreateOptionsMenu(paramMenu, localb.fe);
      return true;
    }
  }
  
  protected final void dealContentView(View paramView)
  {
    if (this.uNW != null) {
      this.uNW.dealContentView(paramView);
    }
  }
  
  protected final String getClassName()
  {
    return this.uNW.getClass().getName();
  }
  
  protected final int getLayoutId()
  {
    if (this.uNW != null) {
      return this.uNW.getLayoutId();
    }
    return -1;
  }
  
  protected final View getLayoutView()
  {
    if (this.uNW != null) {
      return this.uNW.getLayoutView();
    }
    return null;
  }
  
  public final ActionBar getSupportActionBar()
  {
    if (this.mActionBar == null) {
      this.mActionBar = this.uNX.cAk();
    }
    return this.mActionBar;
  }
  
  public final boolean h(MenuItem paramMenuItem)
  {
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public final boolean interceptSupportInvalidateOptionsMenu()
  {
    return true;
  }
  
  protected final void onCreateBeforeSetContentView()
  {
    if (this.uNW != null) {
      this.uNW.onCreateBeforeSetContentView();
    }
  }
  
  public final void onKeyboardStateChanged()
  {
    if (this.uNW != null) {
      this.uNW.onKeyboardStateChanged();
    }
  }
  
  public final ActionMode startActionMode(ActionMode.Callback paramCallback)
  {
    Object localObject = this.uNX;
    paramCallback = new f.a(((a)localObject).mActivity, paramCallback);
    if (((a)localObject).Pp != null) {
      ((a)localObject).Pp.finish();
    }
    a.a locala = new a.a((a)localObject, paramCallback);
    ActionBar localActionBar = ((a)localObject).getSupportActionBar();
    if (localActionBar != null) {
      ((a)localObject).Pp = localActionBar.a(locala);
    }
    localObject = ((a)localObject).Pp;
    if (localObject != null) {
      return paramCallback.b((android.support.v7.view.b)localObject);
    }
    return null;
  }
  
  public final void supportInvalidateOptionsMenu()
  {
    this.uNX.supportInvalidateOptionsMenu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.t
 * JD-Core Version:    0.7.0.1
 */