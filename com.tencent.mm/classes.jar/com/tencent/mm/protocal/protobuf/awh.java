package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class awh
  extends com.tencent.mm.bw.a
{
  public String LBC;
  public String iAR;
  public String nickname;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209528);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.e(2, this.nickname);
      }
      if (this.iAR != null) {
        paramVarArgs.e(3, this.iAR);
      }
      if (this.LBC != null) {
        paramVarArgs.e(4, this.LBC);
      }
      AppMethodBeat.o(209528);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.f(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.nickname);
      }
      i = paramInt;
      if (this.iAR != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.iAR);
      }
      paramInt = i;
      if (this.LBC != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LBC);
      }
      AppMethodBeat.o(209528);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209528);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        awh localawh = (awh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209528);
          return -1;
        case 1: 
          localawh.username = locala.UbS.readString();
          AppMethodBeat.o(209528);
          return 0;
        case 2: 
          localawh.nickname = locala.UbS.readString();
          AppMethodBeat.o(209528);
          return 0;
        case 3: 
          localawh.iAR = locala.UbS.readString();
          AppMethodBeat.o(209528);
          return 0;
        }
        localawh.LBC = locala.UbS.readString();
        AppMethodBeat.o(209528);
        return 0;
      }
      AppMethodBeat.o(209528);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awh
 * JD-Core Version:    0.7.0.1
 */