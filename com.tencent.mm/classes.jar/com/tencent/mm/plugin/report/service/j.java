package com.tencent.mm.plugin.report.service;

import com.tencent.mm.cf.h.d;
import com.tencent.mm.h.a.k;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.p;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.platformtools.t.a;
import com.tencent.mm.plugin.report.a.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class j
  implements ar
{
  private static HashMap<Integer, h.d> iiX;
  private c ihk = new c() {};
  private t.a iiZ;
  public boolean nEB = false;
  public HashMap<String, List<d>> nGi;
  public HashMap<String, String> nGj;
  
  static
  {
    HashMap localHashMap = new HashMap();
    iiX = localHashMap;
    localHashMap.put(Integer.valueOf("DUPLICATEKVLOG_TABLE".hashCode()), new h.d()
    {
      public final String[] rK()
      {
        return b.dXp;
      }
    });
  }
  
  public static j bxa()
  {
    return (j)p.B(j.class);
  }
  
  public final void bh(boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    String str = g.DP().cachePath + "CommonOneMicroMsg.db";
    this.iiZ = t.a(hashCode(), str, iiX, false);
    y.i("MicroMsg.SubCoreReport", "summeranrt onAccountPostReset tid[%d] [%d]ms, stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - l), bk.csb() });
    a.udP.c(this.ihk);
    this.nGi = new HashMap();
    this.nGj = new HashMap();
    g.DQ();
    g.DS().O(new Runnable()
    {
      public final void run()
      {
        if (!g.DK()) {
          return;
        }
        bk.h(g.DP().cachePath + "logcat/", "temp_", 10800000L);
      }
      
      public final String toString()
      {
        return super.toString() + "|onAccountPostReset";
      }
    });
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    if (bxa() != null)
    {
      j localj = bxa();
      if (localj.iiZ != null)
      {
        localj.iiZ.jK(localj.hashCode());
        localj.iiZ = null;
      }
    }
    a.udP.d(this.ihk);
    if (this.nGi != null) {
      this.nGi.clear();
    }
    if (this.nGj != null) {
      this.nGj.clear();
    }
  }
  
  public final void s(long paramLong, String paramString)
  {
    Object localObject;
    if ((this.nEB) && (this.nGi != null))
    {
      y.v("MicroMsg.SubCoreReport", "put kv info [%d %s]", new Object[] { Long.valueOf(paramLong), paramString });
      localObject = (List)this.nGi.get(String.valueOf(paramLong));
      if (localObject == null)
      {
        localObject = new LinkedList();
        bool = false;
        ((List)localObject).add(0, new d(paramLong, paramString, bk.UY(), bool));
        this.nGi.put(String.valueOf(paramLong), localObject);
      }
    }
    else
    {
      return;
    }
    d locald = (d)((List)localObject).get(((List)localObject).size() - 1);
    if (bk.co(locald.nFv) < 1000L) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        locald.nFx = true;
      }
      break;
    }
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.j
 * JD-Core Version:    0.7.0.1
 */