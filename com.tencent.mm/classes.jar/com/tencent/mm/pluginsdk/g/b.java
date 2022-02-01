package com.tencent.mm.pluginsdk.g;

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
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cyw;
import com.tencent.mm.protocal.protobuf.cyx;
import com.tencent.mm.protocal.protobuf.cyy;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends q
  implements m
{
  private a JXB;
  private i callback;
  private d rr;
  
  public b(String paramString, cyy paramcyy, int paramInt, byte[] paramArrayOfByte, a parama)
  {
    AppMethodBeat.i(223770);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new cyw();
    ((d.a)localObject).iLO = new cyx();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/parallelupload";
    ((d.a)localObject).funcId = 3784;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (cyw)this.rr.iLK.iLR;
    ((cyw)localObject).MDU = paramString;
    ((cyw)localObject).MDV = paramcyy;
    ((cyw)localObject).MDW = paramInt;
    ((cyw)localObject).MDX = new com.tencent.mm.bw.b(paramArrayOfByte);
    this.JXB = parama;
    AppMethodBeat.o(223770);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(223771);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(223771);
    return i;
  }
  
  public final int getType()
  {
    return 3784;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(223772);
    Log.d("MicroMsg.NetSceneCGIParallelUpload", "summerbig onGYNetEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if ((4 != paramInt2) && ((paramInt2 != 0) || (paramInt3 != 0)))
    {
      Log.e("MicroMsg.NetSceneCGIParallelUpload", "onSceneEnd errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg:" + paramString);
      this.JXB.a(false, paramInt3, null);
      AppMethodBeat.o(223772);
      return;
    }
    paramString = (cyx)((d)params).iLL.iLR;
    if (paramString.getBaseResponse().Ret == 0)
    {
      this.JXB.a(true, 0, paramString);
      AppMethodBeat.o(223772);
      return;
    }
    this.JXB.a(false, paramString.getBaseResponse().Ret, null);
    AppMethodBeat.o(223772);
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, int paramInt, cyx paramcyx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.b
 * JD-Core Version:    0.7.0.1
 */