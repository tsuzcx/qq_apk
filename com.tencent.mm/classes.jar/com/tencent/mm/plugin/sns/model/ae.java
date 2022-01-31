package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.h.d;
import com.tencent.mm.plugin.sns.h.f;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.cdm;
import com.tencent.mm.protocal.protobuf.cdn;
import com.tencent.mm.protocal.protobuf.cds;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public final class ae
{
  String dZZ;
  private String path;
  private d rgd;
  private List<Integer> rge;
  private Map<String, Integer> rgf;
  private List<Integer> rgg;
  private Map<Integer, Integer> rgh;
  
  public ae(String paramString)
  {
    AppMethodBeat.i(36383);
    this.dZZ = "";
    this.rge = new Vector();
    this.rgf = new HashMap();
    this.rgg = new Vector();
    this.rgh = new HashMap();
    this.path = paramString;
    if (!coH()) {
      this.rgd = new d();
    }
    this.rge.clear();
    this.rgf.clear();
    AppMethodBeat.o(36383);
  }
  
  private static void a(long paramLong, LinkedList<com.tencent.mm.plugin.sns.h.e> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(36396);
    a(paramLong, paramLinkedList, paramString, false);
    AppMethodBeat.o(36396);
  }
  
  private static boolean a(long paramLong, LinkedList<com.tencent.mm.plugin.sns.h.e> paramLinkedList, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(36397);
    Iterator localIterator = paramLinkedList.iterator();
    com.tencent.mm.plugin.sns.h.e locale2;
    do
    {
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        locale2 = (com.tencent.mm.plugin.sns.h.e)localIterator.next();
      } while (locale2.rep.Id != paramLong);
      locale1 = locale2;
      if (paramBoolean) {
        break;
      }
    } while (!locale2.rlS.equals(paramString));
    for (com.tencent.mm.plugin.sns.h.e locale1 = locale2;; locale1 = null)
    {
      if (locale1 != null)
      {
        paramLinkedList.remove(locale1);
        AppMethodBeat.o(36397);
        return true;
      }
      AppMethodBeat.o(36397);
      return false;
    }
  }
  
  private static boolean a(LinkedList<cds> paramLinkedList, String paramString, int paramInt)
  {
    AppMethodBeat.i(36389);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(36389);
      return true;
    }
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      cds localcds = (cds)paramLinkedList.next();
      if ((paramString.equals(localcds.ntu)) && (paramInt == localcds.CreateTime))
      {
        AppMethodBeat.o(36389);
        return true;
      }
    }
    AppMethodBeat.o(36389);
    return false;
  }
  
  public static boolean aat(String paramString)
  {
    AppMethodBeat.i(36382);
    if (paramString == null)
    {
      AppMethodBeat.o(36382);
      return false;
    }
    if (paramString.startsWith("_AD_TAG_"))
    {
      AppMethodBeat.o(36382);
      return true;
    }
    AppMethodBeat.o(36382);
    return false;
  }
  
  private static boolean au(LinkedList<com.tencent.mm.plugin.sns.h.e> paramLinkedList)
  {
    AppMethodBeat.i(36385);
    while (!paramLinkedList.isEmpty())
    {
      com.tencent.mm.plugin.sns.h.e locale = (com.tencent.mm.plugin.sns.h.e)paramLinkedList.getFirst();
      if (bo.gz(locale.rlT) > 21600L)
      {
        paramLinkedList.removeFirst();
      }
      else
      {
        if (aat(locale.rlS))
        {
          g.RM();
          g.RK().eHt.a(new k(locale.rep, locale.rlS, locale.rlU), 0);
        }
        for (;;)
        {
          AppMethodBeat.o(36385);
          return true;
          g.RM();
          g.RK().eHt.a(new o(locale.rep, locale.rlS), 0);
        }
      }
    }
    AppMethodBeat.o(36385);
    return false;
  }
  
  public static cds b(cdn paramcdn)
  {
    AppMethodBeat.i(36391);
    cdm localcdm = paramcdn.xOe;
    paramcdn = paramcdn.xOf;
    cds localcds = new cds();
    localcds.ntu = localcdm.ntu;
    localcds.CreateTime = localcdm.CreateTime;
    localcds.Nickname = localcdm.xNV;
    localcds.niK = localcdm.niK;
    localcds.jKs = localcdm.jKs;
    localcds.Username = localcdm.xCG;
    localcds.xNY = localcdm.xNY;
    localcds.xOa = localcdm.xOa;
    localcds.xOc = localcdm.xOc;
    localcds.xOr = paramcdn.xCG;
    localcds.xNZ = paramcdn.xNZ;
    localcds.xNX = paramcdn.xNX;
    AppMethodBeat.o(36391);
    return localcds;
  }
  
  private boolean coG()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(36400);
        try
        {
          byte[] arrayOfByte = this.rgd.toByteArray();
          if (com.tencent.mm.vfs.e.b(this.path, arrayOfByte, arrayOfByte.length) != 0) {
            continue;
          }
          bool = true;
          AppMethodBeat.o(36400);
        }
        catch (IOException localIOException)
        {
          ab.printErrStackTrace("MicroMsg.SnsAsyncQueueMgr", localIOException, "listToFile failed: " + this.path, new Object[0]);
          com.tencent.mm.vfs.e.deleteFile(this.path);
          AppMethodBeat.o(36400);
          boolean bool = false;
          continue;
        }
        return bool;
      }
      finally {}
      AppMethodBeat.o(36400);
      bool = false;
    }
  }
  
  private boolean coH()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(36401);
        arrayOfByte = com.tencent.mm.vfs.e.i(this.path, 0, -1);
        if (arrayOfByte != null) {
          continue;
        }
        AppMethodBeat.o(36401);
        bool = false;
      }
      finally
      {
        try
        {
          byte[] arrayOfByte;
          this.rgd = ((d)new d().parseFrom(arrayOfByte));
          bool = true;
          AppMethodBeat.o(36401);
        }
        catch (IOException localIOException)
        {
          ab.printErrStackTrace("MicroMsg.SnsAsyncQueueMgr", localIOException, "", new Object[0]);
          com.tencent.mm.vfs.e.deleteFile(this.path);
          AppMethodBeat.o(36401);
          boolean bool = false;
        }
        localObject = finally;
      }
      return bool;
    }
  }
  
  private void f(long paramLong, int paramInt, String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(36395);
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
          coG();
          AppMethodBeat.o(36395);
          return;
        }
      }
      finally {}
      a(paramLong, this.rgd.rlM, paramString);
      continue;
      a(paramLong, this.rgd.rlN, paramString);
      continue;
      a(paramLong, this.rgd.rlM, paramString);
      continue;
      a(paramLong, this.rgd.rlN, paramString);
      continue;
      a(paramLong, this.rgd.rlO, paramString);
      continue;
      a(paramLong, this.rgd.rlP, paramString);
    }
  }
  
  public final boolean DG(int paramInt)
  {
    try
    {
      AppMethodBeat.i(36402);
      boolean bool = this.rge.contains(Integer.valueOf(paramInt));
      AppMethodBeat.o(36402);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final boolean DH(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 341
    //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 39	com/tencent/mm/plugin/sns/model/ae:rge	Ljava/util/List;
    //   12: iload_1
    //   13: invokestatic 336	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16: invokeinterface 339 2 0
    //   21: ifeq +15 -> 36
    //   24: iconst_0
    //   25: istore_2
    //   26: ldc_w 341
    //   29: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: monitorexit
    //   34: iload_2
    //   35: ireturn
    //   36: aload_0
    //   37: getfield 39	com/tencent/mm/plugin/sns/model/ae:rge	Ljava/util/List;
    //   40: iload_1
    //   41: invokestatic 336	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   44: invokeinterface 344 2 0
    //   49: pop
    //   50: iconst_1
    //   51: istore_2
    //   52: ldc_w 341
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
  
  public final boolean DI(int paramInt)
  {
    try
    {
      AppMethodBeat.i(36404);
      this.rge.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(36404);
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final boolean DJ(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 349
    //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 46	com/tencent/mm/plugin/sns/model/ae:rgg	Ljava/util/List;
    //   12: iload_1
    //   13: invokestatic 336	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16: invokeinterface 339 2 0
    //   21: ifeq +15 -> 36
    //   24: iconst_0
    //   25: istore_2
    //   26: ldc_w 349
    //   29: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: monitorexit
    //   34: iload_2
    //   35: ireturn
    //   36: aload_0
    //   37: getfield 46	com/tencent/mm/plugin/sns/model/ae:rgg	Ljava/util/List;
    //   40: iload_1
    //   41: invokestatic 336	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   44: invokeinterface 344 2 0
    //   49: pop
    //   50: iconst_1
    //   51: istore_2
    //   52: ldc_w 349
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
  
  public final boolean DK(int paramInt)
  {
    try
    {
      AppMethodBeat.i(36410);
      this.rgg.remove(Integer.valueOf(paramInt));
      this.rgh.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(36410);
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean DL(int paramInt)
  {
    try
    {
      AppMethodBeat.i(36412);
      this.rgh.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(36412);
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final int DM(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 359
    //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 48	com/tencent/mm/plugin/sns/model/ae:rgh	Ljava/util/Map;
    //   12: iload_1
    //   13: invokestatic 336	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16: invokeinterface 362 2 0
    //   21: ifeq +33 -> 54
    //   24: aload_0
    //   25: getfield 48	com/tencent/mm/plugin/sns/model/ae:rgh	Ljava/util/Map;
    //   28: iload_1
    //   29: invokestatic 336	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   32: invokeinterface 365 2 0
    //   37: checkcast 332	java/lang/Integer
    //   40: invokevirtual 369	java/lang/Integer:intValue	()I
    //   43: istore_1
    //   44: ldc_w 359
    //   47: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_0
    //   51: monitorexit
    //   52: iload_1
    //   53: ireturn
    //   54: iconst_m1
    //   55: istore_1
    //   56: ldc_w 359
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
  
  public final boolean a(String paramString, cdn paramcdn)
  {
    AppMethodBeat.i(36392);
    boolean bool = a(paramString, paramcdn, "");
    AppMethodBeat.o(36392);
    return bool;
  }
  
  public final boolean a(String paramString1, cdn paramcdn, String paramString2)
  {
    boolean bool2 = true;
    for (;;)
    {
      com.tencent.mm.plugin.sns.h.e locale;
      try
      {
        AppMethodBeat.i(36393);
        locale = new com.tencent.mm.plugin.sns.h.e();
        locale.rlS = paramString1;
        locale.rep = paramcdn;
        locale.rlT = ((int)bo.aox());
        locale.rlU = paramString2;
        bool1 = bool2;
        switch (paramcdn.xOe.jKs)
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
          if (!coG()) {
            ab.e("MicroMsg.SnsAsyncQueueMgr", "error listToFile");
          }
          AppMethodBeat.o(36393);
          return bool1;
        }
      }
      finally {}
      this.rgd.rlM.add(locale);
      boolean bool1 = bool2;
      if (lL(paramcdn.Id))
      {
        bool1 = false;
        continue;
        this.rgd.rlN.add(locale);
        bool1 = bool2;
        continue;
        this.rgd.rlM.add(locale);
        bool1 = bool2;
        if (lL(paramcdn.Id))
        {
          bool1 = false;
          continue;
          this.rgd.rlN.add(locale);
          bool1 = bool2;
          continue;
          this.rgd.rlO.add(locale);
          bool1 = bool2;
          continue;
          this.rgd.rlP.add(locale);
          bool1 = bool2;
          continue;
          bool1 = bool2;
        }
      }
    }
  }
  
  /* Error */
  public final boolean aau(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 393
    //   7: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: getfield 44	com/tencent/mm/plugin/sns/model/ae:rgf	Ljava/util/Map;
    //   14: aload_1
    //   15: invokeinterface 362 2 0
    //   20: ifeq +13 -> 33
    //   23: ldc_w 393
    //   26: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: iload_2
    //   32: ireturn
    //   33: aload_0
    //   34: getfield 44	com/tencent/mm/plugin/sns/model/ae:rgf	Ljava/util/Map;
    //   37: aload_1
    //   38: iconst_0
    //   39: invokestatic 336	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   42: invokeinterface 397 3 0
    //   47: pop
    //   48: iconst_1
    //   49: istore_2
    //   50: ldc_w 393
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
  
  public final boolean aav(String paramString)
  {
    try
    {
      AppMethodBeat.i(36407);
      this.rgf.remove(paramString);
      AppMethodBeat.o(36407);
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
      AppMethodBeat.i(36390);
      if (bo.isNullOrNil(this.dZZ)) {
        this.dZZ = com.tencent.mm.model.r.Zn();
      }
      if ((this.rgd.rlM.size() == 0) && (this.rgd.rlN.size() == 0))
      {
        AppMethodBeat.o(36390);
        return paramSnsObject;
      }
      l = paramSnsObject.Id;
      localIterator = this.rgd.rlM.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (com.tencent.mm.plugin.sns.h.e)localIterator.next();
        localObject2 = b(((com.tencent.mm.plugin.sns.h.e)localObject1).rep);
        if ((((com.tencent.mm.plugin.sns.h.e)localObject1).rep.Id == l) && (!a(paramSnsObject.LikeUserList, ((cds)localObject2).ntu, ((cds)localObject2).CreateTime)))
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
      localObject1 = (cds)localIterator.next();
      if (((cds)localObject1).Username.equals(this.dZZ))
      {
        i = 0;
        localObject2 = this.rgd.rlR.iterator();
        label231:
        if (!((Iterator)localObject2).hasNext()) {
          break label396;
        }
        if (((f)((Iterator)localObject2).next()).rlV != l) {
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
      localIterator = this.rgd.rlN.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (com.tencent.mm.plugin.sns.h.e)localIterator.next();
        if (((com.tencent.mm.plugin.sns.h.e)localObject1).rep.Id == l)
        {
          localObject1 = b(((com.tencent.mm.plugin.sns.h.e)localObject1).rep);
          if (!a(paramSnsObject.CommentUserList, ((cds)localObject1).ntu, ((cds)localObject1).CreateTime))
          {
            paramSnsObject.CommentUserList.add(localObject1);
            paramSnsObject.CommentCount += 1;
          }
        }
      }
      AppMethodBeat.o(36390);
      break;
      label393:
      break label231;
      label396:
      if (i == 0) {
        break label180;
      }
    }
  }
  
  public final void coF()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(36384);
        if (au(this.rgd.rlM))
        {
          AppMethodBeat.o(36384);
          return;
        }
        if (au(this.rgd.rlN))
        {
          AppMethodBeat.o(36384);
          continue;
        }
        if (!au(this.rgd.rlO)) {
          break label79;
        }
      }
      finally {}
      AppMethodBeat.o(36384);
      continue;
      label79:
      if (au(this.rgd.rlP))
      {
        AppMethodBeat.o(36384);
      }
      else
      {
        f localf;
        long l;
        for (;;)
        {
          if (!this.rgd.rlQ.isEmpty())
          {
            localf = (f)this.rgd.rlQ.getFirst();
            if (bo.gz(localf.rlT) > 21600L)
            {
              this.rgd.rlQ.removeFirst();
            }
            else
            {
              l = localf.rlV;
              g.RM();
              g.RK().eHt.a(new r(l, 1), 0);
              AppMethodBeat.o(36384);
              break;
            }
          }
        }
        for (;;)
        {
          if (!this.rgd.rlR.isEmpty())
          {
            localf = (f)this.rgd.rlR.getFirst();
            if (bo.gz(localf.rlT) > 21600L)
            {
              this.rgd.rlR.removeFirst();
            }
            else
            {
              l = localf.rlV;
              g.RM();
              g.RK().eHt.a(new r(l, 5), 0);
              AppMethodBeat.o(36384);
              break;
            }
          }
        }
        AppMethodBeat.o(36384);
      }
    }
  }
  
  public final int coI()
  {
    try
    {
      AppMethodBeat.i(36408);
      int i = this.rgf.size();
      AppMethodBeat.o(36408);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void e(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(36394);
    ak.cpw();
    f(paramLong, paramInt, paramString);
    AppMethodBeat.o(36394);
  }
  
  public final boolean fv(int paramInt1, int paramInt2)
  {
    try
    {
      AppMethodBeat.i(36411);
      this.rgh.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      AppMethodBeat.o(36411);
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean isDownloading(String paramString)
  {
    try
    {
      AppMethodBeat.i(36405);
      boolean bool = this.rgf.containsKey(paramString);
      AppMethodBeat.o(36405);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public final boolean lH(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 468
    //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 59	com/tencent/mm/plugin/sns/model/ae:rgd	Lcom/tencent/mm/plugin/sns/h/d;
    //   12: getfield 444	com/tencent/mm/plugin/sns/h/d:rlQ	Ljava/util/LinkedList;
    //   15: invokevirtual 86	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   18: astore 4
    //   20: aload 4
    //   22: invokeinterface 91 1 0
    //   27: ifeq +33 -> 60
    //   30: aload 4
    //   32: invokeinterface 95 1 0
    //   37: checkcast 428	com/tencent/mm/plugin/sns/h/f
    //   40: getfield 431	com/tencent/mm/plugin/sns/h/f:rlV	J
    //   43: lload_1
    //   44: lcmp
    //   45: ifne -25 -> 20
    //   48: iconst_0
    //   49: istore_3
    //   50: ldc_w 468
    //   53: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: aload_0
    //   57: monitorexit
    //   58: iload_3
    //   59: ireturn
    //   60: iconst_1
    //   61: istore_3
    //   62: ldc_w 468
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
  
  public final void lI(long paramLong)
  {
    try
    {
      AppMethodBeat.i(36387);
      f localf = new f();
      localf.rlV = paramLong;
      localf.rlT = ((int)bo.aox());
      this.rgd.rlQ.add(localf);
      coG();
      AppMethodBeat.o(36387);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final void lJ(long paramLong)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(36388);
        Iterator localIterator = this.rgd.rlQ.iterator();
        if (localIterator.hasNext())
        {
          f localf = (f)localIterator.next();
          if (localf.rlV != paramLong) {
            continue;
          }
          if (localf != null) {
            this.rgd.rlQ.remove(localf);
          }
          coG();
          AppMethodBeat.o(36388);
          return;
        }
      }
      finally {}
      Object localObject2 = null;
    }
  }
  
  /* Error */
  public final boolean lK(long paramLong)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 476
    //   7: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: new 428	com/tencent/mm/plugin/sns/h/f
    //   13: dup
    //   14: invokespecial 472	com/tencent/mm/plugin/sns/h/f:<init>	()V
    //   17: astore 4
    //   19: aload 4
    //   21: lload_1
    //   22: putfield 431	com/tencent/mm/plugin/sns/h/f:rlV	J
    //   25: aload 4
    //   27: invokestatic 380	com/tencent/mm/sdk/platformtools/bo:aox	()J
    //   30: l2i
    //   31: putfield 445	com/tencent/mm/plugin/sns/h/f:rlT	I
    //   34: aload_0
    //   35: getfield 59	com/tencent/mm/plugin/sns/model/ae:rgd	Lcom/tencent/mm/plugin/sns/h/d;
    //   38: getfield 426	com/tencent/mm/plugin/sns/h/d:rlR	Ljava/util/LinkedList;
    //   41: aload 4
    //   43: invokevirtual 387	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   46: pop
    //   47: aload_0
    //   48: invokespecial 312	com/tencent/mm/plugin/sns/model/ae:coG	()Z
    //   51: pop
    //   52: lload_1
    //   53: aload_0
    //   54: getfield 59	com/tencent/mm/plugin/sns/model/ae:rgd	Lcom/tencent/mm/plugin/sns/h/d;
    //   57: getfield 316	com/tencent/mm/plugin/sns/h/d:rlM	Ljava/util/LinkedList;
    //   60: ldc 32
    //   62: iconst_1
    //   63: invokestatic 77	com/tencent/mm/plugin/sns/model/ae:a	(JLjava/util/LinkedList;Ljava/lang/String;Z)Z
    //   66: ifne +13 -> 79
    //   69: ldc_w 476
    //   72: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: aload_0
    //   76: monitorexit
    //   77: iload_3
    //   78: ireturn
    //   79: iconst_0
    //   80: istore_3
    //   81: ldc_w 476
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
  
  final boolean lL(long paramLong)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(36399);
        Iterator localIterator = this.rgd.rlR.iterator();
        if (!localIterator.hasNext()) {
          break label99;
        }
        f localf = (f)localIterator.next();
        if (localf.rlV != paramLong) {
          continue;
        }
        if (localf != null)
        {
          this.rgd.rlR.remove(localf);
          bool = true;
          coG();
          AppMethodBeat.o(36399);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ae
 * JD-Core Version:    0.7.0.1
 */