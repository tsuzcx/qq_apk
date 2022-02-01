package com.tencent.mm.plugin.newtips.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dpz;
import com.tencent.mm.protocal.protobuf.dqa;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends q
  implements m
{
  boolean Gwb;
  int Gwc;
  private i callback;
  private d rr;
  
  @Deprecated
  public b(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(186285);
    this.Gwb = false;
    this.Gwc = 0;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dpz();
    ((d.a)localObject).lBV = new dqa();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/pushnewtips";
    ((d.a)localObject).funcId = 597;
    this.rr = ((d.a)localObject).bgN();
    localObject = (dpz)d.b.b(this.rr.lBR);
    ((dpz)localObject).TWM = paramInt1;
    ((dpz)localObject).TWN = 1;
    ((dpz)localObject).CRg = paramString;
    this.Gwc = paramInt1;
    AppMethodBeat.o(186285);
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
    this.Gwb = ((dqa)d.c.b(((d)params).lBS)).TWO;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(127210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a.b
 * JD-Core Version:    0.7.0.1
 */