package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dq
  extends com.tencent.mm.bw.a
{
  public int DQE;
  public int DQF;
  public int btD;
  public float btH;
  public int bwR;
  public int kUf;
  public int kUg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103178);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.bwR);
      paramVarArgs.aR(2, this.btD);
      paramVarArgs.x(3, this.btH);
      paramVarArgs.aR(4, this.DQE);
      paramVarArgs.aR(5, this.DQF);
      paramVarArgs.aR(6, this.kUf);
      paramVarArgs.aR(7, this.kUg);
      AppMethodBeat.o(103178);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.bwR);
      int i = f.a.a.b.b.a.bx(2, this.btD);
      int j = f.a.a.b.b.a.fK(3);
      int k = f.a.a.b.b.a.bx(4, this.DQE);
      int m = f.a.a.b.b.a.bx(5, this.DQF);
      int n = f.a.a.b.b.a.bx(6, this.kUf);
      int i1 = f.a.a.b.b.a.bx(7, this.kUg);
      AppMethodBeat.o(103178);
      return paramInt + 0 + i + (j + 4) + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(103178);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dq localdq = (dq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(103178);
        return -1;
      case 1: 
        localdq.bwR = locala.LVo.xF();
        AppMethodBeat.o(103178);
        return 0;
      case 2: 
        localdq.btD = locala.LVo.xF();
        AppMethodBeat.o(103178);
        return 0;
      case 3: 
        localdq.btH = Float.intBitsToFloat(locala.LVo.gaa());
        AppMethodBeat.o(103178);
        return 0;
      case 4: 
        localdq.DQE = locala.LVo.xF();
        AppMethodBeat.o(103178);
        return 0;
      case 5: 
        localdq.DQF = locala.LVo.xF();
        AppMethodBeat.o(103178);
        return 0;
      case 6: 
        localdq.kUf = locala.LVo.xF();
        AppMethodBeat.o(103178);
        return 0;
      }
      localdq.kUg = locala.LVo.xF();
      AppMethodBeat.o(103178);
      return 0;
    }
    AppMethodBeat.o(103178);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dq
 * JD-Core Version:    0.7.0.1
 */