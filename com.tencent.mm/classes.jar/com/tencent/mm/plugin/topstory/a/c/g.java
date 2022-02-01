package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aaa;
import com.tencent.mm.protocal.protobuf.aae;
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.sdk.platformtools.ae;

public final class g
  extends n
  implements k
{
  private f callback;
  public b rr;
  private long szi;
  
  public g(long paramLong, String paramString1, String paramString2, String paramString3, com.tencent.mm.pluginsdk.model.app.g paramg, String paramString4)
  {
    AppMethodBeat.i(91014);
    ae.i("MicroMsg.TopStory.NetSceneTopStoryPostHaokan", "Create NetSceneTopStoryPostVideo ts:%s, extInfo:%s, comment:%s, requestId:%s, appVersion:%s", new Object[] { Long.valueOf(paramLong), paramString1, paramString2, paramString3, paramString4 });
    this.szi = System.currentTimeMillis();
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/colikepost";
    ((b.a)localObject).hQF = new aae();
    ((b.a)localObject).hQG = new aaf();
    this.rr = ((b.a)localObject).aDS();
    localObject = (aae)this.rr.hQD.hQJ;
    ((aae)localObject).timestamp = paramLong;
    ((aae)localObject).Grz = paramString1;
    ((aae)localObject).FQf = paramString2;
    ((aae)localObject).dyb = paramString3;
    ((aae)localObject).GrA = new aaa();
    ((aae)localObject).GrA.appName = paramg.field_appName;
    ((aae)localObject).GrA.appId = paramg.field_appId;
    ((aae)localObject).GrA.version = paramString4;
    AppMethodBeat.o(91014);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(91015);
    this.callback = paramf;
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
    ae.i("MicroMsg.TopStory.NetSceneTopStoryPostHaokan", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.szi) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(91016);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.g
 * JD-Core Version:    0.7.0.1
 */