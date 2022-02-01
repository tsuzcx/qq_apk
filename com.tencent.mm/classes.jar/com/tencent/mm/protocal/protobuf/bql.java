package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bql
  extends com.tencent.mm.bw.a
{
  public int FfD;
  public int FfE;
  public int FfF;
  public int FfG;
  public int FfH;
  public int FfI;
  public int FfJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(190895);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FfD);
      paramVarArgs.aR(2, this.FfE);
      paramVarArgs.aR(3, this.FfF);
      paramVarArgs.aR(4, this.FfG);
      paramVarArgs.aR(5, this.FfH);
      paramVarArgs.aR(6, this.FfI);
      paramVarArgs.aR(7, this.FfJ);
      AppMethodBeat.o(190895);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.FfD);
      int i = f.a.a.b.b.a.bx(2, this.FfE);
      int j = f.a.a.b.b.a.bx(3, this.FfF);
      int k = f.a.a.b.b.a.bx(4, this.FfG);
      int m = f.a.a.b.b.a.bx(5, this.FfH);
      int n = f.a.a.b.b.a.bx(6, this.FfI);
      int i1 = f.a.a.b.b.a.bx(7, this.FfJ);
      AppMethodBeat.o(190895);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(190895);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bql localbql = (bql)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(190895);
        return -1;
      case 1: 
        localbql.FfD = locala.LVo.xF();
        AppMethodBeat.o(190895);
        return 0;
      case 2: 
        localbql.FfE = locala.LVo.xF();
        AppMethodBeat.o(190895);
        return 0;
      case 3: 
        localbql.FfF = locala.LVo.xF();
        AppMethodBeat.o(190895);
        return 0;
      case 4: 
        localbql.FfG = locala.LVo.xF();
        AppMethodBeat.o(190895);
        return 0;
      case 5: 
        localbql.FfH = locala.LVo.xF();
        AppMethodBeat.o(190895);
        return 0;
      case 6: 
        localbql.FfI = locala.LVo.xF();
        AppMethodBeat.o(190895);
        return 0;
      }
      localbql.FfJ = locala.LVo.xF();
      AppMethodBeat.o(190895);
      return 0;
    }
    AppMethodBeat.o(190895);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bql
 * JD-Core Version:    0.7.0.1
 */