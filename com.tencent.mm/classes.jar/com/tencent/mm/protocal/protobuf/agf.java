package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class agf
  extends com.tencent.mm.bw.a
{
  public int Lqt;
  public int Lqu;
  public String info;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125721);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Lqt);
      paramVarArgs.aM(2, this.Lqu);
      if (this.info != null) {
        paramVarArgs.e(3, this.info);
      }
      AppMethodBeat.o(125721);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.Lqt) + 0 + g.a.a.b.b.a.bu(2, this.Lqu);
      paramInt = i;
      if (this.info != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.info);
      }
      AppMethodBeat.o(125721);
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
      AppMethodBeat.o(125721);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      agf localagf = (agf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125721);
        return -1;
      case 1: 
        localagf.Lqt = locala.UbS.zi();
        AppMethodBeat.o(125721);
        return 0;
      case 2: 
        localagf.Lqu = locala.UbS.zi();
        AppMethodBeat.o(125721);
        return 0;
      }
      localagf.info = locala.UbS.readString();
      AppMethodBeat.o(125721);
      return 0;
    }
    AppMethodBeat.o(125721);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agf
 * JD-Core Version:    0.7.0.1
 */