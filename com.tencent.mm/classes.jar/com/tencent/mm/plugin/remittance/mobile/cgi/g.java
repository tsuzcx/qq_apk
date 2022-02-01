package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dek;
import com.tencent.mm.protocal.protobuf.del;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class g
  extends a
{
  private final String TAG;
  public int tav;
  public boolean vxA;
  private del vxx;
  public int vxy;
  public boolean vxz;
  
  public g(String paramString1, String paramString2, String paramString3, double paramDouble, String paramString4, int paramInt, String paramString5, String paramString6, boolean paramBoolean1, String paramString7, boolean paramBoolean2)
  {
    AppMethodBeat.i(67656);
    this.TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitPlaceOrder";
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new dek();
    ((b.a)localObject).gUV = new del();
    ((b.a)localObject).funcId = 2878;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/transferphoneplaceorder";
    this.rr = ((b.a)localObject).atI();
    localObject = (dek)this.rr.gUS.gUX;
    ((dek)localObject).Evw = paramString1;
    ((dek)localObject).Evx = paramString2;
    ((dek)localObject).Evy = paramString3;
    ((dek)localObject).tav = ((int)Math.round(100.0D * paramDouble));
    ((dek)localObject).desc = paramString4;
    ((dek)localObject).EvP = paramInt;
    ((dek)localObject).EvA = paramString5;
    ((dek)localObject).EvK = paramString6;
    if (paramBoolean1) {
      ((dek)localObject).EvQ = bt.by(paramString7, "");
    }
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitPlaceOrder", "do scene NetSceneMobileRemitGetRecord rcvr_openid:%s rcvr_token:%s get_rcvr_ext%s amount:%s desc:%s delay_code:%s real_name_token:%s timestamp_ms:%s isFromForceCheckName:%s replaceorder_token:%s", new Object[] { paramString1, paramString2, paramString3, Double.valueOf(paramDouble), paramString4, Integer.valueOf(paramInt), paramString5, paramString6, Boolean.valueOf(paramBoolean1), bt.by(paramString7, "null") });
    this.tav = ((dek)localObject).tav;
    this.vxy = ((dek)localObject).EvP;
    this.vxz = paramBoolean1;
    this.vxA = paramBoolean2;
    AppMethodBeat.o(67656);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67657);
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitPlaceOrder", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.vxx = ((del)((b)paramq).gUT.gUX);
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitPlaceOrder", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.vxx.ntx), this.vxx.nty });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67657);
  }
  
  public final del djD()
  {
    if (this.vxx == null) {
      return null;
    }
    return this.vxx;
  }
  
  public final void e(q paramq)
  {
    paramq = (del)((b)paramq).gUT.gUX;
    this.IdO = paramq.ntx;
    this.IdP = paramq.nty;
  }
  
  public final int getType()
  {
    return 2878;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.cgi.g
 * JD-Core Version:    0.7.0.1
 */