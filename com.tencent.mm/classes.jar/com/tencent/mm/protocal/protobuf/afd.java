package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class afd
  extends com.tencent.mm.bx.a
{
  public long Znx;
  public int label;
  public String path;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259931);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.path == null)
      {
        paramVarArgs = new b("Not all required fields were included: path");
        AppMethodBeat.o(259931);
        throw paramVarArgs;
      }
      if (this.path != null) {
        paramVarArgs.g(1, this.path);
      }
      paramVarArgs.bS(2, this.label);
      paramVarArgs.bv(3, this.Znx);
      AppMethodBeat.o(259931);
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
      int i = i.a.a.b.b.a.cJ(2, this.label);
      int j = i.a.a.b.b.a.q(3, this.Znx);
      AppMethodBeat.o(259931);
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
          AppMethodBeat.o(259931);
          throw paramVarArgs;
        }
        AppMethodBeat.o(259931);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        afd localafd = (afd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259931);
          return -1;
        case 1: 
          localafd.path = locala.ajGk.readString();
          AppMethodBeat.o(259931);
          return 0;
        case 2: 
          localafd.label = locala.ajGk.aar();
          AppMethodBeat.o(259931);
          return 0;
        }
        localafd.Znx = locala.ajGk.aaw();
        AppMethodBeat.o(259931);
        return 0;
      }
      AppMethodBeat.o(259931);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afd
 * JD-Core Version:    0.7.0.1
 */