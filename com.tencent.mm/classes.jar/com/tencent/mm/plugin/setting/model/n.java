package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.ahx;
import com.tencent.mm.protocal.protobuf.ahy;
import com.tencent.mm.protocal.protobuf.cyf;

public final class n
  extends k.b
{
  private cyf Jdx;
  
  public n()
  {
    this(false, 22, 8);
  }
  
  public n(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(31);
    AppMethodBeat.i(73783);
    this.Jdx = new cyf();
    ahx localahx = new ahx();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localahx.SsH = i;
      i = j;
      if (paramBoolean) {
        i = 0;
      }
      localahx.SsJ = i;
      ahy localahy = new ahy();
      localahy.SsL = paramInt1;
      localahy.SsM = paramInt2;
      localahx.SsI = localahy;
      localahy.SsL = 0;
      localahy.SsM = 0;
      localahx.SsK = localahy;
      this.Jdx.TGF = localahx;
      this.EVU = this.Jdx;
      AppMethodBeat.o(73783);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.n
 * JD-Core Version:    0.7.0.1
 */