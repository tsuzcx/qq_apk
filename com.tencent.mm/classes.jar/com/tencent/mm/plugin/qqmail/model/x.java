package com.tencent.mm.plugin.qqmail.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class x
  extends com.tencent.mm.bx.a
{
  public String Hox;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122757);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Hox == null)
      {
        paramVarArgs = new b("Not all required fields were included: subject");
        AppMethodBeat.o(122757);
        throw paramVarArgs;
      }
      if (this.Hox != null) {
        paramVarArgs.g(1, this.Hox);
      }
      AppMethodBeat.o(122757);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hox == null) {
        break label257;
      }
    }
    label257:
    for (paramInt = i.a.a.b.b.a.h(1, this.Hox) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(122757);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.Hox == null)
        {
          paramVarArgs = new b("Not all required fields were included: subject");
          AppMethodBeat.o(122757);
          throw paramVarArgs;
        }
        AppMethodBeat.o(122757);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        x localx = (x)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(122757);
          return -1;
        }
        localx.Hox = locala.ajGk.readString();
        AppMethodBeat.o(122757);
        return 0;
      }
      AppMethodBeat.o(122757);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.model.x
 * JD-Core Version:    0.7.0.1
 */