package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class lv
  extends com.tencent.mm.bx.a
{
  public int CIo;
  public int CIp;
  public int CIq;
  public int CIr;
  public int CIs;
  public int CzT;
  public int enabled;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103202);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.enabled);
      paramVarArgs.aR(2, this.CIo);
      paramVarArgs.aR(3, this.CIp);
      paramVarArgs.aR(4, this.CIq);
      paramVarArgs.aR(5, this.CIr);
      paramVarArgs.aR(6, this.CIs);
      paramVarArgs.aR(7, this.CzT);
      AppMethodBeat.o(103202);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.enabled);
      int i = f.a.a.b.b.a.bA(2, this.CIo);
      int j = f.a.a.b.b.a.bA(3, this.CIp);
      int k = f.a.a.b.b.a.bA(4, this.CIq);
      int m = f.a.a.b.b.a.bA(5, this.CIr);
      int n = f.a.a.b.b.a.bA(6, this.CIs);
      int i1 = f.a.a.b.b.a.bA(7, this.CzT);
      AppMethodBeat.o(103202);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(103202);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      lv locallv = (lv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(103202);
        return -1;
      case 1: 
        locallv.enabled = locala.KhF.xS();
        AppMethodBeat.o(103202);
        return 0;
      case 2: 
        locallv.CIo = locala.KhF.xS();
        AppMethodBeat.o(103202);
        return 0;
      case 3: 
        locallv.CIp = locala.KhF.xS();
        AppMethodBeat.o(103202);
        return 0;
      case 4: 
        locallv.CIq = locala.KhF.xS();
        AppMethodBeat.o(103202);
        return 0;
      case 5: 
        locallv.CIr = locala.KhF.xS();
        AppMethodBeat.o(103202);
        return 0;
      case 6: 
        locallv.CIs = locala.KhF.xS();
        AppMethodBeat.o(103202);
        return 0;
      }
      locallv.CzT = locala.KhF.xS();
      AppMethodBeat.o(103202);
      return 0;
    }
    AppMethodBeat.o(103202);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lv
 * JD-Core Version:    0.7.0.1
 */