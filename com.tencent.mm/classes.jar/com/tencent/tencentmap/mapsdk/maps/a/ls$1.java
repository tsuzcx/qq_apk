package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.util.LruCache;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.SoftReference;
import java.util.Set;

class ls$1
  extends LruCache<String, Bitmap>
{
  ls$1(ls paramls, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(149221);
    int i = this.a.a(paramBitmap);
    AppMethodBeat.o(149221);
    return i;
  }
  
  protected void a(boolean paramBoolean, String arg2, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    AppMethodBeat.i(149222);
    if (Build.VERSION.SDK_INT >= 11) {
      synchronized (this.a)
      {
        ls.a(this.a).add(new SoftReference(paramBitmap1));
        AppMethodBeat.o(149222);
        return;
      }
    }
    AppMethodBeat.o(149222);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ls.1
 * JD-Core Version:    0.7.0.1
 */