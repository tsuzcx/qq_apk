package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.djl;
import com.tencent.mm.protocal.protobuf.djm;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
  extends a
{
  private final String TAG;
  public int reason;
  public djm wHp;
  private String wHq;
  
  public b(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(174407);
    this.TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord";
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new djl();
    ((b.a)localObject).hvu = new djm();
    ((b.a)localObject).funcId = 2694;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/transferphonecheckname";
    this.rr = ((b.a)localObject).aAz();
    localObject = (djl)this.rr.hvr.hvw;
    ((djl)localObject).reason = paramInt;
    ((djl)localObject).FSz = paramString1;
    ((djl)localObject).FSA = paramString2;
    ((djl)localObject).wNe = paramString3;
    ((djl)localObject).FSB = paramString4;
    ((djl)localObject).FSC = paramString5;
    ac.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "do scene NetSceneMobileRemitCheckName reason:%s rcvrOpenid:%s rcvrToken:%s inputName:%s getRcvrExt:%s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, paramString3, paramString4 });
    this.wHq = paramString3;
    this.reason = paramInt;
    AppMethodBeat.o(174407);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67627);
    ac.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.wHp = ((djm)((com.tencent.mm.ak.b)paramq).hvs.hvw);
    ac.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.wHp.nWx), this.wHp.nWy });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67627);
  }
  
  public final void e(q paramq)
  {
    paramq = (djm)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    this.JFq = paramq.nWx;
    this.JFr = paramq.nWy;
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