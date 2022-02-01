package com.tencent.mm.plugin.profile.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.fkn;
import com.tencent.mm.protocal.protobuf.fko;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends p
  implements m
{
  private h callback;
  public c rr;
  
  public d(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(6384);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fkn();
    ((c.a)localObject).otF = new fko();
    ((c.a)localObject).uri = "/cgi-bin/mmocbiz-bin/switchbrand";
    ((c.a)localObject).funcId = 1394;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (fkn)c.b.b(this.rr.otB);
    ((fkn)localObject).YRQ = paramString;
    ((fkn)localObject).disable = paramBoolean;
    AppMethodBeat.o(6384);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(6386);
    this.callback = paramh;
    Log.i("MicroMsg.brandservice.NetSceneSwitchBrand", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(6386);
    return i;
  }
  
  public final fko gBf()
  {
    AppMethodBeat.i(305378);
    if ((this.rr != null) && (c.c.b(this.rr.otC) != null))
    {
      fko localfko = (fko)c.c.b(this.rr.otC);
      AppMethodBeat.o(305378);
      return localfko;
    }
    AppMethodBeat.o(305378);
    return null;
  }
  
  public final fkn gBg()
  {
    AppMethodBeat.i(305380);
    if ((this.rr != null) && (c.b.b(this.rr.otB) != null))
    {
      fkn localfkn = (fkn)c.b.b(this.rr.otB);
      AppMethodBeat.o(305380);
      return localfkn;
    }
    AppMethodBeat.o(305380);
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
 * Qualified Name:     com.tencent.mm.plugin.profile.a.d
 * JD-Core Version:    0.7.0.1
 */