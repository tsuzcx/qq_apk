package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends com.tencent.mm.bw.a
{
  public int DJF;
  public int DKo;
  public int DKp;
  public int DKq;
  public int DKr;
  public int DKs;
  public int DKt;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143958);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DJF);
      paramVarArgs.aR(2, this.DKo);
      paramVarArgs.aR(3, this.DKp);
      paramVarArgs.aR(4, this.DKq);
      paramVarArgs.aR(5, this.DKr);
      paramVarArgs.aR(6, this.DKs);
      paramVarArgs.aR(7, this.DKt);
      paramVarArgs.aR(8, this.type);
      AppMethodBeat.o(143958);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.DJF);
      int i = f.a.a.b.b.a.bx(2, this.DKo);
      int j = f.a.a.b.b.a.bx(3, this.DKp);
      int k = f.a.a.b.b.a.bx(4, this.DKq);
      int m = f.a.a.b.b.a.bx(5, this.DKr);
      int n = f.a.a.b.b.a.bx(6, this.DKs);
      int i1 = f.a.a.b.b.a.bx(7, this.DKt);
      int i2 = f.a.a.b.b.a.bx(8, this.type);
      AppMethodBeat.o(143958);
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
      AppMethodBeat.o(143958);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      n localn = (n)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143958);
        return -1;
      case 1: 
        localn.DJF = locala.LVo.xF();
        AppMethodBeat.o(143958);
        return 0;
      case 2: 
        localn.DKo = locala.LVo.xF();
        AppMethodBeat.o(143958);
        return 0;
      case 3: 
        localn.DKp = locala.LVo.xF();
        AppMethodBeat.o(143958);
        return 0;
      case 4: 
        localn.DKq = locala.LVo.xF();
        AppMethodBeat.o(143958);
        return 0;
      case 5: 
        localn.DKr = locala.LVo.xF();
        AppMethodBeat.o(143958);
        return 0;
      case 6: 
        localn.DKs = locala.LVo.xF();
        AppMethodBeat.o(143958);
        return 0;
      case 7: 
        localn.DKt = locala.LVo.xF();
        AppMethodBeat.o(143958);
        return 0;
      }
      localn.type = locala.LVo.xF();
      AppMethodBeat.o(143958);
      return 0;
    }
    AppMethodBeat.o(143958);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.n
 * JD-Core Version:    0.7.0.1
 */