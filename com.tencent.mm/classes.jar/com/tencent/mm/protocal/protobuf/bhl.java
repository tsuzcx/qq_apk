package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bhl
  extends com.tencent.mm.bv.a
{
  public int wAK;
  public int wLO;
  public int xwB;
  public String xwC;
  public String xwD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28564);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wAK);
      if (this.xwD != null) {
        paramVarArgs.e(3, this.xwD);
      }
      paramVarArgs.aO(4, this.xwB);
      paramVarArgs.aO(5, this.wLO);
      if (this.xwC != null) {
        paramVarArgs.e(6, this.xwC);
      }
      AppMethodBeat.o(28564);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.wAK) + 0;
      paramInt = i;
      if (this.xwD != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.xwD);
      }
      i = paramInt + e.a.a.b.b.a.bl(4, this.xwB) + e.a.a.b.b.a.bl(5, this.wLO);
      paramInt = i;
      if (this.xwC != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xwC);
      }
      AppMethodBeat.o(28564);
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
      AppMethodBeat.o(28564);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bhl localbhl = (bhl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 2: 
      default: 
        AppMethodBeat.o(28564);
        return -1;
      case 1: 
        localbhl.wAK = locala.CLY.sl();
        AppMethodBeat.o(28564);
        return 0;
      case 3: 
        localbhl.xwD = locala.CLY.readString();
        AppMethodBeat.o(28564);
        return 0;
      case 4: 
        localbhl.xwB = locala.CLY.sl();
        AppMethodBeat.o(28564);
        return 0;
      case 5: 
        localbhl.wLO = locala.CLY.sl();
        AppMethodBeat.o(28564);
        return 0;
      }
      localbhl.xwC = locala.CLY.readString();
      AppMethodBeat.o(28564);
      return 0;
    }
    AppMethodBeat.o(28564);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhl
 * JD-Core Version:    0.7.0.1
 */