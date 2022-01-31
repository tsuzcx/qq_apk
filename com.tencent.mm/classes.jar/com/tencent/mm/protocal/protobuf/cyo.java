package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cyo
  extends com.tencent.mm.bv.a
{
  public int xrc;
  public String yfF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(126193);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xrc);
      if (this.yfF != null) {
        paramVarArgs.e(2, this.yfF);
      }
      AppMethodBeat.o(126193);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.xrc) + 0;
      paramInt = i;
      if (this.yfF != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.yfF);
      }
      AppMethodBeat.o(126193);
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
      AppMethodBeat.o(126193);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cyo localcyo = (cyo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(126193);
        return -1;
      case 1: 
        localcyo.xrc = locala.CLY.sl();
        AppMethodBeat.o(126193);
        return 0;
      }
      localcyo.yfF = locala.CLY.readString();
      AppMethodBeat.o(126193);
      return 0;
    }
    AppMethodBeat.o(126193);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyo
 * JD-Core Version:    0.7.0.1
 */