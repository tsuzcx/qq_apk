package com.tencent.mm.ui.tools;

import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelsimple.j;
import com.tencent.mm.sdk.platformtools.y;

final class MultiStageCitySelectUI$1
  implements a.a
{
  MultiStageCitySelectUI$1(MultiStageCitySelectUI paramMultiStageCitySelectUI) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if (MultiStageCitySelectUI.a(this.wdX) == null) {
      return false;
    }
    if (paramBoolean)
    {
      y.i("MicroMsg.MultiStageCitySelectUI", "lat:%f lng:%f accuracy:%f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1), Double.valueOf(paramDouble2) });
      j localj = new j(paramFloat2, paramFloat1);
      au.Dk().a(localj, 0);
    }
    for (;;)
    {
      if (MultiStageCitySelectUI.a(this.wdX) != null)
      {
        MultiStageCitySelectUI.a(this.wdX).c(MultiStageCitySelectUI.c(this.wdX));
        MultiStageCitySelectUI.d(this.wdX);
      }
      return false;
      MultiStageCitySelectUI.b(this.wdX);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MultiStageCitySelectUI.1
 * JD-Core Version:    0.7.0.1
 */