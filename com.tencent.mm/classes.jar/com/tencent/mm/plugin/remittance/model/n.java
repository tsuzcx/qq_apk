package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.sk;
import com.tencent.mm.protocal.protobuf.sl;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.r;
import java.net.URLDecoder;

public final class n
  extends r
{
  private final String TAG;
  public sl wKv;
  
  public n(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(67863);
    this.TAG = "MicroMsg.NetSceneF2fDynamicCode";
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new sk();
    ((b.a)localObject).hvu = new sl();
    ((b.a)localObject).funcId = 2736;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/f2fdynamiccode";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (sk)this.rr.hvr.hvw;
    ((sk)localObject).uiK = paramInt;
    ((sk)localObject).nYC = paramString1;
    ((sk)localObject).wLu = paramString2;
    ((sk)localObject).Emq = URLDecoder.decode(paramString3);
    ((sk)localObject).wLc = paramString4;
    ((sk)localObject).wLd = paramString5;
    ((sk)localObject).wLx = paramString6;
    ((sk)localObject).nickname = paramString7;
    ((sk)localObject).wKR = paramString8;
    ac.i("MicroMsg.NetSceneF2fDynamicCode", "amount: %s, username: %s, transfer_code_id: %s", new Object[] { Integer.valueOf(paramInt), paramString1, URLDecoder.decode(paramString3) });
    AppMethodBeat.o(67863);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67864);
    ac.i("MicroMsg.NetSceneF2fDynamicCode", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.wKv = ((sl)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneF2fDynamicCode", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.wKv.dae), this.wKv.oxf });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67864);
  }
  
  public final void e(q paramq)
  {
    paramq = (sl)((b)paramq).hvs.hvw;
    this.JFq = paramq.dae;
    this.JFr = paramq.oxf;
  }
  
  public final int getType()
  {
    return 2736;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.n
 * JD-Core Version:    0.7.0.1
 */