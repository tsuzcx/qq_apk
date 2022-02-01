package com.tencent.mm.plugin.wallet_core.c;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.cjj;
import com.tencent.mm.protocal.protobuf.xp;
import com.tencent.mm.protocal.protobuf.xq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.c.z;

public final class d
  extends w
{
  public int COE;
  private f callback;
  public b rr;
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, String paramString7, String paramString8, String paramString9, int paramInt2)
  {
    AppMethodBeat.i(69891);
    this.COE = 0;
    this.COE = paramInt1;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new xp();
    ((b.a)localObject).hNN = new xq();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/checkpayjsapi";
    ((b.a)localObject).funcId = 580;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (xp)this.rr.hNK.hNQ;
    ((xp)localObject).iht = paramString1;
    ((xp)localObject).FDD = paramString2;
    ((xp)localObject).FXe = paramString3;
    ((xp)localObject).FXf = paramString4;
    ((xp)localObject).FXh = paramString5;
    ((xp)localObject).FXg = paramString6;
    ((xp)localObject).FXi = paramInt1;
    ((xp)localObject).nDo = paramString7;
    ((xp)localObject).ujc = paramString8;
    ((xp)localObject).Fva = 2;
    ((xp)localObject).FXl = paramString9;
    ((xp)localObject).FXk = paramInt2;
    ((xp)localObject).FPa = k.eFo();
    if (z.fRx()) {
      ((xp)localObject).FXj = z.getBindCardUuid();
    }
    ad.i("MicroMsg.NetSceneCheckPayJsapi", "appId: %s, UserName: %s, path: %s", new Object[] { paramString1, paramString7, paramString8 });
    AppMethodBeat.o(69891);
  }
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt1, String paramString8, int paramInt2)
  {
    AppMethodBeat.i(69890);
    this.COE = 0;
    this.COE = paramInt1;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new xp();
    ((b.a)localObject).hNN = new xq();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/checkpayjsapi";
    ((b.a)localObject).funcId = 580;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (xp)this.rr.hNK.hNQ;
    ((xp)localObject).iht = paramString1;
    ((xp)localObject).FDD = paramString2;
    ((xp)localObject).FXe = paramString3;
    ((xp)localObject).FXf = paramString4;
    ((xp)localObject).FXh = paramString5;
    ((xp)localObject).FXg = paramString6;
    ((xp)localObject).FWa = paramString7;
    ((xp)localObject).FXi = paramInt1;
    ((xp)localObject).FPa = k.eFo();
    if (z.fRx()) {
      ((xp)localObject).FXj = z.getBindCardUuid();
    }
    ((xp)localObject).Fva = 1;
    ((xp)localObject).FXl = paramString8;
    ((xp)localObject).FXk = paramInt2;
    ad.i("MicroMsg.NetSceneCheckPayJsapi", "appId: %s, url: %s, jsapiScene: %s", new Object[] { paramString1, paramString7, Integer.valueOf(paramInt1) });
    AppMethodBeat.o(69890);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(69892);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(69892);
    return i;
  }
  
  public final String eEF()
  {
    return ((xq)this.rr.hNL.hNQ).Fmb;
  }
  
  public final cjj eEG()
  {
    return ((xq)this.rr.hNL.hNQ).FXm;
  }
  
  public final String getToken()
  {
    return ((xq)this.rr.hNL.hNQ).token;
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
        paramString = (xq)((b)paramq).hNL.hNQ;
        ad.i("MicroMsg.NetSceneCheckPayJsapi", "NetSceneCheckPayJsapi resp.ErrCode is " + paramString.qel + " resp.ErrMsg is " + paramString.qem);
        paramq = (xp)((b)paramq).hNK.hNQ;
        if (paramq.FWa == null) {
          break label410;
        }
        paramArrayOfByte = Uri.parse(paramq.FWa).getQueryParameter("appid");
        if (paramArrayOfByte == paramq.iht) {
          break label321;
        }
        g.yhR.f(14954, new Object[] { paramString.Fmb, "", Integer.valueOf(paramq.FXi), paramq.FXl, paramq.iht, Integer.valueOf(paramq.Fva), Integer.valueOf(paramq.FXk), paramq.FWa, paramArrayOfByte });
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.NetSceneCheckPayJsapi", "NetSceneCheckPayJsapi resp.ErrCode is " + paramString.qel + " resp.ErrMsg is " + paramString.qem);
      paramArrayOfByte = paramString.qem;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramArrayOfByte, this);
      AppMethodBeat.o(69893);
      return;
      label321:
      g.yhR.f(14954, new Object[] { paramString.Fmb, "", Integer.valueOf(paramq.FXi), paramq.FXl, paramq.iht, Integer.valueOf(paramq.Fva), Integer.valueOf(paramq.FXk), paramq.FWa });
      continue;
      label410:
      if ((paramq.nDo != null) && (paramq.ujc != null)) {
        g.yhR.f(14954, new Object[] { paramString.Fmb, "", Integer.valueOf(paramq.FXi), paramq.FXl, paramq.iht, Integer.valueOf(paramq.Fva), Integer.valueOf(paramq.FXk), paramq.ujc, paramq.nDo });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.d
 * JD-Core Version:    0.7.0.1
 */