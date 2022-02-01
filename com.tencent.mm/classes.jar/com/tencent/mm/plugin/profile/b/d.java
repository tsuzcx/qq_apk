package com.tencent.mm.plugin.profile.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.epo;
import com.tencent.mm.protocal.protobuf.epp;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends q
  implements m
{
  private i callback;
  public com.tencent.mm.an.d rr;
  
  public d(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(6384);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new epo();
    ((d.a)localObject).lBV = new epp();
    ((d.a)localObject).uri = "/cgi-bin/mmocbiz-bin/switchbrand";
    ((d.a)localObject).funcId = 1394;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (epo)d.b.b(this.rr.lBR);
    ((epo)localObject).RUp = paramString;
    ((epo)localObject).qfB = paramBoolean;
    AppMethodBeat.o(6384);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(6386);
    this.callback = parami;
    Log.i("MicroMsg.brandservice.NetSceneSwitchBrand", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(6386);
    return i;
  }
  
  public final epp fpR()
  {
    AppMethodBeat.i(263676);
    if ((this.rr != null) && (d.c.b(this.rr.lBS) != null))
    {
      epp localepp = (epp)d.c.b(this.rr.lBS);
      AppMethodBeat.o(263676);
      return localepp;
    }
    AppMethodBeat.o(263676);
    return null;
  }
  
  public final epo fpS()
  {
    AppMethodBeat.i(263677);
    if ((this.rr != null) && (d.b.b(this.rr.lBR) != null))
    {
      epo localepo = (epo)d.b.b(this.rr.lBR);
      AppMethodBeat.o(263677);
      return localepo;
    }
    AppMethodBeat.o(263677);
    return null;
  }
  
  public final int getType()
  {
    return 1394;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(6385);
    Log.d("MicroMsg.brandservice.NetSceneSwitchBrand", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(6385);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.b.d
 * JD-Core Version:    0.7.0.1
 */