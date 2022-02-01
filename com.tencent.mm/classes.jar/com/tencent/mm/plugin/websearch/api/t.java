package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.audio.mix.h.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.gic;
import com.tencent.mm.protocal.protobuf.gid;
import java.net.URLDecoder;
import java.util.LinkedList;
import org.json.JSONArray;

public final class t
  extends p
  implements m
{
  private gic WnQ;
  public gid WnR;
  public w WnS;
  private h callback;
  private c oDw;
  
  public t(w paramw)
  {
    AppMethodBeat.i(315358);
    this.WnS = paramw;
    paramw = new c.a();
    paramw.funcId = 1161;
    paramw.uri = "/cgi-bin/mmsearch-bin/searchsuggestion";
    paramw.otE = new gic();
    paramw.otF = new gid();
    this.oDw = paramw.bEF();
    this.WnQ = ((gic)c.b.b(this.oDw.otB));
    this.WnQ.aakp = this.WnS.hAB;
    this.WnQ.YYo = this.WnS.businessType;
    this.WnQ.acet = aj.asY(6);
    this.WnQ.abuB = this.WnS.Wob;
    this.WnQ.aaLr = aj.dch();
    this.WnQ.IJG = this.WnS.scene;
    this.WnQ.acee = this.WnS.sessionId;
    this.WnQ.aaLs = aj.iqa();
    try
    {
      paramw = new JSONArray(this.WnS.Wog);
      this.WnQ.acex = new LinkedList();
      int i = 0;
      while (i < paramw.length())
      {
        String str = URLDecoder.decode(paramw.getString(i), "UTF-8");
        this.WnQ.acex.add(str);
        i += 1;
      }
      AppMethodBeat.o(315358);
      return;
    }
    catch (Exception paramw)
    {
      b.printErrStackTrace("MicroMsg.WebSearch.NetSceneMMWebSuggest", paramw, "decode json error", new Object[0]);
      AppMethodBeat.o(315358);
    }
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(315367);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
    AppMethodBeat.o(315367);
    return i;
  }
  
  public final int getType()
  {
    return 1161;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(315371);
    b.i("MicroMsg.WebSearch.NetSceneMMWebSuggest", "onGYNetEnd errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.WnR = ((gid)c.c.b(this.oDw.otC));
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(315371);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.t
 * JD-Core Version:    0.7.0.1
 */