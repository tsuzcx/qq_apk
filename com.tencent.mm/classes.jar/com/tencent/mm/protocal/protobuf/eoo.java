package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eoo
  extends com.tencent.mm.bw.a
{
  public int dIZ;
  public String dJa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(74675);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.dIZ);
      if (this.dJa != null) {
        paramVarArgs.e(2, this.dJa);
      }
      AppMethodBeat.o(74675);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.dIZ) + 0;
      paramInt = i;
      if (this.dJa != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dJa);
      }
      AppMethodBeat.o(74675);
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
      AppMethodBeat.o(74675);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      eoo localeoo = (eoo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(74675);
        return -1;
      case 1: 
        localeoo.dIZ = locala.UbS.zi();
        AppMethodBeat.o(74675);
        return 0;
      }
      localeoo.dJa = locala.UbS.readString();
      AppMethodBeat.o(74675);
      return 0;
    }
    AppMethodBeat.o(74675);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eoo
 * JD-Core Version:    0.7.0.1
 */