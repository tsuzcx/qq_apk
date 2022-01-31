package com.tencent.mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.g.a.k;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.platformtools.t.a;
import com.tencent.mm.plugin.report.a.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class j
  implements at
{
  private static HashMap<Integer, h.d> kjX;
  private c jXg;
  private t.a kjZ;
  public boolean qrC;
  public HashMap<String, List<d>> qtl;
  public HashMap<String, String> qtm;
  
  static
  {
    AppMethodBeat.i(72814);
    HashMap localHashMap = new HashMap();
    kjX = localHashMap;
    localHashMap.put(Integer.valueOf("DUPLICATEKVLOG_TABLE".hashCode()), new h.d()
    {
      public final String[] getSQLs()
      {
        return b.SQL_CREATE;
      }
    });
    AppMethodBeat.o(72814);
  }
  
  public j()
  {
    AppMethodBeat.i(72808);
    this.qrC = false;
    this.jXg = new c() {};
    AppMethodBeat.o(72808);
  }
  
  public static j chT()
  {
    AppMethodBeat.i(72811);
    j localj = (j)q.S(j.class);
    AppMethodBeat.o(72811);
    return localj;
  }
  
  public final void ad(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(72813);
    if ((this.qrC) && (this.qtm != null))
    {
      ab.v("MicroMsg.SubCoreReport", "put kv info [%s %s %s]", new Object[] { paramString1, paramString2, paramString3 });
      this.qtm.put(ag.cE(paramString1), paramString2 + paramString3);
    }
    AppMethodBeat.o(72813);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(72810);
    long l = System.currentTimeMillis();
    String str = g.RL().cachePath + "CommonOneMicroMsg.db";
    this.kjZ = t.a(hashCode(), str, kjX, false);
    ab.i("MicroMsg.SubCoreReport", "summeranrt onAccountPostReset tid[%d] [%d]ms, stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - l), bo.dtY() });
    a.ymk.c(this.jXg);
    this.qtl = new HashMap();
    this.qtm = new HashMap();
    AppMethodBeat.o(72810);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(72809);
    if (chT() != null)
    {
      j localj = chT();
      if (localj.kjZ != null)
      {
        localj.kjZ.mG(localj.hashCode());
        localj.kjZ = null;
      }
    }
    a.ymk.d(this.jXg);
    if (this.qtl != null) {
      this.qtl.clear();
    }
    if (this.qtm != null) {
      this.qtm.clear();
    }
    AppMethodBeat.o(72809);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  public final void t(long paramLong, String paramString)
  {
    AppMethodBeat.i(72812);
    Object localObject;
    if ((this.qrC) && (this.qtl != null))
    {
      ab.v("MicroMsg.SubCoreReport", "put kv info [%d %s]", new Object[] { Long.valueOf(paramLong), paramString });
      localObject = (List)this.qtl.get(String.valueOf(paramLong));
      if (localObject == null)
      {
        localObject = new LinkedList();
        bool = false;
        ((List)localObject).add(0, new d(paramLong, paramString, bo.aoy(), bool));
        this.qtl.put(String.valueOf(paramLong), localObject);
      }
    }
    else
    {
      AppMethodBeat.o(72812);
      return;
    }
    d locald = (d)((List)localObject).get(((List)localObject).size() - 1);
    if (bo.hl(locald.qsy) < 1000L) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        locald.qsA = true;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.j
 * JD-Core Version:    0.7.0.1
 */