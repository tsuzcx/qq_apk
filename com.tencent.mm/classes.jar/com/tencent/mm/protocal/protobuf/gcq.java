package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gcq
  extends com.tencent.mm.bx.a
{
  public String YBL;
  public boolean acaA;
  public String acaB;
  public int acaC;
  public int acaD;
  public int acaE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147805);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.acaA);
      if (this.YBL != null) {
        paramVarArgs.g(2, this.YBL);
      }
      if (this.acaB != null) {
        paramVarArgs.g(3, this.acaB);
      }
      paramVarArgs.bS(4, this.acaC);
      paramVarArgs.bS(5, this.acaD);
      paramVarArgs.bS(6, this.acaE);
      AppMethodBeat.o(147805);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.ko(1) + 1 + 0;
      paramInt = i;
      if (this.YBL != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YBL);
      }
      i = paramInt;
      if (this.acaB != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.acaB);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.acaC);
      int j = i.a.a.b.b.a.cJ(5, this.acaD);
      int k = i.a.a.b.b.a.cJ(6, this.acaE);
      AppMethodBeat.o(147805);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(147805);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      gcq localgcq = (gcq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(147805);
        return -1;
      case 1: 
        localgcq.acaA = locala.ajGk.aai();
        AppMethodBeat.o(147805);
        return 0;
      case 2: 
        localgcq.YBL = locala.ajGk.readString();
        AppMethodBeat.o(147805);
        return 0;
      case 3: 
        localgcq.acaB = locala.ajGk.readString();
        AppMethodBeat.o(147805);
        return 0;
      case 4: 
        localgcq.acaC = locala.ajGk.aar();
        AppMethodBeat.o(147805);
        return 0;
      case 5: 
        localgcq.acaD = locala.ajGk.aar();
        AppMethodBeat.o(147805);
        return 0;
      }
      localgcq.acaE = locala.ajGk.aar();
      AppMethodBeat.o(147805);
      return 0;
    }
    AppMethodBeat.o(147805);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gcq
 * JD-Core Version:    0.7.0.1
 */