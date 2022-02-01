package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class acc
  extends com.tencent.mm.bw.a
{
  public boolean LmF;
  public int LmG;
  public int dUS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(225289);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.dUS);
      paramVarArgs.cc(2, this.LmF);
      paramVarArgs.aM(3, this.LmG);
      AppMethodBeat.o(225289);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.dUS);
      int i = g.a.a.b.b.a.fS(2);
      int j = g.a.a.b.b.a.bu(3, this.LmG);
      AppMethodBeat.o(225289);
      return paramInt + 0 + (i + 1) + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(225289);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      acc localacc = (acc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(225289);
        return -1;
      case 1: 
        localacc.dUS = locala.UbS.zi();
        AppMethodBeat.o(225289);
        return 0;
      case 2: 
        localacc.LmF = locala.UbS.yZ();
        AppMethodBeat.o(225289);
        return 0;
      }
      localacc.LmG = locala.UbS.zi();
      AppMethodBeat.o(225289);
      return 0;
    }
    AppMethodBeat.o(225289);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acc
 * JD-Core Version:    0.7.0.1
 */