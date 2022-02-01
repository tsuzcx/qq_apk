package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dve
  extends com.tencent.mm.bx.a
{
  public int DKZ;
  public int EJd;
  public long EJk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50119);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DKZ);
      paramVarArgs.aG(2, this.EJk);
      paramVarArgs.aR(3, this.EJd);
      AppMethodBeat.o(50119);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.DKZ);
      int i = f.a.a.b.b.a.q(2, this.EJk);
      int j = f.a.a.b.b.a.bA(3, this.EJd);
      AppMethodBeat.o(50119);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(50119);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dve localdve = (dve)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50119);
        return -1;
      case 1: 
        localdve.DKZ = locala.KhF.xS();
        AppMethodBeat.o(50119);
        return 0;
      case 2: 
        localdve.EJk = locala.KhF.xT();
        AppMethodBeat.o(50119);
        return 0;
      }
      localdve.EJd = locala.KhF.xS();
      AppMethodBeat.o(50119);
      return 0;
    }
    AppMethodBeat.o(50119);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dve
 * JD-Core Version:    0.7.0.1
 */