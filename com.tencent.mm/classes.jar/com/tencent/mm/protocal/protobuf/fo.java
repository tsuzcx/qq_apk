package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fo
  extends com.tencent.mm.bw.a
{
  public boolean KJa;
  public boolean KJb;
  public int KJc;
  public int KJd;
  public int KJe;
  public int KJf;
  public int KJg;
  public boolean KJh;
  public boolean KJi;
  public boolean KJj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124386);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.cc(1, this.KJa);
      paramVarArgs.cc(2, this.KJb);
      paramVarArgs.aM(3, this.KJc);
      paramVarArgs.aM(4, this.KJd);
      paramVarArgs.aM(5, this.KJe);
      paramVarArgs.aM(6, this.KJf);
      paramVarArgs.aM(7, this.KJg);
      paramVarArgs.cc(8, this.KJh);
      paramVarArgs.cc(9, this.KJi);
      paramVarArgs.cc(10, this.KJj);
      AppMethodBeat.o(124386);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.fS(1);
      int i = g.a.a.b.b.a.fS(2);
      int j = g.a.a.b.b.a.bu(3, this.KJc);
      int k = g.a.a.b.b.a.bu(4, this.KJd);
      int m = g.a.a.b.b.a.bu(5, this.KJe);
      int n = g.a.a.b.b.a.bu(6, this.KJf);
      int i1 = g.a.a.b.b.a.bu(7, this.KJg);
      int i2 = g.a.a.b.b.a.fS(8);
      int i3 = g.a.a.b.b.a.fS(9);
      int i4 = g.a.a.b.b.a.fS(10);
      AppMethodBeat.o(124386);
      return paramInt + 1 + 0 + (i + 1) + j + k + m + n + i1 + (i2 + 1) + (i3 + 1) + (i4 + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(124386);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fo localfo = (fo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124386);
        return -1;
      case 1: 
        localfo.KJa = locala.UbS.yZ();
        AppMethodBeat.o(124386);
        return 0;
      case 2: 
        localfo.KJb = locala.UbS.yZ();
        AppMethodBeat.o(124386);
        return 0;
      case 3: 
        localfo.KJc = locala.UbS.zi();
        AppMethodBeat.o(124386);
        return 0;
      case 4: 
        localfo.KJd = locala.UbS.zi();
        AppMethodBeat.o(124386);
        return 0;
      case 5: 
        localfo.KJe = locala.UbS.zi();
        AppMethodBeat.o(124386);
        return 0;
      case 6: 
        localfo.KJf = locala.UbS.zi();
        AppMethodBeat.o(124386);
        return 0;
      case 7: 
        localfo.KJg = locala.UbS.zi();
        AppMethodBeat.o(124386);
        return 0;
      case 8: 
        localfo.KJh = locala.UbS.yZ();
        AppMethodBeat.o(124386);
        return 0;
      case 9: 
        localfo.KJi = locala.UbS.yZ();
        AppMethodBeat.o(124386);
        return 0;
      }
      localfo.KJj = locala.UbS.yZ();
      AppMethodBeat.o(124386);
      return 0;
    }
    AppMethodBeat.o(124386);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fo
 * JD-Core Version:    0.7.0.1
 */