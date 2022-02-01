package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class edg
  extends com.tencent.mm.bw.a
{
  public int ECO;
  public int FnS;
  public String Foa;
  public int Fob;
  public int NdF;
  public int NdG;
  public String clientId;
  public String content;
  public String dRL;
  public long edx;
  public int iXu;
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
      if (this.dRL == null)
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
      paramVarArgs.bb(1, this.edx);
      paramVarArgs.aM(2, this.iXu);
      if (this.dRL != null) {
        paramVarArgs.e(3, this.dRL);
      }
      if (this.toUser != null) {
        paramVarArgs.e(4, this.toUser);
      }
      if (this.content != null) {
        paramVarArgs.e(5, this.content);
      }
      paramVarArgs.aM(6, this.state);
      if (this.clientId != null) {
        paramVarArgs.e(7, this.clientId);
      }
      paramVarArgs.aM(8, this.FnS);
      paramVarArgs.aM(9, this.NdF);
      paramVarArgs.aM(10, this.retryCount);
      paramVarArgs.aM(11, this.NdG);
      if (this.sessionId != null) {
        paramVarArgs.e(12, this.sessionId);
      }
      if (this.Foa != null) {
        paramVarArgs.e(13, this.Foa);
      }
      paramVarArgs.aM(14, this.Fob);
      paramVarArgs.aM(15, this.ECO);
      AppMethodBeat.o(118533);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.edx) + 0 + g.a.a.b.b.a.bu(2, this.iXu);
      paramInt = i;
      if (this.dRL != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.dRL);
      }
      i = paramInt;
      if (this.toUser != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.toUser);
      }
      paramInt = i;
      if (this.content != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.content);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.state);
      paramInt = i;
      if (this.clientId != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.clientId);
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.FnS) + g.a.a.b.b.a.bu(9, this.NdF) + g.a.a.b.b.a.bu(10, this.retryCount) + g.a.a.b.b.a.bu(11, this.NdG);
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.sessionId);
      }
      i = paramInt;
      if (this.Foa != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.Foa);
      }
      paramInt = g.a.a.b.b.a.bu(14, this.Fob);
      int j = g.a.a.b.b.a.bu(15, this.ECO);
      AppMethodBeat.o(118533);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.dRL == null)
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
      edg localedg = (edg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(118533);
        return -1;
      case 1: 
        localedg.edx = locala.UbS.zl();
        AppMethodBeat.o(118533);
        return 0;
      case 2: 
        localedg.iXu = locala.UbS.zi();
        AppMethodBeat.o(118533);
        return 0;
      case 3: 
        localedg.dRL = locala.UbS.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 4: 
        localedg.toUser = locala.UbS.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 5: 
        localedg.content = locala.UbS.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 6: 
        localedg.state = locala.UbS.zi();
        AppMethodBeat.o(118533);
        return 0;
      case 7: 
        localedg.clientId = locala.UbS.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 8: 
        localedg.FnS = locala.UbS.zi();
        AppMethodBeat.o(118533);
        return 0;
      case 9: 
        localedg.NdF = locala.UbS.zi();
        AppMethodBeat.o(118533);
        return 0;
      case 10: 
        localedg.retryCount = locala.UbS.zi();
        AppMethodBeat.o(118533);
        return 0;
      case 11: 
        localedg.NdG = locala.UbS.zi();
        AppMethodBeat.o(118533);
        return 0;
      case 12: 
        localedg.sessionId = locala.UbS.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 13: 
        localedg.Foa = locala.UbS.readString();
        AppMethodBeat.o(118533);
        return 0;
      case 14: 
        localedg.Fob = locala.UbS.zi();
        AppMethodBeat.o(118533);
        return 0;
      }
      localedg.ECO = locala.UbS.zi();
      AppMethodBeat.o(118533);
      return 0;
    }
    AppMethodBeat.o(118533);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edg
 * JD-Core Version:    0.7.0.1
 */