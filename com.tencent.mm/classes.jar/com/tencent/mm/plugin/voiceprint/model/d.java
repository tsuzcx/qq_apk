package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bkj;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.cvj;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
  extends n
  implements k
{
  String BVk;
  int BVl;
  String BVm;
  private f callback;
  private final b rr;
  
  public d(int paramInt, String paramString)
  {
    AppMethodBeat.i(29759);
    this.BVk = "";
    this.BVl = 0;
    this.BVm = "";
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bkj();
    ((b.a)localObject).hNN = new bkk();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getvoiceprintresource";
    ((b.a)localObject).funcId = 611;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (bkj)this.rr.hNK.hNQ;
    ad.i("MicroMsg.NetSceneGetVoicePrintResource", "sceneType %d %s", new Object[] { Integer.valueOf(paramInt), paramString });
    ((bkj)localObject).GES = paramInt;
    ((bkj)localObject).GEU = paramString;
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
    ad.d("MicroMsg.NetSceneGetVoicePrintResource", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (bkk)((b)paramq).hNL.hNQ;
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29761);
      return;
    }
    if (paramq.GEV != null)
    {
      this.BVk = new String(paramq.GEV.HnH.getBufferToBytes());
      this.BVl = paramq.GEV.Hlk;
      ad.d("MicroMsg.NetSceneGetVoicePrintResource", "vertify resid %d mtext %s", new Object[] { Integer.valueOf(this.BVl), this.BVk });
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29761);
      return;
      ad.e("MicroMsg.NetSceneGetVoicePrintResource", "resp ResourceData null ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.d
 * JD-Core Version:    0.7.0.1
 */