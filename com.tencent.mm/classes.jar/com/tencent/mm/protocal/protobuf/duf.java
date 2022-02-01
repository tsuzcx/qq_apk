package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class duf
  extends com.tencent.mm.cd.a
{
  public LinkedList<String> RXF;
  public String RXO;
  public long Uaz;
  
  public duf()
  {
    AppMethodBeat.i(205879);
    this.RXF = new LinkedList();
    AppMethodBeat.o(205879);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205882);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RXO != null) {
        paramVarArgs.f(1, this.RXO);
      }
      paramVarArgs.bm(2, this.Uaz);
      paramVarArgs.e(3, 1, this.RXF);
      AppMethodBeat.o(205882);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RXO == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.g(1, this.RXO) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.p(2, this.Uaz);
      int j = g.a.a.a.c(3, 1, this.RXF);
      AppMethodBeat.o(205882);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RXF.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(205882);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        duf localduf = (duf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(205882);
          return -1;
        case 1: 
          localduf.RXO = locala.abFh.readString();
          AppMethodBeat.o(205882);
          return 0;
        case 2: 
          localduf.Uaz = locala.abFh.AN();
          AppMethodBeat.o(205882);
          return 0;
        }
        localduf.RXF.add(locala.abFh.readString());
        AppMethodBeat.o(205882);
        return 0;
      }
      AppMethodBeat.o(205882);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duf
 * JD-Core Version:    0.7.0.1
 */