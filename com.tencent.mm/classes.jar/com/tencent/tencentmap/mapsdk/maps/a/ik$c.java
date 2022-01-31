package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.map.lib.MapLanguage;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.listener.MapLanguageChangeListener;
import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

class ik$c
  implements MapLanguageChangeListener
{
  private List<MapRouteSectionWithName> b;
  private List<GeoPoint> c;
  
  public ik$c(ik paramik)
  {
    AppMethodBeat.i(148455);
    paramik.a(this);
    AppMethodBeat.o(148455);
  }
  
  public void a()
  {
    AppMethodBeat.i(148456);
    this.a.b(this);
    AppMethodBeat.o(148456);
  }
  
  public void a(List<MapRouteSectionWithName> paramList, List<GeoPoint> paramList1)
  {
    AppMethodBeat.i(148457);
    this.b = paramList;
    this.c = paramList1;
    ik.a(this.a).a(paramList, paramList1);
    AppMethodBeat.o(148457);
  }
  
  public void b()
  {
    AppMethodBeat.i(148458);
    ik.a(this.a).z();
    this.b = null;
    this.c = null;
    AppMethodBeat.o(148458);
  }
  
  public void onLanguageChange(MapLanguage paramMapLanguage)
  {
    AppMethodBeat.i(148459);
    if (paramMapLanguage == MapLanguage.LAN_CHINESE)
    {
      if ((this.b != null) && (this.c != null))
      {
        ik.a(this.a).a(this.b, this.c);
        AppMethodBeat.o(148459);
      }
    }
    else {
      ik.a(this.a).z();
    }
    AppMethodBeat.o(148459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ik.c
 * JD-Core Version:    0.7.0.1
 */