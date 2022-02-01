package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dxh
  extends com.tencent.mm.bx.a
{
  public String Zqf;
  public String Zqg;
  public int abdm;
  public String abdn;
  public String abdo;
  public String appId;
  public String displayName;
  public String nickName;
  public String userName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152637);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.userName != null) {
        paramVarArgs.g(1, this.userName);
      }
      if (this.nickName != null) {
        paramVarArgs.g(2, this.nickName);
      }
      if (this.displayName != null) {
        paramVarArgs.g(3, this.displayName);
      }
      if (this.Zqf != null) {
        paramVarArgs.g(4, this.Zqf);
      }
      if (this.Zqg != null) {
        paramVarArgs.g(5, this.Zqg);
      }
      paramVarArgs.bS(6, this.abdm);
      if (this.appId != null) {
        paramVarArgs.g(7, this.appId);
      }
      if (this.abdn != null) {
        paramVarArgs.g(8, this.abdn);
      }
      if (this.abdo != null) {
        paramVarArgs.g(9, this.abdo);
      }
      AppMethodBeat.o(152637);
      return 0;
    }
    if (paramInt == 1) {
      if (this.userName == null) {
        break label682;
      }
    }
    label682:
    for (int i = i.a.a.b.b.a.h(1, this.userName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickName != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.nickName);
      }
      i = paramInt;
      if (this.displayName != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.displayName);
      }
      paramInt = i;
      if (this.Zqf != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Zqf);
      }
      i = paramInt;
      if (this.Zqg != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.Zqg);
      }
      i += i.a.a.b.b.a.cJ(6, this.abdm);
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.appId);
      }
      i = paramInt;
      if (this.abdn != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.abdn);
      }
      paramInt = i;
      if (this.abdo != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.abdo);
      }
      AppMethodBeat.o(152637);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152637);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dxh localdxh = (dxh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152637);
          return -1;
        case 1: 
          localdxh.userName = locala.ajGk.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 2: 
          localdxh.nickName = locala.ajGk.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 3: 
          localdxh.displayName = locala.ajGk.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 4: 
          localdxh.Zqf = locala.ajGk.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 5: 
          localdxh.Zqg = locala.ajGk.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 6: 
          localdxh.abdm = locala.ajGk.aar();
          AppMethodBeat.o(152637);
          return 0;
        case 7: 
          localdxh.appId = locala.ajGk.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 8: 
          localdxh.abdn = locala.ajGk.readString();
          AppMethodBeat.o(152637);
          return 0;
        }
        localdxh.abdo = locala.ajGk.readString();
        AppMethodBeat.o(152637);
        return 0;
      }
      AppMethodBeat.o(152637);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxh
 * JD-Core Version:    0.7.0.1
 */