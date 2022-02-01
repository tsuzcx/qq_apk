package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class apg
  extends com.tencent.mm.bx.a
{
  public int Zwh;
  public String Zwi;
  public String Zwj;
  public String Zwk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32200);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Zwh);
      if (this.Zwi != null) {
        paramVarArgs.g(2, this.Zwi);
      }
      if (this.Zwk != null) {
        paramVarArgs.g(3, this.Zwk);
      }
      if (this.Zwj != null) {
        paramVarArgs.g(4, this.Zwj);
      }
      AppMethodBeat.o(32200);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.Zwh) + 0;
      paramInt = i;
      if (this.Zwi != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Zwi);
      }
      i = paramInt;
      if (this.Zwk != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Zwk);
      }
      paramInt = i;
      if (this.Zwj != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Zwj);
      }
      AppMethodBeat.o(32200);
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
      AppMethodBeat.o(32200);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      apg localapg = (apg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32200);
        return -1;
      case 1: 
        localapg.Zwh = locala.ajGk.aar();
        AppMethodBeat.o(32200);
        return 0;
      case 2: 
        localapg.Zwi = locala.ajGk.readString();
        AppMethodBeat.o(32200);
        return 0;
      case 3: 
        localapg.Zwk = locala.ajGk.readString();
        AppMethodBeat.o(32200);
        return 0;
      }
      localapg.Zwj = locala.ajGk.readString();
      AppMethodBeat.o(32200);
      return 0;
    }
    AppMethodBeat.o(32200);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apg
 * JD-Core Version:    0.7.0.1
 */