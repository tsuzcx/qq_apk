package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class dus
  extends com.tencent.mm.cd.a
{
  public int CPw;
  public String RYJ;
  public String SessionId;
  public b TgS;
  public b TgT;
  public String UaY;
  public b UaZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104831);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RYJ != null) {
        paramVarArgs.f(1, this.RYJ);
      }
      if (this.UaY != null) {
        paramVarArgs.f(2, this.UaY);
      }
      if (this.SessionId != null) {
        paramVarArgs.f(3, this.SessionId);
      }
      if (this.TgT != null) {
        paramVarArgs.c(4, this.TgT);
      }
      if (this.TgS != null) {
        paramVarArgs.c(5, this.TgS);
      }
      paramVarArgs.aY(6, this.CPw);
      if (this.UaZ != null) {
        paramVarArgs.c(7, this.UaZ);
      }
      AppMethodBeat.o(104831);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RYJ == null) {
        break label562;
      }
    }
    label562:
    for (int i = g.a.a.b.b.a.g(1, this.RYJ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UaY != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UaY);
      }
      i = paramInt;
      if (this.SessionId != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SessionId);
      }
      paramInt = i;
      if (this.TgT != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.TgT);
      }
      i = paramInt;
      if (this.TgS != null) {
        i = paramInt + g.a.a.b.b.a.b(5, this.TgS);
      }
      i += g.a.a.b.b.a.bM(6, this.CPw);
      paramInt = i;
      if (this.UaZ != null) {
        paramInt = i + g.a.a.b.b.a.b(7, this.UaZ);
      }
      AppMethodBeat.o(104831);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(104831);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dus localdus = (dus)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104831);
          return -1;
        case 1: 
          localdus.RYJ = locala.abFh.readString();
          AppMethodBeat.o(104831);
          return 0;
        case 2: 
          localdus.UaY = locala.abFh.readString();
          AppMethodBeat.o(104831);
          return 0;
        case 3: 
          localdus.SessionId = locala.abFh.readString();
          AppMethodBeat.o(104831);
          return 0;
        case 4: 
          localdus.TgT = locala.abFh.iUw();
          AppMethodBeat.o(104831);
          return 0;
        case 5: 
          localdus.TgS = locala.abFh.iUw();
          AppMethodBeat.o(104831);
          return 0;
        case 6: 
          localdus.CPw = locala.abFh.AK();
          AppMethodBeat.o(104831);
          return 0;
        }
        localdus.UaZ = locala.abFh.iUw();
        AppMethodBeat.o(104831);
        return 0;
      }
      AppMethodBeat.o(104831);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dus
 * JD-Core Version:    0.7.0.1
 */