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
  public ViewGroup Rx;
  a WfA;
  boolean WfB;
  private final Runnable WfC;
  private boolean gh;
  private h is;
  
  public b(Activity paramActivity, a parama)
  {
    super(paramActivity);
    AppMethodBeat.i(141510);
    this.WfC = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(141509);
        b localb = b.this;
        Object localObject = localb.mActivity;
        ActionBar localActionBar = localb.getSupportActionBar();
        if (localActionBar != null) {
          localObject = localActionBar.aD();
        }
        localObject = new h((Context)localObject);
        ((h)localObject).a(localb);
        if (b.this.WfA != null)
        {
          b.this.WfA.f((Menu)localObject);
          b.this.WfA.e((Menu)localObject);
          b.a(b.this, (h)localObject);
        }
        for (;;)
        {
          ((h)localObject).H(true);
          b.this.WfB = false;
          AppMethodBeat.o(141509);
          return;
          b.a(b.this, null);
        }
      }
    };
    this.WfA = parama;
    AppMethodBeat.o(141510);
  }
  
  private void aO()
  {
    AppMethodBeat.i(141512);
    if (!this.gh)
    {
      this.gh = true;
      supportInvalidateOptionsMenu();
    }
    AppMethodBeat.o(141512);
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(222157);
    if (this.mActionBar != null)
    {
      n localn = ((d)this.mActionBar).ht;
      if ((localn != null) && (localn.cI()))
      {
        if (!localn.cJ())
        {
          if (localn.getVisibility() == 0)
          {
            localn.cC();
            AppMethodBeat.o(222157);
          }
        }
        else {
          localn.cL();
        }
        AppMethodBeat.o(222157);
        return;
      }
    }
    paramh.close();
    AppMethodBeat.o(222157);
  }
  
  public final void a(h paramh, boolean paramBoolean) {}
  
  public final boolean a(h paramh, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(222153);
    if (this.WfA != null)
    {
      boolean bool = this.WfA.g(paramMenuItem);
      AppMethodBeat.o(222153);
      return bool;
    }
    AppMethodBeat.o(222153);
    return false;
  }
  
  public final boolean c(h paramh)
  {
    return false;
  }
  
  public final ActionBar hJi()
  {
    AppMethodBeat.i(222148);
    aO();
    if (this.mActionBar == null) {
      this.mActionBar = new d(this.mActivity, this.Rx);
    }
    ActionBar localActionBar = this.mActionBar;
    AppMethodBeat.o(222148);
    return localActionBar;
  }
  
  public final void supportInvalidateOptionsMenu()
  {
    AppMethodBeat.i(141515);
    if (!this.WfB)
    {
      this.WfB = true;
      this.WfC.run();
    }
    AppMethodBeat.o(141515);
  }
  
  public static abstract interface a
  {
    public abstract boolean e(Menu paramMenu);
    
    public abstract boolean f(Menu paramMenu);
    
    public abstract boolean g(MenuItem paramMenuItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.b.b
 * JD-Core Version:    0.7.0.1
 */