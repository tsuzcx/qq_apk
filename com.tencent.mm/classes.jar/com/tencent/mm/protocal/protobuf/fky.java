package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fky
  extends com.tencent.mm.cd.a
{
  public int TXB;
  public int UJA;
  public int UJB;
  public int UJC;
  public String UJD;
  public int UJE;
  public int UJF;
  public long UJG;
  public int UJH;
  public long UJI;
  public String UJJ;
  public String UJK;
  public boolean UJL;
  public String UJM;
  public String UJs;
  public int UJt;
  public String UJu;
  public boolean UJv;
  public boolean UJw;
  public String UJx;
  public String UJy;
  public int UJz;
  public String coverUrl;
  public String fUd;
  public String fUe;
  public String fXu;
  public String id;
  public int mode;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205534);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.f(1, this.id);
      }
      if (this.fXu != null) {
        paramVarArgs.f(2, this.fXu);
      }
      if (this.UJs != null) {
        paramVarArgs.f(3, this.UJs);
      }
      paramVarArgs.aY(4, this.UJt);
      if (this.title != null) {
        paramVarArgs.f(5, this.title);
      }
      if (this.UJu != null) {
        paramVarArgs.f(6, this.UJu);
      }
      paramVarArgs.co(7, this.UJv);
      paramVarArgs.co(8, this.UJw);
      if (this.fUd != null) {
        paramVarArgs.f(9, this.fUd);
      }
      if (this.fUe != null) {
        paramVarArgs.f(10, this.fUe);
      }
      paramVarArgs.aY(11, this.mode);
      if (this.UJx != null) {
        paramVarArgs.f(12, this.UJx);
      }
      if (this.UJy != null) {
        paramVarArgs.f(13, this.UJy);
      }
      paramVarArgs.aY(14, this.UJz);
      paramVarArgs.aY(15, this.UJA);
      paramVarArgs.aY(16, this.TXB);
      paramVarArgs.aY(17, this.UJB);
      paramVarArgs.aY(18, this.UJC);
      if (this.UJD != null) {
        paramVarArgs.f(19, this.UJD);
      }
      paramVarArgs.aY(20, this.UJE);
      paramVarArgs.aY(21, this.UJF);
      paramVarArgs.bm(22, this.UJG);
      paramVarArgs.aY(23, this.UJH);
      paramVarArgs.bm(24, this.UJI);
      if (this.UJJ != null) {
        paramVarArgs.f(25, this.UJJ);
      }
      if (this.UJK != null) {
        paramVarArgs.f(26, this.UJK);
      }
      paramVarArgs.co(27, this.UJL);
      if (this.UJM != null) {
        paramVarArgs.f(28, this.UJM);
      }
      if (this.coverUrl != null) {
        paramVarArgs.f(29, this.coverUrl);
      }
      AppMethodBeat.o(205534);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label1678;
      }
    }
    label1678:
    for (int i = g.a.a.b.b.a.g(1, this.id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fXu != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.fXu);
      }
      i = paramInt;
      if (this.UJs != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.UJs);
      }
      i += g.a.a.b.b.a.bM(4, this.UJt);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.title);
      }
      i = paramInt;
      if (this.UJu != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.UJu);
      }
      i = i + (g.a.a.b.b.a.gL(7) + 1) + (g.a.a.b.b.a.gL(8) + 1);
      paramInt = i;
      if (this.fUd != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.fUd);
      }
      i = paramInt;
      if (this.fUe != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.fUe);
      }
      i += g.a.a.b.b.a.bM(11, this.mode);
      paramInt = i;
      if (this.UJx != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.UJx);
      }
      i = paramInt;
      if (this.UJy != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.UJy);
      }
      i = i + g.a.a.b.b.a.bM(14, this.UJz) + g.a.a.b.b.a.bM(15, this.UJA) + g.a.a.b.b.a.bM(16, this.TXB) + g.a.a.b.b.a.bM(17, this.UJB) + g.a.a.b.b.a.bM(18, this.UJC);
      paramInt = i;
      if (this.UJD != null) {
        paramInt = i + g.a.a.b.b.a.g(19, this.UJD);
      }
      i = paramInt + g.a.a.b.b.a.bM(20, this.UJE) + g.a.a.b.b.a.bM(21, this.UJF) + g.a.a.b.b.a.p(22, this.UJG) + g.a.a.b.b.a.bM(23, this.UJH) + g.a.a.b.b.a.p(24, this.UJI);
      paramInt = i;
      if (this.UJJ != null) {
        paramInt = i + g.a.a.b.b.a.g(25, this.UJJ);
      }
      i = paramInt;
      if (this.UJK != null) {
        i = paramInt + g.a.a.b.b.a.g(26, this.UJK);
      }
      i += g.a.a.b.b.a.gL(27) + 1;
      paramInt = i;
      if (this.UJM != null) {
        paramInt = i + g.a.a.b.b.a.g(28, this.UJM);
      }
      i = paramInt;
      if (this.coverUrl != null) {
        i = paramInt + g.a.a.b.b.a.g(29, this.coverUrl);
      }
      AppMethodBeat.o(205534);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(205534);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fky localfky = (fky)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(205534);
          return -1;
        case 1: 
          localfky.id = locala.abFh.readString();
          AppMethodBeat.o(205534);
          return 0;
        case 2: 
          localfky.fXu = locala.abFh.readString();
          AppMethodBeat.o(205534);
          return 0;
        case 3: 
          localfky.UJs = locala.abFh.readString();
          AppMethodBeat.o(205534);
          return 0;
        case 4: 
          localfky.UJt = locala.abFh.AK();
          AppMethodBeat.o(205534);
          return 0;
        case 5: 
          localfky.title = locala.abFh.readString();
          AppMethodBeat.o(205534);
          return 0;
        case 6: 
          localfky.UJu = locala.abFh.readString();
          AppMethodBeat.o(205534);
          return 0;
        case 7: 
          localfky.UJv = locala.abFh.AB();
          AppMethodBeat.o(205534);
          return 0;
        case 8: 
          localfky.UJw = locala.abFh.AB();
          AppMethodBeat.o(205534);
          return 0;
        case 9: 
          localfky.fUd = locala.abFh.readString();
          AppMethodBeat.o(205534);
          return 0;
        case 10: 
          localfky.fUe = locala.abFh.readString();
          AppMethodBeat.o(205534);
          return 0;
        case 11: 
          localfky.mode = locala.abFh.AK();
          AppMethodBeat.o(205534);
          return 0;
        case 12: 
          localfky.UJx = locala.abFh.readString();
          AppMethodBeat.o(205534);
          return 0;
        case 13: 
          localfky.UJy = locala.abFh.readString();
          AppMethodBeat.o(205534);
          return 0;
        case 14: 
          localfky.UJz = locala.abFh.AK();
          AppMethodBeat.o(205534);
          return 0;
        case 15: 
          localfky.UJA = locala.abFh.AK();
          AppMethodBeat.o(205534);
          return 0;
        case 16: 
          localfky.TXB = locala.abFh.AK();
          AppMethodBeat.o(205534);
          return 0;
        case 17: 
          localfky.UJB = locala.abFh.AK();
          AppMethodBeat.o(205534);
          return 0;
        case 18: 
          localfky.UJC = locala.abFh.AK();
          AppMethodBeat.o(205534);
          return 0;
        case 19: 
          localfky.UJD = locala.abFh.readString();
          AppMethodBeat.o(205534);
          return 0;
        case 20: 
          localfky.UJE = locala.abFh.AK();
          AppMethodBeat.o(205534);
          return 0;
        case 21: 
          localfky.UJF = locala.abFh.AK();
          AppMethodBeat.o(205534);
          return 0;
        case 22: 
          localfky.UJG = locala.abFh.AN();
          AppMethodBeat.o(205534);
          return 0;
        case 23: 
          localfky.UJH = locala.abFh.AK();
          AppMethodBeat.o(205534);
          return 0;
        case 24: 
          localfky.UJI = locala.abFh.AN();
          AppMethodBeat.o(205534);
          return 0;
        case 25: 
          localfky.UJJ = locala.abFh.readString();
          AppMethodBeat.o(205534);
          return 0;
        case 26: 
          localfky.UJK = locala.abFh.readString();
          AppMethodBeat.o(205534);
          return 0;
        case 27: 
          localfky.UJL = locala.abFh.AB();
          AppMethodBeat.o(205534);
          return 0;
        case 28: 
          localfky.UJM = locala.abFh.readString();
          AppMethodBeat.o(205534);
          return 0;
        }
        localfky.coverUrl = locala.abFh.readString();
        AppMethodBeat.o(205534);
        return 0;
      }
      AppMethodBeat.o(205534);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fky
 * JD-Core Version:    0.7.0.1
 */