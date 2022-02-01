package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gjj
  extends com.tencent.mm.bx.a
{
  public String IHW;
  public String Nickname;
  public String acfC;
  public int acfD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124574);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.acfC != null) {
        paramVarArgs.g(1, this.acfC);
      }
      if (this.IHW != null) {
        paramVarArgs.g(2, this.IHW);
      }
      if (this.Nickname != null) {
        paramVarArgs.g(3, this.Nickname);
      }
      paramVarArgs.bS(4, this.acfD);
      AppMethodBeat.o(124574);
      return 0;
    }
    if (paramInt == 1) {
      if (this.acfC == null) {
        break label374;
      }
    }
    label374:
    for (int i = i.a.a.b.b.a.h(1, this.acfC) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IHW != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IHW);
      }
      i = paramInt;
      if (this.Nickname != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Nickname);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.acfD);
      AppMethodBeat.o(124574);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(124574);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gjj localgjj = (gjj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124574);
          return -1;
        case 1: 
          localgjj.acfC = locala.ajGk.readString();
          AppMethodBeat.o(124574);
          return 0;
        case 2: 
          localgjj.IHW = locala.ajGk.readString();
          AppMethodBeat.o(124574);
          return 0;
        case 3: 
          localgjj.Nickname = locala.ajGk.readString();
          AppMethodBeat.o(124574);
          return 0;
        }
        localgjj.acfD = locala.ajGk.aar();
        AppMethodBeat.o(124574);
        return 0;
      }
      AppMethodBeat.o(124574);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gjj
 * JD-Core Version:    0.7.0.1
 */