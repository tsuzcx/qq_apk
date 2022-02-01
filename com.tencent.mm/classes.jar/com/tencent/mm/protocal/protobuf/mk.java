package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mk
  extends com.tencent.mm.cd.a
{
  public String RSe;
  public String path;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207387);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.f(1, this.username);
      }
      if (this.path != null) {
        paramVarArgs.f(2, this.path);
      }
      if (this.RSe != null) {
        paramVarArgs.f(3, this.RSe);
      }
      AppMethodBeat.o(207387);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.g(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.path != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.path);
      }
      i = paramInt;
      if (this.RSe != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RSe);
      }
      AppMethodBeat.o(207387);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(207387);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        mk localmk = (mk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(207387);
          return -1;
        case 1: 
          localmk.username = locala.abFh.readString();
          AppMethodBeat.o(207387);
          return 0;
        case 2: 
          localmk.path = locala.abFh.readString();
          AppMethodBeat.o(207387);
          return 0;
        }
        localmk.RSe = locala.abFh.readString();
        AppMethodBeat.o(207387);
        return 0;
      }
      AppMethodBeat.o(207387);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mk
 * JD-Core Version:    0.7.0.1
 */