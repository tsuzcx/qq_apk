package com.tencent.mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class k
  implements aw
{
  private static HashMap<Integer, h.b> npa;
  private c mYr;
  private r.a npc;
  public boolean vIQ;
  public HashMap<String, List<d>> vKN;
  public HashMap<String, String> vKO;
  
  static
  {
    AppMethodBeat.i(143938);
    HashMap localHashMap = new HashMap();
    npa = localHashMap;
    localHashMap.put(Integer.valueOf("DUPLICATEKVLOG_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.report.a.b.SQL_CREATE;
      }
    });
    AppMethodBeat.o(143938);
  }
  
  public k()
  {
    AppMethodBeat.i(143932);
    this.vIQ = false;
    this.mYr = new c() {};
    AppMethodBeat.o(143932);
  }
  
  public static k dkR()
  {
    AppMethodBeat.i(143935);
    k localk = (k)t.ap(k.class);
    AppMethodBeat.o(143935);
    return localk;
  }
  
  public final void am(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(143937);
    if ((this.vIQ) && (this.vKO != null))
    {
      ad.v("MicroMsg.SubCoreReport", "put kv info [%s %s %s]", new Object[] { paramString1, paramString2, paramString3 });
      this.vKO.put(ai.du(paramString1), paramString2 + paramString3);
    }
    AppMethodBeat.o(143937);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void oT(boolean paramBoolean)
  {
    AppMethodBeat.i(193476);
    this.vIQ = paramBoolean;
    e.oQ(this.vIQ);
    com.tencent.mm.plugin.report.a.oQ(this.vIQ);
    AppMethodBeat.o(193476);
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(143934);
    long l = System.currentTimeMillis();
    String str = g.afB().cachePath + "CommonOneMicroMsg.db";
    this.npc = r.a(hashCode(), str, npa, false);
    ad.i("MicroMsg.SubCoreReport", "summeranrt onAccountPostReset tid[%d] [%d]ms, stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - l), bt.eGN() });
    com.tencent.mm.sdk.b.a.ESL.c(this.mYr);
    this.vKN = new HashMap();
    this.vKO = new HashMap();
    AppMethodBeat.o(143934);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(143933);
    if (dkR() != null)
    {
      k localk = dkR();
      if (localk.npc != null)
      {
        localk.npc.pK(localk.hashCode());
        localk.npc = null;
      }
    }
    com.tencent.mm.sdk.b.a.ESL.d(this.mYr);
    if (this.vKN != null) {
      this.vKN.clear();
    }
    if (this.vKO != null) {
      this.vKO.clear();
    }
    AppMethodBeat.o(143933);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  public final void y(long paramLong, String paramString)
  {
    AppMethodBeat.i(143936);
    Object localObject;
    if ((this.vIQ) && (this.vKN != null))
    {
      ad.v("MicroMsg.SubCoreReport", "put kv info [%d %s]", new Object[] { Long.valueOf(paramLong), paramString });
      localObject = (List)this.vKN.get(String.valueOf(paramLong));
      if (localObject == null)
      {
        localObject = new LinkedList();
        bool = false;
        ((List)localObject).add(0, new d(paramLong, paramString, bt.eGO(), bool));
        this.vKN.put(String.valueOf(paramLong), localObject);
        localObject = new kf();
        ((kf)localObject).doB.doC = paramLong;
        ((kf)localObject).doB.content = paramString;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      }
    }
    else
    {
      AppMethodBeat.o(143936);
      return;
    }
    d locald = (d)((List)localObject).get(((List)localObject).size() - 1);
    if (bt.vM(locald.vJM) < 1000L) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        locald.vJO = true;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.k
 * JD-Core Version:    0.7.0.1
 */