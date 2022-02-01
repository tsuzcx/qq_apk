package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eos
  extends com.tencent.mm.bw.a
{
  public int KEf;
  public cih KHD;
  public String KPA;
  public dql KQo;
  public int LRD;
  public int LiC;
  public String LiD;
  public String LiE;
  public String LiF;
  public String Lir;
  public String Lis;
  public String Liv;
  public int MKH;
  public int MVK;
  public ebj MmQ;
  public String MvT;
  public String Mvo;
  public String Mvp;
  public String NmA;
  public String NmB;
  public String NmC;
  public String NmD;
  public czl NmE;
  public String NmF;
  public int NmG;
  public long NmH;
  public String NmI;
  public eel NmJ;
  public long NmK;
  public int NmL;
  public String NmM;
  public int NmN;
  public int NmO;
  public int NmP;
  public fff NmQ;
  public String NmR;
  public long NmS;
  public String Nmq;
  public String Nmr;
  public int Nms;
  public int Nmt;
  public int Nmu;
  public String Nmv;
  public int Nmw;
  public dqi Nmx;
  public int Nmy;
  public String Nmz;
  public String fuW;
  public String kei;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134260);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MmQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: SnsUserInfo");
        AppMethodBeat.o(134260);
        throw paramVarArgs;
      }
      if (this.MmQ != null)
      {
        paramVarArgs.ni(1, this.MmQ.computeSize());
        this.MmQ.writeFields(paramVarArgs);
      }
      if (this.kei != null) {
        paramVarArgs.e(2, this.kei);
      }
      if (this.Nmq != null) {
        paramVarArgs.e(3, this.Nmq);
      }
      if (this.Nmr != null) {
        paramVarArgs.e(4, this.Nmr);
      }
      paramVarArgs.aM(5, this.Nms);
      paramVarArgs.aM(6, this.Nmt);
      paramVarArgs.aM(7, this.Nmu);
      if (this.Nmv != null) {
        paramVarArgs.e(8, this.Nmv);
      }
      if (this.Lir != null) {
        paramVarArgs.e(9, this.Lir);
      }
      if (this.Lis != null) {
        paramVarArgs.e(10, this.Lis);
      }
      paramVarArgs.aM(11, this.Nmw);
      if (this.Nmx != null)
      {
        paramVarArgs.ni(12, this.Nmx.computeSize());
        this.Nmx.writeFields(paramVarArgs);
      }
      if (this.KQo != null)
      {
        paramVarArgs.ni(13, this.KQo.computeSize());
        this.KQo.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(14, this.KEf);
      paramVarArgs.aM(15, this.Nmy);
      if (this.KPA != null) {
        paramVarArgs.e(16, this.KPA);
      }
      if (this.Mvo != null) {
        paramVarArgs.e(17, this.Mvo);
      }
      if (this.Mvp != null) {
        paramVarArgs.e(18, this.Mvp);
      }
      if (this.Nmz != null) {
        paramVarArgs.e(19, this.Nmz);
      }
      if (this.NmA != null) {
        paramVarArgs.e(20, this.NmA);
      }
      if (this.NmB != null) {
        paramVarArgs.e(21, this.NmB);
      }
      if (this.NmC != null) {
        paramVarArgs.e(22, this.NmC);
      }
      if (this.KHD != null)
      {
        paramVarArgs.ni(23, this.KHD.computeSize());
        this.KHD.writeFields(paramVarArgs);
      }
      if (this.NmD != null) {
        paramVarArgs.e(24, this.NmD);
      }
      if (this.NmE != null)
      {
        paramVarArgs.ni(25, this.NmE.computeSize());
        this.NmE.writeFields(paramVarArgs);
      }
      if (this.NmF != null) {
        paramVarArgs.e(26, this.NmF);
      }
      paramVarArgs.aM(27, this.NmG);
      if (this.fuW != null) {
        paramVarArgs.e(28, this.fuW);
      }
      paramVarArgs.aM(29, this.LRD);
      paramVarArgs.bb(30, this.NmH);
      if (this.NmI != null) {
        paramVarArgs.e(31, this.NmI);
      }
      paramVarArgs.aM(32, this.MKH);
      if (this.NmJ != null)
      {
        paramVarArgs.ni(33, this.NmJ.computeSize());
        this.NmJ.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(34, this.NmK);
      paramVarArgs.aM(35, this.NmL);
      if (this.Liv != null) {
        paramVarArgs.e(36, this.Liv);
      }
      if (this.NmM != null) {
        paramVarArgs.e(37, this.NmM);
      }
      if (this.MvT != null) {
        paramVarArgs.e(38, this.MvT);
      }
      paramVarArgs.aM(39, this.MVK);
      paramVarArgs.aM(44, this.NmN);
      paramVarArgs.aM(45, this.NmO);
      paramVarArgs.aM(46, this.NmP);
      if (this.NmQ != null)
      {
        paramVarArgs.ni(47, this.NmQ.computeSize());
        this.NmQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(48, this.LiC);
      if (this.LiD != null) {
        paramVarArgs.e(49, this.LiD);
      }
      if (this.LiF != null) {
        paramVarArgs.e(51, this.LiF);
      }
      if (this.LiE != null) {
        paramVarArgs.e(50, this.LiE);
      }
      if (this.NmR != null) {
        paramVarArgs.e(52, this.NmR);
      }
      paramVarArgs.bb(53, this.NmS);
      AppMethodBeat.o(134260);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MmQ == null) {
        break label3602;
      }
    }
    label3602:
    for (int i = g.a.a.a.nh(1, this.MmQ.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kei != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.kei);
      }
      i = paramInt;
      if (this.Nmq != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Nmq);
      }
      paramInt = i;
      if (this.Nmr != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Nmr);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.Nms) + g.a.a.b.b.a.bu(6, this.Nmt) + g.a.a.b.b.a.bu(7, this.Nmu);
      paramInt = i;
      if (this.Nmv != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Nmv);
      }
      i = paramInt;
      if (this.Lir != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.Lir);
      }
      paramInt = i;
      if (this.Lis != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.Lis);
      }
      i = paramInt + g.a.a.b.b.a.bu(11, this.Nmw);
      paramInt = i;
      if (this.Nmx != null) {
        paramInt = i + g.a.a.a.nh(12, this.Nmx.computeSize());
      }
      i = paramInt;
      if (this.KQo != null) {
        i = paramInt + g.a.a.a.nh(13, this.KQo.computeSize());
      }
      i = i + g.a.a.b.b.a.bu(14, this.KEf) + g.a.a.b.b.a.bu(15, this.Nmy);
      paramInt = i;
      if (this.KPA != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.KPA);
      }
      i = paramInt;
      if (this.Mvo != null) {
        i = paramInt + g.a.a.b.b.a.f(17, this.Mvo);
      }
      paramInt = i;
      if (this.Mvp != null) {
        paramInt = i + g.a.a.b.b.a.f(18, this.Mvp);
      }
      i = paramInt;
      if (this.Nmz != null) {
        i = paramInt + g.a.a.b.b.a.f(19, this.Nmz);
      }
      paramInt = i;
      if (this.NmA != null) {
        paramInt = i + g.a.a.b.b.a.f(20, this.NmA);
      }
      i = paramInt;
      if (this.NmB != null) {
        i = paramInt + g.a.a.b.b.a.f(21, this.NmB);
      }
      paramInt = i;
      if (this.NmC != null) {
        paramInt = i + g.a.a.b.b.a.f(22, this.NmC);
      }
      i = paramInt;
      if (this.KHD != null) {
        i = paramInt + g.a.a.a.nh(23, this.KHD.computeSize());
      }
      paramInt = i;
      if (this.NmD != null) {
        paramInt = i + g.a.a.b.b.a.f(24, this.NmD);
      }
      i = paramInt;
      if (this.NmE != null) {
        i = paramInt + g.a.a.a.nh(25, this.NmE.computeSize());
      }
      paramInt = i;
      if (this.NmF != null) {
        paramInt = i + g.a.a.b.b.a.f(26, this.NmF);
      }
      i = paramInt + g.a.a.b.b.a.bu(27, this.NmG);
      paramInt = i;
      if (this.fuW != null) {
        paramInt = i + g.a.a.b.b.a.f(28, this.fuW);
      }
      i = paramInt + g.a.a.b.b.a.bu(29, this.LRD) + g.a.a.b.b.a.r(30, this.NmH);
      paramInt = i;
      if (this.NmI != null) {
        paramInt = i + g.a.a.b.b.a.f(31, this.NmI);
      }
      i = paramInt + g.a.a.b.b.a.bu(32, this.MKH);
      paramInt = i;
      if (this.NmJ != null) {
        paramInt = i + g.a.a.a.nh(33, this.NmJ.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.r(34, this.NmK) + g.a.a.b.b.a.bu(35, this.NmL);
      paramInt = i;
      if (this.Liv != null) {
        paramInt = i + g.a.a.b.b.a.f(36, this.Liv);
      }
      i = paramInt;
      if (this.NmM != null) {
        i = paramInt + g.a.a.b.b.a.f(37, this.NmM);
      }
      paramInt = i;
      if (this.MvT != null) {
        paramInt = i + g.a.a.b.b.a.f(38, this.MvT);
      }
      i = paramInt + g.a.a.b.b.a.bu(39, this.MVK) + g.a.a.b.b.a.bu(44, this.NmN) + g.a.a.b.b.a.bu(45, this.NmO) + g.a.a.b.b.a.bu(46, this.NmP);
      paramInt = i;
      if (this.NmQ != null) {
        paramInt = i + g.a.a.a.nh(47, this.NmQ.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(48, this.LiC);
      paramInt = i;
      if (this.LiD != null) {
        paramInt = i + g.a.a.b.b.a.f(49, this.LiD);
      }
      i = paramInt;
      if (this.LiF != null) {
        i = paramInt + g.a.a.b.b.a.f(51, this.LiF);
      }
      paramInt = i;
      if (this.LiE != null) {
        paramInt = i + g.a.a.b.b.a.f(50, this.LiE);
      }
      i = paramInt;
      if (this.NmR != null) {
        i = paramInt + g.a.a.b.b.a.f(52, this.NmR);
      }
      paramInt = g.a.a.b.b.a.r(53, this.NmS);
      AppMethodBeat.o(134260);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.MmQ == null)
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
        eos localeos = (eos)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
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
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebj();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ebj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeos.MmQ = ((ebj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 2: 
          localeos.kei = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 3: 
          localeos.Nmq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 4: 
          localeos.Nmr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 5: 
          localeos.Nms = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(134260);
          return 0;
        case 6: 
          localeos.Nmt = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(134260);
          return 0;
        case 7: 
          localeos.Nmu = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(134260);
          return 0;
        case 8: 
          localeos.Nmv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 9: 
          localeos.Lir = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 10: 
          localeos.Lis = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 11: 
          localeos.Nmw = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(134260);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeos.Nmx = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dql();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dql)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeos.KQo = ((dql)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 14: 
          localeos.KEf = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(134260);
          return 0;
        case 15: 
          localeos.Nmy = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(134260);
          return 0;
        case 16: 
          localeos.KPA = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 17: 
          localeos.Mvo = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 18: 
          localeos.Mvp = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 19: 
          localeos.Nmz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 20: 
          localeos.NmA = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 21: 
          localeos.NmB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 22: 
          localeos.NmC = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 23: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cih();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cih)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeos.KHD = ((cih)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 24: 
          localeos.NmD = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 25: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new czl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((czl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeos.NmE = ((czl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 26: 
          localeos.NmF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 27: 
          localeos.NmG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(134260);
          return 0;
        case 28: 
          localeos.fuW = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 29: 
          localeos.LRD = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(134260);
          return 0;
        case 30: 
          localeos.NmH = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(134260);
          return 0;
        case 31: 
          localeos.NmI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 32: 
          localeos.MKH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(134260);
          return 0;
        case 33: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eel();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eel)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeos.NmJ = ((eel)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 34: 
          localeos.NmK = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(134260);
          return 0;
        case 35: 
          localeos.NmL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(134260);
          return 0;
        case 36: 
          localeos.Liv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 37: 
          localeos.NmM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 38: 
          localeos.MvT = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 39: 
          localeos.MVK = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(134260);
          return 0;
        case 44: 
          localeos.NmN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(134260);
          return 0;
        case 45: 
          localeos.NmO = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(134260);
          return 0;
        case 46: 
          localeos.NmP = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(134260);
          return 0;
        case 47: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fff();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fff)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeos.NmQ = ((fff)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 48: 
          localeos.LiC = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(134260);
          return 0;
        case 49: 
          localeos.LiD = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 51: 
          localeos.LiF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 50: 
          localeos.LiE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 52: 
          localeos.NmR = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134260);
          return 0;
        }
        localeos.NmS = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(134260);
        return 0;
      }
      AppMethodBeat.o(134260);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eos
 * JD-Core Version:    0.7.0.1
 */