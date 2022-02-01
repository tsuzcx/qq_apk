package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bxn
  extends com.tencent.mm.bx.a
{
  public int DUd;
  public String DUe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32367);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DUd);
      if (this.DUe != null) {
        paramVarArgs.d(2, this.DUe);
      }
      AppMethodBeat.o(32367);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.DUd) + 0;
      paramInt = i;
      if (this.DUe != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DUe);
      }
      AppMethodBeat.o(32367);
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
      AppMethodBeat.o(32367);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bxn localbxn = (bxn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32367);
        return -1;
      case 1: 
        localbxn.DUd = locala.KhF.xS();
        AppMethodBeat.o(32367);
        return 0;
      }
      localbxn.DUe = locala.KhF.readString();
      AppMethodBeat.o(32367);
      return 0;
    }
    AppMethodBeat.o(32367);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxn
 * JD-Core Version:    0.7.0.1
 */