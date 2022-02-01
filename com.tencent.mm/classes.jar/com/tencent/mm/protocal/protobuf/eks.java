package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eks
  extends com.tencent.mm.cd.a
{
  public float KFy;
  public int KFz;
  public float UmC;
  public float UmD;
  public float UmE;
  public float UmF;
  public int UmG;
  public long UmH;
  public long UmI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125812);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.i(1, this.UmC);
      paramVarArgs.i(2, this.UmD);
      paramVarArgs.i(3, this.UmE);
      paramVarArgs.i(4, this.UmF);
      paramVarArgs.aY(5, this.UmG);
      paramVarArgs.bm(6, this.UmH);
      paramVarArgs.bm(7, this.UmI);
      paramVarArgs.i(8, this.KFy);
      paramVarArgs.aY(9, this.KFz);
      AppMethodBeat.o(125812);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.gL(1);
      int i = g.a.a.b.b.a.gL(2);
      int j = g.a.a.b.b.a.gL(3);
      int k = g.a.a.b.b.a.gL(4);
      int m = g.a.a.b.b.a.bM(5, this.UmG);
      int n = g.a.a.b.b.a.p(6, this.UmH);
      int i1 = g.a.a.b.b.a.p(7, this.UmI);
      int i2 = g.a.a.b.b.a.gL(8);
      int i3 = g.a.a.b.b.a.bM(9, this.KFz);
      AppMethodBeat.o(125812);
      return paramInt + 4 + 0 + (i + 4) + (j + 4) + (k + 4) + m + n + i1 + (i2 + 4) + i3;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(125812);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      eks localeks = (eks)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125812);
        return -1;
      case 1: 
        localeks.UmC = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(125812);
        return 0;
      case 2: 
        localeks.UmD = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(125812);
        return 0;
      case 3: 
        localeks.UmE = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(125812);
        return 0;
      case 4: 
        localeks.UmF = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(125812);
        return 0;
      case 5: 
        localeks.UmG = locala.abFh.AK();
        AppMethodBeat.o(125812);
        return 0;
      case 6: 
        localeks.UmH = locala.abFh.AN();
        AppMethodBeat.o(125812);
        return 0;
      case 7: 
        localeks.UmI = locala.abFh.AN();
        AppMethodBeat.o(125812);
        return 0;
      case 8: 
        localeks.KFy = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(125812);
        return 0;
      }
      localeks.KFz = locala.abFh.AK();
      AppMethodBeat.o(125812);
      return 0;
    }
    AppMethodBeat.o(125812);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eks
 * JD-Core Version:    0.7.0.1
 */