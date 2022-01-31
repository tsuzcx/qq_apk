package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ui
  extends com.tencent.mm.bv.a
{
  public String Username;
  public int cnE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124307);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.cnE);
      if (this.Username != null) {
        paramVarArgs.e(2, this.Username);
      }
      AppMethodBeat.o(124307);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.cnE) + 0;
      paramInt = i;
      if (this.Username != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.Username);
      }
      AppMethodBeat.o(124307);
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
      AppMethodBeat.o(124307);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      ui localui = (ui)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124307);
        return -1;
      case 1: 
        localui.cnE = locala.CLY.sl();
        AppMethodBeat.o(124307);
        return 0;
      }
      localui.Username = locala.CLY.readString();
      AppMethodBeat.o(124307);
      return 0;
    }
    AppMethodBeat.o(124307);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ui
 * JD-Core Version:    0.7.0.1
 */