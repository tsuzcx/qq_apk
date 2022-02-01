package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eex
  extends com.tencent.mm.cd.a
{
  public com.tencent.mm.cd.b Twz;
  public com.tencent.mm.cd.b Uiv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117924);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Uiv == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Name");
        AppMethodBeat.o(117924);
        throw paramVarArgs;
      }
      if (this.Twz == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Value");
        AppMethodBeat.o(117924);
        throw paramVarArgs;
      }
      if (this.Uiv != null) {
        paramVarArgs.c(1, this.Uiv);
      }
      if (this.Twz != null) {
        paramVarArgs.c(2, this.Twz);
      }
      AppMethodBeat.o(117924);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Uiv == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = g.a.a.b.b.a.b(1, this.Uiv) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Twz != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.Twz);
      }
      AppMethodBeat.o(117924);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Uiv == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: Name");
          AppMethodBeat.o(117924);
          throw paramVarArgs;
        }
        if (this.Twz == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: Value");
          AppMethodBeat.o(117924);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117924);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eex localeex = (eex)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117924);
          return -1;
        case 1: 
          localeex.Uiv = locala.abFh.iUw();
          AppMethodBeat.o(117924);
          return 0;
        }
        localeex.Twz = locala.abFh.iUw();
        AppMethodBeat.o(117924);
        return 0;
      }
      AppMethodBeat.o(117924);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eex
 * JD-Core Version:    0.7.0.1
 */