package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ana
  extends com.tencent.mm.bw.a
{
  public int EGe;
  public float EGf;
  public int EGg;
  public int EGh;
  public int rvF;
  public int rvG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184205);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.rvF);
      paramVarArgs.aR(2, this.rvG);
      paramVarArgs.aR(3, this.EGe);
      paramVarArgs.x(4, this.EGf);
      paramVarArgs.aR(5, this.EGg);
      paramVarArgs.aR(6, this.EGh);
      AppMethodBeat.o(184205);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.rvF);
      int i = f.a.a.b.b.a.bx(2, this.rvG);
      int j = f.a.a.b.b.a.bx(3, this.EGe);
      int k = f.a.a.b.b.a.fK(4);
      int m = f.a.a.b.b.a.bx(5, this.EGg);
      int n = f.a.a.b.b.a.bx(6, this.EGh);
      AppMethodBeat.o(184205);
      return paramInt + 0 + i + j + (k + 4) + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(184205);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ana localana = (ana)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(184205);
        return -1;
      case 1: 
        localana.rvF = locala.LVo.xF();
        AppMethodBeat.o(184205);
        return 0;
      case 2: 
        localana.rvG = locala.LVo.xF();
        AppMethodBeat.o(184205);
        return 0;
      case 3: 
        localana.EGe = locala.LVo.xF();
        AppMethodBeat.o(184205);
        return 0;
      case 4: 
        localana.EGf = Float.intBitsToFloat(locala.LVo.gaa());
        AppMethodBeat.o(184205);
        return 0;
      case 5: 
        localana.EGg = locala.LVo.xF();
        AppMethodBeat.o(184205);
        return 0;
      }
      localana.EGh = locala.LVo.xF();
      AppMethodBeat.o(184205);
      return 0;
    }
    AppMethodBeat.o(184205);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ana
 * JD-Core Version:    0.7.0.1
 */