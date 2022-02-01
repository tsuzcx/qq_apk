package com.tencent.mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.k;
import com.tencent.mm.g.a.kx;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.report.a.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class j
  implements az
{
  private static HashMap<Integer, h.b> oBW;
  private r.a oBY;
  private c ohN;
  
  static
  {
    AppMethodBeat.i(143938);
    HashMap localHashMap = new HashMap();
    oBW = localHashMap;
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
    this.ohN = new c() {};
    AppMethodBeat.o(143932);
  }
  
  public static void A(long paramLong, String paramString)
  {
    AppMethodBeat.i(143936);
    kx localkx = new kx();
    localkx.dzd.dze = paramLong;
    localkx.dzd.content = paramString;
    a.IvT.l(localkx);
    AppMethodBeat.o(143936);
  }
  
  public static j dNK()
  {
    AppMethodBeat.i(143935);
    j localj = (j)u.ap(j.class);
    AppMethodBeat.o(143935);
    return localj;
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
    String str = g.ajR().cachePath + "CommonOneMicroMsg.db";
    this.oBY = r.a(hashCode(), str, oBW, false);
    ae.i("MicroMsg.SubCoreReport", "summeranrt onAccountPostReset tid[%d] [%d]ms, stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - l), bu.fpN() });
    a.IvT.c(this.ohN);
    AppMethodBeat.o(143934);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(143933);
    if (dNK() != null)
    {
      j localj = dNK();
      if (localj.oBY != null)
      {
        localj.oBY.ra(localj.hashCode());
        localj.oBY = null;
      }
    }
    a.IvT.d(this.ohN);
    AppMethodBeat.o(143933);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.j
 * JD-Core Version:    0.7.0.1
 */