package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.afg;
import com.tencent.mm.protocal.protobuf.afh;
import com.tencent.mm.protocal.protobuf.can;

public final class m
  extends k.b
{
  private can ySZ;
  
  public m()
  {
    this(false, 22, 8);
  }
  
  public m(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(31);
    AppMethodBeat.i(73783);
    this.ySZ = new can();
    afg localafg = new afg();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localafg.GvE = i;
      i = j;
      if (paramBoolean) {
        i = 0;
      }
      localafg.GvG = i;
      afh localafh = new afh();
      localafh.GvI = paramInt1;
      localafh.GvJ = paramInt2;
      localafg.GvF = localafh;
      localafh.GvI = 0;
      localafh.GvJ = 0;
      localafg.GvH = localafh;
      this.ySZ.Hom = localafg;
      this.vWq = this.ySZ;
      AppMethodBeat.o(73783);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.m
 * JD-Core Version:    0.7.0.1
 */