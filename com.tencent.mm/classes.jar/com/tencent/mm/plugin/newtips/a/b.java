package com.tencent.mm.plugin.newtips.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cim;
import com.tencent.mm.protocal.protobuf.cin;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
  extends n
  implements k
{
  private g callback;
  private com.tencent.mm.ak.b rr;
  boolean vmM;
  int vmN;
  
  @Deprecated
  public b(int paramInt, String paramString)
  {
    AppMethodBeat.i(127209);
    this.vmM = false;
    this.vmN = 0;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cim();
    ((b.a)localObject).hvu = new cin();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/pushnewtips";
    ((b.a)localObject).funcId = 597;
    this.rr = ((b.a)localObject).aAz();
    localObject = (cim)this.rr.hvr.hvw;
    ((cim)localObject).Fwz = paramInt;
    ((cim)localObject).FwA = 1;
    ((cim)localObject).tlp = paramString;
    this.vmN = paramInt;
    AppMethodBeat.o(127209);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(127211);
    ac.d("MicroMsg.NetScenePushCompatNewTips", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(127211);
    return i;
  }
  
  public final int getType()
  {
    return 597;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(127210);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ac.e("MicroMsg.NetScenePushCompatNewTips", "errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(127210);
      return;
    }
    this.vmM = ((cin)((com.tencent.mm.ak.b)paramq).hvs.hvw).FwC;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(127210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a.b
 * JD-Core Version:    0.7.0.1
 */