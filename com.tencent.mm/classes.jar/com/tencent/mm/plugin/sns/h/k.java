package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class k
  extends com.tencent.mm.bv.a
{
  public String name;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(145286);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.name == null)
      {
        paramVarArgs = new b("Not all required fields were included: name");
        AppMethodBeat.o(145286);
        throw paramVarArgs;
      }
      if (this.name != null) {
        paramVarArgs.e(1, this.name);
      }
      paramVarArgs.aO(2, this.type);
      AppMethodBeat.o(145286);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = e.a.a.b.b.a.f(1, this.name) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.type);
      AppMethodBeat.o(145286);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.name == null)
        {
          paramVarArgs = new b("Not all required fields were included: name");
          AppMethodBeat.o(145286);
          throw paramVarArgs;
        }
        AppMethodBeat.o(145286);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        k localk = (k)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(145286);
          return -1;
        case 1: 
          localk.name = locala.CLY.readString();
          AppMethodBeat.o(145286);
          return 0;
        }
        localk.type = locala.CLY.sl();
        AppMethodBeat.o(145286);
        return 0;
      }
      AppMethodBeat.o(145286);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.k
 * JD-Core Version:    0.7.0.1
 */