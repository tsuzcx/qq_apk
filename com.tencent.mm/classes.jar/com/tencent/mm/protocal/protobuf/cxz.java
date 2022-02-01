package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class cxz
  extends com.tencent.mm.bx.a
{
  public int Eqd;
  public int Eqe;
  public String clientId;
  public String content;
  public long dAu;
  public String dpv;
  public int hgr;
  public int retryCount;
  public String sessionId;
  public int state;
  public String toUser;
  public int xyh;
  public int ygE;
  public String ygM;
  public int ygN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118533);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dpv == null)
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
      paramVarArgs.aG(1, this.dAu);
      paramVarArgs.aR(2, this.hgr);
      if (this.dpv != null) {
        paramVarArgs.d(3, this.dpv);
      }
      if (this.toUser != null) {
        paramVarArgs.d(4, this.toUser);
      }
      if (this.content != null) {
        paramVarArgs.d(5, this.content);
      }
      paramVarArgs.aR(6, this.state);
      if (this.clientId != null) {
        paramVarArgs.d(7, this.clientId);
      }
      paramVarArgs.aR(8, this.ygE);
      paramVarArgs.aR(9, this.Eqd);
      paramVarArgs.aR(10, this.retryCount);
      paramVarArgs.aR(11, this.Eqe);
      if (this.sessionId != null) {
        paramVarArgs.d(12, this.sessionId);
      }
      if (this.ygM != null) {
        paramVarArgs.d(13, this.ygM);
      }
      paramVarArgs.aR(14, this.ygN);
      paramVarArgs.aR(15, this.xyh);
      AppMethodBeat.o(118533);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.q(1, this.dAu) + 0 + f.a.a.b.b.a.bA(2, this.hgr);
      paramInt = i;
      if (this.dpv != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dpv);
      }
      i = paramInt;
      if (this.toUser != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.toUser);
      }
      paramInt = i;
      if (this.content != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.content);
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.state);
      paramInt = i;
      if (this.clientId != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.clientId);
      }
      i = paramInt + f.a.a.b.b.a.bA(8, this.ygE) + f.a.a.b.b.a.bA(9, this.Eqd) + f.a.a.b.b.a.bA(10, this.retryCount) + f.a.a.b.b.a.bA(11, this.Eqe);
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.sessionId);
      }
      i = paramInt;
      if (this.ygM != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.ygM);
      }
      paramInt = f.a.a.b.b.a.bA(14, this.ygN);
      int j = f.a.a.b.b.a.bA(15, this.xyh);
      AppMethodBeat.o(118533);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.dpv == null)
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
      cxz localcxz = (cxz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(118533);
        return -1;
      case 1: 
        localcxz.dAu = locala.KhF.xT();
        AppMethodBeat.o(118533);
        return 0;
      case 2: 
        localcxz.hgr = locala.KhF.xS();
        AppMethodBeat.o(118533);
        return 0;
      case 3: 
        localcxz.dpv = locala.KhF.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 4: 
        localcxz.toUser = locala.KhF.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 5: 
        localcxz.content = locala.KhF.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 6: 
        localcxz.state = locala.KhF.xS();
        AppMethodBeat.o(118533);
        return 0;
      case 7: 
        localcxz.clientId = locala.KhF.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 8: 
        localcxz.ygE = locala.KhF.xS();
        AppMethodBeat.o(118533);
        return 0;
      case 9: 
        localcxz.Eqd = locala.KhF.xS();
        AppMethodBeat.o(118533);
        return 0;
      case 10: 
        localcxz.retryCount = locala.KhF.xS();
        AppMethodBeat.o(118533);
        return 0;
      case 11: 
        localcxz.Eqe = locala.KhF.xS();
        AppMethodBeat.o(118533);
        return 0;
      case 12: 
        localcxz.sessionId = locala.KhF.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 13: 
        localcxz.ygM = locala.KhF.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 14: 
        localcxz.ygN = locala.KhF.xS();
        AppMethodBeat.o(118533);
        return 0;
      }
      localcxz.xyh = locala.KhF.xS();
      AppMethodBeat.o(118533);
      return 0;
    }
    AppMethodBeat.o(118533);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxz
 * JD-Core Version:    0.7.0.1
 */