package com.tencent.mm.plugin.websearch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.protocal.protobuf.bkf;
import com.tencent.mm.protocal.protobuf.bw;
import com.tencent.mm.protocal.protobuf.bx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class c
  implements j
{
  private int AFF;
  private Map<String, String> AFG;
  
  public c()
  {
    AppMethodBeat.i(116549);
    this.AFG = new HashMap();
    AppMethodBeat.o(116549);
  }
  
  public final void RV(int paramInt)
  {
    this.AFF = paramInt;
  }
  
  public final String auX(String paramString)
  {
    AppMethodBeat.i(116553);
    paramString = (String)this.AFG.get(paramString);
    AppMethodBeat.o(116553);
    return paramString;
  }
  
  public final void ci(int paramInt, String paramString)
  {
    AppMethodBeat.i(116550);
    bkf localbkf = new bkf();
    localbkf.DIc = paramInt;
    localbkf.DIj = ((int)(System.currentTimeMillis() / 1000L));
    localbkf.mAK = 1;
    localbkf.DId = new com.tencent.mm.bx.b(paramString.getBytes());
    paramString = new b.a();
    paramString.gUU = new bw();
    paramString.gUV = new bx();
    paramString.uri = "/cgi-bin/mmux-bin/adlog";
    paramString.funcId = 1802;
    paramString = paramString.atI();
    bw localbw = (bw)paramString.gUS.gUX;
    bke localbke = new bke();
    localbke.fVv = d.CpF;
    localbke.fVw = d.CpE;
    localbke.fVx = d.CpH;
    localbke.fVy = d.CpI;
    localbke.fVz = ac.eFu();
    localbke.Dnx = ((int)(System.currentTimeMillis() / 1000L));
    localbw.CwR = localbke;
    localbw.CwS.add(localbkf);
    x.a(paramString, new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(116548);
        ad.d("WebSearchService", "onGYNetEnd oreh errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
          h.vKh.idkeyStat(457L, 1L, 1L, false);
        }
        AppMethodBeat.o(116548);
        return 0;
      }
    });
    AppMethodBeat.o(116550);
  }
  
  public final int ehA()
  {
    return this.AFF;
  }
  
  public final String ehB()
  {
    AppMethodBeat.i(116551);
    String str = aa.Sd(3);
    AppMethodBeat.o(116551);
    return str;
  }
  
  public final void jI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(116552);
    this.AFG.put(paramString1, paramString2);
    AppMethodBeat.o(116552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.c
 * JD-Core Version:    0.7.0.1
 */