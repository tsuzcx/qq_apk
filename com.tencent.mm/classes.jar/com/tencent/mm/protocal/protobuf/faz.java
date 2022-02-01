package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class faz
  extends com.tencent.mm.bw.a
{
  public String AZx;
  public int Bac;
  public int Nxr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(214327);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.AZx != null) {
        paramVarArgs.e(1, this.AZx);
      }
      paramVarArgs.aM(2, this.Nxr);
      paramVarArgs.aM(3, this.Bac);
      AppMethodBeat.o(214327);
      return 0;
    }
    if (paramInt == 1) {
      if (this.AZx == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = g.a.a.b.b.a.f(1, this.AZx) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.Nxr);
      int j = g.a.a.b.b.a.bu(3, this.Bac);
      AppMethodBeat.o(214327);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(214327);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        faz localfaz = (faz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(214327);
          return -1;
        case 1: 
          localfaz.AZx = locala.UbS.readString();
          AppMethodBeat.o(214327);
          return 0;
        case 2: 
          localfaz.Nxr = locala.UbS.zi();
          AppMethodBeat.o(214327);
          return 0;
        }
        localfaz.Bac = locala.UbS.zi();
        AppMethodBeat.o(214327);
        return 0;
      }
      AppMethodBeat.o(214327);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.faz
 * JD-Core Version:    0.7.0.1
 */