package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.audio.mix.i.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.fau;
import com.tencent.mm.protocal.protobuf.fav;
import com.tencent.mm.ui.ao;

public final class x
  extends q
  implements m
{
  private fav IDA;
  private v IDt;
  private fau IDz;
  private i callback;
  private d iUB;
  
  public x(v paramv)
  {
    AppMethodBeat.i(187835);
    this.IDt = paramv;
    paramv = new d.a();
    paramv.funcId = 4858;
    paramv.uri = "/cgi-bin/mmsearch-bin/mmtagsearch";
    paramv.iLN = new fau();
    paramv.iLO = new fav();
    this.iUB = paramv.aXF();
    this.IDz = ((fau)this.iUB.iLK.iLR);
    this.IDz.LPT = this.IDt.dDv;
    this.IDz.MRb = this.IDt.IDE;
    this.IDz.KZg = this.IDt.businessType;
    this.IDz.MlQ = ai.clJ();
    this.IDz.KZk = this.IDt.offset;
    this.IDz.NwV = ai.aft(6);
    this.IDz.MUs = this.IDt.IDF;
    this.IDz.Scene = this.IDt.scene;
    this.IDz.KZj = this.IDt.rjq;
    this.IDz.MRf = this.IDt.dVS;
    this.IDz.NwW = this.IDt.IDG;
    this.IDz.NwY = this.IDt.IDI;
    this.IDz.NwX = this.IDt.IDH;
    this.IDz.NwZ = this.IDt.IDJ;
    this.IDz.Nva = this.IDt.IDO;
    this.IDz.IDN = this.IDt.IDN;
    this.IDz.Nxa = this.IDt.IDP;
    this.IDz.rBI = this.IDt.language;
    this.IDz.NwH = this.IDt.sessionId;
    paramv = this.IDz;
    if (ao.isDarkMode()) {}
    for (int i = 1;; i = 0)
    {
      paramv.MEt = i;
      this.IDz.MlR = ai.fYd();
      AppMethodBeat.o(187835);
      return;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(187836);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
    AppMethodBeat.o(187836);
    return i;
  }
  
  public final fav fXM()
  {
    return this.IDA;
  }
  
  public final v fXN()
  {
    return this.IDt;
  }
  
  public final int getType()
  {
    return 4858;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(187837);
    b.i("MicroMsg.WebSearch.NetSceneTagSearch", "onGYNetEnd errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.IDA = ((fav)this.iUB.iLL.iLR);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(187837);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.x
 * JD-Core Version:    0.7.0.1
 */