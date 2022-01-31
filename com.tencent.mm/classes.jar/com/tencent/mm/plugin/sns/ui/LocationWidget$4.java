package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelstat.e;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.sdk.platformtools.y;

final class LocationWidget$4
  implements a.a
{
  LocationWidget$4(LocationWidget paramLocationWidget) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if (!paramBoolean) {
      return true;
    }
    y.d("MicroMsg.LocationWidget", "get location %f %f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1) });
    e locale = e.Rq();
    if (paramInt == 0)
    {
      paramBoolean = false;
      if (LocationWidget.h(this.oQA) != null) {
        break label98;
      }
    }
    label98:
    for (boolean bool = false;; bool = LocationWidget.h(this.oQA).elu)
    {
      locale.a(2003, paramBoolean, bool, paramFloat1, paramFloat2, (int)paramDouble2);
      o.a(2003, paramFloat1, paramFloat2, 0);
      if (LocationWidget.e(this.oQA)) {
        break label113;
      }
      return false;
      paramBoolean = true;
      break;
    }
    label113:
    if ((LocationWidget.i(this.oQA) == -1000.0F) || (LocationWidget.j(this.oQA) == -1000.0F))
    {
      LocationWidget.a(this.oQA, paramFloat2);
      LocationWidget.b(this.oQA, paramFloat1);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.LocationWidget.4
 * JD-Core Version:    0.7.0.1
 */