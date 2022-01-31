package com.tencent.mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class c
  extends com.tencent.mm.bv.a
{
  public int jKs;
  public boolean qsm;
  public int qst;
  public String qsu;
  public boolean qsv;
  public boolean qsw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72718);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.qsu == null)
      {
        paramVarArgs = new b("Not all required fields were included: Value");
        AppMethodBeat.o(72718);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.qst);
      if (this.qsu != null) {
        paramVarArgs.e(2, this.qsu);
      }
      paramVarArgs.aS(3, this.qsv);
      paramVarArgs.aS(4, this.qsm);
      paramVarArgs.aO(5, this.jKs);
      paramVarArgs.aS(6, this.qsw);
      AppMethodBeat.o(72718);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.qst) + 0;
      paramInt = i;
      if (this.qsu != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.qsu);
      }
      i = e.a.a.b.b.a.eW(3);
      int j = e.a.a.b.b.a.eW(4);
      int k = e.a.a.b.b.a.bl(5, this.jKs);
      int m = e.a.a.b.b.a.eW(6);
      AppMethodBeat.o(72718);
      return paramInt + (i + 1) + (j + 1) + k + (m + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.qsu == null)
      {
        paramVarArgs = new b("Not all required fields were included: Value");
        AppMethodBeat.o(72718);
        throw paramVarArgs;
      }
      AppMethodBeat.o(72718);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(72718);
        return -1;
      case 1: 
        localc.qst = locala.CLY.sl();
        AppMethodBeat.o(72718);
        return 0;
      case 2: 
        localc.qsu = locala.CLY.readString();
        AppMethodBeat.o(72718);
        return 0;
      case 3: 
        localc.qsv = locala.CLY.emu();
        AppMethodBeat.o(72718);
        return 0;
      case 4: 
        localc.qsm = locala.CLY.emu();
        AppMethodBeat.o(72718);
        return 0;
      case 5: 
        localc.jKs = locala.CLY.sl();
        AppMethodBeat.o(72718);
        return 0;
      }
      localc.qsw = locala.CLY.emu();
      AppMethodBeat.o(72718);
      return 0;
    }
    AppMethodBeat.o(72718);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.c
 * JD-Core Version:    0.7.0.1
 */