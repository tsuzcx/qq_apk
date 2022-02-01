package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bhh
  extends com.tencent.mm.bx.a
{
  public int DFd;
  public int DFe;
  public int DFf;
  public int DFg;
  public int DFh;
  public int DFi;
  public int DFj;
  public int dcA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143981);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DFd);
      paramVarArgs.aR(2, this.dcA);
      paramVarArgs.aR(3, this.DFe);
      paramVarArgs.aR(4, this.DFf);
      paramVarArgs.aR(5, this.DFg);
      paramVarArgs.aR(6, this.DFh);
      paramVarArgs.aR(7, this.DFi);
      paramVarArgs.aR(8, this.DFj);
      AppMethodBeat.o(143981);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.DFd);
      int i = f.a.a.b.b.a.bA(2, this.dcA);
      int j = f.a.a.b.b.a.bA(3, this.DFe);
      int k = f.a.a.b.b.a.bA(4, this.DFf);
      int m = f.a.a.b.b.a.bA(5, this.DFg);
      int n = f.a.a.b.b.a.bA(6, this.DFh);
      int i1 = f.a.a.b.b.a.bA(7, this.DFi);
      int i2 = f.a.a.b.b.a.bA(8, this.DFj);
      AppMethodBeat.o(143981);
      return paramInt + 0 + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(143981);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bhh localbhh = (bhh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143981);
        return -1;
      case 1: 
        localbhh.DFd = locala.KhF.xS();
        AppMethodBeat.o(143981);
        return 0;
      case 2: 
        localbhh.dcA = locala.KhF.xS();
        AppMethodBeat.o(143981);
        return 0;
      case 3: 
        localbhh.DFe = locala.KhF.xS();
        AppMethodBeat.o(143981);
        return 0;
      case 4: 
        localbhh.DFf = locala.KhF.xS();
        AppMethodBeat.o(143981);
        return 0;
      case 5: 
        localbhh.DFg = locala.KhF.xS();
        AppMethodBeat.o(143981);
        return 0;
      case 6: 
        localbhh.DFh = locala.KhF.xS();
        AppMethodBeat.o(143981);
        return 0;
      case 7: 
        localbhh.DFi = locala.KhF.xS();
        AppMethodBeat.o(143981);
        return 0;
      }
      localbhh.DFj = locala.KhF.xS();
      AppMethodBeat.o(143981);
      return 0;
    }
    AppMethodBeat.o(143981);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhh
 * JD-Core Version:    0.7.0.1
 */