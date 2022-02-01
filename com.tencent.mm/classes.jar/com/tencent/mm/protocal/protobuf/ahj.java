package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ahj
  extends com.tencent.mm.cd.a
{
  public String SrX;
  public int SrY;
  public String appid;
  public String nickname;
  public String path;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200118);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.f(1, this.appid);
      }
      if (this.path != null) {
        paramVarArgs.f(2, this.path);
      }
      if (this.SrX != null) {
        paramVarArgs.f(3, this.SrX);
      }
      if (this.nickname != null) {
        paramVarArgs.f(4, this.nickname);
      }
      if (this.username != null) {
        paramVarArgs.f(5, this.username);
      }
      paramVarArgs.aY(6, this.SrY);
      AppMethodBeat.o(200118);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label502;
      }
    }
    label502:
    for (int i = g.a.a.b.b.a.g(1, this.appid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.path != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.path);
      }
      i = paramInt;
      if (this.SrX != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SrX);
      }
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.nickname);
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.username);
      }
      paramInt = g.a.a.b.b.a.bM(6, this.SrY);
      AppMethodBeat.o(200118);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(200118);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ahj localahj = (ahj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(200118);
          return -1;
        case 1: 
          localahj.appid = locala.abFh.readString();
          AppMethodBeat.o(200118);
          return 0;
        case 2: 
          localahj.path = locala.abFh.readString();
          AppMethodBeat.o(200118);
          return 0;
        case 3: 
          localahj.SrX = locala.abFh.readString();
          AppMethodBeat.o(200118);
          return 0;
        case 4: 
          localahj.nickname = locala.abFh.readString();
          AppMethodBeat.o(200118);
          return 0;
        case 5: 
          localahj.username = locala.abFh.readString();
          AppMethodBeat.o(200118);
          return 0;
        }
        localahj.SrY = locala.abFh.AK();
        AppMethodBeat.o(200118);
        return 0;
      }
      AppMethodBeat.o(200118);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahj
 * JD-Core Version:    0.7.0.1
 */