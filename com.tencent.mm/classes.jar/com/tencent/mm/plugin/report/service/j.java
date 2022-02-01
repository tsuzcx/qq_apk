package com.tencent.mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.k;
import com.tencent.mm.g.a.kw;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.report.a.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class j
  implements ax
{
  private static HashMap<Integer, h.b> ovv;
  private c obZ;
  private r.a ovx;
  
  static
  {
    AppMethodBeat.i(143938);
    HashMap localHashMap = new HashMap();
    ovv = localHashMap;
    localHashMap.put(Integer.valueOf("DUPLICATEKVLOG_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return b.SQL_CREATE;
      }
    });
    AppMethodBeat.o(143938);
  }
  
  public j()
  {
    AppMethodBeat.i(143932);
    this.obZ = new c() {};
    AppMethodBeat.o(143932);
  }
  
  public static j dKs()
  {
    AppMethodBeat.i(143935);
    j localj = (j)t.ap(j.class);
    AppMethodBeat.o(143935);
    return localj;
  }
  
  public static void z(long paramLong, String paramString)
  {
    AppMethodBeat.i(143936);
    kw localkw = new kw();
    localkw.dxY.dxZ = paramLong;
    localkw.dxY.content = paramString;
    a.IbL.l(localkw);
    AppMethodBeat.o(143936);
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
    String str = g.ajC().cachePath + "CommonOneMicroMsg.db";
    this.ovx = r.a(hashCode(), str, ovv, false);
    ad.i("MicroMsg.SubCoreReport", "summeranrt onAccountPostReset tid[%d] [%d]ms, stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - l), bt.flS() });
    a.IbL.c(this.obZ);
    AppMethodBeat.o(143934);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(143933);
    if (dKs() != null)
    {
      j localj = dKs();
      if (localj.ovx != null)
      {
        localj.ovx.qX(localj.hashCode());
        localj.ovx = null;
      }
    }
    a.IbL.d(this.obZ);
    AppMethodBeat.o(143933);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.j
 * JD-Core Version:    0.7.0.1
 */