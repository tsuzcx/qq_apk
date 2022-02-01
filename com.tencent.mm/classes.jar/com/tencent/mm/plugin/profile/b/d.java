package com.tencent.mm.plugin.profile.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dlc;
import com.tencent.mm.protocal.protobuf.dld;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
  extends n
  implements k
{
  private f callback;
  public b rr;
  
  public d(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(6384);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dlc();
    ((b.a)localObject).hNN = new dld();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/switchbrand";
    ((b.a)localObject).funcId = 1394;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dlc)this.rr.hNK.hNQ;
    ((dlc)localObject).FHb = paramString;
    ((dlc)localObject).lSG = paramBoolean;
    AppMethodBeat.o(6384);
  }
  
  public final dld dAq()
  {
    if ((this.rr != null) && (this.rr.hNL.hNQ != null)) {
      return (dld)this.rr.hNL.hNQ;
    }
    return null;
  }
  
  public final dlc dAr()
  {
    if ((this.rr != null) && (this.rr.hNK.hNQ != null)) {
      return (dlc)this.rr.hNK.hNQ;
    }
    return null;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(6386);
    this.callback = paramf;
    ad.i("MicroMsg.brandservice.NetSceneSwitchBrand", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(6386);
    return i;
  }
  
  public final int getType()
  {
    return 1394;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(6385);
    ad.d("MicroMsg.brandservice.NetSceneSwitchBrand", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
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