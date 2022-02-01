package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class enh
  extends com.tencent.mm.cd.a
{
  public int KQF;
  public int LHU;
  public String LIb;
  public int LIc;
  public int Uqc;
  public int Uqd;
  public String clientId;
  public String content;
  public int createTime;
  public String fLi;
  public long fXG;
  public int retryCount;
  public String sessionId;
  public int state;
  public String toUser;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118533);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fLi == null)
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
      paramVarArgs.bm(1, this.fXG);
      paramVarArgs.aY(2, this.createTime);
      if (this.fLi != null) {
        paramVarArgs.f(3, this.fLi);
      }
      if (this.toUser != null) {
        paramVarArgs.f(4, this.toUser);
      }
      if (this.content != null) {
        paramVarArgs.f(5, this.content);
      }
      paramVarArgs.aY(6, this.state);
      if (this.clientId != null) {
        paramVarArgs.f(7, this.clientId);
      }
      paramVarArgs.aY(8, this.LHU);
      paramVarArgs.aY(9, this.Uqc);
      paramVarArgs.aY(10, this.retryCount);
      paramVarArgs.aY(11, this.Uqd);
      if (this.sessionId != null) {
        paramVarArgs.f(12, this.sessionId);
      }
      if (this.LIb != null) {
        paramVarArgs.f(13, this.LIb);
      }
      paramVarArgs.aY(14, this.LIc);
      paramVarArgs.aY(15, this.KQF);
      AppMethodBeat.o(118533);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.fXG) + 0 + g.a.a.b.b.a.bM(2, this.createTime);
      paramInt = i;
      if (this.fLi != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.fLi);
      }
      i = paramInt;
      if (this.toUser != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.toUser);
      }
      paramInt = i;
      if (this.content != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.content);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.state);
      paramInt = i;
      if (this.clientId != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.clientId);
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.LHU) + g.a.a.b.b.a.bM(9, this.Uqc) + g.a.a.b.b.a.bM(10, this.retryCount) + g.a.a.b.b.a.bM(11, this.Uqd);
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.sessionId);
      }
      i = paramInt;
      if (this.LIb != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.LIb);
      }
      paramInt = g.a.a.b.b.a.bM(14, this.LIc);
      int j = g.a.a.b.b.a.bM(15, this.KQF);
      AppMethodBeat.o(118533);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.fLi == null)
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
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      enh localenh = (enh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(118533);
        return -1;
      case 1: 
        localenh.fXG = locala.abFh.AN();
        AppMethodBeat.o(118533);
        return 0;
      case 2: 
        localenh.createTime = locala.abFh.AK();
        AppMethodBeat.o(118533);
        return 0;
      case 3: 
        localenh.fLi = locala.abFh.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 4: 
        localenh.toUser = locala.abFh.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 5: 
        localenh.content = locala.abFh.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 6: 
        localenh.state = locala.abFh.AK();
        AppMethodBeat.o(118533);
        return 0;
      case 7: 
        localenh.clientId = locala.abFh.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 8: 
        localenh.LHU = locala.abFh.AK();
        AppMethodBeat.o(118533);
        return 0;
      case 9: 
        localenh.Uqc = locala.abFh.AK();
        AppMethodBeat.o(118533);
        return 0;
      case 10: 
        localenh.retryCount = locala.abFh.AK();
        AppMethodBeat.o(118533);
        return 0;
      case 11: 
        localenh.Uqd = locala.abFh.AK();
        AppMethodBeat.o(118533);
        return 0;
      case 12: 
        localenh.sessionId = locala.abFh.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 13: 
        localenh.LIb = locala.abFh.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 14: 
        localenh.LIc = locala.abFh.AK();
        AppMethodBeat.o(118533);
        return 0;
      }
      localenh.KQF = locala.abFh.AK();
      AppMethodBeat.o(118533);
      return 0;
    }
    AppMethodBeat.o(118533);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.enh
 * JD-Core Version:    0.7.0.1
 */