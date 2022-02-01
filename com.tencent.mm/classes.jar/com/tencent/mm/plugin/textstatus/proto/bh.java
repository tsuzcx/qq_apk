package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bh
  extends com.tencent.mm.bx.a
{
  public long GdW;
  public long Toi;
  public int Toj;
  public int Tok;
  public String Ton;
  public String TqA;
  public String TqB;
  public long TqC;
  public long TqD;
  public long TqE;
  public long TqF;
  public long TqG;
  public long TqH;
  public long TqI;
  public long TqJ;
  public long TqK;
  public long TqL;
  public long TqM;
  public long TqN;
  public int TqO;
  public long TqP;
  public long TqQ;
  public long TqR;
  public int TqS;
  public String TqT;
  public int TqU;
  public int TqV;
  public String TqW;
  public String TqX;
  public String TqY;
  public String TqZ;
  public String Tqq;
  public LinkedList<String> Tqs;
  public String Tqt;
  public String Tqu;
  public long Tqv;
  public long Tqw;
  public long Tqx;
  public long Tqy;
  public long Tqz;
  public long Tra;
  public long Trb;
  public int Trc;
  public int Trd;
  public int Tre;
  public int Trf;
  public int Trg;
  public int Trh;
  public String Tri;
  public String Trj;
  public String Trk;
  public long Trl;
  public int enterScene;
  public long enterTime;
  public int hQg;
  public String sessionId;
  public String sourceIcon;
  public String sourceName;
  
  public bh()
  {
    AppMethodBeat.i(289923);
    this.Tqs = new LinkedList();
    AppMethodBeat.o(289923);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(289971);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Tqq != null) {
        paramVarArgs.g(1, this.Tqq);
      }
      paramVarArgs.bS(2, this.enterScene);
      paramVarArgs.bS(3, this.hQg);
      paramVarArgs.bv(4, this.enterTime);
      paramVarArgs.bv(5, this.GdW);
      paramVarArgs.e(6, 1, this.Tqs);
      if (this.Tqt != null) {
        paramVarArgs.g(7, this.Tqt);
      }
      if (this.Tqu != null) {
        paramVarArgs.g(8, this.Tqu);
      }
      paramVarArgs.bv(9, this.Tqv);
      paramVarArgs.bv(10, this.Tqw);
      paramVarArgs.bv(11, this.Tqx);
      paramVarArgs.bv(12, this.Tqy);
      paramVarArgs.bv(13, this.Tqz);
      if (this.TqA != null) {
        paramVarArgs.g(14, this.TqA);
      }
      if (this.TqB != null) {
        paramVarArgs.g(15, this.TqB);
      }
      if (this.sourceName != null) {
        paramVarArgs.g(16, this.sourceName);
      }
      if (this.sourceIcon != null) {
        paramVarArgs.g(17, this.sourceIcon);
      }
      paramVarArgs.bv(18, this.TqC);
      paramVarArgs.bv(19, this.TqD);
      paramVarArgs.bv(20, this.TqE);
      paramVarArgs.bv(21, this.TqF);
      paramVarArgs.bv(22, this.TqG);
      paramVarArgs.bv(23, this.TqH);
      paramVarArgs.bv(24, this.TqI);
      paramVarArgs.bv(25, this.TqJ);
      paramVarArgs.bv(26, this.TqK);
      paramVarArgs.bv(27, this.TqL);
      paramVarArgs.bv(28, this.TqM);
      paramVarArgs.bv(29, this.TqN);
      paramVarArgs.bS(30, this.TqO);
      paramVarArgs.bv(31, this.TqP);
      paramVarArgs.bv(32, this.TqQ);
      paramVarArgs.bv(33, this.TqR);
      if (this.sessionId != null) {
        paramVarArgs.g(34, this.sessionId);
      }
      paramVarArgs.bv(35, this.Toi);
      paramVarArgs.bS(36, this.Toj);
      paramVarArgs.bS(37, this.Tok);
      paramVarArgs.bS(38, this.TqS);
      if (this.TqT != null) {
        paramVarArgs.g(39, this.TqT);
      }
      paramVarArgs.bS(40, this.TqU);
      paramVarArgs.bS(41, this.TqV);
      if (this.TqW != null) {
        paramVarArgs.g(42, this.TqW);
      }
      if (this.TqX != null) {
        paramVarArgs.g(43, this.TqX);
      }
      if (this.TqY != null) {
        paramVarArgs.g(44, this.TqY);
      }
      if (this.TqZ != null) {
        paramVarArgs.g(45, this.TqZ);
      }
      paramVarArgs.bv(46, this.Tra);
      paramVarArgs.bv(47, this.Trb);
      if (this.Ton != null) {
        paramVarArgs.g(48, this.Ton);
      }
      paramVarArgs.bS(49, this.Trc);
      paramVarArgs.bS(50, this.Trd);
      paramVarArgs.bS(51, this.Tre);
      paramVarArgs.bS(52, this.Trf);
      paramVarArgs.bS(53, this.Trg);
      paramVarArgs.bS(54, this.Trh);
      if (this.Tri != null) {
        paramVarArgs.g(55, this.Tri);
      }
      if (this.Trj != null) {
        paramVarArgs.g(56, this.Trj);
      }
      if (this.Trk != null) {
        paramVarArgs.g(57, this.Trk);
      }
      paramVarArgs.bv(58, this.Trl);
      AppMethodBeat.o(289971);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Tqq == null) {
        break label3030;
      }
    }
    label3030:
    for (paramInt = i.a.a.b.b.a.h(1, this.Tqq) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.enterScene) + i.a.a.b.b.a.cJ(3, this.hQg) + i.a.a.b.b.a.q(4, this.enterTime) + i.a.a.b.b.a.q(5, this.GdW) + i.a.a.a.c(6, 1, this.Tqs);
      paramInt = i;
      if (this.Tqt != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.Tqt);
      }
      i = paramInt;
      if (this.Tqu != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.Tqu);
      }
      i = i + i.a.a.b.b.a.q(9, this.Tqv) + i.a.a.b.b.a.q(10, this.Tqw) + i.a.a.b.b.a.q(11, this.Tqx) + i.a.a.b.b.a.q(12, this.Tqy) + i.a.a.b.b.a.q(13, this.Tqz);
      paramInt = i;
      if (this.TqA != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.TqA);
      }
      i = paramInt;
      if (this.TqB != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.TqB);
      }
      paramInt = i;
      if (this.sourceName != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.sourceName);
      }
      i = paramInt;
      if (this.sourceIcon != null) {
        i = paramInt + i.a.a.b.b.a.h(17, this.sourceIcon);
      }
      i = i + i.a.a.b.b.a.q(18, this.TqC) + i.a.a.b.b.a.q(19, this.TqD) + i.a.a.b.b.a.q(20, this.TqE) + i.a.a.b.b.a.q(21, this.TqF) + i.a.a.b.b.a.q(22, this.TqG) + i.a.a.b.b.a.q(23, this.TqH) + i.a.a.b.b.a.q(24, this.TqI) + i.a.a.b.b.a.q(25, this.TqJ) + i.a.a.b.b.a.q(26, this.TqK) + i.a.a.b.b.a.q(27, this.TqL) + i.a.a.b.b.a.q(28, this.TqM) + i.a.a.b.b.a.q(29, this.TqN) + i.a.a.b.b.a.cJ(30, this.TqO) + i.a.a.b.b.a.q(31, this.TqP) + i.a.a.b.b.a.q(32, this.TqQ) + i.a.a.b.b.a.q(33, this.TqR);
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + i.a.a.b.b.a.h(34, this.sessionId);
      }
      i = paramInt + i.a.a.b.b.a.q(35, this.Toi) + i.a.a.b.b.a.cJ(36, this.Toj) + i.a.a.b.b.a.cJ(37, this.Tok) + i.a.a.b.b.a.cJ(38, this.TqS);
      paramInt = i;
      if (this.TqT != null) {
        paramInt = i + i.a.a.b.b.a.h(39, this.TqT);
      }
      i = paramInt + i.a.a.b.b.a.cJ(40, this.TqU) + i.a.a.b.b.a.cJ(41, this.TqV);
      paramInt = i;
      if (this.TqW != null) {
        paramInt = i + i.a.a.b.b.a.h(42, this.TqW);
      }
      i = paramInt;
      if (this.TqX != null) {
        i = paramInt + i.a.a.b.b.a.h(43, this.TqX);
      }
      paramInt = i;
      if (this.TqY != null) {
        paramInt = i + i.a.a.b.b.a.h(44, this.TqY);
      }
      i = paramInt;
      if (this.TqZ != null) {
        i = paramInt + i.a.a.b.b.a.h(45, this.TqZ);
      }
      i = i + i.a.a.b.b.a.q(46, this.Tra) + i.a.a.b.b.a.q(47, this.Trb);
      paramInt = i;
      if (this.Ton != null) {
        paramInt = i + i.a.a.b.b.a.h(48, this.Ton);
      }
      i = paramInt + i.a.a.b.b.a.cJ(49, this.Trc) + i.a.a.b.b.a.cJ(50, this.Trd) + i.a.a.b.b.a.cJ(51, this.Tre) + i.a.a.b.b.a.cJ(52, this.Trf) + i.a.a.b.b.a.cJ(53, this.Trg) + i.a.a.b.b.a.cJ(54, this.Trh);
      paramInt = i;
      if (this.Tri != null) {
        paramInt = i + i.a.a.b.b.a.h(55, this.Tri);
      }
      i = paramInt;
      if (this.Trj != null) {
        i = paramInt + i.a.a.b.b.a.h(56, this.Trj);
      }
      paramInt = i;
      if (this.Trk != null) {
        paramInt = i + i.a.a.b.b.a.h(57, this.Trk);
      }
      i = i.a.a.b.b.a.q(58, this.Trl);
      AppMethodBeat.o(289971);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Tqs.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(289971);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bh localbh = (bh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(289971);
          return -1;
        case 1: 
          localbh.Tqq = locala.ajGk.readString();
          AppMethodBeat.o(289971);
          return 0;
        case 2: 
          localbh.enterScene = locala.ajGk.aar();
          AppMethodBeat.o(289971);
          return 0;
        case 3: 
          localbh.hQg = locala.ajGk.aar();
          AppMethodBeat.o(289971);
          return 0;
        case 4: 
          localbh.enterTime = locala.ajGk.aaw();
          AppMethodBeat.o(289971);
          return 0;
        case 5: 
          localbh.GdW = locala.ajGk.aaw();
          AppMethodBeat.o(289971);
          return 0;
        case 6: 
          localbh.Tqs.add(locala.ajGk.readString());
          AppMethodBeat.o(289971);
          return 0;
        case 7: 
          localbh.Tqt = locala.ajGk.readString();
          AppMethodBeat.o(289971);
          return 0;
        case 8: 
          localbh.Tqu = locala.ajGk.readString();
          AppMethodBeat.o(289971);
          return 0;
        case 9: 
          localbh.Tqv = locala.ajGk.aaw();
          AppMethodBeat.o(289971);
          return 0;
        case 10: 
          localbh.Tqw = locala.ajGk.aaw();
          AppMethodBeat.o(289971);
          return 0;
        case 11: 
          localbh.Tqx = locala.ajGk.aaw();
          AppMethodBeat.o(289971);
          return 0;
        case 12: 
          localbh.Tqy = locala.ajGk.aaw();
          AppMethodBeat.o(289971);
          return 0;
        case 13: 
          localbh.Tqz = locala.ajGk.aaw();
          AppMethodBeat.o(289971);
          return 0;
        case 14: 
          localbh.TqA = locala.ajGk.readString();
          AppMethodBeat.o(289971);
          return 0;
        case 15: 
          localbh.TqB = locala.ajGk.readString();
          AppMethodBeat.o(289971);
          return 0;
        case 16: 
          localbh.sourceName = locala.ajGk.readString();
          AppMethodBeat.o(289971);
          return 0;
        case 17: 
          localbh.sourceIcon = locala.ajGk.readString();
          AppMethodBeat.o(289971);
          return 0;
        case 18: 
          localbh.TqC = locala.ajGk.aaw();
          AppMethodBeat.o(289971);
          return 0;
        case 19: 
          localbh.TqD = locala.ajGk.aaw();
          AppMethodBeat.o(289971);
          return 0;
        case 20: 
          localbh.TqE = locala.ajGk.aaw();
          AppMethodBeat.o(289971);
          return 0;
        case 21: 
          localbh.TqF = locala.ajGk.aaw();
          AppMethodBeat.o(289971);
          return 0;
        case 22: 
          localbh.TqG = locala.ajGk.aaw();
          AppMethodBeat.o(289971);
          return 0;
        case 23: 
          localbh.TqH = locala.ajGk.aaw();
          AppMethodBeat.o(289971);
          return 0;
        case 24: 
          localbh.TqI = locala.ajGk.aaw();
          AppMethodBeat.o(289971);
          return 0;
        case 25: 
          localbh.TqJ = locala.ajGk.aaw();
          AppMethodBeat.o(289971);
          return 0;
        case 26: 
          localbh.TqK = locala.ajGk.aaw();
          AppMethodBeat.o(289971);
          return 0;
        case 27: 
          localbh.TqL = locala.ajGk.aaw();
          AppMethodBeat.o(289971);
          return 0;
        case 28: 
          localbh.TqM = locala.ajGk.aaw();
          AppMethodBeat.o(289971);
          return 0;
        case 29: 
          localbh.TqN = locala.ajGk.aaw();
          AppMethodBeat.o(289971);
          return 0;
        case 30: 
          localbh.TqO = locala.ajGk.aar();
          AppMethodBeat.o(289971);
          return 0;
        case 31: 
          localbh.TqP = locala.ajGk.aaw();
          AppMethodBeat.o(289971);
          return 0;
        case 32: 
          localbh.TqQ = locala.ajGk.aaw();
          AppMethodBeat.o(289971);
          return 0;
        case 33: 
          localbh.TqR = locala.ajGk.aaw();
          AppMethodBeat.o(289971);
          return 0;
        case 34: 
          localbh.sessionId = locala.ajGk.readString();
          AppMethodBeat.o(289971);
          return 0;
        case 35: 
          localbh.Toi = locala.ajGk.aaw();
          AppMethodBeat.o(289971);
          return 0;
        case 36: 
          localbh.Toj = locala.ajGk.aar();
          AppMethodBeat.o(289971);
          return 0;
        case 37: 
          localbh.Tok = locala.ajGk.aar();
          AppMethodBeat.o(289971);
          return 0;
        case 38: 
          localbh.TqS = locala.ajGk.aar();
          AppMethodBeat.o(289971);
          return 0;
        case 39: 
          localbh.TqT = locala.ajGk.readString();
          AppMethodBeat.o(289971);
          return 0;
        case 40: 
          localbh.TqU = locala.ajGk.aar();
          AppMethodBeat.o(289971);
          return 0;
        case 41: 
          localbh.TqV = locala.ajGk.aar();
          AppMethodBeat.o(289971);
          return 0;
        case 42: 
          localbh.TqW = locala.ajGk.readString();
          AppMethodBeat.o(289971);
          return 0;
        case 43: 
          localbh.TqX = locala.ajGk.readString();
          AppMethodBeat.o(289971);
          return 0;
        case 44: 
          localbh.TqY = locala.ajGk.readString();
          AppMethodBeat.o(289971);
          return 0;
        case 45: 
          localbh.TqZ = locala.ajGk.readString();
          AppMethodBeat.o(289971);
          return 0;
        case 46: 
          localbh.Tra = locala.ajGk.aaw();
          AppMethodBeat.o(289971);
          return 0;
        case 47: 
          localbh.Trb = locala.ajGk.aaw();
          AppMethodBeat.o(289971);
          return 0;
        case 48: 
          localbh.Ton = locala.ajGk.readString();
          AppMethodBeat.o(289971);
          return 0;
        case 49: 
          localbh.Trc = locala.ajGk.aar();
          AppMethodBeat.o(289971);
          return 0;
        case 50: 
          localbh.Trd = locala.ajGk.aar();
          AppMethodBeat.o(289971);
          return 0;
        case 51: 
          localbh.Tre = locala.ajGk.aar();
          AppMethodBeat.o(289971);
          return 0;
        case 52: 
          localbh.Trf = locala.ajGk.aar();
          AppMethodBeat.o(289971);
          return 0;
        case 53: 
          localbh.Trg = locala.ajGk.aar();
          AppMethodBeat.o(289971);
          return 0;
        case 54: 
          localbh.Trh = locala.ajGk.aar();
          AppMethodBeat.o(289971);
          return 0;
        case 55: 
          localbh.Tri = locala.ajGk.readString();
          AppMethodBeat.o(289971);
          return 0;
        case 56: 
          localbh.Trj = locala.ajGk.readString();
          AppMethodBeat.o(289971);
          return 0;
        case 57: 
          localbh.Trk = locala.ajGk.readString();
          AppMethodBeat.o(289971);
          return 0;
        }
        localbh.Trl = locala.ajGk.aaw();
        AppMethodBeat.o(289971);
        return 0;
      }
      AppMethodBeat.o(289971);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.bh
 * JD-Core Version:    0.7.0.1
 */