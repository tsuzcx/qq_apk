package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class er
  extends com.tencent.mm.bw.a
{
  public String appId;
  public int cyo;
  public int iOo;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(208700);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appId != null) {
        paramVarArgs.e(1, this.appId);
      }
      if (this.username != null) {
        paramVarArgs.e(2, this.username);
      }
      paramVarArgs.aM(3, this.iOo);
      paramVarArgs.aM(4, this.cyo);
      AppMethodBeat.o(208700);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appId == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = g.a.a.b.b.a.f(1, this.appId) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.username != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.username);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.iOo);
      int j = g.a.a.b.b.a.bu(4, this.cyo);
      AppMethodBeat.o(208700);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(208700);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        er localer = (er)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(208700);
          return -1;
        case 1: 
          localer.appId = locala.UbS.readString();
          AppMethodBeat.o(208700);
          return 0;
        case 2: 
          localer.username = locala.UbS.readString();
          AppMethodBeat.o(208700);
          return 0;
        case 3: 
          localer.iOo = locala.UbS.zi();
          AppMethodBeat.o(208700);
          return 0;
        }
        localer.cyo = locala.UbS.zi();
        AppMethodBeat.o(208700);
        return 0;
      }
      AppMethodBeat.o(208700);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.er
 * JD-Core Version:    0.7.0.1
 */