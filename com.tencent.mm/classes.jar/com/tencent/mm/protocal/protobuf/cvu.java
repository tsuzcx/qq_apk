package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cvu
  extends com.tencent.mm.bw.a
{
  public String nickName;
  public int status;
  public String userName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152636);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.userName != null) {
        paramVarArgs.e(1, this.userName);
      }
      paramVarArgs.aM(2, this.status);
      if (this.nickName != null) {
        paramVarArgs.e(3, this.nickName);
      }
      AppMethodBeat.o(152636);
      return 0;
    }
    if (paramInt == 1) {
      if (this.userName == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.f(1, this.userName) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.status);
      paramInt = i;
      if (this.nickName != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.nickName);
      }
      AppMethodBeat.o(152636);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152636);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cvu localcvu = (cvu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152636);
          return -1;
        case 1: 
          localcvu.userName = locala.UbS.readString();
          AppMethodBeat.o(152636);
          return 0;
        case 2: 
          localcvu.status = locala.UbS.zi();
          AppMethodBeat.o(152636);
          return 0;
        }
        localcvu.nickName = locala.UbS.readString();
        AppMethodBeat.o(152636);
        return 0;
      }
      AppMethodBeat.o(152636);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvu
 * JD-Core Version:    0.7.0.1
 */