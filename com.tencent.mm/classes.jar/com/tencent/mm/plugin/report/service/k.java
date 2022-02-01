package com.tencent.mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class k
  implements aw
{
  private static HashMap<Integer, h.b> nSa;
  private c nAQ;
  private r.a nSc;
  public boolean wSU;
  public HashMap<String, List<d>> wUR;
  public HashMap<String, String> wUS;
  
  static
  {
    AppMethodBeat.i(143938);
    HashMap localHashMap = new HashMap();
    nSa = localHashMap;
    localHashMap.put(Integer.valueOf("DUPLICATEKVLOG_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.report.b.b.SQL_CREATE;
      }
    });
    AppMethodBeat.o(143938);
  }
  
  public k()
  {
    AppMethodBeat.i(143932);
    this.wSU = false;
    this.nAQ = new c() {};
    AppMethodBeat.o(143932);
  }
  
  public static k dyU()
  {
    AppMethodBeat.i(143935);
    k localk = (k)t.ap(k.class);
    AppMethodBeat.o(143935);
    return localk;
  }
  
  public final void an(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(143937);
    if ((this.wSU) && (this.wUS != null))
    {
      ac.v("MicroMsg.SubCoreReport", "put kv info [%s %s %s]", new Object[] { paramString1, paramString2, paramString3 });
      this.wUS.put(ah.dg(paramString1), paramString2 + paramString3);
    }
    AppMethodBeat.o(143937);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(143934);
    long l = System.currentTimeMillis();
    String str = g.agR().cachePath + "CommonOneMicroMsg.db";
    this.nSc = r.a(hashCode(), str, nSa, false);
    ac.i("MicroMsg.SubCoreReport", "summeranrt onAccountPostReset tid[%d] [%d]ms, stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - l), bs.eWi() });
    com.tencent.mm.sdk.b.a.GpY.c(this.nAQ);
    this.wUR = new HashMap();
    this.wUS = new HashMap();
    AppMethodBeat.o(143934);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(143933);
    if (dyU() != null)
    {
      k localk = dyU();
      if (localk.nSc != null)
      {
        localk.nSc.qx(localk.hashCode());
        localk.nSc = null;
      }
    }
    com.tencent.mm.sdk.b.a.GpY.d(this.nAQ);
    if (this.wUR != null) {
      this.wUR.clear();
    }
    if (this.wUS != null) {
      this.wUS.clear();
    }
    AppMethodBeat.o(143933);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  public final void pR(boolean paramBoolean)
  {
    AppMethodBeat.i(206470);
    this.wSU = paramBoolean;
    e.pO(this.wSU);
    com.tencent.mm.plugin.report.a.pO(this.wSU);
    AppMethodBeat.o(206470);
  }
  
  public final void w(long paramLong, String paramString)
  {
    AppMethodBeat.i(143936);
    Object localObject;
    if ((this.wSU) && (this.wUR != null))
    {
      ac.v("MicroMsg.SubCoreReport", "put kv info [%d %s]", new Object[] { Long.valueOf(paramLong), paramString });
      localObject = (List)this.wUR.get(String.valueOf(paramLong));
      if (localObject == null)
      {
        localObject = new LinkedList();
        bool = false;
        ((List)localObject).add(0, new d(paramLong, paramString, bs.eWj(), bool));
        this.wUR.put(String.valueOf(paramLong), localObject);
        localObject = new kn();
        ((kn)localObject).dmk.dml = paramLong;
        ((kn)localObject).dmk.content = paramString;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      }
    }
    else
    {
      AppMethodBeat.o(143936);
      return;
    }
    d locald = (d)((List)localObject).get(((List)localObject).size() - 1);
    if (bs.Ap(locald.wTQ) < 1000L) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        locald.wTS = true;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.k
 * JD-Core Version:    0.7.0.1
 */