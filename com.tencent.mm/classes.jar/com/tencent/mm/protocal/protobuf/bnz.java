package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bnz
  extends com.tencent.mm.bx.a
{
  public int DLi;
  public int DLj;
  public int DLk;
  public int DLl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169923);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DLi);
      paramVarArgs.aR(2, this.DLj);
      paramVarArgs.aR(3, this.DLk);
      paramVarArgs.aR(4, this.DLl);
      AppMethodBeat.o(169923);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.DLi);
      int i = f.a.a.b.b.a.bA(2, this.DLj);
      int j = f.a.a.b.b.a.bA(3, this.DLk);
      int k = f.a.a.b.b.a.bA(4, this.DLl);
      AppMethodBeat.o(169923);
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
      AppMethodBeat.o(169923);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bnz localbnz = (bnz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169923);
        return -1;
      case 1: 
        localbnz.DLi = locala.KhF.xS();
        AppMethodBeat.o(169923);
        return 0;
      case 2: 
        localbnz.DLj = locala.KhF.xS();
        AppMethodBeat.o(169923);
        return 0;
      case 3: 
        localbnz.DLk = locala.KhF.xS();
        AppMethodBeat.o(169923);
        return 0;
      }
      localbnz.DLl = locala.KhF.xS();
      AppMethodBeat.o(169923);
      return 0;
    }
    AppMethodBeat.o(169923);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnz
 * JD-Core Version:    0.7.0.1
 */