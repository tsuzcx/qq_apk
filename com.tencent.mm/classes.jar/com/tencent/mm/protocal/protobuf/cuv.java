package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cuv
  extends com.tencent.mm.cd.a
{
  public int ABK;
  public boolean TCA;
  public int TCB;
  public String TCC;
  public boolean TCD;
  public boolean TCE;
  public String TCF;
  public boolean TCz;
  public String appid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127172);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.co(1, this.TCz);
      paramVarArgs.co(2, this.TCA);
      paramVarArgs.aY(3, this.ABK);
      paramVarArgs.aY(4, this.TCB);
      if (this.TCC != null) {
        paramVarArgs.f(5, this.TCC);
      }
      paramVarArgs.co(6, this.TCD);
      if (this.appid != null) {
        paramVarArgs.f(7, this.appid);
      }
      paramVarArgs.co(8, this.TCE);
      if (this.TCF != null) {
        paramVarArgs.f(9, this.TCF);
      }
      AppMethodBeat.o(127172);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.gL(1) + 1 + 0 + (g.a.a.b.b.a.gL(2) + 1) + g.a.a.b.b.a.bM(3, this.ABK) + g.a.a.b.b.a.bM(4, this.TCB);
      paramInt = i;
      if (this.TCC != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.TCC);
      }
      i = paramInt + (g.a.a.b.b.a.gL(6) + 1);
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.appid);
      }
      i = paramInt + (g.a.a.b.b.a.gL(8) + 1);
      paramInt = i;
      if (this.TCF != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.TCF);
      }
      AppMethodBeat.o(127172);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(127172);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cuv localcuv = (cuv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127172);
        return -1;
      case 1: 
        localcuv.TCz = locala.abFh.AB();
        AppMethodBeat.o(127172);
        return 0;
      case 2: 
        localcuv.TCA = locala.abFh.AB();
        AppMethodBeat.o(127172);
        return 0;
      case 3: 
        localcuv.ABK = locala.abFh.AK();
        AppMethodBeat.o(127172);
        return 0;
      case 4: 
        localcuv.TCB = locala.abFh.AK();
        AppMethodBeat.o(127172);
        return 0;
      case 5: 
        localcuv.TCC = locala.abFh.readString();
        AppMethodBeat.o(127172);
        return 0;
      case 6: 
        localcuv.TCD = locala.abFh.AB();
        AppMethodBeat.o(127172);
        return 0;
      case 7: 
        localcuv.appid = locala.abFh.readString();
        AppMethodBeat.o(127172);
        return 0;
      case 8: 
        localcuv.TCE = locala.abFh.AB();
        AppMethodBeat.o(127172);
        return 0;
      }
      localcuv.TCF = locala.abFh.readString();
      AppMethodBeat.o(127172);
      return 0;
    }
    AppMethodBeat.o(127172);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuv
 * JD-Core Version:    0.7.0.1
 */