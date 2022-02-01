package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.drj;
import com.tencent.mm.protocal.protobuf.drk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;

public final class ab
  extends w
{
  public drk Ojw;
  String Ojx;
  private String Ojy;
  private h callback;
  private long ihV;
  private c nao;
  
  public ab(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(288792);
    this.ihV = 0L;
    Log.i("Micromsg.NetSceneRemittanceMsgCheck", "transferID: %s, amount:%s msgCheckStr:%s", new Object[] { paramString1, Long.valueOf(paramLong), paramString2 });
    this.Ojx = paramString1;
    this.ihV = paramLong;
    this.Ojy = paramString2;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new drj();
    ((c.a)localObject).otF = new drk();
    ((c.a)localObject).funcId = 6230;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/transfermsgcheck";
    this.nao = ((c.a)localObject).bEF();
    localObject = (drj)c.b.b(this.nao.otB);
    ((drj)localObject).Okt = paramString1;
    ((drj)localObject).ihV = paramLong;
    ((drj)localObject).aaXg = paramString2;
    AppMethodBeat.o(288792);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(288799);
    this.callback = paramh;
    int i = dispatch(paramg, this.nao, this);
    AppMethodBeat.o(288799);
    return i;
  }
  
  public final int getType()
  {
    return 6230;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(288801);
    Log.i("Micromsg.NetSceneRemittanceMsgCheck", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.Ojw = ((drk)c.c.b(((c)params).otC));
    Log.i("Micromsg.NetSceneRemittanceMsgCheck", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.Ojw.wuz), this.Ojw.wuA });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(288801);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.ab
 * JD-Core Version:    0.7.0.1
 */