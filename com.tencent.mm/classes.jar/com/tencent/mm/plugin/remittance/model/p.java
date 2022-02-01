package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.vq;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;
import java.net.URLDecoder;

public final class p
  extends r
{
  public vr IlM;
  private final String TAG;
  
  public p(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(67863);
    this.TAG = "MicroMsg.NetSceneF2fDynamicCode";
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new vq();
    ((d.a)localObject).lBV = new vr();
    ((d.a)localObject).funcId = 2736;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/f2fdynamiccode";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (vq)d.b.b(this.rr.lBR);
    ((vq)localObject).amount = paramInt;
    ((vq)localObject).tsk = paramString1;
    ((vq)localObject).ImY = paramString2;
    ((vq)localObject).ShQ = URLDecoder.decode(paramString3);
    ((vq)localObject).ImG = paramString4;
    ((vq)localObject).ImH = paramString5;
    ((vq)localObject).Inb = paramString6;
    ((vq)localObject).nickname = paramString7;
    ((vq)localObject).Imv = paramString8;
    Log.i("MicroMsg.NetSceneF2fDynamicCode", "amount: %s, username: %s, transfer_code_id: %s", new Object[] { Integer.valueOf(paramInt), paramString1, URLDecoder.decode(paramString3) });
    AppMethodBeat.o(67863);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67864);
    Log.i("MicroMsg.NetSceneF2fDynamicCode", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.IlM = ((vr)d.c.b(((d)params).lBS));
    Log.i("MicroMsg.NetSceneF2fDynamicCode", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.IlM.fwx), this.IlM.tVo });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67864);
  }
  
  public final void f(s params)
  {
    AppMethodBeat.i(256266);
    params = (vr)d.c.b(((d)params).lBS);
    this.YVy = params.fwx;
    this.YVz = params.tVo;
    AppMethodBeat.o(256266);
  }
  
  public final int getType()
  {
    return 2736;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.p
 * JD-Core Version:    0.7.0.1
 */