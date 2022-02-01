package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fia
  extends com.tencent.mm.cd.a
{
  public String InB;
  public String username;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(250492);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.f(1, this.username);
      }
      if (this.InB != null) {
        paramVarArgs.f(2, this.InB);
      }
      paramVarArgs.aY(3, this.version);
      AppMethodBeat.o(250492);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.g(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.InB != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.InB);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.version);
      AppMethodBeat.o(250492);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(250492);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fia localfia = (fia)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(250492);
          return -1;
        case 1: 
          localfia.username = locala.abFh.readString();
          AppMethodBeat.o(250492);
          return 0;
        case 2: 
          localfia.InB = locala.abFh.readString();
          AppMethodBeat.o(250492);
          return 0;
        }
        localfia.version = locala.abFh.AK();
        AppMethodBeat.o(250492);
        return 0;
      }
      AppMethodBeat.o(250492);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fia
 * JD-Core Version:    0.7.0.1
 */