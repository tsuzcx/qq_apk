package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cve
  extends com.tencent.mm.cd.a
{
  public int TCM;
  public int TCN;
  public int TCO;
  public int scene;
  public String sessionBuffer;
  public int wGA;
  public long xbk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184214);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.xbk);
      paramVarArgs.aY(2, this.scene);
      paramVarArgs.aY(3, this.wGA);
      paramVarArgs.aY(4, this.TCM);
      if (this.sessionBuffer != null) {
        paramVarArgs.f(5, this.sessionBuffer);
      }
      paramVarArgs.aY(6, this.TCN);
      paramVarArgs.aY(7, this.TCO);
      AppMethodBeat.o(184214);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.xbk) + 0 + g.a.a.b.b.a.bM(2, this.scene) + g.a.a.b.b.a.bM(3, this.wGA) + g.a.a.b.b.a.bM(4, this.TCM);
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.sessionBuffer);
      }
      i = g.a.a.b.b.a.bM(6, this.TCN);
      int j = g.a.a.b.b.a.bM(7, this.TCO);
      AppMethodBeat.o(184214);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(184214);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cve localcve = (cve)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(184214);
        return -1;
      case 1: 
        localcve.xbk = locala.abFh.AN();
        AppMethodBeat.o(184214);
        return 0;
      case 2: 
        localcve.scene = locala.abFh.AK();
        AppMethodBeat.o(184214);
        return 0;
      case 3: 
        localcve.wGA = locala.abFh.AK();
        AppMethodBeat.o(184214);
        return 0;
      case 4: 
        localcve.TCM = locala.abFh.AK();
        AppMethodBeat.o(184214);
        return 0;
      case 5: 
        localcve.sessionBuffer = locala.abFh.readString();
        AppMethodBeat.o(184214);
        return 0;
      case 6: 
        localcve.TCN = locala.abFh.AK();
        AppMethodBeat.o(184214);
        return 0;
      }
      localcve.TCO = locala.abFh.AK();
      AppMethodBeat.o(184214);
      return 0;
    }
    AppMethodBeat.o(184214);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cve
 * JD-Core Version:    0.7.0.1
 */