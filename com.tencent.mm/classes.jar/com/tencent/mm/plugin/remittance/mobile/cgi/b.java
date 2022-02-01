package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.etx;
import com.tencent.mm.protocal.protobuf.ety;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends a
{
  public ety IiI;
  private String IiJ;
  private final String TAG;
  public int bnA;
  
  public b(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(174407);
    this.TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord";
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new etx();
    ((d.a)localObject).lBV = new ety();
    ((d.a)localObject).funcId = 2694;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/transferphonecheckname";
    this.rr = ((d.a)localObject).bgN();
    localObject = (etx)d.b.b(this.rr.lBR);
    ((etx)localObject).bnA = paramInt;
    ((etx)localObject).UvJ = paramString1;
    ((etx)localObject).UvK = paramString2;
    ((etx)localObject).IoS = paramString3;
    ((etx)localObject).UvL = paramString4;
    ((etx)localObject).UvM = paramString5;
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "do scene NetSceneMobileRemitCheckName reason:%s rcvrOpenid:%s rcvrToken:%s inputName:%s getRcvrExt:%s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, paramString3, paramString4 });
    this.IiJ = paramString3;
    this.bnA = paramInt;
    AppMethodBeat.o(174407);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67627);
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.IiI = ((ety)d.c.b(((d)params).lBS));
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.IiI.tqa), this.IiI.tqb });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67627);
  }
  
  public final void f(s params)
  {
    AppMethodBeat.i(278024);
    params = (ety)d.c.b(((d)params).lBS);
    this.YVy = params.tqa;
    this.YVz = params.tqb;
    AppMethodBeat.o(278024);
  }
  
  public final int getType()
  {
    return 2694;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.cgi.b
 * JD-Core Version:    0.7.0.1
 */