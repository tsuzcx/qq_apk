package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aco
  extends com.tencent.mm.bw.a
{
  public int Evf;
  public int duc;
  public int fFp;
  public int fFq;
  public int fps;
  public int height;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90965);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.fFp);
      paramVarArgs.aR(2, this.fps);
      paramVarArgs.aR(3, this.fFq);
      paramVarArgs.aR(4, this.Evf);
      paramVarArgs.aR(5, this.duc);
      paramVarArgs.aR(6, this.width);
      paramVarArgs.aR(7, this.height);
      AppMethodBeat.o(90965);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.fFp);
      int i = f.a.a.b.b.a.bx(2, this.fps);
      int j = f.a.a.b.b.a.bx(3, this.fFq);
      int k = f.a.a.b.b.a.bx(4, this.Evf);
      int m = f.a.a.b.b.a.bx(5, this.duc);
      int n = f.a.a.b.b.a.bx(6, this.width);
      int i1 = f.a.a.b.b.a.bx(7, this.height);
      AppMethodBeat.o(90965);
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
      AppMethodBeat.o(90965);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aco localaco = (aco)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(90965);
        return -1;
      case 1: 
        localaco.fFp = locala.LVo.xF();
        AppMethodBeat.o(90965);
        return 0;
      case 2: 
        localaco.fps = locala.LVo.xF();
        AppMethodBeat.o(90965);
        return 0;
      case 3: 
        localaco.fFq = locala.LVo.xF();
        AppMethodBeat.o(90965);
        return 0;
      case 4: 
        localaco.Evf = locala.LVo.xF();
        AppMethodBeat.o(90965);
        return 0;
      case 5: 
        localaco.duc = locala.LVo.xF();
        AppMethodBeat.o(90965);
        return 0;
      case 6: 
        localaco.width = locala.LVo.xF();
        AppMethodBeat.o(90965);
        return 0;
      }
      localaco.height = locala.LVo.xF();
      AppMethodBeat.o(90965);
      return 0;
    }
    AppMethodBeat.o(90965);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aco
 * JD-Core Version:    0.7.0.1
 */