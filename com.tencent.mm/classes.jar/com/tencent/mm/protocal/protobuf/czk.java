package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class czk
  extends com.tencent.mm.bx.a
{
  public String OkP;
  public int type;
  public String url;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258917);
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
      AppMethodBeat.o(258917);
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
      AppMethodBeat.o(258917);
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
      AppMethodBeat.o(258917);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      czk localczk = (czk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258917);
        return -1;
      case 1: 
        localczk.type = locala.ajGk.aar();
        AppMethodBeat.o(258917);
        return 0;
      case 2: 
        localczk.url = locala.ajGk.readString();
        AppMethodBeat.o(258917);
        return 0;
      case 3: 
        localczk.username = locala.ajGk.readString();
        AppMethodBeat.o(258917);
        return 0;
      }
      localczk.OkP = locala.ajGk.readString();
      AppMethodBeat.o(258917);
      return 0;
    }
    AppMethodBeat.o(258917);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czk
 * JD-Core Version:    0.7.0.1
 */