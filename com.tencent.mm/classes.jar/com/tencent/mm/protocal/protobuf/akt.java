package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class akt
  extends com.tencent.mm.bw.a
{
  public int LtB;
  public String LtC;
  public String LtD;
  public String LtE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32199);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.LtB);
      if (this.LtC != null) {
        paramVarArgs.e(2, this.LtC);
      }
      if (this.LtD != null) {
        paramVarArgs.e(3, this.LtD);
      }
      if (this.LtE != null) {
        paramVarArgs.e(4, this.LtE);
      }
      AppMethodBeat.o(32199);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.LtB) + 0;
      paramInt = i;
      if (this.LtC != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LtC);
      }
      i = paramInt;
      if (this.LtD != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LtD);
      }
      paramInt = i;
      if (this.LtE != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LtE);
      }
      AppMethodBeat.o(32199);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(32199);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      akt localakt = (akt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32199);
        return -1;
      case 1: 
        localakt.LtB = locala.UbS.zi();
        AppMethodBeat.o(32199);
        return 0;
      case 2: 
        localakt.LtC = locala.UbS.readString();
        AppMethodBeat.o(32199);
        return 0;
      case 3: 
        localakt.LtD = locala.UbS.readString();
        AppMethodBeat.o(32199);
        return 0;
      }
      localakt.LtE = locala.UbS.readString();
      AppMethodBeat.o(32199);
      return 0;
    }
    AppMethodBeat.o(32199);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akt
 * JD-Core Version:    0.7.0.1
 */