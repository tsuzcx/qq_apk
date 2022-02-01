package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bb
  extends com.tencent.mm.bx.a
{
  public boolean Cvk;
  public boolean Cvl;
  public int Cvm;
  public boolean Cvn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123537);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bg(1, this.Cvk);
      paramVarArgs.bg(2, this.Cvl);
      paramVarArgs.aR(3, this.Cvm);
      paramVarArgs.bg(4, this.Cvn);
      AppMethodBeat.o(123537);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.fY(1);
      int i = f.a.a.b.b.a.fY(2);
      int j = f.a.a.b.b.a.bA(3, this.Cvm);
      int k = f.a.a.b.b.a.fY(4);
      AppMethodBeat.o(123537);
      return paramInt + 1 + 0 + (i + 1) + j + (k + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(123537);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bb localbb = (bb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123537);
        return -1;
      case 1: 
        localbb.Cvk = locala.KhF.fHu();
        AppMethodBeat.o(123537);
        return 0;
      case 2: 
        localbb.Cvl = locala.KhF.fHu();
        AppMethodBeat.o(123537);
        return 0;
      case 3: 
        localbb.Cvm = locala.KhF.xS();
        AppMethodBeat.o(123537);
        return 0;
      }
      localbb.Cvn = locala.KhF.fHu();
      AppMethodBeat.o(123537);
      return 0;
    }
    AppMethodBeat.o(123537);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bb
 * JD-Core Version:    0.7.0.1
 */