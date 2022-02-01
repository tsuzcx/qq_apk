package com.tencent.mm.plugin.wallet_core.c;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.zw;
import com.tencent.mm.protocal.protobuf.zx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.w;

public final class e
  extends w
{
  public int HPC;
  public zx HPD;
  private i callback;
  private com.tencent.mm.ak.d rr;
  
  public e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramInt, (byte)0);
  }
  
  private e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt, byte paramByte)
  {
    AppMethodBeat.i(69894);
    this.HPC = 0;
    this.HPC = 5;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new zw();
    ((d.a)localObject).iLO = new zx();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/checkuserauthjsapi";
    ((d.a)localObject).funcId = 2728;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (zw)this.rr.iLK.iLR;
    ((zw)localObject).jfi = paramString1;
    ((zw)localObject).KPJ = paramString2;
    ((zw)localObject).Lkp = paramString3;
    ((zw)localObject).Lkq = paramString4;
    ((zw)localObject).Lks = paramString5;
    ((zw)localObject).Lkr = paramString6;
    ((zw)localObject).Ljk = paramString7;
    ((zw)localObject).Lkt = 5;
    ((zw)localObject).Lcc = k.fQy();
    ((zw)localObject).KHd = 1;
    ((zw)localObject).UserName = null;
    ((zw)localObject).xut = null;
    ((zw)localObject).Lkw = paramString8;
    ((zw)localObject).Lkv = paramInt;
    boolean bool = ((a)com.tencent.mm.kernel.g.af(a.class)).dJO();
    paramString3 = com.tencent.mm.plugin.soter.d.d.flM();
    paramString2 = paramString3.FhU;
    paramString3 = paramString3.hFF;
    ((zw)localObject).Llf = 0;
    ((zw)localObject).FhU = paramString2;
    ((zw)localObject).hFF = paramString3;
    if (bool) {}
    for (paramInt = 1;; paramInt = 0)
    {
      ((zw)localObject).Llg = paramInt;
      Log.d("MicroMsg.NetSceneCheckUserAuthJsapi", "cpu_id: %s, uid: %s", new Object[] { paramString2, paramString3 });
      Log.i("MicroMsg.NetSceneCheckUserAuthJsapi", "appId: %s, url: %s, jsapiScene: %s, isOpenTouchPay: %b", new Object[] { paramString1, paramString7, Integer.valueOf(5), Boolean.valueOf(bool) });
      AppMethodBeat.o(69894);
      return;
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
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
        this.HPD = ((zx)((com.tencent.mm.ak.d)params).iLL.iLR);
        paramString = (zw)((com.tencent.mm.ak.d)params).iLK.iLR;
        if (paramString.Ljk == null) {
          break label388;
        }
        params = Uri.parse(paramString.Ljk).getQueryParameter("appid");
        if (params == paramString.jfi) {
          break label296;
        }
        h.CyF.a(14954, new Object[] { this.HPD.KxE, "", Integer.valueOf(paramString.Lkt), paramString.Lkw, paramString.jfi, Integer.valueOf(paramString.KHd), Integer.valueOf(paramString.Lkv), paramString.Ljk, params });
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.NetSceneCheckUserAuthJsapi", "CheckUserAuthJsapiResponse resp.ErrCode is " + this.HPD.rBL + " resp.ErrMsg is " + this.HPD.rBM);
      paramArrayOfByte = this.HPD.rBM;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramArrayOfByte, this);
      AppMethodBeat.o(69896);
      return;
      label296:
      h.CyF.a(14954, new Object[] { this.HPD.KxE, "", Integer.valueOf(paramString.Lkt), paramString.Lkw, paramString.jfi, Integer.valueOf(paramString.KHd), Integer.valueOf(paramString.Lkv), paramString.Ljk });
      continue;
      label388:
      if ((paramString.UserName != null) && (paramString.xut != null)) {
        h.CyF.a(14954, new Object[] { this.HPD.KxE, "", Integer.valueOf(paramString.Lkt), paramString.Lkw, paramString.jfi, Integer.valueOf(paramString.KHd), Integer.valueOf(paramString.Lkv), paramString.xut, paramString.UserName });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.e
 * JD-Core Version:    0.7.0.1
 */