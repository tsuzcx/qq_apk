package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.dfh;
import com.tencent.mm.protocal.protobuf.dfi;
import com.tencent.mm.protocal.protobuf.dfn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public final class ae
{
  String fFK;
  private String path;
  private d ziX;
  private List<Integer> ziY;
  private Map<String, Integer> ziZ;
  private List<Integer> zja;
  private Map<Integer, Integer> zjb;
  
  public ae(String paramString)
  {
    AppMethodBeat.i(95722);
    this.fFK = "";
    this.ziY = new Vector();
    this.ziZ = new HashMap();
    this.zja = new Vector();
    this.zjb = new HashMap();
    this.path = paramString;
    if (!dTG()) {
      this.ziX = new d();
    }
    this.ziY.clear();
    this.ziZ.clear();
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
      } while (locale2.zhd.Id != paramLong);
      locale1 = locale2;
      if (paramBoolean) {
        break;
      }
    } while (!locale2.zqB.equals(paramString));
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
  
  private static boolean a(LinkedList<dfn> paramLinkedList, String paramString, int paramInt)
  {
    AppMethodBeat.i(95728);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(95728);
      return true;
    }
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      dfn localdfn = (dfn)paramLinkedList.next();
      if ((paramString.equals(localdfn.hDa)) && (paramInt == localdfn.CreateTime))
      {
        AppMethodBeat.o(95728);
        return true;
      }
    }
    AppMethodBeat.o(95728);
    return false;
  }
  
  private static boolean aT(LinkedList<e> paramLinkedList)
  {
    AppMethodBeat.i(95724);
    while (!paramLinkedList.isEmpty())
    {
      e locale = (e)paramLinkedList.getFirst();
      if (bt.rM(locale.zqC) > 21600L)
      {
        paramLinkedList.removeFirst();
      }
      else
      {
        if (ayT(locale.zqB))
        {
          g.ajD();
          g.ajB().gAO.a(new j(locale.zhd, locale.zqB, locale.zqD, 0), 0);
        }
        for (;;)
        {
          AppMethodBeat.o(95724);
          return true;
          g.ajD();
          g.ajB().gAO.a(new n(locale.zhd, locale.zqB), 0);
        }
      }
    }
    AppMethodBeat.o(95724);
    return false;
  }
  
  public static boolean ayT(String paramString)
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
  
  public static dfn b(dfi paramdfi)
  {
    AppMethodBeat.i(95730);
    dfh localdfh = paramdfi.HtP;
    paramdfi = paramdfi.HtQ;
    dfn localdfn = new dfn();
    localdfn.hDa = localdfh.hDa;
    localdfn.CreateTime = localdfh.CreateTime;
    localdfn.Nickname = localdfh.HtE;
    localdfn.tRT = localdfh.tRT;
    localdfn.nEf = localdfh.nEf;
    localdfn.Username = localdfh.Hgt;
    localdfn.HtH = localdfh.HtH;
    localdfn.HtJ = localdfh.HtJ;
    localdfn.HtL = localdfh.HtL;
    localdfn.Hub = paramdfi.Hgt;
    localdfn.HtI = paramdfi.HtI;
    localdfn.HtG = paramdfi.HtG;
    localdfn.HtM = localdfh.HtM;
    localdfn.HtN = localdfh.HtN;
    AppMethodBeat.o(95730);
    return localdfn;
  }
  
  private boolean dTF()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(95739);
        try
        {
          byte[] arrayOfByte = this.ziX.toByteArray();
          if (i.f(this.path, arrayOfByte, arrayOfByte.length) != 0) {
            continue;
          }
          bool = true;
          AppMethodBeat.o(95739);
        }
        catch (IOException localIOException)
        {
          ad.printErrStackTrace("MicroMsg.SnsAsyncQueueMgr", localIOException, "listToFile failed: " + this.path, new Object[0]);
          i.deleteFile(this.path);
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
  
  private boolean dTG()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(95740);
        arrayOfByte = i.aY(this.path, 0, -1);
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
          this.ziX = ((d)new d().parseFrom(arrayOfByte));
          bool = true;
          AppMethodBeat.o(95740);
        }
        catch (IOException localIOException)
        {
          ad.printErrStackTrace("MicroMsg.SnsAsyncQueueMgr", localIOException, "", new Object[0]);
          i.deleteFile(this.path);
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
          dTF();
          AppMethodBeat.o(95734);
          return;
        }
      }
      finally {}
      a(paramLong, this.ziX.zqv, paramString);
      continue;
      a(paramLong, this.ziX.zqw, paramString);
      continue;
      a(paramLong, this.ziX.zqv, paramString);
      continue;
      a(paramLong, this.ziX.zqw, paramString);
      continue;
      a(paramLong, this.ziX.zqx, paramString);
      continue;
      a(paramLong, this.ziX.zqy, paramString);
    }
  }
  
  public final boolean PP(int paramInt)
  {
    try
    {
      AppMethodBeat.i(95741);
      boolean bool = this.ziY.contains(Integer.valueOf(paramInt));
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
  public final boolean PQ(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 351
    //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 39	com/tencent/mm/plugin/sns/model/ae:ziY	Ljava/util/List;
    //   12: iload_1
    //   13: invokestatic 346	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16: invokeinterface 349 2 0
    //   21: ifeq +15 -> 36
    //   24: iconst_0
    //   25: istore_2
    //   26: ldc_w 351
    //   29: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: monitorexit
    //   34: iload_2
    //   35: ireturn
    //   36: aload_0
    //   37: getfield 39	com/tencent/mm/plugin/sns/model/ae:ziY	Ljava/util/List;
    //   40: iload_1
    //   41: invokestatic 346	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   44: invokeinterface 354 2 0
    //   49: pop
    //   50: iconst_1
    //   51: istore_2
    //   52: ldc_w 351
    //   55: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: goto -26 -> 32
    //   61: astore_3
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_3
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	ae
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
  
  public final boolean PR(int paramInt)
  {
    try
    {
      AppMethodBeat.i(95743);
      this.ziY.remove(Integer.valueOf(paramInt));
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
  public final boolean PS(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 359
    //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 46	com/tencent/mm/plugin/sns/model/ae:zja	Ljava/util/List;
    //   12: iload_1
    //   13: invokestatic 346	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16: invokeinterface 349 2 0
    //   21: ifeq +15 -> 36
    //   24: iconst_0
    //   25: istore_2
    //   26: ldc_w 359
    //   29: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: monitorexit
    //   34: iload_2
    //   35: ireturn
    //   36: aload_0
    //   37: getfield 46	com/tencent/mm/plugin/sns/model/ae:zja	Ljava/util/List;
    //   40: iload_1
    //   41: invokestatic 346	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   44: invokeinterface 354 2 0
    //   49: pop
    //   50: iconst_1
    //   51: istore_2
    //   52: ldc_w 359
    //   55: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: goto -26 -> 32
    //   61: astore_3
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_3
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	ae
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
  
  public final boolean PT(int paramInt)
  {
    try
    {
      AppMethodBeat.i(95749);
      this.zja.remove(Integer.valueOf(paramInt));
      this.zjb.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(95749);
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean PU(int paramInt)
  {
    try
    {
      AppMethodBeat.i(95751);
      this.zjb.remove(Integer.valueOf(paramInt));
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
  public final int PV(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 369
    //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 48	com/tencent/mm/plugin/sns/model/ae:zjb	Ljava/util/Map;
    //   12: iload_1
    //   13: invokestatic 346	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16: invokeinterface 372 2 0
    //   21: ifeq +33 -> 54
    //   24: aload_0
    //   25: getfield 48	com/tencent/mm/plugin/sns/model/ae:zjb	Ljava/util/Map;
    //   28: iload_1
    //   29: invokestatic 346	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   32: invokeinterface 375 2 0
    //   37: checkcast 342	java/lang/Integer
    //   40: invokevirtual 379	java/lang/Integer:intValue	()I
    //   43: istore_1
    //   44: ldc_w 369
    //   47: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_0
    //   51: monitorexit
    //   52: iload_1
    //   53: ireturn
    //   54: iconst_m1
    //   55: istore_1
    //   56: ldc_w 369
    //   59: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: goto -12 -> 50
    //   65: astore_2
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_2
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	ae
    //   0	70	1	paramInt	int
    //   65	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	50	65	finally
    //   56	62	65	finally
  }
  
  public final boolean a(String paramString, dfi paramdfi)
  {
    AppMethodBeat.i(95731);
    boolean bool = a(paramString, paramdfi, "");
    AppMethodBeat.o(95731);
    return bool;
  }
  
  public final boolean a(String paramString1, dfi paramdfi, String paramString2)
  {
    boolean bool2 = true;
    for (;;)
    {
      e locale;
      try
      {
        AppMethodBeat.i(95732);
        locale = new e();
        locale.zqB = paramString1;
        locale.zhd = paramdfi;
        locale.zqC = ((int)bt.aQJ());
        locale.zqD = paramString2;
        bool1 = bool2;
        switch (paramdfi.HtP.nEf)
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
          if (!dTF()) {
            ad.e("MicroMsg.SnsAsyncQueueMgr", "error listToFile");
          }
          AppMethodBeat.o(95732);
          return bool1;
        }
      }
      finally {}
      this.ziX.zqv.add(locale);
      boolean bool1 = bool2;
      if (zQ(paramdfi.Id))
      {
        bool1 = false;
        continue;
        this.ziX.zqw.add(locale);
        bool1 = bool2;
        continue;
        this.ziX.zqv.add(locale);
        bool1 = bool2;
        if (zQ(paramdfi.Id))
        {
          bool1 = false;
          continue;
          this.ziX.zqw.add(locale);
          bool1 = bool2;
          continue;
          this.ziX.zqx.add(locale);
          bool1 = bool2;
          continue;
          this.ziX.zqy.add(locale);
          bool1 = bool2;
          continue;
          bool1 = bool2;
        }
      }
    }
  }
  
  /* Error */
  public final boolean ayU(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 403
    //   7: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: getfield 44	com/tencent/mm/plugin/sns/model/ae:ziZ	Ljava/util/Map;
    //   14: aload_1
    //   15: invokeinterface 372 2 0
    //   20: ifeq +13 -> 33
    //   23: ldc_w 403
    //   26: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: iload_2
    //   32: ireturn
    //   33: aload_0
    //   34: getfield 44	com/tencent/mm/plugin/sns/model/ae:ziZ	Ljava/util/Map;
    //   37: aload_1
    //   38: iconst_0
    //   39: invokestatic 346	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   42: invokeinterface 407 3 0
    //   47: pop
    //   48: iconst_1
    //   49: istore_2
    //   50: ldc_w 403
    //   53: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: goto -27 -> 29
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	ae
    //   0	64	1	paramString	String
    //   1	49	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	29	59	finally
    //   33	48	59	finally
    //   50	56	59	finally
  }
  
  public final boolean ayV(String paramString)
  {
    try
    {
      AppMethodBeat.i(95746);
      this.ziZ.remove(paramString);
      AppMethodBeat.o(95746);
      return true;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final SnsObject c(SnsObject paramSnsObject)
  {
    long l;
    Iterator localIterator;
    Object localObject1;
    Object localObject2;
    try
    {
      AppMethodBeat.i(95729);
      if (bt.isNullOrNil(this.fFK)) {
        this.fFK = u.aAm();
      }
      if ((this.ziX.zqv.size() == 0) && (this.ziX.zqw.size() == 0))
      {
        AppMethodBeat.o(95729);
        return paramSnsObject;
      }
      l = paramSnsObject.Id;
      localIterator = this.ziX.zqv.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (e)localIterator.next();
        localObject2 = b(((e)localObject1).zhd);
        if ((((e)localObject1).zhd.Id == l) && (!a(paramSnsObject.LikeUserList, ((dfn)localObject2).hDa, ((dfn)localObject2).CreateTime)))
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
      localObject1 = (dfn)localIterator.next();
      if (((dfn)localObject1).Username.equals(this.fFK))
      {
        i = 0;
        localObject2 = this.ziX.zqA.iterator();
        label231:
        if (!((Iterator)localObject2).hasNext()) {
          break label396;
        }
        if (((f)((Iterator)localObject2).next()).zqE != l) {
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
      localIterator = this.ziX.zqw.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (e)localIterator.next();
        if (((e)localObject1).zhd.Id == l)
        {
          localObject1 = b(((e)localObject1).zhd);
          if (!a(paramSnsObject.CommentUserList, ((dfn)localObject1).hDa, ((dfn)localObject1).CreateTime))
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
  
  public final void dTE()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(95723);
        if (aT(this.ziX.zqv))
        {
          AppMethodBeat.o(95723);
          return;
        }
        if (aT(this.ziX.zqw))
        {
          AppMethodBeat.o(95723);
          continue;
        }
        if (!aT(this.ziX.zqx)) {
          break label79;
        }
      }
      finally {}
      AppMethodBeat.o(95723);
      continue;
      label79:
      if (aT(this.ziX.zqy))
      {
        AppMethodBeat.o(95723);
      }
      else
      {
        f localf;
        long l;
        for (;;)
        {
          if (!this.ziX.zqz.isEmpty())
          {
            localf = (f)this.ziX.zqz.getFirst();
            if (bt.rM(localf.zqC) > 21600L)
            {
              this.ziX.zqz.removeFirst();
            }
            else
            {
              l = localf.zqE;
              g.ajD();
              g.ajB().gAO.a(new q(l, 1), 0);
              AppMethodBeat.o(95723);
              break;
            }
          }
        }
        for (;;)
        {
          if (!this.ziX.zqA.isEmpty())
          {
            localf = (f)this.ziX.zqA.getFirst();
            if (bt.rM(localf.zqC) > 21600L)
            {
              this.ziX.zqA.removeFirst();
            }
            else
            {
              l = localf.zqE;
              g.ajD();
              g.ajB().gAO.a(new q(l, 5), 0);
              AppMethodBeat.o(95723);
              break;
            }
          }
        }
        AppMethodBeat.o(95723);
      }
    }
  }
  
  public final int dTH()
  {
    try
    {
      AppMethodBeat.i(95747);
      int i = this.ziZ.size();
      AppMethodBeat.o(95747);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean hz(int paramInt1, int paramInt2)
  {
    try
    {
      AppMethodBeat.i(95750);
      this.zjb.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      AppMethodBeat.o(95750);
      return true;
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
    ak.dUA();
    j(paramLong, paramInt, paramString);
    AppMethodBeat.o(95733);
  }
  
  public final boolean isDownloading(String paramString)
  {
    try
    {
      AppMethodBeat.i(95744);
      boolean bool = this.ziZ.containsKey(paramString);
      AppMethodBeat.o(95744);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public final boolean zM(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 478
    //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 59	com/tencent/mm/plugin/sns/model/ae:ziX	Lcom/tencent/mm/plugin/sns/i/d;
    //   12: getfield 454	com/tencent/mm/plugin/sns/i/d:zqz	Ljava/util/LinkedList;
    //   15: invokevirtual 86	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   18: astore 4
    //   20: aload 4
    //   22: invokeinterface 91 1 0
    //   27: ifeq +33 -> 60
    //   30: aload 4
    //   32: invokeinterface 95 1 0
    //   37: checkcast 438	com/tencent/mm/plugin/sns/i/f
    //   40: getfield 441	com/tencent/mm/plugin/sns/i/f:zqE	J
    //   43: lload_1
    //   44: lcmp
    //   45: ifne -25 -> 20
    //   48: iconst_0
    //   49: istore_3
    //   50: ldc_w 478
    //   53: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: aload_0
    //   57: monitorexit
    //   58: iload_3
    //   59: ireturn
    //   60: iconst_1
    //   61: istore_3
    //   62: ldc_w 478
    //   65: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: goto -12 -> 56
    //   71: astore 4
    //   73: aload_0
    //   74: monitorexit
    //   75: aload 4
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	ae
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
  
  public final void zN(long paramLong)
  {
    try
    {
      AppMethodBeat.i(95726);
      f localf = new f();
      localf.zqE = paramLong;
      localf.zqC = ((int)bt.aQJ());
      this.ziX.zqz.add(localf);
      dTF();
      AppMethodBeat.o(95726);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final void zO(long paramLong)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(95727);
        Iterator localIterator = this.ziX.zqz.iterator();
        if (localIterator.hasNext())
        {
          f localf = (f)localIterator.next();
          if (localf.zqE != paramLong) {
            continue;
          }
          if (localf != null) {
            this.ziX.zqz.remove(localf);
          }
          dTF();
          AppMethodBeat.o(95727);
          return;
        }
      }
      finally {}
      Object localObject2 = null;
    }
  }
  
  /* Error */
  public final boolean zP(long paramLong)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 486
    //   7: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: new 438	com/tencent/mm/plugin/sns/i/f
    //   13: dup
    //   14: invokespecial 482	com/tencent/mm/plugin/sns/i/f:<init>	()V
    //   17: astore 4
    //   19: aload 4
    //   21: lload_1
    //   22: putfield 441	com/tencent/mm/plugin/sns/i/f:zqE	J
    //   25: aload 4
    //   27: invokestatic 390	com/tencent/mm/sdk/platformtools/bt:aQJ	()J
    //   30: l2i
    //   31: putfield 455	com/tencent/mm/plugin/sns/i/f:zqC	I
    //   34: aload_0
    //   35: getfield 59	com/tencent/mm/plugin/sns/model/ae:ziX	Lcom/tencent/mm/plugin/sns/i/d;
    //   38: getfield 436	com/tencent/mm/plugin/sns/i/d:zqA	Ljava/util/LinkedList;
    //   41: aload 4
    //   43: invokevirtual 397	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   46: pop
    //   47: aload_0
    //   48: invokespecial 323	com/tencent/mm/plugin/sns/model/ae:dTF	()Z
    //   51: pop
    //   52: lload_1
    //   53: aload_0
    //   54: getfield 59	com/tencent/mm/plugin/sns/model/ae:ziX	Lcom/tencent/mm/plugin/sns/i/d;
    //   57: getfield 326	com/tencent/mm/plugin/sns/i/d:zqv	Ljava/util/LinkedList;
    //   60: ldc 32
    //   62: iconst_1
    //   63: invokestatic 77	com/tencent/mm/plugin/sns/model/ae:a	(JLjava/util/LinkedList;Ljava/lang/String;Z)Z
    //   66: ifne +13 -> 79
    //   69: ldc_w 486
    //   72: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: aload_0
    //   76: monitorexit
    //   77: iload_3
    //   78: ireturn
    //   79: iconst_0
    //   80: istore_3
    //   81: ldc_w 486
    //   84: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: goto -12 -> 75
    //   90: astore 4
    //   92: aload_0
    //   93: monitorexit
    //   94: aload 4
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	ae
    //   0	97	1	paramLong	long
    //   1	80	3	bool	boolean
    //   17	25	4	localf	f
    //   90	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	75	90	finally
    //   81	87	90	finally
  }
  
  final boolean zQ(long paramLong)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(95738);
        Iterator localIterator = this.ziX.zqA.iterator();
        if (!localIterator.hasNext()) {
          break label99;
        }
        f localf = (f)localIterator.next();
        if (localf.zqE != paramLong) {
          continue;
        }
        if (localf != null)
        {
          this.ziX.zqA.remove(localf);
          bool = true;
          dTF();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ae
 * JD-Core Version:    0.7.0.1
 */