package com.tencent.mm.plugin.wallet_core.c;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.dal;
import com.tencent.mm.protocal.protobuf.ze;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.c.z;

public final class d
  extends w
{
  public int HPC;
  private i callback;
  public com.tencent.mm.ak.d rr;
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, String paramString7, String paramString8, String paramString9, int paramInt2)
  {
    AppMethodBeat.i(69891);
    this.HPC = 0;
    this.HPC = paramInt1;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ze();
    ((d.a)localObject).iLO = new zf();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/checkpayjsapi";
    ((d.a)localObject).funcId = 580;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (ze)this.rr.iLK.iLR;
    ((ze)localObject).jfi = paramString1;
    ((ze)localObject).KPJ = paramString2;
    ((ze)localObject).Lkp = paramString3;
    ((ze)localObject).Lkq = paramString4;
    ((ze)localObject).Lks = paramString5;
    ((ze)localObject).Lkr = paramString6;
    ((ze)localObject).Lkt = paramInt1;
    ((ze)localObject).UserName = paramString7;
    ((ze)localObject).xut = paramString8;
    ((ze)localObject).KHd = 2;
    ((ze)localObject).Lkw = paramString9;
    ((ze)localObject).Lkv = paramInt2;
    ((ze)localObject).Lcc = k.fQy();
    if (z.hhq()) {
      ((ze)localObject).Lku = z.getBindCardUuid();
    }
    Log.i("MicroMsg.NetSceneCheckPayJsapi", "appId: %s, UserName: %s, path: %s", new Object[] { paramString1, paramString7, paramString8 });
    AppMethodBeat.o(69891);
  }
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt1, String paramString8, int paramInt2)
  {
    AppMethodBeat.i(69890);
    this.HPC = 0;
    this.HPC = paramInt1;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ze();
    ((d.a)localObject).iLO = new zf();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/checkpayjsapi";
    ((d.a)localObject).funcId = 580;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (ze)this.rr.iLK.iLR;
    ((ze)localObject).jfi = paramString1;
    ((ze)localObject).KPJ = paramString2;
    ((ze)localObject).Lkp = paramString3;
    ((ze)localObject).Lkq = paramString4;
    ((ze)localObject).Lks = paramString5;
    ((ze)localObject).Lkr = paramString6;
    ((ze)localObject).Ljk = paramString7;
    ((ze)localObject).Lkt = paramInt1;
    ((ze)localObject).Lcc = k.fQy();
    if (z.hhq()) {
      ((ze)localObject).Lku = z.getBindCardUuid();
    }
    ((ze)localObject).KHd = 1;
    ((ze)localObject).Lkw = paramString8;
    ((ze)localObject).Lkv = paramInt2;
    Log.i("MicroMsg.NetSceneCheckPayJsapi", "appId: %s, url: %s, jsapiScene: %s", new Object[] { paramString1, paramString7, Integer.valueOf(paramInt1) });
    AppMethodBeat.o(69890);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(69892);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(69892);
    return i;
  }
  
  public final String fPP()
  {
    return ((zf)this.rr.iLL.iLR).KxE;
  }
  
  public final dal fPQ()
  {
    return ((zf)this.rr.iLL.iLR).Lkx;
  }
  
  public final String getToken()
  {
    return ((zf)this.rr.iLL.iLR).token;
  }
  
  public final int getType()
  {
    return 580;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(69893);
    Log.d("MicroMsg.NetSceneCheckPayJsapi", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    paramArrayOfByte = paramString;
    if (paramInt2 == 0)
    {
      paramArrayOfByte = paramString;
      if (paramInt3 == 0)
      {
        paramString = (zf)((com.tencent.mm.ak.d)params).iLL.iLR;
        Log.i("MicroMsg.NetSceneCheckPayJsapi", "NetSceneCheckPayJsapi resp.ErrCode is " + paramString.rBL + " resp.ErrMsg is " + paramString.rBM);
        params = (ze)((com.tencent.mm.ak.d)params).iLK.iLR;
        if (params.Ljk == null) {
          break label410;
        }
        paramArrayOfByte = Uri.parse(params.Ljk).getQueryParameter("appid");
        if (paramArrayOfByte == params.jfi) {
          break label321;
        }
        h.CyF.a(14954, new Object[] { paramString.KxE, "", Integer.valueOf(params.Lkt), params.Lkw, params.jfi, Integer.valueOf(params.KHd), Integer.valueOf(params.Lkv), params.Ljk, paramArrayOfByte });
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.NetSceneCheckPayJsapi", "NetSceneCheckPayJsapi resp.ErrCode is " + paramString.rBL + " resp.ErrMsg is " + paramString.rBM);
      paramArrayOfByte = paramString.rBM;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramArrayOfByte, this);
      AppMethodBeat.o(69893);
      return;
      label321:
      h.CyF.a(14954, new Object[] { paramString.KxE, "", Integer.valueOf(params.Lkt), params.Lkw, params.jfi, Integer.valueOf(params.KHd), Integer.valueOf(params.Lkv), params.Ljk });
      continue;
      label410:
      if ((params.UserName != null) && (params.xut != null)) {
        h.CyF.a(14954, new Object[] { paramString.KxE, "", Integer.valueOf(params.Lkt), params.Lkw, params.jfi, Integer.valueOf(params.KHd), Integer.valueOf(params.Lkv), params.xut, params.UserName });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.d
 * JD-Core Version:    0.7.0.1
 */