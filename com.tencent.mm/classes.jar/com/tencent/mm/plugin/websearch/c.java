package com.tencent.mm.plugin.websearch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.bte;
import com.tencent.mm.protocal.protobuf.btf;
import com.tencent.mm.protocal.protobuf.by;
import com.tencent.mm.protocal.protobuf.bz;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class c
  implements j
{
  private int DSN;
  private Map<String, String> DSO;
  
  public c()
  {
    AppMethodBeat.i(116549);
    this.DSO = new HashMap();
    AppMethodBeat.o(116549);
  }
  
  public final void WF(int paramInt)
  {
    this.DSN = paramInt;
  }
  
  public final String aHc(String paramString)
  {
    AppMethodBeat.i(116553);
    paramString = (String)this.DSO.get(paramString);
    AppMethodBeat.o(116553);
    return paramString;
  }
  
  public final void ct(int paramInt, String paramString)
  {
    AppMethodBeat.i(116550);
    btf localbtf = new btf();
    localbtf.HgA = paramInt;
    localbtf.HgH = ((int)(System.currentTimeMillis() / 1000L));
    localbtf.nID = 1;
    localbtf.HgB = new com.tencent.mm.bw.b(paramString.getBytes());
    paramString = new b.a();
    paramString.hQF = new by();
    paramString.hQG = new bz();
    paramString.uri = "/cgi-bin/mmux-bin/adlog";
    paramString.funcId = 1802;
    paramString = paramString.aDS();
    by localby = (by)paramString.hQD.hQJ;
    bte localbte = new bte();
    localbte.gvo = d.FFC;
    localbte.gvp = d.FFB;
    localbte.gvq = d.FFE;
    localbte.gvr = d.FFF;
    localbte.gvs = com.tencent.mm.sdk.platformtools.ad.fom();
    localbte.GKM = ((int)(System.currentTimeMillis() / 1000L));
    localby.FMV = localbte;
    localby.FMW.add(localbtf);
    x.a(paramString, new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(116548);
        ae.d("WebSearchService", "onGYNetEnd oreh errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
          g.yxI.idkeyStat(457L, 1L, 1L, false);
        }
        AppMethodBeat.o(116548);
        return 0;
      }
    });
    AppMethodBeat.o(116550);
  }
  
  public final int ePr()
  {
    return this.DSN;
  }
  
  public final String ePs()
  {
    AppMethodBeat.i(116551);
    String str = com.tencent.mm.plugin.websearch.api.ad.WN(3);
    AppMethodBeat.o(116551);
    return str;
  }
  
  public final void kJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(116552);
    this.DSO.put(paramString1, paramString2);
    AppMethodBeat.o(116552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.c
 * JD-Core Version:    0.7.0.1
 */