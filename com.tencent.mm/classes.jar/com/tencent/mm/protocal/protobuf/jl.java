package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class jl
  extends com.tencent.mm.bx.a
{
  public String JFk;
  public String MEp;
  public String YLE;
  public String hAk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91356);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YLE != null) {
        paramVarArgs.g(1, this.YLE);
      }
      if (this.hAk != null) {
        paramVarArgs.g(2, this.hAk);
      }
      if (this.JFk != null) {
        paramVarArgs.g(3, this.JFk);
      }
      if (this.MEp != null) {
        paramVarArgs.g(4, this.MEp);
      }
      AppMethodBeat.o(91356);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YLE == null) {
        break label390;
      }
    }
    label390:
    for (int i = i.a.a.b.b.a.h(1, this.YLE) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hAk != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.hAk);
      }
      i = paramInt;
      if (this.JFk != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.JFk);
      }
      paramInt = i;
      if (this.MEp != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.MEp);
      }
      AppMethodBeat.o(91356);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91356);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        jl localjl = (jl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91356);
          return -1;
        case 1: 
          localjl.YLE = locala.ajGk.readString();
          AppMethodBeat.o(91356);
          return 0;
        case 2: 
          localjl.hAk = locala.ajGk.readString();
          AppMethodBeat.o(91356);
          return 0;
        case 3: 
          localjl.JFk = locala.ajGk.readString();
          AppMethodBeat.o(91356);
          return 0;
        }
        localjl.MEp = locala.ajGk.readString();
        AppMethodBeat.o(91356);
        return 0;
      }
      AppMethodBeat.o(91356);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jl
 * JD-Core Version:    0.7.0.1
 */