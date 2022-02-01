package com.tencent.mm.plugin.wallet_core.c;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.soter.d.d;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.wg;
import com.tencent.mm.protocal.protobuf.wh;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.w;

public final class e
  extends w
{
  public int Bop;
  public wh Boq;
  private com.tencent.mm.ak.g callback;
  private b rr;
  
  public e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramInt, (byte)0);
  }
  
  private e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt, byte paramByte)
  {
    AppMethodBeat.i(69894);
    this.Bop = 0;
    this.Bop = 5;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new wg();
    ((b.a)localObject).hvu = new wh();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/checkuserauthjsapi";
    ((b.a)localObject).funcId = 2728;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (wg)this.rr.hvr.hvw;
    ((wg)localObject).hOf = paramString1;
    ((wg)localObject).DYh = paramString2;
    ((wg)localObject).EpT = paramString3;
    ((wg)localObject).EpU = paramString4;
    ((wg)localObject).EpW = paramString5;
    ((wg)localObject).EpV = paramString6;
    ((wg)localObject).EoO = paramString7;
    ((wg)localObject).EpX = 5;
    ((wg)localObject).EhT = k.ero();
    ((wg)localObject).DPL = 1;
    ((wg)localObject).ncR = null;
    ((wg)localObject).tlT = null;
    ((wg)localObject).Eqa = paramString8;
    ((wg)localObject).EpZ = paramInt;
    boolean bool = ((a)com.tencent.mm.kernel.g.ab(a.class)).cGZ();
    paramString3 = d.dTq();
    paramString2 = paramString3.znE;
    paramString3 = paramString3.znF;
    ((wg)localObject).EqE = 0;
    ((wg)localObject).znE = paramString2;
    ((wg)localObject).znF = paramString3;
    if (bool) {}
    for (paramInt = 1;; paramInt = 0)
    {
      ((wg)localObject).EqF = paramInt;
      ac.d("MicroMsg.NetSceneCheckUserAuthJsapi", "cpu_id: %s, uid: %s", new Object[] { paramString2, paramString3 });
      ac.i("MicroMsg.NetSceneCheckUserAuthJsapi", "appId: %s, url: %s, jsapiScene: %s, isOpenTouchPay: %b", new Object[] { paramString1, paramString7, Integer.valueOf(5), Boolean.valueOf(bool) });
      AppMethodBeat.o(69894);
      return;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(69895);
    this.callback = paramg;
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
    ac.d("MicroMsg.NetSceneCheckUserAuthJsapi", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    paramArrayOfByte = paramString;
    if (paramInt2 == 0)
    {
      paramArrayOfByte = paramString;
      if (paramInt3 == 0)
      {
        this.Boq = ((wh)((b)paramq).hvs.hvw);
        paramString = (wg)((b)paramq).hvr.hvw;
        if (paramString.EoO == null) {
          break label388;
        }
        paramq = Uri.parse(paramString.EoO).getQueryParameter("appid");
        if (paramq == paramString.hOf) {
          break label296;
        }
        h.wUl.f(14954, new Object[] { this.Boq.DGU, "", Integer.valueOf(paramString.EpX), paramString.Eqa, paramString.hOf, Integer.valueOf(paramString.DPL), Integer.valueOf(paramString.EpZ), paramString.EoO, paramq });
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.NetSceneCheckUserAuthJsapi", "CheckUserAuthJsapiResponse resp.ErrCode is " + this.Boq.pAG + " resp.ErrMsg is " + this.Boq.pAH);
      paramArrayOfByte = this.Boq.pAH;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramArrayOfByte, this);
      AppMethodBeat.o(69896);
      return;
      label296:
      h.wUl.f(14954, new Object[] { this.Boq.DGU, "", Integer.valueOf(paramString.EpX), paramString.Eqa, paramString.hOf, Integer.valueOf(paramString.DPL), Integer.valueOf(paramString.EpZ), paramString.EoO });
      continue;
      label388:
      if ((paramString.ncR != null) && (paramString.tlT != null)) {
        h.wUl.f(14954, new Object[] { this.Boq.DGU, "", Integer.valueOf(paramString.EpX), paramString.Eqa, paramString.hOf, Integer.valueOf(paramString.DPL), Integer.valueOf(paramString.EpZ), paramString.tlT, paramString.ncR });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.e
 * JD-Core Version:    0.7.0.1
 */