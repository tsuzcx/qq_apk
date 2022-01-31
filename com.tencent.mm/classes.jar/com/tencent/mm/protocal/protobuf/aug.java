package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aug
  extends com.tencent.mm.bv.a
{
  public long xjc;
  public int xjd;
  public long xje;
  public int xjf;
  public long xjg;
  public int xjh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5217);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.am(1, this.xjc);
      paramVarArgs.aO(2, this.xjd);
      paramVarArgs.am(3, this.xje);
      paramVarArgs.aO(4, this.xjf);
      paramVarArgs.am(5, this.xjg);
      paramVarArgs.aO(6, this.xjh);
      AppMethodBeat.o(5217);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.p(1, this.xjc);
      int i = e.a.a.b.b.a.bl(2, this.xjd);
      int j = e.a.a.b.b.a.p(3, this.xje);
      int k = e.a.a.b.b.a.bl(4, this.xjf);
      int m = e.a.a.b.b.a.p(5, this.xjg);
      int n = e.a.a.b.b.a.bl(6, this.xjh);
      AppMethodBeat.o(5217);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(5217);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      aug localaug = (aug)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(5217);
        return -1;
      case 1: 
        localaug.xjc = locala.CLY.sm();
        AppMethodBeat.o(5217);
        return 0;
      case 2: 
        localaug.xjd = locala.CLY.sl();
        AppMethodBeat.o(5217);
        return 0;
      case 3: 
        localaug.xje = locala.CLY.sm();
        AppMethodBeat.o(5217);
        return 0;
      case 4: 
        localaug.xjf = locala.CLY.sl();
        AppMethodBeat.o(5217);
        return 0;
      case 5: 
        localaug.xjg = locala.CLY.sm();
        AppMethodBeat.o(5217);
        return 0;
      }
      localaug.xjh = locala.CLY.sl();
      AppMethodBeat.o(5217);
      return 0;
    }
    AppMethodBeat.o(5217);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aug
 * JD-Core Version:    0.7.0.1
 */