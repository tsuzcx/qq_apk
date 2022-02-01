package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class buw
  extends com.tencent.mm.bx.a
{
  public String query;
  public long timestamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169046);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.timestamp);
      if (this.query != null) {
        paramVarArgs.g(2, this.query);
      }
      AppMethodBeat.o(169046);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.timestamp) + 0;
      paramInt = i;
      if (this.query != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.query);
      }
      AppMethodBeat.o(169046);
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
      AppMethodBeat.o(169046);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      buw localbuw = (buw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169046);
        return -1;
      case 1: 
        localbuw.timestamp = locala.ajGk.aaw();
        AppMethodBeat.o(169046);
        return 0;
      }
      localbuw.query = locala.ajGk.readString();
      AppMethodBeat.o(169046);
      return 0;
    }
    AppMethodBeat.o(169046);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buw
 * JD-Core Version:    0.7.0.1
 */