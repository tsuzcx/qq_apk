package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.fkr;
import com.tencent.mm.protocal.protobuf.fks;
import com.tencent.mm.sdk.platformtools.Log;

public final class w
  extends q
  implements m
{
  private i callback;
  public String fIY;
  public int fPp;
  private long fhq;
  private d rr;
  
  public w(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(117624);
    this.fPp = paramInt;
    this.fhq = System.currentTimeMillis();
    Object localObject = new d.a();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).uri = "/cgi-bin/mmsearch-bin/searchwebquery";
    ((d.a)localObject).lBU = new fkr();
    ((d.a)localObject).lBV = new fks();
    this.rr = ((d.a)localObject).bgN();
    localObject = (fkr)d.b.b(this.rr.lBR);
    ((fkr)localObject).UJj = paramString2;
    ((fkr)localObject).fIY = paramString1;
    this.fIY = paramString1;
    AppMethodBeat.o(117624);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(117625);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(117625);
    return i;
  }
  
  public final String gQA()
  {
    return this.fIY;
  }
  
  public final int gQB()
  {
    return this.fPp;
  }
  
  public final int getType()
  {
    return 2975;
  }
  
  public final fks gpT()
  {
    AppMethodBeat.i(211425);
    fks localfks = (fks)d.c.b(this.rr.lBS);
    AppMethodBeat.o(211425);
    return localfks;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117626);
    Log.i("MicroMsg.WebSearch.NetSceneSearchWebQuery", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.fhq) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(117626);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.w
 * JD-Core Version:    0.7.0.1
 */