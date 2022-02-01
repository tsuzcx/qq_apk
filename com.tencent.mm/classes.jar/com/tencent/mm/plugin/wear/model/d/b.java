package com.tencent.mm.plugin.wear.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.model.bi;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dsa;
import com.tencent.mm.protocal.protobuf.dsb;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends n
  implements k
{
  private g callback;
  private com.tencent.mm.al.b hdD;
  
  public b(String paramString)
  {
    AppMethodBeat.i(30057);
    Object localObject = new b.a();
    ((b.a)localObject).funcId = 976;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sendyo";
    ((b.a)localObject).gUU = new dsa();
    ((b.a)localObject).gUV = new dsb();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.hdD = ((b.a)localObject).atI();
    localObject = (dsa)this.hdD.gUS.gUX;
    ((dsa)localObject).sdP = paramString;
    ((dsa)localObject).DOf = ((dsa)localObject).CreateTime;
    ((dsa)localObject).CreateTime = ((int)bi.uj(paramString));
    ((dsa)localObject).mBH = 63;
    ((dsa)localObject).EGL = 1;
    ((dsa)localObject).mAK = 1;
    AppMethodBeat.o(30057);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(30059);
    this.callback = paramg;
    int i = dispatch(parame, this.hdD, this);
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
    ad.i("MicroMsg.Wear.NetSceneSendYo", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(30058);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.d.b
 * JD-Core Version:    0.7.0.1
 */