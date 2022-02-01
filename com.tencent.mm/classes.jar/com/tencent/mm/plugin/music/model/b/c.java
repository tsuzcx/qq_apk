package com.tencent.mm.plugin.music.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.buz;
import com.tencent.mm.protocal.protobuf.bva;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends q
  implements m
{
  private buz AkX;
  public String AkY;
  private i callback;
  private d iUB;
  public String playUrl;
  
  public c(String paramString)
  {
    AppMethodBeat.i(63099);
    this.AkY = "";
    this.playUrl = "";
    d.a locala = new d.a();
    locala.funcId = 769;
    locala.uri = "/cgi-bin/micromsg-bin/getshakemusicurl";
    locala.iLN = new buz();
    locala.iLO = new bva();
    this.iUB = locala.aXF();
    this.AkX = ((buz)this.iUB.iLK.iLR);
    this.AkX.Mbq = paramString;
    this.playUrl = paramString;
    Log.i("MicroMsg.Music.NetSceneGetShakeMusicUrl", "request music url:%s", new Object[] { paramString });
    AppMethodBeat.o(63099);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(63100);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
    AppMethodBeat.o(63100);
    return i;
  }
  
  public final int getType()
  {
    return 769;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63101);
    Log.i("MicroMsg.Music.NetSceneGetShakeMusicUrl", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(63101);
      return;
    }
    params = (bva)this.iUB.iLL.iLR;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if (params != null)
    {
      this.AkY = params.Mbq;
      Log.i("MicroMsg.Music.NetSceneGetShakeMusicUrl", "tempPlayUrl:%s", new Object[] { this.AkY });
      AppMethodBeat.o(63101);
      return;
    }
    Log.e("MicroMsg.Music.NetSceneGetShakeMusicUrl", "response is null");
    AppMethodBeat.o(63101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.b.c
 * JD-Core Version:    0.7.0.1
 */