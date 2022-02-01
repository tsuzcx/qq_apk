package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.arr;
import com.tencent.mm.protocal.protobuf.ars;
import com.tencent.mm.sdk.platformtools.Log;

public final class j
  extends p
  implements m
{
  public String QUK;
  private h callback;
  private c rr;
  
  public j(String paramString)
  {
    AppMethodBeat.i(97150);
    this.QUK = "";
    this.QUK = paramString;
    c.a locala = new c.a();
    locala.otE = new arr();
    locala.otF = new ars();
    locala.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_favofficialitem";
    locala.funcId = 2874;
    this.rr = locala.bEF();
    ((arr)c.b.b(this.rr.otB)).ZBo = paramString;
    Log.i("MicroMsg.NetSceneFavOfficialItem", "Req: item_buff[%s]", new Object[] { paramString });
    AppMethodBeat.o(97150);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(97151);
    this.callback = paramh;
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
    c.c.b(((c)params).otC);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(97152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.j
 * JD-Core Version:    0.7.0.1
 */