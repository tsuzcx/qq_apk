package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eo
  extends com.tencent.mm.cd.a
{
  public String appId;
  public int cBU;
  public int cwR;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205523);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appId != null) {
        paramVarArgs.f(1, this.appId);
      }
      if (this.username != null) {
        paramVarArgs.f(2, this.username);
      }
      paramVarArgs.aY(3, this.cBU);
      paramVarArgs.aY(4, this.cwR);
      AppMethodBeat.o(205523);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appId == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = g.a.a.b.b.a.g(1, this.appId) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.username != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.username);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.cBU);
      int j = g.a.a.b.b.a.bM(4, this.cwR);
      AppMethodBeat.o(205523);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(205523);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eo localeo = (eo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(205523);
          return -1;
        case 1: 
          localeo.appId = locala.abFh.readString();
          AppMethodBeat.o(205523);
          return 0;
        case 2: 
          localeo.username = locala.abFh.readString();
          AppMethodBeat.o(205523);
          return 0;
        case 3: 
          localeo.cBU = locala.abFh.AK();
          AppMethodBeat.o(205523);
          return 0;
        }
        localeo.cwR = locala.abFh.AK();
        AppMethodBeat.o(205523);
        return 0;
      }
      AppMethodBeat.o(205523);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eo
 * JD-Core Version:    0.7.0.1
 */