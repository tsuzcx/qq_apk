package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class djt
  extends com.tencent.mm.bw.a
{
  public int AtF;
  public int Bdb;
  public String Bdj;
  public int Bdk;
  public int HRB;
  public int HRC;
  public String clientId;
  public String content;
  public long dLI;
  public String dzZ;
  public int icw;
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
      if (this.dzZ == null)
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
      paramVarArgs.aZ(1, this.dLI);
      paramVarArgs.aS(2, this.icw);
      if (this.dzZ != null) {
        paramVarArgs.d(3, this.dzZ);
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
      paramVarArgs.aS(8, this.Bdb);
      paramVarArgs.aS(9, this.HRB);
      paramVarArgs.aS(10, this.retryCount);
      paramVarArgs.aS(11, this.HRC);
      if (this.sessionId != null) {
        paramVarArgs.d(12, this.sessionId);
      }
      if (this.Bdj != null) {
        paramVarArgs.d(13, this.Bdj);
      }
      paramVarArgs.aS(14, this.Bdk);
      paramVarArgs.aS(15, this.AtF);
      AppMethodBeat.o(118533);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.dLI) + 0 + f.a.a.b.b.a.bz(2, this.icw);
      paramInt = i;
      if (this.dzZ != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dzZ);
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
      i = paramInt + f.a.a.b.b.a.bz(8, this.Bdb) + f.a.a.b.b.a.bz(9, this.HRB) + f.a.a.b.b.a.bz(10, this.retryCount) + f.a.a.b.b.a.bz(11, this.HRC);
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.sessionId);
      }
      i = paramInt;
      if (this.Bdj != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.Bdj);
      }
      paramInt = f.a.a.b.b.a.bz(14, this.Bdk);
      int j = f.a.a.b.b.a.bz(15, this.AtF);
      AppMethodBeat.o(118533);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.dzZ == null)
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
      djt localdjt = (djt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(118533);
        return -1;
      case 1: 
        localdjt.dLI = locala.OmT.zd();
        AppMethodBeat.o(118533);
        return 0;
      case 2: 
        localdjt.icw = locala.OmT.zc();
        AppMethodBeat.o(118533);
        return 0;
      case 3: 
        localdjt.dzZ = locala.OmT.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 4: 
        localdjt.toUser = locala.OmT.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 5: 
        localdjt.content = locala.OmT.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 6: 
        localdjt.state = locala.OmT.zc();
        AppMethodBeat.o(118533);
        return 0;
      case 7: 
        localdjt.clientId = locala.OmT.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 8: 
        localdjt.Bdb = locala.OmT.zc();
        AppMethodBeat.o(118533);
        return 0;
      case 9: 
        localdjt.HRB = locala.OmT.zc();
        AppMethodBeat.o(118533);
        return 0;
      case 10: 
        localdjt.retryCount = locala.OmT.zc();
        AppMethodBeat.o(118533);
        return 0;
      case 11: 
        localdjt.HRC = locala.OmT.zc();
        AppMethodBeat.o(118533);
        return 0;
      case 12: 
        localdjt.sessionId = locala.OmT.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 13: 
        localdjt.Bdj = locala.OmT.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 14: 
        localdjt.Bdk = locala.OmT.zc();
        AppMethodBeat.o(118533);
        return 0;
      }
      localdjt.AtF = locala.OmT.zc();
      AppMethodBeat.o(118533);
      return 0;
    }
    AppMethodBeat.o(118533);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djt
 * JD-Core Version:    0.7.0.1
 */