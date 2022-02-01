package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.fpy;
import com.tencent.mm.protocal.protobuf.fpz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
  extends a
{
  private fpz OfG;
  public int OfH;
  public boolean OfI;
  public boolean OfJ;
  private final String TAG;
  public int amount;
  
  public g(String paramString1, String paramString2, String paramString3, double paramDouble, String paramString4, int paramInt, String paramString5, String paramString6, boolean paramBoolean1, String paramString7, boolean paramBoolean2)
  {
    AppMethodBeat.i(67656);
    this.TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitPlaceOrder";
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fpy();
    ((c.a)localObject).otF = new fpz();
    ((c.a)localObject).funcId = 2878;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/transferphoneplaceorder";
    this.rr = ((c.a)localObject).bEF();
    localObject = (fpy)c.b.b(this.rr.otB);
    ((fpy)localObject).abPo = paramString1;
    ((fpy)localObject).abPp = paramString2;
    ((fpy)localObject).abPq = paramString3;
    ((fpy)localObject).amount = ((int)Math.round(100.0D * paramDouble));
    ((fpy)localObject).desc = paramString4;
    ((fpy)localObject).abPI = paramInt;
    ((fpy)localObject).abPs = paramString5;
    ((fpy)localObject).abPC = paramString6;
    if (paramBoolean1) {
      ((fpy)localObject).abPJ = Util.nullAs(paramString7, "");
    }
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitPlaceOrder", "do scene NetSceneMobileRemitGetRecord rcvr_openid:%s rcvr_token:%s get_rcvr_ext%s amount:%s desc:%s delay_code:%s real_name_token:%s timestamp_ms:%s isFromForceCheckName:%s replaceorder_token:%s", new Object[] { paramString1, paramString2, paramString3, Double.valueOf(paramDouble), paramString4, Integer.valueOf(paramInt), paramString5, paramString6, Boolean.valueOf(paramBoolean1), Util.nullAs(paramString7, "null") });
    this.amount = ((fpy)localObject).amount;
    this.OfH = ((fpy)localObject).abPI;
    this.OfI = paramBoolean1;
    this.OfJ = paramBoolean2;
    AppMethodBeat.o(67656);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67657);
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitPlaceOrder", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.OfG = ((fpz)c.c.b(((c)params).otC));
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitPlaceOrder", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.OfG.wuz), this.OfG.wuA });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67657);
  }
  
  public final void f(s params)
  {
    AppMethodBeat.i(288864);
    params = (fpz)c.c.b(((c)params).otC);
    this.agTs = params.wuz;
    this.agTt = params.wuA;
    AppMethodBeat.o(288864);
  }
  
  public final fpz gLP()
  {
    if (this.OfG == null) {
      return null;
    }
    return this.OfG;
  }
  
  public final int getType()
  {
    return 2878;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.cgi.g
 * JD-Core Version:    0.7.0.1
 */