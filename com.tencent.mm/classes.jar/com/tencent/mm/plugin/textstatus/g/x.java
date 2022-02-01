package com.tencent.mm.plugin.textstatus.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class x
  extends com.tencent.mm.bw.a
{
  public int GaE;
  public String GaI;
  public String Gbg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(222846);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.GaI != null) {
        paramVarArgs.e(1, this.GaI);
      }
      if (this.Gbg != null) {
        paramVarArgs.e(2, this.Gbg);
      }
      paramVarArgs.aM(3, this.GaE);
      AppMethodBeat.o(222846);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GaI == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.f(1, this.GaI) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Gbg != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.Gbg);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.GaE);
      AppMethodBeat.o(222846);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(222846);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        x localx = (x)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(222846);
          return -1;
        case 1: 
          localx.GaI = locala.UbS.readString();
          AppMethodBeat.o(222846);
          return 0;
        case 2: 
          localx.Gbg = locala.UbS.readString();
          AppMethodBeat.o(222846);
          return 0;
        }
        localx.GaE = locala.UbS.zi();
        AppMethodBeat.o(222846);
        return 0;
      }
      AppMethodBeat.o(222846);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.x
 * JD-Core Version:    0.7.0.1
 */