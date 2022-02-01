package com.tencent.mm.plugin.wallet_core.c;

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
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.ake;
import com.tencent.mm.sdk.platformtools.Log;

public final class o
  extends q
  implements m
{
  private boolean HPM;
  private akd HPR;
  public ake HPS;
  private i callback;
  private d hJu;
  
  public o(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(69920);
    this.HPM = paramBoolean;
    d.a locala = new d.a();
    locala.iLN = new akd();
    locala.iLO = new ake();
    if (paramBoolean) {
      locala.funcId = 2529;
    }
    for (locala.uri = "/cgi-bin/mmpay-bin/mktf2fmodifyexposure";; locala.uri = "/cgi-bin/mmpay-bin/mktmodifyexposure")
    {
      locala.iLP = 0;
      locala.respCmdId = 0;
      this.hJu = locala.aXF();
      this.HPR = ((akd)this.hJu.iLK.iLR);
      this.HPR.Ltl = paramString;
      AppMethodBeat.o(69920);
      return;
      locala.funcId = 2888;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(69921);
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
    AppMethodBeat.o(69921);
    return i;
  }
  
  public final int getType()
  {
    if (this.HPM) {
      return 2529;
    }
    return 2888;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69922);
    Log.i("MicroMsg.NetSceneMktModifyExposure", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.HPS = ((ake)((d)params).iLL.iLR);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(69922);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.o
 * JD-Core Version:    0.7.0.1
 */