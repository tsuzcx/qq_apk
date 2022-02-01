package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.avo;
import com.tencent.mm.protocal.protobuf.avp;
import com.tencent.mm.sdk.platformtools.ac;

public final class c
  extends n
  implements k
{
  private g callback;
  private b rr;
  private long rxC;
  private int type;
  
  public c(int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(91008);
    this.type = paramInt1;
    this.rxC = System.currentTimeMillis();
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/getcolikeblocklist";
    ((b.a)localObject).hvt = new avo();
    ((b.a)localObject).hvu = new avp();
    this.rr = ((b.a)localObject).aAz();
    localObject = (avo)this.rr.hvr.hvw;
    ((avo)localObject).ndI = paramInt1;
    ((avo)localObject).ELn = paramLong;
    ((avo)localObject).EfV = paramInt2;
    ac.i("MicroMsg.TopStory.NetSceneTopStoryGetBlockList", "request NetSceneTopStoryGetBlockList: %d %d %d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(91008);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(91009);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(91009);
    return i;
  }
  
  public final avp ecE()
  {
    return (avp)this.rr.hvs.hvw;
  }
  
  public final int getType()
  {
    return 2748;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(91010);
    ac.i("MicroMsg.TopStory.NetSceneTopStoryGetBlockList", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.rxC) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(91010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.c
 * JD-Core Version:    0.7.0.1
 */