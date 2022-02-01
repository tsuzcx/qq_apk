package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cju
  extends com.tencent.mm.bw.a
{
  public int KXD;
  public int Mel;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(175246);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.KXD);
      paramVarArgs.aM(2, this.Mel);
      AppMethodBeat.o(175246);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.KXD);
      int i = g.a.a.b.b.a.bu(2, this.Mel);
      AppMethodBeat.o(175246);
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
      AppMethodBeat.o(175246);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cju localcju = (cju)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(175246);
        return -1;
      case 1: 
        localcju.KXD = locala.UbS.zi();
        AppMethodBeat.o(175246);
        return 0;
      }
      localcju.Mel = locala.UbS.zi();
      AppMethodBeat.o(175246);
      return 0;
    }
    AppMethodBeat.o(175246);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cju
 * JD-Core Version:    0.7.0.1
 */