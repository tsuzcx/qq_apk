package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aie
  extends com.tencent.mm.bw.a
{
  public boolean LrL;
  public boolean LrM;
  public String LrN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113998);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.cc(1, this.LrL);
      paramVarArgs.cc(2, this.LrM);
      if (this.LrN != null) {
        paramVarArgs.e(3, this.LrN);
      }
      AppMethodBeat.o(113998);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.fS(1) + 1 + 0 + (g.a.a.b.b.a.fS(2) + 1);
      paramInt = i;
      if (this.LrN != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.LrN);
      }
      AppMethodBeat.o(113998);
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
      AppMethodBeat.o(113998);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      aie localaie = (aie)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(113998);
        return -1;
      case 1: 
        localaie.LrL = locala.UbS.yZ();
        AppMethodBeat.o(113998);
        return 0;
      case 2: 
        localaie.LrM = locala.UbS.yZ();
        AppMethodBeat.o(113998);
        return 0;
      }
      localaie.LrN = locala.UbS.readString();
      AppMethodBeat.o(113998);
      return 0;
    }
    AppMethodBeat.o(113998);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aie
 * JD-Core Version:    0.7.0.1
 */