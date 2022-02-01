package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cvh;
import com.tencent.mm.protocal.protobuf.cvi;
import com.tencent.mm.protocal.protobuf.erw;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends p
  implements m
{
  String UsX;
  int UsY;
  String UsZ;
  private h callback;
  private final c rr;
  
  public d(int paramInt, String paramString)
  {
    AppMethodBeat.i(29759);
    this.UsX = "";
    this.UsY = 0;
    this.UsZ = "";
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cvh();
    ((c.a)localObject).otF = new cvi();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/getvoiceprintresource";
    ((c.a)localObject).funcId = 611;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (cvh)c.b.b(this.rr.otB);
    Log.i("MicroMsg.NetSceneGetVoicePrintResource", "sceneType %d %s", new Object[] { Integer.valueOf(paramInt), paramString });
    ((cvh)localObject).aaAT = paramInt;
    ((cvh)localObject).YOu = paramString;
    AppMethodBeat.o(29759);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(29760);
    this.callback = paramh;
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
    params = (cvi)c.c.b(((c)params).otC);
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29761);
      return;
    }
    if (params.aaAU != null)
    {
      this.UsX = new String(params.aaAU.abvL.aaxD.Op);
      this.UsY = params.aaAU.abth;
      Log.d("MicroMsg.NetSceneGetVoicePrintResource", "vertify resid %d mtext %s", new Object[] { Integer.valueOf(this.UsY), this.UsX });
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