package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ckq;
import com.tencent.mm.protocal.protobuf.ckr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class ae
  extends q
  implements m
{
  private i callback;
  public d rr;
  
  public ae(int paramInt, String paramString)
  {
    AppMethodBeat.i(151818);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ckq();
    ((d.a)localObject).iLO = new ckr();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/getserviceapplist";
    ((d.a)localObject).funcId = 1060;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (ckq)this.rr.iLK.iLR;
    ((ckq)localObject).offset = paramInt;
    ((ckq)localObject).limit = 20;
    ((ckq)localObject).lang = paramString;
    com.tencent.mm.kernel.g.aAi();
    ((ckq)localObject).Mqa = String.valueOf(((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NXG, Integer.valueOf(0))).intValue());
    AppMethodBeat.o(151818);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(151820);
    this.callback = parami;
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
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ae
 * JD-Core Version:    0.7.0.1
 */