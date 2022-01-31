package com.tencent.mm.plugin.wallet_core.c;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.soter.d.d;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.td;
import com.tencent.mm.protocal.protobuf.te;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.u;

public final class e
  extends u
{
  private f callback;
  private b rr;
  public int ubr;
  public te ubs;
  
  public e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramInt, (byte)0);
  }
  
  private e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt, byte paramByte)
  {
    AppMethodBeat.i(46492);
    this.ubr = 0;
    this.ubr = 5;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new td();
    ((b.a)localObject).fsY = new te();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/checkuserauthjsapi";
    ((b.a)localObject).funcId = 2728;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (td)this.rr.fsV.fta;
    ((td)localObject).fKw = paramString1;
    ((td)localObject).wvC = paramString2;
    ((td)localObject).wKV = paramString3;
    ((td)localObject).wKW = paramString4;
    ((td)localObject).wKY = paramString5;
    ((td)localObject).wKX = paramString6;
    ((td)localObject).wJT = paramString7;
    ((td)localObject).wKZ = 5;
    ((td)localObject).wDH = m.cTC();
    ((td)localObject).woH = 1;
    ((td)localObject).jJA = null;
    ((td)localObject).nuv = null;
    ((td)localObject).wLc = paramString8;
    ((td)localObject).wLb = paramInt;
    boolean bool = ((l)g.E(l.class)).byS();
    paramString3 = d.cyc();
    paramString2 = paramString3.son;
    paramString3 = paramString3.kbP;
    ((td)localObject).wLD = 0;
    ((td)localObject).son = paramString2;
    ((td)localObject).kbP = paramString3;
    if (bool) {}
    for (paramInt = 1;; paramInt = 0)
    {
      ((td)localObject).wLE = paramInt;
      ab.d("MicroMsg.NetSceneCheckUserAuthJsapi", "cpu_id: %s, uid: %s", new Object[] { paramString2, paramString3 });
      ab.i("MicroMsg.NetSceneCheckUserAuthJsapi", "appId: %s, url: %s, jsapiScene: %s, isOpenTouchPay: %b", new Object[] { paramString1, paramString7, Integer.valueOf(5), Boolean.valueOf(bool) });
      AppMethodBeat.o(46492);
      return;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(46493);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(46493);
    return i;
  }
  
  public final int getType()
  {
    return 580;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(142394);
    ab.d("MicroMsg.NetSceneCheckUserAuthJsapi", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    paramArrayOfByte = paramString;
    if (paramInt2 == 0)
    {
      paramArrayOfByte = paramString;
      if (paramInt3 == 0)
      {
        this.ubs = ((te)((b)paramq).fsW.fta);
        paramString = (td)((b)paramq).fsV.fta;
        if (paramString.wJT == null) {
          break label388;
        }
        paramq = Uri.parse(paramString.wJT).getQueryParameter("appid");
        if (paramq == paramString.fKw) {
          break label296;
        }
        h.qsU.e(14954, new Object[] { this.ubs.wgF, "", Integer.valueOf(paramString.wKZ), paramString.wLc, paramString.fKw, Integer.valueOf(paramString.woH), Integer.valueOf(paramString.wLb), paramString.wJT, paramq });
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.NetSceneCheckUserAuthJsapi", "CheckUserAuthJsapiResponse resp.ErrCode is " + this.ubs.lGK + " resp.ErrMsg is " + this.ubs.lGL);
      paramArrayOfByte = this.ubs.lGL;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramArrayOfByte, this);
      AppMethodBeat.o(142394);
      return;
      label296:
      h.qsU.e(14954, new Object[] { this.ubs.wgF, "", Integer.valueOf(paramString.wKZ), paramString.wLc, paramString.fKw, Integer.valueOf(paramString.woH), Integer.valueOf(paramString.wLb), paramString.wJT });
      continue;
      label388:
      if ((paramString.jJA != null) && (paramString.nuv != null)) {
        h.qsU.e(14954, new Object[] { this.ubs.wgF, "", Integer.valueOf(paramString.wKZ), paramString.wLc, paramString.fKw, Integer.valueOf(paramString.woH), Integer.valueOf(paramString.wLb), paramString.nuv, paramString.jJA });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.e
 * JD-Core Version:    0.7.0.1
 */