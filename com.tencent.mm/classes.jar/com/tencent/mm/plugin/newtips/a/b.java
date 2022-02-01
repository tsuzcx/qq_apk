package com.tencent.mm.plugin.newtips.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dgf;
import com.tencent.mm.protocal.protobuf.dgg;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends q
  implements m
{
  boolean ACX;
  int ACY;
  private i callback;
  private d rr;
  
  @Deprecated
  public b(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(188557);
    this.ACX = false;
    this.ACY = 0;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dgf();
    ((d.a)localObject).iLO = new dgg();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/pushnewtips";
    ((d.a)localObject).funcId = 597;
    this.rr = ((d.a)localObject).aXF();
    localObject = (dgf)this.rr.iLK.iLR;
    ((dgf)localObject).MKR = paramInt1;
    ((dgf)localObject).MKS = 1;
    ((dgf)localObject).xMX = paramString;
    this.ACY = paramInt1;
    AppMethodBeat.o(188557);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(127211);
    Log.d("MicroMsg.NetScenePushCompatNewTips", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(127211);
    return i;
  }
  
  public final int getType()
  {
    return 597;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(127210);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetScenePushCompatNewTips", "errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(127210);
      return;
    }
    this.ACX = ((dgg)((d)params).iLL.iLR).MKT;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(127210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a.b
 * JD-Core Version:    0.7.0.1
 */