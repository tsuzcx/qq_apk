package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dft;
import com.tencent.mm.protocal.protobuf.dfu;
import com.tencent.mm.sdk.platformtools.ac;

public final class i
  extends n
  implements k
{
  public int Awe;
  private g callback;
  public int mStatus;
  private final b rr;
  
  public i(int paramInt)
  {
    AppMethodBeat.i(29782);
    b.a locala = new b.a();
    locala.hvt = new dft();
    locala.hvu = new dfu();
    locala.uri = "/cgi-bin/micromsg-bin/switchopvoiceprint";
    locala.funcId = 615;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ((dft)this.rr.hvr.hvw).dgL = paramInt;
    AppMethodBeat.o(29782);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(29783);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(29783);
    return i;
  }
  
  public final int getType()
  {
    return 615;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29784);
    ac.d("MicroMsg.NetSceneSwitchOpVoicePrint", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (dfu)((b)paramq).hvs.hvw;
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29784);
      return;
    }
    this.mStatus = paramq.Fws;
    this.Awe = paramq.FPe;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(29784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.i
 * JD-Core Version:    0.7.0.1
 */