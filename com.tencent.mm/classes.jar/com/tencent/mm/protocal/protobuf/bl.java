package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bl
  extends com.tencent.mm.bv.a
{
  public long endTime;
  public int qYV;
  public int qYW;
  public long startTime;
  public float wnR;
  public float wnS;
  public float wnT;
  public long wnU;
  public long wnV;
  public long wnW;
  public long wnX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94496);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.qYV);
      paramVarArgs.aO(2, this.qYW);
      paramVarArgs.q(3, this.wnR);
      paramVarArgs.q(4, this.wnS);
      paramVarArgs.q(5, this.wnT);
      paramVarArgs.am(6, this.startTime);
      paramVarArgs.am(7, this.endTime);
      paramVarArgs.am(8, this.wnU);
      paramVarArgs.am(9, this.wnV);
      paramVarArgs.am(10, this.wnW);
      paramVarArgs.am(11, this.wnX);
      AppMethodBeat.o(94496);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.qYV);
      int i = e.a.a.b.b.a.bl(2, this.qYW);
      int j = e.a.a.b.b.a.eW(3);
      int k = e.a.a.b.b.a.eW(4);
      int m = e.a.a.b.b.a.eW(5);
      int n = e.a.a.b.b.a.p(6, this.startTime);
      int i1 = e.a.a.b.b.a.p(7, this.endTime);
      int i2 = e.a.a.b.b.a.p(8, this.wnU);
      int i3 = e.a.a.b.b.a.p(9, this.wnV);
      int i4 = e.a.a.b.b.a.p(10, this.wnW);
      int i5 = e.a.a.b.b.a.p(11, this.wnX);
      AppMethodBeat.o(94496);
      return paramInt + 0 + i + (j + 4) + (k + 4) + (m + 4) + n + i1 + i2 + i3 + i4 + i5;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(94496);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bl localbl = (bl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(94496);
        return -1;
      case 1: 
        localbl.qYV = locala.CLY.sl();
        AppMethodBeat.o(94496);
        return 0;
      case 2: 
        localbl.qYW = locala.CLY.sl();
        AppMethodBeat.o(94496);
        return 0;
      case 3: 
        localbl.wnR = Float.intBitsToFloat(locala.CLY.emx());
        AppMethodBeat.o(94496);
        return 0;
      case 4: 
        localbl.wnS = Float.intBitsToFloat(locala.CLY.emx());
        AppMethodBeat.o(94496);
        return 0;
      case 5: 
        localbl.wnT = Float.intBitsToFloat(locala.CLY.emx());
        AppMethodBeat.o(94496);
        return 0;
      case 6: 
        localbl.startTime = locala.CLY.sm();
        AppMethodBeat.o(94496);
        return 0;
      case 7: 
        localbl.endTime = locala.CLY.sm();
        AppMethodBeat.o(94496);
        return 0;
      case 8: 
        localbl.wnU = locala.CLY.sm();
        AppMethodBeat.o(94496);
        return 0;
      case 9: 
        localbl.wnV = locala.CLY.sm();
        AppMethodBeat.o(94496);
        return 0;
      case 10: 
        localbl.wnW = locala.CLY.sm();
        AppMethodBeat.o(94496);
        return 0;
      }
      localbl.wnX = locala.CLY.sm();
      AppMethodBeat.o(94496);
      return 0;
    }
    AppMethodBeat.o(94496);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bl
 * JD-Core Version:    0.7.0.1
 */