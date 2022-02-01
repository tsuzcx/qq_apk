package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bsr
  extends com.tencent.mm.bx.a
{
  public String aaav;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259900);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaav != null) {
        paramVarArgs.g(1, this.aaav);
      }
      AppMethodBeat.o(259900);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaav == null) {
        break label209;
      }
    }
    label209:
    for (paramInt = i.a.a.b.b.a.h(1, this.aaav) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(259900);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259900);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bsr localbsr = (bsr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259900);
          return -1;
        }
        localbsr.aaav = locala.ajGk.readString();
        AppMethodBeat.o(259900);
        return 0;
      }
      AppMethodBeat.o(259900);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsr
 * JD-Core Version:    0.7.0.1
 */