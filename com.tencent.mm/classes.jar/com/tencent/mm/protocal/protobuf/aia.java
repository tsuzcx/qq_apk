package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aia
  extends com.tencent.mm.bx.a
{
  public int DkD;
  public int DkE;
  public int DkF;
  public int Dla;
  public int Dlb;
  public int Dlh;
  public int Lxp;
  public int count;
  public int hpZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168947);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.count);
      paramVarArgs.aR(2, this.DkD);
      paramVarArgs.aR(3, this.DkE);
      paramVarArgs.aR(4, this.DkF);
      paramVarArgs.aR(5, this.Dlh);
      paramVarArgs.aR(7, this.Dla);
      paramVarArgs.aR(8, this.Dlb);
      paramVarArgs.aR(9, this.hpZ);
      paramVarArgs.aR(10, this.Lxp);
      AppMethodBeat.o(168947);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.count);
      int i = f.a.a.b.b.a.bA(2, this.DkD);
      int j = f.a.a.b.b.a.bA(3, this.DkE);
      int k = f.a.a.b.b.a.bA(4, this.DkF);
      int m = f.a.a.b.b.a.bA(5, this.Dlh);
      int n = f.a.a.b.b.a.bA(7, this.Dla);
      int i1 = f.a.a.b.b.a.bA(8, this.Dlb);
      int i2 = f.a.a.b.b.a.bA(9, this.hpZ);
      int i3 = f.a.a.b.b.a.bA(10, this.Lxp);
      AppMethodBeat.o(168947);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(168947);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aia localaia = (aia)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 6: 
      default: 
        AppMethodBeat.o(168947);
        return -1;
      case 1: 
        localaia.count = locala.KhF.xS();
        AppMethodBeat.o(168947);
        return 0;
      case 2: 
        localaia.DkD = locala.KhF.xS();
        AppMethodBeat.o(168947);
        return 0;
      case 3: 
        localaia.DkE = locala.KhF.xS();
        AppMethodBeat.o(168947);
        return 0;
      case 4: 
        localaia.DkF = locala.KhF.xS();
        AppMethodBeat.o(168947);
        return 0;
      case 5: 
        localaia.Dlh = locala.KhF.xS();
        AppMethodBeat.o(168947);
        return 0;
      case 7: 
        localaia.Dla = locala.KhF.xS();
        AppMethodBeat.o(168947);
        return 0;
      case 8: 
        localaia.Dlb = locala.KhF.xS();
        AppMethodBeat.o(168947);
        return 0;
      case 9: 
        localaia.hpZ = locala.KhF.xS();
        AppMethodBeat.o(168947);
        return 0;
      }
      localaia.Lxp = locala.KhF.xS();
      AppMethodBeat.o(168947);
      return 0;
    }
    AppMethodBeat.o(168947);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aia
 * JD-Core Version:    0.7.0.1
 */