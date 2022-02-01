package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ard
  extends com.tencent.mm.bx.a
{
  public String Zyw;
  public String appId;
  public int hJK;
  public String hzy;
  public String iconUrl;
  public String idf;
  public int nOX;
  public int rbZ;
  public int rxs;
  public int subType;
  public int type;
  public String username;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127455);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.g(1, this.username);
      }
      if (this.appId != null) {
        paramVarArgs.g(2, this.appId);
      }
      paramVarArgs.bS(3, this.hJK);
      if (this.iconUrl != null) {
        paramVarArgs.g(4, this.iconUrl);
      }
      paramVarArgs.bS(5, this.type);
      if (this.hzy != null) {
        paramVarArgs.g(6, this.hzy);
      }
      if (this.Zyw != null) {
        paramVarArgs.g(7, this.Zyw);
      }
      paramVarArgs.bS(8, this.version);
      paramVarArgs.bS(9, this.rxs);
      paramVarArgs.bS(10, this.rbZ);
      if (this.idf != null) {
        paramVarArgs.g(11, this.idf);
      }
      paramVarArgs.bS(12, this.subType);
      paramVarArgs.bS(13, this.nOX);
      AppMethodBeat.o(127455);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label834;
      }
    }
    label834:
    for (paramInt = i.a.a.b.b.a.h(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.appId != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.appId);
      }
      i += i.a.a.b.b.a.cJ(3, this.hJK);
      paramInt = i;
      if (this.iconUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.iconUrl);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.type);
      paramInt = i;
      if (this.hzy != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.hzy);
      }
      i = paramInt;
      if (this.Zyw != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.Zyw);
      }
      i = i + i.a.a.b.b.a.cJ(8, this.version) + i.a.a.b.b.a.cJ(9, this.rxs) + i.a.a.b.b.a.cJ(10, this.rbZ);
      paramInt = i;
      if (this.idf != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.idf);
      }
      i = i.a.a.b.b.a.cJ(12, this.subType);
      int j = i.a.a.b.b.a.cJ(13, this.nOX);
      AppMethodBeat.o(127455);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(127455);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ard localard = (ard)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127455);
          return -1;
        case 1: 
          localard.username = locala.ajGk.readString();
          AppMethodBeat.o(127455);
          return 0;
        case 2: 
          localard.appId = locala.ajGk.readString();
          AppMethodBeat.o(127455);
          return 0;
        case 3: 
          localard.hJK = locala.ajGk.aar();
          AppMethodBeat.o(127455);
          return 0;
        case 4: 
          localard.iconUrl = locala.ajGk.readString();
          AppMethodBeat.o(127455);
          return 0;
        case 5: 
          localard.type = locala.ajGk.aar();
          AppMethodBeat.o(127455);
          return 0;
        case 6: 
          localard.hzy = locala.ajGk.readString();
          AppMethodBeat.o(127455);
          return 0;
        case 7: 
          localard.Zyw = locala.ajGk.readString();
          AppMethodBeat.o(127455);
          return 0;
        case 8: 
          localard.version = locala.ajGk.aar();
          AppMethodBeat.o(127455);
          return 0;
        case 9: 
          localard.rxs = locala.ajGk.aar();
          AppMethodBeat.o(127455);
          return 0;
        case 10: 
          localard.rbZ = locala.ajGk.aar();
          AppMethodBeat.o(127455);
          return 0;
        case 11: 
          localard.idf = locala.ajGk.readString();
          AppMethodBeat.o(127455);
          return 0;
        case 12: 
          localard.subType = locala.ajGk.aar();
          AppMethodBeat.o(127455);
          return 0;
        }
        localard.nOX = locala.ajGk.aar();
        AppMethodBeat.o(127455);
        return 0;
      }
      AppMethodBeat.o(127455);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ard
 * JD-Core Version:    0.7.0.1
 */