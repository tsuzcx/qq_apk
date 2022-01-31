package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ug;
import com.tencent.mm.protocal.protobuf.uk;
import com.tencent.mm.protocal.protobuf.ul;
import com.tencent.mm.sdk.platformtools.ab;

public final class g
  extends m
  implements k
{
  private com.tencent.mm.ai.f callback;
  public b rr;
  private long tfo;
  
  public g(long paramLong, String paramString1, String paramString2, String paramString3, com.tencent.mm.pluginsdk.model.app.f paramf, String paramString4)
  {
    AppMethodBeat.i(152190);
    ab.i("MicroMsg.TopStory.NetSceneTopStoryPostHaokan", "Create NetSceneTopStoryPostVideo ts:%s, extInfo:%s, comment:%s, requestId:%s, appVersion:%s", new Object[] { Long.valueOf(paramLong), paramString1, paramString2, paramString3, paramString4 });
    this.tfo = System.currentTimeMillis();
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/colikepost";
    ((b.a)localObject).fsX = new uk();
    ((b.a)localObject).fsY = new ul();
    this.rr = ((b.a)localObject).ado();
    localObject = (uk)this.rr.fsV.fta;
    ((uk)localObject).timestamp = paramLong;
    ((uk)localObject).wMH = paramString1;
    ((uk)localObject).wqH = paramString2;
    ((uk)localObject).ohe = paramString3;
    ((uk)localObject).wMI = new ug();
    ((uk)localObject).wMI.appName = paramf.field_appName;
    ((uk)localObject).wMI.appId = paramf.field_appId;
    ((uk)localObject).wMI.version = paramString4;
    AppMethodBeat.o(152190);
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(152191);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(152191);
    return i;
  }
  
  public final int getType()
  {
    return 2534;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(152192);
    ab.i("MicroMsg.TopStory.NetSceneTopStoryPostHaokan", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.tfo) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(152192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.g
 * JD-Core Version:    0.7.0.1
 */