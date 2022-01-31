package com.tencent.mm.plugin.scanner.ui;

import com.tencent.mm.sdk.platformtools.y;

final class ProductUI$b$1
  implements ProductScrollView.a
{
  ProductUI$b$1(ProductUI.b paramb) {}
  
  public final void aMI()
  {
    float f3 = 1.0F;
    ProductUI.b localb = this.nKN;
    int i = localb.nKK.getScrollY();
    float f1;
    label67:
    float f2;
    if (i < 0)
    {
      f1 = -1.0F;
      y.v("MicroMsg.ProductUI.HeaderEffectHelper", "rate=" + f1);
      if (f1 != 1.0F) {
        break label208;
      }
      if (!localb.nKL)
      {
        localb.nKL = true;
        if (ProductUI.v(localb.nKF) != null)
        {
          float f4 = 1.0F - f1 - 0.2F;
          f2 = f4;
          if (f4 <= 0.0F) {
            f2 = 0.0F;
          }
          if (f1 == 0.0F) {
            f2 = 1.0F;
          }
          ProductUI.n(ProductUI.v(localb.nKF), f2);
        }
        if (ProductUI.w(localb.nKF) != null)
        {
          if (f1 != 0.0F) {
            break label217;
          }
          f2 = 0.0F;
        }
      }
    }
    for (;;)
    {
      ProductUI.n(ProductUI.w(localb.nKF), f2);
      return;
      if ((i >= ProductUI.x(localb.nKF) - localb.Xc) || (ProductUI.x(localb.nKF) == 0.0F))
      {
        f1 = 1.0F;
        break;
      }
      f1 = i * 1.37F / ProductUI.x(localb.nKF);
      break;
      label208:
      localb.nKL = false;
      break label67;
      label217:
      f2 = f3;
      if (f1 >= 0.0F)
      {
        f1 += 0.2F;
        f2 = f3;
        if (f1 <= 1.0F) {
          f2 = f1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI.b.1
 * JD-Core Version:    0.7.0.1
 */