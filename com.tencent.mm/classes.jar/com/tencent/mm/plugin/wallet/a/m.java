package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  extends com.tencent.mm.bv.a
{
  public String por;
  public int selected;
  public String tUC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56655);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.tUC != null) {
        paramVarArgs.e(1, this.tUC);
      }
      paramVarArgs.aO(2, this.selected);
      if (this.por != null) {
        paramVarArgs.e(3, this.por);
      }
      AppMethodBeat.o(56655);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tUC == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = e.a.a.b.b.a.f(1, this.tUC) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.selected);
      paramInt = i;
      if (this.por != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.por);
      }
      AppMethodBeat.o(56655);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56655);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        m localm = (m)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56655);
          return -1;
        case 1: 
          localm.tUC = locala.CLY.readString();
          AppMethodBeat.o(56655);
          return 0;
        case 2: 
          localm.selected = locala.CLY.sl();
          AppMethodBeat.o(56655);
          return 0;
        }
        localm.por = locala.CLY.readString();
        AppMethodBeat.o(56655);
        return 0;
      }
      AppMethodBeat.o(56655);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.m
 * JD-Core Version:    0.7.0.1
 */