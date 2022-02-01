package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bxk;
import com.tencent.mm.protocal.protobuf.bxl;
import com.tencent.mm.protocal.protobuf.dow;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends q
  implements m
{
  String GQM;
  int GQN;
  String GQO;
  private i callback;
  private final com.tencent.mm.ak.d rr;
  
  public d(int paramInt, String paramString)
  {
    AppMethodBeat.i(29759);
    this.GQM = "";
    this.GQN = 0;
    this.GQO = "";
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bxk();
    ((d.a)localObject).iLO = new bxl();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getvoiceprintresource";
    ((d.a)localObject).funcId = 611;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bxk)this.rr.iLK.iLR;
    Log.i("MicroMsg.NetSceneGetVoicePrintResource", "sceneType %d %s", new Object[] { Integer.valueOf(paramInt), paramString });
    ((bxk)localObject).Mdl = paramInt;
    ((bxk)localObject).Mdm = paramString;
    AppMethodBeat.o(29759);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(29760);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(29760);
    return i;
  }
  
  public final int getType()
  {
    return 611;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29761);
    Log.d("MicroMsg.NetSceneGetVoicePrintResource", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    params = (bxl)((com.tencent.mm.ak.d)params).iLL.iLR;
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29761);
      return;
    }
    if (params.Mdn != null)
    {
      this.GQM = new String(params.Mdn.MSr.getBufferToBytes());
      this.GQN = params.Mdn.MPS;
      Log.d("MicroMsg.NetSceneGetVoicePrintResource", "vertify resid %d mtext %s", new Object[] { Integer.valueOf(this.GQN), this.GQM });
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29761);
      return;
      Log.e("MicroMsg.NetSceneGetVoicePrintResource", "resp ResourceData null ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.d
 * JD-Core Version:    0.7.0.1
 */