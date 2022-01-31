package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.uh;
import com.tencent.mm.protocal.protobuf.ui;
import com.tencent.mm.protocal.protobuf.uj;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.List;

public final class h
  extends m
  implements k
{
  private f callback;
  public int fMl;
  public b rr;
  private long tfo;
  private List<String> tfq;
  private List<Integer> tfr;
  
  public h(h paramh)
  {
    AppMethodBeat.i(96395);
    this.fMl = 0;
    ab.i("MicroMsg.TopStory.NetSceneTopStorySetBlockList", "copy NetSceneTopStorySetBlockList", new Object[] { Integer.valueOf(paramh.tfq.size()), Integer.valueOf(paramh.tfr.size()) });
    this.fMl = paramh.fMl;
    q(paramh.tfq, paramh.tfr);
    AppMethodBeat.o(96395);
  }
  
  public h(List<String> paramList, List<Integer> paramList1)
  {
    AppMethodBeat.i(96396);
    this.fMl = 0;
    ab.i("MicroMsg.TopStory.NetSceneTopStorySetBlockList", "create NetSceneTopStorySetBlockList, users size:%s, type size:%s", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(paramList1.size()) });
    q(paramList, paramList1);
    AppMethodBeat.o(96396);
  }
  
  private void q(List<String> paramList, List<Integer> paramList1)
  {
    AppMethodBeat.i(96397);
    this.tfo = System.currentTimeMillis();
    this.tfq = paramList;
    this.tfr = paramList1;
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/colikeblock";
    ((b.a)localObject).fsX = new uh();
    ((b.a)localObject).fsY = new uj();
    this.rr = ((b.a)localObject).ado();
    localObject = (uh)this.rr.fsV.fta;
    int i = 0;
    while (i < paramList.size())
    {
      ui localui = new ui();
      localui.cnE = ((Integer)paramList1.get(i)).intValue();
      localui.Username = ((String)paramList.get(i));
      ((uh)localObject).wrp.add(localui);
      i += 1;
    }
    AppMethodBeat.o(96397);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(96398);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(96398);
    return i;
  }
  
  public final int getType()
  {
    return 2859;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(96399);
    ab.i("MicroMsg.TopStory.NetSceneTopStorySetBlockList", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.tfo) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(96399);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.h
 * JD-Core Version:    0.7.0.1
 */