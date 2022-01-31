package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends com.tencent.mm.bv.a
{
  public int month;
  public String ppS;
  public int year;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56617);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.year);
      paramVarArgs.aO(2, this.month);
      if (this.ppS != null) {
        paramVarArgs.e(3, this.ppS);
      }
      AppMethodBeat.o(56617);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.year) + 0 + e.a.a.b.b.a.bl(2, this.month);
      paramInt = i;
      if (this.ppS != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.ppS);
      }
      AppMethodBeat.o(56617);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(56617);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(56617);
        return -1;
      case 1: 
        locald.year = locala.CLY.sl();
        AppMethodBeat.o(56617);
        return 0;
      case 2: 
        locald.month = locala.CLY.sl();
        AppMethodBeat.o(56617);
        return 0;
      }
      locald.ppS = locala.CLY.readString();
      AppMethodBeat.o(56617);
      return 0;
    }
    AppMethodBeat.o(56617);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.d
 * JD-Core Version:    0.7.0.1
 */