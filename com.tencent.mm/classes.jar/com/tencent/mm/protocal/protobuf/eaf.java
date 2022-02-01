package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eaf
  extends com.tencent.mm.bx.a
{
  public int YGW;
  public int abfn;
  public String appid;
  public int position;
  public String request_id;
  public String tNS;
  public String tNT;
  public String tNX;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50096);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.g(1, this.username);
      }
      if (this.tNS != null) {
        paramVarArgs.g(2, this.tNS);
      }
      if (this.request_id != null) {
        paramVarArgs.g(3, this.request_id);
      }
      if (this.tNT != null) {
        paramVarArgs.g(4, this.tNT);
      }
      if (this.appid != null) {
        paramVarArgs.g(5, this.appid);
      }
      if (this.tNX != null) {
        paramVarArgs.g(6, this.tNX);
      }
      paramVarArgs.bS(7, this.position);
      paramVarArgs.bS(8, this.abfn);
      paramVarArgs.bS(9, this.YGW);
      AppMethodBeat.o(50096);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label654;
      }
    }
    label654:
    for (int i = i.a.a.b.b.a.h(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tNS != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.tNS);
      }
      i = paramInt;
      if (this.request_id != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.request_id);
      }
      paramInt = i;
      if (this.tNT != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.tNT);
      }
      i = paramInt;
      if (this.appid != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.appid);
      }
      paramInt = i;
      if (this.tNX != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.tNX);
      }
      i = i.a.a.b.b.a.cJ(7, this.position);
      int j = i.a.a.b.b.a.cJ(8, this.abfn);
      int k = i.a.a.b.b.a.cJ(9, this.YGW);
      AppMethodBeat.o(50096);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(50096);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        eaf localeaf = (eaf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50096);
          return -1;
        case 1: 
          localeaf.username = locala.ajGk.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 2: 
          localeaf.tNS = locala.ajGk.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 3: 
          localeaf.request_id = locala.ajGk.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 4: 
          localeaf.tNT = locala.ajGk.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 5: 
          localeaf.appid = locala.ajGk.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 6: 
          localeaf.tNX = locala.ajGk.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 7: 
          localeaf.position = locala.ajGk.aar();
          AppMethodBeat.o(50096);
          return 0;
        case 8: 
          localeaf.abfn = locala.ajGk.aar();
          AppMethodBeat.o(50096);
          return 0;
        }
        localeaf.YGW = locala.ajGk.aar();
        AppMethodBeat.o(50096);
        return 0;
      }
      AppMethodBeat.o(50096);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eaf
 * JD-Core Version:    0.7.0.1
 */