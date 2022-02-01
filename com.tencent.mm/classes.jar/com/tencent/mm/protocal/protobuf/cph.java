package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cph
  extends com.tencent.mm.bw.a
{
  public String KGO;
  public String Liq;
  public String UserName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101825);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KGO != null) {
        paramVarArgs.e(1, this.KGO);
      }
      if (this.UserName != null) {
        paramVarArgs.e(2, this.UserName);
      }
      if (this.Liq != null) {
        paramVarArgs.e(3, this.Liq);
      }
      AppMethodBeat.o(101825);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KGO == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.f(1, this.KGO) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.UserName);
      }
      i = paramInt;
      if (this.Liq != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Liq);
      }
      AppMethodBeat.o(101825);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(101825);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cph localcph = (cph)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(101825);
          return -1;
        case 1: 
          localcph.KGO = locala.UbS.readString();
          AppMethodBeat.o(101825);
          return 0;
        case 2: 
          localcph.UserName = locala.UbS.readString();
          AppMethodBeat.o(101825);
          return 0;
        }
        localcph.Liq = locala.UbS.readString();
        AppMethodBeat.o(101825);
        return 0;
      }
      AppMethodBeat.o(101825);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cph
 * JD-Core Version:    0.7.0.1
 */