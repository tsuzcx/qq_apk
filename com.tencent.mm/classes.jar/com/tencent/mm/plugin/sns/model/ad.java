package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.sns.g.d;
import com.tencent.mm.plugin.sns.g.f;
import com.tencent.mm.protocal.c.bsx;
import com.tencent.mm.protocal.c.bsy;
import com.tencent.mm.protocal.c.btd;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public final class ad
{
  String diG = "";
  private d oro;
  private List<Integer> orp = new Vector();
  private Map<String, Integer> orq = new HashMap();
  private List<Integer> orr = new Vector();
  private Map<Integer, Integer> ors = new HashMap();
  private String path;
  
  public ad(String paramString)
  {
    this.path = paramString;
    if (!bDi()) {
      this.oro = new d();
    }
    this.orp.clear();
    this.orq.clear();
  }
  
  public static boolean Nz(String paramString)
  {
    if (paramString == null) {}
    while (!paramString.startsWith("_AD_TAG_")) {
      return false;
    }
    return true;
  }
  
  private static void a(long paramLong, LinkedList<com.tencent.mm.plugin.sns.g.e> paramLinkedList, String paramString)
  {
    a(paramLong, paramLinkedList, paramString, false);
  }
  
  private static boolean a(long paramLong, LinkedList<com.tencent.mm.plugin.sns.g.e> paramLinkedList, String paramString, boolean paramBoolean)
  {
    Iterator localIterator = paramLinkedList.iterator();
    com.tencent.mm.plugin.sns.g.e locale2;
    do
    {
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        locale2 = (com.tencent.mm.plugin.sns.g.e)localIterator.next();
      } while (locale2.opL.sGd != paramLong);
      locale1 = locale2;
      if (paramBoolean) {
        break;
      }
    } while (!locale2.owY.equals(paramString));
    for (com.tencent.mm.plugin.sns.g.e locale1 = locale2;; locale1 = null)
    {
      if (locale1 != null)
      {
        paramLinkedList.remove(locale1);
        return true;
      }
      return false;
    }
  }
  
  private static boolean a(LinkedList<btd> paramLinkedList, String paramString, int paramInt)
  {
    if (bk.bl(paramString)) {
      return true;
    }
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      btd localbtd = (btd)paramLinkedList.next();
      if ((paramString.equals(localbtd.kVs)) && (paramInt == localbtd.mPL)) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean al(LinkedList<com.tencent.mm.plugin.sns.g.e> paramLinkedList)
  {
    while (!paramLinkedList.isEmpty())
    {
      com.tencent.mm.plugin.sns.g.e locale = (com.tencent.mm.plugin.sns.g.e)paramLinkedList.getFirst();
      if (bk.cn(locale.owZ) > 21600L)
      {
        paramLinkedList.removeFirst();
      }
      else
      {
        if (Nz(locale.owY))
        {
          g.DQ();
          g.DO().dJT.a(new k(locale.opL, locale.owY, locale.oxa), 0);
        }
        for (;;)
        {
          return true;
          g.DQ();
          g.DO().dJT.a(new o(locale.opL, locale.owY), 0);
        }
      }
    }
    return false;
  }
  
  public static btd b(bsy parambsy)
  {
    bsx localbsx = parambsy.tJB;
    parambsy = parambsy.tJC;
    btd localbtd = new btd();
    localbtd.kVs = localbsx.kVs;
    localbtd.mPL = localbsx.mPL;
    localbtd.tqh = localbsx.tJr;
    localbtd.swS = localbsx.swS;
    localbtd.hQR = localbsx.hQR;
    localbtd.sxM = localbsx.tAY;
    localbtd.tJu = localbsx.tJu;
    localbtd.tJx = localbsx.tJx;
    localbtd.tJz = localbsx.tJz;
    localbtd.tJO = parambsy.tAY;
    localbtd.tJw = parambsy.tJw;
    localbtd.tJt = parambsy.tJt;
    return localbtd;
  }
  
  private boolean bDh()
  {
    boolean bool = false;
    try
    {
      byte[] arrayOfByte = this.oro.toByteArray();
      int i = com.tencent.mm.vfs.e.b(this.path, arrayOfByte, arrayOfByte.length);
      if (i == 0) {
        bool = true;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.SnsAsyncQueueMgr", localIOException, "listToFile failed: " + this.path, new Object[0]);
        com.tencent.mm.vfs.e.deleteFile(this.path);
      }
    }
    finally {}
    return bool;
  }
  
  /* Error */
  private boolean bDi()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 43	com/tencent/mm/plugin/sns/model/ad:path	Ljava/lang/String;
    //   6: iconst_0
    //   7: iconst_m1
    //   8: invokestatic 286	com/tencent/mm/vfs/e:c	(Ljava/lang/String;II)[B
    //   11: astore_2
    //   12: aload_2
    //   13: ifnonnull +9 -> 22
    //   16: iconst_0
    //   17: istore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: iload_1
    //   21: ireturn
    //   22: aload_0
    //   23: new 49	com/tencent/mm/plugin/sns/g/d
    //   26: dup
    //   27: invokespecial 50	com/tencent/mm/plugin/sns/g/d:<init>	()V
    //   30: aload_2
    //   31: invokevirtual 290	com/tencent/mm/plugin/sns/g/d:aH	([B)Lcom/tencent/mm/bv/a;
    //   34: checkcast 49	com/tencent/mm/plugin/sns/g/d
    //   37: putfield 52	com/tencent/mm/plugin/sns/model/ad:oro	Lcom/tencent/mm/plugin/sns/g/d;
    //   40: iconst_1
    //   41: istore_1
    //   42: goto -24 -> 18
    //   45: astore_2
    //   46: ldc_w 259
    //   49: aload_2
    //   50: ldc 25
    //   52: iconst_0
    //   53: anewarray 4	java/lang/Object
    //   56: invokestatic 279	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   59: aload_0
    //   60: getfield 43	com/tencent/mm/plugin/sns/model/ad:path	Ljava/lang/String;
    //   63: invokestatic 282	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   66: pop
    //   67: iconst_0
    //   68: istore_1
    //   69: goto -51 -> 18
    //   72: astore_2
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_2
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	ad
    //   17	52	1	bool	boolean
    //   11	20	2	arrayOfByte	byte[]
    //   45	5	2	localIOException	IOException
    //   72	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   22	40	45	java/io/IOException
    //   2	12	72	finally
    //   22	40	72	finally
    //   46	67	72	finally
  }
  
  private void f(long paramLong, int paramInt, String paramString)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        bDh();
        return;
      }
      finally {}
      a(paramLong, this.oro.owS, paramString);
      continue;
      a(paramLong, this.oro.owT, paramString);
      continue;
      a(paramLong, this.oro.owS, paramString);
      continue;
      a(paramLong, this.oro.owT, paramString);
      continue;
      a(paramLong, this.oro.owU, paramString);
      continue;
      a(paramLong, this.oro.owV, paramString);
    }
  }
  
  /* Error */
  public final boolean NA(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 37	com/tencent/mm/plugin/sns/model/ad:orq	Ljava/util/Map;
    //   8: aload_1
    //   9: invokeinterface 313 2 0
    //   14: istore_3
    //   15: iload_3
    //   16: ifeq +7 -> 23
    //   19: aload_0
    //   20: monitorexit
    //   21: iload_2
    //   22: ireturn
    //   23: aload_0
    //   24: getfield 37	com/tencent/mm/plugin/sns/model/ad:orq	Ljava/util/Map;
    //   27: aload_1
    //   28: iconst_0
    //   29: invokestatic 319	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   32: invokeinterface 323 3 0
    //   37: pop
    //   38: iconst_1
    //   39: istore_2
    //   40: goto -21 -> 19
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	ad
    //   0	48	1	paramString	String
    //   1	39	2	bool1	boolean
    //   14	2	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   4	15	43	finally
    //   23	38	43	finally
  }
  
  public final boolean NB(String paramString)
  {
    try
    {
      this.orq.remove(paramString);
      return true;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final boolean a(String paramString, bsy parambsy)
  {
    return a(paramString, parambsy, "");
  }
  
  public final boolean a(String paramString1, bsy parambsy, String paramString2)
  {
    boolean bool2 = true;
    for (;;)
    {
      com.tencent.mm.plugin.sns.g.e locale;
      try
      {
        locale = new com.tencent.mm.plugin.sns.g.e();
        locale.owY = paramString1;
        locale.opL = parambsy;
        locale.owZ = ((int)bk.UX());
        locale.oxa = paramString2;
        bool1 = bool2;
        switch (parambsy.tJB.hQR)
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
          if (!bDh()) {
            y.e("MicroMsg.SnsAsyncQueueMgr", "error listToFile");
          }
          return bool1;
        }
      }
      finally {}
      this.oro.owS.add(locale);
      boolean bool1 = bool2;
      if (gg(parambsy.sGd))
      {
        bool1 = false;
        continue;
        this.oro.owT.add(locale);
        bool1 = bool2;
        continue;
        this.oro.owS.add(locale);
        bool1 = bool2;
        if (gg(parambsy.sGd))
        {
          bool1 = false;
          continue;
          this.oro.owT.add(locale);
          bool1 = bool2;
          continue;
          this.oro.owU.add(locale);
          bool1 = bool2;
          continue;
          this.oro.owV.add(locale);
          bool1 = bool2;
          continue;
          bool1 = bool2;
        }
      }
    }
  }
  
  public final void bDg()
  {
    for (;;)
    {
      try
      {
        boolean bool = al(this.oro.owS);
        if (bool) {
          return;
        }
        if ((al(this.oro.owT)) || (al(this.oro.owU)) || (al(this.oro.owV))) {
          continue;
        }
        if (this.oro.owW.isEmpty()) {
          break label157;
        }
        f localf1 = (f)this.oro.owW.getFirst();
        if (bk.cn(localf1.owZ) > 21600L)
        {
          this.oro.owW.removeFirst();
          continue;
        }
        l = localObject.oxb;
      }
      finally {}
      g.DQ();
      g.DO().dJT.a(new r(l, 1), 0);
      continue;
      label157:
      f localf2;
      while (!this.oro.owX.isEmpty())
      {
        localf2 = (f)this.oro.owX.getFirst();
        if (bk.cn(localf2.owZ) <= 21600L) {
          break label215;
        }
        this.oro.owX.removeFirst();
      }
      continue;
      label215:
      long l = localf2.oxb;
      g.DQ();
      g.DO().dJT.a(new r(l, 5), 0);
    }
  }
  
  public final int bDj()
  {
    try
    {
      int i = this.orq.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final bto c(bto parambto)
  {
    int i;
    long l;
    Iterator localIterator;
    Object localObject1;
    Object localObject2;
    try
    {
      if (bk.bl(this.diG)) {
        this.diG = q.Gj();
      }
      if (this.oro.owS.size() == 0)
      {
        i = this.oro.owT.size();
        if (i == 0) {
          return parambto;
        }
      }
      l = parambto.sGd;
      localIterator = this.oro.owS.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (com.tencent.mm.plugin.sns.g.e)localIterator.next();
        localObject2 = b(((com.tencent.mm.plugin.sns.g.e)localObject1).opL);
        if ((((com.tencent.mm.plugin.sns.g.e)localObject1).opL.sGd == l) && (!a(parambto.tJY, ((btd)localObject2).kVs, ((btd)localObject2).mPL)))
        {
          parambto.tJY.add(localObject2);
          parambto.tJW += 1;
        }
      }
      localIterator = parambto.tJY.iterator();
    }
    finally {}
    label170:
    while (localIterator.hasNext())
    {
      localObject1 = (btd)localIterator.next();
      if (((btd)localObject1).sxM.equals(this.diG))
      {
        i = 0;
        localObject2 = this.oro.owX.iterator();
        label221:
        if (!((Iterator)localObject2).hasNext()) {
          break label377;
        }
        if (((f)((Iterator)localObject2).next()).oxb != l) {
          break label374;
        }
        parambto.tJY.remove(localObject1);
        parambto.tJW -= 1;
        i = 1;
        break label374;
      }
    }
    for (;;)
    {
      localIterator = this.oro.owT.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (com.tencent.mm.plugin.sns.g.e)localIterator.next();
        if (((com.tencent.mm.plugin.sns.g.e)localObject1).opL.sGd == l)
        {
          localObject1 = b(((com.tencent.mm.plugin.sns.g.e)localObject1).opL);
          if (!a(parambto.tKb, ((btd)localObject1).kVs, ((btd)localObject1).mPL))
          {
            parambto.tKb.add(localObject1);
            parambto.tJZ += 1;
          }
        }
      }
      break;
      label374:
      break label221;
      label377:
      if (i == 0) {
        break label170;
      }
    }
  }
  
  public final boolean dM(int paramInt1, int paramInt2)
  {
    try
    {
      this.ors.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void e(long paramLong, int paramInt, String paramString)
  {
    aj.bDX();
    f(paramLong, paramInt, paramString);
  }
  
  /* Error */
  public final boolean gc(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 52	com/tencent/mm/plugin/sns/model/ad:oro	Lcom/tencent/mm/plugin/sns/g/d;
    //   6: getfield 355	com/tencent/mm/plugin/sns/g/d:owW	Ljava/util/LinkedList;
    //   9: invokevirtual 83	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   12: astore 6
    //   14: aload 6
    //   16: invokeinterface 88 1 0
    //   21: ifeq +31 -> 52
    //   24: aload 6
    //   26: invokeinterface 92 1 0
    //   31: checkcast 357	com/tencent/mm/plugin/sns/g/f
    //   34: getfield 361	com/tencent/mm/plugin/sns/g/f:oxb	J
    //   37: lstore_3
    //   38: lload_3
    //   39: lload_1
    //   40: lcmp
    //   41: ifne -27 -> 14
    //   44: iconst_0
    //   45: istore 5
    //   47: aload_0
    //   48: monitorexit
    //   49: iload 5
    //   51: ireturn
    //   52: iconst_1
    //   53: istore 5
    //   55: goto -8 -> 47
    //   58: astore 6
    //   60: aload_0
    //   61: monitorexit
    //   62: aload 6
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	ad
    //   0	65	1	paramLong	long
    //   37	2	3	l	long
    //   45	9	5	bool	boolean
    //   12	13	6	localIterator	Iterator
    //   58	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	58	finally
    //   14	38	58	finally
  }
  
  public final void gd(long paramLong)
  {
    try
    {
      f localf = new f();
      localf.oxb = paramLong;
      localf.owZ = ((int)bk.UX());
      this.oro.owW.add(localf);
      bDh();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final void ge(long paramLong)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = this.oro.owW.iterator();
        if (localIterator.hasNext())
        {
          f localf = (f)localIterator.next();
          if (localf.oxb != paramLong) {
            continue;
          }
          if (localf != null) {
            this.oro.owW.remove(localf);
          }
          bDh();
          return;
        }
      }
      finally {}
      Object localObject2 = null;
    }
  }
  
  /* Error */
  public final boolean gf(long paramLong)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: new 357	com/tencent/mm/plugin/sns/g/f
    //   7: dup
    //   8: invokespecial 413	com/tencent/mm/plugin/sns/g/f:<init>	()V
    //   11: astore 5
    //   13: aload 5
    //   15: lload_1
    //   16: putfield 361	com/tencent/mm/plugin/sns/g/f:oxb	J
    //   19: aload 5
    //   21: invokestatic 336	com/tencent/mm/sdk/platformtools/bk:UX	()J
    //   24: l2i
    //   25: putfield 358	com/tencent/mm/plugin/sns/g/f:owZ	I
    //   28: aload_0
    //   29: getfield 52	com/tencent/mm/plugin/sns/model/ad:oro	Lcom/tencent/mm/plugin/sns/g/d;
    //   32: getfield 369	com/tencent/mm/plugin/sns/g/d:owX	Ljava/util/LinkedList;
    //   35: aload 5
    //   37: invokevirtual 345	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   40: pop
    //   41: aload_0
    //   42: invokespecial 294	com/tencent/mm/plugin/sns/model/ad:bDh	()Z
    //   45: pop
    //   46: lload_1
    //   47: aload_0
    //   48: getfield 52	com/tencent/mm/plugin/sns/model/ad:oro	Lcom/tencent/mm/plugin/sns/g/d;
    //   51: getfield 298	com/tencent/mm/plugin/sns/g/d:owS	Ljava/util/LinkedList;
    //   54: ldc 25
    //   56: iconst_1
    //   57: invokestatic 75	com/tencent/mm/plugin/sns/model/ad:a	(JLjava/util/LinkedList;Ljava/lang/String;Z)Z
    //   60: istore 4
    //   62: iload 4
    //   64: ifne +7 -> 71
    //   67: aload_0
    //   68: monitorexit
    //   69: iload_3
    //   70: ireturn
    //   71: iconst_0
    //   72: istore_3
    //   73: goto -6 -> 67
    //   76: astore 5
    //   78: aload_0
    //   79: monitorexit
    //   80: aload 5
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	ad
    //   0	83	1	paramLong	long
    //   1	72	3	bool1	boolean
    //   60	3	4	bool2	boolean
    //   11	25	5	localf	f
    //   76	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	62	76	finally
  }
  
  final boolean gg(long paramLong)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = this.oro.owX.iterator();
        if (!localIterator.hasNext()) {
          break label87;
        }
        f localf = (f)localIterator.next();
        if (localf.oxb != paramLong) {
          continue;
        }
        if (localf != null)
        {
          this.oro.owX.remove(localf);
          bool = true;
          bDh();
          return bool;
        }
      }
      finally {}
      boolean bool = false;
      continue;
      label87:
      Object localObject2 = null;
    }
  }
  
  public final boolean isDownloading(String paramString)
  {
    try
    {
      boolean bool = this.orq.containsKey(paramString);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final boolean xG(int paramInt)
  {
    try
    {
      boolean bool = this.orp.contains(Integer.valueOf(paramInt));
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final boolean xH(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	com/tencent/mm/plugin/sns/model/ad:orp	Ljava/util/List;
    //   6: iload_1
    //   7: invokestatic 319	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   10: invokeinterface 421 2 0
    //   15: istore_2
    //   16: iload_2
    //   17: ifeq +9 -> 26
    //   20: iconst_0
    //   21: istore_2
    //   22: aload_0
    //   23: monitorexit
    //   24: iload_2
    //   25: ireturn
    //   26: aload_0
    //   27: getfield 32	com/tencent/mm/plugin/sns/model/ad:orp	Ljava/util/List;
    //   30: iload_1
    //   31: invokestatic 319	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   34: invokeinterface 423 2 0
    //   39: pop
    //   40: iconst_1
    //   41: istore_2
    //   42: goto -20 -> 22
    //   45: astore_3
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_3
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	ad
    //   0	50	1	paramInt	int
    //   15	27	2	bool	boolean
    //   45	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	45	finally
    //   26	40	45	finally
  }
  
  public final boolean xI(int paramInt)
  {
    try
    {
      this.orp.remove(Integer.valueOf(paramInt));
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final boolean xJ(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 39	com/tencent/mm/plugin/sns/model/ad:orr	Ljava/util/List;
    //   6: iload_1
    //   7: invokestatic 319	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   10: invokeinterface 421 2 0
    //   15: istore_2
    //   16: iload_2
    //   17: ifeq +9 -> 26
    //   20: iconst_0
    //   21: istore_2
    //   22: aload_0
    //   23: monitorexit
    //   24: iload_2
    //   25: ireturn
    //   26: aload_0
    //   27: getfield 39	com/tencent/mm/plugin/sns/model/ad:orr	Ljava/util/List;
    //   30: iload_1
    //   31: invokestatic 319	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   34: invokeinterface 423 2 0
    //   39: pop
    //   40: iconst_1
    //   41: istore_2
    //   42: goto -20 -> 22
    //   45: astore_3
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_3
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	ad
    //   0	50	1	paramInt	int
    //   15	27	2	bool	boolean
    //   45	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	45	finally
    //   26	40	45	finally
  }
  
  public final boolean xK(int paramInt)
  {
    try
    {
      this.orr.remove(Integer.valueOf(paramInt));
      this.ors.remove(Integer.valueOf(paramInt));
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean xL(int paramInt)
  {
    try
    {
      this.ors.remove(Integer.valueOf(paramInt));
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final int xM(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 41	com/tencent/mm/plugin/sns/model/ad:ors	Ljava/util/Map;
    //   6: iload_1
    //   7: invokestatic 319	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   10: invokeinterface 313 2 0
    //   15: ifeq +27 -> 42
    //   18: aload_0
    //   19: getfield 41	com/tencent/mm/plugin/sns/model/ad:ors	Ljava/util/Map;
    //   22: iload_1
    //   23: invokestatic 319	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   26: invokeinterface 433 2 0
    //   31: checkcast 315	java/lang/Integer
    //   34: invokevirtual 436	java/lang/Integer:intValue	()I
    //   37: istore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: iload_1
    //   41: ireturn
    //   42: iconst_m1
    //   43: istore_1
    //   44: goto -6 -> 38
    //   47: astore_2
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_2
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	ad
    //   0	52	1	paramInt	int
    //   47	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	38	47	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ad
 * JD-Core Version:    0.7.0.1
 */