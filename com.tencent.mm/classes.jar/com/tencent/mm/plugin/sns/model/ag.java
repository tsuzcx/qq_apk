package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.j.d;
import com.tencent.mm.plugin.sns.j.e;
import com.tencent.mm.plugin.sns.j.f;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.dzi;
import com.tencent.mm.protocal.protobuf.dzj;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public final class ag
{
  private d DJX;
  private List<Integer> DJY;
  private Map<String, Integer> DJZ;
  private List<Integer> DKa;
  private Map<Integer, Integer> DKb;
  String gna;
  private String path;
  
  public ag(String paramString)
  {
    AppMethodBeat.i(95722);
    this.gna = "";
    this.DJY = new Vector();
    this.DJZ = new HashMap();
    this.DKa = new Vector();
    this.DKb = new HashMap();
    this.path = paramString;
    if (!fap()) {
      this.DJX = new d();
    }
    this.DJY.clear();
    this.DJZ.clear();
    AppMethodBeat.o(95722);
  }
  
  private static void a(long paramLong, LinkedList<e> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(95735);
    a(paramLong, paramLinkedList, paramString, false);
    AppMethodBeat.o(95735);
  }
  
  private static boolean a(long paramLong, LinkedList<e> paramLinkedList, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(95736);
    Iterator localIterator = paramLinkedList.iterator();
    e locale2;
    do
    {
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        locale2 = (e)localIterator.next();
      } while (locale2.DIb.Id != paramLong);
      locale1 = locale2;
      if (paramBoolean) {
        break;
      }
    } while (!locale2.DRR.equals(paramString));
    for (e locale1 = locale2;; locale1 = null)
    {
      if (locale1 != null)
      {
        paramLinkedList.remove(locale1);
        AppMethodBeat.o(95736);
        return true;
      }
      AppMethodBeat.o(95736);
      return false;
    }
  }
  
  private static boolean a(LinkedList<dzo> paramLinkedList, String paramString, int paramInt)
  {
    AppMethodBeat.i(95728);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(95728);
      return true;
    }
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      dzo localdzo = (dzo)paramLinkedList.next();
      if ((paramString.equals(localdzo.iAc)) && (paramInt == localdzo.CreateTime))
      {
        AppMethodBeat.o(95728);
        return true;
      }
    }
    AppMethodBeat.o(95728);
    return false;
  }
  
  public static boolean aPg(String paramString)
  {
    AppMethodBeat.i(95721);
    if (paramString == null)
    {
      AppMethodBeat.o(95721);
      return false;
    }
    if (paramString.startsWith("_AD_TAG_"))
    {
      AppMethodBeat.o(95721);
      return true;
    }
    AppMethodBeat.o(95721);
    return false;
  }
  
  public static dzo b(dzj paramdzj)
  {
    AppMethodBeat.i(95730);
    dzi localdzi = paramdzj.MZb;
    paramdzj = paramdzj.MZc;
    dzo localdzo = new dzo();
    localdzo.iAc = localdzi.iAc;
    localdzo.CreateTime = localdzi.CreateTime;
    localdzo.Nickname = localdzi.MYQ;
    localdzo.xub = localdzi.xub;
    localdzo.oUv = localdzi.oUv;
    localdzo.Username = localdzi.MKC;
    localdzo.MYT = localdzi.MYT;
    localdzo.MYV = localdzi.MYV;
    localdzo.MYX = localdzi.MYX;
    localdzo.MZm = paramdzj.MKC;
    localdzo.MYU = paramdzj.MYU;
    localdzo.MYS = paramdzj.MYS;
    localdzo.MYY = localdzi.MYY;
    localdzo.MYZ = localdzi.MYZ;
    AppMethodBeat.o(95730);
    return localdzo;
  }
  
  private static boolean bp(LinkedList<e> paramLinkedList)
  {
    AppMethodBeat.i(95724);
    while (!paramLinkedList.isEmpty())
    {
      e locale = (e)paramLinkedList.getFirst();
      if (Util.secondsToNow(locale.DRS) > 21600L)
      {
        paramLinkedList.removeFirst();
      }
      else
      {
        if (aPg(locale.DRR))
        {
          g.aAi();
          g.aAg().hqi.a(new k(locale.DIb, locale.DRR, locale.DRT, 0), 0);
        }
        for (;;)
        {
          AppMethodBeat.o(95724);
          return true;
          g.aAi();
          g.aAg().hqi.a(new p(locale.DIb, locale.DRR), 0);
        }
      }
    }
    AppMethodBeat.o(95724);
    return false;
  }
  
  private boolean fao()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(95739);
        try
        {
          byte[] arrayOfByte = this.DJX.toByteArray();
          if (com.tencent.mm.vfs.s.f(this.path, arrayOfByte, arrayOfByte.length) != 0) {
            continue;
          }
          bool = true;
          AppMethodBeat.o(95739);
        }
        catch (IOException localIOException)
        {
          Log.printErrStackTrace("MicroMsg.SnsAsyncQueueMgr", localIOException, "listToFile failed: " + this.path, new Object[0]);
          com.tencent.mm.vfs.s.deleteFile(this.path);
          AppMethodBeat.o(95739);
          boolean bool = false;
          continue;
        }
        return bool;
      }
      finally {}
      AppMethodBeat.o(95739);
      bool = false;
    }
  }
  
  private boolean fap()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(95740);
        arrayOfByte = com.tencent.mm.vfs.s.aW(this.path, 0, -1);
        if (arrayOfByte != null) {
          continue;
        }
        AppMethodBeat.o(95740);
        bool = false;
      }
      finally
      {
        try
        {
          byte[] arrayOfByte;
          this.DJX = ((d)new d().parseFrom(arrayOfByte));
          bool = true;
          AppMethodBeat.o(95740);
        }
        catch (IOException localIOException)
        {
          Log.printErrStackTrace("MicroMsg.SnsAsyncQueueMgr", localIOException, "", new Object[0]);
          com.tencent.mm.vfs.s.deleteFile(this.path);
          AppMethodBeat.o(95740);
          boolean bool = false;
        }
        localObject = finally;
      }
      return bool;
    }
  }
  
  private void j(long paramLong, int paramInt, String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(95734);
        switch (paramInt)
        {
        case 4: 
        case 6: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
          fao();
          AppMethodBeat.o(95734);
          return;
        }
      }
      finally {}
      a(paramLong, this.DJX.DRL, paramString);
      continue;
      a(paramLong, this.DJX.DRM, paramString);
      continue;
      a(paramLong, this.DJX.DRL, paramString);
      continue;
      a(paramLong, this.DJX.DRM, paramString);
      continue;
      a(paramLong, this.DJX.DRN, paramString);
      continue;
      a(paramLong, this.DJX.DRO, paramString);
    }
  }
  
  /* Error */
  public final boolean Jq(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 340
    //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 59	com/tencent/mm/plugin/sns/model/ag:DJX	Lcom/tencent/mm/plugin/sns/j/d;
    //   12: getfield 343	com/tencent/mm/plugin/sns/j/d:DRP	Ljava/util/LinkedList;
    //   15: invokevirtual 86	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   18: astore 4
    //   20: aload 4
    //   22: invokeinterface 91 1 0
    //   27: ifeq +33 -> 60
    //   30: aload 4
    //   32: invokeinterface 95 1 0
    //   37: checkcast 345	com/tencent/mm/plugin/sns/j/f
    //   40: getfield 348	com/tencent/mm/plugin/sns/j/f:DRU	J
    //   43: lload_1
    //   44: lcmp
    //   45: ifne -25 -> 20
    //   48: iconst_0
    //   49: istore_3
    //   50: ldc_w 340
    //   53: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: aload_0
    //   57: monitorexit
    //   58: iload_3
    //   59: ireturn
    //   60: iconst_1
    //   61: istore_3
    //   62: ldc_w 340
    //   65: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: goto -12 -> 56
    //   71: astore 4
    //   73: aload_0
    //   74: monitorexit
    //   75: aload 4
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	ag
    //   0	78	1	paramLong	long
    //   49	13	3	bool	boolean
    //   18	13	4	localIterator	Iterator
    //   71	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	71	finally
    //   20	48	71	finally
    //   50	56	71	finally
    //   62	68	71	finally
  }
  
  public final void Jr(long paramLong)
  {
    try
    {
      AppMethodBeat.i(95726);
      f localf = new f();
      localf.DRU = paramLong;
      localf.DRS = ((int)Util.nowSecond());
      this.DJX.DRP.add(localf);
      fao();
      AppMethodBeat.o(95726);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final void Js(long paramLong)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(95727);
        Iterator localIterator = this.DJX.DRP.iterator();
        if (localIterator.hasNext())
        {
          f localf = (f)localIterator.next();
          if (localf.DRU != paramLong) {
            continue;
          }
          if (localf != null) {
            this.DJX.DRP.remove(localf);
          }
          fao();
          AppMethodBeat.o(95727);
          return;
        }
      }
      finally {}
      Object localObject2 = null;
    }
  }
  
  /* Error */
  public final boolean Jt(long paramLong)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 364
    //   7: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: new 345	com/tencent/mm/plugin/sns/j/f
    //   13: dup
    //   14: invokespecial 352	com/tencent/mm/plugin/sns/j/f:<init>	()V
    //   17: astore 4
    //   19: aload 4
    //   21: lload_1
    //   22: putfield 348	com/tencent/mm/plugin/sns/j/f:DRU	J
    //   25: aload 4
    //   27: invokestatic 356	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
    //   30: l2i
    //   31: putfield 357	com/tencent/mm/plugin/sns/j/f:DRS	I
    //   34: aload_0
    //   35: getfield 59	com/tencent/mm/plugin/sns/model/ag:DJX	Lcom/tencent/mm/plugin/sns/j/d;
    //   38: getfield 367	com/tencent/mm/plugin/sns/j/d:DRQ	Ljava/util/LinkedList;
    //   41: aload 4
    //   43: invokevirtual 360	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   46: pop
    //   47: aload_0
    //   48: invokespecial 323	com/tencent/mm/plugin/sns/model/ag:fao	()Z
    //   51: pop
    //   52: lload_1
    //   53: aload_0
    //   54: getfield 59	com/tencent/mm/plugin/sns/model/ag:DJX	Lcom/tencent/mm/plugin/sns/j/d;
    //   57: getfield 326	com/tencent/mm/plugin/sns/j/d:DRL	Ljava/util/LinkedList;
    //   60: ldc 32
    //   62: iconst_1
    //   63: invokestatic 77	com/tencent/mm/plugin/sns/model/ag:a	(JLjava/util/LinkedList;Ljava/lang/String;Z)Z
    //   66: ifne +13 -> 79
    //   69: ldc_w 364
    //   72: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: aload_0
    //   76: monitorexit
    //   77: iload_3
    //   78: ireturn
    //   79: iconst_0
    //   80: istore_3
    //   81: ldc_w 364
    //   84: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: goto -12 -> 75
    //   90: astore 4
    //   92: aload_0
    //   93: monitorexit
    //   94: aload 4
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	ag
    //   0	97	1	paramLong	long
    //   1	80	3	bool	boolean
    //   17	25	4	localf	f
    //   90	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	75	90	finally
    //   81	87	90	finally
  }
  
  final boolean Ju(long paramLong)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(95738);
        Iterator localIterator = this.DJX.DRQ.iterator();
        if (!localIterator.hasNext()) {
          break label99;
        }
        f localf = (f)localIterator.next();
        if (localf.DRU != paramLong) {
          continue;
        }
        if (localf != null)
        {
          this.DJX.DRQ.remove(localf);
          bool = true;
          fao();
          AppMethodBeat.o(95738);
          return bool;
        }
      }
      finally {}
      boolean bool = false;
      continue;
      label99:
      Object localObject2 = null;
    }
  }
  
  public final boolean Yt(int paramInt)
  {
    try
    {
      AppMethodBeat.i(95741);
      boolean bool = this.DJY.contains(Integer.valueOf(paramInt));
      AppMethodBeat.o(95741);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final boolean Yu(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 383
    //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 39	com/tencent/mm/plugin/sns/model/ag:DJY	Ljava/util/List;
    //   12: iload_1
    //   13: invokestatic 378	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16: invokeinterface 381 2 0
    //   21: ifeq +15 -> 36
    //   24: iconst_0
    //   25: istore_2
    //   26: ldc_w 383
    //   29: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: monitorexit
    //   34: iload_2
    //   35: ireturn
    //   36: aload_0
    //   37: getfield 39	com/tencent/mm/plugin/sns/model/ag:DJY	Ljava/util/List;
    //   40: iload_1
    //   41: invokestatic 378	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   44: invokeinterface 384 2 0
    //   49: pop
    //   50: iconst_1
    //   51: istore_2
    //   52: ldc_w 383
    //   55: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: goto -26 -> 32
    //   61: astore_3
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_3
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	ag
    //   0	66	1	paramInt	int
    //   25	27	2	bool	boolean
    //   61	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	24	61	finally
    //   26	32	61	finally
    //   36	50	61	finally
    //   52	58	61	finally
  }
  
  public final boolean Yv(int paramInt)
  {
    try
    {
      AppMethodBeat.i(95743);
      this.DJY.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(95743);
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final boolean Yw(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 389
    //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 46	com/tencent/mm/plugin/sns/model/ag:DKa	Ljava/util/List;
    //   12: iload_1
    //   13: invokestatic 378	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16: invokeinterface 381 2 0
    //   21: ifeq +15 -> 36
    //   24: iconst_0
    //   25: istore_2
    //   26: ldc_w 389
    //   29: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: monitorexit
    //   34: iload_2
    //   35: ireturn
    //   36: aload_0
    //   37: getfield 46	com/tencent/mm/plugin/sns/model/ag:DKa	Ljava/util/List;
    //   40: iload_1
    //   41: invokestatic 378	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   44: invokeinterface 384 2 0
    //   49: pop
    //   50: iconst_1
    //   51: istore_2
    //   52: ldc_w 389
    //   55: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: goto -26 -> 32
    //   61: astore_3
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_3
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	ag
    //   0	66	1	paramInt	int
    //   25	27	2	bool	boolean
    //   61	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	24	61	finally
    //   26	32	61	finally
    //   36	50	61	finally
    //   52	58	61	finally
  }
  
  public final boolean Yx(int paramInt)
  {
    try
    {
      AppMethodBeat.i(95749);
      this.DKa.remove(Integer.valueOf(paramInt));
      this.DKb.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(95749);
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean Yy(int paramInt)
  {
    try
    {
      AppMethodBeat.i(95751);
      this.DKb.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(95751);
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final int Yz(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 399
    //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 48	com/tencent/mm/plugin/sns/model/ag:DKb	Ljava/util/Map;
    //   12: iload_1
    //   13: invokestatic 378	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16: invokeinterface 402 2 0
    //   21: ifeq +33 -> 54
    //   24: aload_0
    //   25: getfield 48	com/tencent/mm/plugin/sns/model/ag:DKb	Ljava/util/Map;
    //   28: iload_1
    //   29: invokestatic 378	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   32: invokeinterface 405 2 0
    //   37: checkcast 374	java/lang/Integer
    //   40: invokevirtual 409	java/lang/Integer:intValue	()I
    //   43: istore_1
    //   44: ldc_w 399
    //   47: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_0
    //   51: monitorexit
    //   52: iload_1
    //   53: ireturn
    //   54: iconst_m1
    //   55: istore_1
    //   56: ldc_w 399
    //   59: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: goto -12 -> 50
    //   65: astore_2
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_2
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	ag
    //   0	70	1	paramInt	int
    //   65	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	50	65	finally
    //   56	62	65	finally
  }
  
  public final boolean a(String paramString, dzj paramdzj)
  {
    AppMethodBeat.i(95731);
    boolean bool = a(paramString, paramdzj, "");
    AppMethodBeat.o(95731);
    return bool;
  }
  
  public final boolean a(String paramString1, dzj paramdzj, String paramString2)
  {
    boolean bool2 = true;
    for (;;)
    {
      e locale;
      try
      {
        AppMethodBeat.i(95732);
        locale = new e();
        locale.DRR = paramString1;
        locale.DIb = paramdzj;
        locale.DRS = ((int)Util.nowSecond());
        locale.DRT = paramString2;
        bool1 = bool2;
        switch (paramdzj.MZb.oUv)
        {
        case 4: 
        case 6: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
          if (!fao()) {
            Log.e("MicroMsg.SnsAsyncQueueMgr", "error listToFile");
          }
          AppMethodBeat.o(95732);
          return bool1;
        }
      }
      finally {}
      this.DJX.DRL.add(locale);
      boolean bool1 = bool2;
      if (Ju(paramdzj.Id))
      {
        bool1 = false;
        continue;
        this.DJX.DRM.add(locale);
        bool1 = bool2;
        continue;
        this.DJX.DRL.add(locale);
        bool1 = bool2;
        if (Ju(paramdzj.Id))
        {
          bool1 = false;
          continue;
          this.DJX.DRM.add(locale);
          bool1 = bool2;
          continue;
          this.DJX.DRN.add(locale);
          bool1 = bool2;
          continue;
          this.DJX.DRO.add(locale);
          bool1 = bool2;
          continue;
          bool1 = bool2;
        }
      }
    }
  }
  
  /* Error */
  public final boolean aPh(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 426
    //   7: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: getfield 44	com/tencent/mm/plugin/sns/model/ag:DJZ	Ljava/util/Map;
    //   14: aload_1
    //   15: invokeinterface 402 2 0
    //   20: ifeq +13 -> 33
    //   23: ldc_w 426
    //   26: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: iload_2
    //   32: ireturn
    //   33: aload_0
    //   34: getfield 44	com/tencent/mm/plugin/sns/model/ag:DJZ	Ljava/util/Map;
    //   37: aload_1
    //   38: iconst_0
    //   39: invokestatic 378	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   42: invokeinterface 430 3 0
    //   47: pop
    //   48: iconst_1
    //   49: istore_2
    //   50: ldc_w 426
    //   53: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: goto -27 -> 29
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	ag
    //   0	64	1	paramString	String
    //   1	49	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	29	59	finally
    //   33	48	59	finally
    //   50	56	59	finally
  }
  
  public final boolean aPi(String paramString)
  {
    try
    {
      AppMethodBeat.i(95746);
      this.DJZ.remove(paramString);
      AppMethodBeat.o(95746);
      return true;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final SnsObject d(SnsObject paramSnsObject)
  {
    long l;
    Iterator localIterator;
    Object localObject1;
    Object localObject2;
    try
    {
      AppMethodBeat.i(95729);
      if (Util.isNullOrNil(this.gna)) {
        this.gna = z.aTY();
      }
      if ((this.DJX.DRL.size() == 0) && (this.DJX.DRM.size() == 0))
      {
        AppMethodBeat.o(95729);
        return paramSnsObject;
      }
      l = paramSnsObject.Id;
      localIterator = this.DJX.DRL.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (e)localIterator.next();
        localObject2 = b(((e)localObject1).DIb);
        if ((((e)localObject1).DIb.Id == l) && (!a(paramSnsObject.LikeUserList, ((dzo)localObject2).iAc, ((dzo)localObject2).CreateTime)))
        {
          paramSnsObject.LikeUserList.add(localObject2);
          paramSnsObject.LikeCount += 1;
        }
      }
      localIterator = paramSnsObject.LikeUserList.iterator();
    }
    finally {}
    label180:
    int i;
    while (localIterator.hasNext())
    {
      localObject1 = (dzo)localIterator.next();
      if (((dzo)localObject1).Username.equals(this.gna))
      {
        i = 0;
        localObject2 = this.DJX.DRQ.iterator();
        label231:
        if (!((Iterator)localObject2).hasNext()) {
          break label396;
        }
        if (((f)((Iterator)localObject2).next()).DRU != l) {
          break label393;
        }
        paramSnsObject.LikeUserList.remove(localObject1);
        paramSnsObject.LikeCount -= 1;
        i = 1;
        break label393;
      }
    }
    for (;;)
    {
      localIterator = this.DJX.DRM.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (e)localIterator.next();
        if (((e)localObject1).DIb.Id == l)
        {
          localObject1 = b(((e)localObject1).DIb);
          if (!a(paramSnsObject.CommentUserList, ((dzo)localObject1).iAc, ((dzo)localObject1).CreateTime))
          {
            paramSnsObject.CommentUserList.add(localObject1);
            paramSnsObject.CommentCount += 1;
          }
        }
      }
      AppMethodBeat.o(95729);
      break;
      label393:
      break label231;
      label396:
      if (i == 0) {
        break label180;
      }
    }
  }
  
  public final void fan()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(95723);
        if (bp(this.DJX.DRL))
        {
          AppMethodBeat.o(95723);
          return;
        }
        if (bp(this.DJX.DRM))
        {
          AppMethodBeat.o(95723);
          continue;
        }
        if (!bp(this.DJX.DRN)) {
          break label79;
        }
      }
      finally {}
      AppMethodBeat.o(95723);
      continue;
      label79:
      if (bp(this.DJX.DRO))
      {
        AppMethodBeat.o(95723);
      }
      else
      {
        f localf;
        long l;
        for (;;)
        {
          if (!this.DJX.DRP.isEmpty())
          {
            localf = (f)this.DJX.DRP.getFirst();
            if (Util.secondsToNow(localf.DRS) > 21600L)
            {
              this.DJX.DRP.removeFirst();
            }
            else
            {
              l = localf.DRU;
              g.aAi();
              g.aAg().hqi.a(new s(l, 1), 0);
              AppMethodBeat.o(95723);
              break;
            }
          }
        }
        for (;;)
        {
          if (!this.DJX.DRQ.isEmpty())
          {
            localf = (f)this.DJX.DRQ.getFirst();
            if (Util.secondsToNow(localf.DRS) > 21600L)
            {
              this.DJX.DRQ.removeFirst();
            }
            else
            {
              l = localf.DRU;
              g.aAi();
              g.aAg().hqi.a(new s(l, 5), 0);
              AppMethodBeat.o(95723);
              break;
            }
          }
        }
        AppMethodBeat.o(95723);
      }
    }
  }
  
  public final int faq()
  {
    try
    {
      AppMethodBeat.i(95747);
      int i = this.DJZ.size();
      AppMethodBeat.o(95747);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void i(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(95733);
    an.fbo();
    j(paramLong, paramInt, paramString);
    AppMethodBeat.o(95733);
  }
  
  public final boolean isDownloading(String paramString)
  {
    try
    {
      AppMethodBeat.i(95744);
      boolean bool = this.DJZ.containsKey(paramString);
      AppMethodBeat.o(95744);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final boolean iv(int paramInt1, int paramInt2)
  {
    try
    {
      AppMethodBeat.i(95750);
      this.DKb.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      AppMethodBeat.o(95750);
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ag
 * JD-Core Version:    0.7.0.1
 */