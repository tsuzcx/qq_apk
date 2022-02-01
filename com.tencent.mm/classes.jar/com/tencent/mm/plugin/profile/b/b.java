package com.tencent.mm.plugin.profile.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.blj;
import com.tencent.mm.protocal.protobuf.blk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;

public final class b
  extends n
  implements k
{
  private f callback;
  private final com.tencent.mm.al.b rr;
  public String wPy;
  
  public b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(26904);
    this.wPy = paramString1;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new blj();
    ((b.a)localObject).hNN = new blk();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getwburl";
    ((b.a)localObject).funcId = 205;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (blj)this.rr.hNK.hNQ;
    ((blj)localObject).nDo = paramString2;
    ba.aBQ();
    paramString2 = bt.nullAsNil((String)c.ajl().get(46, null));
    ((blj)localObject).Fzc = new SKBuiltinBuffer_t().setBuffer(bt.aRa(paramString2));
    ba.aBQ();
    String str = bt.nullAsNil((String)c.ajl().get(72, null));
    ((blj)localObject).GtX = new SKBuiltinBuffer_t().setBuffer(bt.aRa(str));
    ad.d("MicroMsg.NetSceneGetWeiboURL", "dkwt get weibo url with id=" + paramString1 + ", a2=" + paramString2 + " , newa2:" + str);
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
    return ((blk)this.rr.hNL.hNQ).URL;
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