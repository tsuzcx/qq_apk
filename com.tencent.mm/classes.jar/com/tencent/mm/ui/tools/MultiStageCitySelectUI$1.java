package com.tencent.mm.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;

final class MultiStageCitySelectUI$1
  implements b.a
{
  MultiStageCitySelectUI$1(MultiStageCitySelectUI paramMultiStageCitySelectUI) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(34891);
    if (MultiStageCitySelectUI.a(this.AwG) == null)
    {
      AppMethodBeat.o(34891);
      return false;
    }
    if (paramBoolean)
    {
      ab.i("MicroMsg.MultiStageCitySelectUI", "lat:%f lng:%f accuracy:%f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1), Double.valueOf(paramDouble2) });
      l locall = new l(paramFloat2, paramFloat1);
      aw.Rc().a(locall, 0);
    }
    for (;;)
    {
      if (MultiStageCitySelectUI.a(this.AwG) != null)
      {
        MultiStageCitySelectUI.a(this.AwG).c(MultiStageCitySelectUI.e(this.AwG));
        MultiStageCitySelectUI.f(this.AwG);
      }
      AppMethodBeat.o(34891);
      return false;
      MultiStageCitySelectUI.b(this.AwG);
      if ((!MultiStageCitySelectUI.c(this.AwG)) && (!d.agR()))
      {
        MultiStageCitySelectUI.d(this.AwG);
        h.a(this.AwG, this.AwG.getString(2131300538), this.AwG.getString(2131297087), this.AwG.getString(2131300996), this.AwG.getString(2131296888), false, new MultiStageCitySelectUI.1.1(this), null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MultiStageCitySelectUI.1
 * JD-Core Version:    0.7.0.1
 */