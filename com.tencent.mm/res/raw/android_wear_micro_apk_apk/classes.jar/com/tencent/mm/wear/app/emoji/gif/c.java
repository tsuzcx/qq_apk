package com.tencent.mm.wear.app.emoji.gif;

import android.content.res.Resources;
import com.tencent.mm.a.a;
import com.tencent.mm.a.e;
import com.tencent.mm.wear.a.c.d;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public class c
{
  private static c afY;
  private a<String, WeakReference<Object>> afZ = new e(10);
  private a<String, WeakReference<b>> aga = new e(new com.tencent.mm.a.b() {});
  
  /* Error */
  public static c np()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 37	com/tencent/mm/wear/app/emoji/gif/c:afY	Lcom/tencent/mm/wear/app/emoji/gif/c;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 37	com/tencent/mm/wear/app/emoji/gif/c:afY	Lcom/tencent/mm/wear/app/emoji/gif/c;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	com/tencent/mm/wear/app/emoji/gif/c
    //   21: dup
    //   22: invokespecial 38	com/tencent/mm/wear/app/emoji/gif/c:<init>	()V
    //   25: putstatic 37	com/tencent/mm/wear/app/emoji/gif/c:afY	Lcom/tencent/mm/wear/app/emoji/gif/c;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 37	com/tencent/mm/wear/app/emoji/gif/c:afY	Lcom/tencent/mm/wear/app/emoji/gif/c;
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: areturn
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	5	0	localc	c
    //   40	5	0	localObject1	Object
    //   46	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	28	40	finally
    //   28	31	40	finally
    //   41	44	40	finally
    //   3	12	46	finally
    //   31	35	46	finally
    //   44	46	46	finally
  }
  
  public final b a(String paramString, Resources paramResources, int paramInt)
  {
    if (this.aga.get(null) != null) {}
    for (paramString = (b)((WeakReference)this.aga.get(null)).get();; paramString = null)
    {
      Object localObject = paramString;
      if (paramString == null)
      {
        localObject = new b(paramResources, paramInt);
        this.aga.put(null, new WeakReference(localObject));
      }
      return localObject;
    }
  }
  
  public final b a(String paramString, InputStream paramInputStream)
  {
    b localb1 = null;
    b localb2 = null;
    if (paramInputStream == null) {}
    do
    {
      return localb2;
      d.d("MicroMsg.GIF.MMGIFDrawableCacheMgr", "stream key:%s", new Object[] { paramString });
      if (this.aga.get(paramString) != null) {
        localb1 = (b)((WeakReference)this.aga.get(paramString)).get();
      }
      localb2 = localb1;
    } while (localb1 != null);
    paramInputStream = new b(paramInputStream);
    this.aga.put(paramString, new WeakReference(paramInputStream));
    return paramInputStream;
  }
  
  public final b c(String paramString, byte[] paramArrayOfByte)
  {
    b localb2 = null;
    b localb1 = null;
    if (paramArrayOfByte == null) {
      paramString = localb1;
    }
    do
    {
      return paramString;
      if (this.aga.get(paramString) != null) {
        localb2 = (b)((WeakReference)this.aga.get(paramString)).get();
      }
      localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new b(paramArrayOfByte);
        this.aga.put(paramString, new WeakReference(localb1));
      }
      paramString = localb1;
    } while (localb1.isRunning());
    localb1.reset();
    return localb1;
  }
  
  public final b n(String paramString1, String paramString2)
  {
    b localb1 = null;
    if (this.aga.get(paramString1) != null) {
      localb1 = (b)((WeakReference)this.aga.get(paramString1)).get();
    }
    b localb2 = localb1;
    if (localb1 == null)
    {
      long l = System.currentTimeMillis();
      localb2 = new b(paramString2);
      d.d("MicroMsg.GIF.MMGIFDrawableCacheMgr", "new MMGIFDrawable use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      this.aga.put(paramString1, new WeakReference(localb2));
    }
    return localb2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.emoji.gif.c
 * JD-Core Version:    0.7.0.1
 */