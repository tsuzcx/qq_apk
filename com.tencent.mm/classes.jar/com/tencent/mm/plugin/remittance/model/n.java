package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.uf;
import com.tencent.mm.protocal.protobuf.ug;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.r;
import java.net.URLDecoder;

public final class n
  extends r
{
  private final String TAG;
  public ug xYc;
  
  public n(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(67863);
    this.TAG = "MicroMsg.NetSceneF2fDynamicCode";
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new uf();
    ((b.a)localObject).hNN = new ug();
    ((b.a)localObject).funcId = 2736;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/f2fdynamiccode";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (uf)this.rr.hNK.hNQ;
    ((uf)localObject).vls = paramInt;
    ((uf)localObject).oBW = paramString1;
    ((uf)localObject).xZb = paramString2;
    ((uf)localObject).FTz = URLDecoder.decode(paramString3);
    ((uf)localObject).xYJ = paramString4;
    ((uf)localObject).xYK = paramString5;
    ((uf)localObject).xZe = paramString6;
    ((uf)localObject).nickname = paramString7;
    ((uf)localObject).xYy = paramString8;
    ad.i("MicroMsg.NetSceneF2fDynamicCode", "amount: %s, username: %s, transfer_code_id: %s", new Object[] { Integer.valueOf(paramInt), paramString1, URLDecoder.decode(paramString3) });
    AppMethodBeat.o(67863);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67864);
    ad.i("MicroMsg.NetSceneF2fDynamicCode", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.xYc = ((ug)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneF2fDynamicCode", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.xYc.dlw), this.xYc.paA });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67864);
  }
  
  public final void e(q paramq)
  {
    paramq = (ug)((b)paramq).hNL.hNQ;
    this.Lyu = paramq.dlw;
    this.Lyv = paramq.paA;
  }
  
  public final int getType()
  {
    return 2736;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.n
 * JD-Core Version:    0.7.0.1
 */