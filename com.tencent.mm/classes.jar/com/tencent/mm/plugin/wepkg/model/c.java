package com.tencent.mm.plugin.wepkg.model;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.plugin.game.commlib.c.a.a;
import com.tencent.mm.plugin.wepkg.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c
{
  private static c QMm = null;
  
  public static void aK(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194628);
    if (MMApplicationContext.isMMProcess())
    {
      aL(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(194628);
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      Log.i("MicroMsg.Wepkg.CleanWepkgMgr", "removeWepkgSync fail. can not process on Main thread");
      AppMethodBeat.o(194628);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("ipc_param_pkgid", paramString);
    localBundle.putInt("ipc_param_type", paramInt1);
    localBundle.putInt("ipc_param_reason", paramInt2);
    com.tencent.mm.ipcinvoker.j.a(MainProcessIPCService.PROCESS_NAME, localBundle, b.class);
    AppMethodBeat.o(194628);
  }
  
  private static void aL(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194633);
    if (!MMApplicationContext.isMMProcess())
    {
      Log.i("MicroMsg.Wepkg.CleanWepkgMgr", "removeWepkgInMMSync fail. only run on mm process");
      AppMethodBeat.o(194633);
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      Log.i("MicroMsg.Wepkg.CleanWepkgMgr", "removeWepkgInMMSync fail. can not process on Main thread");
      AppMethodBeat.o(194633);
      return;
    }
    Log.i("MicroMsg.Wepkg.CleanWepkgMgr", "removeWepkgInMMSync, pkgid:[%s], type:%d", new Object[] { paramString, Integer.valueOf(paramInt1) });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(194633);
      return;
      f.hew().hez();
      hi(e.heI(), paramInt2);
      AppMethodBeat.o(194633);
      return;
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(194633);
        return;
      }
      hi(e.box(paramString), paramInt2);
      f.hew().bol(paramString);
      com.tencent.mm.plugin.wepkg.b.d.hev().bol(paramString);
      AppMethodBeat.o(194633);
      return;
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(194633);
        return;
      }
      d(e.box(paramString), bow(paramString), paramInt2);
      f.hew().bol(paramString);
      com.tencent.mm.plugin.wepkg.b.d.hev().bol(paramString);
      AppMethodBeat.o(194633);
      return;
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(194633);
        return;
      }
      String str = e.box(paramString);
      List localList = bow(paramString);
      paramString = j.boG(paramString);
      if (paramString != null) {
        localList.add(paramString.version);
      }
      d(str, localList, paramInt2);
    }
  }
  
  private long aa(q paramq)
  {
    long l2 = 0L;
    AppMethodBeat.i(177088);
    if (paramq == null)
    {
      AppMethodBeat.o(177088);
      return 0L;
    }
    l3 = l2;
    try
    {
      if (!paramq.isDirectory()) {
        break label109;
      }
      l3 = l2;
      paramq = paramq.ifJ();
      l3 = l2;
      j = paramq.length;
      i = 0;
    }
    catch (Exception paramq)
    {
      for (;;)
      {
        int j;
        int i;
        q localq;
        label109:
        long l1 = l3;
        continue;
        i += 1;
      }
    }
    l1 = l2;
    if (i < j)
    {
      localq = paramq[i];
      l3 = l2;
      if (localq.ifH())
      {
        l3 = l2;
        l2 += localq.length();
        break label156;
      }
      l3 = l2;
      l2 += aa(localq);
      break label156;
      l1 = l2;
      l3 = l2;
      if (paramq.ifH())
      {
        l3 = l2;
        l1 = paramq.length();
        l1 = 0L + l1;
      }
    }
    AppMethodBeat.o(177088);
    return l1;
  }
  
  private static List bow(String paramString)
  {
    AppMethodBeat.i(110669);
    ArrayList localArrayList = new ArrayList();
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110669);
      return localArrayList;
    }
    Object localObject = (Bundle)com.tencent.mm.ipcinvoker.j.a(ToolsProcessIPCService.PROCESS_NAME, new IPCString(paramString), a.class);
    if (localObject != null)
    {
      localObject = ((Bundle)localObject).getString("used_wepkg_version");
      if (localObject != null) {
        localArrayList.add(localObject);
      }
    }
    paramString = (Bundle)com.tencent.mm.ipcinvoker.j.a(ToolsMpProcessIPCService.PROCESS_NAME, new IPCString(paramString), a.class);
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
  
  private static boolean d(String paramString, List paramList, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(194648);
    if (Util.isNullOrNil(paramList))
    {
      hi(paramString, paramInt);
      AppMethodBeat.o(194648);
      return true;
    }
    paramString = new q(paramString);
    if ((!paramString.ifE()) || (!paramString.isDirectory()))
    {
      AppMethodBeat.o(194648);
      return false;
    }
    paramString = paramString.ifJ();
    if (paramString == null)
    {
      AppMethodBeat.o(194648);
      return false;
    }
    int j = paramString.length;
    while (i < j)
    {
      Object localObject = paramString[i];
      if ((localObject != null) && (!paramList.contains(localObject.getName()))) {
        hi(localObject.bOF(), paramInt);
      }
      i += 1;
    }
    AppMethodBeat.o(194648);
    return true;
  }
  
  /* Error */
  public static c heF()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 241
    //   5: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 24	com/tencent/mm/plugin/wepkg/model/c:QMm	Lcom/tencent/mm/plugin/wepkg/model/c;
    //   11: ifnonnull +25 -> 36
    //   14: ldc 2
    //   16: monitorenter
    //   17: getstatic 24	com/tencent/mm/plugin/wepkg/model/c:QMm	Lcom/tencent/mm/plugin/wepkg/model/c;
    //   20: ifnonnull +13 -> 33
    //   23: new 2	com/tencent/mm/plugin/wepkg/model/c
    //   26: dup
    //   27: invokespecial 242	com/tencent/mm/plugin/wepkg/model/c:<init>	()V
    //   30: putstatic 24	com/tencent/mm/plugin/wepkg/model/c:QMm	Lcom/tencent/mm/plugin/wepkg/model/c;
    //   33: ldc 2
    //   35: monitorexit
    //   36: getstatic 24	com/tencent/mm/plugin/wepkg/model/c:QMm	Lcom/tencent/mm/plugin/wepkg/model/c;
    //   39: astore_0
    //   40: ldc 241
    //   42: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: ldc 2
    //   47: monitorexit
    //   48: aload_0
    //   49: areturn
    //   50: astore_0
    //   51: ldc 2
    //   53: monitorexit
    //   54: ldc 241
    //   56: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   3	17	61	finally
    //   36	45	61	finally
    //   51	61	61	finally
  }
  
  private static boolean hi(String paramString, int paramInt)
  {
    AppMethodBeat.i(194643);
    try
    {
      Log.i("MicroMsg.Wepkg.CleanWepkgMgr", "Safe delete dir: %s, reason:%d", new Object[] { paramString, Integer.valueOf(paramInt) });
      com.tencent.mm.plugin.wepkg.utils.a.b("WepkgRemove", null, e.boy(paramString), e.boz(paramString), paramInt, 0L, null);
      paramString = new q(paramString);
      Object localObject = paramString.getName() + "_temp";
      localObject = new q(paramString.ifA(), (String)localObject);
      if (paramString.aj((q)localObject))
      {
        u.deleteDir(((q)localObject).getPath());
        AppMethodBeat.o(194643);
        return true;
      }
    }
    catch (Exception paramString)
    {
      Log.i("MicroMsg.Wepkg.CleanWepkgMgr", "safeDeleteDir err:" + paramString.getMessage());
      AppMethodBeat.o(194643);
    }
    return false;
  }
  
  public final void aJ(final String paramString, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(194626);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      com.tencent.mm.plugin.wepkg.utils.d.cMC().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110660);
          c.aK(paramString, paramInt1, paramInt2);
          AppMethodBeat.o(110660);
        }
      });
      AppMethodBeat.o(194626);
      return;
    }
    aK(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(194626);
  }
  
  /* Error */
  public final void heG()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 316
    //   5: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 322	com/tencent/mm/kernel/h:aHG	()Lcom/tencent/mm/kernel/f;
    //   11: invokevirtual 328	com/tencent/mm/kernel/f:aHp	()Lcom/tencent/mm/storage/ao;
    //   14: getstatic 334	com/tencent/mm/storage/ar$a:Vrc	Lcom/tencent/mm/storage/ar$a;
    //   17: lconst_0
    //   18: invokestatic 339	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   21: invokevirtual 345	com/tencent/mm/storage/ao:get	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   24: checkcast 336	java/lang/Long
    //   27: invokestatic 349	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/Long;)J
    //   30: invokestatic 353	com/tencent/mm/sdk/platformtools/Util:secondsToNow	(J)J
    //   33: ldc2_w 354
    //   36: lcmp
    //   37: ifle +55 -> 92
    //   40: invokestatic 322	com/tencent/mm/kernel/h:aHG	()Lcom/tencent/mm/kernel/f;
    //   43: invokevirtual 328	com/tencent/mm/kernel/f:aHp	()Lcom/tencent/mm/storage/ao;
    //   46: getstatic 334	com/tencent/mm/storage/ar$a:Vrc	Lcom/tencent/mm/storage/ar$a;
    //   49: invokestatic 358	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
    //   52: invokestatic 339	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   55: invokevirtual 362	com/tencent/mm/storage/ao:set	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)V
    //   58: ldc 66
    //   60: ldc_w 364
    //   63: invokestatic 73	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: invokestatic 370	com/tencent/mm/plugin/game/commlib/c/a:ewo	()Lcom/tencent/mm/plugin/game/commlib/c/a;
    //   69: ldc_w 372
    //   72: new 6	com/tencent/mm/plugin/wepkg/model/c$1
    //   75: dup
    //   76: aload_0
    //   77: invokespecial 375	com/tencent/mm/plugin/wepkg/model/c$1:<init>	(Lcom/tencent/mm/plugin/wepkg/model/c;)V
    //   80: invokevirtual 378	com/tencent/mm/plugin/game/commlib/c/a:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/game/commlib/c/a$a;)V
    //   83: ldc_w 316
    //   86: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: aload_0
    //   90: monitorexit
    //   91: return
    //   92: ldc_w 316
    //   95: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  @com.tencent.mm.ipcinvoker.c.a
  static class a
    implements m<IPCString, Bundle>
  {}
  
  @com.tencent.mm.ipcinvoker.c.a
  static class b
    implements m<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.c
 * JD-Core Version:    0.7.0.1
 */