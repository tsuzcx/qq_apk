package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class crd
  extends com.tencent.mm.bv.a
{
  public int wrs;
  public int wrt;
  public int wru;
  public int wrv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28701);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wrs);
      paramVarArgs.aO(2, this.wrt);
      paramVarArgs.aO(3, this.wru);
      paramVarArgs.aO(4, this.wrv);
      AppMethodBeat.o(28701);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.wrs);
      int i = e.a.a.b.b.a.bl(2, this.wrt);
      int j = e.a.a.b.b.a.bl(3, this.wru);
      int k = e.a.a.b.b.a.bl(4, this.wrv);
      AppMethodBeat.o(28701);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(28701);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      crd localcrd = (crd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(28701);
        return -1;
      case 1: 
        localcrd.wrs = locala.CLY.sl();
        AppMethodBeat.o(28701);
        return 0;
      case 2: 
        localcrd.wrt = locala.CLY.sl();
        AppMethodBeat.o(28701);
        return 0;
      case 3: 
        localcrd.wru = locala.CLY.sl();
        AppMethodBeat.o(28701);
        return 0;
      }
      localcrd.wrv = locala.CLY.sl();
      AppMethodBeat.o(28701);
      return 0;
    }
    AppMethodBeat.o(28701);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crd
 * JD-Core Version:    0.7.0.1
 */