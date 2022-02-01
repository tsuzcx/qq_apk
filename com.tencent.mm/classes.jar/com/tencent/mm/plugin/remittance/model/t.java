package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.tt;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.sdk.platformtools.ac;

public final class t
  extends n
  implements k
{
  private g callback;
  private b gvE;
  public tu wKE;
  
  public t(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5)
  {
    AppMethodBeat.i(67877);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new tt();
    ((b.a)localObject).hvu = new tu();
    ((b.a)localObject).funcId = 1779;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/transferoldpaycheck";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.gvE = ((b.a)localObject).aAz();
    localObject = (tt)this.gvE.hvr.hvw;
    ((tt)localObject).djr = paramString1;
    ((tt)localObject).wLB = paramString2;
    ((tt)localObject).wLA = paramString3;
    ((tt)localObject).wLu = paramString4;
    ((tt)localObject).wNG = paramLong;
    ((tt)localObject).Enm = paramString5;
    ac.i("MicroMsg.NetSceneRemittancePayCheck", "reqKey: %s, transfer: %s, fee: %s", new Object[] { paramString1, paramString2, Long.valueOf(paramLong) });
    AppMethodBeat.o(67877);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(67878);
    this.callback = paramg;
    int i = dispatch(parame, this.gvE, this);
    AppMethodBeat.o(67878);
    return i;
  }
  
  public final int getType()
  {
    return 1779;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67879);
    ac.i("MicroMsg.NetSceneRemittancePayCheck", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.wKE = ((tu)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneRemittancePayCheck", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.wKE.dae), this.wKE.oxf });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(67879);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.t
 * JD-Core Version:    0.7.0.1
 */