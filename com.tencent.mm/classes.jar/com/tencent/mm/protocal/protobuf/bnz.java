package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class bnz
  extends com.tencent.mm.bw.a
{
  public int FdE;
  public int FdF;
  public int Fdx;
  public b Fdy;
  public int ncL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116337);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Fdx);
      if (this.Fdy != null) {
        paramVarArgs.c(2, this.Fdy);
      }
      paramVarArgs.aR(3, this.FdE);
      paramVarArgs.aR(4, this.ncL);
      paramVarArgs.aR(5, this.FdF);
      AppMethodBeat.o(116337);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.Fdx) + 0;
      paramInt = i;
      if (this.Fdy != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.Fdy);
      }
      i = f.a.a.b.b.a.bx(3, this.FdE);
      int j = f.a.a.b.b.a.bx(4, this.ncL);
      int k = f.a.a.b.b.a.bx(5, this.FdF);
      AppMethodBeat.o(116337);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(116337);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bnz localbnz = (bnz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(116337);
        return -1;
      case 1: 
        localbnz.Fdx = locala.LVo.xF();
        AppMethodBeat.o(116337);
        return 0;
      case 2: 
        localbnz.Fdy = locala.LVo.gfk();
        AppMethodBeat.o(116337);
        return 0;
      case 3: 
        localbnz.FdE = locala.LVo.xF();
        AppMethodBeat.o(116337);
        return 0;
      case 4: 
        localbnz.ncL = locala.LVo.xF();
        AppMethodBeat.o(116337);
        return 0;
      }
      localbnz.FdF = locala.LVo.xF();
      AppMethodBeat.o(116337);
      return 0;
    }
    AppMethodBeat.o(116337);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnz
 * JD-Core Version:    0.7.0.1
 */