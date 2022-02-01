package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.abr;
import com.tencent.mm.protocal.protobuf.abv;
import com.tencent.mm.protocal.protobuf.abw;
import com.tencent.mm.sdk.platformtools.Log;

public final class g
  extends q
  implements m
{
  private i callback;
  public d rr;
  private long uOV;
  
  public g(long paramLong, String paramString1, String paramString2, String paramString3, com.tencent.mm.pluginsdk.model.app.g paramg, String paramString4)
  {
    AppMethodBeat.i(91014);
    Log.i("MicroMsg.TopStory.NetSceneTopStoryPostHaokan", "Create NetSceneTopStoryPostVideo ts:%s, extInfo:%s, comment:%s, requestId:%s, appVersion:%s", new Object[] { Long.valueOf(paramLong), paramString1, paramString2, paramString3, paramString4 });
    this.uOV = System.currentTimeMillis();
    Object localObject = new d.a();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).uri = "/cgi-bin/mmsearch-bin/colikepost";
    ((d.a)localObject).iLN = new abv();
    ((d.a)localObject).iLO = new abw();
    this.rr = ((d.a)localObject).aXF();
    localObject = (abv)this.rr.iLK.iLR;
    ((abv)localObject).timestamp = paramLong;
    ((abv)localObject).Lmx = paramString1;
    ((abv)localObject).KJM = paramString2;
    ((abv)localObject).dPI = paramString3;
    ((abv)localObject).Lmy = new abr();
    ((abv)localObject).Lmy.appName = paramg.field_appName;
    ((abv)localObject).Lmy.appId = paramg.field_appId;
    ((abv)localObject).Lmy.version = paramString4;
    AppMethodBeat.o(91014);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(91015);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(91015);
    return i;
  }
  
  public final int getType()
  {
    return 2534;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(91016);
    Log.i("MicroMsg.TopStory.NetSceneTopStoryPostHaokan", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.uOV) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(91016);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.g
 * JD-Core Version:    0.7.0.1
 */