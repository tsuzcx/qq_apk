package com.tencent.mm.plugin.remittance.bankcard.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dqn;
import com.tencent.mm.protocal.protobuf.dqo;
import com.tencent.mm.sdk.platformtools.Log;

public final class j
  extends b
{
  public String Ocb;
  public dqo Ocj;
  private final String TAG;
  private h callback;
  public String remark;
  private c rr;
  
  public j(String paramString1, String paramString2)
  {
    AppMethodBeat.i(67376);
    this.TAG = "MicroMsg.NetSceneBankRemitModifyExplain";
    Object localObject = new c.a();
    ((c.a)localObject).otE = new dqn();
    ((c.a)localObject).otF = new dqo();
    ((c.a)localObject).funcId = 1590;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/modifyexplain_tsbc";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (dqn)c.b.b(this.rr.otB);
    ((dqn)localObject).OcL = paramString1;
    ((dqn)localObject).OcO = paramString2;
    this.Ocb = paramString1;
    this.remark = paramString2;
    AppMethodBeat.o(67376);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67378);
    Log.i("MicroMsg.NetSceneBankRemitModifyExplain", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.Ocj = ((dqo)c.c.b(((c)params).otC));
    Log.i("MicroMsg.NetSceneBankRemitModifyExplain", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.Ocj.hAV), this.Ocj.wYI });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67378);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(67377);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(67377);
    return i;
  }
  
  public final void f(s params)
  {
    AppMethodBeat.i(288704);
    params = (dqo)c.c.b(((c)params).otC);
    this.agTs = params.hAV;
    this.agTt = params.wYI;
    AppMethodBeat.o(288704);
  }
  
  public final int getType()
  {
    return 1590;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.b.j
 * JD-Core Version:    0.7.0.1
 */