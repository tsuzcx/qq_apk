package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class czj
  extends com.tencent.mm.bv.a
{
  public int lGK;
  public String lGL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96321);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.lGK);
      if (this.lGL != null) {
        paramVarArgs.e(2, this.lGL);
      }
      AppMethodBeat.o(96321);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.lGK) + 0;
      paramInt = i;
      if (this.lGL != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.lGL);
      }
      AppMethodBeat.o(96321);
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
      AppMethodBeat.o(96321);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      czj localczj = (czj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(96321);
        return -1;
      case 1: 
        localczj.lGK = locala.CLY.sl();
        AppMethodBeat.o(96321);
        return 0;
      }
      localczj.lGL = locala.CLY.readString();
      AppMethodBeat.o(96321);
      return 0;
    }
    AppMethodBeat.o(96321);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czj
 * JD-Core Version:    0.7.0.1
 */