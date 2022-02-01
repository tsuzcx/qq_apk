package com.tencent.mm.plugin.websearch.api;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.audio.mix.h.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ccm;
import com.tencent.mm.protocal.protobuf.ccn;

public final class q
  extends com.tencent.mm.an.q
  implements m
{
  private ccm PxL;
  private ccn PxM;
  private int PxN;
  private Bitmap PxO;
  private i callback;
  private d lKU;
  
  public q(ccm paramccm, int paramInt)
  {
    AppMethodBeat.i(212203);
    this.PxN = -1;
    this.PxO = null;
    this.PxL = paramccm;
    this.PxN = paramInt;
    d.a locala = new d.a();
    locala.funcId = 4614;
    locala.uri = "/cgi-bin/mmsearch-bin/searchshare";
    locala.lBU = paramccm;
    locala.lBV = new ccn();
    this.lKU = locala.bgN();
    AppMethodBeat.o(212203);
  }
  
  public final void aD(Bitmap paramBitmap)
  {
    this.PxO = paramBitmap;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(212208);
    this.callback = parami;
    int i = dispatch(paramg, this.lKU, this);
    AppMethodBeat.o(212208);
    return i;
  }
  
  public final int gQm()
  {
    return this.PxN;
  }
  
  public final ccn gQv()
  {
    return this.PxM;
  }
  
  public final ccm gQw()
  {
    return this.PxL;
  }
  
  public final Bitmap getCropBitmap()
  {
    return this.PxO;
  }
  
  public final int getType()
  {
    return 4614;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(212211);
    b.i("MicroMsg.WebSearch.NetSceneGetSearchShare", "onGYNetEnd errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.PxM = ((ccn)d.c.b(this.lKU.lBS));
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(212211);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.q
 * JD-Core Version:    0.7.0.1
 */