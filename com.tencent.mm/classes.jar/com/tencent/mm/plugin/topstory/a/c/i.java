package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aab;
import com.tencent.mm.protocal.protobuf.aac;
import com.tencent.mm.protocal.protobuf.aad;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends n
  implements k
{
  private List<String> BJc;
  private List<Integer> BJd;
  private f callback;
  public int ilG;
  public b rr;
  private long szi;
  
  public i(i parami)
  {
    AppMethodBeat.i(91020);
    this.ilG = 0;
    ae.i("MicroMsg.TopStory.NetSceneTopStorySetBlockList", "copy NetSceneTopStorySetBlockList", new Object[] { Integer.valueOf(parami.BJc.size()), Integer.valueOf(parami.BJd.size()) });
    this.ilG = parami.ilG;
    B(parami.BJc, parami.BJd);
    AppMethodBeat.o(91020);
  }
  
  public i(List<String> paramList, List<Integer> paramList1)
  {
    AppMethodBeat.i(91021);
    this.ilG = 0;
    ae.i("MicroMsg.TopStory.NetSceneTopStorySetBlockList", "create NetSceneTopStorySetBlockList, users size:%s, type size:%s", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(paramList1.size()) });
    B(paramList, paramList1);
    AppMethodBeat.o(91021);
  }
  
  private void B(List<String> paramList, List<Integer> paramList1)
  {
    AppMethodBeat.i(91022);
    this.szi = System.currentTimeMillis();
    this.BJc = paramList;
    this.BJd = paramList1;
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/colikeblock";
    ((b.a)localObject).hQF = new aab();
    ((b.a)localObject).hQG = new aad();
    this.rr = ((b.a)localObject).aDS();
    localObject = (aab)this.rr.hQD.hQJ;
    int i = 0;
    while (i < paramList.size())
    {
      aac localaac = new aac();
      localaac.dms = ((Integer)paramList1.get(i)).intValue();
      localaac.Username = ((String)paramList.get(i));
      ((aab)localObject).FQQ.add(localaac);
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
    ae.i("MicroMsg.TopStory.NetSceneTopStorySetBlockList", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.szi) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(91024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.i
 * JD-Core Version:    0.7.0.1
 */