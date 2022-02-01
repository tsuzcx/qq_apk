package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gen
  extends com.tencent.mm.bx.a
{
  public String OkP;
  public int type;
  public String url;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259725);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      if (this.url != null) {
        paramVarArgs.g(2, this.url);
      }
      if (this.username != null) {
        paramVarArgs.g(3, this.username);
      }
      if (this.OkP != null) {
        paramVarArgs.g(4, this.OkP);
      }
      AppMethodBeat.o(259725);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.type) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.url);
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.username);
      }
      paramInt = i;
      if (this.OkP != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.OkP);
      }
      AppMethodBeat.o(259725);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259725);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      gen localgen = (gen)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259725);
        return -1;
      case 1: 
        localgen.type = locala.ajGk.aar();
        AppMethodBeat.o(259725);
        return 0;
      case 2: 
        localgen.url = locala.ajGk.readString();
        AppMethodBeat.o(259725);
        return 0;
      case 3: 
        localgen.username = locala.ajGk.readString();
        AppMethodBeat.o(259725);
        return 0;
      }
      localgen.OkP = locala.ajGk.readString();
      AppMethodBeat.o(259725);
      return 0;
    }
    AppMethodBeat.o(259725);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gen
 * JD-Core Version:    0.7.0.1
 */