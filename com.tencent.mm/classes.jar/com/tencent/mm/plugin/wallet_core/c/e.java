package com.tencent.mm.plugin.wallet_core.c;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.plugin.soter.d.d;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.yf;
import com.tencent.mm.protocal.protobuf.yg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.w;

public final class e
  extends w
{
  public int COE;
  public yg COF;
  private f callback;
  private b rr;
  
  public e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramInt, (byte)0);
  }
  
  private e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt, byte paramByte)
  {
    AppMethodBeat.i(69894);
    this.COE = 0;
    this.COE = 5;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new yf();
    ((b.a)localObject).hNN = new yg();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/checkuserauthjsapi";
    ((b.a)localObject).funcId = 2728;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (yf)this.rr.hNK.hNQ;
    ((yf)localObject).iht = paramString1;
    ((yf)localObject).FDD = paramString2;
    ((yf)localObject).FXe = paramString3;
    ((yf)localObject).FXf = paramString4;
    ((yf)localObject).FXh = paramString5;
    ((yf)localObject).FXg = paramString6;
    ((yf)localObject).FWa = paramString7;
    ((yf)localObject).FXi = 5;
    ((yf)localObject).FPa = k.eFo();
    ((yf)localObject).Fva = 1;
    ((yf)localObject).nDo = null;
    ((yf)localObject).ujc = null;
    ((yf)localObject).FXl = paramString8;
    ((yf)localObject).FXk = paramInt;
    boolean bool = ((a)com.tencent.mm.kernel.g.ab(a.class)).cPo();
    paramString3 = d.efE();
    paramString2 = paramString3.AFy;
    paramString3 = paramString3.AFz;
    ((yf)localObject).FXO = 0;
    ((yf)localObject).AFy = paramString2;
    ((yf)localObject).AFz = paramString3;
    if (bool) {}
    for (paramInt = 1;; paramInt = 0)
    {
      ((yf)localObject).FXP = paramInt;
      ad.d("MicroMsg.NetSceneCheckUserAuthJsapi", "cpu_id: %s, uid: %s", new Object[] { paramString2, paramString3 });
      ad.i("MicroMsg.NetSceneCheckUserAuthJsapi", "appId: %s, url: %s, jsapiScene: %s, isOpenTouchPay: %b", new Object[] { paramString1, paramString7, Integer.valueOf(5), Boolean.valueOf(bool) });
      AppMethodBeat.o(69894);
      return;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(69895);
    this.callback = paramf;
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
        this.COF = ((yg)((b)paramq).hNL.hNQ);
        paramString = (yf)((b)paramq).hNK.hNQ;
        if (paramString.FWa == null) {
          break label388;
        }
        paramq = Uri.parse(paramString.FWa).getQueryParameter("appid");
        if (paramq == paramString.iht) {
          break label296;
        }
        com.tencent.mm.plugin.report.service.g.yhR.f(14954, new Object[] { this.COF.Fmb, "", Integer.valueOf(paramString.FXi), paramString.FXl, paramString.iht, Integer.valueOf(paramString.Fva), Integer.valueOf(paramString.FXk), paramString.FWa, paramq });
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.NetSceneCheckUserAuthJsapi", "CheckUserAuthJsapiResponse resp.ErrCode is " + this.COF.qel + " resp.ErrMsg is " + this.COF.qem);
      paramArrayOfByte = this.COF.qem;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramArrayOfByte, this);
      AppMethodBeat.o(69896);
      return;
      label296:
      com.tencent.mm.plugin.report.service.g.yhR.f(14954, new Object[] { this.COF.Fmb, "", Integer.valueOf(paramString.FXi), paramString.FXl, paramString.iht, Integer.valueOf(paramString.Fva), Integer.valueOf(paramString.FXk), paramString.FWa });
      continue;
      label388:
      if ((paramString.nDo != null) && (paramString.ujc != null)) {
        com.tencent.mm.plugin.report.service.g.yhR.f(14954, new Object[] { this.COF.Fmb, "", Integer.valueOf(paramString.FXi), paramString.FXl, paramString.iht, Integer.valueOf(paramString.Fva), Integer.valueOf(paramString.FXk), paramString.ujc, paramString.nDo });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.e
 * JD-Core Version:    0.7.0.1
 */