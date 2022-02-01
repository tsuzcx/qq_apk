package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.audio.mix.i.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.fan;
import com.tencent.mm.protocal.protobuf.fao;

public final class aa
  extends a
  implements m
{
  private v IDt;
  private fan IEe;
  private fao IEf;
  private i callback;
  private d iUB;
  
  public aa(v paramv)
  {
    AppMethodBeat.i(187838);
    this.IDt = paramv;
    aWX(this.IDt.dPI);
    this.IEe = new fan();
    this.IEe.type = 1;
    this.IEe.KRB = paramv.content;
    this.IEf = new fao();
    b.i("MicroMsg.WebSearch.NetSceneWebSearchAiScanImageRetrieval", "create NetSceneWebSearchAiScanImageRetrieval scene:%s requestKey:%s", new Object[] { Integer.valueOf(paramv.scene), paramv.dDL });
    paramv = new d.a();
    paramv.funcId = 1532;
    paramv.uri = "/cgi-bin/mmbiz-bin/usrmsg/aiscan_image_retrieval";
    paramv.iLN = this.IEe;
    paramv.iLO = this.IEf;
    this.iUB = paramv.aXF();
    AppMethodBeat.o(187838);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(187840);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
    AppMethodBeat.o(187840);
    return i;
  }
  
  public final String fXC()
  {
    return this.IEf.KRB;
  }
  
  public final int fXD()
  {
    return 0;
  }
  
  public final v fXN()
  {
    return this.IDt;
  }
  
  public final fao fXS()
  {
    return this.IEf;
  }
  
  public final int getType()
  {
    return 1532;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(187839);
    b.i("MicroMsg.WebSearch.NetSceneWebSearchAiScanImageRetrieval", "netId: %s errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) || (paramInt3 == 0)) {
      this.IEf = ((fao)this.iUB.iLL.iLR);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(187839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.aa
 * JD-Core Version:    0.7.0.1
 */