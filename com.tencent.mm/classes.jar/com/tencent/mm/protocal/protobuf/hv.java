package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hv
  extends com.tencent.mm.bx.a
{
  public String desc;
  public String scope;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257934);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.scope != null) {
        paramVarArgs.g(1, this.scope);
      }
      if (this.desc != null) {
        paramVarArgs.g(2, this.desc);
      }
      paramVarArgs.bS(3, this.state);
      AppMethodBeat.o(257934);
      return 0;
    }
    if (paramInt == 1) {
      if (this.scope == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = i.a.a.b.b.a.h(1, this.scope) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.desc != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.desc);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.state);
      AppMethodBeat.o(257934);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257934);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        hv localhv = (hv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257934);
          return -1;
        case 1: 
          localhv.scope = locala.ajGk.readString();
          AppMethodBeat.o(257934);
          return 0;
        case 2: 
          localhv.desc = locala.ajGk.readString();
          AppMethodBeat.o(257934);
          return 0;
        }
        localhv.state = locala.ajGk.aar();
        AppMethodBeat.o(257934);
        return 0;
      }
      AppMethodBeat.o(257934);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hv
 * JD-Core Version:    0.7.0.1
 */