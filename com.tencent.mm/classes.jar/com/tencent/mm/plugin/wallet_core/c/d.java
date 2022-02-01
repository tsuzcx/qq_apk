package com.tencent.mm.plugin.wallet_core.c;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.bzm;
import com.tencent.mm.protocal.protobuf.vg;
import com.tencent.mm.protocal.protobuf.vh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.c.z;

public final class d
  extends w
{
  private g callback;
  public b rr;
  public int zVV;
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, String paramString7, String paramString8, String paramString9, int paramInt2)
  {
    AppMethodBeat.i(69891);
    this.zVV = 0;
    this.zVV = paramInt1;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new vg();
    ((b.a)localObject).gUV = new vh();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/checkpayjsapi";
    ((b.a)localObject).funcId = 580;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (vg)this.rr.gUS.gUX;
    ((vg)localObject).hnC = paramString1;
    ((vg)localObject).CFH = paramString2;
    ((vg)localObject).CXk = paramString3;
    ((vg)localObject).CXl = paramString4;
    ((vg)localObject).CXn = paramString5;
    ((vg)localObject).CXm = paramString6;
    ((vg)localObject).CXo = paramInt1;
    ((vg)localObject).mAQ = paramString7;
    ((vg)localObject).sdZ = paramString8;
    ((vg)localObject).Cxp = 2;
    ((vg)localObject).CXr = paramString9;
    ((vg)localObject).CXq = paramInt2;
    ((vg)localObject).CPi = k.ebS();
    if (z.fjX()) {
      ((vg)localObject).CXp = z.getBindCardUuid();
    }
    ad.i("MicroMsg.NetSceneCheckPayJsapi", "appId: %s, UserName: %s, path: %s", new Object[] { paramString1, paramString7, paramString8 });
    AppMethodBeat.o(69891);
  }
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt1, String paramString8, int paramInt2)
  {
    AppMethodBeat.i(69890);
    this.zVV = 0;
    this.zVV = paramInt1;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new vg();
    ((b.a)localObject).gUV = new vh();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/checkpayjsapi";
    ((b.a)localObject).funcId = 580;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (vg)this.rr.gUS.gUX;
    ((vg)localObject).hnC = paramString1;
    ((vg)localObject).CFH = paramString2;
    ((vg)localObject).CXk = paramString3;
    ((vg)localObject).CXl = paramString4;
    ((vg)localObject).CXn = paramString5;
    ((vg)localObject).CXm = paramString6;
    ((vg)localObject).CWf = paramString7;
    ((vg)localObject).CXo = paramInt1;
    ((vg)localObject).CPi = k.ebS();
    if (z.fjX()) {
      ((vg)localObject).CXp = z.getBindCardUuid();
    }
    ((vg)localObject).Cxp = 1;
    ((vg)localObject).CXr = paramString8;
    ((vg)localObject).CXq = paramInt2;
    ad.i("MicroMsg.NetSceneCheckPayJsapi", "appId: %s, url: %s, jsapiScene: %s", new Object[] { paramString1, paramString7, Integer.valueOf(paramInt1) });
    AppMethodBeat.o(69890);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(69892);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(69892);
    return i;
  }
  
  public final String ebj()
  {
    return ((vh)this.rr.gUT.gUX).CoC;
  }
  
  public final bzm ebk()
  {
    return ((vh)this.rr.gUT.gUX).CXs;
  }
  
  public final String getToken()
  {
    return ((vh)this.rr.gUT.gUX).token;
  }
  
  public final int getType()
  {
    return 580;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(69893);
    ad.d("MicroMsg.NetSceneCheckPayJsapi", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    paramArrayOfByte = paramString;
    if (paramInt2 == 0)
    {
      paramArrayOfByte = paramString;
      if (paramInt3 == 0)
      {
        paramString = (vh)((b)paramq).gUT.gUX;
        ad.i("MicroMsg.NetSceneCheckPayJsapi", "NetSceneCheckPayJsapi resp.ErrCode is " + paramString.oXv + " resp.ErrMsg is " + paramString.oXw);
        paramq = (vg)((b)paramq).gUS.gUX;
        if (paramq.CWf == null) {
          break label410;
        }
        paramArrayOfByte = Uri.parse(paramq.CWf).getQueryParameter("appid");
        if (paramArrayOfByte == paramq.hnC) {
          break label321;
        }
        h.vKh.f(14954, new Object[] { paramString.CoC, "", Integer.valueOf(paramq.CXo), paramq.CXr, paramq.hnC, Integer.valueOf(paramq.Cxp), Integer.valueOf(paramq.CXq), paramq.CWf, paramArrayOfByte });
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.NetSceneCheckPayJsapi", "NetSceneCheckPayJsapi resp.ErrCode is " + paramString.oXv + " resp.ErrMsg is " + paramString.oXw);
      paramArrayOfByte = paramString.oXw;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramArrayOfByte, this);
      AppMethodBeat.o(69893);
      return;
      label321:
      h.vKh.f(14954, new Object[] { paramString.CoC, "", Integer.valueOf(paramq.CXo), paramq.CXr, paramq.hnC, Integer.valueOf(paramq.Cxp), Integer.valueOf(paramq.CXq), paramq.CWf });
      continue;
      label410:
      if ((paramq.mAQ != null) && (paramq.sdZ != null)) {
        h.vKh.f(14954, new Object[] { paramString.CoC, "", Integer.valueOf(paramq.CXo), paramq.CXr, paramq.hnC, Integer.valueOf(paramq.Cxp), Integer.valueOf(paramq.CXq), paramq.sdZ, paramq.mAQ });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.d
 * JD-Core Version:    0.7.0.1
 */