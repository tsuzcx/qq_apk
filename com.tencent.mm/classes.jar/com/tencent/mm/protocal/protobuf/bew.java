package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bew
  extends com.tencent.mm.bx.a
{
  public String ZPh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258655);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZPh != null) {
        paramVarArgs.g(1, this.ZPh);
      }
      AppMethodBeat.o(258655);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZPh == null) {
        break label209;
      }
    }
    label209:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZPh) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(258655);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258655);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bew localbew = (bew)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258655);
          return -1;
        }
        localbew.ZPh = locala.ajGk.readString();
        AppMethodBeat.o(258655);
        return 0;
      }
      AppMethodBeat.o(258655);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bew
 * JD-Core Version:    0.7.0.1
 */