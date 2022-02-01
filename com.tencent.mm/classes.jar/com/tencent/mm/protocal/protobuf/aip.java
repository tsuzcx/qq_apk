package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aip
  extends com.tencent.mm.cd.a
{
  public boolean Sti;
  public boolean Stj;
  public String Stk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113998);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.co(1, this.Sti);
      paramVarArgs.co(2, this.Stj);
      if (this.Stk != null) {
        paramVarArgs.f(3, this.Stk);
      }
      AppMethodBeat.o(113998);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.gL(1) + 1 + 0 + (g.a.a.b.b.a.gL(2) + 1);
      paramInt = i;
      if (this.Stk != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.Stk);
      }
      AppMethodBeat.o(113998);
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
      AppMethodBeat.o(113998);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      aip localaip = (aip)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(113998);
        return -1;
      case 1: 
        localaip.Sti = locala.abFh.AB();
        AppMethodBeat.o(113998);
        return 0;
      case 2: 
        localaip.Stj = locala.abFh.AB();
        AppMethodBeat.o(113998);
        return 0;
      }
      localaip.Stk = locala.abFh.readString();
      AppMethodBeat.o(113998);
      return 0;
    }
    AppMethodBeat.o(113998);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aip
 * JD-Core Version:    0.7.0.1
 */