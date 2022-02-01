package com.tencent.mm.plugin.music.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.biw;
import com.tencent.mm.protocal.protobuf.bix;
import com.tencent.mm.sdk.platformtools.ae;

public final class c
  extends n
  implements k
{
  private f callback;
  private b hZD;
  public String playUrl;
  private biw wAQ;
  public String wAR;
  
  public c(String paramString)
  {
    AppMethodBeat.i(63099);
    this.wAR = "";
    this.playUrl = "";
    b.a locala = new b.a();
    locala.funcId = 769;
    locala.uri = "/cgi-bin/micromsg-bin/getshakemusicurl";
    locala.hQF = new biw();
    locala.hQG = new bix();
    this.hZD = locala.aDS();
    this.wAQ = ((biw)this.hZD.hQD.hQJ);
    this.wAQ.GWI = paramString;
    this.playUrl = paramString;
    ae.i("MicroMsg.Music.NetSceneGetShakeMusicUrl", "request music url:%s", new Object[] { paramString });
    AppMethodBeat.o(63099);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(63100);
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
    AppMethodBeat.o(63100);
    return i;
  }
  
  public final int getType()
  {
    return 769;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63101);
    ae.i("MicroMsg.Music.NetSceneGetShakeMusicUrl", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(63101);
      return;
    }
    paramq = (bix)this.hZD.hQE.hQJ;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if (paramq != null)
    {
      this.wAR = paramq.GWI;
      ae.i("MicroMsg.Music.NetSceneGetShakeMusicUrl", "tempPlayUrl:%s", new Object[] { this.wAR });
      AppMethodBeat.o(63101);
      return;
    }
    ae.e("MicroMsg.Music.NetSceneGetShakeMusicUrl", "response is null");
    AppMethodBeat.o(63101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.b.c
 * JD-Core Version:    0.7.0.1
 */