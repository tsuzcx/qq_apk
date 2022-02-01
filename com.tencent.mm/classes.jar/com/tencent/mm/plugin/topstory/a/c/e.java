package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ado;
import com.tencent.mm.protocal.protobuf.dkx;
import com.tencent.mm.protocal.protobuf.dky;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends q
  implements m
{
  private eit GjJ;
  private i callback;
  public d rr;
  
  public e(eit parameit, List<String> paramList)
  {
    AppMethodBeat.i(91011);
    Log.i("MicroMsg.TopStory.NetSceneTopStoryGetVideoUrl", "Create NetSceneTopStoryGetVideoUrl Video");
    this.GjJ = parameit;
    parameit = new d.a();
    parameit.funcId = getType();
    parameit.uri = "/cgi-bin/mmsearch-bin/recommendgetvideourl";
    parameit.iLN = new dkx();
    parameit.iLO = new dky();
    this.rr = parameit.aXF();
    parameit = (dkx)this.rr.iLK.iLR;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      ado localado = new ado();
      localado.pLq = str;
      parameit.MOR.add(localado);
    }
    AppMethodBeat.o(91011);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(91012);
    this.callback = parami;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.e
 * JD-Core Version:    0.7.0.1
 */