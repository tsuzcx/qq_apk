package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class LocationWidget$3
  implements b.a
{
  LocationWidget$3(LocationWidget paramLocationWidget) {}
  
  public final void b(Addr paramAddr)
  {
    y.i("MicroMsg.LocationWidget", "get info %s", new Object[] { paramAddr.toString() });
    if (!LocationWidget.e(this.oQA)) {}
    do
    {
      return;
      LocationWidget.f(this.oQA);
    } while (!bk.bl(LocationWidget.g(this.oQA)));
    LocationWidget.a(this.oQA, paramAddr.elb);
    LocationWidget.f(this.oQA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.LocationWidget.3
 * JD-Core Version:    0.7.0.1
 */