package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cwb
  extends com.tencent.mm.bw.a
{
  public int FGE;
  public int FGF;
  public int FGG;
  public int FGH;
  public int FGI;
  public int FGJ;
  public int FGK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124550);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FGE);
      paramVarArgs.aR(2, this.FGF);
      paramVarArgs.aR(3, this.FGG);
      paramVarArgs.aR(4, this.FGH);
      paramVarArgs.aR(5, this.FGI);
      paramVarArgs.aR(6, this.FGJ);
      paramVarArgs.aR(7, this.FGK);
      AppMethodBeat.o(124550);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.FGE);
      int i = f.a.a.b.b.a.bx(2, this.FGF);
      int j = f.a.a.b.b.a.bx(3, this.FGG);
      int k = f.a.a.b.b.a.bx(4, this.FGH);
      int m = f.a.a.b.b.a.bx(5, this.FGI);
      int n = f.a.a.b.b.a.bx(6, this.FGJ);
      int i1 = f.a.a.b.b.a.bx(7, this.FGK);
      AppMethodBeat.o(124550);
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
      AppMethodBeat.o(124550);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cwb localcwb = (cwb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124550);
        return -1;
      case 1: 
        localcwb.FGE = locala.LVo.xF();
        AppMethodBeat.o(124550);
        return 0;
      case 2: 
        localcwb.FGF = locala.LVo.xF();
        AppMethodBeat.o(124550);
        return 0;
      case 3: 
        localcwb.FGG = locala.LVo.xF();
        AppMethodBeat.o(124550);
        return 0;
      case 4: 
        localcwb.FGH = locala.LVo.xF();
        AppMethodBeat.o(124550);
        return 0;
      case 5: 
        localcwb.FGI = locala.LVo.xF();
        AppMethodBeat.o(124550);
        return 0;
      case 6: 
        localcwb.FGJ = locala.LVo.xF();
        AppMethodBeat.o(124550);
        return 0;
      }
      localcwb.FGK = locala.LVo.xF();
      AppMethodBeat.o(124550);
      return 0;
    }
    AppMethodBeat.o(124550);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwb
 * JD-Core Version:    0.7.0.1
 */