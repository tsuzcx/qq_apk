package com.tencent.mm.plugin.wallet_index.c.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cdz;
import com.tencent.mm.protocal.protobuf.cea;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.c.w;

public final class a
  extends w
{
  public String BPA;
  public String BPN;
  private g callback;
  public String jumpUrl;
  public String prepayId;
  private b rr;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt)
  {
    AppMethodBeat.i(71846);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cdz();
    ((b.a)localObject).hvu = new cea();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/payibggenprepay";
    ((b.a)localObject).funcId = 1563;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (cdz)this.rr.hvr.hvw;
    ((cdz)localObject).hOf = paramString1;
    ((cdz)localObject).EpU = paramString4;
    ((cdz)localObject).EpT = paramString2;
    ((cdz)localObject).EpV = paramString5;
    ((cdz)localObject).EpW = paramString6;
    ((cdz)localObject).DYh = paramString3;
    ((cdz)localObject).EoO = paramString7;
    ((cdz)localObject).EJO = paramString8;
    ((cdz)localObject).DLC = paramInt;
    ac.d("MicroMsg.NetSceneIbgPayGenPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,", new Object[] { paramString1, paramString4, paramString2, paramString5, paramString6, paramString3, paramString7, paramString8 }));
    AppMethodBeat.o(71846);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(71848);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(71848);
    return i;
  }
  
  public final int getType()
  {
    return 1563;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(71847);
    ac.i("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay raw net errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (cea)((b)paramq).hvs.hvw;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ac.i("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay jump url. biz_errcode: %d, biz_errmsg: %s", new Object[] { Integer.valueOf(paramq.pAG), paramq.pAH });
      paramString = paramq.pAH;
      paramInt3 = paramq.pAG;
      this.jumpUrl = paramq.thh;
      this.prepayId = paramq.EJP;
      this.BPA = paramq.EJQ;
      this.BPN = paramq.FsE;
    }
    for (;;)
    {
      paramq = paramString;
      if (bs.isNullOrNil(paramString)) {
        paramq = ai.getContext().getString(2131765224);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramq, this);
      AppMethodBeat.o(71847);
      return;
      ac.e("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay jump url failed");
      this.jumpUrl = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.a.a
 * JD-Core Version:    0.7.0.1
 */