package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ekh;
import com.tencent.mm.protocal.protobuf.eki;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
  extends a
{
  private eki Cmc;
  public int Cmd;
  public boolean Cme;
  public boolean Cmf;
  private final String TAG;
  public int yRL;
  
  public g(String paramString1, String paramString2, String paramString3, double paramDouble, String paramString4, int paramInt, String paramString5, String paramString6, boolean paramBoolean1, String paramString7, boolean paramBoolean2)
  {
    AppMethodBeat.i(67656);
    this.TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitPlaceOrder";
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ekh();
    ((d.a)localObject).iLO = new eki();
    ((d.a)localObject).funcId = 2878;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/transferphoneplaceorder";
    this.rr = ((d.a)localObject).aXF();
    localObject = (ekh)this.rr.iLK.iLR;
    ((ekh)localObject).Njb = paramString1;
    ((ekh)localObject).Njc = paramString2;
    ((ekh)localObject).Njd = paramString3;
    ((ekh)localObject).yRL = ((int)Math.round(100.0D * paramDouble));
    ((ekh)localObject).desc = paramString4;
    ((ekh)localObject).Nju = paramInt;
    ((ekh)localObject).Njf = paramString5;
    ((ekh)localObject).Njp = paramString6;
    if (paramBoolean1) {
      ((ekh)localObject).Njv = Util.nullAs(paramString7, "");
    }
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitPlaceOrder", "do scene NetSceneMobileRemitGetRecord rcvr_openid:%s rcvr_token:%s get_rcvr_ext%s amount:%s desc:%s delay_code:%s real_name_token:%s timestamp_ms:%s isFromForceCheckName:%s replaceorder_token:%s", new Object[] { paramString1, paramString2, paramString3, Double.valueOf(paramDouble), paramString4, Integer.valueOf(paramInt), paramString5, paramString6, Boolean.valueOf(paramBoolean1), Util.nullAs(paramString7, "null") });
    this.yRL = ((ekh)localObject).yRL;
    this.Cmd = ((ekh)localObject).Nju;
    this.Cme = paramBoolean1;
    this.Cmf = paramBoolean2;
    AppMethodBeat.o(67656);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67657);
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitPlaceOrder", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.Cmc = ((eki)((d)params).iLL.iLR);
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitPlaceOrder", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.Cmc.pTZ), this.Cmc.pUa });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67657);
  }
  
  public final void e(s params)
  {
    params = (eki)((d)params).iLL.iLR;
    this.RtZ = params.pTZ;
    this.Rua = params.pUa;
  }
  
  public final eki eNo()
  {
    if (this.Cmc == null) {
      return null;
    }
    return this.Cmc;
  }
  
  public final int getType()
  {
    return 2878;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.cgi.g
 * JD-Core Version:    0.7.0.1
 */