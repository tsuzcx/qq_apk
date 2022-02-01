package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ok
  extends com.tencent.mm.cd.a
{
  public String RTS;
  public LinkedList<String> RVG;
  
  public ok()
  {
    AppMethodBeat.i(206535);
    this.RVG = new LinkedList();
    AppMethodBeat.o(206535);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(206538);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RTS != null) {
        paramVarArgs.f(1, this.RTS);
      }
      paramVarArgs.e(2, 1, this.RVG);
      AppMethodBeat.o(206538);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RTS == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.g(1, this.RTS) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 1, this.RVG);
      AppMethodBeat.o(206538);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RVG.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(206538);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ok localok = (ok)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(206538);
          return -1;
        case 1: 
          localok.RTS = locala.abFh.readString();
          AppMethodBeat.o(206538);
          return 0;
        }
        localok.RVG.add(locala.abFh.readString());
        AppMethodBeat.o(206538);
        return 0;
      }
      AppMethodBeat.o(206538);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ok
 * JD-Core Version:    0.7.0.1
 */