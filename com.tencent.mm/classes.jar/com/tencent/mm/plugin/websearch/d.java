package com.tencent.mm.plugin.websearch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z;
import com.tencent.mm.am.z.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.protocal.protobuf.cp;
import com.tencent.mm.protocal.protobuf.cq;
import com.tencent.mm.protocal.protobuf.dfn;
import com.tencent.mm.protocal.protobuf.dfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class d
  implements j
{
  private int WnJ;
  private Map<String, String> WnK;
  
  public d()
  {
    AppMethodBeat.i(116549);
    this.WnK = new HashMap();
    AppMethodBeat.o(116549);
  }
  
  public final void asS(int paramInt)
  {
    this.WnJ = paramInt;
  }
  
  public final String bip(String paramString)
  {
    AppMethodBeat.i(116553);
    paramString = (String)this.WnK.get(paramString);
    AppMethodBeat.o(116553);
    return paramString;
  }
  
  public final void dB(int paramInt, String paramString)
  {
    AppMethodBeat.i(116550);
    dfo localdfo = new dfo();
    localdfo.aaLf = paramInt;
    localdfo.aaLn = ((int)(System.currentTimeMillis() / 1000L));
    localdfo.vgN = 1;
    localdfo.aaLg = new b(paramString.getBytes());
    paramString = new c.a();
    paramString.otE = new cp();
    paramString.otF = new cq();
    paramString.uri = "/cgi-bin/mmux-bin/adlog";
    paramString.funcId = 1802;
    paramString = paramString.bEF();
    cp localcp = (cp)c.b.b(paramString.otB);
    dfn localdfn = new dfn();
    localdfn.mut = com.tencent.mm.protocal.d.Yxb;
    localdfn.muu = com.tencent.mm.protocal.d.Yxa;
    localdfn.muv = com.tencent.mm.protocal.d.Yxd;
    localdfn.muw = com.tencent.mm.protocal.d.Yxe;
    localdfn.mux = LocaleUtil.getApplicationLanguage();
    localdfn.aaLm = ((int)(System.currentTimeMillis() / 1000L));
    localcp.YEV = localdfn;
    localcp.YEW.add(localdfo);
    z.a(paramString, new z.a()
    {
      public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, c paramAnonymousc, p paramAnonymousp)
      {
        AppMethodBeat.i(116548);
        Log.d("WebSearchService", "onGYNetEnd oreh errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
          h.OAn.idkeyStat(457L, 1L, 1L, false);
        }
        AppMethodBeat.o(116548);
        return 0;
      }
    });
    AppMethodBeat.o(116550);
  }
  
  public final int ipB()
  {
    return this.WnJ;
  }
  
  public final String ipC()
  {
    AppMethodBeat.i(116551);
    String str = aj.atb(3);
    AppMethodBeat.o(116551);
    return str;
  }
  
  public final void nQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(116552);
    this.WnK.put(paramString1, paramString2);
    AppMethodBeat.o(116552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.d
 * JD-Core Version:    0.7.0.1
 */