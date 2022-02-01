package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class abp
  extends com.tencent.mm.bx.a
{
  public int DbY;
  public int dwp;
  public int fBI;
  public int fBJ;
  public int fps;
  public int height;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90965);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.fBI);
      paramVarArgs.aR(2, this.fps);
      paramVarArgs.aR(3, this.fBJ);
      paramVarArgs.aR(4, this.DbY);
      paramVarArgs.aR(5, this.dwp);
      paramVarArgs.aR(6, this.width);
      paramVarArgs.aR(7, this.height);
      AppMethodBeat.o(90965);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.fBI);
      int i = f.a.a.b.b.a.bA(2, this.fps);
      int j = f.a.a.b.b.a.bA(3, this.fBJ);
      int k = f.a.a.b.b.a.bA(4, this.DbY);
      int m = f.a.a.b.b.a.bA(5, this.dwp);
      int n = f.a.a.b.b.a.bA(6, this.width);
      int i1 = f.a.a.b.b.a.bA(7, this.height);
      AppMethodBeat.o(90965);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(90965);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      abp localabp = (abp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(90965);
        return -1;
      case 1: 
        localabp.fBI = locala.KhF.xS();
        AppMethodBeat.o(90965);
        return 0;
      case 2: 
        localabp.fps = locala.KhF.xS();
        AppMethodBeat.o(90965);
        return 0;
      case 3: 
        localabp.fBJ = locala.KhF.xS();
        AppMethodBeat.o(90965);
        return 0;
      case 4: 
        localabp.DbY = locala.KhF.xS();
        AppMethodBeat.o(90965);
        return 0;
      case 5: 
        localabp.dwp = locala.KhF.xS();
        AppMethodBeat.o(90965);
        return 0;
      case 6: 
        localabp.width = locala.KhF.xS();
        AppMethodBeat.o(90965);
        return 0;
      }
      localabp.height = locala.KhF.xS();
      AppMethodBeat.o(90965);
      return 0;
    }
    AppMethodBeat.o(90965);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abp
 * JD-Core Version:    0.7.0.1
 */