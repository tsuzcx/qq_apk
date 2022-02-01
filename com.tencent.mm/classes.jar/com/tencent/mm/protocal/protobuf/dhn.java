package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dhn
  extends dpc
{
  public String HtI;
  public String HuS;
  public int MAf;
  public dde MAl;
  public String MLJ;
  public String MLP;
  public String MLQ;
  public String MLR;
  public int MLS;
  public LinkedList<ahq> MLT;
  public int MLU;
  public LinkedList<ahq> MLV;
  public ahq MLW;
  public LinkedList<ahq> MLX;
  public ahq MLY;
  public cox MLZ;
  public String MMa;
  public int MMb;
  public String MMc;
  public int MMd;
  public boolean MMe;
  public String MMf;
  public String MMg;
  public LinkedList<ctg> MMh;
  public String MMi;
  public String MMj;
  public String MMk;
  public ctg MMl;
  public cgt MMm;
  public cgt MMn;
  public String MMo;
  public String MMp;
  public aof MMq;
  public LinkedList<ctg> MMr;
  public String MMs;
  public String MMt;
  public ctg MMu;
  public chu MMv;
  public ctg MMw;
  public boolean Mma;
  public String Mnk;
  public String Mnl;
  public ckj efB;
  public int egj;
  public int pTZ;
  public String pUa;
  public int yba;
  
  public dhn()
  {
    AppMethodBeat.i(91644);
    this.MLT = new LinkedList();
    this.MLV = new LinkedList();
    this.MLX = new LinkedList();
    this.MMh = new LinkedList();
    this.MMr = new LinkedList();
    AppMethodBeat.o(91644);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91645);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91645);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.pTZ);
      if (this.pUa != null) {
        paramVarArgs.e(3, this.pUa);
      }
      paramVarArgs.aM(4, this.MAf);
      if (this.MLP != null) {
        paramVarArgs.e(5, this.MLP);
      }
      if (this.MLQ != null) {
        paramVarArgs.e(6, this.MLQ);
      }
      if (this.MLR != null) {
        paramVarArgs.e(7, this.MLR);
      }
      paramVarArgs.aM(8, this.MLS);
      paramVarArgs.e(9, 8, this.MLT);
      paramVarArgs.aM(10, this.egj);
      paramVarArgs.aM(11, this.MLU);
      paramVarArgs.e(12, 8, this.MLV);
      if (this.Mnl != null) {
        paramVarArgs.e(13, this.Mnl);
      }
      if (this.MLW != null)
      {
        paramVarArgs.ni(14, this.MLW.computeSize());
        this.MLW.writeFields(paramVarArgs);
      }
      paramVarArgs.e(15, 8, this.MLX);
      if (this.MLY != null)
      {
        paramVarArgs.ni(16, this.MLY.computeSize());
        this.MLY.writeFields(paramVarArgs);
      }
      if (this.MLZ != null)
      {
        paramVarArgs.ni(17, this.MLZ.computeSize());
        this.MLZ.writeFields(paramVarArgs);
      }
      if (this.MMa != null) {
        paramVarArgs.e(18, this.MMa);
      }
      paramVarArgs.aM(19, this.MMb);
      if (this.MMc != null) {
        paramVarArgs.e(20, this.MMc);
      }
      if (this.MLJ != null) {
        paramVarArgs.e(21, this.MLJ);
      }
      paramVarArgs.aM(22, this.MMd);
      paramVarArgs.cc(23, this.MMe);
      paramVarArgs.aM(24, this.yba);
      if (this.Mnk != null) {
        paramVarArgs.e(25, this.Mnk);
      }
      if (this.MMf != null) {
        paramVarArgs.e(26, this.MMf);
      }
      if (this.MMg != null) {
        paramVarArgs.e(27, this.MMg);
      }
      paramVarArgs.e(28, 8, this.MMh);
      if (this.MMi != null) {
        paramVarArgs.e(29, this.MMi);
      }
      if (this.MMj != null) {
        paramVarArgs.e(30, this.MMj);
      }
      if (this.MMk != null) {
        paramVarArgs.e(31, this.MMk);
      }
      if (this.HtI != null) {
        paramVarArgs.e(32, this.HtI);
      }
      if (this.MMl != null)
      {
        paramVarArgs.ni(33, this.MMl.computeSize());
        this.MMl.writeFields(paramVarArgs);
      }
      if (this.MMm != null)
      {
        paramVarArgs.ni(34, this.MMm.computeSize());
        this.MMm.writeFields(paramVarArgs);
      }
      if (this.MMn != null)
      {
        paramVarArgs.ni(35, this.MMn.computeSize());
        this.MMn.writeFields(paramVarArgs);
      }
      if (this.MMo != null) {
        paramVarArgs.e(36, this.MMo);
      }
      if (this.MMp != null) {
        paramVarArgs.e(37, this.MMp);
      }
      if (this.MMq != null)
      {
        paramVarArgs.ni(38, this.MMq.computeSize());
        this.MMq.writeFields(paramVarArgs);
      }
      paramVarArgs.cc(39, this.Mma);
      if (this.MAl != null)
      {
        paramVarArgs.ni(40, this.MAl.computeSize());
        this.MAl.writeFields(paramVarArgs);
      }
      paramVarArgs.e(41, 8, this.MMr);
      if (this.MMs != null) {
        paramVarArgs.e(42, this.MMs);
      }
      if (this.MMt != null) {
        paramVarArgs.e(43, this.MMt);
      }
      if (this.MMu != null)
      {
        paramVarArgs.ni(44, this.MMu.computeSize());
        this.MMu.writeFields(paramVarArgs);
      }
      if (this.MMv != null)
      {
        paramVarArgs.ni(45, this.MMv.computeSize());
        this.MMv.writeFields(paramVarArgs);
      }
      if (this.MMw != null)
      {
        paramVarArgs.ni(46, this.MMw.computeSize());
        this.MMw.writeFields(paramVarArgs);
      }
      if (this.efB != null)
      {
        paramVarArgs.ni(99, this.efB.computeSize());
        this.efB.writeFields(paramVarArgs);
      }
      if (this.HuS != null) {
        paramVarArgs.e(100, this.HuS);
      }
      AppMethodBeat.o(91645);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label4822;
      }
    }
    label4822:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.pTZ);
      paramInt = i;
      if (this.pUa != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.pUa);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.MAf);
      paramInt = i;
      if (this.MLP != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.MLP);
      }
      i = paramInt;
      if (this.MLQ != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.MLQ);
      }
      paramInt = i;
      if (this.MLR != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.MLR);
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.MLS) + g.a.a.a.c(9, 8, this.MLT) + g.a.a.b.b.a.bu(10, this.egj) + g.a.a.b.b.a.bu(11, this.MLU) + g.a.a.a.c(12, 8, this.MLV);
      paramInt = i;
      if (this.Mnl != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.Mnl);
      }
      i = paramInt;
      if (this.MLW != null) {
        i = paramInt + g.a.a.a.nh(14, this.MLW.computeSize());
      }
      i += g.a.a.a.c(15, 8, this.MLX);
      paramInt = i;
      if (this.MLY != null) {
        paramInt = i + g.a.a.a.nh(16, this.MLY.computeSize());
      }
      i = paramInt;
      if (this.MLZ != null) {
        i = paramInt + g.a.a.a.nh(17, this.MLZ.computeSize());
      }
      paramInt = i;
      if (this.MMa != null) {
        paramInt = i + g.a.a.b.b.a.f(18, this.MMa);
      }
      i = paramInt + g.a.a.b.b.a.bu(19, this.MMb);
      paramInt = i;
      if (this.MMc != null) {
        paramInt = i + g.a.a.b.b.a.f(20, this.MMc);
      }
      i = paramInt;
      if (this.MLJ != null) {
        i = paramInt + g.a.a.b.b.a.f(21, this.MLJ);
      }
      i = i + g.a.a.b.b.a.bu(22, this.MMd) + (g.a.a.b.b.a.fS(23) + 1) + g.a.a.b.b.a.bu(24, this.yba);
      paramInt = i;
      if (this.Mnk != null) {
        paramInt = i + g.a.a.b.b.a.f(25, this.Mnk);
      }
      i = paramInt;
      if (this.MMf != null) {
        i = paramInt + g.a.a.b.b.a.f(26, this.MMf);
      }
      paramInt = i;
      if (this.MMg != null) {
        paramInt = i + g.a.a.b.b.a.f(27, this.MMg);
      }
      i = paramInt + g.a.a.a.c(28, 8, this.MMh);
      paramInt = i;
      if (this.MMi != null) {
        paramInt = i + g.a.a.b.b.a.f(29, this.MMi);
      }
      i = paramInt;
      if (this.MMj != null) {
        i = paramInt + g.a.a.b.b.a.f(30, this.MMj);
      }
      paramInt = i;
      if (this.MMk != null) {
        paramInt = i + g.a.a.b.b.a.f(31, this.MMk);
      }
      i = paramInt;
      if (this.HtI != null) {
        i = paramInt + g.a.a.b.b.a.f(32, this.HtI);
      }
      paramInt = i;
      if (this.MMl != null) {
        paramInt = i + g.a.a.a.nh(33, this.MMl.computeSize());
      }
      i = paramInt;
      if (this.MMm != null) {
        i = paramInt + g.a.a.a.nh(34, this.MMm.computeSize());
      }
      paramInt = i;
      if (this.MMn != null) {
        paramInt = i + g.a.a.a.nh(35, this.MMn.computeSize());
      }
      i = paramInt;
      if (this.MMo != null) {
        i = paramInt + g.a.a.b.b.a.f(36, this.MMo);
      }
      paramInt = i;
      if (this.MMp != null) {
        paramInt = i + g.a.a.b.b.a.f(37, this.MMp);
      }
      i = paramInt;
      if (this.MMq != null) {
        i = paramInt + g.a.a.a.nh(38, this.MMq.computeSize());
      }
      i += g.a.a.b.b.a.fS(39) + 1;
      paramInt = i;
      if (this.MAl != null) {
        paramInt = i + g.a.a.a.nh(40, this.MAl.computeSize());
      }
      i = paramInt + g.a.a.a.c(41, 8, this.MMr);
      paramInt = i;
      if (this.MMs != null) {
        paramInt = i + g.a.a.b.b.a.f(42, this.MMs);
      }
      i = paramInt;
      if (this.MMt != null) {
        i = paramInt + g.a.a.b.b.a.f(43, this.MMt);
      }
      paramInt = i;
      if (this.MMu != null) {
        paramInt = i + g.a.a.a.nh(44, this.MMu.computeSize());
      }
      i = paramInt;
      if (this.MMv != null) {
        i = paramInt + g.a.a.a.nh(45, this.MMv.computeSize());
      }
      paramInt = i;
      if (this.MMw != null) {
        paramInt = i + g.a.a.a.nh(46, this.MMw.computeSize());
      }
      i = paramInt;
      if (this.efB != null) {
        i = paramInt + g.a.a.a.nh(99, this.efB.computeSize());
      }
      paramInt = i;
      if (this.HuS != null) {
        paramInt = i + g.a.a.b.b.a.f(100, this.HuS);
      }
      AppMethodBeat.o(91645);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MLT.clear();
        this.MLV.clear();
        this.MLX.clear();
        this.MMh.clear();
        this.MMr.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91645);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91645);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dhn localdhn = (dhn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 47: 
        case 48: 
        case 49: 
        case 50: 
        case 51: 
        case 52: 
        case 53: 
        case 54: 
        case 55: 
        case 56: 
        case 57: 
        case 58: 
        case 59: 
        case 60: 
        case 61: 
        case 62: 
        case 63: 
        case 64: 
        case 65: 
        case 66: 
        case 67: 
        case 68: 
        case 69: 
        case 70: 
        case 71: 
        case 72: 
        case 73: 
        case 74: 
        case 75: 
        case 76: 
        case 77: 
        case 78: 
        case 79: 
        case 80: 
        case 81: 
        case 82: 
        case 83: 
        case 84: 
        case 85: 
        case 86: 
        case 87: 
        case 88: 
        case 89: 
        case 90: 
        case 91: 
        case 92: 
        case 93: 
        case 94: 
        case 95: 
        case 96: 
        case 97: 
        case 98: 
        default: 
          AppMethodBeat.o(91645);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdhn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 2: 
          localdhn.pTZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91645);
          return 0;
        case 3: 
          localdhn.pUa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 4: 
          localdhn.MAf = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91645);
          return 0;
        case 5: 
          localdhn.MLP = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 6: 
          localdhn.MLQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 7: 
          localdhn.MLR = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 8: 
          localdhn.MLS = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91645);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdhn.MLT.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 10: 
          localdhn.egj = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91645);
          return 0;
        case 11: 
          localdhn.MLU = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91645);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdhn.MLV.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 13: 
          localdhn.Mnl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdhn.MLW = ((ahq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdhn.MLX.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdhn.MLY = ((ahq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 17: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cox();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cox)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdhn.MLZ = ((cox)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 18: 
          localdhn.MMa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 19: 
          localdhn.MMb = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91645);
          return 0;
        case 20: 
          localdhn.MMc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 21: 
          localdhn.MLJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 22: 
          localdhn.MMd = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91645);
          return 0;
        case 23: 
          localdhn.MMe = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(91645);
          return 0;
        case 24: 
          localdhn.yba = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91645);
          return 0;
        case 25: 
          localdhn.Mnk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 26: 
          localdhn.MMf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 27: 
          localdhn.MMg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 28: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdhn.MMh.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 29: 
          localdhn.MMi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 30: 
          localdhn.MMj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 31: 
          localdhn.MMk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 32: 
          localdhn.HtI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 33: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdhn.MMl = ((ctg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 34: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgt();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cgt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdhn.MMm = ((cgt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 35: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgt();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cgt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdhn.MMn = ((cgt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 36: 
          localdhn.MMo = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 37: 
          localdhn.MMp = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 38: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aof();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aof)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdhn.MMq = ((aof)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 39: 
          localdhn.Mma = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(91645);
          return 0;
        case 40: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dde();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dde)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdhn.MAl = ((dde)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 41: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdhn.MMr.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 42: 
          localdhn.MMs = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 43: 
          localdhn.MMt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 44: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdhn.MMu = ((ctg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 45: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chu();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdhn.MMv = ((chu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 46: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdhn.MMw = ((ctg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 99: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ckj();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ckj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdhn.efB = ((ckj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        }
        localdhn.HuS = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91645);
        return 0;
      }
      AppMethodBeat.o(91645);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhn
 * JD-Core Version:    0.7.0.1
 */