package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.yu;
import com.tencent.mm.protocal.protobuf.yv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;

public final class ac
  extends w
{
  public yv Ojz;
  private h callback;
  private c nao;
  
  public ac(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5)
  {
    AppMethodBeat.i(67877);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new yu();
    ((c.a)localObject).otF = new yv();
    ((c.a)localObject).funcId = 1779;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/transferoldpaycheck";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.nao = ((c.a)localObject).bEF();
    localObject = (yu)c.b.b(this.nao.otB);
    ((yu)localObject).hMy = paramString1;
    ((yu)localObject).Okt = paramString2;
    ((yu)localObject).Oks = paramString3;
    ((yu)localObject).Oiw = paramString4;
    ((yu)localObject).OmN = paramLong;
    ((yu)localObject).ZgS = paramString5;
    Log.i("MicroMsg.NetSceneRemittancePayCheck", "reqKey: %s, transfer: %s, fee: %s", new Object[] { paramString1, paramString2, Long.valueOf(paramLong) });
    AppMethodBeat.o(67877);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(67878);
    this.callback = paramh;
    int i = dispatch(paramg, this.nao, this);
    AppMethodBeat.o(67878);
    return i;
  }
  
  public final int getType()
  {
    return 1779;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(288810);
    Log.i("MicroMsg.NetSceneRemittancePayCheck", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.Ojz = ((yv)c.c.b(((c)params).otC));
    Log.i("MicroMsg.NetSceneRemittancePayCheck", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.Ojz.hAV), this.Ojz.wYI });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(288810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.ac
 * JD-Core Version:    0.7.0.1
 */