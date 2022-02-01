package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cch
  extends com.tencent.mm.bx.a
{
  public String dtI;
  public int dtJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(19408);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.dtJ);
      if (this.dtI != null) {
        paramVarArgs.d(2, this.dtI);
      }
      AppMethodBeat.o(19408);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.dtJ) + 0;
      paramInt = i;
      if (this.dtI != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dtI);
      }
      AppMethodBeat.o(19408);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(19408);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cch localcch = (cch)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(19408);
        return -1;
      case 1: 
        localcch.dtJ = locala.KhF.xS();
        AppMethodBeat.o(19408);
        return 0;
      }
      localcch.dtI = locala.KhF.readString();
      AppMethodBeat.o(19408);
      return 0;
    }
    AppMethodBeat.o(19408);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cch
 * JD-Core Version:    0.7.0.1
 */