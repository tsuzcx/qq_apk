package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class als
  extends com.tencent.mm.bw.a
{
  public int EFl;
  public int cSh;
  public long gmP;
  public int liveStatus;
  public String yId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195089);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.gmP);
      paramVarArgs.aR(2, this.EFl);
      paramVarArgs.aR(3, this.liveStatus);
      if (this.yId != null) {
        paramVarArgs.d(4, this.yId);
      }
      paramVarArgs.aR(5, this.cSh);
      AppMethodBeat.o(195089);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.gmP) + 0 + f.a.a.b.b.a.bx(2, this.EFl) + f.a.a.b.b.a.bx(3, this.liveStatus);
      paramInt = i;
      if (this.yId != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.yId);
      }
      i = f.a.a.b.b.a.bx(5, this.cSh);
      AppMethodBeat.o(195089);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(195089);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      als localals = (als)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(195089);
        return -1;
      case 1: 
        localals.gmP = locala.LVo.xG();
        AppMethodBeat.o(195089);
        return 0;
      case 2: 
        localals.EFl = locala.LVo.xF();
        AppMethodBeat.o(195089);
        return 0;
      case 3: 
        localals.liveStatus = locala.LVo.xF();
        AppMethodBeat.o(195089);
        return 0;
      case 4: 
        localals.yId = locala.LVo.readString();
        AppMethodBeat.o(195089);
        return 0;
      }
      localals.cSh = locala.LVo.xF();
      AppMethodBeat.o(195089);
      return 0;
    }
    AppMethodBeat.o(195089);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.als
 * JD-Core Version:    0.7.0.1
 */