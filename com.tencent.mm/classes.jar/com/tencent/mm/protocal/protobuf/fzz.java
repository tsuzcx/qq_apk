package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class fzz
  extends com.tencent.mm.bx.a
{
  public long ZvA;
  public long abKe;
  public int abXJ;
  public int abXK;
  public int abXL;
  public int abXM;
  public b abXN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125501);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.abKe);
      paramVarArgs.bv(2, this.ZvA);
      paramVarArgs.bS(3, this.abXJ);
      paramVarArgs.bS(4, this.abXK);
      paramVarArgs.bS(5, this.abXL);
      paramVarArgs.bS(6, this.abXM);
      if (this.abXN != null) {
        paramVarArgs.d(7, this.abXN);
      }
      AppMethodBeat.o(125501);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.abKe) + 0 + i.a.a.b.b.a.q(2, this.ZvA) + i.a.a.b.b.a.cJ(3, this.abXJ) + i.a.a.b.b.a.cJ(4, this.abXK) + i.a.a.b.b.a.cJ(5, this.abXL) + i.a.a.b.b.a.cJ(6, this.abXM);
      paramInt = i;
      if (this.abXN != null) {
        paramInt = i + i.a.a.b.b.a.c(7, this.abXN);
      }
      AppMethodBeat.o(125501);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(125501);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fzz localfzz = (fzz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125501);
        return -1;
      case 1: 
        localfzz.abKe = locala.ajGk.aaw();
        AppMethodBeat.o(125501);
        return 0;
      case 2: 
        localfzz.ZvA = locala.ajGk.aaw();
        AppMethodBeat.o(125501);
        return 0;
      case 3: 
        localfzz.abXJ = locala.ajGk.aar();
        AppMethodBeat.o(125501);
        return 0;
      case 4: 
        localfzz.abXK = locala.ajGk.aar();
        AppMethodBeat.o(125501);
        return 0;
      case 5: 
        localfzz.abXL = locala.ajGk.aar();
        AppMethodBeat.o(125501);
        return 0;
      case 6: 
        localfzz.abXM = locala.ajGk.aar();
        AppMethodBeat.o(125501);
        return 0;
      }
      localfzz.abXN = locala.ajGk.kFX();
      AppMethodBeat.o(125501);
      return 0;
    }
    AppMethodBeat.o(125501);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fzz
 * JD-Core Version:    0.7.0.1
 */