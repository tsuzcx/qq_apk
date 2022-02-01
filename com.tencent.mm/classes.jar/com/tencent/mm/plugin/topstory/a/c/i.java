package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.xz;
import com.tencent.mm.protocal.protobuf.ya;
import com.tencent.mm.protocal.protobuf.yb;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends n
  implements k
{
  private g callback;
  public int hPz;
  public b rr;
  private long rxC;
  private List<String> zZR;
  private List<Integer> zZS;
  
  public i(i parami)
  {
    AppMethodBeat.i(91020);
    this.hPz = 0;
    ac.i("MicroMsg.TopStory.NetSceneTopStorySetBlockList", "copy NetSceneTopStorySetBlockList", new Object[] { Integer.valueOf(parami.zZR.size()), Integer.valueOf(parami.zZS.size()) });
    this.hPz = parami.hPz;
    B(parami.zZR, parami.zZS);
    AppMethodBeat.o(91020);
  }
  
  public i(List<String> paramList, List<Integer> paramList1)
  {
    AppMethodBeat.i(91021);
    this.hPz = 0;
    ac.i("MicroMsg.TopStory.NetSceneTopStorySetBlockList", "create NetSceneTopStorySetBlockList, users size:%s, type size:%s", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(paramList1.size()) });
    B(paramList, paramList1);
    AppMethodBeat.o(91021);
  }
  
  private void B(List<String> paramList, List<Integer> paramList1)
  {
    AppMethodBeat.i(91022);
    this.rxC = System.currentTimeMillis();
    this.zZR = paramList;
    this.zZS = paramList1;
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/colikeblock";
    ((b.a)localObject).hvt = new xz();
    ((b.a)localObject).hvu = new yb();
    this.rr = ((b.a)localObject).aAz();
    localObject = (xz)this.rr.hvr.hvw;
    int i = 0;
    while (i < paramList.size())
    {
      ya localya = new ya();
      localya.cZY = ((Integer)paramList1.get(i)).intValue();
      localya.Username = ((String)paramList.get(i));
      ((xz)localObject).DSZ.add(localya);
      i += 1;
    }
    AppMethodBeat.o(91022);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(91023);
    this.callback = paramg;
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
    ac.i("MicroMsg.TopStory.NetSceneTopStorySetBlockList", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.rxC) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(91024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.i
 * JD-Core Version:    0.7.0.1
 */