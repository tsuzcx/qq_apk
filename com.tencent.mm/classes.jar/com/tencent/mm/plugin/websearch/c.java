package com.tencent.mm.plugin.websearch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.w;
import com.tencent.mm.plugin.websearch.a.a;
import com.tencent.mm.plugin.websearch.api.n;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.ayw;
import com.tencent.mm.protocal.protobuf.ayx;
import com.tencent.mm.protocal.protobuf.bq;
import com.tencent.mm.protocal.protobuf.br;
import com.tencent.mm.sdk.platformtools.aa;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class c
  implements n
{
  private int uIy;
  private Map<String, String> uIz;
  
  public c()
  {
    AppMethodBeat.i(91352);
    this.uIz = new HashMap();
    AppMethodBeat.o(91352);
  }
  
  public final void IW(int paramInt)
  {
    this.uIy = paramInt;
  }
  
  public final String agm(String paramString)
  {
    AppMethodBeat.i(91356);
    paramString = (String)this.uIz.get(paramString);
    AppMethodBeat.o(91356);
    return paramString;
  }
  
  public final void bw(int paramInt, String paramString)
  {
    AppMethodBeat.i(91353);
    ayx localayx = new ayx();
    localayx.xoo = paramInt;
    localayx.xov = ((int)(System.currentTimeMillis() / 1000L));
    localayx.jJu = 1;
    localayx.xop = new com.tencent.mm.bv.b(paramString.getBytes());
    paramString = new b.a();
    paramString.fsX = new bq();
    paramString.fsY = new br();
    paramString.uri = "/cgi-bin/mmux-bin/adlog";
    paramString.funcId = 1802;
    paramString = paramString.ado();
    bq localbq = (bq)paramString.fsV.fta;
    ayw localayw = new ayw();
    localayw.wAb = d.whC;
    localayw.wAc = d.whB;
    localayw.wAd = d.whE;
    localayw.wAe = d.whF;
    localayw.wAf = aa.dsG();
    localayw.wWT = ((int)(System.currentTimeMillis() / 1000L));
    localbq.woj = localayw;
    localbq.wok.add(localayx);
    w.a(paramString, new c.1(this));
    AppMethodBeat.o(91353);
  }
  
  public final int cYY()
  {
    return this.uIy;
  }
  
  public final String cYZ()
  {
    AppMethodBeat.i(91354);
    String str = a.aLw();
    AppMethodBeat.o(91354);
    return str;
  }
  
  public final void hf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(91355);
    this.uIz.put(paramString1, paramString2);
    AppMethodBeat.o(91355);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.c
 * JD-Core Version:    0.7.0.1
 */