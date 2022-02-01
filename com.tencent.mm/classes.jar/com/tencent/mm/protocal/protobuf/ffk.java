package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ffk
  extends com.tencent.mm.cd.a
{
  public String errmsg;
  public int fBP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147782);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.fBP);
      if (this.errmsg != null) {
        paramVarArgs.f(2, this.errmsg);
      }
      AppMethodBeat.o(147782);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.fBP) + 0;
      paramInt = i;
      if (this.errmsg != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.errmsg);
      }
      AppMethodBeat.o(147782);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(147782);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ffk localffk = (ffk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(147782);
        return -1;
      case 1: 
        localffk.fBP = locala.abFh.AK();
        AppMethodBeat.o(147782);
        return 0;
      }
      localffk.errmsg = locala.abFh.readString();
      AppMethodBeat.o(147782);
      return 0;
    }
    AppMethodBeat.o(147782);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ffk
 * JD-Core Version:    0.7.0.1
 */