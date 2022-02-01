package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class qq
  extends com.tencent.mm.cd.a
{
  public b RYU;
  public b RYV;
  public int port;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133158);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.type);
      paramVarArgs.aY(2, this.port);
      if (this.RYU != null) {
        paramVarArgs.c(3, this.RYU);
      }
      if (this.RYV != null) {
        paramVarArgs.c(4, this.RYV);
      }
      AppMethodBeat.o(133158);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.type) + 0 + g.a.a.b.b.a.bM(2, this.port);
      paramInt = i;
      if (this.RYU != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.RYU);
      }
      i = paramInt;
      if (this.RYV != null) {
        i = paramInt + g.a.a.b.b.a.b(4, this.RYV);
      }
      AppMethodBeat.o(133158);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(133158);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      qq localqq = (qq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(133158);
        return -1;
      case 1: 
        localqq.type = locala.abFh.AK();
        AppMethodBeat.o(133158);
        return 0;
      case 2: 
        localqq.port = locala.abFh.AK();
        AppMethodBeat.o(133158);
        return 0;
      case 3: 
        localqq.RYU = locala.abFh.iUw();
        AppMethodBeat.o(133158);
        return 0;
      }
      localqq.RYV = locala.abFh.iUw();
      AppMethodBeat.o(133158);
      return 0;
    }
    AppMethodBeat.o(133158);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qq
 * JD-Core Version:    0.7.0.1
 */