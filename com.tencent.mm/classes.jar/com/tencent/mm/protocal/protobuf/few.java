package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class few
  extends com.tencent.mm.bw.a
{
  public String NAk;
  public String NAl;
  public String dNI;
  public int nJE;
  public int nLk;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123710);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.type);
      if (this.dNI != null) {
        paramVarArgs.e(2, this.dNI);
      }
      if (this.NAk != null) {
        paramVarArgs.e(3, this.NAk);
      }
      if (this.NAl != null) {
        paramVarArgs.e(4, this.NAl);
      }
      paramVarArgs.aM(5, this.nJE);
      paramVarArgs.aM(6, this.nLk);
      AppMethodBeat.o(123710);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.type) + 0;
      paramInt = i;
      if (this.dNI != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dNI);
      }
      i = paramInt;
      if (this.NAk != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.NAk);
      }
      paramInt = i;
      if (this.NAl != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.NAl);
      }
      i = g.a.a.b.b.a.bu(5, this.nJE);
      int j = g.a.a.b.b.a.bu(6, this.nLk);
      AppMethodBeat.o(123710);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(123710);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      few localfew = (few)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123710);
        return -1;
      case 1: 
        localfew.type = locala.UbS.zi();
        AppMethodBeat.o(123710);
        return 0;
      case 2: 
        localfew.dNI = locala.UbS.readString();
        AppMethodBeat.o(123710);
        return 0;
      case 3: 
        localfew.NAk = locala.UbS.readString();
        AppMethodBeat.o(123710);
        return 0;
      case 4: 
        localfew.NAl = locala.UbS.readString();
        AppMethodBeat.o(123710);
        return 0;
      case 5: 
        localfew.nJE = locala.UbS.zi();
        AppMethodBeat.o(123710);
        return 0;
      }
      localfew.nLk = locala.UbS.zi();
      AppMethodBeat.o(123710);
      return 0;
    }
    AppMethodBeat.o(123710);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.few
 * JD-Core Version:    0.7.0.1
 */