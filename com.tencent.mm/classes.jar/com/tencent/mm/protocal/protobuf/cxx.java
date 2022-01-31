package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cxx
  extends com.tencent.mm.bv.a
{
  public int Ret;
  public int wsb;
  public long wsz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28762);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.Ret);
      paramVarArgs.aO(2, this.wsb);
      paramVarArgs.am(3, this.wsz);
      AppMethodBeat.o(28762);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.Ret);
      int i = e.a.a.b.b.a.bl(2, this.wsb);
      int j = e.a.a.b.b.a.p(3, this.wsz);
      AppMethodBeat.o(28762);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(28762);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cxx localcxx = (cxx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(28762);
        return -1;
      case 1: 
        localcxx.Ret = locala.CLY.sl();
        AppMethodBeat.o(28762);
        return 0;
      case 2: 
        localcxx.wsb = locala.CLY.sl();
        AppMethodBeat.o(28762);
        return 0;
      }
      localcxx.wsz = locala.CLY.sm();
      AppMethodBeat.o(28762);
      return 0;
    }
    AppMethodBeat.o(28762);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxx
 * JD-Core Version:    0.7.0.1
 */