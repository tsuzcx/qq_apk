package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bxf;
import com.tencent.mm.protocal.protobuf.bxg;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends q
  implements m
{
  private i callback;
  private com.tencent.mm.ak.d rr;
  
  public d(String paramString)
  {
    AppMethodBeat.i(88480);
    d.a locala = new d.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmsearch-bin/getuserattrbyopenid";
    locala.iLN = new bxf();
    locala.iLO = new bxg();
    this.rr = locala.aXF();
    ((bxf)this.rr.iLK.iLR).openid = paramString;
    AppMethodBeat.o(88480);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(88481);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(88481);
    return i;
  }
  
  public final bxg fyb()
  {
    return (bxg)this.rr.iLL.iLR;
  }
  
  public final int getType()
  {
    return 2830;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88482);
    Log.i("MicroMsg.TopStory.NetSceneTopStoryGetUsername", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(88482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.d
 * JD-Core Version:    0.7.0.1
 */