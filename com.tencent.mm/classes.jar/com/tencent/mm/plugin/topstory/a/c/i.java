package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.abs;
import com.tencent.mm.protocal.protobuf.abt;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends q
  implements m
{
  private List<String> GjL;
  private List<Integer> GjM;
  private com.tencent.mm.ak.i callback;
  public int jgF;
  public d rr;
  private long uOV;
  
  public i(i parami)
  {
    AppMethodBeat.i(91020);
    this.jgF = 0;
    Log.i("MicroMsg.TopStory.NetSceneTopStorySetBlockList", "copy NetSceneTopStorySetBlockList", new Object[] { Integer.valueOf(parami.GjL.size()), Integer.valueOf(parami.GjM.size()) });
    this.jgF = parami.jgF;
    x(parami.GjL, parami.GjM);
    AppMethodBeat.o(91020);
  }
  
  public i(List<String> paramList, List<Integer> paramList1)
  {
    AppMethodBeat.i(91021);
    this.jgF = 0;
    Log.i("MicroMsg.TopStory.NetSceneTopStorySetBlockList", "create NetSceneTopStorySetBlockList, users size:%s, type size:%s", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(paramList1.size()) });
    x(paramList, paramList1);
    AppMethodBeat.o(91021);
  }
  
  private void x(List<String> paramList, List<Integer> paramList1)
  {
    AppMethodBeat.i(91022);
    this.uOV = System.currentTimeMillis();
    this.GjL = paramList;
    this.GjM = paramList1;
    Object localObject = new d.a();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).uri = "/cgi-bin/mmsearch-bin/colikeblock";
    ((d.a)localObject).iLN = new abs();
    ((d.a)localObject).iLO = new abu();
    this.rr = ((d.a)localObject).aXF();
    localObject = (abs)this.rr.iLK.iLR;
    int i = 0;
    while (i < paramList.size())
    {
      abt localabt = new abt();
      localabt.dDH = ((Integer)paramList1.get(i)).intValue();
      localabt.Username = ((String)paramList.get(i));
      ((abs)localObject).KKx.add(localabt);
      i += 1;
    }
    AppMethodBeat.o(91022);
  }
  
  public final int doScene(g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(91023);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(91023);
    return i;
  }
  
  public final int getType()
  {
    return 2859;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(91024);
    Log.i("MicroMsg.TopStory.NetSceneTopStorySetBlockList", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.uOV) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(91024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.i
 * JD-Core Version:    0.7.0.1
 */