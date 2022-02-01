package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bew
  extends com.tencent.mm.bw.a
{
  public boolean tOS;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32212);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      paramVarArgs.cc(2, this.tOS);
      AppMethodBeat.o(32212);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label266;
      }
    }
    label266:
    for (paramInt = g.a.a.b.b.a.f(1, this.username) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.fS(2);
      AppMethodBeat.o(32212);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32212);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bew localbew = (bew)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32212);
          return -1;
        case 1: 
          localbew.username = locala.UbS.readString();
          AppMethodBeat.o(32212);
          return 0;
        }
        localbew.tOS = locala.UbS.yZ();
        AppMethodBeat.o(32212);
        return 0;
      }
      AppMethodBeat.o(32212);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bew
 * JD-Core Version:    0.7.0.1
 */