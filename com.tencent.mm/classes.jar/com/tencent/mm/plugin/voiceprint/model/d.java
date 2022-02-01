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
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bgb;
import com.tencent.mm.protocal.protobuf.bgc;
import com.tencent.mm.protocal.protobuf.cqe;
import com.tencent.mm.sdk.platformtools.ac;

public final class d
  extends n
  implements k
{
  String AvP;
  int AvQ;
  String AvR;
  private g callback;
  private final b rr;
  
  public d(int paramInt, String paramString)
  {
    AppMethodBeat.i(29759);
    this.AvP = "";
    this.AvQ = 0;
    this.AvR = "";
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bgb();
    ((b.a)localObject).hvu = new bgc();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getvoiceprintresource";
    ((b.a)localObject).funcId = 611;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (bgb)this.rr.hvr.hvw;
    ac.i("MicroMsg.NetSceneGetVoicePrintResource", "sceneType %d %s", new Object[] { Integer.valueOf(paramInt), paramString });
    ((bgb)localObject).EVv = paramInt;
    ((bgb)localObject).EVw = paramString;
    AppMethodBeat.o(29759);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(29760);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(29760);
    return i;
  }
  
  public final int getType()
  {
    return 611;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29761);
    ac.d("MicroMsg.NetSceneGetVoicePrintResource", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (bgc)((b)paramq).hvs.hvw;
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29761);
      return;
    }
    if (paramq.EVx != null)
    {
      this.AvP = new String(paramq.EVx.FDu.getBufferToBytes());
      this.AvQ = paramq.EVx.FAX;
      ac.d("MicroMsg.NetSceneGetVoicePrintResource", "vertify resid %d mtext %s", new Object[] { Integer.valueOf(this.AvQ), this.AvP });
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29761);
      return;
      ac.e("MicroMsg.NetSceneGetVoicePrintResource", "resp ResourceData null ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.d
 * JD-Core Version:    0.7.0.1
 */