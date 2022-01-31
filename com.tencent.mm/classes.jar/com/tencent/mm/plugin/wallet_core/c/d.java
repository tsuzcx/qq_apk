package com.tencent.mm.plugin.wallet_core.c;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.protocal.protobuf.so;
import com.tencent.mm.protocal.protobuf.sp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.c.x;

public final class d
  extends u
{
  private f callback;
  public b rr;
  public int ubr;
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, String paramString7, String paramString8, String paramString9, int paramInt2)
  {
    AppMethodBeat.i(46489);
    this.ubr = 0;
    this.ubr = paramInt1;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new so();
    ((b.a)localObject).fsY = new sp();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/checkpayjsapi";
    ((b.a)localObject).funcId = 580;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (so)this.rr.fsV.fta;
    ((so)localObject).fKw = paramString1;
    ((so)localObject).wvC = paramString2;
    ((so)localObject).wKV = paramString3;
    ((so)localObject).wKW = paramString4;
    ((so)localObject).wKY = paramString5;
    ((so)localObject).wKX = paramString6;
    ((so)localObject).wKZ = paramInt1;
    ((so)localObject).jJA = paramString7;
    ((so)localObject).nuv = paramString8;
    ((so)localObject).woH = 2;
    ((so)localObject).wLc = paramString9;
    ((so)localObject).wLb = paramInt2;
    ((so)localObject).wDH = m.cTC();
    if (x.dSp()) {
      ((so)localObject).wLa = x.dSr();
    }
    ab.i("MicroMsg.NetSceneCheckPayJsapi", "appId: %s, UserName: %s, path: %s", new Object[] { paramString1, paramString7, paramString8 });
    AppMethodBeat.o(46489);
  }
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt1, String paramString8, int paramInt2)
  {
    AppMethodBeat.i(46488);
    this.ubr = 0;
    this.ubr = paramInt1;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new so();
    ((b.a)localObject).fsY = new sp();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/checkpayjsapi";
    ((b.a)localObject).funcId = 580;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (so)this.rr.fsV.fta;
    ((so)localObject).fKw = paramString1;
    ((so)localObject).wvC = paramString2;
    ((so)localObject).wKV = paramString3;
    ((so)localObject).wKW = paramString4;
    ((so)localObject).wKY = paramString5;
    ((so)localObject).wKX = paramString6;
    ((so)localObject).wJT = paramString7;
    ((so)localObject).wKZ = paramInt1;
    ((so)localObject).wDH = m.cTC();
    if (x.dSp()) {
      ((so)localObject).wLa = x.dSr();
    }
    ((so)localObject).woH = 1;
    ((so)localObject).wLc = paramString8;
    ((so)localObject).wLb = paramInt2;
    ab.i("MicroMsg.NetSceneCheckPayJsapi", "appId: %s, url: %s, jsapiScene: %s", new Object[] { paramString1, paramString7, Integer.valueOf(paramInt1) });
    AppMethodBeat.o(46488);
  }
  
  public final String cSW()
  {
    return ((sp)this.rr.fsW.fta).wgF;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(46490);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(46490);
    return i;
  }
  
  public final String getToken()
  {
    return ((sp)this.rr.fsW.fta).token;
  }
  
  public final int getType()
  {
    return 580;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(142393);
    ab.d("MicroMsg.NetSceneCheckPayJsapi", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    paramArrayOfByte = paramString;
    if (paramInt2 == 0)
    {
      paramArrayOfByte = paramString;
      if (paramInt3 == 0)
      {
        paramString = (sp)((b)paramq).fsW.fta;
        ab.i("MicroMsg.NetSceneCheckPayJsapi", "NetSceneCheckPayJsapi resp.ErrCode is " + paramString.lGK + " resp.ErrMsg is " + paramString.lGL);
        paramq = (so)((b)paramq).fsV.fta;
        if (paramq.wJT == null) {
          break label410;
        }
        paramArrayOfByte = Uri.parse(paramq.wJT).getQueryParameter("appid");
        if (paramArrayOfByte == paramq.fKw) {
          break label321;
        }
        h.qsU.e(14954, new Object[] { paramString.wgF, "", Integer.valueOf(paramq.wKZ), paramq.wLc, paramq.fKw, Integer.valueOf(paramq.woH), Integer.valueOf(paramq.wLb), paramq.wJT, paramArrayOfByte });
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.NetSceneCheckPayJsapi", "NetSceneCheckPayJsapi resp.ErrCode is " + paramString.lGK + " resp.ErrMsg is " + paramString.lGL);
      paramArrayOfByte = paramString.lGL;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramArrayOfByte, this);
      AppMethodBeat.o(142393);
      return;
      label321:
      h.qsU.e(14954, new Object[] { paramString.wgF, "", Integer.valueOf(paramq.wKZ), paramq.wLc, paramq.fKw, Integer.valueOf(paramq.woH), Integer.valueOf(paramq.wLb), paramq.wJT });
      continue;
      label410:
      if ((paramq.jJA != null) && (paramq.nuv != null)) {
        h.qsU.e(14954, new Object[] { paramString.wgF, "", Integer.valueOf(paramq.wKZ), paramq.wLc, paramq.fKw, Integer.valueOf(paramq.woH), Integer.valueOf(paramq.wLb), paramq.nuv, paramq.jJA });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.d
 * JD-Core Version:    0.7.0.1
 */