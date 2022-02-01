package com.tencent.mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class d
  extends com.tencent.mm.bw.a
{
  public boolean Cyc;
  public String Cyk;
  public boolean Cyl;
  public boolean Cym;
  public int hii;
  public int oUv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143831);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Cyk == null)
      {
        paramVarArgs = new b("Not all required fields were included: Value");
        AppMethodBeat.o(143831);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.hii);
      if (this.Cyk != null) {
        paramVarArgs.e(2, this.Cyk);
      }
      paramVarArgs.cc(3, this.Cyl);
      paramVarArgs.cc(4, this.Cyc);
      paramVarArgs.aM(5, this.oUv);
      paramVarArgs.cc(6, this.Cym);
      AppMethodBeat.o(143831);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.hii) + 0;
      paramInt = i;
      if (this.Cyk != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Cyk);
      }
      i = g.a.a.b.b.a.fS(3);
      int j = g.a.a.b.b.a.fS(4);
      int k = g.a.a.b.b.a.bu(5, this.oUv);
      int m = g.a.a.b.b.a.fS(6);
      AppMethodBeat.o(143831);
      return paramInt + (i + 1) + (j + 1) + k + (m + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.Cyk == null)
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
        locald.hii = locala.UbS.zi();
        AppMethodBeat.o(143831);
        return 0;
      case 2: 
        locald.Cyk = locala.UbS.readString();
        AppMethodBeat.o(143831);
        return 0;
      case 3: 
        locald.Cyl = locala.UbS.yZ();
        AppMethodBeat.o(143831);
        return 0;
      case 4: 
        locald.Cyc = locala.UbS.yZ();
        AppMethodBeat.o(143831);
        return 0;
      case 5: 
        locald.oUv = locala.UbS.zi();
        AppMethodBeat.o(143831);
        return 0;
      }
      locald.Cym = locala.UbS.yZ();
      AppMethodBeat.o(143831);
      return 0;
    }
    AppMethodBeat.o(143831);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.d
 * JD-Core Version:    0.7.0.1
 */