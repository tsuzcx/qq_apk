package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fjq
  extends com.tencent.mm.bx.a
{
  public int OzG;
  public String abKm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133200);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.OzG);
      if (this.abKm != null) {
        paramVarArgs.g(2, this.abKm);
      }
      AppMethodBeat.o(133200);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.OzG) + 0;
      paramInt = i;
      if (this.abKm != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abKm);
      }
      AppMethodBeat.o(133200);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(133200);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fjq localfjq = (fjq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(133200);
        return -1;
      case 1: 
        localfjq.OzG = locala.ajGk.aar();
        AppMethodBeat.o(133200);
        return 0;
      }
      localfjq.abKm = locala.ajGk.readString();
      AppMethodBeat.o(133200);
      return 0;
    }
    AppMethodBeat.o(133200);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fjq
 * JD-Core Version:    0.7.0.1
 */