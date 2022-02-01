package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.j.d;
import com.tencent.mm.plugin.sns.j.e;
import com.tencent.mm.plugin.sns.j.f;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.eji;
import com.tencent.mm.protocal.protobuf.ejj;
import com.tencent.mm.protocal.protobuf.ejo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public final class ag
{
  private d JWZ;
  private List<Integer> JXa;
  private Map<String, Integer> JXb;
  private List<Integer> JXc;
  private Map<Integer, Integer> JXd;
  String iRj;
  private String path;
  
  public ag(String paramString)
  {
    AppMethodBeat.i(95722);
    this.iRj = "";
    this.JXa = new Vector();
    this.JXb = new HashMap();
    this.JXc = new Vector();
    this.JXd = new HashMap();
    this.path = paramString;
    if (!fOj()) {
      this.JWZ = new d();
    }
    this.JXa.clear();
    this.JXb.clear();
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
      } while (locale2.JVa.Id != paramLong);
      locale1 = locale2;
      if (paramBoolean) {
        break;
      }
    } while (!locale2.KeY.equals(paramString));
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
  
  private static boolean a(LinkedList<ejo> paramLinkedList, String paramString, int paramInt)
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
      ejo localejo = (ejo)paramLinkedList.next();
      if ((paramString.equals(localejo.lpy)) && (paramInt == localejo.CreateTime))
      {
        AppMethodBeat.o(95728);
        return true;
      }
    }
    AppMethodBeat.o(95728);
    return false;
  }
  
  public static ejo b(ejj paramejj)
  {
    AppMethodBeat.i(95730);
    eji localeji = paramejj.Ulv;
    paramejj = paramejj.Ulw;
    ejo localejo = new ejo();
    localejo.lpy = localeji.lpy;
    localejo.CreateTime = localeji.CreateTime;
    localejo.Nickname = localeji.Ulk;
    localejo.Cqs = localeji.Cqs;
    localejo.rWu = localeji.rWu;
    localejo.Username = localeji.TWw;
    localejo.Uln = localeji.Uln;
    localejo.Ulp = localeji.Ulp;
    localejo.Ulr = localeji.Ulr;
    localejo.UlG = paramejj.TWw;
    localejo.Ulo = paramejj.Ulo;
    localejo.Ulm = paramejj.Ulm;
    localejo.Uls = localeji.Uls;
    localejo.Ult = localeji.Ult;
    AppMethodBeat.o(95730);
    return localejo;
  }
  
  private static boolean bJ(LinkedList<e> paramLinkedList)
  {
    AppMethodBeat.i(95724);
    while (!paramLinkedList.isEmpty())
    {
      e locale = (e)paramLinkedList.getFirst();
      if (Util.secondsToNow(locale.KeZ) > 21600L)
      {
        paramLinkedList.removeFirst();
      }
      else
      {
        if (bab(locale.KeY))
        {
          h.aHH();
          h.aHF().kcd.a(new k(locale.JVa, locale.KeY, locale.Kfa, 0), 0);
        }
        for (;;)
        {
          AppMethodBeat.o(95724);
          return true;
          h.aHH();
          h.aHF().kcd.a(new p(locale.JVa, locale.KeY), 0);
        }
      }
    }
    AppMethodBeat.o(95724);
    return false;
  }
  
  public static boolean bab(String paramString)
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
  
  private boolean fOi()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(95739);
        try
        {
          byte[] arrayOfByte = this.JWZ.toByteArray();
          if (u.f(this.path, arrayOfByte, arrayOfByte.length) != 0) {
            continue;
          }
          bool = true;
          AppMethodBeat.o(95739);
        }
        catch (IOException localIOException)
        {
          Log.printErrStackTrace("MicroMsg.SnsAsyncQueueMgr", localIOException, "listToFile failed: " + this.path, new Object[0]);
          u.deleteFile(this.path);
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
  
  private boolean fOj()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(95740);
        arrayOfByte = u.aY(this.path, 0, -1);
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
          this.JWZ = ((d)new d().parseFrom(arrayOfByte));
          bool = true;
          AppMethodBeat.o(95740);
        }
        catch (IOException localIOException)
        {
          Log.printErrStackTrace("MicroMsg.SnsAsyncQueueMgr", localIOException, "", new Object[0]);
          u.deleteFile(this.path);
          AppMethodBeat.o(95740);
          boolean bool = false;
        }
        localObject = finally;
      }
      return bool;
    }
  }
  
  private void i(long paramLong, int paramInt, String paramString)
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
          fOi();
          AppMethodBeat.o(95734);
          return;
        }
      }
      finally {}
      a(paramLong, this.JWZ.KeS, paramString);
      continue;
      a(paramLong, this.JWZ.KeT, paramString);
      continue;
      a(paramLong, this.JWZ.KeS, paramString);
      continue;
      a(paramLong, this.JWZ.KeT, paramString);
      continue;
      a(paramLong, this.JWZ.KeU, paramString);
      continue;
      a(paramLong, this.JWZ.KeV, paramString);
    }
  }
  
  /* Error */
  public final boolean QJ(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 339
    //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 59	com/tencent/mm/plugin/sns/model/ag:JWZ	Lcom/tencent/mm/plugin/sns/j/d;
    //   12: getfield 342	com/tencent/mm/plugin/sns/j/d:KeW	Ljava/util/LinkedList;
    //   15: invokevirtual 86	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   18: astore 4
    //   20: aload 4
    //   22: invokeinterface 91 1 0
    //   27: ifeq +33 -> 60
    //   30: aload 4
    //   32: invokeinterface 95 1 0
    //   37: checkcast 344	com/tencent/mm/plugin/sns/j/f
    //   40: getfield 347	com/tencent/mm/plugin/sns/j/f:Kfb	J
    //   43: lload_1
    //   44: lcmp
    //   45: ifne -25 -> 20
    //   48: iconst_0
    //   49: istore_3
    //   50: ldc_w 339
    //   53: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: aload_0
    //   57: monitorexit
    //   58: iload_3
    //   59: ireturn
    //   60: iconst_1
    //   61: istore_3
    //   62: ldc_w 339
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
  
  public final void QK(long paramLong)
  {
    try
    {
      AppMethodBeat.i(95726);
      f localf = new f();
      localf.Kfb = paramLong;
      localf.KeZ = ((int)Util.nowSecond());
      this.JWZ.KeW.add(localf);
      fOi();
      AppMethodBeat.o(95726);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final void QL(long paramLong)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(95727);
        Iterator localIterator = this.JWZ.KeW.iterator();
        if (localIterator.hasNext())
        {
          f localf = (f)localIterator.next();
          if (localf.Kfb != paramLong) {
            continue;
          }
          if (localf != null) {
            this.JWZ.KeW.remove(localf);
          }
          fOi();
          AppMethodBeat.o(95727);
          return;
        }
      }
      finally {}
      Object localObject2 = null;
    }
  }
  
  /* Error */
  public final boolean QM(long paramLong)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 363
    //   7: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: new 344	com/tencent/mm/plugin/sns/j/f
    //   13: dup
    //   14: invokespecial 351	com/tencent/mm/plugin/sns/j/f:<init>	()V
    //   17: astore 4
    //   19: aload 4
    //   21: lload_1
    //   22: putfield 347	com/tencent/mm/plugin/sns/j/f:Kfb	J
    //   25: aload 4
    //   27: invokestatic 355	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
    //   30: l2i
    //   31: putfield 356	com/tencent/mm/plugin/sns/j/f:KeZ	I
    //   34: aload_0
    //   35: getfield 59	com/tencent/mm/plugin/sns/model/ag:JWZ	Lcom/tencent/mm/plugin/sns/j/d;
    //   38: getfield 366	com/tencent/mm/plugin/sns/j/d:KeX	Ljava/util/LinkedList;
    //   41: aload 4
    //   43: invokevirtual 359	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   46: pop
    //   47: aload_0
    //   48: invokespecial 322	com/tencent/mm/plugin/sns/model/ag:fOi	()Z
    //   51: pop
    //   52: lload_1
    //   53: aload_0
    //   54: getfield 59	com/tencent/mm/plugin/sns/model/ag:JWZ	Lcom/tencent/mm/plugin/sns/j/d;
    //   57: getfield 325	com/tencent/mm/plugin/sns/j/d:KeS	Ljava/util/LinkedList;
    //   60: ldc 32
    //   62: iconst_1
    //   63: invokestatic 77	com/tencent/mm/plugin/sns/model/ag:a	(JLjava/util/LinkedList;Ljava/lang/String;Z)Z
    //   66: ifne +13 -> 79
    //   69: ldc_w 363
    //   72: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: aload_0
    //   76: monitorexit
    //   77: iload_3
    //   78: ireturn
    //   79: iconst_0
    //   80: istore_3
    //   81: ldc_w 363
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
  
  final boolean QN(long paramLong)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(95738);
        Iterator localIterator = this.JWZ.KeX.iterator();
        if (!localIterator.hasNext()) {
          break label99;
        }
        f localf = (f)localIterator.next();
        if (localf.Kfb != paramLong) {
          continue;
        }
        if (localf != null)
        {
          this.JWZ.KeX.remove(localf);
          bool = true;
          fOi();
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
  
  public final boolean a(String paramString, ejj paramejj)
  {
    AppMethodBeat.i(95731);
    boolean bool = a(paramString, paramejj, "");
    AppMethodBeat.o(95731);
    return bool;
  }
  
  public final boolean a(String paramString1, ejj paramejj, String paramString2)
  {
    boolean bool2 = true;
    for (;;)
    {
      e locale;
      try
      {
        AppMethodBeat.i(95732);
        locale = new e();
        locale.KeY = paramString1;
        locale.JVa = paramejj;
        locale.KeZ = ((int)Util.nowSecond());
        locale.Kfa = paramString2;
        bool1 = bool2;
        switch (paramejj.Ulv.rWu)
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
          if (!fOi()) {
            Log.e("MicroMsg.SnsAsyncQueueMgr", "error listToFile");
          }
          AppMethodBeat.o(95732);
          return bool1;
        }
      }
      finally {}
      this.JWZ.KeS.add(locale);
      boolean bool1 = bool2;
      if (QN(paramejj.Id))
      {
        bool1 = false;
        continue;
        this.JWZ.KeT.add(locale);
        bool1 = bool2;
        continue;
        this.JWZ.KeS.add(locale);
        bool1 = bool2;
        if (QN(paramejj.Id))
        {
          bool1 = false;
          continue;
          this.JWZ.KeT.add(locale);
          bool1 = bool2;
          continue;
          this.JWZ.KeU.add(locale);
          bool1 = bool2;
          continue;
          this.JWZ.KeV.add(locale);
          bool1 = bool2;
          continue;
          bool1 = bool2;
        }
      }
    }
  }
  
  public final boolean afL(int paramInt)
  {
    try
    {
      AppMethodBeat.i(95741);
      boolean bool = this.JXa.contains(Integer.valueOf(paramInt));
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
  public final boolean afM(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 397
    //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 39	com/tencent/mm/plugin/sns/model/ag:JXa	Ljava/util/List;
    //   12: iload_1
    //   13: invokestatic 392	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16: invokeinterface 395 2 0
    //   21: ifeq +15 -> 36
    //   24: iconst_0
    //   25: istore_2
    //   26: ldc_w 397
    //   29: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: monitorexit
    //   34: iload_2
    //   35: ireturn
    //   36: aload_0
    //   37: getfield 39	com/tencent/mm/plugin/sns/model/ag:JXa	Ljava/util/List;
    //   40: iload_1
    //   41: invokestatic 392	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   44: invokeinterface 398 2 0
    //   49: pop
    //   50: iconst_1
    //   51: istore_2
    //   52: ldc_w 397
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
  
  public final boolean afN(int paramInt)
  {
    try
    {
      AppMethodBeat.i(95743);
      this.JXa.remove(Integer.valueOf(paramInt));
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
  public final boolean afO(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 403
    //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 46	com/tencent/mm/plugin/sns/model/ag:JXc	Ljava/util/List;
    //   12: iload_1
    //   13: invokestatic 392	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16: invokeinterface 395 2 0
    //   21: ifeq +15 -> 36
    //   24: iconst_0
    //   25: istore_2
    //   26: ldc_w 403
    //   29: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: monitorexit
    //   34: iload_2
    //   35: ireturn
    //   36: aload_0
    //   37: getfield 46	com/tencent/mm/plugin/sns/model/ag:JXc	Ljava/util/List;
    //   40: iload_1
    //   41: invokestatic 392	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   44: invokeinterface 398 2 0
    //   49: pop
    //   50: iconst_1
    //   51: istore_2
    //   52: ldc_w 403
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
  
  public final boolean afP(int paramInt)
  {
    try
    {
      AppMethodBeat.i(95749);
      this.JXc.remove(Integer.valueOf(paramInt));
      this.JXd.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(95749);
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean afQ(int paramInt)
  {
    try
    {
      AppMethodBeat.i(95751);
      this.JXd.remove(Integer.valueOf(paramInt));
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
  public final int afR(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 413
    //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 48	com/tencent/mm/plugin/sns/model/ag:JXd	Ljava/util/Map;
    //   12: iload_1
    //   13: invokestatic 392	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16: invokeinterface 416 2 0
    //   21: ifeq +33 -> 54
    //   24: aload_0
    //   25: getfield 48	com/tencent/mm/plugin/sns/model/ag:JXd	Ljava/util/Map;
    //   28: iload_1
    //   29: invokestatic 392	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   32: invokeinterface 419 2 0
    //   37: checkcast 388	java/lang/Integer
    //   40: invokevirtual 423	java/lang/Integer:intValue	()I
    //   43: istore_1
    //   44: ldc_w 413
    //   47: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_0
    //   51: monitorexit
    //   52: iload_1
    //   53: ireturn
    //   54: iconst_m1
    //   55: istore_1
    //   56: ldc_w 413
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
  
  /* Error */
  public final boolean bac(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 425
    //   7: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: getfield 44	com/tencent/mm/plugin/sns/model/ag:JXb	Ljava/util/Map;
    //   14: aload_1
    //   15: invokeinterface 416 2 0
    //   20: ifeq +13 -> 33
    //   23: ldc_w 425
    //   26: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: iload_2
    //   32: ireturn
    //   33: aload_0
    //   34: getfield 44	com/tencent/mm/plugin/sns/model/ag:JXb	Ljava/util/Map;
    //   37: aload_1
    //   38: iconst_0
    //   39: invokestatic 392	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   42: invokeinterface 429 3 0
    //   47: pop
    //   48: iconst_1
    //   49: istore_2
    //   50: ldc_w 425
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
  
  public final boolean bad(String paramString)
  {
    try
    {
      AppMethodBeat.i(95746);
      this.JXb.remove(paramString);
      AppMethodBeat.o(95746);
      return true;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final SnsObject f(SnsObject paramSnsObject)
  {
    long l;
    Iterator localIterator;
    Object localObject1;
    Object localObject2;
    try
    {
      AppMethodBeat.i(95729);
      if (Util.isNullOrNil(this.iRj)) {
        this.iRj = z.bcZ();
      }
      if ((this.JWZ.KeS.size() == 0) && (this.JWZ.KeT.size() == 0))
      {
        AppMethodBeat.o(95729);
        return paramSnsObject;
      }
      l = paramSnsObject.Id;
      localIterator = this.JWZ.KeS.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (e)localIterator.next();
        localObject2 = b(((e)localObject1).JVa);
        if ((((e)localObject1).JVa.Id == l) && (!a(paramSnsObject.LikeUserList, ((ejo)localObject2).lpy, ((ejo)localObject2).CreateTime)))
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
      localObject1 = (ejo)localIterator.next();
      if (((ejo)localObject1).Username.equals(this.iRj))
      {
        i = 0;
        localObject2 = this.JWZ.KeX.iterator();
        label231:
        if (!((Iterator)localObject2).hasNext()) {
          break label396;
        }
        if (((f)((Iterator)localObject2).next()).Kfb != l) {
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
      localIterator = this.JWZ.KeT.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (e)localIterator.next();
        if (((e)localObject1).JVa.Id == l)
        {
          localObject1 = b(((e)localObject1).JVa);
          if (!a(paramSnsObject.CommentUserList, ((ejo)localObject1).lpy, ((ejo)localObject1).CreateTime))
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
  
  public final void fOh()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(95723);
        if (bJ(this.JWZ.KeS))
        {
          AppMethodBeat.o(95723);
          return;
        }
        if (bJ(this.JWZ.KeT))
        {
          AppMethodBeat.o(95723);
          continue;
        }
        if (!bJ(this.JWZ.KeU)) {
          break label79;
        }
      }
      finally {}
      AppMethodBeat.o(95723);
      continue;
      label79:
      if (bJ(this.JWZ.KeV))
      {
        AppMethodBeat.o(95723);
      }
      else
      {
        f localf;
        long l;
        for (;;)
        {
          if (!this.JWZ.KeW.isEmpty())
          {
            localf = (f)this.JWZ.KeW.getFirst();
            if (Util.secondsToNow(localf.KeZ) > 21600L)
            {
              this.JWZ.KeW.removeFirst();
            }
            else
            {
              l = localf.Kfb;
              h.aHH();
              h.aHF().kcd.a(new s(l, 1), 0);
              AppMethodBeat.o(95723);
              break;
            }
          }
        }
        for (;;)
        {
          if (!this.JWZ.KeX.isEmpty())
          {
            localf = (f)this.JWZ.KeX.getFirst();
            if (Util.secondsToNow(localf.KeZ) > 21600L)
            {
              this.JWZ.KeX.removeFirst();
            }
            else
            {
              l = localf.Kfb;
              h.aHH();
              h.aHF().kcd.a(new s(l, 5), 0);
              AppMethodBeat.o(95723);
              break;
            }
          }
        }
        AppMethodBeat.o(95723);
      }
    }
  }
  
  public final int fOk()
  {
    try
    {
      AppMethodBeat.i(95747);
      int i = this.JXb.size();
      AppMethodBeat.o(95747);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void h(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(95733);
    an.fPi();
    i(paramLong, paramInt, paramString);
    AppMethodBeat.o(95733);
  }
  
  public final boolean isDownloading(String paramString)
  {
    try
    {
      AppMethodBeat.i(95744);
      boolean bool = this.JXb.containsKey(paramString);
      AppMethodBeat.o(95744);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final boolean jE(int paramInt1, int paramInt2)
  {
    try
    {
      AppMethodBeat.i(95750);
      this.JXd.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ag
 * JD-Core Version:    0.7.0.1
 */