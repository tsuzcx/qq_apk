package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cow;
import com.tencent.mm.protocal.protobuf.cox;
import com.tencent.mm.sdk.platformtools.ad;

public final class p
  extends n
  implements k
{
  public String Bhd;
  private cow COW;
  public cox COX;
  private f callback;
  private b gPp;
  
  public p(String paramString1, String paramString2)
  {
    AppMethodBeat.i(69923);
    b.a locala = new b.a();
    locala.hNM = new cow();
    locala.hNN = new cox();
    locala.funcId = 2710;
    locala.uri = "/cgi-bin/mmpay-bin/mktqueryawardstatus";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.gPp = locala.aDC();
    this.COW = ((cow)this.gPp.hNK.hNQ);
    this.COW.Dhp = paramString1;
    this.Bhd = paramString2;
    ad.i("MicroMsg.NetSceneMtkQueryAwardStatus", "NetSceneMtkQueryAwardStatus, query_award_status_params: %s, activityId: %s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(69923);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(69924);
    this.callback = paramf;
    int i = dispatch(parame, this.gPp, this);
    AppMethodBeat.o(69924);
    return i;
  }
  
  public final int getType()
  {
    return 2710;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69925);
    ad.i("MicroMsg.NetSceneMtkQueryAwardStatus", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.COX = ((cox)((b)paramq).hNL.hNQ);
    if ((paramInt2 == 0) || (paramInt3 == 0)) {
      ad.i("MicroMsg.NetSceneMtkQueryAwardStatus", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.COX.ozR), this.COX.ozS });
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(69925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.p
 * JD-Core Version:    0.7.0.1
 */