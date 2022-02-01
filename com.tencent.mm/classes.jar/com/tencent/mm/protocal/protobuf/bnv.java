package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class bnv
  extends com.tencent.mm.bw.a
{
  public int EvG;
  public int FdA;
  public int Fdx;
  public b Fdy;
  public int Fdz;
  public int ncL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143982);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Fdx);
      if (this.Fdy != null) {
        paramVarArgs.c(2, this.Fdy);
      }
      paramVarArgs.aR(3, this.Fdz);
      paramVarArgs.aR(4, this.EvG);
      paramVarArgs.aR(5, this.ncL);
      paramVarArgs.aR(6, this.FdA);
      AppMethodBeat.o(143982);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.Fdx) + 0;
      paramInt = i;
      if (this.Fdy != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.Fdy);
      }
      i = f.a.a.b.b.a.bx(3, this.Fdz);
      int j = f.a.a.b.b.a.bx(4, this.EvG);
      int k = f.a.a.b.b.a.bx(5, this.ncL);
      int m = f.a.a.b.b.a.bx(6, this.FdA);
      AppMethodBeat.o(143982);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(143982);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bnv localbnv = (bnv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143982);
        return -1;
      case 1: 
        localbnv.Fdx = locala.LVo.xF();
        AppMethodBeat.o(143982);
        return 0;
      case 2: 
        localbnv.Fdy = locala.LVo.gfk();
        AppMethodBeat.o(143982);
        return 0;
      case 3: 
        localbnv.Fdz = locala.LVo.xF();
        AppMethodBeat.o(143982);
        return 0;
      case 4: 
        localbnv.EvG = locala.LVo.xF();
        AppMethodBeat.o(143982);
        return 0;
      case 5: 
        localbnv.ncL = locala.LVo.xF();
        AppMethodBeat.o(143982);
        return 0;
      }
      localbnv.FdA = locala.LVo.xF();
      AppMethodBeat.o(143982);
      return 0;
    }
    AppMethodBeat.o(143982);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnv
 * JD-Core Version:    0.7.0.1
 */