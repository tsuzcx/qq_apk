package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.protocal.protobuf.bck;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
  extends n
  implements k
{
  private g callback;
  private final b rr;
  String zdj;
  int zdk;
  String zdl;
  
  public d(int paramInt, String paramString)
  {
    AppMethodBeat.i(29759);
    this.zdj = "";
    this.zdk = 0;
    this.zdl = "";
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new bcj();
    ((b.a)localObject).gUV = new bck();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getvoiceprintresource";
    ((b.a)localObject).funcId = 611;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (bcj)this.rr.gUS.gUX;
    ad.i("MicroMsg.NetSceneGetVoicePrintResource", "sceneType %d %s", new Object[] { Integer.valueOf(paramInt), paramString });
    ((bcj)localObject).DzZ = paramInt;
    ((bcj)localObject).DAa = paramString;
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
    ad.d("MicroMsg.NetSceneGetVoicePrintResource", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (bck)((b)paramq).gUT.gUX;
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29761);
      return;
    }
    if (paramq.DAb != null)
    {
      this.zdj = new String(paramq.DAb.Egu.getBufferToBytes());
      this.zdk = paramq.DAb.EdY;
      ad.d("MicroMsg.NetSceneGetVoicePrintResource", "vertify resid %d mtext %s", new Object[] { Integer.valueOf(this.zdk), this.zdj });
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