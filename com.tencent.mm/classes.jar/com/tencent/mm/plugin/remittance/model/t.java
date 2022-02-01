package com.tencent.mm.plugin.remittance.model;

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
import com.tencent.mm.protocal.protobuf.vo;
import com.tencent.mm.protocal.protobuf.vp;
import com.tencent.mm.sdk.platformtools.ad;

public final class t
  extends n
  implements k
{
  private f callback;
  private b gPp;
  public vp xYl;
  
  public t(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5)
  {
    AppMethodBeat.i(67877);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new vo();
    ((b.a)localObject).hNN = new vp();
    ((b.a)localObject).funcId = 1779;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/transferoldpaycheck";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.gPp = ((b.a)localObject).aDC();
    localObject = (vo)this.gPp.hNK.hNQ;
    ((vo)localObject).dve = paramString1;
    ((vo)localObject).xZi = paramString2;
    ((vo)localObject).xZh = paramString3;
    ((vo)localObject).xZb = paramString4;
    ((vo)localObject).ybo = paramLong;
    ((vo)localObject).FUv = paramString5;
    ad.i("MicroMsg.NetSceneRemittancePayCheck", "reqKey: %s, transfer: %s, fee: %s", new Object[] { paramString1, paramString2, Long.valueOf(paramLong) });
    AppMethodBeat.o(67877);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(67878);
    this.callback = paramf;
    int i = dispatch(parame, this.gPp, this);
    AppMethodBeat.o(67878);
    return i;
  }
  
  public final int getType()
  {
    return 1779;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67879);
    ad.i("MicroMsg.NetSceneRemittancePayCheck", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.xYl = ((vp)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneRemittancePayCheck", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.xYl.dlw), this.xYl.paA });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(67879);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.t
 * JD-Core Version:    0.7.0.1
 */