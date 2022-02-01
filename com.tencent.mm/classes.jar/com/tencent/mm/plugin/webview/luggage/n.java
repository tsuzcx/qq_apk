package com.tencent.mm.plugin.webview.luggage;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;

public class n
{
  f ASM;
  com.tencent.mm.plugin.webview.luggage.b.n ATY;
  com.tencent.mm.ui.widget.a.e mET;
  
  public n(f paramf, com.tencent.mm.plugin.webview.luggage.b.n paramn)
  {
    AppMethodBeat.i(78411);
    this.ASM = paramf;
    this.ATY = paramn;
    this.mET = new com.tencent.mm.ui.widget.a.e(this.ASM.mContext, 0, false);
    this.mET.HrX = new n.c()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(78407);
        n localn = n.this;
        localn.ATY.b(localn.ASM.mContext, localn.ASM, paramAnonymousl);
        AppMethodBeat.o(78407);
      }
    };
    this.mET.HEP = new n.c()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(78408);
        n localn = n.this;
        localn.ATY.c(localn.ASM.mContext, localn.ASM, paramAnonymousl);
        AppMethodBeat.o(78408);
      }
    };
    this.mET.HrY = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(78409);
        n.this.d(paramAnonymousMenuItem);
        n.this.mET.bfo();
        AppMethodBeat.o(78409);
      }
    };
    this.mET.HER = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(78410);
        n.this.d(paramAnonymousMenuItem);
        n.this.mET.bfo();
        AppMethodBeat.o(78410);
      }
    };
    this.mET.csG();
    AppMethodBeat.o(78411);
  }
  
  protected final void d(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(78412);
    this.ATY.a(this.ASM.mContext, this.ASM, paramMenuItem);
    AppMethodBeat.o(78412);
  }
  
  public final void eln()
  {
    AppMethodBeat.i(78413);
    if (this.mET != null) {
      this.mET.bfo();
    }
    AppMethodBeat.o(78413);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.n
 * JD-Core Version:    0.7.0.1
 */