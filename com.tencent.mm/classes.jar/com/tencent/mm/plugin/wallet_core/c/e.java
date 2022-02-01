package com.tencent.mm.plugin.wallet_core.c;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.plugin.soter.d.d;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.yi;
import com.tencent.mm.protocal.protobuf.yj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.w;

public final class e
  extends w
{
  public int Dgj;
  public yj Dgk;
  private f callback;
  private b rr;
  
  public e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramInt, (byte)0);
  }
  
  private e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt, byte paramByte)
  {
    AppMethodBeat.i(69894);
    this.Dgj = 0;
    this.Dgj = 5;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new yi();
    ((b.a)localObject).hQG = new yj();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/checkuserauthjsapi";
    ((b.a)localObject).funcId = 2728;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (yi)this.rr.hQD.hQJ;
    ((yi)localObject).ikm = paramString1;
    ((yi)localObject).FVY = paramString2;
    ((yi)localObject).GpD = paramString3;
    ((yi)localObject).GpE = paramString4;
    ((yi)localObject).GpG = paramString5;
    ((yi)localObject).GpF = paramString6;
    ((yi)localObject).Goz = paramString7;
    ((yi)localObject).GpH = 5;
    ((yi)localObject).Ghz = k.eIV();
    ((yi)localObject).FNy = 1;
    ((yi)localObject).nIJ = null;
    ((yi)localObject).uuA = null;
    ((yi)localObject).GpK = paramString8;
    ((yi)localObject).GpJ = paramInt;
    boolean bool = ((a)com.tencent.mm.kernel.g.ab(a.class)).cRT();
    paramString3 = d.ejm();
    paramString2 = paramString3.AXb;
    paramString3 = paramString3.AXc;
    ((yi)localObject).Gqn = 0;
    ((yi)localObject).AXb = paramString2;
    ((yi)localObject).AXc = paramString3;
    if (bool) {}
    for (paramInt = 1;; paramInt = 0)
    {
      ((yi)localObject).Gqo = paramInt;
      ae.d("MicroMsg.NetSceneCheckUserAuthJsapi", "cpu_id: %s, uid: %s", new Object[] { paramString2, paramString3 });
      ae.i("MicroMsg.NetSceneCheckUserAuthJsapi", "appId: %s, url: %s, jsapiScene: %s, isOpenTouchPay: %b", new Object[] { paramString1, paramString7, Integer.valueOf(5), Boolean.valueOf(bool) });
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
    ae.d("MicroMsg.NetSceneCheckUserAuthJsapi", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    paramArrayOfByte = paramString;
    if (paramInt2 == 0)
    {
      paramArrayOfByte = paramString;
      if (paramInt3 == 0)
      {
        this.Dgk = ((yj)((b)paramq).hQE.hQJ);
        paramString = (yi)((b)paramq).hQD.hQJ;
        if (paramString.Goz == null) {
          break label388;
        }
        paramq = Uri.parse(paramString.Goz).getQueryParameter("appid");
        if (paramq == paramString.ikm) {
          break label296;
        }
        com.tencent.mm.plugin.report.service.g.yxI.f(14954, new Object[] { this.Dgk.FEz, "", Integer.valueOf(paramString.GpH), paramString.GpK, paramString.ikm, Integer.valueOf(paramString.FNy), Integer.valueOf(paramString.GpJ), paramString.Goz, paramq });
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.NetSceneCheckUserAuthJsapi", "CheckUserAuthJsapiResponse resp.ErrCode is " + this.Dgk.qkQ + " resp.ErrMsg is " + this.Dgk.qkR);
      paramArrayOfByte = this.Dgk.qkR;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramArrayOfByte, this);
      AppMethodBeat.o(69896);
      return;
      label296:
      com.tencent.mm.plugin.report.service.g.yxI.f(14954, new Object[] { this.Dgk.FEz, "", Integer.valueOf(paramString.GpH), paramString.GpK, paramString.ikm, Integer.valueOf(paramString.FNy), Integer.valueOf(paramString.GpJ), paramString.Goz });
      continue;
      label388:
      if ((paramString.nIJ != null) && (paramString.uuA != null)) {
        com.tencent.mm.plugin.report.service.g.yxI.f(14954, new Object[] { this.Dgk.FEz, "", Integer.valueOf(paramString.GpH), paramString.GpK, paramString.ikm, Integer.valueOf(paramString.FNy), Integer.valueOf(paramString.GpJ), paramString.uuA, paramString.nIJ });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.e
 * JD-Core Version:    0.7.0.1
 */