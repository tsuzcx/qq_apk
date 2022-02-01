package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ctm;
import com.tencent.mm.protocal.protobuf.ctn;
import com.tencent.mm.protocal.protobuf.ekt;
import java.util.List;

public final class m
  extends q
  implements com.tencent.mm.network.m
{
  public List<ekt> CFD;
  public long CFE;
  public float angle;
  private i callback;
  public int dEb;
  public d rr;
  
  public m(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    AppMethodBeat.i(120856);
    d.a locala = new d.a();
    ctm localctm = new ctm();
    localctm.Myo = paramInt2;
    localctm.Myp = paramInt3;
    localctm.Myt = paramString1;
    localctm.Myu = paramString2;
    localctm.Scene = paramInt1;
    locala.iLN = localctm;
    locala.iLO = new ctn();
    locala.uri = "/cgi-bin/micromsg-bin/newocrtranslation";
    locala.funcId = getType();
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    this.dEb = paramInt2;
    AppMethodBeat.o(120856);
  }
  
  public m(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this(0, paramInt1, paramInt2, paramString1, paramString2);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(120857);
    this.callback = parami;
    this.CFE = System.currentTimeMillis();
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(120857);
    return i;
  }
  
  public final List<ekt> ePQ()
  {
    return this.CFD;
  }
  
  public final String ePR()
  {
    return ((ctn)this.rr.iLL.iLR).Myx;
  }
  
  public final long ePS()
  {
    return this.CFE;
  }
  
  public final float getAngle()
  {
    return this.angle;
  }
  
  public final int getSessionId()
  {
    return this.dEb;
  }
  
  public final int getType()
  {
    return 294;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(120858);
    this.angle = ((ctn)((d)params).iLL.iLR).Myv;
    this.CFD = ((ctn)((d)params).iLL.iLR).LWt;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(120858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.m
 * JD-Core Version:    0.7.0.1
 */