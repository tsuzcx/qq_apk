package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fve
  extends com.tencent.mm.bx.a
{
  public String UserName;
  public String ZqN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32490);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.g(1, this.UserName);
      }
      if (this.ZqN != null) {
        paramVarArgs.g(2, this.ZqN);
      }
      AppMethodBeat.o(32490);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label278;
      }
    }
    label278:
    for (paramInt = i.a.a.b.b.a.h(1, this.UserName) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZqN != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.ZqN);
      }
      AppMethodBeat.o(32490);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32490);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fve localfve = (fve)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32490);
          return -1;
        case 1: 
          localfve.UserName = locala.ajGk.readString();
          AppMethodBeat.o(32490);
          return 0;
        }
        localfve.ZqN = locala.ajGk.readString();
        AppMethodBeat.o(32490);
        return 0;
      }
      AppMethodBeat.o(32490);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fve
 * JD-Core Version:    0.7.0.1
 */