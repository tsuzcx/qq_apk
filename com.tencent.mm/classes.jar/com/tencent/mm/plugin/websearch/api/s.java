package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.audio.mix.h.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.fln;
import com.tencent.mm.protocal.protobuf.flo;
import java.net.URLDecoder;
import java.util.LinkedList;
import org.json.JSONArray;

public final class s
  extends q
  implements m
{
  private v PxJ;
  private fln PxP;
  private flo PxQ;
  private i callback;
  private d lKU;
  
  public s(v paramv)
  {
    AppMethodBeat.i(212351);
    this.PxJ = paramv;
    paramv = new d.a();
    paramv.funcId = 1161;
    paramv.uri = "/cgi-bin/mmsearch-bin/searchsuggestion";
    paramv.lBU = new fln();
    paramv.lBV = new flo();
    this.lKU = paramv.bgN();
    this.PxP = ((fln)d.b.b(this.lKU.lBR));
    this.PxP.SYn = this.PxJ.fwe;
    this.PxP.Sap = this.PxJ.businessType;
    this.PxP.UKl = ai.anh(6);
    this.PxP.Udh = this.PxJ.PxU;
    this.PxP.TwK = ai.czn();
    this.PxP.CPw = this.PxJ.scene;
    this.PxP.UJX = this.PxJ.sessionId;
    this.PxP.TwL = ai.gQO();
    try
    {
      paramv = new JSONArray(this.PxJ.PxZ);
      this.PxP.UKp = new LinkedList();
      int i = 0;
      while (i < paramv.length())
      {
        String str = URLDecoder.decode(paramv.getString(i), "UTF-8");
        this.PxP.UKp.add(str);
        i += 1;
      }
      AppMethodBeat.o(212351);
      return;
    }
    catch (Exception paramv)
    {
      b.printErrStackTrace("MicroMsg.WebSearch.NetSceneMMWebSuggest", paramv, "decode json error", new Object[0]);
      AppMethodBeat.o(212351);
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(212357);
    this.callback = parami;
    int i = dispatch(paramg, this.lKU, this);
    AppMethodBeat.o(212357);
    return i;
  }
  
  public final flo gQx()
  {
    return this.PxQ;
  }
  
  public final v gQy()
  {
    return this.PxJ;
  }
  
  public final int getType()
  {
    return 1161;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(212360);
    b.i("MicroMsg.WebSearch.NetSceneMMWebSuggest", "onGYNetEnd errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.PxQ = ((flo)d.c.b(this.lKU.lBS));
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(212360);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.s
 * JD-Core Version:    0.7.0.1
 */