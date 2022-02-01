package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.audio.mix.h.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.flg;
import com.tencent.mm.protocal.protobuf.flh;

public final class aa
  extends a
  implements m
{
  private v PxJ;
  private flg Pyu;
  private flh Pyv;
  private i callback;
  private d lKU;
  
  public aa(v paramv)
  {
    AppMethodBeat.i(212744);
    this.PxJ = paramv;
    biI(this.PxJ.fIY);
    this.Pyu = new flg();
    this.Pyu.type = 1;
    this.Pyu.RSB = paramv.content;
    this.Pyv = new flh();
    b.i("MicroMsg.WebSearch.NetSceneWebSearchAiScanImageRetrieval", "create NetSceneWebSearchAiScanImageRetrieval scene:%s requestKey:%s", new Object[] { Integer.valueOf(paramv.scene), paramv.fwv });
    paramv = new d.a();
    paramv.funcId = 1532;
    paramv.uri = "/cgi-bin/mmbiz-bin/usrmsg/aiscan_image_retrieval";
    paramv.lBU = this.Pyu;
    paramv.lBV = this.Pyv;
    this.lKU = paramv.bgN();
    AppMethodBeat.o(212744);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(212751);
    this.callback = parami;
    int i = dispatch(paramg, this.lKU, this);
    AppMethodBeat.o(212751);
    return i;
  }
  
  public final flh gQD()
  {
    return this.Pyv;
  }
  
  public final String gQp()
  {
    return this.Pyv.RSB;
  }
  
  public final int gQq()
  {
    return 0;
  }
  
  public final v gQy()
  {
    return this.PxJ;
  }
  
  public final int getType()
  {
    return 1532;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(212746);
    b.i("MicroMsg.WebSearch.NetSceneWebSearchAiScanImageRetrieval", "netId: %s errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) || (paramInt3 == 0)) {
      this.Pyv = ((flh)d.c.b(this.lKU.lBS));
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(212746);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.aa
 * JD-Core Version:    0.7.0.1
 */