package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dwu
  extends com.tencent.mm.bx.a
{
  public int EKH;
  public boolean EKI;
  public boolean EKJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123713);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EKH);
      paramVarArgs.bg(2, this.EKI);
      paramVarArgs.bg(3, this.EKJ);
      AppMethodBeat.o(123713);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.EKH);
      int i = f.a.a.b.b.a.fY(2);
      int j = f.a.a.b.b.a.fY(3);
      AppMethodBeat.o(123713);
      return paramInt + 0 + (i + 1) + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(123713);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dwu localdwu = (dwu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123713);
        return -1;
      case 1: 
        localdwu.EKH = locala.KhF.xS();
        AppMethodBeat.o(123713);
        return 0;
      case 2: 
        localdwu.EKI = locala.KhF.fHu();
        AppMethodBeat.o(123713);
        return 0;
      }
      localdwu.EKJ = locala.KhF.fHu();
      AppMethodBeat.o(123713);
      return 0;
    }
    AppMethodBeat.o(123713);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwu
 * JD-Core Version:    0.7.0.1
 */