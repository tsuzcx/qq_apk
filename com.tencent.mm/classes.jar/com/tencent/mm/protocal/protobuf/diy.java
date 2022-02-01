package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class diy
  extends com.tencent.mm.bw.a
{
  public String LRO;
  public String LuX;
  public String UserName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127291);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.e(1, this.UserName);
      }
      if (this.LRO != null) {
        paramVarArgs.e(2, this.LRO);
      }
      if (this.LuX != null) {
        paramVarArgs.e(3, this.LuX);
      }
      AppMethodBeat.o(127291);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.f(1, this.UserName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LRO != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LRO);
      }
      i = paramInt;
      if (this.LuX != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LuX);
      }
      AppMethodBeat.o(127291);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(127291);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        diy localdiy = (diy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127291);
          return -1;
        case 1: 
          localdiy.UserName = locala.UbS.readString();
          AppMethodBeat.o(127291);
          return 0;
        case 2: 
          localdiy.LRO = locala.UbS.readString();
          AppMethodBeat.o(127291);
          return 0;
        }
        localdiy.LuX = locala.UbS.readString();
        AppMethodBeat.o(127291);
        return 0;
      }
      AppMethodBeat.o(127291);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.diy
 * JD-Core Version:    0.7.0.1
 */