package com.tencent.mm.plugin.remittance.bankcard.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ekk;
import com.tencent.mm.protocal.protobuf.ekl;
import com.tencent.mm.sdk.platformtools.Log;

public final class i
  extends b
{
  public ekl Oci;
  private h callback;
  public int limit;
  private c rr;
  
  public i(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(67373);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ekk();
    ((c.a)localObject).otF = new ekl();
    ((c.a)localObject).funcId = 1511;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/historylist_tsbc";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ekk)c.b.b(this.rr.otB);
    ((ekk)localObject).limit = paramInt1;
    ((ekk)localObject).offset = paramInt2;
    this.limit = paramInt1;
    Log.i("MicroMsg.NetSceneBankRemitHistoryList", "limit: %s, offset: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(67373);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67375);
    Log.i("MicroMsg.NetSceneBankRemitHistoryList", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.Oci = ((ekl)c.c.b(((c)params).otC));
    Log.i("MicroMsg.NetSceneBankRemitHistoryList", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.Oci.hAV), this.Oci.wYI });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67375);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(67374);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(67374);
    return i;
  }
  
  public final void f(s params)
  {
    AppMethodBeat.i(288715);
    params = (ekl)c.c.b(((c)params).otC);
    this.agTs = params.hAV;
    this.agTt = params.wYI;
    AppMethodBeat.o(288715);
  }
  
  public final int getType()
  {
    return 1511;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.b.i
 * JD-Core Version:    0.7.0.1
 */