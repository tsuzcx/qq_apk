package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class cgx
  extends com.tencent.mm.bv.a
{
  public long cJA;
  public String clientId;
  public String content;
  public String cpW;
  public String czp;
  public int fDT;
  public int retryCount;
  public int state;
  public String sxC;
  public int sxD;
  public int sxu;
  public String toUser;
  public int xRJ;
  public int xRK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(108907);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.czp == null)
      {
        paramVarArgs = new b("Not all required fields were included: fromUser");
        AppMethodBeat.o(108907);
        throw paramVarArgs;
      }
      if (this.toUser == null)
      {
        paramVarArgs = new b("Not all required fields were included: toUser");
        AppMethodBeat.o(108907);
        throw paramVarArgs;
      }
      paramVarArgs.am(1, this.cJA);
      paramVarArgs.aO(2, this.fDT);
      if (this.czp != null) {
        paramVarArgs.e(3, this.czp);
      }
      if (this.toUser != null) {
        paramVarArgs.e(4, this.toUser);
      }
      if (this.content != null) {
        paramVarArgs.e(5, this.content);
      }
      paramVarArgs.aO(6, this.state);
      if (this.clientId != null) {
        paramVarArgs.e(7, this.clientId);
      }
      paramVarArgs.aO(8, this.sxu);
      paramVarArgs.aO(9, this.xRJ);
      paramVarArgs.aO(10, this.retryCount);
      paramVarArgs.aO(11, this.xRK);
      if (this.cpW != null) {
        paramVarArgs.e(12, this.cpW);
      }
      if (this.sxC != null) {
        paramVarArgs.e(13, this.sxC);
      }
      paramVarArgs.aO(14, this.sxD);
      AppMethodBeat.o(108907);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.p(1, this.cJA) + 0 + e.a.a.b.b.a.bl(2, this.fDT);
      paramInt = i;
      if (this.czp != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.czp);
      }
      i = paramInt;
      if (this.toUser != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.toUser);
      }
      paramInt = i;
      if (this.content != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.content);
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.state);
      paramInt = i;
      if (this.clientId != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.clientId);
      }
      i = paramInt + e.a.a.b.b.a.bl(8, this.sxu) + e.a.a.b.b.a.bl(9, this.xRJ) + e.a.a.b.b.a.bl(10, this.retryCount) + e.a.a.b.b.a.bl(11, this.xRK);
      paramInt = i;
      if (this.cpW != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.cpW);
      }
      i = paramInt;
      if (this.sxC != null) {
        i = paramInt + e.a.a.b.b.a.f(13, this.sxC);
      }
      paramInt = e.a.a.b.b.a.bl(14, this.sxD);
      AppMethodBeat.o(108907);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.czp == null)
      {
        paramVarArgs = new b("Not all required fields were included: fromUser");
        AppMethodBeat.o(108907);
        throw paramVarArgs;
      }
      if (this.toUser == null)
      {
        paramVarArgs = new b("Not all required fields were included: toUser");
        AppMethodBeat.o(108907);
        throw paramVarArgs;
      }
      AppMethodBeat.o(108907);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cgx localcgx = (cgx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(108907);
        return -1;
      case 1: 
        localcgx.cJA = locala.CLY.sm();
        AppMethodBeat.o(108907);
        return 0;
      case 2: 
        localcgx.fDT = locala.CLY.sl();
        AppMethodBeat.o(108907);
        return 0;
      case 3: 
        localcgx.czp = locala.CLY.readString();
        AppMethodBeat.o(108907);
        return 0;
      case 4: 
        localcgx.toUser = locala.CLY.readString();
        AppMethodBeat.o(108907);
        return 0;
      case 5: 
        localcgx.content = locala.CLY.readString();
        AppMethodBeat.o(108907);
        return 0;
      case 6: 
        localcgx.state = locala.CLY.sl();
        AppMethodBeat.o(108907);
        return 0;
      case 7: 
        localcgx.clientId = locala.CLY.readString();
        AppMethodBeat.o(108907);
        return 0;
      case 8: 
        localcgx.sxu = locala.CLY.sl();
        AppMethodBeat.o(108907);
        return 0;
      case 9: 
        localcgx.xRJ = locala.CLY.sl();
        AppMethodBeat.o(108907);
        return 0;
      case 10: 
        localcgx.retryCount = locala.CLY.sl();
        AppMethodBeat.o(108907);
        return 0;
      case 11: 
        localcgx.xRK = locala.CLY.sl();
        AppMethodBeat.o(108907);
        return 0;
      case 12: 
        localcgx.cpW = locala.CLY.readString();
        AppMethodBeat.o(108907);
        return 0;
      case 13: 
        localcgx.sxC = locala.CLY.readString();
        AppMethodBeat.o(108907);
        return 0;
      }
      localcgx.sxD = locala.CLY.sl();
      AppMethodBeat.o(108907);
      return 0;
    }
    AppMethodBeat.o(108907);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgx
 * JD-Core Version:    0.7.0.1
 */