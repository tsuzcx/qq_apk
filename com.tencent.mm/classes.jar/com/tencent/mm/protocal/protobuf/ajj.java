package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ajj
  extends com.tencent.mm.bw.a
{
  public int EDU;
  public int EDV;
  public int EDW;
  public int EDX;
  public int EDY;
  public int EDZ;
  public int EEa;
  public int count;
  public int hQB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168947);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.count);
      paramVarArgs.aR(2, this.EDU);
      paramVarArgs.aR(3, this.EDV);
      paramVarArgs.aR(4, this.EDW);
      paramVarArgs.aR(5, this.EDX);
      paramVarArgs.aR(7, this.EDY);
      paramVarArgs.aR(8, this.EDZ);
      paramVarArgs.aR(9, this.hQB);
      paramVarArgs.aR(10, this.EEa);
      AppMethodBeat.o(168947);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.count);
      int i = f.a.a.b.b.a.bx(2, this.EDU);
      int j = f.a.a.b.b.a.bx(3, this.EDV);
      int k = f.a.a.b.b.a.bx(4, this.EDW);
      int m = f.a.a.b.b.a.bx(5, this.EDX);
      int n = f.a.a.b.b.a.bx(7, this.EDY);
      int i1 = f.a.a.b.b.a.bx(8, this.EDZ);
      int i2 = f.a.a.b.b.a.bx(9, this.hQB);
      int i3 = f.a.a.b.b.a.bx(10, this.EEa);
      AppMethodBeat.o(168947);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(168947);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ajj localajj = (ajj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 6: 
      default: 
        AppMethodBeat.o(168947);
        return -1;
      case 1: 
        localajj.count = locala.LVo.xF();
        AppMethodBeat.o(168947);
        return 0;
      case 2: 
        localajj.EDU = locala.LVo.xF();
        AppMethodBeat.o(168947);
        return 0;
      case 3: 
        localajj.EDV = locala.LVo.xF();
        AppMethodBeat.o(168947);
        return 0;
      case 4: 
        localajj.EDW = locala.LVo.xF();
        AppMethodBeat.o(168947);
        return 0;
      case 5: 
        localajj.EDX = locala.LVo.xF();
        AppMethodBeat.o(168947);
        return 0;
      case 7: 
        localajj.EDY = locala.LVo.xF();
        AppMethodBeat.o(168947);
        return 0;
      case 8: 
        localajj.EDZ = locala.LVo.xF();
        AppMethodBeat.o(168947);
        return 0;
      case 9: 
        localajj.hQB = locala.LVo.xF();
        AppMethodBeat.o(168947);
        return 0;
      }
      localajj.EEa = locala.LVo.xF();
      AppMethodBeat.o(168947);
      return 0;
    }
    AppMethodBeat.o(168947);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajj
 * JD-Core Version:    0.7.0.1
 */