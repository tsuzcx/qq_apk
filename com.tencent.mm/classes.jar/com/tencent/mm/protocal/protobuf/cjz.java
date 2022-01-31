package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cjz
  extends com.tencent.mm.bv.a
{
  public long xUa;
  public long xUb;
  public int xUc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94635);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.am(1, this.xUa);
      paramVarArgs.am(2, this.xUb);
      paramVarArgs.aO(3, this.xUc);
      AppMethodBeat.o(94635);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.p(1, this.xUa);
      int i = e.a.a.b.b.a.p(2, this.xUb);
      int j = e.a.a.b.b.a.bl(3, this.xUc);
      AppMethodBeat.o(94635);
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
      AppMethodBeat.o(94635);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cjz localcjz = (cjz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(94635);
        return -1;
      case 1: 
        localcjz.xUa = locala.CLY.sm();
        AppMethodBeat.o(94635);
        return 0;
      case 2: 
        localcjz.xUb = locala.CLY.sm();
        AppMethodBeat.o(94635);
        return 0;
      }
      localcjz.xUc = locala.CLY.sl();
      AppMethodBeat.o(94635);
      return 0;
    }
    AppMethodBeat.o(94635);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjz
 * JD-Core Version:    0.7.0.1
 */