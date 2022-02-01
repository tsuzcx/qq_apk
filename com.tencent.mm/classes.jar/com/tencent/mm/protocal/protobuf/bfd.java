package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bfd
  extends dpc
{
  public LinkedList<bfe> LOI;
  public bfe LOJ;
  public int LOK;
  public bey LOL;
  public String LOM;
  public String LOO;
  public cfm LOP;
  public dju LgT;
  public cdh Lus;
  public int dDN;
  public LinkedList<bez> dkr;
  public int egY;
  public int egZ;
  public int eha;
  public long eht;
  public int qwe;
  public String qwn;
  public String yPK;
  public String yQE;
  public int yRN;
  public String yRO;
  public String yRP;
  public String yVA;
  public String yVC;
  public String yVD;
  public int yVJ;
  public String yVb;
  public long yVi;
  public long yVj;
  public String yVk;
  public int yVm;
  public int yVn;
  public String yVo;
  public String yVy;
  public int yVz;
  public int yWN;
  
  public bfd()
  {
    AppMethodBeat.i(214296);
    this.dDN = 0;
    this.qwn = "ok";
    this.LOI = new LinkedList();
    this.dkr = new LinkedList();
    AppMethodBeat.o(214296);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(214297);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(214297);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.dDN);
      if (this.qwn != null) {
        paramVarArgs.e(3, this.qwn);
      }
      if (this.yQE != null) {
        paramVarArgs.e(4, this.yQE);
      }
      paramVarArgs.bb(5, this.eht);
      paramVarArgs.aM(6, this.yWN);
      paramVarArgs.bb(7, this.yVi);
      paramVarArgs.aM(8, this.qwe);
      paramVarArgs.bb(9, this.yVj);
      paramVarArgs.aM(10, this.egY);
      paramVarArgs.aM(11, this.yVm);
      paramVarArgs.aM(12, this.yVn);
      paramVarArgs.aM(13, this.eha);
      paramVarArgs.aM(14, this.egZ);
      if (this.yVb != null) {
        paramVarArgs.e(15, this.yVb);
      }
      if (this.yPK != null) {
        paramVarArgs.e(16, this.yPK);
      }
      if (this.yVk != null) {
        paramVarArgs.e(17, this.yVk);
      }
      if (this.yVo != null) {
        paramVarArgs.e(18, this.yVo);
      }
      paramVarArgs.e(19, 8, this.LOI);
      paramVarArgs.e(20, 8, this.dkr);
      paramVarArgs.aM(21, this.yRN);
      if (this.yRP != null) {
        paramVarArgs.e(22, this.yRP);
      }
      if (this.yVy != null) {
        paramVarArgs.e(23, this.yVy);
      }
      if (this.yRO != null) {
        paramVarArgs.e(24, this.yRO);
      }
      if (this.LgT != null)
      {
        paramVarArgs.ni(25, this.LgT.computeSize());
        this.LgT.writeFields(paramVarArgs);
      }
      if (this.LOO != null) {
        paramVarArgs.e(26, this.LOO);
      }
      if (this.LOM != null) {
        paramVarArgs.e(27, this.LOM);
      }
      paramVarArgs.aM(28, this.yVz);
      if (this.yVA != null) {
        paramVarArgs.e(29, this.yVA);
      }
      if (this.LOP != null)
      {
        paramVarArgs.ni(30, this.LOP.computeSize());
        this.LOP.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(31, this.LOK);
      paramVarArgs.aM(32, this.yVJ);
      if (this.Lus != null)
      {
        paramVarArgs.ni(33, this.Lus.computeSize());
        this.Lus.writeFields(paramVarArgs);
      }
      if (this.yVC != null) {
        paramVarArgs.e(34, this.yVC);
      }
      if (this.yVD != null) {
        paramVarArgs.e(35, this.yVD);
      }
      if (this.LOL != null)
      {
        paramVarArgs.ni(36, this.LOL.computeSize());
        this.LOL.writeFields(paramVarArgs);
      }
      if (this.LOJ != null)
      {
        paramVarArgs.ni(37, this.LOJ.computeSize());
        this.LOJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(214297);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2950;
      }
    }
    label2950:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.dDN);
      paramInt = i;
      if (this.qwn != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.qwn);
      }
      i = paramInt;
      if (this.yQE != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.yQE);
      }
      i = i + g.a.a.b.b.a.r(5, this.eht) + g.a.a.b.b.a.bu(6, this.yWN) + g.a.a.b.b.a.r(7, this.yVi) + g.a.a.b.b.a.bu(8, this.qwe) + g.a.a.b.b.a.r(9, this.yVj) + g.a.a.b.b.a.bu(10, this.egY) + g.a.a.b.b.a.bu(11, this.yVm) + g.a.a.b.b.a.bu(12, this.yVn) + g.a.a.b.b.a.bu(13, this.eha) + g.a.a.b.b.a.bu(14, this.egZ);
      paramInt = i;
      if (this.yVb != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.yVb);
      }
      i = paramInt;
      if (this.yPK != null) {
        i = paramInt + g.a.a.b.b.a.f(16, this.yPK);
      }
      paramInt = i;
      if (this.yVk != null) {
        paramInt = i + g.a.a.b.b.a.f(17, this.yVk);
      }
      i = paramInt;
      if (this.yVo != null) {
        i = paramInt + g.a.a.b.b.a.f(18, this.yVo);
      }
      i = i + g.a.a.a.c(19, 8, this.LOI) + g.a.a.a.c(20, 8, this.dkr) + g.a.a.b.b.a.bu(21, this.yRN);
      paramInt = i;
      if (this.yRP != null) {
        paramInt = i + g.a.a.b.b.a.f(22, this.yRP);
      }
      i = paramInt;
      if (this.yVy != null) {
        i = paramInt + g.a.a.b.b.a.f(23, this.yVy);
      }
      paramInt = i;
      if (this.yRO != null) {
        paramInt = i + g.a.a.b.b.a.f(24, this.yRO);
      }
      i = paramInt;
      if (this.LgT != null) {
        i = paramInt + g.a.a.a.nh(25, this.LgT.computeSize());
      }
      paramInt = i;
      if (this.LOO != null) {
        paramInt = i + g.a.a.b.b.a.f(26, this.LOO);
      }
      i = paramInt;
      if (this.LOM != null) {
        i = paramInt + g.a.a.b.b.a.f(27, this.LOM);
      }
      i += g.a.a.b.b.a.bu(28, this.yVz);
      paramInt = i;
      if (this.yVA != null) {
        paramInt = i + g.a.a.b.b.a.f(29, this.yVA);
      }
      i = paramInt;
      if (this.LOP != null) {
        i = paramInt + g.a.a.a.nh(30, this.LOP.computeSize());
      }
      i = i + g.a.a.b.b.a.bu(31, this.LOK) + g.a.a.b.b.a.bu(32, this.yVJ);
      paramInt = i;
      if (this.Lus != null) {
        paramInt = i + g.a.a.a.nh(33, this.Lus.computeSize());
      }
      i = paramInt;
      if (this.yVC != null) {
        i = paramInt + g.a.a.b.b.a.f(34, this.yVC);
      }
      paramInt = i;
      if (this.yVD != null) {
        paramInt = i + g.a.a.b.b.a.f(35, this.yVD);
      }
      i = paramInt;
      if (this.LOL != null) {
        i = paramInt + g.a.a.a.nh(36, this.LOL.computeSize());
      }
      paramInt = i;
      if (this.LOJ != null) {
        paramInt = i + g.a.a.a.nh(37, this.LOJ.computeSize());
      }
      AppMethodBeat.o(214297);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LOI.clear();
        this.dkr.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(214297);
          throw paramVarArgs;
        }
        AppMethodBeat.o(214297);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bfd localbfd = (bfd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(214297);
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
            localbfd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(214297);
          return 0;
        case 2: 
          localbfd.dDN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(214297);
          return 0;
        case 3: 
          localbfd.qwn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214297);
          return 0;
        case 4: 
          localbfd.yQE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214297);
          return 0;
        case 5: 
          localbfd.eht = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(214297);
          return 0;
        case 6: 
          localbfd.yWN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(214297);
          return 0;
        case 7: 
          localbfd.yVi = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(214297);
          return 0;
        case 8: 
          localbfd.qwe = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(214297);
          return 0;
        case 9: 
          localbfd.yVj = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(214297);
          return 0;
        case 10: 
          localbfd.egY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(214297);
          return 0;
        case 11: 
          localbfd.yVm = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(214297);
          return 0;
        case 12: 
          localbfd.yVn = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(214297);
          return 0;
        case 13: 
          localbfd.eha = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(214297);
          return 0;
        case 14: 
          localbfd.egZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(214297);
          return 0;
        case 15: 
          localbfd.yVb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214297);
          return 0;
        case 16: 
          localbfd.yPK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214297);
          return 0;
        case 17: 
          localbfd.yVk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214297);
          return 0;
        case 18: 
          localbfd.yVo = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214297);
          return 0;
        case 19: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bfe();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bfe)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbfd.LOI.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(214297);
          return 0;
        case 20: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bez();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bez)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbfd.dkr.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(214297);
          return 0;
        case 21: 
          localbfd.yRN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(214297);
          return 0;
        case 22: 
          localbfd.yRP = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214297);
          return 0;
        case 23: 
          localbfd.yVy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214297);
          return 0;
        case 24: 
          localbfd.yRO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214297);
          return 0;
        case 25: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dju();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dju)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbfd.LgT = ((dju)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(214297);
          return 0;
        case 26: 
          localbfd.LOO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214297);
          return 0;
        case 27: 
          localbfd.LOM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214297);
          return 0;
        case 28: 
          localbfd.yVz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(214297);
          return 0;
        case 29: 
          localbfd.yVA = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214297);
          return 0;
        case 30: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfm();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbfd.LOP = ((cfm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(214297);
          return 0;
        case 31: 
          localbfd.LOK = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(214297);
          return 0;
        case 32: 
          localbfd.yVJ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(214297);
          return 0;
        case 33: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cdh();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cdh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbfd.Lus = ((cdh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(214297);
          return 0;
        case 34: 
          localbfd.yVC = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214297);
          return 0;
        case 35: 
          localbfd.yVD = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214297);
          return 0;
        case 36: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bey();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bey)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbfd.LOL = ((bey)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(214297);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bfe();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bfe)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbfd.LOJ = ((bfe)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(214297);
        return 0;
      }
      AppMethodBeat.o(214297);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfd
 * JD-Core Version:    0.7.0.1
 */