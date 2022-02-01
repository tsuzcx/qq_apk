package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class deu
  extends com.tencent.mm.bw.a
{
  public long KVb;
  public long MJN;
  public int pVV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104829);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.pVV);
      paramVarArgs.bb(2, this.KVb);
      paramVarArgs.bb(3, this.MJN);
      AppMethodBeat.o(104829);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.pVV);
      int i = g.a.a.b.b.a.r(2, this.KVb);
      int j = g.a.a.b.b.a.r(3, this.MJN);
      AppMethodBeat.o(104829);
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
      AppMethodBeat.o(104829);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      deu localdeu = (deu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104829);
        return -1;
      case 1: 
        localdeu.pVV = locala.UbS.zi();
        AppMethodBeat.o(104829);
        return 0;
      case 2: 
        localdeu.KVb = locala.UbS.zl();
        AppMethodBeat.o(104829);
        return 0;
      }
      localdeu.MJN = locala.UbS.zl();
      AppMethodBeat.o(104829);
      return 0;
    }
    AppMethodBeat.o(104829);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.deu
 * JD-Core Version:    0.7.0.1
 */