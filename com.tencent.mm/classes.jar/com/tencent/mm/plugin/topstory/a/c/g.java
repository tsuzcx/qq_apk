package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.xy;
import com.tencent.mm.protocal.protobuf.yc;
import com.tencent.mm.protocal.protobuf.yd;
import com.tencent.mm.sdk.platformtools.ac;

public final class g
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  public b rr;
  private long rxC;
  
  public g(long paramLong, String paramString1, String paramString2, String paramString3, com.tencent.mm.pluginsdk.model.app.g paramg, String paramString4)
  {
    AppMethodBeat.i(91014);
    ac.i("MicroMsg.TopStory.NetSceneTopStoryPostHaokan", "Create NetSceneTopStoryPostVideo ts:%s, extInfo:%s, comment:%s, requestId:%s, appVersion:%s", new Object[] { Long.valueOf(paramLong), paramString1, paramString2, paramString3, paramString4 });
    this.rxC = System.currentTimeMillis();
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/colikepost";
    ((b.a)localObject).hvt = new yc();
    ((b.a)localObject).hvu = new yd();
    this.rr = ((b.a)localObject).aAz();
    localObject = (yc)this.rr.hvr.hvw;
    ((yc)localObject).timestamp = paramLong;
    ((yc)localObject).ErQ = paramString1;
    ((yc)localObject).DSo = paramString2;
    ((yc)localObject).dlj = paramString3;
    ((yc)localObject).ErR = new xy();
    ((yc)localObject).ErR.appName = paramg.field_appName;
    ((yc)localObject).ErR.appId = paramg.field_appId;
    ((yc)localObject).ErR.version = paramString4;
    AppMethodBeat.o(91014);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(91015);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(91015);
    return i;
  }
  
  public final int getType()
  {
    return 2534;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(91016);
    ac.i("MicroMsg.TopStory.NetSceneTopStoryPostHaokan", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.rxC) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(91016);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.g
 * JD-Core Version:    0.7.0.1
 */