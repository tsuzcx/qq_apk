package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.bdv;
import com.tencent.mm.protocal.protobuf.yn;
import com.tencent.mm.protocal.protobuf.yo;

public final class k
  extends j.b
{
  private bdv qEI;
  
  public k()
  {
    this(false, 22, 8);
  }
  
  public k(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(31);
    AppMethodBeat.i(126861);
    this.qEI = new bdv();
    yn localyn = new yn();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localyn.wPD = i;
      i = j;
      if (paramBoolean) {
        i = 0;
      }
      localyn.wPF = i;
      yo localyo = new yo();
      localyo.wPH = paramInt1;
      localyo.wPI = paramInt2;
      localyn.wPE = localyo;
      localyo.wPH = 0;
      localyo.wPI = 0;
      localyn.wPG = localyo;
      this.qEI.xtJ = localyn;
      this.oDZ = this.qEI;
      AppMethodBeat.o(126861);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.k
 * JD-Core Version:    0.7.0.1
 */