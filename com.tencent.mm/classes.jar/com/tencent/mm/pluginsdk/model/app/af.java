package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.brr;
import com.tencent.mm.protocal.protobuf.brs;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

public final class af
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  public b rr;
  
  public af(int paramInt, String paramString)
  {
    AppMethodBeat.i(151818);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new brr();
    ((b.a)localObject).hvu = new brs();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/getserviceapplist";
    ((b.a)localObject).funcId = 1060;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (brr)this.rr.hvr.hvw;
    ((brr)localObject).offset = paramInt;
    ((brr)localObject).limit = 20;
    ((brr)localObject).lang = paramString;
    com.tencent.mm.kernel.g.agS();
    ((brr)localObject).FgJ = String.valueOf(((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GIP, Integer.valueOf(0))).intValue());
    AppMethodBeat.o(151818);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(151820);
    this.callback = paramg;
    ac.i("MicroMsg.NetSceneGetServiceAppList", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(151820);
    return i;
  }
  
  public final int getType()
  {
    return 1060;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151819);
    ac.d("MicroMsg.NetSceneGetServiceAppList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(151819);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.af
 * JD-Core Version:    0.7.0.1
 */