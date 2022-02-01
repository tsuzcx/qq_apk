package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends q
  implements m
{
  public List<String> MWw;
  public List<Integer> MWx;
  private com.tencent.mm.an.i callback;
  private long fhq;
  public int lXi;
  private d rr;
  
  public i(i parami)
  {
    AppMethodBeat.i(91020);
    this.lXi = 0;
    Log.i("MicroMsg.TopStory.NetSceneTopStorySetBlockList", "copy NetSceneTopStorySetBlockList", new Object[] { Integer.valueOf(parami.MWw.size()), Integer.valueOf(parami.MWx.size()) });
    this.lXi = parami.lXi;
    C(parami.MWw, parami.MWx);
    AppMethodBeat.o(91020);
  }
  
  public i(List<String> paramList, List<Integer> paramList1)
  {
    AppMethodBeat.i(91021);
    this.lXi = 0;
    Log.i("MicroMsg.TopStory.NetSceneTopStorySetBlockList", "create NetSceneTopStorySetBlockList, users size:%s, type size:%s", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(paramList1.size()) });
    C(paramList, paramList1);
    AppMethodBeat.o(91021);
  }
  
  private void C(List<String> paramList, List<Integer> paramList1)
  {
    AppMethodBeat.i(91022);
    this.fhq = System.currentTimeMillis();
    this.MWw = paramList;
    this.MWx = paramList1;
    Object localObject = new d.a();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).uri = "/cgi-bin/mmsearch-bin/colikeblock";
    ((d.a)localObject).lBU = new abz();
    ((d.a)localObject).lBV = new acb();
    this.rr = ((d.a)localObject).bgN();
    localObject = (abz)d.b.b(this.rr.lBR);
    int i = 0;
    while (i < paramList.size())
    {
      aca localaca = new aca();
      localaca.fwq = ((Integer)paramList1.get(i)).intValue();
      localaca.Username = ((String)paramList.get(i));
      ((abz)localObject).RLp.add(localaca);
      i += 1;
    }
    AppMethodBeat.o(91022);
  }
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
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
  
  public final acb gpZ()
  {
    AppMethodBeat.i(191077);
    acb localacb = (acb)d.c.b(this.rr.lBS);
    AppMethodBeat.o(191077);
    return localacb;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(91024);
    Log.i("MicroMsg.TopStory.NetSceneTopStorySetBlockList", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.fhq) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(91024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.i
 * JD-Core Version:    0.7.0.1
 */