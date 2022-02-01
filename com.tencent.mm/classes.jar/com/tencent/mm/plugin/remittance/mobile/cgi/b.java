package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ejt;
import com.tencent.mm.protocal.protobuf.eju;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends a
{
  public eju ClP;
  private String ClQ;
  private final String TAG;
  public int bDZ;
  
  public b(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(174407);
    this.TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord";
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ejt();
    ((d.a)localObject).iLO = new eju();
    ((d.a)localObject).funcId = 2694;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/transferphonecheckname";
    this.rr = ((d.a)localObject).aXF();
    localObject = (ejt)this.rr.iLK.iLR;
    ((ejt)localObject).bDZ = paramInt;
    ((ejt)localObject).Njb = paramString1;
    ((ejt)localObject).Njc = paramString2;
    ((ejt)localObject).Cru = paramString3;
    ((ejt)localObject).Njd = paramString4;
    ((ejt)localObject).Nje = paramString5;
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "do scene NetSceneMobileRemitCheckName reason:%s rcvrOpenid:%s rcvrToken:%s inputName:%s getRcvrExt:%s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, paramString3, paramString4 });
    this.ClQ = paramString3;
    this.bDZ = paramInt;
    AppMethodBeat.o(174407);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67627);
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.ClP = ((eju)((d)params).iLL.iLR);
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.ClP.pTZ), this.ClP.pUa });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67627);
  }
  
  public final void e(s params)
  {
    params = (eju)((d)params).iLL.iLR;
    this.RtZ = params.pTZ;
    this.Rua = params.pUa;
  }
  
  public final int getType()
  {
    return 2694;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.cgi.b
 * JD-Core Version:    0.7.0.1
 */