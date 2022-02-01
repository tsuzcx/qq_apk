package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  extends com.tencent.mm.cd.a
{
  public String GGC;
  public String OwI;
  public int selected;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91298);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.OwI != null) {
        paramVarArgs.f(1, this.OwI);
      }
      paramVarArgs.aY(2, this.selected);
      if (this.GGC != null) {
        paramVarArgs.f(3, this.GGC);
      }
      AppMethodBeat.o(91298);
      return 0;
    }
    if (paramInt == 1) {
      if (this.OwI == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.g(1, this.OwI) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.selected);
      paramInt = i;
      if (this.GGC != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.GGC);
      }
      AppMethodBeat.o(91298);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91298);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        m localm = (m)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91298);
          return -1;
        case 1: 
          localm.OwI = locala.abFh.readString();
          AppMethodBeat.o(91298);
          return 0;
        case 2: 
          localm.selected = locala.abFh.AK();
          AppMethodBeat.o(91298);
          return 0;
        }
        localm.GGC = locala.abFh.readString();
        AppMethodBeat.o(91298);
        return 0;
      }
      AppMethodBeat.o(91298);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.m
 * JD-Core Version:    0.7.0.1
 */