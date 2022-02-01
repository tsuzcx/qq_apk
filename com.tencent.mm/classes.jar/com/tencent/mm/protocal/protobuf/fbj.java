package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class fbj
  extends com.tencent.mm.cd.a
{
  public boolean Nop;
  public String PzO;
  public long duration;
  public String kXi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(255084);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.PzO == null)
      {
        paramVarArgs = new b("Not all required fields were included: templatePath");
        AppMethodBeat.o(255084);
        throw paramVarArgs;
      }
      if (this.kXi == null)
      {
        paramVarArgs = new b("Not all required fields were included: musicPath");
        AppMethodBeat.o(255084);
        throw paramVarArgs;
      }
      if (this.PzO != null) {
        paramVarArgs.f(1, this.PzO);
      }
      if (this.kXi != null) {
        paramVarArgs.f(2, this.kXi);
      }
      paramVarArgs.bm(3, this.duration);
      paramVarArgs.co(4, this.Nop);
      AppMethodBeat.o(255084);
      return 0;
    }
    if (paramInt == 1) {
      if (this.PzO == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = g.a.a.b.b.a.g(1, this.PzO) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.kXi != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.kXi);
      }
      paramInt = g.a.a.b.b.a.p(3, this.duration);
      int j = g.a.a.b.b.a.gL(4);
      AppMethodBeat.o(255084);
      return i + paramInt + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.PzO == null)
        {
          paramVarArgs = new b("Not all required fields were included: templatePath");
          AppMethodBeat.o(255084);
          throw paramVarArgs;
        }
        if (this.kXi == null)
        {
          paramVarArgs = new b("Not all required fields were included: musicPath");
          AppMethodBeat.o(255084);
          throw paramVarArgs;
        }
        AppMethodBeat.o(255084);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fbj localfbj = (fbj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(255084);
          return -1;
        case 1: 
          localfbj.PzO = locala.abFh.readString();
          AppMethodBeat.o(255084);
          return 0;
        case 2: 
          localfbj.kXi = locala.abFh.readString();
          AppMethodBeat.o(255084);
          return 0;
        case 3: 
          localfbj.duration = locala.abFh.AN();
          AppMethodBeat.o(255084);
          return 0;
        }
        localfbj.Nop = locala.abFh.AB();
        AppMethodBeat.o(255084);
        return 0;
      }
      AppMethodBeat.o(255084);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbj
 * JD-Core Version:    0.7.0.1
 */