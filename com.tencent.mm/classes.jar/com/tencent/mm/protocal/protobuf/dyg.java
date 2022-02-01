package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dyg
  extends com.tencent.mm.bw.a
{
  public int KSa;
  public int MjZ;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153304);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      paramVarArgs.aM(2, this.MjZ);
      paramVarArgs.aM(3, this.KSa);
      AppMethodBeat.o(153304);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = g.a.a.b.b.a.f(1, this.username) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.MjZ);
      int j = g.a.a.b.b.a.bu(3, this.KSa);
      AppMethodBeat.o(153304);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(153304);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dyg localdyg = (dyg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153304);
          return -1;
        case 1: 
          localdyg.username = locala.UbS.readString();
          AppMethodBeat.o(153304);
          return 0;
        case 2: 
          localdyg.MjZ = locala.UbS.zi();
          AppMethodBeat.o(153304);
          return 0;
        }
        localdyg.KSa = locala.UbS.zi();
        AppMethodBeat.o(153304);
        return 0;
      }
      AppMethodBeat.o(153304);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyg
 * JD-Core Version:    0.7.0.1
 */