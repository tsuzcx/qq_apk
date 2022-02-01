package com.tencent.mm.plugin.websearch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.protocal.protobuf.cfx;
import com.tencent.mm.protocal.protobuf.cfy;
import com.tencent.mm.protocal.protobuf.ch;
import com.tencent.mm.protocal.protobuf.ci;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class c
  implements j
{
  private int IDn;
  private Map<String, String> IDo;
  
  public c()
  {
    AppMethodBeat.i(116549);
    this.IDo = new HashMap();
    AppMethodBeat.o(116549);
  }
  
  public final String aWW(String paramString)
  {
    AppMethodBeat.i(116553);
    paramString = (String)this.IDo.get(paramString);
    AppMethodBeat.o(116553);
    return paramString;
  }
  
  public final void afn(int paramInt)
  {
    this.IDn = paramInt;
  }
  
  public final void cL(int paramInt, String paramString)
  {
    AppMethodBeat.i(116550);
    cfy localcfy = new cfy();
    localcfy.MlF = paramInt;
    localcfy.MlM = ((int)(System.currentTimeMillis() / 1000L));
    localcfy.oTz = 1;
    localcfy.MlG = new b(paramString.getBytes());
    paramString = new d.a();
    paramString.iLN = new ch();
    paramString.iLO = new ci();
    paramString.uri = "/cgi-bin/mmux-bin/adlog";
    paramString.funcId = 1802;
    paramString = paramString.aXF();
    ch localch = (ch)paramString.iLK.iLR;
    cfx localcfx = new cfx();
    localcfx.hid = com.tencent.mm.protocal.d.KyJ;
    localcfx.hie = com.tencent.mm.protocal.d.KyI;
    localcfx.hif = com.tencent.mm.protocal.d.KyL;
    localcfx.hig = com.tencent.mm.protocal.d.KyM;
    localcfx.hih = LocaleUtil.getApplicationLanguage();
    localcfx.LOF = ((int)(System.currentTimeMillis() / 1000L));
    localch.KGA = localcfx;
    localch.KGB.add(localcfy);
    aa.a(paramString, new aa.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.d paramAnonymousd, q paramAnonymousq)
      {
        AppMethodBeat.i(116548);
        Log.d("WebSearchService", "onGYNetEnd oreh errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
          h.CyF.idkeyStat(457L, 1L, 1L, false);
        }
        AppMethodBeat.o(116548);
        return 0;
      }
    });
    AppMethodBeat.o(116550);
  }
  
  public final int fXx()
  {
    return this.IDn;
  }
  
  public final String fXy()
  {
    AppMethodBeat.i(116551);
    String str = ai.afw(3);
    AppMethodBeat.o(116551);
    return str;
  }
  
  public final void lF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(116552);
    this.IDo.put(paramString1, paramString2);
    AppMethodBeat.o(116552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.c
 * JD-Core Version:    0.7.0.1
 */