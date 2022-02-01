package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.abe;
import com.tencent.mm.protocal.protobuf.crv;
import com.tencent.mm.protocal.protobuf.crw;
import com.tencent.mm.protocal.protobuf.doa;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends n
  implements k
{
  private doa BrB;
  private f callback;
  public b rr;
  
  public e(doa paramdoa, List<String> paramList)
  {
    AppMethodBeat.i(91011);
    ad.i("MicroMsg.TopStory.NetSceneTopStoryGetVideoUrl", "Create NetSceneTopStoryGetVideoUrl Video");
    this.BrB = paramdoa;
    paramdoa = new b.a();
    paramdoa.funcId = getType();
    paramdoa.uri = "/cgi-bin/mmsearch-bin/recommendgetvideourl";
    paramdoa.hNM = new crv();
    paramdoa.hNN = new crw();
    this.rr = paramdoa.aDC();
    paramdoa = (crv)this.rr.hNK.hNQ;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      abe localabe = new abe();
      localabe.orq = str;
      paramdoa.Hkp.add(localabe);
    }
    AppMethodBeat.o(91011);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(91012);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(91012);
    return i;
  }
  
  public final int getType()
  {
    return 2579;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(91013);
    ad.i("MicroMsg.TopStory.NetSceneTopStoryGetVideoUrl", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(91013);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.e
 * JD-Core Version:    0.7.0.1
 */