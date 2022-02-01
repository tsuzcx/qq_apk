package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dfj
  extends com.tencent.mm.cd.a
{
  public String announcement;
  public String mye;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152641);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.mye != null) {
        paramVarArgs.f(1, this.mye);
      }
      if (this.announcement != null) {
        paramVarArgs.f(2, this.announcement);
      }
      AppMethodBeat.o(152641);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mye == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.g(1, this.mye) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.announcement != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.announcement);
      }
      AppMethodBeat.o(152641);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152641);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dfj localdfj = (dfj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152641);
          return -1;
        case 1: 
          localdfj.mye = locala.abFh.readString();
          AppMethodBeat.o(152641);
          return 0;
        }
        localdfj.announcement = locala.abFh.readString();
        AppMethodBeat.o(152641);
        return 0;
      }
      AppMethodBeat.o(152641);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfj
 * JD-Core Version:    0.7.0.1
 */