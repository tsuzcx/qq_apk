package com.tencent.mm.pluginsdk.h;

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
import com.tencent.mm.protocal.protobuf.dii;
import com.tencent.mm.protocal.protobuf.dij;
import com.tencent.mm.protocal.protobuf.dik;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends q
  implements m
{
  private a QYd;
  private i callback;
  private d rr;
  
  public b(String paramString, dik paramdik, int paramInt, byte[] paramArrayOfByte, a parama)
  {
    AppMethodBeat.i(198132);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dii();
    ((d.a)localObject).lBV = new dij();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/parallelupload";
    ((d.a)localObject).funcId = 3784;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (dii)d.b.b(this.rr.lBR);
    ((dii)localObject).TPD = paramString;
    ((dii)localObject).TPE = paramdik;
    ((dii)localObject).TPF = paramInt;
    ((dii)localObject).TPG = new com.tencent.mm.cd.b(paramArrayOfByte);
    this.QYd = parama;
    AppMethodBeat.o(198132);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(198134);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(198134);
    return i;
  }
  
  public final int getType()
  {
    return 3784;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(198138);
    Log.d("MicroMsg.NetSceneCGIParallelUpload", "summerbig onGYNetEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if ((4 != paramInt2) && ((paramInt2 != 0) || (paramInt3 != 0)))
    {
      Log.e("MicroMsg.NetSceneCGIParallelUpload", "onSceneEnd errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg:" + paramString);
      this.QYd.a(false, paramInt3, null);
      AppMethodBeat.o(198138);
      return;
    }
    paramString = (dij)d.c.b(((d)params).lBS);
    if (paramString.getBaseResponse().CqV == 0)
    {
      this.QYd.a(true, 0, paramString);
      AppMethodBeat.o(198138);
      return;
    }
    this.QYd.a(false, paramString.getBaseResponse().CqV, null);
    AppMethodBeat.o(198138);
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, int paramInt, dij paramdij);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.b
 * JD-Core Version:    0.7.0.1
 */