package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class diy
  extends com.tencent.mm.bx.a
{
  public String ALG;
  public int ALH;
  public int ALy;
  public int Acs;
  public int HxQ;
  public int HxR;
  public String clientId;
  public String content;
  public long dKt;
  public String dyU;
  public int hZE;
  public int retryCount;
  public String sessionId;
  public int state;
  public String toUser;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118533);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dyU == null)
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
      paramVarArgs.aY(1, this.dKt);
      paramVarArgs.aS(2, this.hZE);
      if (this.dyU != null) {
        paramVarArgs.d(3, this.dyU);
      }
      if (this.toUser != null) {
        paramVarArgs.d(4, this.toUser);
      }
      if (this.content != null) {
        paramVarArgs.d(5, this.content);
      }
      paramVarArgs.aS(6, this.state);
      if (this.clientId != null) {
        paramVarArgs.d(7, this.clientId);
      }
      paramVarArgs.aS(8, this.ALy);
      paramVarArgs.aS(9, this.HxQ);
      paramVarArgs.aS(10, this.retryCount);
      paramVarArgs.aS(11, this.HxR);
      if (this.sessionId != null) {
        paramVarArgs.d(12, this.sessionId);
      }
      if (this.ALG != null) {
        paramVarArgs.d(13, this.ALG);
      }
      paramVarArgs.aS(14, this.ALH);
      paramVarArgs.aS(15, this.Acs);
      AppMethodBeat.o(118533);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.dKt) + 0 + f.a.a.b.b.a.bz(2, this.hZE);
      paramInt = i;
      if (this.dyU != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dyU);
      }
      i = paramInt;
      if (this.toUser != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.toUser);
      }
      paramInt = i;
      if (this.content != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.content);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.state);
      paramInt = i;
      if (this.clientId != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.clientId);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.ALy) + f.a.a.b.b.a.bz(9, this.HxQ) + f.a.a.b.b.a.bz(10, this.retryCount) + f.a.a.b.b.a.bz(11, this.HxR);
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.sessionId);
      }
      i = paramInt;
      if (this.ALG != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.ALG);
      }
      paramInt = f.a.a.b.b.a.bz(14, this.ALH);
      int j = f.a.a.b.b.a.bz(15, this.Acs);
      AppMethodBeat.o(118533);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.dyU == null)
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
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      diy localdiy = (diy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(118533);
        return -1;
      case 1: 
        localdiy.dKt = locala.NPN.zd();
        AppMethodBeat.o(118533);
        return 0;
      case 2: 
        localdiy.hZE = locala.NPN.zc();
        AppMethodBeat.o(118533);
        return 0;
      case 3: 
        localdiy.dyU = locala.NPN.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 4: 
        localdiy.toUser = locala.NPN.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 5: 
        localdiy.content = locala.NPN.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 6: 
        localdiy.state = locala.NPN.zc();
        AppMethodBeat.o(118533);
        return 0;
      case 7: 
        localdiy.clientId = locala.NPN.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 8: 
        localdiy.ALy = locala.NPN.zc();
        AppMethodBeat.o(118533);
        return 0;
      case 9: 
        localdiy.HxQ = locala.NPN.zc();
        AppMethodBeat.o(118533);
        return 0;
      case 10: 
        localdiy.retryCount = locala.NPN.zc();
        AppMethodBeat.o(118533);
        return 0;
      case 11: 
        localdiy.HxR = locala.NPN.zc();
        AppMethodBeat.o(118533);
        return 0;
      case 12: 
        localdiy.sessionId = locala.NPN.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 13: 
        localdiy.ALG = locala.NPN.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 14: 
        localdiy.ALH = locala.NPN.zc();
        AppMethodBeat.o(118533);
        return 0;
      }
      localdiy.Acs = locala.NPN.zc();
      AppMethodBeat.o(118533);
      return 0;
    }
    AppMethodBeat.o(118533);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.diy
 * JD-Core Version:    0.7.0.1
 */