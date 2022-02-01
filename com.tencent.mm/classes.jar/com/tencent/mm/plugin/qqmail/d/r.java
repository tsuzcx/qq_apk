package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;

public final class r
  extends q
  implements m
{
  private i callback;
  public d kwO;
  
  public r(String paramString)
  {
    AppMethodBeat.i(250098);
    d.a locala = new d.a();
    locala.funcId = getType();
    w localw = new w();
    localw.Hmy = paramString;
    locala.lBU = localw;
    locala.lBV = new x();
    locala.uri = "/cgi-bin/micromsg-bin/preparebindxmail";
    Log.i("MicroMsg.NetScenePrepareBindXmail", "bindQQMail %s", new Object[] { paramString });
    this.kwO = locala.bgN();
    AppMethodBeat.o(250098);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(250100);
    this.callback = parami;
    int i = dispatch(paramg, this.kwO, this);
    AppMethodBeat.o(250100);
    return i;
  }
  
  public final int getType()
  {
    return 3848;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(250101);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(250101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.r
 * JD-Core Version:    0.7.0.1
 */