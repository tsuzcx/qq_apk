package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.mm;
import com.tencent.mm.protocal.protobuf.mn;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends p
  implements m
{
  public mn VZn;
  private h callback;
  private com.tencent.mm.am.c rr;
  
  public c(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(71688);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new mm();
    ((c.a)localObject).otF = new mn();
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/bindecard";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (mm)c.b.b(this.rr.otB);
    ((mm)localObject).YNI = paramString1;
    ((mm)localObject).YNJ = paramString2;
    ((mm)localObject).VJo = paramString3;
    ((mm)localObject).YNK = paramString4;
    ((mm)localObject).hUn = paramInt;
    Log.i("MicroMsg.NetSceneBindECard", "cardType: %s, reqSerial: %s, openScene: %s, verifyCode: %s, bindToken: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), paramString3, paramString4 });
    AppMethodBeat.o(71688);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(71690);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(71690);
    return i;
  }
  
  public final int getType()
  {
    return 1986;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(71689);
    Log.i("MicroMsg.NetSceneBindECard", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.VZn = ((mn)c.c.b(((com.tencent.mm.am.c)params).otC));
    Log.i("MicroMsg.NetSceneBindECard", "ret_code: %d, ret_msg: %s", new Object[] { Integer.valueOf(this.VZn.wuz), this.VZn.wuA });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(71689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a.c
 * JD-Core Version:    0.7.0.1
 */