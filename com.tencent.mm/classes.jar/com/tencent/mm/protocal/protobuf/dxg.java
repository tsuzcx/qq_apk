package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dxg
  extends com.tencent.mm.bx.a
{
  public String nickName;
  public int status;
  public String userName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152636);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.userName != null) {
        paramVarArgs.g(1, this.userName);
      }
      paramVarArgs.bS(2, this.status);
      if (this.nickName != null) {
        paramVarArgs.g(3, this.nickName);
      }
      AppMethodBeat.o(152636);
      return 0;
    }
    if (paramInt == 1) {
      if (this.userName == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = i.a.a.b.b.a.h(1, this.userName) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.status);
      paramInt = i;
      if (this.nickName != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.nickName);
      }
      AppMethodBeat.o(152636);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152636);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dxg localdxg = (dxg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152636);
          return -1;
        case 1: 
          localdxg.userName = locala.ajGk.readString();
          AppMethodBeat.o(152636);
          return 0;
        case 2: 
          localdxg.status = locala.ajGk.aar();
          AppMethodBeat.o(152636);
          return 0;
        }
        localdxg.nickName = locala.ajGk.readString();
        AppMethodBeat.o(152636);
        return 0;
      }
      AppMethodBeat.o(152636);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxg
 * JD-Core Version:    0.7.0.1
 */