package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.vo;
import com.tencent.mm.protocal.protobuf.vp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;
import java.net.URLDecoder;

public final class n
  extends r
{
  public vp CoK;
  private final String TAG;
  
  public n(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(67863);
    this.TAG = "MicroMsg.NetSceneF2fDynamicCode";
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new vo();
    ((d.a)localObject).iLO = new vp();
    ((d.a)localObject).funcId = 2736;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/f2fdynamiccode";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (vo)this.rr.iLK.iLR;
    ((vo)localObject).yRL = paramInt;
    ((vo)localObject).pWm = paramString1;
    ((vo)localObject).CpJ = paramString2;
    ((vo)localObject).LgC = URLDecoder.decode(paramString3);
    ((vo)localObject).Cpr = paramString4;
    ((vo)localObject).Cps = paramString5;
    ((vo)localObject).CpM = paramString6;
    ((vo)localObject).nickname = paramString7;
    ((vo)localObject).Cpg = paramString8;
    Log.i("MicroMsg.NetSceneF2fDynamicCode", "amount: %s, username: %s, transfer_code_id: %s", new Object[] { Integer.valueOf(paramInt), paramString1, URLDecoder.decode(paramString3) });
    AppMethodBeat.o(67863);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67864);
    Log.i("MicroMsg.NetSceneF2fDynamicCode", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.CoK = ((vp)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneF2fDynamicCode", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.CoK.dDN), this.CoK.qwn });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67864);
  }
  
  public final void e(s params)
  {
    params = (vp)((d)params).iLL.iLR;
    this.RtZ = params.dDN;
    this.Rua = params.qwn;
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