package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.ahm;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.cpp;

public final class n
  extends k.b
{
  private cpp CXR;
  
  public n()
  {
    this(false, 22, 8);
  }
  
  public n(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(31);
    AppMethodBeat.i(73783);
    this.CXR = new cpp();
    ahm localahm = new ahm();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localahm.Lrk = i;
      i = j;
      if (paramBoolean) {
        i = 0;
      }
      localahm.Lrm = i;
      ahn localahn = new ahn();
      localahn.Lro = paramInt1;
      localahn.Lrp = paramInt2;
      localahm.Lrl = localahn;
      localahn.Lro = 0;
      localahn.Lrp = 0;
      localahm.Lrn = localahn;
      this.CXR.MvH = localahm;
      this.zqv = this.CXR;
      AppMethodBeat.o(73783);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.n
 * JD-Core Version:    0.7.0.1
 */