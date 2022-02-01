package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.djz;
import com.tencent.mm.protocal.protobuf.dka;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class g
  extends a
{
  private final String TAG;
  public int uiK;
  private dka wHC;
  public int wHD;
  public boolean wHE;
  public boolean wHF;
  
  public g(String paramString1, String paramString2, String paramString3, double paramDouble, String paramString4, int paramInt, String paramString5, String paramString6, boolean paramBoolean1, String paramString7, boolean paramBoolean2)
  {
    AppMethodBeat.i(67656);
    this.TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitPlaceOrder";
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new djz();
    ((b.a)localObject).hvu = new dka();
    ((b.a)localObject).funcId = 2878;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/transferphoneplaceorder";
    this.rr = ((b.a)localObject).aAz();
    localObject = (djz)this.rr.hvr.hvw;
    ((djz)localObject).FSz = paramString1;
    ((djz)localObject).FSA = paramString2;
    ((djz)localObject).FSB = paramString3;
    ((djz)localObject).uiK = ((int)Math.round(100.0D * paramDouble));
    ((djz)localObject).desc = paramString4;
    ((djz)localObject).FSS = paramInt;
    ((djz)localObject).FSD = paramString5;
    ((djz)localObject).FSN = paramString6;
    if (paramBoolean1) {
      ((djz)localObject).FST = bs.bG(paramString7, "");
    }
    ac.i("MicroMsg.mobileRemit.NetSceneMobileRemitPlaceOrder", "do scene NetSceneMobileRemitGetRecord rcvr_openid:%s rcvr_token:%s get_rcvr_ext%s amount:%s desc:%s delay_code:%s real_name_token:%s timestamp_ms:%s isFromForceCheckName:%s replaceorder_token:%s", new Object[] { paramString1, paramString2, paramString3, Double.valueOf(paramDouble), paramString4, Integer.valueOf(paramInt), paramString5, paramString6, Boolean.valueOf(paramBoolean1), bs.bG(paramString7, "null") });
    this.uiK = ((djz)localObject).uiK;
    this.wHD = ((djz)localObject).FSS;
    this.wHE = paramBoolean1;
    this.wHF = paramBoolean2;
    AppMethodBeat.o(67656);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67657);
    ac.i("MicroMsg.mobileRemit.NetSceneMobileRemitPlaceOrder", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.wHC = ((dka)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.mobileRemit.NetSceneMobileRemitPlaceOrder", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.wHC.nWx), this.wHC.nWy });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67657);
  }
  
  public final dka dxF()
  {
    if (this.wHC == null) {
      return null;
    }
    return this.wHC;
  }
  
  public final void e(q paramq)
  {
    paramq = (dka)((b)paramq).hvs.hvw;
    this.JFq = paramq.nWx;
    this.JFr = paramq.nWy;
  }
  
  public final int getType()
  {
    return 2878;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.cgi.g
 * JD-Core Version:    0.7.0.1
 */