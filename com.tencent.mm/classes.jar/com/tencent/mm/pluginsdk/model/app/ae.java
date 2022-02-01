package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bwe;
import com.tencent.mm.protocal.protobuf.bwf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public final class ae
  extends n
  implements k
{
  private f callback;
  public b rr;
  
  public ae(int paramInt, String paramString)
  {
    AppMethodBeat.i(151818);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bwe();
    ((b.a)localObject).hNN = new bwf();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/getserviceapplist";
    ((b.a)localObject).funcId = 1060;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (bwe)this.rr.hNK.hNQ;
    ((bwe)localObject).offset = paramInt;
    ((bwe)localObject).limit = 20;
    ((bwe)localObject).lang = paramString;
    g.ajD();
    ((bwe)localObject).GQl = String.valueOf(((Integer)g.ajC().ajl().get(al.a.Ivh, Integer.valueOf(0))).intValue());
    AppMethodBeat.o(151818);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(151820);
    this.callback = paramf;
    ad.i("MicroMsg.NetSceneGetServiceAppList", "do scene");
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
    ad.d("MicroMsg.NetSceneGetServiceAppList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(151819);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ae
 * JD-Core Version:    0.7.0.1
 */