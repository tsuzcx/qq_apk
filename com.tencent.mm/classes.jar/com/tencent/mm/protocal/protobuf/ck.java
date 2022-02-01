package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ck
  extends com.tencent.mm.bx.a
{
  public int PVB;
  public int PVC;
  public float YEA;
  public long YEB;
  public long YEC;
  public long YED;
  public long YEE;
  public float YEy;
  public float YEz;
  public long endTime;
  public long startTime;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125698);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.PVB);
      paramVarArgs.bS(2, this.PVC);
      paramVarArgs.l(3, this.YEy);
      paramVarArgs.l(4, this.YEz);
      paramVarArgs.l(5, this.YEA);
      paramVarArgs.bv(6, this.startTime);
      paramVarArgs.bv(7, this.endTime);
      paramVarArgs.bv(8, this.YEB);
      paramVarArgs.bv(9, this.YEC);
      paramVarArgs.bv(10, this.YED);
      paramVarArgs.bv(11, this.YEE);
      AppMethodBeat.o(125698);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.PVB);
      int i = i.a.a.b.b.a.cJ(2, this.PVC);
      int j = i.a.a.b.b.a.ko(3);
      int k = i.a.a.b.b.a.ko(4);
      int m = i.a.a.b.b.a.ko(5);
      int n = i.a.a.b.b.a.q(6, this.startTime);
      int i1 = i.a.a.b.b.a.q(7, this.endTime);
      int i2 = i.a.a.b.b.a.q(8, this.YEB);
      int i3 = i.a.a.b.b.a.q(9, this.YEC);
      int i4 = i.a.a.b.b.a.q(10, this.YED);
      int i5 = i.a.a.b.b.a.q(11, this.YEE);
      AppMethodBeat.o(125698);
      return paramInt + 0 + i + (j + 4) + (k + 4) + (m + 4) + n + i1 + i2 + i3 + i4 + i5;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(125698);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ck localck = (ck)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125698);
        return -1;
      case 1: 
        localck.PVB = locala.ajGk.aar();
        AppMethodBeat.o(125698);
        return 0;
      case 2: 
        localck.PVC = locala.ajGk.aar();
        AppMethodBeat.o(125698);
        return 0;
      case 3: 
        localck.YEy = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(125698);
        return 0;
      case 4: 
        localck.YEz = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(125698);
        return 0;
      case 5: 
        localck.YEA = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(125698);
        return 0;
      case 6: 
        localck.startTime = locala.ajGk.aaw();
        AppMethodBeat.o(125698);
        return 0;
      case 7: 
        localck.endTime = locala.ajGk.aaw();
        AppMethodBeat.o(125698);
        return 0;
      case 8: 
        localck.YEB = locala.ajGk.aaw();
        AppMethodBeat.o(125698);
        return 0;
      case 9: 
        localck.YEC = locala.ajGk.aaw();
        AppMethodBeat.o(125698);
        return 0;
      case 10: 
        localck.YED = locala.ajGk.aaw();
        AppMethodBeat.o(125698);
        return 0;
      }
      localck.YEE = locala.ajGk.aaw();
      AppMethodBeat.o(125698);
      return 0;
    }
    AppMethodBeat.o(125698);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ck
 * JD-Core Version:    0.7.0.1
 */