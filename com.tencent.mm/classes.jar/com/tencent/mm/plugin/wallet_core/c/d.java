package com.tencent.mm.plugin.wallet_core.c;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.djz;
import com.tencent.mm.protocal.protobuf.zi;
import com.tencent.mm.protocal.protobuf.zj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.c.z;

public final class d
  extends w
{
  public int OHK;
  private i callback;
  public com.tencent.mm.an.d rr;
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, String paramString7, String paramString8, String paramString9, int paramInt2)
  {
    AppMethodBeat.i(69891);
    this.OHK = 0;
    this.OHK = paramInt1;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new zi();
    ((d.a)localObject).lBV = new zj();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/checkpayjsapi";
    ((d.a)localObject).funcId = 580;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (zi)d.b.b(this.rr.lBR);
    ((zi)localObject).lVG = paramString1;
    ((zi)localObject).RQH = paramString2;
    ((zi)localObject).Sly = paramString3;
    ((zi)localObject).Slz = paramString4;
    ((zi)localObject).SlB = paramString5;
    ((zi)localObject).SlA = paramString6;
    ((zi)localObject).SlC = paramInt1;
    ((zi)localObject).UserName = paramString7;
    ((zi)localObject).CqK = paramString8;
    ((zi)localObject).RIv = 2;
    ((zi)localObject).SlF = paramString9;
    ((zi)localObject).SlE = paramInt2;
    ((zi)localObject).Sdp = k.gJe();
    if (z.iiS()) {
      ((zi)localObject).SlD = z.getBindCardUuid();
    }
    Log.i("MicroMsg.NetSceneCheckPayJsapi", "appId: %s, UserName: %s, path: %s", new Object[] { paramString1, paramString7, paramString8 });
    AppMethodBeat.o(69891);
  }
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt1, String paramString8, int paramInt2)
  {
    AppMethodBeat.i(69890);
    this.OHK = 0;
    this.OHK = paramInt1;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new zi();
    ((d.a)localObject).lBV = new zj();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/checkpayjsapi";
    ((d.a)localObject).funcId = 580;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (zi)d.b.b(this.rr.lBR);
    ((zi)localObject).lVG = paramString1;
    ((zi)localObject).RQH = paramString2;
    ((zi)localObject).Sly = paramString3;
    ((zi)localObject).Slz = paramString4;
    ((zi)localObject).SlB = paramString5;
    ((zi)localObject).SlA = paramString6;
    ((zi)localObject).SkB = paramString7;
    ((zi)localObject).SlC = paramInt1;
    ((zi)localObject).Sdp = k.gJe();
    if (z.iiS()) {
      ((zi)localObject).SlD = z.getBindCardUuid();
    }
    ((zi)localObject).RIv = 1;
    ((zi)localObject).SlF = paramString8;
    ((zi)localObject).SlE = paramInt2;
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
  
  public final String gIv()
  {
    AppMethodBeat.i(205116);
    String str = ((zj)d.c.b(this.rr.lBS)).Rzs;
    AppMethodBeat.o(205116);
    return str;
  }
  
  public final djz gIw()
  {
    AppMethodBeat.i(205117);
    djz localdjz = ((zj)d.c.b(this.rr.lBS)).SlG;
    AppMethodBeat.o(205117);
    return localdjz;
  }
  
  public final String getToken()
  {
    AppMethodBeat.i(205115);
    String str = ((zj)d.c.b(this.rr.lBS)).token;
    AppMethodBeat.o(205115);
    return str;
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
        paramString = (zj)d.c.b(((com.tencent.mm.an.d)params).lBS);
        Log.i("MicroMsg.NetSceneCheckPayJsapi", "NetSceneCheckPayJsapi resp.ErrCode is " + paramString.vht + " resp.ErrMsg is " + paramString.vhu);
        params = (zi)d.b.b(((com.tencent.mm.an.d)params).lBR);
        if (params.SkB == null) {
          break label412;
        }
        paramArrayOfByte = Uri.parse(params.SkB).getQueryParameter("appid");
        if (paramArrayOfByte == params.lVG) {
          break label322;
        }
        h.IzE.a(14954, new Object[] { paramString.Rzs, "", Integer.valueOf(params.SlC), params.SlF, params.lVG, Integer.valueOf(params.RIv), Integer.valueOf(params.SlE), params.SkB, paramArrayOfByte });
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.NetSceneCheckPayJsapi", "NetSceneCheckPayJsapi resp.ErrCode is " + paramString.vht + " resp.ErrMsg is " + paramString.vhu);
      paramArrayOfByte = paramString.vhu;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramArrayOfByte, this);
      AppMethodBeat.o(69893);
      return;
      label322:
      h.IzE.a(14954, new Object[] { paramString.Rzs, "", Integer.valueOf(params.SlC), params.SlF, params.lVG, Integer.valueOf(params.RIv), Integer.valueOf(params.SlE), params.SkB });
      continue;
      label412:
      if ((params.UserName != null) && (params.CqK != null)) {
        h.IzE.a(14954, new Object[] { paramString.Rzs, "", Integer.valueOf(params.SlC), params.SlF, params.lVG, Integer.valueOf(params.RIv), Integer.valueOf(params.SlE), params.CqK, params.UserName });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.d
 * JD-Core Version:    0.7.0.1
 */