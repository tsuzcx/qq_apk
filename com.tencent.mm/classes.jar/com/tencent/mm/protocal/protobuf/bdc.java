package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bdc
  extends com.tencent.mm.bw.a
{
  public int LMU;
  public int LMV;
  public String config;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209691);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.LMU);
      if (this.config != null) {
        paramVarArgs.e(2, this.config);
      }
      paramVarArgs.aM(3, this.LMV);
      AppMethodBeat.o(209691);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.LMU) + 0;
      paramInt = i;
      if (this.config != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.config);
      }
      i = g.a.a.b.b.a.bu(3, this.LMV);
      AppMethodBeat.o(209691);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209691);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bdc localbdc = (bdc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209691);
        return -1;
      case 1: 
        localbdc.LMU = locala.UbS.zi();
        AppMethodBeat.o(209691);
        return 0;
      case 2: 
        localbdc.config = locala.UbS.readString();
        AppMethodBeat.o(209691);
        return 0;
      }
      localbdc.LMV = locala.UbS.zi();
      AppMethodBeat.o(209691);
      return 0;
    }
    AppMethodBeat.o(209691);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdc
 * JD-Core Version:    0.7.0.1
 */