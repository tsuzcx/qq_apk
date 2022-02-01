package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eut
  extends com.tencent.mm.cd.a
{
  public long Uwo;
  public long Uwp;
  public long Uwq;
  public double Uwr;
  public double Uws;
  public double Uwt;
  public double Uwu;
  public long Uwv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110914);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.Uwo);
      paramVarArgs.bm(2, this.Uwp);
      paramVarArgs.bm(3, this.Uwq);
      paramVarArgs.e(4, this.Uwr);
      paramVarArgs.e(5, this.Uws);
      paramVarArgs.e(6, this.Uwt);
      paramVarArgs.e(7, this.Uwu);
      paramVarArgs.bm(8, this.Uwv);
      AppMethodBeat.o(110914);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.p(1, this.Uwo);
      int i = g.a.a.b.b.a.p(2, this.Uwp);
      int j = g.a.a.b.b.a.p(3, this.Uwq);
      int k = g.a.a.b.b.a.gL(4);
      int m = g.a.a.b.b.a.gL(5);
      int n = g.a.a.b.b.a.gL(6);
      int i1 = g.a.a.b.b.a.gL(7);
      int i2 = g.a.a.b.b.a.p(8, this.Uwv);
      AppMethodBeat.o(110914);
      return paramInt + 0 + i + j + (k + 8) + (m + 8) + (n + 8) + (i1 + 8) + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(110914);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      eut localeut = (eut)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(110914);
        return -1;
      case 1: 
        localeut.Uwo = locala.abFh.AN();
        AppMethodBeat.o(110914);
        return 0;
      case 2: 
        localeut.Uwp = locala.abFh.AN();
        AppMethodBeat.o(110914);
        return 0;
      case 3: 
        localeut.Uwq = locala.abFh.AN();
        AppMethodBeat.o(110914);
        return 0;
      case 4: 
        localeut.Uwr = Double.longBitsToDouble(locala.abFh.AP());
        AppMethodBeat.o(110914);
        return 0;
      case 5: 
        localeut.Uws = Double.longBitsToDouble(locala.abFh.AP());
        AppMethodBeat.o(110914);
        return 0;
      case 6: 
        localeut.Uwt = Double.longBitsToDouble(locala.abFh.AP());
        AppMethodBeat.o(110914);
        return 0;
      case 7: 
        localeut.Uwu = Double.longBitsToDouble(locala.abFh.AP());
        AppMethodBeat.o(110914);
        return 0;
      }
      localeut.Uwv = locala.abFh.AN();
      AppMethodBeat.o(110914);
      return 0;
    }
    AppMethodBeat.o(110914);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eut
 * JD-Core Version:    0.7.0.1
 */