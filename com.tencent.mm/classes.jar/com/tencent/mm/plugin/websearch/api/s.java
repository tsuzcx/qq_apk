package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.audio.mix.i.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.fau;
import com.tencent.mm.protocal.protobuf.fav;
import java.net.URLDecoder;
import java.util.LinkedList;
import org.json.JSONArray;

public final class s
  extends q
  implements m
{
  private fav IDA;
  private v IDt;
  private fau IDz;
  private i callback;
  private d iUB;
  
  public s(v paramv)
  {
    AppMethodBeat.i(187832);
    this.IDt = paramv;
    paramv = new d.a();
    paramv.funcId = 1161;
    paramv.uri = "/cgi-bin/mmsearch-bin/searchsuggestion";
    paramv.iLN = new fau();
    paramv.iLO = new fav();
    this.iUB = paramv.aXF();
    this.IDz = ((fau)this.iUB.iLK.iLR);
    this.IDz.LPT = this.IDt.dDv;
    this.IDz.KZg = this.IDt.businessType;
    this.IDz.NwV = ai.aft(6);
    this.IDz.MRb = this.IDt.IDE;
    this.IDz.MlQ = ai.clJ();
    this.IDz.Scene = this.IDt.scene;
    this.IDz.NwH = this.IDt.sessionId;
    this.IDz.MlR = ai.fYd();
    try
    {
      paramv = new JSONArray(this.IDt.IDJ);
      this.IDz.NwZ = new LinkedList();
      int i = 0;
      while (i < paramv.length())
      {
        String str = URLDecoder.decode(paramv.getString(i), "UTF-8");
        this.IDz.NwZ.add(str);
        i += 1;
      }
      AppMethodBeat.o(187832);
      return;
    }
    catch (Exception paramv)
    {
      b.printErrStackTrace("MicroMsg.WebSearch.NetSceneMMWebSuggest", paramv, "decode json error", new Object[0]);
      AppMethodBeat.o(187832);
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(187833);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
    AppMethodBeat.o(187833);
    return i;
  }
  
  public final fav fXM()
  {
    return this.IDA;
  }
  
  public final v fXN()
  {
    return this.IDt;
  }
  
  public final int getType()
  {
    return 1161;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(187834);
    b.i("MicroMsg.WebSearch.NetSceneMMWebSuggest", "onGYNetEnd errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.IDA = ((fav)this.iUB.iLL.iLR);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(187834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.s
 * JD-Core Version:    0.7.0.1
 */