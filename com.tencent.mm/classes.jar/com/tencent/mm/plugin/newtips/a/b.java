package com.tencent.mm.plugin.newtips.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eiu;
import com.tencent.mm.protocal.protobuf.eiv;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends p
  implements m
{
  boolean Msa;
  int Msb;
  private h callback;
  private c rr;
  
  @Deprecated
  public b(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(266300);
    this.Msa = false;
    this.Msb = 0;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new eiu();
    ((c.a)localObject).otF = new eiv();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/pushnewtips";
    ((c.a)localObject).funcId = 597;
    this.rr = ((c.a)localObject).bEF();
    localObject = (eiu)c.b.b(this.rr.otB);
    ((eiu)localObject).abnE = paramInt1;
    ((eiu)localObject).abnF = 1;
    ((eiu)localObject).ILw = paramString;
    this.Msb = paramInt1;
    AppMethodBeat.o(266300);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(127211);
    Log.d("MicroMsg.NetScenePushCompatNewTips", "doScene");
    this.callback = paramh;
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
    this.Msa = ((eiv)c.c.b(((c)params).otC)).abnG;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(127210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a.b
 * JD-Core Version:    0.7.0.1
 */