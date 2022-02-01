package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class xi
  extends com.tencent.mm.bw.a
{
  public String LiG;
  public double LiH;
  public double LiI;
  public double LiJ;
  public double LiK;
  public double LiL;
  public int xNc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(87874);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LiG != null) {
        paramVarArgs.e(1, this.LiG);
      }
      paramVarArgs.e(2, this.LiH);
      paramVarArgs.e(3, this.LiI);
      paramVarArgs.e(4, this.LiJ);
      paramVarArgs.e(5, this.LiK);
      paramVarArgs.e(6, this.LiL);
      paramVarArgs.aM(7, this.xNc);
      AppMethodBeat.o(87874);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LiG == null) {
        break label501;
      }
    }
    label501:
    for (paramInt = g.a.a.b.b.a.f(1, this.LiG) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.fS(2);
      int j = g.a.a.b.b.a.fS(3);
      int k = g.a.a.b.b.a.fS(4);
      int m = g.a.a.b.b.a.fS(5);
      int n = g.a.a.b.b.a.fS(6);
      int i1 = g.a.a.b.b.a.bu(7, this.xNc);
      AppMethodBeat.o(87874);
      return paramInt + (i + 8) + (j + 8) + (k + 8) + (m + 8) + (n + 8) + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(87874);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        xi localxi = (xi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(87874);
          return -1;
        case 1: 
          localxi.LiG = locala.UbS.readString();
          AppMethodBeat.o(87874);
          return 0;
        case 2: 
          localxi.LiH = Double.longBitsToDouble(locala.UbS.zn());
          AppMethodBeat.o(87874);
          return 0;
        case 3: 
          localxi.LiI = Double.longBitsToDouble(locala.UbS.zn());
          AppMethodBeat.o(87874);
          return 0;
        case 4: 
          localxi.LiJ = Double.longBitsToDouble(locala.UbS.zn());
          AppMethodBeat.o(87874);
          return 0;
        case 5: 
          localxi.LiK = Double.longBitsToDouble(locala.UbS.zn());
          AppMethodBeat.o(87874);
          return 0;
        case 6: 
          localxi.LiL = Double.longBitsToDouble(locala.UbS.zn());
          AppMethodBeat.o(87874);
          return 0;
        }
        localxi.xNc = locala.UbS.zi();
        AppMethodBeat.o(87874);
        return 0;
      }
      AppMethodBeat.o(87874);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xi
 * JD-Core Version:    0.7.0.1
 */