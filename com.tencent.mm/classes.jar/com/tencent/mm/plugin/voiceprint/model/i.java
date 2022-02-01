package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dmd;
import com.tencent.mm.protocal.protobuf.dme;
import com.tencent.mm.sdk.platformtools.ae;

public final class i
  extends n
  implements k
{
  public int Cna;
  private f callback;
  public int mStatus;
  private final b rr;
  
  public i(int paramInt)
  {
    AppMethodBeat.i(29782);
    b.a locala = new b.a();
    locala.hQF = new dmd();
    locala.hQG = new dme();
    locala.uri = "/cgi-bin/micromsg-bin/switchopvoiceprint";
    locala.funcId = 615;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    ((dmd)this.rr.hQD.hQJ).dto = paramInt;
    AppMethodBeat.o(29782);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(29783);
    this.callback = paramf;
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
    ae.d("MicroMsg.NetSceneSwitchOpVoicePrint", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (dme)((b)paramq).hQE.hQJ;
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29784);
      return;
    }
    this.mStatus = paramq.HzY;
    this.Cna = paramq.HTC;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(29784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.i
 * JD-Core Version:    0.7.0.1
 */