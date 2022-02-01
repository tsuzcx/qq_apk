package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eln
  extends com.tencent.mm.cd.a
{
  public LinkedList<Long> UnE;
  public String UnF;
  
  public eln()
  {
    AppMethodBeat.i(261598);
    this.UnE = new LinkedList();
    AppMethodBeat.o(261598);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(261606);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 3, this.UnE);
      if (this.UnF != null) {
        paramVarArgs.f(2, this.UnF);
      }
      AppMethodBeat.o(261606);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.a.c(1, 3, this.UnE) + 0;
      paramInt = i;
      if (this.UnF != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UnF);
      }
      AppMethodBeat.o(261606);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.UnE.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(261606);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      eln localeln = (eln)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(261606);
        return -1;
      case 1: 
        localeln.UnE.add(Long.valueOf(locala.abFh.AN()));
        AppMethodBeat.o(261606);
        return 0;
      }
      localeln.UnF = locala.abFh.readString();
      AppMethodBeat.o(261606);
      return 0;
    }
    AppMethodBeat.o(261606);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eln
 * JD-Core Version:    0.7.0.1
 */