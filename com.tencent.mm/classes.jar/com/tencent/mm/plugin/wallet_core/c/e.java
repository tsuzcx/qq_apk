package com.tencent.mm.plugin.wallet_core.c;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.fingerprint.c.a;
import com.tencent.mm.plugin.soter.model.b;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;

public final class e
  extends w
{
  public int Vxw;
  public acb Vxx;
  private com.tencent.mm.am.h callback;
  private com.tencent.mm.am.c rr;
  
  public e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramInt, (byte)0);
  }
  
  private e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt, byte paramByte)
  {
    AppMethodBeat.i(69894);
    this.Vxw = 0;
    this.Vxw = 5;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new aca();
    ((c.a)localObject).otF = new acb();
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/checkuserauthjsapi";
    ((c.a)localObject).funcId = 2728;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (aca)c.b.b(this.rr.otB);
    ((aca)localObject).oOI = paramString1;
    ((aca)localObject).YNW = paramString2;
    ((aca)localObject).ZjI = paramString3;
    ((aca)localObject).ZjJ = paramString4;
    ((aca)localObject).ZjL = paramString5;
    ((aca)localObject).ZjK = paramString6;
    ((aca)localObject).ZiL = paramString7;
    ((aca)localObject).ZjM = 5;
    ((aca)localObject).Zbi = k.iis();
    ((aca)localObject).YFx = 1;
    ((aca)localObject).UserName = null;
    ((aca)localObject).IcT = null;
    ((aca)localObject).ZjP = paramString8;
    ((aca)localObject).ZjO = paramInt;
    paramString2 = (a)com.tencent.mm.kernel.h.ax(a.class);
    boolean bool = paramString2.ftq();
    paramString4 = b.htz();
    paramString3 = paramString4.RZY;
    paramString4 = paramString4.mXG;
    if (paramString2.isRoot())
    {
      paramInt = 1;
      ((aca)localObject).ZkA = paramInt;
      ((aca)localObject).RZY = paramString3;
      ((aca)localObject).mXG = paramString4;
      if (!bool) {
        break label344;
      }
    }
    label344:
    for (paramInt = 1;; paramInt = 0)
    {
      ((aca)localObject).ZkB = paramInt;
      Log.d("MicroMsg.NetSceneCheckUserAuthJsapi", "cpu_id: %s, uid: %s", new Object[] { paramString3, paramString4 });
      Log.i("MicroMsg.NetSceneCheckUserAuthJsapi", "appId: %s, url: %s, jsapiScene: %s, isOpenTouchPay: %b", new Object[] { paramString1, paramString7, Integer.valueOf(5), Boolean.valueOf(bool) });
      AppMethodBeat.o(69894);
      return;
      paramInt = 0;
      break;
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(69895);
    this.callback = paramh;
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
        this.Vxx = ((acb)c.c.b(((com.tencent.mm.am.c)params).otC));
        paramString = (aca)c.b.b(((com.tencent.mm.am.c)params).otB);
        if (paramString.ZiL == null) {
          break label388;
        }
        params = Uri.parse(paramString.ZiL).getQueryParameter("appid");
        if (params == paramString.oOI) {
          break label296;
        }
        com.tencent.mm.plugin.report.service.h.OAn.b(14954, new Object[] { this.Vxx.YvQ, "", Integer.valueOf(paramString.ZjM), paramString.ZjP, paramString.oOI, Integer.valueOf(paramString.YFx), Integer.valueOf(paramString.ZjO), paramString.ZiL, params });
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.NetSceneCheckUserAuthJsapi", "CheckUserAuthJsapiResponse resp.ErrCode is " + this.Vxx.ytv + " resp.ErrMsg is " + this.Vxx.ytw);
      paramArrayOfByte = this.Vxx.ytw;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramArrayOfByte, this);
      AppMethodBeat.o(69896);
      return;
      label296:
      com.tencent.mm.plugin.report.service.h.OAn.b(14954, new Object[] { this.Vxx.YvQ, "", Integer.valueOf(paramString.ZjM), paramString.ZjP, paramString.oOI, Integer.valueOf(paramString.YFx), Integer.valueOf(paramString.ZjO), paramString.ZiL });
      continue;
      label388:
      if ((paramString.UserName != null) && (paramString.IcT != null)) {
        com.tencent.mm.plugin.report.service.h.OAn.b(14954, new Object[] { this.Vxx.YvQ, "", Integer.valueOf(paramString.ZjM), paramString.ZjP, paramString.oOI, Integer.valueOf(paramString.YFx), Integer.valueOf(paramString.ZjO), paramString.IcT, paramString.UserName });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.e
 * JD-Core Version:    0.7.0.1
 */