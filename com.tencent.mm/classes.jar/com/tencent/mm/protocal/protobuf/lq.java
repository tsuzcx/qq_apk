package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class lq
  extends com.tencent.mm.bx.a
{
  public int CHH;
  public int CHI;
  public int CreateTime;
  public int Cxn;
  public int mBH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124398);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.CHH);
      paramVarArgs.aR(2, this.CreateTime);
      paramVarArgs.aR(3, this.Cxn);
      paramVarArgs.aR(4, this.mBH);
      paramVarArgs.aR(5, this.CHI);
      AppMethodBeat.o(124398);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.CHH);
      int i = f.a.a.b.b.a.bA(2, this.CreateTime);
      int j = f.a.a.b.b.a.bA(3, this.Cxn);
      int k = f.a.a.b.b.a.bA(4, this.mBH);
      int m = f.a.a.b.b.a.bA(5, this.CHI);
      AppMethodBeat.o(124398);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(124398);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      lq locallq = (lq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124398);
        return -1;
      case 1: 
        locallq.CHH = locala.KhF.xS();
        AppMethodBeat.o(124398);
        return 0;
      case 2: 
        locallq.CreateTime = locala.KhF.xS();
        AppMethodBeat.o(124398);
        return 0;
      case 3: 
        locallq.Cxn = locala.KhF.xS();
        AppMethodBeat.o(124398);
        return 0;
      case 4: 
        locallq.mBH = locala.KhF.xS();
        AppMethodBeat.o(124398);
        return 0;
      }
      locallq.CHI = locala.KhF.xS();
      AppMethodBeat.o(124398);
      return 0;
    }
    AppMethodBeat.o(124398);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lq
 * JD-Core Version:    0.7.0.1
 */