package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.k.d;
import com.tencent.mm.plugin.sns.k.e;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.fdp;
import com.tencent.mm.protocal.protobuf.fdq;
import com.tencent.mm.protocal.protobuf.fdv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public final class ai
{
  private com.tencent.mm.plugin.sns.k.c Quh;
  private List<Integer> Qui;
  private Map<String, Integer> Quj;
  private List<Integer> Quk;
  private Map<Integer, Integer> Qul;
  String ltf;
  private String path;
  
  public ai(String paramString)
  {
    AppMethodBeat.i(95722);
    this.ltf = "";
    this.Qui = new Vector();
    this.Quj = new HashMap();
    this.Quk = new Vector();
    this.Qul = new HashMap();
    this.path = paramString;
    if (!hfV()) {
      this.Quh = new com.tencent.mm.plugin.sns.k.c();
    }
    this.Qui.clear();
    this.Quj.clear();
    AppMethodBeat.o(95722);
  }
  
  private static void a(long paramLong, LinkedList<d> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(95735);
    a(paramLong, paramLinkedList, paramString, false);
    AppMethodBeat.o(95735);
  }
  
  private static boolean a(long paramLong, LinkedList<d> paramLinkedList, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(95736);
    Iterator localIterator = paramLinkedList.iterator();
    d locald2;
    do
    {
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        locald2 = (d)localIterator.next();
      } while (locald2.Qsc.Id != paramLong);
      locald1 = locald2;
      if (paramBoolean) {
        break;
      }
    } while (!locald2.QCC.equals(paramString));
    for (d locald1 = locald2;; locald1 = null)
    {
      if (locald1 != null)
      {
        paramLinkedList.remove(locald1);
        AppMethodBeat.o(95736);
        return true;
      }
      AppMethodBeat.o(95736);
      return false;
    }
  }
  
  public static boolean aYr(String paramString)
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
  
  public static fdv b(fdq paramfdq)
  {
    AppMethodBeat.i(95730);
    fdp localfdp = paramfdq.abDp;
    paramfdq = paramfdq.abDq;
    fdv localfdv = new fdv();
    localfdv.nUB = localfdp.nUB;
    localfdv.CreateTime = localfdp.CreateTime;
    localfdv.Nickname = localfdp.abDe;
    localfdv.IcB = localfdp.IcB;
    localfdv.vhJ = localfdp.vhJ;
    localfdv.Username = localfdp.abnl;
    localfdv.abDh = localfdp.abDh;
    localfdv.abDj = localfdp.abDj;
    localfdv.abDl = localfdp.abDl;
    localfdv.abDA = paramfdq.abnl;
    localfdv.abDi = paramfdq.abDi;
    localfdv.abDg = paramfdq.abDg;
    localfdv.abDm = localfdp.abDm;
    localfdv.abDn = localfdp.abDn;
    AppMethodBeat.o(95730);
    return localfdv;
  }
  
  private static boolean b(LinkedList<fdv> paramLinkedList, String paramString, int paramInt)
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
      fdv localfdv = (fdv)paramLinkedList.next();
      if ((paramString.equals(localfdv.nUB)) && (paramInt == localfdv.CreateTime))
      {
        AppMethodBeat.o(95728);
        return true;
      }
    }
    AppMethodBeat.o(95728);
    return false;
  }
  
  private static boolean bS(LinkedList<d> paramLinkedList)
  {
    AppMethodBeat.i(95724);
    while (!paramLinkedList.isEmpty())
    {
      d locald = (d)paramLinkedList.getFirst();
      if (Util.secondsToNow(locald.QCD) > 21600L)
      {
        paramLinkedList.removeFirst();
      }
      else
      {
        if (aYr(locald.QCC))
        {
          h.baF();
          h.baD().mCm.a(new k(locald.Qsc, locald.QCC, locald.QCE, 0), 0);
        }
        for (;;)
        {
          AppMethodBeat.o(95724);
          return true;
          h.baF();
          h.baD().mCm.a(new p(locald.Qsc, locald.QCC), 0);
        }
      }
    }
    AppMethodBeat.o(95724);
    return false;
  }
  
  private boolean hfU()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(95739);
        try
        {
          byte[] arrayOfByte = this.Quh.toByteArray();
          if (y.f(this.path, arrayOfByte, arrayOfByte.length) != 0) {
            continue;
          }
          bool = true;
          AppMethodBeat.o(95739);
        }
        catch (IOException localIOException)
        {
          Log.printErrStackTrace("MicroMsg.SnsAsyncQueueMgr", localIOException, "listToFile failed: " + this.path, new Object[0]);
          y.deleteFile(this.path);
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
  
  private boolean hfV()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(95740);
        arrayOfByte = y.bi(this.path, 0, -1);
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
          this.Quh = ((com.tencent.mm.plugin.sns.k.c)new com.tencent.mm.plugin.sns.k.c().parseFrom(arrayOfByte));
          bool = true;
          AppMethodBeat.o(95740);
        }
        catch (IOException localIOException)
        {
          Log.printErrStackTrace("MicroMsg.SnsAsyncQueueMgr", localIOException, "", new Object[0]);
          y.deleteFile(this.path);
          AppMethodBeat.o(95740);
          boolean bool = false;
        }
        localObject = finally;
      }
      return bool;
    }
  }
  
  private void k(long paramLong, int paramInt, String paramString)
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
          hfU();
          AppMethodBeat.o(95734);
          return;
        }
      }
      finally {}
      a(paramLong, this.Quh.QCw, paramString);
      continue;
      a(paramLong, this.Quh.QCx, paramString);
      continue;
      a(paramLong, this.Quh.QCw, paramString);
      continue;
      a(paramLong, this.Quh.QCx, paramString);
      continue;
      a(paramLong, this.Quh.QCy, paramString);
      continue;
      a(paramLong, this.Quh.QCz, paramString);
    }
  }
  
  public final boolean a(String paramString, fdq paramfdq)
  {
    AppMethodBeat.i(95731);
    boolean bool = a(paramString, paramfdq, "");
    AppMethodBeat.o(95731);
    return bool;
  }
  
  public final boolean a(String paramString1, fdq paramfdq, String paramString2)
  {
    boolean bool2 = true;
    for (;;)
    {
      d locald;
      try
      {
        AppMethodBeat.i(95732);
        locald = new d();
        locald.QCC = paramString1;
        locald.Qsc = paramfdq;
        locald.QCD = ((int)Util.nowSecond());
        locald.QCE = paramString2;
        bool1 = bool2;
        switch (paramfdq.abDp.vhJ)
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
          if (!hfU()) {
            Log.e("MicroMsg.SnsAsyncQueueMgr", "error listToFile");
          }
          AppMethodBeat.o(95732);
          return bool1;
        }
      }
      finally {}
      this.Quh.QCw.add(locald);
      boolean bool1 = bool2;
      if (uT(paramfdq.Id))
      {
        bool1 = false;
        continue;
        this.Quh.QCx.add(locald);
        bool1 = bool2;
        continue;
        this.Quh.QCw.add(locald);
        bool1 = bool2;
        if (uT(paramfdq.Id))
        {
          bool1 = false;
          continue;
          this.Quh.QCx.add(locald);
          bool1 = bool2;
          continue;
          this.Quh.QCy.add(locald);
          bool1 = bool2;
          continue;
          this.Quh.QCz.add(locald);
          bool1 = bool2;
          continue;
          bool1 = bool2;
        }
      }
    }
  }
  
  /* Error */
  public final boolean aYs(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 363
    //   7: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: getfield 44	com/tencent/mm/plugin/sns/model/ai:Quj	Ljava/util/Map;
    //   14: aload_1
    //   15: invokeinterface 366 2 0
    //   20: ifeq +13 -> 33
    //   23: ldc_w 363
    //   26: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: iload_2
    //   32: ireturn
    //   33: aload_0
    //   34: getfield 44	com/tencent/mm/plugin/sns/model/ai:Quj	Ljava/util/Map;
    //   37: aload_1
    //   38: iconst_0
    //   39: invokestatic 372	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   42: invokeinterface 376 3 0
    //   47: pop
    //   48: iconst_1
    //   49: istore_2
    //   50: ldc_w 363
    //   53: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: goto -27 -> 29
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	ai
    //   0	64	1	paramString	String
    //   1	49	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	29	59	finally
    //   33	48	59	finally
    //   50	56	59	finally
  }
  
  public final boolean aYt(String paramString)
  {
    try
    {
      AppMethodBeat.i(95746);
      this.Quj.remove(paramString);
      AppMethodBeat.o(95746);
      return true;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final boolean akA(int paramInt)
  {
    try
    {
      AppMethodBeat.i(95741);
      boolean bool = this.Qui.contains(Integer.valueOf(paramInt));
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
  public final boolean akB(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 389
    //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 39	com/tencent/mm/plugin/sns/model/ai:Qui	Ljava/util/List;
    //   12: iload_1
    //   13: invokestatic 372	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16: invokeinterface 387 2 0
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
    //   37: getfield 39	com/tencent/mm/plugin/sns/model/ai:Qui	Ljava/util/List;
    //   40: iload_1
    //   41: invokestatic 372	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   44: invokeinterface 390 2 0
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
    //   0	66	0	this	ai
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
  
  public final boolean akC(int paramInt)
  {
    try
    {
      AppMethodBeat.i(95743);
      this.Qui.remove(Integer.valueOf(paramInt));
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
  public final boolean akD(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 395
    //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 46	com/tencent/mm/plugin/sns/model/ai:Quk	Ljava/util/List;
    //   12: iload_1
    //   13: invokestatic 372	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16: invokeinterface 387 2 0
    //   21: ifeq +15 -> 36
    //   24: iconst_0
    //   25: istore_2
    //   26: ldc_w 395
    //   29: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: monitorexit
    //   34: iload_2
    //   35: ireturn
    //   36: aload_0
    //   37: getfield 46	com/tencent/mm/plugin/sns/model/ai:Quk	Ljava/util/List;
    //   40: iload_1
    //   41: invokestatic 372	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   44: invokeinterface 390 2 0
    //   49: pop
    //   50: iconst_1
    //   51: istore_2
    //   52: ldc_w 395
    //   55: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: goto -26 -> 32
    //   61: astore_3
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_3
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	ai
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
  
  public final boolean akE(int paramInt)
  {
    try
    {
      AppMethodBeat.i(95749);
      this.Quk.remove(Integer.valueOf(paramInt));
      this.Qul.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(95749);
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean akF(int paramInt)
  {
    try
    {
      AppMethodBeat.i(95751);
      this.Qul.remove(Integer.valueOf(paramInt));
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
  public final int akG(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 402
    //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 48	com/tencent/mm/plugin/sns/model/ai:Qul	Ljava/util/Map;
    //   12: iload_1
    //   13: invokestatic 372	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16: invokeinterface 366 2 0
    //   21: ifeq +33 -> 54
    //   24: aload_0
    //   25: getfield 48	com/tencent/mm/plugin/sns/model/ai:Qul	Ljava/util/Map;
    //   28: iload_1
    //   29: invokestatic 372	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   32: invokeinterface 405 2 0
    //   37: checkcast 368	java/lang/Integer
    //   40: invokevirtual 409	java/lang/Integer:intValue	()I
    //   43: istore_1
    //   44: ldc_w 402
    //   47: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_0
    //   51: monitorexit
    //   52: iload_1
    //   53: ireturn
    //   54: iconst_m1
    //   55: istore_1
    //   56: ldc_w 402
    //   59: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: goto -12 -> 50
    //   65: astore_2
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_2
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	ai
    //   0	70	1	paramInt	int
    //   65	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	50	65	finally
    //   56	62	65	finally
  }
  
  public final SnsObject g(SnsObject paramSnsObject)
  {
    long l;
    Iterator localIterator;
    Object localObject1;
    Object localObject2;
    try
    {
      AppMethodBeat.i(95729);
      if (Util.isNullOrNil(this.ltf)) {
        this.ltf = z.bAM();
      }
      if ((this.Quh.QCw.size() == 0) && (this.Quh.QCx.size() == 0))
      {
        AppMethodBeat.o(95729);
        return paramSnsObject;
      }
      l = paramSnsObject.Id;
      localIterator = this.Quh.QCw.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (d)localIterator.next();
        localObject2 = b(((d)localObject1).Qsc);
        if ((((d)localObject1).Qsc.Id == l) && (!b(paramSnsObject.LikeUserList, ((fdv)localObject2).nUB, ((fdv)localObject2).CreateTime)))
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
      localObject1 = (fdv)localIterator.next();
      if (((fdv)localObject1).Username.equals(this.ltf))
      {
        i = 0;
        localObject2 = this.Quh.QCB.iterator();
        label231:
        if (!((Iterator)localObject2).hasNext()) {
          break label396;
        }
        if (((e)((Iterator)localObject2).next()).QCF != l) {
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
      localIterator = this.Quh.QCx.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (d)localIterator.next();
        if (((d)localObject1).Qsc.Id == l)
        {
          localObject1 = b(((d)localObject1).Qsc);
          if (!b(paramSnsObject.CommentUserList, ((fdv)localObject1).nUB, ((fdv)localObject1).CreateTime))
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
  
  public final void hfT()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(95723);
        if (bS(this.Quh.QCw))
        {
          AppMethodBeat.o(95723);
          return;
        }
        if (bS(this.Quh.QCx))
        {
          AppMethodBeat.o(95723);
          continue;
        }
        if (!bS(this.Quh.QCy)) {
          break label79;
        }
      }
      finally {}
      AppMethodBeat.o(95723);
      continue;
      label79:
      if (bS(this.Quh.QCz))
      {
        AppMethodBeat.o(95723);
      }
      else
      {
        e locale;
        long l;
        for (;;)
        {
          if (!this.Quh.QCA.isEmpty())
          {
            locale = (e)this.Quh.QCA.getFirst();
            if (Util.secondsToNow(locale.QCD) > 21600L)
            {
              this.Quh.QCA.removeFirst();
            }
            else
            {
              l = locale.QCF;
              h.baF();
              h.baD().mCm.a(new s(l, 1), 0);
              AppMethodBeat.o(95723);
              break;
            }
          }
        }
        for (;;)
        {
          if (!this.Quh.QCB.isEmpty())
          {
            locale = (e)this.Quh.QCB.getFirst();
            if (Util.secondsToNow(locale.QCD) > 21600L)
            {
              this.Quh.QCB.removeFirst();
            }
            else
            {
              l = locale.QCF;
              h.baF();
              h.baD().mCm.a(new s(l, 5), 0);
              AppMethodBeat.o(95723);
              break;
            }
          }
        }
        AppMethodBeat.o(95723);
      }
    }
  }
  
  public final int hfW()
  {
    try
    {
      AppMethodBeat.i(95747);
      int i = this.Quj.size();
      AppMethodBeat.o(95747);
      return i;
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
      AppMethodBeat.i(95744);
      boolean bool = this.Quj.containsKey(paramString);
      AppMethodBeat.o(95744);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void j(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(95733);
    ap.hhb();
    k(paramLong, paramInt, paramString);
    AppMethodBeat.o(95733);
  }
  
  public final boolean lq(int paramInt1, int paramInt2)
  {
    try
    {
      AppMethodBeat.i(95750);
      this.Qul.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      AppMethodBeat.o(95750);
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final boolean uP(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 479
    //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 59	com/tencent/mm/plugin/sns/model/ai:Quh	Lcom/tencent/mm/plugin/sns/k/c;
    //   12: getfield 454	com/tencent/mm/plugin/sns/k/c:QCA	Ljava/util/LinkedList;
    //   15: invokevirtual 86	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   18: astore 4
    //   20: aload 4
    //   22: invokeinterface 91 1 0
    //   27: ifeq +33 -> 60
    //   30: aload 4
    //   32: invokeinterface 95 1 0
    //   37: checkcast 438	com/tencent/mm/plugin/sns/k/e
    //   40: getfield 441	com/tencent/mm/plugin/sns/k/e:QCF	J
    //   43: lload_1
    //   44: lcmp
    //   45: ifne -25 -> 20
    //   48: iconst_0
    //   49: istore_3
    //   50: ldc_w 479
    //   53: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: aload_0
    //   57: monitorexit
    //   58: iload_3
    //   59: ireturn
    //   60: iconst_1
    //   61: istore_3
    //   62: ldc_w 479
    //   65: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: goto -12 -> 56
    //   71: astore 4
    //   73: aload_0
    //   74: monitorexit
    //   75: aload 4
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	ai
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
  
  public final void uQ(long paramLong)
  {
    try
    {
      AppMethodBeat.i(95726);
      e locale = new e();
      locale.QCF = paramLong;
      locale.QCD = ((int)Util.nowSecond());
      this.Quh.QCA.add(locale);
      hfU();
      AppMethodBeat.o(95726);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final void uR(long paramLong)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(95727);
        Iterator localIterator = this.Quh.QCA.iterator();
        if (localIterator.hasNext())
        {
          e locale = (e)localIterator.next();
          if (locale.QCF != paramLong) {
            continue;
          }
          if (locale != null) {
            this.Quh.QCA.remove(locale);
          }
          hfU();
          AppMethodBeat.o(95727);
          return;
        }
      }
      finally {}
      Object localObject2 = null;
    }
  }
  
  /* Error */
  public final boolean uS(long paramLong)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 487
    //   7: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: new 438	com/tencent/mm/plugin/sns/k/e
    //   13: dup
    //   14: invokespecial 483	com/tencent/mm/plugin/sns/k/e:<init>	()V
    //   17: astore 4
    //   19: aload 4
    //   21: lload_1
    //   22: putfield 441	com/tencent/mm/plugin/sns/k/e:QCF	J
    //   25: aload 4
    //   27: invokestatic 348	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
    //   30: l2i
    //   31: putfield 455	com/tencent/mm/plugin/sns/k/e:QCD	I
    //   34: aload_0
    //   35: getfield 59	com/tencent/mm/plugin/sns/model/ai:Quh	Lcom/tencent/mm/plugin/sns/k/c;
    //   38: getfield 436	com/tencent/mm/plugin/sns/k/c:QCB	Ljava/util/LinkedList;
    //   41: aload 4
    //   43: invokevirtual 357	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   46: pop
    //   47: aload_0
    //   48: invokespecial 323	com/tencent/mm/plugin/sns/model/ai:hfU	()Z
    //   51: pop
    //   52: lload_1
    //   53: aload_0
    //   54: getfield 59	com/tencent/mm/plugin/sns/model/ai:Quh	Lcom/tencent/mm/plugin/sns/k/c;
    //   57: getfield 326	com/tencent/mm/plugin/sns/k/c:QCw	Ljava/util/LinkedList;
    //   60: ldc 32
    //   62: iconst_1
    //   63: invokestatic 77	com/tencent/mm/plugin/sns/model/ai:a	(JLjava/util/LinkedList;Ljava/lang/String;Z)Z
    //   66: ifne +13 -> 79
    //   69: ldc_w 487
    //   72: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: aload_0
    //   76: monitorexit
    //   77: iload_3
    //   78: ireturn
    //   79: iconst_0
    //   80: istore_3
    //   81: ldc_w 487
    //   84: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: goto -12 -> 75
    //   90: astore 4
    //   92: aload_0
    //   93: monitorexit
    //   94: aload 4
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	ai
    //   0	97	1	paramLong	long
    //   1	80	3	bool	boolean
    //   17	25	4	locale	e
    //   90	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	75	90	finally
    //   81	87	90	finally
  }
  
  final boolean uT(long paramLong)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(95738);
        Iterator localIterator = this.Quh.QCB.iterator();
        if (!localIterator.hasNext()) {
          break label99;
        }
        e locale = (e)localIterator.next();
        if (locale.QCF != paramLong) {
          continue;
        }
        if (locale != null)
        {
          this.Quh.QCB.remove(locale);
          bool = true;
          hfU();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ai
 * JD-Core Version:    0.7.0.1
 */