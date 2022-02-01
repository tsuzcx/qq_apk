package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class axs
  extends com.tencent.mm.bw.a
{
  public long LHZ;
  public int LIa;
  public String gTs;
  public String nickname;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209572);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.e(2, this.nickname);
      }
      if (this.gTs != null) {
        paramVarArgs.e(3, this.gTs);
      }
      paramVarArgs.bb(4, this.LHZ);
      paramVarArgs.aM(5, this.LIa);
      AppMethodBeat.o(209572);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label426;
      }
    }
    label426:
    for (int i = g.a.a.b.b.a.f(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.nickname);
      }
      i = paramInt;
      if (this.gTs != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.gTs);
      }
      paramInt = g.a.a.b.b.a.r(4, this.LHZ);
      int j = g.a.a.b.b.a.bu(5, this.LIa);
      AppMethodBeat.o(209572);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209572);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        axs localaxs = (axs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209572);
          return -1;
        case 1: 
          localaxs.username = locala.UbS.readString();
          AppMethodBeat.o(209572);
          return 0;
        case 2: 
          localaxs.nickname = locala.UbS.readString();
          AppMethodBeat.o(209572);
          return 0;
        case 3: 
          localaxs.gTs = locala.UbS.readString();
          AppMethodBeat.o(209572);
          return 0;
        case 4: 
          localaxs.LHZ = locala.UbS.zl();
          AppMethodBeat.o(209572);
          return 0;
        }
        localaxs.LIa = locala.UbS.zi();
        AppMethodBeat.o(209572);
        return 0;
      }
      AppMethodBeat.o(209572);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axs
 * JD-Core Version:    0.7.0.1
 */