package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cro
  extends com.tencent.mm.cd.a
{
  public int errCode;
  public String errMsg;
  public int errType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(229756);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.errType);
      paramVarArgs.aY(2, this.errCode);
      if (this.errMsg != null) {
        paramVarArgs.f(3, this.errMsg);
      }
      AppMethodBeat.o(229756);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.errType) + 0 + g.a.a.b.b.a.bM(2, this.errCode);
      paramInt = i;
      if (this.errMsg != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.errMsg);
      }
      AppMethodBeat.o(229756);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(229756);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cro localcro = (cro)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(229756);
        return -1;
      case 1: 
        localcro.errType = locala.abFh.AK();
        AppMethodBeat.o(229756);
        return 0;
      case 2: 
        localcro.errCode = locala.abFh.AK();
        AppMethodBeat.o(229756);
        return 0;
      }
      localcro.errMsg = locala.abFh.readString();
      AppMethodBeat.o(229756);
      return 0;
    }
    AppMethodBeat.o(229756);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cro
 * JD-Core Version:    0.7.0.1
 */