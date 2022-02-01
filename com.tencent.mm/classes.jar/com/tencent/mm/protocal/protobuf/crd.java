package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class crd
  extends com.tencent.mm.bw.a
{
  public int Mwu;
  public int Mwv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143984);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Mwu);
      paramVarArgs.aM(2, this.Mwv);
      AppMethodBeat.o(143984);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.Mwu);
      int i = g.a.a.b.b.a.bu(2, this.Mwv);
      AppMethodBeat.o(143984);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(143984);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      crd localcrd = (crd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143984);
        return -1;
      case 1: 
        localcrd.Mwu = locala.UbS.zi();
        AppMethodBeat.o(143984);
        return 0;
      }
      localcrd.Mwv = locala.UbS.zi();
      AppMethodBeat.o(143984);
      return 0;
    }
    AppMethodBeat.o(143984);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crd
 * JD-Core Version:    0.7.0.1
 */