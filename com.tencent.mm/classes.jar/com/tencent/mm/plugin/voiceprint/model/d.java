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
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.blb;
import com.tencent.mm.protocal.protobuf.blc;
import com.tencent.mm.protocal.protobuf.cwd;
import com.tencent.mm.sdk.platformtools.ae;

public final class d
  extends n
  implements k
{
  String CmL;
  int CmM;
  String CmN;
  private f callback;
  private final b rr;
  
  public d(int paramInt, String paramString)
  {
    AppMethodBeat.i(29759);
    this.CmL = "";
    this.CmM = 0;
    this.CmN = "";
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new blb();
    ((b.a)localObject).hQG = new blc();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getvoiceprintresource";
    ((b.a)localObject).funcId = 611;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (blb)this.rr.hQD.hQJ;
    ae.i("MicroMsg.NetSceneGetVoicePrintResource", "sceneType %d %s", new Object[] { Integer.valueOf(paramInt), paramString });
    ((blb)localObject).GYv = paramInt;
    ((blb)localObject).GYw = paramString;
    AppMethodBeat.o(29759);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(29760);
    this.callback = paramf;
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
    ae.d("MicroMsg.NetSceneGetVoicePrintResource", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (blc)((b)paramq).hQE.hQJ;
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29761);
      return;
    }
    if (paramq.GYx != null)
    {
      this.CmL = new String(paramq.GYx.HHh.getBufferToBytes());
      this.CmM = paramq.GYx.HEK;
      ae.d("MicroMsg.NetSceneGetVoicePrintResource", "vertify resid %d mtext %s", new Object[] { Integer.valueOf(this.CmM), this.CmL });
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29761);
      return;
      ae.e("MicroMsg.NetSceneGetVoicePrintResource", "resp ResourceData null ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.d
 * JD-Core Version:    0.7.0.1
 */