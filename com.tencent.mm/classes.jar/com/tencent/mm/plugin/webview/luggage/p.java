package com.tencent.mm.plugin.webview.luggage;

import android.view.MenuItem;
import com.tencent.luggage.d.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.b.n;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.a.f;

public class p
{
  g WFG;
  n WHc;
  f vlk;
  
  public p(g paramg, n paramn)
  {
    AppMethodBeat.i(78411);
    this.WFG = paramg;
    this.WHc = paramn;
    this.vlk = new f(this.WFG.mContext, 0, false);
    this.vlk.Vtg = new u.g()
    {
      public final void onCreateMMMenu(s paramAnonymouss)
      {
        AppMethodBeat.i(78407);
        p localp = p.this;
        localp.WHc.b(localp.WFG.mContext, localp.WFG, paramAnonymouss);
        AppMethodBeat.o(78407);
      }
    };
    this.vlk.GAz = new u.g()
    {
      public final void onCreateMMMenu(s paramAnonymouss)
      {
        AppMethodBeat.i(78408);
        p localp = p.this;
        localp.WHc.c(localp.WFG.mContext, localp.WFG, paramAnonymouss);
        AppMethodBeat.o(78408);
      }
    };
    this.vlk.GAC = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(78409);
        p.this.g(paramAnonymousMenuItem);
        p.this.vlk.cyW();
        AppMethodBeat.o(78409);
      }
    };
    this.vlk.agem = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(78410);
        p.this.g(paramAnonymousMenuItem);
        p.this.vlk.cyW();
        AppMethodBeat.o(78410);
      }
    };
    this.vlk.dDn();
    AppMethodBeat.o(78411);
  }
  
  protected final void g(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(78412);
    this.WHc.a(this.WFG.mContext, this.WFG, paramMenuItem);
    AppMethodBeat.o(78412);
  }
  
  public final void iuH()
  {
    AppMethodBeat.i(78413);
    if (this.vlk != null) {
      this.vlk.cyW();
    }
    AppMethodBeat.o(78413);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.p
 * JD-Core Version:    0.7.0.1
 */