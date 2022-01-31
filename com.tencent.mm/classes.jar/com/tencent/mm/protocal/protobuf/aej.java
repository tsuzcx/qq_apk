package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aej
  extends com.tencent.mm.bv.a
{
  public String nQe;
  public int wxV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151388);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wxV);
      if (this.nQe != null) {
        paramVarArgs.e(2, this.nQe);
      }
      AppMethodBeat.o(151388);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.wxV) + 0;
      paramInt = i;
      if (this.nQe != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.nQe);
      }
      AppMethodBeat.o(151388);
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
      AppMethodBeat.o(151388);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      aej localaej = (aej)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(151388);
        return -1;
      case 1: 
        localaej.wxV = locala.CLY.sl();
        AppMethodBeat.o(151388);
        return 0;
      }
      localaej.nQe = locala.CLY.readString();
      AppMethodBeat.o(151388);
      return 0;
    }
    AppMethodBeat.o(151388);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aej
 * JD-Core Version:    0.7.0.1
 */