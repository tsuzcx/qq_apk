package com.tencent.mm.plugin.qqmail.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;

public final class q
  extends p
  implements m
{
  private h callback;
  public c nao;
  
  public q(String paramString)
  {
    AppMethodBeat.i(267063);
    c.a locala = new c.a();
    locala.funcId = getType();
    v localv = new v();
    localv.Nkm = paramString;
    locala.otE = localv;
    locala.otF = new w();
    locala.uri = "/cgi-bin/micromsg-bin/preparebindxmail";
    Log.i("MicroMsg.NetScenePrepareBindXmail", "bindQQMail %s", new Object[] { paramString });
    this.nao = locala.bEF();
    AppMethodBeat.o(267063);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(267069);
    this.callback = paramh;
    int i = dispatch(paramg, this.nao, this);
    AppMethodBeat.o(267069);
    return i;
  }
  
  public final int getType()
  {
    return 3848;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(267071);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(267071);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.model.q
 * JD-Core Version:    0.7.0.1
 */