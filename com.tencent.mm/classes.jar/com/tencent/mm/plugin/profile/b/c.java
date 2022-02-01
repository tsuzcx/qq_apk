package com.tencent.mm.plugin.profile.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dvy;
import com.tencent.mm.protocal.protobuf.dvz;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends q
  implements m
{
  private i callback;
  public d rr;
  
  public c(String paramString, int paramInt)
  {
    AppMethodBeat.i(26907);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dvy();
    ((d.a)localObject).iLO = new dvz();
    ((d.a)localObject).uri = "/cgi-bin/mmocbiz-bin/setbrandflag";
    ((d.a)localObject).funcId = 1363;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (dvy)this.rr.iLK.iLR;
    ((dvy)localObject).KTt = paramString;
    ((dvy)localObject).MWH = paramInt;
    ((dvy)localObject).MWI = 4;
    AppMethodBeat.o(26907);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(26909);
    this.callback = parami;
    Log.i("MicroMsg.brandservice.NetSceneSetBrandFlag", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(26909);
    return i;
  }
  
  public final int getType()
  {
    return 1363;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26908);
    Log.d("MicroMsg.brandservice.NetSceneSetBrandFlag", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(26908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.b.c
 * JD-Core Version:    0.7.0.1
 */