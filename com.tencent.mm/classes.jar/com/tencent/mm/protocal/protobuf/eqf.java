package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eqf
  extends com.tencent.mm.bw.a
{
  public String NnM;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32493);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      if (this.NnM != null) {
        paramVarArgs.e(2, this.NnM);
      }
      AppMethodBeat.o(32493);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label282;
      }
    }
    label282:
    for (paramInt = g.a.a.b.b.a.f(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.NnM != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.NnM);
      }
      AppMethodBeat.o(32493);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32493);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eqf localeqf = (eqf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32493);
          return -1;
        case 1: 
          localeqf.username = locala.UbS.readString();
          AppMethodBeat.o(32493);
          return 0;
        }
        localeqf.NnM = locala.UbS.readString();
        AppMethodBeat.o(32493);
        return 0;
      }
      AppMethodBeat.o(32493);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqf
 * JD-Core Version:    0.7.0.1
 */