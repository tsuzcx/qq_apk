package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.czg;
import com.tencent.mm.protocal.protobuf.czh;
import com.tencent.mm.sdk.platformtools.Log;

public final class j
  extends b
{
  public String IfC;
  public czh IfK;
  private final String TAG;
  private i callback;
  public String remark;
  private d rr;
  
  public j(String paramString1, String paramString2)
  {
    AppMethodBeat.i(67376);
    this.TAG = "MicroMsg.NetSceneBankRemitModifyExplain";
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new czg();
    ((d.a)localObject).lBV = new czh();
    ((d.a)localObject).funcId = 1590;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/modifyexplain_tsbc";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (czg)d.b.b(this.rr.lBR);
    ((czg)localObject).Igm = paramString1;
    ((czg)localObject).Igp = paramString2;
    this.IfC = paramString1;
    this.remark = paramString2;
    AppMethodBeat.o(67376);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67378);
    Log.i("MicroMsg.NetSceneBankRemitModifyExplain", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.IfK = ((czh)d.c.b(((d)params).lBS));
    Log.i("MicroMsg.NetSceneBankRemitModifyExplain", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.IfK.fwx), this.IfK.tVo });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67378);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(67377);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(67377);
    return i;
  }
  
  public final void f(s params)
  {
    AppMethodBeat.i(275084);
    params = (czh)d.c.b(((d)params).lBS);
    this.YVy = params.fwx;
    this.YVz = params.tVo;
    AppMethodBeat.o(275084);
  }
  
  public final int getType()
  {
    return 1590;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.j
 * JD-Core Version:    0.7.0.1
 */