package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eul;
import com.tencent.mm.protocal.protobuf.eum;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
  extends a
{
  private eum IiV;
  public int IiW;
  public boolean IiX;
  public boolean IiY;
  private final String TAG;
  public int amount;
  
  public g(String paramString1, String paramString2, String paramString3, double paramDouble, String paramString4, int paramInt, String paramString5, String paramString6, boolean paramBoolean1, String paramString7, boolean paramBoolean2)
  {
    AppMethodBeat.i(67656);
    this.TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitPlaceOrder";
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new eul();
    ((d.a)localObject).lBV = new eum();
    ((d.a)localObject).funcId = 2878;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/transferphoneplaceorder";
    this.rr = ((d.a)localObject).bgN();
    localObject = (eul)d.b.b(this.rr.lBR);
    ((eul)localObject).UvJ = paramString1;
    ((eul)localObject).UvK = paramString2;
    ((eul)localObject).UvL = paramString3;
    ((eul)localObject).amount = ((int)Math.round(100.0D * paramDouble));
    ((eul)localObject).desc = paramString4;
    ((eul)localObject).Uwc = paramInt;
    ((eul)localObject).UvN = paramString5;
    ((eul)localObject).UvX = paramString6;
    if (paramBoolean1) {
      ((eul)localObject).Uwd = Util.nullAs(paramString7, "");
    }
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitPlaceOrder", "do scene NetSceneMobileRemitGetRecord rcvr_openid:%s rcvr_token:%s get_rcvr_ext%s amount:%s desc:%s delay_code:%s real_name_token:%s timestamp_ms:%s isFromForceCheckName:%s replaceorder_token:%s", new Object[] { paramString1, paramString2, paramString3, Double.valueOf(paramDouble), paramString4, Integer.valueOf(paramInt), paramString5, paramString6, Boolean.valueOf(paramBoolean1), Util.nullAs(paramString7, "null") });
    this.amount = ((eul)localObject).amount;
    this.IiW = ((eul)localObject).Uwc;
    this.IiX = paramBoolean1;
    this.IiY = paramBoolean2;
    AppMethodBeat.o(67656);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67657);
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitPlaceOrder", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.IiV = ((eum)d.c.b(((d)params).lBS));
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitPlaceOrder", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.IiV.tqa), this.IiV.tqb });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67657);
  }
  
  public final void f(s params)
  {
    AppMethodBeat.i(255881);
    params = (eum)d.c.b(((d)params).lBS);
    this.YVy = params.tqa;
    this.YVz = params.tqb;
    AppMethodBeat.o(255881);
  }
  
  public final eum fAd()
  {
    if (this.IiV == null) {
      return null;
    }
    return this.IiV;
  }
  
  public final int getType()
  {
    return 2878;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.cgi.g
 * JD-Core Version:    0.7.0.1
 */