package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fcn
  extends com.tencent.mm.cd.a
{
  public String UBZ;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200839);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.f(1, this.username);
      }
      if (this.UBZ != null) {
        paramVarArgs.f(2, this.UBZ);
      }
      AppMethodBeat.o(200839);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.g(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UBZ != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.UBZ);
      }
      AppMethodBeat.o(200839);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(200839);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fcn localfcn = (fcn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(200839);
          return -1;
        case 1: 
          localfcn.username = locala.abFh.readString();
          AppMethodBeat.o(200839);
          return 0;
        }
        localfcn.UBZ = locala.abFh.readString();
        AppMethodBeat.o(200839);
        return 0;
      }
      AppMethodBeat.o(200839);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fcn
 * JD-Core Version:    0.7.0.1
 */