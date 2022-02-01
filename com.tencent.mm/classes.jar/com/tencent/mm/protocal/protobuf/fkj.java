package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class fkj
  extends com.tencent.mm.cd.a
{
  public String UJa;
  public String UJb;
  public String UJc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32562);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UJa == null)
      {
        paramVarArgs = new b("Not all required fields were included: Plugin");
        AppMethodBeat.o(32562);
        throw paramVarArgs;
      }
      if (this.UJb == null)
      {
        paramVarArgs = new b("Not all required fields were included: ActivityPath");
        AppMethodBeat.o(32562);
        throw paramVarArgs;
      }
      if (this.UJa != null) {
        paramVarArgs.f(1, this.UJa);
      }
      if (this.UJb != null) {
        paramVarArgs.f(2, this.UJb);
      }
      if (this.UJc != null) {
        paramVarArgs.f(3, this.UJc);
      }
      AppMethodBeat.o(32562);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UJa == null) {
        break label443;
      }
    }
    label443:
    for (int i = g.a.a.b.b.a.g(1, this.UJa) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UJb != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UJb);
      }
      i = paramInt;
      if (this.UJc != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.UJc);
      }
      AppMethodBeat.o(32562);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.UJa == null)
        {
          paramVarArgs = new b("Not all required fields were included: Plugin");
          AppMethodBeat.o(32562);
          throw paramVarArgs;
        }
        if (this.UJb == null)
        {
          paramVarArgs = new b("Not all required fields were included: ActivityPath");
          AppMethodBeat.o(32562);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32562);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fkj localfkj = (fkj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32562);
          return -1;
        case 1: 
          localfkj.UJa = locala.abFh.readString();
          AppMethodBeat.o(32562);
          return 0;
        case 2: 
          localfkj.UJb = locala.abFh.readString();
          AppMethodBeat.o(32562);
          return 0;
        }
        localfkj.UJc = locala.abFh.readString();
        AppMethodBeat.o(32562);
        return 0;
      }
      AppMethodBeat.o(32562);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fkj
 * JD-Core Version:    0.7.0.1
 */