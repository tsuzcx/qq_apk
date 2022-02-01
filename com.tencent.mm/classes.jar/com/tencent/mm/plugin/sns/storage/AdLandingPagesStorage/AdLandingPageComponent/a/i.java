package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.amx;
import com.tencent.mm.protocal.protobuf.amy;
import com.tencent.mm.sdk.platformtools.Log;

public final class i
  extends q
  implements m
{
  public String EiS;
  private com.tencent.mm.ak.i callback;
  private d rr;
  
  public i(String paramString)
  {
    AppMethodBeat.i(97150);
    this.EiS = "";
    this.EiS = paramString;
    d.a locala = new d.a();
    locala.iLN = new amx();
    locala.iLO = new amy();
    locala.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_favofficialitem";
    locala.funcId = 2874;
    this.rr = locala.aXF();
    ((amx)this.rr.iLK.iLR).LxV = paramString;
    Log.i("MicroMsg.NetSceneFavOfficialItem", "Req: item_buff[%s]", new Object[] { paramString });
    AppMethodBeat.o(97150);
  }
  
  public final int doScene(g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(97151);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(97151);
    return i;
  }
  
  public final int getType()
  {
    return 2874;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(97152);
    Log.i("MicroMsg.NetSceneFavOfficialItem", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(97152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.i
 * JD-Core Version:    0.7.0.1
 */