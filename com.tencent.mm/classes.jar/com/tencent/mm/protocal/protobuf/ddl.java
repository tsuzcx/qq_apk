package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ddl
  extends com.tencent.mm.bw.a
{
  public int FNf;
  public int FNg;
  public String clientId;
  public String content;
  public String dng;
  public long dyg;
  public int hGU;
  public int retryCount;
  public String sessionId;
  public int state;
  public String toUser;
  public int yKW;
  public int ztE;
  public String ztM;
  public int ztN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118533);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dng == null)
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
      paramVarArgs.aO(1, this.dyg);
      paramVarArgs.aR(2, this.hGU);
      if (this.dng != null) {
        paramVarArgs.d(3, this.dng);
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
      paramVarArgs.aR(8, this.ztE);
      paramVarArgs.aR(9, this.FNf);
      paramVarArgs.aR(10, this.retryCount);
      paramVarArgs.aR(11, this.FNg);
      if (this.sessionId != null) {
        paramVarArgs.d(12, this.sessionId);
      }
      if (this.ztM != null) {
        paramVarArgs.d(13, this.ztM);
      }
      paramVarArgs.aR(14, this.ztN);
      paramVarArgs.aR(15, this.yKW);
      AppMethodBeat.o(118533);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.dyg) + 0 + f.a.a.b.b.a.bx(2, this.hGU);
      paramInt = i;
      if (this.dng != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dng);
      }
      i = paramInt;
      if (this.toUser != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.toUser);
      }
      paramInt = i;
      if (this.content != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.content);
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.state);
      paramInt = i;
      if (this.clientId != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.clientId);
      }
      i = paramInt + f.a.a.b.b.a.bx(8, this.ztE) + f.a.a.b.b.a.bx(9, this.FNf) + f.a.a.b.b.a.bx(10, this.retryCount) + f.a.a.b.b.a.bx(11, this.FNg);
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.sessionId);
      }
      i = paramInt;
      if (this.ztM != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.ztM);
      }
      paramInt = f.a.a.b.b.a.bx(14, this.ztN);
      int j = f.a.a.b.b.a.bx(15, this.yKW);
      AppMethodBeat.o(118533);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.dng == null)
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
      ddl localddl = (ddl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(118533);
        return -1;
      case 1: 
        localddl.dyg = locala.LVo.xG();
        AppMethodBeat.o(118533);
        return 0;
      case 2: 
        localddl.hGU = locala.LVo.xF();
        AppMethodBeat.o(118533);
        return 0;
      case 3: 
        localddl.dng = locala.LVo.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 4: 
        localddl.toUser = locala.LVo.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 5: 
        localddl.content = locala.LVo.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 6: 
        localddl.state = locala.LVo.xF();
        AppMethodBeat.o(118533);
        return 0;
      case 7: 
        localddl.clientId = locala.LVo.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 8: 
        localddl.ztE = locala.LVo.xF();
        AppMethodBeat.o(118533);
        return 0;
      case 9: 
        localddl.FNf = locala.LVo.xF();
        AppMethodBeat.o(118533);
        return 0;
      case 10: 
        localddl.retryCount = locala.LVo.xF();
        AppMethodBeat.o(118533);
        return 0;
      case 11: 
        localddl.FNg = locala.LVo.xF();
        AppMethodBeat.o(118533);
        return 0;
      case 12: 
        localddl.sessionId = locala.LVo.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 13: 
        localddl.ztM = locala.LVo.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 14: 
        localddl.ztN = locala.LVo.xF();
        AppMethodBeat.o(118533);
        return 0;
      }
      localddl.yKW = locala.LVo.xF();
      AppMethodBeat.o(118533);
      return 0;
    }
    AppMethodBeat.o(118533);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddl
 * JD-Core Version:    0.7.0.1
 */