package com.tencent.mm.plugin.websearch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.bny;
import com.tencent.mm.protocal.protobuf.bnz;
import com.tencent.mm.protocal.protobuf.by;
import com.tencent.mm.protocal.protobuf.bz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class c
  implements i
{
  private int BXY;
  private Map<String, String> BXZ;
  
  public c()
  {
    AppMethodBeat.i(116549);
    this.BXZ = new HashMap();
    AppMethodBeat.o(116549);
  }
  
  public final void Uf(int paramInt)
  {
    this.BXY = paramInt;
  }
  
  public final String aAo(String paramString)
  {
    AppMethodBeat.i(116553);
    paramString = (String)this.BXZ.get(paramString);
    AppMethodBeat.o(116553);
    return paramString;
  }
  
  public final void cl(int paramInt, String paramString)
  {
    AppMethodBeat.i(116550);
    bnz localbnz = new bnz();
    localbnz.Fdx = paramInt;
    localbnz.FdE = ((int)(System.currentTimeMillis() / 1000L));
    localbnz.ncL = 1;
    localbnz.Fdy = new com.tencent.mm.bw.b(paramString.getBytes());
    paramString = new b.a();
    paramString.hvt = new by();
    paramString.hvu = new bz();
    paramString.uri = "/cgi-bin/mmux-bin/adlog";
    paramString.funcId = 1802;
    paramString = paramString.aAz();
    by localby = (by)paramString.hvr.hvw;
    bny localbny = new bny();
    localbny.fZq = d.DHX;
    localbny.fZr = d.DHW;
    localbny.fZs = d.DHZ;
    localbny.fZt = d.DIa;
    localbny.fZu = ab.eUO();
    localbny.EIx = ((int)(System.currentTimeMillis() / 1000L));
    localby.DPn = localbny;
    localby.DPo.add(localbnz);
    x.a(paramString, new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(116548);
        ac.d("WebSearchService", "onGYNetEnd oreh errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
          h.wUl.idkeyStat(457L, 1L, 1L, false);
        }
        AppMethodBeat.o(116548);
        return 0;
      }
    });
    AppMethodBeat.o(116550);
  }
  
  public final int ewU()
  {
    return this.BXY;
  }
  
  public final String ewV()
  {
    AppMethodBeat.i(116551);
    String str = z.Un(3);
    AppMethodBeat.o(116551);
    return str;
  }
  
  public final void ke(String paramString1, String paramString2)
  {
    AppMethodBeat.i(116552);
    this.BXZ.put(paramString1, paramString2);
    AppMethodBeat.o(116552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.c
 * JD-Core Version:    0.7.0.1
 */