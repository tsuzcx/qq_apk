package com.tencent.mm.plugin.wear.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.model.bq;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.fkh;
import com.tencent.mm.protocal.protobuf.fki;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends q
  implements m
{
  private i callback;
  private d lKU;
  
  public b(String paramString)
  {
    AppMethodBeat.i(30057);
    Object localObject = new d.a();
    ((d.a)localObject).funcId = 976;
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/sendyo";
    ((d.a)localObject).lBU = new fkh();
    ((d.a)localObject).lBV = new fki();
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.lKU = ((d.a)localObject).bgN();
    localObject = (fkh)d.b.b(this.lKU.lBR);
    ((fkh)localObject).CRQ = paramString;
    ((fkh)localObject).TFR = ((fkh)localObject).CreateTime;
    ((fkh)localObject).CreateTime = ((int)bq.RP(paramString));
    ((fkh)localObject).rWu = 63;
    ((fkh)localObject).UIZ = 1;
    ((fkh)localObject).rVx = 1;
    AppMethodBeat.o(30057);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(30059);
    this.callback = parami;
    int i = dispatch(paramg, this.lKU, this);
    AppMethodBeat.o(30059);
    return i;
  }
  
  public final int getType()
  {
    return 976;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30058);
    Log.i("MicroMsg.Wear.NetSceneSendYo", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(30058);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.d.b
 * JD-Core Version:    0.7.0.1
 */