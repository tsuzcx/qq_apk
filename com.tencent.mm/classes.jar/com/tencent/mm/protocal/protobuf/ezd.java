package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ezd
  extends com.tencent.mm.cd.a
{
  public String SrJ;
  public String UserName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32490);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.f(1, this.UserName);
      }
      if (this.SrJ != null) {
        paramVarArgs.f(2, this.SrJ);
      }
      AppMethodBeat.o(32490);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label282;
      }
    }
    label282:
    for (paramInt = g.a.a.b.b.a.g(1, this.UserName) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SrJ != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.SrJ);
      }
      AppMethodBeat.o(32490);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32490);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ezd localezd = (ezd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32490);
          return -1;
        case 1: 
          localezd.UserName = locala.abFh.readString();
          AppMethodBeat.o(32490);
          return 0;
        }
        localezd.SrJ = locala.abFh.readString();
        AppMethodBeat.o(32490);
        return 0;
      }
      AppMethodBeat.o(32490);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezd
 * JD-Core Version:    0.7.0.1
 */