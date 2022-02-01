package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dyf
  extends com.tencent.mm.bx.a
{
  public String appId;
  public int from;
  public String hUf;
  public String iconUrl;
  public String nickname;
  public int pkgVersion;
  public int qHO;
  public String rSA;
  public boolean rSB;
  public String rSC;
  public boolean rSD;
  public String rSy;
  public String rSz;
  public String rcM;
  public String rcN;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257951);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.rSB);
      if (this.rSy != null) {
        paramVarArgs.g(2, this.rSy);
      }
      if (this.rSz != null) {
        paramVarArgs.g(3, this.rSz);
      }
      if (this.rSA != null) {
        paramVarArgs.g(4, this.rSA);
      }
      paramVarArgs.di(5, this.rSD);
      if (this.rSC != null) {
        paramVarArgs.g(6, this.rSC);
      }
      if (this.appId != null) {
        paramVarArgs.g(7, this.appId);
      }
      if (this.username != null) {
        paramVarArgs.g(8, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.g(9, this.nickname);
      }
      if (this.iconUrl != null) {
        paramVarArgs.g(10, this.iconUrl);
      }
      paramVarArgs.bS(11, this.qHO);
      paramVarArgs.bS(12, this.pkgVersion);
      if (this.rcM != null) {
        paramVarArgs.g(13, this.rcM);
      }
      paramVarArgs.bS(14, this.from);
      if (this.hUf != null) {
        paramVarArgs.g(15, this.hUf);
      }
      if (this.rcN != null) {
        paramVarArgs.g(16, this.rcN);
      }
      AppMethodBeat.o(257951);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.ko(1) + 1 + 0;
      paramInt = i;
      if (this.rSy != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.rSy);
      }
      i = paramInt;
      if (this.rSz != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.rSz);
      }
      paramInt = i;
      if (this.rSA != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.rSA);
      }
      i = paramInt + (i.a.a.b.b.a.ko(5) + 1);
      paramInt = i;
      if (this.rSC != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.rSC);
      }
      i = paramInt;
      if (this.appId != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.appId);
      }
      paramInt = i;
      if (this.username != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.username);
      }
      i = paramInt;
      if (this.nickname != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.nickname);
      }
      paramInt = i;
      if (this.iconUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.iconUrl);
      }
      i = paramInt + i.a.a.b.b.a.cJ(11, this.qHO) + i.a.a.b.b.a.cJ(12, this.pkgVersion);
      paramInt = i;
      if (this.rcM != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.rcM);
      }
      i = paramInt + i.a.a.b.b.a.cJ(14, this.from);
      paramInt = i;
      if (this.hUf != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.hUf);
      }
      i = paramInt;
      if (this.rcN != null) {
        i = paramInt + i.a.a.b.b.a.h(16, this.rcN);
      }
      AppMethodBeat.o(257951);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257951);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dyf localdyf = (dyf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257951);
        return -1;
      case 1: 
        localdyf.rSB = locala.ajGk.aai();
        AppMethodBeat.o(257951);
        return 0;
      case 2: 
        localdyf.rSy = locala.ajGk.readString();
        AppMethodBeat.o(257951);
        return 0;
      case 3: 
        localdyf.rSz = locala.ajGk.readString();
        AppMethodBeat.o(257951);
        return 0;
      case 4: 
        localdyf.rSA = locala.ajGk.readString();
        AppMethodBeat.o(257951);
        return 0;
      case 5: 
        localdyf.rSD = locala.ajGk.aai();
        AppMethodBeat.o(257951);
        return 0;
      case 6: 
        localdyf.rSC = locala.ajGk.readString();
        AppMethodBeat.o(257951);
        return 0;
      case 7: 
        localdyf.appId = locala.ajGk.readString();
        AppMethodBeat.o(257951);
        return 0;
      case 8: 
        localdyf.username = locala.ajGk.readString();
        AppMethodBeat.o(257951);
        return 0;
      case 9: 
        localdyf.nickname = locala.ajGk.readString();
        AppMethodBeat.o(257951);
        return 0;
      case 10: 
        localdyf.iconUrl = locala.ajGk.readString();
        AppMethodBeat.o(257951);
        return 0;
      case 11: 
        localdyf.qHO = locala.ajGk.aar();
        AppMethodBeat.o(257951);
        return 0;
      case 12: 
        localdyf.pkgVersion = locala.ajGk.aar();
        AppMethodBeat.o(257951);
        return 0;
      case 13: 
        localdyf.rcM = locala.ajGk.readString();
        AppMethodBeat.o(257951);
        return 0;
      case 14: 
        localdyf.from = locala.ajGk.aar();
        AppMethodBeat.o(257951);
        return 0;
      case 15: 
        localdyf.hUf = locala.ajGk.readString();
        AppMethodBeat.o(257951);
        return 0;
      }
      localdyf.rcN = locala.ajGk.readString();
      AppMethodBeat.o(257951);
      return 0;
    }
    AppMethodBeat.o(257951);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyf
 * JD-Core Version:    0.7.0.1
 */