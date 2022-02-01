package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;

public final class r
  extends q
  implements m
{
  private i callback;
  public d hJu;
  
  public r(String paramString)
  {
    AppMethodBeat.i(198606);
    d.a locala = new d.a();
    locala.funcId = getType();
    w localw = new w();
    localw.Bsf = paramString;
    locala.iLN = localw;
    locala.iLO = new x();
    locala.uri = "/cgi-bin/micromsg-bin/preparebindxmail";
    Log.i("MicroMsg.NetScenePrepareBindXmail", "bindQQMail %s", new Object[] { paramString });
    this.hJu = locala.aXF();
    AppMethodBeat.o(198606);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(198607);
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
    AppMethodBeat.o(198607);
    return i;
  }
  
  public final int getType()
  {
    return 3848;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(198608);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(198608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.r
 * JD-Core Version:    0.7.0.1
 */