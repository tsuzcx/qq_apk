package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dpq;
import com.tencent.mm.protocal.protobuf.dpr;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
  extends a
{
  private final String TAG;
  public dpr xVh;
  
  public e(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6)
  {
    AppMethodBeat.i(67651);
    this.TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitGetSuccPage";
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dpq();
    ((b.a)localObject).hNN = new dpr();
    ((b.a)localObject).funcId = 1903;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/transferphonesuccpage";
    this.rr = ((b.a)localObject).aDC();
    localObject = (dpq)this.rr.hNK.hNQ;
    ((dpq)localObject).FpY = paramString1;
    ((dpq)localObject).FvI = paramString2;
    ((dpq)localObject).HDi = paramString3;
    ((dpq)localObject).HDj = paramString4;
    ((dpq)localObject).vls = paramInt;
    ((dpq)localObject).HDA = paramString5;
    ((dpq)localObject).HDI = paramString6;
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetSuccPage", "do scene NetSceneMobileRemitGetSuccPage out_trade_no:%s trans_id:%s rcvr_openid:%s rcvr_token:%s amount:%s placeorder_token:%s placeorder_ext:%s", new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(paramInt), paramString5, paramString6 });
    AppMethodBeat.o(67651);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67652);
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetSuccPage", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.xVh = ((dpr)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetSuccPage", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.xVh.ozR), this.xVh.ozS });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67652);
  }
  
  public final void e(q paramq)
  {
    paramq = (dpr)((b)paramq).hNL.hNQ;
    this.Lyu = paramq.ozR;
    this.Lyv = paramq.ozS;
  }
  
  public final int getType()
  {
    return 1903;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.cgi.e
 * JD-Core Version:    0.7.0.1
 */