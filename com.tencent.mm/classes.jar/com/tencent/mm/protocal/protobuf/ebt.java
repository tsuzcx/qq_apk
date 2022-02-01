package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ebt
  extends com.tencent.mm.bx.a
{
  public String VGA;
  public String VHT;
  public long VIA;
  public long VIB;
  public long VIC;
  public int VID;
  public int VIE;
  public long VIF;
  public String VQT;
  public String abhn;
  public String abho;
  public String abhp;
  public int abhq;
  public String icon;
  public String title;
  public String type;
  public String url;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91578);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.g(1, this.url);
      }
      if (this.wording != null) {
        paramVarArgs.g(2, this.wording);
      }
      if (this.icon != null) {
        paramVarArgs.g(3, this.icon);
      }
      if (this.VQT != null) {
        paramVarArgs.g(4, this.VQT);
      }
      if (this.VHT != null) {
        paramVarArgs.g(5, this.VHT);
      }
      if (this.abhn != null) {
        paramVarArgs.g(6, this.abhn);
      }
      if (this.type != null) {
        paramVarArgs.g(7, this.type);
      }
      if (this.title != null) {
        paramVarArgs.g(8, this.title);
      }
      paramVarArgs.bv(9, this.VIA);
      paramVarArgs.bv(10, this.VIB);
      if (this.VGA != null) {
        paramVarArgs.g(11, this.VGA);
      }
      paramVarArgs.bv(12, this.VIC);
      paramVarArgs.bS(13, this.VID);
      paramVarArgs.bS(14, this.VIE);
      if (this.abho != null) {
        paramVarArgs.g(15, this.abho);
      }
      if (this.abhp != null) {
        paramVarArgs.g(16, this.abhp);
      }
      paramVarArgs.bv(17, this.VIF);
      paramVarArgs.bS(18, this.abhq);
      AppMethodBeat.o(91578);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label1142;
      }
    }
    label1142:
    for (int i = i.a.a.b.b.a.h(1, this.url) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.wording);
      }
      i = paramInt;
      if (this.icon != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.icon);
      }
      paramInt = i;
      if (this.VQT != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.VQT);
      }
      i = paramInt;
      if (this.VHT != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.VHT);
      }
      paramInt = i;
      if (this.abhn != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abhn);
      }
      i = paramInt;
      if (this.type != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.type);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.title);
      }
      i = paramInt + i.a.a.b.b.a.q(9, this.VIA) + i.a.a.b.b.a.q(10, this.VIB);
      paramInt = i;
      if (this.VGA != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.VGA);
      }
      i = paramInt + i.a.a.b.b.a.q(12, this.VIC) + i.a.a.b.b.a.cJ(13, this.VID) + i.a.a.b.b.a.cJ(14, this.VIE);
      paramInt = i;
      if (this.abho != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.abho);
      }
      i = paramInt;
      if (this.abhp != null) {
        i = paramInt + i.a.a.b.b.a.h(16, this.abhp);
      }
      paramInt = i.a.a.b.b.a.q(17, this.VIF);
      int j = i.a.a.b.b.a.cJ(18, this.abhq);
      AppMethodBeat.o(91578);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91578);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ebt localebt = (ebt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91578);
          return -1;
        case 1: 
          localebt.url = locala.ajGk.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 2: 
          localebt.wording = locala.ajGk.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 3: 
          localebt.icon = locala.ajGk.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 4: 
          localebt.VQT = locala.ajGk.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 5: 
          localebt.VHT = locala.ajGk.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 6: 
          localebt.abhn = locala.ajGk.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 7: 
          localebt.type = locala.ajGk.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 8: 
          localebt.title = locala.ajGk.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 9: 
          localebt.VIA = locala.ajGk.aaw();
          AppMethodBeat.o(91578);
          return 0;
        case 10: 
          localebt.VIB = locala.ajGk.aaw();
          AppMethodBeat.o(91578);
          return 0;
        case 11: 
          localebt.VGA = locala.ajGk.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 12: 
          localebt.VIC = locala.ajGk.aaw();
          AppMethodBeat.o(91578);
          return 0;
        case 13: 
          localebt.VID = locala.ajGk.aar();
          AppMethodBeat.o(91578);
          return 0;
        case 14: 
          localebt.VIE = locala.ajGk.aar();
          AppMethodBeat.o(91578);
          return 0;
        case 15: 
          localebt.abho = locala.ajGk.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 16: 
          localebt.abhp = locala.ajGk.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 17: 
          localebt.VIF = locala.ajGk.aaw();
          AppMethodBeat.o(91578);
          return 0;
        }
        localebt.abhq = locala.ajGk.aar();
        AppMethodBeat.o(91578);
        return 0;
      }
      AppMethodBeat.o(91578);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebt
 * JD-Core Version:    0.7.0.1
 */