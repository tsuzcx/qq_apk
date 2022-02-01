package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aaa;
import com.tencent.mm.protocal.protobuf.zy;
import com.tencent.mm.protocal.protobuf.zz;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends n
  implements k
{
  private List<String> BrD;
  private List<Integer> BrE;
  private f callback;
  public int iiN;
  public b rr;
  private long soX;
  
  public i(i parami)
  {
    AppMethodBeat.i(91020);
    this.iiN = 0;
    ad.i("MicroMsg.TopStory.NetSceneTopStorySetBlockList", "copy NetSceneTopStorySetBlockList", new Object[] { Integer.valueOf(parami.BrD.size()), Integer.valueOf(parami.BrE.size()) });
    this.iiN = parami.iiN;
    C(parami.BrD, parami.BrE);
    AppMethodBeat.o(91020);
  }
  
  public i(List<String> paramList, List<Integer> paramList1)
  {
    AppMethodBeat.i(91021);
    this.iiN = 0;
    ad.i("MicroMsg.TopStory.NetSceneTopStorySetBlockList", "create NetSceneTopStorySetBlockList, users size:%s, type size:%s", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(paramList1.size()) });
    C(paramList, paramList1);
    AppMethodBeat.o(91021);
  }
  
  private void C(List<String> paramList, List<Integer> paramList1)
  {
    AppMethodBeat.i(91022);
    this.soX = System.currentTimeMillis();
    this.BrD = paramList;
    this.BrE = paramList1;
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/colikeblock";
    ((b.a)localObject).hNM = new zy();
    ((b.a)localObject).hNN = new aaa();
    this.rr = ((b.a)localObject).aDC();
    localObject = (zy)this.rr.hNK.hNQ;
    int i = 0;
    while (i < paramList.size())
    {
      zz localzz = new zz();
      localzz.dlq = ((Integer)paramList1.get(i)).intValue();
      localzz.Username = ((String)paramList.get(i));
      ((zy)localObject).Fys.add(localzz);
      i += 1;
    }
    AppMethodBeat.o(91022);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(91023);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(91023);
    return i;
  }
  
  public final int getType()
  {
    return 2859;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(91024);
    ad.i("MicroMsg.TopStory.NetSceneTopStorySetBlockList", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.soX) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(91024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.i
 * JD-Core Version:    0.7.0.1
 */