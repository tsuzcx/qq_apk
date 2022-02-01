package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class afw
  extends com.tencent.mm.bx.a
{
  public String DfP;
  public String appId;
  public int cfU;
  public String dbu;
  public int dkC;
  public String dzY;
  public String iconUrl;
  public int jwB;
  public int subType;
  public int type;
  public String username;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127455);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.appId != null) {
        paramVarArgs.d(2, this.appId);
      }
      paramVarArgs.aR(3, this.dkC);
      if (this.iconUrl != null) {
        paramVarArgs.d(4, this.iconUrl);
      }
      paramVarArgs.aR(5, this.type);
      if (this.dbu != null) {
        paramVarArgs.d(6, this.dbu);
      }
      if (this.DfP != null) {
        paramVarArgs.d(7, this.DfP);
      }
      paramVarArgs.aR(8, this.version);
      paramVarArgs.aR(9, this.jwB);
      paramVarArgs.aR(10, this.cfU);
      if (this.dzY != null) {
        paramVarArgs.d(11, this.dzY);
      }
      paramVarArgs.aR(12, this.subType);
      AppMethodBeat.o(127455);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label790;
      }
    }
    label790:
    for (paramInt = f.a.a.b.b.a.e(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.appId != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.appId);
      }
      i += f.a.a.b.b.a.bA(3, this.dkC);
      paramInt = i;
      if (this.iconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.iconUrl);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.type);
      paramInt = i;
      if (this.dbu != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.dbu);
      }
      i = paramInt;
      if (this.DfP != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.DfP);
      }
      i = i + f.a.a.b.b.a.bA(8, this.version) + f.a.a.b.b.a.bA(9, this.jwB) + f.a.a.b.b.a.bA(10, this.cfU);
      paramInt = i;
      if (this.dzY != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.dzY);
      }
      i = f.a.a.b.b.a.bA(12, this.subType);
      AppMethodBeat.o(127455);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(127455);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        afw localafw = (afw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127455);
          return -1;
        case 1: 
          localafw.username = locala.KhF.readString();
          AppMethodBeat.o(127455);
          return 0;
        case 2: 
          localafw.appId = locala.KhF.readString();
          AppMethodBeat.o(127455);
          return 0;
        case 3: 
          localafw.dkC = locala.KhF.xS();
          AppMethodBeat.o(127455);
          return 0;
        case 4: 
          localafw.iconUrl = locala.KhF.readString();
          AppMethodBeat.o(127455);
          return 0;
        case 5: 
          localafw.type = locala.KhF.xS();
          AppMethodBeat.o(127455);
          return 0;
        case 6: 
          localafw.dbu = locala.KhF.readString();
          AppMethodBeat.o(127455);
          return 0;
        case 7: 
          localafw.DfP = locala.KhF.readString();
          AppMethodBeat.o(127455);
          return 0;
        case 8: 
          localafw.version = locala.KhF.xS();
          AppMethodBeat.o(127455);
          return 0;
        case 9: 
          localafw.jwB = locala.KhF.xS();
          AppMethodBeat.o(127455);
          return 0;
        case 10: 
          localafw.cfU = locala.KhF.xS();
          AppMethodBeat.o(127455);
          return 0;
        case 11: 
          localafw.dzY = locala.KhF.readString();
          AppMethodBeat.o(127455);
          return 0;
        }
        localafw.subType = locala.KhF.xS();
        AppMethodBeat.o(127455);
        return 0;
      }
      AppMethodBeat.o(127455);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afw
 * JD-Core Version:    0.7.0.1
 */