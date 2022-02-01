package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class eyr
  extends com.tencent.mm.bw.a
{
  public String KWF;
  public int xNF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32530);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KWF == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(32530);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.xNF);
      if (this.KWF != null) {
        paramVarArgs.e(2, this.KWF);
      }
      AppMethodBeat.o(32530);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.xNF) + 0;
      paramInt = i;
      if (this.KWF != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KWF);
      }
      AppMethodBeat.o(32530);
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
      if (this.KWF == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(32530);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32530);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      eyr localeyr = (eyr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32530);
        return -1;
      case 1: 
        localeyr.xNF = locala.UbS.zi();
        AppMethodBeat.o(32530);
        return 0;
      }
      localeyr.KWF = locala.UbS.readString();
      AppMethodBeat.o(32530);
      return 0;
    }
    AppMethodBeat.o(32530);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eyr
 * JD-Core Version:    0.7.0.1
 */