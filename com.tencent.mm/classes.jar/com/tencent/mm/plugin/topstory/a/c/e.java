package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cms;
import com.tencent.mm.protocal.protobuf.cmt;
import com.tencent.mm.protocal.protobuf.dil;
import com.tencent.mm.protocal.protobuf.ze;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends n
  implements k
{
  private g callback;
  public b rr;
  private dil zZP;
  
  public e(dil paramdil, List<String> paramList)
  {
    AppMethodBeat.i(91011);
    ac.i("MicroMsg.TopStory.NetSceneTopStoryGetVideoUrl", "Create NetSceneTopStoryGetVideoUrl Video");
    this.zZP = paramdil;
    paramdil = new b.a();
    paramdil.funcId = getType();
    paramdil.uri = "/cgi-bin/mmsearch-bin/recommendgetvideourl";
    paramdil.hvt = new cms();
    paramdil.hvu = new cmt();
    this.rr = paramdil.aAz();
    paramdil = (cms)this.rr.hvr.hvw;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      ze localze = new ze();
      localze.nOK = str;
      paramdil.FAb.add(localze);
    }
    AppMethodBeat.o(91011);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(91012);
    this.callback = paramg;
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
    ac.i("MicroMsg.TopStory.NetSceneTopStoryGetVideoUrl", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(91013);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.e
 * JD-Core Version:    0.7.0.1
 */