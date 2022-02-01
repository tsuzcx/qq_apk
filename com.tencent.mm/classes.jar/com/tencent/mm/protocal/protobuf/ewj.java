package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ewj
  extends com.tencent.mm.bw.a
{
  public String MVg;
  public int Nug;
  public String keh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32507);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MVg != null) {
        paramVarArgs.e(1, this.MVg);
      }
      if (this.keh != null) {
        paramVarArgs.e(2, this.keh);
      }
      paramVarArgs.aM(3, this.Nug);
      AppMethodBeat.o(32507);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MVg == null) {
        break label327;
      }
    }
    label327:
    for (paramInt = g.a.a.b.b.a.f(1, this.MVg) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.keh != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.keh);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.Nug);
      AppMethodBeat.o(32507);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32507);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ewj localewj = (ewj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32507);
          return -1;
        case 1: 
          localewj.MVg = locala.UbS.readString();
          AppMethodBeat.o(32507);
          return 0;
        case 2: 
          localewj.keh = locala.UbS.readString();
          AppMethodBeat.o(32507);
          return 0;
        }
        localewj.Nug = locala.UbS.zi();
        AppMethodBeat.o(32507);
        return 0;
      }
      AppMethodBeat.o(32507);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ewj
 * JD-Core Version:    0.7.0.1
 */