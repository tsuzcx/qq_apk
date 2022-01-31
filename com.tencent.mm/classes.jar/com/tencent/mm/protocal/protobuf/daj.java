package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class daj
  extends com.tencent.mm.bv.a
{
  public double ygP;
  public long ygQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115011);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.f(1, this.ygP);
      paramVarArgs.am(2, this.ygQ);
      AppMethodBeat.o(115011);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.eW(1);
      int i = e.a.a.b.b.a.p(2, this.ygQ);
      AppMethodBeat.o(115011);
      return paramInt + 8 + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(115011);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      daj localdaj = (daj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115011);
        return -1;
      case 1: 
        localdaj.ygP = Double.longBitsToDouble(locala.CLY.emy());
        AppMethodBeat.o(115011);
        return 0;
      }
      localdaj.ygQ = locala.CLY.sm();
      AppMethodBeat.o(115011);
      return 0;
    }
    AppMethodBeat.o(115011);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.daj
 * JD-Core Version:    0.7.0.1
 */