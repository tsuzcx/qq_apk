package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class bff
  extends com.tencent.mm.cd.a
{
  public int SPR;
  public int SPS;
  public b SPT;
  public String fcD;
  public String sessionId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(202947);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fcD != null) {
        paramVarArgs.f(1, this.fcD);
      }
      if (this.sessionId != null) {
        paramVarArgs.f(2, this.sessionId);
      }
      paramVarArgs.aY(3, this.SPR);
      paramVarArgs.aY(4, this.SPS);
      if (this.SPT != null) {
        paramVarArgs.c(5, this.SPT);
      }
      AppMethodBeat.o(202947);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fcD == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = g.a.a.b.b.a.g(1, this.fcD) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sessionId != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.sessionId);
      }
      i = i + g.a.a.b.b.a.bM(3, this.SPR) + g.a.a.b.b.a.bM(4, this.SPS);
      paramInt = i;
      if (this.SPT != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.SPT);
      }
      AppMethodBeat.o(202947);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(202947);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bff localbff = (bff)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(202947);
          return -1;
        case 1: 
          localbff.fcD = locala.abFh.readString();
          AppMethodBeat.o(202947);
          return 0;
        case 2: 
          localbff.sessionId = locala.abFh.readString();
          AppMethodBeat.o(202947);
          return 0;
        case 3: 
          localbff.SPR = locala.abFh.AK();
          AppMethodBeat.o(202947);
          return 0;
        case 4: 
          localbff.SPS = locala.abFh.AK();
          AppMethodBeat.o(202947);
          return 0;
        }
        localbff.SPT = locala.abFh.iUw();
        AppMethodBeat.o(202947);
        return 0;
      }
      AppMethodBeat.o(202947);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bff
 * JD-Core Version:    0.7.0.1
 */