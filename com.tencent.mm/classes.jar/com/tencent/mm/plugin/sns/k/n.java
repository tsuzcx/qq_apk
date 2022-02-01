package com.tencent.mm.plugin.sns.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class n
  extends com.tencent.mm.bx.a
{
  public String name;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96164);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.name == null)
      {
        paramVarArgs = new b("Not all required fields were included: name");
        AppMethodBeat.o(96164);
        throw paramVarArgs;
      }
      if (this.name != null) {
        paramVarArgs.g(1, this.name);
      }
      paramVarArgs.bS(2, this.type);
      AppMethodBeat.o(96164);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = i.a.a.b.b.a.h(1, this.name) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.type);
      AppMethodBeat.o(96164);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.name == null)
        {
          paramVarArgs = new b("Not all required fields were included: name");
          AppMethodBeat.o(96164);
          throw paramVarArgs;
        }
        AppMethodBeat.o(96164);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        n localn = (n)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(96164);
          return -1;
        case 1: 
          localn.name = locala.ajGk.readString();
          AppMethodBeat.o(96164);
          return 0;
        }
        localn.type = locala.ajGk.aar();
        AppMethodBeat.o(96164);
        return 0;
      }
      AppMethodBeat.o(96164);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.k.n
 * JD-Core Version:    0.7.0.1
 */