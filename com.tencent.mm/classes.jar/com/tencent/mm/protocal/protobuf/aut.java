package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aut
  extends com.tencent.mm.bw.a
{
  public boolean GLK;
  public boolean GLL;
  public boolean GLM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116470);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bC(1, this.GLK);
      paramVarArgs.bC(2, this.GLL);
      paramVarArgs.bC(3, this.GLM);
      AppMethodBeat.o(116470);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.amF(1);
      int i = f.a.a.b.b.a.amF(2);
      int j = f.a.a.b.b.a.amF(3);
      AppMethodBeat.o(116470);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(116470);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aut localaut = (aut)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(116470);
        return -1;
      case 1: 
        localaut.GLK = locala.OmT.gvY();
        AppMethodBeat.o(116470);
        return 0;
      case 2: 
        localaut.GLL = locala.OmT.gvY();
        AppMethodBeat.o(116470);
        return 0;
      }
      localaut.GLM = locala.OmT.gvY();
      AppMethodBeat.o(116470);
      return 0;
    }
    AppMethodBeat.o(116470);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aut
 * JD-Core Version:    0.7.0.1
 */