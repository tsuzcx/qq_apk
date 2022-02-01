package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dlv
  extends com.tencent.mm.cd.a
{
  public String TSO;
  public LinkedList<String> TSP;
  
  public dlv()
  {
    AppMethodBeat.i(201126);
    this.TSP = new LinkedList();
    AppMethodBeat.o(201126);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(201138);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TSO != null) {
        paramVarArgs.f(1, this.TSO);
      }
      paramVarArgs.e(2, 1, this.TSP);
      AppMethodBeat.o(201138);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TSO == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.g(1, this.TSO) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 1, this.TSP);
      AppMethodBeat.o(201138);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TSP.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(201138);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dlv localdlv = (dlv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(201138);
          return -1;
        case 1: 
          localdlv.TSO = locala.abFh.readString();
          AppMethodBeat.o(201138);
          return 0;
        }
        localdlv.TSP.add(locala.abFh.readString());
        AppMethodBeat.o(201138);
        return 0;
      }
      AppMethodBeat.o(201138);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlv
 * JD-Core Version:    0.7.0.1
 */