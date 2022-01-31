package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import com.tencent.map.lib.b;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.util.StringUtil;
import java.lang.ref.WeakReference;

class ly$c
  implements b
{
  private final WeakReference<ly> a;
  
  public ly$c(ly paramly)
  {
    this.a = new WeakReference(paramly);
  }
  
  public Bitmap a(String paramString)
  {
    Bitmap localBitmap = je.a(paramString);
    if (localBitmap == null) {
      localBitmap = lq.t.a(paramString);
    }
    for (;;)
    {
      Object localObject3 = localBitmap;
      if (this.a != null)
      {
        if (this.a.get() != null) {
          break label43;
        }
        localObject3 = localBitmap;
      }
      for (;;)
      {
        return localObject3;
        label43:
        localObject3 = localBitmap;
        if (localBitmap == null)
        {
          Object localObject2 = localBitmap;
          try
          {
            Object localObject1;
            if (!paramString.startsWith("poi_icon"))
            {
              localObject1 = localBitmap;
              localObject2 = localBitmap;
              if (!paramString.startsWith("mapcfg_")) {}
            }
            else
            {
              localObject2 = localBitmap;
              localObject1 = StringUtil.removeSuffix(paramString) + "@2x.png";
              localObject2 = localBitmap;
              localObject1 = ly.a((ly)this.a.get(), (String)localObject1);
            }
            if (localObject1 != null)
            {
              localObject3 = localObject1;
              localObject2 = localObject1;
              if (!StringUtil.isEmpty(paramString))
              {
                localObject2 = localObject1;
                return li.a((Bitmap)localObject1, ly.c((ly)this.a.get()));
              }
            }
            else
            {
              localObject2 = localObject1;
              paramString = ly.a((ly)this.a.get(), paramString);
              return paramString;
            }
          }
          catch (OutOfMemoryError paramString)
          {
            return localObject2;
          }
        }
      }
    }
  }
  
  public String a(GeoPoint paramGeoPoint)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ly.c
 * JD-Core Version:    0.7.0.1
 */