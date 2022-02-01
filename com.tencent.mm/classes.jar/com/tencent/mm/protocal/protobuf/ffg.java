package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ffg
  extends com.tencent.mm.cd.a
{
  public String Username;
  public int rVU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115924);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Username != null) {
        paramVarArgs.f(1, this.Username);
      }
      paramVarArgs.aY(2, this.rVU);
      AppMethodBeat.o(115924);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = g.a.a.b.b.a.g(1, this.Username) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.rVU);
      AppMethodBeat.o(115924);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(115924);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ffg localffg = (ffg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(115924);
          return -1;
        case 1: 
          localffg.Username = locala.abFh.readString();
          AppMethodBeat.o(115924);
          return 0;
        }
        localffg.rVU = locala.abFh.AK();
        AppMethodBeat.o(115924);
        return 0;
      }
      AppMethodBeat.o(115924);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ffg
 * JD-Core Version:    0.7.0.1
 */