package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class bui
  extends com.tencent.mm.bx.a
{
  public long ADF;
  public int AJo;
  public String DUN;
  public int FuA;
  public String GSR;
  public String GSS;
  public int GST;
  public int GSU;
  public String GSV;
  public String GSW;
  public boolean GSX;
  public String extraInfo;
  public int hJx;
  public int hLK;
  public String sessionId;
  public String zIB;
  public String zIE;
  public String zIO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259175);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.sessionId != null) {
        paramVarArgs.g(1, this.sessionId);
      }
      if (this.zIO != null) {
        paramVarArgs.g(2, this.zIO);
      }
      if (this.zIB != null) {
        paramVarArgs.g(3, this.zIB);
      }
      if (this.GSR != null) {
        paramVarArgs.g(4, this.GSR);
      }
      paramVarArgs.bS(5, this.FuA);
      paramVarArgs.bS(6, this.AJo);
      paramVarArgs.bv(7, this.ADF);
      paramVarArgs.bS(8, this.hLK);
      paramVarArgs.bS(9, this.GST);
      if (this.GSV != null) {
        paramVarArgs.g(10, this.GSV);
      }
      paramVarArgs.bS(11, this.GSU);
      if (this.extraInfo != null) {
        paramVarArgs.g(12, this.extraInfo);
      }
      if (this.zIE != null) {
        paramVarArgs.g(13, this.zIE);
      }
      paramVarArgs.di(14, this.GSX);
      paramVarArgs.bS(15, this.hJx);
      if (this.GSS != null) {
        paramVarArgs.g(16, this.GSS);
      }
      if (this.DUN != null) {
        paramVarArgs.g(17, this.DUN);
      }
      if (this.GSW != null) {
        paramVarArgs.g(18, this.GSW);
      }
      AppMethodBeat.o(259175);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sessionId == null) {
        break label1118;
      }
    }
    label1118:
    for (int i = i.a.a.b.b.a.h(1, this.sessionId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.zIO != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.zIO);
      }
      i = paramInt;
      if (this.zIB != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.zIB);
      }
      paramInt = i;
      if (this.GSR != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.GSR);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.FuA) + i.a.a.b.b.a.cJ(6, this.AJo) + i.a.a.b.b.a.q(7, this.ADF) + i.a.a.b.b.a.cJ(8, this.hLK) + i.a.a.b.b.a.cJ(9, this.GST);
      paramInt = i;
      if (this.GSV != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.GSV);
      }
      i = paramInt + i.a.a.b.b.a.cJ(11, this.GSU);
      paramInt = i;
      if (this.extraInfo != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.extraInfo);
      }
      i = paramInt;
      if (this.zIE != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.zIE);
      }
      i = i + (i.a.a.b.b.a.ko(14) + 1) + i.a.a.b.b.a.cJ(15, this.hJx);
      paramInt = i;
      if (this.GSS != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.GSS);
      }
      i = paramInt;
      if (this.DUN != null) {
        i = paramInt + i.a.a.b.b.a.h(17, this.DUN);
      }
      paramInt = i;
      if (this.GSW != null) {
        paramInt = i + i.a.a.b.b.a.h(18, this.GSW);
      }
      AppMethodBeat.o(259175);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259175);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bui localbui = (bui)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259175);
          return -1;
        case 1: 
          localbui.sessionId = locala.ajGk.readString();
          AppMethodBeat.o(259175);
          return 0;
        case 2: 
          localbui.zIO = locala.ajGk.readString();
          AppMethodBeat.o(259175);
          return 0;
        case 3: 
          localbui.zIB = locala.ajGk.readString();
          AppMethodBeat.o(259175);
          return 0;
        case 4: 
          localbui.GSR = locala.ajGk.readString();
          AppMethodBeat.o(259175);
          return 0;
        case 5: 
          localbui.FuA = locala.ajGk.aar();
          AppMethodBeat.o(259175);
          return 0;
        case 6: 
          localbui.AJo = locala.ajGk.aar();
          AppMethodBeat.o(259175);
          return 0;
        case 7: 
          localbui.ADF = locala.ajGk.aaw();
          AppMethodBeat.o(259175);
          return 0;
        case 8: 
          localbui.hLK = locala.ajGk.aar();
          AppMethodBeat.o(259175);
          return 0;
        case 9: 
          localbui.GST = locala.ajGk.aar();
          AppMethodBeat.o(259175);
          return 0;
        case 10: 
          localbui.GSV = locala.ajGk.readString();
          AppMethodBeat.o(259175);
          return 0;
        case 11: 
          localbui.GSU = locala.ajGk.aar();
          AppMethodBeat.o(259175);
          return 0;
        case 12: 
          localbui.extraInfo = locala.ajGk.readString();
          AppMethodBeat.o(259175);
          return 0;
        case 13: 
          localbui.zIE = locala.ajGk.readString();
          AppMethodBeat.o(259175);
          return 0;
        case 14: 
          localbui.GSX = locala.ajGk.aai();
          AppMethodBeat.o(259175);
          return 0;
        case 15: 
          localbui.hJx = locala.ajGk.aar();
          AppMethodBeat.o(259175);
          return 0;
        case 16: 
          localbui.GSS = locala.ajGk.readString();
          AppMethodBeat.o(259175);
          return 0;
        case 17: 
          localbui.DUN = locala.ajGk.readString();
          AppMethodBeat.o(259175);
          return 0;
        }
        localbui.GSW = locala.ajGk.readString();
        AppMethodBeat.o(259175);
        return 0;
      }
      AppMethodBeat.o(259175);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bui
 * JD-Core Version:    0.7.0.1
 */