package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cvl
  extends com.tencent.mm.bv.a
{
  public String url;
  public int ydS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56998);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.ydS);
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      AppMethodBeat.o(56998);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.ydS) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.url);
      }
      AppMethodBeat.o(56998);
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
      AppMethodBeat.o(56998);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cvl localcvl = (cvl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(56998);
        return -1;
      case 1: 
        localcvl.ydS = locala.CLY.sl();
        AppMethodBeat.o(56998);
        return 0;
      }
      localcvl.url = locala.CLY.readString();
      AppMethodBeat.o(56998);
      return 0;
    }
    AppMethodBeat.o(56998);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvl
 * JD-Core Version:    0.7.0.1
 */