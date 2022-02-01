package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dew
  extends com.tencent.mm.bw.a
{
  public String dWe;
  public int dWf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(19408);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.dWf);
      if (this.dWe != null) {
        paramVarArgs.e(2, this.dWe);
      }
      AppMethodBeat.o(19408);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.dWf) + 0;
      paramInt = i;
      if (this.dWe != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dWe);
      }
      AppMethodBeat.o(19408);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(19408);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dew localdew = (dew)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(19408);
        return -1;
      case 1: 
        localdew.dWf = locala.UbS.zi();
        AppMethodBeat.o(19408);
        return 0;
      }
      localdew.dWe = locala.UbS.readString();
      AppMethodBeat.o(19408);
      return 0;
    }
    AppMethodBeat.o(19408);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dew
 * JD-Core Version:    0.7.0.1
 */