package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class iu
  extends com.tencent.mm.bx.a
{
  public String data;
  public int hGE;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153261);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.g(1, this.username);
      }
      if (this.data != null) {
        paramVarArgs.g(2, this.data);
      }
      paramVarArgs.bS(3, this.hGE);
      AppMethodBeat.o(153261);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = i.a.a.b.b.a.h(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.data != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.data);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.hGE);
      AppMethodBeat.o(153261);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(153261);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        iu localiu = (iu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153261);
          return -1;
        case 1: 
          localiu.username = locala.ajGk.readString();
          AppMethodBeat.o(153261);
          return 0;
        case 2: 
          localiu.data = locala.ajGk.readString();
          AppMethodBeat.o(153261);
          return 0;
        }
        localiu.hGE = locala.ajGk.aar();
        AppMethodBeat.o(153261);
        return 0;
      }
      AppMethodBeat.o(153261);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.iu
 * JD-Core Version:    0.7.0.1
 */