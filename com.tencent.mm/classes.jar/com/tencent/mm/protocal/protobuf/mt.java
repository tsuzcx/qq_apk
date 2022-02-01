package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mt
  extends com.tencent.mm.bw.a
{
  public String KRa;
  public String path;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212226);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      if (this.path != null) {
        paramVarArgs.e(2, this.path);
      }
      if (this.KRa != null) {
        paramVarArgs.e(3, this.KRa);
      }
      AppMethodBeat.o(212226);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.f(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.path != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.path);
      }
      i = paramInt;
      if (this.KRa != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KRa);
      }
      AppMethodBeat.o(212226);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(212226);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        mt localmt = (mt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(212226);
          return -1;
        case 1: 
          localmt.username = locala.UbS.readString();
          AppMethodBeat.o(212226);
          return 0;
        case 2: 
          localmt.path = locala.UbS.readString();
          AppMethodBeat.o(212226);
          return 0;
        }
        localmt.KRa = locala.UbS.readString();
        AppMethodBeat.o(212226);
        return 0;
      }
      AppMethodBeat.o(212226);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mt
 * JD-Core Version:    0.7.0.1
 */