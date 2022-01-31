package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bcq
  extends com.tencent.mm.bv.a
{
  public int niE;
  public int niK;
  public String wqN;
  public int xoq;
  public int xrO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94538);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.niK);
      paramVarArgs.aO(2, this.niE);
      paramVarArgs.aO(3, this.xrO);
      if (this.wqN != null) {
        paramVarArgs.e(4, this.wqN);
      }
      paramVarArgs.aO(5, this.xoq);
      AppMethodBeat.o(94538);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.niK) + 0 + e.a.a.b.b.a.bl(2, this.niE) + e.a.a.b.b.a.bl(3, this.xrO);
      paramInt = i;
      if (this.wqN != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wqN);
      }
      i = e.a.a.b.b.a.bl(5, this.xoq);
      AppMethodBeat.o(94538);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(94538);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bcq localbcq = (bcq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(94538);
        return -1;
      case 1: 
        localbcq.niK = locala.CLY.sl();
        AppMethodBeat.o(94538);
        return 0;
      case 2: 
        localbcq.niE = locala.CLY.sl();
        AppMethodBeat.o(94538);
        return 0;
      case 3: 
        localbcq.xrO = locala.CLY.sl();
        AppMethodBeat.o(94538);
        return 0;
      case 4: 
        localbcq.wqN = locala.CLY.readString();
        AppMethodBeat.o(94538);
        return 0;
      }
      localbcq.xoq = locala.CLY.sl();
      AppMethodBeat.o(94538);
      return 0;
    }
    AppMethodBeat.o(94538);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcq
 * JD-Core Version:    0.7.0.1
 */