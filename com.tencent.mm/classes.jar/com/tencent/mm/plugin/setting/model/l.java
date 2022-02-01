package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.abx;
import com.tencent.mm.protocal.protobuf.aby;
import com.tencent.mm.protocal.protobuf.bqn;

public final class l
  extends j.b
{
  private bqn wdb;
  
  public l()
  {
    this(false, 22, 8);
  }
  
  public l(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(31);
    AppMethodBeat.i(73783);
    this.wdb = new bqn();
    abx localabx = new abx();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localabx.Dcu = i;
      i = j;
      if (paramBoolean) {
        i = 0;
      }
      localabx.Dcw = i;
      aby localaby = new aby();
      localaby.Dcy = paramInt1;
      localaby.Dcz = paramInt2;
      localabx.Dcv = localaby;
      localaby.Dcy = 0;
      localaby.Dcz = 0;
      localabx.Dcx = localaby;
      this.wdb.DOM = localabx;
      this.tyM = this.wdb;
      AppMethodBeat.o(73783);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.l
 * JD-Core Version:    0.7.0.1
 */