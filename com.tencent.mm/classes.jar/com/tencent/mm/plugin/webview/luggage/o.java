package com.tencent.mm.plugin.webview.luggage;

import android.view.MenuItem;
import com.tencent.luggage.d.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.b.n;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e;

public class o
{
  g Egl;
  n EhC;
  e nMW;
  
  public o(g paramg, n paramn)
  {
    AppMethodBeat.i(78411);
    this.Egl = paramg;
    this.EhC = paramn;
    this.nMW = new e(this.Egl.mContext, 0, false);
    this.nMW.LfS = new n.d()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(78407);
        o localo = o.this;
        localo.EhC.b(localo.Egl.mContext, localo.Egl, paramAnonymousl);
        AppMethodBeat.o(78407);
      }
    };
    this.nMW.LsQ = new n.d()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(78408);
        o localo = o.this;
        localo.EhC.c(localo.Egl.mContext, localo.Egl, paramAnonymousl);
        AppMethodBeat.o(78408);
      }
    };
    this.nMW.LfT = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(78409);
        o.this.d(paramAnonymousMenuItem);
        o.this.nMW.bqD();
        AppMethodBeat.o(78409);
      }
    };
    this.nMW.LsT = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(78410);
        o.this.d(paramAnonymousMenuItem);
        o.this.nMW.bqD();
        AppMethodBeat.o(78410);
      }
    };
    this.nMW.cPF();
    AppMethodBeat.o(78411);
  }
  
  protected final void d(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(78412);
    this.EhC.a(this.Egl.mContext, this.Egl, paramMenuItem);
    AppMethodBeat.o(78412);
  }
  
  public final void eTn()
  {
    AppMethodBeat.i(78413);
    if (this.nMW != null) {
      this.nMW.bqD();
    }
    AppMethodBeat.o(78413);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.o
 * JD-Core Version:    0.7.0.1
 */