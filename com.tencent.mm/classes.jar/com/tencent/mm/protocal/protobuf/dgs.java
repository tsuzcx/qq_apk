package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class dgs
  extends com.tencent.mm.bx.a
{
  public String aaLL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257935);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaLL != null) {
        paramVarArgs.g(1, this.aaLL);
      }
      AppMethodBeat.o(257935);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaLL == null) {
        break label209;
      }
    }
    label209:
    for (paramInt = i.a.a.b.b.a.h(1, this.aaLL) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(257935);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257935);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dgs localdgs = (dgs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257935);
          return -1;
        }
        localdgs.aaLL = locala.ajGk.readString();
        AppMethodBeat.o(257935);
        return 0;
      }
      AppMethodBeat.o(257935);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgs
 * JD-Core Version:    0.7.0.1
 */