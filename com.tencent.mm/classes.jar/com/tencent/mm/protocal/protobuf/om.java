package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class om
  extends com.tencent.mm.cd.a
{
  public String RTS;
  public LinkedList<String> RVG;
  public String RVJ;
  
  public om()
  {
    AppMethodBeat.i(207379);
    this.RVG = new LinkedList();
    AppMethodBeat.o(207379);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207382);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RTS != null) {
        paramVarArgs.f(1, this.RTS);
      }
      paramVarArgs.e(2, 1, this.RVG);
      if (this.RVJ != null) {
        paramVarArgs.f(3, this.RVJ);
      }
      AppMethodBeat.o(207382);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RTS == null) {
        break label334;
      }
    }
    label334:
    for (paramInt = g.a.a.b.b.a.g(1, this.RTS) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 1, this.RVG);
      paramInt = i;
      if (this.RVJ != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.RVJ);
      }
      AppMethodBeat.o(207382);
      return paramInt;
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
        AppMethodBeat.o(207382);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        om localom = (om)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(207382);
          return -1;
        case 1: 
          localom.RTS = locala.abFh.readString();
          AppMethodBeat.o(207382);
          return 0;
        case 2: 
          localom.RVG.add(locala.abFh.readString());
          AppMethodBeat.o(207382);
          return 0;
        }
        localom.RVJ = locala.abFh.readString();
        AppMethodBeat.o(207382);
        return 0;
      }
      AppMethodBeat.o(207382);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.om
 * JD-Core Version:    0.7.0.1
 */