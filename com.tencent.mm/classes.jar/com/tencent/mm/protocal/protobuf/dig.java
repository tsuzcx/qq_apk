package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dig
  extends com.tencent.mm.cd.a
{
  public String CSe;
  public String LensId;
  public int TPA;
  public int TPB;
  public int TPw;
  public int TPx;
  public int TPy;
  public long TPz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104825);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.TPw);
      paramVarArgs.aY(2, this.TPx);
      paramVarArgs.aY(3, this.TPy);
      if (this.CSe != null) {
        paramVarArgs.f(4, this.CSe);
      }
      paramVarArgs.bm(5, this.TPz);
      paramVarArgs.aY(6, this.TPA);
      if (this.LensId != null) {
        paramVarArgs.f(7, this.LensId);
      }
      paramVarArgs.aY(8, this.TPB);
      AppMethodBeat.o(104825);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.TPw) + 0 + g.a.a.b.b.a.bM(2, this.TPx) + g.a.a.b.b.a.bM(3, this.TPy);
      paramInt = i;
      if (this.CSe != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CSe);
      }
      i = paramInt + g.a.a.b.b.a.p(5, this.TPz) + g.a.a.b.b.a.bM(6, this.TPA);
      paramInt = i;
      if (this.LensId != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.LensId);
      }
      i = g.a.a.b.b.a.bM(8, this.TPB);
      AppMethodBeat.o(104825);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(104825);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dig localdig = (dig)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104825);
        return -1;
      case 1: 
        localdig.TPw = locala.abFh.AK();
        AppMethodBeat.o(104825);
        return 0;
      case 2: 
        localdig.TPx = locala.abFh.AK();
        AppMethodBeat.o(104825);
        return 0;
      case 3: 
        localdig.TPy = locala.abFh.AK();
        AppMethodBeat.o(104825);
        return 0;
      case 4: 
        localdig.CSe = locala.abFh.readString();
        AppMethodBeat.o(104825);
        return 0;
      case 5: 
        localdig.TPz = locala.abFh.AN();
        AppMethodBeat.o(104825);
        return 0;
      case 6: 
        localdig.TPA = locala.abFh.AK();
        AppMethodBeat.o(104825);
        return 0;
      case 7: 
        localdig.LensId = locala.abFh.readString();
        AppMethodBeat.o(104825);
        return 0;
      }
      localdig.TPB = locala.abFh.AK();
      AppMethodBeat.o(104825);
      return 0;
    }
    AppMethodBeat.o(104825);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dig
 * JD-Core Version:    0.7.0.1
 */