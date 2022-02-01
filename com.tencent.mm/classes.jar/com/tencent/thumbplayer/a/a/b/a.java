package com.tencent.thumbplayer.a.a.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.core.common.TPThumbplayerCapabilityHelper;
import com.tencent.thumbplayer.utils.g;
import com.tencent.thumbplayer.utils.j;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.ScheduledExecutorService;

public final class a
{
  private static int[] ZAJ = new int[0];
  
  /* Error */
  public static boolean aAL(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: ldc 2
    //   5: monitorenter
    //   6: getstatic 12	com/tencent/thumbplayer/a/a/b/a:ZAJ	[I
    //   9: astore 6
    //   11: aload 6
    //   13: arraylength
    //   14: istore_2
    //   15: iconst_0
    //   16: istore_1
    //   17: iload 5
    //   19: istore 4
    //   21: iload_1
    //   22: iload_2
    //   23: if_icmpge +16 -> 39
    //   26: aload 6
    //   28: iload_1
    //   29: iaload
    //   30: istore_3
    //   31: iload_3
    //   32: iload_0
    //   33: if_icmpne +12 -> 45
    //   36: iconst_1
    //   37: istore 4
    //   39: ldc 2
    //   41: monitorexit
    //   42: iload 4
    //   44: ireturn
    //   45: iload_1
    //   46: iconst_1
    //   47: iadd
    //   48: istore_1
    //   49: goto -32 -> 17
    //   52: astore 6
    //   54: ldc 2
    //   56: monitorexit
    //   57: aload 6
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	paramInt	int
    //   16	33	1	i	int
    //   14	10	2	j	int
    //   30	4	3	k	int
    //   19	24	4	bool1	boolean
    //   1	17	5	bool2	boolean
    //   9	18	6	arrayOfInt	int[]
    //   52	6	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	15	52	finally
  }
  
  public static int[] getDRMCapabilities()
  {
    try
    {
      int[] arrayOfInt = ZAJ;
      return arrayOfInt;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static void i(HashSet<String> paramHashSet)
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(219385);
        if ((paramHashSet != null) && (paramHashSet.size() > 0))
        {
          paramHashSet = paramHashSet.toArray();
          ZAJ = new int[paramHashSet.length];
          i = 0;
          if (i < paramHashSet.length) {
            if ((paramHashSet[i] instanceof String)) {
              ZAJ[i] = Integer.parseInt((String)paramHashSet[i]);
            } else {
              ZAJ[i] = -1;
            }
          }
        }
      }
      finally {}
      g.i("TPDrmCapability", "TPDrmCapability, read sp ret:" + Arrays.toString(ZAJ));
      AppMethodBeat.o(219385);
      return;
      i += 1;
    }
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(219388);
    g.i("TPDrmCapability", "TPDrmCapability, init");
    if (!TPPlayerMgr.isThumbPlayerEnable())
    {
      AppMethodBeat.o(219388);
      return;
    }
    g.i("TPDrmCapability", "TPDrmCapability, read sp.");
    paramContext = paramContext.getSharedPreferences("DRM_CAP", 0);
    i((HashSet)paramContext.getStringSet("DRM_CAP_LIST", new HashSet()));
    j.getScheduledExecutorServiceInstance().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219380);
        Object localObject = TPThumbplayerCapabilityHelper.getDRMCapabilities();
        g.i("TPDrmCapability", "TPThumbplayerCapabilityHelper, drm cap:" + Arrays.toString((int[])localObject));
        if (localObject.length == 0)
        {
          AppMethodBeat.o(219380);
          return;
        }
        HashSet localHashSet = new HashSet();
        int m = localObject.length;
        int j = 0;
        if (j < m)
        {
          int k = localObject[j];
          int i;
          if (k == 0) {
            i = 0;
          }
          for (;;)
          {
            localHashSet.add(String.valueOf(i));
            j += 1;
            break;
            if (1 == k)
            {
              i = 1;
            }
            else if (2 == k)
            {
              i = 2;
            }
            else
            {
              i = k;
              if (3 == k) {
                i = 3;
              }
            }
          }
        }
        a.j(localHashSet);
        localObject = this.WaK.edit();
        ((SharedPreferences.Editor)localObject).putStringSet("DRM_CAP_LIST", localHashSet);
        ((SharedPreferences.Editor)localObject).apply();
        AppMethodBeat.o(219380);
      }
    });
    AppMethodBeat.o(219388);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */