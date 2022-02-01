package com.tencent.mm.plugin.wallet_core.c;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.ckd;
import com.tencent.mm.protocal.protobuf.xs;
import com.tencent.mm.protocal.protobuf.xt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.c.z;

public final class d
  extends w
{
  public int Dgj;
  private f callback;
  public b rr;
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, String paramString7, String paramString8, String paramString9, int paramInt2)
  {
    AppMethodBeat.i(69891);
    this.Dgj = 0;
    this.Dgj = paramInt1;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new xs();
    ((b.a)localObject).hQG = new xt();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/checkpayjsapi";
    ((b.a)localObject).funcId = 580;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (xs)this.rr.hQD.hQJ;
    ((xs)localObject).ikm = paramString1;
    ((xs)localObject).FVY = paramString2;
    ((xs)localObject).GpD = paramString3;
    ((xs)localObject).GpE = paramString4;
    ((xs)localObject).GpG = paramString5;
    ((xs)localObject).GpF = paramString6;
    ((xs)localObject).GpH = paramInt1;
    ((xs)localObject).nIJ = paramString7;
    ((xs)localObject).uuA = paramString8;
    ((xs)localObject).FNy = 2;
    ((xs)localObject).GpK = paramString9;
    ((xs)localObject).GpJ = paramInt2;
    ((xs)localObject).Ghz = k.eIV();
    if (z.fVT()) {
      ((xs)localObject).GpI = z.getBindCardUuid();
    }
    ae.i("MicroMsg.NetSceneCheckPayJsapi", "appId: %s, UserName: %s, path: %s", new Object[] { paramString1, paramString7, paramString8 });
    AppMethodBeat.o(69891);
  }
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt1, String paramString8, int paramInt2)
  {
    AppMethodBeat.i(69890);
    this.Dgj = 0;
    this.Dgj = paramInt1;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new xs();
    ((b.a)localObject).hQG = new xt();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/checkpayjsapi";
    ((b.a)localObject).funcId = 580;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (xs)this.rr.hQD.hQJ;
    ((xs)localObject).ikm = paramString1;
    ((xs)localObject).FVY = paramString2;
    ((xs)localObject).GpD = paramString3;
    ((xs)localObject).GpE = paramString4;
    ((xs)localObject).GpG = paramString5;
    ((xs)localObject).GpF = paramString6;
    ((xs)localObject).Goz = paramString7;
    ((xs)localObject).GpH = paramInt1;
    ((xs)localObject).Ghz = k.eIV();
    if (z.fVT()) {
      ((xs)localObject).GpI = z.getBindCardUuid();
    }
    ((xs)localObject).FNy = 1;
    ((xs)localObject).GpK = paramString8;
    ((xs)localObject).GpJ = paramInt2;
    ae.i("MicroMsg.NetSceneCheckPayJsapi", "appId: %s, url: %s, jsapiScene: %s", new Object[] { paramString1, paramString7, Integer.valueOf(paramInt1) });
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
  
  public final String eIm()
  {
    return ((xt)this.rr.hQE.hQJ).FEz;
  }
  
  public final ckd eIn()
  {
    return ((xt)this.rr.hQE.hQJ).GpL;
  }
  
  public final String getToken()
  {
    return ((xt)this.rr.hQE.hQJ).token;
  }
  
  public final int getType()
  {
    return 580;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(69893);
    ae.d("MicroMsg.NetSceneCheckPayJsapi", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    paramArrayOfByte = paramString;
    if (paramInt2 == 0)
    {
      paramArrayOfByte = paramString;
      if (paramInt3 == 0)
      {
        paramString = (xt)((b)paramq).hQE.hQJ;
        ae.i("MicroMsg.NetSceneCheckPayJsapi", "NetSceneCheckPayJsapi resp.ErrCode is " + paramString.qkQ + " resp.ErrMsg is " + paramString.qkR);
        paramq = (xs)((b)paramq).hQD.hQJ;
        if (paramq.Goz == null) {
          break label410;
        }
        paramArrayOfByte = Uri.parse(paramq.Goz).getQueryParameter("appid");
        if (paramArrayOfByte == paramq.ikm) {
          break label321;
        }
        g.yxI.f(14954, new Object[] { paramString.FEz, "", Integer.valueOf(paramq.GpH), paramq.GpK, paramq.ikm, Integer.valueOf(paramq.FNy), Integer.valueOf(paramq.GpJ), paramq.Goz, paramArrayOfByte });
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.NetSceneCheckPayJsapi", "NetSceneCheckPayJsapi resp.ErrCode is " + paramString.qkQ + " resp.ErrMsg is " + paramString.qkR);
      paramArrayOfByte = paramString.qkR;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramArrayOfByte, this);
      AppMethodBeat.o(69893);
      return;
      label321:
      g.yxI.f(14954, new Object[] { paramString.FEz, "", Integer.valueOf(paramq.GpH), paramq.GpK, paramq.ikm, Integer.valueOf(paramq.FNy), Integer.valueOf(paramq.GpJ), paramq.Goz });
      continue;
      label410:
      if ((paramq.nIJ != null) && (paramq.uuA != null)) {
        g.yxI.f(14954, new Object[] { paramString.FEz, "", Integer.valueOf(paramq.GpH), paramq.GpK, paramq.ikm, Integer.valueOf(paramq.FNy), Integer.valueOf(paramq.GpJ), paramq.uuA, paramq.nIJ });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.d
 * JD-Core Version:    0.7.0.1
 */