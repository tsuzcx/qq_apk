package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cit
  extends com.tencent.mm.bw.a
{
  public int errCode;
  public String errMsg;
  public int errType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209724);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.errType);
      paramVarArgs.aM(2, this.errCode);
      if (this.errMsg != null) {
        paramVarArgs.e(3, this.errMsg);
      }
      AppMethodBeat.o(209724);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.errType) + 0 + g.a.a.b.b.a.bu(2, this.errCode);
      paramInt = i;
      if (this.errMsg != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.errMsg);
      }
      AppMethodBeat.o(209724);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209724);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cit localcit = (cit)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209724);
        return -1;
      case 1: 
        localcit.errType = locala.UbS.zi();
        AppMethodBeat.o(209724);
        return 0;
      case 2: 
        localcit.errCode = locala.UbS.zi();
        AppMethodBeat.o(209724);
        return 0;
      }
      localcit.errMsg = locala.UbS.readString();
      AppMethodBeat.o(209724);
      return 0;
    }
    AppMethodBeat.o(209724);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cit
 * JD-Core Version:    0.7.0.1
 */