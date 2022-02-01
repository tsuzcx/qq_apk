package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gkq
  extends com.tencent.mm.bx.a
{
  public int OzG;
  public int OzH;
  public String SessionId;
  public int WBK;
  public String Zsa;
  public int aalm;
  public String acgt;
  public String acgu;
  public String acgv;
  public int acgw;
  public int crm;
  public int icZ;
  public String ida;
  public String oOI;
  public String tPO;
  public int tPS;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123693);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.vhJ);
      if (this.oOI != null) {
        paramVarArgs.g(2, this.oOI);
      }
      if (this.acgt != null) {
        paramVarArgs.g(3, this.acgt);
      }
      paramVarArgs.bS(4, this.OzG);
      paramVarArgs.bS(5, this.crm);
      paramVarArgs.bS(6, this.OzH);
      if (this.acgu != null) {
        paramVarArgs.g(7, this.acgu);
      }
      paramVarArgs.bS(8, this.aalm);
      if (this.SessionId != null) {
        paramVarArgs.g(9, this.SessionId);
      }
      if (this.acgv != null) {
        paramVarArgs.g(10, this.acgv);
      }
      paramVarArgs.bS(11, this.WBK);
      paramVarArgs.bS(12, this.acgw);
      if (this.Zsa != null) {
        paramVarArgs.g(13, this.Zsa);
      }
      if (this.tPO != null) {
        paramVarArgs.g(14, this.tPO);
      }
      paramVarArgs.bS(15, this.icZ);
      if (this.ida != null) {
        paramVarArgs.g(16, this.ida);
      }
      paramVarArgs.bS(17, this.tPS);
      AppMethodBeat.o(123693);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.vhJ) + 0;
      paramInt = i;
      if (this.oOI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.oOI);
      }
      i = paramInt;
      if (this.acgt != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.acgt);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.OzG) + i.a.a.b.b.a.cJ(5, this.crm) + i.a.a.b.b.a.cJ(6, this.OzH);
      paramInt = i;
      if (this.acgu != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.acgu);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.aalm);
      paramInt = i;
      if (this.SessionId != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.SessionId);
      }
      i = paramInt;
      if (this.acgv != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.acgv);
      }
      i = i + i.a.a.b.b.a.cJ(11, this.WBK) + i.a.a.b.b.a.cJ(12, this.acgw);
      paramInt = i;
      if (this.Zsa != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.Zsa);
      }
      i = paramInt;
      if (this.tPO != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.tPO);
      }
      i += i.a.a.b.b.a.cJ(15, this.icZ);
      paramInt = i;
      if (this.ida != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.ida);
      }
      i = i.a.a.b.b.a.cJ(17, this.tPS);
      AppMethodBeat.o(123693);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(123693);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      gkq localgkq = (gkq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123693);
        return -1;
      case 1: 
        localgkq.vhJ = locala.ajGk.aar();
        AppMethodBeat.o(123693);
        return 0;
      case 2: 
        localgkq.oOI = locala.ajGk.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 3: 
        localgkq.acgt = locala.ajGk.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 4: 
        localgkq.OzG = locala.ajGk.aar();
        AppMethodBeat.o(123693);
        return 0;
      case 5: 
        localgkq.crm = locala.ajGk.aar();
        AppMethodBeat.o(123693);
        return 0;
      case 6: 
        localgkq.OzH = locala.ajGk.aar();
        AppMethodBeat.o(123693);
        return 0;
      case 7: 
        localgkq.acgu = locala.ajGk.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 8: 
        localgkq.aalm = locala.ajGk.aar();
        AppMethodBeat.o(123693);
        return 0;
      case 9: 
        localgkq.SessionId = locala.ajGk.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 10: 
        localgkq.acgv = locala.ajGk.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 11: 
        localgkq.WBK = locala.ajGk.aar();
        AppMethodBeat.o(123693);
        return 0;
      case 12: 
        localgkq.acgw = locala.ajGk.aar();
        AppMethodBeat.o(123693);
        return 0;
      case 13: 
        localgkq.Zsa = locala.ajGk.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 14: 
        localgkq.tPO = locala.ajGk.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 15: 
        localgkq.icZ = locala.ajGk.aar();
        AppMethodBeat.o(123693);
        return 0;
      case 16: 
        localgkq.ida = locala.ajGk.readString();
        AppMethodBeat.o(123693);
        return 0;
      }
      localgkq.tPS = locala.ajGk.aar();
      AppMethodBeat.o(123693);
      return 0;
    }
    AppMethodBeat.o(123693);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gkq
 * JD-Core Version:    0.7.0.1
 */