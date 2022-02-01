package com.tencent.mm.plugin.qqmail.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.qqmail.d.bb;
import com.tencent.mm.plugin.qqmail.d.bc;
import java.util.LinkedList;

public final class f
  extends q
  implements m
{
  public String BqZ;
  private i callback;
  private d iUB;
  
  public f(String paramString, int paramInt)
  {
    AppMethodBeat.i(198665);
    d.a locala = new d.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/xmmailbroker/mb_updatemailstatus";
    bb localbb = new bb();
    localbb.Btu.add(paramString);
    com.tencent.mm.kernel.g.aAf();
    localbb.uin = a.getUin();
    localbb.Btv = paramInt;
    locala.iLN = localbb;
    locala.iLO = new bc();
    this.iUB = locala.aXF();
    this.BqZ = paramString;
    AppMethodBeat.o(198665);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(198666);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
    AppMethodBeat.o(198666);
    return i;
  }
  
  public final int getType()
  {
    return 11480;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(198667);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(198667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.e.f
 * JD-Core Version:    0.7.0.1
 */