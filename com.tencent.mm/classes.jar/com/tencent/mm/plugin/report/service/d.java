package com.tencent.mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class d
  extends com.tencent.mm.cd.a
{
  public boolean Izb;
  public String Izj;
  public boolean Izk;
  public boolean Izl;
  public int jUg;
  public int rWu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143831);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Izj == null)
      {
        paramVarArgs = new b("Not all required fields were included: Value");
        AppMethodBeat.o(143831);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.jUg);
      if (this.Izj != null) {
        paramVarArgs.f(2, this.Izj);
      }
      paramVarArgs.co(3, this.Izk);
      paramVarArgs.co(4, this.Izb);
      paramVarArgs.aY(5, this.rWu);
      paramVarArgs.co(6, this.Izl);
      AppMethodBeat.o(143831);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.jUg) + 0;
      paramInt = i;
      if (this.Izj != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Izj);
      }
      i = g.a.a.b.b.a.gL(3);
      int j = g.a.a.b.b.a.gL(4);
      int k = g.a.a.b.b.a.bM(5, this.rWu);
      int m = g.a.a.b.b.a.gL(6);
      AppMethodBeat.o(143831);
      return paramInt + (i + 1) + (j + 1) + k + (m + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.Izj == null)
      {
        paramVarArgs = new b("Not all required fields were included: Value");
        AppMethodBeat.o(143831);
        throw paramVarArgs;
      }
      AppMethodBeat.o(143831);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143831);
        return -1;
      case 1: 
        locald.jUg = locala.abFh.AK();
        AppMethodBeat.o(143831);
        return 0;
      case 2: 
        locald.Izj = locala.abFh.readString();
        AppMethodBeat.o(143831);
        return 0;
      case 3: 
        locald.Izk = locala.abFh.AB();
        AppMethodBeat.o(143831);
        return 0;
      case 4: 
        locald.Izb = locala.abFh.AB();
        AppMethodBeat.o(143831);
        return 0;
      case 5: 
        locald.rWu = locala.abFh.AK();
        AppMethodBeat.o(143831);
        return 0;
      }
      locald.Izl = locala.abFh.AB();
      AppMethodBeat.o(143831);
      return 0;
    }
    AppMethodBeat.o(143831);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.d
 * JD-Core Version:    0.7.0.1
 */