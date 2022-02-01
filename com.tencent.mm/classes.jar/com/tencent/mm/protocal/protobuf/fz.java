package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fz
  extends com.tencent.mm.bx.a
{
  public int CAG;
  public int CAH;
  public int CAI;
  public int CAJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32126);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.CAG);
      paramVarArgs.aR(2, this.CAH);
      paramVarArgs.aR(3, this.CAI);
      paramVarArgs.aR(4, this.CAJ);
      AppMethodBeat.o(32126);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.CAG);
      int i = f.a.a.b.b.a.bA(2, this.CAH);
      int j = f.a.a.b.b.a.bA(3, this.CAI);
      int k = f.a.a.b.b.a.bA(4, this.CAJ);
      AppMethodBeat.o(32126);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(32126);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      fz localfz = (fz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32126);
        return -1;
      case 1: 
        localfz.CAG = locala.KhF.xS();
        AppMethodBeat.o(32126);
        return 0;
      case 2: 
        localfz.CAH = locala.KhF.xS();
        AppMethodBeat.o(32126);
        return 0;
      case 3: 
        localfz.CAI = locala.KhF.xS();
        AppMethodBeat.o(32126);
        return 0;
      }
      localfz.CAJ = locala.KhF.xS();
      AppMethodBeat.o(32126);
      return 0;
    }
    AppMethodBeat.o(32126);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fz
 * JD-Core Version:    0.7.0.1
 */