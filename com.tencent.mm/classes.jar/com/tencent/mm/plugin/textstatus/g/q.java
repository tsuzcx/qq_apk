package com.tencent.mm.plugin.textstatus.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
  extends com.tencent.mm.bw.a
{
  public String GaI;
  public int GaJ;
  public String GaN;
  public String Gas;
  public int Gaz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(222839);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Gas != null) {
        paramVarArgs.e(1, this.Gas);
      }
      if (this.GaI != null) {
        paramVarArgs.e(2, this.GaI);
      }
      if (this.GaN != null) {
        paramVarArgs.e(3, this.GaN);
      }
      paramVarArgs.aM(4, this.GaJ);
      paramVarArgs.aM(5, this.Gaz);
      AppMethodBeat.o(222839);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gas == null) {
        break label426;
      }
    }
    label426:
    for (int i = g.a.a.b.b.a.f(1, this.Gas) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GaI != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.GaI);
      }
      i = paramInt;
      if (this.GaN != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.GaN);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.GaJ);
      int j = g.a.a.b.b.a.bu(5, this.Gaz);
      AppMethodBeat.o(222839);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(222839);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        q localq = (q)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(222839);
          return -1;
        case 1: 
          localq.Gas = locala.UbS.readString();
          AppMethodBeat.o(222839);
          return 0;
        case 2: 
          localq.GaI = locala.UbS.readString();
          AppMethodBeat.o(222839);
          return 0;
        case 3: 
          localq.GaN = locala.UbS.readString();
          AppMethodBeat.o(222839);
          return 0;
        case 4: 
          localq.GaJ = locala.UbS.zi();
          AppMethodBeat.o(222839);
          return 0;
        }
        localq.Gaz = locala.UbS.zi();
        AppMethodBeat.o(222839);
        return 0;
      }
      AppMethodBeat.o(222839);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.q
 * JD-Core Version:    0.7.0.1
 */