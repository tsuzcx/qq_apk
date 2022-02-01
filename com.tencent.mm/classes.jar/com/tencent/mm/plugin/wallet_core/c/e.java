package com.tencent.mm.plugin.wallet_core.c;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.aaa;
import com.tencent.mm.protocal.protobuf.aab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.w;

public final class e
  extends w
{
  public int OHK;
  public aab OHL;
  private i callback;
  private com.tencent.mm.an.d rr;
  
  public e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramInt, (byte)0);
  }
  
  private e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt, byte paramByte)
  {
    AppMethodBeat.i(69894);
    this.OHK = 0;
    this.OHK = 5;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new aaa();
    ((d.a)localObject).lBV = new aab();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/checkuserauthjsapi";
    ((d.a)localObject).funcId = 2728;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (aaa)d.b.b(this.rr.lBR);
    ((aaa)localObject).lVG = paramString1;
    ((aaa)localObject).RQH = paramString2;
    ((aaa)localObject).Sly = paramString3;
    ((aaa)localObject).Slz = paramString4;
    ((aaa)localObject).SlB = paramString5;
    ((aaa)localObject).SlA = paramString6;
    ((aaa)localObject).SkB = paramString7;
    ((aaa)localObject).SlC = 5;
    ((aaa)localObject).Sdp = k.gJe();
    ((aaa)localObject).RIv = 1;
    ((aaa)localObject).UserName = null;
    ((aaa)localObject).CqK = null;
    ((aaa)localObject).SlF = paramString8;
    ((aaa)localObject).SlE = paramInt;
    boolean bool = ((a)com.tencent.mm.kernel.h.ae(a.class)).eon();
    paramString3 = com.tencent.mm.plugin.soter.d.d.gai();
    paramString2 = paramString3.Lwz;
    paramString3 = paramString3.ktM;
    ((aaa)localObject).Smo = 0;
    ((aaa)localObject).Lwz = paramString2;
    ((aaa)localObject).ktM = paramString3;
    if (bool) {}
    for (paramInt = 1;; paramInt = 0)
    {
      ((aaa)localObject).Smp = paramInt;
      Log.d("MicroMsg.NetSceneCheckUserAuthJsapi", "cpu_id: %s, uid: %s", new Object[] { paramString2, paramString3 });
      Log.i("MicroMsg.NetSceneCheckUserAuthJsapi", "appId: %s, url: %s, jsapiScene: %s, isOpenTouchPay: %b", new Object[] { paramString1, paramString7, Integer.valueOf(5), Boolean.valueOf(bool) });
      AppMethodBeat.o(69894);
      return;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(69895);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(69895);
    return i;
  }
  
  public final int getType()
  {
    return 580;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(69896);
    Log.d("MicroMsg.NetSceneCheckUserAuthJsapi", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    paramArrayOfByte = paramString;
    if (paramInt2 == 0)
    {
      paramArrayOfByte = paramString;
      if (paramInt3 == 0)
      {
        this.OHL = ((aab)d.c.b(((com.tencent.mm.an.d)params).lBS));
        paramString = (aaa)d.b.b(((com.tencent.mm.an.d)params).lBR);
        if (paramString.SkB == null) {
          break label388;
        }
        params = Uri.parse(paramString.SkB).getQueryParameter("appid");
        if (params == paramString.lVG) {
          break label296;
        }
        com.tencent.mm.plugin.report.service.h.IzE.a(14954, new Object[] { this.OHL.Rzs, "", Integer.valueOf(paramString.SlC), paramString.SlF, paramString.lVG, Integer.valueOf(paramString.RIv), Integer.valueOf(paramString.SlE), paramString.SkB, params });
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.NetSceneCheckUserAuthJsapi", "CheckUserAuthJsapiResponse resp.ErrCode is " + this.OHL.vht + " resp.ErrMsg is " + this.OHL.vhu);
      paramArrayOfByte = this.OHL.vhu;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramArrayOfByte, this);
      AppMethodBeat.o(69896);
      return;
      label296:
      com.tencent.mm.plugin.report.service.h.IzE.a(14954, new Object[] { this.OHL.Rzs, "", Integer.valueOf(paramString.SlC), paramString.SlF, paramString.lVG, Integer.valueOf(paramString.RIv), Integer.valueOf(paramString.SlE), paramString.SkB });
      continue;
      label388:
      if ((paramString.UserName != null) && (paramString.CqK != null)) {
        com.tencent.mm.plugin.report.service.h.IzE.a(14954, new Object[] { this.OHL.Rzs, "", Integer.valueOf(paramString.SlC), paramString.SlF, paramString.lVG, Integer.valueOf(paramString.RIv), Integer.valueOf(paramString.SlE), paramString.CqK, paramString.UserName });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.e
 * JD-Core Version:    0.7.0.1
 */