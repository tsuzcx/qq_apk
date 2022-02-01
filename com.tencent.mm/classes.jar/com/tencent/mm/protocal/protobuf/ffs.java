package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ffs
  extends com.tencent.mm.bx.a
{
  public int abFF;
  public int abFG;
  public int pSq;
  public String pSr;
  public long pSs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43131);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.pSq);
      if (this.pSr != null) {
        paramVarArgs.g(2, this.pSr);
      }
      paramVarArgs.bv(3, this.pSs);
      paramVarArgs.bS(4, this.abFF);
      paramVarArgs.bS(5, this.abFG);
      AppMethodBeat.o(43131);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.pSq) + 0;
      paramInt = i;
      if (this.pSr != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.pSr);
      }
      i = i.a.a.b.b.a.q(3, this.pSs);
      int j = i.a.a.b.b.a.cJ(4, this.abFF);
      int k = i.a.a.b.b.a.cJ(5, this.abFG);
      AppMethodBeat.o(43131);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(43131);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ffs localffs = (ffs)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43131);
        return -1;
      case 1: 
        localffs.pSq = locala.ajGk.aar();
        AppMethodBeat.o(43131);
        return 0;
      case 2: 
        localffs.pSr = locala.ajGk.readString();
        AppMethodBeat.o(43131);
        return 0;
      case 3: 
        localffs.pSs = locala.ajGk.aaw();
        AppMethodBeat.o(43131);
        return 0;
      case 4: 
        localffs.abFF = locala.ajGk.aar();
        AppMethodBeat.o(43131);
        return 0;
      }
      localffs.abFG = locala.ajGk.aar();
      AppMethodBeat.o(43131);
      return 0;
    }
    AppMethodBeat.o(43131);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ffs
 * JD-Core Version:    0.7.0.1
 */