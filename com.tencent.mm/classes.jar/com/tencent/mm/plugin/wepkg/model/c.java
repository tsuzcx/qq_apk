package com.tencent.mm.plugin.wepkg.model;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.game.commlib.c.a.a;
import com.tencent.mm.plugin.wepkg.b.f;
import com.tencent.mm.plugin.wepkg.utils.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c
{
  private static c EXc = null;
  
  private long W(com.tencent.mm.vfs.k paramk)
  {
    long l2 = 0L;
    AppMethodBeat.i(177088);
    if (paramk == null)
    {
      AppMethodBeat.o(177088);
      return 0L;
    }
    l3 = l2;
    try
    {
      if (!paramk.isDirectory()) {
        break label109;
      }
      l3 = l2;
      paramk = paramk.fTj();
      l3 = l2;
      j = paramk.length;
      i = 0;
    }
    catch (Exception paramk)
    {
      for (;;)
      {
        int j;
        int i;
        com.tencent.mm.vfs.k localk;
        label109:
        long l1 = l3;
        continue;
        i += 1;
      }
    }
    l1 = l2;
    if (i < j)
    {
      localk = paramk[i];
      l3 = l2;
      if (localk.isFile())
      {
        l3 = l2;
        l2 += localk.length();
        break label156;
      }
      l3 = l2;
      l2 += W(localk);
      break label156;
      l1 = l2;
      l3 = l2;
      if (paramk.isFile())
      {
        l3 = l2;
        l1 = paramk.length();
        l1 = 0L + l1;
      }
    }
    AppMethodBeat.o(177088);
    return l1;
  }
  
  public static void aG(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(209390);
    if (ak.cpe())
    {
      aH(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(209390);
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ae.i("MicroMsg.Wepkg.CleanWepkgMgr", "removeWepkgSync fail. can not process on Main thread");
      AppMethodBeat.o(209390);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("ipc_param_pkgid", paramString);
    localBundle.putInt("ipc_param_type", paramInt1);
    localBundle.putInt("ipc_param_reason", paramInt2);
    h.a("com.tencent.mm", localBundle, b.class);
    AppMethodBeat.o(209390);
  }
  
  private static void aH(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(209391);
    if (!ak.cpe())
    {
      ae.i("MicroMsg.Wepkg.CleanWepkgMgr", "removeWepkgInMMSync fail. only run on mm process");
      AppMethodBeat.o(209391);
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ae.i("MicroMsg.Wepkg.CleanWepkgMgr", "removeWepkgInMMSync fail. can not process on Main thread");
      AppMethodBeat.o(209391);
      return;
    }
    ae.i("MicroMsg.Wepkg.CleanWepkgMgr", "removeWepkgInMMSync, pkgid:[%s], type:%d", new Object[] { paramString, Integer.valueOf(paramInt1) });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(209391);
      return;
      f.fbz().fbC();
      gb(d.fbL(), paramInt2);
      AppMethodBeat.o(209391);
      return;
      if (bu.isNullOrNil(paramString))
      {
        AppMethodBeat.o(209391);
        return;
      }
      gb(d.aMe(paramString), paramInt2);
      f.fbz().aLT(paramString);
      com.tencent.mm.plugin.wepkg.b.d.fby().aLT(paramString);
      AppMethodBeat.o(209391);
      return;
      if (bu.isNullOrNil(paramString))
      {
        AppMethodBeat.o(209391);
        return;
      }
      c(d.aMe(paramString), aMd(paramString), paramInt2);
      f.fbz().aLT(paramString);
      com.tencent.mm.plugin.wepkg.b.d.fby().aLT(paramString);
      AppMethodBeat.o(209391);
      return;
      if (bu.isNullOrNil(paramString))
      {
        AppMethodBeat.o(209391);
        return;
      }
      String str = d.aMe(paramString);
      List localList = aMd(paramString);
      paramString = i.aMn(paramString);
      if (paramString != null) {
        localList.add(paramString.version);
      }
      c(str, localList, paramInt2);
    }
  }
  
  private static List aMd(String paramString)
  {
    AppMethodBeat.i(110669);
    ArrayList localArrayList = new ArrayList();
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110669);
      return localArrayList;
    }
    Object localObject = (Bundle)h.a("com.tencent.mm:tools", new IPCString(paramString), c.a.class);
    if (localObject != null)
    {
      localObject = ((Bundle)localObject).getString("used_wepkg_version");
      if (localObject != null) {
        localArrayList.add(localObject);
      }
    }
    paramString = (Bundle)h.a("com.tencent.mm:toolsmp", new IPCString(paramString), c.a.class);
    if (paramString != null)
    {
      paramString = paramString.getString("used_wepkg_version");
      if (paramString != null) {
        localArrayList.add(paramString);
      }
    }
    AppMethodBeat.o(110669);
    return localArrayList;
  }
  
  private static boolean c(String paramString, List paramList, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(209393);
    if (bu.ht(paramList))
    {
      gb(paramString, paramInt);
      AppMethodBeat.o(209393);
      return true;
    }
    paramString = new com.tencent.mm.vfs.k(paramString);
    if ((!paramString.exists()) || (!paramString.isDirectory()))
    {
      AppMethodBeat.o(209393);
      return false;
    }
    paramString = paramString.fTj();
    if (paramString == null)
    {
      AppMethodBeat.o(209393);
      return false;
    }
    int j = paramString.length;
    while (i < j)
    {
      Object localObject = paramString[i];
      if ((localObject != null) && (!paramList.contains(localObject.getName()))) {
        gb(w.B(localObject.fTh()), paramInt);
      }
      i += 1;
    }
    AppMethodBeat.o(209393);
    return true;
  }
  
  /* Error */
  public static c fbI()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 244
    //   5: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 23	com/tencent/mm/plugin/wepkg/model/c:EXc	Lcom/tencent/mm/plugin/wepkg/model/c;
    //   11: ifnonnull +25 -> 36
    //   14: ldc 2
    //   16: monitorenter
    //   17: getstatic 23	com/tencent/mm/plugin/wepkg/model/c:EXc	Lcom/tencent/mm/plugin/wepkg/model/c;
    //   20: ifnonnull +13 -> 33
    //   23: new 2	com/tencent/mm/plugin/wepkg/model/c
    //   26: dup
    //   27: invokespecial 245	com/tencent/mm/plugin/wepkg/model/c:<init>	()V
    //   30: putstatic 23	com/tencent/mm/plugin/wepkg/model/c:EXc	Lcom/tencent/mm/plugin/wepkg/model/c;
    //   33: ldc 2
    //   35: monitorexit
    //   36: getstatic 23	com/tencent/mm/plugin/wepkg/model/c:EXc	Lcom/tencent/mm/plugin/wepkg/model/c;
    //   39: astore_0
    //   40: ldc 244
    //   42: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: ldc 2
    //   47: monitorexit
    //   48: aload_0
    //   49: areturn
    //   50: astore_0
    //   51: ldc 2
    //   53: monitorexit
    //   54: ldc 244
    //   56: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload_0
    //   60: athrow
    //   61: astore_0
    //   62: ldc 2
    //   64: monitorexit
    //   65: aload_0
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   39	10	0	localc	c
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
  
  private static boolean gb(String paramString, int paramInt)
  {
    AppMethodBeat.i(209392);
    try
    {
      ae.i("MicroMsg.Wepkg.CleanWepkgMgr", "Safe delete dir: %s, reason:%d", new Object[] { paramString, Integer.valueOf(paramInt) });
      a.b("WepkgRemove", null, d.aMf(paramString), d.aMg(paramString), paramInt, 0L, null);
      paramString = new com.tencent.mm.vfs.k(paramString);
      Object localObject = paramString.getName() + "_temp";
      localObject = new com.tencent.mm.vfs.k(paramString.getParent(), (String)localObject);
      if (paramString.ag((com.tencent.mm.vfs.k)localObject))
      {
        o.dd(w.B(((com.tencent.mm.vfs.k)localObject).mUri), true);
        AppMethodBeat.o(209392);
        return true;
      }
    }
    catch (Exception paramString)
    {
      ae.i("MicroMsg.Wepkg.CleanWepkgMgr", "safeDeleteDir err:" + paramString.getMessage());
      AppMethodBeat.o(209392);
    }
    return false;
  }
  
  public final void aF(final String paramString, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(209389);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      com.tencent.mm.plugin.wepkg.utils.d.caq().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110660);
          c.aG(paramString, paramInt1, paramInt2);
          AppMethodBeat.o(110660);
        }
      });
      AppMethodBeat.o(209389);
      return;
    }
    aG(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(209389);
  }
  
  /* Error */
  public final void fbJ()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 321
    //   5: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 327	com/tencent/mm/kernel/g:ajR	()Lcom/tencent/mm/kernel/e;
    //   11: invokevirtual 333	com/tencent/mm/kernel/e:ajA	()Lcom/tencent/mm/storage/aj;
    //   14: getstatic 339	com/tencent/mm/storage/am$a:IUH	Lcom/tencent/mm/storage/am$a;
    //   17: lconst_0
    //   18: invokestatic 344	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   21: invokevirtual 350	com/tencent/mm/storage/aj:get	(Lcom/tencent/mm/storage/am$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   24: checkcast 341	java/lang/Long
    //   27: invokestatic 353	com/tencent/mm/sdk/platformtools/bu:i	(Ljava/lang/Long;)J
    //   30: invokestatic 357	com/tencent/mm/sdk/platformtools/bu:rZ	(J)J
    //   33: ldc2_w 358
    //   36: lcmp
    //   37: ifle +55 -> 92
    //   40: invokestatic 327	com/tencent/mm/kernel/g:ajR	()Lcom/tencent/mm/kernel/e;
    //   43: invokevirtual 333	com/tencent/mm/kernel/e:ajA	()Lcom/tencent/mm/storage/aj;
    //   46: getstatic 339	com/tencent/mm/storage/am$a:IUH	Lcom/tencent/mm/storage/am$a;
    //   49: invokestatic 362	com/tencent/mm/sdk/platformtools/bu:aRi	()J
    //   52: invokestatic 344	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   55: invokevirtual 366	com/tencent/mm/storage/aj:set	(Lcom/tencent/mm/storage/am$a;Ljava/lang/Object;)V
    //   58: ldc 85
    //   60: ldc_w 368
    //   63: invokestatic 92	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: invokestatic 374	com/tencent/mm/plugin/game/commlib/c/a:cZE	()Lcom/tencent/mm/plugin/game/commlib/c/a;
    //   69: ldc_w 376
    //   72: new 6	com/tencent/mm/plugin/wepkg/model/c$1
    //   75: dup
    //   76: aload_0
    //   77: invokespecial 379	com/tencent/mm/plugin/wepkg/model/c$1:<init>	(Lcom/tencent/mm/plugin/wepkg/model/c;)V
    //   80: invokevirtual 382	com/tencent/mm/plugin/game/commlib/c/a:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/game/commlib/c/a$a;)V
    //   83: ldc_w 321
    //   86: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: aload_0
    //   90: monitorexit
    //   91: return
    //   92: ldc_w 321
    //   95: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: goto -9 -> 89
    //   101: astore_1
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	c
    //   101	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	89	101	finally
    //   92	98	101	finally
  }
  
  static class b
    implements com.tencent.mm.ipcinvoker.k<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.c
 * JD-Core Version:    0.7.0.1
 */