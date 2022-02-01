package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dwk
  extends com.tencent.mm.bx.a
{
  public String aaNt;
  public boolean abcr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258445);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaNt != null) {
        paramVarArgs.g(1, this.aaNt);
      }
      paramVarArgs.di(2, this.abcr);
      AppMethodBeat.o(258445);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaNt == null) {
        break label254;
      }
    }
    label254:
    for (paramInt = i.a.a.b.b.a.h(1, this.aaNt) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.ko(2);
      AppMethodBeat.o(258445);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258445);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dwk localdwk = (dwk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258445);
          return -1;
        case 1: 
          localdwk.aaNt = locala.ajGk.readString();
          AppMethodBeat.o(258445);
          return 0;
        }
        localdwk.abcr = locala.ajGk.aai();
        AppMethodBeat.o(258445);
        return 0;
      }
      AppMethodBeat.o(258445);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwk
 * JD-Core Version:    0.7.0.1
 */