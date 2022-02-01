package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bfb
  extends dpc
{
  public LinkedList<bfe> LOI;
  public bfe LOJ;
  public int LOK;
  public bey LOL;
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
  public int yVv;
  public String yVy;
  public int yVz;
  public int yWN;
  
  public bfb()
  {
    AppMethodBeat.i(214293);
    this.dDN = 0;
    this.qwn = "ok";
    this.LOI = new LinkedList();
    this.dkr = new LinkedList();
    AppMethodBeat.o(214293);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(214294);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(214294);
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
      paramVarArgs.aM(4, this.yWN);
      paramVarArgs.aM(5, this.qwe);
      paramVarArgs.bb(6, this.yVj);
      if (this.yQE != null) {
        paramVarArgs.e(7, this.yQE);
      }
      paramVarArgs.bb(8, this.eht);
      if (this.yPK != null) {
        paramVarArgs.e(9, this.yPK);
      }
      paramVarArgs.aM(10, this.yVm);
      if (this.yVk != null) {
        paramVarArgs.e(11, this.yVk);
      }
      paramVarArgs.e(12, 8, this.LOI);
      paramVarArgs.aM(13, this.egY);
      paramVarArgs.aM(14, this.yVn);
      paramVarArgs.aM(15, this.egZ);
      paramVarArgs.aM(16, this.eha);
      if (this.yVb != null) {
        paramVarArgs.e(17, this.yVb);
      }
      if (this.yVo != null) {
        paramVarArgs.e(18, this.yVo);
      }
      paramVarArgs.aM(19, this.yVv);
      paramVarArgs.bb(20, this.yVi);
      paramVarArgs.e(21, 8, this.dkr);
      if (this.LOJ != null)
      {
        paramVarArgs.ni(22, this.LOJ.computeSize());
        this.LOJ.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(23, this.yRN);
      if (this.yRP != null) {
        paramVarArgs.e(24, this.yRP);
      }
      if (this.yVy != null) {
        paramVarArgs.e(25, this.yVy);
      }
      if (this.yRO != null) {
        paramVarArgs.e(26, this.yRO);
      }
      paramVarArgs.aM(27, this.yVz);
      if (this.yVA != null) {
        paramVarArgs.e(28, this.yVA);
      }
      paramVarArgs.aM(29, this.LOK);
      paramVarArgs.aM(30, this.yVJ);
      if (this.yVC != null) {
        paramVarArgs.e(31, this.yVC);
      }
      if (this.yVD != null) {
        paramVarArgs.e(32, this.yVD);
      }
      if (this.LOL != null)
      {
        paramVarArgs.ni(33, this.LOL.computeSize());
        this.LOL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(214294);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2410;
      }
    }
    label2410:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.dDN);
      paramInt = i;
      if (this.qwn != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.qwn);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.yWN) + g.a.a.b.b.a.bu(5, this.qwe) + g.a.a.b.b.a.r(6, this.yVj);
      paramInt = i;
      if (this.yQE != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.yQE);
      }
      i = paramInt + g.a.a.b.b.a.r(8, this.eht);
      paramInt = i;
      if (this.yPK != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.yPK);
      }
      i = paramInt + g.a.a.b.b.a.bu(10, this.yVm);
      paramInt = i;
      if (this.yVk != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.yVk);
      }
      i = paramInt + g.a.a.a.c(12, 8, this.LOI) + g.a.a.b.b.a.bu(13, this.egY) + g.a.a.b.b.a.bu(14, this.yVn) + g.a.a.b.b.a.bu(15, this.egZ) + g.a.a.b.b.a.bu(16, this.eha);
      paramInt = i;
      if (this.yVb != null) {
        paramInt = i + g.a.a.b.b.a.f(17, this.yVb);
      }
      i = paramInt;
      if (this.yVo != null) {
        i = paramInt + g.a.a.b.b.a.f(18, this.yVo);
      }
      i = i + g.a.a.b.b.a.bu(19, this.yVv) + g.a.a.b.b.a.r(20, this.yVi) + g.a.a.a.c(21, 8, this.dkr);
      paramInt = i;
      if (this.LOJ != null) {
        paramInt = i + g.a.a.a.nh(22, this.LOJ.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(23, this.yRN);
      paramInt = i;
      if (this.yRP != null) {
        paramInt = i + g.a.a.b.b.a.f(24, this.yRP);
      }
      i = paramInt;
      if (this.yVy != null) {
        i = paramInt + g.a.a.b.b.a.f(25, this.yVy);
      }
      paramInt = i;
      if (this.yRO != null) {
        paramInt = i + g.a.a.b.b.a.f(26, this.yRO);
      }
      i = paramInt + g.a.a.b.b.a.bu(27, this.yVz);
      paramInt = i;
      if (this.yVA != null) {
        paramInt = i + g.a.a.b.b.a.f(28, this.yVA);
      }
      i = paramInt + g.a.a.b.b.a.bu(29, this.LOK) + g.a.a.b.b.a.bu(30, this.yVJ);
      paramInt = i;
      if (this.yVC != null) {
        paramInt = i + g.a.a.b.b.a.f(31, this.yVC);
      }
      i = paramInt;
      if (this.yVD != null) {
        i = paramInt + g.a.a.b.b.a.f(32, this.yVD);
      }
      paramInt = i;
      if (this.LOL != null) {
        paramInt = i + g.a.a.a.nh(33, this.LOL.computeSize());
      }
      AppMethodBeat.o(214294);
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
          AppMethodBeat.o(214294);
          throw paramVarArgs;
        }
        AppMethodBeat.o(214294);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bfb localbfb = (bfb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(214294);
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
            localbfb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(214294);
          return 0;
        case 2: 
          localbfb.dDN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(214294);
          return 0;
        case 3: 
          localbfb.qwn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214294);
          return 0;
        case 4: 
          localbfb.yWN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(214294);
          return 0;
        case 5: 
          localbfb.qwe = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(214294);
          return 0;
        case 6: 
          localbfb.yVj = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(214294);
          return 0;
        case 7: 
          localbfb.yQE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214294);
          return 0;
        case 8: 
          localbfb.eht = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(214294);
          return 0;
        case 9: 
          localbfb.yPK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214294);
          return 0;
        case 10: 
          localbfb.yVm = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(214294);
          return 0;
        case 11: 
          localbfb.yVk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214294);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bfe();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bfe)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbfb.LOI.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(214294);
          return 0;
        case 13: 
          localbfb.egY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(214294);
          return 0;
        case 14: 
          localbfb.yVn = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(214294);
          return 0;
        case 15: 
          localbfb.egZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(214294);
          return 0;
        case 16: 
          localbfb.eha = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(214294);
          return 0;
        case 17: 
          localbfb.yVb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214294);
          return 0;
        case 18: 
          localbfb.yVo = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214294);
          return 0;
        case 19: 
          localbfb.yVv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(214294);
          return 0;
        case 20: 
          localbfb.yVi = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(214294);
          return 0;
        case 21: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bez();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bez)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbfb.dkr.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(214294);
          return 0;
        case 22: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bfe();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bfe)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbfb.LOJ = ((bfe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(214294);
          return 0;
        case 23: 
          localbfb.yRN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(214294);
          return 0;
        case 24: 
          localbfb.yRP = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214294);
          return 0;
        case 25: 
          localbfb.yVy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214294);
          return 0;
        case 26: 
          localbfb.yRO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214294);
          return 0;
        case 27: 
          localbfb.yVz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(214294);
          return 0;
        case 28: 
          localbfb.yVA = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214294);
          return 0;
        case 29: 
          localbfb.LOK = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(214294);
          return 0;
        case 30: 
          localbfb.yVJ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(214294);
          return 0;
        case 31: 
          localbfb.yVC = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214294);
          return 0;
        case 32: 
          localbfb.yVD = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214294);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bey();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bey)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbfb.LOL = ((bey)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(214294);
        return 0;
      }
      AppMethodBeat.o(214294);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfb
 * JD-Core Version:    0.7.0.1
 */