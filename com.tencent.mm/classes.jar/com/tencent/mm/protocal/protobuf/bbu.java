package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bbu
  extends com.tencent.mm.bv.a
{
  public int Scene;
  public String wAa;
  public long xqQ;
  public long xqR;
  public int xqS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124324);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.Scene);
      if (this.wAa != null) {
        paramVarArgs.e(2, this.wAa);
      }
      paramVarArgs.am(3, this.xqR);
      paramVarArgs.am(4, this.xqQ);
      paramVarArgs.aO(5, this.xqS);
      AppMethodBeat.o(124324);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.Scene) + 0;
      paramInt = i;
      if (this.wAa != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wAa);
      }
      i = e.a.a.b.b.a.p(3, this.xqR);
      int j = e.a.a.b.b.a.p(4, this.xqQ);
      int k = e.a.a.b.b.a.bl(5, this.xqS);
      AppMethodBeat.o(124324);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(124324);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bbu localbbu = (bbu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124324);
        return -1;
      case 1: 
        localbbu.Scene = locala.CLY.sl();
        AppMethodBeat.o(124324);
        return 0;
      case 2: 
        localbbu.wAa = locala.CLY.readString();
        AppMethodBeat.o(124324);
        return 0;
      case 3: 
        localbbu.xqR = locala.CLY.sm();
        AppMethodBeat.o(124324);
        return 0;
      case 4: 
        localbbu.xqQ = locala.CLY.sm();
        AppMethodBeat.o(124324);
        return 0;
      }
      localbbu.xqS = locala.CLY.sl();
      AppMethodBeat.o(124324);
      return 0;
    }
    AppMethodBeat.o(124324);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbu
 * JD-Core Version:    0.7.0.1
 */