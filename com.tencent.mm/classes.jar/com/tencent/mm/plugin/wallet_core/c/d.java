package com.tencent.mm.plugin.wallet_core.c;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.cek;
import com.tencent.mm.protocal.protobuf.vq;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.c.z;

public final class d
  extends w
{
  public int Bop;
  private g callback;
  public b rr;
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, String paramString7, String paramString8, String paramString9, int paramInt2)
  {
    AppMethodBeat.i(69891);
    this.Bop = 0;
    this.Bop = paramInt1;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new vq();
    ((b.a)localObject).hvu = new vr();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/checkpayjsapi";
    ((b.a)localObject).funcId = 580;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (vq)this.rr.hvr.hvw;
    ((vq)localObject).hOf = paramString1;
    ((vq)localObject).DYh = paramString2;
    ((vq)localObject).EpT = paramString3;
    ((vq)localObject).EpU = paramString4;
    ((vq)localObject).EpW = paramString5;
    ((vq)localObject).EpV = paramString6;
    ((vq)localObject).EpX = paramInt1;
    ((vq)localObject).ncR = paramString7;
    ((vq)localObject).tlT = paramString8;
    ((vq)localObject).DPL = 2;
    ((vq)localObject).Eqa = paramString9;
    ((vq)localObject).EpZ = paramInt2;
    ((vq)localObject).EhT = k.ero();
    if (z.fAn()) {
      ((vq)localObject).EpY = z.getBindCardUuid();
    }
    ac.i("MicroMsg.NetSceneCheckPayJsapi", "appId: %s, UserName: %s, path: %s", new Object[] { paramString1, paramString7, paramString8 });
    AppMethodBeat.o(69891);
  }
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt1, String paramString8, int paramInt2)
  {
    AppMethodBeat.i(69890);
    this.Bop = 0;
    this.Bop = paramInt1;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new vq();
    ((b.a)localObject).hvu = new vr();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/checkpayjsapi";
    ((b.a)localObject).funcId = 580;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (vq)this.rr.hvr.hvw;
    ((vq)localObject).hOf = paramString1;
    ((vq)localObject).DYh = paramString2;
    ((vq)localObject).EpT = paramString3;
    ((vq)localObject).EpU = paramString4;
    ((vq)localObject).EpW = paramString5;
    ((vq)localObject).EpV = paramString6;
    ((vq)localObject).EoO = paramString7;
    ((vq)localObject).EpX = paramInt1;
    ((vq)localObject).EhT = k.ero();
    if (z.fAn()) {
      ((vq)localObject).EpY = z.getBindCardUuid();
    }
    ((vq)localObject).DPL = 1;
    ((vq)localObject).Eqa = paramString8;
    ((vq)localObject).EpZ = paramInt2;
    ac.i("MicroMsg.NetSceneCheckPayJsapi", "appId: %s, url: %s, jsapiScene: %s", new Object[] { paramString1, paramString7, Integer.valueOf(paramInt1) });
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
  
  public final String eqF()
  {
    return ((vr)this.rr.hvs.hvw).DGU;
  }
  
  public final cek eqG()
  {
    return ((vr)this.rr.hvs.hvw).Eqb;
  }
  
  public final String getToken()
  {
    return ((vr)this.rr.hvs.hvw).token;
  }
  
  public final int getType()
  {
    return 580;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(69893);
    ac.d("MicroMsg.NetSceneCheckPayJsapi", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    paramArrayOfByte = paramString;
    if (paramInt2 == 0)
    {
      paramArrayOfByte = paramString;
      if (paramInt3 == 0)
      {
        paramString = (vr)((b)paramq).hvs.hvw;
        ac.i("MicroMsg.NetSceneCheckPayJsapi", "NetSceneCheckPayJsapi resp.ErrCode is " + paramString.pAG + " resp.ErrMsg is " + paramString.pAH);
        paramq = (vq)((b)paramq).hvr.hvw;
        if (paramq.EoO == null) {
          break label410;
        }
        paramArrayOfByte = Uri.parse(paramq.EoO).getQueryParameter("appid");
        if (paramArrayOfByte == paramq.hOf) {
          break label321;
        }
        h.wUl.f(14954, new Object[] { paramString.DGU, "", Integer.valueOf(paramq.EpX), paramq.Eqa, paramq.hOf, Integer.valueOf(paramq.DPL), Integer.valueOf(paramq.EpZ), paramq.EoO, paramArrayOfByte });
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.NetSceneCheckPayJsapi", "NetSceneCheckPayJsapi resp.ErrCode is " + paramString.pAG + " resp.ErrMsg is " + paramString.pAH);
      paramArrayOfByte = paramString.pAH;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramArrayOfByte, this);
      AppMethodBeat.o(69893);
      return;
      label321:
      h.wUl.f(14954, new Object[] { paramString.DGU, "", Integer.valueOf(paramq.EpX), paramq.Eqa, paramq.hOf, Integer.valueOf(paramq.DPL), Integer.valueOf(paramq.EpZ), paramq.EoO });
      continue;
      label410:
      if ((paramq.ncR != null) && (paramq.tlT != null)) {
        h.wUl.f(14954, new Object[] { paramString.DGU, "", Integer.valueOf(paramq.EpX), paramq.Eqa, paramq.hOf, Integer.valueOf(paramq.DPL), Integer.valueOf(paramq.EpZ), paramq.tlT, paramq.ncR });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.d
 * JD-Core Version:    0.7.0.1
 */