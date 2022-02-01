package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aed;
import com.tencent.mm.protocal.protobuf.aee;
import com.tencent.mm.protocal.protobuf.aef;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends p
  implements m
{
  public List<String> TJa;
  public List<Integer> TJb;
  private h callback;
  private long hlB;
  public int oQk;
  private c rr;
  
  public i(i parami)
  {
    AppMethodBeat.i(91020);
    this.oQk = 0;
    Log.i("MicroMsg.TopStory.NetSceneTopStorySetBlockList", "copy NetSceneTopStorySetBlockList", new Object[] { Integer.valueOf(parami.TJa.size()), Integer.valueOf(parami.TJb.size()) });
    this.oQk = parami.oQk;
    P(parami.TJa, parami.TJb);
    AppMethodBeat.o(91020);
  }
  
  public i(List<String> paramList, List<Integer> paramList1)
  {
    AppMethodBeat.i(91021);
    this.oQk = 0;
    Log.i("MicroMsg.TopStory.NetSceneTopStorySetBlockList", "create NetSceneTopStorySetBlockList, users size:%s, type size:%s", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(paramList1.size()) });
    P(paramList, paramList1);
    AppMethodBeat.o(91021);
  }
  
  private void P(List<String> paramList, List<Integer> paramList1)
  {
    AppMethodBeat.i(91022);
    this.hlB = System.currentTimeMillis();
    this.TJa = paramList;
    this.TJb = paramList1;
    Object localObject = new c.a();
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).uri = "/cgi-bin/mmsearch-bin/colikeblock";
    ((c.a)localObject).otE = new aed();
    ((c.a)localObject).otF = new aef();
    this.rr = ((c.a)localObject).bEF();
    localObject = (aed)c.b.b(this.rr.otB);
    int i = 0;
    while (i < paramList.size())
    {
      aee localaee = new aee();
      localaee.hAO = ((Integer)paramList1.get(i)).intValue();
      localaee.Username = ((String)paramList.get(i));
      ((aed)localObject).YIB.add(localaee);
      i += 1;
    }
    AppMethodBeat.o(91022);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(91023);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(91023);
    return i;
  }
  
  public final int getType()
  {
    return 2859;
  }
  
  public final aef hMV()
  {
    AppMethodBeat.i(271663);
    aef localaef = (aef)c.c.b(this.rr.otC);
    AppMethodBeat.o(271663);
    return localaef;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(91024);
    Log.i("MicroMsg.TopStory.NetSceneTopStorySetBlockList", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.hlB) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(91024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.i
 * JD-Core Version:    0.7.0.1
 */