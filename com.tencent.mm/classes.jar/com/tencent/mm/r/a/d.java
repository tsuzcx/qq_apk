package com.tencent.mm.r.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends com.tencent.mm.bx.a
{
  public String appid;
  public String mdE;
  public String mdF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231407);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.g(1, this.appid);
      }
      if (this.mdE != null) {
        paramVarArgs.g(2, this.mdE);
      }
      if (this.mdF != null) {
        paramVarArgs.g(3, this.mdF);
      }
      AppMethodBeat.o(231407);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.appid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mdE != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.mdE);
      }
      i = paramInt;
      if (this.mdF != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.mdF);
      }
      AppMethodBeat.o(231407);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(231407);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(231407);
          return -1;
        case 1: 
          locald.appid = locala.ajGk.readString();
          AppMethodBeat.o(231407);
          return 0;
        case 2: 
          locald.mdE = locala.ajGk.readString();
          AppMethodBeat.o(231407);
          return 0;
        }
        locald.mdF = locala.ajGk.readString();
        AppMethodBeat.o(231407);
        return 0;
      }
      AppMethodBeat.o(231407);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.r.a.d
 * JD-Core Version:    0.7.0.1
 */