package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class coz
  extends com.tencent.mm.cd.a
{
  public long RXl;
  public LinkedList<String> TwJ;
  
  public coz()
  {
    AppMethodBeat.i(252590);
    this.RXl = 0L;
    this.TwJ = new LinkedList();
    AppMethodBeat.o(252590);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(252592);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.RXl);
      paramVarArgs.e(2, 1, this.TwJ);
      AppMethodBeat.o(252592);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.p(1, this.RXl);
      int i = g.a.a.a.c(2, 1, this.TwJ);
      AppMethodBeat.o(252592);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.TwJ.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(252592);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      coz localcoz = (coz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(252592);
        return -1;
      case 1: 
        localcoz.RXl = locala.abFh.AN();
        AppMethodBeat.o(252592);
        return 0;
      }
      localcoz.TwJ.add(locala.abFh.readString());
      AppMethodBeat.o(252592);
      return 0;
    }
    AppMethodBeat.o(252592);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.coz
 * JD-Core Version:    0.7.0.1
 */