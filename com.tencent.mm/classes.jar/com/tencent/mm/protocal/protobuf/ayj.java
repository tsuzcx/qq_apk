package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ayj
  extends com.tencent.mm.cd.a
{
  public String RRY;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230033);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RRY != null) {
        paramVarArgs.f(1, this.RRY);
      }
      if (this.title != null) {
        paramVarArgs.f(2, this.title);
      }
      AppMethodBeat.o(230033);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RRY == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.g(1, this.RRY) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.title);
      }
      AppMethodBeat.o(230033);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(230033);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ayj localayj = (ayj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(230033);
          return -1;
        case 1: 
          localayj.RRY = locala.abFh.readString();
          AppMethodBeat.o(230033);
          return 0;
        }
        localayj.title = locala.abFh.readString();
        AppMethodBeat.o(230033);
        return 0;
      }
      AppMethodBeat.o(230033);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayj
 * JD-Core Version:    0.7.0.1
 */