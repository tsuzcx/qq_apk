package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dbd
  extends com.tencent.mm.bx.a
{
  public int aaGA;
  public int aaGB;
  public int aaGC;
  public int aaGD;
  public int aaGE;
  public int aaGF;
  public int aaGz;
  public int hAO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143981);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aaGz);
      paramVarArgs.bS(2, this.hAO);
      paramVarArgs.bS(3, this.aaGA);
      paramVarArgs.bS(4, this.aaGB);
      paramVarArgs.bS(5, this.aaGC);
      paramVarArgs.bS(6, this.aaGD);
      paramVarArgs.bS(7, this.aaGE);
      paramVarArgs.bS(8, this.aaGF);
      AppMethodBeat.o(143981);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.aaGz);
      int i = i.a.a.b.b.a.cJ(2, this.hAO);
      int j = i.a.a.b.b.a.cJ(3, this.aaGA);
      int k = i.a.a.b.b.a.cJ(4, this.aaGB);
      int m = i.a.a.b.b.a.cJ(5, this.aaGC);
      int n = i.a.a.b.b.a.cJ(6, this.aaGD);
      int i1 = i.a.a.b.b.a.cJ(7, this.aaGE);
      int i2 = i.a.a.b.b.a.cJ(8, this.aaGF);
      AppMethodBeat.o(143981);
      return paramInt + 0 + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(143981);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dbd localdbd = (dbd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143981);
        return -1;
      case 1: 
        localdbd.aaGz = locala.ajGk.aar();
        AppMethodBeat.o(143981);
        return 0;
      case 2: 
        localdbd.hAO = locala.ajGk.aar();
        AppMethodBeat.o(143981);
        return 0;
      case 3: 
        localdbd.aaGA = locala.ajGk.aar();
        AppMethodBeat.o(143981);
        return 0;
      case 4: 
        localdbd.aaGB = locala.ajGk.aar();
        AppMethodBeat.o(143981);
        return 0;
      case 5: 
        localdbd.aaGC = locala.ajGk.aar();
        AppMethodBeat.o(143981);
        return 0;
      case 6: 
        localdbd.aaGD = locala.ajGk.aar();
        AppMethodBeat.o(143981);
        return 0;
      case 7: 
        localdbd.aaGE = locala.ajGk.aar();
        AppMethodBeat.o(143981);
        return 0;
      }
      localdbd.aaGF = locala.ajGk.aar();
      AppMethodBeat.o(143981);
      return 0;
    }
    AppMethodBeat.o(143981);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbd
 * JD-Core Version:    0.7.0.1
 */