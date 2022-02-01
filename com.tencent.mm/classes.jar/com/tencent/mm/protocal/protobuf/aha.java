package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aha
  extends com.tencent.mm.bw.a
{
  public int LnA;
  public int LqF;
  public int LqG;
  public int LqH;
  public int LqI;
  public int LqJ;
  public int LqK;
  public int channels;
  public int qsU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90964);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.LqF);
      paramVarArgs.aM(2, this.LqG);
      paramVarArgs.aM(3, this.channels);
      paramVarArgs.aM(4, this.LqH);
      paramVarArgs.aM(5, this.LnA);
      paramVarArgs.aM(6, this.qsU);
      paramVarArgs.aM(7, this.LqI);
      paramVarArgs.aM(8, this.LqJ);
      paramVarArgs.aM(9, this.LqK);
      AppMethodBeat.o(90964);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.LqF);
      int i = g.a.a.b.b.a.bu(2, this.LqG);
      int j = g.a.a.b.b.a.bu(3, this.channels);
      int k = g.a.a.b.b.a.bu(4, this.LqH);
      int m = g.a.a.b.b.a.bu(5, this.LnA);
      int n = g.a.a.b.b.a.bu(6, this.qsU);
      int i1 = g.a.a.b.b.a.bu(7, this.LqI);
      int i2 = g.a.a.b.b.a.bu(8, this.LqJ);
      int i3 = g.a.a.b.b.a.bu(9, this.LqK);
      AppMethodBeat.o(90964);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(90964);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      aha localaha = (aha)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(90964);
        return -1;
      case 1: 
        localaha.LqF = locala.UbS.zi();
        AppMethodBeat.o(90964);
        return 0;
      case 2: 
        localaha.LqG = locala.UbS.zi();
        AppMethodBeat.o(90964);
        return 0;
      case 3: 
        localaha.channels = locala.UbS.zi();
        AppMethodBeat.o(90964);
        return 0;
      case 4: 
        localaha.LqH = locala.UbS.zi();
        AppMethodBeat.o(90964);
        return 0;
      case 5: 
        localaha.LnA = locala.UbS.zi();
        AppMethodBeat.o(90964);
        return 0;
      case 6: 
        localaha.qsU = locala.UbS.zi();
        AppMethodBeat.o(90964);
        return 0;
      case 7: 
        localaha.LqI = locala.UbS.zi();
        AppMethodBeat.o(90964);
        return 0;
      case 8: 
        localaha.LqJ = locala.UbS.zi();
        AppMethodBeat.o(90964);
        return 0;
      }
      localaha.LqK = locala.UbS.zi();
      AppMethodBeat.o(90964);
      return 0;
    }
    AppMethodBeat.o(90964);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aha
 * JD-Core Version:    0.7.0.1
 */