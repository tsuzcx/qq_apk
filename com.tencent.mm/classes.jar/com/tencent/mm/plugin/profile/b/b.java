package com.tencent.mm.plugin.profile.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bmb;
import com.tencent.mm.protocal.protobuf.bmc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;

public final class b
  extends n
  implements k
{
  private f callback;
  private final com.tencent.mm.ak.b rr;
  public String xfp;
  
  public b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(26904);
    this.xfp = paramString1;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bmb();
    ((b.a)localObject).hQG = new bmc();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getwburl";
    ((b.a)localObject).funcId = 205;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (bmb)this.rr.hQD.hQJ;
    ((bmb)localObject).nIJ = paramString2;
    bc.aCg();
    paramString2 = bu.nullAsNil((String)c.ajA().get(46, null));
    ((bmb)localObject).FRA = new SKBuiltinBuffer_t().setBuffer(bu.aSx(paramString2));
    bc.aCg();
    String str = bu.nullAsNil((String)c.ajA().get(72, null));
    ((bmb)localObject).GNw = new SKBuiltinBuffer_t().setBuffer(bu.aSx(str));
    ae.d("MicroMsg.NetSceneGetWeiboURL", "dkwt get weibo url with id=" + paramString1 + ", a2=" + paramString2 + " , newa2:" + str);
    AppMethodBeat.o(26904);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(26905);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(26905);
    return i;
  }
  
  public final int getType()
  {
    return 205;
  }
  
  public final String getURL()
  {
    return ((bmc)this.rr.hQE.hQJ).URL;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26906);
    ae.d("MicroMsg.NetSceneGetWeiboURL", "dkwt onGYNetEnd:[%d,%d] get weibo url result:[%s] ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), getURL() });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.b.b
 * JD-Core Version:    0.7.0.1
 */