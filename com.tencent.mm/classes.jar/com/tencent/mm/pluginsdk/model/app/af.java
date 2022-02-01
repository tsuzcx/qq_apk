package com.tencent.mm.pluginsdk.model.app;

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
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.fk;
import com.tencent.mm.protocal.protobuf.fl;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;

public final class af
  extends p
  implements m
{
  int XSN;
  ae XSO;
  private h callback;
  private c rr;
  
  public af(int paramInt, ae paramae)
  {
    AppMethodBeat.i(151804);
    this.XSN = paramInt;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fk();
    ((c.a)localObject).otF = new fl();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/appcenter";
    ((c.a)localObject).funcId = 452;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (fk)c.b.b(this.rr.otB);
    byte[] arrayOfByte = paramae.iIa();
    if (arrayOfByte != null) {
      ((fk)localObject).YGU = new gol().df(arrayOfByte);
    }
    ((fk)localObject).vhJ = paramInt;
    this.XSO = paramae;
    AppMethodBeat.o(151804);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(151806);
    this.callback = paramh;
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
    this.XSO.cV(w.a(((fl)c.c.b(this.rr.otC)).YGV));
    this.XSO.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, this.rr, paramArrayOfByte);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.af
 * JD-Core Version:    0.7.0.1
 */