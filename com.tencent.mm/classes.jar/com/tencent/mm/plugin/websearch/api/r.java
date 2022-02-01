package com.tencent.mm.plugin.websearch.api;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.audio.mix.h.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.crx;
import com.tencent.mm.protocal.protobuf.cry;

public final class r
  extends p
  implements m
{
  public crx WnU;
  public cry WnV;
  public int WnW;
  public Bitmap WnX;
  private h callback;
  private c oDw;
  
  public r(crx paramcrx, int paramInt)
  {
    AppMethodBeat.i(315361);
    this.WnW = -1;
    this.WnX = null;
    this.WnU = paramcrx;
    this.WnW = paramInt;
    c.a locala = new c.a();
    locala.funcId = 4614;
    locala.uri = "/cgi-bin/mmsearch-bin/searchshare";
    locala.otE = paramcrx;
    locala.otF = new cry();
    this.oDw = locala.bEF();
    AppMethodBeat.o(315361);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(315370);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
    AppMethodBeat.o(315370);
    return i;
  }
  
  public final int getType()
  {
    return 4614;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(315376);
    b.i("MicroMsg.WebSearch.NetSceneGetSearchShare", "onGYNetEnd errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.WnV = ((cry)c.c.b(this.oDw.otC));
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(315376);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.r
 * JD-Core Version:    0.7.0.1
 */