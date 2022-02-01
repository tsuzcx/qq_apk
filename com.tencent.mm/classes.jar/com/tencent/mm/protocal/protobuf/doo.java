package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class doo
  extends com.tencent.mm.bw.a
{
  public int KXC;
  public String MbW;
  public int MbZ;
  public String dNI;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(175247);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dNI != null) {
        paramVarArgs.e(1, this.dNI);
      }
      if (this.username != null) {
        paramVarArgs.e(2, this.username);
      }
      if (this.MbW != null) {
        paramVarArgs.e(3, this.MbW);
      }
      paramVarArgs.aM(4, this.MbZ);
      paramVarArgs.aM(5, this.KXC);
      AppMethodBeat.o(175247);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dNI == null) {
        break label426;
      }
    }
    label426:
    for (int i = g.a.a.b.b.a.f(1, this.dNI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.username);
      }
      i = paramInt;
      if (this.MbW != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MbW);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.MbZ);
      int j = g.a.a.b.b.a.bu(5, this.KXC);
      AppMethodBeat.o(175247);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(175247);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        doo localdoo = (doo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(175247);
          return -1;
        case 1: 
          localdoo.dNI = locala.UbS.readString();
          AppMethodBeat.o(175247);
          return 0;
        case 2: 
          localdoo.username = locala.UbS.readString();
          AppMethodBeat.o(175247);
          return 0;
        case 3: 
          localdoo.MbW = locala.UbS.readString();
          AppMethodBeat.o(175247);
          return 0;
        case 4: 
          localdoo.MbZ = locala.UbS.zi();
          AppMethodBeat.o(175247);
          return 0;
        }
        localdoo.KXC = locala.UbS.zi();
        AppMethodBeat.o(175247);
        return 0;
      }
      AppMethodBeat.o(175247);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.doo
 * JD-Core Version:    0.7.0.1
 */