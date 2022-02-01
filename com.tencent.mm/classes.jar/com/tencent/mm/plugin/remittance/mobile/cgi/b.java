package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ddw;
import com.tencent.mm.protocal.protobuf.ddx;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends a
{
  private final String TAG;
  public int bvJ;
  public ddx vxk;
  private String vxl;
  
  public b(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(174407);
    this.TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord";
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new ddw();
    ((b.a)localObject).gUV = new ddx();
    ((b.a)localObject).funcId = 2694;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/transferphonecheckname";
    this.rr = ((b.a)localObject).atI();
    localObject = (ddw)this.rr.gUS.gUX;
    ((ddw)localObject).bvJ = paramInt;
    ((ddw)localObject).Evw = paramString1;
    ((ddw)localObject).Evx = paramString2;
    ((ddw)localObject).vCZ = paramString3;
    ((ddw)localObject).Evy = paramString4;
    ((ddw)localObject).Evz = paramString5;
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "do scene NetSceneMobileRemitCheckName reason:%s rcvrOpenid:%s rcvrToken:%s inputName:%s getRcvrExt:%s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, paramString3, paramString4 });
    this.vxl = paramString3;
    this.bvJ = paramInt;
    AppMethodBeat.o(174407);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67627);
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.vxk = ((ddx)((com.tencent.mm.al.b)paramq).gUT.gUX);
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.vxk.ntx), this.vxk.nty });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67627);
  }
  
  public final void e(q paramq)
  {
    paramq = (ddx)((com.tencent.mm.al.b)paramq).gUT.gUX;
    this.IdO = paramq.ntx;
    this.IdP = paramq.nty;
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