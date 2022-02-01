package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  extends com.tencent.mm.cd.a
{
  public int mKG;
  public int mKH;
  public int mKI;
  public long mKJ;
  public long mKK;
  public String mKL;
  public String mKM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91323);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.mKG);
      paramVarArgs.aY(2, this.mKH);
      paramVarArgs.aY(3, this.mKI);
      paramVarArgs.bm(4, this.mKJ);
      paramVarArgs.bm(5, this.mKK);
      if (this.mKL != null) {
        paramVarArgs.f(6, this.mKL);
      }
      if (this.mKM != null) {
        paramVarArgs.f(7, this.mKM);
      }
      AppMethodBeat.o(91323);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.mKG) + 0 + g.a.a.b.b.a.bM(2, this.mKH) + g.a.a.b.b.a.bM(3, this.mKI) + g.a.a.b.b.a.p(4, this.mKJ) + g.a.a.b.b.a.p(5, this.mKK);
      paramInt = i;
      if (this.mKL != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.mKL);
      }
      i = paramInt;
      if (this.mKM != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.mKM);
      }
      AppMethodBeat.o(91323);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(91323);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      o localo = (o)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91323);
        return -1;
      case 1: 
        localo.mKG = locala.abFh.AK();
        AppMethodBeat.o(91323);
        return 0;
      case 2: 
        localo.mKH = locala.abFh.AK();
        AppMethodBeat.o(91323);
        return 0;
      case 3: 
        localo.mKI = locala.abFh.AK();
        AppMethodBeat.o(91323);
        return 0;
      case 4: 
        localo.mKJ = locala.abFh.AN();
        AppMethodBeat.o(91323);
        return 0;
      case 5: 
        localo.mKK = locala.abFh.AN();
        AppMethodBeat.o(91323);
        return 0;
      case 6: 
        localo.mKL = locala.abFh.readString();
        AppMethodBeat.o(91323);
        return 0;
      }
      localo.mKM = locala.abFh.readString();
      AppMethodBeat.o(91323);
      return 0;
    }
    AppMethodBeat.o(91323);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.o
 * JD-Core Version:    0.7.0.1
 */