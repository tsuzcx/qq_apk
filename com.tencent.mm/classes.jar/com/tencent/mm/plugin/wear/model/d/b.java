package com.tencent.mm.plugin.wear.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.bi;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dxr;
import com.tencent.mm.protocal.protobuf.dxs;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
  extends n
  implements k
{
  private g callback;
  private com.tencent.mm.ak.b hEg;
  
  public b(String paramString)
  {
    AppMethodBeat.i(30057);
    Object localObject = new b.a();
    ((b.a)localObject).funcId = 976;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sendyo";
    ((b.a)localObject).hvt = new dxr();
    ((b.a)localObject).hvu = new dxs();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.hEg = ((b.a)localObject).aAz();
    localObject = (dxr)this.hEg.hvr.hvw;
    ((dxr)localObject).tlJ = paramString;
    ((dxr)localObject).Fkw = ((dxr)localObject).CreateTime;
    ((dxr)localObject).CreateTime = ((int)bi.yp(paramString));
    ((dxr)localObject).ndI = 63;
    ((dxr)localObject).GdX = 1;
    ((dxr)localObject).ncL = 1;
    AppMethodBeat.o(30057);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(30059);
    this.callback = paramg;
    int i = dispatch(parame, this.hEg, this);
    AppMethodBeat.o(30059);
    return i;
  }
  
  public final int getType()
  {
    return 976;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30058);
    ac.i("MicroMsg.Wear.NetSceneSendYo", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(30058);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.d.b
 * JD-Core Version:    0.7.0.1
 */