package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class asw
  extends com.tencent.mm.bx.a
{
  public int ZiB;
  public String Ziv;
  public int vhk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127494);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Ziv != null) {
        paramVarArgs.g(1, this.Ziv);
      }
      paramVarArgs.bS(2, this.ZiB);
      paramVarArgs.bS(3, this.vhk);
      AppMethodBeat.o(127494);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ziv == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = i.a.a.b.b.a.h(1, this.Ziv) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.ZiB);
      int j = i.a.a.b.b.a.cJ(3, this.vhk);
      AppMethodBeat.o(127494);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(127494);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        asw localasw = (asw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127494);
          return -1;
        case 1: 
          localasw.Ziv = locala.ajGk.readString();
          AppMethodBeat.o(127494);
          return 0;
        case 2: 
          localasw.ZiB = locala.ajGk.aar();
          AppMethodBeat.o(127494);
          return 0;
        }
        localasw.vhk = locala.ajGk.aar();
        AppMethodBeat.o(127494);
        return 0;
      }
      AppMethodBeat.o(127494);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asw
 * JD-Core Version:    0.7.0.1
 */