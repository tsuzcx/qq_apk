package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class sl
  extends com.tencent.mm.cd.a
{
  public int SbS;
  public int SbT;
  public int item_type;
  public b tqA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(247736);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SbS);
      paramVarArgs.aY(2, this.item_type);
      if (this.tqA != null) {
        paramVarArgs.c(3, this.tqA);
      }
      paramVarArgs.aY(4, this.SbT);
      AppMethodBeat.o(247736);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.SbS) + 0 + g.a.a.b.b.a.bM(2, this.item_type);
      paramInt = i;
      if (this.tqA != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.tqA);
      }
      i = g.a.a.b.b.a.bM(4, this.SbT);
      AppMethodBeat.o(247736);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(247736);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      sl localsl = (sl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(247736);
        return -1;
      case 1: 
        localsl.SbS = locala.abFh.AK();
        AppMethodBeat.o(247736);
        return 0;
      case 2: 
        localsl.item_type = locala.abFh.AK();
        AppMethodBeat.o(247736);
        return 0;
      case 3: 
        localsl.tqA = locala.abFh.iUw();
        AppMethodBeat.o(247736);
        return 0;
      }
      localsl.SbT = locala.abFh.AK();
      AppMethodBeat.o(247736);
      return 0;
    }
    AppMethodBeat.o(247736);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sl
 * JD-Core Version:    0.7.0.1
 */