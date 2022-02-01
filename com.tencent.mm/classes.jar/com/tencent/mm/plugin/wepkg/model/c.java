package com.tencent.mm.plugin.wepkg.model;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.game.commlib.c.a.a;
import com.tencent.mm.plugin.wepkg.b.f;
import com.tencent.mm.plugin.wepkg.utils.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c
{
  private static c EEG = null;
  
  private long W(e parame)
  {
    long l2 = 0L;
    AppMethodBeat.i(177088);
    if (parame == null)
    {
      AppMethodBeat.o(177088);
      return 0L;
    }
    l3 = l2;
    try
    {
      if (!parame.isDirectory()) {
        break label109;
      }
      l3 = l2;
      parame = parame.fOM();
      l3 = l2;
      j = parame.length;
      i = 0;
    }
    catch (Exception parame)
    {
      for (;;)
      {
        int j;
        int i;
        e locale;
        label109:
        long l1 = l3;
        continue;
        i += 1;
      }
    }
    l1 = l2;
    if (i < j)
    {
      locale = parame[i];
      l3 = l2;
      if (locale.isFile())
      {
        l3 = l2;
        l2 += locale.length();
        break label156;
      }
      l3 = l2;
      l2 += W(locale);
      break label156;
      l1 = l2;
      l3 = l2;
      if (parame.isFile())
      {
        l3 = l2;
        l1 = parame.length();
        l1 = 0L + l1;
      }
    }
    AppMethodBeat.o(177088);
    return l1;
  }
  
  public static void aE(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(214462);
    if (aj.cnC())
    {
      aF(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(214462);
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ad.i("MicroMsg.Wepkg.CleanWepkgMgr", "removeWepkgSync fail. can not process on Main thread");
      AppMethodBeat.o(214462);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("ipc_param_pkgid", paramString);
    localBundle.putInt("ipc_param_type", paramInt1);
    localBundle.putInt("ipc_param_reason", paramInt2);
    h.a("com.tencent.mm", localBundle, b.class);
    AppMethodBeat.o(214462);
  }
  
  private static void aF(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(214463);
    if (!aj.cnC())
    {
      ad.i("MicroMsg.Wepkg.CleanWepkgMgr", "removeWepkgInMMSync fail. only run on mm process");
      AppMethodBeat.o(214463);
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ad.i("MicroMsg.Wepkg.CleanWepkgMgr", "removeWepkgInMMSync fail. can not process on Main thread");
      AppMethodBeat.o(214463);
      return;
    }
    ad.i("MicroMsg.Wepkg.CleanWepkgMgr", "removeWepkgInMMSync, pkgid:[%s], type:%d", new Object[] { paramString, Integer.valueOf(paramInt1) });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(214463);
      return;
      f.eXN().eXQ();
      fS(d.eXZ(), paramInt2);
      AppMethodBeat.o(214463);
      return;
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(214463);
        return;
      }
      fS(d.aKI(paramString), paramInt2);
      f.eXN().aKx(paramString);
      com.tencent.mm.plugin.wepkg.b.d.eXM().aKx(paramString);
      AppMethodBeat.o(214463);
      return;
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(214463);
        return;
      }
      c(d.aKI(paramString), aKH(paramString), paramInt2);
      f.eXN().aKx(paramString);
      com.tencent.mm.plugin.wepkg.b.d.eXM().aKx(paramString);
      AppMethodBeat.o(214463);
      return;
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(214463);
        return;
      }
      String str = d.aKI(paramString);
      List localList = aKH(paramString);
      paramString = i.aKR(paramString);
      if (paramString != null) {
        localList.add(paramString.version);
      }
      c(str, localList, paramInt2);
    }
  }
  
  private static List aKH(String paramString)
  {
    AppMethodBeat.i(110669);
    ArrayList localArrayList = new ArrayList();
    if (bt.isNullOrNil(paramString))
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
    AppMethodBeat.i(214465);
    if (bt.hj(paramList))
    {
      fS(paramString, paramInt);
      AppMethodBeat.o(214465);
      return true;
    }
    paramString = new e(paramString);
    if ((!paramString.exists()) || (!paramString.isDirectory()))
    {
      AppMethodBeat.o(214465);
      return false;
    }
    paramString = paramString.fOM();
    if (paramString == null)
    {
      AppMethodBeat.o(214465);
      return false;
    }
    int j = paramString.length;
    while (i < j)
    {
      Object localObject = paramString[i];
      if ((localObject != null) && (!paramList.contains(localObject.getName()))) {
        fS(q.B(localObject.fOK()), paramInt);
      }
      i += 1;
    }
    AppMethodBeat.o(214465);
    return true;
  }
  
  /* Error */
  public static c eXW()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 244
    //   5: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 23	com/tencent/mm/plugin/wepkg/model/c:EEG	Lcom/tencent/mm/plugin/wepkg/model/c;
    //   11: ifnonnull +25 -> 36
    //   14: ldc 2
    //   16: monitorenter
    //   17: getstatic 23	com/tencent/mm/plugin/wepkg/model/c:EEG	Lcom/tencent/mm/plugin/wepkg/model/c;
    //   20: ifnonnull +13 -> 33
    //   23: new 2	com/tencent/mm/plugin/wepkg/model/c
    //   26: dup
    //   27: invokespecial 245	com/tencent/mm/plugin/wepkg/model/c:<init>	()V
    //   30: putstatic 23	com/tencent/mm/plugin/wepkg/model/c:EEG	Lcom/tencent/mm/plugin/wepkg/model/c;
    //   33: ldc 2
    //   35: monitorexit
    //   36: getstatic 23	com/tencent/mm/plugin/wepkg/model/c:EEG	Lcom/tencent/mm/plugin/wepkg/model/c;
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
  
  private static boolean fS(String paramString, int paramInt)
  {
    AppMethodBeat.i(214464);
    try
    {
      ad.i("MicroMsg.Wepkg.CleanWepkgMgr", "Safe delete dir: %s, reason:%d", new Object[] { paramString, Integer.valueOf(paramInt) });
      a.b("WepkgRemove", null, d.aKJ(paramString), d.aKK(paramString), paramInt, 0L, null);
      paramString = new e(paramString);
      Object localObject = paramString.getName() + "_temp";
      localObject = new e(paramString.getParent(), (String)localObject);
      if (paramString.ag((e)localObject))
      {
        com.tencent.mm.vfs.i.cZ(q.B(((e)localObject).mUri), true);
        AppMethodBeat.o(214464);
        return true;
      }
    }
    catch (Exception paramString)
    {
      ad.i("MicroMsg.Wepkg.CleanWepkgMgr", "safeDeleteDir err:" + paramString.getMessage());
      AppMethodBeat.o(214464);
    }
    return false;
  }
  
  public final void aD(final String paramString, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(214461);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      com.tencent.mm.plugin.wepkg.utils.d.bZb().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110660);
          c.aE(paramString, paramInt1, paramInt2);
          AppMethodBeat.o(110660);
        }
      });
      AppMethodBeat.o(214461);
      return;
    }
    aE(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(214461);
  }
  
  /* Error */
  public final void eXX()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 321
    //   5: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 327	com/tencent/mm/kernel/g:ajC	()Lcom/tencent/mm/kernel/e;
    //   11: invokevirtual 333	com/tencent/mm/kernel/e:ajl	()Lcom/tencent/mm/storage/ai;
    //   14: getstatic 339	com/tencent/mm/storage/al$a:IAi	Lcom/tencent/mm/storage/al$a;
    //   17: lconst_0
    //   18: invokestatic 344	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   21: invokevirtual 350	com/tencent/mm/storage/ai:get	(Lcom/tencent/mm/storage/al$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   24: checkcast 341	java/lang/Long
    //   27: invokestatic 354	com/tencent/mm/sdk/platformtools/bt:g	(Ljava/lang/Long;)J
    //   30: invokestatic 358	com/tencent/mm/sdk/platformtools/bt:rM	(J)J
    //   33: ldc2_w 359
    //   36: lcmp
    //   37: ifle +55 -> 92
    //   40: invokestatic 327	com/tencent/mm/kernel/g:ajC	()Lcom/tencent/mm/kernel/e;
    //   43: invokevirtual 333	com/tencent/mm/kernel/e:ajl	()Lcom/tencent/mm/storage/ai;
    //   46: getstatic 339	com/tencent/mm/storage/al$a:IAi	Lcom/tencent/mm/storage/al$a;
    //   49: invokestatic 363	com/tencent/mm/sdk/platformtools/bt:aQJ	()J
    //   52: invokestatic 344	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   55: invokevirtual 367	com/tencent/mm/storage/ai:set	(Lcom/tencent/mm/storage/al$a;Ljava/lang/Object;)V
    //   58: ldc 85
    //   60: ldc_w 369
    //   63: invokestatic 92	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: invokestatic 375	com/tencent/mm/plugin/game/commlib/c/a:cWX	()Lcom/tencent/mm/plugin/game/commlib/c/a;
    //   69: ldc_w 377
    //   72: new 6	com/tencent/mm/plugin/wepkg/model/c$1
    //   75: dup
    //   76: aload_0
    //   77: invokespecial 380	com/tencent/mm/plugin/wepkg/model/c$1:<init>	(Lcom/tencent/mm/plugin/wepkg/model/c;)V
    //   80: invokevirtual 383	com/tencent/mm/plugin/game/commlib/c/a:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/game/commlib/c/a$a;)V
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
    implements k<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.c
 * JD-Core Version:    0.7.0.1
 */