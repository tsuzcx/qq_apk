package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cer
  extends cld
{
  public int CYU;
  public boolean DIo;
  public int DRI;
  public cba DRO;
  public String DZA;
  public String DZC;
  public String EaD;
  public String EaE;
  public String EaF;
  public int EaG;
  public LinkedList<aca> EaH;
  public int EaI;
  public LinkedList<aca> EaJ;
  public aca EaK;
  public LinkedList<aca> EaL;
  public aca EaM;
  public bpv EaN;
  public String EaO;
  public int EaP;
  public String EaQ;
  public int EaR;
  public boolean EaS;
  public String EaT;
  public String EaU;
  public LinkedList<bsy> EaV;
  public String EaW;
  public String EaX;
  public String EaY;
  public bsy EaZ;
  public String Eax;
  public bko Eba;
  public bko Ebb;
  public String Ebc;
  public String Ebd;
  public ahq Ebe;
  public LinkedList<bsy> Ebf;
  public String Ebg;
  public String Ebh;
  public blm Ebi;
  public int dCZ;
  public int ntx;
  public String nty;
  public String zEQ;
  public String zFY;
  
  public cer()
  {
    AppMethodBeat.i(91644);
    this.EaH = new LinkedList();
    this.EaJ = new LinkedList();
    this.EaL = new LinkedList();
    this.EaV = new LinkedList();
    this.Ebf = new LinkedList();
    AppMethodBeat.o(91644);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91645);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91645);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ntx);
      if (this.nty != null) {
        paramVarArgs.d(3, this.nty);
      }
      paramVarArgs.aR(4, this.DRI);
      if (this.EaD != null) {
        paramVarArgs.d(5, this.EaD);
      }
      if (this.EaE != null) {
        paramVarArgs.d(6, this.EaE);
      }
      if (this.EaF != null) {
        paramVarArgs.d(7, this.EaF);
      }
      paramVarArgs.aR(8, this.EaG);
      paramVarArgs.e(9, 8, this.EaH);
      paramVarArgs.aR(10, this.dCZ);
      paramVarArgs.aR(11, this.EaI);
      paramVarArgs.e(12, 8, this.EaJ);
      if (this.DZA != null) {
        paramVarArgs.d(13, this.DZA);
      }
      if (this.EaK != null)
      {
        paramVarArgs.kX(14, this.EaK.computeSize());
        this.EaK.writeFields(paramVarArgs);
      }
      paramVarArgs.e(15, 8, this.EaL);
      if (this.EaM != null)
      {
        paramVarArgs.kX(16, this.EaM.computeSize());
        this.EaM.writeFields(paramVarArgs);
      }
      if (this.EaN != null)
      {
        paramVarArgs.kX(17, this.EaN.computeSize());
        this.EaN.writeFields(paramVarArgs);
      }
      if (this.EaO != null) {
        paramVarArgs.d(18, this.EaO);
      }
      paramVarArgs.aR(19, this.EaP);
      if (this.EaQ != null) {
        paramVarArgs.d(20, this.EaQ);
      }
      if (this.Eax != null) {
        paramVarArgs.d(21, this.Eax);
      }
      paramVarArgs.aR(22, this.EaR);
      paramVarArgs.bg(23, this.EaS);
      paramVarArgs.aR(24, this.CYU);
      if (this.DZC != null) {
        paramVarArgs.d(25, this.DZC);
      }
      if (this.EaT != null) {
        paramVarArgs.d(26, this.EaT);
      }
      if (this.EaU != null) {
        paramVarArgs.d(27, this.EaU);
      }
      paramVarArgs.e(28, 8, this.EaV);
      if (this.EaW != null) {
        paramVarArgs.d(29, this.EaW);
      }
      if (this.EaX != null) {
        paramVarArgs.d(30, this.EaX);
      }
      if (this.EaY != null) {
        paramVarArgs.d(31, this.EaY);
      }
      if (this.zEQ != null) {
        paramVarArgs.d(32, this.zEQ);
      }
      if (this.EaZ != null)
      {
        paramVarArgs.kX(33, this.EaZ.computeSize());
        this.EaZ.writeFields(paramVarArgs);
      }
      if (this.Eba != null)
      {
        paramVarArgs.kX(34, this.Eba.computeSize());
        this.Eba.writeFields(paramVarArgs);
      }
      if (this.Ebb != null)
      {
        paramVarArgs.kX(35, this.Ebb.computeSize());
        this.Ebb.writeFields(paramVarArgs);
      }
      if (this.Ebc != null) {
        paramVarArgs.d(36, this.Ebc);
      }
      if (this.Ebd != null) {
        paramVarArgs.d(37, this.Ebd);
      }
      if (this.Ebe != null)
      {
        paramVarArgs.kX(38, this.Ebe.computeSize());
        this.Ebe.writeFields(paramVarArgs);
      }
      paramVarArgs.bg(39, this.DIo);
      if (this.DRO != null)
      {
        paramVarArgs.kX(40, this.DRO.computeSize());
        this.DRO.writeFields(paramVarArgs);
      }
      paramVarArgs.e(41, 8, this.Ebf);
      if (this.Ebg != null) {
        paramVarArgs.d(42, this.Ebg);
      }
      if (this.Ebh != null) {
        paramVarArgs.d(43, this.Ebh);
      }
      if (this.Ebi != null)
      {
        paramVarArgs.kX(45, this.Ebi.computeSize());
        this.Ebi.writeFields(paramVarArgs);
      }
      if (this.zFY != null) {
        paramVarArgs.d(100, this.zFY);
      }
      AppMethodBeat.o(91645);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label4366;
      }
    }
    label4366:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.ntx);
      paramInt = i;
      if (this.nty != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nty);
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.DRI);
      paramInt = i;
      if (this.EaD != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EaD);
      }
      i = paramInt;
      if (this.EaE != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.EaE);
      }
      paramInt = i;
      if (this.EaF != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.EaF);
      }
      i = paramInt + f.a.a.b.b.a.bA(8, this.EaG) + f.a.a.a.c(9, 8, this.EaH) + f.a.a.b.b.a.bA(10, this.dCZ) + f.a.a.b.b.a.bA(11, this.EaI) + f.a.a.a.c(12, 8, this.EaJ);
      paramInt = i;
      if (this.DZA != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.DZA);
      }
      i = paramInt;
      if (this.EaK != null) {
        i = paramInt + f.a.a.a.kW(14, this.EaK.computeSize());
      }
      i += f.a.a.a.c(15, 8, this.EaL);
      paramInt = i;
      if (this.EaM != null) {
        paramInt = i + f.a.a.a.kW(16, this.EaM.computeSize());
      }
      i = paramInt;
      if (this.EaN != null) {
        i = paramInt + f.a.a.a.kW(17, this.EaN.computeSize());
      }
      paramInt = i;
      if (this.EaO != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.EaO);
      }
      i = paramInt + f.a.a.b.b.a.bA(19, this.EaP);
      paramInt = i;
      if (this.EaQ != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.EaQ);
      }
      i = paramInt;
      if (this.Eax != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.Eax);
      }
      i = i + f.a.a.b.b.a.bA(22, this.EaR) + (f.a.a.b.b.a.fY(23) + 1) + f.a.a.b.b.a.bA(24, this.CYU);
      paramInt = i;
      if (this.DZC != null) {
        paramInt = i + f.a.a.b.b.a.e(25, this.DZC);
      }
      i = paramInt;
      if (this.EaT != null) {
        i = paramInt + f.a.a.b.b.a.e(26, this.EaT);
      }
      paramInt = i;
      if (this.EaU != null) {
        paramInt = i + f.a.a.b.b.a.e(27, this.EaU);
      }
      i = paramInt + f.a.a.a.c(28, 8, this.EaV);
      paramInt = i;
      if (this.EaW != null) {
        paramInt = i + f.a.a.b.b.a.e(29, this.EaW);
      }
      i = paramInt;
      if (this.EaX != null) {
        i = paramInt + f.a.a.b.b.a.e(30, this.EaX);
      }
      paramInt = i;
      if (this.EaY != null) {
        paramInt = i + f.a.a.b.b.a.e(31, this.EaY);
      }
      i = paramInt;
      if (this.zEQ != null) {
        i = paramInt + f.a.a.b.b.a.e(32, this.zEQ);
      }
      paramInt = i;
      if (this.EaZ != null) {
        paramInt = i + f.a.a.a.kW(33, this.EaZ.computeSize());
      }
      i = paramInt;
      if (this.Eba != null) {
        i = paramInt + f.a.a.a.kW(34, this.Eba.computeSize());
      }
      paramInt = i;
      if (this.Ebb != null) {
        paramInt = i + f.a.a.a.kW(35, this.Ebb.computeSize());
      }
      i = paramInt;
      if (this.Ebc != null) {
        i = paramInt + f.a.a.b.b.a.e(36, this.Ebc);
      }
      paramInt = i;
      if (this.Ebd != null) {
        paramInt = i + f.a.a.b.b.a.e(37, this.Ebd);
      }
      i = paramInt;
      if (this.Ebe != null) {
        i = paramInt + f.a.a.a.kW(38, this.Ebe.computeSize());
      }
      i += f.a.a.b.b.a.fY(39) + 1;
      paramInt = i;
      if (this.DRO != null) {
        paramInt = i + f.a.a.a.kW(40, this.DRO.computeSize());
      }
      i = paramInt + f.a.a.a.c(41, 8, this.Ebf);
      paramInt = i;
      if (this.Ebg != null) {
        paramInt = i + f.a.a.b.b.a.e(42, this.Ebg);
      }
      i = paramInt;
      if (this.Ebh != null) {
        i = paramInt + f.a.a.b.b.a.e(43, this.Ebh);
      }
      paramInt = i;
      if (this.Ebi != null) {
        paramInt = i + f.a.a.a.kW(45, this.Ebi.computeSize());
      }
      i = paramInt;
      if (this.zFY != null) {
        i = paramInt + f.a.a.b.b.a.e(100, this.zFY);
      }
      AppMethodBeat.o(91645);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EaH.clear();
        this.EaJ.clear();
        this.EaL.clear();
        this.EaV.clear();
        this.Ebf.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cer localcer = (cer)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 44: 
        case 46: 
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
        case 99: 
        default: 
          AppMethodBeat.o(91645);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcer.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 2: 
          localcer.ntx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91645);
          return 0;
        case 3: 
          localcer.nty = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 4: 
          localcer.DRI = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91645);
          return 0;
        case 5: 
          localcer.EaD = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 6: 
          localcer.EaE = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 7: 
          localcer.EaF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 8: 
          localcer.EaG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91645);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aca();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aca)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcer.EaH.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 10: 
          localcer.dCZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91645);
          return 0;
        case 11: 
          localcer.EaI = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91645);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aca();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aca)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcer.EaJ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 13: 
          localcer.DZA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aca();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aca)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcer.EaK = ((aca)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aca();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aca)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcer.EaL.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aca();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aca)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcer.EaM = ((aca)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bpv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcer.EaN = ((bpv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 18: 
          localcer.EaO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 19: 
          localcer.EaP = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91645);
          return 0;
        case 20: 
          localcer.EaQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 21: 
          localcer.Eax = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 22: 
          localcer.EaR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91645);
          return 0;
        case 23: 
          localcer.EaS = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(91645);
          return 0;
        case 24: 
          localcer.CYU = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91645);
          return 0;
        case 25: 
          localcer.DZC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 26: 
          localcer.EaT = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 27: 
          localcer.EaU = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 28: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bsy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bsy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcer.EaV.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 29: 
          localcer.EaW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 30: 
          localcer.EaX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 31: 
          localcer.EaY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 32: 
          localcer.zEQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 33: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bsy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bsy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcer.EaZ = ((bsy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 34: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bko();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bko)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcer.Eba = ((bko)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 35: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bko();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bko)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcer.Ebb = ((bko)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 36: 
          localcer.Ebc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 37: 
          localcer.Ebd = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 38: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcer.Ebe = ((ahq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 39: 
          localcer.DIo = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(91645);
          return 0;
        case 40: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cba();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cba)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcer.DRO = ((cba)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 41: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bsy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bsy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcer.Ebf.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 42: 
          localcer.Ebg = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 43: 
          localcer.Ebh = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 45: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new blm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((blm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcer.Ebi = ((blm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        }
        localcer.zFY = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91645);
        return 0;
      }
      AppMethodBeat.o(91645);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cer
 * JD-Core Version:    0.7.0.1
 */