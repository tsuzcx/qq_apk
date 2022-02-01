package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class aly
  extends com.tencent.mm.cd.a
{
  public String SvX;
  public String Swi;
  public LinkedList<String> Swj;
  public boolean Swk;
  
  public aly()
  {
    AppMethodBeat.i(32203);
    this.Swj = new LinkedList();
    AppMethodBeat.o(32203);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32204);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SvX == null)
      {
        paramVarArgs = new b("Not all required fields were included: LoginUrl");
        AppMethodBeat.o(32204);
        throw paramVarArgs;
      }
      if (this.SvX != null) {
        paramVarArgs.f(1, this.SvX);
      }
      if (this.Swi != null) {
        paramVarArgs.f(2, this.Swi);
      }
      paramVarArgs.e(3, 1, this.Swj);
      paramVarArgs.co(4, this.Swk);
      AppMethodBeat.o(32204);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SvX == null) {
        break label436;
      }
    }
    label436:
    for (paramInt = g.a.a.b.b.a.g(1, this.SvX) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Swi != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.Swi);
      }
      paramInt = g.a.a.a.c(3, 1, this.Swj);
      int j = g.a.a.b.b.a.gL(4);
      AppMethodBeat.o(32204);
      return i + paramInt + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Swj.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.SvX == null)
        {
          paramVarArgs = new b("Not all required fields were included: LoginUrl");
          AppMethodBeat.o(32204);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32204);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        aly localaly = (aly)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32204);
          return -1;
        case 1: 
          localaly.SvX = locala.abFh.readString();
          AppMethodBeat.o(32204);
          return 0;
        case 2: 
          localaly.Swi = locala.abFh.readString();
          AppMethodBeat.o(32204);
          return 0;
        case 3: 
          localaly.Swj.add(locala.abFh.readString());
          AppMethodBeat.o(32204);
          return 0;
        }
        localaly.Swk = locala.abFh.AB();
        AppMethodBeat.o(32204);
        return 0;
      }
      AppMethodBeat.o(32204);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aly
 * JD-Core Version:    0.7.0.1
 */