package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.MapLanguage;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.listener.MapLanguageChangeListener;
import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import java.util.List;

class jh$c
  implements MapLanguageChangeListener
{
  private List<MapRouteSectionWithName> b;
  private List<GeoPoint> c;
  
  public jh$c(jh paramjh)
  {
    paramjh.a(this);
  }
  
  public void a()
  {
    this.a.b(this);
  }
  
  public void a(List<MapRouteSectionWithName> paramList, List<GeoPoint> paramList1)
  {
    this.b = paramList;
    this.c = paramList1;
    jh.a(this.a).a(paramList, paramList1);
  }
  
  public void b()
  {
    jh.a(this.a).C();
    this.b = null;
    this.c = null;
  }
  
  public void onLanguageChange(MapLanguage paramMapLanguage)
  {
    if (paramMapLanguage == MapLanguage.LAN_CHINESE)
    {
      if ((this.b != null) && (this.c != null)) {
        jh.a(this.a).a(this.b, this.c);
      }
      return;
    }
    jh.a(this.a).C();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.jh.c
 * JD-Core Version:    0.7.0.1
 */