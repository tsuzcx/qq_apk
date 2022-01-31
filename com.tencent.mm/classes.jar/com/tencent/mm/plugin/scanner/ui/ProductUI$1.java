package com.tencent.mm.plugin.scanner.ui;

import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.scanner.a.l;
import com.tencent.mm.plugin.scanner.util.o.a;
import com.tencent.mm.sdk.platformtools.y;

final class ProductUI$1
  implements a.a
{
  ProductUI$1(ProductUI paramProductUI) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if (paramBoolean)
    {
      y.i("MicroMsg.scanner.ProductUI", "getLocation suc");
      if (ProductUI.a(this.nKF) != null)
      {
        y.i("MicroMsg.scanner.ProductUI", "do getActionInfoScene, lng=" + paramFloat1 + ", lat=" + paramFloat2);
        com.tencent.mm.plugin.scanner.a.c localc = new com.tencent.mm.plugin.scanner.a.c(ProductUI.b(this.nKF), l.cn(ProductUI.a(this.nKF).nPR), ProductUI.c(this.nKF), ProductUI.d(this.nKF), paramFloat1, paramFloat2);
        au.Dk().a(localc, 0);
      }
      if (ProductUI.e(this.nKF) != null) {
        ProductUI.e(this.nKF).c(ProductUI.f(this.nKF));
      }
      if (!ProductUI.g(this.nKF))
      {
        ProductUI.h(this.nKF);
        o.a(2011, paramFloat1, paramFloat2, (int)paramDouble2);
      }
      return false;
    }
    y.w("MicroMsg.scanner.ProductUI", "getLocation fail");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI.1
 * JD-Core Version:    0.7.0.1
 */