package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class uq
  extends com.tencent.mm.bv.a
{
  public int jJS;
  public int nqW;
  public int pIE;
  public int wMO;
  public int wxV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151387);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.pIE);
      paramVarArgs.aO(2, this.nqW);
      paramVarArgs.aO(3, this.wMO);
      paramVarArgs.aO(4, this.jJS);
      paramVarArgs.aO(5, this.wxV);
      AppMethodBeat.o(151387);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.pIE);
      int i = e.a.a.b.b.a.bl(2, this.nqW);
      int j = e.a.a.b.b.a.bl(3, this.wMO);
      int k = e.a.a.b.b.a.bl(4, this.jJS);
      int m = e.a.a.b.b.a.bl(5, this.wxV);
      AppMethodBeat.o(151387);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(151387);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      uq localuq = (uq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(151387);
        return -1;
      case 1: 
        localuq.pIE = locala.CLY.sl();
        AppMethodBeat.o(151387);
        return 0;
      case 2: 
        localuq.nqW = locala.CLY.sl();
        AppMethodBeat.o(151387);
        return 0;
      case 3: 
        localuq.wMO = locala.CLY.sl();
        AppMethodBeat.o(151387);
        return 0;
      case 4: 
        localuq.jJS = locala.CLY.sl();
        AppMethodBeat.o(151387);
        return 0;
      }
      localuq.wxV = locala.CLY.sl();
      AppMethodBeat.o(151387);
      return 0;
    }
    AppMethodBeat.o(151387);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uq
 * JD-Core Version:    0.7.0.1
 */