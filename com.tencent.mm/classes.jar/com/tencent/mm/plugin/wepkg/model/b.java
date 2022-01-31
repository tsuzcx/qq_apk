package com.tencent.mm.plugin.wepkg.model;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class b
{
  private static b vFM = null;
  
  private long U(File paramFile)
  {
    long l2 = 0L;
    AppMethodBeat.i(63511);
    if (paramFile == null)
    {
      AppMethodBeat.o(63511);
      return 0L;
    }
    l3 = l2;
    try
    {
      if (!paramFile.isDirectory()) {
        break label109;
      }
      l3 = l2;
      paramFile = paramFile.listFiles();
      l3 = l2;
      j = paramFile.length;
      i = 0;
    }
    catch (Exception paramFile)
    {
      for (;;)
      {
        int j;
        int i;
        File localFile;
        label109:
        long l1 = l3;
        continue;
        i += 1;
      }
    }
    l1 = l2;
    if (i < j)
    {
      localFile = paramFile[i];
      l3 = l2;
      if (localFile.isFile())
      {
        l3 = l2;
        l2 += localFile.length();
        break label156;
      }
      l3 = l2;
      l2 += U(localFile);
      break label156;
      l1 = l2;
      l3 = l2;
      if (paramFile.isFile())
      {
        l3 = l2;
        l1 = paramFile.length();
        l1 = 0L + l1;
      }
    }
    AppMethodBeat.o(63511);
    return l1;
  }
  
  private static boolean aky(String paramString)
  {
    AppMethodBeat.i(63512);
    try
    {
      ab.i("MicroMsg.Wepkg.CleanWepkgMgr", "Safe delete dir: %s", new Object[] { paramString });
      paramString = new File(paramString);
      Object localObject = paramString.getName() + "_temp";
      localObject = new File(paramString.getParent(), (String)localObject);
      if (paramString.renameTo((File)localObject))
      {
        e.o((File)localObject);
        AppMethodBeat.o(63512);
        return true;
      }
    }
    catch (Exception paramString)
    {
      ab.i("MicroMsg.Wepkg.CleanWepkgMgr", "safeDeleteDir err:" + paramString.getMessage());
      AppMethodBeat.o(63512);
    }
    return false;
  }
  
  /* Error */
  public static b dkA()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 111
    //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 15	com/tencent/mm/plugin/wepkg/model/b:vFM	Lcom/tencent/mm/plugin/wepkg/model/b;
    //   11: ifnonnull +25 -> 36
    //   14: ldc 2
    //   16: monitorenter
    //   17: getstatic 15	com/tencent/mm/plugin/wepkg/model/b:vFM	Lcom/tencent/mm/plugin/wepkg/model/b;
    //   20: ifnonnull +13 -> 33
    //   23: new 2	com/tencent/mm/plugin/wepkg/model/b
    //   26: dup
    //   27: invokespecial 112	com/tencent/mm/plugin/wepkg/model/b:<init>	()V
    //   30: putstatic 15	com/tencent/mm/plugin/wepkg/model/b:vFM	Lcom/tencent/mm/plugin/wepkg/model/b;
    //   33: ldc 2
    //   35: monitorexit
    //   36: getstatic 15	com/tencent/mm/plugin/wepkg/model/b:vFM	Lcom/tencent/mm/plugin/wepkg/model/b;
    //   39: astore_0
    //   40: ldc 111
    //   42: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: ldc 2
    //   47: monitorexit
    //   48: aload_0
    //   49: areturn
    //   50: astore_0
    //   51: ldc 2
    //   53: monitorexit
    //   54: ldc 111
    //   56: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload_0
    //   60: athrow
    //   61: astore_0
    //   62: ldc 2
    //   64: monitorexit
    //   65: aload_0
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   39	10	0	localb	b
    //   50	10	0	localObject1	Object
    //   61	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   17	33	50	finally
    //   33	36	50	finally
    //   51	54	50	finally
    //   3	17	61	finally
    //   36	45	61	finally
    //   54	61	61	finally
  }
  
  public static void ef(String paramString, int paramInt)
  {
    AppMethodBeat.i(63509);
    if (ah.brt())
    {
      eg(paramString, paramInt);
      AppMethodBeat.o(63509);
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ab.i("MicroMsg.Wepkg.CleanWepkgMgr", "removeWepkgSync fail. can not process on Main thread");
      AppMethodBeat.o(63509);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("ipc_param_pkgid", paramString);
    localBundle.putInt("ipc_param_type", paramInt);
    com.tencent.mm.ipcinvoker.f.a("com.tencent.mm", localBundle, b.class);
    AppMethodBeat.o(63509);
  }
  
  private static void eg(String paramString, int paramInt)
  {
    AppMethodBeat.i(63510);
    if (!ah.brt())
    {
      ab.i("MicroMsg.Wepkg.CleanWepkgMgr", "removeWepkgInMMSync fail. only run on mm process");
      AppMethodBeat.o(63510);
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ab.i("MicroMsg.Wepkg.CleanWepkgMgr", "removeWepkgInMMSync fail. can not process on Main thread");
      AppMethodBeat.o(63510);
      return;
    }
    ab.i("MicroMsg.Wepkg.CleanWepkgMgr", "removeWepkgInMMSync, pkgid:[%s], type:%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(63510);
      return;
      com.tencent.mm.plugin.wepkg.b.f.dkq().dku();
      aky(c.vFO);
      AppMethodBeat.o(63510);
      return;
      if (bo.isNullOrNil(paramString))
      {
        AppMethodBeat.o(63510);
        return;
      }
      aky(c.akz(paramString));
      com.tencent.mm.plugin.wepkg.b.f.dkq().akn(paramString);
      com.tencent.mm.plugin.wepkg.b.d.dkp().akn(paramString);
      AppMethodBeat.o(63510);
      return;
      if (bo.isNullOrNil(paramString))
      {
        AppMethodBeat.o(63510);
        return;
      }
      String str = c.akz(paramString);
      Object localObject1 = (Bundle)com.tencent.mm.ipcinvoker.f.a("com.tencent.mm:tools", new IPCString(paramString), b.a.class);
      if (localObject1 == null)
      {
        AppMethodBeat.o(63510);
        return;
      }
      localObject1 = ((Bundle)localObject1).getString("used_wepkg_version");
      Object localObject2 = new ArrayList();
      if (!bo.isNullOrNil((String)localObject1)) {
        ((List)localObject2).add(localObject1);
      }
      u(str, (List)localObject2);
      com.tencent.mm.plugin.wepkg.b.f.dkq().akn(paramString);
      com.tencent.mm.plugin.wepkg.b.d.dkp().akn(paramString);
      AppMethodBeat.o(63510);
      return;
      if (bo.isNullOrNil(paramString))
      {
        AppMethodBeat.o(63510);
        return;
      }
      str = c.akz(paramString);
      localObject1 = (Bundle)com.tencent.mm.ipcinvoker.f.a("com.tencent.mm:tools", new IPCString(paramString), b.a.class);
      if (localObject1 == null)
      {
        AppMethodBeat.o(63510);
        return;
      }
      localObject2 = ((Bundle)localObject1).getString("used_wepkg_version");
      localObject1 = new ArrayList();
      if (!bo.isNullOrNil((String)localObject2)) {
        ((List)localObject1).add(localObject2);
      }
      paramString = h.akF(paramString);
      if (paramString != null) {
        ((List)localObject1).add(paramString.version);
      }
      u(str, (List)localObject1);
    }
  }
  
  private static boolean u(String paramString, List paramList)
  {
    int i = 0;
    AppMethodBeat.i(63513);
    if (bo.es(paramList))
    {
      aky(paramString);
      AppMethodBeat.o(63513);
      return true;
    }
    paramString = new File(paramString);
    if ((!paramString.exists()) || (!paramString.isDirectory()))
    {
      AppMethodBeat.o(63513);
      return false;
    }
    paramString = paramString.listFiles();
    if (paramString == null)
    {
      AppMethodBeat.o(63513);
      return false;
    }
    int j = paramString.length;
    while (i < j)
    {
      Object localObject = paramString[i];
      if ((localObject != null) && (!paramList.contains(localObject.getName()))) {
        aky(localObject.getAbsolutePath());
      }
      i += 1;
    }
    AppMethodBeat.o(63513);
    return true;
  }
  
  public final void dkB()
  {
    try
    {
      AppMethodBeat.i(63507);
      com.tencent.mm.plugin.wepkg.utils.d.aNS().ac(new b.1(this));
      AppMethodBeat.o(63507);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void ee(String paramString, int paramInt)
  {
    AppMethodBeat.i(63508);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      com.tencent.mm.plugin.wepkg.utils.d.aNS().ac(new b.3(this, paramString, paramInt));
      AppMethodBeat.o(63508);
      return;
    }
    ef(paramString, paramInt);
    AppMethodBeat.o(63508);
  }
  
  static class b
    implements i<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.b
 * JD-Core Version:    0.7.0.1
 */