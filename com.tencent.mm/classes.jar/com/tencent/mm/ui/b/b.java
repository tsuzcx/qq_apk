package com.tencent.mm.ui.b;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.h.a;
import android.support.v7.view.menu.o.a;
import android.support.v7.widget.w;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

public final class b
  extends a
  implements h.a, o.a
{
  public ViewGroup MY;
  private boolean Pu;
  private h dm;
  a uRA;
  boolean uRB;
  private final Runnable uRC = new Runnable()
  {
    public final void run()
    {
      b localb = b.this;
      Object localObject = localb.mActivity;
      ActionBar localActionBar = localb.getSupportActionBar();
      if (localActionBar != null) {
        localObject = localActionBar.getThemedContext();
      }
      localObject = new h((Context)localObject);
      ((h)localObject).a(localb);
      if (b.this.uRA != null)
      {
        b.this.uRA.d((Menu)localObject);
        b.this.uRA.c((Menu)localObject);
        b.a(b.this, (h)localObject);
      }
      for (;;)
      {
        ((h)localObject).q(true);
        b.this.uRB = false;
        return;
        b.a(b.this, null);
      }
    }
  };
  
  public b(Activity paramActivity, a parama)
  {
    super(paramActivity);
    this.uRA = parama;
  }
  
  public final void a(h paramh, boolean paramBoolean) {}
  
  public final boolean a(h paramh, MenuItem paramMenuItem)
  {
    if (this.uRA != null) {
      return this.uRA.h(paramMenuItem);
    }
    return false;
  }
  
  public final void b(h paramh)
  {
    if (this.mActionBar != null)
    {
      w localw = ((d)this.mActionBar).Qq;
      if ((localw != null) && (localw.fE()))
      {
        if (!localw.isOverflowMenuShowing())
        {
          if (localw.getVisibility() == 0) {
            localw.showOverflowMenu();
          }
          return;
        }
        localw.hideOverflowMenu();
        return;
      }
    }
    paramh.close();
  }
  
  public final ActionBar cAk()
  {
    if (!this.Pu)
    {
      this.Pu = true;
      supportInvalidateOptionsMenu();
    }
    if (this.mActionBar == null) {
      this.mActionBar = new d(this.mActivity, this.MY);
    }
    return this.mActionBar;
  }
  
  public final boolean d(h paramh)
  {
    return false;
  }
  
  public final void supportInvalidateOptionsMenu()
  {
    if (!this.uRB)
    {
      this.uRB = true;
      this.uRC.run();
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean c(Menu paramMenu);
    
    public abstract boolean d(Menu paramMenu);
    
    public abstract boolean h(MenuItem paramMenuItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.b.b
 * JD-Core Version:    0.7.0.1
 */