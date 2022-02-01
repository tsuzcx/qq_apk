package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fuv
  extends com.tencent.mm.bx.a
{
  public int aaaw;
  public int abSN;
  public int business_type;
  public long timestamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258886);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aaaw);
      paramVarArgs.bS(2, this.business_type);
      paramVarArgs.bv(3, this.timestamp);
      paramVarArgs.bS(4, this.abSN);
      AppMethodBeat.o(258886);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.aaaw);
      int i = i.a.a.b.b.a.cJ(2, this.business_type);
      int j = i.a.a.b.b.a.q(3, this.timestamp);
      int k = i.a.a.b.b.a.cJ(4, this.abSN);
      AppMethodBeat.o(258886);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258886);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fuv localfuv = (fuv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258886);
        return -1;
      case 1: 
        localfuv.aaaw = locala.ajGk.aar();
        AppMethodBeat.o(258886);
        return 0;
      case 2: 
        localfuv.business_type = locala.ajGk.aar();
        AppMethodBeat.o(258886);
        return 0;
      case 3: 
        localfuv.timestamp = locala.ajGk.aaw();
        AppMethodBeat.o(258886);
        return 0;
      }
      localfuv.abSN = locala.ajGk.aar();
      AppMethodBeat.o(258886);
      return 0;
    }
    AppMethodBeat.o(258886);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fuv
 * JD-Core Version:    0.7.0.1
 */