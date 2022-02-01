package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class clo
  extends com.tencent.mm.bw.a
{
  public int MqO;
  public int MqP;
  public int MqQ;
  public int MqR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169923);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.MqO);
      paramVarArgs.aM(2, this.MqP);
      paramVarArgs.aM(3, this.MqQ);
      paramVarArgs.aM(4, this.MqR);
      AppMethodBeat.o(169923);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.MqO);
      int i = g.a.a.b.b.a.bu(2, this.MqP);
      int j = g.a.a.b.b.a.bu(3, this.MqQ);
      int k = g.a.a.b.b.a.bu(4, this.MqR);
      AppMethodBeat.o(169923);
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
      AppMethodBeat.o(169923);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      clo localclo = (clo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169923);
        return -1;
      case 1: 
        localclo.MqO = locala.UbS.zi();
        AppMethodBeat.o(169923);
        return 0;
      case 2: 
        localclo.MqP = locala.UbS.zi();
        AppMethodBeat.o(169923);
        return 0;
      case 3: 
        localclo.MqQ = locala.UbS.zi();
        AppMethodBeat.o(169923);
        return 0;
      }
      localclo.MqR = locala.UbS.zi();
      AppMethodBeat.o(169923);
      return 0;
    }
    AppMethodBeat.o(169923);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clo
 * JD-Core Version:    0.7.0.1
 */