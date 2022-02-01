package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dpo;
import com.tencent.mm.protocal.protobuf.dpp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class g
  extends a
{
  private final String TAG;
  public int vls;
  private dpp xVj;
  public int xVk;
  public boolean xVl;
  public boolean xVm;
  
  public g(String paramString1, String paramString2, String paramString3, double paramDouble, String paramString4, int paramInt, String paramString5, String paramString6, boolean paramBoolean1, String paramString7, boolean paramBoolean2)
  {
    AppMethodBeat.i(67656);
    this.TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitPlaceOrder";
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dpo();
    ((b.a)localObject).hNN = new dpp();
    ((b.a)localObject).funcId = 2878;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/transferphoneplaceorder";
    this.rr = ((b.a)localObject).aDC();
    localObject = (dpo)this.rr.hNK.hNQ;
    ((dpo)localObject).HDi = paramString1;
    ((dpo)localObject).HDj = paramString2;
    ((dpo)localObject).HDk = paramString3;
    ((dpo)localObject).vls = ((int)Math.round(100.0D * paramDouble));
    ((dpo)localObject).desc = paramString4;
    ((dpo)localObject).HDB = paramInt;
    ((dpo)localObject).HDm = paramString5;
    ((dpo)localObject).HDw = paramString6;
    if (paramBoolean1) {
      ((dpo)localObject).HDC = bt.bI(paramString7, "");
    }
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitPlaceOrder", "do scene NetSceneMobileRemitGetRecord rcvr_openid:%s rcvr_token:%s get_rcvr_ext%s amount:%s desc:%s delay_code:%s real_name_token:%s timestamp_ms:%s isFromForceCheckName:%s replaceorder_token:%s", new Object[] { paramString1, paramString2, paramString3, Double.valueOf(paramDouble), paramString4, Integer.valueOf(paramInt), paramString5, paramString6, Boolean.valueOf(paramBoolean1), bt.bI(paramString7, "null") });
    this.vls = ((dpo)localObject).vls;
    this.xVk = ((dpo)localObject).HDB;
    this.xVl = paramBoolean1;
    this.xVm = paramBoolean2;
    AppMethodBeat.o(67656);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67657);
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitPlaceOrder", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.xVj = ((dpp)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitPlaceOrder", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.xVj.ozR), this.xVj.ozS });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67657);
  }
  
  public final dpp dIX()
  {
    if (this.xVj == null) {
      return null;
    }
    return this.xVj;
  }
  
  public final void e(q paramq)
  {
    paramq = (dpp)((b)paramq).hNL.hNQ;
    this.Lyu = paramq.ozR;
    this.Lyv = paramq.ozS;
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