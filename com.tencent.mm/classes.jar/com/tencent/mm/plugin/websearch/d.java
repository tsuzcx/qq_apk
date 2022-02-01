package com.tencent.mm.plugin.websearch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.protocal.protobuf.cf;
import com.tencent.mm.protocal.protobuf.cg;
import com.tencent.mm.protocal.protobuf.cot;
import com.tencent.mm.protocal.protobuf.cou;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class d
  implements j
{
  private int PxD;
  private Map<String, String> PxE;
  
  public d()
  {
    AppMethodBeat.i(116549);
    this.PxE = new HashMap();
    AppMethodBeat.o(116549);
  }
  
  public final void anb(int paramInt)
  {
    this.PxD = paramInt;
  }
  
  public final String biH(String paramString)
  {
    AppMethodBeat.i(116553);
    paramString = (String)this.PxE.get(paramString);
    AppMethodBeat.o(116553);
    return paramString;
  }
  
  public final void cM(int paramInt, String paramString)
  {
    AppMethodBeat.i(116550);
    cou localcou = new cou();
    localcou.Twy = paramInt;
    localcou.TwG = ((int)(System.currentTimeMillis() / 1000L));
    localcou.rVx = 1;
    localcou.Twz = new b(paramString.getBytes());
    paramString = new d.a();
    paramString.lBU = new cf();
    paramString.lBV = new cg();
    paramString.uri = "/cgi-bin/mmux-bin/adlog";
    paramString.funcId = 1802;
    paramString = paramString.bgN();
    cf localcf = (cf)d.b.b(paramString.lBR);
    cot localcot = new cot();
    localcot.jUb = com.tencent.mm.protocal.d.RAx;
    localcot.jUc = com.tencent.mm.protocal.d.RAw;
    localcot.jUd = com.tencent.mm.protocal.d.RAz;
    localcot.jUe = com.tencent.mm.protocal.d.RAA;
    localcot.jUf = LocaleUtil.getApplicationLanguage();
    localcot.TwF = ((int)(System.currentTimeMillis() / 1000L));
    localcf.RHS = localcot;
    localcf.RHT.add(localcou);
    aa.a(paramString, new aa.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.d paramAnonymousd, q paramAnonymousq)
      {
        AppMethodBeat.i(116548);
        Log.d("WebSearchService", "onGYNetEnd oreh errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
          h.IzE.idkeyStat(457L, 1L, 1L, false);
        }
        AppMethodBeat.o(116548);
        return 0;
      }
    });
    AppMethodBeat.o(116550);
  }
  
  public final int gQk()
  {
    return this.PxD;
  }
  
  public final String gQl()
  {
    AppMethodBeat.i(116551);
    String str = ai.ank(3);
    AppMethodBeat.o(116551);
    return str;
  }
  
  public final void me(String paramString1, String paramString2)
  {
    AppMethodBeat.i(116552);
    this.PxE.put(paramString1, paramString2);
    AppMethodBeat.o(116552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.d
 * JD-Core Version:    0.7.0.1
 */