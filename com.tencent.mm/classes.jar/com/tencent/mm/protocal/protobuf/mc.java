package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mc
  extends com.tencent.mm.bw.a
{
  public int DSp;
  public int EaQ;
  public int EaR;
  public int EaS;
  public int EaT;
  public int EaU;
  public int enabled;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103202);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.enabled);
      paramVarArgs.aR(2, this.EaQ);
      paramVarArgs.aR(3, this.EaR);
      paramVarArgs.aR(4, this.EaS);
      paramVarArgs.aR(5, this.EaT);
      paramVarArgs.aR(6, this.EaU);
      paramVarArgs.aR(7, this.DSp);
      AppMethodBeat.o(103202);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.enabled);
      int i = f.a.a.b.b.a.bx(2, this.EaQ);
      int j = f.a.a.b.b.a.bx(3, this.EaR);
      int k = f.a.a.b.b.a.bx(4, this.EaS);
      int m = f.a.a.b.b.a.bx(5, this.EaT);
      int n = f.a.a.b.b.a.bx(6, this.EaU);
      int i1 = f.a.a.b.b.a.bx(7, this.DSp);
      AppMethodBeat.o(103202);
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
      AppMethodBeat.o(103202);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      mc localmc = (mc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(103202);
        return -1;
      case 1: 
        localmc.enabled = locala.LVo.xF();
        AppMethodBeat.o(103202);
        return 0;
      case 2: 
        localmc.EaQ = locala.LVo.xF();
        AppMethodBeat.o(103202);
        return 0;
      case 3: 
        localmc.EaR = locala.LVo.xF();
        AppMethodBeat.o(103202);
        return 0;
      case 4: 
        localmc.EaS = locala.LVo.xF();
        AppMethodBeat.o(103202);
        return 0;
      case 5: 
        localmc.EaT = locala.LVo.xF();
        AppMethodBeat.o(103202);
        return 0;
      case 6: 
        localmc.EaU = locala.LVo.xF();
        AppMethodBeat.o(103202);
        return 0;
      }
      localmc.DSp = locala.LVo.xF();
      AppMethodBeat.o(103202);
      return 0;
    }
    AppMethodBeat.o(103202);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mc
 * JD-Core Version:    0.7.0.1
 */