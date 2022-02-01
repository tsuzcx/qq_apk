package com.tencent.mm.plugin.profile.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bhb;
import com.tencent.mm.protocal.protobuf.bhc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;

public final class b
  extends n
  implements k
{
  private g callback;
  private final com.tencent.mm.ak.b rr;
  public String vIr;
  
  public b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(26904);
    this.vIr = paramString1;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bhb();
    ((b.a)localObject).hvu = new bhc();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getwburl";
    ((b.a)localObject).funcId = 205;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (bhb)this.rr.hvr.hvw;
    ((bhb)localObject).ncR = paramString2;
    az.ayM();
    paramString2 = bs.nullAsNil((String)c.agA().get(46, null));
    ((bhb)localObject).DTI = new SKBuiltinBuffer_t().setBuffer(bs.aLu(paramString2));
    az.ayM();
    String str = bs.nullAsNil((String)c.agA().get(72, null));
    ((bhb)localObject).EKU = new SKBuiltinBuffer_t().setBuffer(bs.aLu(str));
    ac.d("MicroMsg.NetSceneGetWeiboURL", "dkwt get weibo url with id=" + paramString1 + ", a2=" + paramString2 + " , newa2:" + str);
    AppMethodBeat.o(26904);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(26905);
    this.callback = paramg;
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
    return ((bhc)this.rr.hvs.hvw).URL;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26906);
    ac.d("MicroMsg.NetSceneGetWeiboURL", "dkwt onGYNetEnd:[%d,%d] get weibo url result:[%s] ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), getURL() });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.b.b
 * JD-Core Version:    0.7.0.1
 */