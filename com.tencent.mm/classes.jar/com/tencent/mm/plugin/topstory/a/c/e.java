package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.protocal.protobuf.csq;
import com.tencent.mm.protocal.protobuf.dox;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends n
  implements k
{
  private dox BJa;
  private f callback;
  public b rr;
  
  public e(dox paramdox, List<String> paramList)
  {
    AppMethodBeat.i(91011);
    ae.i("MicroMsg.TopStory.NetSceneTopStoryGetVideoUrl", "Create NetSceneTopStoryGetVideoUrl Video");
    this.BJa = paramdox;
    paramdox = new b.a();
    paramdox.funcId = getType();
    paramdox.uri = "/cgi-bin/mmsearch-bin/recommendgetvideourl";
    paramdox.hQF = new csp();
    paramdox.hQG = new csq();
    this.rr = paramdox.aDS();
    paramdox = (csp)this.rr.hQD.hQJ;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      abn localabn = new abn();
      localabn.oxM = str;
      paramdox.HDP.add(localabn);
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
    ae.i("MicroMsg.TopStory.NetSceneTopStoryGetVideoUrl", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(91013);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.e
 * JD-Core Version:    0.7.0.1
 */