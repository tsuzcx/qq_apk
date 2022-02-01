package com.tencent.mm.plugin.webview.luggage;

import android.view.MenuItem;
import com.tencent.luggage.d.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.b.n;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.e;

public class o
{
  g ISU;
  n IUo;
  e oXS;
  
  public o(g paramg, n paramn)
  {
    AppMethodBeat.i(78411);
    this.ISU = paramg;
    this.IUo = paramn;
    this.oXS = new e(this.ISU.mContext, 0, false);
    this.oXS.HLX = new o.f()
    {
      public final void onCreateMMMenu(m paramAnonymousm)
      {
        AppMethodBeat.i(78407);
        o localo = o.this;
        localo.IUo.b(localo.ISU.mContext, localo.ISU, paramAnonymousm);
        AppMethodBeat.o(78407);
      }
    };
    this.oXS.QNH = new o.f()
    {
      public final void onCreateMMMenu(m paramAnonymousm)
      {
        AppMethodBeat.i(78408);
        o localo = o.this;
        localo.IUo.c(localo.ISU.mContext, localo.ISU, paramAnonymousm);
        AppMethodBeat.o(78408);
      }
    };
    this.oXS.HLY = new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(78409);
        o.this.d(paramAnonymousMenuItem);
        o.this.oXS.bMo();
        AppMethodBeat.o(78409);
      }
    };
    this.oXS.QNK = new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(78410);
        o.this.d(paramAnonymousMenuItem);
        o.this.oXS.bMo();
        AppMethodBeat.o(78410);
      }
    };
    this.oXS.dGm();
    AppMethodBeat.o(78411);
  }
  
  protected final void d(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(78412);
    this.IUo.a(this.ISU.mContext, this.ISU, paramMenuItem);
    AppMethodBeat.o(78412);
  }
  
  public final void gca()
  {
    AppMethodBeat.i(78413);
    if (this.oXS != null) {
      this.oXS.bMo();
    }
    AppMethodBeat.o(78413);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.o
 * JD-Core Version:    0.7.0.1
 */