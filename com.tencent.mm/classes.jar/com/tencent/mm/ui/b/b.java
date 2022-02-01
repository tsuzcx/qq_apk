package com.tencent.mm.ui.b;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.h.a;
import android.support.v7.view.menu.o.a;
import android.support.v7.widget.u;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends a
  implements h.a, o.a
{
  a FTs;
  boolean FTt;
  private final Runnable FTu;
  public ViewGroup TP;
  private boolean VP;
  private h XT;
  
  public b(Activity paramActivity, a parama)
  {
    super(paramActivity);
    AppMethodBeat.i(141510);
    this.FTu = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(141509);
        b localb = b.this;
        Object localObject = localb.mActivity;
        ActionBar localActionBar = localb.getSupportActionBar();
        if (localActionBar != null) {
          localObject = localActionBar.getThemedContext();
        }
        localObject = new h((Context)localObject);
        ((h)localObject).a(localb);
        if (b.this.FTs != null)
        {
          b.this.FTs.e((Menu)localObject);
          b.this.FTs.d((Menu)localObject);
          b.a(b.this, (h)localObject);
        }
        for (;;)
        {
          ((h)localObject).r(true);
          b.this.FTt = false;
          AppMethodBeat.o(141509);
          return;
          b.a(b.this, null);
        }
      }
    };
    this.FTs = parama;
    AppMethodBeat.o(141510);
  }
  
  private void fY()
  {
    AppMethodBeat.i(141512);
    if (!this.VP)
    {
      this.VP = true;
      supportInvalidateOptionsMenu();
    }
    AppMethodBeat.o(141512);
  }
  
  public final void a(h paramh, boolean paramBoolean) {}
  
  public final boolean a(h paramh, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(141513);
    if (this.FTs != null)
    {
      boolean bool = this.FTs.f(paramMenuItem);
      AppMethodBeat.o(141513);
      return bool;
    }
    AppMethodBeat.o(141513);
    return false;
  }
  
  public final void b(h paramh)
  {
    AppMethodBeat.i(141514);
    if (this.mActionBar != null)
    {
      u localu = ((d)this.mActionBar).WX;
      if ((localu != null) && (localu.hS()))
      {
        if (!localu.isOverflowMenuShowing())
        {
          if (localu.getVisibility() == 0)
          {
            localu.showOverflowMenu();
            AppMethodBeat.o(141514);
          }
        }
        else {
          localu.hideOverflowMenu();
        }
        AppMethodBeat.o(141514);
        return;
      }
    }
    paramh.close();
    AppMethodBeat.o(141514);
  }
  
  public final boolean d(h paramh)
  {
    return false;
  }
  
  public final ActionBar eSg()
  {
    AppMethodBeat.i(141511);
    fY();
    if (this.mActionBar == null) {
      this.mActionBar = new d(this.mActivity, this.TP);
    }
    ActionBar localActionBar = this.mActionBar;
    AppMethodBeat.o(141511);
    return localActionBar;
  }
  
  public final void supportInvalidateOptionsMenu()
  {
    AppMethodBeat.i(141515);
    if (!this.FTt)
    {
      this.FTt = true;
      this.FTu.run();
    }
    AppMethodBeat.o(141515);
  }
  
  public static abstract interface a
  {
    public abstract boolean d(Menu paramMenu);
    
    public abstract boolean e(Menu paramMenu);
    
    public abstract boolean f(MenuItem paramMenuItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.b.b
 * JD-Core Version:    0.7.0.1
 */