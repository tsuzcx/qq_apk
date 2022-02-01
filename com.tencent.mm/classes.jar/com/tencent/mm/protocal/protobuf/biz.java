package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class biz
  extends com.tencent.mm.bw.a
{
  public long EXQ;
  public int EXR;
  public long EXS;
  public int EXT;
  public long EXU;
  public int EXV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115845);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.EXQ);
      paramVarArgs.aR(2, this.EXR);
      paramVarArgs.aO(3, this.EXS);
      paramVarArgs.aR(4, this.EXT);
      paramVarArgs.aO(5, this.EXU);
      paramVarArgs.aR(6, this.EXV);
      AppMethodBeat.o(115845);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.EXQ);
      int i = f.a.a.b.b.a.bx(2, this.EXR);
      int j = f.a.a.b.b.a.p(3, this.EXS);
      int k = f.a.a.b.b.a.bx(4, this.EXT);
      int m = f.a.a.b.b.a.p(5, this.EXU);
      int n = f.a.a.b.b.a.bx(6, this.EXV);
      AppMethodBeat.o(115845);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(115845);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      biz localbiz = (biz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115845);
        return -1;
      case 1: 
        localbiz.EXQ = locala.LVo.xG();
        AppMethodBeat.o(115845);
        return 0;
      case 2: 
        localbiz.EXR = locala.LVo.xF();
        AppMethodBeat.o(115845);
        return 0;
      case 3: 
        localbiz.EXS = locala.LVo.xG();
        AppMethodBeat.o(115845);
        return 0;
      case 4: 
        localbiz.EXT = locala.LVo.xF();
        AppMethodBeat.o(115845);
        return 0;
      case 5: 
        localbiz.EXU = locala.LVo.xG();
        AppMethodBeat.o(115845);
        return 0;
      }
      localbiz.EXV = locala.LVo.xF();
      AppMethodBeat.o(115845);
      return 0;
    }
    AppMethodBeat.o(115845);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.biz
 * JD-Core Version:    0.7.0.1
 */