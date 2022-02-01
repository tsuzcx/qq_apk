package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dpx;
import com.tencent.mm.protocal.protobuf.dpy;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
  extends a
{
  private final String TAG;
  public int reason;
  public dpy ykP;
  private String ykQ;
  
  public b(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(174407);
    this.TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord";
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dpx();
    ((b.a)localObject).hQG = new dpy();
    ((b.a)localObject).funcId = 2694;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/transferphonecheckname";
    this.rr = ((b.a)localObject).aDS();
    localObject = (dpx)this.rr.hQD.hQJ;
    ((dpx)localObject).reason = paramInt;
    ((dpx)localObject).HWV = paramString1;
    ((dpx)localObject).HWW = paramString2;
    ((dpx)localObject).yqD = paramString3;
    ((dpx)localObject).HWX = paramString4;
    ((dpx)localObject).HWY = paramString5;
    ae.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "do scene NetSceneMobileRemitCheckName reason:%s rcvrOpenid:%s rcvrToken:%s inputName:%s getRcvrExt:%s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, paramString3, paramString4 });
    this.ykQ = paramString3;
    this.reason = paramInt;
    AppMethodBeat.o(174407);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67627);
    ae.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.ykP = ((dpy)((com.tencent.mm.ak.b)paramq).hQE.hQJ);
    ae.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.ykP.oGt), this.ykP.oGu });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67627);
  }
  
  public final void e(q paramq)
  {
    paramq = (dpy)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    this.LVj = paramq.oGt;
    this.LVk = paramq.oGu;
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