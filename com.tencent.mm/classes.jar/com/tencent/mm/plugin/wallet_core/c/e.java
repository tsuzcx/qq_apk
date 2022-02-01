package com.tencent.mm.plugin.wallet_core.c;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.soter.d.d;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.vw;
import com.tencent.mm.protocal.protobuf.vx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.w;

public final class e
  extends w
{
  private com.tencent.mm.al.g callback;
  private b rr;
  public int zVV;
  public vx zVW;
  
  public e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramInt, (byte)0);
  }
  
  private e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt, byte paramByte)
  {
    AppMethodBeat.i(69894);
    this.zVV = 0;
    this.zVV = 5;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new vw();
    ((b.a)localObject).gUV = new vx();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/checkuserauthjsapi";
    ((b.a)localObject).funcId = 2728;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (vw)this.rr.gUS.gUX;
    ((vw)localObject).hnC = paramString1;
    ((vw)localObject).CFH = paramString2;
    ((vw)localObject).CXk = paramString3;
    ((vw)localObject).CXl = paramString4;
    ((vw)localObject).CXn = paramString5;
    ((vw)localObject).CXm = paramString6;
    ((vw)localObject).CWf = paramString7;
    ((vw)localObject).CXo = 5;
    ((vw)localObject).CPi = k.ebS();
    ((vw)localObject).Cxp = 1;
    ((vw)localObject).mAQ = null;
    ((vw)localObject).sdZ = null;
    ((vw)localObject).CXr = paramString8;
    ((vw)localObject).CXq = paramInt;
    boolean bool = ((a)com.tencent.mm.kernel.g.ab(a.class)).ctN();
    paramString3 = d.dEQ();
    paramString2 = paramString3.yaF;
    paramString3 = paramString3.yaG;
    ((vw)localObject).CXV = 0;
    ((vw)localObject).yaF = paramString2;
    ((vw)localObject).yaG = paramString3;
    if (bool) {}
    for (paramInt = 1;; paramInt = 0)
    {
      ((vw)localObject).CXW = paramInt;
      ad.d("MicroMsg.NetSceneCheckUserAuthJsapi", "cpu_id: %s, uid: %s", new Object[] { paramString2, paramString3 });
      ad.i("MicroMsg.NetSceneCheckUserAuthJsapi", "appId: %s, url: %s, jsapiScene: %s, isOpenTouchPay: %b", new Object[] { paramString1, paramString7, Integer.valueOf(5), Boolean.valueOf(bool) });
      AppMethodBeat.o(69894);
      return;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(69895);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(69895);
    return i;
  }
  
  public final int getType()
  {
    return 580;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(69896);
    ad.d("MicroMsg.NetSceneCheckUserAuthJsapi", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    paramArrayOfByte = paramString;
    if (paramInt2 == 0)
    {
      paramArrayOfByte = paramString;
      if (paramInt3 == 0)
      {
        this.zVW = ((vx)((b)paramq).gUT.gUX);
        paramString = (vw)((b)paramq).gUS.gUX;
        if (paramString.CWf == null) {
          break label388;
        }
        paramq = Uri.parse(paramString.CWf).getQueryParameter("appid");
        if (paramq == paramString.hnC) {
          break label296;
        }
        h.vKh.f(14954, new Object[] { this.zVW.CoC, "", Integer.valueOf(paramString.CXo), paramString.CXr, paramString.hnC, Integer.valueOf(paramString.Cxp), Integer.valueOf(paramString.CXq), paramString.CWf, paramq });
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.NetSceneCheckUserAuthJsapi", "CheckUserAuthJsapiResponse resp.ErrCode is " + this.zVW.oXv + " resp.ErrMsg is " + this.zVW.oXw);
      paramArrayOfByte = this.zVW.oXw;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramArrayOfByte, this);
      AppMethodBeat.o(69896);
      return;
      label296:
      h.vKh.f(14954, new Object[] { this.zVW.CoC, "", Integer.valueOf(paramString.CXo), paramString.CXr, paramString.hnC, Integer.valueOf(paramString.Cxp), Integer.valueOf(paramString.CXq), paramString.CWf });
      continue;
      label388:
      if ((paramString.mAQ != null) && (paramString.sdZ != null)) {
        h.vKh.f(14954, new Object[] { this.zVW.CoC, "", Integer.valueOf(paramString.CXo), paramString.CXr, paramString.hnC, Integer.valueOf(paramString.Cxp), Integer.valueOf(paramString.CXq), paramString.sdZ, paramString.mAQ });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.e
 * JD-Core Version:    0.7.0.1
 */