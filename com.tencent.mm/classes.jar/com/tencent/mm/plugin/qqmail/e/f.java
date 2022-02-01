package com.tencent.mm.plugin.qqmail.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.qqmail.d.bb;
import com.tencent.mm.plugin.qqmail.d.bc;
import java.util.LinkedList;

public final class f
  extends q
  implements m
{
  public String Hls;
  private i callback;
  private d lKU;
  
  public f(String paramString, int paramInt)
  {
    AppMethodBeat.i(250890);
    d.a locala = new d.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/xmmailbroker/mb_updatemailstatus";
    bb localbb = new bb();
    localbb.HnO.add(paramString);
    h.aHE();
    localbb.uin = b.getUin();
    localbb.HnP = paramInt;
    locala.lBU = localbb;
    locala.lBV = new bc();
    this.lKU = locala.bgN();
    this.Hls = paramString;
    AppMethodBeat.o(250890);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(250894);
    this.callback = parami;
    int i = dispatch(paramg, this.lKU, this);
    AppMethodBeat.o(250894);
    return i;
  }
  
  public final int getType()
  {
    return 11480;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(250895);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(250895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.e.f
 * JD-Core Version:    0.7.0.1
 */