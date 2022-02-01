package com.tencent.mm.plugin.music.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bdy;
import com.tencent.mm.protocal.protobuf.bdz;
import com.tencent.mm.sdk.platformtools.ac;

public final class c
  extends n
  implements k
{
  private g callback;
  private b hEg;
  public String playUrl;
  private bdy vfM;
  public String vfN;
  
  public c(String paramString)
  {
    AppMethodBeat.i(63099);
    this.vfN = "";
    this.playUrl = "";
    b.a locala = new b.a();
    locala.funcId = 769;
    locala.uri = "/cgi-bin/micromsg-bin/getshakemusicurl";
    locala.hvt = new bdy();
    locala.hvu = new bdz();
    this.hEg = locala.aAz();
    this.vfM = ((bdy)this.hEg.hvr.hvw);
    this.vfM.ETL = paramString;
    this.playUrl = paramString;
    ac.i("MicroMsg.Music.NetSceneGetShakeMusicUrl", "request music url:%s", new Object[] { paramString });
    AppMethodBeat.o(63099);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(63100);
    this.callback = paramg;
    int i = dispatch(parame, this.hEg, this);
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
    ac.i("MicroMsg.Music.NetSceneGetShakeMusicUrl", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(63101);
      return;
    }
    paramq = (bdz)this.hEg.hvs.hvw;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if (paramq != null)
    {
      this.vfN = paramq.ETL;
      ac.i("MicroMsg.Music.NetSceneGetShakeMusicUrl", "tempPlayUrl:%s", new Object[] { this.vfN });
      AppMethodBeat.o(63101);
      return;
    }
    ac.e("MicroMsg.Music.NetSceneGetShakeMusicUrl", "response is null");
    AppMethodBeat.o(63101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.b.c
 * JD-Core Version:    0.7.0.1
 */