package com.tencent.mm.plugin.profile.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bdj;
import com.tencent.mm.protocal.protobuf.bdk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;

public final class b
  extends n
  implements k
{
  private g callback;
  private final com.tencent.mm.al.b rr;
  public String uzy;
  
  public b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(26904);
    this.uzy = paramString1;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new bdj();
    ((b.a)localObject).gUV = new bdk();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getwburl";
    ((b.a)localObject).funcId = 205;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (bdj)this.rr.gUS.gUX;
    ((bdj)localObject).mAQ = paramString2;
    az.arV();
    paramString2 = bt.nullAsNil((String)c.afk().get(46, null));
    ((bdj)localObject).CBk = new SKBuiltinBuffer_t().setBuffer(bt.aGd(paramString2));
    az.arV();
    String str = bt.nullAsNil((String)c.afk().get(72, null));
    ((bdj)localObject).DpR = new SKBuiltinBuffer_t().setBuffer(bt.aGd(str));
    ad.d("MicroMsg.NetSceneGetWeiboURL", "dkwt get weibo url with id=" + paramString1 + ", a2=" + paramString2 + " , newa2:" + str);
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
    return ((bdk)this.rr.gUT.gUX).URL;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26906);
    ad.d("MicroMsg.NetSceneGetWeiboURL", "dkwt onGYNetEnd:[%d,%d] get weibo url result:[%s] ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), getURL() });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.b.b
 * JD-Core Version:    0.7.0.1
 */