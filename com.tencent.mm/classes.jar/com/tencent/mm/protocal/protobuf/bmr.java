package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bmr
  extends com.tencent.mm.cd.a
{
  public int SXA = 0;
  public String SXB = "";
  public boolean SXC = false;
  public int SXy = 7;
  public long SXz = 0L;
  public int aNf = 0;
  public int mbp = 0;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122494);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SXy);
      paramVarArgs.bm(2, this.SXz);
      paramVarArgs.aY(3, this.SXA);
      if (this.SXB != null) {
        paramVarArgs.f(4, this.SXB);
      }
      paramVarArgs.aY(5, this.aNf);
      paramVarArgs.aY(6, this.mbp);
      paramVarArgs.co(7, this.SXC);
      AppMethodBeat.o(122494);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.SXy) + 0 + g.a.a.b.b.a.p(2, this.SXz) + g.a.a.b.b.a.bM(3, this.SXA);
      paramInt = i;
      if (this.SXB != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SXB);
      }
      i = g.a.a.b.b.a.bM(5, this.aNf);
      int j = g.a.a.b.b.a.bM(6, this.mbp);
      int k = g.a.a.b.b.a.gL(7);
      AppMethodBeat.o(122494);
      return paramInt + i + j + (k + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(122494);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bmr localbmr = (bmr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(122494);
        return -1;
      case 1: 
        localbmr.SXy = locala.abFh.AK();
        AppMethodBeat.o(122494);
        return 0;
      case 2: 
        localbmr.SXz = locala.abFh.AN();
        AppMethodBeat.o(122494);
        return 0;
      case 3: 
        localbmr.SXA = locala.abFh.AK();
        AppMethodBeat.o(122494);
        return 0;
      case 4: 
        localbmr.SXB = locala.abFh.readString();
        AppMethodBeat.o(122494);
        return 0;
      case 5: 
        localbmr.aNf = locala.abFh.AK();
        AppMethodBeat.o(122494);
        return 0;
      case 6: 
        localbmr.mbp = locala.abFh.AK();
        AppMethodBeat.o(122494);
        return 0;
      }
      localbmr.SXC = locala.abFh.AB();
      AppMethodBeat.o(122494);
      return 0;
    }
    AppMethodBeat.o(122494);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmr
 * JD-Core Version:    0.7.0.1
 */