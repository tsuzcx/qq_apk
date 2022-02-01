package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.aex;
import com.tencent.mm.protocal.protobuf.aey;
import com.tencent.mm.protocal.protobuf.bzt;

public final class l
  extends k.b
{
  private bzt yCU;
  
  public l()
  {
    this(false, 22, 8);
  }
  
  public l(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(31);
    AppMethodBeat.i(73783);
    this.yCU = new bzt();
    aex localaex = new aex();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localaex.GcX = i;
      i = j;
      if (paramBoolean) {
        i = 0;
      }
      localaex.GcZ = i;
      aey localaey = new aey();
      localaey.Gdb = paramInt1;
      localaey.Gdc = paramInt2;
      localaex.GcY = localaey;
      localaey.Gdb = 0;
      localaey.Gdc = 0;
      localaex.Gda = localaey;
      this.yCU.GUL = localaex;
      this.vKm = this.yCU;
      AppMethodBeat.o(73783);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.l
 * JD-Core Version:    0.7.0.1
 */