package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cfe;
import com.tencent.mm.protocal.protobuf.cff;
import com.tencent.mm.protocal.protobuf.dys;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends q
  implements m
{
  String NGX;
  int NGY;
  String NGZ;
  private i callback;
  private final com.tencent.mm.an.d rr;
  
  public d(int paramInt, String paramString)
  {
    AppMethodBeat.i(29759);
    this.NGX = "";
    this.NGY = 0;
    this.NGZ = "";
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new cfe();
    ((d.a)localObject).lBV = new cff();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getvoiceprintresource";
    ((d.a)localObject).funcId = 611;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (cfe)d.b.b(this.rr.lBR);
    Log.i("MicroMsg.NetSceneGetVoicePrintResource", "sceneType %d %s", new Object[] { Integer.valueOf(paramInt), paramString });
    ((cfe)localObject).TmM = paramInt;
    ((cfe)localObject).TmN = paramString;
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
    params = (cff)d.c.b(((com.tencent.mm.an.d)params).lBS);
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29761);
      return;
    }
    if (params.TmO != null)
    {
      this.NGX = new String(params.TmO.Uey.Tkb.UH);
      this.NGY = params.TmO.UbW;
      Log.d("MicroMsg.NetSceneGetVoicePrintResource", "vertify resid %d mtext %s", new Object[] { Integer.valueOf(this.NGY), this.NGX });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.d
 * JD-Core Version:    0.7.0.1
 */