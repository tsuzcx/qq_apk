package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class fqq
  extends com.tencent.mm.bx.a
{
  public int abQB;
  public int abQC;
  public String abQD;
  public b abQE;
  public int abQF;
  public int abQG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82481);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abQB);
      paramVarArgs.bS(2, this.abQC);
      if (this.abQD != null) {
        paramVarArgs.g(3, this.abQD);
      }
      if (this.abQE != null) {
        paramVarArgs.d(4, this.abQE);
      }
      paramVarArgs.bS(5, this.abQF);
      paramVarArgs.bS(6, this.abQG);
      AppMethodBeat.o(82481);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.abQB) + 0 + i.a.a.b.b.a.cJ(2, this.abQC);
      paramInt = i;
      if (this.abQD != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.abQD);
      }
      i = paramInt;
      if (this.abQE != null) {
        i = paramInt + i.a.a.b.b.a.c(4, this.abQE);
      }
      paramInt = i.a.a.b.b.a.cJ(5, this.abQF);
      int j = i.a.a.b.b.a.cJ(6, this.abQG);
      AppMethodBeat.o(82481);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(82481);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fqq localfqq = (fqq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(82481);
        return -1;
      case 1: 
        localfqq.abQB = locala.ajGk.aar();
        AppMethodBeat.o(82481);
        return 0;
      case 2: 
        localfqq.abQC = locala.ajGk.aar();
        AppMethodBeat.o(82481);
        return 0;
      case 3: 
        localfqq.abQD = locala.ajGk.readString();
        AppMethodBeat.o(82481);
        return 0;
      case 4: 
        localfqq.abQE = locala.ajGk.kFX();
        AppMethodBeat.o(82481);
        return 0;
      case 5: 
        localfqq.abQF = locala.ajGk.aar();
        AppMethodBeat.o(82481);
        return 0;
      }
      localfqq.abQG = locala.ajGk.aar();
      AppMethodBeat.o(82481);
      return 0;
    }
    AppMethodBeat.o(82481);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fqq
 * JD-Core Version:    0.7.0.1
 */