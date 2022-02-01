package com.tencent.mm.plugin.wear.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.bl;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.efi;
import com.tencent.mm.protocal.protobuf.efj;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
  extends n
  implements k
{
  private f callback;
  private com.tencent.mm.ak.b hZD;
  
  public b(String paramString)
  {
    AppMethodBeat.i(30057);
    Object localObject = new b.a();
    ((b.a)localObject).funcId = 976;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sendyo";
    ((b.a)localObject).hQF = new efi();
    ((b.a)localObject).hQG = new efj();
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.hZD = ((b.a)localObject).aDS();
    localObject = (efi)this.hZD.hQD.hQJ;
    ((efi)localObject).uvF = paramString;
    ((efi)localObject).HnF = ((efi)localObject).CreateTime;
    ((efi)localObject).CreateTime = ((int)bl.BQ(paramString));
    ((efi)localObject).nJA = 63;
    ((efi)localObject).Ijk = 1;
    ((efi)localObject).nID = 1;
    AppMethodBeat.o(30057);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(30059);
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
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
    ae.i("MicroMsg.Wear.NetSceneSendYo", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(30058);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.d.b
 * JD-Core Version:    0.7.0.1
 */