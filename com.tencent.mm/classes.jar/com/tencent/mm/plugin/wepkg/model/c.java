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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c
{
  private static c DaH = null;
  
  private long U(e parame)
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
      parame = parame.fxX();
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
      l2 += U(locale);
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
  
  public static void aA(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199875);
    if (ai.ciE())
    {
      aB(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(199875);
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ac.i("MicroMsg.Wepkg.CleanWepkgMgr", "removeWepkgSync fail. can not process on Main thread");
      AppMethodBeat.o(199875);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("ipc_param_pkgid", paramString);
    localBundle.putInt("ipc_param_type", paramInt1);
    localBundle.putInt("ipc_param_reason", paramInt2);
    h.a("com.tencent.mm", localBundle, b.class);
    AppMethodBeat.o(199875);
  }
  
  private static void aB(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199876);
    if (!ai.ciE())
    {
      ac.i("MicroMsg.Wepkg.CleanWepkgMgr", "removeWepkgInMMSync fail. only run on mm process");
      AppMethodBeat.o(199876);
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ac.i("MicroMsg.Wepkg.CleanWepkgMgr", "removeWepkgInMMSync fail. can not process on Main thread");
      AppMethodBeat.o(199876);
      return;
    }
    ac.i("MicroMsg.Wepkg.CleanWepkgMgr", "removeWepkgInMMSync, pkgid:[%s], type:%d", new Object[] { paramString, Integer.valueOf(paramInt1) });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(199876);
      return;
      f.eIT().eIW();
      fv(d.eJg(), paramInt2);
      AppMethodBeat.o(199876);
      return;
      if (bs.isNullOrNil(paramString))
      {
        AppMethodBeat.o(199876);
        return;
      }
      fv(d.aFj(paramString), paramInt2);
      f.eIT().aEX(paramString);
      com.tencent.mm.plugin.wepkg.b.d.eIS().aEX(paramString);
      AppMethodBeat.o(199876);
      return;
      if (bs.isNullOrNil(paramString))
      {
        AppMethodBeat.o(199876);
        return;
      }
      c(d.aFj(paramString), aFi(paramString), paramInt2);
      f.eIT().aEX(paramString);
      com.tencent.mm.plugin.wepkg.b.d.eIS().aEX(paramString);
      AppMethodBeat.o(199876);
      return;
      if (bs.isNullOrNil(paramString))
      {
        AppMethodBeat.o(199876);
        return;
      }
      String str = d.aFj(paramString);
      List localList = aFi(paramString);
      paramString = i.aFr(paramString);
      if (paramString != null) {
        localList.add(paramString.version);
      }
      c(str, localList, paramInt2);
    }
  }
  
  private static List aFi(String paramString)
  {
    AppMethodBeat.i(110669);
    ArrayList localArrayList = new ArrayList();
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110669);
      return localArrayList;
    }
    Object localObject = (Bundle)h.a("com.tencent.mm:tools", new IPCString(paramString), a.class);
    if (localObject != null)
    {
      localObject = ((Bundle)localObject).getString("used_wepkg_version");
      if (localObject != null) {
        localArrayList.add(localObject);
      }
    }
    paramString = (Bundle)h.a("com.tencent.mm:toolsmp", new IPCString(paramString), a.class);
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
    AppMethodBeat.i(199878);
    if (bs.gY(paramList))
    {
      fv(paramString, paramInt);
      AppMethodBeat.o(199878);
      return true;
    }
    paramString = new e(paramString);
    if ((!paramString.exists()) || (!paramString.isDirectory()))
    {
      AppMethodBeat.o(199878);
      return false;
    }
    paramString = paramString.fxX();
    if (paramString == null)
    {
      AppMethodBeat.o(199878);
      return false;
    }
    int j = paramString.length;
    while (i < j)
    {
      Object localObject = paramString[i];
      if ((localObject != null) && (!paramList.contains(localObject.getName()))) {
        fv(q.B(localObject.fxV()), paramInt);
      }
      i += 1;
    }
    AppMethodBeat.o(199878);
    return true;
  }
  
  /* Error */
  public static c eJd()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 244
    //   5: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 24	com/tencent/mm/plugin/wepkg/model/c:DaH	Lcom/tencent/mm/plugin/wepkg/model/c;
    //   11: ifnonnull +25 -> 36
    //   14: ldc 2
    //   16: monitorenter
    //   17: getstatic 24	com/tencent/mm/plugin/wepkg/model/c:DaH	Lcom/tencent/mm/plugin/wepkg/model/c;
    //   20: ifnonnull +13 -> 33
    //   23: new 2	com/tencent/mm/plugin/wepkg/model/c
    //   26: dup
    //   27: invokespecial 245	com/tencent/mm/plugin/wepkg/model/c:<init>	()V
    //   30: putstatic 24	com/tencent/mm/plugin/wepkg/model/c:DaH	Lcom/tencent/mm/plugin/wepkg/model/c;
    //   33: ldc 2
    //   35: monitorexit
    //   36: getstatic 24	com/tencent/mm/plugin/wepkg/model/c:DaH	Lcom/tencent/mm/plugin/wepkg/model/c;
    //   39: astore_0
    //   40: ldc 244
    //   42: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: ldc 2
    //   47: monitorexit
    //   48: aload_0
    //   49: areturn
    //   50: astore_0
    //   51: ldc 2
    //   53: monitorexit
    //   54: ldc 244
    //   56: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private static boolean fv(String paramString, int paramInt)
  {
    AppMethodBeat.i(199877);
    try
    {
      ac.i("MicroMsg.Wepkg.CleanWepkgMgr", "Safe delete dir: %s, reason:%d", new Object[] { paramString, Integer.valueOf(paramInt) });
      a.b("WepkgRemove", null, d.aFk(paramString), d.aFl(paramString), paramInt, 0L, null);
      paramString = new e(paramString);
      Object localObject = paramString.getName() + "_temp";
      localObject = new e(paramString.getParent(), (String)localObject);
      if (paramString.ae((e)localObject))
      {
        com.tencent.mm.vfs.i.cU(q.B(((e)localObject).mUri), true);
        AppMethodBeat.o(199877);
        return true;
      }
    }
    catch (Exception paramString)
    {
      ac.i("MicroMsg.Wepkg.CleanWepkgMgr", "safeDeleteDir err:" + paramString.getMessage());
      AppMethodBeat.o(199877);
    }
    return false;
  }
  
  public final void az(final String paramString, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(199874);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      com.tencent.mm.plugin.wepkg.utils.d.bUw().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110660);
          c.aA(paramString, paramInt1, paramInt2);
          AppMethodBeat.o(110660);
        }
      });
      AppMethodBeat.o(199874);
      return;
    }
    aA(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(199874);
  }
  
  /* Error */
  public final void eJe()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 321
    //   5: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 327	com/tencent/mm/kernel/g:agR	()Lcom/tencent/mm/kernel/e;
    //   11: invokevirtual 333	com/tencent/mm/kernel/e:agA	()Lcom/tencent/mm/storage/ae;
    //   14: getstatic 339	com/tencent/mm/storage/ah$a:GNR	Lcom/tencent/mm/storage/ah$a;
    //   17: lconst_0
    //   18: invokestatic 344	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   21: invokevirtual 350	com/tencent/mm/storage/ae:get	(Lcom/tencent/mm/storage/ah$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   24: checkcast 341	java/lang/Long
    //   27: invokestatic 354	com/tencent/mm/sdk/platformtools/bs:g	(Ljava/lang/Long;)J
    //   30: invokestatic 358	com/tencent/mm/sdk/platformtools/bs:pN	(J)J
    //   33: ldc2_w 359
    //   36: lcmp
    //   37: ifle +55 -> 92
    //   40: invokestatic 327	com/tencent/mm/kernel/g:agR	()Lcom/tencent/mm/kernel/e;
    //   43: invokevirtual 333	com/tencent/mm/kernel/e:agA	()Lcom/tencent/mm/storage/ae;
    //   46: getstatic 339	com/tencent/mm/storage/ah$a:GNR	Lcom/tencent/mm/storage/ah$a;
    //   49: invokestatic 363	com/tencent/mm/sdk/platformtools/bs:aNx	()J
    //   52: invokestatic 344	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   55: invokevirtual 367	com/tencent/mm/storage/ae:set	(Lcom/tencent/mm/storage/ah$a;Ljava/lang/Object;)V
    //   58: ldc 85
    //   60: ldc_w 369
    //   63: invokestatic 92	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: invokestatic 375	com/tencent/mm/plugin/game/commlib/c/a:cOB	()Lcom/tencent/mm/plugin/game/commlib/c/a;
    //   69: ldc_w 377
    //   72: new 6	com/tencent/mm/plugin/wepkg/model/c$1
    //   75: dup
    //   76: aload_0
    //   77: invokespecial 380	com/tencent/mm/plugin/wepkg/model/c$1:<init>	(Lcom/tencent/mm/plugin/wepkg/model/c;)V
    //   80: invokevirtual 383	com/tencent/mm/plugin/game/commlib/c/a:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/game/commlib/c/a$a;)V
    //   83: ldc_w 321
    //   86: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: aload_0
    //   90: monitorexit
    //   91: return
    //   92: ldc_w 321
    //   95: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  static class a
    implements k<IPCString, Bundle>
  {}
  
  static class b
    implements k<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.c
 * JD-Core Version:    0.7.0.1
 */