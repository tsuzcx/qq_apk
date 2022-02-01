package com.tencent.mm.plugin.webview.luggage;

import android.view.MenuItem;
import com.tencent.luggage.d.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.b.n;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.e;

public class o
{
  g PPn;
  n PQF;
  e rZT;
  
  public o(g paramg, n paramn)
  {
    AppMethodBeat.i(78411);
    this.PPn = paramg;
    this.PQF = paramn;
    this.rZT = new e(this.PPn.mContext, 0, false);
    this.rZT.ODT = new q.f()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymouso)
      {
        AppMethodBeat.i(78407);
        o localo = o.this;
        localo.PQF.b(localo.PPn.mContext, localo.PPn, paramAnonymouso);
        AppMethodBeat.o(78407);
      }
    };
    this.rZT.Ymx = new q.f()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymouso)
      {
        AppMethodBeat.i(78408);
        o localo = o.this;
        localo.PQF.c(localo.PPn.mContext, localo.PPn, paramAnonymouso);
        AppMethodBeat.o(78408);
      }
    };
    this.rZT.ODU = new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(78409);
        o.this.e(paramAnonymousMenuItem);
        o.this.rZT.bYF();
        AppMethodBeat.o(78409);
      }
    };
    this.rZT.YmA = new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(78410);
        o.this.e(paramAnonymousMenuItem);
        o.this.rZT.bYF();
        AppMethodBeat.o(78410);
      }
    };
    this.rZT.eik();
    AppMethodBeat.o(78411);
  }
  
  protected final void e(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(78412);
    this.PQF.a(this.PPn.mContext, this.PPn, paramMenuItem);
    AppMethodBeat.o(78412);
  }
  
  public final void gUW()
  {
    AppMethodBeat.i(78413);
    if (this.rZT != null) {
      this.rZT.bYF();
    }
    AppMethodBeat.o(78413);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.o
 * JD-Core Version:    0.7.0.1
 */