package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ebo
  extends com.tencent.mm.bw.a
{
  public int Nbm;
  public int Nbn;
  public long Nbo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125839);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Nbm);
      paramVarArgs.aM(2, this.Nbn);
      paramVarArgs.bb(3, this.Nbo);
      AppMethodBeat.o(125839);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.Nbm);
      int i = g.a.a.b.b.a.bu(2, this.Nbn);
      int j = g.a.a.b.b.a.r(3, this.Nbo);
      AppMethodBeat.o(125839);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(125839);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ebo localebo = (ebo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125839);
        return -1;
      case 1: 
        localebo.Nbm = locala.UbS.zi();
        AppMethodBeat.o(125839);
        return 0;
      case 2: 
        localebo.Nbn = locala.UbS.zi();
        AppMethodBeat.o(125839);
        return 0;
      }
      localebo.Nbo = locala.UbS.zl();
      AppMethodBeat.o(125839);
      return 0;
    }
    AppMethodBeat.o(125839);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebo
 * JD-Core Version:    0.7.0.1
 */