package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aab;
import com.tencent.mm.protocal.protobuf.aac;
import com.tencent.mm.protocal.protobuf.zx;
import com.tencent.mm.sdk.platformtools.ad;

public final class g
  extends n
  implements k
{
  private f callback;
  public b rr;
  private long soX;
  
  public g(long paramLong, String paramString1, String paramString2, String paramString3, com.tencent.mm.pluginsdk.model.app.g paramg, String paramString4)
  {
    AppMethodBeat.i(91014);
    ad.i("MicroMsg.TopStory.NetSceneTopStoryPostHaokan", "Create NetSceneTopStoryPostVideo ts:%s, extInfo:%s, comment:%s, requestId:%s, appVersion:%s", new Object[] { Long.valueOf(paramLong), paramString1, paramString2, paramString3, paramString4 });
    this.soX = System.currentTimeMillis();
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/colikepost";
    ((b.a)localObject).hNM = new aab();
    ((b.a)localObject).hNN = new aac();
    this.rr = ((b.a)localObject).aDC();
    localObject = (aab)this.rr.hNK.hNQ;
    ((aab)localObject).timestamp = paramLong;
    ((aab)localObject).FYZ = paramString1;
    ((aab)localObject).FxH = paramString2;
    ((aab)localObject).dwW = paramString3;
    ((aab)localObject).FZa = new zx();
    ((aab)localObject).FZa.appName = paramg.field_appName;
    ((aab)localObject).FZa.appId = paramg.field_appId;
    ((aab)localObject).FZa.version = paramString4;
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
    ad.i("MicroMsg.TopStory.NetSceneTopStoryPostHaokan", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.soX) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(91016);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.g
 * JD-Core Version:    0.7.0.1
 */