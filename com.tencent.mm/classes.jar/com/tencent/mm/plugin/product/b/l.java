package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.eew;
import com.tencent.mm.protocal.protobuf.eex;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.w;

public final class l
  extends w
  implements m
{
  public String AZw;
  private i callback;
  private d rr;
  
  public l(dyy paramdyy, String paramString)
  {
    AppMethodBeat.i(66906);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new eew();
    ((d.a)localObject).iLO = new eex();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/submitmallorder";
    ((d.a)localObject).funcId = 556;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (eew)this.rr.iLK.iLR;
    ((eew)localObject).NeQ = paramdyy;
    ((eew)localObject).NeS = paramString;
    AppMethodBeat.o(66906);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(66907);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(66907);
    return i;
  }
  
  public final int getType()
  {
    return 556;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(66908);
    params = (eex)((d)params).iLL.iLR;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Log.d("MicroMsg.NetSceneMallSubmitMallOrder", "resp.ReqKey " + params.NeR);
      this.AZw = params.NeR;
    }
    Log.d("MicroMsg.NetSceneMallSubmitMallOrder", "errCode " + paramInt3 + ", errMsg " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(66908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.l
 * JD-Core Version:    0.7.0.1
 */