package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fbt
  extends com.tencent.mm.bw.a
{
  public int NxR;
  public int NxS;
  public int NxT;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196218);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.version);
      paramVarArgs.aM(2, this.NxR);
      paramVarArgs.aM(3, this.NxS);
      paramVarArgs.aM(4, this.NxT);
      AppMethodBeat.o(196218);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.version);
      int i = g.a.a.b.b.a.bu(2, this.NxR);
      int j = g.a.a.b.b.a.bu(3, this.NxS);
      int k = g.a.a.b.b.a.bu(4, this.NxT);
      AppMethodBeat.o(196218);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(196218);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fbt localfbt = (fbt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(196218);
        return -1;
      case 1: 
        localfbt.version = locala.UbS.zi();
        AppMethodBeat.o(196218);
        return 0;
      case 2: 
        localfbt.NxR = locala.UbS.zi();
        AppMethodBeat.o(196218);
        return 0;
      case 3: 
        localfbt.NxS = locala.UbS.zi();
        AppMethodBeat.o(196218);
        return 0;
      }
      localfbt.NxT = locala.UbS.zi();
      AppMethodBeat.o(196218);
      return 0;
    }
    AppMethodBeat.o(196218);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbt
 * JD-Core Version:    0.7.0.1
 */