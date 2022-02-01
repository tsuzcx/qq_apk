package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dkn
  extends com.tencent.mm.bx.a
{
  public int aaQA;
  public String aaQB;
  public int aaQC;
  public int aaQD;
  public String aaQE;
  public int aaQF;
  public int aaQG;
  public String aaQH;
  public String aaQI;
  public String aaQJ;
  public String aaQK;
  public String aaQt;
  public String aaQu;
  public String aaQv;
  public String aaQw;
  public int aaQx;
  public String aaQy;
  public int aaQz;
  public String appid;
  public int group_id;
  public String xlJ;
  public int xlL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152627);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.g(1, this.appid);
      }
      if (this.aaQt != null) {
        paramVarArgs.g(20, this.aaQt);
      }
      if (this.aaQu != null) {
        paramVarArgs.g(21, this.aaQu);
      }
      if (this.aaQv != null) {
        paramVarArgs.g(22, this.aaQv);
      }
      if (this.aaQw != null) {
        paramVarArgs.g(23, this.aaQw);
      }
      if (this.xlJ != null) {
        paramVarArgs.g(31, this.xlJ);
      }
      paramVarArgs.bS(32, this.xlL);
      paramVarArgs.bS(33, this.aaQx);
      if (this.aaQy != null) {
        paramVarArgs.g(34, this.aaQy);
      }
      paramVarArgs.bS(35, this.aaQz);
      paramVarArgs.bS(36, this.aaQA);
      if (this.aaQB != null) {
        paramVarArgs.g(37, this.aaQB);
      }
      paramVarArgs.bS(38, this.aaQC);
      paramVarArgs.bS(39, this.aaQD);
      if (this.aaQE != null) {
        paramVarArgs.g(41, this.aaQE);
      }
      paramVarArgs.bS(200, this.aaQF);
      paramVarArgs.bS(201, this.aaQG);
      paramVarArgs.bS(202, this.group_id);
      if (this.aaQH != null) {
        paramVarArgs.g(203, this.aaQH);
      }
      if (this.aaQI != null) {
        paramVarArgs.g(204, this.aaQI);
      }
      if (this.aaQJ != null) {
        paramVarArgs.g(205, this.aaQJ);
      }
      if (this.aaQK != null) {
        paramVarArgs.g(206, this.aaQK);
      }
      AppMethodBeat.o(152627);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label1458;
      }
    }
    label1458:
    for (int i = i.a.a.b.b.a.h(1, this.appid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaQt != null) {
        paramInt = i + i.a.a.b.b.a.h(20, this.aaQt);
      }
      i = paramInt;
      if (this.aaQu != null) {
        i = paramInt + i.a.a.b.b.a.h(21, this.aaQu);
      }
      paramInt = i;
      if (this.aaQv != null) {
        paramInt = i + i.a.a.b.b.a.h(22, this.aaQv);
      }
      i = paramInt;
      if (this.aaQw != null) {
        i = paramInt + i.a.a.b.b.a.h(23, this.aaQw);
      }
      paramInt = i;
      if (this.xlJ != null) {
        paramInt = i + i.a.a.b.b.a.h(31, this.xlJ);
      }
      i = paramInt + i.a.a.b.b.a.cJ(32, this.xlL) + i.a.a.b.b.a.cJ(33, this.aaQx);
      paramInt = i;
      if (this.aaQy != null) {
        paramInt = i + i.a.a.b.b.a.h(34, this.aaQy);
      }
      i = paramInt + i.a.a.b.b.a.cJ(35, this.aaQz) + i.a.a.b.b.a.cJ(36, this.aaQA);
      paramInt = i;
      if (this.aaQB != null) {
        paramInt = i + i.a.a.b.b.a.h(37, this.aaQB);
      }
      i = paramInt + i.a.a.b.b.a.cJ(38, this.aaQC) + i.a.a.b.b.a.cJ(39, this.aaQD);
      paramInt = i;
      if (this.aaQE != null) {
        paramInt = i + i.a.a.b.b.a.h(41, this.aaQE);
      }
      i = paramInt + i.a.a.b.b.a.cJ(200, this.aaQF) + i.a.a.b.b.a.cJ(201, this.aaQG) + i.a.a.b.b.a.cJ(202, this.group_id);
      paramInt = i;
      if (this.aaQH != null) {
        paramInt = i + i.a.a.b.b.a.h(203, this.aaQH);
      }
      i = paramInt;
      if (this.aaQI != null) {
        i = paramInt + i.a.a.b.b.a.h(204, this.aaQI);
      }
      paramInt = i;
      if (this.aaQJ != null) {
        paramInt = i + i.a.a.b.b.a.h(205, this.aaQJ);
      }
      i = paramInt;
      if (this.aaQK != null) {
        i = paramInt + i.a.a.b.b.a.h(206, this.aaQK);
      }
      AppMethodBeat.o(152627);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152627);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dkn localdkn = (dkn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152627);
          return -1;
        case 1: 
          localdkn.appid = locala.ajGk.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 20: 
          localdkn.aaQt = locala.ajGk.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 21: 
          localdkn.aaQu = locala.ajGk.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 22: 
          localdkn.aaQv = locala.ajGk.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 23: 
          localdkn.aaQw = locala.ajGk.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 31: 
          localdkn.xlJ = locala.ajGk.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 32: 
          localdkn.xlL = locala.ajGk.aar();
          AppMethodBeat.o(152627);
          return 0;
        case 33: 
          localdkn.aaQx = locala.ajGk.aar();
          AppMethodBeat.o(152627);
          return 0;
        case 34: 
          localdkn.aaQy = locala.ajGk.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 35: 
          localdkn.aaQz = locala.ajGk.aar();
          AppMethodBeat.o(152627);
          return 0;
        case 36: 
          localdkn.aaQA = locala.ajGk.aar();
          AppMethodBeat.o(152627);
          return 0;
        case 37: 
          localdkn.aaQB = locala.ajGk.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 38: 
          localdkn.aaQC = locala.ajGk.aar();
          AppMethodBeat.o(152627);
          return 0;
        case 39: 
          localdkn.aaQD = locala.ajGk.aar();
          AppMethodBeat.o(152627);
          return 0;
        case 41: 
          localdkn.aaQE = locala.ajGk.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 200: 
          localdkn.aaQF = locala.ajGk.aar();
          AppMethodBeat.o(152627);
          return 0;
        case 201: 
          localdkn.aaQG = locala.ajGk.aar();
          AppMethodBeat.o(152627);
          return 0;
        case 202: 
          localdkn.group_id = locala.ajGk.aar();
          AppMethodBeat.o(152627);
          return 0;
        case 203: 
          localdkn.aaQH = locala.ajGk.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 204: 
          localdkn.aaQI = locala.ajGk.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 205: 
          localdkn.aaQJ = locala.ajGk.readString();
          AppMethodBeat.o(152627);
          return 0;
        }
        localdkn.aaQK = locala.ajGk.readString();
        AppMethodBeat.o(152627);
        return 0;
      }
      AppMethodBeat.o(152627);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkn
 * JD-Core Version:    0.7.0.1
 */