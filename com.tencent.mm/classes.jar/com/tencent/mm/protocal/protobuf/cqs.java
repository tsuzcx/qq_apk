package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cqs
  extends com.tencent.mm.bv.a
{
  public int type;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96316);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.type);
      paramVarArgs.aO(2, this.version);
      AppMethodBeat.o(96316);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.type);
      int i = e.a.a.b.b.a.bl(2, this.version);
      AppMethodBeat.o(96316);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(96316);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cqs localcqs = (cqs)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(96316);
        return -1;
      case 1: 
        localcqs.type = locala.CLY.sl();
        AppMethodBeat.o(96316);
        return 0;
      }
      localcqs.version = locala.CLY.sl();
      AppMethodBeat.o(96316);
      return 0;
    }
    AppMethodBeat.o(96316);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqs
 * JD-Core Version:    0.7.0.1
 */