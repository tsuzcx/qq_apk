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
  private static c BIy = null;
  
  private static boolean A(String paramString, List paramList)
  {
    int i = 0;
    AppMethodBeat.i(110671);
    if (bt.gL(paramList))
    {
      azS(paramString);
      AppMethodBeat.o(110671);
      return true;
    }
    paramString = new e(paramString);
    if ((!paramString.exists()) || (!paramString.isDirectory()))
    {
      AppMethodBeat.o(110671);
      return false;
    }
    paramString = paramString.fhW();
    if (paramString == null)
    {
      AppMethodBeat.o(110671);
      return false;
    }
    int j = paramString.length;
    while (i < j)
    {
      Object localObject = paramString[i];
      if ((localObject != null) && (!paramList.contains(localObject.getName()))) {
        azS(q.B(localObject.fhU()));
      }
      i += 1;
    }
    AppMethodBeat.o(110671);
    return true;
  }
  
  private long V(e parame)
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
      parame = parame.fhW();
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
      l2 += V(locale);
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
  
  private static List azR(String paramString)
  {
    AppMethodBeat.i(110669);
    ArrayList localArrayList = new ArrayList();
    if (bt.isNullOrNil(paramString))
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
  
  private static boolean azS(String paramString)
  {
    AppMethodBeat.i(110670);
    try
    {
      ad.i("MicroMsg.Wepkg.CleanWepkgMgr", "Safe delete dir: %s", new Object[] { paramString });
      paramString = new e(paramString);
      Object localObject = paramString.getName() + "_temp";
      localObject = new e(paramString.getParent(), (String)localObject);
      if (paramString.af((e)localObject))
      {
        com.tencent.mm.vfs.i.cO(q.B(((e)localObject).mUri), true);
        AppMethodBeat.o(110670);
        return true;
      }
    }
    catch (Exception paramString)
    {
      ad.i("MicroMsg.Wepkg.CleanWepkgMgr", "safeDeleteDir err:" + paramString.getMessage());
      AppMethodBeat.o(110670);
    }
    return false;
  }
  
  /* Error */
  public static c etK()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 187
    //   5: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 24	com/tencent/mm/plugin/wepkg/model/c:BIy	Lcom/tencent/mm/plugin/wepkg/model/c;
    //   11: ifnonnull +25 -> 36
    //   14: ldc 2
    //   16: monitorenter
    //   17: getstatic 24	com/tencent/mm/plugin/wepkg/model/c:BIy	Lcom/tencent/mm/plugin/wepkg/model/c;
    //   20: ifnonnull +13 -> 33
    //   23: new 2	com/tencent/mm/plugin/wepkg/model/c
    //   26: dup
    //   27: invokespecial 188	com/tencent/mm/plugin/wepkg/model/c:<init>	()V
    //   30: putstatic 24	com/tencent/mm/plugin/wepkg/model/c:BIy	Lcom/tencent/mm/plugin/wepkg/model/c;
    //   33: ldc 2
    //   35: monitorexit
    //   36: getstatic 24	com/tencent/mm/plugin/wepkg/model/c:BIy	Lcom/tencent/mm/plugin/wepkg/model/c;
    //   39: astore_0
    //   40: ldc 187
    //   42: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: ldc 2
    //   47: monitorexit
    //   48: aload_0
    //   49: areturn
    //   50: astore_0
    //   51: ldc 2
    //   53: monitorexit
    //   54: ldc 187
    //   56: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static void fo(String paramString, int paramInt)
  {
    AppMethodBeat.i(110666);
    if (aj.cbv())
    {
      fp(paramString, paramInt);
      AppMethodBeat.o(110666);
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ad.i("MicroMsg.Wepkg.CleanWepkgMgr", "removeWepkgSync fail. can not process on Main thread");
      AppMethodBeat.o(110666);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("ipc_param_pkgid", paramString);
    localBundle.putInt("ipc_param_type", paramInt);
    h.a("com.tencent.mm", localBundle, b.class);
    AppMethodBeat.o(110666);
  }
  
  private static void fp(String paramString, int paramInt)
  {
    AppMethodBeat.i(110667);
    if (!aj.cbv())
    {
      ad.i("MicroMsg.Wepkg.CleanWepkgMgr", "removeWepkgInMMSync fail. only run on mm process");
      AppMethodBeat.o(110667);
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ad.i("MicroMsg.Wepkg.CleanWepkgMgr", "removeWepkgInMMSync fail. can not process on Main thread");
      AppMethodBeat.o(110667);
      return;
    }
    ad.i("MicroMsg.Wepkg.CleanWepkgMgr", "removeWepkgInMMSync, pkgid:[%s], type:%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(110667);
      return;
      f.etA().etD();
      azS(d.etN());
      AppMethodBeat.o(110667);
      return;
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(110667);
        return;
      }
      azS(d.azT(paramString));
      f.etA().azG(paramString);
      com.tencent.mm.plugin.wepkg.b.d.etz().azG(paramString);
      AppMethodBeat.o(110667);
      return;
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(110667);
        return;
      }
      A(d.azT(paramString), azR(paramString));
      f.etA().azG(paramString);
      com.tencent.mm.plugin.wepkg.b.d.etz().azG(paramString);
      AppMethodBeat.o(110667);
      return;
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(110667);
        return;
      }
      String str = d.azT(paramString);
      List localList = azR(paramString);
      paramString = i.azZ(paramString);
      if (paramString != null) {
        localList.add(paramString.version);
      }
      A(str, localList);
    }
  }
  
  /* Error */
  public final void etL()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 287
    //   5: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 293	com/tencent/mm/kernel/g:afB	()Lcom/tencent/mm/kernel/e;
    //   11: invokevirtual 299	com/tencent/mm/kernel/e:afk	()Lcom/tencent/mm/storage/ab;
    //   14: getstatic 305	com/tencent/mm/storage/ae$a:Fqb	Lcom/tencent/mm/storage/ae$a;
    //   17: lconst_0
    //   18: invokestatic 310	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   21: invokevirtual 316	com/tencent/mm/storage/ab:get	(Lcom/tencent/mm/storage/ae$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   24: checkcast 307	java/lang/Long
    //   27: invokestatic 320	com/tencent/mm/sdk/platformtools/bt:f	(Ljava/lang/Long;)J
    //   30: invokestatic 324	com/tencent/mm/sdk/platformtools/bt:lZ	(J)J
    //   33: ldc2_w 325
    //   36: lcmp
    //   37: ifle +55 -> 92
    //   40: invokestatic 293	com/tencent/mm/kernel/g:afB	()Lcom/tencent/mm/kernel/e;
    //   43: invokevirtual 299	com/tencent/mm/kernel/e:afk	()Lcom/tencent/mm/storage/ab;
    //   46: getstatic 305	com/tencent/mm/storage/ae$a:Fqb	Lcom/tencent/mm/storage/ae$a;
    //   49: invokestatic 329	com/tencent/mm/sdk/platformtools/bt:aGK	()J
    //   52: invokestatic 310	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   55: invokevirtual 333	com/tencent/mm/storage/ab:set	(Lcom/tencent/mm/storage/ae$a;Ljava/lang/Object;)V
    //   58: ldc 137
    //   60: ldc_w 335
    //   63: invokestatic 184	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: invokestatic 341	com/tencent/mm/plugin/game/commlib/c/a:cBs	()Lcom/tencent/mm/plugin/game/commlib/c/a;
    //   69: ldc_w 343
    //   72: new 6	com/tencent/mm/plugin/wepkg/model/c$1
    //   75: dup
    //   76: aload_0
    //   77: invokespecial 346	com/tencent/mm/plugin/wepkg/model/c$1:<init>	(Lcom/tencent/mm/plugin/wepkg/model/c;)V
    //   80: invokevirtual 349	com/tencent/mm/plugin/game/commlib/c/a:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/game/commlib/c/a$a;)V
    //   83: ldc_w 287
    //   86: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: aload_0
    //   90: monitorexit
    //   91: return
    //   92: ldc_w 287
    //   95: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final void fn(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(110665);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      com.tencent.mm.plugin.wepkg.utils.d.bNl().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110660);
          c.fo(paramString, paramInt);
          AppMethodBeat.o(110660);
        }
      });
      AppMethodBeat.o(110665);
      return;
    }
    fo(paramString, paramInt);
    AppMethodBeat.o(110665);
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