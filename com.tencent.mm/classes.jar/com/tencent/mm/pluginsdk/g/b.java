package com.tencent.mm.pluginsdk.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cip;
import com.tencent.mm.protocal.protobuf.ciq;
import com.tencent.mm.protocal.protobuf.cir;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
  extends n
  implements k
{
  private a FgJ;
  private f callback;
  private com.tencent.mm.ak.b rr;
  
  public b(String paramString, cir paramcir, int paramInt, byte[] paramArrayOfByte, a parama)
  {
    AppMethodBeat.i(218834);
    Object localObject = new com.tencent.mm.ak.b.a();
    ((com.tencent.mm.ak.b.a)localObject).hQF = new cip();
    ((com.tencent.mm.ak.b.a)localObject).hQG = new ciq();
    ((com.tencent.mm.ak.b.a)localObject).uri = "/cgi-bin/micromsg-bin/parallelupload";
    ((com.tencent.mm.ak.b.a)localObject).funcId = 3784;
    ((com.tencent.mm.ak.b.a)localObject).hQH = 0;
    ((com.tencent.mm.ak.b.a)localObject).respCmdId = 0;
    this.rr = ((com.tencent.mm.ak.b.a)localObject).aDS();
    localObject = (cip)this.rr.hQD.hQJ;
    ((cip)localObject).HuW = paramString;
    ((cip)localObject).HuX = paramcir;
    ((cip)localObject).HuY = paramInt;
    ((cip)localObject).HuZ = new com.tencent.mm.bw.b(paramArrayOfByte);
    this.FgJ = parama;
    AppMethodBeat.o(218834);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(218835);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(218835);
    return i;
  }
  
  public final int getType()
  {
    return 3784;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(218836);
    ae.d("MicroMsg.NetSceneCGIParallelUpload", "summerbig onGYNetEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if ((4 != paramInt2) && ((paramInt2 != 0) || (paramInt3 != 0)))
    {
      ae.e("MicroMsg.NetSceneCGIParallelUpload", "onSceneEnd errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg:" + paramString);
      this.FgJ.a(false, paramInt3, null);
      AppMethodBeat.o(218836);
      return;
    }
    paramString = (ciq)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    if (paramString.getBaseResponse().Ret == 0)
    {
      this.FgJ.a(true, 0, paramString);
      AppMethodBeat.o(218836);
      return;
    }
    this.FgJ.a(false, paramString.getBaseResponse().Ret, null);
    AppMethodBeat.o(218836);
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, int paramInt, ciq paramciq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.b
 * JD-Core Version:    0.7.0.1
 */