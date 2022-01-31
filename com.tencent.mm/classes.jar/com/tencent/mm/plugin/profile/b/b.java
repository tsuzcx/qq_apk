package com.tencent.mm.plugin.profile.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.asm;
import com.tencent.mm.protocal.protobuf.asn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;

public final class b
  extends m
  implements k
{
  private f callback;
  public String pxO;
  private final com.tencent.mm.ai.b rr;
  
  public b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(23284);
    this.pxO = paramString1;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new asm();
    ((b.a)localObject).fsY = new asn();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getwburl";
    ((b.a)localObject).funcId = 205;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (asm)this.rr.fsV.fta;
    ((asm)localObject).jJA = paramString2;
    aw.aaz();
    paramString2 = bo.nullAsNil((String)c.Ru().get(46, null));
    ((asm)localObject).wrT = new SKBuiltinBuffer_t().setBuffer(bo.apQ(paramString2));
    aw.aaz();
    String str = bo.nullAsNil((String)c.Ru().get(72, null));
    ((asm)localObject).wYg = new SKBuiltinBuffer_t().setBuffer(bo.apQ(str));
    ab.d("MicroMsg.NetSceneGetWeiboURL", "dkwt get weibo url with id=" + paramString1 + ", a2=" + paramString2 + " , newa2:" + str);
    AppMethodBeat.o(23284);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(23285);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(23285);
    return i;
  }
  
  public final int getType()
  {
    return 205;
  }
  
  public final String getURL()
  {
    return ((asn)this.rr.fsW.fta).URL;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23286);
    ab.d("MicroMsg.NetSceneGetWeiboURL", "dkwt onGYNetEnd:[%d,%d] get weibo url result:[%s] ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), getURL() });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23286);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.b.b
 * JD-Core Version:    0.7.0.1
 */