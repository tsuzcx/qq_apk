package com.tencent.mm.plugin.music.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.csd;
import com.tencent.mm.protocal.protobuf.cse;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends p
  implements m
{
  private csd LMY;
  public String LMZ;
  private h callback;
  private com.tencent.mm.am.c oDw;
  public String playUrl;
  
  public c(String paramString)
  {
    AppMethodBeat.i(63099);
    this.LMZ = "";
    this.playUrl = "";
    c.a locala = new c.a();
    locala.funcId = 769;
    locala.uri = "/cgi-bin/micromsg-bin/getshakemusicurl";
    locala.otE = new csd();
    locala.otF = new cse();
    this.oDw = locala.bEF();
    this.LMY = ((csd)c.b.b(this.oDw.otB));
    this.LMY.aayu = paramString;
    this.playUrl = paramString;
    Log.i("MicroMsg.Music.NetSceneGetShakeMusicUrl", "request music url:%s", new Object[] { paramString });
    AppMethodBeat.o(63099);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(63100);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
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
    params = (cse)c.c.b(this.oDw.otC);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if (params != null)
    {
      this.LMZ = params.aayu;
      Log.i("MicroMsg.Music.NetSceneGetShakeMusicUrl", "tempPlayUrl:%s", new Object[] { this.LMZ });
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