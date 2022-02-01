package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class do
  extends com.tencent.mm.bx.a
{
  public int Cyi;
  public int Cyj;
  public int bvE;
  public float bvI;
  public int bzj;
  public int ksP;
  public int ksQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103178);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.bzj);
      paramVarArgs.aR(2, this.bvE);
      paramVarArgs.x(3, this.bvI);
      paramVarArgs.aR(4, this.Cyi);
      paramVarArgs.aR(5, this.Cyj);
      paramVarArgs.aR(6, this.ksP);
      paramVarArgs.aR(7, this.ksQ);
      AppMethodBeat.o(103178);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.bzj);
      int i = f.a.a.b.b.a.bA(2, this.bvE);
      int j = f.a.a.b.b.a.fY(3);
      int k = f.a.a.b.b.a.bA(4, this.Cyi);
      int m = f.a.a.b.b.a.bA(5, this.Cyj);
      int n = f.a.a.b.b.a.bA(6, this.ksP);
      int i1 = f.a.a.b.b.a.bA(7, this.ksQ);
      AppMethodBeat.o(103178);
      return paramInt + 0 + i + (j + 4) + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(103178);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      do localdo = (do)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(103178);
        return -1;
      case 1: 
        localdo.bzj = locala.KhF.xS();
        AppMethodBeat.o(103178);
        return 0;
      case 2: 
        localdo.bvE = locala.KhF.xS();
        AppMethodBeat.o(103178);
        return 0;
      case 3: 
        localdo.bvI = Float.intBitsToFloat(locala.KhF.fHx());
        AppMethodBeat.o(103178);
        return 0;
      case 4: 
        localdo.Cyi = locala.KhF.xS();
        AppMethodBeat.o(103178);
        return 0;
      case 5: 
        localdo.Cyj = locala.KhF.xS();
        AppMethodBeat.o(103178);
        return 0;
      case 6: 
        localdo.ksP = locala.KhF.xS();
        AppMethodBeat.o(103178);
        return 0;
      }
      localdo.ksQ = locala.KhF.xS();
      AppMethodBeat.o(103178);
      return 0;
    }
    AppMethodBeat.o(103178);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.do
 * JD-Core Version:    0.7.0.1
 */