package com.tencent.mm.plugin.remittance.bankcard.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ep;
import com.tencent.mm.protocal.protobuf.erq;
import com.tencent.mm.protocal.protobuf.err;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.model.j;

public final class o
  extends b
  implements j
{
  public err Oco;
  private final String TAG;
  private h callback;
  private c rr;
  
  public o(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, int paramInt3, int paramInt4, String paramString5, String paramString6, com.tencent.mm.bx.b paramb, int paramInt5)
  {
    AppMethodBeat.i(67391);
    this.TAG = "MicroMsg.NetSceneBankRemitRequestOrder";
    Log.i("MicroMsg.NetSceneBankRemitRequestOrder", "unique_id:%s last_transfer_bill_id:%s unpay_type:%s", new Object[] { Util.nullAsNil(paramString6), Base64.encodeToString(paramb.toByteArray(), 2), Integer.valueOf(paramInt5) });
    Object localObject = new c.a();
    ((c.a)localObject).otE = new erq();
    ((c.a)localObject).otF = new err();
    ((c.a)localObject).funcId = 1380;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/request_tsbc";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (erq)c.b.b(this.rr.otB);
    ((erq)localObject).OcL = paramString1;
    ((erq)localObject).OcM = paramString2;
    ((erq)localObject).hAk = paramString3;
    ((erq)localObject).Ocy = paramInt1;
    ((erq)localObject).abvk = paramInt2;
    ((erq)localObject).abvl = paramString4;
    ((erq)localObject).abvm = paramInt3;
    ((erq)localObject).abvn = paramInt4;
    ((erq)localObject).YIM = paramString5;
    ((erq)localObject).abdU = paramString6;
    ((erq)localObject).abvo = paramb;
    ((erq)localObject).YXw = paramInt5;
    AppMethodBeat.o(67391);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67393);
    Log.i("MicroMsg.NetSceneBankRemitRequestOrder", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.Oco = ((err)c.c.b(((c)params).otC));
    Log.i("MicroMsg.NetSceneBankRemitRequestOrder", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.Oco.hAV), this.Oco.wYI });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67393);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(67392);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(67392);
    return i;
  }
  
  public final boolean drV()
  {
    return false;
  }
  
  public final void f(s params)
  {
    AppMethodBeat.i(288727);
    params = (err)c.c.b(((c)params).otC);
    this.agTs = params.hAV;
    this.agTt = params.wYI;
    AppMethodBeat.o(288727);
  }
  
  public final boolean gLA()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.Oco.abvp != null)
    {
      bool1 = bool2;
      if (this.Oco.abvp.eQp == 1) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public final int getType()
  {
    return 1380;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.b.o
 * JD-Core Version:    0.7.0.1
 */