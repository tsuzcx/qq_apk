package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class xo
  extends com.tencent.mm.cd.a
{
  public int CRl;
  public String SjX;
  public double SjY;
  public double SjZ;
  public double Ska;
  public double Skb;
  public double Skc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(87874);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SjX != null) {
        paramVarArgs.f(1, this.SjX);
      }
      paramVarArgs.e(2, this.SjY);
      paramVarArgs.e(3, this.SjZ);
      paramVarArgs.e(4, this.Ska);
      paramVarArgs.e(5, this.Skb);
      paramVarArgs.e(6, this.Skc);
      paramVarArgs.aY(7, this.CRl);
      AppMethodBeat.o(87874);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SjX == null) {
        break label501;
      }
    }
    label501:
    for (paramInt = g.a.a.b.b.a.g(1, this.SjX) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.gL(2);
      int j = g.a.a.b.b.a.gL(3);
      int k = g.a.a.b.b.a.gL(4);
      int m = g.a.a.b.b.a.gL(5);
      int n = g.a.a.b.b.a.gL(6);
      int i1 = g.a.a.b.b.a.bM(7, this.CRl);
      AppMethodBeat.o(87874);
      return paramInt + (i + 8) + (j + 8) + (k + 8) + (m + 8) + (n + 8) + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(87874);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        xo localxo = (xo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(87874);
          return -1;
        case 1: 
          localxo.SjX = locala.abFh.readString();
          AppMethodBeat.o(87874);
          return 0;
        case 2: 
          localxo.SjY = Double.longBitsToDouble(locala.abFh.AP());
          AppMethodBeat.o(87874);
          return 0;
        case 3: 
          localxo.SjZ = Double.longBitsToDouble(locala.abFh.AP());
          AppMethodBeat.o(87874);
          return 0;
        case 4: 
          localxo.Ska = Double.longBitsToDouble(locala.abFh.AP());
          AppMethodBeat.o(87874);
          return 0;
        case 5: 
          localxo.Skb = Double.longBitsToDouble(locala.abFh.AP());
          AppMethodBeat.o(87874);
          return 0;
        case 6: 
          localxo.Skc = Double.longBitsToDouble(locala.abFh.AP());
          AppMethodBeat.o(87874);
          return 0;
        }
        localxo.CRl = locala.abFh.AK();
        AppMethodBeat.o(87874);
        return 0;
      }
      AppMethodBeat.o(87874);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xo
 * JD-Core Version:    0.7.0.1
 */