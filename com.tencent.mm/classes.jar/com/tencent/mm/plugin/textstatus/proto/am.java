package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class am
  extends com.tencent.mm.cd.a
{
  public long MEC;
  public int MED;
  public int MEE;
  public String MFV;
  public long MFX;
  public LinkedList<String> MFY;
  public String MFZ;
  public int MGA;
  public int MGB;
  public String MGC;
  public String MGD;
  public String MGE;
  public String MGF;
  public String MGa;
  public long MGb;
  public long MGc;
  public long MGd;
  public long MGe;
  public long MGf;
  public String MGg;
  public String MGh;
  public long MGi;
  public long MGj;
  public long MGk;
  public long MGl;
  public long MGm;
  public long MGn;
  public long MGo;
  public long MGp;
  public long MGq;
  public long MGr;
  public long MGs;
  public long MGt;
  public int MGu;
  public long MGv;
  public long MGw;
  public long MGx;
  public int MGy;
  public String MGz;
  public int enterScene;
  public long enterTime;
  public int fKA;
  public String sessionId;
  public String sourceIcon;
  public String sourceName;
  
  public am()
  {
    AppMethodBeat.i(243664);
    this.MFY = new LinkedList();
    AppMethodBeat.o(243664);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(243666);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MFV != null) {
        paramVarArgs.f(1, this.MFV);
      }
      paramVarArgs.aY(2, this.enterScene);
      paramVarArgs.aY(3, this.fKA);
      paramVarArgs.bm(4, this.enterTime);
      paramVarArgs.bm(5, this.MFX);
      paramVarArgs.e(6, 1, this.MFY);
      if (this.MFZ != null) {
        paramVarArgs.f(7, this.MFZ);
      }
      if (this.MGa != null) {
        paramVarArgs.f(8, this.MGa);
      }
      paramVarArgs.bm(9, this.MGb);
      paramVarArgs.bm(10, this.MGc);
      paramVarArgs.bm(11, this.MGd);
      paramVarArgs.bm(12, this.MGe);
      paramVarArgs.bm(13, this.MGf);
      if (this.MGg != null) {
        paramVarArgs.f(14, this.MGg);
      }
      if (this.MGh != null) {
        paramVarArgs.f(15, this.MGh);
      }
      if (this.sourceName != null) {
        paramVarArgs.f(16, this.sourceName);
      }
      if (this.sourceIcon != null) {
        paramVarArgs.f(17, this.sourceIcon);
      }
      paramVarArgs.bm(18, this.MGi);
      paramVarArgs.bm(19, this.MGj);
      paramVarArgs.bm(20, this.MGk);
      paramVarArgs.bm(21, this.MGl);
      paramVarArgs.bm(22, this.MGm);
      paramVarArgs.bm(23, this.MGn);
      paramVarArgs.bm(24, this.MGo);
      paramVarArgs.bm(25, this.MGp);
      paramVarArgs.bm(26, this.MGq);
      paramVarArgs.bm(27, this.MGr);
      paramVarArgs.bm(28, this.MGs);
      paramVarArgs.bm(29, this.MGt);
      paramVarArgs.aY(30, this.MGu);
      paramVarArgs.bm(31, this.MGv);
      paramVarArgs.bm(32, this.MGw);
      paramVarArgs.bm(33, this.MGx);
      if (this.sessionId != null) {
        paramVarArgs.f(34, this.sessionId);
      }
      paramVarArgs.bm(35, this.MEC);
      paramVarArgs.aY(36, this.MED);
      paramVarArgs.aY(37, this.MEE);
      paramVarArgs.aY(38, this.MGy);
      if (this.MGz != null) {
        paramVarArgs.f(39, this.MGz);
      }
      paramVarArgs.aY(40, this.MGA);
      paramVarArgs.aY(41, this.MGB);
      if (this.MGC != null) {
        paramVarArgs.f(42, this.MGC);
      }
      if (this.MGD != null) {
        paramVarArgs.f(43, this.MGD);
      }
      if (this.MGE != null) {
        paramVarArgs.f(44, this.MGE);
      }
      if (this.MGF != null) {
        paramVarArgs.f(45, this.MGF);
      }
      AppMethodBeat.o(243666);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MFV == null) {
        break label2382;
      }
    }
    label2382:
    for (paramInt = g.a.a.b.b.a.g(1, this.MFV) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.enterScene) + g.a.a.b.b.a.bM(3, this.fKA) + g.a.a.b.b.a.p(4, this.enterTime) + g.a.a.b.b.a.p(5, this.MFX) + g.a.a.a.c(6, 1, this.MFY);
      paramInt = i;
      if (this.MFZ != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.MFZ);
      }
      i = paramInt;
      if (this.MGa != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.MGa);
      }
      i = i + g.a.a.b.b.a.p(9, this.MGb) + g.a.a.b.b.a.p(10, this.MGc) + g.a.a.b.b.a.p(11, this.MGd) + g.a.a.b.b.a.p(12, this.MGe) + g.a.a.b.b.a.p(13, this.MGf);
      paramInt = i;
      if (this.MGg != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.MGg);
      }
      i = paramInt;
      if (this.MGh != null) {
        i = paramInt + g.a.a.b.b.a.g(15, this.MGh);
      }
      paramInt = i;
      if (this.sourceName != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.sourceName);
      }
      i = paramInt;
      if (this.sourceIcon != null) {
        i = paramInt + g.a.a.b.b.a.g(17, this.sourceIcon);
      }
      i = i + g.a.a.b.b.a.p(18, this.MGi) + g.a.a.b.b.a.p(19, this.MGj) + g.a.a.b.b.a.p(20, this.MGk) + g.a.a.b.b.a.p(21, this.MGl) + g.a.a.b.b.a.p(22, this.MGm) + g.a.a.b.b.a.p(23, this.MGn) + g.a.a.b.b.a.p(24, this.MGo) + g.a.a.b.b.a.p(25, this.MGp) + g.a.a.b.b.a.p(26, this.MGq) + g.a.a.b.b.a.p(27, this.MGr) + g.a.a.b.b.a.p(28, this.MGs) + g.a.a.b.b.a.p(29, this.MGt) + g.a.a.b.b.a.bM(30, this.MGu) + g.a.a.b.b.a.p(31, this.MGv) + g.a.a.b.b.a.p(32, this.MGw) + g.a.a.b.b.a.p(33, this.MGx);
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + g.a.a.b.b.a.g(34, this.sessionId);
      }
      i = paramInt + g.a.a.b.b.a.p(35, this.MEC) + g.a.a.b.b.a.bM(36, this.MED) + g.a.a.b.b.a.bM(37, this.MEE) + g.a.a.b.b.a.bM(38, this.MGy);
      paramInt = i;
      if (this.MGz != null) {
        paramInt = i + g.a.a.b.b.a.g(39, this.MGz);
      }
      i = paramInt + g.a.a.b.b.a.bM(40, this.MGA) + g.a.a.b.b.a.bM(41, this.MGB);
      paramInt = i;
      if (this.MGC != null) {
        paramInt = i + g.a.a.b.b.a.g(42, this.MGC);
      }
      i = paramInt;
      if (this.MGD != null) {
        i = paramInt + g.a.a.b.b.a.g(43, this.MGD);
      }
      paramInt = i;
      if (this.MGE != null) {
        paramInt = i + g.a.a.b.b.a.g(44, this.MGE);
      }
      i = paramInt;
      if (this.MGF != null) {
        i = paramInt + g.a.a.b.b.a.g(45, this.MGF);
      }
      AppMethodBeat.o(243666);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MFY.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(243666);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        am localam = (am)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(243666);
          return -1;
        case 1: 
          localam.MFV = locala.abFh.readString();
          AppMethodBeat.o(243666);
          return 0;
        case 2: 
          localam.enterScene = locala.abFh.AK();
          AppMethodBeat.o(243666);
          return 0;
        case 3: 
          localam.fKA = locala.abFh.AK();
          AppMethodBeat.o(243666);
          return 0;
        case 4: 
          localam.enterTime = locala.abFh.AN();
          AppMethodBeat.o(243666);
          return 0;
        case 5: 
          localam.MFX = locala.abFh.AN();
          AppMethodBeat.o(243666);
          return 0;
        case 6: 
          localam.MFY.add(locala.abFh.readString());
          AppMethodBeat.o(243666);
          return 0;
        case 7: 
          localam.MFZ = locala.abFh.readString();
          AppMethodBeat.o(243666);
          return 0;
        case 8: 
          localam.MGa = locala.abFh.readString();
          AppMethodBeat.o(243666);
          return 0;
        case 9: 
          localam.MGb = locala.abFh.AN();
          AppMethodBeat.o(243666);
          return 0;
        case 10: 
          localam.MGc = locala.abFh.AN();
          AppMethodBeat.o(243666);
          return 0;
        case 11: 
          localam.MGd = locala.abFh.AN();
          AppMethodBeat.o(243666);
          return 0;
        case 12: 
          localam.MGe = locala.abFh.AN();
          AppMethodBeat.o(243666);
          return 0;
        case 13: 
          localam.MGf = locala.abFh.AN();
          AppMethodBeat.o(243666);
          return 0;
        case 14: 
          localam.MGg = locala.abFh.readString();
          AppMethodBeat.o(243666);
          return 0;
        case 15: 
          localam.MGh = locala.abFh.readString();
          AppMethodBeat.o(243666);
          return 0;
        case 16: 
          localam.sourceName = locala.abFh.readString();
          AppMethodBeat.o(243666);
          return 0;
        case 17: 
          localam.sourceIcon = locala.abFh.readString();
          AppMethodBeat.o(243666);
          return 0;
        case 18: 
          localam.MGi = locala.abFh.AN();
          AppMethodBeat.o(243666);
          return 0;
        case 19: 
          localam.MGj = locala.abFh.AN();
          AppMethodBeat.o(243666);
          return 0;
        case 20: 
          localam.MGk = locala.abFh.AN();
          AppMethodBeat.o(243666);
          return 0;
        case 21: 
          localam.MGl = locala.abFh.AN();
          AppMethodBeat.o(243666);
          return 0;
        case 22: 
          localam.MGm = locala.abFh.AN();
          AppMethodBeat.o(243666);
          return 0;
        case 23: 
          localam.MGn = locala.abFh.AN();
          AppMethodBeat.o(243666);
          return 0;
        case 24: 
          localam.MGo = locala.abFh.AN();
          AppMethodBeat.o(243666);
          return 0;
        case 25: 
          localam.MGp = locala.abFh.AN();
          AppMethodBeat.o(243666);
          return 0;
        case 26: 
          localam.MGq = locala.abFh.AN();
          AppMethodBeat.o(243666);
          return 0;
        case 27: 
          localam.MGr = locala.abFh.AN();
          AppMethodBeat.o(243666);
          return 0;
        case 28: 
          localam.MGs = locala.abFh.AN();
          AppMethodBeat.o(243666);
          return 0;
        case 29: 
          localam.MGt = locala.abFh.AN();
          AppMethodBeat.o(243666);
          return 0;
        case 30: 
          localam.MGu = locala.abFh.AK();
          AppMethodBeat.o(243666);
          return 0;
        case 31: 
          localam.MGv = locala.abFh.AN();
          AppMethodBeat.o(243666);
          return 0;
        case 32: 
          localam.MGw = locala.abFh.AN();
          AppMethodBeat.o(243666);
          return 0;
        case 33: 
          localam.MGx = locala.abFh.AN();
          AppMethodBeat.o(243666);
          return 0;
        case 34: 
          localam.sessionId = locala.abFh.readString();
          AppMethodBeat.o(243666);
          return 0;
        case 35: 
          localam.MEC = locala.abFh.AN();
          AppMethodBeat.o(243666);
          return 0;
        case 36: 
          localam.MED = locala.abFh.AK();
          AppMethodBeat.o(243666);
          return 0;
        case 37: 
          localam.MEE = locala.abFh.AK();
          AppMethodBeat.o(243666);
          return 0;
        case 38: 
          localam.MGy = locala.abFh.AK();
          AppMethodBeat.o(243666);
          return 0;
        case 39: 
          localam.MGz = locala.abFh.readString();
          AppMethodBeat.o(243666);
          return 0;
        case 40: 
          localam.MGA = locala.abFh.AK();
          AppMethodBeat.o(243666);
          return 0;
        case 41: 
          localam.MGB = locala.abFh.AK();
          AppMethodBeat.o(243666);
          return 0;
        case 42: 
          localam.MGC = locala.abFh.readString();
          AppMethodBeat.o(243666);
          return 0;
        case 43: 
          localam.MGD = locala.abFh.readString();
          AppMethodBeat.o(243666);
          return 0;
        case 44: 
          localam.MGE = locala.abFh.readString();
          AppMethodBeat.o(243666);
          return 0;
        }
        localam.MGF = locala.abFh.readString();
        AppMethodBeat.o(243666);
        return 0;
      }
      AppMethodBeat.o(243666);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.am
 * JD-Core Version:    0.7.0.1
 */