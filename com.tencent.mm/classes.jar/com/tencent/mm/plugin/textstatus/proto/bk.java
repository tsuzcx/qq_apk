package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bk
  extends com.tencent.mm.bx.a
{
  public int HTK;
  public int show_type;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(289917);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.g(1, this.username);
      }
      paramVarArgs.bS(2, this.HTK);
      paramVarArgs.bS(3, this.show_type);
      AppMethodBeat.o(289917);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = i.a.a.b.b.a.h(1, this.username) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.HTK);
      int j = i.a.a.b.b.a.cJ(3, this.show_type);
      AppMethodBeat.o(289917);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(289917);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bk localbk = (bk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(289917);
          return -1;
        case 1: 
          localbk.username = locala.ajGk.readString();
          AppMethodBeat.o(289917);
          return 0;
        case 2: 
          localbk.HTK = locala.ajGk.aar();
          AppMethodBeat.o(289917);
          return 0;
        }
        localbk.show_type = locala.ajGk.aar();
        AppMethodBeat.o(289917);
        return 0;
      }
      AppMethodBeat.o(289917);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.bk
 * JD-Core Version:    0.7.0.1
 */