package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.util.LruCache;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.SoftReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ls
{
  private LruCache<String, Bitmap> a;
  private Set<SoftReference<Bitmap>> b;
  private final float c;
  
  public ls(int paramInt)
  {
    AppMethodBeat.i(149225);
    this.c = 0.2F;
    a(paramInt);
    AppMethodBeat.o(149225);
  }
  
  private void a(int paramInt)
  {
    AppMethodBeat.i(149226);
    paramInt = Math.min(paramInt, (int)(0.2F * (float)Runtime.getRuntime().maxMemory()));
    if (Build.VERSION.SDK_INT >= 11) {
      this.b = new HashSet();
    }
    this.a = new ls.1(this, paramInt);
    AppMethodBeat.o(149226);
  }
  
  public int a(Bitmap paramBitmap)
  {
    AppMethodBeat.i(149227);
    if (Build.VERSION.SDK_INT >= 19)
    {
      i = paramBitmap.getAllocationByteCount();
      AppMethodBeat.o(149227);
      return i;
    }
    if (Build.VERSION.SDK_INT >= 12)
    {
      i = paramBitmap.getByteCount();
      AppMethodBeat.o(149227);
      return i;
    }
    int i = paramBitmap.getRowBytes();
    int j = paramBitmap.getHeight();
    AppMethodBeat.o(149227);
    return i * j;
  }
  
  public Bitmap a()
  {
    AppMethodBeat.i(149228);
    for (;;)
    {
      try
      {
        if ((this.b != null) && (!this.b.isEmpty()))
        {
          Iterator localIterator = this.b.iterator();
          if (localIterator.hasNext())
          {
            Bitmap localBitmap = (Bitmap)((SoftReference)localIterator.next()).get();
            if ((localBitmap != null) && (localBitmap.isMutable()))
            {
              localIterator.remove();
              return localBitmap;
            }
            localIterator.remove();
            continue;
          }
        }
        Object localObject2 = null;
      }
      finally
      {
        AppMethodBeat.o(149228);
      }
    }
  }
  
  public Bitmap a(String paramString)
  {
    AppMethodBeat.i(149229);
    Bitmap localBitmap = null;
    if (this.a != null) {
      localBitmap = (Bitmap)this.a.get(paramString);
    }
    AppMethodBeat.o(149229);
    return localBitmap;
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(149230);
    if ((paramString == null) || (paramBitmap == null))
    {
      AppMethodBeat.o(149230);
      return;
    }
    this.a.put(paramString, paramBitmap);
    AppMethodBeat.o(149230);
  }
  
  public void b()
  {
    AppMethodBeat.i(100470);
    if (this.a != null) {
      this.a.evictAll();
    }
    AppMethodBeat.o(100470);
  }
  
  public void c()
  {
    AppMethodBeat.i(149231);
    this.a.evictAll();
    this.b.clear();
    this.a = null;
    this.b = null;
    AppMethodBeat.o(149231);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ls
 * JD-Core Version:    0.7.0.1
 */