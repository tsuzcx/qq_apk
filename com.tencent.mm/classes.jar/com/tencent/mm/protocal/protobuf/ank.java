package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ank
  extends com.tencent.mm.cd.a
{
  public String SxE;
  public String appId;
  public int fES;
  public String fXg;
  public String fve;
  public String iconUrl;
  public int nYp;
  public int otE;
  public int subType;
  public int type;
  public String username;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127455);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.f(1, this.username);
      }
      if (this.appId != null) {
        paramVarArgs.f(2, this.appId);
      }
      paramVarArgs.aY(3, this.fES);
      if (this.iconUrl != null) {
        paramVarArgs.f(4, this.iconUrl);
      }
      paramVarArgs.aY(5, this.type);
      if (this.fve != null) {
        paramVarArgs.f(6, this.fve);
      }
      if (this.SxE != null) {
        paramVarArgs.f(7, this.SxE);
      }
      paramVarArgs.aY(8, this.version);
      paramVarArgs.aY(9, this.otE);
      paramVarArgs.aY(10, this.nYp);
      if (this.fXg != null) {
        paramVarArgs.f(11, this.fXg);
      }
      paramVarArgs.aY(12, this.subType);
      AppMethodBeat.o(127455);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label790;
      }
    }
    label790:
    for (paramInt = g.a.a.b.b.a.g(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.appId != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.appId);
      }
      i += g.a.a.b.b.a.bM(3, this.fES);
      paramInt = i;
      if (this.iconUrl != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.iconUrl);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.type);
      paramInt = i;
      if (this.fve != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.fve);
      }
      i = paramInt;
      if (this.SxE != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.SxE);
      }
      i = i + g.a.a.b.b.a.bM(8, this.version) + g.a.a.b.b.a.bM(9, this.otE) + g.a.a.b.b.a.bM(10, this.nYp);
      paramInt = i;
      if (this.fXg != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.fXg);
      }
      i = g.a.a.b.b.a.bM(12, this.subType);
      AppMethodBeat.o(127455);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(127455);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ank localank = (ank)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127455);
          return -1;
        case 1: 
          localank.username = locala.abFh.readString();
          AppMethodBeat.o(127455);
          return 0;
        case 2: 
          localank.appId = locala.abFh.readString();
          AppMethodBeat.o(127455);
          return 0;
        case 3: 
          localank.fES = locala.abFh.AK();
          AppMethodBeat.o(127455);
          return 0;
        case 4: 
          localank.iconUrl = locala.abFh.readString();
          AppMethodBeat.o(127455);
          return 0;
        case 5: 
          localank.type = locala.abFh.AK();
          AppMethodBeat.o(127455);
          return 0;
        case 6: 
          localank.fve = locala.abFh.readString();
          AppMethodBeat.o(127455);
          return 0;
        case 7: 
          localank.SxE = locala.abFh.readString();
          AppMethodBeat.o(127455);
          return 0;
        case 8: 
          localank.version = locala.abFh.AK();
          AppMethodBeat.o(127455);
          return 0;
        case 9: 
          localank.otE = locala.abFh.AK();
          AppMethodBeat.o(127455);
          return 0;
        case 10: 
          localank.nYp = locala.abFh.AK();
          AppMethodBeat.o(127455);
          return 0;
        case 11: 
          localank.fXg = locala.abFh.readString();
          AppMethodBeat.o(127455);
          return 0;
        }
        localank.subType = locala.abFh.AK();
        AppMethodBeat.o(127455);
        return 0;
      }
      AppMethodBeat.o(127455);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ank
 * JD-Core Version:    0.7.0.1
 */