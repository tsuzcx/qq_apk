package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  extends com.tencent.mm.bw.a
{
  public String ANo;
  public String HEP;
  public int selected;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91298);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.HEP != null) {
        paramVarArgs.e(1, this.HEP);
      }
      paramVarArgs.aM(2, this.selected);
      if (this.ANo != null) {
        paramVarArgs.e(3, this.ANo);
      }
      AppMethodBeat.o(91298);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HEP == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.f(1, this.HEP) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.selected);
      paramInt = i;
      if (this.ANo != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.ANo);
      }
      AppMethodBeat.o(91298);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
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
          localm.HEP = locala.UbS.readString();
          AppMethodBeat.o(91298);
          return 0;
        case 2: 
          localm.selected = locala.UbS.zi();
          AppMethodBeat.o(91298);
          return 0;
        }
        localm.ANo = locala.UbS.readString();
        AppMethodBeat.o(91298);
        return 0;
      }
      AppMethodBeat.o(91298);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.m
 * JD-Core Version:    0.7.0.1
 */