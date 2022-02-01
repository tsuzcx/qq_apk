package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class bcr
  extends com.tencent.mm.cd.a
{
  public b DgQ;
  public int item_type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230403);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.item_type);
      if (this.DgQ != null) {
        paramVarArgs.c(2, this.DgQ);
      }
      AppMethodBeat.o(230403);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.item_type) + 0;
      paramInt = i;
      if (this.DgQ != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.DgQ);
      }
      AppMethodBeat.o(230403);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(230403);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bcr localbcr = (bcr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(230403);
        return -1;
      case 1: 
        localbcr.item_type = locala.abFh.AK();
        AppMethodBeat.o(230403);
        return 0;
      }
      localbcr.DgQ = locala.abFh.iUw();
      AppMethodBeat.o(230403);
      return 0;
    }
    AppMethodBeat.o(230403);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcr
 * JD-Core Version:    0.7.0.1
 */