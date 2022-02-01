package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class egk
  extends com.tencent.mm.bw.a
{
  public int Ngr;
  public String Ngs;
  public String Ngt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117933);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Ngr);
      if (this.Ngs != null) {
        paramVarArgs.e(2, this.Ngs);
      }
      if (this.Ngt != null) {
        paramVarArgs.e(3, this.Ngt);
      }
      AppMethodBeat.o(117933);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.Ngr) + 0;
      paramInt = i;
      if (this.Ngs != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Ngs);
      }
      i = paramInt;
      if (this.Ngt != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Ngt);
      }
      AppMethodBeat.o(117933);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(117933);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      egk localegk = (egk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117933);
        return -1;
      case 1: 
        localegk.Ngr = locala.UbS.zi();
        AppMethodBeat.o(117933);
        return 0;
      case 2: 
        localegk.Ngs = locala.UbS.readString();
        AppMethodBeat.o(117933);
        return 0;
      }
      localegk.Ngt = locala.UbS.readString();
      AppMethodBeat.o(117933);
      return 0;
    }
    AppMethodBeat.o(117933);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egk
 * JD-Core Version:    0.7.0.1
 */