package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bcc
  extends com.tencent.mm.bx.a
{
  public String ZNk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259479);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZNk != null) {
        paramVarArgs.g(1, this.ZNk);
      }
      AppMethodBeat.o(259479);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZNk == null) {
        break label209;
      }
    }
    label209:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZNk) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(259479);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259479);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bcc localbcc = (bcc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259479);
          return -1;
        }
        localbcc.ZNk = locala.ajGk.readString();
        AppMethodBeat.o(259479);
        return 0;
      }
      AppMethodBeat.o(259479);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcc
 * JD-Core Version:    0.7.0.1
 */