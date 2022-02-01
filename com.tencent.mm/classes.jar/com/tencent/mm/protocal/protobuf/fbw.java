package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fbw
  extends com.tencent.mm.bw.a
{
  public String Nickname;
  public String NxV;
  public int NxW;
  public String xJE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124574);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NxV != null) {
        paramVarArgs.e(1, this.NxV);
      }
      if (this.xJE != null) {
        paramVarArgs.e(2, this.xJE);
      }
      if (this.Nickname != null) {
        paramVarArgs.e(3, this.Nickname);
      }
      paramVarArgs.aM(4, this.NxW);
      AppMethodBeat.o(124574);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NxV == null) {
        break label378;
      }
    }
    label378:
    for (int i = g.a.a.b.b.a.f(1, this.NxV) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xJE != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.xJE);
      }
      i = paramInt;
      if (this.Nickname != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Nickname);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.NxW);
      AppMethodBeat.o(124574);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(124574);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fbw localfbw = (fbw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124574);
          return -1;
        case 1: 
          localfbw.NxV = locala.UbS.readString();
          AppMethodBeat.o(124574);
          return 0;
        case 2: 
          localfbw.xJE = locala.UbS.readString();
          AppMethodBeat.o(124574);
          return 0;
        case 3: 
          localfbw.Nickname = locala.UbS.readString();
          AppMethodBeat.o(124574);
          return 0;
        }
        localfbw.NxW = locala.UbS.zi();
        AppMethodBeat.o(124574);
        return 0;
      }
      AppMethodBeat.o(124574);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbw
 * JD-Core Version:    0.7.0.1
 */