package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.protocal.protobuf.acx;
import com.tencent.mm.protocal.protobuf.bve;

public final class l
  extends j.b
{
  private bve xop;
  
  public l()
  {
    this(false, 22, 8);
  }
  
  public l(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(31);
    AppMethodBeat.i(73783);
    this.xop = new bve();
    acw localacw = new acw();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localacw.EvB = i;
      i = j;
      if (paramBoolean) {
        i = 0;
      }
      localacw.EvD = i;
      acx localacx = new acx();
      localacx.EvF = paramInt1;
      localacx.EvG = paramInt2;
      localacw.EvC = localacx;
      localacx.EvF = 0;
      localacx.EvG = 0;
      localacw.EvE = localacx;
      this.xop.Fld = localacw;
      this.uHj = this.xop;
      AppMethodBeat.o(73783);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.l
 * JD-Core Version:    0.7.0.1
 */