package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class czd
  extends com.tencent.mm.bv.a
{
  public String Nickname;
  public String nqE;
  public String ygd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11824);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ygd != null) {
        paramVarArgs.e(1, this.ygd);
      }
      if (this.nqE != null) {
        paramVarArgs.e(2, this.nqE);
      }
      if (this.Nickname != null) {
        paramVarArgs.e(3, this.Nickname);
      }
      AppMethodBeat.o(11824);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ygd == null) {
        break label343;
      }
    }
    label343:
    for (int i = e.a.a.b.b.a.f(1, this.ygd) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nqE != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.nqE);
      }
      i = paramInt;
      if (this.Nickname != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.Nickname);
      }
      AppMethodBeat.o(11824);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(11824);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        czd localczd = (czd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(11824);
          return -1;
        case 1: 
          localczd.ygd = locala.CLY.readString();
          AppMethodBeat.o(11824);
          return 0;
        case 2: 
          localczd.nqE = locala.CLY.readString();
          AppMethodBeat.o(11824);
          return 0;
        }
        localczd.Nickname = locala.CLY.readString();
        AppMethodBeat.o(11824);
        return 0;
      }
      AppMethodBeat.o(11824);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czd
 * JD-Core Version:    0.7.0.1
 */