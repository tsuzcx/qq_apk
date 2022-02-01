package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dux
  extends com.tencent.mm.bx.a
{
  public int Cxn;
  public int DKZ;
  public int EJd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123703);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DKZ);
      paramVarArgs.aR(2, this.Cxn);
      paramVarArgs.aR(3, this.EJd);
      AppMethodBeat.o(123703);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.DKZ);
      int i = f.a.a.b.b.a.bA(2, this.Cxn);
      int j = f.a.a.b.b.a.bA(3, this.EJd);
      AppMethodBeat.o(123703);
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
      AppMethodBeat.o(123703);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dux localdux = (dux)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123703);
        return -1;
      case 1: 
        localdux.DKZ = locala.KhF.xS();
        AppMethodBeat.o(123703);
        return 0;
      case 2: 
        localdux.Cxn = locala.KhF.xS();
        AppMethodBeat.o(123703);
        return 0;
      }
      localdux.EJd = locala.KhF.xS();
      AppMethodBeat.o(123703);
      return 0;
    }
    AppMethodBeat.o(123703);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dux
 * JD-Core Version:    0.7.0.1
 */