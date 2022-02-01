package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ank
  extends com.tencent.mm.bw.a
{
  public int dbL;
  public int diw;
  public long hES;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195105);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.diw);
      paramVarArgs.aO(2, this.hES);
      paramVarArgs.aR(3, this.dbL);
      AppMethodBeat.o(195105);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.diw);
      int i = f.a.a.b.b.a.p(2, this.hES);
      int j = f.a.a.b.b.a.bx(3, this.dbL);
      AppMethodBeat.o(195105);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(195105);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ank localank = (ank)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(195105);
        return -1;
      case 1: 
        localank.diw = locala.LVo.xF();
        AppMethodBeat.o(195105);
        return 0;
      case 2: 
        localank.hES = locala.LVo.xG();
        AppMethodBeat.o(195105);
        return 0;
      }
      localank.dbL = locala.LVo.xF();
      AppMethodBeat.o(195105);
      return 0;
    }
    AppMethodBeat.o(195105);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ank
 * JD-Core Version:    0.7.0.1
 */