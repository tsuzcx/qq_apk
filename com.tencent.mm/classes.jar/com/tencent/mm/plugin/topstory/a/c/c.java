package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cho;
import com.tencent.mm.protocal.protobuf.chp;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends p
  implements m
{
  private h callback;
  private long hlB;
  private com.tencent.mm.am.c rr;
  private int type;
  
  public c(int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(91008);
    this.type = paramInt1;
    this.hlB = System.currentTimeMillis();
    Object localObject = new c.a();
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).uri = "/cgi-bin/mmsearch-bin/getcolikeblocklist";
    ((c.a)localObject).otE = new cho();
    ((c.a)localObject).otF = new chp();
    this.rr = ((c.a)localObject).bEF();
    localObject = (cho)c.b.b(this.rr.otB);
    ((cho)localObject).vhJ = paramInt1;
    ((cho)localObject).aanC = paramLong;
    ((cho)localObject).YYs = paramInt2;
    Log.i("MicroMsg.TopStory.NetSceneTopStoryGetBlockList", "request NetSceneTopStoryGetBlockList: %d %d %d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(91008);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(91009);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(91009);
    return i;
  }
  
  public final int getType()
  {
    return 2748;
  }
  
  public final chp hMR()
  {
    AppMethodBeat.i(271656);
    chp localchp = (chp)c.c.b(this.rr.otC);
    AppMethodBeat.o(271656);
    return localchp;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(91010);
    Log.i("MicroMsg.TopStory.NetSceneTopStoryGetBlockList", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.hlB) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(91010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.c
 * JD-Core Version:    0.7.0.1
 */