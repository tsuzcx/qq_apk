package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dkl;
import com.tencent.mm.protocal.protobuf.dkm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public final class ai
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  public c rr;
  
  public ai(int paramInt, String paramString)
  {
    AppMethodBeat.i(151818);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new dkl();
    ((c.a)localObject).otF = new dkm();
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/getserviceapplist";
    ((c.a)localObject).funcId = 1060;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (dkl)c.b.b(this.rr.otB);
    ((dkl)localObject).offset = paramInt;
    ((dkl)localObject).limit = 20;
    ((dkl)localObject).lang = paramString;
    com.tencent.mm.kernel.h.baF();
    ((dkl)localObject).aaQr = String.valueOf(((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNa, Integer.valueOf(0))).intValue());
    AppMethodBeat.o(151818);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(151820);
    this.callback = paramh;
    Log.i("MicroMsg.NetSceneGetServiceAppList", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(151820);
    return i;
  }
  
  public final int getType()
  {
    return 1060;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151819);
    Log.d("MicroMsg.NetSceneGetServiceAppList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(151819);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ai
 * JD-Core Version:    0.7.0.1
 */