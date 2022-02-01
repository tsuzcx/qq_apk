package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  extends com.tencent.mm.bx.a
{
  public String ToG;
  public String ToH;
  public String ToI;
  public String ToJ;
  public String ToK;
  public boolean ToL;
  public String city;
  public String country;
  public String hNw;
  public String nickname;
  public String province;
  public int ret;
  public int sex;
  public String signature;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(290041);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ret);
      if (this.hNw != null) {
        paramVarArgs.g(2, this.hNw);
      }
      if (this.ToG != null) {
        paramVarArgs.g(3, this.ToG);
      }
      if (this.nickname != null) {
        paramVarArgs.g(4, this.nickname);
      }
      paramVarArgs.bS(5, this.sex);
      if (this.province != null) {
        paramVarArgs.g(6, this.province);
      }
      if (this.city != null) {
        paramVarArgs.g(7, this.city);
      }
      if (this.signature != null) {
        paramVarArgs.g(8, this.signature);
      }
      if (this.ToH != null) {
        paramVarArgs.g(9, this.ToH);
      }
      if (this.ToI != null) {
        paramVarArgs.g(10, this.ToI);
      }
      if (this.ToJ != null) {
        paramVarArgs.g(11, this.ToJ);
      }
      if (this.country != null) {
        paramVarArgs.g(12, this.country);
      }
      if (this.ToK != null) {
        paramVarArgs.g(13, this.ToK);
      }
      paramVarArgs.di(14, this.ToL);
      AppMethodBeat.o(290041);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.ret) + 0;
      paramInt = i;
      if (this.hNw != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.hNw);
      }
      i = paramInt;
      if (this.ToG != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ToG);
      }
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.nickname);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.sex);
      paramInt = i;
      if (this.province != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.province);
      }
      i = paramInt;
      if (this.city != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.city);
      }
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.signature);
      }
      i = paramInt;
      if (this.ToH != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.ToH);
      }
      paramInt = i;
      if (this.ToI != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.ToI);
      }
      i = paramInt;
      if (this.ToJ != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.ToJ);
      }
      paramInt = i;
      if (this.country != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.country);
      }
      i = paramInt;
      if (this.ToK != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.ToK);
      }
      paramInt = i.a.a.b.b.a.ko(14);
      AppMethodBeat.o(290041);
      return i + (paramInt + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(290041);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      h localh = (h)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(290041);
        return -1;
      case 1: 
        localh.ret = locala.ajGk.aar();
        AppMethodBeat.o(290041);
        return 0;
      case 2: 
        localh.hNw = locala.ajGk.readString();
        AppMethodBeat.o(290041);
        return 0;
      case 3: 
        localh.ToG = locala.ajGk.readString();
        AppMethodBeat.o(290041);
        return 0;
      case 4: 
        localh.nickname = locala.ajGk.readString();
        AppMethodBeat.o(290041);
        return 0;
      case 5: 
        localh.sex = locala.ajGk.aar();
        AppMethodBeat.o(290041);
        return 0;
      case 6: 
        localh.province = locala.ajGk.readString();
        AppMethodBeat.o(290041);
        return 0;
      case 7: 
        localh.city = locala.ajGk.readString();
        AppMethodBeat.o(290041);
        return 0;
      case 8: 
        localh.signature = locala.ajGk.readString();
        AppMethodBeat.o(290041);
        return 0;
      case 9: 
        localh.ToH = locala.ajGk.readString();
        AppMethodBeat.o(290041);
        return 0;
      case 10: 
        localh.ToI = locala.ajGk.readString();
        AppMethodBeat.o(290041);
        return 0;
      case 11: 
        localh.ToJ = locala.ajGk.readString();
        AppMethodBeat.o(290041);
        return 0;
      case 12: 
        localh.country = locala.ajGk.readString();
        AppMethodBeat.o(290041);
        return 0;
      case 13: 
        localh.ToK = locala.ajGk.readString();
        AppMethodBeat.o(290041);
        return 0;
      }
      localh.ToL = locala.ajGk.aai();
      AppMethodBeat.o(290041);
      return 0;
    }
    AppMethodBeat.o(290041);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.h
 * JD-Core Version:    0.7.0.1
 */