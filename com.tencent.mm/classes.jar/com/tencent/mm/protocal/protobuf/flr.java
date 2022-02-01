package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class flr
  extends com.tencent.mm.bx.a
{
  public long YKn;
  public long YKq;
  public int abMf;
  public String abMg;
  public int abMh;
  public int abMi;
  public int abMj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258956);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.YKq);
      paramVarArgs.bS(2, this.abMf);
      if (this.abMg != null) {
        paramVarArgs.g(3, this.abMg);
      }
      paramVarArgs.bv(4, this.YKn);
      paramVarArgs.bS(5, this.abMh);
      paramVarArgs.bS(6, this.abMi);
      paramVarArgs.bS(7, this.abMj);
      AppMethodBeat.o(258956);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.YKq) + 0 + i.a.a.b.b.a.cJ(2, this.abMf);
      paramInt = i;
      if (this.abMg != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.abMg);
      }
      i = i.a.a.b.b.a.q(4, this.YKn);
      int j = i.a.a.b.b.a.cJ(5, this.abMh);
      int k = i.a.a.b.b.a.cJ(6, this.abMi);
      int m = i.a.a.b.b.a.cJ(7, this.abMj);
      AppMethodBeat.o(258956);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258956);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      flr localflr = (flr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258956);
        return -1;
      case 1: 
        localflr.YKq = locala.ajGk.aaw();
        AppMethodBeat.o(258956);
        return 0;
      case 2: 
        localflr.abMf = locala.ajGk.aar();
        AppMethodBeat.o(258956);
        return 0;
      case 3: 
        localflr.abMg = locala.ajGk.readString();
        AppMethodBeat.o(258956);
        return 0;
      case 4: 
        localflr.YKn = locala.ajGk.aaw();
        AppMethodBeat.o(258956);
        return 0;
      case 5: 
        localflr.abMh = locala.ajGk.aar();
        AppMethodBeat.o(258956);
        return 0;
      case 6: 
        localflr.abMi = locala.ajGk.aar();
        AppMethodBeat.o(258956);
        return 0;
      }
      localflr.abMj = locala.ajGk.aar();
      AppMethodBeat.o(258956);
      return 0;
    }
    AppMethodBeat.o(258956);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.flr
 * JD-Core Version:    0.7.0.1
 */