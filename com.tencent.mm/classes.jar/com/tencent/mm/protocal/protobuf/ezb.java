package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ezb
  extends com.tencent.mm.cd.a
{
  public String UserName;
  public String UzG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32489);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.f(1, this.UserName);
      }
      if (this.UzG != null) {
        paramVarArgs.f(2, this.UzG);
      }
      AppMethodBeat.o(32489);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label282;
      }
    }
    label282:
    for (paramInt = g.a.a.b.b.a.g(1, this.UserName) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UzG != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.UzG);
      }
      AppMethodBeat.o(32489);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32489);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ezb localezb = (ezb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32489);
          return -1;
        case 1: 
          localezb.UserName = locala.abFh.readString();
          AppMethodBeat.o(32489);
          return 0;
        }
        localezb.UzG = locala.abFh.readString();
        AppMethodBeat.o(32489);
        return 0;
      }
      AppMethodBeat.o(32489);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezb
 * JD-Core Version:    0.7.0.1
 */