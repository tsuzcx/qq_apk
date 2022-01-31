package com.tencent.tencentmap.mapsdk.dynamic;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.dw;
import com.tencent.tencentmap.mapsdk.a.dy;
import com.tencent.tencentmap.mapsdk.a.ea;
import com.tencent.tencentmap.mapsdk.a.eg;
import com.tencent.tencentmap.mapsdk.map.IMapView;
import com.tencent.tencentmap.mapsdk.map.TencentMapOptions;

public class b
{
  private TencentMapOptions a;
  
  public IMapView a(Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(101277);
    int i = 0;
    this.a = paramTencentMapOptions;
    if (this.a != null) {
      i = this.a.getMapType();
    }
    switch (i)
    {
    default: 
      paramContext = new ea(paramContext, this.a);
    }
    for (;;)
    {
      AppMethodBeat.o(101277);
      return paramContext;
      dw.a("maptype", "glmapview");
      paramContext = new ea(paramContext, this.a);
      continue;
      paramContext = new dy(paramContext, this.a);
      dw.a("maptype", "texturemapview");
      continue;
      paramContext = new eg(paramContext, this.a);
      dw.a("maptype", "maprenderlayer");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.dynamic.b
 * JD-Core Version:    0.7.0.1
 */