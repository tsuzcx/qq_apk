package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.cd.a
{
  public String CMP;
  public String CNj;
  public String GTG;
  public String lpy;
  public int rWu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91264);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CMP != null) {
        paramVarArgs.f(1, this.CMP);
      }
      if (this.GTG != null) {
        paramVarArgs.f(2, this.GTG);
      }
      paramVarArgs.aY(3, this.rWu);
      if (this.lpy != null) {
        paramVarArgs.f(4, this.lpy);
      }
      if (this.CNj != null) {
        paramVarArgs.f(5, this.CNj);
      }
      AppMethodBeat.o(91264);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CMP == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = g.a.a.b.b.a.g(1, this.CMP) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GTG != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.GTG);
      }
      i += g.a.a.b.b.a.bM(3, this.rWu);
      paramInt = i;
      if (this.lpy != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.lpy);
      }
      i = paramInt;
      if (this.CNj != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.CNj);
      }
      AppMethodBeat.o(91264);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91264);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        a locala1 = (a)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91264);
          return -1;
        case 1: 
          locala1.CMP = locala.abFh.readString();
          AppMethodBeat.o(91264);
          return 0;
        case 2: 
          locala1.GTG = locala.abFh.readString();
          AppMethodBeat.o(91264);
          return 0;
        case 3: 
          locala1.rWu = locala.abFh.AK();
          AppMethodBeat.o(91264);
          return 0;
        case 4: 
          locala1.lpy = locala.abFh.readString();
          AppMethodBeat.o(91264);
          return 0;
        }
        locala1.CNj = locala.abFh.readString();
        AppMethodBeat.o(91264);
        return 0;
      }
      AppMethodBeat.o(91264);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.a
 * JD-Core Version:    0.7.0.1
 */