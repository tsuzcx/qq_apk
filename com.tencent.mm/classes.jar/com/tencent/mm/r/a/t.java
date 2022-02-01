package com.tencent.mm.r.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class t
  extends com.tencent.mm.bx.a
{
  public String met;
  public String meu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231431);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.met != null) {
        paramVarArgs.g(1, this.met);
      }
      if (this.meu != null) {
        paramVarArgs.g(2, this.meu);
      }
      AppMethodBeat.o(231431);
      return 0;
    }
    if (paramInt == 1) {
      if (this.met == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.met) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.meu != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.meu);
      }
      AppMethodBeat.o(231431);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(231431);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        t localt = (t)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(231431);
          return -1;
        case 1: 
          localt.met = locala.ajGk.readString();
          AppMethodBeat.o(231431);
          return 0;
        }
        localt.meu = locala.ajGk.readString();
        AppMethodBeat.o(231431);
        return 0;
      }
      AppMethodBeat.o(231431);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.r.a.t
 * JD-Core Version:    0.7.0.1
 */