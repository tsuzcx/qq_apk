package com.tencent.mm.plugin.profile.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.efm;
import com.tencent.mm.protocal.protobuf.efn;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends q
  implements m
{
  private i callback;
  public com.tencent.mm.ak.d rr;
  
  public d(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(6384);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new efm();
    ((d.a)localObject).iLO = new efn();
    ((d.a)localObject).uri = "/cgi-bin/mmocbiz-bin/switchbrand";
    ((d.a)localObject).funcId = 1394;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (efm)this.rr.iLK.iLR;
    ((efm)localObject).KTt = paramString;
    ((efm)localObject).neT = paramBoolean;
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
  
  public final efn eDY()
  {
    if ((this.rr != null) && (this.rr.iLL.iLR != null)) {
      return (efn)this.rr.iLL.iLR;
    }
    return null;
  }
  
  public final efm eDZ()
  {
    if ((this.rr != null) && (this.rr.iLK.iLR != null)) {
      return (efm)this.rr.iLK.iLR;
    }
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