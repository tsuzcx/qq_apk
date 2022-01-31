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
  public ViewGroup MO;
  private boolean OJ;
  private h eq;
  a zgb;
  boolean zgc;
  private final Runnable zgd;
  
  public b(Activity paramActivity, a parama)
  {
    super(paramActivity);
    AppMethodBeat.i(106150);
    this.zgd = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106149);
        b localb = b.this;
        Object localObject = localb.mActivity;
        ActionBar localActionBar = localb.getSupportActionBar();
        if (localActionBar != null) {
          localObject = localActionBar.getThemedContext();
        }
        localObject = new h((Context)localObject);
        ((h)localObject).a(localb);
        if (b.this.zgb != null)
        {
          b.this.zgb.d((Menu)localObject);
          b.this.zgb.c((Menu)localObject);
          b.a(b.this, (h)localObject);
        }
        for (;;)
        {
          ((h)localObject).p(true);
          b.this.zgc = false;
          AppMethodBeat.o(106149);
          return;
          b.a(b.this, null);
        }
      }
    };
    this.zgb = parama;
    AppMethodBeat.o(106150);
  }
  
  private void eG()
  {
    AppMethodBeat.i(106152);
    if (!this.OJ)
    {
      this.OJ = true;
      supportInvalidateOptionsMenu();
    }
    AppMethodBeat.o(106152);
  }
  
  public final void a(h paramh, boolean paramBoolean) {}
  
  public final boolean a(h paramh, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(106153);
    if (this.zgb != null)
    {
      boolean bool = this.zgb.e(paramMenuItem);
      AppMethodBeat.o(106153);
      return bool;
    }
    AppMethodBeat.o(106153);
    return false;
  }
  
  public final void b(h paramh)
  {
    AppMethodBeat.i(106154);
    if (this.mActionBar != null)
    {
      u localu = ((d)this.mActionBar).PY;
      if ((localu != null) && (localu.gx()))
      {
        if (!localu.isOverflowMenuShowing())
        {
          if (localu.getVisibility() == 0)
          {
            localu.showOverflowMenu();
            AppMethodBeat.o(106154);
          }
        }
        else {
          localu.hideOverflowMenu();
        }
        AppMethodBeat.o(106154);
        return;
      }
    }
    paramh.close();
    AppMethodBeat.o(106154);
  }
  
  public final boolean d(h paramh)
  {
    return false;
  }
  
  public final ActionBar dDu()
  {
    AppMethodBeat.i(106151);
    eG();
    if (this.mActionBar == null) {
      this.mActionBar = new d(this.mActivity, this.MO);
    }
    ActionBar localActionBar = this.mActionBar;
    AppMethodBeat.o(106151);
    return localActionBar;
  }
  
  public final void supportInvalidateOptionsMenu()
  {
    AppMethodBeat.i(106155);
    if (!this.zgc)
    {
      this.zgc = true;
      this.zgd.run();
    }
    AppMethodBeat.o(106155);
  }
  
  public static abstract interface a
  {
    public abstract boolean c(Menu paramMenu);
    
    public abstract boolean d(Menu paramMenu);
    
    public abstract boolean e(MenuItem paramMenuItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.b.b
 * JD-Core Version:    0.7.0.1
 */