package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bad;
import com.tencent.mm.sdk.platformtools.ae;

public final class c
  extends n
  implements k
{
  private f callback;
  private b rr;
  private long szi;
  private int type;
  
  public c(int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(91008);
    this.type = paramInt1;
    this.szi = System.currentTimeMillis();
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/getcolikeblocklist";
    ((b.a)localObject).hQF = new bac();
    ((b.a)localObject).hQG = new bad();
    this.rr = ((b.a)localObject).aDS();
    localObject = (bac)this.rr.hQD.hQJ;
    ((bac)localObject).nJA = paramInt1;
    ((bac)localObject).GNP = paramLong;
    ((bac)localObject).GeT = paramInt2;
    ae.i("MicroMsg.TopStory.NetSceneTopStoryGetBlockList", "request NetSceneTopStoryGetBlockList: %d %d %d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(91008);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(91009);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(91009);
    return i;
  }
  
  public final bad esC()
  {
    return (bad)this.rr.hQE.hQJ;
  }
  
  public final int getType()
  {
    return 2748;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(91010);
    ae.i("MicroMsg.TopStory.NetSceneTopStoryGetBlockList", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.szi) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(91010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.c
 * JD-Core Version:    0.7.0.1
 */