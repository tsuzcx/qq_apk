package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.agg;
import com.tencent.mm.protocal.protobuf.enl;
import com.tencent.mm.protocal.protobuf.enm;
import com.tencent.mm.protocal.protobuf.foe;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends p
  implements m
{
  private foe TIY;
  private h callback;
  public c rr;
  
  public e(foe paramfoe, List<String> paramList)
  {
    AppMethodBeat.i(91011);
    Log.i("MicroMsg.TopStory.NetSceneTopStoryGetVideoUrl", "Create NetSceneTopStoryGetVideoUrl Video");
    this.TIY = paramfoe;
    paramfoe = new c.a();
    paramfoe.funcId = getType();
    paramfoe.uri = "/cgi-bin/mmsearch-bin/recommendgetvideourl";
    paramfoe.otE = new enl();
    paramfoe.otF = new enm();
    this.rr = paramfoe.bEF();
    paramfoe = (enl)c.b.b(this.rr.otB);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      agg localagg = new agg();
      localagg.vYo = str;
      paramfoe.abrX.add(localagg);
    }
    AppMethodBeat.o(91011);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(91012);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(91012);
    return i;
  }
  
  public final int getType()
  {
    return 2579;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(91013);
    Log.i("MicroMsg.TopStory.NetSceneTopStoryGetVideoUrl", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(91013);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.e
 * JD-Core Version:    0.7.0.1
 */