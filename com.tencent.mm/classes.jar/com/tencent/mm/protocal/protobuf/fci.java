package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fci
  extends com.tencent.mm.cd.a
{
  public int RCo;
  public String UCl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195960);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.RCo);
      if (this.UCl != null) {
        paramVarArgs.f(2, this.UCl);
      }
      AppMethodBeat.o(195960);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.RCo) + 0;
      paramInt = i;
      if (this.UCl != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UCl);
      }
      AppMethodBeat.o(195960);
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
      AppMethodBeat.o(195960);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fci localfci = (fci)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(195960);
        return -1;
      case 1: 
        localfci.RCo = locala.abFh.AK();
        AppMethodBeat.o(195960);
        return 0;
      }
      localfci.UCl = locala.abFh.readString();
      AppMethodBeat.o(195960);
      return 0;
    }
    AppMethodBeat.o(195960);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fci
 * JD-Core Version:    0.7.0.1
 */