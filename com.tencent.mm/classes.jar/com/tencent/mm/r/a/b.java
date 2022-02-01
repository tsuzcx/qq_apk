package com.tencent.mm.r.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bx.a
{
  public String mdC;
  public String mdD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231404);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.mdC != null) {
        paramVarArgs.g(1, this.mdC);
      }
      if (this.mdD != null) {
        paramVarArgs.g(2, this.mdD);
      }
      AppMethodBeat.o(231404);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mdC == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.mdC) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.mdD != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.mdD);
      }
      AppMethodBeat.o(231404);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(231404);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(231404);
          return -1;
        case 1: 
          localb.mdC = locala.ajGk.readString();
          AppMethodBeat.o(231404);
          return 0;
        }
        localb.mdD = locala.ajGk.readString();
        AppMethodBeat.o(231404);
        return 0;
      }
      AppMethodBeat.o(231404);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.r.a.b
 * JD-Core Version:    0.7.0.1
 */