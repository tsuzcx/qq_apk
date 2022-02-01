package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ri
  extends dpc
{
  public int Cpq = 0;
  public String Cpr;
  public String Cps;
  public String Cpt;
  public String Cpu;
  public String KHM;
  public String KHN;
  public String KHO;
  public eig KYA;
  public String KYB;
  public int KYC;
  public int KYD;
  public int KYE;
  public com.tencent.mm.bw.b KYF;
  public int KYG;
  public int KYH;
  public int KYI;
  public rb KYJ;
  public ea KYK;
  public dz KYL;
  public zg KYM;
  public String KYf;
  public String KYt;
  public dyf KYu;
  public String KYv;
  public String KYw;
  public int KYx;
  public int KYy;
  public int KYz;
  public String dNQ;
  public int pTZ;
  public String pUa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91375);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91375);
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
      if (this.dNQ != null) {
        paramVarArgs.e(4, this.dNQ);
      }
      if (this.KYt != null) {
        paramVarArgs.e(5, this.KYt);
      }
      if (this.KYu != null)
      {
        paramVarArgs.ni(6, this.KYu.computeSize());
        this.KYu.writeFields(paramVarArgs);
      }
      if (this.KHM != null) {
        paramVarArgs.e(7, this.KHM);
      }
      if (this.KHO != null) {
        paramVarArgs.e(8, this.KHO);
      }
      if (this.KYv != null) {
        paramVarArgs.e(9, this.KYv);
      }
      if (this.KYw != null) {
        paramVarArgs.e(10, this.KYw);
      }
      paramVarArgs.aM(11, this.KYx);
      if (this.KHN != null) {
        paramVarArgs.e(12, this.KHN);
      }
      if (this.KYf != null) {
        paramVarArgs.e(13, this.KYf);
      }
      paramVarArgs.aM(14, this.KYy);
      paramVarArgs.aM(15, this.KYz);
      if (this.KYA != null)
      {
        paramVarArgs.ni(16, this.KYA.computeSize());
        this.KYA.writeFields(paramVarArgs);
      }
      if (this.KYB != null) {
        paramVarArgs.e(17, this.KYB);
      }
      paramVarArgs.aM(18, this.KYC);
      paramVarArgs.aM(19, this.KYD);
      paramVarArgs.aM(20, this.KYE);
      if (this.KYF != null) {
        paramVarArgs.c(21, this.KYF);
      }
      paramVarArgs.aM(22, this.KYG);
      paramVarArgs.aM(23, this.Cpq);
      if (this.Cpr != null) {
        paramVarArgs.e(24, this.Cpr);
      }
      if (this.Cps != null) {
        paramVarArgs.e(25, this.Cps);
      }
      paramVarArgs.aM(26, this.KYH);
      if (this.Cpt != null) {
        paramVarArgs.e(27, this.Cpt);
      }
      if (this.Cpu != null) {
        paramVarArgs.e(28, this.Cpu);
      }
      paramVarArgs.aM(29, this.KYI);
      if (this.KYJ != null)
      {
        paramVarArgs.ni(30, this.KYJ.computeSize());
        this.KYJ.writeFields(paramVarArgs);
      }
      if (this.KYK != null)
      {
        paramVarArgs.ni(31, this.KYK.computeSize());
        this.KYK.writeFields(paramVarArgs);
      }
      if (this.KYL != null)
      {
        paramVarArgs.ni(32, this.KYL.computeSize());
        this.KYL.writeFields(paramVarArgs);
      }
      if (this.KYM != null)
      {
        paramVarArgs.ni(33, this.KYM.computeSize());
        this.KYM.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91375);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2714;
      }
    }
    label2714:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.pTZ);
      paramInt = i;
      if (this.pUa != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.pUa);
      }
      i = paramInt;
      if (this.dNQ != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.dNQ);
      }
      paramInt = i;
      if (this.KYt != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KYt);
      }
      i = paramInt;
      if (this.KYu != null) {
        i = paramInt + g.a.a.a.nh(6, this.KYu.computeSize());
      }
      paramInt = i;
      if (this.KHM != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.KHM);
      }
      i = paramInt;
      if (this.KHO != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.KHO);
      }
      paramInt = i;
      if (this.KYv != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.KYv);
      }
      i = paramInt;
      if (this.KYw != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.KYw);
      }
      i += g.a.a.b.b.a.bu(11, this.KYx);
      paramInt = i;
      if (this.KHN != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.KHN);
      }
      i = paramInt;
      if (this.KYf != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.KYf);
      }
      i = i + g.a.a.b.b.a.bu(14, this.KYy) + g.a.a.b.b.a.bu(15, this.KYz);
      paramInt = i;
      if (this.KYA != null) {
        paramInt = i + g.a.a.a.nh(16, this.KYA.computeSize());
      }
      i = paramInt;
      if (this.KYB != null) {
        i = paramInt + g.a.a.b.b.a.f(17, this.KYB);
      }
      i = i + g.a.a.b.b.a.bu(18, this.KYC) + g.a.a.b.b.a.bu(19, this.KYD) + g.a.a.b.b.a.bu(20, this.KYE);
      paramInt = i;
      if (this.KYF != null) {
        paramInt = i + g.a.a.b.b.a.b(21, this.KYF);
      }
      i = paramInt + g.a.a.b.b.a.bu(22, this.KYG) + g.a.a.b.b.a.bu(23, this.Cpq);
      paramInt = i;
      if (this.Cpr != null) {
        paramInt = i + g.a.a.b.b.a.f(24, this.Cpr);
      }
      i = paramInt;
      if (this.Cps != null) {
        i = paramInt + g.a.a.b.b.a.f(25, this.Cps);
      }
      i += g.a.a.b.b.a.bu(26, this.KYH);
      paramInt = i;
      if (this.Cpt != null) {
        paramInt = i + g.a.a.b.b.a.f(27, this.Cpt);
      }
      i = paramInt;
      if (this.Cpu != null) {
        i = paramInt + g.a.a.b.b.a.f(28, this.Cpu);
      }
      i += g.a.a.b.b.a.bu(29, this.KYI);
      paramInt = i;
      if (this.KYJ != null) {
        paramInt = i + g.a.a.a.nh(30, this.KYJ.computeSize());
      }
      i = paramInt;
      if (this.KYK != null) {
        i = paramInt + g.a.a.a.nh(31, this.KYK.computeSize());
      }
      paramInt = i;
      if (this.KYL != null) {
        paramInt = i + g.a.a.a.nh(32, this.KYL.computeSize());
      }
      i = paramInt;
      if (this.KYM != null) {
        i = paramInt + g.a.a.a.nh(33, this.KYM.computeSize());
      }
      AppMethodBeat.o(91375);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91375);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91375);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ri localri = (ri)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91375);
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
            localri.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        case 2: 
          localri.pTZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91375);
          return 0;
        case 3: 
          localri.pUa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 4: 
          localri.dNQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 5: 
          localri.KYt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localri.KYu = ((dyf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        case 7: 
          localri.KHM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 8: 
          localri.KHO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 9: 
          localri.KYv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 10: 
          localri.KYw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 11: 
          localri.KYx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91375);
          return 0;
        case 12: 
          localri.KHN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 13: 
          localri.KYf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 14: 
          localri.KYy = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91375);
          return 0;
        case 15: 
          localri.KYz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91375);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eig();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eig)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localri.KYA = ((eig)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        case 17: 
          localri.KYB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 18: 
          localri.KYC = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91375);
          return 0;
        case 19: 
          localri.KYD = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91375);
          return 0;
        case 20: 
          localri.KYE = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91375);
          return 0;
        case 21: 
          localri.KYF = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(91375);
          return 0;
        case 22: 
          localri.KYG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91375);
          return 0;
        case 23: 
          localri.Cpq = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91375);
          return 0;
        case 24: 
          localri.Cpr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 25: 
          localri.Cps = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 26: 
          localri.KYH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91375);
          return 0;
        case 27: 
          localri.Cpt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 28: 
          localri.Cpu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 29: 
          localri.KYI = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91375);
          return 0;
        case 30: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rb();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localri.KYJ = ((rb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        case 31: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ea();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ea)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localri.KYK = ((ea)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        case 32: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dz();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localri.KYL = ((dz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new zg();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((zg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localri.KYM = ((zg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91375);
        return 0;
      }
      AppMethodBeat.o(91375);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ri
 * JD-Core Version:    0.7.0.1
 */