package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class civ
  extends com.tencent.mm.cd.a
{
  public String CMD;
  public String CNj;
  public String RMc;
  public String RPQ;
  public String TpK;
  public String TpL;
  public int TpM;
  public int TpN;
  public int TpO;
  public int TpP;
  public String TpQ;
  public String TpR;
  public String TpS;
  public String TpT;
  public int TpU;
  public int idX;
  public long idY;
  public String idZ;
  public String iea;
  public String ieb;
  public String iec;
  public String mVD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82425);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TpK != null) {
        paramVarArgs.f(1, this.TpK);
      }
      if (this.RMc != null) {
        paramVarArgs.f(2, this.RMc);
      }
      if (this.RPQ != null) {
        paramVarArgs.f(3, this.RPQ);
      }
      if (this.TpL != null) {
        paramVarArgs.f(4, this.TpL);
      }
      paramVarArgs.aY(5, this.TpM);
      paramVarArgs.aY(6, this.TpN);
      paramVarArgs.aY(7, this.TpO);
      paramVarArgs.aY(8, this.TpP);
      if (this.TpQ != null) {
        paramVarArgs.f(9, this.TpQ);
      }
      if (this.mVD != null) {
        paramVarArgs.f(10, this.mVD);
      }
      if (this.CNj != null) {
        paramVarArgs.f(11, this.CNj);
      }
      if (this.CMD != null) {
        paramVarArgs.f(12, this.CMD);
      }
      if (this.TpR != null) {
        paramVarArgs.f(13, this.TpR);
      }
      if (this.TpS != null) {
        paramVarArgs.f(14, this.TpS);
      }
      if (this.TpT != null) {
        paramVarArgs.f(15, this.TpT);
      }
      paramVarArgs.aY(16, this.TpU);
      paramVarArgs.aY(17, this.idX);
      paramVarArgs.bm(18, this.idY);
      if (this.idZ != null) {
        paramVarArgs.f(19, this.idZ);
      }
      if (this.iea != null) {
        paramVarArgs.f(20, this.iea);
      }
      if (this.ieb != null) {
        paramVarArgs.f(21, this.ieb);
      }
      if (this.iec != null) {
        paramVarArgs.f(22, this.iec);
      }
      AppMethodBeat.o(82425);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TpK == null) {
        break label1386;
      }
    }
    label1386:
    for (int i = g.a.a.b.b.a.g(1, this.TpK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RMc != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RMc);
      }
      i = paramInt;
      if (this.RPQ != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RPQ);
      }
      paramInt = i;
      if (this.TpL != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TpL);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.TpM) + g.a.a.b.b.a.bM(6, this.TpN) + g.a.a.b.b.a.bM(7, this.TpO) + g.a.a.b.b.a.bM(8, this.TpP);
      paramInt = i;
      if (this.TpQ != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.TpQ);
      }
      i = paramInt;
      if (this.mVD != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.mVD);
      }
      paramInt = i;
      if (this.CNj != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.CNj);
      }
      i = paramInt;
      if (this.CMD != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.CMD);
      }
      paramInt = i;
      if (this.TpR != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.TpR);
      }
      i = paramInt;
      if (this.TpS != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.TpS);
      }
      paramInt = i;
      if (this.TpT != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.TpT);
      }
      i = paramInt + g.a.a.b.b.a.bM(16, this.TpU) + g.a.a.b.b.a.bM(17, this.idX) + g.a.a.b.b.a.p(18, this.idY);
      paramInt = i;
      if (this.idZ != null) {
        paramInt = i + g.a.a.b.b.a.g(19, this.idZ);
      }
      i = paramInt;
      if (this.iea != null) {
        i = paramInt + g.a.a.b.b.a.g(20, this.iea);
      }
      paramInt = i;
      if (this.ieb != null) {
        paramInt = i + g.a.a.b.b.a.g(21, this.ieb);
      }
      i = paramInt;
      if (this.iec != null) {
        i = paramInt + g.a.a.b.b.a.g(22, this.iec);
      }
      AppMethodBeat.o(82425);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(82425);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        civ localciv = (civ)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82425);
          return -1;
        case 1: 
          localciv.TpK = locala.abFh.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 2: 
          localciv.RMc = locala.abFh.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 3: 
          localciv.RPQ = locala.abFh.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 4: 
          localciv.TpL = locala.abFh.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 5: 
          localciv.TpM = locala.abFh.AK();
          AppMethodBeat.o(82425);
          return 0;
        case 6: 
          localciv.TpN = locala.abFh.AK();
          AppMethodBeat.o(82425);
          return 0;
        case 7: 
          localciv.TpO = locala.abFh.AK();
          AppMethodBeat.o(82425);
          return 0;
        case 8: 
          localciv.TpP = locala.abFh.AK();
          AppMethodBeat.o(82425);
          return 0;
        case 9: 
          localciv.TpQ = locala.abFh.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 10: 
          localciv.mVD = locala.abFh.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 11: 
          localciv.CNj = locala.abFh.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 12: 
          localciv.CMD = locala.abFh.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 13: 
          localciv.TpR = locala.abFh.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 14: 
          localciv.TpS = locala.abFh.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 15: 
          localciv.TpT = locala.abFh.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 16: 
          localciv.TpU = locala.abFh.AK();
          AppMethodBeat.o(82425);
          return 0;
        case 17: 
          localciv.idX = locala.abFh.AK();
          AppMethodBeat.o(82425);
          return 0;
        case 18: 
          localciv.idY = locala.abFh.AN();
          AppMethodBeat.o(82425);
          return 0;
        case 19: 
          localciv.idZ = locala.abFh.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 20: 
          localciv.iea = locala.abFh.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 21: 
          localciv.ieb = locala.abFh.readString();
          AppMethodBeat.o(82425);
          return 0;
        }
        localciv.iec = locala.abFh.readString();
        AppMethodBeat.o(82425);
        return 0;
      }
      AppMethodBeat.o(82425);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.civ
 * JD-Core Version:    0.7.0.1
 */