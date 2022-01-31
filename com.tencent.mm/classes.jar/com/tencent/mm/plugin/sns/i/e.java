package com.tencent.mm.plugin.sns.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.d;
import com.tencent.mm.storage.y;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class e
{
  private static final Integer roM;
  public static e roN;
  public y dZQ;
  public int eDB;
  public HashMap<String, Integer> roO;
  public HashMap<String, String> roP;
  public HashSet<String> roQ;
  private LinkedHashMap<Long, Object> roR;
  private int roS;
  public int roT;
  public int roU;
  private com.tencent.mm.sdk.b.c<fb> roV;
  
  static
  {
    AppMethodBeat.i(36891);
    roM = Integer.valueOf(1);
    roN = new e();
    AppMethodBeat.o(36891);
  }
  
  private e()
  {
    AppMethodBeat.i(36883);
    this.roS = 0;
    this.roT = 200;
    this.roU = 86400;
    this.eDB = 0;
    this.roV = new e.2(this);
    Object localObject1 = com.tencent.mm.model.c.c.abU().me("100077");
    if (((com.tencent.mm.storage.c)localObject1).isValid())
    {
      localObject1 = ((com.tencent.mm.storage.c)localObject1).dvN();
      this.roT = bo.getInt((String)((Map)localObject1).get("maxCacheFeedCount"), 200);
      this.roU = bo.getInt((String)((Map)localObject1).get("maxCacheSeconds"), 86400);
      this.eDB = bo.getInt((String)((Map)localObject1).get("needUploadData"), 0);
    }
    ab.i("MicroMsg.SnsReportHelper", "initAbtestArg maxCacheFeedCount:%d, maxCacheSeconds:%d, needUploadData:%d", new Object[] { Integer.valueOf(this.roT), Integer.valueOf(this.roU), Integer.valueOf(this.eDB) });
    cqf();
    this.dZQ = new y(ac.eQv + "snsreport.cfg");
    localObject1 = this.dZQ.get(3, new HashMap());
    Object localObject2 = this.dZQ.get(4, new HashMap());
    Object localObject3 = this.dZQ.get(5, new HashSet());
    Object localObject4 = this.dZQ.get(6, new LinkedHashMap());
    if ((!(localObject1 instanceof HashMap)) || (!(localObject2 instanceof HashMap)) || (!(localObject3 instanceof HashSet)) || (!(localObject4 instanceof LinkedHashMap)))
    {
      com.tencent.mm.vfs.e.deleteFile(ac.eQv + "snsreport.cfg");
      this.roO = new HashMap();
      this.roP = new HashMap();
      this.roQ = new HashSet();
    }
    for (this.roR = new LinkedHashMap();; this.roR = ((LinkedHashMap)localObject4))
    {
      ab.d("MicroMsg.SnsReportHelper", "obj[%d] objForAppId[%d] objForFold[%d] objForAppIdCgi[%d] ", new Object[] { Integer.valueOf(this.roO.size()), Integer.valueOf(this.roP.size()), Integer.valueOf(this.roQ.size()), Integer.valueOf(this.roR.size()) });
      com.tencent.mm.sdk.b.a.ymk.b(this.roV);
      AppMethodBeat.o(36883);
      return;
      this.roO = ((HashMap)localObject1);
      this.roP = ((HashMap)localObject2);
      this.roQ = ((HashSet)localObject3);
    }
  }
  
  private void cqf()
  {
    AppMethodBeat.i(36886);
    this.roS = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lRF, 0);
    ab.i("MicroMsg.SnsReportHelper", "resetXExptControl maxFeedIdForCgiRecord[%d]", new Object[] { Integer.valueOf(this.roS) });
    AppMethodBeat.o(36886);
  }
  
  public final void br(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(36884);
    if (this.eDB == 0)
    {
      AppMethodBeat.o(36884);
      return;
    }
    HashMap localHashMap = this.roO;
    if (this.roO.containsKey(paramString)) {}
    for (int i = ((Integer)this.roO.get(paramString)).intValue() + 1;; i = 1)
    {
      localHashMap.put(paramString, Integer.valueOf(i));
      if (paramBoolean) {
        this.roQ.add(paramString);
      }
      AppMethodBeat.o(36884);
      return;
    }
  }
  
  /* Error */
  public final void cqg()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 249
    //   4: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 59	com/tencent/mm/plugin/sns/i/e:roS	I
    //   11: ifgt +11 -> 22
    //   14: ldc 249
    //   16: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: new 251	com/tencent/mm/plugin/sns/i/e$1
    //   25: dup
    //   26: aload_0
    //   27: aload_0
    //   28: getfield 181	com/tencent/mm/plugin/sns/i/e:roR	Ljava/util/LinkedHashMap;
    //   31: invokevirtual 255	java/util/LinkedHashMap:clone	()Ljava/lang/Object;
    //   34: checkcast 166	java/util/LinkedHashMap
    //   37: invokespecial 258	com/tencent/mm/plugin/sns/i/e$1:<init>	(Lcom/tencent/mm/plugin/sns/i/e;Ljava/util/LinkedHashMap;)V
    //   40: ldc_w 260
    //   43: invokestatic 266	com/tencent/mm/sdk/g/d:post	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   46: ldc 249
    //   48: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: goto -32 -> 19
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	e
    //   54	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	54	finally
    //   22	51	54	finally
  }
  
  public final LinkedList<Long> cqh()
  {
    try
    {
      AppMethodBeat.i(138381);
      Object localObject3 = (LinkedHashMap)this.roR.clone();
      if ((((LinkedHashMap)localObject3).size() <= 0) || (this.roS <= 0))
      {
        localObject1 = null;
        AppMethodBeat.o(138381);
        return localObject1;
      }
      Object localObject1 = new LinkedList();
      int i = 0;
      localObject3 = ((LinkedHashMap)localObject3).keySet().iterator();
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          ((LinkedList)localObject1).addFirst((Long)((Iterator)localObject3).next());
          i += 1;
          if (i > this.roS) {
            ((LinkedList)localObject1).removeLast();
          }
        }
        else
        {
          AppMethodBeat.o(138381);
          break;
        }
      }
    }
    finally {}
  }
  
  public final void gt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(36885);
    if ((this.eDB == 0) || (bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(36885);
      return;
    }
    this.roP.put(paramString1, paramString2);
    AppMethodBeat.o(36885);
  }
  
  public final void lN(long paramLong)
  {
    try
    {
      AppMethodBeat.i(36887);
      if (this.roS > 0) {
        this.roR.put(Long.valueOf(paramLong), roM);
      }
      AppMethodBeat.o(36887);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.i.e
 * JD-Core Version:    0.7.0.1
 */