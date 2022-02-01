package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class erm
  extends com.tencent.mm.bx.a
{
  public int Tqb;
  public String aazm;
  public int aazp;
  public String appid;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(175247);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.g(1, this.appid);
      }
      if (this.username != null) {
        paramVarArgs.g(2, this.username);
      }
      if (this.aazm != null) {
        paramVarArgs.g(3, this.aazm);
      }
      paramVarArgs.bS(4, this.aazp);
      paramVarArgs.bS(5, this.Tqb);
      AppMethodBeat.o(175247);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label422;
      }
    }
    label422:
    for (int i = i.a.a.b.b.a.h(1, this.appid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.username);
      }
      i = paramInt;
      if (this.aazm != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aazm);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.aazp);
      int j = i.a.a.b.b.a.cJ(5, this.Tqb);
      AppMethodBeat.o(175247);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(175247);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        erm localerm = (erm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(175247);
          return -1;
        case 1: 
          localerm.appid = locala.ajGk.readString();
          AppMethodBeat.o(175247);
          return 0;
        case 2: 
          localerm.username = locala.ajGk.readString();
          AppMethodBeat.o(175247);
          return 0;
        case 3: 
          localerm.aazm = locala.ajGk.readString();
          AppMethodBeat.o(175247);
          return 0;
        case 4: 
          localerm.aazp = locala.ajGk.aar();
          AppMethodBeat.o(175247);
          return 0;
        }
        localerm.Tqb = locala.ajGk.aar();
        AppMethodBeat.o(175247);
        return 0;
      }
      AppMethodBeat.o(175247);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.erm
 * JD-Core Version:    0.7.0.1
 */