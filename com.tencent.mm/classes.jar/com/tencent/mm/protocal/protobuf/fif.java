package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class fif
  extends com.tencent.mm.bx.a
{
  public int Rqx;
  public String SlC;
  public int SlD;
  public int Slv;
  public int abJb;
  public int abJc;
  public String clientId;
  public String content;
  public int createTime;
  public String hQQ;
  public long idH;
  public int retryCount;
  public String sessionId;
  public int state;
  public String toUser;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118533);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hQQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: fromUser");
        AppMethodBeat.o(118533);
        throw paramVarArgs;
      }
      if (this.toUser == null)
      {
        paramVarArgs = new b("Not all required fields were included: toUser");
        AppMethodBeat.o(118533);
        throw paramVarArgs;
      }
      paramVarArgs.bv(1, this.idH);
      paramVarArgs.bS(2, this.createTime);
      if (this.hQQ != null) {
        paramVarArgs.g(3, this.hQQ);
      }
      if (this.toUser != null) {
        paramVarArgs.g(4, this.toUser);
      }
      if (this.content != null) {
        paramVarArgs.g(5, this.content);
      }
      paramVarArgs.bS(6, this.state);
      if (this.clientId != null) {
        paramVarArgs.g(7, this.clientId);
      }
      paramVarArgs.bS(8, this.Slv);
      paramVarArgs.bS(9, this.abJb);
      paramVarArgs.bS(10, this.retryCount);
      paramVarArgs.bS(11, this.abJc);
      if (this.sessionId != null) {
        paramVarArgs.g(12, this.sessionId);
      }
      if (this.SlC != null) {
        paramVarArgs.g(13, this.SlC);
      }
      paramVarArgs.bS(14, this.SlD);
      paramVarArgs.bS(15, this.Rqx);
      AppMethodBeat.o(118533);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.idH) + 0 + i.a.a.b.b.a.cJ(2, this.createTime);
      paramInt = i;
      if (this.hQQ != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.hQQ);
      }
      i = paramInt;
      if (this.toUser != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.toUser);
      }
      paramInt = i;
      if (this.content != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.content);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.state);
      paramInt = i;
      if (this.clientId != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.clientId);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.Slv) + i.a.a.b.b.a.cJ(9, this.abJb) + i.a.a.b.b.a.cJ(10, this.retryCount) + i.a.a.b.b.a.cJ(11, this.abJc);
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.sessionId);
      }
      i = paramInt;
      if (this.SlC != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.SlC);
      }
      paramInt = i.a.a.b.b.a.cJ(14, this.SlD);
      int j = i.a.a.b.b.a.cJ(15, this.Rqx);
      AppMethodBeat.o(118533);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.hQQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: fromUser");
        AppMethodBeat.o(118533);
        throw paramVarArgs;
      }
      if (this.toUser == null)
      {
        paramVarArgs = new b("Not all required fields were included: toUser");
        AppMethodBeat.o(118533);
        throw paramVarArgs;
      }
      AppMethodBeat.o(118533);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fif localfif = (fif)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(118533);
        return -1;
      case 1: 
        localfif.idH = locala.ajGk.aaw();
        AppMethodBeat.o(118533);
        return 0;
      case 2: 
        localfif.createTime = locala.ajGk.aar();
        AppMethodBeat.o(118533);
        return 0;
      case 3: 
        localfif.hQQ = locala.ajGk.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 4: 
        localfif.toUser = locala.ajGk.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 5: 
        localfif.content = locala.ajGk.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 6: 
        localfif.state = locala.ajGk.aar();
        AppMethodBeat.o(118533);
        return 0;
      case 7: 
        localfif.clientId = locala.ajGk.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 8: 
        localfif.Slv = locala.ajGk.aar();
        AppMethodBeat.o(118533);
        return 0;
      case 9: 
        localfif.abJb = locala.ajGk.aar();
        AppMethodBeat.o(118533);
        return 0;
      case 10: 
        localfif.retryCount = locala.ajGk.aar();
        AppMethodBeat.o(118533);
        return 0;
      case 11: 
        localfif.abJc = locala.ajGk.aar();
        AppMethodBeat.o(118533);
        return 0;
      case 12: 
        localfif.sessionId = locala.ajGk.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 13: 
        localfif.SlC = locala.ajGk.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 14: 
        localfif.SlD = locala.ajGk.aar();
        AppMethodBeat.o(118533);
        return 0;
      }
      localfif.Rqx = locala.ajGk.aar();
      AppMethodBeat.o(118533);
      return 0;
    }
    AppMethodBeat.o(118533);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fif
 * JD-Core Version:    0.7.0.1
 */