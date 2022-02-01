package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dxu
  extends com.tencent.mm.cd.a
{
  public String CMD;
  public String CPs;
  public int CPw;
  public String RPP;
  public String RYJ;
  public long Sap;
  public String SessionId;
  public int SmY;
  public String TPZ;
  public long TVZ;
  public int Tkv;
  public String Tkx;
  public String Tky;
  public int Tst;
  public int Typ;
  public String Ude;
  public int Udf;
  public int Udg;
  public int Udh;
  public String Udi;
  public String Udj;
  public String Udk;
  public int Udl;
  public int Udm;
  public int Udn;
  public int Udo;
  public String Udp;
  public String Udq;
  public int Udr;
  public String Uds;
  public int Udt;
  public int Udu;
  public String Udv;
  public int Udw;
  public String Udx;
  public String Udy;
  public String Udz;
  public String fwr;
  public String sSU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117900);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.CPw);
      if (this.Tky != null) {
        paramVarArgs.f(2, this.Tky);
      }
      if (this.Ude != null) {
        paramVarArgs.f(3, this.Ude);
      }
      paramVarArgs.bm(4, this.Sap);
      if (this.TPZ != null) {
        paramVarArgs.f(5, this.TPZ);
      }
      paramVarArgs.aY(6, this.Udf);
      paramVarArgs.aY(7, this.Udg);
      paramVarArgs.aY(8, this.Udh);
      paramVarArgs.bm(9, this.TVZ);
      paramVarArgs.aY(10, this.Tst);
      if (this.Udi != null) {
        paramVarArgs.f(11, this.Udi);
      }
      paramVarArgs.aY(12, this.SmY);
      if (this.Udj != null) {
        paramVarArgs.f(13, this.Udj);
      }
      if (this.Udk != null) {
        paramVarArgs.f(14, this.Udk);
      }
      paramVarArgs.aY(15, this.Typ);
      paramVarArgs.aY(16, this.Udl);
      paramVarArgs.aY(17, this.Tkv);
      if (this.RYJ != null) {
        paramVarArgs.f(18, this.RYJ);
      }
      paramVarArgs.aY(19, this.Udm);
      paramVarArgs.aY(20, this.Udn);
      if (this.CMD != null) {
        paramVarArgs.f(21, this.CMD);
      }
      if (this.SessionId != null) {
        paramVarArgs.f(22, this.SessionId);
      }
      paramVarArgs.aY(23, this.Udo);
      if (this.Udp != null) {
        paramVarArgs.f(24, this.Udp);
      }
      if (this.fwr != null) {
        paramVarArgs.f(25, this.fwr);
      }
      if (this.RPP != null) {
        paramVarArgs.f(26, this.RPP);
      }
      if (this.Udq != null) {
        paramVarArgs.f(27, this.Udq);
      }
      if (this.sSU != null) {
        paramVarArgs.f(28, this.sSU);
      }
      if (this.Tkx != null) {
        paramVarArgs.f(29, this.Tkx);
      }
      paramVarArgs.aY(30, this.Udr);
      if (this.Uds != null) {
        paramVarArgs.f(31, this.Uds);
      }
      paramVarArgs.aY(32, this.Udt);
      paramVarArgs.aY(33, this.Udu);
      if (this.Udv != null) {
        paramVarArgs.f(34, this.Udv);
      }
      paramVarArgs.aY(35, this.Udw);
      if (this.Udx != null) {
        paramVarArgs.f(36, this.Udx);
      }
      if (this.Udy != null) {
        paramVarArgs.f(37, this.Udy);
      }
      if (this.CPs != null) {
        paramVarArgs.f(38, this.CPs);
      }
      if (this.Udz != null) {
        paramVarArgs.f(39, this.Udz);
      }
      AppMethodBeat.o(117900);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.CPw) + 0;
      paramInt = i;
      if (this.Tky != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Tky);
      }
      i = paramInt;
      if (this.Ude != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Ude);
      }
      i += g.a.a.b.b.a.p(4, this.Sap);
      paramInt = i;
      if (this.TPZ != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.TPZ);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.Udf) + g.a.a.b.b.a.bM(7, this.Udg) + g.a.a.b.b.a.bM(8, this.Udh) + g.a.a.b.b.a.p(9, this.TVZ) + g.a.a.b.b.a.bM(10, this.Tst);
      paramInt = i;
      if (this.Udi != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.Udi);
      }
      i = paramInt + g.a.a.b.b.a.bM(12, this.SmY);
      paramInt = i;
      if (this.Udj != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.Udj);
      }
      i = paramInt;
      if (this.Udk != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.Udk);
      }
      i = i + g.a.a.b.b.a.bM(15, this.Typ) + g.a.a.b.b.a.bM(16, this.Udl) + g.a.a.b.b.a.bM(17, this.Tkv);
      paramInt = i;
      if (this.RYJ != null) {
        paramInt = i + g.a.a.b.b.a.g(18, this.RYJ);
      }
      i = paramInt + g.a.a.b.b.a.bM(19, this.Udm) + g.a.a.b.b.a.bM(20, this.Udn);
      paramInt = i;
      if (this.CMD != null) {
        paramInt = i + g.a.a.b.b.a.g(21, this.CMD);
      }
      i = paramInt;
      if (this.SessionId != null) {
        i = paramInt + g.a.a.b.b.a.g(22, this.SessionId);
      }
      i += g.a.a.b.b.a.bM(23, this.Udo);
      paramInt = i;
      if (this.Udp != null) {
        paramInt = i + g.a.a.b.b.a.g(24, this.Udp);
      }
      i = paramInt;
      if (this.fwr != null) {
        i = paramInt + g.a.a.b.b.a.g(25, this.fwr);
      }
      paramInt = i;
      if (this.RPP != null) {
        paramInt = i + g.a.a.b.b.a.g(26, this.RPP);
      }
      i = paramInt;
      if (this.Udq != null) {
        i = paramInt + g.a.a.b.b.a.g(27, this.Udq);
      }
      paramInt = i;
      if (this.sSU != null) {
        paramInt = i + g.a.a.b.b.a.g(28, this.sSU);
      }
      i = paramInt;
      if (this.Tkx != null) {
        i = paramInt + g.a.a.b.b.a.g(29, this.Tkx);
      }
      i += g.a.a.b.b.a.bM(30, this.Udr);
      paramInt = i;
      if (this.Uds != null) {
        paramInt = i + g.a.a.b.b.a.g(31, this.Uds);
      }
      i = paramInt + g.a.a.b.b.a.bM(32, this.Udt) + g.a.a.b.b.a.bM(33, this.Udu);
      paramInt = i;
      if (this.Udv != null) {
        paramInt = i + g.a.a.b.b.a.g(34, this.Udv);
      }
      i = paramInt + g.a.a.b.b.a.bM(35, this.Udw);
      paramInt = i;
      if (this.Udx != null) {
        paramInt = i + g.a.a.b.b.a.g(36, this.Udx);
      }
      i = paramInt;
      if (this.Udy != null) {
        i = paramInt + g.a.a.b.b.a.g(37, this.Udy);
      }
      paramInt = i;
      if (this.CPs != null) {
        paramInt = i + g.a.a.b.b.a.g(38, this.CPs);
      }
      i = paramInt;
      if (this.Udz != null) {
        i = paramInt + g.a.a.b.b.a.g(39, this.Udz);
      }
      AppMethodBeat.o(117900);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(117900);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dxu localdxu = (dxu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117900);
        return -1;
      case 1: 
        localdxu.CPw = locala.abFh.AK();
        AppMethodBeat.o(117900);
        return 0;
      case 2: 
        localdxu.Tky = locala.abFh.readString();
        AppMethodBeat.o(117900);
        return 0;
      case 3: 
        localdxu.Ude = locala.abFh.readString();
        AppMethodBeat.o(117900);
        return 0;
      case 4: 
        localdxu.Sap = locala.abFh.AN();
        AppMethodBeat.o(117900);
        return 0;
      case 5: 
        localdxu.TPZ = locala.abFh.readString();
        AppMethodBeat.o(117900);
        return 0;
      case 6: 
        localdxu.Udf = locala.abFh.AK();
        AppMethodBeat.o(117900);
        return 0;
      case 7: 
        localdxu.Udg = locala.abFh.AK();
        AppMethodBeat.o(117900);
        return 0;
      case 8: 
        localdxu.Udh = locala.abFh.AK();
        AppMethodBeat.o(117900);
        return 0;
      case 9: 
        localdxu.TVZ = locala.abFh.AN();
        AppMethodBeat.o(117900);
        return 0;
      case 10: 
        localdxu.Tst = locala.abFh.AK();
        AppMethodBeat.o(117900);
        return 0;
      case 11: 
        localdxu.Udi = locala.abFh.readString();
        AppMethodBeat.o(117900);
        return 0;
      case 12: 
        localdxu.SmY = locala.abFh.AK();
        AppMethodBeat.o(117900);
        return 0;
      case 13: 
        localdxu.Udj = locala.abFh.readString();
        AppMethodBeat.o(117900);
        return 0;
      case 14: 
        localdxu.Udk = locala.abFh.readString();
        AppMethodBeat.o(117900);
        return 0;
      case 15: 
        localdxu.Typ = locala.abFh.AK();
        AppMethodBeat.o(117900);
        return 0;
      case 16: 
        localdxu.Udl = locala.abFh.AK();
        AppMethodBeat.o(117900);
        return 0;
      case 17: 
        localdxu.Tkv = locala.abFh.AK();
        AppMethodBeat.o(117900);
        return 0;
      case 18: 
        localdxu.RYJ = locala.abFh.readString();
        AppMethodBeat.o(117900);
        return 0;
      case 19: 
        localdxu.Udm = locala.abFh.AK();
        AppMethodBeat.o(117900);
        return 0;
      case 20: 
        localdxu.Udn = locala.abFh.AK();
        AppMethodBeat.o(117900);
        return 0;
      case 21: 
        localdxu.CMD = locala.abFh.readString();
        AppMethodBeat.o(117900);
        return 0;
      case 22: 
        localdxu.SessionId = locala.abFh.readString();
        AppMethodBeat.o(117900);
        return 0;
      case 23: 
        localdxu.Udo = locala.abFh.AK();
        AppMethodBeat.o(117900);
        return 0;
      case 24: 
        localdxu.Udp = locala.abFh.readString();
        AppMethodBeat.o(117900);
        return 0;
      case 25: 
        localdxu.fwr = locala.abFh.readString();
        AppMethodBeat.o(117900);
        return 0;
      case 26: 
        localdxu.RPP = locala.abFh.readString();
        AppMethodBeat.o(117900);
        return 0;
      case 27: 
        localdxu.Udq = locala.abFh.readString();
        AppMethodBeat.o(117900);
        return 0;
      case 28: 
        localdxu.sSU = locala.abFh.readString();
        AppMethodBeat.o(117900);
        return 0;
      case 29: 
        localdxu.Tkx = locala.abFh.readString();
        AppMethodBeat.o(117900);
        return 0;
      case 30: 
        localdxu.Udr = locala.abFh.AK();
        AppMethodBeat.o(117900);
        return 0;
      case 31: 
        localdxu.Uds = locala.abFh.readString();
        AppMethodBeat.o(117900);
        return 0;
      case 32: 
        localdxu.Udt = locala.abFh.AK();
        AppMethodBeat.o(117900);
        return 0;
      case 33: 
        localdxu.Udu = locala.abFh.AK();
        AppMethodBeat.o(117900);
        return 0;
      case 34: 
        localdxu.Udv = locala.abFh.readString();
        AppMethodBeat.o(117900);
        return 0;
      case 35: 
        localdxu.Udw = locala.abFh.AK();
        AppMethodBeat.o(117900);
        return 0;
      case 36: 
        localdxu.Udx = locala.abFh.readString();
        AppMethodBeat.o(117900);
        return 0;
      case 37: 
        localdxu.Udy = locala.abFh.readString();
        AppMethodBeat.o(117900);
        return 0;
      case 38: 
        localdxu.CPs = locala.abFh.readString();
        AppMethodBeat.o(117900);
        return 0;
      }
      localdxu.Udz = locala.abFh.readString();
      AppMethodBeat.o(117900);
      return 0;
    }
    AppMethodBeat.o(117900);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxu
 * JD-Core Version:    0.7.0.1
 */