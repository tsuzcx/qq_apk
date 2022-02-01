package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dyi
  extends com.tencent.mm.cd.a
{
  public int RYL;
  public int TnG;
  public String TnI;
  public String appid;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(175247);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.f(1, this.appid);
      }
      if (this.username != null) {
        paramVarArgs.f(2, this.username);
      }
      if (this.TnI != null) {
        paramVarArgs.f(3, this.TnI);
      }
      paramVarArgs.aY(4, this.TnG);
      paramVarArgs.aY(5, this.RYL);
      AppMethodBeat.o(175247);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label426;
      }
    }
    label426:
    for (int i = g.a.a.b.b.a.g(1, this.appid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.username);
      }
      i = paramInt;
      if (this.TnI != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TnI);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.TnG);
      int j = g.a.a.b.b.a.bM(5, this.RYL);
      AppMethodBeat.o(175247);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(175247);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dyi localdyi = (dyi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(175247);
          return -1;
        case 1: 
          localdyi.appid = locala.abFh.readString();
          AppMethodBeat.o(175247);
          return 0;
        case 2: 
          localdyi.username = locala.abFh.readString();
          AppMethodBeat.o(175247);
          return 0;
        case 3: 
          localdyi.TnI = locala.abFh.readString();
          AppMethodBeat.o(175247);
          return 0;
        case 4: 
          localdyi.TnG = locala.abFh.AK();
          AppMethodBeat.o(175247);
          return 0;
        }
        localdyi.RYL = locala.abFh.AK();
        AppMethodBeat.o(175247);
        return 0;
      }
      AppMethodBeat.o(175247);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyi
 * JD-Core Version:    0.7.0.1
 */