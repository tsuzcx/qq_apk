package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bqn
  extends com.tencent.mm.bx.a
{
  public int ZYw;
  public String oUw;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257570);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      paramVarArgs.bS(2, this.ZYw);
      if (this.oUw != null) {
        paramVarArgs.g(3, this.oUw);
      }
      AppMethodBeat.o(257570);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.type) + 0 + i.a.a.b.b.a.cJ(2, this.ZYw);
      paramInt = i;
      if (this.oUw != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.oUw);
      }
      AppMethodBeat.o(257570);
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
      AppMethodBeat.o(257570);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bqn localbqn = (bqn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257570);
        return -1;
      case 1: 
        localbqn.type = locala.ajGk.aar();
        AppMethodBeat.o(257570);
        return 0;
      case 2: 
        localbqn.ZYw = locala.ajGk.aar();
        AppMethodBeat.o(257570);
        return 0;
      }
      localbqn.oUw = locala.ajGk.readString();
      AppMethodBeat.o(257570);
      return 0;
    }
    AppMethodBeat.o(257570);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqn
 * JD-Core Version:    0.7.0.1
 */