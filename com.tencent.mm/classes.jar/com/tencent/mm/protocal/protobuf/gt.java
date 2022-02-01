package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gt
  extends com.tencent.mm.bx.a
{
  public int dmD;
  public String dmE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123546);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.dmD);
      if (this.dmE != null) {
        paramVarArgs.d(2, this.dmE);
      }
      AppMethodBeat.o(123546);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.dmD) + 0;
      paramInt = i;
      if (this.dmE != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dmE);
      }
      AppMethodBeat.o(123546);
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
      AppMethodBeat.o(123546);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      gt localgt = (gt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123546);
        return -1;
      case 1: 
        localgt.dmD = locala.KhF.xS();
        AppMethodBeat.o(123546);
        return 0;
      }
      localgt.dmE = locala.KhF.readString();
      AppMethodBeat.o(123546);
      return 0;
    }
    AppMethodBeat.o(123546);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gt
 * JD-Core Version:    0.7.0.1
 */