package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.et;
import com.tencent.mm.protocal.protobuf.eu;
import com.tencent.mm.sdk.platformtools.Log;

public final class ab
  extends q
  implements m
{
  int JWw;
  aa JWx;
  private i callback;
  private d rr;
  
  public ab(int paramInt, aa paramaa)
  {
    AppMethodBeat.i(151804);
    this.JWw = paramInt;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new et();
    ((d.a)localObject).iLO = new eu();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/appcenter";
    ((d.a)localObject).funcId = 452;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (et)this.rr.iLK.iLR;
    byte[] arrayOfByte = paramaa.gmB();
    if (arrayOfByte != null) {
      ((et)localObject).ReqBuf = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
    }
    ((et)localObject).oUv = paramInt;
    this.JWx = paramaa;
    AppMethodBeat.o(151804);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(151806);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(151806);
    return i;
  }
  
  public final int getType()
  {
    return 452;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151805);
    Log.d("MicroMsg.NetSceneAppCenter", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneAppCenter", "errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(151805);
      return;
    }
    this.JWx.cB(z.a(((eu)this.rr.iLL.iLR).KIk));
    this.JWx.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, this.rr, paramArrayOfByte);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ab
 * JD-Core Version:    0.7.0.1
 */