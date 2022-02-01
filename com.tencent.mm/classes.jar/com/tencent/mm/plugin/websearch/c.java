package com.tencent.mm.plugin.websearch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.bsk;
import com.tencent.mm.protocal.protobuf.bsl;
import com.tencent.mm.protocal.protobuf.by;
import com.tencent.mm.protocal.protobuf.bz;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class c
  implements j
{
  private int DAQ;
  private Map<String, String> DAR;
  
  public c()
  {
    AppMethodBeat.i(116549);
    this.DAR = new HashMap();
    AppMethodBeat.o(116549);
  }
  
  public final void VY(int paramInt)
  {
    this.DAQ = paramInt;
  }
  
  public final String aFI(String paramString)
  {
    AppMethodBeat.i(116553);
    paramString = (String)this.DAR.get(paramString);
    AppMethodBeat.o(116553);
    return paramString;
  }
  
  public final void ct(int paramInt, String paramString)
  {
    AppMethodBeat.i(116550);
    bsl localbsl = new bsl();
    localbsl.GNa = paramInt;
    localbsl.GNh = ((int)(System.currentTimeMillis() / 1000L));
    localbsl.nDi = 1;
    localbsl.GNb = new com.tencent.mm.bx.b(paramString.getBytes());
    paramString = new b.a();
    paramString.hNM = new by();
    paramString.hNN = new bz();
    paramString.uri = "/cgi-bin/mmux-bin/adlog";
    paramString.funcId = 1802;
    paramString = paramString.aDC();
    by localby = (by)paramString.hNK.hNQ;
    bsk localbsk = new bsk();
    localbsk.gsM = d.Fne;
    localbsk.gsN = d.Fnd;
    localbsk.gsO = d.Fng;
    localbsk.gsP = d.Fnh;
    localbsk.gsQ = ac.fks();
    localbsk.Gro = ((int)(System.currentTimeMillis() / 1000L));
    localby.Fux = localbsk;
    localby.Fuy.add(localbsl);
    x.a(paramString, new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(116548);
        com.tencent.mm.sdk.platformtools.ad.d("WebSearchService", "onGYNetEnd oreh errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
          g.yhR.idkeyStat(457L, 1L, 1L, false);
        }
        AppMethodBeat.o(116548);
        return 0;
      }
    });
    AppMethodBeat.o(116550);
  }
  
  public final int eLI()
  {
    return this.DAQ;
  }
  
  public final String eLJ()
  {
    AppMethodBeat.i(116551);
    String str = com.tencent.mm.plugin.websearch.api.ad.Wg(3);
    AppMethodBeat.o(116551);
    return str;
  }
  
  public final void kC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(116552);
    this.DAR.put(paramString1, paramString2);
    AppMethodBeat.o(116552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.c
 * JD-Core Version:    0.7.0.1
 */