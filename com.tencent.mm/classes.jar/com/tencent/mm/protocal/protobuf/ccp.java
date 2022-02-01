package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ccp
  extends com.tencent.mm.bw.a
{
  public int Miv;
  public int Miw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82430);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Miv);
      paramVarArgs.aM(2, this.Miw);
      AppMethodBeat.o(82430);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.Miv);
      int i = g.a.a.b.b.a.bu(2, this.Miw);
      AppMethodBeat.o(82430);
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
      AppMethodBeat.o(82430);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ccp localccp = (ccp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(82430);
        return -1;
      case 1: 
        localccp.Miv = locala.UbS.zi();
        AppMethodBeat.o(82430);
        return 0;
      }
      localccp.Miw = locala.UbS.zi();
      AppMethodBeat.o(82430);
      return 0;
    }
    AppMethodBeat.o(82430);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccp
 * JD-Core Version:    0.7.0.1
 */