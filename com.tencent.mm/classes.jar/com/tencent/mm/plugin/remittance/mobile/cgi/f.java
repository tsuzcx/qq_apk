package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.fpw;
import com.tencent.mm.protocal.protobuf.fpx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;

public final class f
  extends w
{
  private fpx OfF;
  private final String TAG;
  private h callback;
  private c nao;
  
  public f(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(67653);
    this.TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord";
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fpw();
    ((c.a)localObject).otF = new fpx();
    ((c.a)localObject).funcId = 2817;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/transferphonepaycheck";
    this.nao = ((c.a)localObject).bEF();
    localObject = (fpw)c.b.b(this.nao.otB);
    ((fpw)localObject).hMy = paramString1;
    ((fpw)localObject).Okt = paramString2;
    ((fpw)localObject).Oks = paramString3;
    ((fpw)localObject).Oiw = paramString4;
    ((fpw)localObject).OmN = paramLong;
    ((fpw)localObject).ZgS = paramString5;
    ((fpw)localObject).abPp = paramString6;
    ((fpw)localObject).abPH = paramString7;
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "do scene NetSceneMobileRemitPayCheck reqKey:%s transferId:%s transactionId:%s receiverOpenid:%s fee:%s extendStr:%s rcvrToken:%s placeorderToken:%s", new Object[] { paramString1, paramString2, paramString3, paramString4, Long.valueOf(paramLong), paramString5, paramString6, paramString7 });
    AppMethodBeat.o(67653);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(67655);
    this.callback = paramh;
    int i = dispatch(paramg, this.nao, this);
    AppMethodBeat.o(67655);
    return i;
  }
  
  public final int getType()
  {
    return 2817;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(288860);
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.OfF = ((fpx)c.c.b(((c)params).otC));
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.OfF.hAV), this.OfF.wYI });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(288860);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.cgi.f
 * JD-Core Version:    0.7.0.1
 */