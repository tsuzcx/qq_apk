package com.tencent.mm.ui.b;

import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.h.a;
import androidx.appcompat.view.menu.o.a;
import androidx.appcompat.widget.n;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends a
  implements h.a, o.a
{
  a adLH;
  boolean adLI;
  private final Runnable adLJ;
  public ViewGroup bxO;
  private boolean hc;
  private h jo;
  
  public b(Activity paramActivity, a parama)
  {
    super(paramActivity);
    AppMethodBeat.i(141510);
    this.adLJ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(141509);
        b localb = b.this;
        Object localObject = localb.mActivity;
        ActionBar localActionBar = localb.getSupportActionBar();
        if (localActionBar != null) {
          localObject = localActionBar.bw();
        }
        localObject = new h((Context)localObject);
        ((h)localObject).a(localb);
        if ((b.this.adLH != null) && (b.this.adLH.f((Menu)localObject)) && (b.this.adLH.e((Menu)localObject))) {
          b.a(b.this, (h)localObject);
        }
        for (;;)
        {
          ((h)localObject).L(true);
          b.this.adLI = false;
          AppMethodBeat.o(141509);
          return;
          b.a(b.this, null);
        }
      }
    };
    this.adLH = parama;
    AppMethodBeat.o(141510);
  }
  
  private void bH()
  {
    AppMethodBeat.i(141512);
    if (!this.hc)
    {
      this.hc = true;
      supportInvalidateOptionsMenu();
    }
    AppMethodBeat.o(141512);
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(250064);
    if (this.mActionBar != null)
    {
      n localn = ((d)this.mActionBar).iq;
      if ((localn != null) && (localn.dB()))
      {
        if (!localn.dC())
        {
          if (localn.getVisibility() == 0)
          {
            localn.dv();
            AppMethodBeat.o(250064);
          }
        }
        else {
          localn.dE();
        }
        AppMethodBeat.o(250064);
        return;
      }
    }
    paramh.close();
    AppMethodBeat.o(250064);
  }
  
  public final void a(h paramh, boolean paramBoolean) {}
  
  public final boolean a(h paramh, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(250058);
    if (this.adLH != null)
    {
      boolean bool = this.adLH.i(paramMenuItem);
      AppMethodBeat.o(250058);
      return bool;
    }
    AppMethodBeat.o(250058);
    return false;
  }
  
  public final boolean c(h paramh)
  {
    return false;
  }
  
  public final ActionBar jlx()
  {
    AppMethodBeat.i(250053);
    bH();
    if (this.mActionBar == null) {
      this.mActionBar = new d(this.mActivity, this.bxO);
    }
    ActionBar localActionBar = this.mActionBar;
    AppMethodBeat.o(250053);
    return localActionBar;
  }
  
  public final void supportInvalidateOptionsMenu()
  {
    AppMethodBeat.i(141515);
    if (!this.adLI)
    {
      this.adLI = true;
      this.adLJ.run();
    }
    AppMethodBeat.o(141515);
  }
  
  public static abstract interface a
  {
    public abstract boolean e(Menu paramMenu);
    
    public abstract boolean f(Menu paramMenu);
    
    public abstract boolean i(MenuItem paramMenuItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.b.b
 * JD-Core Version:    0.7.0.1
 */