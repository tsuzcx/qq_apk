package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import com.tencent.map.lib.util.SystemUtil;
import java.nio.IntBuffer;
import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL10;

class jh$d
{
  private final ArrayList<jh.e> b = new ArrayList();
  private jh.e c;
  
  private jh$d(jh paramjh) {}
  
  private Bitmap a(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    int i = paramInt1 * paramInt2;
    int[] arrayOfInt2 = new int[i];
    int[] arrayOfInt1 = new int[i];
    IntBuffer localIntBuffer = IntBuffer.wrap(arrayOfInt2);
    localIntBuffer.position(0);
    paramGL10.glReadPixels((jh.e(this.a).width() - paramInt1) / 2, (jh.e(this.a).height() - paramInt2) / 2, paramInt1, paramInt2, 6408, 5121, localIntBuffer);
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
      return paramGL10;
    }
    catch (OutOfMemoryError paramGL10) {}
    return Bitmap.createBitmap(arrayOfInt1, paramInt1, paramInt2, Bitmap.Config.RGB_565);
  }
  
  private void a(jh.e parame)
  {
    if ((parame == null) || (parame.a())) {
      return;
    }
    parame.b();
    synchronized (this.b)
    {
      this.b.remove(parame);
      jh.c(this.a).i();
      return;
    }
  }
  
  private jh.e b()
  {
    jh.e locale = null;
    synchronized (this.b)
    {
      if (this.b.size() > 0) {
        locale = (jh.e)this.b.get(0);
      }
      return locale;
    }
  }
  
  public jh.e a(GL10 paramGL10)
  {
    paramGL10 = null;
    for (;;)
    {
      try
      {
        this.c = b();
        localObject = this.c;
        if (localObject == null) {
          return paramGL10;
        }
        if (this.c.c())
        {
          a(this.c);
          continue;
        }
        jh.c(this.a).h();
      }
      finally {}
      paramGL10 = jh.e.c(this.c);
      int k = jh.e.d(this.c);
      int i = jh.e.e(this.c);
      Object localObject = new Rect();
      int j = (int)(SystemUtil.getDensity(jh.d(this.a)) * 20.0F);
      k = (jh.e(this.a).width() - k) / 2 + j;
      ((Rect)localObject).right = k;
      ((Rect)localObject).left = k;
      i = (jh.e(this.a).height() - i) / 2 + j;
      ((Rect)localObject).bottom = i;
      ((Rect)localObject).top = i;
      jh.c(this.a).b(paramGL10, (Rect)localObject);
      paramGL10 = this.c;
    }
  }
  
  /* Error */
  public void a(GL10 paramGL10, je paramje, iu paramiu)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	com/tencent/tencentmap/mapsdk/a/jh$d:a	Lcom/tencent/tencentmap/mapsdk/a/jh;
    //   6: invokestatic 155	com/tencent/tencentmap/mapsdk/a/jh:a	(Lcom/tencent/tencentmap/mapsdk/a/jh;)Lcom/tencent/tencentmap/mapsdk/a/jc;
    //   9: astore_1
    //   10: aload_1
    //   11: ifnonnull +6 -> 17
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: getfield 109	com/tencent/tencentmap/mapsdk/a/jh$d:c	Lcom/tencent/tencentmap/mapsdk/a/jh$e;
    //   21: invokestatic 159	com/tencent/tencentmap/mapsdk/a/jh$e:f	(Lcom/tencent/tencentmap/mapsdk/a/jh$e;)Lcom/tencent/tencentmap/mapsdk/a/kj;
    //   24: astore_1
    //   25: aload_1
    //   26: ifnull +27 -> 53
    //   29: aload_1
    //   30: instanceof 161
    //   33: ifeq +12 -> 45
    //   36: aload_1
    //   37: checkcast 161	com/tencent/tencentmap/mapsdk/a/ka
    //   40: aload_2
    //   41: aload_3
    //   42: invokevirtual 164	com/tencent/tencentmap/mapsdk/a/ka:a	(Lcom/tencent/tencentmap/mapsdk/a/je;Lcom/tencent/tencentmap/mapsdk/a/iu;)V
    //   45: aload_1
    //   46: aload_2
    //   47: aload_3
    //   48: invokeinterface 168 3 0
    //   53: aload_2
    //   54: invokevirtual 172	com/tencent/tencentmap/mapsdk/a/je:a	()V
    //   57: goto -43 -> 14
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	d
    //   0	65	1	paramGL10	GL10
    //   0	65	2	paramje	je
    //   0	65	3	paramiu	iu
    // Exception table:
    //   from	to	target	type
    //   2	10	60	finally
    //   17	25	60	finally
    //   29	45	60	finally
    //   45	53	60	finally
    //   53	57	60	finally
  }
  
  public boolean a()
  {
    for (;;)
    {
      synchronized (this.b)
      {
        if (this.b != null)
        {
          if (!this.b.isEmpty()) {
            break label41;
          }
          break label36;
          return bool;
        }
      }
      label36:
      boolean bool = true;
      continue;
      label41:
      bool = false;
    }
  }
  
  public void b(GL10 paramGL10, je paramje, iu paramiu)
  {
    try
    {
      if ((this.c != null) && (!this.c.c()))
      {
        int i = jh.e.d(this.c);
        int j = jh.e.e(this.c);
        paramje = jh.e.g(this.c);
        paramiu = jh.e.f(this.c);
        paramGL10 = a(paramGL10, i, j);
        if ((paramje != null) && (!this.c.a())) {
          paramje.a(paramGL10, paramiu);
        }
        a(this.c);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.jh.d
 * JD-Core Version:    0.7.0.1
 */