package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class djt
  extends com.tencent.mm.bx.a
{
  public String aaPI;
  public int end;
  public int start;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259802);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaPI != null) {
        paramVarArgs.g(1, this.aaPI);
      }
      paramVarArgs.bS(2, this.start);
      paramVarArgs.bS(3, this.end);
      AppMethodBeat.o(259802);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaPI == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = i.a.a.b.b.a.h(1, this.aaPI) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.start);
      int j = i.a.a.b.b.a.cJ(3, this.end);
      AppMethodBeat.o(259802);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259802);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        djt localdjt = (djt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259802);
          return -1;
        case 1: 
          localdjt.aaPI = locala.ajGk.readString();
          AppMethodBeat.o(259802);
          return 0;
        case 2: 
          localdjt.start = locala.ajGk.aar();
          AppMethodBeat.o(259802);
          return 0;
        }
        localdjt.end = locala.ajGk.aar();
        AppMethodBeat.o(259802);
        return 0;
      }
      AppMethodBeat.o(259802);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djt
 * JD-Core Version:    0.7.0.1
 */