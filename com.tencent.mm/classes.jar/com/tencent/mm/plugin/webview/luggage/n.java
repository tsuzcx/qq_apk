package com.tencent.mm.plugin.webview.luggage;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;

public class n
{
  f CkZ;
  com.tencent.mm.plugin.webview.luggage.b.n Cml;
  com.tencent.mm.ui.widget.a.e ngY;
  
  public n(f paramf, com.tencent.mm.plugin.webview.luggage.b.n paramn)
  {
    AppMethodBeat.i(78411);
    this.CkZ = paramf;
    this.Cml = paramn;
    this.ngY = new com.tencent.mm.ui.widget.a.e(this.CkZ.mContext, 0, false);
    this.ngY.ISu = new n.c()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(78407);
        n localn = n.this;
        localn.Cml.b(localn.CkZ.mContext, localn.CkZ, paramAnonymousl);
        AppMethodBeat.o(78407);
      }
    };
    this.ngY.Jfj = new n.c()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(78408);
        n localn = n.this;
        localn.Cml.c(localn.CkZ.mContext, localn.CkZ, paramAnonymousl);
        AppMethodBeat.o(78408);
      }
    };
    this.ngY.ISv = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(78409);
        n.this.d(paramAnonymousMenuItem);
        n.this.ngY.bmi();
        AppMethodBeat.o(78409);
      }
    };
    this.ngY.Jfl = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(78410);
        n.this.d(paramAnonymousMenuItem);
        n.this.ngY.bmi();
        AppMethodBeat.o(78410);
      }
    };
    this.ngY.cED();
    AppMethodBeat.o(78411);
  }
  
  protected final void d(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(78412);
    this.Cml.a(this.CkZ.mContext, this.CkZ, paramMenuItem);
    AppMethodBeat.o(78412);
  }
  
  public final void eAJ()
  {
    AppMethodBeat.i(78413);
    if (this.ngY != null) {
      this.ngY.bmi();
    }
    AppMethodBeat.o(78413);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.n
 * JD-Core Version:    0.7.0.1
 */