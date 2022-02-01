package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.dud;
import com.tencent.mm.protocal.protobuf.due;
import com.tencent.mm.protocal.protobuf.fql;
import java.util.List;

public final class s
  extends p
  implements m
{
  public List<fql> ORL;
  public long ORM;
  public float angle;
  private h callback;
  public int hBm;
  public c rr;
  
  public s(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    AppMethodBeat.i(120856);
    c.a locala = new c.a();
    dud localdud = new dud();
    localdud.aaZE = paramInt2;
    localdud.aaZF = paramInt3;
    localdud.aaZJ = paramString1;
    localdud.aaZK = paramString2;
    localdud.IJG = paramInt1;
    locala.otE = localdud;
    locala.otF = new due();
    locala.uri = "/cgi-bin/micromsg-bin/newocrtranslation";
    locala.funcId = getType();
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    this.hBm = paramInt2;
    AppMethodBeat.o(120856);
  }
  
  public s(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this(0, paramInt1, paramInt2, paramString1, paramString2);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(120857);
    this.callback = paramh;
    this.ORM = System.currentTimeMillis();
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(120857);
    return i;
  }
  
  public final String gQU()
  {
    AppMethodBeat.i(314403);
    String str = ((due)c.c.b(this.rr.otC)).aaZN;
    AppMethodBeat.o(314403);
    return str;
  }
  
  public final int getType()
  {
    return 294;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(120858);
    this.angle = ((due)c.c.b(((c)params).otC)).aaZL;
    this.ORL = ((due)c.c.b(((c)params).otC)).aasU;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(120858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.s
 * JD-Core Version:    0.7.0.1
 */