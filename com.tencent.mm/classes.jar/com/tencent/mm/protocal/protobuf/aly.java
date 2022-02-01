package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aly
  extends com.tencent.mm.bx.a
{
  public int index;
  public String name;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257800);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.index);
      paramVarArgs.bS(2, this.type);
      if (this.name != null) {
        paramVarArgs.g(3, this.name);
      }
      AppMethodBeat.o(257800);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.index) + 0 + i.a.a.b.b.a.cJ(2, this.type);
      paramInt = i;
      if (this.name != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.name);
      }
      AppMethodBeat.o(257800);
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
      AppMethodBeat.o(257800);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      aly localaly = (aly)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257800);
        return -1;
      case 1: 
        localaly.index = locala.ajGk.aar();
        AppMethodBeat.o(257800);
        return 0;
      case 2: 
        localaly.type = locala.ajGk.aar();
        AppMethodBeat.o(257800);
        return 0;
      }
      localaly.name = locala.ajGk.readString();
      AppMethodBeat.o(257800);
      return 0;
    }
    AppMethodBeat.o(257800);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aly
 * JD-Core Version:    0.7.0.1
 */