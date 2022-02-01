package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends com.tencent.mm.bw.a
{
  public int DKe;
  public int DKf;
  public int DKg;
  public int DKh;
  public int DKi;
  public int DKj;
  public int DKk;
  public int action;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143955);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DKe);
      paramVarArgs.aR(2, this.action);
      paramVarArgs.aR(3, this.DKf);
      paramVarArgs.aR(4, this.DKg);
      paramVarArgs.aR(5, this.DKh);
      paramVarArgs.aR(6, this.DKi);
      paramVarArgs.aR(7, this.DKj);
      paramVarArgs.aR(8, this.DKk);
      AppMethodBeat.o(143955);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.DKe);
      int i = f.a.a.b.b.a.bx(2, this.action);
      int j = f.a.a.b.b.a.bx(3, this.DKf);
      int k = f.a.a.b.b.a.bx(4, this.DKg);
      int m = f.a.a.b.b.a.bx(5, this.DKh);
      int n = f.a.a.b.b.a.bx(6, this.DKi);
      int i1 = f.a.a.b.b.a.bx(7, this.DKj);
      int i2 = f.a.a.b.b.a.bx(8, this.DKk);
      AppMethodBeat.o(143955);
      return paramInt + 0 + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(143955);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      l locall = (l)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143955);
        return -1;
      case 1: 
        locall.DKe = locala.LVo.xF();
        AppMethodBeat.o(143955);
        return 0;
      case 2: 
        locall.action = locala.LVo.xF();
        AppMethodBeat.o(143955);
        return 0;
      case 3: 
        locall.DKf = locala.LVo.xF();
        AppMethodBeat.o(143955);
        return 0;
      case 4: 
        locall.DKg = locala.LVo.xF();
        AppMethodBeat.o(143955);
        return 0;
      case 5: 
        locall.DKh = locala.LVo.xF();
        AppMethodBeat.o(143955);
        return 0;
      case 6: 
        locall.DKi = locala.LVo.xF();
        AppMethodBeat.o(143955);
        return 0;
      case 7: 
        locall.DKj = locala.LVo.xF();
        AppMethodBeat.o(143955);
        return 0;
      }
      locall.DKk = locala.LVo.xF();
      AppMethodBeat.o(143955);
      return 0;
    }
    AppMethodBeat.o(143955);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.l
 * JD-Core Version:    0.7.0.1
 */