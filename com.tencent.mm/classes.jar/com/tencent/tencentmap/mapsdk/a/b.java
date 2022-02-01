package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.IMapView;
import com.tencent.tencentmap.mapsdk.map.TencentMapOptions;

public class b
{
  private TencentMapOptions a;
  
  public IMapView a(Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(186412);
    int i = 0;
    this.a = paramTencentMapOptions;
    if (this.a != null) {
      i = this.a.getMapType();
    }
    switch (i)
    {
    default: 
      paramContext = new i(paramContext, this.a);
    }
    for (;;)
    {
      AppMethodBeat.o(186412);
      return paramContext;
      a.a("maptype", "glmapview");
      paramContext = new i(paramContext, this.a);
      continue;
      paramContext = new f(paramContext, this.a);
      a.a("maptype", "texturemapview");
      continue;
      paramContext = new o(paramContext, this.a);
      a.a("maptype", "maprenderlayer");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.b
 * JD-Core Version:    0.7.0.1
 */