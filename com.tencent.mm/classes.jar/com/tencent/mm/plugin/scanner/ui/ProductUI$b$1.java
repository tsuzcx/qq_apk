package com.tencent.mm.plugin.scanner.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class ProductUI$b$1
  implements ProductScrollView.a
{
  ProductUI$b$1(ProductUI.b paramb) {}
  
  public final void bqW()
  {
    float f3 = 1.0F;
    AppMethodBeat.i(81103);
    ProductUI.b localb = this.qyq;
    int i = localb.qyn.getScrollY();
    float f1;
    label65:
    float f2;
    if (i < 0)
    {
      f1 = -1.0F;
      ab.v("MicroMsg.ProductUI.HeaderEffectHelper", "rate=".concat(String.valueOf(f1)));
      if (f1 != 1.0F) {
        break label211;
      }
      if (!localb.qyo)
      {
        localb.qyo = true;
        if (ProductUI.x(localb.qyh) != null)
        {
          float f4 = 1.0F - f1 - 0.2F;
          f2 = f4;
          if (f4 <= 0.0F) {
            f2 = 0.0F;
          }
          if (f1 == 0.0F) {
            f2 = 1.0F;
          }
          ProductUI.q(ProductUI.x(localb.qyh), f2);
        }
        if (ProductUI.y(localb.qyh) != null)
        {
          if (f1 != 0.0F) {
            break label220;
          }
          f2 = 0.0F;
        }
      }
    }
    for (;;)
    {
      ProductUI.q(ProductUI.y(localb.qyh), f2);
      AppMethodBeat.o(81103);
      return;
      if ((i >= ProductUI.z(localb.qyh) - localb.XO) || (ProductUI.z(localb.qyh) == 0.0F))
      {
        f1 = 1.0F;
        break;
      }
      f1 = i * 1.37F / ProductUI.z(localb.qyh);
      break;
      label211:
      localb.qyo = false;
      break label65;
      label220:
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