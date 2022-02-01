package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class drp
  extends com.tencent.mm.bw.a
{
  public int MUj;
  public int Timestamp;
  public int him;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117906);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.MUj);
      paramVarArgs.aM(2, this.Timestamp);
      paramVarArgs.aM(3, this.him);
      AppMethodBeat.o(117906);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.MUj);
      int i = g.a.a.b.b.a.bu(2, this.Timestamp);
      int j = g.a.a.b.b.a.bu(3, this.him);
      AppMethodBeat.o(117906);
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
      AppMethodBeat.o(117906);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      drp localdrp = (drp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117906);
        return -1;
      case 1: 
        localdrp.MUj = locala.UbS.zi();
        AppMethodBeat.o(117906);
        return 0;
      case 2: 
        localdrp.Timestamp = locala.UbS.zi();
        AppMethodBeat.o(117906);
        return 0;
      }
      localdrp.him = locala.UbS.zi();
      AppMethodBeat.o(117906);
      return 0;
    }
    AppMethodBeat.o(117906);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drp
 * JD-Core Version:    0.7.0.1
 */