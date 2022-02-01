package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gh
  extends com.tencent.mm.bx.a
{
  public int xcK;
  public int xcL;
  public int xcM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32125);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.xcK);
      paramVarArgs.aS(2, this.xcL);
      paramVarArgs.aS(3, this.xcM);
      AppMethodBeat.o(32125);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.xcK);
      int i = f.a.a.b.b.a.bz(2, this.xcL);
      int j = f.a.a.b.b.a.bz(3, this.xcM);
      AppMethodBeat.o(32125);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(32125);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      gh localgh = (gh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32125);
        return -1;
      case 1: 
        localgh.xcK = locala.NPN.zc();
        AppMethodBeat.o(32125);
        return 0;
      case 2: 
        localgh.xcL = locala.NPN.zc();
        AppMethodBeat.o(32125);
        return 0;
      }
      localgh.xcM = locala.NPN.zc();
      AppMethodBeat.o(32125);
      return 0;
    }
    AppMethodBeat.o(32125);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gh
 * JD-Core Version:    0.7.0.1
 */