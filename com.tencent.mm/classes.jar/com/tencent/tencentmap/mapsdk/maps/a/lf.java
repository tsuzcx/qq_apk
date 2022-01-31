package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.map.lib.b;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.map.lib.util.SystemUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.ao;
import com.tencent.tencentmap.mapsdk.a.p;
import com.tencent.tencentmap.mapsdk.a.r;
import com.tencent.tencentmap.mapsdk.a.t;
import java.io.Closeable;
import java.io.InputStream;

public class lf
  implements b
{
  private Context a;
  private final float b;
  private String c;
  
  public lf(Context paramContext, String paramString)
  {
    AppMethodBeat.i(149140);
    this.a = paramContext.getApplicationContext();
    this.b = (SystemUtil.getDensity(this.a) / 2.0F);
    this.c = paramString;
    AppMethodBeat.o(149140);
  }
  
  private Bitmap b(String paramString)
  {
    AppMethodBeat.i(149142);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(149142);
      return null;
    }
    Object localObject2 = t.b(p.a(this.a).b(this.c) + paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = t.b(p.a(this.a).c(this.c) + paramString);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = t.b(p.a(this.a).e() + paramString);
    }
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (r.a() == null) {
        break label213;
      }
      localObject1 = r.b(this.a, r.a() + paramString);
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = r.a(this.a, paramString);
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = r.b(this.a, paramString);
      }
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(149142);
      return null;
      label213:
      localObject1 = localObject2;
      if (r.b() != null) {
        localObject1 = t.b(r.b() + paramString);
      }
    }
    paramString = BitmapFactory.decodeStream((InputStream)localObject1);
    t.a((Closeable)localObject1);
    AppMethodBeat.o(149142);
    return paramString;
  }
  
  public Bitmap a(String paramString)
  {
    AppMethodBeat.i(149141);
    Object localObject2 = ih.a(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = ka.u.a(paramString);
    }
    if (this.a == null)
    {
      AppMethodBeat.o(149141);
      return localObject1;
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = localObject1;
    }
    for (;;)
    {
      try
      {
        if (!paramString.startsWith("poi_icon"))
        {
          localObject3 = localObject1;
          localObject2 = localObject1;
          if (!paramString.startsWith("mapcfg_")) {}
        }
        else
        {
          localObject2 = localObject1;
          localObject3 = b(StringUtil.removeSuffix(paramString) + "@2x.png");
        }
        if (localObject3 == null) {
          continue;
        }
        localObject2 = localObject3;
        if (paramString.contains("poi_icon_indoor")) {
          continue;
        }
        localObject2 = localObject3;
        paramString = jr.a((Bitmap)localObject3, this.b);
        localObject2 = paramString;
      }
      catch (OutOfMemoryError paramString)
      {
        Object localObject3;
        continue;
      }
      AppMethodBeat.o(149141);
      return localObject2;
      localObject2 = localObject3;
      paramString = jr.a((Bitmap)localObject3, (int)(this.b * ((Bitmap)localObject3).getHeight()) / ((Bitmap)localObject3).getHeight());
      localObject2 = paramString;
      continue;
      localObject2 = localObject3;
      paramString = b(paramString);
      localObject2 = paramString;
    }
  }
  
  public String a(GeoPoint paramGeoPoint)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.lf
 * JD-Core Version:    0.7.0.1
 */