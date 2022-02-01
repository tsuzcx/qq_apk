package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fwx
  extends com.tencent.mm.bx.a
{
  public String abUM;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32493);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.g(1, this.username);
      }
      if (this.abUM != null) {
        paramVarArgs.g(2, this.abUM);
      }
      AppMethodBeat.o(32493);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label278;
      }
    }
    label278:
    for (paramInt = i.a.a.b.b.a.h(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abUM != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abUM);
      }
      AppMethodBeat.o(32493);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32493);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fwx localfwx = (fwx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32493);
          return -1;
        case 1: 
          localfwx.username = locala.ajGk.readString();
          AppMethodBeat.o(32493);
          return 0;
        }
        localfwx.abUM = locala.ajGk.readString();
        AppMethodBeat.o(32493);
        return 0;
      }
      AppMethodBeat.o(32493);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fwx
 * JD-Core Version:    0.7.0.1
 */