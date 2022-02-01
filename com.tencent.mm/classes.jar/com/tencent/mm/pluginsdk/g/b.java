package com.tencent.mm.pluginsdk.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.chv;
import com.tencent.mm.protocal.protobuf.chw;
import com.tencent.mm.protocal.protobuf.chx;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends n
  implements k
{
  private a EOn;
  private f callback;
  private com.tencent.mm.al.b rr;
  
  public b(String paramString, chx paramchx, int paramInt, byte[] paramArrayOfByte, a parama)
  {
    AppMethodBeat.i(195381);
    Object localObject = new com.tencent.mm.al.b.a();
    ((com.tencent.mm.al.b.a)localObject).hNM = new chv();
    ((com.tencent.mm.al.b.a)localObject).hNN = new chw();
    ((com.tencent.mm.al.b.a)localObject).uri = "/cgi-bin/micromsg-bin/parallelupload";
    ((com.tencent.mm.al.b.a)localObject).funcId = 3784;
    ((com.tencent.mm.al.b.a)localObject).hNO = 0;
    ((com.tencent.mm.al.b.a)localObject).respCmdId = 0;
    this.rr = ((com.tencent.mm.al.b.a)localObject).aDC();
    localObject = (chv)this.rr.hNK.hNQ;
    ((chv)localObject).Hbw = paramString;
    ((chv)localObject).Hbx = paramchx;
    ((chv)localObject).Hby = paramInt;
    ((chv)localObject).Hbz = new com.tencent.mm.bx.b(paramArrayOfByte);
    this.EOn = parama;
    AppMethodBeat.o(195381);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(195382);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(195382);
    return i;
  }
  
  public final int getType()
  {
    return 3784;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(195383);
    ad.d("MicroMsg.NetSceneCGIParallelUpload", "summerbig onGYNetEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if ((4 != paramInt2) && ((paramInt2 != 0) || (paramInt3 != 0)))
    {
      ad.e("MicroMsg.NetSceneCGIParallelUpload", "onSceneEnd errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg:" + paramString);
      this.EOn.a(false, paramInt3, null);
      AppMethodBeat.o(195383);
      return;
    }
    paramString = (chw)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    if (paramString.getBaseResponse().Ret == 0)
    {
      this.EOn.a(true, 0, paramString);
      AppMethodBeat.o(195383);
      return;
    }
    this.EOn.a(false, paramString.getBaseResponse().Ret, null);
    AppMethodBeat.o(195383);
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, int paramInt, chw paramchw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.b
 * JD-Core Version:    0.7.0.1
 */