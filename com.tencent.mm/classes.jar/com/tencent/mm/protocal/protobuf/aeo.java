package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aeo
  extends com.tencent.mm.bx.a
{
  public int Gcz;
  public int dGc;
  public int fYO;
  public int fYP;
  public int fps;
  public int height;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90965);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.fYO);
      paramVarArgs.aS(2, this.fps);
      paramVarArgs.aS(3, this.fYP);
      paramVarArgs.aS(4, this.Gcz);
      paramVarArgs.aS(5, this.dGc);
      paramVarArgs.aS(6, this.width);
      paramVarArgs.aS(7, this.height);
      AppMethodBeat.o(90965);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.fYO);
      int i = f.a.a.b.b.a.bz(2, this.fps);
      int j = f.a.a.b.b.a.bz(3, this.fYP);
      int k = f.a.a.b.b.a.bz(4, this.Gcz);
      int m = f.a.a.b.b.a.bz(5, this.dGc);
      int n = f.a.a.b.b.a.bz(6, this.width);
      int i1 = f.a.a.b.b.a.bz(7, this.height);
      AppMethodBeat.o(90965);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(90965);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aeo localaeo = (aeo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(90965);
        return -1;
      case 1: 
        localaeo.fYO = locala.NPN.zc();
        AppMethodBeat.o(90965);
        return 0;
      case 2: 
        localaeo.fps = locala.NPN.zc();
        AppMethodBeat.o(90965);
        return 0;
      case 3: 
        localaeo.fYP = locala.NPN.zc();
        AppMethodBeat.o(90965);
        return 0;
      case 4: 
        localaeo.Gcz = locala.NPN.zc();
        AppMethodBeat.o(90965);
        return 0;
      case 5: 
        localaeo.dGc = locala.NPN.zc();
        AppMethodBeat.o(90965);
        return 0;
      case 6: 
        localaeo.width = locala.NPN.zc();
        AppMethodBeat.o(90965);
        return 0;
      }
      localaeo.height = locala.NPN.zc();
      AppMethodBeat.o(90965);
      return 0;
    }
    AppMethodBeat.o(90965);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aeo
 * JD-Core Version:    0.7.0.1
 */