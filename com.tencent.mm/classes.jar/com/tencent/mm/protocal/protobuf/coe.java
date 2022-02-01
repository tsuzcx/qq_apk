package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class coe
  extends com.tencent.mm.bw.a
{
  public int LEL;
  public int LGa;
  public String dVY;
  public String uUI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209763);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dVY != null) {
        paramVarArgs.e(1, this.dVY);
      }
      paramVarArgs.aM(2, this.LEL);
      paramVarArgs.aM(3, this.LGa);
      if (this.uUI != null) {
        paramVarArgs.e(4, this.uUI);
      }
      AppMethodBeat.o(209763);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dVY == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = g.a.a.b.b.a.f(1, this.dVY) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.LEL) + g.a.a.b.b.a.bu(3, this.LGa);
      paramInt = i;
      if (this.uUI != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.uUI);
      }
      AppMethodBeat.o(209763);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209763);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        coe localcoe = (coe)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209763);
          return -1;
        case 1: 
          localcoe.dVY = locala.UbS.readString();
          AppMethodBeat.o(209763);
          return 0;
        case 2: 
          localcoe.LEL = locala.UbS.zi();
          AppMethodBeat.o(209763);
          return 0;
        case 3: 
          localcoe.LGa = locala.UbS.zi();
          AppMethodBeat.o(209763);
          return 0;
        }
        localcoe.uUI = locala.UbS.readString();
        AppMethodBeat.o(209763);
        return 0;
      }
      AppMethodBeat.o(209763);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.coe
 * JD-Core Version:    0.7.0.1
 */