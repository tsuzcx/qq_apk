package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cri
  extends com.tencent.mm.bv.a
{
  public int fKi;
  public int xZO;
  public String xZS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28704);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xZO);
      paramVarArgs.aO(2, this.fKi);
      if (this.xZS != null) {
        paramVarArgs.e(3, this.xZS);
      }
      AppMethodBeat.o(28704);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.xZO) + 0 + e.a.a.b.b.a.bl(2, this.fKi);
      paramInt = i;
      if (this.xZS != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.xZS);
      }
      AppMethodBeat.o(28704);
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
      AppMethodBeat.o(28704);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cri localcri = (cri)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(28704);
        return -1;
      case 1: 
        localcri.xZO = locala.CLY.sl();
        AppMethodBeat.o(28704);
        return 0;
      case 2: 
        localcri.fKi = locala.CLY.sl();
        AppMethodBeat.o(28704);
        return 0;
      }
      localcri.xZS = locala.CLY.readString();
      AppMethodBeat.o(28704);
      return 0;
    }
    AppMethodBeat.o(28704);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cri
 * JD-Core Version:    0.7.0.1
 */