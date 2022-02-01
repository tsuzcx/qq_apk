package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eza
  extends com.tencent.mm.cd.a
{
  public int RFx;
  public crd RIW;
  public String RQy;
  public eai RRm;
  public String SjI;
  public String SjJ;
  public String SjM;
  public int SjT;
  public String SjU;
  public String SjV;
  public String SjW;
  public String TGR;
  public String TGm;
  public String TGn;
  public int TWB;
  public int Tai;
  public elj TxL;
  public int Uid;
  public int UzA;
  public int UzB;
  public fqg UzC;
  public String UzD;
  public long UzE;
  public int UzF;
  public String Uzc;
  public String Uzd;
  public int Uze;
  public int Uzf;
  public int Uzg;
  public String Uzh;
  public int Uzi;
  public eaf Uzj;
  public int Uzk;
  public String Uzl;
  public String Uzm;
  public String Uzn;
  public String Uzo;
  public String Uzp;
  public diz Uzq;
  public String Uzr;
  public int Uzs;
  public long Uzt;
  public String Uzu;
  public eom Uzv;
  public long Uzw;
  public int Uzx;
  public String Uzy;
  public int Uzz;
  public String hDv;
  public String mVI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134260);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TxL == null)
      {
        paramVarArgs = new b("Not all required fields were included: SnsUserInfo");
        AppMethodBeat.o(134260);
        throw paramVarArgs;
      }
      if (this.TxL != null)
      {
        paramVarArgs.oE(1, this.TxL.computeSize());
        this.TxL.writeFields(paramVarArgs);
      }
      if (this.mVI != null) {
        paramVarArgs.f(2, this.mVI);
      }
      if (this.Uzc != null) {
        paramVarArgs.f(3, this.Uzc);
      }
      if (this.Uzd != null) {
        paramVarArgs.f(4, this.Uzd);
      }
      paramVarArgs.aY(5, this.Uze);
      paramVarArgs.aY(6, this.Uzf);
      paramVarArgs.aY(7, this.Uzg);
      if (this.Uzh != null) {
        paramVarArgs.f(8, this.Uzh);
      }
      if (this.SjI != null) {
        paramVarArgs.f(9, this.SjI);
      }
      if (this.SjJ != null) {
        paramVarArgs.f(10, this.SjJ);
      }
      paramVarArgs.aY(11, this.Uzi);
      if (this.Uzj != null)
      {
        paramVarArgs.oE(12, this.Uzj.computeSize());
        this.Uzj.writeFields(paramVarArgs);
      }
      if (this.RRm != null)
      {
        paramVarArgs.oE(13, this.RRm.computeSize());
        this.RRm.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(14, this.RFx);
      paramVarArgs.aY(15, this.Uzk);
      if (this.RQy != null) {
        paramVarArgs.f(16, this.RQy);
      }
      if (this.TGm != null) {
        paramVarArgs.f(17, this.TGm);
      }
      if (this.TGn != null) {
        paramVarArgs.f(18, this.TGn);
      }
      if (this.Uzl != null) {
        paramVarArgs.f(19, this.Uzl);
      }
      if (this.Uzm != null) {
        paramVarArgs.f(20, this.Uzm);
      }
      if (this.Uzn != null) {
        paramVarArgs.f(21, this.Uzn);
      }
      if (this.Uzo != null) {
        paramVarArgs.f(22, this.Uzo);
      }
      if (this.RIW != null)
      {
        paramVarArgs.oE(23, this.RIW.computeSize());
        this.RIW.writeFields(paramVarArgs);
      }
      if (this.Uzp != null) {
        paramVarArgs.f(24, this.Uzp);
      }
      if (this.Uzq != null)
      {
        paramVarArgs.oE(25, this.Uzq.computeSize());
        this.Uzq.writeFields(paramVarArgs);
      }
      if (this.Uzr != null) {
        paramVarArgs.f(26, this.Uzr);
      }
      paramVarArgs.aY(27, this.Uzs);
      if (this.hDv != null) {
        paramVarArgs.f(28, this.hDv);
      }
      paramVarArgs.aY(29, this.Tai);
      paramVarArgs.bm(30, this.Uzt);
      if (this.Uzu != null) {
        paramVarArgs.f(31, this.Uzu);
      }
      paramVarArgs.aY(32, this.TWB);
      if (this.Uzv != null)
      {
        paramVarArgs.oE(33, this.Uzv.computeSize());
        this.Uzv.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(34, this.Uzw);
      paramVarArgs.aY(35, this.Uzx);
      if (this.SjM != null) {
        paramVarArgs.f(36, this.SjM);
      }
      if (this.Uzy != null) {
        paramVarArgs.f(37, this.Uzy);
      }
      if (this.TGR != null) {
        paramVarArgs.f(38, this.TGR);
      }
      paramVarArgs.aY(39, this.Uid);
      paramVarArgs.aY(44, this.Uzz);
      paramVarArgs.aY(45, this.UzA);
      paramVarArgs.aY(46, this.UzB);
      if (this.UzC != null)
      {
        paramVarArgs.oE(47, this.UzC.computeSize());
        this.UzC.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(48, this.SjT);
      if (this.SjU != null) {
        paramVarArgs.f(49, this.SjU);
      }
      if (this.SjW != null) {
        paramVarArgs.f(51, this.SjW);
      }
      if (this.SjV != null) {
        paramVarArgs.f(50, this.SjV);
      }
      if (this.UzD != null) {
        paramVarArgs.f(52, this.UzD);
      }
      paramVarArgs.bm(53, this.UzE);
      paramVarArgs.aY(54, this.UzF);
      AppMethodBeat.o(134260);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TxL == null) {
        break label3496;
      }
    }
    label3496:
    for (int i = g.a.a.a.oD(1, this.TxL.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mVI != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.mVI);
      }
      i = paramInt;
      if (this.Uzc != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Uzc);
      }
      paramInt = i;
      if (this.Uzd != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Uzd);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.Uze) + g.a.a.b.b.a.bM(6, this.Uzf) + g.a.a.b.b.a.bM(7, this.Uzg);
      paramInt = i;
      if (this.Uzh != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.Uzh);
      }
      i = paramInt;
      if (this.SjI != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.SjI);
      }
      paramInt = i;
      if (this.SjJ != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.SjJ);
      }
      i = paramInt + g.a.a.b.b.a.bM(11, this.Uzi);
      paramInt = i;
      if (this.Uzj != null) {
        paramInt = i + g.a.a.a.oD(12, this.Uzj.computeSize());
      }
      i = paramInt;
      if (this.RRm != null) {
        i = paramInt + g.a.a.a.oD(13, this.RRm.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(14, this.RFx) + g.a.a.b.b.a.bM(15, this.Uzk);
      paramInt = i;
      if (this.RQy != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.RQy);
      }
      i = paramInt;
      if (this.TGm != null) {
        i = paramInt + g.a.a.b.b.a.g(17, this.TGm);
      }
      paramInt = i;
      if (this.TGn != null) {
        paramInt = i + g.a.a.b.b.a.g(18, this.TGn);
      }
      i = paramInt;
      if (this.Uzl != null) {
        i = paramInt + g.a.a.b.b.a.g(19, this.Uzl);
      }
      paramInt = i;
      if (this.Uzm != null) {
        paramInt = i + g.a.a.b.b.a.g(20, this.Uzm);
      }
      i = paramInt;
      if (this.Uzn != null) {
        i = paramInt + g.a.a.b.b.a.g(21, this.Uzn);
      }
      paramInt = i;
      if (this.Uzo != null) {
        paramInt = i + g.a.a.b.b.a.g(22, this.Uzo);
      }
      i = paramInt;
      if (this.RIW != null) {
        i = paramInt + g.a.a.a.oD(23, this.RIW.computeSize());
      }
      paramInt = i;
      if (this.Uzp != null) {
        paramInt = i + g.a.a.b.b.a.g(24, this.Uzp);
      }
      i = paramInt;
      if (this.Uzq != null) {
        i = paramInt + g.a.a.a.oD(25, this.Uzq.computeSize());
      }
      paramInt = i;
      if (this.Uzr != null) {
        paramInt = i + g.a.a.b.b.a.g(26, this.Uzr);
      }
      i = paramInt + g.a.a.b.b.a.bM(27, this.Uzs);
      paramInt = i;
      if (this.hDv != null) {
        paramInt = i + g.a.a.b.b.a.g(28, this.hDv);
      }
      i = paramInt + g.a.a.b.b.a.bM(29, this.Tai) + g.a.a.b.b.a.p(30, this.Uzt);
      paramInt = i;
      if (this.Uzu != null) {
        paramInt = i + g.a.a.b.b.a.g(31, this.Uzu);
      }
      i = paramInt + g.a.a.b.b.a.bM(32, this.TWB);
      paramInt = i;
      if (this.Uzv != null) {
        paramInt = i + g.a.a.a.oD(33, this.Uzv.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.p(34, this.Uzw) + g.a.a.b.b.a.bM(35, this.Uzx);
      paramInt = i;
      if (this.SjM != null) {
        paramInt = i + g.a.a.b.b.a.g(36, this.SjM);
      }
      i = paramInt;
      if (this.Uzy != null) {
        i = paramInt + g.a.a.b.b.a.g(37, this.Uzy);
      }
      paramInt = i;
      if (this.TGR != null) {
        paramInt = i + g.a.a.b.b.a.g(38, this.TGR);
      }
      i = paramInt + g.a.a.b.b.a.bM(39, this.Uid) + g.a.a.b.b.a.bM(44, this.Uzz) + g.a.a.b.b.a.bM(45, this.UzA) + g.a.a.b.b.a.bM(46, this.UzB);
      paramInt = i;
      if (this.UzC != null) {
        paramInt = i + g.a.a.a.oD(47, this.UzC.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(48, this.SjT);
      paramInt = i;
      if (this.SjU != null) {
        paramInt = i + g.a.a.b.b.a.g(49, this.SjU);
      }
      i = paramInt;
      if (this.SjW != null) {
        i = paramInt + g.a.a.b.b.a.g(51, this.SjW);
      }
      paramInt = i;
      if (this.SjV != null) {
        paramInt = i + g.a.a.b.b.a.g(50, this.SjV);
      }
      i = paramInt;
      if (this.UzD != null) {
        i = paramInt + g.a.a.b.b.a.g(52, this.UzD);
      }
      paramInt = g.a.a.b.b.a.p(53, this.UzE);
      int j = g.a.a.b.b.a.bM(54, this.UzF);
      AppMethodBeat.o(134260);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.TxL == null)
        {
          paramVarArgs = new b("Not all required fields were included: SnsUserInfo");
          AppMethodBeat.o(134260);
          throw paramVarArgs;
        }
        AppMethodBeat.o(134260);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eza localeza = (eza)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 40: 
        case 41: 
        case 42: 
        case 43: 
        default: 
          AppMethodBeat.o(134260);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new elj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((elj)localObject2).parseFrom((byte[])localObject1);
            }
            localeza.TxL = ((elj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 2: 
          localeza.mVI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 3: 
          localeza.Uzc = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 4: 
          localeza.Uzd = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 5: 
          localeza.Uze = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(134260);
          return 0;
        case 6: 
          localeza.Uzf = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(134260);
          return 0;
        case 7: 
          localeza.Uzg = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(134260);
          return 0;
        case 8: 
          localeza.Uzh = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 9: 
          localeza.SjI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 10: 
          localeza.SjJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 11: 
          localeza.Uzi = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(134260);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localeza.Uzj = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eai();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eai)localObject2).parseFrom((byte[])localObject1);
            }
            localeza.RRm = ((eai)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 14: 
          localeza.RFx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(134260);
          return 0;
        case 15: 
          localeza.Uzk = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(134260);
          return 0;
        case 16: 
          localeza.RQy = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 17: 
          localeza.TGm = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 18: 
          localeza.TGn = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 19: 
          localeza.Uzl = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 20: 
          localeza.Uzm = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 21: 
          localeza.Uzn = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 22: 
          localeza.Uzo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 23: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new crd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((crd)localObject2).parseFrom((byte[])localObject1);
            }
            localeza.RIW = ((crd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 24: 
          localeza.Uzp = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 25: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new diz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((diz)localObject2).parseFrom((byte[])localObject1);
            }
            localeza.Uzq = ((diz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 26: 
          localeza.Uzr = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 27: 
          localeza.Uzs = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(134260);
          return 0;
        case 28: 
          localeza.hDv = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 29: 
          localeza.Tai = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(134260);
          return 0;
        case 30: 
          localeza.Uzt = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(134260);
          return 0;
        case 31: 
          localeza.Uzu = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 32: 
          localeza.TWB = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(134260);
          return 0;
        case 33: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eom();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eom)localObject2).parseFrom((byte[])localObject1);
            }
            localeza.Uzv = ((eom)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 34: 
          localeza.Uzw = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(134260);
          return 0;
        case 35: 
          localeza.Uzx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(134260);
          return 0;
        case 36: 
          localeza.SjM = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 37: 
          localeza.Uzy = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 38: 
          localeza.TGR = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 39: 
          localeza.Uid = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(134260);
          return 0;
        case 44: 
          localeza.Uzz = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(134260);
          return 0;
        case 45: 
          localeza.UzA = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(134260);
          return 0;
        case 46: 
          localeza.UzB = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(134260);
          return 0;
        case 47: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fqg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fqg)localObject2).parseFrom((byte[])localObject1);
            }
            localeza.UzC = ((fqg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 48: 
          localeza.SjT = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(134260);
          return 0;
        case 49: 
          localeza.SjU = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 51: 
          localeza.SjW = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 50: 
          localeza.SjV = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 52: 
          localeza.UzD = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 53: 
          localeza.UzE = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(134260);
          return 0;
        }
        localeza.UzF = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(134260);
        return 0;
      }
      AppMethodBeat.o(134260);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eza
 * JD-Core Version:    0.7.0.1
 */