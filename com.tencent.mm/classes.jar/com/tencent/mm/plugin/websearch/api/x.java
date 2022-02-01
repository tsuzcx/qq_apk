package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ghf;
import com.tencent.mm.protocal.protobuf.ghg;
import com.tencent.mm.sdk.platformtools.Log;

public final class x
  extends p
  implements m
{
  private h callback;
  public String hOG;
  public int hVk;
  private long hlB;
  private c rr;
  
  public x(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(117624);
    this.hVk = paramInt;
    this.hlB = System.currentTimeMillis();
    Object localObject = new c.a();
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).uri = "/cgi-bin/mmsearch-bin/searchwebquery";
    ((c.a)localObject).otE = new ghf();
    ((c.a)localObject).otF = new ghg();
    this.rr = ((c.a)localObject).bEF();
    localObject = (ghf)c.b.b(this.rr.otB);
    ((ghf)localObject).acdr = paramString2;
    ((ghf)localObject).hOG = paramString1;
    this.hOG = paramString1;
    AppMethodBeat.o(117624);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(117625);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(117625);
    return i;
  }
  
  public final int getType()
  {
    return 2975;
  }
  
  public final ghg hMP()
  {
    AppMethodBeat.i(315366);
    ghg localghg = (ghg)c.c.b(this.rr.otC);
    AppMethodBeat.o(315366);
    return localghg;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117626);
    Log.i("MicroMsg.WebSearch.NetSceneSearchWebQuery", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.hlB) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(117626);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.x
 * JD-Core Version:    0.7.0.1
 */