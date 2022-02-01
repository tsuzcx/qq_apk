package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aex
  extends com.tencent.mm.bw.a
{
  public int Gvg;
  public int dHi;
  public int fps;
  public int gaV;
  public int gaW;
  public int height;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90965);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.gaV);
      paramVarArgs.aS(2, this.fps);
      paramVarArgs.aS(3, this.gaW);
      paramVarArgs.aS(4, this.Gvg);
      paramVarArgs.aS(5, this.dHi);
      paramVarArgs.aS(6, this.width);
      paramVarArgs.aS(7, this.height);
      AppMethodBeat.o(90965);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.gaV);
      int i = f.a.a.b.b.a.bz(2, this.fps);
      int j = f.a.a.b.b.a.bz(3, this.gaW);
      int k = f.a.a.b.b.a.bz(4, this.Gvg);
      int m = f.a.a.b.b.a.bz(5, this.dHi);
      int n = f.a.a.b.b.a.bz(6, this.width);
      int i1 = f.a.a.b.b.a.bz(7, this.height);
      AppMethodBeat.o(90965);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(90965);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aex localaex = (aex)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(90965);
        return -1;
      case 1: 
        localaex.gaV = locala.OmT.zc();
        AppMethodBeat.o(90965);
        return 0;
      case 2: 
        localaex.fps = locala.OmT.zc();
        AppMethodBeat.o(90965);
        return 0;
      case 3: 
        localaex.gaW = locala.OmT.zc();
        AppMethodBeat.o(90965);
        return 0;
      case 4: 
        localaex.Gvg = locala.OmT.zc();
        AppMethodBeat.o(90965);
        return 0;
      case 5: 
        localaex.dHi = locala.OmT.zc();
        AppMethodBeat.o(90965);
        return 0;
      case 6: 
        localaex.width = locala.OmT.zc();
        AppMethodBeat.o(90965);
        return 0;
      }
      localaex.height = locala.OmT.zc();
      AppMethodBeat.o(90965);
      return 0;
    }
    AppMethodBeat.o(90965);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aex
 * JD-Core Version:    0.7.0.1
 */