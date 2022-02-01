package com.tencent.mm.plugin.wallet_core.c;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.abg;
import com.tencent.mm.protocal.protobuf.ecj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.aa;
import com.tencent.mm.wallet_core.model.w;

public final class d
  extends w
{
  public int Vxw;
  private com.tencent.mm.am.h callback;
  public c rr;
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, String paramString7, String paramString8, String paramString9, int paramInt2)
  {
    AppMethodBeat.i(69891);
    this.Vxw = 0;
    this.Vxw = paramInt1;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new abf();
    ((c.a)localObject).otF = new abg();
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/checkpayjsapi";
    ((c.a)localObject).funcId = 580;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (abf)c.b.b(this.rr.otB);
    ((abf)localObject).oOI = paramString1;
    ((abf)localObject).YNW = paramString2;
    ((abf)localObject).ZjI = paramString3;
    ((abf)localObject).ZjJ = paramString4;
    ((abf)localObject).ZjL = paramString5;
    ((abf)localObject).ZjK = paramString6;
    ((abf)localObject).ZjM = paramInt1;
    ((abf)localObject).UserName = paramString7;
    ((abf)localObject).IcT = paramString8;
    ((abf)localObject).YFx = 2;
    ((abf)localObject).ZjP = paramString9;
    ((abf)localObject).ZjO = paramInt2;
    ((abf)localObject).Zbi = k.iis();
    if (aa.jOO()) {
      ((abf)localObject).ZjN = aa.getBindCardUuid();
    }
    Log.i("MicroMsg.NetSceneCheckPayJsapi", "appId: %s, UserName: %s, path: %s", new Object[] { paramString1, paramString7, paramString8 });
    AppMethodBeat.o(69891);
  }
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt1, String paramString8, int paramInt2)
  {
    AppMethodBeat.i(69890);
    this.Vxw = 0;
    this.Vxw = paramInt1;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new abf();
    ((c.a)localObject).otF = new abg();
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/checkpayjsapi";
    ((c.a)localObject).funcId = 580;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (abf)c.b.b(this.rr.otB);
    ((abf)localObject).oOI = paramString1;
    ((abf)localObject).YNW = paramString2;
    ((abf)localObject).ZjI = paramString3;
    ((abf)localObject).ZjJ = paramString4;
    ((abf)localObject).ZjL = paramString5;
    ((abf)localObject).ZjK = paramString6;
    ((abf)localObject).ZiL = paramString7;
    ((abf)localObject).ZjM = paramInt1;
    ((abf)localObject).Zbi = k.iis();
    if (aa.jOO()) {
      ((abf)localObject).ZjN = aa.getBindCardUuid();
    }
    ((abf)localObject).YFx = 1;
    ((abf)localObject).ZjP = paramString8;
    ((abf)localObject).ZjO = paramInt2;
    Log.i("MicroMsg.NetSceneCheckPayJsapi", "appId: %s, url: %s, jsapiScene: %s", new Object[] { paramString1, paramString7, Integer.valueOf(paramInt1) });
    AppMethodBeat.o(69890);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(69892);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(69892);
    return i;
  }
  
  public final String getToken()
  {
    AppMethodBeat.i(301128);
    String str = ((abg)c.c.b(this.rr.otC)).token;
    AppMethodBeat.o(301128);
    return str;
  }
  
  public final int getType()
  {
    return 580;
  }
  
  public final String ihJ()
  {
    AppMethodBeat.i(301129);
    String str = ((abg)c.c.b(this.rr.otC)).YvQ;
    AppMethodBeat.o(301129);
    return str;
  }
  
  public final ecj ihK()
  {
    AppMethodBeat.i(301132);
    ecj localecj = ((abg)c.c.b(this.rr.otC)).ZjQ;
    AppMethodBeat.o(301132);
    return localecj;
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
        paramString = (abg)c.c.b(((c)params).otC);
        Log.i("MicroMsg.NetSceneCheckPayJsapi", "NetSceneCheckPayJsapi resp.ErrCode is " + paramString.ytv + " resp.ErrMsg is " + paramString.ytw);
        params = (abf)c.b.b(((c)params).otB);
        if (params.ZiL == null) {
          break label412;
        }
        paramArrayOfByte = Uri.parse(params.ZiL).getQueryParameter("appid");
        if (paramArrayOfByte == params.oOI) {
          break label322;
        }
        com.tencent.mm.plugin.report.service.h.OAn.b(14954, new Object[] { paramString.YvQ, "", Integer.valueOf(params.ZjM), params.ZjP, params.oOI, Integer.valueOf(params.YFx), Integer.valueOf(params.ZjO), params.ZiL, paramArrayOfByte });
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.NetSceneCheckPayJsapi", "NetSceneCheckPayJsapi resp.ErrCode is " + paramString.ytv + " resp.ErrMsg is " + paramString.ytw);
      paramArrayOfByte = paramString.ytw;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramArrayOfByte, this);
      AppMethodBeat.o(69893);
      return;
      label322:
      com.tencent.mm.plugin.report.service.h.OAn.b(14954, new Object[] { paramString.YvQ, "", Integer.valueOf(params.ZjM), params.ZjP, params.oOI, Integer.valueOf(params.YFx), Integer.valueOf(params.ZjO), params.ZiL });
      continue;
      label412:
      if ((params.UserName != null) && (params.IcT != null)) {
        com.tencent.mm.plugin.report.service.h.OAn.b(14954, new Object[] { paramString.YvQ, "", Integer.valueOf(params.ZjM), params.ZjP, params.oOI, Integer.valueOf(params.YFx), Integer.valueOf(params.ZjO), params.IcT, params.UserName });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.d
 * JD-Core Version:    0.7.0.1
 */