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
  g DOl;
  n DPC;
  e nHu;
  
  public o(g paramg, n paramn)
  {
    AppMethodBeat.i(78411);
    this.DOl = paramg;
    this.DPC = paramn;
    this.nHu = new e(this.DOl.mContext, 0, false);
    this.nHu.KJy = new n.d()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(78407);
        o localo = o.this;
        localo.DPC.b(localo.DOl.mContext, localo.DOl, paramAnonymousl);
        AppMethodBeat.o(78407);
      }
    };
    this.nHu.KWs = new n.d()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(78408);
        o localo = o.this;
        localo.DPC.c(localo.DOl.mContext, localo.DOl, paramAnonymousl);
        AppMethodBeat.o(78408);
      }
    };
    this.nHu.KJz = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(78409);
        o.this.d(paramAnonymousMenuItem);
        o.this.nHu.bpT();
        AppMethodBeat.o(78409);
      }
    };
    this.nHu.KWv = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(78410);
        o.this.d(paramAnonymousMenuItem);
        o.this.nHu.bpT();
        AppMethodBeat.o(78410);
      }
    };
    this.nHu.cMW();
    AppMethodBeat.o(78411);
  }
  
  protected final void d(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(78412);
    this.DPC.a(this.DOl.mContext, this.DOl, paramMenuItem);
    AppMethodBeat.o(78412);
  }
  
  public final void ePB()
  {
    AppMethodBeat.i(78413);
    if (this.nHu != null) {
      this.nHu.bpT();
    }
    AppMethodBeat.o(78413);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.o
 * JD-Core Version:    0.7.0.1
 */