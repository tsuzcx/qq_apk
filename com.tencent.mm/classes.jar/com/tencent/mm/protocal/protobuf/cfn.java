package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cfn
  extends com.tencent.mm.bv.a
{
  public int wPd;
  public int xPT;
  public int xPU;
  public int xoD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94627);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wPd);
      paramVarArgs.aO(2, this.xoD);
      paramVarArgs.aO(3, this.xPT);
      paramVarArgs.aO(4, this.xPU);
      AppMethodBeat.o(94627);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.wPd);
      int i = e.a.a.b.b.a.bl(2, this.xoD);
      int j = e.a.a.b.b.a.bl(3, this.xPT);
      int k = e.a.a.b.b.a.bl(4, this.xPU);
      AppMethodBeat.o(94627);
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
      AppMethodBeat.o(94627);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cfn localcfn = (cfn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(94627);
        return -1;
      case 1: 
        localcfn.wPd = locala.CLY.sl();
        AppMethodBeat.o(94627);
        return 0;
      case 2: 
        localcfn.xoD = locala.CLY.sl();
        AppMethodBeat.o(94627);
        return 0;
      case 3: 
        localcfn.xPT = locala.CLY.sl();
        AppMethodBeat.o(94627);
        return 0;
      }
      localcfn.xPU = locala.CLY.sl();
      AppMethodBeat.o(94627);
      return 0;
    }
    AppMethodBeat.o(94627);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfn
 * JD-Core Version:    0.7.0.1
 */