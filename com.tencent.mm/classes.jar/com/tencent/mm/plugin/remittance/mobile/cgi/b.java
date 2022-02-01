package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dpa;
import com.tencent.mm.protocal.protobuf.dpb;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends a
{
  private final String TAG;
  public int reason;
  public dpb xUW;
  private String xUX;
  
  public b(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(174407);
    this.TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord";
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dpa();
    ((b.a)localObject).hNN = new dpb();
    ((b.a)localObject).funcId = 2694;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/transferphonecheckname";
    this.rr = ((b.a)localObject).aDC();
    localObject = (dpa)this.rr.hNK.hNQ;
    ((dpa)localObject).reason = paramInt;
    ((dpa)localObject).HDi = paramString1;
    ((dpa)localObject).HDj = paramString2;
    ((dpa)localObject).yaM = paramString3;
    ((dpa)localObject).HDk = paramString4;
    ((dpa)localObject).HDl = paramString5;
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "do scene NetSceneMobileRemitCheckName reason:%s rcvrOpenid:%s rcvrToken:%s inputName:%s getRcvrExt:%s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, paramString3, paramString4 });
    this.xUX = paramString3;
    this.reason = paramInt;
    AppMethodBeat.o(174407);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67627);
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.xUW = ((dpb)((com.tencent.mm.al.b)paramq).hNL.hNQ);
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.xUW.ozR), this.xUW.ozS });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67627);
  }
  
  public final void e(q paramq)
  {
    paramq = (dpb)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    this.Lyu = paramq.ozR;
    this.Lyv = paramq.ozS;
  }
  
  public final int getType()
  {
    return 2694;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.cgi.b
 * JD-Core Version:    0.7.0.1
 */