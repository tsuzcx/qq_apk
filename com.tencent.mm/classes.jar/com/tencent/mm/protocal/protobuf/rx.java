package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class rx
  extends com.tencent.mm.cd.a
{
  public String EtG;
  public int RYL;
  public String SaZ;
  public String appid;
  public String nickname;
  public String username;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56244);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.f(1, this.username);
      }
      if (this.appid != null) {
        paramVarArgs.f(2, this.appid);
      }
      if (this.EtG != null) {
        paramVarArgs.f(3, this.EtG);
      }
      if (this.nickname != null) {
        paramVarArgs.f(4, this.nickname);
      }
      paramVarArgs.aY(5, this.RYL);
      if (this.SaZ != null) {
        paramVarArgs.f(6, this.SaZ);
      }
      paramVarArgs.aY(7, this.version);
      AppMethodBeat.o(56244);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label546;
      }
    }
    label546:
    for (int i = g.a.a.b.b.a.g(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.appid);
      }
      i = paramInt;
      if (this.EtG != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.EtG);
      }
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.nickname);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.RYL);
      paramInt = i;
      if (this.SaZ != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.SaZ);
      }
      i = g.a.a.b.b.a.bM(7, this.version);
      AppMethodBeat.o(56244);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(56244);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        rx localrx = (rx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56244);
          return -1;
        case 1: 
          localrx.username = locala.abFh.readString();
          AppMethodBeat.o(56244);
          return 0;
        case 2: 
          localrx.appid = locala.abFh.readString();
          AppMethodBeat.o(56244);
          return 0;
        case 3: 
          localrx.EtG = locala.abFh.readString();
          AppMethodBeat.o(56244);
          return 0;
        case 4: 
          localrx.nickname = locala.abFh.readString();
          AppMethodBeat.o(56244);
          return 0;
        case 5: 
          localrx.RYL = locala.abFh.AK();
          AppMethodBeat.o(56244);
          return 0;
        case 6: 
          localrx.SaZ = locala.abFh.readString();
          AppMethodBeat.o(56244);
          return 0;
        }
        localrx.version = locala.abFh.AK();
        AppMethodBeat.o(56244);
        return 0;
      }
      AppMethodBeat.o(56244);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rx
 * JD-Core Version:    0.7.0.1
 */