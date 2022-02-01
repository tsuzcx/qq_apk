package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dts
  extends com.tencent.mm.bx.a
{
  public int dqI;
  public String dqJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(74675);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.dqI);
      if (this.dqJ != null) {
        paramVarArgs.d(2, this.dqJ);
      }
      AppMethodBeat.o(74675);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.dqI) + 0;
      paramInt = i;
      if (this.dqJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dqJ);
      }
      AppMethodBeat.o(74675);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(74675);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dts localdts = (dts)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(74675);
        return -1;
      case 1: 
        localdts.dqI = locala.NPN.zc();
        AppMethodBeat.o(74675);
        return 0;
      }
      localdts.dqJ = locala.NPN.readString();
      AppMethodBeat.o(74675);
      return 0;
    }
    AppMethodBeat.o(74675);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dts
 * JD-Core Version:    0.7.0.1
 */