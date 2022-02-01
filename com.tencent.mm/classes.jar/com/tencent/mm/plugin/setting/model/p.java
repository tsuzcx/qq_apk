package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.akq;
import com.tencent.mm.protocal.protobuf.akr;
import com.tencent.mm.protocal.protobuf.dpl;

public final class p
  extends k.b
{
  private dpl PnM;
  
  public p()
  {
    this(false, 22, 8);
  }
  
  public p(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(31);
    AppMethodBeat.i(73783);
    this.PnM = new dpl();
    akq localakq = new akq();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localakq.ZrQ = i;
      i = j;
      if (paramBoolean) {
        i = 0;
      }
      localakq.ZrS = i;
      akr localakr = new akr();
      localakr.ZrU = paramInt1;
      localakr.ZrV = paramInt2;
      localakq.ZrR = localakr;
      localakr.ZrU = 0;
      localakr.ZrV = 0;
      localakq.ZrT = localakr;
      this.PnM.aaWm = localakq;
      this.KRu = this.PnM;
      AppMethodBeat.o(73783);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.p
 * JD-Core Version:    0.7.0.1
 */