package com.tencent.mm.plugin.topstory.a.c;

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

public final class a
  extends p
  implements m
{
  private h callback;
  public String hOG;
  private long hlB;
  private c rr;
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(88477);
    this.hlB = System.currentTimeMillis();
    Object localObject = new c.a();
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).uri = "/cgi-bin/mmsearch-bin/searchwebcomm";
    ((c.a)localObject).otE = new ghf();
    ((c.a)localObject).otF = new ghg();
    this.rr = ((c.a)localObject).bEF();
    localObject = (ghf)c.b.b(this.rr.otB);
    ((ghf)localObject).acdr = paramString2;
    ((ghf)localObject).hOG = paramString1;
    this.hOG = paramString1;
    AppMethodBeat.o(88477);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(88478);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(88478);
    return i;
  }
  
  public final int getType()
  {
    return 2582;
  }
  
  public final ghg hMP()
  {
    AppMethodBeat.i(271670);
    ghg localghg = (ghg)c.c.b(this.rr.otC);
    AppMethodBeat.o(271670);
    return localghg;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88479);
    Log.i("MicroMsg.TopStory.NetSceneSearchWebComm", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.hlB) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(88479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.a
 * JD-Core Version:    0.7.0.1
 */