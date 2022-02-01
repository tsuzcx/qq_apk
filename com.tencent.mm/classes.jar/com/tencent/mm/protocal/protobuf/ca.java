package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ca
  extends com.tencent.mm.cd.a
{
  public int JEA;
  public int JEz;
  public long RHA;
  public long RHB;
  public float RHv;
  public float RHw;
  public float RHx;
  public long RHy;
  public long RHz;
  public long endTime;
  public long startTime;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125698);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.JEz);
      paramVarArgs.aY(2, this.JEA);
      paramVarArgs.i(3, this.RHv);
      paramVarArgs.i(4, this.RHw);
      paramVarArgs.i(5, this.RHx);
      paramVarArgs.bm(6, this.startTime);
      paramVarArgs.bm(7, this.endTime);
      paramVarArgs.bm(8, this.RHy);
      paramVarArgs.bm(9, this.RHz);
      paramVarArgs.bm(10, this.RHA);
      paramVarArgs.bm(11, this.RHB);
      AppMethodBeat.o(125698);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.JEz);
      int i = g.a.a.b.b.a.bM(2, this.JEA);
      int j = g.a.a.b.b.a.gL(3);
      int k = g.a.a.b.b.a.gL(4);
      int m = g.a.a.b.b.a.gL(5);
      int n = g.a.a.b.b.a.p(6, this.startTime);
      int i1 = g.a.a.b.b.a.p(7, this.endTime);
      int i2 = g.a.a.b.b.a.p(8, this.RHy);
      int i3 = g.a.a.b.b.a.p(9, this.RHz);
      int i4 = g.a.a.b.b.a.p(10, this.RHA);
      int i5 = g.a.a.b.b.a.p(11, this.RHB);
      AppMethodBeat.o(125698);
      return paramInt + 0 + i + (j + 4) + (k + 4) + (m + 4) + n + i1 + i2 + i3 + i4 + i5;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(125698);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ca localca = (ca)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125698);
        return -1;
      case 1: 
        localca.JEz = locala.abFh.AK();
        AppMethodBeat.o(125698);
        return 0;
      case 2: 
        localca.JEA = locala.abFh.AK();
        AppMethodBeat.o(125698);
        return 0;
      case 3: 
        localca.RHv = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(125698);
        return 0;
      case 4: 
        localca.RHw = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(125698);
        return 0;
      case 5: 
        localca.RHx = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(125698);
        return 0;
      case 6: 
        localca.startTime = locala.abFh.AN();
        AppMethodBeat.o(125698);
        return 0;
      case 7: 
        localca.endTime = locala.abFh.AN();
        AppMethodBeat.o(125698);
        return 0;
      case 8: 
        localca.RHy = locala.abFh.AN();
        AppMethodBeat.o(125698);
        return 0;
      case 9: 
        localca.RHz = locala.abFh.AN();
        AppMethodBeat.o(125698);
        return 0;
      case 10: 
        localca.RHA = locala.abFh.AN();
        AppMethodBeat.o(125698);
        return 0;
      }
      localca.RHB = locala.abFh.AN();
      AppMethodBeat.o(125698);
      return 0;
    }
    AppMethodBeat.o(125698);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ca
 * JD-Core Version:    0.7.0.1
 */