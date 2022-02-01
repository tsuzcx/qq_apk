package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fly
  extends com.tencent.mm.cd.a
{
  public String UKN;
  public boolean UKO;
  public int UKP;
  public int UKQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110856);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UKN != null) {
        paramVarArgs.f(1, this.UKN);
      }
      paramVarArgs.co(2, this.UKO);
      paramVarArgs.aY(3, this.UKP);
      paramVarArgs.aY(4, this.UKQ);
      AppMethodBeat.o(110856);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UKN == null) {
        break label350;
      }
    }
    label350:
    for (paramInt = g.a.a.b.b.a.g(1, this.UKN) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.gL(2);
      int j = g.a.a.b.b.a.bM(3, this.UKP);
      int k = g.a.a.b.b.a.bM(4, this.UKQ);
      AppMethodBeat.o(110856);
      return paramInt + (i + 1) + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(110856);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fly localfly = (fly)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(110856);
          return -1;
        case 1: 
          localfly.UKN = locala.abFh.readString();
          AppMethodBeat.o(110856);
          return 0;
        case 2: 
          localfly.UKO = locala.abFh.AB();
          AppMethodBeat.o(110856);
          return 0;
        case 3: 
          localfly.UKP = locala.abFh.AK();
          AppMethodBeat.o(110856);
          return 0;
        }
        localfly.UKQ = locala.abFh.AK();
        AppMethodBeat.o(110856);
        return 0;
      }
      AppMethodBeat.o(110856);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fly
 * JD-Core Version:    0.7.0.1
 */