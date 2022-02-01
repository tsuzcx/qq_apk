package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.blm;
import com.tencent.mm.protocal.protobuf.bln;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends q
  implements m
{
  private i callback;
  private d rr;
  private int type;
  private long uOV;
  
  public c(int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(91008);
    this.type = paramInt1;
    this.uOV = System.currentTimeMillis();
    Object localObject = new d.a();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).uri = "/cgi-bin/mmsearch-bin/getcolikeblocklist";
    ((d.a)localObject).iLN = new blm();
    ((d.a)localObject).iLO = new bln();
    this.rr = ((d.a)localObject).aXF();
    localObject = (blm)this.rr.iLK.iLR;
    ((blm)localObject).oUv = paramInt1;
    ((blm)localObject).LRV = paramLong;
    ((blm)localObject).KZk = paramInt2;
    Log.i("MicroMsg.TopStory.NetSceneTopStoryGetBlockList", "request NetSceneTopStoryGetBlockList: %d %d %d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(91008);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(91009);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(91009);
    return i;
  }
  
  public final bln fya()
  {
    return (bln)this.rr.iLL.iLR;
  }
  
  public final int getType()
  {
    return 2748;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(91010);
    Log.i("MicroMsg.TopStory.NetSceneTopStoryGetBlockList", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.uOV) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(91010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.c
 * JD-Core Version:    0.7.0.1
 */