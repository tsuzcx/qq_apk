package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import com.tencent.map.lib.util.SystemUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.IntBuffer;
import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL10;

class ik$d
{
  private final ArrayList<ik.e> b;
  private ik.e c;
  
  private ik$d(ik paramik)
  {
    AppMethodBeat.i(148460);
    this.b = new ArrayList();
    AppMethodBeat.o(148460);
  }
  
  private Bitmap a(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148467);
    int i = paramInt1 * paramInt2;
    int[] arrayOfInt2 = new int[i];
    int[] arrayOfInt1 = new int[i];
    IntBuffer localIntBuffer = IntBuffer.wrap(arrayOfInt2);
    localIntBuffer.position(0);
    paramGL10.glReadPixels((ik.e(this.a).width() - paramInt1) / 2, (ik.e(this.a).height() - paramInt2) / 2, paramInt1, paramInt2, 6408, 5121, localIntBuffer);
    i = 0;
    while (i < paramInt2)
    {
      int j = 0;
      while (j < paramInt1)
      {
        int k = arrayOfInt2[(i * paramInt1 + j)];
        arrayOfInt1[((paramInt2 - i - 1) * paramInt1 + j)] = (k & 0xFF00FF00 | k << 16 & 0xFF0000 | k >> 16 & 0xFF);
        j += 1;
      }
      i += 1;
    }
    try
    {
      paramGL10 = Bitmap.createBitmap(arrayOfInt1, paramInt1, paramInt2, Bitmap.Config.RGB_565);
      AppMethodBeat.o(148467);
      return paramGL10;
    }
    catch (OutOfMemoryError paramGL10)
    {
      for (;;)
      {
        paramGL10 = Bitmap.createBitmap(arrayOfInt1, paramInt1, paramInt2, Bitmap.Config.RGB_565);
      }
    }
  }
  
  private void a(ik.e parame)
  {
    AppMethodBeat.i(148466);
    if ((parame == null) || (parame.a()))
    {
      AppMethodBeat.o(148466);
      return;
    }
    parame.b();
    synchronized (this.b)
    {
      this.b.remove(parame);
      ik.c(this.a).i();
      AppMethodBeat.o(148466);
      return;
    }
  }
  
  private ik.e b()
  {
    AppMethodBeat.i(148461);
    ik.e locale = null;
    synchronized (this.b)
    {
      if (this.b.size() > 0) {
        locale = (ik.e)this.b.get(0);
      }
      AppMethodBeat.o(148461);
      return locale;
    }
  }
  
  public ik.e a(GL10 paramGL10)
  {
    paramGL10 = null;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(148463);
        this.c = b();
        if (this.c == null)
        {
          AppMethodBeat.o(148463);
          return paramGL10;
        }
        if (this.c.c())
        {
          a(this.c);
          AppMethodBeat.o(148463);
          continue;
        }
        ik.c(this.a).h();
      }
      finally {}
      paramGL10 = ik.e.c(this.c);
      int k = ik.e.d(this.c);
      int i = ik.e.e(this.c);
      Rect localRect = new Rect();
      int j = (int)(SystemUtil.getDensity(ik.d(this.a)) * 20.0F);
      k = (ik.e(this.a).width() - k) / 2 + j;
      localRect.right = k;
      localRect.left = k;
      i = (ik.e(this.a).height() - i) / 2 + j;
      localRect.bottom = i;
      localRect.top = i;
      ik.c(this.a).b(paramGL10, localRect);
      paramGL10 = this.c;
      AppMethodBeat.o(148463);
    }
  }
  
  /* Error */
  public void a(GL10 paramGL10, ih paramih, hu paramhu)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 166
    //   4: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 18	com/tencent/tencentmap/mapsdk/maps/a/ik$d:a	Lcom/tencent/tencentmap/mapsdk/maps/a/ik;
    //   11: invokestatic 169	com/tencent/tencentmap/mapsdk/maps/a/ik:a	(Lcom/tencent/tencentmap/mapsdk/maps/a/ik;)Lcom/tencent/tencentmap/mapsdk/maps/a/if;
    //   14: ifnonnull +11 -> 25
    //   17: ldc 166
    //   19: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: getfield 122	com/tencent/tencentmap/mapsdk/maps/a/ik$d:c	Lcom/tencent/tencentmap/mapsdk/maps/a/ik$e;
    //   29: invokestatic 173	com/tencent/tencentmap/mapsdk/maps/a/ik$e:f	(Lcom/tencent/tencentmap/mapsdk/maps/a/ik$e;)Lcom/tencent/map/lib/element/j;
    //   32: astore_1
    //   33: aload_1
    //   34: ifnull +27 -> 61
    //   37: aload_1
    //   38: instanceof 175
    //   41: ifeq +12 -> 53
    //   44: aload_1
    //   45: checkcast 175	com/tencent/map/lib/element/a
    //   48: aload_2
    //   49: aload_3
    //   50: invokevirtual 178	com/tencent/map/lib/element/a:a	(Lcom/tencent/tencentmap/mapsdk/maps/a/ih;Lcom/tencent/tencentmap/mapsdk/maps/a/hu;)V
    //   53: aload_1
    //   54: aload_2
    //   55: aload_3
    //   56: invokeinterface 182 3 0
    //   61: aload_2
    //   62: invokevirtual 186	com/tencent/tencentmap/mapsdk/maps/a/ih:a	()V
    //   65: ldc 166
    //   67: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: goto -48 -> 22
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	d
    //   0	78	1	paramGL10	GL10
    //   0	78	2	paramih	ih
    //   0	78	3	paramhu	hu
    // Exception table:
    //   from	to	target	type
    //   2	22	73	finally
    //   25	33	73	finally
    //   37	53	73	finally
    //   53	61	73	finally
    //   61	70	73	finally
  }
  
  public boolean a()
  {
    AppMethodBeat.i(148462);
    for (;;)
    {
      synchronized (this.b)
      {
        if (this.b != null) {
          if (this.b.isEmpty())
          {
            break label56;
            AppMethodBeat.o(148462);
            return bool;
          }
          else
          {
            bool = false;
          }
        }
      }
      label56:
      boolean bool = true;
    }
  }
  
  public void b(GL10 paramGL10, ih paramih, hu paramhu)
  {
    try
    {
      AppMethodBeat.i(148465);
      if ((this.c != null) && (!this.c.c()))
      {
        int i = ik.e.d(this.c);
        int j = ik.e.e(this.c);
        paramih = ik.e.g(this.c);
        paramhu = ik.e.f(this.c);
        paramGL10 = a(paramGL10, i, j);
        if ((paramih != null) && (!this.c.a())) {
          paramih.a(paramGL10, paramhu);
        }
        a(this.c);
      }
      AppMethodBeat.o(148465);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ik.d
 * JD-Core Version:    0.7.0.1
 */