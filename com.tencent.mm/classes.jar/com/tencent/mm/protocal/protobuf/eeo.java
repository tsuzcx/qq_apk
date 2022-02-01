package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eeo
  extends com.tencent.mm.bx.a
{
  public float MpJ;
  public String abjS;
  public String abjU;
  public String abjV;
  public String abjW;
  public String abjX;
  public String abjY;
  public String abjZ;
  public String abka;
  public String abkb;
  public float abkc;
  public int abkd;
  public String abke;
  public LinkedList<String> abkf;
  public String abkg;
  
  public eeo()
  {
    AppMethodBeat.i(260025);
    this.abkf = new LinkedList();
    AppMethodBeat.o(260025);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260033);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abjU != null) {
        paramVarArgs.g(1, this.abjU);
      }
      paramVarArgs.l(2, this.MpJ);
      if (this.abjV != null) {
        paramVarArgs.g(3, this.abjV);
      }
      if (this.abjW != null) {
        paramVarArgs.g(4, this.abjW);
      }
      if (this.abjS != null) {
        paramVarArgs.g(5, this.abjS);
      }
      if (this.abjX != null) {
        paramVarArgs.g(6, this.abjX);
      }
      if (this.abjY != null) {
        paramVarArgs.g(7, this.abjY);
      }
      if (this.abjZ != null) {
        paramVarArgs.g(8, this.abjZ);
      }
      if (this.abka != null) {
        paramVarArgs.g(9, this.abka);
      }
      if (this.abkb != null) {
        paramVarArgs.g(10, this.abkb);
      }
      paramVarArgs.l(11, this.abkc);
      paramVarArgs.bS(12, this.abkd);
      if (this.abke != null) {
        paramVarArgs.g(13, this.abke);
      }
      paramVarArgs.e(14, 1, this.abkf);
      if (this.abkg != null) {
        paramVarArgs.g(101, this.abkg);
      }
      AppMethodBeat.o(260033);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abjU == null) {
        break label1080;
      }
    }
    label1080:
    for (paramInt = i.a.a.b.b.a.h(1, this.abjU) + 0;; paramInt = 0)
    {
      int i = paramInt + (i.a.a.b.b.a.ko(2) + 4);
      paramInt = i;
      if (this.abjV != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.abjV);
      }
      i = paramInt;
      if (this.abjW != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.abjW);
      }
      paramInt = i;
      if (this.abjS != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.abjS);
      }
      i = paramInt;
      if (this.abjX != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.abjX);
      }
      paramInt = i;
      if (this.abjY != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.abjY);
      }
      i = paramInt;
      if (this.abjZ != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.abjZ);
      }
      paramInt = i;
      if (this.abka != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.abka);
      }
      i = paramInt;
      if (this.abkb != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.abkb);
      }
      i = i + (i.a.a.b.b.a.ko(11) + 4) + i.a.a.b.b.a.cJ(12, this.abkd);
      paramInt = i;
      if (this.abke != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.abke);
      }
      i = paramInt + i.a.a.a.c(14, 1, this.abkf);
      paramInt = i;
      if (this.abkg != null) {
        paramInt = i + i.a.a.b.b.a.h(101, this.abkg);
      }
      AppMethodBeat.o(260033);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abkf.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260033);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        eeo localeeo = (eeo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(260033);
          return -1;
        case 1: 
          localeeo.abjU = locala.ajGk.readString();
          AppMethodBeat.o(260033);
          return 0;
        case 2: 
          localeeo.MpJ = Float.intBitsToFloat(locala.ajGk.aax());
          AppMethodBeat.o(260033);
          return 0;
        case 3: 
          localeeo.abjV = locala.ajGk.readString();
          AppMethodBeat.o(260033);
          return 0;
        case 4: 
          localeeo.abjW = locala.ajGk.readString();
          AppMethodBeat.o(260033);
          return 0;
        case 5: 
          localeeo.abjS = locala.ajGk.readString();
          AppMethodBeat.o(260033);
          return 0;
        case 6: 
          localeeo.abjX = locala.ajGk.readString();
          AppMethodBeat.o(260033);
          return 0;
        case 7: 
          localeeo.abjY = locala.ajGk.readString();
          AppMethodBeat.o(260033);
          return 0;
        case 8: 
          localeeo.abjZ = locala.ajGk.readString();
          AppMethodBeat.o(260033);
          return 0;
        case 9: 
          localeeo.abka = locala.ajGk.readString();
          AppMethodBeat.o(260033);
          return 0;
        case 10: 
          localeeo.abkb = locala.ajGk.readString();
          AppMethodBeat.o(260033);
          return 0;
        case 11: 
          localeeo.abkc = Float.intBitsToFloat(locala.ajGk.aax());
          AppMethodBeat.o(260033);
          return 0;
        case 12: 
          localeeo.abkd = locala.ajGk.aar();
          AppMethodBeat.o(260033);
          return 0;
        case 13: 
          localeeo.abke = locala.ajGk.readString();
          AppMethodBeat.o(260033);
          return 0;
        case 14: 
          localeeo.abkf.add(locala.ajGk.readString());
          AppMethodBeat.o(260033);
          return 0;
        }
        localeeo.abkg = locala.ajGk.readString();
        AppMethodBeat.o(260033);
        return 0;
      }
      AppMethodBeat.o(260033);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eeo
 * JD-Core Version:    0.7.0.1
 */