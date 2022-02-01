package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dim
  extends com.tencent.mm.bx.a
{
  public int errCode;
  public String errMsg;
  public int errType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260195);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.errType);
      paramVarArgs.bS(2, this.errCode);
      if (this.errMsg != null) {
        paramVarArgs.g(3, this.errMsg);
      }
      AppMethodBeat.o(260195);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.errType) + 0 + i.a.a.b.b.a.cJ(2, this.errCode);
      paramInt = i;
      if (this.errMsg != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.errMsg);
      }
      AppMethodBeat.o(260195);
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
      AppMethodBeat.o(260195);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dim localdim = (dim)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(260195);
        return -1;
      case 1: 
        localdim.errType = locala.ajGk.aar();
        AppMethodBeat.o(260195);
        return 0;
      case 2: 
        localdim.errCode = locala.ajGk.aar();
        AppMethodBeat.o(260195);
        return 0;
      }
      localdim.errMsg = locala.ajGk.readString();
      AppMethodBeat.o(260195);
      return 0;
    }
    AppMethodBeat.o(260195);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dim
 * JD-Core Version:    0.7.0.1
 */