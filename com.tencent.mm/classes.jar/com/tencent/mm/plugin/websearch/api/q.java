package com.tencent.mm.plugin.websearch.api;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.audio.mix.i.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.buu;
import com.tencent.mm.protocal.protobuf.buv;

public final class q
  extends com.tencent.mm.ak.q
  implements m
{
  private buu IDv;
  private buv IDw;
  private int IDx;
  private Bitmap IDy;
  private i callback;
  private d iUB;
  
  public q(buu parambuu, int paramInt)
  {
    AppMethodBeat.i(187826);
    this.IDx = -1;
    this.IDy = null;
    this.IDv = parambuu;
    this.IDx = paramInt;
    d.a locala = new d.a();
    locala.funcId = 4614;
    locala.uri = "/cgi-bin/mmsearch-bin/searchshare";
    locala.iLN = parambuu;
    locala.iLO = new buv();
    this.iUB = locala.aXF();
    AppMethodBeat.o(187826);
  }
  
  public final void aG(Bitmap paramBitmap)
  {
    this.IDy = paramBitmap;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(187827);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
    AppMethodBeat.o(187827);
    return i;
  }
  
  public final buv fXK()
  {
    return this.IDw;
  }
  
  public final buu fXL()
  {
    return this.IDv;
  }
  
  public final int fXz()
  {
    return this.IDx;
  }
  
  public final Bitmap getCropBitmap()
  {
    return this.IDy;
  }
  
  public final int getType()
  {
    return 4614;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(187828);
    b.i("MicroMsg.WebSearch.NetSceneGetSearchShare", "onGYNetEnd errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.IDw = ((buv)this.iUB.iLL.iLR);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(187828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.q
 * JD-Core Version:    0.7.0.1
 */