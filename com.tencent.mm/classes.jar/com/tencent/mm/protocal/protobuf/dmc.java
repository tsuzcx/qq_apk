package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class dmc
  extends com.tencent.mm.bx.a
{
  public long axI;
  public String path;
  public long start;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258997);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.path == null)
      {
        paramVarArgs = new b("Not all required fields were included: path");
        AppMethodBeat.o(258997);
        throw paramVarArgs;
      }
      if (this.path != null) {
        paramVarArgs.g(1, this.path);
      }
      paramVarArgs.bv(2, this.start);
      paramVarArgs.bv(3, this.axI);
      AppMethodBeat.o(258997);
      return 0;
    }
    if (paramInt == 1) {
      if (this.path == null) {
        break label350;
      }
    }
    label350:
    for (paramInt = i.a.a.b.b.a.h(1, this.path) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.q(2, this.start);
      int j = i.a.a.b.b.a.q(3, this.axI);
      AppMethodBeat.o(258997);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.path == null)
        {
          paramVarArgs = new b("Not all required fields were included: path");
          AppMethodBeat.o(258997);
          throw paramVarArgs;
        }
        AppMethodBeat.o(258997);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dmc localdmc = (dmc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258997);
          return -1;
        case 1: 
          localdmc.path = locala.ajGk.readString();
          AppMethodBeat.o(258997);
          return 0;
        case 2: 
          localdmc.start = locala.ajGk.aaw();
          AppMethodBeat.o(258997);
          return 0;
        }
        localdmc.axI = locala.ajGk.aaw();
        AppMethodBeat.o(258997);
        return 0;
      }
      AppMethodBeat.o(258997);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmc
 * JD-Core Version:    0.7.0.1
 */