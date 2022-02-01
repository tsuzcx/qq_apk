package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bxv;
import com.tencent.mm.protocal.protobuf.bxw;
import com.tencent.mm.protocal.protobuf.dkj;
import java.util.List;

public final class h
  extends n
  implements k
{
  public float angle;
  private g callback;
  public int daq;
  public b rr;
  public List<dkj> wYW;
  public long wYX;
  
  public h(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    AppMethodBeat.i(120856);
    b.a locala = new b.a();
    bxv localbxv = new bxv();
    localbxv.Fmy = paramInt2;
    localbxv.Fmz = paramInt3;
    localbxv.FmD = paramString1;
    localbxv.FmE = paramString2;
    localbxv.Scene = paramInt1;
    locala.hvt = localbxv;
    locala.hvu = new bxw();
    locala.uri = "/cgi-bin/micromsg-bin/newocrtranslation";
    locala.funcId = getType();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    this.daq = paramInt2;
    AppMethodBeat.o(120856);
  }
  
  public h(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this(0, paramInt1, paramInt2, paramString1, paramString2);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(120857);
    this.callback = paramg;
    this.wYX = System.currentTimeMillis();
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(120857);
    return i;
  }
  
  public final float dzt()
  {
    return this.angle;
  }
  
  public final List<dkj> dzu()
  {
    return this.wYW;
  }
  
  public final String dzv()
  {
    return ((bxw)this.rr.hvs.hvw).FmH;
  }
  
  public final long dzw()
  {
    return this.wYX;
  }
  
  public final int getSessionId()
  {
    return this.daq;
  }
  
  public final int getType()
  {
    return 294;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(120858);
    this.angle = ((bxw)((b)paramq).hvs.hvw).FmF;
    this.wYW = ((bxw)((b)paramq).hvs.hvw).EPD;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(120858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.h
 * JD-Core Version:    0.7.0.1
 */