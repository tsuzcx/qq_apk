package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dem;
import com.tencent.mm.protocal.protobuf.den;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
  extends a
{
  private final String TAG;
  public den vxv;
  
  public e(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6)
  {
    AppMethodBeat.i(67651);
    this.TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitGetSuccPage";
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new dem();
    ((b.a)localObject).gUV = new den();
    ((b.a)localObject).funcId = 1903;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/transferphonesuccpage";
    this.rr = ((b.a)localObject).atI();
    localObject = (dem)this.rr.gUS.gUX;
    ((dem)localObject).CsB = paramString1;
    ((dem)localObject).CxX = paramString2;
    ((dem)localObject).Evw = paramString3;
    ((dem)localObject).Evx = paramString4;
    ((dem)localObject).tav = paramInt;
    ((dem)localObject).EvO = paramString5;
    ((dem)localObject).EvW = paramString6;
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetSuccPage", "do scene NetSceneMobileRemitGetSuccPage out_trade_no:%s trans_id:%s rcvr_openid:%s rcvr_token:%s amount:%s placeorder_token:%s placeorder_ext:%s", new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(paramInt), paramString5, paramString6 });
    AppMethodBeat.o(67651);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67652);
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetSuccPage", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.vxv = ((den)((b)paramq).gUT.gUX);
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetSuccPage", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.vxv.ntx), this.vxv.nty });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67652);
  }
  
  public final void e(q paramq)
  {
    paramq = (den)((b)paramq).gUT.gUX;
    this.IdO = paramq.ntx;
    this.IdP = paramq.nty;
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