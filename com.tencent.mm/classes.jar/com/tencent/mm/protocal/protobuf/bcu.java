package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bcu
  extends com.tencent.mm.bv.a
{
  public float xsH;
  public float xsI;
  public float xsJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94542);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.q(1, this.xsH);
      paramVarArgs.q(2, this.xsI);
      paramVarArgs.q(3, this.xsJ);
      AppMethodBeat.o(94542);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.eW(1);
      int i = e.a.a.b.b.a.eW(2);
      int j = e.a.a.b.b.a.eW(3);
      AppMethodBeat.o(94542);
      return paramInt + 4 + 0 + (i + 4) + (j + 4);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(94542);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bcu localbcu = (bcu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(94542);
        return -1;
      case 1: 
        localbcu.xsH = Float.intBitsToFloat(locala.CLY.emx());
        AppMethodBeat.o(94542);
        return 0;
      case 2: 
        localbcu.xsI = Float.intBitsToFloat(locala.CLY.emx());
        AppMethodBeat.o(94542);
        return 0;
      }
      localbcu.xsJ = Float.intBitsToFloat(locala.CLY.emx());
      AppMethodBeat.o(94542);
      return 0;
    }
    AppMethodBeat.o(94542);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcu
 * JD-Core Version:    0.7.0.1
 */