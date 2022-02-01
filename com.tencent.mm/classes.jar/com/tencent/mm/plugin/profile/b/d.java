package com.tencent.mm.plugin.profile.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dfp;
import com.tencent.mm.protocal.protobuf.dfq;
import com.tencent.mm.sdk.platformtools.ac;

public final class d
  extends n
  implements k
{
  private g callback;
  public b rr;
  
  public d(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(6384);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dfp();
    ((b.a)localObject).hvu = new dfq();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/switchbrand";
    ((b.a)localObject).funcId = 1394;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (dfp)this.rr.hvr.hvw;
    ((dfp)localObject).Ebs = paramString;
    ((dfp)localObject).ltx = paramBoolean;
    AppMethodBeat.o(6384);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(6386);
    this.callback = paramg;
    ac.i("MicroMsg.brandservice.NetSceneSwitchBrand", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(6386);
    return i;
  }
  
  public final dfq dpN()
  {
    if ((this.rr != null) && (this.rr.hvs.hvw != null)) {
      return (dfq)this.rr.hvs.hvw;
    }
    return null;
  }
  
  public final dfp dpO()
  {
    if ((this.rr != null) && (this.rr.hvr.hvw != null)) {
      return (dfp)this.rr.hvr.hvw;
    }
    return null;
  }
  
  public final int getType()
  {
    return 1394;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(6385);
    ac.d("MicroMsg.brandservice.NetSceneSwitchBrand", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(6385);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.b.d
 * JD-Core Version:    0.7.0.1
 */