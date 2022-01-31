package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cjh
  extends com.tencent.mm.bv.a
{
  public String xTA;
  public int xTy;
  public String xTz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124366);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xTy);
      if (this.xTz != null) {
        paramVarArgs.e(2, this.xTz);
      }
      if (this.xTA != null) {
        paramVarArgs.e(3, this.xTA);
      }
      AppMethodBeat.o(124366);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.xTy) + 0;
      paramInt = i;
      if (this.xTz != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xTz);
      }
      i = paramInt;
      if (this.xTA != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xTA);
      }
      AppMethodBeat.o(124366);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(124366);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cjh localcjh = (cjh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124366);
        return -1;
      case 1: 
        localcjh.xTy = locala.CLY.sl();
        AppMethodBeat.o(124366);
        return 0;
      case 2: 
        localcjh.xTz = locala.CLY.readString();
        AppMethodBeat.o(124366);
        return 0;
      }
      localcjh.xTA = locala.CLY.readString();
      AppMethodBeat.o(124366);
      return 0;
    }
    AppMethodBeat.o(124366);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjh
 * JD-Core Version:    0.7.0.1
 */