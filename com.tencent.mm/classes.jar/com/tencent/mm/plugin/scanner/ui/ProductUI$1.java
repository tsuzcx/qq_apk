package com.tencent.mm.plugin.scanner.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.scanner.model.c;
import com.tencent.mm.plugin.scanner.model.m;
import com.tencent.mm.plugin.scanner.util.q.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;

final class ProductUI$1
  implements b.a
{
  ProductUI$1(ProductUI paramProductUI) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(81079);
    if (paramBoolean)
    {
      ab.i("MicroMsg.scanner.ProductUI", "getLocation suc");
      if (ProductUI.a(this.qyh) != null)
      {
        ab.i("MicroMsg.scanner.ProductUI", "do getActionInfoScene, lng=" + paramFloat1 + ", lat=" + paramFloat2);
        c localc = new c(ProductUI.b(this.qyh), m.cR(ProductUI.a(this.qyh).qDK), ProductUI.c(this.qyh), ProductUI.d(this.qyh), paramFloat1, paramFloat2);
        g.Rc().a(localc, 0);
      }
      if (ProductUI.e(this.qyh) != null) {
        ProductUI.e(this.qyh).c(ProductUI.f(this.qyh));
      }
      if (!ProductUI.g(this.qyh))
      {
        ProductUI.h(this.qyh);
        o.a(2011, paramFloat1, paramFloat2, (int)paramDouble2);
      }
      AppMethodBeat.o(81079);
      return false;
    }
    if ((!ProductUI.i(this.qyh)) && (!d.agR()))
    {
      ProductUI.j(this.qyh);
      h.a(this.qyh, this.qyh.getString(2131300538), this.qyh.getString(2131297087), this.qyh.getString(2131300996), this.qyh.getString(2131296888), false, new ProductUI.1.1(this), null);
    }
    ab.w("MicroMsg.scanner.ProductUI", "getLocation fail");
    AppMethodBeat.o(81079);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI.1
 * JD-Core Version:    0.7.0.1
 */