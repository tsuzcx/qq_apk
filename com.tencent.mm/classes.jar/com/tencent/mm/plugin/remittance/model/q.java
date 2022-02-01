package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.xi;
import com.tencent.mm.protocal.protobuf.xj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.r;
import java.net.URLDecoder;

public final class q
  extends r
{
  public xj Ojd;
  private final String TAG;
  
  public q(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(67863);
    this.TAG = "MicroMsg.NetSceneF2fDynamicCode";
    Object localObject = new c.a();
    ((c.a)localObject).otE = new xi();
    ((c.a)localObject).otF = new xj();
    ((c.a)localObject).funcId = 2736;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/f2fdynamiccode";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (xi)c.b.b(this.rr.otB);
    ((xi)localObject).amount = paramInt;
    ((xi)localObject).wwH = paramString1;
    ((xi)localObject).Oiw = paramString2;
    ((xi)localObject).ZfW = URLDecoder.decode(paramString3);
    ((xi)localObject).OjW = paramString4;
    ((xi)localObject).OjX = paramString5;
    ((xi)localObject).Okp = paramString6;
    ((xi)localObject).nickname = paramString7;
    ((xi)localObject).OiN = paramString8;
    Log.i("MicroMsg.NetSceneF2fDynamicCode", "amount: %s, username: %s, transfer_code_id: %s", new Object[] { Integer.valueOf(paramInt), paramString1, URLDecoder.decode(paramString3) });
    AppMethodBeat.o(67863);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67864);
    Log.i("MicroMsg.NetSceneF2fDynamicCode", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.Ojd = ((xj)c.c.b(((c)params).otC));
    Log.i("MicroMsg.NetSceneF2fDynamicCode", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.Ojd.hAV), this.Ojd.wYI });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67864);
  }
  
  public final void f(s params)
  {
    AppMethodBeat.i(288843);
    params = (xj)c.c.b(((c)params).otC);
    this.agTs = params.hAV;
    this.agTt = params.wYI;
    AppMethodBeat.o(288843);
  }
  
  public final int getType()
  {
    return 2736;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.q
 * JD-Core Version:    0.7.0.1
 */