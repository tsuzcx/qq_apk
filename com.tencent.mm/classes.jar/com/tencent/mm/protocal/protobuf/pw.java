package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class pw
  extends com.tencent.mm.bx.a
{
  public String ADE;
  public String DVu;
  public int YHv;
  public int YSj;
  public int YTA;
  public String YTB;
  public long YTC;
  public int YTD;
  public int YTE;
  public int YTF;
  public int YTG;
  public int YTH;
  public int YTI;
  public int YTJ;
  public long YTK;
  public String YTL;
  public int YTM;
  public String YTN;
  public String YTO;
  public int YTP;
  public String YTQ;
  public int YTR;
  public String YTS;
  public String YTT;
  public int YTU;
  public int YTV;
  public String YTW;
  public long YTX;
  public int YTY;
  public String YTZ;
  public LinkedList<Integer> YTo;
  public int YTp;
  public int YTq;
  public int YTr;
  public int YTs;
  public int YTt;
  public int YTu;
  public int YTv;
  public int YTw;
  public int YTx;
  public int YTy;
  public int YTz;
  public String YUa;
  public int YUb;
  public String aid;
  public int cancel;
  public String event;
  public long hCz;
  public String iaI;
  public int msg_type;
  public int pos;
  public int style;
  public int tNW;
  public String traceid;
  public int weight;
  public String wtD;
  
  public pw()
  {
    AppMethodBeat.i(6398);
    this.YTo = new LinkedList();
    this.tNW = 0;
    this.YUb = 0;
    AppMethodBeat.o(6398);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6399);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ADE != null) {
        paramVarArgs.g(1, this.ADE);
      }
      paramVarArgs.bv(2, this.hCz);
      paramVarArgs.bS(3, this.pos);
      paramVarArgs.e(4, 2, this.YTo);
      paramVarArgs.bS(5, this.YTp);
      paramVarArgs.bS(6, this.YTq);
      paramVarArgs.bS(7, this.YTr);
      paramVarArgs.bS(8, this.YTs);
      paramVarArgs.bS(9, this.YTt);
      paramVarArgs.bS(10, this.YTu);
      paramVarArgs.bS(11, this.YSj);
      paramVarArgs.bS(12, this.YTv);
      paramVarArgs.bS(13, this.YTw);
      paramVarArgs.bS(14, this.cancel);
      paramVarArgs.bS(15, this.YTx);
      paramVarArgs.bS(16, this.YTy);
      paramVarArgs.bS(17, this.YTz);
      paramVarArgs.bS(18, this.YTA);
      paramVarArgs.bS(19, this.msg_type);
      if (this.YTB != null) {
        paramVarArgs.g(20, this.YTB);
      }
      paramVarArgs.bv(21, this.YTC);
      paramVarArgs.bS(22, this.YTD);
      paramVarArgs.bS(23, this.YTE);
      paramVarArgs.bS(24, this.YTF);
      paramVarArgs.bS(25, this.YTG);
      paramVarArgs.bS(26, this.YTH);
      paramVarArgs.bS(27, this.YTI);
      paramVarArgs.bS(28, this.YTJ);
      paramVarArgs.bS(29, this.tNW);
      paramVarArgs.bv(30, this.YTK);
      if (this.YTL != null) {
        paramVarArgs.g(31, this.YTL);
      }
      paramVarArgs.bS(32, this.YTM);
      paramVarArgs.bS(33, this.weight);
      if (this.YTN != null) {
        paramVarArgs.g(34, this.YTN);
      }
      paramVarArgs.bS(35, this.style);
      if (this.YTO != null) {
        paramVarArgs.g(36, this.YTO);
      }
      if (this.event != null) {
        paramVarArgs.g(37, this.event);
      }
      if (this.iaI != null) {
        paramVarArgs.g(38, this.iaI);
      }
      paramVarArgs.bS(39, this.YTP);
      if (this.YTQ != null) {
        paramVarArgs.g(40, this.YTQ);
      }
      if (this.aid != null) {
        paramVarArgs.g(41, this.aid);
      }
      if (this.traceid != null) {
        paramVarArgs.g(42, this.traceid);
      }
      paramVarArgs.bS(43, this.YTR);
      if (this.DVu != null) {
        paramVarArgs.g(44, this.DVu);
      }
      if (this.YTS != null) {
        paramVarArgs.g(45, this.YTS);
      }
      if (this.YTT != null) {
        paramVarArgs.g(46, this.YTT);
      }
      paramVarArgs.bS(47, this.YTU);
      paramVarArgs.bS(48, this.YTV);
      if (this.wtD != null) {
        paramVarArgs.g(49, this.wtD);
      }
      if (this.YTW != null) {
        paramVarArgs.g(50, this.YTW);
      }
      paramVarArgs.bv(51, this.YTX);
      paramVarArgs.bS(52, this.YTY);
      paramVarArgs.bS(53, this.YHv);
      if (this.YTZ != null) {
        paramVarArgs.g(54, this.YTZ);
      }
      if (this.YUa != null) {
        paramVarArgs.g(57, this.YUa);
      }
      paramVarArgs.bS(58, this.YUb);
      AppMethodBeat.o(6399);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ADE == null) {
        break label3019;
      }
    }
    label3019:
    for (paramInt = i.a.a.b.b.a.h(1, this.ADE) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.hCz) + i.a.a.b.b.a.cJ(3, this.pos) + i.a.a.a.c(4, 2, this.YTo) + i.a.a.b.b.a.cJ(5, this.YTp) + i.a.a.b.b.a.cJ(6, this.YTq) + i.a.a.b.b.a.cJ(7, this.YTr) + i.a.a.b.b.a.cJ(8, this.YTs) + i.a.a.b.b.a.cJ(9, this.YTt) + i.a.a.b.b.a.cJ(10, this.YTu) + i.a.a.b.b.a.cJ(11, this.YSj) + i.a.a.b.b.a.cJ(12, this.YTv) + i.a.a.b.b.a.cJ(13, this.YTw) + i.a.a.b.b.a.cJ(14, this.cancel) + i.a.a.b.b.a.cJ(15, this.YTx) + i.a.a.b.b.a.cJ(16, this.YTy) + i.a.a.b.b.a.cJ(17, this.YTz) + i.a.a.b.b.a.cJ(18, this.YTA) + i.a.a.b.b.a.cJ(19, this.msg_type);
      paramInt = i;
      if (this.YTB != null) {
        paramInt = i + i.a.a.b.b.a.h(20, this.YTB);
      }
      i = paramInt + i.a.a.b.b.a.q(21, this.YTC) + i.a.a.b.b.a.cJ(22, this.YTD) + i.a.a.b.b.a.cJ(23, this.YTE) + i.a.a.b.b.a.cJ(24, this.YTF) + i.a.a.b.b.a.cJ(25, this.YTG) + i.a.a.b.b.a.cJ(26, this.YTH) + i.a.a.b.b.a.cJ(27, this.YTI) + i.a.a.b.b.a.cJ(28, this.YTJ) + i.a.a.b.b.a.cJ(29, this.tNW) + i.a.a.b.b.a.q(30, this.YTK);
      paramInt = i;
      if (this.YTL != null) {
        paramInt = i + i.a.a.b.b.a.h(31, this.YTL);
      }
      i = paramInt + i.a.a.b.b.a.cJ(32, this.YTM) + i.a.a.b.b.a.cJ(33, this.weight);
      paramInt = i;
      if (this.YTN != null) {
        paramInt = i + i.a.a.b.b.a.h(34, this.YTN);
      }
      i = paramInt + i.a.a.b.b.a.cJ(35, this.style);
      paramInt = i;
      if (this.YTO != null) {
        paramInt = i + i.a.a.b.b.a.h(36, this.YTO);
      }
      i = paramInt;
      if (this.event != null) {
        i = paramInt + i.a.a.b.b.a.h(37, this.event);
      }
      paramInt = i;
      if (this.iaI != null) {
        paramInt = i + i.a.a.b.b.a.h(38, this.iaI);
      }
      i = paramInt + i.a.a.b.b.a.cJ(39, this.YTP);
      paramInt = i;
      if (this.YTQ != null) {
        paramInt = i + i.a.a.b.b.a.h(40, this.YTQ);
      }
      i = paramInt;
      if (this.aid != null) {
        i = paramInt + i.a.a.b.b.a.h(41, this.aid);
      }
      paramInt = i;
      if (this.traceid != null) {
        paramInt = i + i.a.a.b.b.a.h(42, this.traceid);
      }
      i = paramInt + i.a.a.b.b.a.cJ(43, this.YTR);
      paramInt = i;
      if (this.DVu != null) {
        paramInt = i + i.a.a.b.b.a.h(44, this.DVu);
      }
      i = paramInt;
      if (this.YTS != null) {
        i = paramInt + i.a.a.b.b.a.h(45, this.YTS);
      }
      paramInt = i;
      if (this.YTT != null) {
        paramInt = i + i.a.a.b.b.a.h(46, this.YTT);
      }
      i = paramInt + i.a.a.b.b.a.cJ(47, this.YTU) + i.a.a.b.b.a.cJ(48, this.YTV);
      paramInt = i;
      if (this.wtD != null) {
        paramInt = i + i.a.a.b.b.a.h(49, this.wtD);
      }
      i = paramInt;
      if (this.YTW != null) {
        i = paramInt + i.a.a.b.b.a.h(50, this.YTW);
      }
      i = i + i.a.a.b.b.a.q(51, this.YTX) + i.a.a.b.b.a.cJ(52, this.YTY) + i.a.a.b.b.a.cJ(53, this.YHv);
      paramInt = i;
      if (this.YTZ != null) {
        paramInt = i + i.a.a.b.b.a.h(54, this.YTZ);
      }
      i = paramInt;
      if (this.YUa != null) {
        i = paramInt + i.a.a.b.b.a.h(57, this.YUa);
      }
      paramInt = i.a.a.b.b.a.cJ(58, this.YUb);
      AppMethodBeat.o(6399);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YTo.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(6399);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        pw localpw = (pw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 55: 
        case 56: 
        default: 
          AppMethodBeat.o(6399);
          return -1;
        case 1: 
          localpw.ADE = locala.ajGk.readString();
          AppMethodBeat.o(6399);
          return 0;
        case 2: 
          localpw.hCz = locala.ajGk.aaw();
          AppMethodBeat.o(6399);
          return 0;
        case 3: 
          localpw.pos = locala.ajGk.aar();
          AppMethodBeat.o(6399);
          return 0;
        case 4: 
          localpw.YTo.add(Integer.valueOf(locala.ajGk.aar()));
          AppMethodBeat.o(6399);
          return 0;
        case 5: 
          localpw.YTp = locala.ajGk.aar();
          AppMethodBeat.o(6399);
          return 0;
        case 6: 
          localpw.YTq = locala.ajGk.aar();
          AppMethodBeat.o(6399);
          return 0;
        case 7: 
          localpw.YTr = locala.ajGk.aar();
          AppMethodBeat.o(6399);
          return 0;
        case 8: 
          localpw.YTs = locala.ajGk.aar();
          AppMethodBeat.o(6399);
          return 0;
        case 9: 
          localpw.YTt = locala.ajGk.aar();
          AppMethodBeat.o(6399);
          return 0;
        case 10: 
          localpw.YTu = locala.ajGk.aar();
          AppMethodBeat.o(6399);
          return 0;
        case 11: 
          localpw.YSj = locala.ajGk.aar();
          AppMethodBeat.o(6399);
          return 0;
        case 12: 
          localpw.YTv = locala.ajGk.aar();
          AppMethodBeat.o(6399);
          return 0;
        case 13: 
          localpw.YTw = locala.ajGk.aar();
          AppMethodBeat.o(6399);
          return 0;
        case 14: 
          localpw.cancel = locala.ajGk.aar();
          AppMethodBeat.o(6399);
          return 0;
        case 15: 
          localpw.YTx = locala.ajGk.aar();
          AppMethodBeat.o(6399);
          return 0;
        case 16: 
          localpw.YTy = locala.ajGk.aar();
          AppMethodBeat.o(6399);
          return 0;
        case 17: 
          localpw.YTz = locala.ajGk.aar();
          AppMethodBeat.o(6399);
          return 0;
        case 18: 
          localpw.YTA = locala.ajGk.aar();
          AppMethodBeat.o(6399);
          return 0;
        case 19: 
          localpw.msg_type = locala.ajGk.aar();
          AppMethodBeat.o(6399);
          return 0;
        case 20: 
          localpw.YTB = locala.ajGk.readString();
          AppMethodBeat.o(6399);
          return 0;
        case 21: 
          localpw.YTC = locala.ajGk.aaw();
          AppMethodBeat.o(6399);
          return 0;
        case 22: 
          localpw.YTD = locala.ajGk.aar();
          AppMethodBeat.o(6399);
          return 0;
        case 23: 
          localpw.YTE = locala.ajGk.aar();
          AppMethodBeat.o(6399);
          return 0;
        case 24: 
          localpw.YTF = locala.ajGk.aar();
          AppMethodBeat.o(6399);
          return 0;
        case 25: 
          localpw.YTG = locala.ajGk.aar();
          AppMethodBeat.o(6399);
          return 0;
        case 26: 
          localpw.YTH = locala.ajGk.aar();
          AppMethodBeat.o(6399);
          return 0;
        case 27: 
          localpw.YTI = locala.ajGk.aar();
          AppMethodBeat.o(6399);
          return 0;
        case 28: 
          localpw.YTJ = locala.ajGk.aar();
          AppMethodBeat.o(6399);
          return 0;
        case 29: 
          localpw.tNW = locala.ajGk.aar();
          AppMethodBeat.o(6399);
          return 0;
        case 30: 
          localpw.YTK = locala.ajGk.aaw();
          AppMethodBeat.o(6399);
          return 0;
        case 31: 
          localpw.YTL = locala.ajGk.readString();
          AppMethodBeat.o(6399);
          return 0;
        case 32: 
          localpw.YTM = locala.ajGk.aar();
          AppMethodBeat.o(6399);
          return 0;
        case 33: 
          localpw.weight = locala.ajGk.aar();
          AppMethodBeat.o(6399);
          return 0;
        case 34: 
          localpw.YTN = locala.ajGk.readString();
          AppMethodBeat.o(6399);
          return 0;
        case 35: 
          localpw.style = locala.ajGk.aar();
          AppMethodBeat.o(6399);
          return 0;
        case 36: 
          localpw.YTO = locala.ajGk.readString();
          AppMethodBeat.o(6399);
          return 0;
        case 37: 
          localpw.event = locala.ajGk.readString();
          AppMethodBeat.o(6399);
          return 0;
        case 38: 
          localpw.iaI = locala.ajGk.readString();
          AppMethodBeat.o(6399);
          return 0;
        case 39: 
          localpw.YTP = locala.ajGk.aar();
          AppMethodBeat.o(6399);
          return 0;
        case 40: 
          localpw.YTQ = locala.ajGk.readString();
          AppMethodBeat.o(6399);
          return 0;
        case 41: 
          localpw.aid = locala.ajGk.readString();
          AppMethodBeat.o(6399);
          return 0;
        case 42: 
          localpw.traceid = locala.ajGk.readString();
          AppMethodBeat.o(6399);
          return 0;
        case 43: 
          localpw.YTR = locala.ajGk.aar();
          AppMethodBeat.o(6399);
          return 0;
        case 44: 
          localpw.DVu = locala.ajGk.readString();
          AppMethodBeat.o(6399);
          return 0;
        case 45: 
          localpw.YTS = locala.ajGk.readString();
          AppMethodBeat.o(6399);
          return 0;
        case 46: 
          localpw.YTT = locala.ajGk.readString();
          AppMethodBeat.o(6399);
          return 0;
        case 47: 
          localpw.YTU = locala.ajGk.aar();
          AppMethodBeat.o(6399);
          return 0;
        case 48: 
          localpw.YTV = locala.ajGk.aar();
          AppMethodBeat.o(6399);
          return 0;
        case 49: 
          localpw.wtD = locala.ajGk.readString();
          AppMethodBeat.o(6399);
          return 0;
        case 50: 
          localpw.YTW = locala.ajGk.readString();
          AppMethodBeat.o(6399);
          return 0;
        case 51: 
          localpw.YTX = locala.ajGk.aaw();
          AppMethodBeat.o(6399);
          return 0;
        case 52: 
          localpw.YTY = locala.ajGk.aar();
          AppMethodBeat.o(6399);
          return 0;
        case 53: 
          localpw.YHv = locala.ajGk.aar();
          AppMethodBeat.o(6399);
          return 0;
        case 54: 
          localpw.YTZ = locala.ajGk.readString();
          AppMethodBeat.o(6399);
          return 0;
        case 57: 
          localpw.YUa = locala.ajGk.readString();
          AppMethodBeat.o(6399);
          return 0;
        }
        localpw.YUb = locala.ajGk.aar();
        AppMethodBeat.o(6399);
        return 0;
      }
      AppMethodBeat.o(6399);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pw
 * JD-Core Version:    0.7.0.1
 */