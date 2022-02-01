package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.audio.mix.h.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.fln;
import com.tencent.mm.protocal.protobuf.flo;
import com.tencent.mm.ui.ar;

public final class r
  extends q
  implements m
{
  private v PxJ;
  private fln PxP;
  private flo PxQ;
  private i callback;
  private d lKU;
  
  public r(v paramv)
  {
    AppMethodBeat.i(212076);
    this.PxJ = paramv;
    paramv = new d.a();
    paramv.funcId = 719;
    paramv.uri = "/cgi-bin/micromsg-bin/mmwebsearch";
    paramv.lBU = new fln();
    paramv.lBV = new flo();
    this.lKU = paramv.bgN();
    this.PxP = ((fln)d.b.b(this.lKU.lBR));
    this.PxP.SYn = this.PxJ.fwe;
    this.PxP.Udh = this.PxJ.PxU;
    this.PxP.Sap = this.PxJ.businessType;
    this.PxP.TwK = ai.czn();
    this.PxP.Sat = this.PxJ.offset;
    this.PxP.UKl = ai.anh(0);
    this.PxP.UgB = this.PxJ.PxV;
    this.PxP.CPw = this.PxJ.scene;
    this.PxP.Sas = this.PxJ.uMC;
    this.PxP.Udl = this.PxJ.fPw;
    this.PxP.UKm = this.PxJ.PxW;
    this.PxP.UKo = this.PxJ.PxY;
    this.PxP.UKn = this.PxJ.PxX;
    this.PxP.UKp = this.PxJ.PxZ;
    this.PxP.UIj = this.PxJ.Pye;
    this.PxP.Pyd = this.PxJ.Pyd;
    this.PxP.UKq = this.PxJ.Pyf;
    this.PxP.vhq = this.PxJ.language;
    this.PxP.UJX = this.PxJ.sessionId;
    paramv = this.PxP;
    if (ar.isDarkMode()) {}
    for (int i = 1;; i = 0)
    {
      paramv.TQc = i;
      this.PxP.TwL = ai.gQO();
      AppMethodBeat.o(212076);
      return;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(212082);
    this.callback = parami;
    int i = dispatch(paramg, this.lKU, this);
    AppMethodBeat.o(212082);
    return i;
  }
  
  public final flo gQx()
  {
    return this.PxQ;
  }
  
  public final int getType()
  {
    return 719;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(212085);
    b.i("MicroMsg.WebSearch.NetSceneMMWebSearch", "onGYNetEnd errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.PxQ = ((flo)d.c.b(this.lKU.lBS));
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(212085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.r
 * JD-Core Version:    0.7.0.1
 */