package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dle
  extends com.tencent.mm.cd.a
{
  public LinkedList<String> TSl;
  public int iUE;
  
  public dle()
  {
    AppMethodBeat.i(207775);
    this.TSl = new LinkedList();
    AppMethodBeat.o(207775);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207777);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.iUE);
      paramVarArgs.e(2, 1, this.TSl);
      AppMethodBeat.o(207777);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.iUE);
      int i = g.a.a.a.c(2, 1, this.TSl);
      AppMethodBeat.o(207777);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.TSl.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(207777);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dle localdle = (dle)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(207777);
        return -1;
      case 1: 
        localdle.iUE = locala.abFh.AK();
        AppMethodBeat.o(207777);
        return 0;
      }
      localdle.TSl.add(locala.abFh.readString());
      AppMethodBeat.o(207777);
      return 0;
    }
    AppMethodBeat.o(207777);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dle
 * JD-Core Version:    0.7.0.1
 */