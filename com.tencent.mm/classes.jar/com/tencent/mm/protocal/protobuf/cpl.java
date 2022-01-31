package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cpl
  extends com.tencent.mm.bv.a
{
  public int errCode;
  public String errMsg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(102391);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.errCode);
      if (this.errMsg != null) {
        paramVarArgs.e(2, this.errMsg);
      }
      AppMethodBeat.o(102391);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.errCode) + 0;
      paramInt = i;
      if (this.errMsg != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.errMsg);
      }
      AppMethodBeat.o(102391);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(102391);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cpl localcpl = (cpl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(102391);
        return -1;
      case 1: 
        localcpl.errCode = locala.CLY.sl();
        AppMethodBeat.o(102391);
        return 0;
      }
      localcpl.errMsg = locala.CLY.readString();
      AppMethodBeat.o(102391);
      return 0;
    }
    AppMethodBeat.o(102391);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpl
 * JD-Core Version:    0.7.0.1
 */