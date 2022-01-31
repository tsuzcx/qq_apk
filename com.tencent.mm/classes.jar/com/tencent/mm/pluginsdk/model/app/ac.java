package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bbc;
import com.tencent.mm.protocal.protobuf.bbd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class ac
  extends m
  implements k
{
  private f callback;
  public b rr;
  
  public ac(int paramInt, String paramString)
  {
    AppMethodBeat.i(79381);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bbc();
    ((b.a)localObject).fsY = new bbd();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/getserviceapplist";
    ((b.a)localObject).funcId = 1060;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (bbc)this.rr.fsV.fta;
    ((bbc)localObject).offset = paramInt;
    ((bbc)localObject).limit = 20;
    ((bbc)localObject).lang = paramString;
    g.RM();
    ((bbc)localObject).xqk = String.valueOf(((Integer)g.RL().Ru().get(ac.a.yCE, Integer.valueOf(0))).intValue());
    AppMethodBeat.o(79381);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(79383);
    this.callback = paramf;
    ab.i("MicroMsg.NetSceneGetServiceAppList", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(79383);
    return i;
  }
  
  public final int getType()
  {
    return 1060;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(79382);
    ab.d("MicroMsg.NetSceneGetServiceAppList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(79382);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ac
 * JD-Core Version:    0.7.0.1
 */