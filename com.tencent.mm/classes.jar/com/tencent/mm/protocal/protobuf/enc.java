package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class enc
  extends com.tencent.mm.bx.a
{
  public String Wqc;
  public String Zxp;
  public int ablO;
  public String abrA;
  public long abry;
  public int abrz;
  public String appId;
  public String businessId;
  public String cardId;
  public String data;
  public String hRR;
  public int pos;
  public String title;
  public int weight;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259936);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      paramVarArgs.bS(2, this.pos);
      paramVarArgs.bS(3, this.weight);
      paramVarArgs.bv(4, this.abry);
      paramVarArgs.bS(5, this.abrz);
      if (this.businessId != null) {
        paramVarArgs.g(6, this.businessId);
      }
      if (this.cardId != null) {
        paramVarArgs.g(7, this.cardId);
      }
      if (this.data != null) {
        paramVarArgs.g(8, this.data);
      }
      if (this.Zxp != null) {
        paramVarArgs.g(9, this.Zxp);
      }
      if (this.appId != null) {
        paramVarArgs.g(10, this.appId);
      }
      if (this.Wqc != null) {
        paramVarArgs.g(11, this.Wqc);
      }
      if (this.hRR != null) {
        paramVarArgs.g(12, this.hRR);
      }
      if (this.abrA != null) {
        paramVarArgs.g(13, this.abrA);
      }
      paramVarArgs.bS(14, this.ablO);
      AppMethodBeat.o(259936);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label922;
      }
    }
    label922:
    for (paramInt = i.a.a.b.b.a.h(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.pos) + i.a.a.b.b.a.cJ(3, this.weight) + i.a.a.b.b.a.q(4, this.abry) + i.a.a.b.b.a.cJ(5, this.abrz);
      paramInt = i;
      if (this.businessId != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.businessId);
      }
      i = paramInt;
      if (this.cardId != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.cardId);
      }
      paramInt = i;
      if (this.data != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.data);
      }
      i = paramInt;
      if (this.Zxp != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.Zxp);
      }
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.appId);
      }
      i = paramInt;
      if (this.Wqc != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.Wqc);
      }
      paramInt = i;
      if (this.hRR != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.hRR);
      }
      i = paramInt;
      if (this.abrA != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.abrA);
      }
      paramInt = i.a.a.b.b.a.cJ(14, this.ablO);
      AppMethodBeat.o(259936);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259936);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        enc localenc = (enc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259936);
          return -1;
        case 1: 
          localenc.title = locala.ajGk.readString();
          AppMethodBeat.o(259936);
          return 0;
        case 2: 
          localenc.pos = locala.ajGk.aar();
          AppMethodBeat.o(259936);
          return 0;
        case 3: 
          localenc.weight = locala.ajGk.aar();
          AppMethodBeat.o(259936);
          return 0;
        case 4: 
          localenc.abry = locala.ajGk.aaw();
          AppMethodBeat.o(259936);
          return 0;
        case 5: 
          localenc.abrz = locala.ajGk.aar();
          AppMethodBeat.o(259936);
          return 0;
        case 6: 
          localenc.businessId = locala.ajGk.readString();
          AppMethodBeat.o(259936);
          return 0;
        case 7: 
          localenc.cardId = locala.ajGk.readString();
          AppMethodBeat.o(259936);
          return 0;
        case 8: 
          localenc.data = locala.ajGk.readString();
          AppMethodBeat.o(259936);
          return 0;
        case 9: 
          localenc.Zxp = locala.ajGk.readString();
          AppMethodBeat.o(259936);
          return 0;
        case 10: 
          localenc.appId = locala.ajGk.readString();
          AppMethodBeat.o(259936);
          return 0;
        case 11: 
          localenc.Wqc = locala.ajGk.readString();
          AppMethodBeat.o(259936);
          return 0;
        case 12: 
          localenc.hRR = locala.ajGk.readString();
          AppMethodBeat.o(259936);
          return 0;
        case 13: 
          localenc.abrA = locala.ajGk.readString();
          AppMethodBeat.o(259936);
          return 0;
        }
        localenc.ablO = locala.ajGk.aar();
        AppMethodBeat.o(259936);
        return 0;
      }
      AppMethodBeat.o(259936);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.enc
 * JD-Core Version:    0.7.0.1
 */