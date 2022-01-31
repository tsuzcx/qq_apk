package com.tencent.mm.plugin.profile.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cis;
import com.tencent.mm.protocal.protobuf.cit;
import com.tencent.mm.sdk.platformtools.ab;

public final class d
  extends m
  implements k
{
  private f callback;
  public b rr;
  
  public d(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(14672);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cis();
    ((b.a)localObject).fsY = new cit();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/switchbrand";
    ((b.a)localObject).funcId = 1394;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (cis)this.rr.fsV.fta;
    ((cis)localObject).wyh = paramString;
    ((cis)localObject).xTc = paramBoolean;
    AppMethodBeat.o(14672);
  }
  
  public final cit cbO()
  {
    if ((this.rr != null) && (this.rr.fsW.fta != null)) {
      return (cit)this.rr.fsW.fta;
    }
    return null;
  }
  
  public final cis cbP()
  {
    if ((this.rr != null) && (this.rr.fsV.fta != null)) {
      return (cis)this.rr.fsV.fta;
    }
    return null;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(14674);
    this.callback = paramf;
    ab.i("MicroMsg.brandservice.NetSceneSwitchBrand", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(14674);
    return i;
  }
  
  public final int getType()
  {
    return 1394;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(14673);
    ab.d("MicroMsg.brandservice.NetSceneSwitchBrand", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(14673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.b.d
 * JD-Core Version:    0.7.0.1
 */