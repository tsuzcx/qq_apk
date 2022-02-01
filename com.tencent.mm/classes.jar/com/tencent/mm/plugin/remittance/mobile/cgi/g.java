package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dql;
import com.tencent.mm.protocal.protobuf.dqm;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class g
  extends a
{
  private final String TAG;
  public int vxx;
  private dqm ylc;
  public int yld;
  public boolean yle;
  public boolean ylf;
  
  public g(String paramString1, String paramString2, String paramString3, double paramDouble, String paramString4, int paramInt, String paramString5, String paramString6, boolean paramBoolean1, String paramString7, boolean paramBoolean2)
  {
    AppMethodBeat.i(67656);
    this.TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitPlaceOrder";
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dql();
    ((b.a)localObject).hQG = new dqm();
    ((b.a)localObject).funcId = 2878;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/transferphoneplaceorder";
    this.rr = ((b.a)localObject).aDS();
    localObject = (dql)this.rr.hQD.hQJ;
    ((dql)localObject).HWV = paramString1;
    ((dql)localObject).HWW = paramString2;
    ((dql)localObject).HWX = paramString3;
    ((dql)localObject).vxx = ((int)Math.round(100.0D * paramDouble));
    ((dql)localObject).desc = paramString4;
    ((dql)localObject).HXo = paramInt;
    ((dql)localObject).HWZ = paramString5;
    ((dql)localObject).HXj = paramString6;
    if (paramBoolean1) {
      ((dql)localObject).HXp = bu.bI(paramString7, "");
    }
    ae.i("MicroMsg.mobileRemit.NetSceneMobileRemitPlaceOrder", "do scene NetSceneMobileRemitGetRecord rcvr_openid:%s rcvr_token:%s get_rcvr_ext%s amount:%s desc:%s delay_code:%s real_name_token:%s timestamp_ms:%s isFromForceCheckName:%s replaceorder_token:%s", new Object[] { paramString1, paramString2, paramString3, Double.valueOf(paramDouble), paramString4, Integer.valueOf(paramInt), paramString5, paramString6, Boolean.valueOf(paramBoolean1), bu.bI(paramString7, "null") });
    this.vxx = ((dql)localObject).vxx;
    this.yld = ((dql)localObject).HXo;
    this.yle = paramBoolean1;
    this.ylf = paramBoolean2;
    AppMethodBeat.o(67656);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67657);
    ae.i("MicroMsg.mobileRemit.NetSceneMobileRemitPlaceOrder", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.ylc = ((dqm)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.mobileRemit.NetSceneMobileRemitPlaceOrder", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.ylc.oGt), this.ylc.oGu });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67657);
  }
  
  public final dqm dMo()
  {
    if (this.ylc == null) {
      return null;
    }
    return this.ylc;
  }
  
  public final void e(q paramq)
  {
    paramq = (dqm)((b)paramq).hQE.hQJ;
    this.LVj = paramq.oGt;
    this.LVk = paramq.oGu;
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